--========================================================================
--========================================================================
--========================================================================
-- Alertas cuenta T9N002324

/*
Desde el 29-jul
*/
SELECT * FROM public.vw_reporte_maestro_datos_saldos where trim(account_no)='T9N002324';
--3510798.72000000000000000000

/*
Desde el 29-jul
*/
SELECT * FROM public.vw_reporte_maestro_datos_movimientos where trim(account_no)='T9N002324';
--3510798.72000000000000000000



--========================================================================
--========================================================================
--========================================================================
--

select vw_com.comision_diaria_saldo, *
    from clientes.vw_maestro_comision vw_com
;


select 1, 0.00002726150000000000, (power(1 + 0.00002726150000000000, 365) - 1) * 100, public.fn_change_base_fee(0.00002726150000000000, 'DAILY', 'ANNUAL', 'E')
UNION
select 2, 0.00002726150000000000, 0.00002726150000000000*365*100, public.fn_change_base_fee(0.00002726150000000000, 'DAILY', 'ANNUAL', 'P')
UNION
select 3, 1.25, power(1 + (1.25 / 100.0), 1.0 / 365) - 1, public.fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'E')
UNION
select 4, 1.25, 1.25/365/100, public.fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P')
UNION
select 5, 1.25, 1.25/365/100, public.fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P')
;


--========================================================================
--========================================================================
--========================================================================
-- Flag ingresos/egresos nulo/vacio

select *
from public.vw_maestro_movimientos_pershing
where trim(account_no)='T9N002324'
;


select *
from public.vw_maestro_movimientos_pershing
where trim(account_no)='T9N001631'
ORDER BY process_date ASC

;




select * from public.vw_reporte_maestro_datos_movimientos
where aplica_flujo_neto is null;

--========================================================================
--========================================================================
--========================================================================
-- Fecha apertura cuenta
SELECT distinct account_number, date_account_opened, min(process_date)
FROM pershing.vw_maestro_cuenta
group by account_number, date_account_opened
;






--========================================================================
--========================================================================
--========================================================================
--



