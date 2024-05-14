create or replace function stage_pershing.fn_parse_acct_reg_a(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_a
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
        fn_reg.transaction_type::VARCHAR(100),
        fn_reg.autotitled_usertitled_account::VARCHAR(100),
        fn_reg.account_type_code::VARCHAR(100),
        fn_reg.registration_type::VARCHAR(100),
        fn_reg.campo_14::VARCHAR(100),
        fn_reg.number_of_account_title_lines::VARCHAR(100),
        fn_reg.account_registration_line_1::VARCHAR(100),
        fn_reg.account_registration_line_2::VARCHAR(100),
        fn_reg.account_registration_line_3::VARCHAR(100),
        fn_reg.account_registration_line_4::VARCHAR(100),
        fn_reg.account_registration_line_5::VARCHAR(100),
        fn_reg.account_registration_line_6::VARCHAR(100),
        fn_reg.registration_type_detail::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_account_opened, 'CCYYMMDD')::DATE as date_account_opened,
        public.fn_fecha_string_to_date(fn_reg.date_account_information_updated, 'CCYYMMDD')::DATE as date_account_information_updated,
        fn_reg.account_status_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.pending_closed_date, 'CCYYMMDD')::DATE as pending_closed_date,
        public.fn_fecha_string_to_date(fn_reg.date_account_closed, 'CCYYMMDD')::DATE as date_account_closed,
        public.fn_fecha_string_to_date(fn_reg.closing_notice_date, 'CCYYMMDD')::DATE as closing_notice_date,
        public.fn_fecha_string_to_date(fn_reg.account_reactivated_date, 'CCYYMMDD')::DATE as account_reactivated_date,
        public.fn_fecha_string_to_date(fn_reg.date_account_reopened, 'CCYYMMDD')::DATE as date_account_reopened,
        fn_reg.proceeds::VARCHAR(100),
        fn_reg.transfer_instructions::VARCHAR(100),
        fn_reg.income_isntructions::VARCHAR(100),
        fn_reg.number_of_confirms_for_thi_account::VARCHAR(100),
        fn_reg.number_of_statements_for_this_account::VARCHAR(100),
        fn_reg.investment_objetive_trans_code::VARCHAR(100),
        fn_reg.comments_act::VARCHAR(100),
        fn_reg.employer_shotname::VARCHAR(100),
        fn_reg.employers_cusip::VARCHAR(100),
        fn_reg.employers_symbol::VARCHAR(100),
        fn_reg.margin_privileges_revoked::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.statement_review_date, 'CCYYMMDD')::DATE as statement_review_date,
        fn_reg.margin_papers_on_file::VARCHAR(100),
        fn_reg.option_papers_on_file::VARCHAR(100),
        fn_reg.campo_45::VARCHAR(100),
        fn_reg.good_faith_margin::VARCHAR(100),
        fn_reg.ip_discretion_granted::VARCHAR(100),
        fn_reg.invest_advisor_discretion_granted::VARCHAR(100),
        fn_reg.third_party_discretion_granted::VARCHAR(100),
        fn_reg.third_party_name::VARCHAR(100),
        fn_reg.risk_factor_code::VARCHAR(100),
        fn_reg.investment_objetive_code::VARCHAR(100),
        fn_reg.option_equities::VARCHAR(100),
        fn_reg.option_index::VARCHAR(100),
        fn_reg.option_debt::VARCHAR(100),
        fn_reg.option_currency::VARCHAR(100),
        fn_reg.option_level_1::VARCHAR(100),
        fn_reg.option_level_2::VARCHAR(100),
        fn_reg.option_level_3::VARCHAR(100),
        fn_reg.option_level_4::VARCHAR(100),
        CASE WHEN trim(fn_reg.option_call_limits)='' THEN NULL ELSE fn_reg.option_call_limits END::int as option_call_limits,
        CASE WHEN trim(fn_reg.option_put_limits)='' THEN NULL ELSE fn_reg.option_put_limits END::int as option_put_limits,
        CASE WHEN trim(fn_reg.option_total_limits_of_puts_and_calls)='' THEN NULL ELSE fn_reg.option_total_limits_of_puts_and_calls END::int as option_total_limits_of_puts_and_calls,
        fn_reg.non_us_dollar_trading::VARCHAR(100),
        fn_reg.campo_65::VARCHAR(100),
        fn_reg.non_customer_indicator::VARCHAR(100),
        fn_reg.third_party_fee_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.third_party_fee_approval_date, 'CCYYMMDD')::DATE as third_party_fee_approval_date,
        fn_reg.intermediary_account_ind::VARCHAR(100),
        fn_reg.commission_schedule::VARCHAR(100),
        fn_reg.group_index::VARCHAR(100),
        fn_reg.money_manager_id::VARCHAR(100),
        fn_reg.money_manager_objective_id::VARCHAR(100),
        fn_reg.dtc_id_confirm_number::VARCHAR(100),
        fn_reg.caps_master_mnemonic::VARCHAR(100),
        fn_reg.employee_id::VARCHAR(100),
        fn_reg.prime_broker_free_fund_indicator::VARCHAR(100),
        fn_reg.fee_based_account_indicator::VARCHAR(100),
        fn_reg.campo_79::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.fee_based_termination_date, 'CCYYMMDD')::DATE as fee_based_termination_date,
        fn_reg.campo_81::VARCHAR(100),
        fn_reg.plan_name::VARCHAR(100),
        fn_reg.self_directed_401_k_account_type::VARCHAR(100),
        fn_reg.plan_type::VARCHAR(100),
        fn_reg.plan_number::VARCHAR(100),
        fn_reg.employee_or_employee_relative::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(fn_reg.commission_percent_discount, 9)::NUMERIC(45,20) as commission_percent_discount,
        fn_reg.ind_12_b_1_fee_blocking::VARCHAR(100),
        fn_reg.name_of_ip_signed_new_account_form::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_of_ip_signed_new_account_form, 'CCYYMMDD')::DATE as date_of_ip_signed_new_account_form,
        fn_reg.name_of_principal_signed_new_account_form::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_of_principal_signed_new_account_form, 'CCYYMMDD')::DATE as date_of_principal_signed_new_account_form,
        fn_reg.politically_exposed_person::VARCHAR(100),
        fn_reg.private_banking_account::VARCHAR(100),
        fn_reg.foreign_bank_account::VARCHAR(100),
        fn_reg.initial_source_of_funds::VARCHAR(100),
        fn_reg.usa_patriot_act_exempt_reason::VARCHAR(100),
        fn_reg.primary_country_of_citizenship::VARCHAR(100),
        fn_reg.country_of_residence::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.birth_date, 'CCYYMMDD')::DATE as birth_date,
        fn_reg.age_based_fund_roll_exempt::VARCHAR(100),
        fn_reg.money_fundreform_retail::VARCHAR(100),
        fn_reg.trusted_contact_status::VARCHAR(100),
        fn_reg.regulatory_account_type_category::VARCHAR(100),
        fn_reg.account_managed_by_trust_comp_id::VARCHAR(100),
        fn_reg.voting_auth::VARCHAR(100),
        fn_reg.campo_107::VARCHAR(100),
        fn_reg.campo_108::VARCHAR(100),
        fn_reg.campo_109::VARCHAR(100),
        fn_reg.campo_110::VARCHAR(100),
        fn_reg.customer_type::VARCHAR(100),
        fn_reg.campo_112::VARCHAR(100),
        fn_reg.campo_113::VARCHAR(100),
        fn_reg.campo_114::VARCHAR(100),
        fn_reg.campo_115::VARCHAR(100),
        fn_reg.campo_116::VARCHAR(100),
        fn_reg.fulfillment_method::VARCHAR(100),
        fn_reg.credit_interest_indicator::VARCHAR(100),
        fn_reg.ama_indicator::VARCHAR(100),
        fn_reg.campo_120::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_a(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_acct_reg_a(bigint) owner to postgres;
