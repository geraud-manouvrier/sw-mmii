create or replace view public.vw_maestro_movimientos_pershing
            (custodian, client_id, tipo_identificador_cliente, office_id, account_no, name, process_date, tipo_reg,
             trade_date, settlement_date, activity, buy_sell_code, buy_sell_value, quantity, price, commission, fees,
             net_amount, usde_net_amount, principal, cusip, symbol, isin, currency, fx_rate, interest, currency_base,
             cash_margin, product_type, security_description, activity_description, activity_code, source_code,
             description_1, description_2, description_3, ticker, id_sub_sub_tipo, id_sub_tipo, id_tipo,
             nombre_sub_sub_tipo, flujo_neto, ingreso_egreso, retiro, recaudo, id_cuenta_custodio)
as
SELECT custodian,
       client_id,
       tipo_identificador_cliente,
       office_id,
       account_no,
       name,
       process_date,
       tipo_reg,
       trade_date,
       settlement_date,
       activity,
       buy_sell_code,
       buy_sell_value,
       quantity,
       price,
       commission,
       fees,
       net_amount,
       usde_net_amount,
       principal,
       cusip,
       symbol,
       isin,
       currency,
       fx_rate,
       interest,
       currency_base,
       cash_margin,
       product_type,
       security_description,
       activity_description,
       activity_code,
       source_code,
       description_1,
       description_2,
       description_3,
       ticker,
       id_sub_sub_tipo,
       id_sub_tipo,
       id_tipo,
       nombre_sub_sub_tipo,
       flujo_neto,
       ingreso_egreso,
       CASE
           WHEN ingreso_egreso AND usde_net_amount < 0::numeric THEN abs(usde_net_amount)
           ELSE 0::numeric
           END::numeric(45, 20) AS retiro,
       CASE
           WHEN ingreso_egreso AND usde_net_amount > 0::numeric THEN abs(usde_net_amount)
           ELSE 0::numeric
           END::numeric(45, 20) AS recaudo,
       id_cuenta_custodio
FROM (SELECT vw_mov_persh.custodian,
             maestro_crm.identificador_cliente                                                                      AS client_id,
             maestro_crm.tipo_identificador_cliente,
             vw_mov_persh.office_id,
             vw_mov_persh.account_no,
             COALESCE(maestro_crm.nombre_cliente, vw_act.full_name)                                                 AS name,
             vw_mov_persh.process_date,
             vw_mov_persh.tipo_reg,
             COALESCE(vw_mov_persh.trade_date, fn_fecha_string_to_date(vw_mov_persh.process_date,
                                                                       'YYYYMMDD'::character varying))              AS trade_date,
             vw_mov_persh.settlement_date,
             par_src_cod.descripcion_movimiento                                                                     AS activity,
             vw_mov_persh.buy_sell_code,
             vw_mov_persh.buy_sell_value,
             COALESCE(vw_mov_persh.quantity,
                      CASE
                          WHEN vw_mov_persh.price <> 0::numeric THEN vw_mov_persh.net_amount / vw_mov_persh.price
                          ELSE NULL::numeric
                          END)::numeric(45, 20)                                                                     AS quantity,
             vw_mov_persh.price,
             vw_mov_persh.commission,
             vw_mov_persh.total_fees                                                                                AS fees,
             COALESCE(vw_mov_persh.net_amount, vw_mov_persh.quantity * vw_mov_persh.price *
                                               COALESCE(vw_mov_persh.factored_market_value_multiplier,
                                                        1::numeric(45, 20)))::numeric(45, 20)                       AS net_amount,
             COALESCE(vw_mov_persh.usde_net_amount, vw_mov_persh.quantity * vw_mov_persh.price * vw_mov_persh.fx_rate *
                                                    COALESCE(vw_mov_persh.factored_market_value_multiplier,
                                                             1::numeric(45, 20)))::numeric(45, 20)                  AS usde_net_amount,
             COALESCE(vw_mov_persh.principal, vw_mov_persh.net_amount,
                      vw_mov_persh.quantity * vw_mov_persh.price * vw_mov_persh.fx_rate *
                      COALESCE(vw_mov_persh.factored_market_value_multiplier,
                               1::numeric(45, 20)))::numeric(45, 20)                                                AS principal,
             vw_mov_persh.cusip,
             CASE
                 WHEN TRIM(BOTH FROM COALESCE(vw_mov_persh.symbol, ''::character varying)) = ''::text AND
                      vw_mov_persh.cusip::text = 'USD999997'::text THEN vw_mov_persh.cusip
                 ELSE vw_mov_persh.symbol
                 END                                                                                                AS symbol,
             vw_mov_persh.isin,
             vw_mov_persh.currency,
             vw_mov_persh.fx_rate,
             vw_mov_persh.interest,
             vw_mov_persh.currency_base,
             vw_mov_persh.cash_margin,
             vw_mov_persh.id_sub_sub_tipo                                                                           AS product_type,
             vw_mov_persh.security_description,
             CASE
                 WHEN vw_mov_persh.tipo_reg::text = 'NON_TDE'::text THEN
                     CASE
                         WHEN TRIM(BOTH FROM vw_mov_persh.source_code) = 'CHRG'::text AND
                              POSITION(('FgnFee'::text) IN (vw_mov_persh.description_1)) = 0 THEN TRIM(BOTH FROM
                                                                                                       (((TRIM(BOTH FROM vw_mov_persh.description_1) || ' '::text) ||
                                                                                                         TRIM(BOTH FROM vw_mov_persh.description_2)) ||
                                                                                                        ' '::text) ||
                                                                                                       TRIM(BOTH FROM vw_mov_persh.description_3))
                         ELSE par_src_cod.descripcion_movimiento::text
                         END
                 WHEN vw_mov_persh.isin::text = '9999246'::text THEN
                     (((((((COALESCE(vw_mov_persh.buy_sell_value, ''::character varying)::character varying(100)::text ||
                            ' $'::text) ||
                           COALESCE(abs(vw_mov_persh.net_amount::numeric(45, 2))::character varying(100),
                                    ''::character varying)::character varying(100)::text) || ' ISIN #'::text) ||
                         COALESCE(vw_mov_persh.isin, ''::character varying)::character varying(100)::text) ||
                        ' TD:'::text) || COALESCE((((substr(vw_mov_persh.trade_date::text, 6, 2) || '/'::text) ||
                                                    substr(vw_mov_persh.trade_date::text, 9, 2)) || '/'::text) ||
                                                  substr(vw_mov_persh.trade_date::text, 1, 4),
                                                  ''::text)::character varying(100)::text) || ' SD:'::text) || COALESCE(
                             (((substr(vw_mov_persh.settlement_date::text, 6, 2) || '/'::text) ||
                               substr(vw_mov_persh.settlement_date::text, 9, 2)) || '/'::text) ||
                             substr(vw_mov_persh.settlement_date::text, 1, 4), ''::text)::character varying(100)::text
                 ELSE
                     (((((((((COALESCE(vw_mov_persh.buy_sell_value, ''::character varying)::character varying(100)::text ||
                              ' '::text) || COALESCE(abs(vw_mov_persh.quantity::numeric(45, 2))::character varying(100),
                                                     ''::character varying)::character varying(100)::text) ||
                            ' SHRS OF ISIN #'::text) ||
                           COALESCE(vw_mov_persh.isin, ''::character varying)::character varying(100)::text) ||
                          ' PRICE: $'::text) || COALESCE(vw_mov_persh.price::numeric(45, 4)::character varying(100),
                                                         ''::character varying)::character varying(100)::text) ||
                        ' TD:'::text) || COALESCE((((substr(vw_mov_persh.trade_date::text, 6, 2) || '/'::text) ||
                                                    substr(vw_mov_persh.trade_date::text, 9, 2)) || '/'::text) ||
                                                  substr(vw_mov_persh.trade_date::text, 1, 4),
                                                  ''::text)::character varying(100)::text) || ' SD:'::text) || COALESCE(
                             (((substr(vw_mov_persh.settlement_date::text, 6, 2) || '/'::text) ||
                               substr(vw_mov_persh.settlement_date::text, 9, 2)) || '/'::text) ||
                             substr(vw_mov_persh.settlement_date::text, 1, 4), ''::text)::character varying(100)::text
                 END::character varying(100)                                                                        AS activity_description,
             vw_mov_persh.source_code                                                                               AS activity_code,
             vw_mov_persh.source_code,
             vw_mov_persh.description_1,
             vw_mov_persh.description_2,
             vw_mov_persh.description_3,
             vw_mov_persh.ticker,
             vw_mov_persh.id_sub_sub_tipo,
             vw_mov_persh.id_sub_tipo,
             vw_mov_persh.id_tipo,
             par_asset.glosa::character varying(100)                                                                AS nombre_sub_sub_tipo,
             par_src_cod.aplica_flujo_neto                                                                          AS flujo_neto,
             par_src_cod.aplica_flujo_neto = 1                                                                      AS ingreso_egreso,
             maestro_crm.id_cuenta_custodio
      FROM (SELECT 'pershing'::character varying(100)                                                                                                   AS id_custodian,
                   fn_obtiene_valor_parametro('custodian'::character varying,
                                              'pershing'::character varying)::character varying(100)                                                    AS custodian,
                   "left"(tb_mov.account_number::text, 3)::character varying(100)                                                                       AS office_id,
                   "left"(tb_mov.account_number::text, 9)::character varying(100)                                                                       AS account_no,
                   tb_mov.account_number                                                                                                                AS account_number_full,
                   pershing.fn_obtiene_valor_param_generic_pershing('account_type'::character varying,
                                                                    "right"(tb_mov.account_number::text, 1)::character varying)::character varying(100) AS cash_margin,
                   tb_mov.process_date,
                   CASE
                       WHEN tb_mov.buy_sell_code::text <> ALL
                            (ARRAY ['B'::character varying::text, 'S'::character varying::text]) THEN 'NON_TDE'::text
                       ELSE 'TDE_INST'::text
                       END::character varying(100)                                                                                                      AS tipo_reg,
                   tb_mov.trade_date,
                   tb_mov.settlement_entry_date                                                                                                         AS settlement_date,
                   tb_mov.buy_sell_code,
                   pershing.fn_obtiene_valor_param_generic_pershing('buy_sell_code'::character varying,
                                                                    tb_mov.buy_sell_code)::character varying(100)                                       AS buy_sell_value,
                   tb_mov.quantity,
                   COALESCE(tb_mov.price_in_trade_currency, tb_det.latest_price)                                                                        AS price,
                   COALESCE(tb_mov.commision_in_usd, 0::numeric)::numeric(45, 20)                                                                       AS commission,
                   (COALESCE(tb_mov.misc_fee_in_usd, 0::numeric) + COALESCE(tb_mov.other_fee_in_usd, 0::numeric) +
                    COALESCE(tb_mov.settlement_fee_in_usd, 0::numeric) +
                    COALESCE(tb_mov.transaction_fee_in_usd, 0::numeric))::numeric(45, 20)                                                               AS total_fees,
                   (tb_mov.net_amount_in_usd * '-1'::integer::numeric)::numeric(45, 20)                                                                 AS net_amount,
                   tb_mov.net_amount_in_usd * '-1'::integer::numeric *
                   tb_mov.settlement_usd_currency_fx_rate                                                                                               AS usde_net_amount,
                   tb_mov.principal_in_usd                                                                                                              AS principal,
                   tb_mov.cusip_number                                                                                                                  AS cusip,
                   tb_mov.security_symbol                                                                                                               AS symbol,
                   tb_det.isin_code                                                                                                                     AS isin,
                   tb_mov.trade_currency_code                                                                                                           AS currency,
                   tb_mov.settlement_usd_currency_fx_rate                                                                                               AS fx_rate,
                   COALESCE(tb_mov.interest_in_usd, 0::numeric)::numeric(45, 20)                                                                        AS interest,
                   tb_mov.security_currency_of_issuance                                                                                                 AS currency_base,
                   TRIM(BOTH FROM (((((((((TRIM(BOTH FROM tb_det.secutiry_description_line_1) || ' '::text) ||
                                          TRIM(BOTH FROM tb_det.secutiry_description_line_2)) || ' '::text) ||
                                        TRIM(BOTH FROM tb_det.secutiry_description_line_3)) || ' '::text) ||
                                      TRIM(BOTH FROM tb_det.secutiry_description_line_4)) || ' '::text) ||
                                    TRIM(BOTH FROM tb_det.secutiry_description_line_5)) || ' '::text) ||
                                  TRIM(BOTH FROM tb_det.secutiry_description_line_6))::character varying(100)                                           AS security_description,
                   CASE
                       WHEN tb_mov.transaction_type::text = 'T'::text THEN 'TDE'::character varying
                       ELSE tb_mov.source_code
                       END::character varying(100)                                                                                                      AS source_code,
                   TRIM(BOTH FROM tb_mov.description_line_1)                                                                                            AS description_1,
                   TRIM(BOTH FROM tb_mov.description_line_2)                                                                                            AS description_2,
                   TRIM(BOTH FROM tb_mov.description_line_3)                                                                                            AS description_3,
                   tb_mov.security_symbol                                                                                                               AS ticker,
                   tb_det.asset_subsubtype                                                                                                              AS id_sub_sub_tipo,
                   tb_det.asset_subtype                                                                                                                 AS id_sub_tipo,
                   tb_det.asset_type                                                                                                                    AS id_tipo,
                   tb_det.factored_market_value_multiplier
            FROM pershing.sfl_gact tb_mov
                     LEFT JOIN pershing.sfl_isca tb_det ON tb_mov.process_date::text = tb_det.process_date::text AND
                                                           tb_mov.cusip_number::text = tb_det.cusip_number::text
            WHERE
                TRIM(BOTH FROM tb_mov.source_code) <> ALL (ARRAY ['ITS'::text, 'SGR'::text, 'NET'::text])) vw_mov_persh
               LEFT JOIN clientes.vw_maestro_clientes_cuentas maestro_crm
                         ON vw_mov_persh.id_custodian::text = maestro_crm.id_custodio::text AND
                            vw_mov_persh.account_no::text = maestro_crm.id_cuenta_custodio::text
               LEFT JOIN pershing.vw_maestro_cuenta vw_act
                         ON vw_mov_persh.account_no::text = vw_act.account_number::text AND
                            vw_mov_persh.process_date::text = vw_act.process_date::text
               LEFT JOIN par_source_code par_src_cod
                         ON TRIM(BOTH FROM vw_mov_persh.source_code) = par_src_cod.source_code_pershing::text AND
                            (par_src_cod.signo_movimiento IS NULL OR
                             CASE
                                 WHEN COALESCE(vw_mov_persh.quantity,
                                               CASE
                                                   WHEN vw_mov_persh.price <> 0::numeric
                                                       THEN vw_mov_persh.net_amount / vw_mov_persh.price
                                                   ELSE NULL::numeric
                                                   END)::numeric(45, 20) >= 0::numeric
                                     THEN par_src_cod.signo_movimiento >= 0
                                 ELSE par_src_cod.signo_movimiento < 0
                                 END)
               LEFT JOIN pershing.par_asset_type_code par_asset
                         ON TRIM(BOTH FROM vw_mov_persh.id_tipo) = TRIM(BOTH FROM par_asset.id_tipo) AND
                            TRIM(BOTH FROM vw_mov_persh.id_sub_tipo) = TRIM(BOTH FROM par_asset.id_sub_tipo) AND
                            TRIM(BOTH FROM vw_mov_persh.id_sub_sub_tipo) = TRIM(BOTH FROM par_asset.id_sub_sub_tipo)
      WHERE CASE
                WHEN par_src_cod.source_code_pershing IS NULL AND
                     COALESCE(vw_mov_persh.net_amount, vw_mov_persh.quantity * vw_mov_persh.price) = 0::numeric
                    THEN false
                ELSE true
                END) tb_mov_persh;

alter table public.vw_maestro_movimientos_pershing
    owner to postgres;

