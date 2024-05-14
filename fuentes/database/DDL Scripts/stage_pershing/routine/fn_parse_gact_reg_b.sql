create or replace function stage_pershing.fn_parse_gact_reg_b(_id_proceso bigint) returns SETOF stage_pershing.stage_gact_reg_b
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        transaction_code::VARCHAR(100),
        record_indicator_value::VARCHAR(100),
        record_id_sequence_number::int,
        account_number::VARCHAR(100),
        security_currency_of_issuance::VARCHAR(100),
        trade_currency_code::VARCHAR(100),
        settlement_currency_code::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_usd_currency_fx_rate, 9)::NUMERIC(45,20) as settlement_usd_currency_fx_rate,
        settlement_usd_multiply_divide_code::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(cross_currency_fx_rate, 9)::NUMERIC(45,20) as cross_currency_fx_rate,
        currency_multiply_divide_code::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(accrued_interest_in_settlement_currency, 2)::NUMERIC(45,20) as accrued_interest_in_settlement_currency,
        accrued_interest_in_settlement_currency_sign::VARCHAR(100),
        market_code::VARCHAR(100),
        internal_reference_for_gloss::VARCHAR(100),
        ibd_version::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(net_amount_in_settlement_currency, 2)::NUMERIC(45,20) as net_amount_in_settlement_currency,
        net_amount_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(principal_amount_in_settlement_currency, 2)::NUMERIC(45,20) as principal_amount_in_settlement_currency,
        principal_amount_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(interest_in_settlement_currency, 2)::NUMERIC(45,20) as interest_in_settlement_currency,
        interest_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(commission_in_settlement_currency, 2)::NUMERIC(45,20) as commission_in_settlement_currency,
        commission_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(tax_in_settlement_currency, 2)::NUMERIC(45,20) as tax_in_settlement_currency,
        tax_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(transaction_fee_in_settlement_currency, 2)::NUMERIC(45,20) as transaction_fee_in_settlement_currency,
        transaction_fee_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(miscellaneous_fee_in_settlement_currency, 2)::NUMERIC(45,20) as miscellaneous_fee_in_settlement_currency,
        miscellaneous_fee_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(other_fee_in_settlement_currency, 2)::NUMERIC(45,20) as other_fee_in_settlement_currency,
        other_fee_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(sales_credit_in_settlement_currency, 2)::NUMERIC(45,20) as sales_credit_in_settlement_currency,
        sales_credit_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_fee_in_settlement_currency, 2)::NUMERIC(45,20) as settlement_fee_in_settlement_currency,
        settlement_fee_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(service_charge_in_settlement_currency, 2)::NUMERIC(45,20) as service_charge_in_settlement_currency,
        service_charge_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(markup_markdown_in_settlement_currency, 2)::NUMERIC(45,20) as markup_markdown_in_settlement_currency,
        markup_markdown_in_settlement_currency_sign::VARCHAR(100),
        global_exchange::VARCHAR(100),
        number_of_description_lines::int,
        last_description_line::int,
        description_line_1::VARCHAR(100),
        description_line_2::VARCHAR(100),
        description_line_3::VARCHAR(100),
        description_line_4::VARCHAR(100),
        description_line_5::VARCHAR(100),
        description_line_6::VARCHAR(100),
        description_line_7::VARCHAR(100),
        description_line_8::VARCHAR(100),
        description_line_9::VARCHAR(100),
        description_line_10::VARCHAR(100),
        description_line_11::VARCHAR(100),
        description_line_12::VARCHAR(100),
        security_currency_indicator::VARCHAR(100),
        market_mnemonic_code::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(ccy_of_issuance_usd_ccy_fx_rate, 9)::NUMERIC(45,20) as ccy_of_issuance_usd_ccy_fx_rate,
        ccy_of_issuance_usd_multiply_divide_code::VARCHAR(100),
        alternate_security_id_type::VARCHAR(100),
        alternate_security_id::VARCHAR(100),
        alternate_security_id_type_2::VARCHAR(100),
        alternate_security_id_2::VARCHAR(100),
        international_non_dollar_symbol::VARCHAR(100),
        confirmation_code_1::VARCHAR(100),
        confirmation_code_2::VARCHAR(100),
        confirmation_code_3::VARCHAR(100),
        confirmation_code_4::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(pmp, 9)::NUMERIC(45,20) as pmp,
        public.fn_convierte_texto_numerico_cobol(total_amount_mark_up_down, 2)::NUMERIC(45,20) as total_amount_mark_up_down,
        total_amount_mark_up_down_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(pmp_percent, 5)::NUMERIC(45,20) as pmp_percent,
        campo_73::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gact_reg_b(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_gact_reg_b(bigint) owner to postgres;

