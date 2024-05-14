create or replace function stage_pershing.fn_extrae_isrc_reg_trailer(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, eof character varying, campo_2 character varying, campo_3 character varying, date_of_data character varying, campo_5 character varying, remote_id character varying, campo_7 character varying, campo_8 character varying, number_of_records character varying, campo_10 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as eof,
        substr(sfl_file.linea, 19, 18)::VARCHAR(100) as campo_2,
        substr(sfl_file.linea, 37, 10)::VARCHAR(100) as campo_3,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 12)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 84, 22)::VARCHAR(100) as campo_8,
        substr(sfl_file.linea, 106, 10)::VARCHAR(100) as number_of_records,
        substr(sfl_file.linea, 116, 134)::VARCHAR(100) as campo_10,
        substr(sfl_file.linea, 250, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isrc_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 3)		= 'SRA'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isrc_reg_trailer(bigint) owner to postgres;
