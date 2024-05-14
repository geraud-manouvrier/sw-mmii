create or replace view public.vw_maestro_saldos_pershing
            (custodian, tipo_reg, client_id, firm_no, sub_no, office_id, rep_no, rep, account_no, name, process_date,
             symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity, market_price,
             id_currency, currency, market_value, fx_rate, usde_market_value, advisory_fee_anual, factor,
             comision_devengada_diaria, usde_market_price, sec_no, desc_1, desc_2, desc_3, sedol, ticker,
             id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo, sec_id)
as
SELECT pos.custodian,
       pos.tipo_reg,
       pos.client_id,
       NULL::character varying(100)                                 AS firm_no,
       NULL::character varying(100)                                 AS sub_no,
       pos.office_id,
       NULL::character varying(100)                                 AS rep_no,
       NULL::character varying(100)                                 AS rep,
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
       NULL::numeric(45, 20)                                        AS advisory_fee_anual,
       NULL::integer                                                AS factor,
       (pos.usde_market_value * tb_fee.fee_diario)::numeric(45, 20) AS comision_devengada_diaria,
       pos.usde_market_price,
       pos.sec_no,
       NULL::character varying(100)                                 AS desc_1,
       NULL::character varying(100)                                 AS desc_2,
       NULL::character varying(100)                                 AS desc_3,
       NULL::character varying(100)                                 AS sedol,
       NULL::character varying(100)                                 AS ticker,
       pos.id_sub_sub_tipo_activo,
       pos.id_sub_tipo_activo,
       pos.id_tipo_activo,
       pos.nombre_sub_sub_tipo_activo,
       NULL::character varying(100)                                 AS sec_id
FROM (SELECT vw_pos_val.custodian,
             vw_pos_val.tipo_reg,
             maestro_crm.identificador_cliente                                                                        AS client_id,
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
             NULL::integer                                                                                            AS sec_no,
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

alter table public.vw_maestro_saldos_pershing
    owner to postgres;

