/*
2025-02-25
Actual: 10.0.0-COL
*/

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_INV_BASE' FROM public.users where username in ('admin-qye')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_INV_PRECALC' FROM public.users where username in ('admin-qye')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_INV_RENT' FROM public.users where username in ('admin-qye')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_INV_CONTRL' FROM public.users where username in ('admin-qye')
;

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTRL_OPER_DIARIO' FROM public.users where username in ('daniel.gomez1', 'brayan.giraldom')
;


--========================================================================
--========================================================================
--========================================================================
--
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
            CTA_NO_INF.account_id::VARCHAR(100) as identificador,
            count(*)::int as cant_reg
            FROM
            (
                SELECT DISTINCT
                    ctas_no_map.process_date,
                    ctas_no_map.account_no||' - '||ctas_no_map.client_name as account_id
                FROM public.vw_cuentas_no_mapeadas_pershing ctas_no_map
                WHERE ctas_no_map.process_date=_process_date
            ) CTA_NO_INF
            GROUP BY CTA_NO_INF.process_date::VARCHAR(100), CTA_NO_INF.account_id::VARCHAR(100)
            ORDER BY CTA_NO_INF.process_date::VARCHAR(100), CTA_NO_INF.account_id::VARCHAR(100);
    RETURN;
    END;
$$;




--========================================================================
--========================================================================
--========================================================================
-- Calendario

create function public.fn_calendario_genera_fechas()
    returns TABLE(fecha_as_date date)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
        SELECT fn_cal.fecha_as_date as fecha_as_date
        FROM public.fn_calendario_genera_fechas(NULL, NULL) fn_cal;
    RETURN;
    END;
$$;



create or replace view public.vw_calendario
as
SELECT cal.fecha_as_date,
       fn_fecha_date_to_string(cal.fecha_as_date, 'YYYYMMDD'::character varying, ''::character varying)   AS fecha_as_str,
       fn_fecha_date_to_string(cal.fecha_as_date, 'DDMMYYYY'::character varying, '-'::character varying)  AS fecha_cl,
       fn_fecha_date_to_string(cal.fecha_as_date, 'YYYYMMDD'::character varying,
                               '-'::character varying)                                                    AS fecha_cl_inv,
       fn_fecha_date_to_string(cal.fecha_as_date, 'MMDDYYYY'::character varying, '/'::character varying)  AS fecha_usa,
       fn_fecha_date_to_string(cal.fecha_as_date, 'YYYYDDMM'::character varying,
                               '/'::character varying)                                                    AS fecha_usa_inv,
       EXTRACT(day FROM cal.fecha_as_date)::integer                                                       AS dia_del_mes,
       EXTRACT(month FROM cal.fecha_as_date)::integer                                                     AS mes_del_agnio,
       NULL::character varying(100)                                                                       AS mes_del_agnio_str,
       NULL::character varying(100)                                                                       AS mes_del_agnio_str_corto,
       EXTRACT(year FROM cal.fecha_as_date)::integer                                                      AS agnio,
       NULL::integer                                                                                      AS dia_de_semana_base0,
       NULL::integer                                                                                      AS dia_de_semana_base1,
       NULL::integer                                                                                      AS dia_del_agnio,
       NULL::integer                                                                                      AS semana_del_mes_base_dia1,
       NULL::integer                                                                                      AS semana_del_mes_base_entera,
       NULL::integer                                                                                      AS semana_del_agnio_base_dia1,
       NULL::integer                                                                                      AS semana_del_agnio_base_entera,
       NULL::boolean                                                                                      AS habil_chile,
       NULL::boolean                                                                                      AS habil_usa,
       NULL::boolean                                                                                      AS habil_pershing,
       NULL::boolean                                                                                      AS habil_stonex,
       EXTRACT(month FROM cal.fecha_as_date + '1 day'::interval) <>
       EXTRACT(month FROM cal.fecha_as_date)                                                              AS last_day_of_month,
       EXTRACT(year FROM cal.fecha_as_date + '1 day'::interval) <>
       EXTRACT(year FROM cal.fecha_as_date)                                                               AS last_day_of_year
FROM fn_calendario_genera_fechas() cal(fecha_as_date)
ORDER BY cal.fecha_as_date;


--========================================================================
--========================================================================
--========================================================================
-- Rentabilidades y retornos

create schema rep_inv;

create type rep_inv.reg_rent as
(
    fecha_desde               date,
    fecha_hasta               date,
    agregador_n1              varchar(100),
    agregador_n2              varchar(100),
    agregador_n3              varchar(100),
    agregador_n4              varchar(100),
    cant_reg                  integer,
    dias_con_saldo            integer,
    rentabilidad_periodo      numeric(45, 20),
    suma_saldos_iniciales     numeric(45, 20),
    suma_saldo_rentabilidad   numeric(45, 20),
    rentabilidad_ponderada_cl numeric(45, 20),
    rentabilidad_periodo_cl   numeric(45, 20)
);


create table if not exists rep_inv.base_saldos_diarios
(
    id_reg                        bigint generated by default as identity
        constraint base_saldos_diarios_pk
            primary key,
    cant_reg                      bigint,
    process_date                  varchar(100),
    client_id                     varchar(100),
    custodian                     varchar(100),
    account_no                    varchar(100),
    cusip                         varchar(100),
    isin                          varchar(100),
    symbol                        varchar(100),
    security_description          varchar(100),
    id_tipo_activo                varchar(100),
    id_sub_tipo_activo            varchar(100),
    id_sub_sub_tipo_activo        varchar(100),
    currency                      varchar(100),
    sum_quantity                  numeric(45, 20),
    sum_market_value              numeric(45, 20),
    sum_usde_market_value         numeric(45, 20),
    sum_comision_devengada_diaria numeric(45, 20)
);


create unique index if not exists base_saldos_diarios_ui
    on rep_inv.base_saldos_diarios (process_date, client_id, custodian, account_no, cusip, isin, symbol, security_description,
                            id_tipo_activo, id_sub_tipo_activo, id_sub_sub_tipo_activo, currency);

create index if not exists base_saldos_diarios_client_id_index
    on rep_inv.base_saldos_diarios (client_id);

create table if not exists rep_inv.base_movimientos_diarios
(
    id_reg                 bigint generated by default as identity
        constraint base_movimientos_diarios_pk
            primary key,
    cant_reg               bigint,
    process_date           varchar(100),
    client_id              varchar(100),
    custodian              varchar(100),
    account_no             varchar(100),
    cusip                  varchar(100),
    isin                   varchar(100),
    symbol                 varchar(100),
    source_code            varchar(100),
    activity_description   varchar(100),
    id_tipo_activo         varchar(100),
    id_sub_tipo_activo     varchar(100),
    id_sub_sub_tipo_activo varchar(100),
    currency               varchar(100),
    sum_quantity           numeric(45, 20),
    sum_net_amount         numeric(45, 20),
    sum_principal          numeric(45, 20),
    sum_usde_net_amount    numeric(45, 20),
    tipo_reg               varchar(100)
);


create unique index if not exists base_movimientos_diarios_ui
    on rep_inv.base_movimientos_diarios (process_date, client_id, custodian, account_no, cusip, isin, symbol, source_code,
                                 activity_description, id_tipo_activo, id_sub_tipo_activo, id_sub_sub_tipo_activo,
                                 currency, tipo_reg);

create index if not exists base_movimientos_diarios_client_id_index
    on rep_inv.base_movimientos_diarios (client_id);

create table if not exists rep_inv.consolidado_agregado_n1
(
    process_date                varchar(100) not null,
    process_date_as_date        date,
    agregador_n1                varchar(100) not null,
    saldo_dia                   numeric(45, 20),
    abonos_dia                  numeric(45, 20),
    retiros_dia                 numeric(45, 20),
    dividendos_dia              numeric(45, 20),
    comision_devengada_dia      numeric(45, 20),
    saldo_dia_anterior          numeric(45, 20) default (0)::numeric(45, 20),
    utilidad                    numeric(45, 20) default (0)::numeric(45, 20),
    rentabilidad                numeric(45, 20) default (0)::numeric(45, 20),
    saldo_rentabilidad          numeric(45, 20) default (0)::numeric(45, 20),
    rentabilidad_base_pitatoria numeric(45, 20) default 0,
    constraint consolidado_agregado_n1_pk
        primary key (process_date, agregador_n1)
);


create index if not exists consolidado_agregado_n1_ui
    on rep_inv.consolidado_agregado_n1 (process_date_as_date, agregador_n1);

create index if not exists consolidado_agregado_n1_agregadores_index
    on rep_inv.consolidado_agregado_n1 (agregador_n1);

create table if not exists rep_inv.consolidado_agregado_n2
(
    process_date                varchar(100) not null,
    process_date_as_date        date,
    agregador_n1                varchar(100) not null,
    agregador_n2                varchar(100) not null,
    saldo_dia                   numeric(45, 20),
    abonos_dia                  numeric(45, 20),
    retiros_dia                 numeric(45, 20),
    dividendos_dia              numeric(45, 20),
    comision_devengada_dia      numeric(45, 20),
    saldo_dia_anterior          numeric(45, 20) default (0)::numeric(45, 20),
    utilidad                    numeric(45, 20) default (0)::numeric(45, 20),
    rentabilidad                numeric(45, 20) default (0)::numeric(45, 20),
    saldo_rentabilidad          numeric(45, 20) default (0)::numeric(45, 20),
    rentabilidad_base_pitatoria numeric(45, 20) default 0,
    constraint consolidado_agregado_n2_pk
        primary key (process_date, agregador_n1, agregador_n2)
);


create index if not exists consolidado_agregado_n2_ui
    on rep_inv.consolidado_agregado_n2 (process_date_as_date, agregador_n1, agregador_n2);

create index if not exists consolidado_agregado_n2_agregadores_index
    on rep_inv.consolidado_agregado_n2 (agregador_n1, agregador_n2);

create table if not exists rep_inv.consolidado_agregado_n3
(
    process_date                varchar(100) not null,
    process_date_as_date        date,
    agregador_n1                varchar(100) not null,
    agregador_n2                varchar(100) not null,
    agregador_n3                varchar(100) not null,
    saldo_dia                   numeric(45, 20),
    abonos_dia                  numeric(45, 20),
    retiros_dia                 numeric(45, 20),
    dividendos_dia              numeric(45, 20),
    comision_devengada_dia      numeric(45, 20),
    saldo_dia_anterior          numeric(45, 20) default (0)::numeric(45, 20),
    utilidad                    numeric(45, 20) default (0)::numeric(45, 20),
    rentabilidad                numeric(45, 20) default (0)::numeric(45, 20),
    saldo_rentabilidad          numeric(45, 20) default (0)::numeric(45, 20),
    rentabilidad_base_pitatoria numeric(45, 20) default 0,
    constraint consolidado_agregado_n3_pk
        primary key (process_date, agregador_n1, agregador_n2, agregador_n3)
);


create index if not exists consolidado_agregado_n3_ui
    on rep_inv.consolidado_agregado_n3 (process_date_as_date, agregador_n1, agregador_n2, agregador_n3);

create index if not exists consolidado_agregado_n3_agregadores_index
    on rep_inv.consolidado_agregado_n3 (agregador_n1, agregador_n2, agregador_n3);

create table if not exists rep_inv.consolidado_agregado_n4
(
    process_date                varchar(100) not null,
    process_date_as_date        date,
    agregador_n1                varchar(100) not null,
    agregador_n2                varchar(100) not null,
    agregador_n3                varchar(100) not null,
    agregador_n4                varchar(100) not null,
    saldo_dia                   numeric(45, 20),
    abonos_dia                  numeric(45, 20),
    retiros_dia                 numeric(45, 20),
    dividendos_dia              numeric(45, 20),
    comision_devengada_dia      numeric(45, 20),
    saldo_dia_anterior          numeric(45, 20) default (0)::numeric(45, 20),
    utilidad                    numeric(45, 20) default (0)::numeric(45, 20),
    rentabilidad                numeric(45, 20) default (0)::numeric(45, 20),
    saldo_rentabilidad          numeric(45, 20) default (0)::numeric(45, 20),
    rentabilidad_base_pitatoria numeric(45, 20) default 0,
    constraint consolidado_agregado_n4_pk
        primary key (process_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4)
);


create index if not exists consolidado_agregado_n4_ui
    on rep_inv.consolidado_agregado_n4 (process_date_as_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4);

create index if not exists consolidado_agregado_n4_agregadores_index
    on rep_inv.consolidado_agregado_n4 (agregador_n1, agregador_n2, agregador_n3, agregador_n4);

create table if not exists rep_inv.rentabilidad_calculada_detallada
(
    nivel                   varchar(100) not null,
    process_date_desde      varchar(100) not null,
    process_date_hasta      varchar(100) not null,
    agregador_n1            varchar(100) not null,
    agregador_n2            varchar(100) not null,
    agregador_n3            varchar(100) not null,
    agregador_n4            varchar(100) not null,
    saldo_dia               numeric(45, 20),
    abonos_dia              numeric(45, 20),
    retiros_dia             numeric(45, 20),
    dividendos_dia          numeric(45, 20),
    saldo_dia_anterior      numeric(45, 20),
    comision_devengada_dia  numeric(45, 20),
    utilidad                numeric(45, 20),
    rentabilidad            numeric(45, 20),
    saldo_rentabilidad      numeric(45, 20),
    suma_saldo_rentabilidad numeric(45, 20),
    suma_saldos_iniciales   numeric(45, 20),
    primer_dia_con_saldo    date,
    ultimo_dia_con_saldo    date,
    dias_con_saldo          integer,
    rentabilidad_ponderada  numeric(45, 20),
    rentabilidad_periodo_cl numeric(45, 20),
    base1_fecha_desde       date,
    base1_fecha_hasta       date,
    base1_rentabilidad      numeric(45, 20),
    base2_fecha_desde       date,
    base2_fecha_hasta       date,
    base2_rentabilidad      numeric(45, 20),
    base3_fecha_desde       date,
    base3_fecha_hasta       date,
    base3_rentabilidad      numeric(45, 20),
    base4_fecha_desde       date,
    base4_fecha_hasta       date,
    base4_rentabilidad      numeric(45, 20),
    base5_fecha_desde       date,
    base5_fecha_hasta       date,
    base5_rentabilidad      numeric(45, 20),
    base6_fecha_desde       date,
    base6_fecha_hasta       date,
    base6_rentabilidad      numeric(45, 20),
    base7_fecha_desde       date,
    base7_fecha_hasta       date,
    base7_rentabilidad      numeric(45, 20),
    base8_fecha_desde       date,
    base8_fecha_hasta       date,
    base8_rentabilidad      numeric(45, 20),
    constraint rentabilidad_calculada_detallada_pk
        primary key (nivel, process_date_desde, process_date_hasta, agregador_n1, agregador_n2, agregador_n3,
                     agregador_n4)
);


create table if not exists rep_inv.rentabilidad_calculada
(
    id                              bigint generated always as identity
        constraint rentabilidad_calculada_pk
            primary key,
    row_id                          varchar(100) not null,
    nivel                           varchar(100),
    sub_nivel                       bigint,
    process_date                    varchar(100) not null,
    process_date_as_date            date,
    agregador_n1                    varchar(100) not null,
    agregador_n2                    varchar(100) not null,
    agregador_n3                    varchar(100) not null,
    agregador_n4                    varchar(100) not null,
    saldo_dia_anterior              numeric(45, 20),
    abonos_dia                      numeric(45, 20),
    retiros_dia                     numeric(45, 20),
    dividendos_dia                  numeric(45, 20),
    saldo_dia                       numeric(45, 20),
    comision_devengada_dia          numeric(45, 20),
    utilidad                        numeric(45, 20),
    rentabilidad                    numeric(45, 20),
    rentabilidad_base_pitatoria     numeric(45, 20),
    saldo_rentabilidad              numeric(45, 20),
    base1_start_date                date,
    base1_fecha_desde               date,
    base1_fecha_hasta               date,
    base1_rentabilidad              numeric(45, 20),
    base1_dias_con_saldo            integer,
    base1_suma_saldos_iniciales     numeric(45, 20),
    base1_suma_saldo_rentabilidad   numeric(45, 20),
    base1_rentabilidad_ponderada_cl numeric(45, 20),
    base1_rentabilidad_periodo_cl   numeric(45, 20),
    base1_cant_reg                  integer,
    base2_start_date                date,
    base2_fecha_desde               date,
    base2_fecha_hasta               date,
    base2_rentabilidad              numeric(45, 20),
    base2_dias_con_saldo            integer,
    base2_suma_saldos_iniciales     numeric(45, 20),
    base2_suma_saldo_rentabilidad   numeric(45, 20),
    base2_rentabilidad_ponderada_cl numeric(45, 20),
    base2_rentabilidad_periodo_cl   numeric(45, 20),
    base2_cant_reg                  integer,
    base3_start_date                date,
    base3_fecha_desde               date,
    base3_fecha_hasta               date,
    base3_rentabilidad              numeric(45, 20),
    base3_dias_con_saldo            integer,
    base3_suma_saldos_iniciales     numeric(45, 20),
    base3_suma_saldo_rentabilidad   numeric(45, 20),
    base3_rentabilidad_ponderada_cl numeric(45, 20),
    base3_rentabilidad_periodo_cl   numeric(45, 20),
    base3_cant_reg                  integer,
    base4_start_date                date,
    base4_fecha_desde               date,
    base4_fecha_hasta               date,
    base4_rentabilidad              numeric(45, 20),
    base4_dias_con_saldo            integer,
    base4_suma_saldos_iniciales     numeric(45, 20),
    base4_suma_saldo_rentabilidad   numeric(45, 20),
    base4_rentabilidad_ponderada_cl numeric(45, 20),
    base4_rentabilidad_periodo_cl   numeric(45, 20),
    base4_cant_reg                  integer,
    base5_start_date                date,
    base5_fecha_desde               date,
    base5_fecha_hasta               date,
    base5_rentabilidad              numeric(45, 20),
    base5_dias_con_saldo            integer,
    base5_suma_saldos_iniciales     numeric(45, 20),
    base5_suma_saldo_rentabilidad   numeric(45, 20),
    base5_rentabilidad_ponderada_cl numeric(45, 20),
    base5_rentabilidad_periodo_cl   numeric(45, 20),
    base5_cant_reg                  integer,
    base6_start_date                date,
    base6_fecha_desde               date,
    base6_fecha_hasta               date,
    base6_rentabilidad              numeric(45, 20),
    base6_dias_con_saldo            integer,
    base6_suma_saldos_iniciales     numeric(45, 20),
    base6_suma_saldo_rentabilidad   numeric(45, 20),
    base6_rentabilidad_ponderada_cl numeric(45, 20),
    base6_rentabilidad_periodo_cl   numeric(45, 20),
    base6_cant_reg                  integer,
    base7_start_date                date,
    base7_fecha_desde               date,
    base7_fecha_hasta               date,
    base7_rentabilidad              numeric(45, 20),
    base7_dias_con_saldo            integer,
    base7_suma_saldos_iniciales     numeric(45, 20),
    base7_suma_saldo_rentabilidad   numeric(45, 20),
    base7_rentabilidad_ponderada_cl numeric(45, 20),
    base7_rentabilidad_periodo_cl   numeric(45, 20),
    base7_cant_reg                  integer,
    base8_start_date                date,
    base8_fecha_desde               date,
    base8_fecha_hasta               date,
    base8_rentabilidad              numeric(45, 20),
    base8_dias_con_saldo            integer,
    base8_suma_saldos_iniciales     numeric(45, 20),
    base8_suma_saldo_rentabilidad   numeric(45, 20),
    base8_rentabilidad_ponderada_cl numeric(45, 20),
    base8_rentabilidad_periodo_cl   numeric(45, 20),
    base8_cant_reg                  integer
);

create index if not exists rentabildiad_calculada_main_index
    on rep_inv.rentabilidad_calculada (process_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4);

create or replace view rep_inv.vw_base_consolidado
as
SELECT COALESCE(sld.process_date, mov.process_date)                                      AS process_date,
       COALESCE(sld.client_id, mov.client_id)                                            AS client_id,
       COALESCE(sld.custodian, mov.custodian)                                            AS custodian,
       COALESCE(sld.account_no, mov.account_no)                                          AS account_no,
       COALESCE(sld.cusip, mov.cusip)                                                    AS cusip,
       COALESCE(sld.isin, mov.isin)                                                      AS isin,
       COALESCE(sld.symbol, mov.symbol)                                                  AS symbol,
       COALESCE(sld.security_description, ''::character varying)::character varying(100) AS security_description,
       COALESCE(sld.id_tipo_activo, mov.id_tipo_activo)                                  AS id_tipo_activo,
       COALESCE(sld.id_sub_tipo_activo, mov.id_sub_tipo_activo)                          AS id_sub_tipo_activo,
       COALESCE(sld.id_sub_sub_tipo_activo, mov.id_sub_sub_tipo_activo)                  AS id_sub_sub_tipo_activo,
       COALESCE(sld.currency, mov.currency)                                              AS currency,
       COALESCE(sld.sum_usde_market_value, 0::numeric)::numeric(45, 20)                  AS saldo_dia,
       COALESCE(mov.dividendos, 0::numeric)::numeric(45, 20)                             AS dividendos_dia,
       COALESCE(mov.abonos, 0::numeric)::numeric(45, 20)                                 AS abonos_dia,
       COALESCE(mov.retiros, 0::numeric)::numeric(45, 20)                                AS retiros_dia,
       COALESCE(sld.sum_comision_devengada_diaria, 0::numeric)::numeric(45, 20)          AS comision_devengada,
       COALESCE(mov.activity_description, ''::text)::character varying(100)              AS activity_description
FROM rep_inv.base_saldos_diarios sld
         FULL JOIN (SELECT mov_1.process_date,
                           mov_1.client_id,
                           mov_1.custodian,
                           mov_1.account_no,
                           mov_1.cusip,
                           mov_1.isin,
                           mov_1.symbol,
                           mov_1.id_tipo_activo,
                           mov_1.id_sub_tipo_activo,
                           mov_1.id_sub_sub_tipo_activo,
                           mov_1.currency,
                           sum(
                                   CASE mov_1.tipo_reg
                                       WHEN 'DIV'::text THEN mov_1.sum_usde_net_amount
                                       ELSE 0::numeric
                                       END)                                                                          AS dividendos,
                           sum(
                                   CASE mov_1.tipo_reg
                                       WHEN 'ABO'::text THEN mov_1.sum_usde_net_amount
                                       ELSE 0::numeric
                                       END)                                                                          AS abonos,
                           sum(
                                   CASE mov_1.tipo_reg
                                       WHEN 'RET'::text THEN mov_1.sum_usde_net_amount
                                       ELSE 0::numeric
                                       END)                                                                          AS retiros,
                           string_agg(COALESCE(mov_1.activity_description, ''::character varying)::text,
                                      '||'::text)                                                                    AS activity_description
                    FROM rep_inv.base_movimientos_diarios mov_1
                    GROUP BY mov_1.process_date, mov_1.client_id, mov_1.custodian, mov_1.account_no, mov_1.cusip,
                             mov_1.isin, mov_1.symbol, mov_1.id_tipo_activo, mov_1.id_sub_tipo_activo,
                             mov_1.id_sub_sub_tipo_activo, mov_1.currency) mov
                   ON sld.process_date::text = mov.process_date::text AND sld.client_id::text = mov.client_id::text AND
                      sld.custodian::text = mov.custodian::text AND sld.account_no::text = mov.account_no::text AND
                      sld.cusip::text = mov.cusip::text AND sld.isin::text = mov.isin::text AND
                      sld.symbol::text = mov.symbol::text AND sld.id_tipo_activo::text = mov.id_tipo_activo::text AND
                      sld.id_sub_tipo_activo::text = mov.id_sub_tipo_activo::text AND
                      sld.id_sub_sub_tipo_activo::text = mov.id_sub_sub_tipo_activo::text AND
                      sld.currency::text = mov.currency::text;


create or replace function rep_inv.fn_rentabilidad(_agregador_n1 character varying, _agregador_n2 character varying, _agregador_n3 character varying, _agregador_n4 character varying, _fecha_desde character varying, _fecha_hasta character varying)
    returns TABLE(
        row_id character varying, nivel character varying, sub_nivel bigint, process_date character varying, process_date_as_date date,
        agregador_n1 character varying, agregador_n2 character varying, agregador_n3 character varying, agregador_n4 character varying,
        saldo_dia numeric, abonos_dia numeric, retiros_dia numeric, dividendos_dia numeric, saldo_dia_anterior numeric, comision_devengada_dia numeric,
        utilidad numeric, rentabilidad numeric, saldo_rentabilidad numeric, suma_saldo_rentabilidad numeric, suma_saldos_iniciales numeric,
        primer_dia_con_saldo date, ultimo_dia_con_saldo date, dias_con_saldo integer,
        --TODO: Limpiar columnas "chile"
        rentabilidad_ponderada numeric, rentabilidad_periodo_cl numeric,
        base1_fecha_desde date, base1_fecha_hasta date, base1_rentabilidad numeric,
        base2_fecha_desde date, base2_fecha_hasta date, base2_rentabilidad numeric,
        base3_fecha_desde date, base3_fecha_hasta date, base3_rentabilidad numeric,
        base4_fecha_desde date, base4_fecha_hasta date, base4_rentabilidad numeric,
        base5_fecha_desde date, base5_fecha_hasta date, base5_rentabilidad numeric,
        base6_fecha_desde date, base6_fecha_hasta date, base6_rentabilidad numeric,
        base7_fecha_desde date, base7_fecha_hasta date, base7_rentabilidad numeric,
        base8_fecha_desde date, base8_fecha_hasta date, base8_rentabilidad numeric)
    language plpgsql
as
$$
BEGIN
    /*
    inioper     inicio operaciones
    apercta		apertura cuenta = inicio operaciones
    1mes		1 mes
    3meses		3 meses
    12meses		12 meses
    ytd			acumulado en el año
    20meses		20 meses
     */

    IF (trim(_agregador_n2)='') THEN
        _agregador_n2:=NULL;
    end if;

    --Nivel 1
    RETURN QUERY
        SELECT
            ('N1-'||(rank() OVER win_order)::VARCHAR(100))::VARCHAR(100)       AS row_id,
            'N1'::VARCHAR(100) as nivel,
            (rank() OVER win_order)::bigint as sub_nivel,
            calc.process_date, calc.process_date_as_date,
            calc.agregador_n1, NULL::VARCHAR(100) as agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4,
            calc.saldo_dia, calc.abonos_dia, calc.retiros_dia, calc.dividendos_dia, calc.saldo_dia_anterior,
            calc.comision_devengada_dia,
            calc.utilidad, calc.rentabilidad, calc.saldo_rentabilidad,
            calc.suma_saldo_rentabilidad::NUMERIC(45,20), calc.suma_saldos_iniciales::NUMERIC(45,20),
            calc.primer_dia_con_saldo::DATE, calc.ultimo_dia_con_saldo::DATE, ((calc.ultimo_dia_con_saldo- calc.primer_dia_con_saldo)+1)::int as dias_con_saldo,
            (CASE WHEN calc.suma_saldos_iniciales=0 THEN NULL ELSE calc.suma_saldo_rentabilidad/calc.suma_saldos_iniciales END)::NUMERIC(45,20) as rentabilidad_ponderada,
            (power( ( 1 + CASE WHEN calc.suma_saldos_iniciales=0 THEN NULL ELSE calc.suma_saldo_rentabilidad/calc.suma_saldos_iniciales END ), ((calc.ultimo_dia_con_saldo- calc.primer_dia_con_saldo)+1) ) - 1)::NUMERIC(45,20) as rentabilidad_periodo_cl,
            --Desde inicio operaciones
            calc.fecha_desde_base_inioper::DATE as base1_fecha_desde,
            calc.fecha_hasta_base_inioper::DATE as base1_fecha_hasta,
            calc.rentabilidad_pitatoria_base_inioper::NUMERIC(45,20) as base1_rentabilidad,
            --Desde apertura (igual a inicio operaciones)
            calc.fecha_desde_base_apertura::DATE as base2_fecha_desde,
            calc.fecha_hasta_base_apertura::DATE as base2_fecha_hasta,
            calc.rentabilidad_pitatoria_base_apertura::NUMERIC(45,20) as base2_rentabilidad,
            --1 mes
            calc.fecha_desde_base_1mes::DATE as base3_fecha_desde,
            calc.fecha_hasta_base_1mes::DATE as base3_fecha_hasta,
            calc.rentabilidad_pitatoria_base_1mes::NUMERIC(45,20) as base3_rentabilidad,
            --3 meses
            calc.fecha_desde_base_3meses::DATE as base4_fecha_desde,
            calc.fecha_hasta_base_3meses::DATE as base4_fecha_hasta,
            calc.rentabilidad_pitatoria_base_3meses::NUMERIC(45,20) as base4_rentabilidad,
            --12 meses
            calc.fecha_desde_base_12meses::DATE as base5_fecha_desde,
            calc.fecha_hasta_base_12meses::DATE as base5_fecha_hasta,
            calc.rentabilidad_pitatoria_base_12meses::NUMERIC(45,20) as base5_rentabilidad,
            --Año en curso (desde 01 ene) o YTD
            calc.fecha_desde_base_ytd::DATE as base6_fecha_desde,
            calc.fecha_hasta_base_ytd::DATE as base6_fecha_hasta,
            calc.rentabilidad_pitatoria_base_ytd::NUMERIC(45,20) as base6_rentabilidad,
            --20 meses
            calc.fecha_desde_base_20meses::DATE as base7_fecha_desde,
            calc.fecha_hasta_base_20meses::DATE as base7_fecha_hasta,
            calc.rentabilidad_pitatoria_base_20meses::NUMERIC(45,20) as base7_rentabilidad,
            --Compatibildiad/escalabilidad futura
            NULL::DATE as base8_fecha_desde,
            NULL::DATE as base8_fecha_hasta,
            NULL::NUMERIC(45,20) as base8_rentabilidad
        FROM (
                 SELECT
                     tbn.process_date, tbn.process_date_as_date,
                     tbn.agregador_n1,
                     tbn.saldo_dia, tbn.abonos_dia, tbn.retiros_dia, tbn.dividendos_dia, tbn.comision_devengada_dia, tbn.saldo_dia_anterior,
                     tbn.utilidad, tbn.rentabilidad, tbn.saldo_rentabilidad,
                     min(tbn.process_date_as_date) OVER win_rent_inioper as fecha_desde_base_inioper,
                     max(tbn.process_date_as_date) OVER win_rent_inioper as fecha_hasta_base_inioper,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_inioper as rentabilidad_pitatoria_base_inioper,
                     min(tbn.process_date_as_date) OVER win_rent_apertura as fecha_desde_base_apertura,
                     max(tbn.process_date_as_date) OVER win_rent_apertura as fecha_hasta_base_apertura,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_apertura as rentabilidad_pitatoria_base_apertura,
                     min(tbn.process_date_as_date) OVER win_rent_1mes as fecha_desde_base_1mes,
                     max(tbn.process_date_as_date) OVER win_rent_1mes as fecha_hasta_base_1mes,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_1mes as rentabilidad_pitatoria_base_1mes,
                     min(tbn.process_date_as_date) OVER win_rent_3meses as fecha_desde_base_3meses,
                     max(tbn.process_date_as_date) OVER win_rent_3meses as fecha_hasta_base_3meses,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_3meses as rentabilidad_pitatoria_base_3meses,
                     min(tbn.process_date_as_date) OVER win_rent_12meses as fecha_desde_base_12meses,
                     max(tbn.process_date_as_date) OVER win_rent_12meses as fecha_hasta_base_12meses,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_12meses as rentabilidad_pitatoria_base_12meses,
                     min(tbn.process_date_as_date) OVER win_rent_ytd as fecha_desde_base_ytd,
                     max(tbn.process_date_as_date) OVER win_rent_ytd as fecha_hasta_base_ytd,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_ytd as rentabilidad_pitatoria_base_ytd,
                     sum(tbn.saldo_rentabilidad) OVER win_full as suma_saldo_rentabilidad,
                     sum(tbn.saldo_dia_anterior) OVER win_full as suma_saldos_iniciales,
                     min(tbn.process_date_as_date) OVER win_full as primer_dia_con_saldo,
                     max(tbn.process_date_as_date) OVER win_full as ultimo_dia_con_saldo,
                     min(tbn.process_date_as_date) OVER win_rent_20meses as fecha_desde_base_20meses,
                     max(tbn.process_date_as_date) OVER win_rent_20meses as fecha_hasta_base_20meses,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_20meses as rentabilidad_pitatoria_base_20meses
                 FROM rep_inv.consolidado_agregado_n1 tbn
                 WHERE tbn.agregador_n1=COALESCE(_agregador_n1, tbn.agregador_n1)
                 WINDOW
                    win_full AS (PARTITION BY tbn.agregador_n1 ORDER BY tbn.process_date_as_date),
                    win_rent_inioper AS (PARTITION BY tbn.agregador_n1 ORDER BY tbn.process_date_as_date ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),
                    win_rent_apertura AS (PARTITION BY tbn.agregador_n1 ORDER BY tbn.process_date_as_date),
                    win_rent_1mes AS (PARTITION BY tbn.agregador_n1 ORDER BY tbn.process_date_as_date RANGE BETWEEN '1 month' PRECEDING AND CURRENT ROW),
                    win_rent_3meses AS (PARTITION BY tbn.agregador_n1 ORDER BY tbn.process_date_as_date RANGE BETWEEN '3 month' PRECEDING AND CURRENT ROW),
                    win_rent_12meses AS (PARTITION BY tbn.agregador_n1 ORDER BY tbn.process_date_as_date RANGE BETWEEN '12 month' PRECEDING  AND CURRENT ROW),
                    win_rent_ytd AS (PARTITION BY tbn.agregador_n1, EXTRACT(YEAR FROM tbn.process_date_as_date) ORDER BY tbn.process_date_as_date),
                    win_rent_20meses AS (PARTITION BY tbn.agregador_n1 ORDER BY tbn.process_date_as_date RANGE BETWEEN '20 month' PRECEDING  AND CURRENT ROW)
             ) as calc
        WHERE calc.process_date>=_fecha_desde AND calc.process_date<=_fecha_hasta
        WINDOW win_order as (ORDER BY calc.agregador_n1, calc.process_date_as_date)
        ORDER BY calc.agregador_n1, calc.process_date_as_date
    ;
    --Nivel 2
    RETURN QUERY
        SELECT
            ('N2-'||(rank() OVER win_order)::VARCHAR(100))::VARCHAR(100)       AS row_id,
            'N2'::VARCHAR(100) as nivel,
            (rank() OVER win_order)::bigint as sub_nivel,
            calc.process_date, calc.process_date_as_date,
            calc.agregador_n1, calc.agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4,
            calc.saldo_dia, calc.abonos_dia, calc.retiros_dia, calc.dividendos_dia, calc.saldo_dia_anterior,
            calc.comision_devengada_dia,
            calc.utilidad, calc.rentabilidad, calc.saldo_rentabilidad,
            calc.suma_saldo_rentabilidad::NUMERIC(45,20), calc.suma_saldos_iniciales::NUMERIC(45,20),
            calc.primer_dia_con_saldo::DATE, calc.ultimo_dia_con_saldo::DATE, ((calc.ultimo_dia_con_saldo- calc.primer_dia_con_saldo)+1)::int as dias_con_saldo,
            (CASE WHEN calc.suma_saldos_iniciales=0 THEN NULL ELSE calc.suma_saldo_rentabilidad/calc.suma_saldos_iniciales END)::NUMERIC(45,20) as rentabilidad_ponderada,
            (power( ( 1 + CASE WHEN calc.suma_saldos_iniciales=0 THEN NULL ELSE calc.suma_saldo_rentabilidad/calc.suma_saldos_iniciales END ), ((calc.ultimo_dia_con_saldo- calc.primer_dia_con_saldo)+1) ) - 1)::NUMERIC(45,20) as rentabilidad_periodo_cl,
            --Desde inicio operaciones
            calc.fecha_desde_base_inioper::DATE as base1_fecha_desde,
            calc.fecha_hasta_base_inioper::DATE as base1_fecha_hasta,
            calc.rentabilidad_pitatoria_base_inioper::NUMERIC(45,20) as base1_rentabilidad,
            --Desde apertura (igual a inicio operaciones)
            calc.fecha_desde_base_apertura::DATE as base2_fecha_desde,
            calc.fecha_hasta_base_apertura::DATE as base2_fecha_hasta,
            calc.rentabilidad_pitatoria_base_apertura::NUMERIC(45,20) as base2_rentabilidad,
            --1 mes
            calc.fecha_desde_base_1mes::DATE as base3_fecha_desde,
            calc.fecha_hasta_base_1mes::DATE as base3_fecha_hasta,
            calc.rentabilidad_pitatoria_base_1mes::NUMERIC(45,20) as base3_rentabilidad,
            --3 meses
            calc.fecha_desde_base_3meses::DATE as base4_fecha_desde,
            calc.fecha_hasta_base_3meses::DATE as base4_fecha_hasta,
            calc.rentabilidad_pitatoria_base_3meses::NUMERIC(45,20) as base4_rentabilidad,
            --12 meses
            calc.fecha_desde_base_12meses::DATE as base5_fecha_desde,
            calc.fecha_hasta_base_12meses::DATE as base5_fecha_hasta,
            calc.rentabilidad_pitatoria_base_12meses::NUMERIC(45,20) as base5_rentabilidad,
            --Año en curso (desde 01 ene) o YTD
            calc.fecha_desde_base_ytd::DATE as base6_fecha_desde,
            calc.fecha_hasta_base_ytd::DATE as base6_fecha_hasta,
            calc.rentabilidad_pitatoria_base_ytd::NUMERIC(45,20) as base6_rentabilidad,
            --20 meses
            calc.fecha_desde_base_20meses::DATE as base7_fecha_desde,
            calc.fecha_hasta_base_20meses::DATE as base7_fecha_hasta,
            calc.rentabilidad_pitatoria_base_20meses::NUMERIC(45,20) as base7_rentabilidad,
            --Compatibildiad/escalabilidad futura
            NULL::DATE as base8_fecha_desde,
            NULL::DATE as base8_fecha_hasta,
            NULL::NUMERIC(45,20) as base8_rentabilidad
        FROM (
                 SELECT
                     tbn.process_date, tbn.process_date_as_date,
                     tbn.agregador_n1, tbn.agregador_n2,
                     tbn.saldo_dia, tbn.abonos_dia, tbn.retiros_dia, tbn.dividendos_dia, tbn.comision_devengada_dia, tbn.saldo_dia_anterior,
                     tbn.utilidad, tbn.rentabilidad, tbn.saldo_rentabilidad,
                     min(tbn.process_date_as_date) OVER win_rent_inioper as fecha_desde_base_inioper,
                     max(tbn.process_date_as_date) OVER win_rent_inioper as fecha_hasta_base_inioper,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_inioper as rentabilidad_pitatoria_base_inioper,
                     min(tbn.process_date_as_date) OVER win_rent_apertura as fecha_desde_base_apertura,
                     max(tbn.process_date_as_date) OVER win_rent_apertura as fecha_hasta_base_apertura,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_apertura as rentabilidad_pitatoria_base_apertura,
                     min(tbn.process_date_as_date) OVER win_rent_1mes as fecha_desde_base_1mes,
                     max(tbn.process_date_as_date) OVER win_rent_1mes as fecha_hasta_base_1mes,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_1mes as rentabilidad_pitatoria_base_1mes,
                     min(tbn.process_date_as_date) OVER win_rent_3meses as fecha_desde_base_3meses,
                     max(tbn.process_date_as_date) OVER win_rent_3meses as fecha_hasta_base_3meses,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_3meses as rentabilidad_pitatoria_base_3meses,
                     min(tbn.process_date_as_date) OVER win_rent_12meses as fecha_desde_base_12meses,
                     max(tbn.process_date_as_date) OVER win_rent_12meses as fecha_hasta_base_12meses,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_12meses as rentabilidad_pitatoria_base_12meses,
                     min(tbn.process_date_as_date) OVER win_rent_ytd as fecha_desde_base_ytd,
                     max(tbn.process_date_as_date) OVER win_rent_ytd as fecha_hasta_base_ytd,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_ytd as rentabilidad_pitatoria_base_ytd,
                     sum(tbn.saldo_rentabilidad) OVER win_full as suma_saldo_rentabilidad,
                     sum(tbn.saldo_dia_anterior) OVER win_full as suma_saldos_iniciales,
                     min(tbn.process_date_as_date) OVER win_full as primer_dia_con_saldo,
                     max(tbn.process_date_as_date) OVER win_full as ultimo_dia_con_saldo,
                     min(tbn.process_date_as_date) OVER win_rent_20meses as fecha_desde_base_20meses,
                     max(tbn.process_date_as_date) OVER win_rent_20meses as fecha_hasta_base_20meses,
                     public.prod(tbn.rentabilidad_base_pitatoria) OVER win_rent_20meses as rentabilidad_pitatoria_base_20meses
                 FROM rep_inv.consolidado_agregado_n2 tbn
                 WHERE tbn.agregador_n1=COALESCE(_agregador_n1, tbn.agregador_n1) AND tbn.agregador_n2=COALESCE(_agregador_n2, tbn.agregador_n2)
                 WINDOW
                     win_full AS (PARTITION BY tbn.agregador_n1, tbn.agregador_n2 ORDER BY tbn.process_date_as_date),
                    win_rent_inioper AS (PARTITION BY tbn.agregador_n1, tbn.agregador_n2 ORDER BY tbn.process_date_as_date ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),
                    win_rent_apertura AS (PARTITION BY tbn.agregador_n1, tbn.agregador_n2 ORDER BY tbn.process_date_as_date),
                    win_rent_1mes AS (PARTITION BY tbn.agregador_n1, tbn.agregador_n2 ORDER BY tbn.process_date_as_date RANGE BETWEEN '1 month' PRECEDING AND CURRENT ROW),
                    win_rent_3meses AS (PARTITION BY tbn.agregador_n1, tbn.agregador_n2 ORDER BY tbn.process_date_as_date RANGE BETWEEN '3 month' PRECEDING AND CURRENT ROW),
                    win_rent_12meses AS (PARTITION BY tbn.agregador_n1, tbn.agregador_n2 ORDER BY tbn.process_date_as_date RANGE BETWEEN '12 month' PRECEDING  AND CURRENT ROW),
                    win_rent_ytd AS (PARTITION BY tbn.agregador_n1, tbn.agregador_n2, EXTRACT(YEAR FROM tbn.process_date_as_date) ORDER BY tbn.process_date_as_date),
                    win_rent_20meses AS (PARTITION BY tbn.agregador_n1, tbn.agregador_n2 ORDER BY tbn.process_date_as_date RANGE BETWEEN '20 month' PRECEDING  AND CURRENT ROW)
             ) as calc
        WHERE calc.process_date>=_fecha_desde AND calc.process_date<=_fecha_hasta
        WINDOW win_order as (ORDER BY calc.agregador_n1, calc.agregador_n2, calc.process_date_as_date)
        ORDER BY calc.agregador_n1, calc.agregador_n2, calc.process_date_as_date
    ;
    RETURN;
END;
$$;


create or replace function rep_inv.fn_start_date_for_metric(_date_in date, _metric character varying) returns date
    language plpgsql
as
$$
DECLARE _aux_date DATE;
    BEGIN

    IF _metric='MTD' THEN
        RETURN date_trunc('month', _date_in);
    ELSEIF _metric='YTD' THEN
        RETURN date_trunc('year', _date_in);
    ELSEIF _metric='INI_OPER' THEN
        RETURN '2022-01-01'::date;
    ELSEIF _metric='APER' THEN
        RETURN '2022-01-01'::date;
    ELSEIF _metric='1M' THEN
        _aux_date = public.fn_calendario_ult_dia_mes(_date_in);
        IF _date_in=_aux_date THEN
            RETURN date_trunc('month', _date_in);
        ELSE
            RETURN (_date_in - interval '1 month')+ interval '1 day';
        END IF;
    ELSEIF _metric='3M' THEN
        _aux_date = public.fn_calendario_ult_dia_mes(_date_in);
        IF _date_in=_aux_date THEN
            RETURN date_trunc('month', _date_in - interval '2 month');
        ELSE
            RETURN (_date_in - interval '3 month')+ interval '1 day';
        END IF;
    ELSEIF _metric='12M' THEN
        _aux_date = public.fn_calendario_ult_dia_mes(_date_in);
        IF _date_in=_aux_date THEN
            RETURN date_trunc('month', _date_in - interval '11 month');
        ELSE
            RETURN (_date_in - interval '12 month')+ interval '1 day';
        END IF;
    ELSEIF _metric='20M' THEN
        _aux_date = public.fn_calendario_ult_dia_mes(_date_in);
        IF _date_in=_aux_date THEN
            RETURN date_trunc('month', _date_in - interval '19 month');
        ELSE
            RETURN (_date_in - interval '20 month')+ interval '1 day';
        END IF;
    END IF;

    RETURN null::date;

    END;
$$;


create or replace function rep_inv.fn_calculo_rentabilidad_agregada(
    _date_ini date, _date_fin date, _agregador_n1 character varying, _agregador_n2 character varying, _agregador_n3 character varying, _agregador_n4 character varying
) returns SETOF rep_inv.reg_rent
    language plpgsql
as
$$
    BEGIN

    DROP TABLE IF EXISTS temptb_base_calculo;

    CREATE TEMP TABLE temptb_base_calculo AS
    (
        SELECT
            tbn.process_date_as_date, tbn.saldo_dia_anterior, tbn.saldo_rentabilidad, tbn.rentabilidad_base_pitatoria,
            tbn.agregador_n1, NULL::VARCHAR(100) as agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4
        FROM rep_inv.consolidado_agregado_n1 tbn
        WHERE tbn.agregador_n1= _agregador_n1
        AND tbn.process_date_as_date>=_date_ini
        AND tbn.process_date_as_date<=_date_fin
    );

    INSERT INTO temptb_base_calculo
    SELECT
            tbn.process_date_as_date, tbn.saldo_dia_anterior, tbn.saldo_rentabilidad, tbn.rentabilidad_base_pitatoria,
            tbn.agregador_n1, NULL::VARCHAR(100) as agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4
        FROM rep_inv.consolidado_agregado_n2 tbn
        WHERE tbn.agregador_n1= _agregador_n1 AND tbn.agregador_n2= _agregador_n2
        AND tbn.process_date_as_date>=_date_ini
        AND tbn.process_date_as_date<=_date_fin
    ;

    RETURN QUERY
    SELECT
        tb_calc.fecha_desde, tb_calc.fecha_hasta,
        tb_calc.agregador_n1, tb_calc.agregador_n2, tb_calc.agregador_n3, tb_calc.agregador_n4,
        tb_calc.cant_reg, tb_calc.dias_con_saldo,
        tb_calc.pitatoria::NUMERIC(45,20) as rentabilidad_periodo,
        tb_calc.suma_saldos_iniciales, tb_calc.suma_saldo_rentabilidad,
        (CASE
            WHEN tb_calc.suma_saldos_iniciales=0 THEN NULL
            ELSE tb_calc.suma_saldo_rentabilidad/tb_calc.suma_saldos_iniciales
            END)::NUMERIC(45,20) as rentabilidad_ponderada_cl,
        (power(
            ( 1 + CASE WHEN tb_calc.suma_saldos_iniciales=0 THEN NULL ELSE tb_calc.suma_saldo_rentabilidad/tb_calc.suma_saldos_iniciales END ),
            (tb_calc.dias_con_saldo)
            ) - 1)::NUMERIC(45,20) as rentabilidad_periodo_cl

    FROM
    (
        SELECT
            count(*)::integer                                                           as cant_reg,
            min(tbn.process_date_as_date)::DATE                                         as fecha_desde,
            max(tbn.process_date_as_date)::DATE                                         as fecha_hasta,
            ((max(tbn.process_date_as_date)- min(tbn.process_date_as_date))+1)::integer as dias_con_saldo,
            sum(tbn.saldo_dia_anterior)::NUMERIC(45,20)                                 as suma_saldos_iniciales,
            sum(tbn.saldo_rentabilidad)::NUMERIC(45,20)                                 as suma_saldo_rentabilidad,
            public.prod(COALESCE(tbn.rentabilidad_base_pitatoria,1))-1::NUMERIC(45,20)  as pitatoria,
            tbn.agregador_n1                                                            as agregador_n1,
            tbn.agregador_n2                                                            as agregador_n2,
            tbn.agregador_n3                                                            as agregador_n3,
            tbn.agregador_n4                                                            as agregador_n4
        FROM temptb_base_calculo tbn
        GROUP BY tbn.agregador_n1, tbn.agregador_n2, tbn.agregador_n3, tbn.agregador_n4
    ) as tb_calc
    ;

    DROP TABLE temptb_base_calculo;

    END;
$$;


create or replace function rep_inv.fn_calcula_rentabilidad(
    _agregador_n1 character varying, _agregador_n2 character varying, _agregador_n3 character varying, _agregador_n4 character varying,
    _start_process_date character varying, _end_process_date character varying
) returns SETOF rep_inv.rentabilidad_calculada
    language plpgsql
as
$$
BEGIN
    /*
    inioper     inicio operaciones
    apercta		apertura cuenta = inicio operaciones
    1mes		1 mes
    3meses		3 meses
    12meses		12 meses
    ytd			acumulado en el año
    20meses		20 meses
     */

    IF (trim(_agregador_n2)='') THEN
        _agregador_n2:=NULL;
    end if;

    IF (trim(_agregador_n3)='') THEN
        _agregador_n3:=NULL;
    end if;

    IF (trim(_agregador_n4)='') THEN
        _agregador_n4:=NULL;
    end if;


    DROP TABLE IF EXISTS temptb_consolidado_agregado;

    --TODO: Parametrizar query
    CREATE TEMP TABLE temptb_consolidado_agregado AS
    (
        SELECT
            'N1'::VARCHAR(100) as nivel,
            rank() OVER (ORDER BY tbn.process_date, tbn.agregador_n1)::BIGINT as sub_nivel,
            tbn.process_date, tbn.process_date_as_date,
            tbn.agregador_n1, NULL::VARCHAR(100) as agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4,
            tbn.saldo_dia_anterior, tbn.abonos_dia, tbn.retiros_dia, tbn.dividendos_dia, tbn.saldo_dia,
            tbn.comision_devengada_dia,
            tbn.utilidad, tbn.rentabilidad, tbn.rentabilidad_base_pitatoria, tbn.saldo_rentabilidad
        FROM rep_inv.consolidado_agregado_n1 tbn
        WHERE tbn.agregador_n1=COALESCE(_agregador_n1, tbn.agregador_n1)
        AND tbn.process_date>=_start_process_date AND tbn.process_date<=_end_process_date
    );
    INSERT INTO temptb_consolidado_agregado (nivel, sub_nivel, process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4, abonos_dia, retiros_dia, dividendos_dia, saldo_dia, comision_devengada_dia)
    SELECT
        'N2'::VARCHAR(100) as nivel,
        rank() OVER (ORDER BY tbn.process_date, tbn.agregador_n1, tbn.agregador_n2)::BIGINT as sub_nivel,
        tbn.process_date, tbn.process_date_as_date,
        tbn.agregador_n1, tbn.agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4,
        tbn.abonos_dia, tbn.retiros_dia, tbn.dividendos_dia, tbn.saldo_dia,
        tbn.comision_devengada_dia
    FROM rep_inv.consolidado_agregado_n2 tbn
    WHERE tbn.agregador_n1=COALESCE(_agregador_n1, tbn.agregador_n1) AND tbn.agregador_n2=COALESCE(_agregador_n2, tbn.agregador_n2)
    AND tbn.process_date>=_start_process_date AND tbn.process_date<=_end_process_date
    ;


    RETURN QUERY
        SELECT
            (rank() OVER (ORDER BY tb_calc.row_id, tb_calc.nivel, tb_calc.sub_nivel,tb_calc.process_date))::BIGINT as id,
            tb_calc.row_id, tb_calc.nivel, tb_calc.sub_nivel,
            tb_calc.process_date, tb_calc.process_date_as_date,
            tb_calc.agregador_n1, tb_calc.agregador_n2, tb_calc.agregador_n3, tb_calc.agregador_n4,
            tb_calc.saldo_dia_anterior, tb_calc.abonos_dia, tb_calc.retiros_dia, tb_calc.dividendos_dia, tb_calc.saldo_dia,
            tb_calc.comision_devengada_dia,
            tb_calc.utilidad, tb_calc.rentabilidad, tb_calc.rentabilidad_base_pitatoria, tb_calc.saldo_rentabilidad,
            --Inicio Operaciones
            tb_calc.start_date_inioper as base1_start_date,
            (tb_calc.det_rent_inioper).fecha_desde as base1_fecha_desde,
            (tb_calc.det_rent_inioper).fecha_hasta as base1_fecha_hasta,
            (tb_calc.det_rent_inioper).rentabilidad_periodo as base1_rentabilidad,
            (tb_calc.det_rent_inioper).dias_con_saldo as base1_dias_con_saldo,
            (tb_calc.det_rent_inioper).suma_saldos_iniciales as base1_suma_saldos_iniciales,
            (tb_calc.det_rent_inioper).suma_saldo_rentabilidad as base1_suma_saldo_rentabilidad,
            (tb_calc.det_rent_inioper).rentabilidad_ponderada_cl as base1_rentabilidad_ponderada_cl,
            (tb_calc.det_rent_inioper).rentabilidad_periodo_cl as base1_rentabilidad_periodo_cl,
            (tb_calc.det_rent_inioper).cant_reg as base1_cant_reg,
            --Apertura
            tb_calc.start_date_aper as base2_start_date,
            (tb_calc.det_rent_aper).fecha_desde as base2_fecha_desde,
            (tb_calc.det_rent_aper).fecha_hasta as base2_fecha_hasta,
            (tb_calc.det_rent_aper).rentabilidad_periodo as base2_rentabilidad,
            (tb_calc.det_rent_aper).dias_con_saldo as base2_dias_con_saldo,
            (tb_calc.det_rent_aper).suma_saldos_iniciales as base2_suma_saldos_iniciales,
            (tb_calc.det_rent_aper).suma_saldo_rentabilidad as base2_suma_saldo_rentabilidad,
            (tb_calc.det_rent_aper).rentabilidad_ponderada_cl as base2_rentabilidad_ponderada_cl,
            (tb_calc.det_rent_aper).rentabilidad_periodo_cl as base2_rentabilidad_periodo_cl,
            (tb_calc.det_rent_aper).cant_reg as base2_cant_reg,
            --1 mes
            tb_calc.start_date_1m as base3_start_date,
            (tb_calc.det_rent_1m).fecha_desde as base3_fecha_desde,
            (tb_calc.det_rent_1m).fecha_hasta as base3_fecha_hasta,
            (tb_calc.det_rent_1m).rentabilidad_periodo as base3_rentabilidad,
            (tb_calc.det_rent_1m).dias_con_saldo as base3_dias_con_saldo,
            (tb_calc.det_rent_1m).suma_saldos_iniciales as base3_suma_saldos_iniciales,
            (tb_calc.det_rent_1m).suma_saldo_rentabilidad as base3_suma_saldo_rentabilidad,
            (tb_calc.det_rent_1m).rentabilidad_ponderada_cl as base3_rentabilidad_ponderada_cl,
            (tb_calc.det_rent_1m).rentabilidad_periodo_cl as base3_rentabilidad_periodo_cl,
            (tb_calc.det_rent_1m).cant_reg as base3_cant_reg,
            --3 meses
            tb_calc.start_date_3m as base4_start_date,
            (tb_calc.det_rent_3m).fecha_desde as base4_fecha_desde,
            (tb_calc.det_rent_3m).fecha_hasta as base4_fecha_hasta,
            (tb_calc.det_rent_3m).rentabilidad_periodo as base4_rentabilidad,
            (tb_calc.det_rent_3m).dias_con_saldo as base4_dias_con_saldo,
            (tb_calc.det_rent_3m).suma_saldos_iniciales as base4_suma_saldos_iniciales,
            (tb_calc.det_rent_3m).suma_saldo_rentabilidad as base4_suma_saldo_rentabilidad,
            (tb_calc.det_rent_3m).rentabilidad_ponderada_cl as base4_rentabilidad_ponderada_cl,
            (tb_calc.det_rent_3m).rentabilidad_periodo_cl as base4_rentabilidad_periodo_cl,
            (tb_calc.det_rent_3m).cant_reg as base4_cant_reg,
            --12 meses
            tb_calc.start_date_12m as base5_start_date,
            (tb_calc.det_rent_12m).fecha_desde as base5_fecha_desde,
            (tb_calc.det_rent_12m).fecha_hasta as base5_fecha_hasta,
            (tb_calc.det_rent_12m).rentabilidad_periodo as base5_rentabilidad,
            (tb_calc.det_rent_12m).dias_con_saldo as base5_dias_con_saldo,
            (tb_calc.det_rent_12m).suma_saldos_iniciales as base5_suma_saldos_iniciales,
            (tb_calc.det_rent_12m).suma_saldo_rentabilidad as base5_suma_saldo_rentabilidad,
            (tb_calc.det_rent_12m).rentabilidad_ponderada_cl as base5_rentabilidad_ponderada_cl,
            (tb_calc.det_rent_12m).rentabilidad_periodo_cl as base5_rentabilidad_periodo_cl,
            (tb_calc.det_rent_12m).cant_reg as base5_cant_reg,
            --YTD
            tb_calc.start_date_ytd as base6_start_date,
            (tb_calc.det_rent_ytd).fecha_desde as base6_fecha_desde,
            (tb_calc.det_rent_ytd).fecha_hasta as base6_fecha_hasta,
            (tb_calc.det_rent_ytd).rentabilidad_periodo as base6_rentabilidad,
            (tb_calc.det_rent_ytd).dias_con_saldo as base6_dias_con_saldo,
            (tb_calc.det_rent_ytd).suma_saldos_iniciales as base6_suma_saldos_iniciales,
            (tb_calc.det_rent_ytd).suma_saldo_rentabilidad as base6_suma_saldo_rentabilidad,
            (tb_calc.det_rent_ytd).rentabilidad_ponderada_cl as base6_rentabilidad_ponderada_cl,
            (tb_calc.det_rent_ytd).rentabilidad_periodo_cl as base6_rentabilidad_periodo_cl,
            (tb_calc.det_rent_ytd).cant_reg as base6_cant_reg,
            --20 meses
            tb_calc.start_date_20m as base7_start_date,
            (tb_calc.det_rent_20m).fecha_desde as base7_fecha_desde,
            (tb_calc.det_rent_20m).fecha_hasta as base7_fecha_hasta,
            (tb_calc.det_rent_20m).rentabilidad_periodo as base7_rentabilidad,
            (tb_calc.det_rent_20m).dias_con_saldo as base7_dias_con_saldo,
            (tb_calc.det_rent_20m).suma_saldos_iniciales as base7_suma_saldos_iniciales,
            (tb_calc.det_rent_20m).suma_saldo_rentabilidad as base7_suma_saldo_rentabilidad,
            (tb_calc.det_rent_20m).rentabilidad_ponderada_cl as base7_rentabilidad_ponderada_cl,
            (tb_calc.det_rent_20m).rentabilidad_periodo_cl as base7_rentabilidad_periodo_cl,
            (tb_calc.det_rent_20m).cant_reg as base7_cant_reg,
            --No implementada
            NULL::date as base8_start_date,
            NULL::date as base8_fecha_desde,
            NULL::date as base8_fecha_hasta,
            NULL::NUMERIC(45,20) as base8_rentabilidad,
            NULL::INTEGER as base8_dias_con_saldo,
            NULL::NUMERIC(45,20) as base8_suma_saldos_iniciales,
            NULL::NUMERIC(45,20) as base8_suma_saldo_rentabilidad,
            NULL::NUMERIC(45,20) as base8_rentabilidad_ponderada_cl,
            NULL::NUMERIC(45,20) as base8_rentabilidad_periodo_cl,
            NULL::INTEGER as base8_cant_reg
        FROM
            (
                SELECT
                    (tb_base.nivel||'-'||tb_base.sub_nivel)::VARCHAR(100) as row_id,
                    tb_base.nivel, tb_base.sub_nivel,
                    tb_base.process_date, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4,
                    tb_base.saldo_dia_anterior, tb_base.abonos_dia, tb_base.retiros_dia, tb_base.dividendos_dia, tb_base.saldo_dia,
                    tb_base.comision_devengada_dia,
                    tb_base.utilidad, tb_base.rentabilidad, tb_base.rentabilidad_base_pitatoria, tb_base.saldo_rentabilidad,
                    tb_base.start_date_inioper,
                    tb_base.start_date_aper,
                    tb_base.start_date_1m,
                    tb_base.start_date_3m,
                    tb_base.start_date_12m,
                    tb_base.start_date_ytd,
                    tb_base.start_date_20m,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_inioper, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_inioper,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_aper, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_aper,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_1m, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_1m,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_3m, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_3m,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_12m, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_12m,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_ytd, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_ytd,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_20m, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_20m
                FROM
                    (
                        SELECT
                            tbn.nivel,
                            tbn.sub_nivel,
                            tbn.process_date, tbn.process_date_as_date,
                            tbn.agregador_n1, tbn.agregador_n2, tbn.agregador_n3, tbn.agregador_n4,
                            tbn.saldo_dia_anterior, tbn.abonos_dia, tbn.retiros_dia, tbn.dividendos_dia, tbn.saldo_dia,
                            tbn.comision_devengada_dia,
                            tbn.utilidad, tbn.rentabilidad, tbn.rentabilidad_base_pitatoria, tbn.saldo_rentabilidad,
                            rep_inv.fn_start_date_for_metric(tbn.process_date_as_date, 'INI_OPER') as start_date_inioper,
                            rep_inv.fn_start_date_for_metric(tbn.process_date_as_date, 'APER') as start_date_aper,
                            rep_inv.fn_start_date_for_metric(tbn.process_date_as_date, '1M') as start_date_1m,
                            rep_inv.fn_start_date_for_metric(tbn.process_date_as_date, '3M') as start_date_3m,
                            rep_inv.fn_start_date_for_metric(tbn.process_date_as_date, '12M') as start_date_12m,
                            rep_inv.fn_start_date_for_metric(tbn.process_date_as_date, 'YTD') as start_date_ytd,
                            rep_inv.fn_start_date_for_metric(tbn.process_date_as_date, '20M') as start_date_20m
                        FROM temptb_consolidado_agregado tbn
                    ) as tb_base
            ) as tb_calc
    ;

    DROP TABLE IF EXISTS temptb_consolidado_agregado;

    RETURN;
END;
$$;



create or replace function rep_inv.fn_redond_mult(value numeric, multiple numeric) returns numeric
    language plpgsql
as
$$
BEGIN
    --RAISE NOTICE 'Llamando a fn_redond_mult con value [%] y multiple [%]', value, multiple;
    RETURN (ROUND(value / multiple) * multiple)::NUMERIC(45,20);
END;
$$;


create or replace function rep_inv.fn_calcula_rentabilidad_base100(_process_date_start character varying, _process_date_end character varying, _agregador_n1 character varying)
    returns TABLE(process_date character varying, agregador_n1 character varying, valor_dia numeric, valor_base_100 numeric, min_axis numeric, max_axis numeric)
    language plpgsql
as
$$
DECLARE
    --Limites y rangos
    _max_value NUMERIC(45,20);
    _min_value NUMERIC(45,20);
    _max_value_mult NUMERIC(45,20);
    _min_value_mult NUMERIC(45,20);
    _max_diff NUMERIC(45,20);
    _min_diff NUMERIC(45,20);
    _max_axis NUMERIC(45,20);
    _min_axis NUMERIC(45,20);

BEGIN

    IF (_process_date_start IS NULL) THEN
        _process_date_start := public.fn_fecha_date_to_string(
                                    rep_inv.fn_start_date_for_metric( public.fn_fecha_string_to_date(_process_date_end, 'YYYYMMDD'::character varying), '12M'),
                                    'YYYYMMDD', '');
        RAISE NOTICE 'Se ha calculado _process_date_start como [%] para _process_date_end [%]', _process_date_start, _process_date_end;
    end if;
    DROP TABLE IF EXISTS temp_rentabilidad;

    CREATE TEMP TABLE temp_rentabilidad AS
        SELECT
            tb_rent.process_date,
            tb_rent.agregador_n1,
            tb_rent.rentabilidad_base_pitatoria as valor_dia,
            public.prod(tb_rent.rentabilidad_base_pitatoria) OVER (PARTITION BY tb_rent.agregador_n1 ORDER BY tb_rent.process_date_as_date ASC)*100::NUMERIC(45,20) AS valor_base_100
        FROM rep_inv.consolidado_agregado_n1 tb_rent
        WHERE tb_rent.process_date >= _process_date_start AND tb_rent.process_date <= _process_date_end
        AND tb_rent.agregador_n1 = _agregador_n1
        ORDER BY tb_rent.process_date;

    RAISE NOTICE 'Datos cargados, iniciando cálculos...';


    RAISE NOTICE 'Cálculos de base generados, calculando min/max ejes...';

    SELECT
        min(tmp_tb.valor_base_100), max(tmp_tb.valor_base_100)
    INTO
        _min_value, _max_value
    FROM temp_rentabilidad tmp_tb;

    _min_value_mult := rep_inv.fn_redond_mult(_min_value, 5);
    _max_value_mult := rep_inv.fn_redond_mult(_max_value,5);

    _min_diff   := _min_value_mult - _min_value;
    _max_diff   := _max_value_mult - _max_value;

    _min_axis   :=  CASE WHEN (_min_diff>=0) then _min_value_mult - 5 else _min_value_mult END;
    _max_axis   :=  CASE WHEN (_max_diff<1) then _max_value_mult + 5 else _max_value_mult END;
    --Ajustamos para que no sea 100 el límite
    IF (_min_axis=100)
    THEN
        _min_axis := 95;
    END IF;
    IF (_max_axis=100)
    THEN
        _max_axis := 105;
    END IF;

    --RAISE NOTICE 'Mínimo [%], múltiplo [%], Diff [%], Axis [%]', _min_value, _min_value_mult, _min_diff, _min_axis;
    --RAISE NOTICE 'Máximo [%], múltiplo [%], Diff [%], Axis [%]', _max_value, _max_value_mult, _max_diff, _max_axis;

    RAISE NOTICE 'Devolviendo datos...';

    RETURN QUERY
        SELECT
            tb_out.process_date,
            tb_out.agregador_n1,
            tb_out.valor_dia,
            tb_out.valor_base_100,
            _min_axis as min_axis, _max_axis as max_axis
        FROM temp_rentabilidad tb_out
        ORDER BY tb_out.process_date ASC;

    -- Manejo de excepciones
    EXCEPTION
    WHEN OTHERS THEN
        RAISE EXCEPTION 'Error en calcular_rentabilidad_base100 para rango de process date [%-%] y agregador [%]: %', _process_date_start, _process_date_end, _agregador_n1,SQLERRM;

END;
$$;


create or replace function rep_inv.fn_lista_clientes_por_generar(_process_date character varying)
    returns TABLE(client_id character varying, process_date character varying)
    language plpgsql
as
$$
    DECLARE _start_process_date VARCHAR(100);
    DECLARE _end_process_date VARCHAR(100);
BEGIN


    _start_process_date := LEFT(_process_date,6)||'01';
    _end_process_date   := _process_date;

    DROP TABLE IF EXISTS temp_base_clientes;

    CREATE TEMP TABLE temp_base_clientes AS
        SELECT distinct vw_sld.client_id FROM public.vw_reporte_maestro_datos_saldos vw_sld
        WHERE vw_sld.process_date<=_process_date AND vw_sld.process_date>=_start_process_date;

    INSERT INTO temp_base_clientes (client_id)
    SELECT distinct vw_mov.client_id FROM public.vw_reporte_maestro_datos_movimientos vw_mov
    WHERE vw_mov.process_date<=_process_date AND vw_mov.process_date>=_start_process_date;

    RETURN QUERY
        SELECT DISTINCT tb_base.client_id::VARCHAR(100) as client_id, _process_date::VARCHAR(100) as process_date
        FROM temp_base_clientes tb_base
        ORDER BY tb_base.client_id
        ;

    -- Manejo de excepciones
    EXCEPTION
    WHEN OTHERS THEN
        RAISE EXCEPTION 'Error en fn_lista_clientes_por_generar para process date [%]: %', _process_date, SQLERRM;

END;
$$;




create or replace function rep_inv.fn_precalculo_diario(_process_date_from character varying) returns character varying
    language plpgsql
as
$$
DECLARE _output VARCHAR(100);
    BEGIN
        _output:='';


        RAISE NOTICE 'Limpiando datos pre-existente del mismo process date... [%]', timeofday();


        DELETE FROM rep_inv.base_saldos_diarios WHERE process_date      >= _process_date_from;
        DELETE FROM rep_inv.base_movimientos_diarios WHERE process_date >= _process_date_from;
        DELETE FROM rep_inv.consolidado_agregado_n1 WHERE process_date  >= _process_date_from;
        DELETE FROM rep_inv.consolidado_agregado_n2 WHERE process_date  >= _process_date_from;
        DELETE FROM rep_inv.consolidado_agregado_n3 WHERE process_date  >= _process_date_from;
        DELETE FROM rep_inv.consolidado_agregado_n4 WHERE process_date  >= _process_date_from;

        /***********************************
        *** Saldos
        ***********************************/
        RAISE NOTICE 'Guardando saldos... [%]', timeofday();



        RAISE NOTICE 'Obteniendo saldos desde Maestros Hub [%]', timeofday();
        INSERT INTO rep_inv.base_saldos_diarios
            (cant_reg,
             process_date, client_id, custodian, account_no,
             cusip, isin, symbol, security_description,
             id_tipo_activo, id_sub_tipo_activo, id_sub_sub_tipo_activo, currency,
             sum_quantity, sum_market_value, sum_usde_market_value, sum_comision_devengada_diaria)
        SELECT
            count(*) as cant_reg,
            process_date, client_id, trim(upper(custodian)) as custodian, trim(account_no) as account_no,
            trim(cusip) as cusip, trim(isin) as isin, trim(symbol) as symbol, trim(security_description),
            trim(id_tipo_activo) as id_tipo_activo, trim(id_sub_tipo_activo) as id_sub_tipo_activo, trim(id_sub_sub_tipo_activo) as id_sub_sub_tipo_activo, trim(currency) as currency,
            sum(quantity) as sum_quantity, sum(market_value) as sum_market_value, sum(usde_market_value) as sum_usde_market_value, sum(comision_devengada_diaria) as sum_comision_devengada_diaria
        FROM public.vw_reporte_maestro_datos_saldos
        WHERE process_date  >= _process_date_from
        GROUP BY process_date, client_id, trim(upper(custodian)), trim(account_no), trim(cusip), trim(isin), trim(symbol), trim(security_description), trim(id_tipo_activo), trim(id_sub_tipo_activo), trim(id_sub_sub_tipo_activo), trim(currency)
        ORDER BY 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
        ;


        /***********************************
        *** Movimientos
        ***********************************/
        RAISE NOTICE 'Obteniendo movimientos desde Maestros Hub [%]', timeofday();

        RAISE NOTICE 'Guardando dividendos... [%]', timeofday();
        --Dividendos
        INSERT INTO rep_inv.base_movimientos_diarios
            (cant_reg,
             process_date, client_id, custodian, account_no,
             cusip, isin, symbol, source_code, activity_description,
             id_tipo_activo, id_sub_tipo_activo, id_sub_sub_tipo_activo, currency,
             sum_quantity, sum_net_amount, sum_principal, sum_usde_net_amount,
             tipo_reg)
        SELECT
            count(*) as cant_reg,
            process_date, client_id, trim(upper(custodian)) as custodian, trim(account_no) as account_no,
            trim(cusip) as cusip, trim(isin) as isin, trim(symbol) as symbol, trim(activity_code) as source_code, trim(activity_description) as activity_description,
            trim(id_tipo_activo) as id_tipo_activo, trim(id_sub_tipo_activo) as id_sub_tipo_activo, trim(id_sub_sub_tipo_activo) as id_sub_sub_tipo_activo, trim(currency) as currency,
            sum(quantity) as sum_quantity, sum(net_amount) as sum_net_amount, sum(principal) as sum_principal, sum(usde_net_amount) as sum_usde_net_amount,
            'DIV'::VARCHAR(100) as tipo_reg
        FROM public.vw_reporte_maestro_datos_movimientos
        WHERE process_date  >= _process_date_from
        AND trim(activity_code) in ( SELECT trim(tb_isrc.source_code) from pershing.sfl_isrc_actual tb_isrc where tb_isrc.statement_div_ind='DIVT' )
        GROUP BY process_date, client_id, trim(upper(custodian)), trim(account_no), trim(cusip), trim(isin), trim(symbol), trim(activity_code), trim(activity_description), trim(id_tipo_activo), trim(id_sub_tipo_activo), trim(id_sub_sub_tipo_activo), trim(currency)
        ORDER BY 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14;

        RAISE NOTICE 'Guardando abonos... [%]', timeofday();
        --Abonos
        INSERT INTO rep_inv.base_movimientos_diarios
            (cant_reg,
             process_date, client_id, custodian, account_no,
             cusip, isin, symbol, source_code, activity_description,
             id_tipo_activo, id_sub_tipo_activo, id_sub_sub_tipo_activo, currency,
             sum_quantity, sum_net_amount, sum_principal, sum_usde_net_amount,
             tipo_reg)
        SELECT
            count(*) as cant_reg,
            process_date, client_id, trim(upper(custodian)) as custodian, trim(account_no) as account_no,
            trim(cusip) as cusip, trim(isin) as isin, trim(symbol) as symbol, trim(activity_code) as source_code, trim(activity_description) as activity_description,
            trim(id_tipo_activo) as id_tipo_activo, trim(id_sub_tipo_activo) as id_sub_tipo_activo, trim(id_sub_sub_tipo_activo) as id_sub_sub_tipo_activo, trim(currency) as currency,
            sum(quantity) as sum_quantity, sum(net_amount) as sum_net_amount, sum(principal) as sum_principal, sum(usde_net_amount) as sum_usde_net_amount,
            'ABO'::VARCHAR(100) as tipo_reg
        FROM public.vw_reporte_maestro_datos_movimientos
        WHERE process_date  >= _process_date_from
        AND aplica_flujo_neto=1
        AND usde_net_amount>0
        GROUP BY process_date, client_id, trim(upper(custodian)), trim(account_no), trim(cusip), trim(isin), trim(symbol), trim(activity_code), trim(activity_description), trim(id_tipo_activo), trim(id_sub_tipo_activo), trim(id_sub_sub_tipo_activo), trim(currency)
        ORDER BY 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14;

        RAISE NOTICE 'Guardando retiros... [%]', timeofday();
        --Retiros
        INSERT INTO rep_inv.base_movimientos_diarios
            (cant_reg,
             process_date, client_id, custodian, account_no,
             cusip, isin, symbol, source_code, activity_description,
             id_tipo_activo, id_sub_tipo_activo, id_sub_sub_tipo_activo, currency,
             sum_quantity, sum_net_amount, sum_principal, sum_usde_net_amount,
             tipo_reg)
        SELECT
            count(*) as cant_reg,
            process_date, client_id, trim(upper(custodian)) as custodian, trim(account_no) as account_no,
            trim(cusip) as cusip, trim(isin) as isin, trim(symbol) as symbol, trim(activity_code) as source_code, trim(activity_description) as activity_description,
            trim(id_tipo_activo) as id_tipo_activo, trim(id_sub_tipo_activo) as id_sub_tipo_activo, trim(id_sub_sub_tipo_activo) as id_sub_sub_tipo_activo, trim(currency) as currency,
            sum(quantity) as sum_quantity, sum(net_amount) as sum_net_amount, sum(principal) as sum_principal, sum(usde_net_amount) as sum_usde_net_amount,
            'RET'::VARCHAR(100) as tipo_reg
        FROM public.vw_reporte_maestro_datos_movimientos
        WHERE process_date  >= _process_date_from
        AND aplica_flujo_neto=1
        AND usde_net_amount<0
        GROUP BY process_date, client_id, trim(upper(custodian)), trim(account_no), trim(cusip), trim(isin), trim(symbol), trim(activity_code), trim(activity_description), trim(id_tipo_activo), trim(id_sub_tipo_activo), trim(id_sub_sub_tipo_activo), trim(currency)
        ORDER BY 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14;



        RAISE NOTICE 'Limpiando saldos no positivos iniciales... [%]', timeofday();

        CREATE TEMP TABLE temptb_first_process_date AS
            SELECT
                tb_start_date.client_id, min(tb_start_date.process_date) as first_process_date
            FROM
            (
                select process_date, client_id, sum(sum_usde_market_value) as sum_usde_market_value
                from rep_inv.base_saldos_diarios
                group by process_date, client_id
            ) as tb_start_date
            where tb_start_date.sum_usde_market_value>0
            group by tb_start_date.client_id
            ;


        --Borra los registros que no tienen ningún saldo positivo
        DELETE FROM rep_inv.base_saldos_diarios
        WHERE client_id NOT IN (SELECT client_id FROM temptb_first_process_date);

        --Borra los registros que no tienen ningún saldo positivo
        DELETE FROM rep_inv.base_movimientos_diarios
        WHERE client_id NOT IN (SELECT client_id FROM temptb_first_process_date);

        --Borra los registros para clientes que inician con saldo negativo (deja desde el primer día con saldo positivo)
        DELETE FROM rep_inv.base_saldos_diarios
        USING temptb_first_process_date
        WHERE rep_inv.base_saldos_diarios.client_id = temptb_first_process_date.client_id
        AND rep_inv.base_saldos_diarios.process_date < temptb_first_process_date.first_process_date;

        --Borra los registros para clientes que inician con saldo negativo (deja desde el primer día con saldo positivo)
        DELETE FROM rep_inv.base_movimientos_diarios
        USING temptb_first_process_date
        WHERE rep_inv.base_movimientos_diarios.client_id = temptb_first_process_date.client_id
        AND rep_inv.base_movimientos_diarios.process_date < temptb_first_process_date.first_process_date;


        RAISE NOTICE 'Creando base agregada... [%]', timeofday();

        CREATE TEMP TABLE temptb_base_agregada AS
            (
            SELECT
                process_date,
                public.fn_fecha_string_to_date(process_date, 'YYYYMMDD'::character varying) AS process_date_as_date,
                client_id as agregador_n1,
                custodian||'||'||account_no as agregador_n2,
                id_sub_sub_tipo_activo as agregador_n3,
                cusip as agregador_n4,
                sum(saldo_dia) as saldo_dia,
                sum(abonos_dia) as abonos_dia,
                sum(retiros_dia) as retiros_dia,
                sum(dividendos_dia) as dividendos_dia,
                sum(comision_devengada) as comision_devengada_dia
            FROM rep_inv.vw_base_consolidado
            WHERE process_date  >= _process_date_from
            group by process_date, client_id, custodian||'||'||account_no, account_no, id_sub_sub_tipo_activo, cusip
            HAVING
                process_date IS NOT NULL
               AND client_id IS NOT NULL
               AND custodian||'||'||account_no IS NOT NULL
               AND id_sub_sub_tipo_activo IS NOT NULL
               AND cusip IS NOT NULL
            ORDER BY 1, 2, 3, 4, 5, 6
        );

        RAISE NOTICE 'Cargando datos desde base agregada... [%]', timeofday();


        INSERT INTO rep_inv.consolidado_agregado_n1
            (process_date, process_date_as_date, agregador_n1, saldo_dia, abonos_dia, retiros_dia, dividendos_dia, comision_devengada_dia)
        SELECT
            process_date, process_date_as_date, agregador_n1, sum(saldo_dia) as saldo_dia, sum(abonos_dia) as abonos_dia, sum(retiros_dia) as retiros_dia, sum(dividendos_dia) as dividendos_dia, sum(comision_devengada_dia) as comision_devengada
        FROM temptb_base_agregada
        GROUP BY process_date, process_date_as_date, agregador_n1
        ORDER BY process_date, process_date_as_date, agregador_n1
        ;


        INSERT INTO rep_inv.consolidado_agregado_n2
            (process_date, process_date_as_date, agregador_n1, agregador_n2, saldo_dia, abonos_dia, retiros_dia, dividendos_dia, comision_devengada_dia)
        SELECT
            process_date, process_date_as_date, agregador_n1, agregador_n2, sum(saldo_dia) as saldo_dia, sum(abonos_dia) as abonos_dia, sum(retiros_dia) as retiros_dia, sum(dividendos_dia) as dividendos_dia, sum(comision_devengada_dia) as comision_devengada
        FROM temptb_base_agregada
        GROUP BY process_date, process_date_as_date, agregador_n1, agregador_n2
        ORDER BY process_date, process_date_as_date, agregador_n1, agregador_n2
        ;


        INSERT INTO rep_inv.consolidado_agregado_n3
            (process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3, saldo_dia, abonos_dia, retiros_dia, dividendos_dia, comision_devengada_dia)
        SELECT
            process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3, sum(saldo_dia) as saldo_dia, sum(abonos_dia) as abonos_dia, sum(retiros_dia) as retiros_dia, sum(dividendos_dia) as dividendos_dia, sum(comision_devengada_dia) as comision_devengada
        FROM temptb_base_agregada
        GROUP BY process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3
        ORDER BY process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3
        ;


        INSERT INTO rep_inv.consolidado_agregado_n4
            (process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4, saldo_dia, abonos_dia, retiros_dia, dividendos_dia, comision_devengada_dia)
        SELECT
            process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4, sum(saldo_dia) as saldo_dia, sum(abonos_dia) as abonos_dia, sum(retiros_dia) as retiros_dia, sum(dividendos_dia) as dividendos_dia, sum(comision_devengada_dia) as comision_devengada
        FROM temptb_base_agregada
        GROUP BY process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4
        ORDER BY process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4
        ;



        RAISE NOTICE 'Calculando saldo día anterior N1... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n1 data_t0
        SET saldo_dia_anterior= COALESCE((SELECT sum(saldo_dia)
                                          FROM rep_inv.consolidado_agregado_n1 data_tmenos1
                                          WHERE data_tmenos1.process_date_as_date   = data_t0.process_date_as_date - 1
                                            AND data_tmenos1.agregador_n1           = data_t0.agregador_n1), 0)
        WHERE data_t0.process_date  >= _process_date_from
        ;


        RAISE NOTICE 'Calculando saldo día anterior N2... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n2 data_t0
        SET saldo_dia_anterior= COALESCE((SELECT sum(saldo_dia)
                                          FROM rep_inv.consolidado_agregado_n2 data_tmenos1
                                          WHERE data_tmenos1.process_date_as_date   = data_t0.process_date_as_date - 1
                                            AND data_tmenos1.agregador_n1           = data_t0.agregador_n1
                                            AND data_tmenos1.agregador_n2           = data_t0.agregador_n2), 0)
        WHERE data_t0.process_date  >= _process_date_from
        ;


        RAISE NOTICE 'Calculando saldo día anterior N3... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n3 data_t0
        SET saldo_dia_anterior= COALESCE((SELECT sum(saldo_dia)
                                          FROM rep_inv.consolidado_agregado_n3 data_tmenos1
                                          WHERE data_tmenos1.process_date_as_date   = data_t0.process_date_as_date - 1
                                            AND data_tmenos1.agregador_n1           = data_t0.agregador_n1
                                            AND data_tmenos1.agregador_n2           = data_t0.agregador_n2
                                            AND data_tmenos1.agregador_n3           = data_t0.agregador_n3), 0)
        WHERE data_t0.process_date  >= _process_date_from
        ;


        RAISE NOTICE 'Calculando saldo día anterior N4... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n4 data_t0
        SET saldo_dia_anterior= COALESCE((SELECT sum(saldo_dia)
                                          FROM rep_inv.consolidado_agregado_n4 data_tmenos1
                                          WHERE data_tmenos1.process_date_as_date   = data_t0.process_date_as_date - 1
                                            AND data_tmenos1.agregador_n1           = data_t0.agregador_n1
                                            AND data_tmenos1.agregador_n2           = data_t0.agregador_n2
                                            AND data_tmenos1.agregador_n3           = data_t0.agregador_n3
                                            AND data_tmenos1.agregador_n4           = data_t0.agregador_n4), 0)
        WHERE data_t0.process_date  >= _process_date_from
        ;



        RAISE NOTICE 'Calculando utilidades y rentabilidades N1... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n1
        SET
            --Dividendos ya están considerados en saldos... se duplciaría
            utilidad= saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior,
            rentabilidad= CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END,
            rentabilidad_base_pitatoria= (CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END)+1,
            saldo_rentabilidad  = CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE ( (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior ) * saldo_dia_anterior END
        WHERE process_date  >= _process_date_from;

        RAISE NOTICE 'Calculando utilidades y rentabilidades N2... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n2
        SET
            --Dividendos ya están considerados en saldos... se duplciaría
            utilidad= saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior,
            rentabilidad= CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END,
            rentabilidad_base_pitatoria= (CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END)+1,
            saldo_rentabilidad  = CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE ( (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior ) * saldo_dia_anterior END
        WHERE process_date  >= _process_date_from;

        RAISE NOTICE 'Calculando utilidades y rentabilidades N3... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n3
        SET
            --Dividendos ya están considerados en saldos... se duplciaría
            utilidad= saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior,
            rentabilidad= CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END,
            rentabilidad_base_pitatoria= (CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END)+1,
            saldo_rentabilidad  = CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE ( (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior ) * saldo_dia_anterior END
        WHERE process_date  >= _process_date_from;

        RAISE NOTICE 'Calculando utilidades y rentabilidades N4... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n4
        SET
            --Dividendos ya están considerados en saldos... se duplciaría
            utilidad= saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior,
            rentabilidad= CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END,
            rentabilidad_base_pitatoria= (CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END)+1,
            saldo_rentabilidad  = CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE ( (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior ) * saldo_dia_anterior END
        WHERE process_date  >= _process_date_from;



        RAISE NOTICE 'Finalizando PA... [%]', timeofday();
        DROP TABLE IF EXISTS temptb_base_agregada;
        DROP TABLE IF EXISTS temptb_first_process_date;

        return _output;
    END;
$$;


create or replace function rep_inv.fn_control_saldo_dia_negativo(_process_date character varying)
    returns TABLE(id_control integer, glosa_control character varying, descripcion_control character varying, process_date character varying, identificador character varying, cant_reg integer)
    language plpgsql
as
$$
DECLARE _id_control integer                     := 2;
DECLARE _glosa_control VARCHAR(1000)            := 'Saldo Diario Negativo';
DECLARE _descripcion_control_base VARCHAR(1000) := 'Saldo del día actual o anterior negativo';
--Otras variables auxiliares
    BEGIN


    RETURN QUERY
        SELECT DISTINCT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            _descripcion_control_base as descripcion_control,
            tb_n1.process_date::VARCHAR(100),
            tb_n1.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
            from rep_inv.consolidado_agregado_n1 tb_n1
            WHERE tb_n1.process_date=COALESCE(_process_date, tb_n1.process_date)
            AND (tb_n1.saldo_dia<0 OR tb_n1.saldo_dia_anterior<0)
            GROUP BY tb_n1.process_date, tb_n1.agregador_n1
            ORDER BY tb_n1.process_date, tb_n1.agregador_n1
    ;
    RETURN;
    END;
$$;

create or replace function rep_inv.fn_control_agregadores_invalidos(_process_date character varying)
    returns TABLE(id_control integer, glosa_control character varying, descripcion_control character varying, process_date character varying, identificador character varying, cant_reg integer)
    language plpgsql
as
$$
DECLARE _id_control integer                     := 3;
DECLARE _glosa_control VARCHAR(1000)            := 'Agregadores no válidos';
DECLARE _descripcion_control_base VARCHAR(1000) := 'Campos de agregación con valores no válidos';
--Otras variables auxiliares
    BEGIN


    RETURN QUERY
        SELECT DISTINCT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||' (Saldos)')::VARCHAR(1000) as descripcion_control,
            tb_n1.process_date::VARCHAR(100),
            ('Client-ID:'||COALESCE(tb_n1.client_id, '')||'||Custodian:'||COALESCE(tb_n1.custodian, '')||'||Account:'||COALESCE(tb_n1.account_no, '')||'||Cusip:'||COALESCE(tb_n1.cusip, ''))::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
            from rep_inv.base_saldos_diarios tb_n1
            WHERE tb_n1.process_date=COALESCE(_process_date, tb_n1.process_date)
            AND (tb_n1.client_id IS NULL OR tb_n1.account_no IS NULL OR tb_n1.custodian IS NULL or tb_n1.cusip IS NULL)
            GROUP BY tb_n1.process_date,
                     ('Client-ID:'||COALESCE(tb_n1.client_id, '')||'||Custodian:'||COALESCE(tb_n1.custodian, '')||'||Account:'||COALESCE(tb_n1.account_no, '')||'||Cusip:'||COALESCE(tb_n1.cusip, ''))::VARCHAR(100)
            ORDER BY tb_n1.process_date,
                     ('Client-ID:'||COALESCE(tb_n1.client_id, '')||'||Custodian:'||COALESCE(tb_n1.custodian, '')||'||Account:'||COALESCE(tb_n1.account_no, '')||'||Cusip:'||COALESCE(tb_n1.cusip, ''))::VARCHAR(100)
    ;
    RETURN QUERY
        SELECT DISTINCT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||' (Movimientos)')::VARCHAR(1000) as descripcion_control,
            tb_n1.process_date::VARCHAR(100),
            ('Client-ID:'||COALESCE(tb_n1.client_id, '')||'||Custodian:'||COALESCE(tb_n1.custodian, '')||'||Account:'||COALESCE(tb_n1.account_no, '')||'||Cusip:'||COALESCE(tb_n1.cusip, ''))::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
            from rep_inv.base_movimientos_diarios tb_n1
            WHERE tb_n1.process_date=COALESCE(_process_date, tb_n1.process_date)
            AND (tb_n1.client_id IS NULL OR tb_n1.account_no IS NULL OR tb_n1.custodian IS NULL or tb_n1.cusip IS NULL)
            GROUP BY tb_n1.process_date,
                     ('Client-ID:'||COALESCE(tb_n1.client_id, '')||'||Custodian:'||COALESCE(tb_n1.custodian, '')||'||Account:'||COALESCE(tb_n1.account_no, '')||'||Cusip:'||COALESCE(tb_n1.cusip, ''))::VARCHAR(100)
            ORDER BY tb_n1.process_date,
                     ('Client-ID:'||COALESCE(tb_n1.client_id, '')||'||Custodian:'||COALESCE(tb_n1.custodian, '')||'||Account:'||COALESCE(tb_n1.account_no, '')||'||Cusip:'||COALESCE(tb_n1.cusip, ''))::VARCHAR(100)

    ;

    RETURN;
    END;
$$;


create or replace function rep_inv.fn_control_rentabilidades_significativas(_process_date character varying, _exec_monthly boolean, _exec_daily boolean)
    returns TABLE(id_control integer, glosa_control character varying, descripcion_control character varying, process_date character varying, identificador character varying, cant_reg integer)
    language plpgsql
as
$$
DECLARE _id_control integer                     := 1;
DECLARE _glosa_control VARCHAR(1000)            := 'Rentabilidades Significativas';
DECLARE _descripcion_control_base VARCHAR(1000) := 'Rentabilidades fuera del rango ';
--Otras variables auxiliares
DECLARE _min_rent_dia numeric(45,20);
DECLARE _max_rent_dia numeric(45,20);
DECLARE _rango_rent_dia VARCHAR(20);
DECLARE _min_rent_1mes numeric(45,20);
DECLARE _max_rent_1mes numeric(45,20);
DECLARE _rango_rent_1mes VARCHAR(20);
DECLARE _min_rent_3meses numeric(45,20);
DECLARE _max_rent_3meses numeric(45,20);
DECLARE _rango_rent_3meses VARCHAR(20);
DECLARE _min_rent_12meses numeric(45,20);
DECLARE _max_rent_12meses numeric(45,20);
DECLARE _rango_rent_12meses VARCHAR(20);
DECLARE _min_rent_ytd numeric(45,20);
DECLARE _max_rent_ytd numeric(45,20);
DECLARE _rango_rent_ytd VARCHAR(20);
DECLARE _min_rent_20meses numeric(45,20);
DECLARE _max_rent_20meses numeric(45,20);
DECLARE _rango_rent_20meses VARCHAR(20);
    BEGIN

    _min_rent_dia       := -0.05;
    _max_rent_dia       := 0.05;
    _rango_rent_dia       := CAST(_min_rent_dia*100 as VARCHAR(5))||'% - '||CAST(_max_rent_dia*100 as VARCHAR(5))||'%';
    _min_rent_1mes      := -0.10;
    _max_rent_1mes      := 0.20;
    _rango_rent_1mes      := CAST(_min_rent_1mes*100 as VARCHAR(5))||'% - '||CAST(_max_rent_1mes*100 as VARCHAR(5))||'%';
    _min_rent_3meses    := -0.15;
    _max_rent_3meses    := 0.40;
    _rango_rent_3meses    := CAST(_min_rent_3meses*100 as VARCHAR(5))||'% - '||CAST(_max_rent_3meses*100 as VARCHAR(5))||'%';
    _min_rent_12meses   := -0.20;
    _max_rent_12meses   := 0.60;
    _rango_rent_12meses   := CAST(_min_rent_12meses*100 as VARCHAR(5))||'% - '||CAST(_max_rent_12meses*100 as VARCHAR(5))||'%';
    _min_rent_ytd       := -0.20;
    _max_rent_ytd       := 0.60;
    _rango_rent_ytd       := CAST(_min_rent_ytd*100 as VARCHAR(5))||'% - '||CAST(_max_rent_ytd*100 as VARCHAR(5))||'%';
    _min_rent_20meses   := -0.20;
    _max_rent_20meses   := 0.60;
    _rango_rent_20meses   := CAST(_min_rent_20meses*100 as VARCHAR(5))||'% - '||CAST(_max_rent_20meses*100 as VARCHAR(5))||'%';

    RAISE NOTICE 'Ejecutando controles de rentabilidades significativas diarios';
    RETURN QUERY
        SELECT DISTINCT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||_rango_rent_dia||' (diaria)')::VARCHAR(1000) as descripcion_control,
            tb_n1.process_date::VARCHAR(100),
            tb_n1.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
            from rep_inv.consolidado_agregado_n1 tb_n1
            WHERE _exec_daily
            AND tb_n1.process_date=COALESCE(_process_date, tb_n1.process_date)
            AND (tb_n1.rentabilidad<_min_rent_dia OR tb_n1.rentabilidad>_max_rent_dia)
            GROUP BY tb_n1.process_date, tb_n1.agregador_n1
            ORDER BY tb_n1.process_date, tb_n1.agregador_n1
    ;

    IF (NOT _exec_monthly) THEN
        RAISE NOTICE 'No se ejecutaran controles de rentabilidades significativas mensuales, finalizando';
        RETURN;
    END IF;
    RAISE NOTICE 'Ejecutando controles de rentabilidades significativas mensuales';

    DROP TABLE IF EXISTS temp_rentabilidades;
    CREATE TEMP TABLE temp_rentabilidades AS
        SELECT *
        FROM rep_inv.fn_calcula_rentabilidad(NULL, nULL, NULL, NULL, _process_date, _process_date) tb_rent
        WHERE tb_rent.nivel='N1'
        AND (
                tb_rent.base3_rentabilidad<_min_rent_1mes OR tb_rent.base3_rentabilidad>_max_rent_1mes OR
                tb_rent.base4_rentabilidad<_min_rent_3meses OR tb_rent.base4_rentabilidad>_max_rent_3meses OR
                tb_rent.base5_rentabilidad<_min_rent_12meses OR tb_rent.base5_rentabilidad>_max_rent_12meses OR
                tb_rent.base6_rentabilidad<_min_rent_ytd OR tb_rent.base6_rentabilidad>_max_rent_ytd OR
                tb_rent.base7_rentabilidad<_min_rent_20meses OR tb_rent.base7_rentabilidad>_max_rent_20meses
            )
    ;

    RETURN QUERY
        SELECT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||_rango_rent_1mes||' (1 mes)')::VARCHAR(1000) as descripcion_control,
            tb_rent.process_date::VARCHAR(100),
            tb_rent.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
        FROM temp_rentabilidades tb_rent
        WHERE
            _exec_monthly AND ( tb_rent.base3_rentabilidad<_min_rent_1mes OR tb_rent.base3_rentabilidad>_max_rent_1mes )
        GROUP BY tb_rent.process_date, tb_rent.agregador_n1
        ORDER BY tb_rent.process_date, tb_rent.agregador_n1
    ;

    RETURN QUERY
        SELECT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||_rango_rent_3meses||' (3 meses)')::VARCHAR(1000) as descripcion_control,
            tb_rent.process_date::VARCHAR(100),
            tb_rent.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
        FROM temp_rentabilidades tb_rent
        WHERE
            _exec_monthly AND ( tb_rent.base4_rentabilidad<_min_rent_3meses OR tb_rent.base4_rentabilidad>_max_rent_3meses )
        GROUP BY tb_rent.process_date, tb_rent.agregador_n1
        ORDER BY tb_rent.process_date, tb_rent.agregador_n1
    ;

    RETURN QUERY
        SELECT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||_rango_rent_12meses||' (12 meses)')::VARCHAR(1000) as descripcion_control,
            tb_rent.process_date::VARCHAR(100),
            tb_rent.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
        FROM temp_rentabilidades tb_rent
        WHERE
            _exec_monthly AND ( tb_rent.base5_rentabilidad<_min_rent_12meses OR tb_rent.base5_rentabilidad>_max_rent_12meses )
        GROUP BY tb_rent.process_date, tb_rent.agregador_n1
        ORDER BY tb_rent.process_date, tb_rent.agregador_n1
    ;

    RETURN QUERY
        SELECT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||CAST(_max_rent_ytd*100 as VARCHAR(5))||'% (YTD)')::VARCHAR(1000) as descripcion_control,
            tb_rent.process_date::VARCHAR(100),
            tb_rent.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
        FROM temp_rentabilidades tb_rent
        WHERE
            _exec_monthly AND ( tb_rent.base6_rentabilidad<_min_rent_ytd OR tb_rent.base6_rentabilidad>_max_rent_ytd )
        GROUP BY tb_rent.process_date, tb_rent.agregador_n1
        ORDER BY tb_rent.process_date, tb_rent.agregador_n1
    ;

    RETURN QUERY
        SELECT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||_rango_rent_20meses||' (20 meses)')::VARCHAR(1000) as descripcion_control,
            tb_rent.process_date::VARCHAR(100),
            tb_rent.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
        FROM temp_rentabilidades tb_rent
        WHERE
            _exec_monthly AND ( tb_rent.base7_rentabilidad<_min_rent_20meses OR tb_rent.base7_rentabilidad>_max_rent_20meses )
        GROUP BY tb_rent.process_date, tb_rent.agregador_n1
        ORDER BY tb_rent.process_date, tb_rent.agregador_n1
    ;

    RETURN;
    END;
$$;


create or replace function rep_inv.fn_control(_process_date character varying, _exec_monthly boolean, _exec_daily boolean)
    returns TABLE(id bigint, id_control integer, glosa_control character varying, descripcion_control character varying, process_date character varying, identificador character varying, cant_reg integer)
    language plpgsql
as
$$
DECLARE _timestamp_reg timestamp;
DECLARE _timestamp_proceso timestamp;
    BEGIN
        _timestamp_proceso  := clock_timestamp();
        _timestamp_reg      := _timestamp_proceso;
        if (_exec_monthly IS NULL) THEN
            _exec_monthly := COALESCE((
                SELECT dia_del_mes=1 from public.vw_calendario
                where fecha_as_str>_process_date
                ORDER BY fecha_as_date ASC
                LIMIT 1
                ), false);
        END IF;
        IF (_exec_daily IS NULL) THEN
            _exec_daily := TRUE;
        END IF;

        DROP TABLE IF EXISTS temp_control;
        CREATE TEMP TABLE temp_control (
            id_control integer, glosa_control VARCHAR (1000), descripcion_control VARCHAR (1000), process_date VARCHAR (100), identificador VARCHAR (100), cant_reg integer
        );

        --Control 01
        _timestamp_reg  :=  clock_timestamp();
        RAISE NOTICE 'Ejecutando control 01...';
        INSERT INTO temp_control (id_control, glosa_control, descripcion_control, process_date, identificador, cant_reg)
        SELECT FN_CTRL_01.id_control, FN_CTRL_01.glosa_control, FN_CTRL_01.descripcion_control, FN_CTRL_01.process_date, FN_CTRL_01.identificador, FN_CTRL_01.cant_reg
        FROM rep_inv.fn_control_rentabilidades_significativas(_process_date, _exec_monthly, _exec_daily) as FN_CTRL_01;
        RAISE NOTICE 'Control 01 ejecutado [%]', clock_timestamp()-_timestamp_reg;


        --Control 02
        IF (FALSE) THEN
            RAISE NOTICE 'Saltando control 02 Rep Inv';
        ELSE
            _timestamp_reg  :=  clock_timestamp();
            RAISE NOTICE 'Ejecutando control 02...';
            INSERT INTO temp_control (id_control, glosa_control, descripcion_control, process_date, identificador, cant_reg)
            SELECT FN_CTRL_02.id_control,FN_CTRL_02.glosa_control,FN_CTRL_02.descripcion_control,FN_CTRL_02.process_date,FN_CTRL_02.identificador,FN_CTRL_02.cant_reg
            FROM rep_inv.fn_control_saldo_dia_negativo(_process_date) as FN_CTRL_02;
            RAISE NOTICE 'Control 02 ejecutado [%]', clock_timestamp()-_timestamp_reg;
        END IF;


        --Control 03
        IF (FALSE) THEN
            RAISE NOTICE 'Saltando control 03 Rep Inv';
        ELSE
            _timestamp_reg  :=  clock_timestamp();
            RAISE NOTICE 'Ejecutando control 03...';
            INSERT INTO temp_control (id_control, glosa_control, descripcion_control, process_date, identificador, cant_reg)
            SELECT FN_CTRL_03.id_control,FN_CTRL_03.glosa_control,FN_CTRL_03.descripcion_control,FN_CTRL_03.process_date,FN_CTRL_03.identificador,FN_CTRL_03.cant_reg
            FROM rep_inv.fn_control_agregadores_invalidos(_process_date) as FN_CTRL_03;
            RAISE NOTICE 'Control 03 ejecutado [%]', clock_timestamp()-_timestamp_reg;
        END IF;



    RETURN QUERY
        SELECT
            (ROW_NUMBER() OVER())::bigint as id,
            TB_CD.id_control, TB_CD.glosa_control, TB_CD.descripcion_control, TB_CD.process_date, TB_CD.identificador, TB_CD.cant_reg
        FROM temp_control TB_CD
        ORDER BY TB_CD.id_control, TB_CD.process_date DESC,
                 TB_CD.identificador ASC, TB_CD.cant_reg ASC
        ;

    RETURN;
    END;
$$;



select min(process_date), max(process_date) from public.vw_reporte_maestro_datos_saldos;
select min(process_date), max(process_date) from public.vw_reporte_maestro_datos_movimientos;



SELECT * FROM rep_inv.fn_precalculo_diario('20240101');

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



