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
-- Integración Fee RIA
-- Función para actualziar el fee en maestro cuentas, saldos y recalcular valores derivados (pendiente ver si se actualzia en la cuenta modelo clientes)
CREATE or replace function public.fn_actualiza_fee_ria(
    _custodian VARCHAR(100),
    _account_no VARCHAR(100),
    _process_date VARCHAR(100),
    _new_annual_percent_fee numeric
)
returns table(
    custodian varchar(100),
    account_no varchar(100),
    process_date varchar(100),
    new_annual_percent_fee numeric(45,20),
    --Cambios en modelo clientes
    modelo_clientes_rows_updated int,
    --Cambios en maestro saldos
    maestro_saldos_rows_match int,
    maestro_saldos_rows_updated int,
    maestro_saldos_old_annual_fee_min numeric(45,20),
    maestro_saldos_old_annual_fee_max numeric(45,20),
    maestro_saldos_new_annual_fee numeric(45,20),
    --Cambios en maestro cuentas
    maestro_cuentas_rows_match int,
    maestro_cuentas_rows_updated int,
    maestro_cuentas_old_fee_min numeric(45,20),
    maestro_cuentas_old_fee_max numeric(45,20),
    maestro_cuentas_new_fee numeric(45,20),
    --Campos de control
    status_code int,
    status_msg varchar(1000)
)
language plpgsql
as
$$
DECLARE
    _cant_update_model_cte int := 0;
    _cant_match_saldos int;
    _cant_update_saldos int;
    _cant_match_cuentas int;
    _cant_update_cuentas int;
    _old_fee_saldos_min numeric(45,20);
    _old_fee_saldos_max numeric(45,20);
    _old_fee_cuentas_min numeric(45,20);
    _old_fee_cuentas_max numeric(45,20);
BEGIN
    --Validaciones mínimas
    IF _custodian IS NULL OR trim(_custodian) = '' THEN
        RAISE EXCEPTION '_custodian no puede ser nulo/vacío' USING ERRCODE = '22023';
    END IF;

    IF _account_no IS NULL OR trim(_account_no) = '' THEN
        RAISE EXCEPTION '_account_no no puede ser nulo/vacío' USING ERRCODE = '22023';
    END IF;

    IF _process_date IS NULL OR trim(_process_date) = '' THEN
        RAISE EXCEPTION '_process_date no puede ser nulo/vacío' USING ERRCODE = '22023';
    END IF;

    IF _new_annual_percent_fee IS NULL OR _new_annual_percent_fee < 0 THEN
        RAISE EXCEPTION '_new_annual_percent_fee inválido [%]', _new_annual_percent_fee USING ERRCODE = '22023';
    END IF;

    --Normalizamos
    _custodian:= trim(upper(_custodian));

    --Modelo clientes (N/A)
    if (_process_date=public.get_max_process_date()) then
        RAISE NOTICE 'Actualizando Fee de Modelo Clientes...';
        UPDATE clientes.cuenta
            set fee = _new_annual_percent_fee
        WHERE upper(cuenta.id_custodio) = _custodian
        AND cuenta.id_cuenta_custodio   = _account_no
        ;

        GET DIAGNOSTICS _cant_update_model_cte = ROW_COUNT;
    END IF;

    --Estadísticas previas a update
    SELECT
        count(*),
        min(annual_fee),
        max(annual_fee)
    INTO
        _cant_match_saldos,
        _old_fee_saldos_min,
        _old_fee_saldos_max
    FROM public.tbvw_maestro_saldos_pershing tb_sld
    WHERE tb_sld.account_no = _account_no
      AND tb_sld.process_date = _process_date
      AND upper(tb_sld.custodian) = _custodian;

    --Actualizamos registros de Maestro de saldos
    UPDATE public.tbvw_maestro_saldos_pershing tb_sld
    SET
        id_fee_aplicado           = calc.id_fee_aplicado_calc,
        annual_fee                = calc.annual_fee_calc,
        tasa_proteccion           = calc.tasa_proteccion_calc,
        tasa_suracorp             = calc.tasa_suracorp_calc,
        fee_diario                = calc.fee_diario_calc,
        fee_diario_proteccion     = calc.fee_diario_proteccion_calc,
        fee_diario_sura_corp      = calc.fee_diario_sura_corp_calc,
        comision_devengada_diaria = calc.comision_devengada_diaria_calc,
        ingreso_proteccion        = calc.ingreso_proteccion_calc
    FROM (
        SELECT
            base.row_no,
            base.process_date,
            base.account_no,
            base.usde_market_value,
            base.total_usde_market_value,
            --Campos a usar en update: valor calculado y valor actualmente existente
            base.id_fee_aplicado as id_fee_aplicado_actual,
            fee_seg.id as id_fee_aplicado_calc,
            base.annual_fee as annual_fee_actual,
            (base.new_fee / 100)::numeric(45,20) AS annual_fee_calc,
            base.tasa_proteccion as tasa_proteccion_actual,
            (fn_dist.fee_perc_proteccion / 100)::NUMERIC(45,20) AS tasa_proteccion_calc,
            base.tasa_suracorp as tasa_suracorp_actual,
            (fn_dist.fee_perc_ria / 100)::NUMERIC(45,20)        AS tasa_suracorp_calc,
            base.fee_diario as fee_diario_actual,
            fn_change_base_fee(base.new_fee, 'ANNUAL', 'DAILY', 'P')::NUMERIC(45,20) AS fee_diario_calc,
            base.fee_diario_proteccion as fee_diario_proteccion_actual,
            fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying)::NUMERIC(45,20) as fee_diario_proteccion_calc,
            base.fee_diario_sura_corp as fee_diario_sura_corp_actual,
            fn_change_base_fee(fn_dist.fee_perc_ria, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying)::NUMERIC(45,20) as fee_diario_sura_corp_calc,
            base.comision_devengada_diaria as comision_devengada_diaria_actual,
            (fn_change_base_fee(base.new_fee, 'ANNUAL', 'DAILY', 'P')*base.usde_market_value)::NUMERIC(45,20) as comision_devengada_diaria_calc ,
            base.ingreso_proteccion as ingreso_proteccion_actual,
            (fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying)*base.usde_market_value)::NUMERIC(45,20) as ingreso_proteccion_calc
        FROM
        (
            SELECT
                tb_sld.row_no,
                tb_sld.process_date,
                upper(tb_sld.custodian)::VARCHAR(100) as custodian,
                tb_sld.account_no,
                tb_sld.usde_market_value,
                tb_sld.total_usde_market_value,
                tb_sld.id_fee_aplicado,
                tb_sld.annual_fee,
                tb_sld.tasa_proteccion,
                tb_sld.tasa_suracorp,
                tb_sld.fee_diario,
                tb_sld.fee_diario_proteccion,
                tb_sld.fee_diario_sura_corp,
                tb_sld.comision_devengada_diaria,
                tb_sld.ingreso_proteccion,
                _new_annual_percent_fee::NUMERIC(45,20) as new_fee
            FROM public.tbvw_maestro_saldos_pershing tb_sld
            WHERE tb_sld.account_no = _account_no
            AND tb_sld.process_date = _process_date
            AND upper(tb_sld.custodian)=_custodian
        ) base
        LEFT JOIN clientes.par_fee_segmento fee_seg
            ON fee_seg.monto_min <= base.total_usde_market_value
            AND fee_seg.monto_max >  base.total_usde_market_value
        CROSS JOIN LATERAL public.fn_distribucion_ingresos(base.new_fee, base.process_date) AS fn_dist(fee_perc_proteccion, fee_perc_ria)
        ) calc
    WHERE tb_sld.row_no = calc.row_no
    AND tb_sld.annual_fee IS DISTINCT FROM calc.annual_fee_calc;

    GET DIAGNOSTICS _cant_update_saldos = ROW_COUNT;

    --Estadísticas previas a update
    SELECT
        count(*),
        min(fee),
        max(fee)
    INTO
        _cant_match_cuentas,
        _old_fee_cuentas_min,
        _old_fee_cuentas_max
    FROM public.tbvw_maestro_cuentas_pershing tb_cta
    WHERE tb_cta.account_no = _account_no
      AND tb_cta.process_date = _process_date
      AND upper(tb_cta.custodian) = _custodian;

    --Actualizamos registros de Maestro de Cuentas
    UPDATE public.tbvw_maestro_cuentas_pershing tb_cta
    SET
        fee                = calc.annual_fee_calc
    FROM (
        SELECT
            base.row_no,
            base.process_date,
            base.account_no,
            base.fee   as annual_fee_actual,
            base.new_fee as annual_fee_calc
        FROM (
            SELECT
                tb_cta.row_no,
                tb_cta.process_date,
                tb_cta.account_no,
                tb_cta.fee,
                _new_annual_percent_fee::NUMERIC(45,20) as new_fee
            FROM public.tbvw_maestro_cuentas_pershing tb_cta
            WHERE tb_cta.account_no = _account_no
            AND tb_cta.process_date = _process_date
            AND upper(tb_cta.custodian)=_custodian
            ) base
    ) calc
    WHERE tb_cta.row_no = calc.row_no
    AND tb_cta.fee IS DISTINCT FROM calc.annual_fee_calc;

    GET DIAGNOSTICS _cant_update_cuentas = ROW_COUNT;


    RETURN QUERY
    SELECT
        _custodian,
        _account_no,
        _process_date,
        _new_annual_percent_fee,
        _cant_update_model_cte,
        _cant_match_saldos,
        _cant_update_saldos,
        _old_fee_saldos_min,
        _old_fee_saldos_max,
        (_new_annual_percent_fee / 100)::numeric(45,20),

        _cant_match_cuentas,
        _cant_update_cuentas,
        _old_fee_cuentas_min,
        _old_fee_cuentas_max,
        _new_annual_percent_fee,

        0,
        'OK'::varchar(1000);

END
$$;

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