create table zz_backup.tbvw_maestro_cuentas_pershing_20241017
(
    id                                            bigint,
    custodian                                     varchar(100),
    id_interno_cliente                            integer,
    client_id                                     varchar(100),
    name                                          varchar(100),
    id_tipo_identificador_cliente                 integer,
    tipo_identificador_cliente                    varchar(100),
    glosa_identificador_cliente                   varchar(100),
    id_interno_cuenta                             integer,
    id_custodio                                   varchar(100),
    id_cuenta_custodio                            varchar(100),
    habilitado                                    boolean,
    ibd_number                                    varchar(100),
    id_office                                     text,
    ip_number                                     varchar(100),
    account_no                                    varchar(100),
    id_proceso                                    bigint,
    process_date                                  varchar(100),
    record_id_sequence_number                     integer,
    account_short_name                            varchar(100),
    full_name                                     varchar(100),
    full_address                                  varchar(100),
    transaction_type                              varchar(100),
    autotitled_usertitled_account                 varchar(100),
    account_type_code                             varchar(100),
    registration_type                             varchar(100),
    registration_type_value                       varchar(1000),
    number_of_account_title_lines                 varchar(100),
    account_registration_line_1                   varchar(100),
    account_registration_line_2                   varchar(100),
    account_registration_line_3                   varchar(100),
    account_registration_line_4                   varchar(100),
    account_registration_line_5                   varchar(100),
    account_registration_line_6                   varchar(100),
    registration_type_detail                      varchar(100),
    date_account_opened                           date,
    date_account_information_updated              date,
    account_status_indicator                      varchar(100),
    pending_closed_date                           date,
    date_account_closed                           date,
    closing_notice_date                           date,
    account_reactivated_date                      date,
    date_account_reopened                         date,
    proceeds                                      varchar(100),
    transfer_instructions                         varchar(100),
    income_isntructions                           varchar(100),
    number_of_confirms_for_thi_account            varchar(100),
    number_of_statements_for_this_account         varchar(100),
    investment_objetive_trans_code                varchar(100),
    comments_act                                  varchar(100),
    employer_shotname                             varchar(100),
    employers_cusip                               varchar(100),
    employers_symbol                              varchar(100),
    margin_privileges_revoked                     varchar(100),
    statement_review_date                         date,
    margin_papers_on_file                         varchar(100),
    cash_margin_account                           varchar(100),
    option_papers_on_file                         varchar(100),
    good_faith_margin                             varchar(100),
    ip_discretion_granted                         varchar(100),
    invest_advisor_discretion_granted             varchar(100),
    invest_advisor_discretion_granted_value       varchar,
    third_party_discretion_granted                varchar(100),
    third_party_name                              varchar(100),
    risk_factor_code                              varchar(100),
    investment_objetive_code                      varchar(100),
    option_equities                               varchar(100),
    option_index                                  varchar(100),
    option_debt                                   varchar(100),
    option_currency                               varchar(100),
    option_level_1                                varchar(100),
    option_level_2                                varchar(100),
    option_level_3                                varchar(100),
    option_level_4                                varchar(100),
    option_call_limits                            integer,
    option_put_limits                             integer,
    option_total_limits_of_puts_and_calls         integer,
    non_us_dollar_trading                         varchar(100),
    non_customer_indicator                        varchar(100),
    third_party_fee_indicator                     varchar(100),
    third_party_fee_approval_date                 date,
    intermediary_account_ind                      varchar(100),
    commission_schedule                           varchar(100),
    group_index                                   varchar(100),
    money_manager_id                              varchar(100),
    money_manager_objective_id                    varchar(100),
    dtc_id_confirm_number                         varchar(100),
    caps_master_mnemonic                          varchar(100),
    employee_id                                   varchar(100),
    prime_broker_free_fund_indicator              varchar(100),
    fee_based_account_indicator                   varchar(100),
    fee_based_termination_date                    date,
    plan_name                                     varchar(100),
    self_directed_401_k_account_type              varchar(100),
    plan_type                                     varchar(100),
    plan_number                                   varchar(100),
    employee_or_employee_relative                 varchar(100),
    commission_percent_discount                   numeric(45, 20),
    ind_12_b_1_fee_blocking                       varchar(100),
    name_of_ip_signed_new_account_form            varchar(100),
    date_of_ip_signed_new_account_form            date,
    name_of_principal_signed_new_account_form     varchar(100),
    date_of_principal_signed_new_account_form     date,
    politically_exposed_person                    varchar(100),
    private_banking_account                       varchar(100),
    foreign_bank_account                          varchar(100),
    initial_source_of_funds                       varchar(100),
    usa_patriot_act_exempt_reason                 varchar(100),
    country_of_citizenship_code                   varchar(100),
    country_of_citizenship_value                  varchar(1000),
    country_of_residence_code                     varchar(100),
    country_of_residence_value                    varchar(1000),
    birth_date                                    date,
    age_based_fund_roll_exempt                    varchar(100),
    money_fundreform_retail                       varchar(100),
    trusted_contact_status                        varchar(100),
    regulatory_account_type_category              varchar(100),
    account_managed_by_trust_comp_id              varchar(100),
    voting_auth                                   varchar(100),
    customer_type                                 varchar(100),
    fulfillment_method                            varchar(100),
    credit_interest_indicator                     varchar(100),
    ama_indicator                                 varchar(100),
    ama_indicator_value                           text,
    tax_id_type                                   varchar(100),
    tax_id_number                                 varchar(100),
    date_tax_id_applied_for                       date,
    w_8_w_9_indicator                             varchar(100),
    w_8_w_9_date_signed                           date,
    w_8_w_9_effective_date                        date,
    w_8_w_9_document_type                         varchar(100),
    w_8_date_signed                               date,
    w_8_effective_date                            date,
    w_9_date_signed                               date,
    w_9_effective_date                            date,
    tax_status                                    varchar(100),
    b_notice_reason_code                          varchar(100),
    first_b_notice_status                         varchar(100),
    date_first_b_notice_status_issued_enforced    date,
    date_first_notice_status_satisfied            date,
    second_b_notice_status                        varchar(100),
    date_second_b_notice_status_issued_enforced   date,
    date_second_b_notice_status_satisfied         date,
    c_notice_status                               varchar(100),
    date_c_notice_status_issued_enforced          date,
    date_c_notice_status_satisfied                date,
    old_account_number                            varchar(100),
    original_account_open_date                    date,
    unidentified_large_trader_id                  varchar(100),
    large_trader_type_code                        varchar(100),
    large_trader_type_last_change_date            date,
    initial_source_of_funds_other                 varchar(100),
    finance_away                                  varchar(100),
    account_funding_date                          date,
    statement_currency_code                       varchar(100),
    future_statement_currency_code                varchar(100),
    future_statement_currency_code_effective_date date,
    account_level_routing_code_1                  varchar(100),
    account_level_routing_code_2                  varchar(100),
    account_level_routing_code_3                  varchar(100),
    account_level_routing_code_4                  varchar(100),
    self_directed_ind                             varchar(100),
    digital_advice_ind                            varchar(100),
    pte_account_ind                               varchar(100),
    first_ip                                      varchar(100),
    second_ip                                     varchar(100),
    third_ip                                      varchar(100),
    fourth_ip                                     varchar(100),
    fifth_ip                                      varchar(100),
    sixth_ip                                      varchar(100),
    seventh_ip                                    varchar(100),
    eighth_ip                                     varchar(100),
    ninth_ip                                      varchar(100),
    tenth_ip                                      varchar(100),
    alert_im_acornym                              varchar(100),
    alert_im_access_code                          varchar(100),
    broker_acronym                                varchar(100),
    cross_reference_indicator                     varchar(100),
    bny_trust_indicator                           varchar(100),
    source_of_asset_at_acct_opening               varchar(100),
    commission_doscount_code                      varchar(100),
    external_account_number                       varchar(100),
    confirmation_suppression_indicator            varchar(100),
    date_last_mail_sent                           date,
    date_last_mail_sent_outside                   date,
    fully_paid_lending_agreement_indicator        varchar(100),
    fully_paid_lending_agreement_date             date,
    custodian_account_type                        varchar(100),
    mifid_customer_categorization                 varchar(100),
    cash_management_tran_code                     varchar(100),
    sweep_status_indicator                        varchar(100),
    date_sweep_activated                          date,
    date_sweep_details_changed                    date,
    cober_margin_debit_indicator                  varchar(100),
    first_fund_sweep_account_id                   varchar(100),
    firstfund_sweep_account_percent               numeric(45, 20),
    first_fundsweep_account_redemption_priority   varchar(100),
    second_fund_sweep_account_id                  varchar(100),
    second_fund_sweep_account_percent             numeric(45, 20),
    second_fundsweep_account_redemption_priority  varchar(100),
    type_of_bank_account                          varchar(100),
    banklink_aba_number                           varchar(100),
    banklink_dda_number                           varchar(100),
    fund_bank_indicator                           varchar(100),
    w_9_corp_tax_classification_code              varchar(100),
    combined_margin_acct_indicator                varchar(100),
    pledge_collateral_account_indicator           varchar(100),
    finra_institutional_account_code              varchar(100),
    proposed_account_reference_id                 varchar(100),
    advisor_model_id                              varchar(100),
    firm_model_style_id                           varchar(100),
    dvp_restriction_code                          varchar(100),
    dvp_restriction_exp_date                      date,
    escheatment_withholding_ind                   varchar(100),
    source_of_origination                         varchar(100),
    source_of_persona                             varchar(100),
    client_onboarding_method                      varchar(100),
    tax_filing_code                               varchar(100),
    nor_purpose_collateral_acct_ind               varchar(100),
    addr_1_trx_code                               varchar(100),
    addr_1_special_handling_ind                   varchar(100),
    addr_1_delivery_id                            varchar(100),
    addr_1_attention_line_prefix                  varchar(100),
    addr_1_attention_line_detail                  varchar(100),
    addr_1_line_1                                 varchar(100),
    addr_1_line_2                                 varchar(100),
    addr_1_line_3                                 varchar(100),
    addr_1_line_4                                 varchar(100),
    addr_1_city_state                             varchar(100),
    addr_1_country_code                           varchar(100),
    addr_2_trx_code                               varchar(100),
    addr_2_special_handling_ind                   varchar(100),
    addr_2_delivery_id                            varchar(100),
    addr_2_attention_line_prefix                  varchar(100),
    addr_2_attention_line_detail                  varchar(100),
    addr_2_line_1                                 varchar(100),
    addr_2_line_2                                 varchar(100),
    addr_2_line_3                                 varchar(100),
    addr_2_line_4                                 varchar(100),
    addr_2_city_state                             varchar(100),
    addr_2_country_code                           varchar(100),
    account_description                           varchar(100),
    set_as_mail_addr_2_ind                        varchar(100),
    principal_billing_allocation_pct              numeric(45, 20),
    seasonal_addr_id_1                            varchar(100),
    from_date_1                                   date,
    to_date_1                                     date,
    seasonal_addr_id_2                            varchar(100),
    from_date_2                                   date,
    to_date_2                                     date,
    seasonal_addr_id_3                            varchar(100),
    from_date_3                                   date,
    to_date_3                                     date,
    cost_basis_acct_system                        varchar(100),
    disposition_method_mutual_funds               varchar(100),
    disposition_method_other                      varchar(100),
    disposition_method_stocks                     varchar(100),
    amortize_taxable_premium_bonds                varchar(100),
    accrue_market_disc_based_on                   varchar(100),
    accrue_market_disc_income                     varchar(100),
    addr_3_trx_code                               varchar(100),
    addr_3_special_handling_ind                   varchar(100),
    addr_3_delivery_id                            varchar(100),
    addr_3_attention_line_prefix                  varchar(100),
    addr_3_attention_line_detail                  varchar(100),
    addr_3_line_1                                 varchar(100),
    addr_3_line_2                                 varchar(100),
    addr_3_line_3                                 varchar(100),
    addr_3_line_4                                 varchar(100),
    addr_3_city_state                             varchar(100),
    addr_3_country_code                           varchar(100),
    set_as_mail_addr_3_ind                        varchar(100),
    addr_4_trx_code                               varchar(100),
    addr_4_special_handling_ind                   varchar(100),
    addr_4_delivery_id                            varchar(100),
    addr_4_attention_line_prefix                  varchar(100),
    addr_4_attention_line_detail                  varchar(100),
    addr_4_line_1                                 varchar(100),
    addr_4_line_2                                 varchar(100),
    addr_4_line_3                                 varchar(100),
    addr_4_line_4                                 varchar(100),
    addr_4_city_state                             varchar(100),
    addr_4_country_code                           varchar(100),
    set_as_mail_addr_4_ind                        varchar(100),
    addr_5_trx_code                               varchar(100),
    addr_5_special_handling_ind                   varchar(100),
    addr_5_delivery_id                            varchar(100),
    addr_5_attention_line_prefix                  varchar(100),
    addr_5_attention_line_detail                  varchar(100),
    addr_5_line_1                                 varchar(100),
    addr_5_line_2                                 varchar(100),
    addr_5_line_3                                 varchar(100),
    addr_5_line_4                                 varchar(100),
    addr_5_city_state                             varchar(100),
    addr_5_country_code                           varchar(100),
    set_as_mail_addr_5_ind                        varchar(100),
    addr_6_trx_code                               varchar(100),
    addr_6_special_handling_ind                   varchar(100),
    addr_6_delivery_id                            varchar(100),
    addr_6_attention_line_prefix                  varchar(100),
    addr_6_attention_line_detail                  varchar(100),
    addr_6_line_1                                 varchar(100),
    addr_6_line_2                                 varchar(100),
    addr_6_line_3                                 varchar(100),
    addr_6_line_4                                 varchar(100),
    addr_6_city_state                             varchar(100),
    addr_6_country_code                           varchar(100),
    set_as_mail_addr_6_ind                        varchar(100),
    addr_7_trx_code                               varchar(100),
    addr_7_special_handling_ind                   varchar(100),
    addr_7_delivery_id                            varchar(100),
    addr_7_attention_line_prefix                  varchar(100),
    addr_7_attention_line_detail                  varchar(100),
    addr_7_line_1                                 varchar(100),
    addr_7_line_2                                 varchar(100),
    addr_7_line_3                                 varchar(100),
    addr_7_line_4                                 varchar(100),
    addr_7_city_state                             varchar(100),
    addr_7_country_code                           varchar(100),
    set_as_mail_addr_7_ind                        varchar(100),
    record_transaction_code                       varchar(100),
    base_currency                                 varchar(100),
    income_currency                               varchar(100),
    statement_language                            varchar(100),
    statement_format_code                         varchar(100),
    msrb_statement_ind                            varchar(100),
    pep                                           varchar(100),
    first_name_pep                                varchar(100),
    last_name_pep                                 varchar(100),
    suffix_pep                                    varchar(100),
    political_office_held                         varchar(100),
    country_of_office                             varchar(100),
    foreign_bank_account_ind                      varchar(100),
    foreign_bank_cert_date                        date,
    foreign_bank_cert_exp_date                    date,
    central_bank_ind                              varchar(100),
    acct_foreign_financial_inst                   varchar(100),
    foreign_bank_acct_oper_1                      varchar(100),
    foreign_bank_acct_oper_2                      varchar(100),
    foreign_bank_acct_oper_3                      varchar(100),
    number_people_own                             varchar(100),
    proprietary_acct_owned                        varchar(100),
    tel_1_transaction_code                        varchar(100),
    tel_1_us_ind                                  varchar(100),
    tel_1_type_id                                 varchar(100),
    tel_1_number                                  varchar(100),
    tel_1_extension                               varchar(100),
    tel_2_transaction_code                        varchar(100),
    tel_2_us_ind                                  varchar(100),
    tel_2_type_id                                 varchar(100),
    tel_2_number                                  varchar(100),
    tel_2_extension                               varchar(100),
    tel_3_transaction_code                        varchar(100),
    tel_3_us_ind                                  varchar(100),
    tel_3_type_id                                 varchar(100),
    tel_3_number                                  varchar(100),
    tel_3_extension                               varchar(100),
    tel_4_transaction_code                        varchar(100),
    tel_4_us_ind                                  varchar(100),
    tel_4_type_id                                 varchar(100),
    tel_4_number                                  varchar(100),
    tel_4_extension                               varchar(100),
    tel_5_transaction_code                        varchar(100),
    tel_5_us_ind                                  varchar(100),
    tel_5_type_id                                 varchar(100),
    tel_5_number                                  varchar(100),
    tel_5_extension                               varchar(100),
    tel_6_transaction_code                        varchar(100),
    tel_6_us_ind                                  varchar(100),
    tel_6_type_id                                 varchar(100),
    tel_6_number                                  varchar(100),
    tel_6_extension                               varchar(100),
    tel_7_transaction_code                        varchar(100),
    tel_7_us_ind                                  varchar(100),
    tel_7_type_id                                 varchar(100),
    tel_7_number                                  varchar(100),
    tel_7_extension                               varchar(100),
    tel_8_transaction_code                        varchar(100),
    tel_8_us_ind                                  varchar(100),
    tel_8_type_id                                 varchar(100),
    tel_8_number                                  varchar(100),
    tel_8_extension                               varchar(100),
    email_address                                 varchar(100),
    external_position_ind                         varchar(100),
    purge_eligible_ind                            varchar(100),
    advisory_acct_ind                             varchar(100),
    product_profile_code                          varchar(100),
    cents_per_share_discount                      integer,
    option_disclosure_date                        date,
    country_acct_level_tax_residency              varchar(100)
);

alter table zz_backup.tbvw_maestro_cuentas_pershing_20241017
    owner to postgres;

