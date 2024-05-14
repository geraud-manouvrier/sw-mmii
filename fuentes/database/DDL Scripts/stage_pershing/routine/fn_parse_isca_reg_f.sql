create or replace function stage_pershing.fn_parse_isca_reg_f(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_f
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
        public.fn_convierte_texto_numerico_cobol(expanded_bid_price, 9)::NUMERIC(45,20) as expanded_bid_price,
        public.fn_convierte_texto_numerico_cobol(expanded_ask_price, 9)::NUMERIC(45,20) as expanded_ask_price,
        public.fn_convierte_texto_numerico_cobol(expanded_previous_day_price, 9)::NUMERIC(45,20) as expanded_previous_day_price,
        public.fn_convierte_texto_numerico_cobol(expanded_latest_price, 9)::NUMERIC(45,20) as expanded_latest_price,
        public.fn_convierte_texto_numerico_cobol(expanded_end_of_month_price, 9)::NUMERIC(45,20) as expanded_end_of_month_price,
        public.fn_convierte_texto_numerico_cobol(contract_share_quantity, 2)::NUMERIC(45,20) as contract_share_quantity,
        year_covered_under_cost_basis_rules::int,
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_f(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_f(bigint) owner to postgres;

