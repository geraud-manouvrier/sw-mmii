create or replace function stage_pershing.fn_extrae_acct_reg_trailer(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, eof character varying, campo_02 character varying, campo_03 character varying, date_of_data character varying, campo_05 character varying, remote_id character varying, campo_07 character varying, campo_08 character varying, number_of_detail_records character varying, campo_10 character varying, refreshed_or_updated character varying, campo_12 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as eof,
        substr(sfl_file.linea, 19, 18)::VARCHAR(100) as campo_02,
        substr(sfl_file.linea, 37, 10)::VARCHAR(100) as campo_03,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_05,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 12)::VARCHAR(100) as campo_07,
        substr(sfl_file.linea, 84, 22)::VARCHAR(100) as campo_08,
        substr(sfl_file.linea, 106, 10)::VARCHAR(100) as number_of_detail_records,
        substr(sfl_file.linea, 116, 3)::VARCHAR(100) as campo_10,
        substr(sfl_file.linea, 119, 9)::VARCHAR(100) as refreshed_or_updated,
        substr(sfl_file.linea, 128, 622)::VARCHAR(100) as campo_12,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CIW'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_acct_reg_trailer(bigint) owner to postgres;

