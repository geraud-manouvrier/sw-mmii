create or replace function stage_pershing.fn_parse_isca_reg_n(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_n
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
        campo_5::VARCHAR(100),
        public.fn_fecha_string_to_date(effective_date_rate_1, 'CCYYMMDD') as effective_date_rate_1,
        public.fn_convierte_texto_numerico_cobol(coupon_interest_rate_1, 9)::NUMERIC(45,20) as coupon_interest_rate_1,
        campo_8::VARCHAR(100),
        public.fn_fecha_string_to_date(effective_date_rate_2, 'CCYYMMDD') as effective_date_rate_2,
        public.fn_convierte_texto_numerico_cobol(coupon_interest_rate_2, 9)::NUMERIC(45,20) as coupon_interest_rate_2,
        campo_11::VARCHAR(100),
        public.fn_fecha_string_to_date(effective_date_rate_3, 'CCYYMMDD') as effective_date_rate_3,
        public.fn_convierte_texto_numerico_cobol(coupon_interest_rate_3, 9)::NUMERIC(45,20) as coupon_interest_rate_3,
        campo_14::VARCHAR(100),
        public.fn_fecha_string_to_date(effective_date_rate_4, 'CCYYMMDD') as effective_date_rate_4,
        public.fn_convierte_texto_numerico_cobol(coupon_interest_rate_4, 9)::NUMERIC(45,20) as coupon_interest_rate_4,
        campo_17::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_n(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_n(bigint) owner to postgres;

