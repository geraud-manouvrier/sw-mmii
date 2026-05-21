--========================================================================
--========================================================================
--========================================================================
--Ajuste de materialización de data para control de fechas no permitidas de reprocesar

create or replace function public.fn_reporte_maestro_materializa_data(_process_date character varying, _tipo_maestro character varying, _custodio character varying) returns bigint
    language plpgsql
as
$$
DECLARE _row_count  BIGINT;
/*Por clientes mal cargados en Custodio, mal proceso de SFL o similares (se modifica info del custodio)*/
DECLARE black_list_sld character varying[] := ARRAY['20251013', '20251111', '20251112', '20251113', '20251219', '20251224', '20251225', '20251226', '20251227', '20251228', '20251229', '20251230', '20251231', '20260101', '20260102', '20260103', '20260104', '20260105', '20260306', '20260307', '20260308'];
DECLARE black_list_mov character varying[] := ARRAY['20251013', '20251111', '20260306'];


    BEGIN

    IF (_tipo_maestro NOT IN ('CTA', 'SLD', 'MOV', 'REL') ) THEN
        RAISE NOTICE 'Tipo de maestro no válido [%]', _tipo_maestro;
        return -1;
    end if;

    IF (_custodio NOT IN ('PERSHING') ) THEN
        RAISE NOTICE 'Custodio no válido [%]', _custodio;
        return -2;
    end if;

    IF (_tipo_maestro='CTA') THEN
        IF (_custodio ='PERSHING') THEN
            DELETE FROM public.tbvw_maestro_cuentas_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_cuentas_pershing
            (id, custodian, id_interno_cliente, client_id, name, id_tipo_identificador_cliente, tipo_identificador_cliente, glosa_identificador_cliente, id_interno_cuenta, id_custodio, id_cuenta_custodio, habilitado, fee, ibd_number, id_office, ip_number, account_no, id_proceso, process_date, record_id_sequence_number, account_short_name, full_name, full_address, transaction_type, autotitled_usertitled_account, account_type_code, registration_type, registration_type_value, number_of_account_title_lines, account_registration_line_1, account_registration_line_2, account_registration_line_3, account_registration_line_4, account_registration_line_5, account_registration_line_6, registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions, income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked, statement_review_date, margin_papers_on_file, cash_margin_account, option_papers_on_file, good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted, invest_advisor_discretion_granted_value, third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits, option_total_limits_of_puts_and_calls, non_us_dollar_trading, non_customer_indicator, third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule, group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic, employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date, plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative, commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form, date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form, date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account, foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, country_of_citizenship_code, country_of_citizenship_value, country_of_residence_code, country_of_residence_value, birth_date, age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status, regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, customer_type, fulfillment_method, credit_interest_indicator, ama_indicator, ama_indicator_value, tax_id_type, tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, w_8_date_signed, w_8_effective_date, w_9_date_signed, w_9_effective_date, tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced, date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced, date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced, date_c_notice_status_satisfied, old_account_number, original_account_open_date, unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date, initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code, future_statement_currency_code, future_statement_currency_code_effective_date, account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3, account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip, third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym, alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator, source_of_asset_at_acct_opening, commission_doscount_code, external_account_number, confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside, fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type, mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated, date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id, firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id, second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account, banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code, combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code, proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code, dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona, client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code, addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix, addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4, addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id, addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3, addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind, principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2, from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system, disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks, amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code, addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix, addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4, addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code, addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix, addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4, addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code, addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix, addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4, addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code, addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix, addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4, addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code, addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix, addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4, addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency, income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep, last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind, foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst, foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own, proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension, tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code, tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind, tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id, tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number, tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension, tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address, external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code, cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency, estado_cuenta)
            SELECT
                id, custodian, id_interno_cliente, client_id, name, id_tipo_identificador_cliente, tipo_identificador_cliente, glosa_identificador_cliente, id_interno_cuenta, id_custodio, id_cuenta_custodio, habilitado, fee, ibd_number, id_office, ip_number, account_no, id_proceso, process_date, record_id_sequence_number, account_short_name, full_name, full_address, transaction_type, autotitled_usertitled_account, account_type_code, registration_type, registration_type_value, number_of_account_title_lines, account_registration_line_1, account_registration_line_2, account_registration_line_3, account_registration_line_4, account_registration_line_5, account_registration_line_6, registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions, income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked, statement_review_date, margin_papers_on_file, cash_margin_account, option_papers_on_file, good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted, invest_advisor_discretion_granted_value, third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits, option_total_limits_of_puts_and_calls, non_us_dollar_trading, non_customer_indicator, third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule, group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic, employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date, plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative, commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form, date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form, date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account, foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, country_of_citizenship_code, country_of_citizenship_value, country_of_residence_code, country_of_residence_value, birth_date, age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status, regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, customer_type, fulfillment_method, credit_interest_indicator, ama_indicator, ama_indicator_value, tax_id_type, tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, w_8_date_signed, w_8_effective_date, w_9_date_signed, w_9_effective_date, tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced, date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced, date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced, date_c_notice_status_satisfied, old_account_number, original_account_open_date, unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date, initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code, future_statement_currency_code, future_statement_currency_code_effective_date, account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3, account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip, third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym, alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator, source_of_asset_at_acct_opening, commission_doscount_code, external_account_number, confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside, fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type, mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated, date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id, firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id, second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account, banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code, combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code, proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code, dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona, client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code, addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix, addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4, addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id, addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3, addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind, principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2, from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system, disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks, amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code, addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix, addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4, addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code, addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix, addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4, addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code, addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix, addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4, addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code, addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix, addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4, addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code, addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix, addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4, addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency, income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep, last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind, foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst, foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own, proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension, tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code, tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind, tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id, tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number, tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension, tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address, external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code, cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency, NULL::VARCHAR(100) as estado_cuenta
            FROM public.vw_maestro_cuentas_pershing where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;

            --Actualizamos marca estado cuenta
            UPDATE public.tbvw_maestro_cuentas_pershing
                SET estado_cuenta = public.fn_estado_cuenta_from_tbvw(account_no, _process_date)
            WHERE process_date=_process_date;

            RETURN _row_count;
        END IF;
    END IF;


    IF (_tipo_maestro='SLD') THEN
        IF (_custodio ='PERSHING') THEN
            IF _process_date = ANY(black_list_sld) THEN
                RAISE EXCEPTION 'La fecha [%] está en la lista no permitida de procesos para saldos. No se realizará la materialización.', _process_date
                using errcode = '22023';
            END IF;
            DELETE FROM public.tbvw_maestro_saldos_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_saldos_pershing
            (custodian, tipo_reg, client_id, office_id, account_no, name, process_date, symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity, market_price, id_currency, currency, market_value, fx_rate, usde_market_value, total_usde_market_value, id_fee_aplicado, annual_fee, tasa_proteccion, tasa_suracorp, fee_diario, fee_diario_proteccion, fee_diario_sura_corp, comision_devengada_diaria, ingreso_proteccion, usde_market_price, id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo, tipo_identificador_cliente)
            SELECT
                custodian, tipo_reg, client_id, office_id, account_no, name, process_date, symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity, market_price, id_currency, currency, market_value, fx_rate, usde_market_value, total_usde_market_value, id_fee_aplicado, annual_fee, tasa_proteccion, tasa_suracorp, fee_diario, fee_diario_proteccion, fee_diario_sura_corp, comision_devengada_diaria, ingreso_proteccion, usde_market_price, id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo, tipo_identificador_cliente
            FROM public.vw_maestro_saldos_pershing where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;


            RETURN _row_count;
        END IF;
    END IF;


    IF (_tipo_maestro='MOV') THEN
        IF (_custodio ='PERSHING') THEN
            IF _process_date = ANY(black_list_mov) THEN
                RAISE EXCEPTION 'La fecha [%] está en la lista no permitida de procesos para movimientos. No se realizará la materialización.', _process_date
                using errcode = '22023';
            END IF;
            DELETE FROM public.tbvw_maestro_movimientos_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_movimientos_pershing
                (custodian, client_id, office_id, account_no, name, process_date, tipo_reg, trade_date, settlement_date, activity, buy_sell_code, buy_sell_value, quantity, price, commission, fees, net_amount, usde_net_amount, principal, cusip, symbol, isin, currency, fx_rate, interest, currency_base, cash_margin, product_type, security_description, activity_description, activity_code, source_code, description_1, description_2, description_3, ticker, id_sub_sub_tipo, id_sub_tipo, id_tipo, nombre_sub_sub_tipo, flujo_neto, ingreso_egreso, retiro, recaudo, id_cuenta_custodio, tipo_identificador_cliente)
                SELECT
                    custodian, client_id, office_id, account_no, name, process_date, tipo_reg, trade_date, settlement_date, activity, buy_sell_code, buy_sell_value, quantity, price, commission, fees, net_amount, usde_net_amount, principal, cusip, symbol, isin, currency, fx_rate, interest, currency_base, cash_margin, product_type, security_description, activity_description, activity_code, source_code, description_1, description_2, description_3, ticker, id_sub_sub_tipo, id_sub_tipo, id_tipo, nombre_sub_sub_tipo, flujo_neto, ingreso_egreso, retiro, recaudo, id_cuenta_custodio, tipo_identificador_cliente
                FROM public.vw_maestro_movimientos_pershing where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;
            RETURN _row_count;
        END IF;
    END IF;



    IF (_tipo_maestro='REL') THEN
        IF (_custodio ='PERSHING') THEN
            DELETE FROM public.tbvw_maestro_relacionados_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_relacionados_pershing
                (process_date, id_interno_cliente, custodian, client_id, account_no, tipo_identificador_cliente, glosa_identificador_cliente, office_id, name, id_relacionado, identificador_relacionado, nombre_relacionado, tipo_identificador_relacionado, glosa_tipo_identificador_relacionado, id_cargo, cargo)
                SELECT
                    process_date, id_interno_cliente, custodian, client_id, account_no, tipo_identificador_cliente, glosa_identificador_cliente, office_id, name, id_relacionado, identificador_relacionado, nombre_relacionado, tipo_identificador_relacionado, glosa_tipo_identificador_relacionado, id_cargo, cargo
                FROM public.vw_reporte_maestro_datos_relacionados where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;
            RETURN _row_count;
        END IF;
    END IF;

    return NULL::BIGINT;
    END;
$$;



--========================================================================
--========================================================================
--========================================================================
-- Respaldo tablas maestros por descuadre (20260503)
SELECT * INTO zz_backup.tbvw_maestro_cuentas_pershing_20260503_descuadre
FROM public.tbvw_maestro_cuentas_pershing;      -- 128,364 reg.
SELECT * INTO zz_backup.tbvw_maestro_saldos_pershing_20260503_descuadre
FROM public.tbvw_maestro_saldos_pershing;       -- 593,372 reg.
SELECT * INTO zz_backup.tbvw_maestro_movimientos_pershing_20260503_descuadre
FROM public.tbvw_maestro_movimientos_pershing;  -- 20,240 reg.



select vw_cte.process_date, vw_cte.account_no, count(*)
into zz_backup.cuadre_ria_proteccion_20260416_clientes_proteccion
from public.vw_reporte_maestro_datos_clientes vw_cte
group by process_date, account_no
order by process_date, account_no
;
select vw_sld.process_date, vw_sld.account_no, count(*), sum(vw_sld.usde_market_value)
into zz_backup.cuadre_ria_proteccion_20260416_saldos_proteccion
from public.vw_reporte_maestro_datos_saldos vw_sld
group by process_date, account_no
order by process_date, account_no
;
select vw_mov.process_date, vw_mov.account_no, count(*), sum(vw_mov.usde_net_amount)
into zz_backup.cuadre_ria_proteccion_20260416_movimientos_proteccion
from public.vw_reporte_maestro_datos_movimientos vw_mov
group by process_date, account_no
order by process_date, account_no
;


--========================================================================
--========================================================================
--========================================================================
-- Saldos

--En Diciembre hubo proceso de GCUS fuera de orden, generando error en Prote -> Borrar registros de prote y cuadrar post

--Borrar registro tipo_reg CUS (cusip USD999997)
select *
--delete
from public.tbvw_maestro_saldos_pershing sld
where sld.process_date='20251219'
and sld.account_no in ('T9N002589', 'T9O003693', 'T9O005136', 'T9O005144')
and sld.tipo_reg='CUS' and sld.cusip='USD999997'
;   --4 reg
UPDATE public.tbvw_maestro_saldos_pershing sld
SET total_usde_market_value = sub.total
FROM (
    SELECT
        process_date,
        account_no,
        SUM(usde_market_value) OVER (PARTITION BY process_date, account_no) AS total,
        ctid
    FROM public.tbvw_maestro_saldos_pershing
    where process_date='20251219'
    and account_no in ('T9N002589', 'T9O003693', 'T9O005136', 'T9O005144')
) sub
WHERE sld.ctid = sub.ctid;  --9 reg.

--Borrar registro tipo_reg CUS (cusip USD999997)
select *
--delete
from public.tbvw_maestro_saldos_pershing sld
where sld.process_date>='20251224' and sld.process_date<='20251230'
and sld.account_no in ('T9O001952', 'T9O003024', 'T9O003123', 'T9O005102')
and sld.tipo_reg='CUS' and sld.cusip='USD999997'
;   --28 reg
UPDATE public.tbvw_maestro_saldos_pershing sld
SET total_usde_market_value = sub.total
FROM (
    SELECT
        process_date,
        account_no,
        SUM(usde_market_value) OVER (PARTITION BY process_date, account_no) AS total,
        ctid
    FROM public.tbvw_maestro_saldos_pershing
    where process_date>='20251224' and process_date<='20251230'
    and account_no in ('T9O001952', 'T9O003024', 'T9O003123', 'T9O005102')
) sub
WHERE sld.ctid = sub.ctid;  --133 reg.

--Borrar registro tipo_reg CUS (cusip USD999997)
select *
--delete
from public.tbvw_maestro_saldos_pershing sld
where sld.process_date>='20251231' and sld.process_date<='20260105'
and sld.account_no in ('T9O001952', 'T9O005102')
and sld.tipo_reg='CUS' and sld.cusip='USD999997'
;   --12 reg
UPDATE public.tbvw_maestro_saldos_pershing sld
SET total_usde_market_value = sub.total
FROM (
    SELECT
        process_date,
        account_no,
        SUM(usde_market_value) OVER (PARTITION BY process_date, account_no) AS total,
        ctid
    FROM public.tbvw_maestro_saldos_pershing
    where process_date>='20251231' and process_date<='20260105'
    and account_no in ('T9O001952', 'T9O005102')
) sub
WHERE sld.ctid = sub.ctid;  --42 reg.

--Borrar registros tipo_reg CUS (cusip G49543AC8, L5780N309, L57867621)
select *
--delete
from public.tbvw_maestro_saldos_pershing sld
where sld.process_date in ('20251224', '20251225')
and sld.account_no in ('T9O005110')
and sld.tipo_reg='CUS' and sld.cusip in ('G49543AC8', 'L5780N309', 'L57867621')
;   --6 reg
UPDATE public.tbvw_maestro_saldos_pershing sld
SET total_usde_market_value = sub.total
FROM (
    SELECT
        process_date,
        account_no,
        SUM(usde_market_value) OVER (PARTITION BY process_date, account_no) AS total,
        ctid
    FROM public.tbvw_maestro_saldos_pershing
    where process_date in ('20251224', '20251225')
    and account_no in ('T9O005110')
) sub
WHERE sld.ctid = sub.ctid;  --8 reg.

--Query de cuadratura consolidada contra RIA
select sld.process_date, sld.account_no, count(*), sum(sld.usde_market_value), avg(sld.quantity)
from public.tbvw_maestro_saldos_pershing sld
WHERE sld.process_date>='20251219' and sld.process_date<='20260105'
and sld.account_no in ('T9O001952', 'T9O003024', 'T9O003123', 'T9O005102', 'T9O005110', 'T9N002589', 'T9O003693', 'T9O005136', 'T9O005144')
group by sld.process_date, sld.account_no
order by sld.process_date, sld.account_no
;


--Registros faltantes (6 reg., de los cuales 3 tienen qty=0)
--Verificamos que no estén
SELECT *
FROM public.tbvw_maestro_saldos_pershing sld
where sld.process_date>='20260306'
and sld.process_date<='20260308'
and sld.account_no='T9O004642'
;   --0 reg.

/*
total_usde_market_value=null
id_fee_aplicado=3
annual_fee=0.01500000000000000000
tasa_proteccion=0.01100000000000000000
tasa_suracorp=0.00400000000000000000
fee_diario=0.00004109589041095890
fee_diario_proteccion=0.00003013698630136986
fee_diario_sura_corp=0.00001095890410958904
ingreso_proteccion=usde_market_value*0.00003013698630136986
tipo_identificador_cliente='CC'
--Para insert
null, 3, 0.01500000000000000000, 0.01100000000000000000, 0.00400000000000000000, 0.00004109589041095890, 0.00003013698630136986, 0.00001095890410958904,
usde_market_value*0.00003013698630136986, 'CC'

** Se debe actualizar total_usde_market_value

*/
SELECT * FROM public.tbvw_maestro_saldos_pershing where tbvw_maestro_saldos_pershing.account_no='T9O004642';
SELECT fee, fee/100, * FROM clientes.vw_maestro_clientes_cuentas where vw_maestro_clientes_cuentas.id_cuenta_custodio='T9O004642'; --1.5, 0.015
SELECT fn_change_base_fee(1.5, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying); --0.0000410958904109589041
SELECT fee_perc_proteccion / 100, fee_perc_ria / 100, *
from fn_distribucion_ingresos(0.015 * 100::numeric, '20260306');   --0.011, 0.004, 1.1, 0.4
SELECT * from fn_change_base_fee(1.1, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying);
--0.000030136986301369863
SELECT * from fn_change_base_fee(0.4, 'ANNUAL'::character varying, 'DAILY'::character varying, 'P'::character varying);
--0.0000109589041095890411

INSERT INTO public.tbvw_maestro_saldos_pershing (
custodian, tipo_reg, client_id, office_id, account_no, name, process_date,
symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity,
market_price, id_currency, currency, market_value, fx_rate,
usde_market_value, comision_devengada_diaria, usde_market_price,
id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo,
total_usde_market_value, id_fee_aplicado, annual_fee, tasa_proteccion, tasa_suracorp, fee_diario, fee_diario_proteccion, fee_diario_sura_corp,
ingreso_proteccion, tipo_identificador_cliente
) VALUES ('PERSHING', 'CAJA', '52865290', 'T9O', 'T9O004642', 'GLORIA CRISTINA GONZALEZ OSSA TOD DTD 10/03/2025', '20260306',
'9999246', '9999246', '9999246', 'MONEY', 'Money Market', 'Cash', 0,
1.00000000000000000000, 'USD', 'USD', 0.00000000000000000000, 1.00000000000000000000,
0.00000000000000000000, 0.00000000000000000000, 1.00000000000000000000,
'MONEY', 'MONEY', 'CAJA', 'Money Market y Caja',
null, 3, 0.01500000000000000000, 0.01100000000000000000, 0.00400000000000000000, 0.00004109589041095890, 0.00003013698630136986, 0.00001095890410958904,
(0.00000000000000000000*0.000030136986301369863)::NUMERIC(45,20), 'CC'
);
INSERT INTO public.tbvw_maestro_saldos_pershing (
custodian, tipo_reg, client_id, office_id, account_no, name, process_date,
symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity,
market_price, id_currency, currency, market_value, fx_rate,
usde_market_value, comision_devengada_diaria, usde_market_price,
id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo,
total_usde_market_value, id_fee_aplicado, annual_fee, tasa_proteccion, tasa_suracorp, fee_diario, fee_diario_proteccion, fee_diario_sura_corp,
ingreso_proteccion, tipo_identificador_cliente
) VALUES ('PERSHING', 'CUS', '52865290', 'T9O', 'T9O004642', 'GLORIA CRISTINA GONZALEZ OSSA TOD DTD 10/03/2025', '20260306',
'USD999997', 'USD999997', '', 'CURRENCY', 'U.S.DOLLARS CURRENCY', 'Cash', 87074.4,
1.00000000000000000000, 'USD', 'USD', 87074.40000000000000000000, 1.00000000000000000000,
87074.40000000000000000000, 3.57840000000000000000, 1.00000000000000000000,
'CURRENCY', 'CURRENCY', 'CURRENCY', 'Monedas',
null, 3, 0.01500000000000000000, 0.01100000000000000000, 0.00400000000000000000, 0.00004109589041095890, 0.00003013698630136986, 0.00001095890410958904,
(87074.40000000000000000000*0.000030136986301369863)::NUMERIC(45,20), 'CC'
);
INSERT INTO public.tbvw_maestro_saldos_pershing (
custodian, tipo_reg, client_id, office_id, account_no, name, process_date,
symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity,
market_price, id_currency, currency, market_value, fx_rate,
usde_market_value, comision_devengada_diaria, usde_market_price,
id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo,
total_usde_market_value, id_fee_aplicado, annual_fee, tasa_proteccion, tasa_suracorp, fee_diario, fee_diario_proteccion, fee_diario_sura_corp,
ingreso_proteccion, tipo_identificador_cliente
) VALUES ('PERSHING', 'CUS', '52865290', 'T9O', 'T9O004642', 'GLORIA CRISTINA GONZALEZ OSSA TOD DTD 10/03/2025', '20260307',
'USD999997', 'USD999997', '', 'CURRENCY', 'U.S.DOLLARS CURRENCY', 'Cash', 87074.4,
1.00000000000000000000, 'USD', 'USD', 87074.40000000000000000000, 1.00000000000000000000,
87074.40000000000000000000, 3.57840000000000000000, 1.00000000000000000000,
'CURRENCY', 'CURRENCY', 'CURRENCY', 'Monedas',
null, 3, 0.01500000000000000000, 0.01100000000000000000, 0.00400000000000000000, 0.00004109589041095890, 0.00003013698630136986, 0.00001095890410958904,
(87074.40000000000000000000*0.000030136986301369863)::NUMERIC(45,20), 'CC'
);
INSERT INTO public.tbvw_maestro_saldos_pershing (
custodian, tipo_reg, client_id, office_id, account_no, name, process_date,
symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity,
market_price, id_currency, currency, market_value, fx_rate,
usde_market_value, comision_devengada_diaria, usde_market_price,
id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo,
total_usde_market_value, id_fee_aplicado, annual_fee, tasa_proteccion, tasa_suracorp, fee_diario, fee_diario_proteccion, fee_diario_sura_corp,
ingreso_proteccion, tipo_identificador_cliente
) VALUES ('PERSHING', 'CAJA', '52865290', 'T9O', 'T9O004642', 'GLORIA CRISTINA GONZALEZ OSSA TOD DTD 10/03/2025', '20260307',
'9999246', '9999246', '9999246', 'MONEY', 'Money Market', 'Cash', 0,
1.00000000000000000000, 'USD', 'USD', 0.00000000000000000000, 1.00000000000000000000,
0.00000000000000000000, 0.00000000000000000000, 1.00000000000000000000,
'MONEY', 'MONEY', 'CAJA', 'Money Market y Caja',
null, 3, 0.01500000000000000000, 0.01100000000000000000, 0.00400000000000000000, 0.00004109589041095890, 0.00003013698630136986, 0.00001095890410958904,
(0.00000000000000000000*0.000030136986301369863)::NUMERIC(45,20), 'CC'
);
INSERT INTO public.tbvw_maestro_saldos_pershing (
custodian, tipo_reg, client_id, office_id, account_no, name, process_date,
symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity,
market_price, id_currency, currency, market_value, fx_rate,
usde_market_value, comision_devengada_diaria, usde_market_price,
id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo,
total_usde_market_value, id_fee_aplicado, annual_fee, tasa_proteccion, tasa_suracorp, fee_diario, fee_diario_proteccion, fee_diario_sura_corp,
ingreso_proteccion, tipo_identificador_cliente
) VALUES ('PERSHING', 'CAJA', '52865290', 'T9O', 'T9O004642', 'GLORIA CRISTINA GONZALEZ OSSA TOD DTD 10/03/2025', '20260308',
'9999246', '9999246', '9999246', 'MONEY', 'Money Market', 'Cash', 0,
1.00000000000000000000, 'USD', 'USD', 0.00000000000000000000, 1.00000000000000000000,
0.00000000000000000000, 0.00000000000000000000, 1.00000000000000000000,
'MONEY', 'MONEY', 'CAJA', 'Money Market y Caja',
null, 3, 0.01500000000000000000, 0.01100000000000000000, 0.00400000000000000000, 0.00004109589041095890, 0.00003013698630136986, 0.00001095890410958904,
(0.00000000000000000000*0.000030136986301369863)::NUMERIC(45,20), 'CC'
);
INSERT INTO public.tbvw_maestro_saldos_pershing (
custodian, tipo_reg, client_id, office_id, account_no, name, process_date,
symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity,
market_price, id_currency, currency, market_value, fx_rate,
usde_market_value, comision_devengada_diaria, usde_market_price,
id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo,
total_usde_market_value, id_fee_aplicado, annual_fee, tasa_proteccion, tasa_suracorp, fee_diario, fee_diario_proteccion, fee_diario_sura_corp,
ingreso_proteccion, tipo_identificador_cliente
) VALUES ('PERSHING', 'CUS', '52865290', 'T9O', 'T9O004642', 'GLORIA CRISTINA GONZALEZ OSSA TOD DTD 10/03/2025', '20260308',
'USD999997', 'USD999997', '', 'CURRENCY', 'U.S.DOLLARS CURRENCY', 'Cash', 87074.4,
1.00000000000000000000, 'USD', 'USD', 87074.40000000000000000000, 1.00000000000000000000,
87074.40000000000000000000, 3.57840000000000000000, 1.00000000000000000000,
'CURRENCY', 'CURRENCY', 'CURRENCY', 'Monedas',
null, 3, 0.01500000000000000000, 0.01100000000000000000, 0.00400000000000000000, 0.00004109589041095890, 0.00003013698630136986, 0.00001095890410958904,
(87074.40000000000000000000*0.000030136986301369863)::NUMERIC(45,20), 'CC'
);


--Verificamos que estén
SELECT *
FROM public.tbvw_maestro_saldos_pershing sld
where sld.process_date>='20260306'
and sld.process_date<='20260308'
and sld.account_no='T9O004642'
;   --6 reg.

--Query de cuadratura consolidada contra RIA
select sld.process_date, sld.account_no, count(*), sum(sld.usde_market_value), avg(sld.quantity)
from public.tbvw_maestro_saldos_pershing sld
WHERE process_date >= '20260306'
AND process_date <= '20260308'
AND account_no = 'T9O004642'
group by sld.process_date, sld.account_no
order by sld.process_date, sld.account_no
;

--Actualizamos total_usde_market_value en los 6 registros
UPDATE public.tbvw_maestro_saldos_pershing sld
SET total_usde_market_value = sub.total
FROM (
    SELECT
        process_date,
        account_no,
        SUM(usde_market_value) OVER (PARTITION BY process_date, account_no) AS total,
        ctid
    FROM public.tbvw_maestro_saldos_pershing
    WHERE process_date >= '20260306'
      AND process_date <= '20260308'
      AND account_no = 'T9O004642'
) sub
WHERE sld.ctid = sub.ctid;
--Deben ser 6 registros

SELECT *
FROM public.tbvw_maestro_saldos_pershing sld
where sld.process_date>='20260306'
and sld.process_date<='20260308'
and sld.account_no='T9O004642'
;--Cuadrados los total_usde_market_value


--Verificamos que no esté
SELECT * FROM public.tbvw_maestro_saldos_pershing
where tbvw_maestro_saldos_pershing.account_no='T9O004303'
and tbvw_maestro_saldos_pershing.process_date='20251013'
and tbvw_maestro_saldos_pershing.cusip='F2912T160'
;   --0 reg.

INSERT INTO public.tbvw_maestro_saldos_pershing (
custodian, tipo_reg, client_id, office_id, account_no, name, process_date,
symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity,
market_price, id_currency, currency, market_value, fx_rate,
usde_market_value, comision_devengada_diaria, usde_market_price,
id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo,
total_usde_market_value, id_fee_aplicado, annual_fee, tasa_proteccion, tasa_suracorp, fee_diario, fee_diario_proteccion, fee_diario_sura_corp,
ingreso_proteccion, tipo_identificador_cliente
) VALUES ('PERSHING', 'CUS', '17123390', 'T9O', 'T9O004303', 'MARCO ANTONIO LEON TORRES TOD DTD 09/15/2025', '20251013',
'F2912T160', 'F2912T160', 'FR001400JGH2', 'MTOPLOAD', 'EDR SICAV MILLESIMA SELECT 2028 FUND CLASS CR (H)(USD)', 'Cash', 300.459,
117.19000000000000000000, 'USD', 'USD', 35210.79021000000000000000, 1.00000000000000000000,
35210.79021000000000000000, 1.44701877600000000000, 117.19000000000000000000,
'MTOPLOAD', 'MFOPEN', 'MUTFUND', 'Fondos Mutuos',
null, 3, 0.01500000000000000000, 0.01100000000000000000, 0.00400000000000000000, 0.00004109589041095890, 0.00003013698630136986, 0.00001095890410958904,
(35210.79021000000000000000*0.000030136986301369863)::NUMERIC(45,20), 'CC'
);
--Actualizamos total_usde_market_value
UPDATE public.tbvw_maestro_saldos_pershing sld
SET total_usde_market_value = sub.total
FROM (
    SELECT
        process_date,
        account_no,
        SUM(usde_market_value) OVER (PARTITION BY process_date, account_no) AS total,
        ctid
    FROM public.tbvw_maestro_saldos_pershing
    WHERE process_date = '20251013'
      AND account_no = 'T9O004303'
) sub
WHERE sld.ctid = sub.ctid;
--Debe ser 7 registros

SELECT * FROM public.tbvw_maestro_saldos_pershing
where tbvw_maestro_saldos_pershing.account_no='T9O004303'
and tbvw_maestro_saldos_pershing.process_date='20251013'
and tbvw_maestro_saldos_pershing.cusip='F2912T160'
;   --1 reg.

--========================================================================
--========================================================================
--========================================================================
-- Movimientos





--Cargar estos 3 registros
select * from public.vw_reporte_maestro_datos_movimientos
where vw_reporte_maestro_datos_movimientos.process_date='20251111'
and vw_reporte_maestro_datos_movimientos.account_no='T9N001631'
;
select * from public.vw_reporte_maestro_datos_movimientos
where vw_reporte_maestro_datos_movimientos.process_date='20251013'
and vw_reporte_maestro_datos_movimientos.account_no='T9O004303'
;
select * from public.vw_reporte_maestro_datos_movimientos
where vw_reporte_maestro_datos_movimientos.process_date='20260306'
and vw_reporte_maestro_datos_movimientos.account_no='T9O004642'
;

--Omitir, está ok ya
select * from public.vw_reporte_maestro_datos_movimientos
where vw_reporte_maestro_datos_movimientos.process_date='20260107'
and vw_reporte_maestro_datos_movimientos.account_no='T9O005110'
;



--Verificar que no estén los 3 movimientos a cargar
select * from public.tbvw_maestro_movimientos_pershing mov
where mov.process_date='20251111'
and mov.account_no='T9N001631'
UNION
select * from public.tbvw_maestro_movimientos_pershing mov
where mov.process_date='20251013'
and mov.account_no='T9O004303'
UNION
select * from public.tbvw_maestro_movimientos_pershing mov
where mov.process_date='20260306'
and mov.account_no='T9O004642'
;   --0 reg.

/*
ingreso_egreso= TDE-false; RFF-true; MVI-false
retiro=0
recaudo=0 para FN=0; usde_net_amount para FN=1 (RFF)
tipo_identificador_cliente='CC'
false, 0, 0, 'CC'
*/



INSERT INTO public.tbvw_maestro_movimientos_pershing (
custodian, client_id, office_id, account_no, name, process_date, tipo_reg,
trade_date, settlement_date, activity, buy_sell_code, buy_sell_value, quantity,
price, commission, fees, net_amount,
usde_net_amount, principal, cusip, symbol, isin, currency,
fx_rate, interest, currency_base, cash_margin, product_type,
security_description, activity_description,
activity_code, source_code, description_1, description_2, description_3, ticker,
id_sub_sub_tipo, id_sub_tipo, id_tipo, nombre_sub_sub_tipo, flujo_neto, id_cuenta_custodio,
ingreso_egreso, retiro, recaudo, tipo_identificador_cliente)
VALUES (
'Pershing', '17123390', 'T9O', 'T9O004303', 'MARCO ANTONIO LEON TORRES TOD DTD 09/15/2025', '20251013', 'TDE_INST',
'2025-10-09', '2025-10-14', 'TRADE ENTRY', 'B', 'Buy', 300.45900000000000000000,
117.19000000000000000000, 15.00000000000000000000, 0.00000000000000000000, -35225.79000000000000000000,
-35225.79000000000000000000, 35210.79000000000000000000, 'F2912T160', 'F2912T160       ', 'FR001400JGH2', 'USD',
1.00000000000000000000, 0.00000000000000000000, 'USD', 'Cash', 'MTOPLOAD',
'EDR SICAV MILLESIMA SELECT 2028 FUND CLASS CR (H)(USD)', 'Buy 300.46 SHRS OF ISIN #FR001400JGH2 PRICE: $117.1900 TD:10/09/2025 SD:10/14/2025',
'TDE', 'TDE', 'EDR SICAV MILLESIMA', 'SELECT 2028 FUND', 'CLASS CR (H)(USD)', 'F2912T160       ',
'MTOPLOAD', 'MFOPEN  ', 'MUTFUND ', 'Fondos Mutuos', 0, 'T9O004303',
false, 0, 0, 'CC'
);
INSERT INTO public.tbvw_maestro_movimientos_pershing (
custodian, client_id, office_id, account_no, name, process_date, tipo_reg,
trade_date, settlement_date, activity, buy_sell_code, buy_sell_value, quantity,
price, commission, fees, net_amount,
usde_net_amount, principal, cusip, symbol, isin, currency,
fx_rate, interest, currency_base, cash_margin, product_type,
security_description, activity_description,
activity_code, source_code, description_1, description_2, description_3, ticker,
id_sub_sub_tipo, id_sub_tipo, id_tipo, nombre_sub_sub_tipo, flujo_neto, id_cuenta_custodio,
ingreso_egreso, retiro, recaudo, tipo_identificador_cliente)
VALUES (
'Pershing', '52865290', 'T9O', 'T9O004642', 'GLORIA CRISTINA GONZALEZ OSSA TOD DTD 10/03/2025', '20260306', 'NON_TDE',
'2026-03-06', '2026-03-06', 'FEDERAL FUNDS RECEIVED', ' ', null, 87074.40000000000000000000,
1.00000000000000000000, 0.00000000000000000000, 0.00000000000000000000, 87074.40000000000000000000,
87074.40000000000000000000, 87074.40000000000000000000, 'USD999997', 'USD999997', '            ', 'USD',
1.00000000000000000000, 0.00000000000000000000, 'USD', 'Cash', 'CURRENCY',
'U.S.DOLLARS CURRENCY', 'FEDERAL FUNDS RECEIVED',
'RFF', 'RFF', 'PERSHING LLC', 'UPP260306A478LY5', '', '                ',
'CURRENCY', 'CURRENCY', 'CURRENCY', 'Monedas', 1, 'T9O004642',
true, 0, 87074.40000000000000000000, 'CC'
);
INSERT INTO public.tbvw_maestro_movimientos_pershing (
custodian, client_id, office_id, account_no, name, process_date, tipo_reg,
trade_date, settlement_date, activity, buy_sell_code, buy_sell_value, quantity,
price, commission, fees, net_amount,
usde_net_amount, principal, cusip, symbol, isin, currency,
fx_rate, interest, currency_base, cash_margin, product_type,
security_description, activity_description,
activity_code, source_code, description_1, description_2, description_3, ticker,
id_sub_sub_tipo, id_sub_tipo, id_tipo, nombre_sub_sub_tipo, flujo_neto, id_cuenta_custodio,
ingreso_egreso, retiro, recaudo, tipo_identificador_cliente)
VALUES (
'Pershing', '70073062', 'T9N', 'T9N001631', 'JORGE IGNACIO SALDARRIAGA VELEZ', '20251111', 'NON_TDE',
'2025-11-11', '2025-11-11', 'POSITION ADJUSTMENT INCREASE', ' ', null, 919.08000000000000000000,
1.00000000000000000000, 0.00000000000000000000, 0.00000000000000000000, 919.08000000000000000000,
919.08000000000000000000, 919.08000000000000000000, '433LP3149', '433LP3149       ', '            ', 'USD',
1.00000000000000000000, 0.00000000000000000000, 'USD', 'Cash', 'SUBLP   ',
'HINES GLOBAL INCOME TRUST ICAPITAL OFFSHORE ACCESS FUND SP1', 'POSITION ADJUSTMENT INCREASE',
'MVI', 'MVI', 'HINES GLOBAL INCOME', 'TRUST ICAPITAL', '', '433LP3149       ',
'SUBLP   ', 'SUBLP   ', 'LIMPART ', 'Activos Alternativos', 0, 'T9N001631',
false, 0, 0, 'CC'
);

--Verificar que estén los 3 movimientos ahora
select * from public.tbvw_maestro_movimientos_pershing mov
where mov.process_date='20251111'
and mov.account_no='T9N001631'
UNION
select * from public.tbvw_maestro_movimientos_pershing mov
where mov.process_date='20251013'
and mov.account_no='T9O004303'
UNION
select * from public.tbvw_maestro_movimientos_pershing mov
where mov.process_date='20260306'
and mov.account_no='T9O004642'
;   --3 reg.



-- Reprocesamos retornos, vía web desde 20251001
-- Reprocesamos archivos sin materialización, vía web desde 20251001



--========================================================================
--========================================================================
--========================================================================
-- Parte 2, pendientes descuadre

--Respaldamos
SELECT * INTO zz_backup.tbvw_maestro_saldos_pershing_20260518
FROM public.tbvw_maestro_saldos_pershing
;



/*
Quantity mal pegado por posible re proceso sFL con cusip 433LP3149
quantity, market_value, usde_market_value: 157074.6
*/
SELECT
    tb_sld.row_no, tb_sld.process_date, tb_sld.client_id, tb_sld.account_no,
    tb_sld.symbol, tb_sld.cusip, tb_sld.isin_code,
    tb_sld.quantity, tb_sld.market_price, tb_sld.market_value, tb_sld.fx_rate, tb_sld.usde_market_value, tb_sld.usde_market_price,
    tb_sld.comision_devengada_diaria
FROM public.tbvw_maestro_saldos_pershing tb_sld
WHERE tb_sld.account_no='T9N001631'
and tb_sld.process_date in ('20251112', '20251113')
and tb_sld.cusip='433LP3149'
order by process_date, account_no, symbol, cusip, isin_code, quantity
;

UPDATE public.tbvw_maestro_saldos_pershing tb_sld
SET
    quantity = 157074.6,
    market_value = 157074.6,
    usde_market_value = 157074.6
WHERE tb_sld.account_no='T9N001631'
and tb_sld.process_date in ('20251112', '20251113')
and tb_sld.cusip='433LP3149'
;--2 reg

--Actualizamos total_usde_market_value
UPDATE public.tbvw_maestro_saldos_pershing sld
SET total_usde_market_value = sub.total
FROM (
     SELECT
        row_no, process_date, account_no,
        SUM(usde_market_value) OVER (
            PARTITION BY process_date, account_no
        )::numeric(45,20) AS total
    FROM public.tbvw_maestro_saldos_pershing
    WHERE account_no = 'T9N001631'
      AND process_date IN ('20251112', '20251113')
) sub
WHERE sld.row_no = sub.row_no
AND sld.account_no = 'T9N001631'
AND sld.process_date IN ('20251112', '20251113');

--Reprocesar comisiones/ingresos vía Script SQL -> ok
--Re procesar maestros sin materialización -> ok



--Hacer update desde tabla temporal cargada de RIA
SELECT
    tb_sld.row_no, tb_sld.process_date, tb_sld.client_id, tb_sld.account_no,
    tb_sld.symbol, tb_sld.cusip, tb_sld.isin_code,
    tb_sld.quantity, tb_sld.market_price, tb_sld.market_value, tb_sld.fx_rate, tb_sld.usde_market_value, tb_sld.usde_market_price,
    tb_sld.comision_devengada_diaria
FROM public.tbvw_maestro_saldos_pershing tb_sld
WHERE tb_sld.process_date in ('20251013', '20251111')
and account_no in
('T9N001490', 'T9N001508', 'T9N001599', 'T9N001631', 'T9N001649', 'T9N001656', 'T9N001664', 'T9N001706', 'T9N002019', 'T9N002076', 'T9N002134', 'T9N002167', 'T9N002183', 'T9N002225', 'T9N002324', 'T9N002407', 'T9N002423', 'T9N002431', 'T9N002456', 'T9N002514', 'T9N002589', 'T9O001192', 'T9O001267', 'T9O001275', 'T9O001341', 'T9O001366', 'T9O001374', 'T9O001382', 'T9O001390', 'T9O001408', 'T9O001457', 'T9O001465', 'T9O001473', 'T9O001481', 'T9O001507', 'T9O001515', 'T9O001523', 'T9O001531', 'T9O001556', 'T9O001564', 'T9O001572', 'T9O001580', 'T9O001598', 'T9O001606', 'T9O001614', 'T9O001648', 'T9O001655', 'T9O001705', 'T9O001713', 'T9O001754', 'T9O001796', 'T9O001804', 'T9O001812', 'T9O001820', 'T9O001838', 'T9O001846', 'T9O001853', 'T9O001879', 'T9O001887', 'T9O001895', 'T9O001903', 'T9O001911', 'T9O001929', 'T9O001937', 'T9O001945', 'T9O001952', 'T9O001960', 'T9O001978', 'T9O001994', 'T9O002000', 'T9O002026', 'T9O002034', 'T9O002042', 'T9O002059', 'T9O002067', 'T9O002083', 'T9O002091', 'T9O002117', 'T9O002125', 'T9O002133', 'T9O002158', 'T9O002166', 'T9O002174', 'T9O002182', 'T9O002190', 'T9O002208', 'T9O002216', 'T9O002224', 'T9O002232', 'T9O002240', 'T9O002265', 'T9O002273', 'T9O002281', 'T9O002299', 'T9O002307', 'T9O002315', 'T9O002323', 'T9O002331', 'T9O002364', 'T9O002372', 'T9O002380', 'T9O002398', 'T9O002406', 'T9O002414', 'T9O002422', 'T9O002430', 'T9O002448', 'T9O002471', 'T9O002489', 'T9O002497', 'T9O002505', 'T9O002521', 'T9O002547', 'T9O002554', 'T9O002562', 'T9O002570', 'T9O002588', 'T9O002596', 'T9O002604', 'T9O002620', 'T9O002638', 'T9O002646', 'T9O002653', 'T9O002661', 'T9O002679', 'T9O002687', 'T9O002695', 'T9O002703', 'T9O002711', 'T9O002737', 'T9O002745', 'T9O002752', 'T9O002778', 'T9O002786', 'T9O002794', 'T9O002828', 'T9O002844', 'T9O002851', 'T9O002869', 'T9O002877', 'T9O002885', 'T9O002893', 'T9O002901', 'T9O002919', 'T9O002927', 'T9O002935', 'T9O002943', 'T9O002976', 'T9O002992', 'T9O003024', 'T9O003032', 'T9O003040', 'T9O003057', 'T9O003065', 'T9O003073', 'T9O003099', 'T9O003107', 'T9O003115', 'T9O003123', 'T9O003131', 'T9O003164', 'T9O003172', 'T9O003180', 'T9O003198', 'T9O003206', 'T9O003214', 'T9O003222', 'T9O003230', 'T9O003263', 'T9O003271', 'T9O003297', 'T9O003305', 'T9O003339', 'T9O003347', 'T9O003354', 'T9O003362', 'T9O003370', 'T9O003396', 'T9O003412', 'T9O003420', 'T9O003438', 'T9O003453', 'T9O003461', 'T9O003479', 'T9O003487', 'T9O003495', 'T9O003503', 'T9O003511', 'T9O003529', 'T9O003537', 'T9O003545', 'T9O003560', 'T9O003578', 'T9O003586', 'T9O003602', 'T9O003610', 'T9O003628', 'T9O003636', 'T9O003644', 'T9O003651', 'T9O003669', 'T9O003677', 'T9O003693', 'T9O003701', 'T9O003735', 'T9O003768', 'T9O003784', 'T9O003792', 'T9O003800', 'T9O003818', 'T9O003826', 'T9O003834', 'T9O003859', 'T9O003867', 'T9O003875', 'T9O003883', 'T9O003909', 'T9O003925', 'T9O003933', 'T9O003958', 'T9O003966', 'T9O003974', 'T9O003982', 'T9O003990', 'T9O004006', 'T9O004022', 'T9O004030', 'T9O004055', 'T9O004063', 'T9O004071', 'T9O004089', 'T9O004097', 'T9O004121', 'T9O004139', 'T9O004147', 'T9O004162', 'T9O004170', 'T9O004188', 'T9O004196', 'T9O004204', 'T9O004212', 'T9O004246', 'T9O004253', 'T9O004261', 'T9O004279', 'T9O004287', 'T9O004295', 'T9O004303', 'T9O004311', 'T9O004329', 'T9O004345', 'T9O004378', 'T9O004394', 'T9O004410', 'T9O004428', 'T9O004436', 'T9O004451', 'T9O004477', 'T9O004485', 'T9O004501', 'T9O004519', 'T9O004527', 'T9O004543', 'T9O004550', 'T9O004568', 'T9O004576', 'T9O004584', 'T9O004592', 'T9O004600', 'T9O004618', 'T9O004626', 'T9O004642', 'T9O004659', 'T9O004667', 'T9O004683', 'T9O004691', 'T9O004709', 'T9O004717', 'T9O004766', 'T9O004774', 'T9O004790', 'T9O004808', 'T9O004816', 'T9O004824', 'T9O004832', 'T9O004857', 'T9O004865', 'T9O004881', 'T9O004899', 'T9O004907', 'T9O004915', 'T9O004923', 'T9O004931', 'T9O004964', 'T9O004972', 'T9O004980', 'T9O005011', 'T9O005029', 'T9O005045', 'T9O005052', 'T9O005060', 'T9O005078', 'T9O005086', 'T9O005102', 'T9O005110', 'T9O005128', 'T9O005136', 'T9O005144', 'T9O005151', 'T9O005169', 'T9O005177', 'T9O005219', 'T9O005243', 'T9O005250', 'T9O005268', 'T9O005276', 'T9O005284', 'T9O005292', 'T9O005300', 'T9O005326', 'T9O005359', 'T9O005367', 'T9O005375', 'T9O005417', 'T9O005425', 'T9O005466', 'T9O005482', 'T9O005508', 'T9O005516', 'T9O005540', 'T9O005615', 'T9O005623', 'T9O005631', 'T9O005649', 'T9O005664', 'T9O005672', 'T9O005680', 'T9O005698', 'T9O005714', 'T9O005722', 'T9O005748', 'T9O005755', 'T9O005771', 'T9O005789', 'T9O005797', 'T9O005813', 'T9O005821', 'T9O005839', 'T9O005847', 'T9O005862', 'T9O005870', 'T9O005888', 'T9O005896', 'T9O005904', 'T9O005912', 'T9O005920', 'T9O005938', 'T9O005946', 'T9O005961', 'T9O005995', 'T9O006019', 'T9O006035', 'T9O006043', 'T9O006050', 'T9O006068', 'T9O006076', 'T9O006084', 'T9O006100', 'T9O006118', 'T9O006126', 'T9O006142', 'T9O006159', 'T9O006167', 'T9O006175', 'T9O006183', 'T9O006191', 'T9O006209', 'T9O006217', 'T9O006225', 'T9O006233', 'T9O006258', 'T9O006274', 'T9O006282', 'T9O006290', 'T9O006308', 'T9O006316', 'T9O006324', 'T9O006332', 'T9O006340', 'T9O006357', 'T9O006365', 'T9O006381', 'T9O006407', 'T9O006415', 'T9O006449'
)
order by process_date, account_no, symbol, cusip, isin_code, quantity
;

SELECT
    bk.process_date, bk.client_id, bk.account_no, bk.symbol, bk.cusip, bk.isin_code,
    bk.quantity, bk.market_price, bk.market_value, bk.fx_rate, bk.usde_market_value, bk.usde_market_price
    --, bk.comision_devengada_diaria, bk.row_no
FROM zz_backup.tbvw_maestro_saldos_pershing_from_ria_20260518 bk
;

--Cruzamos ambas tablas
SELECT
    (
            ria.quantity IS DISTINCT FROM prote.quantity
         OR ria.market_price IS DISTINCT FROM prote.market_price
         OR ria.market_value IS DISTINCT FROM prote.market_value
         OR ria.fx_rate IS DISTINCT FROM prote.fx_rate
         OR ria.usde_market_value IS DISTINCT FROM prote.usde_market_value
         OR ria.usde_market_price IS DISTINCT FROM prote.usde_market_price
      )::boolean as are_diff,
    ria.process_date, prote.process_date,
    ria.client_id, prote.client_id,
    ria.account_no, prote.account_no,
    ria.symbol, prote.symbol,
    ria.cusip, prote.cusip,
    ria.isin_code, prote.isin_code,
    ria.quantity, prote.quantity,
    ria.market_price, prote.market_price,
    ria.market_value, prote.market_value,
    ria.fx_rate, prote.fx_rate,
    ria.usde_market_value, prote.usde_market_value,
    ria.usde_market_price, prote.usde_market_price,
    ria.comision_devengada_diaria, prote.comision_devengada_diaria,
    ria.row_no, prote.row_no
FROM
(
    --RIA
    SELECT
        bk.process_date, bk.client_id, bk.account_no, bk.symbol, bk.cusip, bk.isin_code,
        bk.quantity, bk.market_price, bk.market_value, bk.fx_rate, bk.usde_market_value, bk.usde_market_price
        , bk.comision_devengada_diaria, bk.row_no
    FROM zz_backup.tbvw_maestro_saldos_pershing_from_ria_20260518 bk
    order by process_date, account_no, symbol, cusip, isin_code, quantity
) as ria
FULL OUTER JOIN
(
--Prote
    SELECT
        tb_sld.row_no,
        tb_sld.process_date, tb_sld.client_id, tb_sld.account_no,
        tb_sld.symbol, tb_sld.cusip, tb_sld.isin_code,
        tb_sld.quantity, tb_sld.market_price, tb_sld.market_value, tb_sld.fx_rate, tb_sld.usde_market_value, tb_sld.usde_market_price
        ,tb_sld.comision_devengada_diaria
    FROM public.tbvw_maestro_saldos_pershing tb_sld
    WHERE tb_sld.process_date in ('20251013', '20251111')
    and account_no in
    ('T9N001490', 'T9N001508', 'T9N001599', 'T9N001631', 'T9N001649', 'T9N001656', 'T9N001664', 'T9N001706', 'T9N002019', 'T9N002076', 'T9N002134', 'T9N002167', 'T9N002183', 'T9N002225', 'T9N002324', 'T9N002407', 'T9N002423', 'T9N002431', 'T9N002456', 'T9N002514', 'T9N002589', 'T9O001192', 'T9O001267', 'T9O001275', 'T9O001341', 'T9O001366', 'T9O001374', 'T9O001382', 'T9O001390', 'T9O001408', 'T9O001457', 'T9O001465', 'T9O001473', 'T9O001481', 'T9O001507', 'T9O001515', 'T9O001523', 'T9O001531', 'T9O001556', 'T9O001564', 'T9O001572', 'T9O001580', 'T9O001598', 'T9O001606', 'T9O001614', 'T9O001648', 'T9O001655', 'T9O001705', 'T9O001713', 'T9O001754', 'T9O001796', 'T9O001804', 'T9O001812', 'T9O001820', 'T9O001838', 'T9O001846', 'T9O001853', 'T9O001879', 'T9O001887', 'T9O001895', 'T9O001903', 'T9O001911', 'T9O001929', 'T9O001937', 'T9O001945', 'T9O001952', 'T9O001960', 'T9O001978', 'T9O001994', 'T9O002000', 'T9O002026', 'T9O002034', 'T9O002042', 'T9O002059', 'T9O002067', 'T9O002083', 'T9O002091', 'T9O002117', 'T9O002125', 'T9O002133', 'T9O002158', 'T9O002166', 'T9O002174', 'T9O002182', 'T9O002190', 'T9O002208', 'T9O002216', 'T9O002224', 'T9O002232', 'T9O002240', 'T9O002265', 'T9O002273', 'T9O002281', 'T9O002299', 'T9O002307', 'T9O002315', 'T9O002323', 'T9O002331', 'T9O002364', 'T9O002372', 'T9O002380', 'T9O002398', 'T9O002406', 'T9O002414', 'T9O002422', 'T9O002430', 'T9O002448', 'T9O002471', 'T9O002489', 'T9O002497', 'T9O002505', 'T9O002521', 'T9O002547', 'T9O002554', 'T9O002562', 'T9O002570', 'T9O002588', 'T9O002596', 'T9O002604', 'T9O002620', 'T9O002638', 'T9O002646', 'T9O002653', 'T9O002661', 'T9O002679', 'T9O002687', 'T9O002695', 'T9O002703', 'T9O002711', 'T9O002737', 'T9O002745', 'T9O002752', 'T9O002778', 'T9O002786', 'T9O002794', 'T9O002828', 'T9O002844', 'T9O002851', 'T9O002869', 'T9O002877', 'T9O002885', 'T9O002893', 'T9O002901', 'T9O002919', 'T9O002927', 'T9O002935', 'T9O002943', 'T9O002976', 'T9O002992', 'T9O003024', 'T9O003032', 'T9O003040', 'T9O003057', 'T9O003065', 'T9O003073', 'T9O003099', 'T9O003107', 'T9O003115', 'T9O003123', 'T9O003131', 'T9O003164', 'T9O003172', 'T9O003180', 'T9O003198', 'T9O003206', 'T9O003214', 'T9O003222', 'T9O003230', 'T9O003263', 'T9O003271', 'T9O003297', 'T9O003305', 'T9O003339', 'T9O003347', 'T9O003354', 'T9O003362', 'T9O003370', 'T9O003396', 'T9O003412', 'T9O003420', 'T9O003438', 'T9O003453', 'T9O003461', 'T9O003479', 'T9O003487', 'T9O003495', 'T9O003503', 'T9O003511', 'T9O003529', 'T9O003537', 'T9O003545', 'T9O003560', 'T9O003578', 'T9O003586', 'T9O003602', 'T9O003610', 'T9O003628', 'T9O003636', 'T9O003644', 'T9O003651', 'T9O003669', 'T9O003677', 'T9O003693', 'T9O003701', 'T9O003735', 'T9O003768', 'T9O003784', 'T9O003792', 'T9O003800', 'T9O003818', 'T9O003826', 'T9O003834', 'T9O003859', 'T9O003867', 'T9O003875', 'T9O003883', 'T9O003909', 'T9O003925', 'T9O003933', 'T9O003958', 'T9O003966', 'T9O003974', 'T9O003982', 'T9O003990', 'T9O004006', 'T9O004022', 'T9O004030', 'T9O004055', 'T9O004063', 'T9O004071', 'T9O004089', 'T9O004097', 'T9O004121', 'T9O004139', 'T9O004147', 'T9O004162', 'T9O004170', 'T9O004188', 'T9O004196', 'T9O004204', 'T9O004212', 'T9O004246', 'T9O004253', 'T9O004261', 'T9O004279', 'T9O004287', 'T9O004295', 'T9O004303', 'T9O004311', 'T9O004329', 'T9O004345', 'T9O004378', 'T9O004394', 'T9O004410', 'T9O004428', 'T9O004436', 'T9O004451', 'T9O004477', 'T9O004485', 'T9O004501', 'T9O004519', 'T9O004527', 'T9O004543', 'T9O004550', 'T9O004568', 'T9O004576', 'T9O004584', 'T9O004592', 'T9O004600', 'T9O004618', 'T9O004626', 'T9O004642', 'T9O004659', 'T9O004667', 'T9O004683', 'T9O004691', 'T9O004709', 'T9O004717', 'T9O004766', 'T9O004774', 'T9O004790', 'T9O004808', 'T9O004816', 'T9O004824', 'T9O004832', 'T9O004857', 'T9O004865', 'T9O004881', 'T9O004899', 'T9O004907', 'T9O004915', 'T9O004923', 'T9O004931', 'T9O004964', 'T9O004972', 'T9O004980', 'T9O005011', 'T9O005029', 'T9O005045', 'T9O005052', 'T9O005060', 'T9O005078', 'T9O005086', 'T9O005102', 'T9O005110', 'T9O005128', 'T9O005136', 'T9O005144', 'T9O005151', 'T9O005169', 'T9O005177', 'T9O005219', 'T9O005243', 'T9O005250', 'T9O005268', 'T9O005276', 'T9O005284', 'T9O005292', 'T9O005300', 'T9O005326', 'T9O005359', 'T9O005367', 'T9O005375', 'T9O005417', 'T9O005425', 'T9O005466', 'T9O005482', 'T9O005508', 'T9O005516', 'T9O005540', 'T9O005615', 'T9O005623', 'T9O005631', 'T9O005649', 'T9O005664', 'T9O005672', 'T9O005680', 'T9O005698', 'T9O005714', 'T9O005722', 'T9O005748', 'T9O005755', 'T9O005771', 'T9O005789', 'T9O005797', 'T9O005813', 'T9O005821', 'T9O005839', 'T9O005847', 'T9O005862', 'T9O005870', 'T9O005888', 'T9O005896', 'T9O005904', 'T9O005912', 'T9O005920', 'T9O005938', 'T9O005946', 'T9O005961', 'T9O005995', 'T9O006019', 'T9O006035', 'T9O006043', 'T9O006050', 'T9O006068', 'T9O006076', 'T9O006084', 'T9O006100', 'T9O006118', 'T9O006126', 'T9O006142', 'T9O006159', 'T9O006167', 'T9O006175', 'T9O006183', 'T9O006191', 'T9O006209', 'T9O006217', 'T9O006225', 'T9O006233', 'T9O006258', 'T9O006274', 'T9O006282', 'T9O006290', 'T9O006308', 'T9O006316', 'T9O006324', 'T9O006332', 'T9O006340', 'T9O006357', 'T9O006365', 'T9O006381', 'T9O006407', 'T9O006415', 'T9O006449'
    )
    order by process_date, account_no, symbol, cusip, isin_code, quantity
) as prote
ON ria.process_date=prote.process_date
    --and ria.client_id=prote.client_id
    and ria.account_no=prote.account_no
    and ria.symbol=prote.symbol
    and ria.cusip=prote.cusip
    and ria.isin_code=prote.isin_code
WHERE NOT --Iguales: 900 reg.; distintos en algún campos: 1651
     (
            ria.quantity IS DISTINCT FROM prote.quantity
         OR ria.market_price IS DISTINCT FROM prote.market_price
         OR ria.market_value IS DISTINCT FROM prote.market_value
         OR ria.fx_rate IS DISTINCT FROM prote.fx_rate
         OR ria.usde_market_value IS DISTINCT FROM prote.usde_market_value
         OR ria.usde_market_price IS DISTINCT FROM prote.usde_market_price
      )
;
--Obtenemos cantidad de registros que cruzan en tabla de respaldo
SELECT
        --tb_sld.row_no,
        tb_sld.process_date, tb_sld.client_id, tb_sld.account_no,
        tb_sld.symbol, tb_sld.cusip, tb_sld.isin_code,
        tb_sld.quantity, tb_sld.market_price, tb_sld.market_value, tb_sld.fx_rate, tb_sld.usde_market_value, tb_sld.usde_market_price
        ,tb_sld.comision_devengada_diaria,
         (
            select count(*) FROM zz_backup.tbvw_maestro_saldos_pershing_from_ria_20260518 bk
            WHERE bk.process_date=tb_sld.process_date
                --Tienen distintos client id RIA/Prote
            --AND NULLIF(upper(trim(bk.client_id)), '')    IS NOT DISTINCT FROM NULLIF(upper(trim(tb_sld.client_id)), '')
            AND NULLIF(upper(trim(bk.account_no)), '')    IS NOT DISTINCT FROM NULLIF(upper(trim(tb_sld.account_no)), '')
            AND NULLIF(upper(trim(bk.symbol)), '')    IS NOT DISTINCT FROM NULLIF(upper(trim(tb_sld.symbol)), '')
          AND NULLIF(upper(trim(bk.cusip)), '')     IS NOT DISTINCT FROM NULLIF(upper(trim(tb_sld.cusip)), '')
          AND NULLIF(upper(trim(bk.isin_code)), '') IS NOT DISTINCT FROM NULLIF(upper(trim(tb_sld.isin_code)), '')
            )
    FROM public.tbvw_maestro_saldos_pershing tb_sld
    WHERE tb_sld.process_date in ('20251013', '20251111')
    and account_no in
    ('T9N001490', 'T9N001508', 'T9N001599', 'T9N001631', 'T9N001649', 'T9N001656', 'T9N001664', 'T9N001706', 'T9N002019', 'T9N002076', 'T9N002134', 'T9N002167', 'T9N002183', 'T9N002225', 'T9N002324', 'T9N002407', 'T9N002423', 'T9N002431', 'T9N002456', 'T9N002514', 'T9N002589', 'T9O001192', 'T9O001267', 'T9O001275', 'T9O001341', 'T9O001366', 'T9O001374', 'T9O001382', 'T9O001390', 'T9O001408', 'T9O001457', 'T9O001465', 'T9O001473', 'T9O001481', 'T9O001507', 'T9O001515', 'T9O001523', 'T9O001531', 'T9O001556', 'T9O001564', 'T9O001572', 'T9O001580', 'T9O001598', 'T9O001606', 'T9O001614', 'T9O001648', 'T9O001655', 'T9O001705', 'T9O001713', 'T9O001754', 'T9O001796', 'T9O001804', 'T9O001812', 'T9O001820', 'T9O001838', 'T9O001846', 'T9O001853', 'T9O001879', 'T9O001887', 'T9O001895', 'T9O001903', 'T9O001911', 'T9O001929', 'T9O001937', 'T9O001945', 'T9O001952', 'T9O001960', 'T9O001978', 'T9O001994', 'T9O002000', 'T9O002026', 'T9O002034', 'T9O002042', 'T9O002059', 'T9O002067', 'T9O002083', 'T9O002091', 'T9O002117', 'T9O002125', 'T9O002133', 'T9O002158', 'T9O002166', 'T9O002174', 'T9O002182', 'T9O002190', 'T9O002208', 'T9O002216', 'T9O002224', 'T9O002232', 'T9O002240', 'T9O002265', 'T9O002273', 'T9O002281', 'T9O002299', 'T9O002307', 'T9O002315', 'T9O002323', 'T9O002331', 'T9O002364', 'T9O002372', 'T9O002380', 'T9O002398', 'T9O002406', 'T9O002414', 'T9O002422', 'T9O002430', 'T9O002448', 'T9O002471', 'T9O002489', 'T9O002497', 'T9O002505', 'T9O002521', 'T9O002547', 'T9O002554', 'T9O002562', 'T9O002570', 'T9O002588', 'T9O002596', 'T9O002604', 'T9O002620', 'T9O002638', 'T9O002646', 'T9O002653', 'T9O002661', 'T9O002679', 'T9O002687', 'T9O002695', 'T9O002703', 'T9O002711', 'T9O002737', 'T9O002745', 'T9O002752', 'T9O002778', 'T9O002786', 'T9O002794', 'T9O002828', 'T9O002844', 'T9O002851', 'T9O002869', 'T9O002877', 'T9O002885', 'T9O002893', 'T9O002901', 'T9O002919', 'T9O002927', 'T9O002935', 'T9O002943', 'T9O002976', 'T9O002992', 'T9O003024', 'T9O003032', 'T9O003040', 'T9O003057', 'T9O003065', 'T9O003073', 'T9O003099', 'T9O003107', 'T9O003115', 'T9O003123', 'T9O003131', 'T9O003164', 'T9O003172', 'T9O003180', 'T9O003198', 'T9O003206', 'T9O003214', 'T9O003222', 'T9O003230', 'T9O003263', 'T9O003271', 'T9O003297', 'T9O003305', 'T9O003339', 'T9O003347', 'T9O003354', 'T9O003362', 'T9O003370', 'T9O003396', 'T9O003412', 'T9O003420', 'T9O003438', 'T9O003453', 'T9O003461', 'T9O003479', 'T9O003487', 'T9O003495', 'T9O003503', 'T9O003511', 'T9O003529', 'T9O003537', 'T9O003545', 'T9O003560', 'T9O003578', 'T9O003586', 'T9O003602', 'T9O003610', 'T9O003628', 'T9O003636', 'T9O003644', 'T9O003651', 'T9O003669', 'T9O003677', 'T9O003693', 'T9O003701', 'T9O003735', 'T9O003768', 'T9O003784', 'T9O003792', 'T9O003800', 'T9O003818', 'T9O003826', 'T9O003834', 'T9O003859', 'T9O003867', 'T9O003875', 'T9O003883', 'T9O003909', 'T9O003925', 'T9O003933', 'T9O003958', 'T9O003966', 'T9O003974', 'T9O003982', 'T9O003990', 'T9O004006', 'T9O004022', 'T9O004030', 'T9O004055', 'T9O004063', 'T9O004071', 'T9O004089', 'T9O004097', 'T9O004121', 'T9O004139', 'T9O004147', 'T9O004162', 'T9O004170', 'T9O004188', 'T9O004196', 'T9O004204', 'T9O004212', 'T9O004246', 'T9O004253', 'T9O004261', 'T9O004279', 'T9O004287', 'T9O004295', 'T9O004303', 'T9O004311', 'T9O004329', 'T9O004345', 'T9O004378', 'T9O004394', 'T9O004410', 'T9O004428', 'T9O004436', 'T9O004451', 'T9O004477', 'T9O004485', 'T9O004501', 'T9O004519', 'T9O004527', 'T9O004543', 'T9O004550', 'T9O004568', 'T9O004576', 'T9O004584', 'T9O004592', 'T9O004600', 'T9O004618', 'T9O004626', 'T9O004642', 'T9O004659', 'T9O004667', 'T9O004683', 'T9O004691', 'T9O004709', 'T9O004717', 'T9O004766', 'T9O004774', 'T9O004790', 'T9O004808', 'T9O004816', 'T9O004824', 'T9O004832', 'T9O004857', 'T9O004865', 'T9O004881', 'T9O004899', 'T9O004907', 'T9O004915', 'T9O004923', 'T9O004931', 'T9O004964', 'T9O004972', 'T9O004980', 'T9O005011', 'T9O005029', 'T9O005045', 'T9O005052', 'T9O005060', 'T9O005078', 'T9O005086', 'T9O005102', 'T9O005110', 'T9O005128', 'T9O005136', 'T9O005144', 'T9O005151', 'T9O005169', 'T9O005177', 'T9O005219', 'T9O005243', 'T9O005250', 'T9O005268', 'T9O005276', 'T9O005284', 'T9O005292', 'T9O005300', 'T9O005326', 'T9O005359', 'T9O005367', 'T9O005375', 'T9O005417', 'T9O005425', 'T9O005466', 'T9O005482', 'T9O005508', 'T9O005516', 'T9O005540', 'T9O005615', 'T9O005623', 'T9O005631', 'T9O005649', 'T9O005664', 'T9O005672', 'T9O005680', 'T9O005698', 'T9O005714', 'T9O005722', 'T9O005748', 'T9O005755', 'T9O005771', 'T9O005789', 'T9O005797', 'T9O005813', 'T9O005821', 'T9O005839', 'T9O005847', 'T9O005862', 'T9O005870', 'T9O005888', 'T9O005896', 'T9O005904', 'T9O005912', 'T9O005920', 'T9O005938', 'T9O005946', 'T9O005961', 'T9O005995', 'T9O006019', 'T9O006035', 'T9O006043', 'T9O006050', 'T9O006068', 'T9O006076', 'T9O006084', 'T9O006100', 'T9O006118', 'T9O006126', 'T9O006142', 'T9O006159', 'T9O006167', 'T9O006175', 'T9O006183', 'T9O006191', 'T9O006209', 'T9O006217', 'T9O006225', 'T9O006233', 'T9O006258', 'T9O006274', 'T9O006282', 'T9O006290', 'T9O006308', 'T9O006316', 'T9O006324', 'T9O006332', 'T9O006340', 'T9O006357', 'T9O006365', 'T9O006381', 'T9O006407', 'T9O006415', 'T9O006449'
    )
    order by process_date, account_no, symbol, cusip, isin_code, quantity
;

--Query de update
UPDATE public.tbvw_maestro_saldos_pershing tb_sld
SET
    quantity          = calc.quantity_bk,
    market_price      = calc.market_price_bk,
    market_value      = calc.market_value_bk,
    fx_rate           = calc.fx_rate_bk,
    usde_market_value = calc.usde_market_value_bk,
    usde_market_price = calc.usde_market_price_bk
FROM
(
    SELECT
        tb_sld.row_no,

        tb_sld.process_date,
        tb_sld.client_id        AS client_id_actual,
        bk.client_id            AS client_id_bk,

        tb_sld.account_no,
        tb_sld.symbol,
        tb_sld.cusip,
        tb_sld.isin_code,

        tb_sld.quantity         AS quantity_actual,
        bk.quantity             AS quantity_bk,

        tb_sld.market_price     AS market_price_actual,
        bk.market_price         AS market_price_bk,

        tb_sld.market_value     AS market_value_actual,
        bk.market_value         AS market_value_bk,

        tb_sld.fx_rate          AS fx_rate_actual,
        bk.fx_rate              AS fx_rate_bk,

        tb_sld.usde_market_value AS usde_market_value_actual,
        bk.usde_market_value     AS usde_market_value_bk,

        tb_sld.usde_market_price AS usde_market_price_actual,
        bk.usde_market_price     AS usde_market_price_bk

    FROM public.tbvw_maestro_saldos_pershing tb_sld
    JOIN zz_backup.tbvw_maestro_saldos_pershing_from_ria_20260518 bk
      ON bk.process_date = tb_sld.process_date
     AND bk.account_no   = tb_sld.account_no
     AND upper(trim(bk.symbol))    = upper(trim(tb_sld.symbol))
     AND upper(trim(bk.cusip))     = upper(trim(tb_sld.cusip))
     AND upper(trim(bk.isin_code)) = upper(trim(tb_sld.isin_code))

    WHERE tb_sld.process_date IN ('20251013', '20251111')
      AND tb_sld.account_no IN
      ('T9N001490', 'T9N001508', 'T9N001599', 'T9N001631', 'T9N001649', 'T9N001656', 'T9N001664', 'T9N001706', 'T9N002019', 'T9N002076', 'T9N002134', 'T9N002167', 'T9N002183', 'T9N002225', 'T9N002324', 'T9N002407', 'T9N002423', 'T9N002431', 'T9N002456', 'T9N002514', 'T9N002589', 'T9O001192', 'T9O001267', 'T9O001275', 'T9O001341', 'T9O001366', 'T9O001374', 'T9O001382', 'T9O001390', 'T9O001408', 'T9O001457', 'T9O001465', 'T9O001473', 'T9O001481', 'T9O001507', 'T9O001515', 'T9O001523', 'T9O001531', 'T9O001556', 'T9O001564', 'T9O001572', 'T9O001580', 'T9O001598', 'T9O001606', 'T9O001614', 'T9O001648', 'T9O001655', 'T9O001705', 'T9O001713', 'T9O001754', 'T9O001796', 'T9O001804', 'T9O001812', 'T9O001820', 'T9O001838', 'T9O001846', 'T9O001853', 'T9O001879', 'T9O001887', 'T9O001895', 'T9O001903', 'T9O001911', 'T9O001929', 'T9O001937', 'T9O001945', 'T9O001952', 'T9O001960', 'T9O001978', 'T9O001994', 'T9O002000', 'T9O002026', 'T9O002034', 'T9O002042', 'T9O002059', 'T9O002067', 'T9O002083', 'T9O002091', 'T9O002117', 'T9O002125', 'T9O002133', 'T9O002158', 'T9O002166', 'T9O002174', 'T9O002182', 'T9O002190', 'T9O002208', 'T9O002216', 'T9O002224', 'T9O002232', 'T9O002240', 'T9O002265', 'T9O002273', 'T9O002281', 'T9O002299', 'T9O002307', 'T9O002315', 'T9O002323', 'T9O002331', 'T9O002364', 'T9O002372', 'T9O002380', 'T9O002398', 'T9O002406', 'T9O002414', 'T9O002422', 'T9O002430', 'T9O002448', 'T9O002471', 'T9O002489', 'T9O002497', 'T9O002505', 'T9O002521', 'T9O002547', 'T9O002554', 'T9O002562', 'T9O002570', 'T9O002588', 'T9O002596', 'T9O002604', 'T9O002620', 'T9O002638', 'T9O002646', 'T9O002653', 'T9O002661', 'T9O002679', 'T9O002687', 'T9O002695', 'T9O002703', 'T9O002711', 'T9O002737', 'T9O002745', 'T9O002752', 'T9O002778', 'T9O002786', 'T9O002794', 'T9O002828', 'T9O002844', 'T9O002851', 'T9O002869', 'T9O002877', 'T9O002885', 'T9O002893', 'T9O002901', 'T9O002919', 'T9O002927', 'T9O002935', 'T9O002943', 'T9O002976', 'T9O002992', 'T9O003024', 'T9O003032', 'T9O003040', 'T9O003057', 'T9O003065', 'T9O003073', 'T9O003099', 'T9O003107', 'T9O003115', 'T9O003123', 'T9O003131', 'T9O003164', 'T9O003172', 'T9O003180', 'T9O003198', 'T9O003206', 'T9O003214', 'T9O003222', 'T9O003230', 'T9O003263', 'T9O003271', 'T9O003297', 'T9O003305', 'T9O003339', 'T9O003347', 'T9O003354', 'T9O003362', 'T9O003370', 'T9O003396', 'T9O003412', 'T9O003420', 'T9O003438', 'T9O003453', 'T9O003461', 'T9O003479', 'T9O003487', 'T9O003495', 'T9O003503', 'T9O003511', 'T9O003529', 'T9O003537', 'T9O003545', 'T9O003560', 'T9O003578', 'T9O003586', 'T9O003602', 'T9O003610', 'T9O003628', 'T9O003636', 'T9O003644', 'T9O003651', 'T9O003669', 'T9O003677', 'T9O003693', 'T9O003701', 'T9O003735', 'T9O003768', 'T9O003784', 'T9O003792', 'T9O003800', 'T9O003818', 'T9O003826', 'T9O003834', 'T9O003859', 'T9O003867', 'T9O003875', 'T9O003883', 'T9O003909', 'T9O003925', 'T9O003933', 'T9O003958', 'T9O003966', 'T9O003974', 'T9O003982', 'T9O003990', 'T9O004006', 'T9O004022', 'T9O004030', 'T9O004055', 'T9O004063', 'T9O004071', 'T9O004089', 'T9O004097', 'T9O004121', 'T9O004139', 'T9O004147', 'T9O004162', 'T9O004170', 'T9O004188', 'T9O004196', 'T9O004204', 'T9O004212', 'T9O004246', 'T9O004253', 'T9O004261', 'T9O004279', 'T9O004287', 'T9O004295', 'T9O004303', 'T9O004311', 'T9O004329', 'T9O004345', 'T9O004378', 'T9O004394', 'T9O004410', 'T9O004428', 'T9O004436', 'T9O004451', 'T9O004477', 'T9O004485', 'T9O004501', 'T9O004519', 'T9O004527', 'T9O004543', 'T9O004550', 'T9O004568', 'T9O004576', 'T9O004584', 'T9O004592', 'T9O004600', 'T9O004618', 'T9O004626', 'T9O004642', 'T9O004659', 'T9O004667', 'T9O004683', 'T9O004691', 'T9O004709', 'T9O004717', 'T9O004766', 'T9O004774', 'T9O004790', 'T9O004808', 'T9O004816', 'T9O004824', 'T9O004832', 'T9O004857', 'T9O004865', 'T9O004881', 'T9O004899', 'T9O004907', 'T9O004915', 'T9O004923', 'T9O004931', 'T9O004964', 'T9O004972', 'T9O004980', 'T9O005011', 'T9O005029', 'T9O005045', 'T9O005052', 'T9O005060', 'T9O005078', 'T9O005086', 'T9O005102', 'T9O005110', 'T9O005128', 'T9O005136', 'T9O005144', 'T9O005151', 'T9O005169', 'T9O005177', 'T9O005219', 'T9O005243', 'T9O005250', 'T9O005268', 'T9O005276', 'T9O005284', 'T9O005292', 'T9O005300', 'T9O005326', 'T9O005359', 'T9O005367', 'T9O005375', 'T9O005417', 'T9O005425', 'T9O005466', 'T9O005482', 'T9O005508', 'T9O005516', 'T9O005540', 'T9O005615', 'T9O005623', 'T9O005631', 'T9O005649', 'T9O005664', 'T9O005672', 'T9O005680', 'T9O005698', 'T9O005714', 'T9O005722', 'T9O005748', 'T9O005755', 'T9O005771', 'T9O005789', 'T9O005797', 'T9O005813', 'T9O005821', 'T9O005839', 'T9O005847', 'T9O005862', 'T9O005870', 'T9O005888', 'T9O005896', 'T9O005904', 'T9O005912', 'T9O005920', 'T9O005938', 'T9O005946', 'T9O005961', 'T9O005995', 'T9O006019', 'T9O006035', 'T9O006043', 'T9O006050', 'T9O006068', 'T9O006076', 'T9O006084', 'T9O006100', 'T9O006118', 'T9O006126', 'T9O006142', 'T9O006159', 'T9O006167', 'T9O006175', 'T9O006183', 'T9O006191', 'T9O006209', 'T9O006217', 'T9O006225', 'T9O006233', 'T9O006258', 'T9O006274', 'T9O006282', 'T9O006290', 'T9O006308', 'T9O006316', 'T9O006324', 'T9O006332', 'T9O006340', 'T9O006357', 'T9O006365', 'T9O006381', 'T9O006407', 'T9O006415', 'T9O006449'
    )
      AND (
            tb_sld.quantity IS DISTINCT FROM bk.quantity
         OR tb_sld.market_price IS DISTINCT FROM bk.market_price
         OR tb_sld.market_value IS DISTINCT FROM bk.market_value
         OR tb_sld.fx_rate IS DISTINCT FROM bk.fx_rate
         OR tb_sld.usde_market_value IS DISTINCT FROM bk.usde_market_value
         OR tb_sld.usde_market_price IS DISTINCT FROM bk.usde_market_price
      )

) calc
WHERE tb_sld.row_no = calc.row_no;
--1651 reg.


--Actualizamos el total_usde_market_value
UPDATE public.tbvw_maestro_saldos_pershing sld
SET total_usde_market_value = sub.total
FROM (
     SELECT
        row_no, process_date, account_no,
        SUM(usde_market_value) OVER (
            PARTITION BY process_date, account_no
        )::numeric(45,20) AS total
    FROM public.tbvw_maestro_saldos_pershing
    WHERE process_date in ('20251013', '20251111')
    and account_no in
    ('T9N001490', 'T9N001508', 'T9N001599', 'T9N001631', 'T9N001649', 'T9N001656', 'T9N001664', 'T9N001706', 'T9N002019', 'T9N002076', 'T9N002134', 'T9N002167', 'T9N002183', 'T9N002225', 'T9N002324', 'T9N002407', 'T9N002423', 'T9N002431', 'T9N002456', 'T9N002514', 'T9N002589', 'T9O001192', 'T9O001267', 'T9O001275', 'T9O001341', 'T9O001366', 'T9O001374', 'T9O001382', 'T9O001390', 'T9O001408', 'T9O001457', 'T9O001465', 'T9O001473', 'T9O001481', 'T9O001507', 'T9O001515', 'T9O001523', 'T9O001531', 'T9O001556', 'T9O001564', 'T9O001572', 'T9O001580', 'T9O001598', 'T9O001606', 'T9O001614', 'T9O001648', 'T9O001655', 'T9O001705', 'T9O001713', 'T9O001754', 'T9O001796', 'T9O001804', 'T9O001812', 'T9O001820', 'T9O001838', 'T9O001846', 'T9O001853', 'T9O001879', 'T9O001887', 'T9O001895', 'T9O001903', 'T9O001911', 'T9O001929', 'T9O001937', 'T9O001945', 'T9O001952', 'T9O001960', 'T9O001978', 'T9O001994', 'T9O002000', 'T9O002026', 'T9O002034', 'T9O002042', 'T9O002059', 'T9O002067', 'T9O002083', 'T9O002091', 'T9O002117', 'T9O002125', 'T9O002133', 'T9O002158', 'T9O002166', 'T9O002174', 'T9O002182', 'T9O002190', 'T9O002208', 'T9O002216', 'T9O002224', 'T9O002232', 'T9O002240', 'T9O002265', 'T9O002273', 'T9O002281', 'T9O002299', 'T9O002307', 'T9O002315', 'T9O002323', 'T9O002331', 'T9O002364', 'T9O002372', 'T9O002380', 'T9O002398', 'T9O002406', 'T9O002414', 'T9O002422', 'T9O002430', 'T9O002448', 'T9O002471', 'T9O002489', 'T9O002497', 'T9O002505', 'T9O002521', 'T9O002547', 'T9O002554', 'T9O002562', 'T9O002570', 'T9O002588', 'T9O002596', 'T9O002604', 'T9O002620', 'T9O002638', 'T9O002646', 'T9O002653', 'T9O002661', 'T9O002679', 'T9O002687', 'T9O002695', 'T9O002703', 'T9O002711', 'T9O002737', 'T9O002745', 'T9O002752', 'T9O002778', 'T9O002786', 'T9O002794', 'T9O002828', 'T9O002844', 'T9O002851', 'T9O002869', 'T9O002877', 'T9O002885', 'T9O002893', 'T9O002901', 'T9O002919', 'T9O002927', 'T9O002935', 'T9O002943', 'T9O002976', 'T9O002992', 'T9O003024', 'T9O003032', 'T9O003040', 'T9O003057', 'T9O003065', 'T9O003073', 'T9O003099', 'T9O003107', 'T9O003115', 'T9O003123', 'T9O003131', 'T9O003164', 'T9O003172', 'T9O003180', 'T9O003198', 'T9O003206', 'T9O003214', 'T9O003222', 'T9O003230', 'T9O003263', 'T9O003271', 'T9O003297', 'T9O003305', 'T9O003339', 'T9O003347', 'T9O003354', 'T9O003362', 'T9O003370', 'T9O003396', 'T9O003412', 'T9O003420', 'T9O003438', 'T9O003453', 'T9O003461', 'T9O003479', 'T9O003487', 'T9O003495', 'T9O003503', 'T9O003511', 'T9O003529', 'T9O003537', 'T9O003545', 'T9O003560', 'T9O003578', 'T9O003586', 'T9O003602', 'T9O003610', 'T9O003628', 'T9O003636', 'T9O003644', 'T9O003651', 'T9O003669', 'T9O003677', 'T9O003693', 'T9O003701', 'T9O003735', 'T9O003768', 'T9O003784', 'T9O003792', 'T9O003800', 'T9O003818', 'T9O003826', 'T9O003834', 'T9O003859', 'T9O003867', 'T9O003875', 'T9O003883', 'T9O003909', 'T9O003925', 'T9O003933', 'T9O003958', 'T9O003966', 'T9O003974', 'T9O003982', 'T9O003990', 'T9O004006', 'T9O004022', 'T9O004030', 'T9O004055', 'T9O004063', 'T9O004071', 'T9O004089', 'T9O004097', 'T9O004121', 'T9O004139', 'T9O004147', 'T9O004162', 'T9O004170', 'T9O004188', 'T9O004196', 'T9O004204', 'T9O004212', 'T9O004246', 'T9O004253', 'T9O004261', 'T9O004279', 'T9O004287', 'T9O004295', 'T9O004303', 'T9O004311', 'T9O004329', 'T9O004345', 'T9O004378', 'T9O004394', 'T9O004410', 'T9O004428', 'T9O004436', 'T9O004451', 'T9O004477', 'T9O004485', 'T9O004501', 'T9O004519', 'T9O004527', 'T9O004543', 'T9O004550', 'T9O004568', 'T9O004576', 'T9O004584', 'T9O004592', 'T9O004600', 'T9O004618', 'T9O004626', 'T9O004642', 'T9O004659', 'T9O004667', 'T9O004683', 'T9O004691', 'T9O004709', 'T9O004717', 'T9O004766', 'T9O004774', 'T9O004790', 'T9O004808', 'T9O004816', 'T9O004824', 'T9O004832', 'T9O004857', 'T9O004865', 'T9O004881', 'T9O004899', 'T9O004907', 'T9O004915', 'T9O004923', 'T9O004931', 'T9O004964', 'T9O004972', 'T9O004980', 'T9O005011', 'T9O005029', 'T9O005045', 'T9O005052', 'T9O005060', 'T9O005078', 'T9O005086', 'T9O005102', 'T9O005110', 'T9O005128', 'T9O005136', 'T9O005144', 'T9O005151', 'T9O005169', 'T9O005177', 'T9O005219', 'T9O005243', 'T9O005250', 'T9O005268', 'T9O005276', 'T9O005284', 'T9O005292', 'T9O005300', 'T9O005326', 'T9O005359', 'T9O005367', 'T9O005375', 'T9O005417', 'T9O005425', 'T9O005466', 'T9O005482', 'T9O005508', 'T9O005516', 'T9O005540', 'T9O005615', 'T9O005623', 'T9O005631', 'T9O005649', 'T9O005664', 'T9O005672', 'T9O005680', 'T9O005698', 'T9O005714', 'T9O005722', 'T9O005748', 'T9O005755', 'T9O005771', 'T9O005789', 'T9O005797', 'T9O005813', 'T9O005821', 'T9O005839', 'T9O005847', 'T9O005862', 'T9O005870', 'T9O005888', 'T9O005896', 'T9O005904', 'T9O005912', 'T9O005920', 'T9O005938', 'T9O005946', 'T9O005961', 'T9O005995', 'T9O006019', 'T9O006035', 'T9O006043', 'T9O006050', 'T9O006068', 'T9O006076', 'T9O006084', 'T9O006100', 'T9O006118', 'T9O006126', 'T9O006142', 'T9O006159', 'T9O006167', 'T9O006175', 'T9O006183', 'T9O006191', 'T9O006209', 'T9O006217', 'T9O006225', 'T9O006233', 'T9O006258', 'T9O006274', 'T9O006282', 'T9O006290', 'T9O006308', 'T9O006316', 'T9O006324', 'T9O006332', 'T9O006340', 'T9O006357', 'T9O006365', 'T9O006381', 'T9O006407', 'T9O006415', 'T9O006449'
    )
) sub
WHERE sld.row_no = sub.row_no
and sld.process_date in ('20251013', '20251111')
    and sld.account_no in
    ('T9N001490', 'T9N001508', 'T9N001599', 'T9N001631', 'T9N001649', 'T9N001656', 'T9N001664', 'T9N001706', 'T9N002019', 'T9N002076', 'T9N002134', 'T9N002167', 'T9N002183', 'T9N002225', 'T9N002324', 'T9N002407', 'T9N002423', 'T9N002431', 'T9N002456', 'T9N002514', 'T9N002589', 'T9O001192', 'T9O001267', 'T9O001275', 'T9O001341', 'T9O001366', 'T9O001374', 'T9O001382', 'T9O001390', 'T9O001408', 'T9O001457', 'T9O001465', 'T9O001473', 'T9O001481', 'T9O001507', 'T9O001515', 'T9O001523', 'T9O001531', 'T9O001556', 'T9O001564', 'T9O001572', 'T9O001580', 'T9O001598', 'T9O001606', 'T9O001614', 'T9O001648', 'T9O001655', 'T9O001705', 'T9O001713', 'T9O001754', 'T9O001796', 'T9O001804', 'T9O001812', 'T9O001820', 'T9O001838', 'T9O001846', 'T9O001853', 'T9O001879', 'T9O001887', 'T9O001895', 'T9O001903', 'T9O001911', 'T9O001929', 'T9O001937', 'T9O001945', 'T9O001952', 'T9O001960', 'T9O001978', 'T9O001994', 'T9O002000', 'T9O002026', 'T9O002034', 'T9O002042', 'T9O002059', 'T9O002067', 'T9O002083', 'T9O002091', 'T9O002117', 'T9O002125', 'T9O002133', 'T9O002158', 'T9O002166', 'T9O002174', 'T9O002182', 'T9O002190', 'T9O002208', 'T9O002216', 'T9O002224', 'T9O002232', 'T9O002240', 'T9O002265', 'T9O002273', 'T9O002281', 'T9O002299', 'T9O002307', 'T9O002315', 'T9O002323', 'T9O002331', 'T9O002364', 'T9O002372', 'T9O002380', 'T9O002398', 'T9O002406', 'T9O002414', 'T9O002422', 'T9O002430', 'T9O002448', 'T9O002471', 'T9O002489', 'T9O002497', 'T9O002505', 'T9O002521', 'T9O002547', 'T9O002554', 'T9O002562', 'T9O002570', 'T9O002588', 'T9O002596', 'T9O002604', 'T9O002620', 'T9O002638', 'T9O002646', 'T9O002653', 'T9O002661', 'T9O002679', 'T9O002687', 'T9O002695', 'T9O002703', 'T9O002711', 'T9O002737', 'T9O002745', 'T9O002752', 'T9O002778', 'T9O002786', 'T9O002794', 'T9O002828', 'T9O002844', 'T9O002851', 'T9O002869', 'T9O002877', 'T9O002885', 'T9O002893', 'T9O002901', 'T9O002919', 'T9O002927', 'T9O002935', 'T9O002943', 'T9O002976', 'T9O002992', 'T9O003024', 'T9O003032', 'T9O003040', 'T9O003057', 'T9O003065', 'T9O003073', 'T9O003099', 'T9O003107', 'T9O003115', 'T9O003123', 'T9O003131', 'T9O003164', 'T9O003172', 'T9O003180', 'T9O003198', 'T9O003206', 'T9O003214', 'T9O003222', 'T9O003230', 'T9O003263', 'T9O003271', 'T9O003297', 'T9O003305', 'T9O003339', 'T9O003347', 'T9O003354', 'T9O003362', 'T9O003370', 'T9O003396', 'T9O003412', 'T9O003420', 'T9O003438', 'T9O003453', 'T9O003461', 'T9O003479', 'T9O003487', 'T9O003495', 'T9O003503', 'T9O003511', 'T9O003529', 'T9O003537', 'T9O003545', 'T9O003560', 'T9O003578', 'T9O003586', 'T9O003602', 'T9O003610', 'T9O003628', 'T9O003636', 'T9O003644', 'T9O003651', 'T9O003669', 'T9O003677', 'T9O003693', 'T9O003701', 'T9O003735', 'T9O003768', 'T9O003784', 'T9O003792', 'T9O003800', 'T9O003818', 'T9O003826', 'T9O003834', 'T9O003859', 'T9O003867', 'T9O003875', 'T9O003883', 'T9O003909', 'T9O003925', 'T9O003933', 'T9O003958', 'T9O003966', 'T9O003974', 'T9O003982', 'T9O003990', 'T9O004006', 'T9O004022', 'T9O004030', 'T9O004055', 'T9O004063', 'T9O004071', 'T9O004089', 'T9O004097', 'T9O004121', 'T9O004139', 'T9O004147', 'T9O004162', 'T9O004170', 'T9O004188', 'T9O004196', 'T9O004204', 'T9O004212', 'T9O004246', 'T9O004253', 'T9O004261', 'T9O004279', 'T9O004287', 'T9O004295', 'T9O004303', 'T9O004311', 'T9O004329', 'T9O004345', 'T9O004378', 'T9O004394', 'T9O004410', 'T9O004428', 'T9O004436', 'T9O004451', 'T9O004477', 'T9O004485', 'T9O004501', 'T9O004519', 'T9O004527', 'T9O004543', 'T9O004550', 'T9O004568', 'T9O004576', 'T9O004584', 'T9O004592', 'T9O004600', 'T9O004618', 'T9O004626', 'T9O004642', 'T9O004659', 'T9O004667', 'T9O004683', 'T9O004691', 'T9O004709', 'T9O004717', 'T9O004766', 'T9O004774', 'T9O004790', 'T9O004808', 'T9O004816', 'T9O004824', 'T9O004832', 'T9O004857', 'T9O004865', 'T9O004881', 'T9O004899', 'T9O004907', 'T9O004915', 'T9O004923', 'T9O004931', 'T9O004964', 'T9O004972', 'T9O004980', 'T9O005011', 'T9O005029', 'T9O005045', 'T9O005052', 'T9O005060', 'T9O005078', 'T9O005086', 'T9O005102', 'T9O005110', 'T9O005128', 'T9O005136', 'T9O005144', 'T9O005151', 'T9O005169', 'T9O005177', 'T9O005219', 'T9O005243', 'T9O005250', 'T9O005268', 'T9O005276', 'T9O005284', 'T9O005292', 'T9O005300', 'T9O005326', 'T9O005359', 'T9O005367', 'T9O005375', 'T9O005417', 'T9O005425', 'T9O005466', 'T9O005482', 'T9O005508', 'T9O005516', 'T9O005540', 'T9O005615', 'T9O005623', 'T9O005631', 'T9O005649', 'T9O005664', 'T9O005672', 'T9O005680', 'T9O005698', 'T9O005714', 'T9O005722', 'T9O005748', 'T9O005755', 'T9O005771', 'T9O005789', 'T9O005797', 'T9O005813', 'T9O005821', 'T9O005839', 'T9O005847', 'T9O005862', 'T9O005870', 'T9O005888', 'T9O005896', 'T9O005904', 'T9O005912', 'T9O005920', 'T9O005938', 'T9O005946', 'T9O005961', 'T9O005995', 'T9O006019', 'T9O006035', 'T9O006043', 'T9O006050', 'T9O006068', 'T9O006076', 'T9O006084', 'T9O006100', 'T9O006118', 'T9O006126', 'T9O006142', 'T9O006159', 'T9O006167', 'T9O006175', 'T9O006183', 'T9O006191', 'T9O006209', 'T9O006217', 'T9O006225', 'T9O006233', 'T9O006258', 'T9O006274', 'T9O006282', 'T9O006290', 'T9O006308', 'T9O006316', 'T9O006324', 'T9O006332', 'T9O006340', 'T9O006357', 'T9O006365', 'T9O006381', 'T9O006407', 'T9O006415', 'T9O006449'
    )
;

--Reprocesar comisiones/ingresos vía Script SQL -> ok
--Re procesar maestros sin materialización -> ok

