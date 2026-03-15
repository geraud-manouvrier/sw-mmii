/*
2026-03-15
Actual: 13.1.0-COL
*/

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTES_INFOREJEC' FROM public.users where username in ('admin-qye')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTES_INFOREJEC' FROM public.users where username in ('daniel.gomez1')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_MANT_ENROL_CUENTA' FROM public.users where username in ('daniel.gomez1', 'brayan.giraldom')
;


--========================================================================
--========================================================================
--========================================================================
--

select * from public.par_feriado;

insert into public.par_feriado (dia, es_habil_pershing, es_habil_stonex, observaciones) values
('2026-02-16', false, false, 'Presidents Day');

--========================================================================
--========================================================================
--========================================================================
--
UPDATE public.tbvw_maestro_saldos_pershing
set
    annual_fee=0.015,
    fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'),
    comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P')
WHERE account_no='T9O004311' AND process_date>='20250901' AND process_date<='20250930' AND 1.5=100*0.015;

select
    usde_market_value, annual_fee, annual_fee*100, fee_diario, fn_change_base_fee(annual_fee*100, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria,
    *
from public.vw_reporte_maestro_datos_saldos
where process_date='20260204'
;

select
    usde_market_value, annual_fee, annual_fee*100, fee_diario,
    (fn_change_base_fee(annual_fee*100, 'ANNUAL', 'DAILY', 'P')::numeric(45,20)),
    ((fn_change_base_fee(annual_fee*100, 'ANNUAL', 'DAILY', 'P')::numeric(45,20))-fee_diario)*usde_market_value,
    comision_devengada_diaria,
    *
from public.tbvw_maestro_saldos_pershing
where fee_diario<>(fn_change_base_fee(annual_fee*100, 'ANNUAL', 'DAILY', 'P')::numeric(45,20))
;

select distinct fee_diario from public.tbvw_maestro_saldos_pershing;


create or replace function public.fn_distribucion_ingresos(_annual_fee_perc numeric(45,20), _process_date VARCHAR(100)) returns TABLE(fee_perc_proteccion numeric(45,20), fee_perc_ria numeric(45,20))
    language plpgsql
as
$$
DECLARE
    _fee_perc_proteccion numeric(45,20);
    _fee_perc_ria numeric(45,20);
BEGIN
    -- Validaciones mínimas
    /*
    if (_annual_fee_perc is null) then
        raise exception '_annual_fee_perc [%] no puede ser nulo', _annual_fee_perc
            using errcode = '22023'; -- null value not allowed
    end if;
    */
    if (_process_date is null or _process_date<'20240422') then
        raise exception '_process_date no puede ser nulo ni precia al 20240429'
            using errcode = '22023'; -- null value not allowed
    end if;

    if (_annual_fee_perc<=0.5) then
        _fee_perc_ria        := 0.25;
        _fee_perc_proteccion := _annual_fee_perc-_fee_perc_ria;
    else
        _fee_perc_ria        := 0.4;
        _fee_perc_proteccion := _annual_fee_perc-_fee_perc_ria;
    END IF;

    RETURN QUERY
        select _fee_perc_proteccion, _fee_perc_ria;
    RETURN;

END;
$$;


create or replace view public.vw_maestro_saldos_pershing as
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
       (fn_dist.fee_perc_proteccion/100)::NUMERIC(45,20) as tasa_proteccion,
       (fn_dist.fee_perc_ria/100)::NUMERIC(45,20) as tasa_suracorp,
       COALESCE(pos.comision_diaria_excepcion, pos.daily_fee_client)::numeric(45, 20)                           AS fee_diario,
       fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL', 'DAILY', 'P')::numeric(45,20) as fee_diario_proteccion,
       fn_change_base_fee(fn_dist.fee_perc_ria, 'ANNUAL', 'DAILY', 'P')::numeric(45,20) as fee_diario_sura_corp,
       (pos.usde_market_value *
        COALESCE(pos.comision_diaria_excepcion, pos.daily_fee_client))::numeric(45, 20)                         AS comision_devengada_diaria,
       (pos.usde_market_value * fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL', 'DAILY', 'P'))::numeric(45, 20)                                  AS ingreso_proteccion,
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
        CROSS JOIN LATERAL public.fn_distribucion_ingresos(COALESCE(pos.comision_anual_excepcion, pos.annual_fee_client)*100, pos.process_date) fn_dist
         LEFT JOIN clientes.par_fee_segmento tb_fee ON pos.total_usde_market_value >= tb_fee.monto_min AND
                                                       pos.total_usde_market_value < tb_fee.monto_max
;



--========================================================================
--========================================================================
--========================================================================
--
--Actualizamos distribución de ingresos (requiere fee cliente bien almacenado)

--************************
--Tasas
UPDATE public.tbvw_maestro_saldos_pershing pos SET tasa_proteccion=(
    SELECT (fn_dist.fee_perc_proteccion / 100)::numeric(45,20)
    FROM public.fn_distribucion_ingresos((pos.annual_fee * 100), pos.process_date) AS fn_dist(fee_perc_proteccion, fee_perc_ria))
where COALESCE(annual_fee*100,0)>=0.25;

UPDATE public.tbvw_maestro_saldos_pershing pos SET tasa_suracorp=(
    SELECT (fn_dist.fee_perc_ria / 100)::numeric(45,20)
    FROM public.fn_distribucion_ingresos((pos.annual_fee * 100), pos.process_date) AS fn_dist(fee_perc_proteccion, fee_perc_ria))
where COALESCE(annual_fee*100,0)>=0.25;
--************************
--Fee diario
UPDATE public.tbvw_maestro_saldos_pershing pos SET fee_diario_proteccion=(
    SELECT fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL', 'DAILY', 'P')::numeric(45,20)
    FROM public.fn_distribucion_ingresos((pos.annual_fee * 100), pos.process_date) AS fn_dist(fee_perc_proteccion, fee_perc_ria))
where COALESCE(annual_fee*100,0)>=0.25;

UPDATE public.tbvw_maestro_saldos_pershing pos SET fee_diario_sura_corp=(
    SELECT fn_change_base_fee(fn_dist.fee_perc_ria, 'ANNUAL', 'DAILY', 'P')::numeric(45,20)
    FROM public.fn_distribucion_ingresos((pos.annual_fee * 100), pos.process_date) AS fn_dist(fee_perc_proteccion, fee_perc_ria))
where COALESCE(annual_fee*100,0)>=0.25;
--************************
--Ingreso proteccion
UPDATE public.tbvw_maestro_saldos_pershing pos SET ingreso_proteccion=(
    SELECT (pos.usde_market_value*fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL', 'DAILY', 'P'))::numeric(45,20)
    FROM public.fn_distribucion_ingresos((pos.annual_fee * 100), pos.process_date) AS fn_dist(fee_perc_proteccion, fee_perc_ria))
where COALESCE(annual_fee*100,0)>=0.25;



--Query de validación ok
SELECT
    pos.process_date,
    pos.client_id,
    pos.account_no,
    pos.custodian,
    pos.tipo_reg,
    pos.cusip,
    pos.product_type,

    -- ACTUAL vs ESPERADO
    pos.tasa_proteccion          AS tasa_proteccion_db,
    (fn_dist.fee_perc_proteccion / 100)::numeric(45,20)     AS tasa_proteccion_calc,
    (pos.tasa_proteccion - ((fn_dist.fee_perc_proteccion / 100)::numeric(45,20))) AS diff_tasa_proteccion,

    pos.tasa_suracorp            AS tasa_suracorp_db,
    ((fn_dist.fee_perc_ria / 100)::numeric(45,20))       AS tasa_suracorp_calc,
    (pos.tasa_suracorp - ((fn_dist.fee_perc_ria / 100)::numeric(45,20))) AS diff_tasa_suracorp,

    pos.fee_diario_proteccion    AS fee_diario_proteccion_db,
    (fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL', 'DAILY', 'P')::numeric(45,20)) AS fee_diario_proteccion_calc,
    (pos.fee_diario_proteccion - (fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL', 'DAILY', 'P')::numeric(45,20))) AS diff_fee_diario_proteccion,

    pos.fee_diario_sura_corp     AS fee_diario_sura_corp_db,
    (fn_change_base_fee(fn_dist.fee_perc_ria, 'ANNUAL', 'DAILY', 'P')::numeric(45,20)) AS fee_diario_sura_corp_calc,
    (pos.fee_diario_sura_corp - (fn_change_base_fee(fn_dist.fee_perc_ria, 'ANNUAL', 'DAILY', 'P')::numeric(45,20))) AS diff_fee_diario_sura_corp,

    pos.ingreso_proteccion       AS ingreso_proteccion_db,
    ((pos.usde_market_value*fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL', 'DAILY', 'P'))::numeric(45,20))  AS ingreso_proteccion_calc,
    (pos.ingreso_proteccion - ((pos.usde_market_value*fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL', 'DAILY', 'P'))::numeric(45,20))) AS diff_ingreso_proteccion

FROM public.tbvw_maestro_saldos_pershing pos
CROSS JOIN LATERAL public.fn_distribucion_ingresos(pos.annual_fee*100, pos.process_date)  fn_dist
where COALESCE(annual_fee*100,0)>=0.25
AND (
        pos.tasa_proteccion IS DISTINCT FROM (fn_dist.fee_perc_proteccion / 100)::numeric(45,20)
     OR pos.tasa_suracorp   IS DISTINCT FROM (fn_dist.fee_perc_ria        / 100)::numeric(45,20)
     OR pos.fee_diario_proteccion IS DISTINCT FROM fn_change_base_fee(fn_dist.fee_perc_proteccion,'ANNUAL','DAILY','P')::numeric(45,20)
     OR pos.fee_diario_sura_corp  IS DISTINCT FROM fn_change_base_fee(fn_dist.fee_perc_ria,'ANNUAL','DAILY','P')::numeric(45,20)
     OR abs(
          pos.ingreso_proteccion
          - (pos.usde_market_value * fn_change_base_fee(fn_dist.fee_perc_proteccion,'ANNUAL','DAILY','P'))::numeric(45,20)
        ) > 0.00000000000000000001  -- <-- tolerancia para este campo (ajústala)
  )
;


/*
diff_ingreso_proteccion
0.00000000000000000001
0.00000000000000245756
0.00000000000000317865
*/

--========================================================================
--========================================================================
--========================================================================
--Corrección Fee (finalmente, nada que hacer; dato nunca fue incorrecto)
select * from clientes.cliente where identificador='1032368000';
--id 324
select * from clientes.cuenta where id_cliente=324 and cuenta.id_cuenta_custodio='T9O005169';
--id 298


SELECT * FROM public.tbvw_maestro_saldos_pershing where account_no='T9O005169' and process_date>='20260120';





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



