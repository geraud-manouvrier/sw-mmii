create or replace function stage_pershing.fn_extrae_isca_reg_e(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, exp_first_call_price character varying, exp_first_par_call_price character varying, exp_put_price character varying, exp_second_premium_call_price character varying, name_issuer_security character varying, issuing_currency character varying, globally_locked_sec_ind character varying, globally_locked_reason_code character varying, spac_ind character varying, campo_14 character varying, eor character varying)
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
        substr(sfl_file.linea, 21, 18)::VARCHAR(100) as exp_first_call_price,
        substr(sfl_file.linea, 39, 18)::VARCHAR(100) as exp_first_par_call_price,
        substr(sfl_file.linea, 57, 18)::VARCHAR(100) as exp_put_price,
        substr(sfl_file.linea, 75, 18)::VARCHAR(100) as exp_second_premium_call_price,
        substr(sfl_file.linea, 93, 32)::VARCHAR(100) as name_issuer_security,
        substr(sfl_file.linea, 125, 3)::VARCHAR(100) as issuing_currency,
        substr(sfl_file.linea, 128, 1)::VARCHAR(100) as globally_locked_sec_ind,
        substr(sfl_file.linea, 129, 1)::VARCHAR(100) as globally_locked_reason_code,
        substr(sfl_file.linea, 130, 1)::VARCHAR(100) as spac_ind,
        substr(sfl_file.linea, 131, 1)::VARCHAR(100) as campo_14,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    AND substr(sfl_file.linea, 1, 18)		<> 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'E'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_e(bigint) owner to postgres;

