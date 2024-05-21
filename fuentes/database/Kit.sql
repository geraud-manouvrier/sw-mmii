/*
2024-05-20
Actual: 8.0.0-COL
Last:   7.0.0-COL
*/

--========================================================================
--========================================================================
--========================================================================
--Creción de usuarios admin y app
/*
CREATE USER mmii_admindb CREATEDB CREATEROLE PASSWORD 'b55tO<RB4aza';
GRANT azure_pg_admin TO mmii_admindb;
--create database qande_mmii with owner mmii_admindb;
create database qande_mmii;
CREATE USER mmii_appuserdb PASSWORD 'H;859md+5GAf';
GRANT CONNECT ON DATABASE qande_mmii TO mmii_appuserdb;
--ALTER DEFAULT PRIVILEGES FOR ROLE mmii_appuserdb GRANT SELECT, INSERT, DELETE ON TABLES TO mmii_appuserdb;
--ALTER DEFAULT PRIVILEGES FOR ROLE mmii_appuserdb GRANT EXECUTE ON FUNCTIONS TO mmii_appuserdb;
*/

--========================================================================
--========================================================================
--========================================================================
--Columna Tipo Identificador a reportes maestros (sólo saldos y movimientos; ya está en cuentas)

ALTER TABLE public.tbvw_maestro_movimientos_pershing ADD COLUMN tipo_identificador_cliente VARCHAR(100) NULL;
ALTER TABLE public.tbvw_maestro_saldos_pershing ADD COLUMN tipo_identificador_cliente VARCHAR(100) NULL;

--Actualizamos los valores de la columna tipo_identificador (Todos son CC actualmente)
UPDATE public.tbvw_maestro_movimientos_pershing MSTR
SET tipo_identificador_cliente = (SELECT tipo_identificador_cliente FROM clientes.vw_maestro_clientes_cuentas WHERE identificador_cliente=MSTR.client_id);
UPDATE public.tbvw_maestro_saldos_pershing MSTR
SET tipo_identificador_cliente = (SELECT tipo_identificador_cliente FROM clientes.vw_maestro_clientes_cuentas WHERE identificador_cliente=MSTR.client_id);

--Verificación
SELECT distinct client_id, tipo_identificador_cliente FROM public.tbvw_maestro_movimientos_pershing;
SELECT distinct client_id, tipo_identificador_cliente FROM public.tbvw_maestro_saldos_pershing;

--========================================================================
--========================================================================
--========================================================================
--Modificación de vistas SALDOS
DROP FUNCTION public.fn_reporte_maestro_datos_saldos;
DROP VIEW public.vw_reporte_maestro_datos_saldos;
DROP VIEW public.vw_maestro_saldos_pershing;


create or replace view public.vw_maestro_saldos_pershing
as
SELECT pos.custodian,
       pos.tipo_reg,
       pos.client_id,
       pos.tipo_identificador_cliente,
       pos.office_id,
       pos.account_no,
       pos.name,
       pos.process_date,
       pos.symbol,
       pos.cusip,
       pos.isin_code,
       pos.product_type,
       pos.security_description,
       pos.cash_margin_account,
       pos.quantity,
       pos.market_price,
       pos.id_currency,
       pos.currency,
       pos.market_value,
       pos.fx_rate,
       pos.usde_market_value,
       pos.total_usde_market_value::numeric(45, 20)                            AS total_usde_market_value,
       tb_fee.id                                                               AS id_fee_aplicado,
       tb_fee.annual_fee,
       tb_fee.tasa_proteccion,
       tb_fee.tasa_suracorp,
       tb_fee.fee_diario,
       tb_fee.fee_diario_proteccion,
       tb_fee.fee_diario_sura_corp,
       (pos.usde_market_value * tb_fee.fee_diario)::numeric(45, 20)            AS comision_devengada_diaria,
       (pos.usde_market_value * tb_fee.fee_diario_proteccion)::numeric(45, 20) AS ingreso_proteccion,
       pos.usde_market_price,
       pos.id_sub_sub_tipo_activo,
       pos.id_sub_tipo_activo,
       pos.id_tipo_activo,
       pos.nombre_sub_sub_tipo_activo
FROM (SELECT vw_pos_val.custodian,
             vw_pos_val.tipo_reg,
             maestro_crm.identificador_cliente                                                                        AS client_id,
             maestro_crm.tipo_identificador_cliente,
             vw_pos_val.office_id,
             vw_pos_val.account_number                                                                                AS account_no,
             maestro_crm.nombre_cliente                                                                               AS name,
             vw_pos_val.process_date,
             vw_pos_val.symbol,
             vw_pos_val.cusip,
             vw_pos_val.isin_code,
             vw_pos_val.product_type,
             vw_pos_val.security_description,
             vw_pos_val.cash_margin_account,
             vw_pos_val.quantity,
             vw_pos_val.market_price,
             vw_pos_val.id_currency,
             vw_pos_val.currency,
             vw_pos_val.market_value,
             vw_pos_val.fx_rate,
             vw_pos_val.usde_market_value,
             sum(vw_pos_val.usde_market_value)
             OVER (PARTITION BY vw_pos_val.process_date, vw_pos_val.account_number)                                   AS total_usde_market_value,
             vw_pos_val.usde_market_price,
             vw_pos_val.id_sub_sub_tipo_activo,
             vw_pos_val.id_sub_tipo_activo,
             vw_pos_val.id_tipo_activo,
             vw_pos_val.nombre_sub_sub_tipo_activo
      FROM pershing.vw_maestro_posicion_valorizada vw_pos_val
               LEFT JOIN clientes.vw_maestro_clientes_cuentas maestro_crm
                         ON vw_pos_val.id_custodian::text = maestro_crm.id_custodio::text AND
                            vw_pos_val.account_number = maestro_crm.id_cuenta_custodio::text) pos
         LEFT JOIN clientes.par_fee_segmento tb_fee ON pos.total_usde_market_value >= tb_fee.monto_min AND
                                                       pos.total_usde_market_value < tb_fee.monto_max;


create or replace view public.vw_reporte_maestro_datos_saldos
as
SELECT rank() OVER (ORDER BY row_id, src_vw) AS row_id,
       id_reg,
       tipo_reg,
       custodian,
       client_id,
       tipo_identificador_cliente,
       office_id,
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
       comision_devengada_diaria,
       usde_market_price,
       id_sub_sub_tipo_activo,
       id_sub_tipo_activo,
       id_tipo_activo,
       nombre_sub_sub_tipo_activo,
       total_usde_market_value,
       ingreso_proteccion,
       annual_fee,
       tasa_proteccion,
       tasa_suracorp,
       fee_diario,
       fee_diario_proteccion,
       fee_diario_sura_corp
FROM (SELECT 'B'::text                                                                                                                                                                                                                                                                           AS src_vw,
             rank()
             OVER (ORDER BY vw_sld.tipo_reg, vw_sld.process_date, vw_sld.custodian, vw_sld.account_no, vw_sld.cash_margin_account, vw_sld.symbol, vw_sld.cusip, vw_sld.isin_code, vw_sld.quantity, vw_sld.market_price, vw_sld.market_value, vw_sld.usde_market_value, vw_sld.usde_market_price) AS row_id,
             rank()
             OVER (ORDER BY vw_sld.tipo_reg, vw_sld.process_date, vw_sld.custodian, vw_sld.account_no, vw_sld.cash_margin_account, vw_sld.symbol, vw_sld.cusip, vw_sld.isin_code, vw_sld.quantity, vw_sld.market_price, vw_sld.market_value, vw_sld.usde_market_value, vw_sld.usde_market_price) AS id_reg,
             vw_sld.tipo_reg,
             vw_sld.custodian,
             vw_sld.client_id,
             vw_sld.tipo_identificador_cliente,
             vw_sld.office_id,
             vw_sld.account_no,
             upper(vw_sld.name::text)::character varying(100)                                                                                                                                                                                                                                    AS name,
             vw_sld.process_date,
             upper(vw_sld.symbol::text)::character varying(100)                                                                                                                                                                                                                                  AS symbol,
             upper(vw_sld.cusip::text)::character varying(100)                                                                                                                                                                                                                                   AS cusip,
             upper(vw_sld.isin_code::text)::character varying(100)                                                                                                                                                                                                                               AS isin,
             upper(vw_sld.product_type::text)::character varying(100)                                                                                                                                                                                                                            AS product_type,
             upper(vw_sld.security_description::text)::character varying(100)                                                                                                                                                                                                                    AS security_description,
             upper(vw_sld.cash_margin_account::text)::character varying(1000)                                                                                                                                                                                                                    AS cash_margin_account,
             vw_sld.quantity,
             vw_sld.market_price,
             vw_sld.currency,
             vw_sld.market_value,
             vw_sld.fx_rate,
             vw_sld.usde_market_value,
             vw_sld.comision_devengada_diaria,
             vw_sld.usde_market_price,
             upper(vw_sld.id_sub_sub_tipo_activo::text)::character varying(100)                                                                                                                                                                                                                  AS id_sub_sub_tipo_activo,
             upper(vw_sld.id_sub_tipo_activo::text)::character varying(100)                                                                                                                                                                                                                      AS id_sub_tipo_activo,
             upper(vw_sld.id_tipo_activo::text)::character varying(100)                                                                                                                                                                                                                          AS id_tipo_activo,
             upper(vw_sld.nombre_sub_sub_tipo_activo::text)::character varying(100)                                                                                                                                                                                                              AS nombre_sub_sub_tipo_activo,
             vw_sld.total_usde_market_value,
             vw_sld.ingreso_proteccion,
             vw_sld.annual_fee,
             vw_sld.tasa_proteccion,
             vw_sld.tasa_suracorp,
             vw_sld.fee_diario,
             vw_sld.fee_diario_proteccion,
             vw_sld.fee_diario_sura_corp
      FROM tbvw_maestro_saldos_pershing vw_sld
      WHERE vw_sld.quantity <> 0::numeric
      UNION
      SELECT 'C'::text                            AS src_vw,
             rank() OVER (ORDER BY sld_no_inf.id) AS row_id,
             sld_no_inf.id                        AS id_reg,
             sld_no_inf.tipo_reg,
             sld_no_inf.custodian,
             sld_no_inf.client_id,
             NULL::VARCHAR(100) as tipo_identificador_cliente,
             sld_no_inf.office_id,
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
             sld_no_inf.comision_devengada_diaria,
             sld_no_inf.usde_market_price,
             sld_no_inf.id_sub_sub_tipo_activo,
             sld_no_inf.id_sub_tipo_activo,
             sld_no_inf.id_tipo_activo,
             sld_no_inf.nombre_sub_sub_tipo_activo,
             NULL::numeric(45, 20)                AS total_usde_market_value,
             NULL::numeric(45, 20)                AS ingreso_proteccion,
             NULL::numeric(45, 20)                AS annual_fee,
             NULL::numeric(45, 20)                AS tasa_proteccion,
             NULL::numeric(45, 20)                AS tasa_suracorp,
             NULL::numeric(45, 20)                AS fee_diario,
             NULL::numeric(45, 20)                AS fee_diario_proteccion,
             NULL::numeric(45, 20)                AS fee_diario_sura_corp
      FROM rectificacion_saldos_no_informados sld_no_inf
      WHERE sld_no_inf.id_estado_rectificacion = 0) vw_union
ORDER BY process_date, client_id, account_no, product_type, cusip;


create function public.fn_reporte_maestro_datos_saldos(_process_date character varying) returns SETOF vw_reporte_maestro_datos_saldos
    language plpgsql
as
$$
    BEGIN


    RETURN QUERY
    SELECT
        *
    FROM public.vw_reporte_maestro_datos_saldos vw_sal
    WHERE vw_sal.process_date = _process_date

    ;

    RETURN;
    END;
$$;





--========================================================================
--========================================================================
--========================================================================
--Modificación de vistas MOVIMIENTOS
DROP FUNCTION public.fn_reporte_maestro_datos_movimientos;
DROP VIEW public.vw_reporte_maestro_datos_movimientos;
DROP VIEW public.vw_maestro_movimientos_pershing;

create view public.vw_maestro_movimientos_pershing
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
             maestro_crm.nombre_cliente                                                                             AS name,
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
                                                      ''::text)::character varying(100)::text) || ' SD:'::text) ||
                         COALESCE((((substr(vw_mov_persh.settlement_date::text, 6, 2) || '/'::text) ||
                                    substr(vw_mov_persh.settlement_date::text, 9, 2)) || '/'::text) ||
                                  substr(vw_mov_persh.settlement_date::text, 1, 4), ''::text)::character varying(100)::text
                 ELSE (((((((((COALESCE(vw_mov_persh.buy_sell_value, ''::character varying)::character varying(100)::text ||
                               ' '::text) ||
                              COALESCE(abs(vw_mov_persh.quantity::numeric(45, 2))::character varying(100),
                                       ''::character varying)::character varying(100)::text) ||
                             ' SHRS OF ISIN #'::text) ||
                            COALESCE(vw_mov_persh.isin, ''::character varying)::character varying(100)::text) ||
                           ' PRICE: $'::text) || COALESCE(vw_mov_persh.price::numeric(45, 4)::character varying(100),
                                                          ''::character varying)::character varying(100)::text) ||
                         ' TD:'::text) || COALESCE((((substr(vw_mov_persh.trade_date::text, 6, 2) || '/'::text) ||
                                                     substr(vw_mov_persh.trade_date::text, 9, 2)) || '/'::text) ||
                                                   substr(vw_mov_persh.trade_date::text, 1, 4),
                                                   ''::text)::character varying(100)::text) || ' SD:'::text) ||
                      COALESCE((((substr(vw_mov_persh.settlement_date::text, 6, 2) || '/'::text) ||
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
            WHERE TRIM(BOTH FROM tb_mov.source_code) <> ALL
                  (ARRAY ['ITS'::text, 'SGR'::text, 'NET'::text])) vw_mov_persh
               LEFT JOIN clientes.vw_maestro_clientes_cuentas maestro_crm
                         ON vw_mov_persh.id_custodian::text = maestro_crm.id_custodio::text AND
                            vw_mov_persh.account_no::text = maestro_crm.id_cuenta_custodio::text
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



create view public.vw_reporte_maestro_datos_movimientos
as
SELECT rank() OVER (ORDER BY row_id, src_vw) AS row_id,
       src_vw,
       id_reg,
       tipo_reg,
       custodian,
       client_id,
       tipo_identificador_cliente,
       account_no,
       name,
       process_date,
       trade_date,
       settlement_date,
       activity,
       buy_sell,
       quantity,
       price,
       comission,
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
       cash_margin_account,
       product_type,
       security_description,
       activity_description,
       activity_code,
       source_code,
       description1,
       description2,
       description3,
       ticker,
       id_sub_sub_tipo_activo,
       id_sub_tipo_activo,
       id_tipo_activo,
       nombre_sub_sub_tipo_activo,
       aplica_flujo_neto,
       office_id,
       id_cuenta_custodio,
       ingreso_egreso,
       retiro,
       recaudo
FROM (SELECT 'B'::text                                                                                                                                                                                                                                                                                                                                                                                  AS src_vw,
             rank()
             OVER (ORDER BY vw_mov.tipo_reg, vw_mov.process_date, vw_mov.custodian, vw_mov.account_no, vw_mov.id_cuenta_custodio, vw_mov.cash_margin, vw_mov.cusip, vw_mov.symbol, vw_mov.isin, vw_mov.source_code, vw_mov.buy_sell_code, vw_mov.description_1, vw_mov.description_2, vw_mov.description_3, vw_mov.quantity, vw_mov.net_amount, vw_mov.principal, vw_mov.price, vw_mov.usde_net_amount) AS row_id,
             rank()
             OVER (ORDER BY vw_mov.tipo_reg, vw_mov.process_date, vw_mov.custodian, vw_mov.account_no, vw_mov.id_cuenta_custodio, vw_mov.cash_margin, vw_mov.cusip, vw_mov.symbol, vw_mov.isin, vw_mov.source_code, vw_mov.buy_sell_code, vw_mov.description_1, vw_mov.description_2, vw_mov.description_3, vw_mov.quantity, vw_mov.net_amount, vw_mov.principal, vw_mov.price, vw_mov.usde_net_amount) AS id_reg,
             upper(vw_mov.tipo_reg::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                       AS tipo_reg,
             upper(vw_mov.custodian::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                      AS custodian,
             upper(vw_mov.client_id::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                      AS client_id,
             vw_mov.tipo_identificador_cliente,
             vw_mov.account_no,
             upper(vw_mov.name::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                           AS name,
             upper(vw_mov.process_date::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                   AS process_date,
             fn_fecha_date_to_string(vw_mov.trade_date, 'YYYYMMDD'::character varying,
                                     '-'::character varying)::character varying(100)                                                                                                                                                                                                                                                                                                                    AS trade_date,
             fn_fecha_date_to_string(vw_mov.settlement_date, 'YYYYMMDD'::character varying,
                                     '-'::character varying)::character varying(100)                                                                                                                                                                                                                                                                                                                    AS settlement_date,
             upper(vw_mov.activity::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                       AS activity,
             upper(vw_mov.buy_sell_value::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                 AS buy_sell,
             vw_mov.quantity,
             vw_mov.price,
             vw_mov.commission                                                                                                                                                                                                                                                                                                                                                                          AS comission,
             vw_mov.fees,
             vw_mov.net_amount,
             vw_mov.usde_net_amount,
             vw_mov.principal,
             upper(vw_mov.cusip::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                          AS cusip,
             upper(vw_mov.symbol::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                         AS symbol,
             upper(vw_mov.isin::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                           AS isin,
             upper(vw_mov.currency::text)::character varying(1000)                                                                                                                                                                                                                                                                                                                                      AS currency,
             vw_mov.fx_rate,
             vw_mov.interest,
             upper(vw_mov.currency_base::text)::character varying(1000)                                                                                                                                                                                                                                                                                                                                 AS currency_base,
             upper(vw_mov.cash_margin::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                    AS cash_margin_account,
             upper(vw_mov.product_type::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                   AS product_type,
             upper(vw_mov.security_description::text)::character varying(100)                                                                                                                                                                                                                                                                                                                           AS security_description,
             upper(vw_mov.activity_description::text)::character varying(100)                                                                                                                                                                                                                                                                                                                           AS activity_description,
             upper(vw_mov.activity_code::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                  AS activity_code,
             upper(vw_mov.source_code::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                    AS source_code,
             upper(vw_mov.description_1)::character varying(100)                                                                                                                                                                                                                                                                                                                                        AS description1,
             upper(vw_mov.description_2)::character varying(100)                                                                                                                                                                                                                                                                                                                                        AS description2,
             upper(vw_mov.description_3)::character varying(100)                                                                                                                                                                                                                                                                                                                                        AS description3,
             upper(vw_mov.ticker::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                         AS ticker,
             upper(vw_mov.id_sub_sub_tipo::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                AS id_sub_sub_tipo_activo,
             upper(vw_mov.id_sub_tipo::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                    AS id_sub_tipo_activo,
             upper(vw_mov.id_tipo::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                        AS id_tipo_activo,
             upper(vw_mov.nombre_sub_sub_tipo::text)::character varying(100)                                                                                                                                                                                                                                                                                                                            AS nombre_sub_sub_tipo_activo,
             vw_mov.flujo_neto                                                                                                                                                                                                                                                                                                                                                                          AS aplica_flujo_neto,
             upper(vw_mov.office_id::text)::character varying(100)                                                                                                                                                                                                                                                                                                                                      AS office_id,
             upper(vw_mov.id_cuenta_custodio::text)::character varying(100)                                                                                                                                                                                                                                                                                                                             AS id_cuenta_custodio,
             vw_mov.ingreso_egreso,
             vw_mov.retiro,
             vw_mov.recaudo
      FROM tbvw_maestro_movimientos_pershing vw_mov
      UNION
      SELECT 'C'::text                                                                  AS src_vw,
             rank() OVER (ORDER BY mov_no_inf.id)                                       AS row_id,
             mov_no_inf.id                                                              AS id_reg,
             upper(mov_no_inf.tipo_reg::text)::character varying(100)                   AS tipo_reg,
             upper(mov_no_inf.custodian::text)::character varying(100)                  AS custodian,
             upper(mov_no_inf.client_id::text)::character varying(100)                  AS client_id,
             NULL::character varying(100)                  AS tipo_identificador_cliente,
             mov_no_inf.account_no::character varying(100)                              AS account_no,
             upper(mov_no_inf.name::text)::character varying(100)                       AS name,
             upper(mov_no_inf.process_date::text)::character varying(100)               AS process_date,
             upper(mov_no_inf.trade_date::text)::character varying(100)                 AS trade_date,
             upper(mov_no_inf.settlement_date::text)::character varying(100)            AS settlement_date,
             upper(mov_no_inf.activity::text)::character varying(100)                   AS activity,
             upper(mov_no_inf.buy_sell::text)::character varying(100)                   AS buy_sell,
             mov_no_inf.quantity,
             mov_no_inf.price,
             mov_no_inf.comission,
             mov_no_inf.fees,
             mov_no_inf.net_amount,
             mov_no_inf.usde_net_amount,
             mov_no_inf.principal,
             upper(mov_no_inf.cusip::text)::character varying(100)                      AS cusip,
             upper(mov_no_inf.symbol::text)::character varying(100)                     AS symbol,
             upper(mov_no_inf.isin::text)::character varying(100)                       AS isin,
             upper(mov_no_inf.currency::text)::character varying(1000)                  AS currency,
             mov_no_inf.fx_rate,
             mov_no_inf.interest,
             upper(mov_no_inf.currency_base::text)::character varying(1000)             AS currency_base,
             upper(mov_no_inf.cash_margin_account::text)::character varying(1000)       AS cash_margin_account,
             upper(mov_no_inf.product_type::text)::character varying(100)               AS product_type,
             upper(mov_no_inf.security_description::text)::character varying(100)       AS security_description,
             upper(mov_no_inf.activity_description::text)::character varying(100)       AS activity_description,
             upper(mov_no_inf.activity_code::text)::character varying(100)              AS activity_code,
             upper(mov_no_inf.source_code::text)::character varying                     AS source_code,
             upper(mov_no_inf.description1::text)::character varying(100)               AS description1,
             upper(mov_no_inf.description2::text)::character varying(100)               AS description2,
             upper(mov_no_inf.description3::text)::character varying(100)               AS description3,
             upper(mov_no_inf.ticker::text)::character varying(100)                     AS ticker,
             upper(mov_no_inf.id_sub_sub_tipo_activo::text)::character varying(100)     AS id_sub_sub_tipo_activo,
             upper(mov_no_inf.id_sub_tipo_activo::text)::character varying(100)         AS id_sub_tipo_activo,
             upper(mov_no_inf.id_tipo_activo::text)::character varying(100)             AS id_tipo_activo,
             upper(mov_no_inf.nombre_sub_sub_tipo_activo::text)::character varying(100) AS nombre_sub_sub_tipo_activo,
             mov_no_inf.aplica_flujo_neto,
             upper(mov_no_inf.office_id::text)::character varying(100)                  AS office_id,
             upper(mov_no_inf.id_cuenta_custodio::text)::character varying(100)         AS id_cuenta_custodio,
             NULL::boolean                                                              AS ingreso_egreso,
             NULL::numeric(45, 20)                                                      AS retiro,
             NULL::numeric(45, 20)                                                      AS recaudo
      FROM rectificacion_movimientos_no_informados mov_no_inf
      WHERE mov_no_inf.id_estado_rectificacion = 0) vw_union
ORDER BY process_date, client_id, account_no, product_type, cusip;


create function public.fn_reporte_maestro_datos_movimientos(_process_date character varying) returns SETOF vw_reporte_maestro_datos_movimientos
    language plpgsql
as
$$
    BEGIN


    RETURN QUERY
    SELECT
        *
    FROM public.vw_reporte_maestro_datos_movimientos vw_mov
    WHERE vw_mov.process_date = _process_date

    ;

    RETURN;
    END;
$$;




--========================================================================
--========================================================================
--========================================================================
--Modificación de vistas CLIENTES
DROP FUNCTION public.fn_reporte_maestro_datos_clientes;
DROP VIEW public.vw_reporte_maestro_datos_clientes;


create view public.vw_reporte_maestro_datos_clientes
as
SELECT rank() OVER (ORDER BY row_id, src_vw) AS row_id,
       id_reg,
       custodian,
       client_id,
       tipo_identificador_cliente,
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
             vw_acct.tipo_identificador_cliente,
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
             NULL::VARCHAR(100) as tipo_identificador_cliente,
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


create function public.fn_reporte_maestro_datos_clientes(_process_date character varying) returns SETOF vw_reporte_maestro_datos_clientes
    language plpgsql
as
$$
    BEGIN


    RETURN QUERY
    SELECT
        *
    FROM public.vw_reporte_maestro_datos_clientes vw_cte
    WHERE vw_cte.process_date = _process_date

    ;

    RETURN;
    END;
$$;



--========================================================================
--========================================================================
--========================================================================
--

create or replace view public.vw_maestro_movimientos_pershing
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
             maestro_crm.nombre_cliente                                                                             AS name,
             vw_mov_persh.process_date,
             vw_mov_persh.tipo_reg,
             COALESCE(vw_mov_persh.trade_date, fn_fecha_string_to_date(vw_mov_persh.process_date,
                                                                       'YYYYMMDD'::character varying))::date              AS trade_date,
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
                                                      ''::text)::character varying(100)::text) || ' SD:'::text) ||
                         COALESCE((((substr(vw_mov_persh.settlement_date::text, 6, 2) || '/'::text) ||
                                    substr(vw_mov_persh.settlement_date::text, 9, 2)) || '/'::text) ||
                                  substr(vw_mov_persh.settlement_date::text, 1, 4), ''::text)::character varying(100)::text
                 ELSE (((((((((COALESCE(vw_mov_persh.buy_sell_value, ''::character varying)::character varying(100)::text ||
                               ' '::text) ||
                              COALESCE(abs(vw_mov_persh.quantity::numeric(45, 2))::character varying(100),
                                       ''::character varying)::character varying(100)::text) ||
                             ' SHRS OF ISIN #'::text) ||
                            COALESCE(vw_mov_persh.isin, ''::character varying)::character varying(100)::text) ||
                           ' PRICE: $'::text) || COALESCE(vw_mov_persh.price::numeric(45, 4)::character varying(100),
                                                          ''::character varying)::character varying(100)::text) ||
                         ' TD:'::text) || COALESCE((((substr(vw_mov_persh.trade_date::text, 6, 2) || '/'::text) ||
                                                     substr(vw_mov_persh.trade_date::text, 9, 2)) || '/'::text) ||
                                                   substr(vw_mov_persh.trade_date::text, 1, 4),
                                                   ''::text)::character varying(100)::text) || ' SD:'::text) ||
                      COALESCE((((substr(vw_mov_persh.settlement_date::text, 6, 2) || '/'::text) ||
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
            WHERE TRIM(BOTH FROM tb_mov.source_code) <> ALL
                  (ARRAY ['ITS'::text, 'SGR'::text, 'NET'::text])) vw_mov_persh
               LEFT JOIN clientes.vw_maestro_clientes_cuentas maestro_crm
                         ON vw_mov_persh.id_custodian::text = maestro_crm.id_custodio::text AND
                            vw_mov_persh.account_no::text = maestro_crm.id_cuenta_custodio::text
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




--========================================================================
--========================================================================
--========================================================================
--



