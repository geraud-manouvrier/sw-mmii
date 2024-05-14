create or replace function stage_pershing.fn_parse_isca_reg_i(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_i
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
        campo_4::VARCHAR(100),
        option_root_id::VARCHAR(100),
        public.fn_fecha_string_to_date(expiration_date, 'YYMMDD') as expiration_date,
        call_put_indicator::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(strike_price, 3)::NUMERIC(45,20) as strike_price,
        fund_type::VARCHAR(100),
        broad_narrow_indicator::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(leverage_factor, 9)::NUMERIC(45,20) as leverage_factor,
        leverage_factor_sign::VARCHAR(100),
        public.fn_fecha_string_to_date(outstanding_shares_update_date, 'CCYYMMDD') as outstanding_shares_update_date,
        expanded_symbol::VARCHAR(100),
        state_of_issuance::VARCHAR(100),
        option_excercise_pricing_model_code::VARCHAR(100),
        public.fn_fecha_string_to_date(first_accrual_date, 'CCYYMMDD') as first_accrual_date,
        tranche_code::VARCHAR(100),
        campo_19::VARCHAR(100),
        worthless_security_indicator::VARCHAR(100),
        uit_termination_code::int,
        fdic_certification_number::VARCHAR(100),
        revenue_stream::VARCHAR(100),
        restricted_marijuana_ind::VARCHAR(100),
        campo_25::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_i(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_i(bigint) owner to postgres;

