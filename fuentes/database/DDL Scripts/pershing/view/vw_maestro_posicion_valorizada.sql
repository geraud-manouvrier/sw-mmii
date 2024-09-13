create or replace view pershing.vw_maestro_posicion_valorizada
            (process_date, process_date_val_his, id_custodian, custodian, tipo_reg, sub_tipo_reg, office_id, ip_number,
             account_number, cusip, quantity, account_type, cash_margin_account, id_currency, currency, fx_rate,
             market_price, market_value, usde_market_price, usde_market_value, symbol, isin_code, security_description,
             product_type, id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo)
as
SELECT process_date,
       process_date_val_his,
       id_custodian,
       custodian,
       tipo_reg,
       sub_tipo_reg,
       office_id,
       ip_number,
       account_number,
       cusip_number                                              AS cusip,
       quantity,
       account_type,
       cash_margin_account,
       id_currency,
       currency,
       fx_rate,
       market_price,
       (
           CASE
               WHEN tipo_reg::text = 'CAJA'::text OR sub_tipo_reg::text = 'C'::text THEN quantity
               ELSE quantity * latest_price
               END * factor_mkv_mult)::numeric(45, 20)           AS market_value,
       CASE
           WHEN tipo_reg::text = 'CAJA'::text THEN 1::numeric(45, 20)
           WHEN sub_tipo_reg::text = 'C'::text THEN fx_rate
           ELSE latest_price * fx_rate
           END::numeric(45, 20)                                  AS usde_market_price,
       (
           CASE
               WHEN tipo_reg::text = 'CAJA'::text OR sub_tipo_reg::text = 'C'::text THEN quantity
               ELSE quantity * latest_price
               END * factor_mkv_mult * fx_rate)::numeric(45, 20) AS usde_market_value,
       security_symbol                                           AS symbol,
       isin_code,
       security_description,
       product_type,
       id_sub_sub_tipo_activo,
       id_sub_tipo_activo,
       id_tipo_activo,
       nombre_sub_sub_tipo_activo
FROM (SELECT 'pershing'::character varying(100)                                                            AS id_custodian,
             fn_obtiene_valor_parametro('custodian'::character varying,
                                        'pershing'::character varying)::character varying(100)             AS custodian,
             vw_pos.tipo_reg,
             vw_pos.sub_tipo_reg,
             vw_pos.flag_informar,
             vw_pos.ip_number,
             vw_pos.process_date,
             vw_pos.account_number,
             "left"(vw_pos.account_number, 3)::character varying(100)                                      AS office_id,
             vw_pos.account_type,
             pershing.fn_obtiene_valor_param_generic_pershing('account_type'::character varying,
                                                              vw_pos.account_type)::character varying(100) AS cash_margin_account,
             vw_pos.security_symbol,
             vw_pos.cusip_number,
             TRIM(BOTH FROM (((((((((TRIM(BOTH FROM vw_pos.security_description_line_1) || ' '::text) ||
                                    TRIM(BOTH FROM vw_pos.security_description_line_2)) || ' '::text) ||
                                  TRIM(BOTH FROM vw_pos.security_description_line_3)) || ' '::text) ||
                                TRIM(BOTH FROM vw_pos.security_description_line_4)) || ' '::text) ||
                              TRIM(BOTH FROM vw_pos.security_description_line_5)) || ' '::text) ||
                            TRIM(BOTH FROM vw_pos.security_description_line_6))::character varying(100)    AS security_description,
             vw_pos.currency                                                                               AS id_currency,
             vw_pos.quantity,
             CASE
                 WHEN vw_pos.tipo_reg::text = 'CAJA'::text OR vw_pos.sub_tipo_reg::text = 'C'::text THEN 1::numeric
                 ELSE val_his.latest_price
                 END::numeric(45, 20)                                                                      AS market_price,
             val_his.process_date                                                                          AS process_date_val_his,
             val_his.latest_price,
             CASE
                 WHEN vw_pos.tipo_reg::text = 'CAJA'::text THEN 1::numeric
                 ELSE val_his.exchange_rate_denom_currency_usd
                 END::numeric(45, 20)                                                                      AS fx_rate,
             COALESCE(val_his.factored_market_value_multiplier,
                      1::numeric(45, 20))                                                                  AS factor_mkv_mult,
             CASE
                 WHEN vw_pos.tipo_reg::text = 'CAJA'::text THEN vw_pos.cusip_number
                 ELSE val_his.isin_code
                 END                                                                                       AS isin_code,
             par_crrcy.codigo                                                                              AS currency,
             par_asset.id_sub_sub_tipo                                                                     AS product_type,
             par_asset.id_sub_sub_tipo                                                                     AS id_sub_sub_tipo_activo,
             par_asset.id_sub_tipo                                                                         AS id_sub_tipo_activo,
             par_asset.id_tipo                                                                             AS id_tipo_activo,
             par_asset.glosa                                                                               AS nombre_sub_sub_tipo_activo
      FROM pershing.vw_maestro_posicion vw_pos
               LEFT JOIN pershing.sfl_isca_historica val_his
                         ON vw_pos.process_date::text = val_his.process_date::text AND
                            vw_pos.cusip_number::text = val_his.cusip_number::text
               LEFT JOIN par_maestro_monedas par_crrcy ON vw_pos.currency::text = par_crrcy.cod_pershing::text
               LEFT JOIN pershing.par_asset_type_code par_asset ON
          CASE
              WHEN vw_pos.tipo_reg::text = 'CAJA'::text THEN 'MONEY'::text = par_asset.id_sub_sub_tipo::text
              ELSE TRIM(BOTH FROM val_his.asset_type) = TRIM(BOTH FROM par_asset.id_tipo) AND
                   TRIM(BOTH FROM val_his.asset_subtype) = TRIM(BOTH FROM par_asset.id_sub_tipo) AND
                   TRIM(BOTH FROM val_his.asset_subsubtype) = TRIM(BOTH FROM par_asset.id_sub_sub_tipo)
              END
      WHERE vw_pos.flag_informar) t_pos;

alter table pershing.vw_maestro_posicion_valorizada
    owner to postgres;

