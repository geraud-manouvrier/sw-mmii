--========================================================================
--========================================================================
--========================================================================
--

select distinct process_date
from public.vw_reporte_maestro_datos_saldos
order by process_date
;

select count(*) as registros, count(distinct account_no) as cuentas, process_date
from public.tbvw_maestro_saldos_pershing
where COALESCE(client_id,'')=''
--and account_no not in (select distinct id_cuenta_custodio from clientes.cuenta)
group by process_date
order by process_date
;

select * from clientes.cuenta;


select * from public.vw_reporte_maestro_datos_saldos
where process_date='20240807'
;


select * from public.tbvw_maestro_saldos_pershing
where process_date='20240807'
;


--========================================================================
--========================================================================
--========================================================================
--
SELECT distinct process_date FROM zz_backup.tbvw_maestro_cuentas_pershing_20250114 where client_id IS NULL order by 1;
SELECT distinct process_date FROM zz_backup.tbvw_maestro_movimientos_pershing_20250114 where client_id IS NULL order by 1;
SELECT distinct process_date FROM zz_backup.tbvw_maestro_saldos_pershing_20250114 where client_id IS NULL or id_fee_aplicado IS NULL order by 1;

SELECT distinct process_date FROM zz_backup.tbvw_maestro_cuentas_pershing_20250114 where client_id IS NULL UNION
SELECT distinct process_date FROM zz_backup.tbvw_maestro_movimientos_pershing_20250114 where client_id IS NULL UNION
SELECT distinct process_date FROM zz_backup.tbvw_maestro_saldos_pershing_20250114 where client_id IS NULL or id_fee_aplicado IS NULL
;

--========================================================================
--========================================================================
--========================================================================
--

SELECT * FROM public.fn_control_diario_cuentas_no_mapeadas('20250122');


SELECT * FROM  public.fn_control_diario('20250122', 'admin');

SELECT * FROM public.fn_control_diario_reporte_listado('20250122', '20250122', 0);

select * from public.jobs_log;
select * from public.jobs_estado;
--select * from public.jobs_maestro;
select * from public.control_diario;


SELECT estado FROM public.jobs_estado WHERE id_job=1 and id_proceso='20250122' AND sub_id_proceso = '';

SELECT * FROM public.fn_control_diario_cuentas_no_mapeadas('20250122');
SELECT * FROM public.fn_control_diario_cuentas_no_mapeadas('20250121');
SELECT * FROM public.fn_control_diario_cuentas_no_mapeadas('20250120');
--========================================================================
--========================================================================
--========================================================================
--





--========================================================================
--========================================================================
--========================================================================
--



