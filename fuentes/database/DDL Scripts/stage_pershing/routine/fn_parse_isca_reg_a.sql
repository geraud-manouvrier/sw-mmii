create or replace function stage_pershing.fn_parse_isca_reg_a(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_a
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        security_type::VARCHAR(100),
        security_modifier::VARCHAR(100),
        security_calculation_code::VARCHAR(100),
        primary_exchange::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(coupon_rate_fis_or_indicated_dividend_eq, 3)::NUMERIC(45,20) as coupon_rate_fis_or_indicated_dividend_eq,
        public.fn_fecha_string_to_date(maturity_option_expire_date, 'CCYYDDD') as maturity_option_expire_date,
        underlying_security_cusip::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(first_call_price_fix_inc_or_strike_price_option, 4)::NUMERIC(45,20) as first_call_price_fix_inc_or_strike_price_option,
        public.fn_convierte_texto_numerico_cobol(first_par_call_price_fix_inc_or_units_option, 4)::NUMERIC(45,20) as first_par_call_price_fix_inc_or_units_option,
        primary_symbol::VARCHAR(100),
        interest_frequency::VARCHAR(100),
        bond_class::VARCHAR(100),
        first_coupon_day::VARCHAR(100),
        call_indicator::VARCHAR(100),
        put_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(next_par_call_date, 'CCYYDDD') as next_par_call_date,
        public.fn_fecha_string_to_date(prerefunded_date, 'CCYYDDD') as prerefunded_date,
        public.fn_fecha_string_to_date(next_premium_call_date, 'CCYYDDD') as next_premium_call_date,
        public.fn_fecha_string_to_date(dated_date_for_fix_inc_or_ex_dividend_date_eq, 'CCYYDDD') as dated_date_for_fix_inc_or_ex_dividend_date_eq,
        public.fn_fecha_string_to_date(first_coupon_fix_inc_or_payable_date_eq, 'CCYYDDD') as first_coupon_fix_inc_or_payable_date_eq,
        campo_24::VARCHAR(100),
        federal_marginable_ind::VARCHAR(100),
        cns_eligible_code::VARCHAR(100),
        dtcc_eligible_code::VARCHAR(100),
        nscc_eligible_code::VARCHAR(100),
        foreign_security::VARCHAR(100),
        second_coupon_day::VARCHAR(100),
        dividend_interest_payment_method::VARCHAR(100),
        minor_product_code::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_a(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_a(bigint) owner to postgres;

