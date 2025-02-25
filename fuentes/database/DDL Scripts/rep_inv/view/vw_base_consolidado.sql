create or replace view rep_inv.vw_base_consolidado
            (process_date, client_id, custodian, account_no, cusip, isin, symbol, security_description, id_tipo_activo,
             id_sub_tipo_activo, id_sub_sub_tipo_activo, currency, saldo_dia, dividendos_dia, abonos_dia, retiros_dia,
             comision_devengada, activity_description)
as
SELECT COALESCE(sld.process_date, mov.process_date)                                      AS process_date,
       COALESCE(sld.client_id, mov.client_id)                                            AS client_id,
       COALESCE(sld.custodian, mov.custodian)                                            AS custodian,
       COALESCE(sld.account_no, mov.account_no)                                          AS account_no,
       COALESCE(sld.cusip, mov.cusip)                                                    AS cusip,
       COALESCE(sld.isin, mov.isin)                                                      AS isin,
       COALESCE(sld.symbol, mov.symbol)                                                  AS symbol,
       COALESCE(sld.security_description, ''::character varying)::character varying(100) AS security_description,
       COALESCE(sld.id_tipo_activo, mov.id_tipo_activo)                                  AS id_tipo_activo,
       COALESCE(sld.id_sub_tipo_activo, mov.id_sub_tipo_activo)                          AS id_sub_tipo_activo,
       COALESCE(sld.id_sub_sub_tipo_activo, mov.id_sub_sub_tipo_activo)                  AS id_sub_sub_tipo_activo,
       COALESCE(sld.currency, mov.currency)                                              AS currency,
       COALESCE(sld.sum_usde_market_value, 0::numeric)::numeric(45, 20)                  AS saldo_dia,
       COALESCE(mov.dividendos, 0::numeric)::numeric(45, 20)                             AS dividendos_dia,
       COALESCE(mov.abonos, 0::numeric)::numeric(45, 20)                                 AS abonos_dia,
       COALESCE(mov.retiros, 0::numeric)::numeric(45, 20)                                AS retiros_dia,
       COALESCE(sld.sum_comision_devengada_diaria, 0::numeric)::numeric(45, 20)          AS comision_devengada,
       COALESCE(mov.activity_description, ''::text)::character varying(100)              AS activity_description
FROM rep_inv.base_saldos_diarios sld
         FULL JOIN (SELECT mov_1.process_date,
                           mov_1.client_id,
                           mov_1.custodian,
                           mov_1.account_no,
                           mov_1.cusip,
                           mov_1.isin,
                           mov_1.symbol,
                           mov_1.id_tipo_activo,
                           mov_1.id_sub_tipo_activo,
                           mov_1.id_sub_sub_tipo_activo,
                           mov_1.currency,
                           sum(
                                   CASE mov_1.tipo_reg
                                       WHEN 'DIV'::text THEN mov_1.sum_usde_net_amount
                                       ELSE 0::numeric
                                       END)                                                                          AS dividendos,
                           sum(
                                   CASE mov_1.tipo_reg
                                       WHEN 'ABO'::text THEN mov_1.sum_usde_net_amount
                                       ELSE 0::numeric
                                       END)                                                                          AS abonos,
                           sum(
                                   CASE mov_1.tipo_reg
                                       WHEN 'RET'::text THEN mov_1.sum_usde_net_amount
                                       ELSE 0::numeric
                                       END)                                                                          AS retiros,
                           string_agg(COALESCE(mov_1.activity_description, ''::character varying)::text,
                                      '||'::text)                                                                    AS activity_description
                    FROM rep_inv.base_movimientos_diarios mov_1
                    GROUP BY mov_1.process_date, mov_1.client_id, mov_1.custodian, mov_1.account_no, mov_1.cusip,
                             mov_1.isin, mov_1.symbol, mov_1.id_tipo_activo, mov_1.id_sub_tipo_activo,
                             mov_1.id_sub_sub_tipo_activo, mov_1.currency) mov
                   ON sld.process_date::text = mov.process_date::text AND sld.client_id::text = mov.client_id::text AND
                      sld.custodian::text = mov.custodian::text AND sld.account_no::text = mov.account_no::text AND
                      sld.cusip::text = mov.cusip::text AND sld.isin::text = mov.isin::text AND
                      sld.symbol::text = mov.symbol::text AND sld.id_tipo_activo::text = mov.id_tipo_activo::text AND
                      sld.id_sub_tipo_activo::text = mov.id_sub_tipo_activo::text AND
                      sld.id_sub_sub_tipo_activo::text = mov.id_sub_sub_tipo_activo::text AND
                      sld.currency::text = mov.currency::text;

alter table rep_inv.vw_base_consolidado
    owner to postgres;

