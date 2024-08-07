--Cuenta SURA RIA informadas

SELECT * FROM pershing.sfl_gact
where account_number like '%T9N8%' or account_number like '%T9N9%' or account_number like '%T9O8%' or account_number like '%T9O9%'
;
--4+729
SELECT * FROM pershing.sfl_gact
where NOT pershing.fn_excluye_cuenta('CARGA_SFL', account_number)
;


--733
SELECT * FROM pershing.sfl_gact
;


select *
from public.vw_reporte_maestro_datos_movimientos
where pershing.fn_excluye_cuenta('CARGA_SFL', account_no)
;

select *
from public.vw_reporte_maestro_datos_saldos
where pershing.fn_excluye_cuenta('CARGA_SFL', account_no)
;

select *
from public.vw_reporte_maestro_datos_clientes
where pershing.fn_excluye_cuenta('CARGA_SFL', account_no)
;


SELECT * FROM stage_pershing.stage_gmon_reg_header
where process_date='20240723'
;


SELECT * FROM pershing.sfl_gmon
where process_date='20240723'
;