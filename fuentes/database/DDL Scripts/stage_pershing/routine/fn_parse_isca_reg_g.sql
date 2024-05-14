create or replace function stage_pershing.fn_parse_isca_reg_g(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_g
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
        public.fn_convierte_texto_numerico_cobol(delta, 9)::NUMERIC(45,20) as delta,
        delta_sign::VARCHAR(100),
        delta_value_presence_ind::VARCHAR(100),
        campo_8::VARCHAR(100),
        isin_code::VARCHAR(100),
        issuer_identifier::VARCHAR(100),
        campo_11::VARCHAR(100),
        campo_12::VARCHAR(100),
        symbol_of_the_underlying_security::VARCHAR(100),
        asset_type::VARCHAR(100),
        asset_subtype::VARCHAR(100),
        asset_subsubtype::VARCHAR(100),
        payment_day_delays::int,
        campo_18::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_g(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_g(bigint) owner to postgres;

