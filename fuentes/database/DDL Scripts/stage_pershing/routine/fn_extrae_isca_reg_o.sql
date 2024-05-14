create or replace function stage_pershing.fn_extrae_isca_reg_o(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, oas_treasury_rate character varying, oas_treasury_rate_sign character varying, oas_treasury_effective_date character varying, minimum_piece character varying, minimum_increment character varying, issue_date_security character varying, campo_11 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 4)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 21, 18)::VARCHAR(100) as oas_treasury_rate,
        substr(sfl_file.linea, 39, 1)::VARCHAR(100) as oas_treasury_rate_sign,
        substr(sfl_file.linea, 40, 8)::VARCHAR(100) as oas_treasury_effective_date,
        substr(sfl_file.linea, 48, 15)::VARCHAR(100) as minimum_piece,
        substr(sfl_file.linea, 63, 15)::VARCHAR(100) as minimum_increment,
        substr(sfl_file.linea, 78, 8)::VARCHAR(100) as issue_date_security,
        substr(sfl_file.linea, 86, 46)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'O'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_o(bigint) owner to postgres;

