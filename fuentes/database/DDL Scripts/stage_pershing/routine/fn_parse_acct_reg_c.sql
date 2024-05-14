create or replace function stage_pershing.fn_parse_acct_reg_c(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_c
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        fn_reg.id::BIGINT, fn_reg.id_proceso::BIGINT, fn_reg.process_date::VARCHAR(100),
        fn_reg.transaction_code::VARCHAR(100),
        fn_reg.record_indicator_value::VARCHAR(100),
        fn_reg.record_id_sequence_number::int as record_id_sequence_number,
        fn_reg.account_number::VARCHAR(100),
        fn_reg.ibd_number::VARCHAR(100),
        fn_reg.campo_6::VARCHAR(100),
        fn_reg.ip_number::VARCHAR(100),
        fn_reg.account_short_name::VARCHAR(100),
        fn_reg.campo_9::VARCHAR(100),
        fn_reg.addr_1_trx_code::VARCHAR(100),
        fn_reg.addr_1_special_handling_ind::VARCHAR(100),
        fn_reg.addr_1_delivery_id::VARCHAR(100),
        fn_reg.addr_1_attention_line_prefix::VARCHAR(100),
        fn_reg.addr_1_attention_line_detail::VARCHAR(100),
        fn_reg.addr_1_line_1::VARCHAR(100),
        fn_reg.addr_1_line_2::VARCHAR(100),
        fn_reg.addr_1_line_3::VARCHAR(100),
        fn_reg.addr_1_line_4::VARCHAR(100),
        fn_reg.addr_1_city_state::VARCHAR(100),
        fn_reg.addr_1_country_code::VARCHAR(100),
        fn_reg.campo_21::VARCHAR(100),
        fn_reg.campo_22::VARCHAR(100),
        fn_reg.campo_23::VARCHAR(100),
        fn_reg.campo_24::VARCHAR(100),
        fn_reg.campo_25::VARCHAR(100),
        fn_reg.campo_26::VARCHAR(100),
        fn_reg.campo_27::VARCHAR(100),
        fn_reg.campo_28::VARCHAR(100),
        fn_reg.campo_29::VARCHAR(100),
        fn_reg.campo_30::VARCHAR(100),
        fn_reg.addr_2_trx_code::VARCHAR(100),
        fn_reg.addr_2_special_handling_ind::VARCHAR(100),
        fn_reg.addr_2_delivery_id::VARCHAR(100),
        fn_reg.addr_2_attention_line_prefix::VARCHAR(100),
        fn_reg.addr_2_attention_line_detail::VARCHAR(100),
        fn_reg.addr_2_line_1::VARCHAR(100),
        fn_reg.addr_2_line_2::VARCHAR(100),
        fn_reg.addr_2_line_3::VARCHAR(100),
        fn_reg.addr_2_line_4::VARCHAR(100),
        fn_reg.addr_2_city_state::VARCHAR(100),
        fn_reg.addr_2_country_code::VARCHAR(100),
        fn_reg.account_description::VARCHAR(100),
        fn_reg.set_as_mail_addr_2_ind::VARCHAR(100),
        fn_reg.campo_44::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(fn_reg.principal_billing_allocation_pct, 9)::NUMERIC(45,20) as principal_billing_allocation_pct,
        fn_reg.campo_46::VARCHAR(100),
        fn_reg.seasonal_addr_id_1::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.from_date_1, 'CCYYMMDD')::DATE as from_date_1,
        public.fn_fecha_string_to_date(fn_reg.to_date_1, 'CCYYMMDD')::DATE as to_date_1,
        fn_reg.seasonal_addr_id_2::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.from_date_2, 'CCYYMMDD')::DATE as from_date_2,
        public.fn_fecha_string_to_date(fn_reg.to_date_2, 'CCYYMMDD')::DATE as to_date_2,
        fn_reg.seasonal_addr_id_3::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.from_date_3, 'CCYYMMDD')::DATE as from_date_3,
        public.fn_fecha_string_to_date(fn_reg.to_date_3, 'CCYYMMDD')::DATE as to_date_3,
        fn_reg.cost_basis_acct_system::VARCHAR(100),
        fn_reg.disposition_method_mutual_funds::VARCHAR(100),
        fn_reg.disposition_method_other::VARCHAR(100),
        fn_reg.disposition_method_stocks::VARCHAR(100),
        fn_reg.campo_60::VARCHAR(100),
        fn_reg.amortize_taxable_premium_bonds::VARCHAR(100),
        fn_reg.accrue_market_disc_based_on::VARCHAR(100),
        fn_reg.accrue_market_disc_income::VARCHAR(100),
        fn_reg.campo_64::VARCHAR(100),
        fn_reg.campo_65::VARCHAR(100),
        fn_reg.campo_66::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_c(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_acct_reg_c(bigint) owner to postgres;

