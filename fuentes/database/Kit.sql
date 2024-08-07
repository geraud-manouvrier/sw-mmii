/*
2024-08-07
Actual: 8.1.1-COL
Last:   8.1.0-COL
*/

--========================================================================
--========================================================================
--========================================================================
--Creción de usuarios admin y app
/*
CREATE USER mmii_admindb CREATEDB CREATEROLE PASSWORD 'b55tO<RB4aza';
GRANT azure_pg_admin TO mmii_admindb;
--create database qande_mmii with owner mmii_admindb;
create database qande_mmii;
CREATE USER mmii_appuserdb PASSWORD 'H;859md+5GAf';
GRANT CONNECT ON DATABASE qande_mmii TO mmii_appuserdb;
--ALTER DEFAULT PRIVILEGES FOR ROLE mmii_appuserdb GRANT SELECT, INSERT, DELETE ON TABLES TO mmii_appuserdb;
--ALTER DEFAULT PRIVILEGES FOR ROLE mmii_appuserdb GRANT EXECUTE ON FUNCTIONS TO mmii_appuserdb;
*/

--========================================================================
--========================================================================
--========================================================================
-- Rutina para excluir cuentas SURA
create or replace function pershing.fn_excluye_cuenta(_proceso VARCHAR(100), _account_number VARCHAR(100)) returns bool
    language plpgsql
as
$$
DECLARE _valor_parametro_out bool;
    BEGIN
        _valor_parametro_out    := false;
        IF (_proceso='CARGA_SFL') THEN
            --Patrón de cuentas SURA RIA (internas)
            IF ( _account_number like '%T9N8%' or _account_number like '%T9N9%' or _account_number like '%T9O8%' or _account_number like '%T9O9%' ) THEN
                _valor_parametro_out    := true;
            END IF;
        END IF;

    RETURN _valor_parametro_out;
    END;
$$;


--========================================================================
--========================================================================
--========================================================================
--ACCT

create or replace procedure pershing.pa_procesa_acct(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _process_date VARCHAR(100);
begin

    SELECT tb_proc.process_date INTO _process_date
    FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso;

    DELETE FROM pershing.sfl_acct tb_sfl WHERE tb_sfl.process_date= _process_date;

    INSERT INTO pershing.sfl_acct (id_proceso, process_date, record_id_sequence_number, account_number, ibd_number, ip_number, account_short_name, transaction_type, autotitled_usertitled_account, account_type_code, registration_type, number_of_account_title_lines, account_registration_line_1, account_registration_line_2, account_registration_line_3, account_registration_line_4, account_registration_line_5, account_registration_line_6, registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions, income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked, statement_review_date, margin_papers_on_file, option_papers_on_file, good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted, third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits, option_total_limits_of_puts_and_calls, non_us_dollar_trading, non_customer_indicator, third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule, group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic, employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date, plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative, commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form, date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form, date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account, foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, primary_country_of_citizenship, country_of_residence, birth_date, age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status, regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, customer_type, fulfillment_method, credit_interest_indicator, ama_indicator, tax_id_type, tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced, date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced, date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced, date_c_notice_status_satisfied, old_account_number, original_account_open_date, unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date, initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code, future_statement_currency_code, future_statement_currency_code_effective_date, account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3, account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip, third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym, alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator, source_of_asset_at_acct_opening, commission_doscount_code, external_account_number, confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside, fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type, mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated, date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id, firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id, second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account, banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code, combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code, proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code, dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona, client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code, addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix, addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4, addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id, addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3, addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind, principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2, from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system, disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks, amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code, addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix, addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4, addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code, addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix, addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4, addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code, addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix, addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4, addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code, addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix, addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4, addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code, addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix, addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4, addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency, income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep, last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind, foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst, foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own, proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension, tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code, tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind, tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id, tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number, tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension, tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address, external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code, cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency)
    SELECT
        reg_a.id_proceso, reg_a.process_date, reg_a.record_id_sequence_number, reg_a.account_number, reg_a.ibd_number, reg_a.ip_number,
        reg_a.account_short_name, transaction_type, autotitled_usertitled_account, account_type_code, registration_type, number_of_account_title_lines, account_registration_line_1, account_registration_line_2, account_registration_line_3, account_registration_line_4, account_registration_line_5, account_registration_line_6, registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions, income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked, statement_review_date, margin_papers_on_file, option_papers_on_file, good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted, third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits, option_total_limits_of_puts_and_calls, reg_a.non_us_dollar_trading, non_customer_indicator, third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule, group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic, employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date, plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative, commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form, date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form, date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account, foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, primary_country_of_citizenship, country_of_residence, birth_date, age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status, regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, customer_type, fulfillment_method, credit_interest_indicator, ama_indicator, tax_id_type, tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced, date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced, date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced, date_c_notice_status_satisfied, old_account_number, original_account_open_date, unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date, initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code, future_statement_currency_code, future_statement_currency_code_effective_date, account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3, account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip, third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym, alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator, source_of_asset_at_acct_opening, commission_doscount_code, external_account_number, confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside, fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type, mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated, date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id, firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id, second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account, banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code, combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code, proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code, dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona, client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code, addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix, addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4, addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id, addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3, addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind, principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2, from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system, disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks, amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code, addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix, addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4, addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code, addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix, addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4, addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code, addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix, addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4, addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code, addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix, addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4, addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code, addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix, addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4, addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency, income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep, last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind, foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst, foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own, proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension, tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code, tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind, tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id, tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number, tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension, tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address, external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code, cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency
    FROM stage_pershing.stage_acct_reg_header reg_header
    INNER JOIN stage_pershing.stage_acct_reg_trailer reg_trailer
    ON reg_header.id_proceso=reg_trailer.id_proceso
    INNER JOIN stage_pershing.stage_acct_reg_a reg_a
    ON reg_header.id_proceso=reg_a.id_proceso
    LEFT JOIN stage_pershing.stage_acct_reg_b reg_b
    ON reg_header.id_proceso=reg_b.id_proceso AND reg_a.account_number=reg_b.account_number
    LEFT JOIN stage_pershing.stage_acct_reg_c reg_c
    ON reg_header.id_proceso=reg_c.id_proceso AND reg_a.account_number=reg_c.account_number
    LEFT JOIN stage_pershing.stage_acct_reg_d reg_d
    ON reg_header.id_proceso=reg_d.id_proceso AND reg_a.account_number=reg_d.account_number
    LEFT JOIN stage_pershing.stage_acct_reg_e reg_e
    ON reg_header.id_proceso=reg_e.id_proceso AND reg_a.account_number=reg_e.account_number
    LEFT JOIN stage_pershing.stage_acct_reg_f reg_f
    ON reg_header.id_proceso=reg_f.id_proceso AND reg_a.account_number=reg_f.account_number
    LEFT JOIN stage_pershing.stage_acct_reg_w reg_w
    ON reg_header.id_proceso=reg_w.id_proceso AND reg_a.account_number=reg_w.account_number
    WHERE reg_header.id_proceso=_id_proceso
    AND NOT pershing.fn_excluye_cuenta('CARGA_SFL', reg_a.account_number)
    ;

    DELETE FROM pershing.sfl_acct_historica WHERE process_date=_process_date;

    INSERT INTO pershing.sfl_acct_historica (id_proceso, process_date, record_id_sequence_number, account_number, ibd_number, ip_number, account_short_name, transaction_type, autotitled_usertitled_account, account_type_code, registration_type, number_of_account_title_lines, account_registration_line_1, account_registration_line_2, account_registration_line_3, account_registration_line_4, account_registration_line_5, account_registration_line_6, registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions, income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked, statement_review_date, margin_papers_on_file, option_papers_on_file, good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted, third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits, option_total_limits_of_puts_and_calls, non_us_dollar_trading, non_customer_indicator, third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule, group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic, employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date, plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative, commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form, date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form, date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account, foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, primary_country_of_citizenship, country_of_residence, birth_date, age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status, regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, customer_type, fulfillment_method, credit_interest_indicator, ama_indicator, tax_id_type, tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced, date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced, date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced, date_c_notice_status_satisfied, old_account_number, original_account_open_date, unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date, initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code, future_statement_currency_code, future_statement_currency_code_effective_date, account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3, account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip, third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym, alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator, source_of_asset_at_acct_opening, commission_doscount_code, external_account_number, confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside, fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type, mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated, date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id, firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id, second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account, banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code, combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code, proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code, dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona, client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code, addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix, addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4, addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id, addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3, addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind, principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2, from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system, disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks, amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code, addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix, addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4, addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code, addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix, addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4, addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code, addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix, addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4, addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code, addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix, addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4, addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code, addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix, addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4, addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency, income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep, last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind, foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst, foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own, proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension, tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code, tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind, tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id, tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number, tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension, tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address, external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code, cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency)
    SELECT
        acct_his.id_proceso, _process_date as process_date, acct_his.record_id_sequence_number, acct_his.account_number, acct_his.ibd_number, acct_his.ip_number, acct_his.account_short_name, acct_his.transaction_type, acct_his.autotitled_usertitled_account, acct_his.account_type_code, acct_his.registration_type, acct_his.number_of_account_title_lines, acct_his.account_registration_line_1, acct_his.account_registration_line_2, acct_his.account_registration_line_3, acct_his.account_registration_line_4, acct_his.account_registration_line_5, acct_his.account_registration_line_6, acct_his.registration_type_detail, acct_his.date_account_opened, acct_his.date_account_information_updated, acct_his.account_status_indicator, acct_his.pending_closed_date, acct_his.date_account_closed, acct_his.closing_notice_date, acct_his.account_reactivated_date, acct_his.date_account_reopened, acct_his.proceeds, acct_his.transfer_instructions, acct_his.income_isntructions, acct_his.number_of_confirms_for_thi_account, acct_his.number_of_statements_for_this_account, acct_his.investment_objetive_trans_code, acct_his.comments_act, acct_his.employer_shotname, acct_his.employers_cusip, acct_his.employers_symbol, acct_his.margin_privileges_revoked, acct_his.statement_review_date, acct_his.margin_papers_on_file, acct_his.option_papers_on_file, acct_his.good_faith_margin, acct_his.ip_discretion_granted, acct_his.invest_advisor_discretion_granted, acct_his.third_party_discretion_granted, acct_his.third_party_name, acct_his.risk_factor_code, acct_his.investment_objetive_code, acct_his.option_equities, acct_his.option_index, acct_his.option_debt, acct_his.option_currency, acct_his.option_level_1, acct_his.option_level_2, acct_his.option_level_3, acct_his.option_level_4, acct_his.option_call_limits, acct_his.option_put_limits, acct_his.option_total_limits_of_puts_and_calls, acct_his.non_us_dollar_trading, acct_his.non_customer_indicator, acct_his.third_party_fee_indicator, acct_his.third_party_fee_approval_date, acct_his.intermediary_account_ind, acct_his.commission_schedule, acct_his.group_index, acct_his.money_manager_id, acct_his.money_manager_objective_id, acct_his.dtc_id_confirm_number, acct_his.caps_master_mnemonic, acct_his.employee_id, acct_his.prime_broker_free_fund_indicator, acct_his.fee_based_account_indicator, acct_his.fee_based_termination_date, acct_his.plan_name, acct_his.self_directed_401_k_account_type, acct_his.plan_type, acct_his.plan_number, acct_his.employee_or_employee_relative, acct_his.commission_percent_discount, acct_his.ind_12_b_1_fee_blocking, acct_his.name_of_ip_signed_new_account_form, acct_his.date_of_ip_signed_new_account_form, acct_his.name_of_principal_signed_new_account_form, acct_his.date_of_principal_signed_new_account_form, acct_his.politically_exposed_person, acct_his.private_banking_account, acct_his.foreign_bank_account, acct_his.initial_source_of_funds, acct_his.usa_patriot_act_exempt_reason, acct_his.primary_country_of_citizenship, acct_his.country_of_residence, acct_his.birth_date, acct_his.age_based_fund_roll_exempt, acct_his.money_fundreform_retail, acct_his.trusted_contact_status, acct_his.regulatory_account_type_category, acct_his.account_managed_by_trust_comp_id, acct_his.voting_auth, acct_his.customer_type, acct_his.fulfillment_method, acct_his.credit_interest_indicator, acct_his.ama_indicator, acct_his.tax_id_type, acct_his.tax_id_number, acct_his.date_tax_id_applied_for, acct_his.w_8_w_9_indicator, acct_his.w_8_w_9_date_signed, acct_his.w_8_w_9_effective_date, acct_his.w_8_w_9_document_type, acct_his.tax_status, acct_his.b_notice_reason_code, acct_his.first_b_notice_status, acct_his.date_first_b_notice_status_issued_enforced, acct_his.date_first_notice_status_satisfied, acct_his.second_b_notice_status, acct_his.date_second_b_notice_status_issued_enforced, acct_his.date_second_b_notice_status_satisfied, acct_his.c_notice_status, acct_his.date_c_notice_status_issued_enforced, acct_his.date_c_notice_status_satisfied, acct_his.old_account_number, acct_his.original_account_open_date, acct_his.unidentified_large_trader_id, acct_his.large_trader_type_code, acct_his.large_trader_type_last_change_date, acct_his.initial_source_of_funds_other, acct_his.finance_away, acct_his.account_funding_date, acct_his.statement_currency_code, acct_his.future_statement_currency_code, acct_his.future_statement_currency_code_effective_date, acct_his.account_level_routing_code_1, acct_his.account_level_routing_code_2, acct_his.account_level_routing_code_3, acct_his.account_level_routing_code_4, acct_his.self_directed_ind, acct_his.digital_advice_ind, acct_his.pte_account_ind, acct_his.first_ip, acct_his.second_ip, acct_his.third_ip, acct_his.fourth_ip, acct_his.fifth_ip, acct_his.sixth_ip, acct_his.seventh_ip, acct_his.eighth_ip, acct_his.ninth_ip, acct_his.tenth_ip, acct_his.alert_im_acornym, acct_his.alert_im_access_code, acct_his.broker_acronym, acct_his.cross_reference_indicator, acct_his.bny_trust_indicator, acct_his.source_of_asset_at_acct_opening, acct_his.commission_doscount_code, acct_his.external_account_number, acct_his.confirmation_suppression_indicator, acct_his.date_last_mail_sent, acct_his.date_last_mail_sent_outside, acct_his.fully_paid_lending_agreement_indicator, acct_his.fully_paid_lending_agreement_date, acct_his.custodian_account_type, acct_his.mifid_customer_categorization, acct_his.cash_management_tran_code, acct_his.sweep_status_indicator, acct_his.date_sweep_activated, acct_his.date_sweep_details_changed, acct_his.cober_margin_debit_indicator, acct_his.first_fund_sweep_account_id, acct_his.firstfund_sweep_account_percent, acct_his.first_fundsweep_account_redemption_priority, acct_his.second_fund_sweep_account_id, acct_his.second_fund_sweep_account_percent, acct_his.second_fundsweep_account_redemption_priority, acct_his.type_of_bank_account, acct_his.banklink_aba_number, acct_his.banklink_dda_number, acct_his.fund_bank_indicator, acct_his.w_9_corp_tax_classification_code, acct_his.combined_margin_acct_indicator, acct_his.pledge_collateral_account_indicator, acct_his.finra_institutional_account_code, acct_his.proposed_account_reference_id, acct_his.advisor_model_id, acct_his.firm_model_style_id, acct_his.dvp_restriction_code, acct_his.dvp_restriction_exp_date, acct_his.escheatment_withholding_ind, acct_his.source_of_origination, acct_his.source_of_persona, acct_his.client_onboarding_method, acct_his.tax_filing_code, acct_his.nor_purpose_collateral_acct_ind, acct_his.addr_1_trx_code, acct_his.addr_1_special_handling_ind, acct_his.addr_1_delivery_id, acct_his.addr_1_attention_line_prefix, acct_his.addr_1_attention_line_detail, acct_his.addr_1_line_1, acct_his.addr_1_line_2, acct_his.addr_1_line_3, acct_his.addr_1_line_4, acct_his.addr_1_city_state, acct_his.addr_1_country_code, acct_his.addr_2_trx_code, acct_his.addr_2_special_handling_ind, acct_his.addr_2_delivery_id, acct_his.addr_2_attention_line_prefix, acct_his.addr_2_attention_line_detail, acct_his.addr_2_line_1, acct_his.addr_2_line_2, acct_his.addr_2_line_3, acct_his.addr_2_line_4, acct_his.addr_2_city_state, acct_his.addr_2_country_code, acct_his.account_description, acct_his.set_as_mail_addr_2_ind, acct_his.principal_billing_allocation_pct, acct_his.seasonal_addr_id_1, acct_his.from_date_1, acct_his.to_date_1, acct_his.seasonal_addr_id_2, acct_his.from_date_2, acct_his.to_date_2, acct_his.seasonal_addr_id_3, acct_his.from_date_3, acct_his.to_date_3, acct_his.cost_basis_acct_system, acct_his.disposition_method_mutual_funds, acct_his.disposition_method_other, acct_his.disposition_method_stocks, acct_his.amortize_taxable_premium_bonds, acct_his.accrue_market_disc_based_on, acct_his.accrue_market_disc_income, acct_his.addr_3_trx_code, acct_his.addr_3_special_handling_ind, acct_his.addr_3_delivery_id, acct_his.addr_3_attention_line_prefix, acct_his.addr_3_attention_line_detail, acct_his.addr_3_line_1, acct_his.addr_3_line_2, acct_his.addr_3_line_3, acct_his.addr_3_line_4, acct_his.addr_3_city_state, acct_his.addr_3_country_code, acct_his.set_as_mail_addr_3_ind, acct_his.addr_4_trx_code, acct_his.addr_4_special_handling_ind, acct_his.addr_4_delivery_id, acct_his.addr_4_attention_line_prefix, acct_his.addr_4_attention_line_detail, acct_his.addr_4_line_1, acct_his.addr_4_line_2, acct_his.addr_4_line_3, acct_his.addr_4_line_4, acct_his.addr_4_city_state, acct_his.addr_4_country_code, acct_his.set_as_mail_addr_4_ind, acct_his.addr_5_trx_code, acct_his.addr_5_special_handling_ind, acct_his.addr_5_delivery_id, acct_his.addr_5_attention_line_prefix, acct_his.addr_5_attention_line_detail, acct_his.addr_5_line_1, acct_his.addr_5_line_2, acct_his.addr_5_line_3, acct_his.addr_5_line_4, acct_his.addr_5_city_state, acct_his.addr_5_country_code, acct_his.set_as_mail_addr_5_ind, acct_his.addr_6_trx_code, acct_his.addr_6_special_handling_ind, acct_his.addr_6_delivery_id, acct_his.addr_6_attention_line_prefix, acct_his.addr_6_attention_line_detail, acct_his.addr_6_line_1, acct_his.addr_6_line_2, acct_his.addr_6_line_3, acct_his.addr_6_line_4, acct_his.addr_6_city_state, acct_his.addr_6_country_code, acct_his.set_as_mail_addr_6_ind, acct_his.addr_7_trx_code, acct_his.addr_7_special_handling_ind, acct_his.addr_7_delivery_id, acct_his.addr_7_attention_line_prefix, acct_his.addr_7_attention_line_detail, acct_his.addr_7_line_1, acct_his.addr_7_line_2, acct_his.addr_7_line_3, acct_his.addr_7_line_4, acct_his.addr_7_city_state, acct_his.addr_7_country_code, acct_his.set_as_mail_addr_7_ind, acct_his.record_transaction_code, acct_his.base_currency, acct_his.income_currency, acct_his.statement_language, acct_his.statement_format_code, acct_his.msrb_statement_ind, acct_his.pep, acct_his.first_name_pep, acct_his.last_name_pep, acct_his.suffix_pep, acct_his.political_office_held, acct_his.country_of_office, acct_his.foreign_bank_account_ind, acct_his.foreign_bank_cert_date, acct_his.foreign_bank_cert_exp_date, acct_his.central_bank_ind, acct_his.acct_foreign_financial_inst, acct_his.foreign_bank_acct_oper_1, acct_his.foreign_bank_acct_oper_2, acct_his.foreign_bank_acct_oper_3, acct_his.number_people_own, acct_his.proprietary_acct_owned, acct_his.tel_1_transaction_code, acct_his.tel_1_us_ind, acct_his.tel_1_type_id, acct_his.tel_1_number, acct_his.tel_1_extension, acct_his.tel_2_transaction_code, acct_his.tel_2_us_ind, acct_his.tel_2_type_id, acct_his.tel_2_number, acct_his.tel_2_extension, acct_his.tel_3_transaction_code, acct_his.tel_3_us_ind, acct_his.tel_3_type_id, acct_his.tel_3_number, acct_his.tel_3_extension, acct_his.tel_4_transaction_code, acct_his.tel_4_us_ind, acct_his.tel_4_type_id, acct_his.tel_4_number, acct_his.tel_4_extension, acct_his.tel_5_transaction_code, acct_his.tel_5_us_ind, acct_his.tel_5_type_id, acct_his.tel_5_number, acct_his.tel_5_extension, acct_his.tel_6_transaction_code, acct_his.tel_6_us_ind, acct_his.tel_6_type_id, acct_his.tel_6_number, acct_his.tel_6_extension, acct_his.tel_7_transaction_code, acct_his.tel_7_us_ind, acct_his.tel_7_type_id, acct_his.tel_7_number, acct_his.tel_7_extension, acct_his.tel_8_transaction_code, acct_his.tel_8_us_ind, acct_his.tel_8_type_id, acct_his.tel_8_number, acct_his.tel_8_extension, acct_his.email_address, acct_his.external_position_ind, acct_his.purge_eligible_ind, acct_his.advisory_acct_ind, acct_his.product_profile_code, acct_his.cents_per_share_discount, acct_his.option_disclosure_date, acct_his.country_acct_level_tax_residency
    FROM pershing.sfl_acct acct_his
    INNER JOIN
    (
        SELECT max(acct_det.process_date) as process_date, acct_det.account_number
        FROM pershing.sfl_acct acct_det
        WHERE acct_det.process_date<=_process_date
        GROUP BY acct_det.account_number
    ) as acct_last
    ON acct_his.process_date=acct_last.process_date
    AND acct_his.account_number=acct_last.account_number
    ;
end;
$$;




--========================================================================
--========================================================================
--========================================================================
--GACT

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




--========================================================================
--========================================================================
--========================================================================
--GCUS

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


create or replace procedure pershing.pa_gcus_calcula_custodia(IN _process_date character varying)
    language plpgsql
as
$$
begin

    IF (_process_date IS NULL) THEN
        RAISE EXCEPTION 'Process Date no puede ser NULL';
    END IF;

    TRUNCATE TABLE pershing.sfl_gcus_actual;

    INSERT INTO pershing.sfl_gcus_actual (id_proceso, process_date, record_id_sequence_number, account_number, cusip_number, portfolio_currency, underlying_cusip_number, country_code, ip_record_number, ibd_number, currency_security_indicator, issue_currency, datestamp_trade_date, datestamp_settlement_date, trade_date_quantity, settlement_date_quantity, seg_quantity, safekeeping_quantity, transfer_quantity, pending_transfer_quantity, legal_transfer_quantity, tendered_quantity, pending_papers, short_against_the_box_quantity, networked_quantity, pending_split_quantity, quantity_covering_options, trade_date_quantity_bought, trade_date_quantity_sold, fed_rquirement, house_margin_requirement, nyse_requirement, equity_requirment, security_symbol, security_type, security_mod, security_calc, minor_product_code, network_eligibility_indicator, strike_price, expiration_maturity_date, contract_size, conversion_ratio, account_short_name, state_code, country_code_account, number_security_description_lines, security_description_line_1, security_description_line_2, security_description_line_3, security_description_line_4, security_description_line_5, security_description_line_6, dividend_option, long_term_capital_gains_option, short_term_capital_gains_option, firm_trading_indicator, position_currency_security, trade_date_liquidating_value, pool_factor, exchange_rate, settlement_date_liquidating_value, alternate_security_id_type, alternate_security_id, position_currency, fully_paid_lending_quantity, fully_paid_lending_quantity_collateral_amount, option_root_id, expiration_date, call_put_indicator, trade_date_repo_quantity, settlement_date_repo_quantity, trade_date_reverse_repo_quantity, settlement_date_reverse_repo_quantity, collateral_pledge_quantity, corporate_exec_serv_collateral_pledge_quantity, trade_date_repo_liquidating_value, settlement_date_repo_liquidating_value, trade_date_reverse_repo_liquidating_value, settlement_date_reverse_repo_liquidating_value, collateral_pledge_liquidating_value, corporate_exec_serv_collateral_pledge_liquidating_value, trade_date_repo_loan_amount, settlement_date_repo_loan_amount, trade_date_reverse_repo_loan_amount, settlement_date_reverse_repo_loan_amount, accrued_interes_value, dividend_or_coupon_rate, pending_split_quantity_liquidating_value, internal_non_dollar_symbol, pledged_quantity)
    SELECT tb_det.id_proceso, tb_det.process_date, tb_det.record_id_sequence_number, tb_det.account_number, tb_det.cusip_number, tb_det.portfolio_currency, tb_det.underlying_cusip_number, tb_det.country_code, tb_det.ip_record_number, tb_det.ibd_number, tb_det.currency_security_indicator, tb_det.issue_currency, tb_det.datestamp_trade_date, tb_det.datestamp_settlement_date, tb_det.trade_date_quantity, tb_det.settlement_date_quantity, tb_det.seg_quantity, tb_det.safekeeping_quantity, tb_det.transfer_quantity, tb_det.pending_transfer_quantity, tb_det.legal_transfer_quantity, tb_det.tendered_quantity, tb_det.pending_papers, tb_det.short_against_the_box_quantity, tb_det.networked_quantity, tb_det.pending_split_quantity, tb_det.quantity_covering_options, tb_det.trade_date_quantity_bought, tb_det.trade_date_quantity_sold, tb_det.fed_rquirement, tb_det.house_margin_requirement, tb_det.nyse_requirement, tb_det.equity_requirment, tb_det.security_symbol, tb_det.security_type, tb_det.security_mod, tb_det.security_calc, tb_det.minor_product_code, tb_det.network_eligibility_indicator, tb_det.strike_price, tb_det.expiration_maturity_date, tb_det.contract_size, tb_det.conversion_ratio, tb_det.account_short_name, tb_det.state_code, tb_det.country_code_account, tb_det.number_security_description_lines, tb_det.security_description_line_1, tb_det.security_description_line_2, tb_det.security_description_line_3, tb_det.security_description_line_4, tb_det.security_description_line_5, tb_det.security_description_line_6, tb_det.dividend_option, tb_det.long_term_capital_gains_option, tb_det.short_term_capital_gains_option, tb_det.firm_trading_indicator, tb_det.position_currency_security, tb_det.trade_date_liquidating_value, tb_det.pool_factor, tb_det.exchange_rate, tb_det.settlement_date_liquidating_value, tb_det.alternate_security_id_type, tb_det.alternate_security_id, tb_det.position_currency, tb_det.fully_paid_lending_quantity, tb_det.fully_paid_lending_quantity_collateral_amount, tb_det.option_root_id, tb_det.expiration_date, tb_det.call_put_indicator, tb_det.trade_date_repo_quantity, tb_det.settlement_date_repo_quantity, tb_det.trade_date_reverse_repo_quantity, tb_det.settlement_date_reverse_repo_quantity, tb_det.collateral_pledge_quantity, tb_det.corporate_exec_serv_collateral_pledge_quantity, tb_det.trade_date_repo_liquidating_value, tb_det.settlement_date_repo_liquidating_value, tb_det.trade_date_reverse_repo_liquidating_value, tb_det.settlement_date_reverse_repo_liquidating_value, tb_det.collateral_pledge_liquidating_value, tb_det.corporate_exec_serv_collateral_pledge_liquidating_value, tb_det.trade_date_repo_loan_amount, tb_det.settlement_date_repo_loan_amount, tb_det.trade_date_reverse_repo_loan_amount, tb_det.settlement_date_reverse_repo_loan_amount, tb_det.accrued_interes_value, tb_det.dividend_or_coupon_rate, tb_det.pending_split_quantity_liquidating_value, tb_det.internal_non_dollar_symbol, tb_det.pledged_quantity
    FROM pershing.sfl_gcus tb_det
    INNER JOIN
    (
        SELECT max(gcus_acum.process_date) as process_date, gcus_acum.account_number, gcus_acum.cusip_number, gcus_acum.currency_security_indicator
        FROM pershing.sfl_gcus gcus_acum
        WHERE gcus_acum.process_date<=_process_date
        GROUP BY gcus_acum.account_number, gcus_acum.cusip_number, gcus_acum.currency_security_indicator
    ) as tb_cab
    ON tb_det.process_date=tb_cab.process_date
    AND tb_det.account_number=tb_cab.account_number
    AND tb_det.cusip_number=tb_cab.cusip_number
    AND tb_det.currency_security_indicator=tb_cab.currency_security_indicator
    AND tb_det.process_date=tb_cab.process_date
    ;

    DELETE FROM pershing.sfl_gcus_historica gcus_del WHERE gcus_del.process_date=_process_date;

    INSERT INTO pershing.sfl_gcus_historica (id_proceso, process_date, record_id_sequence_number, account_number, cusip_number, portfolio_currency, underlying_cusip_number, country_code, ip_record_number, ibd_number, currency_security_indicator, issue_currency, datestamp_trade_date, datestamp_settlement_date, trade_date_quantity, settlement_date_quantity, seg_quantity, safekeeping_quantity, transfer_quantity, pending_transfer_quantity, legal_transfer_quantity, tendered_quantity, pending_papers, short_against_the_box_quantity, networked_quantity, pending_split_quantity, quantity_covering_options, trade_date_quantity_bought, trade_date_quantity_sold, fed_rquirement, house_margin_requirement, nyse_requirement, equity_requirment, security_symbol, security_type, security_mod, security_calc, minor_product_code, network_eligibility_indicator, strike_price, expiration_maturity_date, contract_size, conversion_ratio, account_short_name, state_code, country_code_account, number_security_description_lines, security_description_line_1, security_description_line_2, security_description_line_3, security_description_line_4, security_description_line_5, security_description_line_6, dividend_option, long_term_capital_gains_option, short_term_capital_gains_option, firm_trading_indicator, position_currency_security, trade_date_liquidating_value, pool_factor, exchange_rate, settlement_date_liquidating_value, alternate_security_id_type, alternate_security_id, position_currency, fully_paid_lending_quantity, fully_paid_lending_quantity_collateral_amount, option_root_id, expiration_date, call_put_indicator, trade_date_repo_quantity, settlement_date_repo_quantity, trade_date_reverse_repo_quantity, settlement_date_reverse_repo_quantity, collateral_pledge_quantity, corporate_exec_serv_collateral_pledge_quantity, trade_date_repo_liquidating_value, settlement_date_repo_liquidating_value, trade_date_reverse_repo_liquidating_value, settlement_date_reverse_repo_liquidating_value, collateral_pledge_liquidating_value, corporate_exec_serv_collateral_pledge_liquidating_value, trade_date_repo_loan_amount, settlement_date_repo_loan_amount, trade_date_reverse_repo_loan_amount, settlement_date_reverse_repo_loan_amount, accrued_interes_value, dividend_or_coupon_rate, pending_split_quantity_liquidating_value, internal_non_dollar_symbol, pledged_quantity)
    SELECT
        gcus_act.id_proceso, _process_date as process_date, gcus_act.record_id_sequence_number, gcus_act.account_number, gcus_act.cusip_number, gcus_act.portfolio_currency, gcus_act.underlying_cusip_number, gcus_act.country_code, gcus_act.ip_record_number, gcus_act.ibd_number, gcus_act.currency_security_indicator, gcus_act.issue_currency, gcus_act.datestamp_trade_date, gcus_act.datestamp_settlement_date, gcus_act.trade_date_quantity, gcus_act.settlement_date_quantity, gcus_act.seg_quantity, gcus_act.safekeeping_quantity, gcus_act.transfer_quantity, gcus_act.pending_transfer_quantity, gcus_act.legal_transfer_quantity, gcus_act.tendered_quantity, gcus_act.pending_papers, gcus_act.short_against_the_box_quantity, gcus_act.networked_quantity, gcus_act.pending_split_quantity, gcus_act.quantity_covering_options, gcus_act.trade_date_quantity_bought, gcus_act.trade_date_quantity_sold, gcus_act.fed_rquirement, gcus_act.house_margin_requirement, gcus_act.nyse_requirement, gcus_act.equity_requirment, gcus_act.security_symbol, gcus_act.security_type, gcus_act.security_mod, gcus_act.security_calc, gcus_act.minor_product_code, gcus_act.network_eligibility_indicator, gcus_act.strike_price, gcus_act.expiration_maturity_date, gcus_act.contract_size, gcus_act.conversion_ratio, gcus_act.account_short_name, gcus_act.state_code, gcus_act.country_code_account, gcus_act.number_security_description_lines, gcus_act.security_description_line_1, gcus_act.security_description_line_2, gcus_act.security_description_line_3, gcus_act.security_description_line_4, gcus_act.security_description_line_5, gcus_act.security_description_line_6, gcus_act.dividend_option, gcus_act.long_term_capital_gains_option, gcus_act.short_term_capital_gains_option, gcus_act.firm_trading_indicator, gcus_act.position_currency_security, gcus_act.trade_date_liquidating_value, gcus_act.pool_factor, gcus_act.exchange_rate, gcus_act.settlement_date_liquidating_value, gcus_act.alternate_security_id_type, gcus_act.alternate_security_id, gcus_act.position_currency, gcus_act.fully_paid_lending_quantity, gcus_act.fully_paid_lending_quantity_collateral_amount, gcus_act.option_root_id, gcus_act.expiration_date, gcus_act.call_put_indicator, gcus_act.trade_date_repo_quantity, gcus_act.settlement_date_repo_quantity, gcus_act.trade_date_reverse_repo_quantity, gcus_act.settlement_date_reverse_repo_quantity, gcus_act.collateral_pledge_quantity, gcus_act.corporate_exec_serv_collateral_pledge_quantity, gcus_act.trade_date_repo_liquidating_value, gcus_act.settlement_date_repo_liquidating_value, gcus_act.trade_date_reverse_repo_liquidating_value, gcus_act.settlement_date_reverse_repo_liquidating_value, gcus_act.collateral_pledge_liquidating_value, gcus_act.corporate_exec_serv_collateral_pledge_liquidating_value, gcus_act.trade_date_repo_loan_amount, gcus_act.settlement_date_repo_loan_amount, gcus_act.trade_date_reverse_repo_loan_amount, gcus_act.settlement_date_reverse_repo_loan_amount, gcus_act.accrued_interes_value, gcus_act.dividend_or_coupon_rate, gcus_act.pending_split_quantity_liquidating_value, gcus_act.internal_non_dollar_symbol, gcus_act.pledged_quantity
    FROM pershing.sfl_gcus_actual gcus_act;

end;
$$;





--========================================================================
--========================================================================
--========================================================================
--GMON


create or replace procedure pershing.pa_procesa_gmon(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _process_date VARCHAR(100);
DECLARE _last_process_date VARCHAR(100);
begin

    SELECT tb_proc.process_date INTO _process_date
    FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso;

    DELETE FROM pershing.sfl_gmon tb_sfl WHERE tb_sfl.process_date= _process_date;

    INSERT INTO pershing.sfl_gmon (id_proceso, process_date, record_id_sequence_number, account_number, ip_number, ibd_number, usde_td_balance, usd_td_balance, long_td_market, short_td_market, td_liquidating_equity, total_usde_td_balance, total_equity, trade_date_net_worth, mmf_principal_balance, mmf_dividend, cash_available, date_of_data, usde_sd_balance, usd_sd_balance, long_sd_market, short_sd_market, sma_date_stamp, sma_balance, margin_buying_power, technical_short_value, total_fed_requirement, total_options_requirement, base_currency, non_usd_currency, masked_house_call)
    SELECT
        reg_header.id_proceso, reg_header.process_date, reg_a.record_id_sequence_number, reg_a.account_number, reg_a.ip_number, reg_a.ibd_number,
        usde_td_balance*public.fn_convierte_signo_factor(usde_td_balance_sign) as usde_td_balance,
        usd_td_balance*public.fn_convierte_signo_factor(usd_td_balance_sign) as usd_td_balance,
        long_td_market*public.fn_convierte_signo_factor(long_td_market_sign) as long_td_market,
        short_td_market*public.fn_convierte_signo_factor(short_td_market_sign) as short_td_market,
        td_liquidating_equity*public.fn_convierte_signo_factor(td_liquidating_equity_sign) as td_liquidating_equity,
        total_usde_td_balance*public.fn_convierte_signo_factor(total_usde_td_balance_sign) as total_usde_td_balance,
        total_equity*public.fn_convierte_signo_factor(total_equity_sign) as total_equity,
        trade_date_net_worth*public.fn_convierte_signo_factor(trade_date_net_worth_sign) as trade_date_net_worth,
        mmf_principal_balance*public.fn_convierte_signo_factor(mmf_principal_balance_sign) as mmf_principal_balance,
        mmf_dividend*public.fn_convierte_signo_factor(mmf_dividend_sign) as mmf_dividend,
        cash_available*public.fn_convierte_signo_factor(cash_available_sign) as cash_available, reg_a.date_of_data,
        usde_sd_balance*public.fn_convierte_signo_factor(usde_sd_balance_sign) as usde_sd_balance,
        usd_sd_balance*public.fn_convierte_signo_factor(usd_sd_balance_sign) as usd_sd_balance,
        long_sd_market*public.fn_convierte_signo_factor(long_sd_market_sign) as long_sd_market,
        short_sd_market*public.fn_convierte_signo_factor(short_sd_market_sign) as short_sd_market, sma_date_stamp,
        sma_balance*public.fn_convierte_signo_factor(sma_balance_sign) as sma_balance,
        margin_buying_power*public.fn_convierte_signo_factor(margin_buying_power_sign) as margin_buying_power,
        technical_short_value*public.fn_convierte_signo_factor(technical_short_value_sign) as technical_short_value,
        total_fed_requirement*public.fn_convierte_signo_factor(total_fed_requirement_sign) as total_fed_requirement,
        total_options_requirement*public.fn_convierte_signo_factor(total_options_requirement_sign) as total_options_requirement, base_currency, non_usd_currency,
        masked_house_call*public.fn_convierte_signo_factor(masked_house_call_sign) as masked_house_call
    FROM stage_pershing.stage_gmon_reg_header reg_header
    INNER JOIN stage_pershing.stage_gmon_reg_trailer reg_trailer
    ON reg_header.id_proceso=reg_trailer.id_proceso
    INNER JOIN stage_pershing.stage_gmon_reg_a reg_a
    ON reg_header.id_proceso=reg_a.id_proceso
    LEFT JOIN stage_pershing.stage_gmon_reg_b reg_b
    ON reg_header.id_proceso=reg_b.id_proceso AND reg_a.account_number=reg_b.account_number
    WHERE reg_header.id_proceso=_id_proceso
    AND NOT pershing.fn_excluye_cuenta('CARGA_SFL', reg_a.account_number)
    ;


    DELETE FROM pershing.sfl_gmon_historica WHERE process_date=_process_date;

    --Si no se cargaron datos y no existe SFL
    IF ( (SELECT count(*) FROM pershing.sfl_gmon where process_date=_process_date)=0    --No se cargaron datos en INSERT anterior
        AND
         (SELECT count(*) FROM stage_pershing.stage_gmon_reg_header where process_date=_process_date)=0 ) THEN  --No venían datos en SFL
        --Replicar data ultimo process date disponible
        SELECT max(process_date) INTO _last_process_date
        FROM pershing.sfl_gmon where process_date<=_process_date;

        INSERT INTO pershing.sfl_gmon_historica (id_proceso, process_date, record_id_sequence_number, account_number, ip_number, ibd_number, usde_td_balance, usd_td_balance, long_td_market, short_td_market, td_liquidating_equity, total_usde_td_balance, total_equity, trade_date_net_worth, mmf_principal_balance, mmf_dividend, cash_available, date_of_data, usde_sd_balance, usd_sd_balance, long_sd_market, short_sd_market, sma_date_stamp, sma_balance, margin_buying_power, technical_short_value, total_fed_requirement, total_options_requirement, base_currency, non_usd_currency, masked_house_call)
        SELECT
            id_proceso, _process_date as process_date, record_id_sequence_number, account_number, ip_number, ibd_number, usde_td_balance, usd_td_balance, long_td_market, short_td_market, td_liquidating_equity, total_usde_td_balance, total_equity, trade_date_net_worth, mmf_principal_balance, mmf_dividend, cash_available, date_of_data, usde_sd_balance, usd_sd_balance, long_sd_market, short_sd_market, sma_date_stamp, sma_balance, margin_buying_power, technical_short_value, total_fed_requirement, total_options_requirement, base_currency, non_usd_currency, masked_house_call
        FROM pershing.sfl_gmon
        WHERE process_date=_last_process_date;
    ELSE

        INSERT INTO pershing.sfl_gmon_historica (id_proceso, process_date, record_id_sequence_number, account_number, ip_number, ibd_number, usde_td_balance, usd_td_balance, long_td_market, short_td_market, td_liquidating_equity, total_usde_td_balance, total_equity, trade_date_net_worth, mmf_principal_balance, mmf_dividend, cash_available, date_of_data, usde_sd_balance, usd_sd_balance, long_sd_market, short_sd_market, sma_date_stamp, sma_balance, margin_buying_power, technical_short_value, total_fed_requirement, total_options_requirement, base_currency, non_usd_currency, masked_house_call)
        SELECT
            gmon_his.id_proceso, _process_date as process_date, gmon_his.record_id_sequence_number, gmon_his.account_number, gmon_his.ip_number, gmon_his.ibd_number, gmon_his.usde_td_balance, gmon_his.usd_td_balance, gmon_his.long_td_market, gmon_his.short_td_market, gmon_his.td_liquidating_equity, gmon_his.total_usde_td_balance, gmon_his.total_equity, gmon_his.trade_date_net_worth, gmon_his.mmf_principal_balance, gmon_his.mmf_dividend, gmon_his.cash_available, gmon_his.date_of_data, gmon_his.usde_sd_balance, gmon_his.usd_sd_balance, gmon_his.long_sd_market, gmon_his.short_sd_market, gmon_his.sma_date_stamp, gmon_his.sma_balance, gmon_his.margin_buying_power, gmon_his.technical_short_value, gmon_his.total_fed_requirement, gmon_his.total_options_requirement, gmon_his.base_currency, gmon_his.non_usd_currency, gmon_his.masked_house_call
        FROM pershing.sfl_gmon gmon_his
        WHERE gmon_his.process_date=_process_date
        ;
    END IF;


end;
$$;




--========================================================================
--========================================================================
--========================================================================
-- Error sources

create or replace function public.fn_calendario_genera_fechas(_start_date_in date, _end_date_in date)
    returns TABLE(fecha_as_date date)
    language plpgsql
as
$$
DECLARE _start_date_default DATE;
DECLARE _end_date_default DATE;
    BEGIN

    _start_date_default := '1800-01-01'::DATE;
    _end_date_default := '2100-12-31'::DATE;

    IF (_start_date_in IS NULL) THEN
        _start_date_in  := _start_date_default;
    end if;
    IF (_end_date_in IS NULL) THEN
        _end_date_in    := _end_date_default;
    end if;

    RETURN QUERY
        SELECT dd::date as fecha_as_date
        FROM generate_series
                ( _start_date_in::timestamp
                , _end_date_in::timestamp
                , '1 day'::interval) dd
                ;
    RETURN;
    END;
$$;


--========================================================================
--========================================================================
--========================================================================
--


--========================================================================
--========================================================================
--========================================================================
--



--========================================================================
--========================================================================
--========================================================================
--


--========================================================================
--========================================================================
--========================================================================
--




--========================================================================
--========================================================================
--========================================================================
--


--========================================================================
--========================================================================
--========================================================================
--



--========================================================================
--========================================================================
--========================================================================
--



