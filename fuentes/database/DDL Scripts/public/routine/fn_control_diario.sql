create or replace function public.fn_control_diario(_process_date character varying, _username character varying) returns SETOF control_diario
    language plpgsql
as
$$
DECLARE _timestamp_reg timestamp;
DECLARE _timestamp_proceso timestamp;
DECLARE _menor_correlativo int;
DECLARE _correlativo int;
DECLARE _id_jobs_log bigint;
DECLARE _id_jobs_etdo int;
DECLARE _count_errors int;
    BEGIN
        _timestamp_proceso  := clock_timestamp();
        _timestamp_reg      := _timestamp_proceso;
        _correlativo        := -1;

        RAISE NOTICE 'Iniciando ejecución job Control Diario para fecha [%]', _process_date;

        INSERT INTO public.jobs_log (id_job, start_timestamp, end_timestamp, id_proceso, sub_id_proceso, info)
        VALUES (1, _timestamp_proceso, NULL, _process_date, NULL, NULL);
        _id_jobs_log  := LASTVAL();

        SELECT id INTO _id_jobs_etdo from public.jobs_estado WHERE id_job=1 AND id_proceso=_process_date AND sub_id_proceso='';
        IF (_id_jobs_etdo IS NOT NULL) THEN
            DELETE FROM public.jobs_estado WHERE id_job=1 AND id_proceso=_process_date AND sub_id_proceso='';
        end if;

        INSERT INTO public.jobs_estado (id_job, id_proceso, sub_id_proceso, start_timestamp, end_timestamp, estado)
        VALUES (1, _process_date, '', _timestamp_proceso, NULL, NULL);
        _id_jobs_etdo  := LASTVAL();

        SELECT min(correlativo_diario) INTO _menor_correlativo
        FROM public.control_diario TB_CD WHERE TB_CD.process_date=_process_date;

        IF ( COALESCE(_menor_correlativo,0)<0 ) THEN
            RAISE NOTICE 'Actualizando correlativos para fecha proceso [%], usuario [%]', _process_date, _username;
            UPDATE public.control_diario  SET correlativo_diario=correlativo_diario+ABS(_menor_correlativo)
            WHERE process_date=_process_date;
        END IF;

        --Control 01
        _timestamp_reg  :=  clock_timestamp();
        RAISE NOTICE 'Ejecutando control 01...';
        INSERT INTO public.control_diario (correlativo_diario, process_date, timestamp_control, timestamp_registro, id_control, glosa_control, descripcion_control, identificador, cant_reg, username)
        SELECT _correlativo as correlativo_diario,_process_date as process_date,_timestamp_proceso as timestamp_control,_timestamp_reg as timestamp_registro,
               FN_CTRL_01.id_control,FN_CTRL_01.glosa_control,FN_CTRL_01.descripcion_control,FN_CTRL_01.identificador,FN_CTRL_01.cant_reg,
               _username as username
        FROM public.fn_control_diario_cuentas_no_mapeadas(_process_date) as FN_CTRL_01;
        RAISE NOTICE 'Control 01 ejecutado [%]', clock_timestamp()-_timestamp_reg;

        RAISE NOTICE 'Desplazando correlativos';
        UPDATE public.control_diario SET correlativo_diario=correlativo_diario+ 1
        WHERE process_date=_process_date;

        SELECT count(*) INTO _count_errors FROM public.control_diario WHERE process_date=_process_date AND correlativo_diario=0;
        RAISE NOTICE 'Se encontraron [%] registros con errores', _count_errors;


        RETURN QUERY
            SELECT *
            FROM public.control_diario TB_CD
            WHERE TB_CD.process_date=_process_date AND TB_CD.correlativo_diario=0
            ORDER BY TB_CD.process_date DESC, TB_CD.correlativo_diario ASC,
                TB_CD.id_control ASC, TB_CD.identificador ASC, TB_CD.cant_reg ASC
            ;

        UPDATE public.jobs_log tb_log SET end_timestamp = clock_timestamp() WHERE tb_log.id=_id_jobs_log;
        UPDATE public.jobs_estado SET estado=_count_errors, end_timestamp=clock_timestamp() WHERE id=_id_jobs_etdo;

        RETURN;



    EXCEPTION
        WHEN OTHERS THEN
            -- Revertir cambios de la lógica principal
            RAISE EXCEPTION 'Error en fn_control_diario para process date [%]: %', _process_date, SQLERRM;

    END;
$$;

alter function public.fn_control_diario(varchar, varchar) owner to postgres;

