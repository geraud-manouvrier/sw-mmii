create or replace function stage_pershing.fn_extrae_isca_reg_g(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, delta character varying, delta_sign character varying, delta_value_presence_ind character varying, campo_8 character varying, isin_code character varying, issuer_identifier character varying, campo_11 character varying, campo_12 character varying, symbol_of_the_underlying_security character varying, asset_type character varying, asset_subtype character varying, asset_subsubtype character varying, payment_day_delays character varying, campo_18 character varying, eor character varying)
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
        substr(sfl_file.linea, 21, 18)::VARCHAR(100) as delta,
        substr(sfl_file.linea, 39, 1)::VARCHAR(100) as delta_sign,
        substr(sfl_file.linea, 40, 1)::VARCHAR(100) as delta_value_presence_ind,
        substr(sfl_file.linea, 41, 12)::VARCHAR(100) as campo_8,
        substr(sfl_file.linea, 53, 12)::VARCHAR(100) as isin_code,
        substr(sfl_file.linea, 65, 15)::VARCHAR(100) as issuer_identifier,
        substr(sfl_file.linea, 80, 2)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 82, 3)::VARCHAR(100) as campo_12,
        substr(sfl_file.linea, 85, 16)::VARCHAR(100) as symbol_of_the_underlying_security,
        substr(sfl_file.linea, 101, 8)::VARCHAR(100) as asset_type,
        substr(sfl_file.linea, 109, 8)::VARCHAR(100) as asset_subtype,
        substr(sfl_file.linea, 117, 8)::VARCHAR(100) as asset_subsubtype,
        substr(sfl_file.linea, 125, 3)::VARCHAR(100) as payment_day_delays,
        substr(sfl_file.linea, 128, 4)::VARCHAR(100) as campo_18,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'G'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_g(bigint) owner to postgres;

