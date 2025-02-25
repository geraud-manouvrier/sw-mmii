create or replace function rep_inv.fn_calculo_rentabilidad_agregada(_date_ini date, _date_fin date, _agregador_n1 character varying, _agregador_n2 character varying, _agregador_n3 character varying, _agregador_n4 character varying) returns SETOF rep_inv.reg_rent
    language plpgsql
as
$$
    BEGIN

    DROP TABLE IF EXISTS temptb_base_calculo;

    CREATE TEMP TABLE temptb_base_calculo AS
    (
        SELECT
            tbn.process_date_as_date, tbn.saldo_dia_anterior, tbn.saldo_rentabilidad, tbn.rentabilidad_base_pitatoria,
            tbn.agregador_n1, NULL::VARCHAR(100) as agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4
        FROM rep_inv.consolidado_agregado_n1 tbn
        WHERE tbn.agregador_n1= _agregador_n1
        AND tbn.process_date_as_date>=_date_ini
        AND tbn.process_date_as_date<=_date_fin
    );

    INSERT INTO temptb_base_calculo
    SELECT
            tbn.process_date_as_date, tbn.saldo_dia_anterior, tbn.saldo_rentabilidad, tbn.rentabilidad_base_pitatoria,
            tbn.agregador_n1, NULL::VARCHAR(100) as agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4
        FROM rep_inv.consolidado_agregado_n2 tbn
        WHERE tbn.agregador_n1= _agregador_n1 AND tbn.agregador_n2= _agregador_n2
        AND tbn.process_date_as_date>=_date_ini
        AND tbn.process_date_as_date<=_date_fin
    ;

    RETURN QUERY
    SELECT
        tb_calc.fecha_desde, tb_calc.fecha_hasta,
        tb_calc.agregador_n1, tb_calc.agregador_n2, tb_calc.agregador_n3, tb_calc.agregador_n4,
        tb_calc.cant_reg, tb_calc.dias_con_saldo,
        tb_calc.pitatoria::NUMERIC(45,20) as rentabilidad_periodo,
        tb_calc.suma_saldos_iniciales, tb_calc.suma_saldo_rentabilidad,
        (CASE
            WHEN tb_calc.suma_saldos_iniciales=0 THEN NULL
            ELSE tb_calc.suma_saldo_rentabilidad/tb_calc.suma_saldos_iniciales
            END)::NUMERIC(45,20) as rentabilidad_ponderada_cl,
        (power(
            ( 1 + CASE WHEN tb_calc.suma_saldos_iniciales=0 THEN NULL ELSE tb_calc.suma_saldo_rentabilidad/tb_calc.suma_saldos_iniciales END ),
            (tb_calc.dias_con_saldo)
            ) - 1)::NUMERIC(45,20) as rentabilidad_periodo_cl

    FROM
    (
        SELECT
            count(*)::integer                                                           as cant_reg,
            min(tbn.process_date_as_date)::DATE                                         as fecha_desde,
            max(tbn.process_date_as_date)::DATE                                         as fecha_hasta,
            ((max(tbn.process_date_as_date)- min(tbn.process_date_as_date))+1)::integer as dias_con_saldo,
            sum(tbn.saldo_dia_anterior)::NUMERIC(45,20)                                 as suma_saldos_iniciales,
            sum(tbn.saldo_rentabilidad)::NUMERIC(45,20)                                 as suma_saldo_rentabilidad,
            public.prod(COALESCE(tbn.rentabilidad_base_pitatoria,1))-1::NUMERIC(45,20)  as pitatoria,
            tbn.agregador_n1                                                            as agregador_n1,
            tbn.agregador_n2                                                            as agregador_n2,
            tbn.agregador_n3                                                            as agregador_n3,
            tbn.agregador_n4                                                            as agregador_n4
        FROM temptb_base_calculo tbn
        GROUP BY tbn.agregador_n1, tbn.agregador_n2, tbn.agregador_n3, tbn.agregador_n4
    ) as tb_calc
    ;

    DROP TABLE temptb_base_calculo;

    END;
$$;

alter function rep_inv.fn_calculo_rentabilidad_agregada(date, date, varchar, varchar, varchar, varchar) owner to postgres;

