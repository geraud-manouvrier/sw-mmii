create or replace function stage_pershing.fn_parse_isca_reg_l(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_l
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
        primary_idc_mkt_exch::VARCHAR(100),
        primary_mkt_exch_trading_status::VARCHAR(100),
        primary_mkt_symbol::VARCHAR(100),
        public.fn_fecha_string_to_date(primary_mkt_exch_effective_date, 'CCYYMMDD') as primary_mkt_exch_effective_date,
        primary_mkt_status_code::VARCHAR(100),
        secondary_idc_mkt_exch::VARCHAR(100),
        secondary_mkt_exch_trading_status::VARCHAR(100),
        secondary_mkt_symbol::VARCHAR(100),
        public.fn_fecha_string_to_date(secondary_mkt_exch_effective_date, 'CCYYMMDD') as secondary_mkt_exch_effective_date,
        secondary_mkt_status_code::VARCHAR(100),
        tick_size_pilot_group::VARCHAR(100),
        public.fn_fecha_string_to_date(tick_size_effective_date, 'CCYYMMDD') as tick_size_effective_date,
        public.fn_fecha_string_to_date(tick_size_change_date, 'CCYYMMDD') as tick_size_change_date,
        public.fn_fecha_string_to_date(update_date, 'CCYYMMDD') as update_date,
        public.fn_convierte_texto_numerico_cobol(oas_libor_rate, 9)::NUMERIC(45,20) as oas_libor_rate,
        oas_libor_rate_sign::VARCHAR(100),
        campo_21::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_l(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_l(bigint) owner to postgres;

