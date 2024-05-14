create or replace function stage_pershing.fn_parse_isca_reg_b(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_b
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
        etf_indicator::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(bid_price, 4)::NUMERIC(45,20) as bid_price,
        public.fn_convierte_texto_numerico_cobol(ask_price, 4)::NUMERIC(45,20) as ask_price,
        public.fn_convierte_texto_numerico_cobol(previous_day_price, 4)::NUMERIC(45,20) as previous_day_price,
        public.fn_convierte_texto_numerico_cobol(latest_price, 4)::NUMERIC(45,20) as latest_price,
        public.fn_convierte_texto_numerico_cobol(end_of_month_price, 4)::NUMERIC(45,20) as end_of_month_price,
        round_lot_quantity::int,
        dividend_reinvestment_eligibility_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(previous_price_date, 'CCYYDDD') as previous_price_date,
        public.fn_fecha_string_to_date(latest_price_date, 'CCYYDDD') as latest_price_date,
        public.fn_fecha_string_to_date(end_of_month_price_date, 'CCYYDDD') as end_of_month_price_date,
        public.fn_fecha_string_to_date(record_date, 'CCYYDDD') as record_date,
        fundvest_ind::VARCHAR(100),
        country_code::VARCHAR(100),
        standard_poor_rating::VARCHAR(100),
        moodys_rating::VARCHAR(100),
        bond_sub_class::VARCHAR(100),
        restriction_indicator::VARCHAR(100),
        trace_indicator::VARCHAR(100),
        new_interest_calculation_code::VARCHAR(100),
        sic_code::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_b(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_b(bigint) owner to postgres;

