create or replace function public.fn_control_diario(_process_date character varying, _username character varying) returns SETOF control_diario
    language plpgsql
as
$$
DECLARE _timestamp_reg timestamp;
DECLARE _timestamp_proceso timestamp;
DECLARE _menor_correlativo int;
DECLARE _correlativo int;
DECLARE _id_jobs_log bigint;
    BEGIN
        _timestamp_proceso  := clock_timestamp();
        _timestamp_reg      := _timestamp_proceso;
        _correlativo        := -1;

        INSERT INTO public.jobs_log (id_job, start_timestamp, end_timestamp, id_proceso, sub_id_proceso, info)
        VALUES (1, _timestamp_proceso, NULL, _process_date, NULL, NULL);
        _id_jobs_log  := LASTVAL();

        SELECT min(correlativo_diario) INTO _menor_correlativo
        FROM public.control_diario TB_CD WHERE TB_CD.process_date=_process_date;

        IF ( COALESCE(_menor_correlativo,0)<0 ) THEN
            RAISE NOTICE 'Actualizando correlativos para fecha proceso [%], usuario [%]', _process_date, _username;
            UPDATE public.control_diario  SET correlativo_diario=correlativo_diario+ABS(_menor_correlativo)
            WHERE process_date=_process_date;
        END IF;


        RAISE NOTICE 'Desplazando correlativos';
        UPDATE public.control_diario SET correlativo_diario=correlativo_diario+ 1
        WHERE process_date=_process_date;

        UPDATE public.jobs_log tb_log SET end_timestamp = clock_timestamp() WHERE tb_log.id=_id_jobs_log;

    RETURN QUERY
        SELECT *
        FROM public.control_diario TB_CD
        WHERE TB_CD.process_date=_process_date AND TB_CD.correlativo_diario=0
        ORDER BY TB_CD.process_date DESC, TB_CD.correlativo_diario ASC,
            TB_CD.id_control ASC, TB_CD.identificador ASC, TB_CD.cant_reg ASC
        ;

    RETURN;
    END;
$$;

alter function public.fn_control_diario(varchar, varchar) owner to postgres;

