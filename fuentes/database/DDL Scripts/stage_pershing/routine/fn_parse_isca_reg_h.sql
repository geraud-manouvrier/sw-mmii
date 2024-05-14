create or replace function stage_pershing.fn_parse_isca_reg_h(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_h
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
        public.fn_convierte_texto_numerico_cobol(exchange_rate_denom_currency_usd, 10)::NUMERIC(45,20) as exchange_rate_denom_currency_usd,
        underlying_cusip_1::VARCHAR(100),
        campo_7::VARCHAR(100),
        CASE WHEN trim(deliverable_unit_quantity_1)='' THEN NULL ELSE deliverable_unit_quantity_1 END::int as deliverable_unit_quantity_1,
        underlying_cusip_2::VARCHAR(100),
        campo_10::VARCHAR(100),
        CASE WHEN trim(deliverable_unit_quantity_2)='' THEN NULL ELSE deliverable_unit_quantity_2 END::int as deliverable_unit_quantity_2,
        underlying_cusip_3::VARCHAR(100),
        campo_13::VARCHAR(100),
        CASE WHEN trim(deliverable_unit_quantity_3)='' THEN NULL ELSE deliverable_unit_quantity_3 END::int as deliverable_unit_quantity_3,
        underlying_cusip_4::VARCHAR(100),
        campo_16::VARCHAR(100),
        CASE WHEN trim(deliverable_unit_quantity_4)='' THEN NULL ELSE deliverable_unit_quantity_4 END::int as deliverable_unit_quantity_4,
        annual_dividend_currency_code::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(outstanding_shares, 2)::NUMERIC(45,20) as outstanding_shares,
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_h(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_h(bigint) owner to postgres;

