/*
2025-09-12
Actual: 12.0.1-COL
*/

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTRL_DIFF_FEE' FROM public.users where username in ('admin-qye')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_ADMIN_JOBS_BY_USER' FROM public.users where username in ('brayan.giraldom')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTRL_OPER_DIARIO' FROM public.users where username in ('daniel.gomez1', 'brayan.giraldom')
;


--========================================================================
--========================================================================
--========================================================================
--  fees asignados desde el Q2 al Q4 de 2024, y del Q1 al Q2 de 2025
select *
from public.tbvw_maestro_saldos_pershing
where process_date<'20250701'
;

--Respaldo
SELECT * INTO zz_backup.tbvw_maestro_saldos_pershing_20240911
FROM public.tbvw_maestro_saldos_pershing;

--Q2_Q3_2024
select
    account_no, count(*)    --10, sum:1229  -> Todos ok update
from public.tbvw_maestro_saldos_pershing
where process_date>='20240401' and process_date<='20240630'
and account_no in (
'T9O002448', 'T9O002471', 'T9O001911', 'T9O002414', 'T9O001408', 'T9O001580', 'T9N001490', 'T9O002216', 'T9O002380', 'T9O001523',
'T9O001374', 'T9O002505', 'T9O002679', 'T9N002019', 'T9O001853', 'T9O001382', 'T9O002646', 'T9O001952', 'T9O001804', 'T9O002562',
'T9O002224', 'T9O002588', 'T9O001705', 'T9N001664', 'T9O002430', 'T9O001341', 'T9O001796', 'T9O002026', 'T9O002489', 'T9O001812',
'T9O001598', 'T9O002034', 'T9O001879', 'T9O002166', 'T9O002125', 'T9O002307', 'T9O001473', 'T9O002547', 'T9O001606', 'T9O002208',
'T9O002695', 'T9O001713', 'T9O001903', 'T9O001978', 'T9O002067', 'T9O002604', 'T9O001887', 'T9O001648', 'T9N001631', 'T9O002497',
'T9O001945', 'T9O001192', 'T9N001706', 'T9O002620', 'T9O001929', 'T9O001390', 'T9O001614', 'T9O001465', 'T9O002554', 'T9O001515',
'T9O002422', 'T9O001481', 'T9O002372', 'T9O001531', 'T9O002000', 'T9O001572', 'T9O001457', 'T9O002083', 'T9O002182', 'T9O002265',
'T9O002521', 'T9O002364', 'T9O002059', 'T9O001655', 'T9O002281', 'T9O001564', 'T9N001656', 'T9O001838', 'T9O002273', 'T9O002638',
'T9O002661', 'T9O002711', 'T9O002133', 'T9O002752', 'T9O002778'
)
group by account_no order by account_no ASC
;
--Actualizamos
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002448' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002471' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001911' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002414' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001408' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001580' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001490' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002216' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002380' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001523' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001374' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002505' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002679' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N002019' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001853' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001382' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002646' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001952' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001804' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002562' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002224' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002588' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001705' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001664' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002430' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001341' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001796' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002026' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002489' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001812' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001598' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002034' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001879' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002166' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002125' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002307' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001473' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002547' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001606' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002208' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002695' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001713' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001903' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001978' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002067' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002604' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001887' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001648' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001631' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002497' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001945' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001192' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001706' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002620' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001929' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001390' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001614' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001465' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002554' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001515' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002422' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001481' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002372' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001531' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002000' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001572' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001457' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002083' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002182' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002265' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002521' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002364' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002059' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001655' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002281' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001564' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001656' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001838' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002273' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002638' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002661' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002711' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002133' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002752' AND process_date>='20240401' AND process_date<='20240630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002778' AND process_date>='20240401' AND process_date<='20240630';


--Q4_2024
select
    account_no, count(*)    --66, sum:32483 -> Todos ok update
from public.tbvw_maestro_saldos_pershing
where process_date>='20241001' and process_date<='20241231'
and account_no in (
'T9O002448', 'T9O001911', 'T9O002414', 'T9O001408', 'T9O001580', 'T9N001490', 'T9O002216', 'T9O002380', 'T9O001523', 'T9O001374',
'T9O001853', 'T9O001382', 'T9O001952', 'T9O001804', 'T9O002224', 'T9O001705', 'T9N001664', 'T9O001341', 'T9O002026', 'T9O001812',
'T9O001598', 'T9O002034', 'T9O001879', 'T9O002166', 'T9O002125', 'T9O002307', 'T9O001473', 'T9O001606', 'T9O002208', 'T9O001713',
'T9O001903', 'T9O001978', 'T9O002067', 'T9O001887', 'T9O001648', 'T9N001631', 'T9O002497', 'T9O001945', 'T9O001192', 'T9N001706',
'T9O001929', 'T9O001390', 'T9O001614', 'T9O001465', 'T9O001515', 'T9O002422', 'T9O001481', 'T9O002372', 'T9O001531', 'T9O002000',
'T9O001572', 'T9O001457', 'T9O002083', 'T9O002182', 'T9O002265', 'T9O002364', 'T9O002059', 'T9O001366', 'T9O001655', 'T9O001267',
'T9O001937', 'T9O002281', 'T9O001564', 'T9N001656', 'T9O001838', 'T9O002273'
)
group by account_no order by account_no ASC
;
--Actualizamos
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002448' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001911' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002414' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001408' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001580' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001490' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002216' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002380' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001523' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001374' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001853' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001382' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001952' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001804' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002224' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001705' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001664' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001341' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002026' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001812' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001598' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002034' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001879' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002166' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002125' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002307' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001473' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001606' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002208' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001713' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001903' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001978' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002067' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001887' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001648' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001631' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002497' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001945' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001192' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001706' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001929' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001390' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001614' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001465' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001515' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002422' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001481' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002372' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001531' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002000' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001572' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001457' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002083' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002182' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002265' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002364' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002059' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001366' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001655' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001267' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001937' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002281' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001564' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001656' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001838' AND process_date>='20241001' AND process_date<='20241231';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002273' AND process_date>='20241001' AND process_date<='20241231';


--Q1_2025
select
    account_no, count(*)    --111, sum: 51065 -> Todos ok update
from public.tbvw_maestro_saldos_pershing
where process_date>='20250101' and process_date<='20250331'
and account_no in (
'T9O002448', 'T9O002471', 'T9O001911', 'T9O002414', 'T9O002851', 'T9O002737', 'T9O001580', 'T9O002794', 'T9N001490', 'T9O002216', 
'T9O002380', 'T9O001523', 'T9N002183', 'T9O001374', 'T9O002901', 'T9O002505', 'T9O002893', 'T9O002133', 'T9O003024', 'T9O002679', 
'T9O002315', 'T9N002019', 'T9O001853', 'T9O002786', 'T9O002661', 'T9O002943', 'T9O002240', 'T9O001382', 'T9O002646', 'T9O002877', 
'T9O001952', 'T9O001804', 'T9O002562', 'T9O002158', 'T9O002224', 'T9O002588', 'T9N001664', 'T9O002430', 'T9O001341', 'T9O001796', 
'T9O002026', 'T9O002489', 'T9O001812', 'T9O001598', 'T9O002034', 'T9O001879', 'T9O002166', 'T9O002042', 'T9O002125', 'T9O002307', 
'T9O001473', 'T9O002547', 'T9O002570', 'T9O001606', 'T9O002208', 'T9O002695', 'T9O002778', 'T9O001960', 'T9O001713', 'T9O001903', 
'T9O001978', 'T9O002711', 'T9O002067', 'T9O002604', 'T9O002828', 'T9O002976', 'T9O001887', 'T9O001648', 'T9N001631', 'T9O002497', 
'T9O001945', 'T9O001192', 'T9N001706', 'T9O002620', 'T9O003057', 'T9O001929', 'T9O001390', 'T9O001614', 'T9O002885', 'T9O001465', 
'T9O002554', 'T9O001515', 'T9O002422', 'T9O002752', 'T9O001481', 'T9O002232', 'T9O002372', 'T9O001531', 'T9O002000', 'T9O001572', 
'T9O002992', 'T9O002844', 'T9O001457', 'T9O002083', 'T9O002182', 'T9O002265', 'T9O002521', 'T9O002364', 'T9O002059', 'T9O001366', 
'T9O001655', 'T9O001267', 'T9O002331', 'T9O001937', 'T9O002281', 'T9O001564', 'T9O003206', 'T9N001656', 'T9O001838', 'T9O002869', 
'T9O002273'
)
group by account_no order by account_no ASC
;
--Actualizamos
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002448' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002471' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001911' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002414' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002851' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002737' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001580' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002794' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.749999999999999, fee_diario=fn_change_base_fee(0.749999999999999, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.749999999999999, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001490' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002216' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002380' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001523' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N002183' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001374' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002901' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002505' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002893' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002133' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O003024' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002679' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002315' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N002019' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001853' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002786' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002661' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002943' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002240' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001382' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002646' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002877' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001952' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001804' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002562' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002158' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002224' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002588' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.749999999999999, fee_diario=fn_change_base_fee(0.749999999999999, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.749999999999999, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001664' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002430' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001341' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001796' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002026' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002489' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001812' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001598' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002034' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001879' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002166' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002042' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002125' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002307' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001473' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002547' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002570' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.749999999999998, fee_diario=fn_change_base_fee(0.749999999999998, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.749999999999998, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001606' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002208' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002695' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002778' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001960' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001713' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001903' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001978' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002711' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002067' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002604' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002828' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002976' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001887' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001648' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.750000000000001, fee_diario=fn_change_base_fee(0.750000000000001, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.750000000000001, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001631' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002497' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001945' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001192' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.999999999999999, fee_diario=fn_change_base_fee(0.999999999999999, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.999999999999999, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001706' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002620' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O003057' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001929' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001390' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.749999999999998, fee_diario=fn_change_base_fee(0.749999999999998, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.749999999999998, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001614' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002885' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001465' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002554' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001515' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002422' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002752' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001481' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002232' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002372' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001531' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002000' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001572' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002992' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002844' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001457' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002083' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002182' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002265' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002521' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002364' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002059' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001366' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001655' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001267' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002331' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001937' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002281' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001564' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O003206' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001656' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001838' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002869' AND process_date>='20250101' AND process_date<='20250331';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002273' AND process_date>='20250101' AND process_date<='20250331';



--Q2_2025
select
    account_no, count(*)    --10, sum: 5552 -> Todos ok (2 cuentas estaba duplicadas en update, pero mismo valor)
from public.tbvw_maestro_saldos_pershing
where process_date>='20250401' and process_date<='20250630'
and account_no in (
'T9O002471', 'T9O002828', 'T9O001390', 'T9O002794', 'T9O002471', 'T9O002794', 'T9O002828', 'T9O001390', 'T9O002059', 'T9O001523', 
'T9O002059', 'T9O002273', 'T9O002943', 'T9O002976', 'T9O003586'
)
group by account_no order by account_no ASC
;
--Actualizamos
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002471' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002828       ' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001390' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002794 ' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002471' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002794' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002828' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001390' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002059' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001523' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002059' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002273' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002943' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002976' AND process_date>='20250401' AND process_date<='20250630';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O003586' AND process_date>='20250401' AND process_date<='20250630';





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



