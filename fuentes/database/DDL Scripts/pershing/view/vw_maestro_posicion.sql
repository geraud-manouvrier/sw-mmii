create or replace view pershing.vw_maestro_posicion
            (tipo_reg, sub_tipo_reg, flag_informar, ip_number, process_date, account_number, account_type,
             security_symbol, cusip_number, security_description_line_1, security_description_line_2,
             security_description_line_3, security_description_line_4, security_description_line_5,
             security_description_line_6, quantity, currency, fx_rate)
as
SELECT tipo_reg,
       sub_tipo_reg,
       flag_informar,
       TRIM(BOTH FROM ip_number)::character varying(100)                    AS ip_number,
       process_date,
       account_number,
       account_type,
       security_symbol,
       cusip_number,
       security_description_line_1,
       security_description_line_2,
       security_description_line_3,
       security_description_line_4,
       security_description_line_5,
       security_description_line_6,
       quantity,
       COALESCE(currency, 'USD'::character varying)::character varying(100) AS currency,
       fx_rate
FROM (SELECT 'CUS'::character varying(100)                                  AS tipo_reg,
             t_cus.currency_security_indicator                              AS sub_tipo_reg,
             t_cus.trade_date_quantity <> 0::numeric                        AS flag_informar,
             t_cus.ip_record_number                                         AS ip_number,
             t_cus.process_date,
             "left"(t_cus.account_number::text, 9)                          AS account_number,
             "right"(t_cus.account_number::text, 1)::character varying(100) AS account_type,
             t_cus.security_symbol,
             t_cus.cusip_number,
             t_cus.security_description_line_1,
             t_cus.security_description_line_2,
             t_cus.security_description_line_3,
             t_cus.security_description_line_4,
             t_cus.security_description_line_5,
             t_cus.security_description_line_6,
             t_cus.trade_date_quantity                                      AS quantity,
             t_cus.position_currency_security                               AS currency,
             t_cus.exchange_rate                                            AS fx_rate
      FROM pershing.sfl_gcus_historica t_cus
      UNION
      SELECT 'CAJA'::character varying(100)                                                   AS tipo_reg,
             'MM'::character varying(100)                                                     AS sub_tipo_reg,
             true                                                                             AS flag_informar,
             reg_mm.ip_number,
             reg_mm.process_date,
             reg_mm.account_number,
             '1'::character varying(100)                                                      AS account_type,
             fn_obtiene_valor_parametro('generic.symbol'::character varying,
                                        'MNY_MKT'::character varying)::character varying(100) AS security_symbol,
             fn_obtiene_valor_parametro('generic.cusip'::character varying,
                                        'MNY_MKT'::character varying)::character varying(100) AS cusip_number,
             'Money Market'::character varying                                                AS security_description_line_1,
             ''::character varying                                                            AS security_description_line_2,
             ''::character varying                                                            AS security_description_line_3,
             ''::character varying                                                            AS security_description_line_4,
             ''::character varying                                                            AS security_description_line_5,
             ''::character varying                                                            AS security_description_line_6,
             reg_mm.mmf_principal_balance + reg_mm.mmf_dividend                               AS quantity,
             CASE
                 WHEN TRIM(BOTH FROM COALESCE(reg_mm.base_currency, ''::character varying)) = ''::text
                     THEN (SELECT gcus_crrcy.position_currency_security
                           FROM pershing.sfl_gcus_historica gcus_crrcy
                           WHERE gcus_crrcy.process_date::text = reg_mm.process_date::text
                             AND "left"(gcus_crrcy.account_number::text, 9) = reg_mm.account_number::text
                             AND gcus_crrcy.cusip_number::text = 'USD999997'::text
                           LIMIT 1)
                 ELSE reg_mm.base_currency
                 END                                                                          AS currency,
             1::numeric(45, 20)                                                               AS fx_rate
      FROM pershing.sfl_gmon_historica reg_mm
      UNION
      SELECT 'CAJA'::character varying(100)                                                AS tipo_reg,
             'ST'::character varying(100)                                                  AS sub_tipo_reg,
             false                                                                         AS flag_informar,
             reg_st.ip_number,
             reg_st.process_date,
             reg_st.account_number,
             '1'::character varying(100)                                                   AS account_type,
             fn_obtiene_valor_parametro('generic.symbol'::character varying,
                                        'CASH'::character varying)::character varying(100) AS security_symbol,
             fn_obtiene_valor_parametro('generic.cusip'::character varying,
                                        'CASH'::character varying)::character varying(100) AS cusip_number,
             'Saldo en tránsito'::character varying                                        AS security_description_line_1,
             ''::character varying                                                         AS security_description_line_2,
             ''::character varying                                                         AS security_description_line_3,
             ''::character varying                                                         AS security_description_line_4,
             ''::character varying                                                         AS security_description_line_5,
             ''::character varying                                                         AS security_description_line_6,
             reg_st.usde_td_balance * '-1'::integer::numeric                               AS quantity,
             CASE
                 WHEN TRIM(BOTH FROM COALESCE(reg_st.base_currency, ''::character varying)) = ''::text
                     THEN (SELECT gcus_crrcy.position_currency_security
                           FROM pershing.sfl_gcus_historica gcus_crrcy
                           WHERE gcus_crrcy.process_date::text = reg_st.process_date::text
                             AND "left"(gcus_crrcy.account_number::text, 9) = reg_st.account_number::text
                             AND gcus_crrcy.cusip_number::text = 'USD999997'::text
                           LIMIT 1)
                 ELSE reg_st.base_currency
                 END                                                                       AS currency,
             1::numeric(45, 20)                                                            AS fx_rate
      FROM pershing.sfl_gmon_historica reg_st) tb_pos;

alter table pershing.vw_maestro_posicion
    owner to postgres;

