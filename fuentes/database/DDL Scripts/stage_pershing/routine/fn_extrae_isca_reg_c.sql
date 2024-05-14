create or replace function stage_pershing.fn_extrae_isca_reg_c(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, state_tax_ind character varying, fts_ind character varying, amt_ind character varying, ric_indicator character varying, number_of_description_lines character varying, secutiry_description_line_1 character varying, secutiry_description_line_2 character varying, secutiry_description_line_3 character varying, secutiry_description_line_4 character varying, secutiry_description_line_5 character varying, user_cusip_identifier character varying, price_purge_date character varying, taxable_indicator character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 1)::VARCHAR(100) as state_tax_ind,
        substr(sfl_file.linea, 18, 1)::VARCHAR(100) as fts_ind,
        substr(sfl_file.linea, 19, 1)::VARCHAR(100) as amt_ind,
        substr(sfl_file.linea, 20, 1)::VARCHAR(100) as ric_indicator,
        substr(sfl_file.linea, 21, 1)::VARCHAR(100) as number_of_description_lines,
        substr(sfl_file.linea, 22, 20)::VARCHAR(100) as secutiry_description_line_1,
        substr(sfl_file.linea, 42, 20)::VARCHAR(100) as secutiry_description_line_2,
        substr(sfl_file.linea, 62, 20)::VARCHAR(100) as secutiry_description_line_3,
        substr(sfl_file.linea, 82, 20)::VARCHAR(100) as secutiry_description_line_4,
        substr(sfl_file.linea, 102, 20)::VARCHAR(100) as secutiry_description_line_5,
        substr(sfl_file.linea, 122, 2)::VARCHAR(100) as user_cusip_identifier,
        substr(sfl_file.linea, 124, 7)::VARCHAR(100) as price_purge_date,
        substr(sfl_file.linea, 131, 1)::VARCHAR(100) as taxable_indicator,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'C'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_c(bigint) owner to postgres;

