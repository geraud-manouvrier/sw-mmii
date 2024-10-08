create or replace function stage_pershing.fn_extrae_isca_reg_header(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, bof character varying, campo_2 character varying, campo_3 character varying, date_of_data character varying, campo_5 character varying, remote_id character varying, campo_7 character varying, run_date character varying, campo_9 character varying, run_time character varying, campo_11 character varying, refreshed_or_updated character varying, campo_13 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as bof,
        substr(sfl_file.linea, 19, 18)::VARCHAR(100) as campo_2,
        substr(sfl_file.linea, 37, 10)::VARCHAR(100) as campo_3,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 14)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 86, 10)::VARCHAR(100) as run_date,
        substr(sfl_file.linea, 96, 1)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 97, 8)::VARCHAR(100) as run_time,
        substr(sfl_file.linea, 105, 14)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 119, 9)::VARCHAR(100) as refreshed_or_updated,
        substr(sfl_file.linea, 128, 4)::VARCHAR(100) as campo_13,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 3)		= 'SRA'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_header(bigint) owner to postgres;

