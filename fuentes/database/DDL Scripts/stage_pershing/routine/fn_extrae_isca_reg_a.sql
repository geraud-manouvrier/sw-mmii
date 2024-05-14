create or replace function stage_pershing.fn_extrae_isca_reg_a(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, security_type character varying, security_modifier character varying, security_calculation_code character varying, primary_exchange character varying, coupon_rate_fis_or_indicated_dividend_eq character varying, maturity_option_expire_date character varying, underlying_security_cusip character varying, first_call_price_fix_inc_or_strike_price_option character varying, first_par_call_price_fix_inc_or_units_option character varying, primary_symbol character varying, interest_frequency character varying, bond_class character varying, first_coupon_day character varying, call_indicator character varying, put_indicator character varying, next_par_call_date character varying, prerefunded_date character varying, next_premium_call_date character varying, dated_date_for_fix_inc_or_ex_dividend_date_eq character varying, first_coupon_fix_inc_or_payable_date_eq character varying, campo_24 character varying, federal_marginable_ind character varying, cns_eligible_code character varying, dtcc_eligible_code character varying, nscc_eligible_code character varying, foreign_security character varying, second_coupon_day character varying, dividend_interest_payment_method character varying, minor_product_code character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 1)::VARCHAR(100) as security_type,
        substr(sfl_file.linea, 18, 1)::VARCHAR(100) as security_modifier,
        substr(sfl_file.linea, 19, 1)::VARCHAR(100) as security_calculation_code,
        substr(sfl_file.linea, 20, 1)::VARCHAR(100) as primary_exchange,
        substr(sfl_file.linea, 21, 7)::VARCHAR(100) as coupon_rate_fis_or_indicated_dividend_eq,
        substr(sfl_file.linea, 28, 7)::VARCHAR(100) as maturity_option_expire_date,
        substr(sfl_file.linea, 35, 9)::VARCHAR(100) as underlying_security_cusip,
        substr(sfl_file.linea, 44, 9)::VARCHAR(100) as first_call_price_fix_inc_or_strike_price_option,
        substr(sfl_file.linea, 53, 9)::VARCHAR(100) as first_par_call_price_fix_inc_or_units_option,
        substr(sfl_file.linea, 62, 10)::VARCHAR(100) as primary_symbol,
        substr(sfl_file.linea, 72, 2)::VARCHAR(100) as interest_frequency,
        substr(sfl_file.linea, 74, 1)::VARCHAR(100) as bond_class,
        substr(sfl_file.linea, 75, 2)::VARCHAR(100) as first_coupon_day,
        substr(sfl_file.linea, 77, 1)::VARCHAR(100) as call_indicator,
        substr(sfl_file.linea, 78, 1)::VARCHAR(100) as put_indicator,
        substr(sfl_file.linea, 79, 7)::VARCHAR(100) as next_par_call_date,
        substr(sfl_file.linea, 86, 7)::VARCHAR(100) as prerefunded_date,
        substr(sfl_file.linea, 93, 7)::VARCHAR(100) as next_premium_call_date,
        substr(sfl_file.linea, 100, 7)::VARCHAR(100) as dated_date_for_fix_inc_or_ex_dividend_date_eq,
        substr(sfl_file.linea, 107, 7)::VARCHAR(100) as first_coupon_fix_inc_or_payable_date_eq,
        substr(sfl_file.linea, 114, 7)::VARCHAR(100) as campo_24,
        substr(sfl_file.linea, 121, 1)::VARCHAR(100) as federal_marginable_ind,
        substr(sfl_file.linea, 122, 1)::VARCHAR(100) as cns_eligible_code,
        substr(sfl_file.linea, 123, 1)::VARCHAR(100) as dtcc_eligible_code,
        substr(sfl_file.linea, 124, 1)::VARCHAR(100) as nscc_eligible_code,
        substr(sfl_file.linea, 125, 1)::VARCHAR(100) as foreign_security,
        substr(sfl_file.linea, 126, 2)::VARCHAR(100) as second_coupon_day,
        substr(sfl_file.linea, 128, 1)::VARCHAR(100) as dividend_interest_payment_method,
        substr(sfl_file.linea, 129, 3)::VARCHAR(100) as minor_product_code,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'A'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_a(bigint) owner to postgres;

