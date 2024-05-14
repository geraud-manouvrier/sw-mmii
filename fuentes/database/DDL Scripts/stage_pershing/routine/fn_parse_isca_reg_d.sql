create or replace function stage_pershing.fn_parse_isca_reg_d(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_d
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
        secutiry_description_line_6::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(put_price, 4)::NUMERIC(45,20) as put_price,
        public.fn_fecha_string_to_date(put_date, 'CCYYDDD') as put_date,
        public.fn_convierte_texto_numerico_cobol(second_premium_call_price, 4)::NUMERIC(45,20) as second_premium_call_price,
        public.fn_fecha_string_to_date(second_premium_call_date, 'CCYYDDD') as second_premium_call_date,
        public.fn_fecha_string_to_date(called_date, 'CCYYDDD') as called_date,
        pool_number::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(factor, 8)::NUMERIC(45,20) as factor,
        public.fn_fecha_string_to_date(factor_date, 'CCYYDDD') as factor_date,
        previous_factor::VARCHAR(100),
        public.fn_fecha_string_to_date(previous_factor_date, 'CCYYDDD') as previous_factor_date,
        variable_rate_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(next_last_coupon_date, 'CCYYDDD') as next_last_coupon_date,
        structured_product_ind::VARCHAR(100),
        perpetual_bond_indicator::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_d(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_d(bigint) owner to postgres;

