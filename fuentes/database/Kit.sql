/*
2025-10-09
Actual: 12.1.1-COL
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

--Respaldo
SELECT * INTO zz_backup.tbvw_maestro_saldos_pershing_20241007
FROM public.tbvw_maestro_saldos_pershing;

--Q2_Q3_2024
--Actualizamos
--Grupo de actualización rpevia que faltaba Q3 (se actualizó sólo Q2)
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002448' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002471' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001911' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002414' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001408' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001580' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001490' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002216' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002380' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001523' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001374' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002505' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002679' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N002019' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001853' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001382' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002646' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001952' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001804' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002562' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002224' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002588' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001705' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001664' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002430' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001341' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001796' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002026' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002489' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001812' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001598' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002034' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001879' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002166' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002125' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002307' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001473' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002547' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001606' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002208' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002695' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001713' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001903' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001978' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002067' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002604' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001887' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001648' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001631' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002497' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001945' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001192' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1, fee_diario=fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001706' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002620' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001929' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001390' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001614' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001465' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002554' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001515' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002422' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001481' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002372' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001531' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002000' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001572' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001457' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002083' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002182' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002265' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002521' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002364' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002059' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001655' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002281' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001564' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=0.75, fee_diario=fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(0.75, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9N001656' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O001838' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002273' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002638' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002661' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002711' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002133' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002752' AND process_date>='20240701' AND process_date<='20240930';
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') WHERE account_no='T9O002778' AND process_date>='20240701' AND process_date<='20240930';

--Pendientes por tramos
--1.25 hasta el 12/08; 1.0 desde el 13/08
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') 
WHERE account_no='T9O001960' AND process_date>='20240401' AND process_date<='20240930' AND process_date<='20240812';

UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.0, fee_diario=fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P') 
WHERE account_no='T9O001960' AND process_date>='20240401' AND process_date<='20240930' AND process_date>='20240813';

--1.5 hasta el 30/06; 1.0 desde el 01/07
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') 
WHERE account_no='T9O001366' AND process_date>='20240401' AND process_date<='20240930' and process_date<='20240630';

UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.0, fee_diario=fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P') 
WHERE account_no='T9O001366' AND process_date>='20240401' AND process_date<='20240930' and process_date>='20240701';

--1.5 hasta el 12/06; 1.25 desde el 13/06
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') 
WHERE account_no='T9O001267' AND process_date>='20240401' AND process_date<='20240930' and process_date<='20240612';

UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') 
WHERE account_no='T9O001267' AND process_date>='20240401' AND process_date<='20240930' and process_date>='20240613';

--1.25 hasta el 25/08; 1.5 desde el 26/08
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P') 
WHERE account_no='T9O001937' AND process_date>='20240401' AND process_date<='20240930' and process_date<='20240825';

UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P') 
WHERE account_no='T9O001937' AND process_date>='20240401' AND process_date<='20240930' and process_date>='20240826';


--Q4_2024
--Respaldo
SELECT * INTO zz_backup.tbvw_maestro_saldos_pershing_20241009
FROM public.tbvw_maestro_saldos_pershing;
--Actualizamos
/*
Con base en lo que mencionas, confirmo que la cuenta T9O001960, correspondiente al cliente con CC 43627165,
tiene asignado un fee del 1,00% a partir del 13/08/2024 en adelante.
*/
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.0, fee_diario=fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P')
WHERE account_no='T9O001960' AND process_date>='20241001';





--Q1_2025

--Actualizamos
--1.25 hasta el 17/02; 1.0 desde el 18/02
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P')
WHERE account_no='T9O001408' AND process_date>='20250101' AND process_date<='20250331' AND process_date<='20250217';

UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.0, fee_diario=fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P')
WHERE account_no='T9O001408' AND process_date>='20250101' AND process_date<='20250331' AND process_date>='20250217';

--1.25 hasta el 23/03; 1.0 desde el 24/03
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P')
WHERE account_no='T9O002638' AND process_date>='20250101' AND process_date<='20250331' AND process_date<='20250323';

UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.0, fee_diario=fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P')
WHERE account_no='T9O002638' AND process_date>='20250101' AND process_date<='20250331' AND process_date>='20250324';

--1.25 hasta el 18/02; 1.0 desde el 19/02
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P')
WHERE account_no='T9O001705' AND process_date>='20250101' AND process_date<='20250331' AND process_date<='20250218';

UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.0, fee_diario=fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P')
WHERE account_no='T9O001705' AND process_date>='20250101' AND process_date<='20250331' AND process_date>='20250219';

--1.0 hasta el 20/02; 1.5 desde el 21/02; 1.25 desde el 25/03
UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.0, fee_diario=fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.0, 'ANNUAL', 'DAILY', 'P')
WHERE account_no='T9O001846' AND process_date>='20250101' AND process_date<='20250331' AND process_date<='20250220';

UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.5, fee_diario=fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.5, 'ANNUAL', 'DAILY', 'P')
WHERE account_no='T9O001846' AND process_date>='20250101' AND process_date<='20250331' AND process_date>='20250221' AND process_date<='20250324';

UPDATE public.tbvw_maestro_saldos_pershing set annual_fee=1.25, fee_diario=fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P'), comision_devengada_diaria=usde_market_value*fn_change_base_fee(1.25, 'ANNUAL', 'DAILY', 'P')
WHERE account_no='T9O001846' AND process_date>='20250101' AND process_date<='20250331' AND process_date>='20250325';













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



