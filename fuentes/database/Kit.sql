/*
2024-10-21
Actual: 8.5.0-COL
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
-- Panel Jobs User

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_ADMIN_JOBS_BY_USER' FROM public.users where username in ('admin-qye')
;

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_ADMIN_JOBS_BY_USER' FROM public.users where username in ('usuario')
;

--========================================================================
--========================================================================
--========================================================================
-- Regularización cliente CC70073062 Saldarriaga

create schema zz_backup;


--cliente: id 11
select * from clientes.cliente where identificador='70073062';
--Cuentas: 12 (T9N001631), 13 (T9N001649)
select * from clientes.cuenta where id_cliente=11;

--select *, length(id_cuenta_custodio) from clientes.cuenta where id_cuenta_custodio in ('T9N001631', 'T9N001649	');
select * from clientes.cuenta where id_cuenta_custodio like '%T9N001631%' or id_cuenta_custodio like '%T9N001649%';


select * from public.tbvw_maestro_cuentas_pershing where account_no like '%T9N001631%' or account_no like '%T9N001649%';

update clientes.cuenta set id_cuenta_custodio=CASE WHEN id_cuenta_custodio like '%T9N001631%' THEN 'T9N001631' ELSE 'T9N001649' END
--select *, CASE WHEN id_cuenta_custodio like '%T9N001631%' THEN 'T9N001631' ELSE 'T9N001649' END as new_id_cuenta_custodio from clientes.cuenta
where id_cuenta_custodio like '%T9N001631%' or id_cuenta_custodio like '%T9N001649%'
;


select * from clientes.cuenta WHERe length(id_cuenta_custodio)<>9;

select * from public.tbvw_maestro_cuentas_pershing WHERe length(id_cuenta_custodio)<>9 OR length(account_no)<>9 or tipo_identificador_cliente IS NULL;
select * from public.tbvw_maestro_saldos_pershing WHERe length(account_no)<>9 or tipo_identificador_cliente IS NULL;
select * from public.tbvw_maestro_movimientos_pershing WHERe length(id_cuenta_custodio)<>9 OR length(account_no)<>9 or tipo_identificador_cliente IS NULL;


--=============================================================
--Cuentas: 270 reg
SELECT * INTO zz_backup.tbvw_maestro_cuentas_pershing_20241017 FROM public.tbvw_maestro_cuentas_pershing
where account_no like '%T9N001631%' or account_no like '%T9N001649%';

update public.tbvw_maestro_cuentas_pershing
set
    id_interno_cliente=11, client_id='70073062', name='JORGE IGNACIO SALDARRIAGA VELEZ',
    id_tipo_identificador_cliente=1, tipo_identificador_cliente='CC', glosa_identificador_cliente='CEDULA DE CIUDADANIA',
    id_custodio='pershing', habilitado=true,
    id_interno_cuenta= CASE WHEN account_no like '%T9N001631%' THEN 12 ELSE 13 END,
    id_cuenta_custodio= CASE WHEN account_no like '%T9N001631%' THEN 'T9N001631' ELSE 'T9N001649' END
--select * from public.tbvw_maestro_cuentas_pershing
where account_no like '%T9N001631%' or account_no like '%T9N001649%';



--=============================================================
--Movimientos: 105 reg
SELECT * INTO zz_backup.tbvw_maestro_movimientos_pershing_20241017 FROM public.tbvw_maestro_movimientos_pershing
where account_no like '%T9N001631%' or account_no like '%T9N001649%';

update public.tbvw_maestro_movimientos_pershing
set
    client_id='70073062', tipo_identificador_cliente='CC', name='JORGE IGNACIO SALDARRIAGA VELEZ',
    id_cuenta_custodio= CASE WHEN account_no like '%T9N001631%' THEN 'T9N001631' ELSE 'T9N001649' END
--select * from public.tbvw_maestro_movimientos_pershing
where account_no like '%T9N001631%' or account_no like '%T9N001649%';

--=============================================================
--Saldos: 1603 reg
SELECT * INTO zz_backup.tbvw_maestro_saldos_pershing_20241017 FROM public.tbvw_maestro_saldos_pershing
where account_no like '%T9N001631%' or account_no like '%T9N001649%';

update public.tbvw_maestro_saldos_pershing
set
    client_id='70073062', tipo_identificador_cliente='CC', name='JORGE IGNACIO SALDARRIAGA VELEZ'
--select * from public.tbvw_maestro_saldos_pershing
where account_no like '%T9N001631%' or account_no like '%T9N001649%';



select * from public.tbvw_maestro_saldos_pershing
where account_no like '%T9N001631%' or account_no like '%T9N001649%';



--========================================================================
--========================================================================
--========================================================================
-- Corrección cuando no viene Cusip "USD999997" en ISCA


UPDATE public.tbvw_maestro_saldos_pershing
    SET isin_code='', product_type='CURRENCY',
        fx_rate=1, usde_market_value=market_value, usde_market_price=1,
        id_sub_sub_tipo_activo='CURRENCY', id_sub_tipo_activo='CURRENCY', id_tipo_activo='CURRENCY', nombre_sub_sub_tipo_activo='Monedas'
where cusip='USD999997'
;
--TODO: total_usde_market_value, id_fee_aplicado, annual_fee, tasa_proteccion, tasa_suracorp, fee_diario*, fee_diario_proteccion*, fee_diario_suracorp*, comision_devengada_diaria ingrespo_proteccion


--3425 reg
SELECT * into zz_backup.vw_maestro_saldos_pershing_20241017_to_fix
FROM public.vw_maestro_saldos_pershing tb_to_fix
WHERE EXISTS
    (
        --615 casos
        select distinct process_date, account_no from public.vw_maestro_saldos_pershing tb_base
        where cusip='USD999997' AND tb_base.process_date=tb_to_fix.process_date AND tb_base.account_no=tb_to_fix.account_no
    )
;

--Candidatos a corregir: 3425
SELECT
    *,
    total_usde_market_value,
    sum(tb_to_fix.usde_market_value) OVER (PARTITION BY tb_to_fix.process_date, tb_to_fix.account_no)                                AS new_total_usde_market_value,
    (SELECT count(*) from zz_backup.vw_maestro_saldos_pershing_20241017_to_fix tb_bk
     where tb_bk.process_date=tb_to_fix.process_date AND tb_bk.account_no=tb_to_fix.account_no AND tb_bk.cusip=tb_to_fix.cusip AND tb_bk.cash_margin_account=tb_to_fix.cash_margin_account ) as count_cruce
FROM public.tbvw_maestro_saldos_pershing tb_to_fix
WHERE EXISTS
    (
        --615 casos
        select distinct process_date, account_no from zz_backup.vw_maestro_saldos_pershing_20241017_to_fix tb_base
        where cusip='USD999997' AND tb_base.process_date=tb_to_fix.process_date AND tb_base.account_no=tb_to_fix.account_no
    )
;

UPDATE public.tbvw_maestro_saldos_pershing AS target
SET
    total_usde_market_value = source.total_usde_market_value,
    id_fee_aplicado = source.id_fee_aplicado,
    annual_fee = source.annual_fee,
    tasa_proteccion = source.tasa_proteccion,
    tasa_suracorp = source.tasa_suracorp,
    fee_diario = source.fee_diario,
    fee_diario_proteccion = source.fee_diario_proteccion,
    fee_diario_sura_corp = source.fee_diario_sura_corp,
    comision_devengada_diaria = source.comision_devengada_diaria,
    ingreso_proteccion = source.ingreso_proteccion
FROM
--SELECT * FROM public.tbvw_maestro_saldos_pershing AS target JOIN
    zz_backup.vw_maestro_saldos_pershing_20241017_to_fix AS source
WHERE
    target.process_date = source.process_date AND
    target.account_no = source.account_no AND
    target.cusip = source.cusip AND
    target.cash_margin_account = source.cash_margin_account AND
    EXISTS
    (
        --615 casos
        select distinct process_date, account_no from zz_backup.vw_maestro_saldos_pershing_20241017_to_fix tb_base
        where cusip='USD999997' AND tb_base.process_date=target.process_date AND tb_base.account_no=target.account_no
    )
    -- Solo actualizar los registros donde los valores sean diferentes
    AND (
        target.total_usde_market_value <> source.total_usde_market_value OR
        target.id_fee_aplicado <> source.id_fee_aplicado OR
        target.annual_fee <> source.annual_fee OR
        target.tasa_proteccion <> source.tasa_proteccion OR
        target.tasa_suracorp <> source.tasa_suracorp OR
        target.fee_diario <> source.fee_diario OR
        target.fee_diario_proteccion <> source.fee_diario_proteccion OR
        target.fee_diario_sura_corp <> source.fee_diario_sura_corp OR
        target.comision_devengada_diaria <> source.comision_devengada_diaria OR
        target.ingreso_proteccion <> source.ingreso_proteccion
    )
RETURNING
    target.process_date,
    target.account_no,
    target.cusip,
    target.cash_margin_account,
    target.total_usde_market_value AS old_total_usde_market_value,
    source.total_usde_market_value AS new_total_usde_market_value,
    target.id_fee_aplicado AS old_id_fee_aplicado,
    source.id_fee_aplicado AS new_id_fee_aplicado,
    target.annual_fee AS old_annual_fee,
    source.annual_fee AS new_annual_fee,
    target.tasa_proteccion AS old_tasa_proteccion,
    source.tasa_proteccion AS new_tasa_proteccion,
    target.tasa_suracorp AS old_tasa_suracorp,
    source.tasa_suracorp AS new_tasa_suracorp,
    target.fee_diario AS old_fee_diario,
    source.fee_diario AS new_fee_diario,
    target.fee_diario_proteccion AS old_fee_diario_proteccion,
    source.fee_diario_proteccion AS new_fee_diario_proteccion,
    target.fee_diario_sura_corp AS old_fee_diario_sura_corp,
    source.fee_diario_sura_corp AS new_fee_diario_sura_corp,
    target.comision_devengada_diaria AS old_comision_devengada_diaria,
    source.comision_devengada_diaria AS new_comision_devengada_diaria,
    target.ingreso_proteccion AS old_ingreso_proteccion,
    source.ingreso_proteccion AS new_ingreso_proteccion
;


select * from zz_backup.vw_maestro_saldos_pershing_20241017_to_fix
where process_date='20240501' and account_no='T9O001267'
;

select * from public.tbvw_maestro_saldos_pershing
where process_date='20240501' and account_no='T9O001267'
;

select * from public.tbvw_maestro_saldos_pershing
where fx_rate is null
;
select * from public.tbvw_maestro_saldos_pershing
where account_no='T9O002091'-- total_usde_market_value<0
;



select * from public.tbvw_maestro_saldos_pershing
where cusip='USD999997'
;

select *
from public.vw_maestro_saldos_pershing
where cusip='USD999997'
order by process_date;
;


select *
from public.vw_maestro_saldos_pershing
where cusip='USD999997'
order by process_date;
;



select *
FROM pershing.vw_maestro_posicion_valorizada
where cusip='USD999997'
order by process_date;
;







--========================================================================
--========================================================================
--========================================================================
--

create or replace view pershing.vw_maestro_posicion_valorizada
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
             public.fn_obtiene_valor_parametro('custodian'::character varying,
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
                 WHEN vw_pos.cusip_number='USD999997' AND val_his.id IS NULL THEN 1::numeric
                 ELSE val_his.latest_price
                 END::numeric(45, 20)                                                                      AS market_price,
             val_his.process_date                                                                          AS process_date_val_his,
             CASE WHEN vw_pos.cusip_number='USD999997' AND val_his.id IS NULL THEN 1::numeric ELSE val_his.latest_price END::NUMERIC(45,20) as latest_price,
             CASE
                 WHEN vw_pos.tipo_reg::text = 'CAJA'::text THEN 1::numeric
                 WHEN vw_pos.cusip_number='USD999997' AND val_his.id IS NULL THEN 1::numeric
                 ELSE val_his.exchange_rate_denom_currency_usd
                 END::numeric(45, 20)                                                                      AS fx_rate,
             COALESCE(val_his.factored_market_value_multiplier,
                      1::numeric(45, 20))                                                                  AS factor_mkv_mult,
             CASE
                 WHEN vw_pos.tipo_reg::text = 'CAJA'::text THEN vw_pos.cusip_number
                 WHEN vw_pos.cusip_number='USD999997' AND val_his.id IS NULL THEN ''
                 ELSE trim(val_his.isin_code)
                 END::VARCHAR(100)                                                                                       AS isin_code,
             par_crrcy.codigo                                                                              AS currency,
             CASE WHEN vw_pos.cusip_number='USD999997' AND val_his.id IS NULL THEN 'CURRENCY' ELSE par_asset.id_sub_sub_tipo END::VARCHAR(100) AS product_type,
             CASE WHEN vw_pos.cusip_number='USD999997' AND val_his.id IS NULL THEN 'CURRENCY' ELSE par_asset.id_sub_sub_tipo END::VARCHAR(100) AS id_sub_sub_tipo_activo,
             CASE WHEN vw_pos.cusip_number='USD999997' AND val_his.id IS NULL THEN 'CURRENCY' ELSE par_asset.id_sub_tipo END::VARCHAR(100) AS id_sub_tipo_activo,
             CASE WHEN vw_pos.cusip_number='USD999997' AND val_his.id IS NULL THEN 'CURRENCY' ELSE par_asset.id_tipo END::VARCHAR(100) AS id_tipo_activo,
             CASE WHEN vw_pos.cusip_number='USD999997' AND val_his.id IS NULL THEN 'Monedas' ELSE par_asset.glosa END::VARCHAR(1000) AS nombre_sub_sub_tipo_activo
      FROM pershing.vw_maestro_posicion vw_pos
               LEFT JOIN pershing.sfl_isca_historica val_his
                         ON vw_pos.process_date::text = val_his.process_date::text AND
                            vw_pos.cusip_number::text = val_his.cusip_number::text
               LEFT JOIN public.par_maestro_monedas par_crrcy ON vw_pos.currency::text = par_crrcy.cod_pershing::text
               LEFT JOIN pershing.par_asset_type_code par_asset ON
          CASE
              WHEN vw_pos.tipo_reg::text = 'CAJA'::text THEN 'MONEY'::text = par_asset.id_sub_sub_tipo::text
              ELSE TRIM(BOTH FROM val_his.asset_type) = TRIM(BOTH FROM par_asset.id_tipo) AND
                   TRIM(BOTH FROM val_his.asset_subtype) = TRIM(BOTH FROM par_asset.id_sub_tipo) AND
                   TRIM(BOTH FROM val_his.asset_subsubtype) = TRIM(BOTH FROM par_asset.id_sub_sub_tipo)
              END
      WHERE vw_pos.flag_informar) t_pos;



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



