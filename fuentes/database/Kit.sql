/*
2026-05-21
Actual: 14.1.1-COL
*/

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_PARAMETROS_FERIADOS' FROM public.users where username in ('admin-qye')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTES_INFOREJEC' FROM public.users where username in ('daniel.gomez1', 'santiago.isaza', 'luis.sanchezc', 'valentina.velez')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_MANT_ENROL_CUENTA' FROM public.users where username in ('daniel.gomez1', 'brayan.giraldom')
;
--Nuevo usuario lisdey.velasquez con mismos accesos brayan.giraldom
INSERT INTO public.users (enabled, password, username) VALUES (true, '', 'lisdey.velasquez');
INSERT INTO public.authorities(user_id, authority)
SELECT
    (SELECT id FROM public.users where username='lisdey.velasquez'),
    authorities.authority
FROM public.authorities WHERE authorities.user_id = (SELECT id FROM public.users where username='brayan.giraldom')
;
/*Habilitar nuevos usuarios informe ejecutivo
•	Elizabeth Garzón Zapata – elizabeth.garzon@proteccion.com.co
•	Estefanía Carvajal Orozco – estefania.carvajal@proteccion.com.co
•	Jésica Lisset Sarmiento Vargas – jesica.sarmiento@proteccion.com.co
•	Katherine Múnera Hurtado – katherine.munera@proteccion.com.co
•	Santiago Moreno Salas – santiago.moreno@proteccion.com.co
•	Daniela Agudelo Gómez – daniela.agudelo@proteccion.com.co
*/
INSERT INTO public.users (enabled, password, username) VALUES (true, '', 'elizabeth.garzon');
INSERT INTO public.users (enabled, password, username) VALUES (true, '', 'estefania.carvajal');
INSERT INTO public.users (enabled, password, username) VALUES (true, '', 'jesica.sarmiento');
--INSERT INTO public.users (enabled, password, username) VALUES (true, '', 'katherine.munera');
INSERT INTO public.users (enabled, password, username) VALUES (true, '', 'santiago.moreno');
INSERT INTO public.users (enabled, password, username) VALUES (true, '', 'daniela.agudelo');
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTES_INFOREJEC' FROM public.users where username in ('elizabeth.garzon', 'estefania.carvajal', 'jesica.sarmiento', 'katherine.munera', 'santiago.moreno', 'daniela.agudelo');
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_USER' FROM public.users where username in ('elizabeth.garzon', 'estefania.carvajal', 'jesica.sarmiento', 'santiago.moreno', 'daniela.agudelo');

--Nuevo usuario anyela.ortega@proteccion.com.co
INSERT INTO public.users (enabled, password, username) VALUES (true, '', 'anyela.ortega');
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_USER' FROM public.users where username in ('anyela.ortega');
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTES_INFOREJEC' FROM public.users where username in ('anyela.ortega');

--========================================================================
--========================================================================
--========================================================================
--Re proceso ID mal asignado
/*
Solicito también el reprocesamiento del cliente C E DESARROLLOS INMOBILIARIOS S.A.S. – T9O002919, ya que el registro fue creado con un ID incorrecto (error interno).
Agradecería su apoyo para reprocesarlo desde el 22/04. El NIT correcto es: NIT 900425189 (las PN asociados están correctos).
*/
select *
from clientes.cuenta where cuenta.id_cuenta_custodio='T9O002919';
--id cliente: 414    id: 373
select *
from clientes.cliente where cliente.id=414
or cliente.identificador='900174390'
or cliente.identificador='900425189'
;
--identificador: 900174390 -> 900425189

select client_id, process_date, * from public.tbvw_maestro_cuentas_pershing tb_cta where client_id='900174390' order by process_date;       --20260422->20260511
select client_id, process_date, * from public.tbvw_maestro_saldos_pershing tb_sld where client_id='900174390' order by process_date;        --20260424->20260511
select client_id, process_date, * from public.tbvw_maestro_movimientos_pershing tb_mov where client_id='900174390' order by process_date;   --20260424->20260506

--Respaldamos
SELECT * INTO zz_backup.tbvw_maestro_cuentas_pershing_20260512 FROM public.tbvw_maestro_cuentas_pershing;
SELECT * INTO zz_backup.tbvw_maestro_saldos_pershing_20260512 FROM public.tbvw_maestro_saldos_pershing;
SELECT * INTO zz_backup.tbvw_maestro_movimientos_pershing_20260512 FROM public.tbvw_maestro_movimientos_pershing;

--Actualizamos tabla de cliente
update clientes.cliente set identificador='900425189' where cliente.identificador='900174390';
--Verificamos
select *
from clientes.cliente where cliente.id=414
or cliente.identificador='900174390'
or cliente.identificador='900425189'
;


--Actualizamos tablas de maestros
update public.tbvw_maestro_cuentas_pershing set client_id='900425189' where client_id='900174390';      --20 reg.
update public.tbvw_maestro_saldos_pershing set client_id='900425189' where client_id='900174390';       --92 reg.
update public.tbvw_maestro_movimientos_pershing set client_id='900425189' where client_id='900174390';  --11 reg.

--Verificamos
select client_id, process_date, * from public.tbvw_maestro_cuentas_pershing tb_cta where client_id='900174390' or client_id='900425189';
select client_id, process_date, * from public.tbvw_maestro_saldos_pershing tb_sld where client_id='900174390' or client_id='900425189';
select client_id, process_date, * from public.tbvw_maestro_movimientos_pershing tb_mov where client_id='900174390' or client_id='900425189';


--========================================================================
--========================================================================
--========================================================================
--Re proceso Fee
/*
En línea con lo conversado el día de ayer, 06/05, comparto los registros a reprocesar en la plataforma relacionados con la cuadratura del fee:
1.	Registros a reprocesar
T9O001390 – JORGE HUMBERTO JOHNSON ARISTIZABAL
•	Desde el 25 de abril
2.	T9O001879 – MARTA LUCIA MURILLO ZULUAGA (TOD DTD 07/26/2024)
•	Desde el 23/04

Usando script "ScriptCorreccionFeesSaldos", se reprocesan estos registros saldos y cuentas
WHERE account_no = 'T9O001390' AND process_date >= '20260425' AND process_date <  '20260505'    --64 y 10 reg.
WHERE account_no = 'T9O001879' AND process_date >= '20260423' AND process_date <  '20260505'    --44 y 12 reg.

*/





--========================================================================
--========================================================================
--========================================================================
-- Ajuste Id cliente
/*
Me pueden ayudar con una nueva reprocesamiento de la información para un cliente – fue un cambio del número de ID.
En este momento se hizo el reprocesamiento hasta los días hábiles (el 07/09), por lo que quedaría faltan días anteriores.
La fecha de creación de la cuenta es el 29 de abril de 2026 con cuenta T9O006183.
*/


select *
from clientes.cuenta where cuenta.id_cuenta_custodio='T9O006183';
--id cliente: 417    id: 376
select *
from clientes.cliente where cliente.id=417
;
--identificador: 304425

select client_id, process_date, * from public.tbvw_maestro_cuentas_pershing tb_cta where account_no='T9O006183' order by process_date;      --8 reg.
select client_id, process_date, * from public.tbvw_maestro_saldos_pershing tb_sld where account_no='T9O006183' order by process_date;       --0 reg
select client_id, process_date, * from public.tbvw_maestro_movimientos_pershing tb_mov where account_no='T9O006183' order by process_date;  --0 reg

--Respaldamos
SELECT * INTO zz_backup.tbvw_maestro_cuentas_pershing_20260515 FROM public.tbvw_maestro_cuentas_pershing;
--SELECT * INTO zz_backup.tbvw_maestro_saldos_pershing_20260515 FROM public.tbvw_maestro_saldos_pershing;
--SELECT * INTO zz_backup.tbvw_maestro_movimientos_pershing_20260515 FROM public.tbvw_maestro_movimientos_pershing;


--Actualizamos tablas de maestros
update public.tbvw_maestro_cuentas_pershing set client_id='304425' where account_no='T9O006183' and process_date<='20260506';
--update public.tbvw_maestro_saldos_pershing set client_id='304425' where account_no='T9O006183' and process_date<='20260506';
--update public.tbvw_maestro_movimientos_pershing set client_id='304425' where account_no='T9O006183' and process_date<='20260506';

--Verificamos con query inicial de select a tablas maestros





--========================================================================
--========================================================================
--========================================================================
-- Error parametrización
DELETE FROM public.par_source_code where par_source_code.source_code_pershing='TND' and id=107;
/*
id,source_code_pershing,signo_movimiento,descripcion_movimiento,aplica_flujo_neto,observaciones_internas
107,TND,1,NONTRADE ACTIVITY,0,
*/
DELETE
--SELECT *
FROM public.tbvw_maestro_movimientos_pershing where tbvw_maestro_movimientos_pershing.source_code='TND'
and tbvw_maestro_movimientos_pershing.activity='NONTRADE ACTIVITY'
and tbvw_maestro_movimientos_pershing.process_date='20260107'
and tbvw_maestro_movimientos_pershing.account_no='T9O005110'
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