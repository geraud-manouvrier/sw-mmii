create or replace function stage_pershing.fn_extrae_acct_reg_b(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, ibd_number character varying, campo_6 character varying, ip_number character varying, account_short_name character varying, campo_9 character varying, tax_id_type character varying, tax_id_number character varying, date_tax_id_applied_for character varying, w_8_w_9_indicator character varying, w_8_w_9_date_signed character varying, w_8_w_9_effective_date character varying, w_8_w_9_document_type character varying, tax_status character varying, b_notice_reason_code character varying, first_b_notice_status character varying, date_first_b_notice_status_issued_enforced character varying, campo_21 character varying, date_first_notice_status_satisfied character varying, second_b_notice_status character varying, date_second_b_notice_status_issued_enforced character varying, campo_25 character varying, date_second_b_notice_status_satisfied character varying, c_notice_status character varying, date_c_notice_status_issued_enforced character varying, date_c_notice_status_satisfied character varying, old_account_number character varying, original_account_open_date character varying, unidentified_large_trader_id character varying, campo_33 character varying, large_trader_type_code character varying, large_trader_type_last_change_date character varying, campo_36 character varying, campo_37 character varying, initial_source_of_funds_other character varying, finance_away character varying, account_funding_date character varying, campo_41 character varying, statement_currency_code character varying, future_statement_currency_code character varying, future_statement_currency_code_effective_date character varying, account_level_routing_code_1 character varying, account_level_routing_code_2 character varying, account_level_routing_code_3 character varying, account_level_routing_code_4 character varying, campo_49 character varying, self_directed_ind character varying, digital_advice_ind character varying, pte_account_ind character varying, campo_53 character varying, first_ip character varying, second_ip character varying, third_ip character varying, fourth_ip character varying, fifth_ip character varying, sixth_ip character varying, seventh_ip character varying, eighth_ip character varying, ninth_ip character varying, tenth_ip character varying, alert_im_acornym character varying, alert_im_access_code character varying, broker_acronym character varying, cross_reference_indicator character varying, bny_trust_indicator character varying, source_of_asset_at_acct_opening character varying, commission_doscount_code character varying, external_account_number character varying, confirmation_suppression_indicator character varying, date_last_mail_sent character varying, date_last_mail_sent_outside character varying, campo_75 character varying, fully_paid_lending_agreement_indicator character varying, fully_paid_lending_agreement_date character varying, custodian_account_type character varying, mifid_customer_categorization character varying, cash_management_tran_code character varying, sweep_status_indicator character varying, date_sweep_activated character varying, date_sweep_details_changed character varying, cober_margin_debit_indicator character varying, campo_85 character varying, first_fund_sweep_account_id character varying, firstfund_sweep_account_percent character varying, first_fundsweep_account_redemption_priority character varying, second_fund_sweep_account_id character varying, second_fund_sweep_account_percent character varying, second_fundsweep_account_redemption_priority character varying, type_of_bank_account character varying, banklink_aba_number character varying, banklink_dda_number character varying, campo_95 character varying, fund_bank_indicator character varying, campo_97 character varying, w_9_corp_tax_classification_code character varying, campo_99 character varying, combined_margin_acct_indicator character varying, pledge_collateral_account_indicator character varying, finra_institutional_account_code character varying, proposed_account_reference_id character varying, advisor_model_id character varying, firm_model_style_id character varying, campo_106 character varying, campo_107 character varying, campo_108 character varying, dvp_restriction_code character varying, dvp_restriction_exp_date character varying, escheatment_withholding_ind character varying, campo_112 character varying, source_of_origination character varying, source_of_persona character varying, client_onboarding_method character varying, tax_filing_code character varying, campo_117 character varying, campo_118 character varying, nor_purpose_collateral_acct_ind character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 9)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 21, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 24, 1)::VARCHAR(100) as campo_6,
        substr(sfl_file.linea, 25, 4)::VARCHAR(100) as ip_number,
        substr(sfl_file.linea, 29, 10)::VARCHAR(100) as account_short_name,
        substr(sfl_file.linea, 39, 2)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 41, 1)::VARCHAR(100) as tax_id_type,
        substr(sfl_file.linea, 42, 9)::VARCHAR(100) as tax_id_number,
        substr(sfl_file.linea, 51, 8)::VARCHAR(100) as date_tax_id_applied_for,
        substr(sfl_file.linea, 59, 2)::VARCHAR(100) as w_8_w_9_indicator,
        substr(sfl_file.linea, 61, 8)::VARCHAR(100) as w_8_w_9_date_signed,
        substr(sfl_file.linea, 69, 8)::VARCHAR(100) as w_8_w_9_effective_date,
        substr(sfl_file.linea, 77, 4)::VARCHAR(100) as w_8_w_9_document_type,
        substr(sfl_file.linea, 81, 1)::VARCHAR(100) as tax_status,
        substr(sfl_file.linea, 82, 1)::VARCHAR(100) as b_notice_reason_code,
        substr(sfl_file.linea, 83, 20)::VARCHAR(100) as first_b_notice_status,
        substr(sfl_file.linea, 103, 8)::VARCHAR(100) as date_first_b_notice_status_issued_enforced,
        substr(sfl_file.linea, 111, 8)::VARCHAR(100) as campo_21,
        substr(sfl_file.linea, 119, 8)::VARCHAR(100) as date_first_notice_status_satisfied,
        substr(sfl_file.linea, 127, 20)::VARCHAR(100) as second_b_notice_status,
        substr(sfl_file.linea, 147, 8)::VARCHAR(100) as date_second_b_notice_status_issued_enforced,
        substr(sfl_file.linea, 155, 8)::VARCHAR(100) as campo_25,
        substr(sfl_file.linea, 163, 8)::VARCHAR(100) as date_second_b_notice_status_satisfied,
        substr(sfl_file.linea, 171, 20)::VARCHAR(100) as c_notice_status,
        substr(sfl_file.linea, 191, 8)::VARCHAR(100) as date_c_notice_status_issued_enforced,
        substr(sfl_file.linea, 199, 8)::VARCHAR(100) as date_c_notice_status_satisfied,
        substr(sfl_file.linea, 207, 20)::VARCHAR(100) as old_account_number,
        substr(sfl_file.linea, 227, 8)::VARCHAR(100) as original_account_open_date,
        substr(sfl_file.linea, 235, 13)::VARCHAR(100) as unidentified_large_trader_id,
        substr(sfl_file.linea, 248, 2)::VARCHAR(100) as campo_33,
        substr(sfl_file.linea, 250, 2)::VARCHAR(100) as large_trader_type_code,
        substr(sfl_file.linea, 252, 8)::VARCHAR(100) as large_trader_type_last_change_date,
        substr(sfl_file.linea, 260, 13)::VARCHAR(100) as campo_36,
        substr(sfl_file.linea, 273, 14)::VARCHAR(100) as campo_37,
        substr(sfl_file.linea, 287, 30)::VARCHAR(100) as initial_source_of_funds_other,
        substr(sfl_file.linea, 317, 1)::VARCHAR(100) as finance_away,
        substr(sfl_file.linea, 318, 8)::VARCHAR(100) as account_funding_date,
        substr(sfl_file.linea, 326, 7)::VARCHAR(100) as campo_41,
        substr(sfl_file.linea, 333, 3)::VARCHAR(100) as statement_currency_code,
        substr(sfl_file.linea, 336, 3)::VARCHAR(100) as future_statement_currency_code,
        substr(sfl_file.linea, 339, 8)::VARCHAR(100) as future_statement_currency_code_effective_date,
        substr(sfl_file.linea, 347, 3)::VARCHAR(100) as account_level_routing_code_1,
        substr(sfl_file.linea, 350, 3)::VARCHAR(100) as account_level_routing_code_2,
        substr(sfl_file.linea, 353, 3)::VARCHAR(100) as account_level_routing_code_3,
        substr(sfl_file.linea, 356, 3)::VARCHAR(100) as account_level_routing_code_4,
        substr(sfl_file.linea, 359, 1)::VARCHAR(100) as campo_49,
        substr(sfl_file.linea, 360, 1)::VARCHAR(100) as self_directed_ind,
        substr(sfl_file.linea, 361, 1)::VARCHAR(100) as digital_advice_ind,
        substr(sfl_file.linea, 362, 1)::VARCHAR(100) as pte_account_ind,
        substr(sfl_file.linea, 363, 8)::VARCHAR(100) as campo_53,
        substr(sfl_file.linea, 371, 3)::VARCHAR(100) as first_ip,
        substr(sfl_file.linea, 374, 3)::VARCHAR(100) as second_ip,
        substr(sfl_file.linea, 377, 3)::VARCHAR(100) as third_ip,
        substr(sfl_file.linea, 380, 3)::VARCHAR(100) as fourth_ip,
        substr(sfl_file.linea, 383, 3)::VARCHAR(100) as fifth_ip,
        substr(sfl_file.linea, 386, 3)::VARCHAR(100) as sixth_ip,
        substr(sfl_file.linea, 389, 3)::VARCHAR(100) as seventh_ip,
        substr(sfl_file.linea, 392, 3)::VARCHAR(100) as eighth_ip,
        substr(sfl_file.linea, 395, 3)::VARCHAR(100) as ninth_ip,
        substr(sfl_file.linea, 398, 3)::VARCHAR(100) as tenth_ip,
        substr(sfl_file.linea, 401, 8)::VARCHAR(100) as alert_im_acornym,
        substr(sfl_file.linea, 409, 16)::VARCHAR(100) as alert_im_access_code,
        substr(sfl_file.linea, 425, 8)::VARCHAR(100) as broker_acronym,
        substr(sfl_file.linea, 433, 1)::VARCHAR(100) as cross_reference_indicator,
        substr(sfl_file.linea, 434, 1)::VARCHAR(100) as bny_trust_indicator,
        substr(sfl_file.linea, 435, 2)::VARCHAR(100) as source_of_asset_at_acct_opening,
        substr(sfl_file.linea, 437, 1)::VARCHAR(100) as commission_doscount_code,
        substr(sfl_file.linea, 438, 20)::VARCHAR(100) as external_account_number,
        substr(sfl_file.linea, 458, 1)::VARCHAR(100) as confirmation_suppression_indicator,
        substr(sfl_file.linea, 459, 6)::VARCHAR(100) as date_last_mail_sent,
        substr(sfl_file.linea, 465, 6)::VARCHAR(100) as date_last_mail_sent_outside,
        substr(sfl_file.linea, 471, 1)::VARCHAR(100) as campo_75,
        substr(sfl_file.linea, 472, 1)::VARCHAR(100) as fully_paid_lending_agreement_indicator,
        substr(sfl_file.linea, 473, 8)::VARCHAR(100) as fully_paid_lending_agreement_date,
        substr(sfl_file.linea, 481, 4)::VARCHAR(100) as custodian_account_type,
        substr(sfl_file.linea, 485, 4)::VARCHAR(100) as mifid_customer_categorization,
        substr(sfl_file.linea, 489, 1)::VARCHAR(100) as cash_management_tran_code,
        substr(sfl_file.linea, 490, 4)::VARCHAR(100) as sweep_status_indicator,
        substr(sfl_file.linea, 494, 8)::VARCHAR(100) as date_sweep_activated,
        substr(sfl_file.linea, 502, 8)::VARCHAR(100) as date_sweep_details_changed,
        substr(sfl_file.linea, 510, 1)::VARCHAR(100) as cober_margin_debit_indicator,
        substr(sfl_file.linea, 511, 1)::VARCHAR(100) as campo_85,
        substr(sfl_file.linea, 512, 7)::VARCHAR(100) as first_fund_sweep_account_id,
        substr(sfl_file.linea, 519, 18)::VARCHAR(100) as firstfund_sweep_account_percent,
        substr(sfl_file.linea, 537, 1)::VARCHAR(100) as first_fundsweep_account_redemption_priority,
        substr(sfl_file.linea, 538, 7)::VARCHAR(100) as second_fund_sweep_account_id,
        substr(sfl_file.linea, 545, 18)::VARCHAR(100) as second_fund_sweep_account_percent,
        substr(sfl_file.linea, 563, 1)::VARCHAR(100) as second_fundsweep_account_redemption_priority,
        substr(sfl_file.linea, 564, 1)::VARCHAR(100) as type_of_bank_account,
        substr(sfl_file.linea, 565, 9)::VARCHAR(100) as banklink_aba_number,
        substr(sfl_file.linea, 574, 17)::VARCHAR(100) as banklink_dda_number,
        substr(sfl_file.linea, 591, 3)::VARCHAR(100) as campo_95,
        substr(sfl_file.linea, 594, 1)::VARCHAR(100) as fund_bank_indicator,
        substr(sfl_file.linea, 595, 36)::VARCHAR(100) as campo_97,
        substr(sfl_file.linea, 631, 4)::VARCHAR(100) as w_9_corp_tax_classification_code,
        substr(sfl_file.linea, 635, 1)::VARCHAR(100) as campo_99,
        substr(sfl_file.linea, 636, 1)::VARCHAR(100) as combined_margin_acct_indicator,
        substr(sfl_file.linea, 637, 1)::VARCHAR(100) as pledge_collateral_account_indicator,
        substr(sfl_file.linea, 638, 4)::VARCHAR(100) as finra_institutional_account_code,
        substr(sfl_file.linea, 642, 6)::VARCHAR(100) as proposed_account_reference_id,
        substr(sfl_file.linea, 648, 12)::VARCHAR(100) as advisor_model_id,
        substr(sfl_file.linea, 660, 6)::VARCHAR(100) as firm_model_style_id,
        substr(sfl_file.linea, 666, 20)::VARCHAR(100) as campo_106,
        substr(sfl_file.linea, 686, 13)::VARCHAR(100) as campo_107,
        substr(sfl_file.linea, 699, 12)::VARCHAR(100) as campo_108,
        substr(sfl_file.linea, 711, 1)::VARCHAR(100) as dvp_restriction_code,
        substr(sfl_file.linea, 712, 8)::VARCHAR(100) as dvp_restriction_exp_date,
        substr(sfl_file.linea, 720, 2)::VARCHAR(100) as escheatment_withholding_ind,
        substr(sfl_file.linea, 722, 1)::VARCHAR(100) as campo_112,
        substr(sfl_file.linea, 723, 4)::VARCHAR(100) as source_of_origination,
        substr(sfl_file.linea, 727, 4)::VARCHAR(100) as source_of_persona,
        substr(sfl_file.linea, 731, 4)::VARCHAR(100) as client_onboarding_method,
        substr(sfl_file.linea, 735, 4)::VARCHAR(100) as tax_filing_code,
        substr(sfl_file.linea, 739, 6)::VARCHAR(100) as campo_117,
        substr(sfl_file.linea, 745, 4)::VARCHAR(100) as campo_118,
        substr(sfl_file.linea, 749, 1)::VARCHAR(100) as nor_purpose_collateral_acct_ind,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CIB'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_acct_reg_b(bigint) owner to postgres;

