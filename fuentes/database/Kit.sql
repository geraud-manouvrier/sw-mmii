/*
2025-02-26
Actual: 10.2.0-COL
*/

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_ADMINQANDE_LOGS_VIEWER' FROM public.users where username in ('admin-qye')
;




--========================================================================
--========================================================================
--========================================================================
--

/*
Nombre: MARIA CLAUDIA URIZA PARDO RICARDO TORRES BELMONTE JT TEN
# cuenta: T9O003222
CC: 51788982
*/
select *
from clientes.cliente
--update clientes.cliente set nombre='MARIA CLAUDIA URIZA PARDO RICARDO TORRES BELMONTE JT TEN'
where identificador='51788982';


select *
from clientes.cuenta
--UPDATE clientes.cuenta set id_cuenta_custodio='T9O003222'
where id_cliente=167 and id=156;












--========================================================================
--========================================================================
--========================================================================
-- Excepciones Comisiones mal ingresadas y reprocesos
/*
Caso Jorge Alberto Zuluaga Martinez – desde el 26/08/2024 – la tasa anualizada a utilizar sería 0,10%, lo que equivale a una tasa diaria de 0,0000027384.
Caso Lina Maria Toro Villa – desde el 26/08/2024 – la tasa anualizada a utilizar sería 0,10%, lo que equivale a una tasa diaria de 0,0000027384.
*/
select * from clientes.cliente
where identificador in ('98549660','43627165');
;

select * from clientes.cuenta where id_cliente in (53,56);

UPDATE clientes.comision_cuenta set comision_diaria_saldo= CASE WHEN id_cuenta=54 THEN 0.0000027384 WHEN id_cuenta=57 THEN 0.0000027384 ELSE comision_diaria_saldo END
--select * from clientes.comision_cuenta
WHERE id_cuenta in (54,57)
;

select * from clientes.comision_cuenta
WHERE id_cuenta in (54,57);

--Reprocesos
select *
from public.vw_maestro_saldos_pershing where account_no IN ('T9O001937', 'T9O001960')
;
select *
from public.tbvw_maestro_saldos_pershing where account_no IN ('T9O001937', 'T9O001960')
;


SELECT * INTO zz_backup.tbvw_maestro_saldos_pershing_20250322
FROM public.tbvw_maestro_saldos_pershing;

--2498
SELECT COUNT(*) FROM public.tbvw_maestro_saldos_pershing WHERE account_no IN ('T9O001937', 'T9O001960') and process_date >= '20240826';

update public.tbvw_maestro_saldos_pershing t
set annual_fee = v.annual_fee,
    fee_diario = v.fee_diario,
    comision_devengada_diaria = v.comision_devengada_diaria
from public.vw_maestro_saldos_pershing v
where t.account_no = v.account_no
  and t.process_date = v.process_date
  and t.cusip = v.cusip
  and t.currency = v.currency
  and t.account_no IN ('T9O001937', 'T9O001960')
  and t.process_date >= '20240826'
;



SELECT * FROM public.tbvw_maestro_saldos_pershing WHERE account_no IN ('T9O001937', 'T9O001960') and process_date >= '20240826' order by process_date, account_no, cusip, currency;
SELECT * FROM zz_backup.tbvw_maestro_saldos_pershing_20250322 WHERE account_no IN ('T9O001937', 'T9O001960') and process_date >= '20240826' order by process_date, account_no, cusip, currency;


--========================================================================
--========================================================================
--========================================================================
-- Excepciones Comisiones mal ingresadas y reprocesos   -> Correcciónd e 0.0000027384 a 0.0000272615

select * from clientes.cliente
where identificador in ('98549660','43627165');
;

select * from clientes.cuenta where id_cliente in (53,56);

select * from clientes.comision_cuenta WHERE id_cuenta in (54,57);

UPDATE clientes.comision_cuenta set comision_diaria_saldo= CASE WHEN id_cuenta=54 THEN 0.0000272615 WHEN id_cuenta=57 THEN 0.0000272615 ELSE comision_diaria_saldo END
--select * from clientes.comision_cuenta
WHERE id_cuenta in (54,57)
;

select * from clientes.comision_cuenta
WHERE id_cuenta in (54,57);

--Reprocesos
select *
from public.vw_maestro_saldos_pershing where account_no IN ('T9O001937', 'T9O001960')
;
select *
from public.tbvw_maestro_saldos_pershing where account_no IN ('T9O001937', 'T9O001960')
;

SELECT * INTO zz_backup.tbvw_maestro_saldos_pershing_20250326
FROM public.tbvw_maestro_saldos_pershing;

--2546
SELECT COUNT(*) FROM public.tbvw_maestro_saldos_pershing WHERE account_no IN ('T9O001937', 'T9O001960') and process_date >= '20240826';

update public.tbvw_maestro_saldos_pershing t
set annual_fee = v.annual_fee,
    fee_diario = v.fee_diario,
    comision_devengada_diaria = v.comision_devengada_diaria
from public.vw_maestro_saldos_pershing v
where t.account_no = v.account_no
  and t.process_date = v.process_date
  and t.cusip = v.cusip
  and t.currency = v.currency
  and t.account_no IN ('T9O001937', 'T9O001960')
  and t.process_date >= '20240826'
;



SELECT * FROM public.tbvw_maestro_saldos_pershing WHERE account_no IN ('T9O001937', 'T9O001960') and process_date >= '20240826' order by process_date, account_no, cusip, currency;
SELECT * FROM zz_backup.tbvw_maestro_saldos_pershing_20250326 WHERE account_no IN ('T9O001937', 'T9O001960') and process_date >= '20240826' order by process_date, account_no, cusip, currency;



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



