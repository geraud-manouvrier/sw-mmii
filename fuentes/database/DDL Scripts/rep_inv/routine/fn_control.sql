create or replace function rep_inv.fn_control(_process_date character varying, _exec_monthly boolean, _exec_daily boolean)
    returns TABLE(id bigint, id_control integer, glosa_control character varying, descripcion_control character varying, process_date character varying, identificador character varying, cant_reg integer)
    language plpgsql
as
$$
DECLARE _timestamp_reg timestamp;
DECLARE _timestamp_proceso timestamp;
    BEGIN
        _timestamp_proceso  := clock_timestamp();
        _timestamp_reg      := _timestamp_proceso;
        if (_exec_monthly IS NULL) THEN
            _exec_monthly := COALESCE((
                SELECT dia_del_mes=1 from public.vw_calendario
                where fecha_as_str>_process_date
                ORDER BY fecha_as_date ASC
                LIMIT 1
                ), false);
        END IF;
        IF (_exec_daily IS NULL) THEN
            _exec_daily := TRUE;
        END IF;

        DROP TABLE IF EXISTS temp_control;
        CREATE TEMP TABLE temp_control (
            id_control integer, glosa_control VARCHAR (1000), descripcion_control VARCHAR (1000), process_date VARCHAR (100), identificador VARCHAR (100), cant_reg integer
        );

        --Control 01
        _timestamp_reg  :=  clock_timestamp();
        RAISE NOTICE 'Ejecutando control 01...';
        INSERT INTO temp_control (id_control, glosa_control, descripcion_control, process_date, identificador, cant_reg)
        SELECT FN_CTRL_01.id_control, FN_CTRL_01.glosa_control, FN_CTRL_01.descripcion_control, FN_CTRL_01.process_date, FN_CTRL_01.identificador, FN_CTRL_01.cant_reg
        FROM rep_inv.fn_control_rentabilidades_significativas(_process_date, _exec_monthly, _exec_daily) as FN_CTRL_01;
        RAISE NOTICE 'Control 01 ejecutado [%]', clock_timestamp()-_timestamp_reg;


        --Control 02
        IF (FALSE) THEN
            RAISE NOTICE 'Saltando control 02 Rep Inv';
        ELSE
            _timestamp_reg  :=  clock_timestamp();
            RAISE NOTICE 'Ejecutando control 02...';
            INSERT INTO temp_control (id_control, glosa_control, descripcion_control, process_date, identificador, cant_reg)
            SELECT FN_CTRL_02.id_control,FN_CTRL_02.glosa_control,FN_CTRL_02.descripcion_control,FN_CTRL_02.process_date,FN_CTRL_02.identificador,FN_CTRL_02.cant_reg
            FROM rep_inv.fn_control_saldo_dia_negativo(_process_date) as FN_CTRL_02;
            RAISE NOTICE 'Control 02 ejecutado [%]', clock_timestamp()-_timestamp_reg;
        END IF;


        --Control 03
        IF (FALSE) THEN
            RAISE NOTICE 'Saltando control 03 Rep Inv';
        ELSE
            _timestamp_reg  :=  clock_timestamp();
            RAISE NOTICE 'Ejecutando control 03...';
            INSERT INTO temp_control (id_control, glosa_control, descripcion_control, process_date, identificador, cant_reg)
            SELECT FN_CTRL_03.id_control,FN_CTRL_03.glosa_control,FN_CTRL_03.descripcion_control,FN_CTRL_03.process_date,FN_CTRL_03.identificador,FN_CTRL_03.cant_reg
            FROM rep_inv.fn_control_agregadores_invalidos(_process_date) as FN_CTRL_03;
            RAISE NOTICE 'Control 03 ejecutado [%]', clock_timestamp()-_timestamp_reg;
        END IF;



    RETURN QUERY
        SELECT
            (ROW_NUMBER() OVER())::bigint as id,
            TB_CD.id_control, TB_CD.glosa_control, TB_CD.descripcion_control, TB_CD.process_date, TB_CD.identificador, TB_CD.cant_reg
        FROM temp_control TB_CD
        ORDER BY TB_CD.id_control, TB_CD.process_date DESC,
                 TB_CD.identificador ASC, TB_CD.cant_reg ASC
        ;

    RETURN;
    END;
$$;

alter function rep_inv.fn_control(varchar, boolean, boolean) owner to postgres;

