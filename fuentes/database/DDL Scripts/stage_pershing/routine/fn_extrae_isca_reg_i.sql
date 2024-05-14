create or replace function stage_pershing.fn_extrae_isca_reg_i(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, option_root_id character varying, expiration_date character varying, call_put_indicator character varying, strike_price character varying, fund_type character varying, broad_narrow_indicator character varying, leverage_factor character varying, leverage_factor_sign character varying, outstanding_shares_update_date character varying, expanded_symbol character varying, state_of_issuance character varying, option_excercise_pricing_model_code character varying, first_accrual_date character varying, tranche_code character varying, campo_19 character varying, worthless_security_indicator character varying, uit_termination_code character varying, fdic_certification_number character varying, revenue_stream character varying, restricted_marijuana_ind character varying, campo_25 character varying, eor character varying)
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
        substr(sfl_file.linea, 21, 6)::VARCHAR(100) as option_root_id,
        substr(sfl_file.linea, 27, 6)::VARCHAR(100) as expiration_date,
        substr(sfl_file.linea, 33, 1)::VARCHAR(100) as call_put_indicator,
        substr(sfl_file.linea, 34, 8)::VARCHAR(100) as strike_price,
        substr(sfl_file.linea, 42, 1)::VARCHAR(100) as fund_type,
        substr(sfl_file.linea, 43, 1)::VARCHAR(100) as broad_narrow_indicator,
        substr(sfl_file.linea, 44, 18)::VARCHAR(100) as leverage_factor,
        substr(sfl_file.linea, 62, 1)::VARCHAR(100) as leverage_factor_sign,
        substr(sfl_file.linea, 63, 8)::VARCHAR(100) as outstanding_shares_update_date,
        substr(sfl_file.linea, 71, 16)::VARCHAR(100) as expanded_symbol,
        substr(sfl_file.linea, 87, 2)::VARCHAR(100) as state_of_issuance,
        substr(sfl_file.linea, 89, 1)::VARCHAR(100) as option_excercise_pricing_model_code,
        substr(sfl_file.linea, 90, 8)::VARCHAR(100) as first_accrual_date,
        substr(sfl_file.linea, 98, 6)::VARCHAR(100) as tranche_code,
        substr(sfl_file.linea, 104, 2)::VARCHAR(100) as campo_19,
        substr(sfl_file.linea, 106, 1)::VARCHAR(100) as worthless_security_indicator,
        substr(sfl_file.linea, 107, 8)::VARCHAR(100) as uit_termination_code,
        substr(sfl_file.linea, 115, 8)::VARCHAR(100) as fdic_certification_number,
        substr(sfl_file.linea, 123, 3)::VARCHAR(100) as revenue_stream,
        substr(sfl_file.linea, 126, 1)::VARCHAR(100) as restricted_marijuana_ind,
        substr(sfl_file.linea, 127, 5)::VARCHAR(100) as campo_25,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'I'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_i(bigint) owner to postgres;

