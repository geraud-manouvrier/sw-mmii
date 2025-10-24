create or replace view public.vw_maestro_saldos_pershing
            (custodian, tipo_reg, client_id, tipo_identificador_cliente, office_id, account_no, name, process_date,
             symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity, market_price,
             id_currency, currency, market_value, fx_rate, usde_market_value, total_usde_market_value, id_fee_aplicado,
             annual_fee, tasa_proteccion, tasa_suracorp, fee_diario, fee_diario_proteccion, fee_diario_sura_corp,
             comision_devengada_diaria, ingreso_proteccion, usde_market_price, id_sub_sub_tipo_activo,
             id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo)
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
       pos.total_usde_market_value::numeric(45, 20)                                                             AS total_usde_market_value,
       tb_fee.id                                                                                                AS id_fee_aplicado,
       COALESCE(pos.comision_anual_excepcion, pos.annual_fee_client)::numeric(45, 20)                           AS annual_fee,
       tb_fee.tasa_proteccion,
       tb_fee.tasa_suracorp,
       COALESCE(pos.comision_diaria_excepcion, pos.daily_fee_client)::numeric(45, 20)                           AS fee_diario,
       tb_fee.fee_diario_proteccion,
       tb_fee.fee_diario_sura_corp,
       (pos.usde_market_value *
        COALESCE(pos.comision_diaria_excepcion, pos.daily_fee_client))::numeric(45, 20)                         AS comision_devengada_diaria,
       (pos.usde_market_value * tb_fee.fee_diario_proteccion)::numeric(45, 20)                                  AS ingreso_proteccion,
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
             COALESCE(maestro_crm.nombre_cliente, vw_act.full_name)                                                   AS name,
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
             vw_pos_val.nombre_sub_sub_tipo_activo,
             clientes.fn_comision_cuenta(vw_pos_val.process_date, maestro_crm.identificador_cliente,
                                         vw_pos_val.custodian, vw_pos_val.account_number::character varying,
                                         NULL::numeric(45, 20),
                                         false)                                                                       AS comision_diaria_excepcion,
             clientes.fn_comision_cuenta(vw_pos_val.process_date, maestro_crm.identificador_cliente,
                                         vw_pos_val.custodian, vw_pos_val.account_number::character varying,
                                         NULL::numeric(45, 20),
                                         true)                                                                        AS comision_anual_excepcion,
             maestro_crm.fee / 100::numeric                                                                           AS annual_fee_client,
             fn_change_base_fee(maestro_crm.fee, 'ANNUAL'::character varying, 'DAILY'::character varying,
                                'P'::character varying)                                                               AS daily_fee_client
      FROM pershing.vw_maestro_posicion_valorizada vw_pos_val
               LEFT JOIN clientes.vw_maestro_clientes_cuentas maestro_crm
                         ON vw_pos_val.id_custodian::text = maestro_crm.id_custodio::text AND
                            vw_pos_val.account_number = maestro_crm.id_cuenta_custodio::text
               LEFT JOIN pershing.vw_maestro_cuenta vw_act
                         ON vw_pos_val.account_number = vw_act.account_number::text AND
                            vw_pos_val.process_date::text = vw_act.process_date::text) pos
         LEFT JOIN clientes.par_fee_segmento tb_fee ON pos.total_usde_market_value >= tb_fee.monto_min AND
                                                       pos.total_usde_market_value < tb_fee.monto_max;

alter table public.vw_maestro_saldos_pershing
    owner to postgres;

