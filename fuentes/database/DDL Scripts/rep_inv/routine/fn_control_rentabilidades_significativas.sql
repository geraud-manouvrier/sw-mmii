create or replace function rep_inv.fn_control_rentabilidades_significativas(_process_date character varying, _exec_monthly boolean, _exec_daily boolean)
    returns TABLE(id_control integer, glosa_control character varying, descripcion_control character varying, process_date character varying, identificador character varying, cant_reg integer)
    language plpgsql
as
$$
DECLARE _id_control integer                     := 1;
DECLARE _glosa_control VARCHAR(1000)            := 'Rentabilidades Significativas';
DECLARE _descripcion_control_base VARCHAR(1000) := 'Rentabilidades fuera del rango ';
--Otras variables auxiliares
DECLARE _min_rent_dia numeric(45,20);
DECLARE _max_rent_dia numeric(45,20);
DECLARE _rango_rent_dia VARCHAR(20);
DECLARE _min_rent_1mes numeric(45,20);
DECLARE _max_rent_1mes numeric(45,20);
DECLARE _rango_rent_1mes VARCHAR(20);
DECLARE _min_rent_3meses numeric(45,20);
DECLARE _max_rent_3meses numeric(45,20);
DECLARE _rango_rent_3meses VARCHAR(20);
DECLARE _min_rent_12meses numeric(45,20);
DECLARE _max_rent_12meses numeric(45,20);
DECLARE _rango_rent_12meses VARCHAR(20);
DECLARE _min_rent_ytd numeric(45,20);
DECLARE _max_rent_ytd numeric(45,20);
DECLARE _rango_rent_ytd VARCHAR(20);
DECLARE _min_rent_20meses numeric(45,20);
DECLARE _max_rent_20meses numeric(45,20);
DECLARE _rango_rent_20meses VARCHAR(20);
    BEGIN

    _min_rent_dia       := -0.05;
    _max_rent_dia       := 0.05;
    _rango_rent_dia       := CAST(_min_rent_dia*100 as VARCHAR(5))||'% - '||CAST(_max_rent_dia*100 as VARCHAR(5))||'%';
    _min_rent_1mes      := -0.10;
    _max_rent_1mes      := 0.20;
    _rango_rent_1mes      := CAST(_min_rent_1mes*100 as VARCHAR(5))||'% - '||CAST(_max_rent_1mes*100 as VARCHAR(5))||'%';
    _min_rent_3meses    := -0.15;
    _max_rent_3meses    := 0.40;
    _rango_rent_3meses    := CAST(_min_rent_3meses*100 as VARCHAR(5))||'% - '||CAST(_max_rent_3meses*100 as VARCHAR(5))||'%';
    _min_rent_12meses   := -0.20;
    _max_rent_12meses   := 0.60;
    _rango_rent_12meses   := CAST(_min_rent_12meses*100 as VARCHAR(5))||'% - '||CAST(_max_rent_12meses*100 as VARCHAR(5))||'%';
    _min_rent_ytd       := -0.20;
    _max_rent_ytd       := 0.60;
    _rango_rent_ytd       := CAST(_min_rent_ytd*100 as VARCHAR(5))||'% - '||CAST(_max_rent_ytd*100 as VARCHAR(5))||'%';
    _min_rent_20meses   := -0.20;
    _max_rent_20meses   := 0.60;
    _rango_rent_20meses   := CAST(_min_rent_20meses*100 as VARCHAR(5))||'% - '||CAST(_max_rent_20meses*100 as VARCHAR(5))||'%';

    RAISE NOTICE 'Ejecutando controles de rentabilidades significativas diarios';
    RETURN QUERY
        SELECT DISTINCT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||_rango_rent_dia||' (diaria)')::VARCHAR(1000) as descripcion_control,
            tb_n1.process_date::VARCHAR(100),
            tb_n1.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
            from rep_inv.consolidado_agregado_n1 tb_n1
            WHERE _exec_daily
            AND tb_n1.process_date=COALESCE(_process_date, tb_n1.process_date)
            AND (tb_n1.rentabilidad<_min_rent_dia OR tb_n1.rentabilidad>_max_rent_dia)
            GROUP BY tb_n1.process_date, tb_n1.agregador_n1
            ORDER BY tb_n1.process_date, tb_n1.agregador_n1
    ;

    IF (NOT _exec_monthly) THEN
        RAISE NOTICE 'No se ejecutaran controles de rentabilidades significativas mensuales, finalizando';
        RETURN;
    END IF;
    RAISE NOTICE 'Ejecutando controles de rentabilidades significativas mensuales';

    DROP TABLE IF EXISTS temp_rentabilidades;
    CREATE TEMP TABLE temp_rentabilidades AS
        SELECT *
        FROM rep_inv.fn_calcula_rentabilidad(NULL, nULL, NULL, NULL, _process_date, _process_date) tb_rent
        WHERE tb_rent.nivel='N1'
        AND (
                tb_rent.base3_rentabilidad<_min_rent_1mes OR tb_rent.base3_rentabilidad>_max_rent_1mes OR
                tb_rent.base4_rentabilidad<_min_rent_3meses OR tb_rent.base4_rentabilidad>_max_rent_3meses OR
                tb_rent.base5_rentabilidad<_min_rent_12meses OR tb_rent.base5_rentabilidad>_max_rent_12meses OR
                tb_rent.base6_rentabilidad<_min_rent_ytd OR tb_rent.base6_rentabilidad>_max_rent_ytd OR
                tb_rent.base7_rentabilidad<_min_rent_20meses OR tb_rent.base7_rentabilidad>_max_rent_20meses
            )
    ;

    RETURN QUERY
        SELECT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||_rango_rent_1mes||' (1 mes)')::VARCHAR(1000) as descripcion_control,
            tb_rent.process_date::VARCHAR(100),
            tb_rent.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
        FROM temp_rentabilidades tb_rent
        WHERE
            _exec_monthly AND ( tb_rent.base3_rentabilidad<_min_rent_1mes OR tb_rent.base3_rentabilidad>_max_rent_1mes )
        GROUP BY tb_rent.process_date, tb_rent.agregador_n1
        ORDER BY tb_rent.process_date, tb_rent.agregador_n1
    ;

    RETURN QUERY
        SELECT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||_rango_rent_3meses||' (3 meses)')::VARCHAR(1000) as descripcion_control,
            tb_rent.process_date::VARCHAR(100),
            tb_rent.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
        FROM temp_rentabilidades tb_rent
        WHERE
            _exec_monthly AND ( tb_rent.base4_rentabilidad<_min_rent_3meses OR tb_rent.base4_rentabilidad>_max_rent_3meses )
        GROUP BY tb_rent.process_date, tb_rent.agregador_n1
        ORDER BY tb_rent.process_date, tb_rent.agregador_n1
    ;

    RETURN QUERY
        SELECT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||_rango_rent_12meses||' (12 meses)')::VARCHAR(1000) as descripcion_control,
            tb_rent.process_date::VARCHAR(100),
            tb_rent.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
        FROM temp_rentabilidades tb_rent
        WHERE
            _exec_monthly AND ( tb_rent.base5_rentabilidad<_min_rent_12meses OR tb_rent.base5_rentabilidad>_max_rent_12meses )
        GROUP BY tb_rent.process_date, tb_rent.agregador_n1
        ORDER BY tb_rent.process_date, tb_rent.agregador_n1
    ;

    RETURN QUERY
        SELECT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||CAST(_max_rent_ytd*100 as VARCHAR(5))||'% (YTD)')::VARCHAR(1000) as descripcion_control,
            tb_rent.process_date::VARCHAR(100),
            tb_rent.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
        FROM temp_rentabilidades tb_rent
        WHERE
            _exec_monthly AND ( tb_rent.base6_rentabilidad<_min_rent_ytd OR tb_rent.base6_rentabilidad>_max_rent_ytd )
        GROUP BY tb_rent.process_date, tb_rent.agregador_n1
        ORDER BY tb_rent.process_date, tb_rent.agregador_n1
    ;

    RETURN QUERY
        SELECT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||_rango_rent_20meses||' (20 meses)')::VARCHAR(1000) as descripcion_control,
            tb_rent.process_date::VARCHAR(100),
            tb_rent.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
        FROM temp_rentabilidades tb_rent
        WHERE
            _exec_monthly AND ( tb_rent.base7_rentabilidad<_min_rent_20meses OR tb_rent.base7_rentabilidad>_max_rent_20meses )
        GROUP BY tb_rent.process_date, tb_rent.agregador_n1
        ORDER BY tb_rent.process_date, tb_rent.agregador_n1
    ;

    RETURN;
    END;
$$;

alter function rep_inv.fn_control_rentabilidades_significativas(varchar, boolean, boolean) owner to postgres;

