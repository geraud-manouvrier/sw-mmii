--========================================================================
--========================================================================
--========================================================================
-- Integración Fee RIA


SELECT * FROM public.fn_reporte_maestro_datos_saldos('20250520') ORDER BY account_no;
SELECT distinct account_no FROM public.fn_reporte_maestro_datos_saldos('20250520') ORDER BY account_no;
--151
SELECT *
FROM clientes.vw_maestro_clientes_cuentas
;


select annual_fee, fee_diario, * from public.tbvw_maestro_saldos_pershing order by process_date desc limit 100;
select fee, * from public.tbvw_maestro_cuentas_pershing order by process_date desc limit 100;


create table zz_backup.tbvw_maestro_cuentas_pershing_20260611
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
    country_acct_level_tax_residency              varchar(100),
    fee                                           numeric(45, 20),
    row_no                                        bigint,
    estado_cuenta                                 varchar(100)
);

create table zz_backup.tbvw_maestro_saldos_pershing_20260518
(
    custodian                  varchar(100),
    tipo_reg                   varchar(100),
    client_id                  varchar(100),
    office_id                  varchar(100),
    account_no                 text,
    name                       varchar(100),
    process_date               varchar(100),
    symbol                     varchar(100),
    cusip                      varchar(100),
    isin_code                  varchar(100),
    product_type               varchar(100),
    security_description       varchar(100),
    cash_margin_account        varchar(100),
    quantity                   numeric,
    market_price               numeric(45, 20),
    id_currency                varchar(100),
    currency                   varchar(100),
    market_value               numeric(45, 20),
    fx_rate                    numeric(45, 20),
    usde_market_value          numeric(45, 20),
    total_usde_market_value    numeric(45, 20),
    id_fee_aplicado            integer,
    annual_fee                 numeric(45, 20),
    tasa_proteccion            numeric(45, 20),
    tasa_suracorp              numeric(45, 20),
    fee_diario                 numeric(45, 20),
    fee_diario_proteccion      numeric(45, 20),
    fee_diario_sura_corp       numeric(45, 20),
    comision_devengada_diaria  numeric(45, 20),
    ingreso_proteccion         numeric(45, 20),
    usde_market_price          numeric(45, 20),
    id_sub_sub_tipo_activo     varchar(100),
    id_sub_tipo_activo         varchar(100),
    id_tipo_activo             varchar(100),
    nombre_sub_sub_tipo_activo varchar(1000),
    tipo_identificador_cliente varchar(100),
    row_no                     bigint
);


create table zz_backup.tbvw_maestro_saldos_pershing_20260611
(
    custodian                  varchar(100),
    tipo_reg                   varchar(100),
    client_id                  varchar(100),
    office_id                  varchar(100),
    account_no                 text,
    name                       varchar(100),
    process_date               varchar(100),
    symbol                     varchar(100),
    cusip                      varchar(100),
    isin_code                  varchar(100),
    product_type               varchar(100),
    security_description       varchar(100),
    cash_margin_account        varchar(100),
    quantity                   numeric,
    market_price               numeric(45, 20),
    id_currency                varchar(100),
    currency                   varchar(100),
    market_value               numeric(45, 20),
    fx_rate                    numeric(45, 20),
    usde_market_value          numeric(45, 20),
    total_usde_market_value    numeric(45, 20),
    id_fee_aplicado            integer,
    annual_fee                 numeric(45, 20),
    tasa_proteccion            numeric(45, 20),
    tasa_suracorp              numeric(45, 20),
    fee_diario                 numeric(45, 20),
    fee_diario_proteccion      numeric(45, 20),
    fee_diario_sura_corp       numeric(45, 20),
    comision_devengada_diaria  numeric(45, 20),
    ingreso_proteccion         numeric(45, 20),
    usde_market_price          numeric(45, 20),
    id_sub_sub_tipo_activo     varchar(100),
    id_sub_tipo_activo         varchar(100),
    id_tipo_activo             varchar(100),
    nombre_sub_sub_tipo_activo varchar(1000),
    tipo_identificador_cliente varchar(100),
    row_no                     bigint
);

select * from public.tbvw_maestro_movimientos_pershing;


--========================================================================
--========================================================================
--========================================================================
-- Carga SFL pendientes 20251013 (670), 20251111(706)   -> OK cargados y listos en DEV y PROD!!!!!!! (TODO: pendientes GCUS/GMON)

--20251013      20251111
select * from pershing.proceso_sfl where proceso_sfl.process_date in ('20251013', '20251111') or id in (670, 706, 667);
/*
id,process_date,process_stamp,start_timestamp,last_step_timestamp
670,20251013,20251013_2025.10.14.05.45.02.117.-0300,2025-10-14 05:50:58.180930,2025-10-14 05:51:02.189237
706,20251111,20251111_2025.11.12.05.45.02.314.-0300,2025-11-12 05:51:58.668694,2025-11-12 05:52:02.431512
*/

select * from stage_pershing.stage_isca_file where process_date='20251013' or id_proceso in (670, 667);   --0 reg
select * from pershing.sfl_isca_historica where process_date='20251013' or id_proceso in (670, 667);      --47 reg, pero con id 667

--670 es el reg en isca; 667 en el hist.
CALL pershing.pa_procesa_isca(670);


select * from stage_pershing.stage_isca_file where process_date='20251111' or id_proceso in (706, 705);
select * from pershing.sfl_isca_historica where process_date='20251111' or id_proceso in (706, 705);

CALL pershing.pa_procesa_isca(706);



--========================================================================
--========================================================================
--========================================================================
--
select *
from public.vw_reporte_maestro_datos_saldos vw_sld
where vw_sld.process_date like '202603%'
and vw_sld.account_no in ('T9N001490', 'T9O001366')
order by process_date, account_no
;   --311 reg
select *
from public.vw_reporte_maestro_datos_movimientos vw_mov
where vw_mov.process_date like '202603%'
and vw_mov.account_no in ('T9N001490', 'T9O001366')
order by process_date, account_no
;   --17 reg

SELECT distinct account_no from public.vw_reporte_maestro_datos_clientes vw_cte
UNION
SELECT distinct account_no from public.vw_reporte_maestro_datos_saldos vw_sld
UNION
SELECT distinct account_no from public.vw_reporte_maestro_datos_movimientos vw_mov
;--352 cuentas en total








--Consolidado

select vw_cte.process_date, vw_cte.account_no, count(*)
from public.vw_reporte_maestro_datos_clientes vw_cte
where vw_cte.process_date like '202603%'
and vw_cte.account_no in
('T9N001490', 'T9N001508', 'T9N001599', 'T9N001631', 'T9N001649', 'T9N001656', 'T9N001664', 'T9N001706', 'T9N002019', 'T9N002076',
'T9N002134', 'T9N002167', 'T9N002183', 'T9N002225', 'T9N002324', 'T9N002407', 'T9N002423', 'T9N002431', 'T9N002456', 'T9N002514',
'T9N002589', 'T9O001192', 'T9O001267', 'T9O001275', 'T9O001341', 'T9O001366', 'T9O001374', 'T9O001382', 'T9O001390', 'T9O001408',
'T9O001457', 'T9O001465', 'T9O001473', 'T9O001481', 'T9O001507', 'T9O001515', 'T9O001523', 'T9O001531', 'T9O001556', 'T9O001564',
'T9O001572', 'T9O001580', 'T9O001598', 'T9O001606', 'T9O001614', 'T9O001648', 'T9O001655', 'T9O001705', 'T9O001713', 'T9O001754',
'T9O001796', 'T9O001804', 'T9O001812', 'T9O001820', 'T9O001838', 'T9O001846', 'T9O001853', 'T9O001879', 'T9O001887', 'T9O001895',
'T9O001903', 'T9O001911', 'T9O001929', 'T9O001937', 'T9O001945', 'T9O001952', 'T9O001960', 'T9O001978', 'T9O001994', 'T9O002000',
'T9O002026', 'T9O002034', 'T9O002042', 'T9O002059', 'T9O002067', 'T9O002083', 'T9O002091', 'T9O002117', 'T9O002125', 'T9O002133',
'T9O002158', 'T9O002166', 'T9O002174', 'T9O002182', 'T9O002190', 'T9O002208', 'T9O002216', 'T9O002224', 'T9O002232', 'T9O002240',
'T9O002265', 'T9O002273', 'T9O002281', 'T9O002299', 'T9O002307', 'T9O002315', 'T9O002323', 'T9O002331', 'T9O002364', 'T9O002372',
'T9O002380', 'T9O002398', 'T9O002406', 'T9O002414', 'T9O002422', 'T9O002430', 'T9O002448', 'T9O002471', 'T9O002489', 'T9O002497',
'T9O002505', 'T9O002521', 'T9O002547', 'T9O002554', 'T9O002562', 'T9O002570', 'T9O002588', 'T9O002596', 'T9O002604', 'T9O002620',
'T9O002638', 'T9O002646', 'T9O002653', 'T9O002661', 'T9O002679', 'T9O002687', 'T9O002695', 'T9O002703', 'T9O002711', 'T9O002737',
'T9O002745', 'T9O002752', 'T9O002778', 'T9O002786', 'T9O002794', 'T9O002828', 'T9O002844', 'T9O002851', 'T9O002869', 'T9O002877',
'T9O002885', 'T9O002893', 'T9O002901', 'T9O002927', 'T9O002935', 'T9O002943', 'T9O002976', 'T9O002992', 'T9O003024', 'T9O003032',
'T9O003040', 'T9O003057', 'T9O003065', 'T9O003073', 'T9O003099', 'T9O003107', 'T9O003115', 'T9O003123', 'T9O003131', 'T9O003164',
'T9O003172', 'T9O003180', 'T9O003198', 'T9O003206', 'T9O003214', 'T9O003222', 'T9O003230', 'T9O003263', 'T9O003271', 'T9O003297',
'T9O003305', 'T9O003339', 'T9O003347', 'T9O003354', 'T9O003362', 'T9O003370', 'T9O003396', 'T9O003412', 'T9O003420', 'T9O003438',
'T9O003453', 'T9O003461', 'T9O003479', 'T9O003487', 'T9O003495', 'T9O003503', 'T9O003511', 'T9O003529', 'T9O003537', 'T9O003545',
'T9O003560', 'T9O003578', 'T9O003586', 'T9O003602', 'T9O003628', 'T9O003644', 'T9O003651', 'T9O003669', 'T9O003677', 'T9O003693',
'T9O003701', 'T9O003735', 'T9O003768', 'T9O003784', 'T9O003792', 'T9O003800', 'T9O003818', 'T9O003826', 'T9O003834', 'T9O003859',
'T9O003867', 'T9O003875', 'T9O003883', 'T9O003909', 'T9O003925', 'T9O003933', 'T9O003958', 'T9O003966', 'T9O003974', 'T9O003982',
'T9O003990', 'T9O004006', 'T9O004022', 'T9O004030', 'T9O004055', 'T9O004063', 'T9O004071', 'T9O004089', 'T9O004097', 'T9O004121',
'T9O004139', 'T9O004147', 'T9O004162', 'T9O004170', 'T9O004188', 'T9O004196', 'T9O004204', 'T9O004212', 'T9O004246', 'T9O004253',
'T9O004261', 'T9O004279', 'T9O004287', 'T9O004295', 'T9O004303', 'T9O004311', 'T9O004329', 'T9O004345', 'T9O004378', 'T9O004394',
'T9O004410', 'T9O004428', 'T9O004436', 'T9O004451', 'T9O004477', 'T9O004485', 'T9O004501', 'T9O004519', 'T9O004527', 'T9O004543',
'T9O004550', 'T9O004568', 'T9O004576', 'T9O004584', 'T9O004592', 'T9O004600', 'T9O004618', 'T9O004626', 'T9O004642', 'T9O004659',
'T9O004667', 'T9O004683', 'T9O004691', 'T9O004709', 'T9O004717', 'T9O004766', 'T9O004774', 'T9O004790', 'T9O004808', 'T9O004816',
'T9O004824', 'T9O004832', 'T9O004857', 'T9O004865', 'T9O004881', 'T9O004899', 'T9O004907', 'T9O004915', 'T9O004923', 'T9O004931',
'T9O004964', 'T9O004972', 'T9O004980', 'T9O005011', 'T9O005029', 'T9O005045', 'T9O005052', 'T9O005060', 'T9O005078', 'T9O005086',
'T9O005102', 'T9O005110', 'T9O005128', 'T9O005136', 'T9O005144', 'T9O005151', 'T9O005169', 'T9O005177', 'T9O005219', 'T9O005243',
'T9O005250', 'T9O005268', 'T9O005276', 'T9O005284', 'T9O005292', 'T9O005300', 'T9O005326', 'T9O005359', 'T9O005367', 'T9O005375',
'T9O005417', 'T9O005425', 'T9O005466', 'T9O005482', 'T9O005508', 'T9O005516', 'T9O005540', 'T9O005615', 'T9O005623', 'T9O005631',
'T9O005649', 'T9O005664', 'T9O005672', 'T9O005680', 'T9O005698', 'T9O005714', 'T9O005722', 'T9O005748', 'T9O005755', 'T9O005771',
'T9O005789', 'T9O005797', 'T9O005813', 'T9O005821', 'T9O005839', 'T9O005847', 'T9O005862', 'T9O005888', 'T9O005896', 'T9O005904',
'T9O005938', 'T9O005961')
group by process_date, account_no
order by process_date, account_no
;
select vw_sld.process_date, vw_sld.account_no, count(*), sum(vw_sld.usde_market_value)
from public.vw_reporte_maestro_datos_saldos vw_sld
where vw_sld.process_date like '202603%'
and vw_sld.account_no in
('T9N001490', 'T9N001508', 'T9N001599', 'T9N001631', 'T9N001649', 'T9N001656', 'T9N001664', 'T9N001706', 'T9N002019', 'T9N002076',
'T9N002134', 'T9N002167', 'T9N002183', 'T9N002225', 'T9N002324', 'T9N002407', 'T9N002423', 'T9N002431', 'T9N002456', 'T9N002514',
'T9N002589', 'T9O001192', 'T9O001267', 'T9O001275', 'T9O001341', 'T9O001366', 'T9O001374', 'T9O001382', 'T9O001390', 'T9O001408',
'T9O001457', 'T9O001465', 'T9O001473', 'T9O001481', 'T9O001507', 'T9O001515', 'T9O001523', 'T9O001531', 'T9O001556', 'T9O001564',
'T9O001572', 'T9O001580', 'T9O001598', 'T9O001606', 'T9O001614', 'T9O001648', 'T9O001655', 'T9O001705', 'T9O001713', 'T9O001754',
'T9O001796', 'T9O001804', 'T9O001812', 'T9O001820', 'T9O001838', 'T9O001846', 'T9O001853', 'T9O001879', 'T9O001887', 'T9O001895',
'T9O001903', 'T9O001911', 'T9O001929', 'T9O001937', 'T9O001945', 'T9O001952', 'T9O001960', 'T9O001978', 'T9O001994', 'T9O002000',
'T9O002026', 'T9O002034', 'T9O002042', 'T9O002059', 'T9O002067', 'T9O002083', 'T9O002091', 'T9O002117', 'T9O002125', 'T9O002133',
'T9O002158', 'T9O002166', 'T9O002174', 'T9O002182', 'T9O002190', 'T9O002208', 'T9O002216', 'T9O002224', 'T9O002232', 'T9O002240',
'T9O002265', 'T9O002273', 'T9O002281', 'T9O002299', 'T9O002307', 'T9O002315', 'T9O002323', 'T9O002331', 'T9O002364', 'T9O002372',
'T9O002380', 'T9O002398', 'T9O002406', 'T9O002414', 'T9O002422', 'T9O002430', 'T9O002448', 'T9O002471', 'T9O002489', 'T9O002497',
'T9O002505', 'T9O002521', 'T9O002547', 'T9O002554', 'T9O002562', 'T9O002570', 'T9O002588', 'T9O002596', 'T9O002604', 'T9O002620',
'T9O002638', 'T9O002646', 'T9O002653', 'T9O002661', 'T9O002679', 'T9O002687', 'T9O002695', 'T9O002703', 'T9O002711', 'T9O002737',
'T9O002745', 'T9O002752', 'T9O002778', 'T9O002786', 'T9O002794', 'T9O002828', 'T9O002844', 'T9O002851', 'T9O002869', 'T9O002877',
'T9O002885', 'T9O002893', 'T9O002901', 'T9O002927', 'T9O002935', 'T9O002943', 'T9O002976', 'T9O002992', 'T9O003024', 'T9O003032',
'T9O003040', 'T9O003057', 'T9O003065', 'T9O003073', 'T9O003099', 'T9O003107', 'T9O003115', 'T9O003123', 'T9O003131', 'T9O003164',
'T9O003172', 'T9O003180', 'T9O003198', 'T9O003206', 'T9O003214', 'T9O003222', 'T9O003230', 'T9O003263', 'T9O003271', 'T9O003297',
'T9O003305', 'T9O003339', 'T9O003347', 'T9O003354', 'T9O003362', 'T9O003370', 'T9O003396', 'T9O003412', 'T9O003420', 'T9O003438',
'T9O003453', 'T9O003461', 'T9O003479', 'T9O003487', 'T9O003495', 'T9O003503', 'T9O003511', 'T9O003529', 'T9O003537', 'T9O003545',
'T9O003560', 'T9O003578', 'T9O003586', 'T9O003602', 'T9O003628', 'T9O003644', 'T9O003651', 'T9O003669', 'T9O003677', 'T9O003693',
'T9O003701', 'T9O003735', 'T9O003768', 'T9O003784', 'T9O003792', 'T9O003800', 'T9O003818', 'T9O003826', 'T9O003834', 'T9O003859',
'T9O003867', 'T9O003875', 'T9O003883', 'T9O003909', 'T9O003925', 'T9O003933', 'T9O003958', 'T9O003966', 'T9O003974', 'T9O003982',
'T9O003990', 'T9O004006', 'T9O004022', 'T9O004030', 'T9O004055', 'T9O004063', 'T9O004071', 'T9O004089', 'T9O004097', 'T9O004121',
'T9O004139', 'T9O004147', 'T9O004162', 'T9O004170', 'T9O004188', 'T9O004196', 'T9O004204', 'T9O004212', 'T9O004246', 'T9O004253',
'T9O004261', 'T9O004279', 'T9O004287', 'T9O004295', 'T9O004303', 'T9O004311', 'T9O004329', 'T9O004345', 'T9O004378', 'T9O004394',
'T9O004410', 'T9O004428', 'T9O004436', 'T9O004451', 'T9O004477', 'T9O004485', 'T9O004501', 'T9O004519', 'T9O004527', 'T9O004543',
'T9O004550', 'T9O004568', 'T9O004576', 'T9O004584', 'T9O004592', 'T9O004600', 'T9O004618', 'T9O004626', 'T9O004642', 'T9O004659',
'T9O004667', 'T9O004683', 'T9O004691', 'T9O004709', 'T9O004717', 'T9O004766', 'T9O004774', 'T9O004790', 'T9O004808', 'T9O004816',
'T9O004824', 'T9O004832', 'T9O004857', 'T9O004865', 'T9O004881', 'T9O004899', 'T9O004907', 'T9O004915', 'T9O004923', 'T9O004931',
'T9O004964', 'T9O004972', 'T9O004980', 'T9O005011', 'T9O005029', 'T9O005045', 'T9O005052', 'T9O005060', 'T9O005078', 'T9O005086',
'T9O005102', 'T9O005110', 'T9O005128', 'T9O005136', 'T9O005144', 'T9O005151', 'T9O005169', 'T9O005177', 'T9O005219', 'T9O005243',
'T9O005250', 'T9O005268', 'T9O005276', 'T9O005284', 'T9O005292', 'T9O005300', 'T9O005326', 'T9O005359', 'T9O005367', 'T9O005375',
'T9O005417', 'T9O005425', 'T9O005466', 'T9O005482', 'T9O005508', 'T9O005516', 'T9O005540', 'T9O005615', 'T9O005623', 'T9O005631',
'T9O005649', 'T9O005664', 'T9O005672', 'T9O005680', 'T9O005698', 'T9O005714', 'T9O005722', 'T9O005748', 'T9O005755', 'T9O005771',
'T9O005789', 'T9O005797', 'T9O005813', 'T9O005821', 'T9O005839', 'T9O005847', 'T9O005862', 'T9O005888', 'T9O005896', 'T9O005904',
'T9O005938', 'T9O005961')
group by process_date, account_no
order by process_date, account_no
;
select vw_mov.process_date, vw_mov.account_no, count(*), sum(vw_mov.usde_net_amount)
from public.vw_reporte_maestro_datos_movimientos vw_mov
where vw_mov.process_date like '202603%'
and vw_mov.account_no in
('T9N001490', 'T9N001508', 'T9N001599', 'T9N001631', 'T9N001649', 'T9N001656', 'T9N001664', 'T9N001706', 'T9N002019', 'T9N002076',
'T9N002134', 'T9N002167', 'T9N002183', 'T9N002225', 'T9N002324', 'T9N002407', 'T9N002423', 'T9N002431', 'T9N002456', 'T9N002514',
'T9N002589', 'T9O001192', 'T9O001267', 'T9O001275', 'T9O001341', 'T9O001366', 'T9O001374', 'T9O001382', 'T9O001390', 'T9O001408',
'T9O001457', 'T9O001465', 'T9O001473', 'T9O001481', 'T9O001507', 'T9O001515', 'T9O001523', 'T9O001531', 'T9O001556', 'T9O001564',
'T9O001572', 'T9O001580', 'T9O001598', 'T9O001606', 'T9O001614', 'T9O001648', 'T9O001655', 'T9O001705', 'T9O001713', 'T9O001754',
'T9O001796', 'T9O001804', 'T9O001812', 'T9O001820', 'T9O001838', 'T9O001846', 'T9O001853', 'T9O001879', 'T9O001887', 'T9O001895',
'T9O001903', 'T9O001911', 'T9O001929', 'T9O001937', 'T9O001945', 'T9O001952', 'T9O001960', 'T9O001978', 'T9O001994', 'T9O002000',
'T9O002026', 'T9O002034', 'T9O002042', 'T9O002059', 'T9O002067', 'T9O002083', 'T9O002091', 'T9O002117', 'T9O002125', 'T9O002133',
'T9O002158', 'T9O002166', 'T9O002174', 'T9O002182', 'T9O002190', 'T9O002208', 'T9O002216', 'T9O002224', 'T9O002232', 'T9O002240',
'T9O002265', 'T9O002273', 'T9O002281', 'T9O002299', 'T9O002307', 'T9O002315', 'T9O002323', 'T9O002331', 'T9O002364', 'T9O002372',
'T9O002380', 'T9O002398', 'T9O002406', 'T9O002414', 'T9O002422', 'T9O002430', 'T9O002448', 'T9O002471', 'T9O002489', 'T9O002497',
'T9O002505', 'T9O002521', 'T9O002547', 'T9O002554', 'T9O002562', 'T9O002570', 'T9O002588', 'T9O002596', 'T9O002604', 'T9O002620',
'T9O002638', 'T9O002646', 'T9O002653', 'T9O002661', 'T9O002679', 'T9O002687', 'T9O002695', 'T9O002703', 'T9O002711', 'T9O002737',
'T9O002745', 'T9O002752', 'T9O002778', 'T9O002786', 'T9O002794', 'T9O002828', 'T9O002844', 'T9O002851', 'T9O002869', 'T9O002877',
'T9O002885', 'T9O002893', 'T9O002901', 'T9O002927', 'T9O002935', 'T9O002943', 'T9O002976', 'T9O002992', 'T9O003024', 'T9O003032',
'T9O003040', 'T9O003057', 'T9O003065', 'T9O003073', 'T9O003099', 'T9O003107', 'T9O003115', 'T9O003123', 'T9O003131', 'T9O003164',
'T9O003172', 'T9O003180', 'T9O003198', 'T9O003206', 'T9O003214', 'T9O003222', 'T9O003230', 'T9O003263', 'T9O003271', 'T9O003297',
'T9O003305', 'T9O003339', 'T9O003347', 'T9O003354', 'T9O003362', 'T9O003370', 'T9O003396', 'T9O003412', 'T9O003420', 'T9O003438',
'T9O003453', 'T9O003461', 'T9O003479', 'T9O003487', 'T9O003495', 'T9O003503', 'T9O003511', 'T9O003529', 'T9O003537', 'T9O003545',
'T9O003560', 'T9O003578', 'T9O003586', 'T9O003602', 'T9O003628', 'T9O003644', 'T9O003651', 'T9O003669', 'T9O003677', 'T9O003693',
'T9O003701', 'T9O003735', 'T9O003768', 'T9O003784', 'T9O003792', 'T9O003800', 'T9O003818', 'T9O003826', 'T9O003834', 'T9O003859',
'T9O003867', 'T9O003875', 'T9O003883', 'T9O003909', 'T9O003925', 'T9O003933', 'T9O003958', 'T9O003966', 'T9O003974', 'T9O003982',
'T9O003990', 'T9O004006', 'T9O004022', 'T9O004030', 'T9O004055', 'T9O004063', 'T9O004071', 'T9O004089', 'T9O004097', 'T9O004121',
'T9O004139', 'T9O004147', 'T9O004162', 'T9O004170', 'T9O004188', 'T9O004196', 'T9O004204', 'T9O004212', 'T9O004246', 'T9O004253',
'T9O004261', 'T9O004279', 'T9O004287', 'T9O004295', 'T9O004303', 'T9O004311', 'T9O004329', 'T9O004345', 'T9O004378', 'T9O004394',
'T9O004410', 'T9O004428', 'T9O004436', 'T9O004451', 'T9O004477', 'T9O004485', 'T9O004501', 'T9O004519', 'T9O004527', 'T9O004543',
'T9O004550', 'T9O004568', 'T9O004576', 'T9O004584', 'T9O004592', 'T9O004600', 'T9O004618', 'T9O004626', 'T9O004642', 'T9O004659',
'T9O004667', 'T9O004683', 'T9O004691', 'T9O004709', 'T9O004717', 'T9O004766', 'T9O004774', 'T9O004790', 'T9O004808', 'T9O004816',
'T9O004824', 'T9O004832', 'T9O004857', 'T9O004865', 'T9O004881', 'T9O004899', 'T9O004907', 'T9O004915', 'T9O004923', 'T9O004931',
'T9O004964', 'T9O004972', 'T9O004980', 'T9O005011', 'T9O005029', 'T9O005045', 'T9O005052', 'T9O005060', 'T9O005078', 'T9O005086',
'T9O005102', 'T9O005110', 'T9O005128', 'T9O005136', 'T9O005144', 'T9O005151', 'T9O005169', 'T9O005177', 'T9O005219', 'T9O005243',
'T9O005250', 'T9O005268', 'T9O005276', 'T9O005284', 'T9O005292', 'T9O005300', 'T9O005326', 'T9O005359', 'T9O005367', 'T9O005375',
'T9O005417', 'T9O005425', 'T9O005466', 'T9O005482', 'T9O005508', 'T9O005516', 'T9O005540', 'T9O005615', 'T9O005623', 'T9O005631',
'T9O005649', 'T9O005664', 'T9O005672', 'T9O005680', 'T9O005698', 'T9O005714', 'T9O005722', 'T9O005748', 'T9O005755', 'T9O005771',
'T9O005789', 'T9O005797', 'T9O005813', 'T9O005821', 'T9O005839', 'T9O005847', 'T9O005862', 'T9O005888', 'T9O005896', 'T9O005904',
'T9O005938', 'T9O005961')
group by process_date, account_no
order by process_date, account_no
;



--========================================================================
--========================================================================
--========================================================================
--Ultimos recaudos
SELECT *
FROM public.vw_reporte_maestro_datos_movimientos vw_mov
where vw_mov.client_id='900425189'
and vw_mov.account_no=COALESCE(null, vw_mov.account_no)
and (vw_mov.ingreso_egreso or vw_mov.aplica_flujo_neto=1)
ORDER BY vw_mov.account_no, vw_mov.process_date, vw_mov.cusip
;



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
--Cuadres recaudos marzo


SELECT
    COALESCE(sld.process_date, mov.process_date) as process_date,
    COALESCE(sld.account_no, mov.account_no) as account_no,
    --sld.cant_sld,
    sld.saldo_dia,
    COALESCE(mov.sum_movtos_dia, 0) as sum_movtos_dia,
    COALESCE(mov.sum_retiro_dia, 0) as sum_retiro_dia,
    COALESCE(mov.sum_recaudo_dia, 0) as sum_recaudo_dia,
    COALESCE(mov.cant_mov_dia, 0) as cantidad_movimientos_dia
FROM (select pos.process_date,
             pos.account_no,
             count(*)                   as cant_sld,
             sum(pos.usde_market_value) as saldo_dia
      from public.vw_reporte_maestro_datos_saldos pos
      where process_date >= '20260301' --and process_date<='20260309'
      group by pos.process_date, pos.account_no
      order by pos.process_date, pos.account_no) as sld
FULL OUTER JOIN
     (select mov.process_date,
             mov.account_no,
             --mov.aplica_flujo_neto,
             count(*)                 as cant_mov_dia,
             sum(mov.usde_net_amount) as sum_movtos_dia,
             sum(mov.retiro)          as sum_retiro_dia,
             sum(mov.recaudo)         as sum_recaudo_dia
      from public.vw_reporte_maestro_datos_movimientos mov
      where process_date >= '20260301'
      --and process_date<='20260309'
--and mov.aplica_flujo_neto=1
      group by mov.process_date, mov.account_no--, mov.aplica_flujo_neto
      order by mov.process_date, mov.account_no--, mov.aplica_flujo_neto
     ) as mov
ON sld.process_date = mov.process_date
AND sld.account_no = mov.account_no
ORDER BY sld.account_no, sld.process_date
;



select
    mov.process_date,
    mov.client_id, mov.name,
    mov.activity, mov.usde_net_amount, mov.cusip, mov.security_description,
    mov.activity_description, mov.activity_code, mov.source_code,
    mov.description1, mov.description2, mov.description3,
    mov.retiro, mov.recaudo
from public.vw_reporte_maestro_datos_movimientos mov
where process_date>='20260301' and process_date<='20260309'
and mov.account_no='T9O003271' and mov.process_date='20260303'
order by mov.process_date
;


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



