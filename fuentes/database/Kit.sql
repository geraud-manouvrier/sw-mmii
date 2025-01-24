/*
2025-01-24
Actual: 9.0.0-COL
*/

INSERT INTO public.users (enabled, password, username) VALUES (true, '', 'santiago.isaza');

SELECT * FROM public.users where username in ('juan.guerra', 'santiago.isaza');

INSERT INTO public.authorities(user_id, authority)
SELECT 11 as user_id, authority FROM public.authorities where user_id=4;

-- Maestros consolidados

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_MAESTRO_CONSOLIDADO' FROM public.users where username in ('admin-qye')
;

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_MAESTRO_CONSOLIDADO' FROM public.users where username in ('daniel.gomez1', 'brayan.giraldom', 'santiago.isaza')
;

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_NOTIF' FROM public.users where username in ('admin-qye')
;

--========================================================================
--========================================================================
--========================================================================
-- Control Diario
INSERT INTO public.jobs_maestro(id, nombre) VALUES (1, 'Control Diario');

create table public.jobs_estado
(
    id              bigint generated always as identity
        constraint jobs_estado_pk
            primary key,
    id_job          integer                     not null references public.jobs_maestro(id),
    id_proceso      varchar(100)                not null,
    sub_id_proceso  varchar(100)  default NULL::character varying,
    start_timestamp timestamp     default now() not null,
    end_timestamp   timestamp,
    estado          integer       default NULL    null
);

create unique index jobs_estado_ui
    on jobs_estado (id_job, id_proceso, sub_id_proceso);

alter table public.jobs_estado
    alter column sub_id_proceso set default '';
UPDATE public.jobs_estado SET sub_id_proceso='' WHERE sub_id_proceso IS NULL;

alter table public.jobs_estado
    alter column sub_id_proceso set not null;

alter table public.jobs_estado
    alter column sub_id_proceso DROP DEFAULT ;


create or replace function public.fn_control_diario_cuentas_no_mapeadas(_process_date character varying)
    returns TABLE(id_control integer, glosa_control character varying, descripcion_control character varying, process_date character varying, identificador character varying, cant_reg integer)
    language plpgsql
as
$$

--Alerta de movimiento nuevo (nunca en la historia)
    BEGIN

    RETURN QUERY
        SELECT DISTINCT
            1 as id_control,
            'Cuentas no mapeadas'::VARCHAR(1000) as glosa_control,
            'Cuentas informadas por custodio, no agregadas en mantenedor enrolamiento'::VARCHAR(1000) as descripcion_control,
            CTA_NO_INF.process_date::VARCHAR(100),
            CTA_NO_INF.account_no::VARCHAR(100) as identificador,
            count(*)::int as cant_reg
            FROM
            (
                SELECT DISTINCT
                    ctas_no_map.process_date,
                    ctas_no_map.account_no
                FROM public.vw_cuentas_no_mapeadas_pershing ctas_no_map
                WHERE ctas_no_map.process_date=_process_date
            ) CTA_NO_INF
            GROUP BY CTA_NO_INF.process_date::VARCHAR(100), CTA_NO_INF.account_no::VARCHAR(100)
            ORDER BY CTA_NO_INF.process_date::VARCHAR(100), CTA_NO_INF.account_no::VARCHAR(100);
    RETURN;
    END;
$$;





create or replace function public.fn_control_diario(_process_date character varying, _username character varying) returns SETOF control_diario
    language plpgsql
as
$$
DECLARE _timestamp_reg timestamp;
DECLARE _timestamp_proceso timestamp;
DECLARE _menor_correlativo int;
DECLARE _correlativo int;
DECLARE _id_jobs_log bigint;
DECLARE _id_jobs_etdo int;
DECLARE _count_errors int;
    BEGIN
        _timestamp_proceso  := clock_timestamp();
        _timestamp_reg      := _timestamp_proceso;
        _correlativo        := -1;

        RAISE NOTICE 'Iniciando ejecución job Control Diario para fecha [%]', _process_date;

        INSERT INTO public.jobs_log (id_job, start_timestamp, end_timestamp, id_proceso, sub_id_proceso, info)
        VALUES (1, _timestamp_proceso, NULL, _process_date, NULL, NULL);
        _id_jobs_log  := LASTVAL();

        SELECT id INTO _id_jobs_etdo from public.jobs_estado WHERE id_job=1 AND id_proceso=_process_date AND sub_id_proceso='';
        IF (_id_jobs_etdo IS NOT NULL) THEN
            DELETE FROM public.jobs_estado WHERE id_job=1 AND id_proceso=_process_date AND sub_id_proceso='';
        end if;

        INSERT INTO public.jobs_estado (id_job, id_proceso, sub_id_proceso, start_timestamp, end_timestamp, estado)
        VALUES (1, _process_date, '', _timestamp_proceso, NULL, NULL);
        _id_jobs_etdo  := LASTVAL();

        SELECT min(correlativo_diario) INTO _menor_correlativo
        FROM public.control_diario TB_CD WHERE TB_CD.process_date=_process_date;

        IF ( COALESCE(_menor_correlativo,0)<0 ) THEN
            RAISE NOTICE 'Actualizando correlativos para fecha proceso [%], usuario [%]', _process_date, _username;
            UPDATE public.control_diario  SET correlativo_diario=correlativo_diario+ABS(_menor_correlativo)
            WHERE process_date=_process_date;
        END IF;

        --Control 01
        _timestamp_reg  :=  clock_timestamp();
        RAISE NOTICE 'Ejecutando control 01...';
        INSERT INTO public.control_diario (correlativo_diario, process_date, timestamp_control, timestamp_registro, id_control, glosa_control, descripcion_control, identificador, cant_reg, username)
        SELECT _correlativo as correlativo_diario,_process_date as process_date,_timestamp_proceso as timestamp_control,_timestamp_reg as timestamp_registro,
               FN_CTRL_01.id_control,FN_CTRL_01.glosa_control,FN_CTRL_01.descripcion_control,FN_CTRL_01.identificador,FN_CTRL_01.cant_reg,
               _username as username
        FROM public.fn_control_diario_cuentas_no_mapeadas(_process_date) as FN_CTRL_01;
        RAISE NOTICE 'Control 01 ejecutado [%]', clock_timestamp()-_timestamp_reg;

        RAISE NOTICE 'Desplazando correlativos';
        UPDATE public.control_diario SET correlativo_diario=correlativo_diario+ 1
        WHERE process_date=_process_date;

        SELECT count(*) INTO _count_errors FROM public.control_diario WHERE process_date=_process_date AND correlativo_diario=0;
        RAISE NOTICE 'Se encontraron [%] registros con errores', _count_errors;


        RETURN QUERY
            SELECT *
            FROM public.control_diario TB_CD
            WHERE TB_CD.process_date=_process_date AND TB_CD.correlativo_diario=0
            ORDER BY TB_CD.process_date DESC, TB_CD.correlativo_diario ASC,
                TB_CD.id_control ASC, TB_CD.identificador ASC, TB_CD.cant_reg ASC
            ;

        UPDATE public.jobs_log tb_log SET end_timestamp = clock_timestamp() WHERE tb_log.id=_id_jobs_log;
        UPDATE public.jobs_estado SET estado=_count_errors, end_timestamp=clock_timestamp() WHERE id=_id_jobs_etdo;

        RETURN;



    EXCEPTION
        WHEN OTHERS THEN
            -- Revertir cambios de la lógica principal
            RAISE EXCEPTION 'Error en fn_control_diario para process date [%]: %', _process_date, SQLERRM;

    END;
$$;





DROP FUNCTION public.fn_control_diario_reporte_listado(_process_date_from varchar, _process_date_to varchar, _correlativo integer);

create or replace function public.fn_control_diario_reporte_listado(_process_date_from character varying, _process_date_to character varying, _correlativo integer) returns SETOF control_diario
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
        SELECT *
        FROM public.control_diario REP_CD
        WHERE REP_CD.process_date       >= _process_date_from
        AND REP_CD.process_date         <= _process_date_to
        AND REP_CD.correlativo_diario   = COALESCE(_correlativo, REP_CD.correlativo_diario)
        ORDER BY REP_CD.process_date ASC, REP_CD.correlativo_diario ASC, REP_CD.id_control, REP_CD.identificador ASC, REP_CD.cant_reg ASC
        ;

    RETURN;
    END;
$$;

drop view public.control_diario_reporte;
alter table control_diario
    drop column id_segmentacion;

TRUNCATE TABLE public.jobs_estado;
INSERT INTO public.jobs_estado (id_job, id_proceso, sub_id_proceso, start_timestamp, end_timestamp, estado)
select distinct 1, process_date, '', now(), now(), 0 from public.vw_reporte_maestro_datos_saldos ORDER BY process_date;

TRUNCATE TABLE public.jobs_log;
TRUNCATE TABLE public.control_diario;

--========================================================================
--========================================================================
--========================================================================
--Reporte mes

--# Cuentas # Clientes Suma Saldo $Suma Ingreso $Suma Retiro $Suma Recaudo $Clientes Null
CREATE VIEW public.vw_reporte_consolidado_movimientos AS
    SELECT
        left(process_date,4)::VARCHAR(100) as agnio,
        left(process_date,6)::VARCHAR(100) as periodo,
        count(distinct client_id)::INT as clients,
        count(distinct account_no)::INT as accounts,
        count(distinct account_no) filter (where client_id is null)::INT as accounts_without_client,
        sum(usde_net_amount)::NUMERIC(45,20) as usde_net_amount,
        sum(retiro)::NUMERIC(45,20) as retiro,
        sum(recaudo)::NUMERIC(45,20) as recaudo
    FROM public.vw_reporte_maestro_datos_movimientos
    GROUP BY left(process_date,4), left(process_date,6)
    ORDER BY left(process_date,4), left(process_date,6)
;

CREATE VIEW public.vw_reporte_consolidado_saldos AS
    SELECT
        left(process_date,4)::VARCHAR(100) as agnio,
        left(process_date,6)::VARCHAR(100) as periodo,
        count(distinct client_id)::INT as clients,
        count(distinct account_no)::INT as accounts,
        count(distinct account_no) filter (where client_id is null)::INT as accounts_without_client,
        sum(usde_market_value)::NUMERIC(45,20) as usde_market_value,
        sum(ingreso_proteccion)::NUMERIC(45,20) as ingreso_proteccion
    FROM public.vw_reporte_maestro_datos_saldos
    GROUP BY left(process_date,4), left(process_date,6)
    ORDER BY left(process_date,4), left(process_date,6)
;

SELECT * FROM public.vw_reporte_consolidado_movimientos;
SELECT * FROM public.vw_reporte_consolidado_saldos;

--========================================================================
--========================================================================
--========================================================================
--Segmento para registros saldos totales
INSERT INTO clientes.par_fee_segmento (glosa, monto_min, monto_max, annual_fee, tasa_proteccion, tasa_suracorp,
                                       modificacion_usuario, modificacion_timestamp)
VALUES ('< 0', -999999999.00000000000000000000, 0.00000000000000000000, 0.00000000000000000000, 0.00000000000000000000,
        0.00000000000000000000, DEFAULT, null);




--========================================================================
--========================================================================
--========================================================================
--Regularización registros nulos Cuentas

SELECT *
FROM tbvw_maestro_cuentas_pershing
WHERE client_id IS NULL;


SELECT *
FROM tbvw_maestro_cuentas_pershing;

SELECT * into zz_backup.tbvw_maestro_cuentas_pershing_20250114
FROM public.tbvw_maestro_cuentas_pershing;

WITH valores_actualizados AS (
    SELECT DISTINCT
        account_no,
        id_interno_cliente,
        client_id,
        name,
        id_tipo_identificador_cliente,
        tipo_identificador_cliente,
        glosa_identificador_cliente,
        id_interno_cuenta,
        id_custodio,
        id_cuenta_custodio,
        habilitado
    FROM tbvw_maestro_cuentas_pershing
    WHERE client_id IS NOT NULL
)
UPDATE tbvw_maestro_cuentas_pershing tb_null
SET
    id_interno_cliente = valores_actualizados.id_interno_cliente,
    client_id = valores_actualizados.client_id,
    name = valores_actualizados.name,
    id_tipo_identificador_cliente = valores_actualizados.id_tipo_identificador_cliente,
    tipo_identificador_cliente = valores_actualizados.tipo_identificador_cliente,
    glosa_identificador_cliente = valores_actualizados.glosa_identificador_cliente,
    id_interno_cuenta = valores_actualizados.id_interno_cuenta,
    id_custodio = valores_actualizados.id_custodio,
    id_cuenta_custodio = valores_actualizados.id_cuenta_custodio,
    habilitado = valores_actualizados.habilitado
FROM valores_actualizados
WHERE tb_null.client_id IS NULL
  AND tb_null.account_no = valores_actualizados.account_no;


SELECT *
FROM tbvw_maestro_cuentas_pershing
WHERE client_id IS NULL;


SELECT *
FROM tbvw_maestro_cuentas_pershing;


--========================================================================
--========================================================================
--========================================================================
--Regularización registros nulos Movimientos

SELECT *
FROM tbvw_maestro_movimientos_pershing
;

SELECT *
FROM tbvw_maestro_movimientos_pershing
WHERE client_id IS NULL;




SELECT * into zz_backup.tbvw_maestro_movimientos_pershing_20250114
FROM public.tbvw_maestro_movimientos_pershing;

WITH valores_actualizados AS (
    SELECT DISTINCT
        account_no,
        client_id,
        id_cuenta_custodio,
        tipo_identificador_cliente
    FROM tbvw_maestro_movimientos_pershing
    WHERE client_id IS NOT NULL
)
UPDATE tbvw_maestro_movimientos_pershing tb_null
SET
    client_id = valores_actualizados.client_id,
    id_cuenta_custodio = valores_actualizados.id_cuenta_custodio,
    tipo_identificador_cliente = valores_actualizados.tipo_identificador_cliente
FROM valores_actualizados
WHERE tb_null.client_id IS NULL
  AND tb_null.account_no = valores_actualizados.account_no;


SELECT *
FROM tbvw_maestro_movimientos_pershing
WHERE client_id IS NULL;


SELECT *
FROM tbvw_maestro_movimientos_pershing;



--========================================================================
--========================================================================
--========================================================================
--Regularización registros nulos Saldos

SELECT *
FROM tbvw_maestro_saldos_pershing
;

SELECT *
FROM tbvw_maestro_saldos_pershing
WHERE client_id IS NULL
;


SELECT *
FROM tbvw_maestro_saldos_pershing
WHERE id_fee_aplicado IS NULL
;




SELECT * into zz_backup.tbvw_maestro_saldos_pershing_20250114
FROM public.tbvw_maestro_saldos_pershing;

WITH valores_actualizados AS (
    SELECT DISTINCT
        account_no,
        client_id,
        tipo_identificador_cliente
    FROM tbvw_maestro_saldos_pershing
    WHERE client_id IS NOT NULL
)
UPDATE tbvw_maestro_saldos_pershing tb_null
SET
    client_id = valores_actualizados.client_id,
    tipo_identificador_cliente = valores_actualizados.tipo_identificador_cliente
FROM valores_actualizados
WHERE tb_null.client_id IS NULL
  AND tb_null.account_no = valores_actualizados.account_no;

UPDATE tbvw_maestro_saldos_pershing tb_null
SET
    id_fee_aplicado=8,
    annual_fee=0.00,
    tasa_proteccion=0.00,
    tasa_suracorp=0.00,
    fee_diario=0.00,
    fee_diario_proteccion=0.00,
    fee_diario_sura_corp=0.00,
    comision_devengada_diaria=0.00,
    ingreso_proteccion=0.00
WHERE tb_null.id_fee_aplicado IS NULL
;


SELECT *
FROM tbvw_maestro_saldos_pershing
;

SELECT *
FROM tbvw_maestro_saldos_pershing
WHERE client_id IS NULL
;


SELECT *
FROM tbvw_maestro_saldos_pershing
WHERE id_fee_aplicado IS NULL
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



