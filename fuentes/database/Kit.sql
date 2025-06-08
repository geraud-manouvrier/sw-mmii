/*
2025-06-08
Actual: 11.1.0-COL
*/

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_MAESTRO_REL' FROM public.users where username in ('admin-qye', 'daniel.gomez1', 'brayan.giraldom', 'santiago.isaza')
;
--daniel.gomez1
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_INV_BASE' FROM public.users where username in ('daniel.gomez1')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_INV_PRECALC' FROM public.users where username in ('daniel.gomez1')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_INV_RENT' FROM public.users where username in ('daniel.gomez1')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_INV_CONTRL' FROM public.users where username in ('daniel.gomez1')
;
--brayan.giraldom
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_INV_BASE' FROM public.users where username in ('brayan.giraldom')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_INV_PRECALC' FROM public.users where username in ('brayan.giraldom')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_INV_RENT' FROM public.users where username in ('brayan.giraldom')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_INV_CONTRL' FROM public.users where username in ('brayan.giraldom')
;

INSERT INTO public.parametro (id_parametro, sub_id_parametro, valor_parametro, comentario)
VALUES ('api.api_key', 'proteccion.temp-retornos', 'a3f9c8d4-12ab-4e8f-9c3d-567e2f8a9b12',
        'Api Key para invocación temporal a prod');

select *
--DELETE
from public.authorities
where authority = 'ROLE_OP_MANT_COMIS_CTA'
AND user_id not in (select id FROM public.users where username in ('admin-qye', 'user-qye', 'usuario'))
;

--========================================================================
--========================================================================
--========================================================================
-- Cargos
CREATE TABLE clientes.par_cargo (
    id VARCHAR(100) NOT NULL,
    glosa VARCHAR(100) NOT NULL,
    flag_habilitado_relacionado boolean NOT NULL,
    CONSTRAINT pk_par_cargo PRIMARY KEY (id)
);

INSERT INTO clientes.par_cargo (id, glosa, flag_habilitado_relacionado)
VALUES
    ('AC', 'Accionista > 5%', true),
    ('CO', 'Controlante', true),
    ('RL', 'Representante Legal', true),
    ('FI', 'Fiduciante', true),
    ('FM', 'Fideicomitente', true),
    ('FR', 'Fiduciario', true),
    ('CF', 'Comité fiduciario, financiero o equivalente', true),
    ('FC', 'Fideicomisario', true),
    ('BE', 'Beneficiario', true),
    ('BC', 'Beneficiario condicionado', true),
    ('CE', 'Beneficiario con control efectivo', true),
    ('DA', 'Beneficiarios con derecho a los activos, beneficios, resultados o utilidades', true),
    ('TA', 'Titular Conjunto Adicional', true);

--Agregar columna a tabla persona_relacionada
ALTER TABLE clientes.persona_relacionada
ADD COLUMN id_cargo VARCHAR(100) NULL;

--Asignar valores a registros relacionados existentes
/*
32491846: Betty Cecilia Martínez Cardona – Accionista > 5% (AC)
71380423: Andrés Felipe Cardona Martínez – Accionista > 5% (AC)
71755403: Gabriel Jaime Cardona Martínez – Accionista > 5% (AC)
98660781: Juan Esteban Cardona Martínez – Accionista > 5% (AC)
Jaime Cardona Montoya (17192143) por favor ponerlo como Representante Legal (RL).
*/
SELECT * FROM clientes.persona_relacionada;
SELECT * FROM clientes.par_cargo;

UPDATE clientes.persona_relacionada
SET id_cargo = 'AC'
WHERE identificador IN ('32491846', '71380423', '71755403', '98660781');
UPDATE clientes.persona_relacionada
SET id_cargo = 'RL'
WHERE identificador = '17192143';

UPDATE clientes.persona_relacionada
SET id_cargo = 'AC'
where id_cargo IS NULL;



--========================================================================
--========================================================================
--========================================================================
--Maestro Relacionados
CREATE or REPLACE VIEW clientes.vw_maestro_relacionado AS
    SELECT
        tb_pr.id as id_relacionado, tb_pr.id_cliente as id_cliente_relacionado,
        tb_pr.identificador as identificador_relacionado, tb_pr.nombre as nombre_relacionado,
        tb_pr.id_tipo_identificador as tipo_identificador_relacionado, tipo_id.tipo_identificador, tipo_id.glosa_identificador as glosa_tipo_identificador,
        tb_pr.id_cargo as id_cargo_relacionado, tb_cargo.glosa,
        tb_pr.flag_habilitado as flag_habilitado_relacionado
    FROM clientes.persona_relacionada tb_pr
    LEFT JOIN clientes.tipo_identificador tipo_id
    ON tb_pr.id_tipo_identificador = tipo_id.id
    LEFT JOIN clientes.par_cargo tb_cargo
    ON tb_pr.id_cargo = tb_cargo.id
WHERE tb_pr.flag_habilitado = true
;

--TODO: Llevarse identificador cliente a maestro clientes
--vw_reporte_maestro_datos_clientes
SELECT * FROM public.vw_reporte_maestro_datos_clientes ORDER BY process_date DESC LIMIT 100;


DROP function public.fn_reporte_maestro_datos_clientes;

drop view public.vw_reporte_maestro_datos_clientes;
create or replace view public.vw_reporte_maestro_datos_clientes
as
SELECT rank() OVER (ORDER BY row_id, src_vw) AS row_id,
       id_reg,
       id_interno_cliente,
       custodian,
       client_id,
       tipo_identificador_cliente,
       glosa_identificador_cliente,
       firm_no,
       sub_no,
       rep_no,
       office_id,
       account_no,
       name,
       fee,
       full_name,
       address,
       short_name,
       date_of_birth,
       acct_status_value,
       email,
       country_code_value,
       country,
       w8_date,
       w9_date,
       w8_status_value,
       w9_status_value,
       discr_trading_code_value,
       account_type,
       cash_margin_account,
       debit_card_indicator,
       open_date,
       close_date,
       participant_type,
       last_statement_date,
       tax_id,
       process_date,
       is_last_info,
       is_last_schema_by_account_no
FROM (SELECT 'B'::text                                                                                                  AS src_vw,
             rank()
             OVER (ORDER BY vw_acct.id, vw_acct.process_date, vw_acct.custodian, vw_acct.account_no)                    AS row_id,
             vw_acct.id                                                                                                 AS id_reg,
             vw_acct.id_interno_cliente                                                                                 as id_interno_cliente,
             upper(vw_acct.custodian::text)::character varying(100)                                                     AS custodian,
             upper(vw_acct.client_id::text)::character varying(100)                                                     AS client_id,
             vw_acct.tipo_identificador_cliente,
             vw_acct.glosa_identificador_cliente,
             vw_acct.ibd_number                                                                                         AS firm_no,
             vw_acct.id_office::character varying(100)                                                                  AS sub_no,
             upper(vw_acct.ip_number::text)::character varying(100)                                                     AS rep_no,
             upper(vw_acct.id_office)::character varying(100)                                                           AS office_id,
             upper(vw_acct.account_no::text)::character varying(100)                                                    AS account_no,
             COALESCE(upper(vw_acct.name::text),
                      upper(vw_acct.full_name::text))::character varying(100)                                           AS name,
             upper(vw_acct.full_name::text)::character varying(100)                                                     AS full_name,
             upper(vw_acct.full_address::text)::character varying(100)                                                  AS address,
             upper(vw_acct.account_short_name::text)::character varying(100)                                            AS short_name,
             vw_acct.birth_date                                                                                         AS date_of_birth,
             CASE
                 WHEN vw_acct.date_account_closed IS NULL THEN 'OPEN'::text
                 ELSE 'CLOSED'::text
                 END::character varying(100)                                                                            AS acct_status_value,
             lower(vw_acct.email_address::text)::character varying(100)                                                 AS email,
             upper(vw_acct.country_of_residence_code::text)::character varying(100)                                     AS country_code_value,
             upper(vw_acct.country_of_residence_value::text)::character varying(100)                                    AS country,
             fn_fecha_date_to_string(vw_acct.w_8_date_signed, 'YYYYMMDD'::character varying,
                                     '-'::character varying)                                                            AS w8_date,
             vw_acct.w_9_date_signed                                                                                    AS w9_date,
             upper(
                     CASE
                         WHEN vw_acct.w_8_w_9_indicator::text = 'W8'::text
                             THEN pershing.fn_obtiene_valor_param_generic_pershing('w8_status'::character varying,
                                                                                   (vw_acct.w_8_date_signed IS NOT NULL)::character varying(100))
                         ELSE NULL::character varying
                         END::text)::character varying(100)                                                             AS w8_status_value,
             upper(
                     CASE
                         WHEN vw_acct.w_8_w_9_indicator::text = 'W9'::text
                             THEN pershing.fn_obtiene_valor_param_generic_pershing('w9_status'::character varying,
                                                                                   (vw_acct.w_9_date_signed IS NOT NULL)::character varying(100))
                         ELSE NULL::character varying
                         END::text)::character varying(100)                                                             AS w9_status_value,
             upper(vw_acct.invest_advisor_discretion_granted_value::text)::character varying(100)                       AS discr_trading_code_value,
             upper(((vw_acct.registration_type_value::text || ' ('::text) || vw_acct.registration_type::text) ||
                   ')'::text)::character varying(100)                                                                   AS account_type,
             upper(vw_acct.cash_margin_account::text)::character varying(100)                                           AS cash_margin_account,
             upper(vw_acct.ama_indicator_value)::character varying(100)                                                 AS debit_card_indicator,
             fn_fecha_date_to_string(vw_acct.date_account_opened, 'YYYYMMDD'::character varying,
                                     '-'::character varying)::character varying(100)                                    AS open_date,
             vw_acct.date_account_closed                                                                                AS close_date,
             fn_obtiene_valor_parametro('pershing.participant_type'::character varying,
                                        'participant_type'::character varying)::character varying(1000)                 AS participant_type,
             NULL::date                                                                                                 AS last_statement_date,
             upper(pershing.fn_obtiene_valor_param_generic_pershing('tax_id_type'::character varying,
                                                                    vw_acct.tax_id_type)::text)::character varying(100) AS tax_id,
             upper(vw_acct.process_date::text)::character varying(100)                                                  AS process_date,
             true                                                                                                       AS is_last_info,
             true                                                                                                       AS is_last_schema_by_account_no,
             vw_acct.fee
      FROM tbvw_maestro_cuentas_pershing vw_acct) vw_union
ORDER BY process_date, client_id, account_no;


--TODO: Re crear objetos pendientes con sincronización

CREATE OR REPLACE VIEW public.vw_reporte_maestro_datos_relacionados AS
    SELECT
        ROW_NUMBER() over (ORDER BY vw_cte.process_date, vw_cte.client_id, vw_cte.custodian, vw_cte.account_no, vw_rel.id_relacionado) as id,
        vw_cte.process_date, vw_cte.id_interno_cliente,
        vw_cte.custodian, vw_cte.client_id, vw_cte.account_no,
        vw_cte.tipo_identificador_cliente, vw_cte.glosa_identificador_cliente, vw_cte.office_id, vw_cte.name,
        vw_rel.id_relacionado, vw_rel.identificador_relacionado, vw_rel.nombre_relacionado,
        vw_rel.tipo_identificador as tipo_identificador_relacionado, vw_rel.glosa_tipo_identificador as glosa_tipo_identificador_relacionado,
        vw_rel.id_cargo_relacionado as id_cargo, vw_rel.glosa as cargo
    FROM public.vw_reporte_maestro_datos_clientes vw_cte
    INNER JOIN clientes.vw_maestro_relacionado vw_rel
    ON vw_cte.id_interno_cliente = vw_rel.id_cliente_relacionado
;

create or replace function public.fn_reporte_maestro_datos_relacionados(_process_date character varying) returns SETOF public.vw_reporte_maestro_datos_relacionados
    language plpgsql
as
$$
    BEGIN


    RETURN QUERY
    SELECT
        *
    FROM public.vw_reporte_maestro_datos_relacionados vw_rel
    WHERE vw_rel.process_date = _process_date

    ;

    RETURN;
    END;
$$;


--========================================================================
--========================================================================
--========================================================================
--

create table public.tbvw_maestro_relacionados_pershing
(
    id              bigint generated always as identity
        constraint tbvw_maestro_relacionados_pershing_pk
            primary key,
    process_date                         varchar(100),
    id_interno_cliente                   integer,
    custodian                            varchar(100),
    client_id                            varchar(100),
    account_no                           varchar(100),
    tipo_identificador_cliente           varchar(100),
    glosa_identificador_cliente          varchar(100),
    office_id                            varchar(100),
    name                                 varchar(100),
    id_relacionado                       integer,
    identificador_relacionado            varchar(100),
    nombre_relacionado                   varchar(100),
    tipo_identificador_relacionado       varchar(100),
    glosa_tipo_identificador_relacionado varchar(100),
    id_cargo                             varchar(100),
    cargo                                varchar(100)
);


create or replace function public.fn_reporte_maestro_materializa_data(_process_date character varying, _tipo_maestro character varying, _custodio character varying) returns bigint
    language plpgsql
as
$$
DECLARE _row_count  BIGINT;


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
            (id, custodian, id_interno_cliente, client_id, name, id_tipo_identificador_cliente, tipo_identificador_cliente, glosa_identificador_cliente, id_interno_cuenta, id_custodio, id_cuenta_custodio, habilitado, fee, ibd_number, id_office, ip_number, account_no, id_proceso, process_date, record_id_sequence_number, account_short_name, full_name, full_address, transaction_type, autotitled_usertitled_account, account_type_code, registration_type, registration_type_value, number_of_account_title_lines, account_registration_line_1, account_registration_line_2, account_registration_line_3, account_registration_line_4, account_registration_line_5, account_registration_line_6, registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions, income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked, statement_review_date, margin_papers_on_file, cash_margin_account, option_papers_on_file, good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted, invest_advisor_discretion_granted_value, third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits, option_total_limits_of_puts_and_calls, non_us_dollar_trading, non_customer_indicator, third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule, group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic, employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date, plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative, commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form, date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form, date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account, foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, country_of_citizenship_code, country_of_citizenship_value, country_of_residence_code, country_of_residence_value, birth_date, age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status, regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, customer_type, fulfillment_method, credit_interest_indicator, ama_indicator, ama_indicator_value, tax_id_type, tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, w_8_date_signed, w_8_effective_date, w_9_date_signed, w_9_effective_date, tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced, date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced, date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced, date_c_notice_status_satisfied, old_account_number, original_account_open_date, unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date, initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code, future_statement_currency_code, future_statement_currency_code_effective_date, account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3, account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip, third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym, alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator, source_of_asset_at_acct_opening, commission_doscount_code, external_account_number, confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside, fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type, mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated, date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id, firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id, second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account, banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code, combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code, proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code, dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona, client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code, addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix, addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4, addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id, addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3, addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind, principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2, from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system, disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks, amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code, addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix, addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4, addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code, addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix, addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4, addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code, addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix, addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4, addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code, addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix, addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4, addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code, addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix, addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4, addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency, income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep, last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind, foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst, foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own, proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension, tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code, tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind, tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id, tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number, tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension, tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address, external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code, cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency)
            SELECT
                id, custodian, id_interno_cliente, client_id, name, id_tipo_identificador_cliente, tipo_identificador_cliente, glosa_identificador_cliente, id_interno_cuenta, id_custodio, id_cuenta_custodio, habilitado, fee, ibd_number, id_office, ip_number, account_no, id_proceso, process_date, record_id_sequence_number, account_short_name, full_name, full_address, transaction_type, autotitled_usertitled_account, account_type_code, registration_type, registration_type_value, number_of_account_title_lines, account_registration_line_1, account_registration_line_2, account_registration_line_3, account_registration_line_4, account_registration_line_5, account_registration_line_6, registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions, income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked, statement_review_date, margin_papers_on_file, cash_margin_account, option_papers_on_file, good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted, invest_advisor_discretion_granted_value, third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits, option_total_limits_of_puts_and_calls, non_us_dollar_trading, non_customer_indicator, third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule, group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic, employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date, plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative, commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form, date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form, date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account, foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, country_of_citizenship_code, country_of_citizenship_value, country_of_residence_code, country_of_residence_value, birth_date, age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status, regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, customer_type, fulfillment_method, credit_interest_indicator, ama_indicator, ama_indicator_value, tax_id_type, tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, w_8_date_signed, w_8_effective_date, w_9_date_signed, w_9_effective_date, tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced, date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced, date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced, date_c_notice_status_satisfied, old_account_number, original_account_open_date, unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date, initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code, future_statement_currency_code, future_statement_currency_code_effective_date, account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3, account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip, third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym, alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator, source_of_asset_at_acct_opening, commission_doscount_code, external_account_number, confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside, fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type, mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated, date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id, firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id, second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account, banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code, combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code, proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code, dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona, client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code, addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix, addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4, addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id, addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3, addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind, principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2, from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system, disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks, amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code, addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix, addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4, addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code, addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix, addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4, addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code, addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix, addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4, addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code, addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix, addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4, addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code, addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix, addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4, addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency, income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep, last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind, foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst, foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own, proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension, tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code, tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind, tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id, tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number, tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension, tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address, external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code, cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency
            FROM public.vw_maestro_cuentas_pershing where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;
            RETURN _row_count;
        END IF;
    END IF;


    IF (_tipo_maestro='SLD') THEN
        IF (_custodio ='PERSHING') THEN
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



--Carga histórica
INSERT INTO public.tbvw_maestro_relacionados_pershing
(process_date, id_interno_cliente, custodian, client_id, account_no, tipo_identificador_cliente, glosa_identificador_cliente, office_id, name, id_relacionado, identificador_relacionado, nombre_relacionado, tipo_identificador_relacionado, glosa_tipo_identificador_relacionado, id_cargo, cargo)
SELECT
    process_date, id_interno_cliente, custodian, client_id, account_no, tipo_identificador_cliente, glosa_identificador_cliente, office_id, name, id_relacionado, identificador_relacionado, nombre_relacionado, tipo_identificador_relacionado, glosa_tipo_identificador_relacionado, id_cargo, cargo
FROM public.vw_reporte_maestro_datos_relacionados --where process_date=_process_date
ORDER BY process_date ASC
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



