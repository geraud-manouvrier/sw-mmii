--========================================================================
--========================================================================
--========================================================================
-- Reporte Clientes
--Saldo diario detallado
SELECT *
FROM public.vw_reporte_maestro_datos_saldos vw_sld
where vw_sld.process_date='20260314'
and vw_sld.client_id='51828522'
and vw_sld.account_no=COALESCE(null, vw_sld.account_no)
ORDER BY vw_sld.account_no, vw_sld.cusip
;

--saldo consolidado por fechas
SELECT sum(vw_sld.usde_market_value), vw_sld.account_no
FROM public.vw_reporte_maestro_datos_saldos vw_sld
where vw_sld.process_date='20251229'
and vw_sld.client_id='51828522'
and vw_sld.account_no=COALESCE(null, vw_sld.account_no)
group by vw_sld.account_no
ORDER BY vw_sld.account_no
;
SELECT sum(vw_sld.usde_market_value), vw_sld.account_no
FROM public.vw_reporte_maestro_datos_saldos vw_sld
where vw_sld.process_date='20260314'
and vw_sld.client_id='51828522'
and vw_sld.account_no=COALESCE(null, vw_sld.account_no)
group by vw_sld.account_no
ORDER BY vw_sld.account_no
;

select *
from public.vw_reporte_maestro_datos_movimientos vw_mov
where vw_mov.process_date>='20251229' and vw_mov.process_date<='20260314'
and vw_mov.client_id='51828522'
and vw_mov.account_no=COALESCE(null, vw_mov.account_no)
order by vw_mov.process_date, vw_mov.account_no, vw_mov.cusip
;

--info de cliente
SELECT *
FROM public.vw_reporte_maestro_datos_clientes vw_cte
where vw_cte.process_date='20260314'
and vw_cte.client_id='51828522'
and vw_cte.account_no=COALESCE(null, vw_cte.account_no)
ORDER BY vw_cte.account_no
;

/*
client_id
43076439
T9N001599
T9O001606

*/
SELECT * FROM public.vw_reporte_maestro_datos_clientes vw_cte
where vw_cte.process_date='20260314'
;
--saldo consolidado por fechas
SELECT sum(vw_sld.usde_market_value), client_id, vw_sld.account_no, vw_sld.process_date, count(*)
FROM public.vw_reporte_maestro_datos_saldos vw_sld
where vw_sld.process_date='20260314'
group by process_date,client_id,vw_sld.account_no
ORDER BY count(*), vw_sld.account_no
;

--========================================================================
--========================================================================
--========================================================================
-- Account Type en Maestro Cuentas
select *, account_type from public.vw_reporte_maestro_datos_clientes where process_date='20251224';
select *, account_type_code, custodian_account_type from public.vw_maestro_cuentas_pershing where process_date='20251224';

--TODO: Eliminar fee de vista maestro clientes (y tabla de materialziacion)

--========================================================================
--========================================================================
--========================================================================
--

select pos.process_date, pos.annual_fee, pos.annual_fee*100,*
from public.tbvw_maestro_saldos_pershing pos
where process_date>='20251001' and process_date<='20251231'
and pos.account_no in ('T9N002423')
;

select *
from public.tbvw_maestro_saldos_pershing pos
where process_date>='20251001' and process_date<='20251231'
;

select distinct
    pos.annual_fee, pos.fee_diario, (pos.annual_fee/365)::NUMERIC(45,20), pos.fee_diario-((pos.annual_fee/365)::NUMERIC(45,20)) as diff,
    pos.tasa_proteccion, pos.fee_diario_proteccion, ((pos.tasa_proteccion/365)::NUMERIC(45,20)), pos.fee_diario_proteccion- ((pos.tasa_proteccion/365)::NUMERIC(45,20)) as diff,
    pos.tasa_suracorp, pos.fee_diario_sura_corp, ((pos.tasa_suracorp/365)::NUMERIC(45,20)), pos.fee_diario_sura_corp- ((pos.tasa_suracorp/365)::NUMERIC(45,20)) as diff,
pos.annual_fee-(pos.tasa_proteccion+pos.tasa_suracorp),
pos.fee_diario-(pos.fee_diario_proteccion+pos.fee_diario_sura_corp)
from public.tbvw_maestro_saldos_pershing pos
where process_date>='20251001' and process_date<='20251231'
;

select distinct
    pos.usde_market_value,
    pos.fee_diario_proteccion,
    pos.ingreso_proteccion, pos.fee_diario_proteccion*pos.usde_market_value as ingreso_proteccion_calc,
    ((pos.fee_diario_proteccion*pos.usde_market_value)::NUMERIC(45,20))-pos.ingreso_proteccion as diff,
    pos.fee_diario,
    pos.comision_devengada_diaria, pos.fee_diario*pos.usde_market_value as comision_devengada_diaria_calc,
    ((pos.fee_diario*pos.usde_market_value)::NUMERIC(45,20))-pos.comision_devengada_diaria as diff
from public.tbvw_maestro_saldos_pershing pos
where process_date>='20251001' and process_date<='20251231'
;

--Extracción
SELECT
    pos.row_id, pos.process_date,
    pos.client_id, pos.account_no, pos.name,
    pos.symbol, pos.cusip, pos.isin, pos.product_type, pos.security_description, pos.cash_margin_account,
    pos.currency, pos.quantity, pos.market_price, pos.market_value, pos.fx_rate, pos.usde_market_price, pos.usde_market_value,
    pos.id_sub_sub_tipo_activo, pos.id_sub_tipo_activo, pos.id_tipo_activo, pos.nombre_sub_sub_tipo_activo,
    pos.comision_devengada_diaria, pos.ingreso_proteccion,
    pos.annual_fee, pos.tasa_proteccion, pos.tasa_suracorp,
    pos.fee_diario, pos.fee_diario_proteccion, pos.fee_diario_sura_corp
FROM public.vw_reporte_maestro_datos_saldos pos
where process_date>='20251001' and process_date<='20251231'
order by process_date, pos.client_id, pos.account_no, pos.cusip
;

--TODO: Revisar fee "no redondeados" o fuera de los tramos correctos
select distinct pos.annual_fee, pos.fee_diario, pos.tasa_proteccion, pos.fee_diario_proteccion, pos.tasa_suracorp, pos.fee_diario_sura_corp
,pos.annual_fee-(pos.tasa_proteccion+pos.tasa_suracorp)
,pos.fee_diario-(pos.fee_diario_proteccion+pos.fee_diario_sura_corp)
from public.tbvw_maestro_saldos_pershing pos
;


--========================================================================
--========================================================================
--========================================================================
--Cuadres recaudos marzo

--13947
select
    pos.process_date,
    count(distinct pos.client_id) as cant_client,
    count(distinct pos.account_no) as cant_account,
    count(*) as cant_reg,
    sum(pos.usde_market_value) as sum_usde_market_value
from public.vw_reporte_maestro_datos_saldos pos
where process_date>='20260301' and process_date<='20260309'
group by pos.process_date
order by pos.process_date
;


select
    mov.process_date,
    mov.client_id, mov.name,
    mov.activity, mov.usde_net_amount, mov.cusip, mov.security_description,
    mov.activity_description, mov.activity_code, mov.source_code,
    mov.description1, mov.description2, mov.description3,
    mov.retiro, mov.recaudo
from public.vw_reporte_maestro_datos_movimientos mov
where process_date>='20260301' and process_date<='20260309'
and mov.aplica_flujo_neto=1
order by mov.process_date
;

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



