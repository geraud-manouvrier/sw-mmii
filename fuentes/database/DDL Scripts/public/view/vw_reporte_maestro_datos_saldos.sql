create or replace view public.vw_reporte_maestro_datos_saldos
            (row_id, id_reg, tipo_reg, custodian, client_id, firm_no, sub_no, office_id, rep_no, rep, account_no, name,
             process_date, symbol, cusip, isin, product_type, security_description, cash_margin_account, quantity,
             market_price, currency, market_value, fx_rate, usde_market_value, factor, comision_devengada_diaria,
             usde_market_price, sec_no, desc_1, desc_2, desc_3, sedol, ticker, id_sub_sub_tipo_activo,
             id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo, sec_id, advisory_fee_anual, process_stamp,
             acct_type, currency_sequence)
as
SELECT rank() OVER (ORDER BY row_id, src_vw) AS row_id,
       id_reg,
       tipo_reg,
       custodian,
       client_id,
       firm_no,
       sub_no,
       office_id,
       rep_no,
       rep,
       account_no,
       name,
       process_date,
       symbol,
       cusip,
       isin,
       product_type,
       security_description,
       cash_margin_account,
       quantity,
       market_price,
       currency,
       market_value,
       fx_rate,
       usde_market_value,
       factor,
       comision_devengada_diaria,
       usde_market_price,
       sec_no,
       desc_1,
       desc_2,
       desc_3,
       sedol,
       ticker,
       id_sub_sub_tipo_activo,
       id_sub_tipo_activo,
       id_tipo_activo,
       nombre_sub_sub_tipo_activo,
       sec_id,
       advisory_fee_anual,
       process_stamp,
       acct_type,
       currency_sequence
FROM (SELECT 'B'::text                                                                                                                                                                                                                                                                                                                        AS src_vw,
             rank()
             OVER (ORDER BY vw_sld.tipo_reg, vw_sld.process_date, vw_sld.custodian, vw_sld.account_no, vw_sld.cash_margin_account, vw_sld.symbol, vw_sld.cusip, vw_sld.isin_code, vw_sld.quantity, vw_sld.market_price, vw_sld.market_value, vw_sld.usde_market_value, vw_sld.usde_market_price, vw_sld.desc_1, vw_sld.desc_2, vw_sld.desc_3) AS row_id,
             rank()
             OVER (ORDER BY vw_sld.tipo_reg, vw_sld.process_date, vw_sld.custodian, vw_sld.account_no, vw_sld.cash_margin_account, vw_sld.symbol, vw_sld.cusip, vw_sld.isin_code, vw_sld.quantity, vw_sld.market_price, vw_sld.market_value, vw_sld.usde_market_value, vw_sld.usde_market_price, vw_sld.desc_1, vw_sld.desc_2, vw_sld.desc_3) AS id_reg,
             vw_sld.tipo_reg,
             vw_sld.custodian,
             vw_sld.client_id,
             vw_sld.firm_no,
             vw_sld.sub_no,
             vw_sld.office_id,
             vw_sld.rep_no,
             vw_sld.rep,
             vw_sld.account_no,
             upper(vw_sld.name::text)::character varying(100)                                                                                                                                                                                                                                                                                 AS name,
             vw_sld.process_date,
             upper(vw_sld.symbol::text)::character varying(100)                                                                                                                                                                                                                                                                               AS symbol,
             upper(vw_sld.cusip::text)::character varying(100)                                                                                                                                                                                                                                                                                AS cusip,
             upper(vw_sld.isin_code::text)::character varying(100)                                                                                                                                                                                                                                                                            AS isin,
             upper(vw_sld.product_type::text)::character varying(100)                                                                                                                                                                                                                                                                         AS product_type,
             upper(vw_sld.security_description::text)::character varying(100)                                                                                                                                                                                                                                                                 AS security_description,
             upper(vw_sld.cash_margin_account::text)::character varying(1000)                                                                                                                                                                                                                                                                 AS cash_margin_account,
             vw_sld.quantity,
             vw_sld.market_price,
             vw_sld.currency,
             vw_sld.market_value,
             vw_sld.fx_rate,
             vw_sld.usde_market_value,
             vw_sld.factor,
             vw_sld.comision_devengada_diaria,
             vw_sld.usde_market_price,
             vw_sld.sec_no,
             upper(vw_sld.desc_1::text)::character varying(100)                                                                                                                                                                                                                                                                               AS desc_1,
             upper(vw_sld.desc_2::text)::character varying(100)                                                                                                                                                                                                                                                                               AS desc_2,
             upper(vw_sld.desc_3::text)::character varying(100)                                                                                                                                                                                                                                                                               AS desc_3,
             upper(vw_sld.sedol::text)::character varying(100)                                                                                                                                                                                                                                                                                AS sedol,
             upper(vw_sld.ticker::text)::character varying(100)                                                                                                                                                                                                                                                                               AS ticker,
             upper(vw_sld.id_sub_sub_tipo_activo::text)::character varying(100)                                                                                                                                                                                                                                                               AS id_sub_sub_tipo_activo,
             upper(vw_sld.id_sub_tipo_activo::text)::character varying(100)                                                                                                                                                                                                                                                                   AS id_sub_tipo_activo,
             upper(vw_sld.id_tipo_activo::text)::character varying(100)                                                                                                                                                                                                                                                                       AS id_tipo_activo,
             upper(vw_sld.nombre_sub_sub_tipo_activo::text)::character varying(100)                                                                                                                                                                                                                                                           AS nombre_sub_sub_tipo_activo,
             upper(vw_sld.sec_id::text)::character varying(100)                                                                                                                                                                                                                                                                               AS sec_id,
             vw_sld.advisory_fee_anual,
             NULL::character varying(100)                                                                                                                                                                                                                                                                                                     AS process_stamp,
             NULL::integer                                                                                                                                                                                                                                                                                                                    AS acct_type,
             NULL::integer                                                                                                                                                                                                                                                                                                                    AS currency_sequence
      FROM tbvw_maestro_saldos_pershing vw_sld
      WHERE vw_sld.quantity <> 0::numeric
      UNION
      SELECT 'C'::text                            AS src_vw,
             rank() OVER (ORDER BY sld_no_inf.id) AS row_id,
             sld_no_inf.id                        AS id_reg,
             sld_no_inf.tipo_reg,
             sld_no_inf.custodian,
             sld_no_inf.client_id,
             sld_no_inf.firm_no,
             sld_no_inf.sub_no,
             sld_no_inf.office_id,
             sld_no_inf.rep_no,
             sld_no_inf.rep,
             sld_no_inf.account_no,
             sld_no_inf.name,
             sld_no_inf.process_date,
             sld_no_inf.symbol,
             sld_no_inf.cusip,
             sld_no_inf.isin,
             sld_no_inf.product_type,
             sld_no_inf.security_description,
             sld_no_inf.cash_margin_account,
             sld_no_inf.quantity,
             sld_no_inf.market_price,
             sld_no_inf.currency,
             sld_no_inf.market_value,
             sld_no_inf.fx_rate,
             sld_no_inf.usde_market_value,
             sld_no_inf.factor,
             sld_no_inf.comision_devengada_diaria,
             sld_no_inf.usde_market_price,
             sld_no_inf.sec_no,
             sld_no_inf.desc_1,
             sld_no_inf.desc_2,
             sld_no_inf.desc_3,
             sld_no_inf.sedol,
             sld_no_inf.ticker,
             sld_no_inf.id_sub_sub_tipo_activo,
             sld_no_inf.id_sub_tipo_activo,
             sld_no_inf.id_tipo_activo,
             sld_no_inf.nombre_sub_sub_tipo_activo,
             sld_no_inf.sec_id,
             sld_no_inf.advisory_fee_anual,
             sld_no_inf.process_stamp,
             sld_no_inf.acct_type,
             sld_no_inf.currency_sequence
      FROM rectificacion_saldos_no_informados sld_no_inf
      WHERE sld_no_inf.id_estado_rectificacion = 0) vw_union
ORDER BY process_date, client_id, account_no, product_type, cusip;

alter table public.vw_reporte_maestro_datos_saldos
    owner to postgres;

