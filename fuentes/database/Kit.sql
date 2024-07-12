/*
2024-07-11
Actual: 8.1.0-COL
Last:   8.0.1-COL
*/

--========================================================================
--========================================================================
--========================================================================
--Creción de usuarios admin y app
/*
CREATE USER mmii_admindb CREATEDB CREATEROLE PASSWORD 'b55tO<RB4aza';
GRANT azure_pg_admin TO mmii_admindb;
--create database qande_mmii with owner mmii_admindb;
create database qande_mmii;
CREATE USER mmii_appuserdb PASSWORD 'H;859md+5GAf';
GRANT CONNECT ON DATABASE qande_mmii TO mmii_appuserdb;
--ALTER DEFAULT PRIVILEGES FOR ROLE mmii_appuserdb GRANT SELECT, INSERT, DELETE ON TABLES TO mmii_appuserdb;
--ALTER DEFAULT PRIVILEGES FOR ROLE mmii_appuserdb GRANT EXECUTE ON FUNCTIONS TO mmii_appuserdb;
*/

--========================================================================
--========================================================================
--========================================================================
-- Vista de cuentas no mapeadas (para alerta)
create or replace VIEW public.vw_cuentas_no_mapeadas_pershing
AS
    SELECT
        DISTINCT act_no_inf.source, act_no_inf.process_date, act_no_inf.account_no, act_no_inf.client_name
    FROM
    (
        SELECT DISTINCT 'CTA'::VARCHAR(100) as source, vw_cta.process_date::VARCHAR(100), vw_cta.account_no::VARCHAR(100), vw_cta.full_name::VARCHAR(100) as client_name FROM public.vw_maestro_cuentas_pershing vw_cta WHERE vw_cta.client_id is NULL
        UNION
        SELECT DISTINCT 'SLD'::VARCHAR(100) as source, vw_sld.process_date::VARCHAR(100), vw_sld.account_no::VARCHAR(100), vw_sld.name::VARCHAR(100) as client_name FROM public.vw_maestro_saldos_pershing vw_sld WHERE vw_sld.client_id is NULL
        UNION
        SELECT DISTINCT 'MOV'::VARCHAR(100) as source, vw_mov.process_date::VARCHAR(100), vw_mov.account_no::VARCHAR(100), vw_mov.name::VARCHAR(100) as client_name FROM public.vw_maestro_movimientos_pershing vw_mov WHERE vw_mov.client_id is NULL
    ) as act_no_inf
;

SELECT *--DISTINCT account_no, client_name
FROM public.vw_cuentas_no_mapeadas_pershing
where process_date='20240625'
;



--========================================================================
--========================================================================
--========================================================================
-- Actualización segmentos Fee
UPDATE clientes.par_fee_segmento
SET glosa     = '>= 0 y < 250k',
    monto_min = 0.00000000000000000000
WHERE id = 3;

ALTER TABLE clientes.par_fee_segmento
ADD COLUMN modificacion_usuario VARCHAR(100) DEFAULT NULL,
ADD COLUMN modificacion_timestamp TIMESTAMP DEFAULT NULL;




--========================================================================
--========================================================================
--========================================================================
--

UPDATE clientes.cuenta
set id_cliente=11
where id=13
;


--========================================================================
--========================================================================
--========================================================================
--
--USER: usuario
insert into public.authorities (authority, user_id)
SELECT 'ROLE_OP_ARCHIVOS_MAESTROS' as authority, id as user_id FROM public.users WHERE id=1
UNION
SELECT 'ROLE_OP_REP_MAESTRO_CLIENTE' as authority, id as user_id FROM public.users WHERE id=1
UNION
SELECT 'ROLE_OP_REP_MAESTRO_SALDOS' as authority, id as user_id FROM public.users WHERE id=1
UNION
SELECT 'ROLE_OP_REP_MAESTRO_MOVTOS' as authority, id as user_id FROM public.users WHERE id=1
UNION
SELECT 'ROLE_OP_MANT_ENROL_CLIENTE' as authority, id as user_id FROM public.users WHERE id=1
;

insert into public.authorities (authority, user_id)
SELECT 'ROLE_OP_MANT_FEE_SEGMENTO' as authority, id as user_id FROM public.users WHERE id=1
;

--USER: Usuarios Protección
insert into public.authorities (authority, user_id)
SELECT 'ROLE_OP_ARCHIVOS_MAESTROS' as authority, id as user_id FROM public.users WHERE id>=4
UNION
SELECT 'ROLE_OP_REP_MAESTRO_CLIENTE' as authority, id as user_id FROM public.users WHERE id>=4
UNION
SELECT 'ROLE_OP_REP_MAESTRO_SALDOS' as authority, id as user_id FROM public.users WHERE id>=4
UNION
SELECT 'ROLE_OP_REP_MAESTRO_MOVTOS' as authority, id as user_id FROM public.users WHERE id>=4
UNION
SELECT 'ROLE_OP_MANT_ENROL_CLIENTE' as authority, id as user_id FROM public.users WHERE id>=4
;

--USER: Juan Guerra
insert into public.authorities (authority, user_id)
SELECT 'ROLE_OP_MANT_FEE_SEGMENTO' as authority, id as user_id FROM public.users WHERE id=4
;

--USER: user-qye
insert into public.authorities (authority, user_id)
SELECT 'ROLE_OP_ARCHIVOS_MAESTROS' as authority, id as user_id FROM public.users WHERE id=3
UNION
SELECT 'ROLE_OP_REP_MAESTRO_CLIENTE' as authority, id as user_id FROM public.users WHERE id=3
UNION
SELECT 'ROLE_OP_REP_MAESTRO_SALDOS' as authority, id as user_id FROM public.users WHERE id=3
UNION
SELECT 'ROLE_OP_REP_MAESTRO_MOVTOS' as authority, id as user_id FROM public.users WHERE id=3
UNION
SELECT 'ROLE_OP_MANT_ENROL_CLIENTE' as authority, id as user_id FROM public.users WHERE id=3
;

--USER: admin-qye
insert into public.authorities (authority, user_id)
SELECT 'ADMINQANDE_LOGS' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'ADMIN_JOBS' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'LS_FTP_PERSHING' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'PERSHING_CONFIGSFL' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'PERSHING_ETDO_FTP' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'PARAMETROS_GLOBALES' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'PARAMETROS_PERSHING' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'USUARIOS_CUENTAS' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'USUARIOS_ROLES' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'ARCHIVOS_MAESTROS' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'REP_MAESTRO_CLIENTE' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'REP_MAESTRO_SALDOS' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'REP_MAESTRO_MOVTOS' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'MANT_SRC_COD_PER' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'CTRL_OPER_DIARIO' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'CONT_SFL_ACCT' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'CONT_SFL_GACT' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'CONT_SFL_GCUS' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'CONT_SFL_GMON' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'CONT_SFL_ISRC' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'CONT_SFL_ISCA' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'MANT_ENROL_CLIENTE' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'RECT_NO_INF' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'RECT_NO_INF_APR' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'RECT_NO_INF_REVER' as authority, id as user_id FROM public.users WHERE id=2
UNION
SELECT 'MANT_FEE_SEGMENTO' as authority, id as user_id FROM public.users WHERE id=2
;



--========================================================================
--========================================================================
--========================================================================
--



