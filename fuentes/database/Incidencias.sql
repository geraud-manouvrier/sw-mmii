--========================================================================
--========================================================================
--========================================================================
--
select min(process_date) from public.vw_reporte_maestro_datos_clientes;
select min(process_date) from public.vw_reporte_maestro_datos_saldos;
select min(process_date) from public.vw_reporte_maestro_datos_movimientos;

--========================================================================
--========================================================================
--========================================================================
-- Reporte Clientes
--Saldo diario detallado
SELECT max(process_date)
FROM public.vw_reporte_maestro_datos_saldos vw_sld
;
SELECT *
FROM public.vw_reporte_maestro_datos_saldos vw_sld
where vw_sld.process_date='20260204'
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
where vw_mov.process_date>='20260201' and vw_mov.process_date<='20260207'
and vw_mov.client_id='51828522'
and vw_mov.account_no=COALESCE(null, vw_mov.account_no)
order by vw_mov.process_date, vw_mov.account_no, vw_mov.cusip
;

--Últimos recaudos
select *
from public.vw_reporte_maestro_datos_movimientos vw_mov
where vw_mov.client_id='51828522'
and vw_mov.account_no=COALESCE(null, vw_mov.account_no)
and (vw_mov.ingreso_egreso or vw_mov.aplica_flujo_neto=1)
ORDER BY account_no, process_date desc, cusip desc
limit 10
;
--Últimos recaudos
select
    vw_mov.client_id, vw_mov.account_no,
    min(vw_mov.process_date) as first_mov_date, max(vw_mov.process_date) as last_mov_date
from public.vw_reporte_maestro_datos_movimientos vw_mov
where vw_mov.client_id='51828522'
and vw_mov.account_no=COALESCE(null, vw_mov.account_no)
and (vw_mov.ingreso_egreso or vw_mov.aplica_flujo_neto=1)
group by vw_mov.client_id, vw_mov.account_no
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

--Retornos que fallan por redondeo?
SELECT * FROM rep_inv.fn_calcula_rentabilidad
('51828522', null, null, null, '20260101', '20260331') fn_rent
WHERE CASE WHEN true then true ELSE fn_rent.agregador_n1='51828522' and COALESCE(fn_rent.agregador_n2,'')=COALESCE(null,'') END
order by fn_rent.nivel, fn_rent.process_date, fn_rent.agregador_n1, fn_rent.agregador_n2, fn_rent.agregador_n3, fn_rent.agregador_n4
;

SELECT *
FROM rep_inv.fn_calculo_rentabilidad_agregada('20260101', '20260331', '51828522',null, null, null)
;


SELECT
    'N1'::VARCHAR(100) as nivel,
    rank() OVER (ORDER BY tbn.process_date, tbn.agregador_n1)::BIGINT as sub_nivel,
    tbn.process_date, tbn.process_date_as_date,
    tbn.agregador_n1, NULL::VARCHAR(100) as agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4,
    tbn.saldo_dia_anterior, tbn.abonos_dia, tbn.retiros_dia, tbn.dividendos_dia, tbn.saldo_dia,
    tbn.comision_devengada_dia,
    tbn.utilidad, tbn.rentabilidad, tbn.rentabilidad_base_pitatoria, tbn.saldo_rentabilidad
FROM rep_inv.consolidado_agregado_n1 tbn
WHERE tbn.agregador_n1=COALESCE('51828522', tbn.agregador_n1)
AND tbn.process_date>='20260101' AND tbn.process_date<='20260331'
UNION
SELECT
    'N2'::VARCHAR(100) as nivel,
    rank() OVER (ORDER BY tbn.process_date, tbn.agregador_n1, tbn.agregador_n2)::BIGINT as sub_nivel,
    tbn.process_date, tbn.process_date_as_date,
    tbn.agregador_n1, tbn.agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4,
    tbn.saldo_dia_anterior, tbn.abonos_dia, tbn.retiros_dia, tbn.dividendos_dia, tbn.saldo_dia,
    tbn.comision_devengada_dia,
    tbn.utilidad, tbn.rentabilidad, tbn.rentabilidad_base_pitatoria, tbn.saldo_rentabilidad
FROM rep_inv.consolidado_agregado_n2 tbn
WHERE tbn.agregador_n1=COALESCE('51828522', tbn.agregador_n1) AND tbn.agregador_n2=COALESCE(null, tbn.agregador_n2)
AND tbn.process_date>='20260101' AND tbn.process_date<='20260331'
;

--saldos duplicados, implica retornos mal calculados
--20260310
select count(*),
       tb_sld.process_date, tb_sld.client_id, tb_sld.account_no,
       tb_sld.cusip, tb_sld.symbol, tb_sld.isin_code, tb_sld.cash_margin_account, tb_sld.product_type, tb_sld.currency,
       tb_sld.quantity
from public.tbvw_maestro_saldos_pershing tb_sld
group by
       tb_sld.process_date, tb_sld.client_id, tb_sld.account_no,
       tb_sld.cusip, tb_sld.symbol, tb_sld.isin_code, tb_sld.cash_margin_account, tb_sld.product_type, tb_sld.currency,
       tb_sld.quantity
having count(*)<>1
;
--6547
/*
20250518, 19, 20, 21
20260310, 17
*/


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
--Cuadres recaudos marzo


SELECT
    COALESCE(sld.process_date, mov.process_date) as process_date,
    COALESCE(sld.account_no, mov.account_no) as account_no,
    --sld.cant_sld,
    sld.saldo_dia,
    COALESCE(mov.sum_movtos_dia, 0) as sum_movtos_dia,
    COALESCE(mov.sum_retiro_dia, 0) as sum_retiro_dia,
    COALESCE(mov.sum_recaudo_dia, 0) as sum_recaudo_dia,
    COALESCE(mov.cant_mov_dia, 0) as cantidad_movimientos_dia
FROM (select pos.process_date,
             pos.account_no,
             count(*)                   as cant_sld,
             sum(pos.usde_market_value) as saldo_dia
      from public.vw_reporte_maestro_datos_saldos pos
      where process_date >= '20260301' --and process_date<='20260309'
      group by pos.process_date, pos.account_no
      order by pos.process_date, pos.account_no) as sld
FULL OUTER JOIN
     (select mov.process_date,
             mov.account_no,
             --mov.aplica_flujo_neto,
             count(*)                 as cant_mov_dia,
             sum(mov.usde_net_amount) as sum_movtos_dia,
             sum(mov.retiro)          as sum_retiro_dia,
             sum(mov.recaudo)         as sum_recaudo_dia
      from public.vw_reporte_maestro_datos_movimientos mov
      where process_date >= '20260301'
      --and process_date<='20260309'
--and mov.aplica_flujo_neto=1
      group by mov.process_date, mov.account_no--, mov.aplica_flujo_neto
      order by mov.process_date, mov.account_no--, mov.aplica_flujo_neto
     ) as mov
ON sld.process_date = mov.process_date
AND sld.account_no = mov.account_no
ORDER BY sld.account_no, sld.process_date
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
and mov.account_no='T9O003271' and mov.process_date='20260303'
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



