create or replace function pershing.fn_proceso_sfl(_process_date character varying, _process_stamp_app character varying, _message character varying) returns pershing.proceso_sfl
    language plpgsql
as
$$
DECLARE _id_proceso_sfl bigint;
DECLARE _ahora timestamp;
DECLARE _proceso_sfl pershing.proceso_sfl;
    BEGIN
        _ahora              := now();

        SELECT id INTO _id_proceso_sfl FROM pershing.proceso_sfl WHERE process_date=_process_date AND process_stamp=_process_stamp_app;

        IF ( _id_proceso_sfl IS NULL) THEN
           --No existe proceso, lo creamos
            INSERT INTO pershing.proceso_sfl (process_date, process_stamp, start_timestamp, last_step_timestamp, info_log, id_estado_proceso_sfl)
            VALUES (_process_date, _process_stamp_app, _ahora, _ahora, 'Proceso iniciado||'||_message, -1);
           _id_proceso_sfl  := LASTVAL();
        ELSE
            --Actualizamos info
            UPDATE pershing.proceso_sfl SET
                last_step_timestamp = _ahora,
                info_log            = info_log||'||'||_message
            WHERE id=_id_proceso_sfl;
        END IF;

    SELECT * INTO _proceso_sfl FROM pershing.proceso_sfl WHERE id=_id_proceso_sfl;

    RETURN _proceso_sfl;
    END;
$$;

alter function pershing.fn_proceso_sfl(varchar, varchar, varchar) owner to postgres;

