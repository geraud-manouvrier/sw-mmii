create or replace procedure pershing.pa_procesa_gcus(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _process_date VARCHAR(100);
begin

    SELECT tb_proc.process_date INTO _process_date FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso;

    DELETE FROM pershing.sfl_gcus tb_sfl WHERE tb_sfl.process_date= (SELECT tb_proc.process_date FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso);

    INSERT INTO pershing.sfl_gcus (id_proceso, process_date, record_id_sequence_number, account_number, cusip_number, portfolio_currency, underlying_cusip_number, country_code, ip_record_number, ibd_number, currency_security_indicator, issue_currency, datestamp_trade_date, datestamp_settlement_date, trade_date_quantity, settlement_date_quantity, seg_quantity, safekeeping_quantity, transfer_quantity, pending_transfer_quantity, legal_transfer_quantity, tendered_quantity, pending_papers, short_against_the_box_quantity, networked_quantity, pending_split_quantity, quantity_covering_options, trade_date_quantity_bought, trade_date_quantity_sold, fed_rquirement, house_margin_requirement, nyse_requirement, equity_requirment, security_symbol, security_type, security_mod, security_calc, minor_product_code, network_eligibility_indicator, strike_price, expiration_maturity_date, contract_size, conversion_ratio, account_short_name, state_code, country_code_account, number_security_description_lines, security_description_line_1, security_description_line_2, security_description_line_3, security_description_line_4, security_description_line_5, security_description_line_6, dividend_option, long_term_capital_gains_option, short_term_capital_gains_option, firm_trading_indicator, position_currency_security, trade_date_liquidating_value, pool_factor, exchange_rate, settlement_date_liquidating_value, alternate_security_id_type, alternate_security_id, position_currency, fully_paid_lending_quantity, fully_paid_lending_quantity_collateral_amount, option_root_id, expiration_date, call_put_indicator, trade_date_repo_quantity, settlement_date_repo_quantity, trade_date_reverse_repo_quantity, settlement_date_reverse_repo_quantity, collateral_pledge_quantity, corporate_exec_serv_collateral_pledge_quantity, trade_date_repo_liquidating_value, settlement_date_repo_liquidating_value, trade_date_reverse_repo_liquidating_value, settlement_date_reverse_repo_liquidating_value, collateral_pledge_liquidating_value, corporate_exec_serv_collateral_pledge_liquidating_value, trade_date_repo_loan_amount, settlement_date_repo_loan_amount, trade_date_reverse_repo_loan_amount, settlement_date_reverse_repo_loan_amount, accrued_interes_value, dividend_or_coupon_rate, pending_split_quantity_liquidating_value, internal_non_dollar_symbol, pledged_quantity)
    SELECT
        reg_header.id_proceso, reg_header.process_date, reg_a.record_id_sequence_number, reg_a.account_number, reg_a.cusip_number, portfolio_currency, reg_a.underlying_cusip_number, reg_a.country_code, reg_a.ip_record_number, reg_a.ibd_number, currency_security_indicator, issue_currency, datestamp_trade_date, datestamp_settlement_date,
        trade_date_quantity*public.fn_convierte_signo_factor(trade_date_quantity_sign) as trade_date_quantity,
        settlement_date_quantity*public.fn_convierte_signo_factor(settlement_date_quantity_sign) as settlement_date_quantity,
        seg_quantity*public.fn_convierte_signo_factor(seg_quantity_sign) as seg_quantity,
        safekeeping_quantity*public.fn_convierte_signo_factor(safekeeping_sign) as safekeeping_quantity,
        transfer_quantity*public.fn_convierte_signo_factor(transfer_quantity_sign) as transfer_quantity,
        pending_transfer_quantity*public.fn_convierte_signo_factor(pending_transfer_quantity_sign) as pending_transfer_quantity,
        legal_transfer_quantity*public.fn_convierte_signo_factor(legal_transfer_quantity_sign) as legal_transfer_quantity,
        tendered_quantity*public.fn_convierte_signo_factor(tendered_quantity_sign) as tendered_quantity,
        pending_papers*public.fn_convierte_signo_factor(pending_papers_sign) as pending_papers,
        short_against_the_box_quantity*public.fn_convierte_signo_factor(short_against_the_box_quantity_sign) as short_against_the_box_quantity,
        networked_quantity*public.fn_convierte_signo_factor(networked_quantity_sign) as networked_quantity,
        pending_split_quantity*public.fn_convierte_signo_factor(pending_split_quantity_sign) as pending_split_quantity,
        quantity_covering_options*public.fn_convierte_signo_factor(quantity_covering_options_sign) as quantity_covering_options,
        trade_date_quantity_bought*public.fn_convierte_signo_factor(trade_date_quantity_bought_sign) as trade_date_quantity_bought,
        trade_date_quantity_sold*public.fn_convierte_signo_factor(trade_date_quantity_sold_sign) as trade_date_quantity_sold,
        fed_rquirement*public.fn_convierte_signo_factor(fed_rquirement_sign) as fed_rquirement,
        house_margin_requirement*public.fn_convierte_signo_factor(house_margin_requirement_sign) as house_margin_requirement,
        nyse_requirement*public.fn_convierte_signo_factor(nyse_requirement_sign) as nyse_requirement,
        equity_requirment*public.fn_convierte_signo_factor(equity_requirment_sign) as equity_requirment, security_symbol, security_type, security_mod, security_calc, minor_product_code, network_eligibility_indicator,
        reg_a.strike_price*public.fn_convierte_signo_factor(reg_a.strike_price_sign) as strike_price, expiration_maturity_date, contract_size, conversion_ratio, account_short_name, state_code, country_code_account, number_security_description_lines, security_description_line_1, security_description_line_2, security_description_line_3, security_description_line_4, security_description_line_5, security_description_line_6, dividend_option, long_term_capital_gains_option, short_term_capital_gains_option, firm_trading_indicator, position_currency_security,
        trade_date_liquidating_value*public.fn_convierte_signo_factor(trade_date_liquidating_value_sign) as trade_date_liquidating_value,
        pool_factor*public.fn_convierte_signo_factor(pool_factor_sign) as pool_factor,
        exchange_rate*public.fn_convierte_signo_factor(exchange_rate_sign) as exchange_rate,
        settlement_date_liquidating_value*public.fn_convierte_signo_factor(settlement_date_liquidating_value_sign) as settlement_date_liquidating_value, alternate_security_id_type, alternate_security_id, position_currency,
        fully_paid_lending_quantity*public.fn_convierte_signo_factor(fully_paid_lending_quantity_sign) as fully_paid_lending_quantity,
        fully_paid_lending_quantity_collateral_amount*public.fn_convierte_signo_factor(fully_paid_lending_quantity_collateral_amount_sign) as fully_paid_lending_quantity_collateral_amount, option_root_id, expiration_date, call_put_indicator,
        trade_date_repo_quantity*public.fn_convierte_signo_factor(trade_date_repo_quantity_sign) as trade_date_repo_quantity,
        settlement_date_repo_quantity*public.fn_convierte_signo_factor(settlement_date_repo_quantity_sign) as settlement_date_repo_quantity,
        trade_date_reverse_repo_quantity*public.fn_convierte_signo_factor(trade_date_reverse_repo_quantity_sign) as trade_date_reverse_repo_quantity,
        settlement_date_reverse_repo_quantity*public.fn_convierte_signo_factor(settlement_date_reverse_repo_quantity_sign) as settlement_date_reverse_repo_quantity,
        collateral_pledge_quantity*public.fn_convierte_signo_factor(collateral_pledge_quantity_sign) as collateral_pledge_quantity,
        corporate_exec_serv_collateral_pledge_quantity*public.fn_convierte_signo_factor(corporate_exec_serv_collateral_pledge_quantity_sign) as corporate_exec_serv_collateral_pledge_quantity,
        trade_date_repo_liquidating_value*public.fn_convierte_signo_factor(trade_date_repo_liquidating_value_sign) as trade_date_repo_liquidating_value,
        settlement_date_repo_liquidating_value*public.fn_convierte_signo_factor(settlement_date_repo_liquidating_value_sign) as settlement_date_repo_liquidating_value,
        trade_date_reverse_repo_liquidating_value*public.fn_convierte_signo_factor(trade_date_reverse_repo_liquidating_value_sign) as trade_date_reverse_repo_liquidating_value,
        settlement_date_reverse_repo_liquidating_value*public.fn_convierte_signo_factor(settlement_date_reverse_repo_liquidating_value_sign) as settlement_date_reverse_repo_liquidating_value,
        collateral_pledge_liquidating_value*public.fn_convierte_signo_factor(collateral_pledge_liquidating_value_sign) as collateral_pledge_liquidating_value,
        corporate_exec_serv_collateral_pledge_liquidating_value*public.fn_convierte_signo_factor(corporate_exec_serv_collateral_pledge_liquidating_value_sign) as corporate_exec_serv_collateral_pledge_liquidating_value,
        trade_date_repo_loan_amount*public.fn_convierte_signo_factor(trade_date_repo_loan_amount_sign) as trade_date_repo_loan_amount,
        settlement_date_repo_loan_amount*public.fn_convierte_signo_factor(settlement_date_repo_loan_amount_sign) as settlement_date_repo_loan_amount,
        trade_date_reverse_repo_loan_amount*public.fn_convierte_signo_factor(trade_date_reverse_repo_loan_amount_sign) as trade_date_reverse_repo_loan_amount,
        settlement_date_reverse_repo_loan_amount*public.fn_convierte_signo_factor(settlement_date_reverse_repo_loan_amount_sign) as settlement_date_reverse_repo_loan_amount,
        accrued_interes_value*public.fn_convierte_signo_factor(accrued_interes_value_sign) as accrued_interes_value, dividend_or_coupon_rate,
        pending_split_quantity_liquidating_value*public.fn_convierte_signo_factor(pending_split_quantity_liquidating_value_sign) as pending_split_quantity_liquidating_value, internal_non_dollar_symbol,
        pledged_quantity*public.fn_convierte_signo_factor(pledged_quantity_sign) as pledged_quantity
    FROM stage_pershing.stage_gcus_reg_header reg_header
    INNER JOIN stage_pershing.stage_gcus_reg_trailer reg_trailer
    ON reg_header.id_proceso=reg_trailer.id_proceso
    INNER JOIN stage_pershing.stage_gcus_reg_a reg_a
    ON reg_header.id_proceso=reg_a.id_proceso
    LEFT JOIN stage_pershing.stage_gcus_reg_b reg_b
    ON reg_header.id_proceso=reg_b.id_proceso AND reg_a.account_number=reg_b.account_number AND reg_a.cusip_number=reg_b.cusip_number AND reg_a.record_id_sequence_number=reg_b.recor_id_sequence_number
    WHERE reg_header.id_proceso=_id_proceso
    AND NOT pershing.fn_excluye_cuenta('CARGA_SFL', reg_a.account_number)
    ;

    CALL pershing.pa_gcus_calcula_custodia(_process_date);
end;
$$;

alter procedure pershing.pa_procesa_gcus(bigint) owner to postgres;

