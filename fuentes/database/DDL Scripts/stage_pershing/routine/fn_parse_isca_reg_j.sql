create or replace function stage_pershing.fn_parse_isca_reg_j(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_j
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
        public.fn_convierte_texto_numerico_cobol(latest_price, 9)::NUMERIC(45,20) as latest_price,
        public.fn_fecha_string_to_date(latest_price_date, 'CCYYMMDD') as latest_price_date,
        public.fn_convierte_texto_numerico_cobol(factored_market_value_multiplier, 12)::NUMERIC(45,20) as factored_market_value_multiplier,
        public.fn_convierte_texto_numerico_cobol(current_yield, 9)::NUMERIC(45,20) as current_yield,
        public.fn_convierte_texto_numerico_cobol(yield, 9)::NUMERIC(45,20) as yield,
        price_source::VARCHAR(100),
        country_of_origin::VARCHAR(100),
        retricted_security_code::VARCHAR(100),
        international_non_dollar_symbol::VARCHAR(100),
        international_exchange::VARCHAR(100),
        variable_rate_category_code::VARCHAR(100),
        interest_rate_completion_ind::VARCHAR(100),
        campo_17::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_j(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_j(bigint) owner to postgres;

