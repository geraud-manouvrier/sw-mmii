create or replace view public.vw_reporte_maestro_datos_clientes
            (row_id, id_reg, custodian, client_id, firm_no, sub_no, rep_no, office_id, account_no, name, full_name,
             address, short_name, date_of_birth, acct_status_value, email, country_code_value, country, w8_date,
             w9_date, w8_status_value, w9_status_value, discr_trading_code_value, account_type, cash_margin_account,
             debit_card_indicator, open_date, close_date, participant_type, last_statement_date, tax_id, process_date,
             is_last_info, is_last_schema_by_account_no)
as
SELECT rank() OVER (ORDER BY row_id, src_vw) AS row_id,
       id_reg,
       custodian,
       client_id,
       firm_no,
       sub_no,
       rep_no,
       office_id,
       account_no,
       name,
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
             upper(vw_acct.custodian::text)::character varying(100)                                                     AS custodian,
             upper(vw_acct.client_id::text)::character varying(100)                                                     AS client_id,
             vw_acct.ibd_number                                                                                         AS firm_no,
             vw_acct.id_office::character varying(100)                                                                  AS sub_no,
             upper(vw_acct.ip_number::text)::character varying(100)                                                     AS rep_no,
             upper(vw_acct.id_office)::character varying(100)                                                           AS office_id,
             upper(vw_acct.account_no::text)::character varying(100)                                                    AS account_no,
             upper(vw_acct.name::text)::character varying(100)                                                          AS name,
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
             true                                                                                                       AS is_last_schema_by_account_no
      FROM tbvw_maestro_cuentas_pershing vw_acct
      UNION
      SELECT 'C'::text                                            AS src_vw,
             rank() OVER (ORDER BY cta_no_inf.id)                 AS row_id,
             cta_no_inf.id                                        AS id_reg,
             cta_no_inf.custodian,
             cta_no_inf.client_id,
             cta_no_inf.firm_no,
             cta_no_inf.sub_no,
             cta_no_inf.rep_no,
             cta_no_inf.office_id,
             cta_no_inf.account_no,
             cta_no_inf.name,
             cta_no_inf.full_name,
             cta_no_inf.address,
             cta_no_inf.short_name,
             cta_no_inf.date_of_birth,
             cta_no_inf.acct_status_value,
             cta_no_inf.email,
             cta_no_inf.country_code_value,
             cta_no_inf.country,
             cta_no_inf.w8_date,
             cta_no_inf.w9_date,
             cta_no_inf.w8_status_value,
             cta_no_inf.w9_status_value,
             cta_no_inf.discr_trading_code_value,
             cta_no_inf.account_type,
             cta_no_inf.cash_margin_account,
             cta_no_inf.debit_card_indicator,
             cta_no_inf.open_date,
             cta_no_inf.close_date,
             cta_no_inf.participant_type::character varying(1000) AS participant_type,
             cta_no_inf.last_statement_date,
             cta_no_inf.tax_id,
             cta_no_inf.process_date,
             cta_no_inf.is_last_info,
             cta_no_inf.is_last_schema_by_account_no
      FROM rectificacion_cuentas_no_informadas cta_no_inf
      WHERE cta_no_inf.id_estado_rectificacion = 0) vw_union
ORDER BY process_date, client_id, account_no;

alter table public.vw_reporte_maestro_datos_clientes
    owner to postgres;

