create or replace function stage_pershing.fn_parse_isca_reg_o(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_o
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
        public.fn_convierte_texto_numerico_cobol(oas_treasury_rate, 9)::NUMERIC(45,20) as oas_treasury_rate,
        oas_treasury_rate_sign::VARCHAR(100),
        public.fn_fecha_string_to_date(oas_treasury_effective_date, 'CCYYMMDD') as oas_treasury_effective_date,
        public.fn_convierte_texto_numerico_cobol(minimum_piece, 3)::NUMERIC(45,20) as minimum_piece,
        public.fn_convierte_texto_numerico_cobol(minimum_increment, 3)::NUMERIC(45,20) as minimum_increment,
        public.fn_fecha_string_to_date(issue_date_security, 'CCYYMMDD') as issue_date_security,
        campo_11::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_o(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_o(bigint) owner to postgres;

