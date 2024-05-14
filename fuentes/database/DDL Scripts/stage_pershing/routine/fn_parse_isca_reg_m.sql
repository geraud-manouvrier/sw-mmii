create or replace function stage_pershing.fn_parse_isca_reg_m(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_m
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
        public.fn_fecha_string_to_date(first_call_date, 'CCYYMMDD') as first_call_date,
        public.fn_convierte_texto_numerico_cobol(first_call_price, 9)::NUMERIC(45,20) as first_call_price,
        campo_8::VARCHAR(100),
        public.fn_fecha_string_to_date(second_call_date, 'CCYYMMDD') as second_call_date,
        public.fn_convierte_texto_numerico_cobol(second_call_price, 9)::NUMERIC(45,20) as second_call_price,
        campo_11::VARCHAR(100),
        public.fn_fecha_string_to_date(third_call_date, 'CCYYMMDD') as third_call_date,
        public.fn_convierte_texto_numerico_cobol(third_call_price, 9)::NUMERIC(45,20) as third_call_price,
        campo_14::VARCHAR(100),
        public.fn_fecha_string_to_date(fourth_call_date, 'CCYYMMDD') as fourth_call_date,
        public.fn_convierte_texto_numerico_cobol(fourth_call_price, 9)::NUMERIC(45,20) as fourth_call_price,
        campo_17::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_m(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_m(bigint) owner to postgres;

