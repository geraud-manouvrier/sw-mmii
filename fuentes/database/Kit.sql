/*
2025-07-20
Actual: 11.3.2-COL
*/

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTRL_DIFF_FEE' FROM public.users where username in ('admin-qye')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_MAESTRO_REL' FROM public.users where username in ('daniel.gomez1', 'brayan.giraldom', 'santiago.isaza')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTRL_DIFF_FEE' FROM public.users where username in ('daniel.gomez1', 'brayan.giraldom', 'santiago.isaza')
;


--========================================================================
--========================================================================
--========================================================================
--
SELECT *
FROM clientes.cliente
limit 100
;
SELECT *
FROM clientes.cuenta
limit 100
;

--SELECT id_cliente, id_cuenta_custodio FROM clientes.cuenta WHERE id_cuenta_custodio='' UNION
--UPDATE clientes.cliente set fee=0 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='');



UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001523');
UPDATE clientes.cliente set fee=1 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9N002183');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9N001656');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001838');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003628');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002869');
UPDATE clientes.cliente set fee=1 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002638');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002273');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003214');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003537');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001374');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003339');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002901');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002505');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002893');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002133');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003024');
UPDATE clientes.cliente set fee=1 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002679');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002315');
UPDATE clientes.cliente set fee=1 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9N002019');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001853');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002786');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003560');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002661');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002943');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003511');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002240');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002646');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002877');
UPDATE clientes.cliente set fee=0.75 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9N002225');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001952');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001804');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002562');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002158');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001911');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002224');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002588');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003545');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003131');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003420');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003032');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002414');
UPDATE clientes.cliente set fee=1 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001705');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9N001664');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002430');
UPDATE clientes.cliente set fee=1 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001408');
UPDATE clientes.cliente set fee=1 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003586');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003461');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001341');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002745');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003412');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002448');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001796');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002026');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002489');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001812');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003172');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001598');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002034');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001879');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003123');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003693');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003644');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002166');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002042');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003818');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002125');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002307');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002547');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002570');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001606');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002208');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002398');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002695');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002778');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003362');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003297');
UPDATE clientes.cliente set fee=1 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001960');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003354');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002935');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003198');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001713');
UPDATE clientes.cliente set fee=1 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002471');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003222');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001903');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003602');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001978');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002711');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002067');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002604');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003065');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002851');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002927');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002828');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002976');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001887');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001648');
UPDATE clientes.cliente set fee=0.75 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9N001631');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002497');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003305');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001945');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001192');
UPDATE clientes.cliente set fee=1 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9N001706');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003800');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002620');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003057');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001929');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001390');
UPDATE clientes.cliente set fee=0.75 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001614');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002885');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001465');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002554');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003180');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001846');
UPDATE clientes.cliente set fee=1 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003487');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001515');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003453');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002422');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003768');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002752');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003396');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001481');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002232');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002372');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001531');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002000');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003230');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003164');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003438');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002596');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001572');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003834');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002992');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002844');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002737');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001457');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002083');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003651');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002182');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002265');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002521');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002364');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003263');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003701');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002059');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001366');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001655');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001267');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001580');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002794');
UPDATE clientes.cliente set fee=1 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9N001490');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003578');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003735');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003206');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002216');
UPDATE clientes.cliente set fee=1.25 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002380');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003529');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002331');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003347');
UPDATE clientes.cliente set fee=1 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001937');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O003669');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O002281');
UPDATE clientes.cliente set fee=1.5 WHERE id = (SELECT id_cliente FROM clientes.cuenta WHERE id_cuenta_custodio='T9O001564');












--========================================================================
--========================================================================
--========================================================================
--Optimización vistas maestro saldos


alter table public.tbvw_maestro_saldos_pershing
    add row_no bigint generated by default as identity;

SELECT row_no, COUNT(*)
  FROM public.tbvw_maestro_saldos_pershing
 GROUP BY row_no
HAVING COUNT(*) > 1;

ALTER TABLE public.tbvw_maestro_saldos_pershing
  ADD CONSTRAINT pk_tbvw_maestro_saldos_pershing_row_no
  PRIMARY KEY (row_no);

CREATE INDEX IF NOT EXISTS tbvw_maestro_saldos_pershing_client_index ON public.tbvw_maestro_saldos_pershing (client_id);
CREATE INDEX IF NOT EXISTS tbvw_maestro_saldos_pershing_custodian_index ON public.tbvw_maestro_saldos_pershing (custodian);
CREATE INDEX IF NOT EXISTS tbvw_maestro_saldos_pershing_account_index ON public.tbvw_maestro_saldos_pershing (account_no);
CREATE INDEX IF NOT EXISTS tbvw_maestro_saldos_pershing_process_date_index ON public.tbvw_maestro_saldos_pershing (process_date);
CREATE INDEX IF NOT EXISTS tbvw_maestro_saldos_pershing_cusip_index ON public.tbvw_maestro_saldos_pershing (cusip);
CREATE INDEX IF NOT EXISTS tbvw_maestro_saldos_pershing_product_index ON public.tbvw_maestro_saldos_pershing (product_type);

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
             vw_sld.row_no AS row_id,
             vw_sld.row_no AS id_reg,
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
      FROM public.tbvw_maestro_saldos_pershing vw_sld
      WHERE vw_sld.quantity <> 0::numeric
      UNION
      SELECT 'C'::text                            AS src_vw,
             sld_no_inf.id AS row_id,
             sld_no_inf.id                        AS id_reg,
             sld_no_inf.tipo_reg,
             sld_no_inf.custodian,
             sld_no_inf.client_id,
             NULL::character varying(100)         AS tipo_identificador_cliente,
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
      FROM public.rectificacion_saldos_no_informados sld_no_inf
      WHERE sld_no_inf.id_estado_rectificacion = 0) vw_union
ORDER BY process_date, client_id, account_no, product_type, cusip;







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


--========================================================================
--========================================================================
--========================================================================
--



--========================================================================
--========================================================================
--========================================================================
--



