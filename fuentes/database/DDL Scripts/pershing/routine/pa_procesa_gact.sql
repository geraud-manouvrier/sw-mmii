create or replace procedure pershing.pa_procesa_gact(IN _id_proceso bigint)
    language plpgsql
as
$$
begin

    DELETE FROM pershing.sfl_gact tb_sfl WHERE tb_sfl.process_date= (SELECT tb_proc.process_date FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso);

    INSERT INTO pershing.sfl_gact (id_proceso, process_date, record_id_sequence_number, account_number, cusip_number, underlying_cusip, security_symbol, investment_professional_of_record, executing_investment_professional, transaction_type, buy_sell_code, open_close_indicator, par_key_code, source_code, maxx_key_code, process_date_sfl, trade_date, settlement_entry_date, source_of_input, reference_number, batch_code, same_day_settlement, contra_account, market_code, blotter_code, cancel_code, correction_code, merket_limit_indicator, legend_code_1, legend_code_2, quantity, price_in_trade_currency, currency_indicator_for_price, net_amount_in_usd, principal_in_usd, interest_in_usd, commision_in_usd, tax_in_usd, transaction_fee_in_usd, misc_fee_in_usd, other_fee_in_usd, tefra_wh_amount_in_usd, pershing_charge_in_usd, brokerage_charge_in_usd, sales_credit_in_usd, settlement_fee_in_usd, service_charge_in_usd, markup_markdown_amount_in_usd, dividend_payable_date, dividend_record_date, dividend_type, shares_of_record_quantity_for_dividends, order_size_quantity, pool_factor, parsed_customer_account_number, ibd_number, security_type_code, security_modifier_code, security_calculation_code, minor_product_code, foreign_product_indicator, with_due_bill_indicator, taxable_municipal_bond_indicator, omnibus_indicator, external_order_id, market_value_of_transaction, ip_number_parsed, reported_price, previous_day_market_value_of_transaction, price_in_usd, option_root_id, expiration_date, put_call_code, strike_price, repo_identifier, taxable, qualified, expanded_ip_number, expanded_exec_ip_number, expanded_legacy_ip_number, security_currency_of_issuance, trade_currency_code, settlement_currency_code, settlement_usd_currency_fx_rate, settlement_usd_multiply_divide_code, cross_currency_fx_rate, currency_multiply_divide_code, accrued_interest_in_settlement_currency, internal_reference_for_gloss, ibd_version, net_amount_in_settlement_currency, principal_amount_in_settlement_currency, interest_in_settlement_currency, commission_in_settlement_currency, tax_in_settlement_currency, transaction_fee_in_settlement_currency, miscellaneous_fee_in_settlement_currency, other_fee_in_settlement_currency, sales_credit_in_settlement_currency, settlement_fee_in_settlement_currency, service_charge_in_settlement_currency, markup_markdown_in_settlement_currency, global_exchange, number_of_description_lines, last_description_line, description_line_1, description_line_2, description_line_3, description_line_4, description_line_5, description_line_6, description_line_7, description_line_8, description_line_9, description_line_10, description_line_11, description_line_12, security_currency_indicator, market_mnemonic_code, ccy_of_issuance_usd_ccy_fx_rate, ccy_of_issuance_usd_multiply_divide_code, alternate_security_id_type, alternate_security_id, alternate_security_id_type_2, alternate_security_id_2, international_non_dollar_symbol, confirmation_code_1, confirmation_code_2, confirmation_code_3, confirmation_code_4, pmp, total_amount_mark_up_down, pmp_percent)
    SELECT
        reg_header.id_proceso, reg_header.process_date, reg_a.record_id_sequence_number, reg_a.account_number, reg_a.cusip_number, underlying_cusip, security_symbol, investment_professional_of_record, executing_investment_professional, transaction_type, buy_sell_code, open_close_indicator, par_key_code, source_code, maxx_key_code, process_date_sfl, trade_date, settlement_entry_date, source_of_input, reference_number, batch_code, same_day_settlement, contra_account, reg_a.market_code, blotter_code, cancel_code, correction_code, merket_limit_indicator, legend_code_1, legend_code_2,
        quantity*public.fn_convierte_signo_factor(quantity_sign) as quantity,
        price_in_trade_currency*public.fn_convierte_signo_factor(price_in_trade_currency_sign) as price_in_trade_currency, currency_indicator_for_price,
        net_amount_in_usd*public.fn_convierte_signo_factor(net_amount_in_usd_sign) as net_amount_in_usd,
        principal_in_usd*public.fn_convierte_signo_factor(principal_in_usd_sign) as principal_in_usd,
        interest_in_usd*public.fn_convierte_signo_factor(interest_in_usd_sign) as interest_in_usd,
        commision_in_usd*public.fn_convierte_signo_factor(commision_in_usd_sign) as commision_in_usd,
        tax_in_usd*public.fn_convierte_signo_factor(tax_in_usd_sign) as tax_in_usd,
        transaction_fee_in_usd*public.fn_convierte_signo_factor(transaction_fee_in_usd_sign) as transaction_fee_in_usd,
        misc_fee_in_usd*public.fn_convierte_signo_factor(misc_fee_in_usd_sign) as misc_fee_in_usd,
        other_fee_in_usd*public.fn_convierte_signo_factor(other_fee_in_usd_sign) as other_fee_in_usd,
        tefra_wh_amount_in_usd*public.fn_convierte_signo_factor(tefra_wh_amount_in_usd_sign) as tefra_wh_amount_in_usd,
        pershing_charge_in_usd*public.fn_convierte_signo_factor(pershing_charge_in_usd_sign) as pershing_charge_in_usd,
        brokerage_charge_in_usd*public.fn_convierte_signo_factor(brokerage_charge_in_usd_sign) as brokerage_charge_in_usd,
        sales_credit_in_usd*public.fn_convierte_signo_factor(sales_credit_in_usd_sign) as sales_credit_in_usd,
        settlement_fee_in_usd*public.fn_convierte_signo_factor(settlement_fee_in_usd_sign) as settlement_fee_in_usd,
        service_charge_in_usd*public.fn_convierte_signo_factor(service_charge_in_usd_sign) as service_charge_in_usd,
        markup_markdown_amount_in_usd*public.fn_convierte_signo_factor(markup_markdown_amount_in_usd_sign) as markup_markdown_amount_in_usd, dividend_payable_date, dividend_record_date, dividend_type, shares_of_record_quantity_for_dividends, order_size_quantity, pool_factor, parsed_customer_account_number, ibd_number, security_type_code, security_modifier_code, security_calculation_code, minor_product_code, foreign_product_indicator, with_due_bill_indicator, taxable_municipal_bond_indicator, omnibus_indicator, external_order_id, market_value_of_transaction, ip_number_parsed,
        reported_price*public.fn_convierte_signo_factor(reported_price_sign) as reported_price, previous_day_market_value_of_transaction, price_in_usd, option_root_id, expiration_date, put_call_code, strike_price, repo_identifier, taxable, qualified, expanded_ip_number, expanded_exec_ip_number, expanded_legacy_ip_number, security_currency_of_issuance, trade_currency_code, settlement_currency_code, settlement_usd_currency_fx_rate, settlement_usd_multiply_divide_code, cross_currency_fx_rate, currency_multiply_divide_code,
        accrued_interest_in_settlement_currency*public.fn_convierte_signo_factor(accrued_interest_in_settlement_currency_sign) as accrued_interest_in_settlement_currency, internal_reference_for_gloss, ibd_version,
        net_amount_in_settlement_currency*public.fn_convierte_signo_factor(net_amount_in_settlement_currency_sign) as net_amount_in_settlement_currency,
        principal_amount_in_settlement_currency*public.fn_convierte_signo_factor(principal_amount_in_settlement_currency_sign) as principal_amount_in_settlement_currency,
        interest_in_settlement_currency*public.fn_convierte_signo_factor(interest_in_settlement_currency_sign) as interest_in_settlement_currency,
        commission_in_settlement_currency*public.fn_convierte_signo_factor(commission_in_settlement_currency_sign) as commission_in_settlement_currency,
        tax_in_settlement_currency*public.fn_convierte_signo_factor(tax_in_settlement_currency_sign) as tax_in_settlement_currency,
        transaction_fee_in_settlement_currency*public.fn_convierte_signo_factor(transaction_fee_in_settlement_currency_sign) as transaction_fee_in_settlement_currency,
        miscellaneous_fee_in_settlement_currency*public.fn_convierte_signo_factor(miscellaneous_fee_in_settlement_currency_sign) as miscellaneous_fee_in_settlement_currency,
        other_fee_in_settlement_currency*public.fn_convierte_signo_factor(other_fee_in_settlement_currency_sign) as other_fee_in_settlement_currency,
        sales_credit_in_settlement_currency*public.fn_convierte_signo_factor(sales_credit_in_settlement_currency_sign) as sales_credit_in_settlement_currency,
        settlement_fee_in_settlement_currency*public.fn_convierte_signo_factor(settlement_fee_in_settlement_currency_sign) as settlement_fee_in_settlement_currency,
        service_charge_in_settlement_currency*public.fn_convierte_signo_factor(service_charge_in_settlement_currency_sign) as service_charge_in_settlement_currency,
        markup_markdown_in_settlement_currency*public.fn_convierte_signo_factor(markup_markdown_in_settlement_currency_sign) as markup_markdown_in_settlement_currency, global_exchange, number_of_description_lines, last_description_line, description_line_1, description_line_2, description_line_3, description_line_4, description_line_5, description_line_6, description_line_7, description_line_8, description_line_9, description_line_10, description_line_11, description_line_12, security_currency_indicator, market_mnemonic_code, ccy_of_issuance_usd_ccy_fx_rate, ccy_of_issuance_usd_multiply_divide_code, alternate_security_id_type, alternate_security_id, alternate_security_id_type_2, alternate_security_id_2, international_non_dollar_symbol, confirmation_code_1, confirmation_code_2, confirmation_code_3, confirmation_code_4, pmp,
        total_amount_mark_up_down*public.fn_convierte_signo_factor(total_amount_mark_up_down_sign) as total_amount_mark_up_down, pmp_percent
    FROM stage_pershing.stage_gact_reg_header reg_header
    INNER JOIN stage_pershing.stage_gact_reg_trailer reg_trailer
    ON reg_header.id_proceso=reg_trailer.id_proceso
    INNER JOIN stage_pershing.stage_gact_reg_a reg_a
    ON reg_header.id_proceso=reg_a.id_proceso
    LEFT JOIN stage_pershing.stage_gact_reg_b reg_b
    ON reg_header.id_proceso=reg_b.id_proceso AND reg_a.record_id_sequence_number=reg_b.record_id_sequence_number
    WHERE reg_header.id_proceso=_id_proceso
    AND NOT pershing.fn_excluye_cuenta('CARGA_SFL', reg_a.account_number)
    ;
end;
$$;

alter procedure pershing.pa_procesa_gact(bigint) owner to postgres;

