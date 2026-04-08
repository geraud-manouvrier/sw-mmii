/*
2026-04-08
Actual: 14.0.0-COL
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


--========================================================================
--========================================================================
--========================================================================
--Eliminación cliente mal creado

select * from clientes.cliente where cliente.identificador='52148107';
select * from clientes.cuenta where cuenta.id_cliente=392;
--Respaldamos
select * into zz_backup.cliente_20260330 from clientes.cliente;
delete from clientes.cliente where identificador='52148107';

select * from clientes.cliente where cliente.identificador='52148107';

--========================================================================
--========================================================================
--========================================================================
--
INSERT INTO public.par_feriado (dia, es_habil_pershing, es_habil_stonex, observaciones)
VALUES ('2026-04-03', false, false, 'Good Friday');





--========================================================================
--========================================================================
--========================================================================
-- Registros maestros duplicados
/*
En saldos para fechas (6547 reg):
20250518, 19, 20, 21
20260310, 17

En movimientos:

En cuentas para fechas (1213 reg):
20250518, 19, 20
20260310, 17

*/
select count(*),
       tb_sld.process_date, tb_sld.client_id, tb_sld.account_no,
       tb_sld.cusip, tb_sld.symbol, tb_sld.isin_code, tb_sld.cash_margin_account, tb_sld.product_type, tb_sld.currency,
       tb_sld.quantity
from public.tbvw_maestro_saldos_pershing tb_sld
group by
       tb_sld.process_date, tb_sld.client_id, tb_sld.account_no,
       tb_sld.cusip, tb_sld.symbol, tb_sld.isin_code, tb_sld.cash_margin_account, tb_sld.product_type, tb_sld.currency,
       tb_sld.quantity
having count(*)<>1
;

select * into zz_backup.tbvw_maestro_saldos_pershing_20260407
FROM public.tbvw_maestro_saldos_pershing
;

WITH duplicados AS (
    SELECT
        ctid,
        process_date, client_id, account_no,
        cusip, symbol, isin_code, quantity,
        row_number() OVER (
            PARTITION BY
                process_date, client_id, account_no,
                cusip, symbol, isin_code, quantity
            ORDER BY ctid
        ) AS rn
    FROM public.tbvw_maestro_saldos_pershing
)
/*
SELECT *
FROM duplicados
WHERE rn > 1;
*/
DELETE FROM public.tbvw_maestro_saldos_pershing t
USING duplicados d
WHERE t.ctid = d.ctid
  AND d.rn > 1;


--Verificamos
select count(*),
       tb_sld.process_date, tb_sld.client_id, tb_sld.account_no,
       tb_sld.cusip, tb_sld.symbol, tb_sld.isin_code, tb_sld.cash_margin_account, tb_sld.product_type, tb_sld.currency,
       tb_sld.quantity
from public.tbvw_maestro_saldos_pershing tb_sld
group by
       tb_sld.process_date, tb_sld.client_id, tb_sld.account_no,
       tb_sld.cusip, tb_sld.symbol, tb_sld.isin_code, tb_sld.cash_margin_account, tb_sld.product_type, tb_sld.currency,
       tb_sld.quantity
having count(*)<>1
;

WITH duplicados AS (
    SELECT
        ctid,
        process_date, client_id, account_no,
        cusip, symbol, isin_code, quantity,
        row_number() OVER (
            PARTITION BY
                process_date, client_id, account_no,
                cusip, symbol, isin_code, quantity
            ORDER BY ctid
        ) AS rn
    FROM public.tbvw_maestro_saldos_pershing
)
SELECT *
FROM duplicados
WHERE rn > 1;

--Movimientos:

select count(*),
       tb_mov.process_date,tb_mov.client_id,tb_mov.account_no,
       tb_mov.cusip,tb_mov.symbol,tb_mov.isin,tb_mov.product_type,tb_mov.currency,
       tb_mov.source_code,tb_mov.activity_code,
       tb_mov.quantity,tb_mov.price,tb_mov.principal,tb_mov.activity_description,tb_mov.security_description,
       tb_mov.description_1, tb_mov.description_2, tb_mov.description_3
from public.tbvw_maestro_movimientos_pershing tb_mov
group by
       tb_mov.process_date, tb_mov.client_id, tb_mov.account_no,
       tb_mov.cusip, tb_mov.symbol, tb_mov.isin, tb_mov.product_type, tb_mov.currency,
       tb_mov.source_code, tb_mov.activity_code,
       tb_mov.quantity, tb_mov.price, tb_mov.principal, tb_mov.activity_description, tb_mov.security_description,
       tb_mov.description_1, tb_mov.description_2, tb_mov.description_3
having count(*)<>1
;
--Ok movimientos, cuadrados contra ambiente RIA


--Cuentas

select count(*),
       tb_cta.process_date, tb_cta.client_id, tb_cta.account_no
from public.tbvw_maestro_cuentas_pershing tb_cta
group by
       tb_cta.process_date, tb_cta.client_id, tb_cta.account_no
having count(*)<>1
;


select * into zz_backup.tbvw_maestro_cuentas_pershing_20260407
FROM public.tbvw_maestro_cuentas_pershing
;

WITH duplicados AS (
    SELECT
        ctid,
        process_date, client_id, account_no,
        row_number() OVER (
            PARTITION BY
                process_date, client_id, account_no
            ORDER BY ctid
        ) AS rn
    FROM public.tbvw_maestro_cuentas_pershing
)
/*
SELECT *
FROM duplicados
WHERE rn > 1;
*/
DELETE FROM public.tbvw_maestro_cuentas_pershing t
USING duplicados d
WHERE t.ctid = d.ctid
  AND d.rn > 1;


--Verificamos

select count(*),
       tb_cta.process_date, tb_cta.client_id, tb_cta.account_no
from public.tbvw_maestro_cuentas_pershing tb_cta
group by
       tb_cta.process_date, tb_cta.client_id, tb_cta.account_no
having count(*)<>1
;

WITH duplicados AS (
    SELECT
        ctid,
        process_date, client_id, account_no,
        row_number() OVER (
            PARTITION BY
                process_date, client_id, account_no
            ORDER BY ctid
        ) AS rn
    FROM public.tbvw_maestro_cuentas_pershing
)
SELECT *
FROM duplicados
WHERE rn > 1;

--Reprocesar rentabilidades y archivos maestros sin materializar
select *
from rep_inv.fn_precalculo_diario('20250518');


DROP function rep_inv.fn_calcula_rentabilidad;
DROP TABLE rep_inv.rentabilidad_calculada;

create table rep_inv.rentabilidad_calculada
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
    base1_rentabilidad_anualizada   numeric(45, 20),
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
    base2_rentabilidad_anualizada   numeric(45, 20),
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
    base3_rentabilidad_anualizada   numeric(45, 20),
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
    base4_rentabilidad_anualizada   numeric(45, 20),
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
    base5_rentabilidad_anualizada   numeric(45, 20),
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
    base6_rentabilidad_anualizada   numeric(45, 20),
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
    base7_rentabilidad_anualizada   numeric(45, 20),
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
    base8_rentabilidad_anualizada   numeric(45, 20),
    base8_dias_con_saldo            integer,
    base8_suma_saldos_iniciales     numeric(45, 20),
    base8_suma_saldo_rentabilidad   numeric(45, 20),
    base8_rentabilidad_ponderada_cl numeric(45, 20),
    base8_rentabilidad_periodo_cl   numeric(45, 20),
    base8_cant_reg                  integer
);


create index rentabildiad_calculada_main_index
    on rep_inv.rentabilidad_calculada (process_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4);

create or replace function rep_inv.fn_calcula_rentabilidad(_agregador_n1 character varying, _agregador_n2 character varying, _agregador_n3 character varying, _agregador_n4 character varying, _start_process_date character varying, _end_process_date character varying) returns SETOF rep_inv.rentabilidad_calculada
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
    1dia        1 día
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
    INSERT INTO temptb_consolidado_agregado
    (
        nivel, sub_nivel, process_date, process_date_as_date,
        agregador_n1, agregador_n2, agregador_n3, agregador_n4,
        saldo_dia_anterior, abonos_dia, retiros_dia, dividendos_dia, saldo_dia,
        comision_devengada_dia, utilidad, rentabilidad, rentabilidad_base_pitatoria, saldo_rentabilidad
    )
    SELECT
        'N2'::VARCHAR(100) as nivel,
        rank() OVER (ORDER BY tbn.process_date, tbn.agregador_n1, tbn.agregador_n2)::BIGINT as sub_nivel,
        tbn.process_date, tbn.process_date_as_date,
        tbn.agregador_n1, tbn.agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4,
        tbn.saldo_dia_anterior, tbn.abonos_dia, tbn.retiros_dia, tbn.dividendos_dia, tbn.saldo_dia,
        tbn.comision_devengada_dia,
        tbn.utilidad, tbn.rentabilidad, tbn.rentabilidad_base_pitatoria, tbn.saldo_rentabilidad
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
            (power((1+(tb_calc.det_rent_inioper).rentabilidad_periodo), (365.0/(tb_calc.det_rent_inioper).dias_con_saldo))-1)::NUMERIC(45,20) as base1_rentabilidad_anualizada,
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
            (power((1+(tb_calc.det_rent_aper).rentabilidad_periodo), (365.0/(tb_calc.det_rent_aper).dias_con_saldo))-1)::NUMERIC(45,20) as base2_rentabilidad_anualizada,
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
            (power((1+(tb_calc.det_rent_1m).rentabilidad_periodo), (365.0/(tb_calc.det_rent_1m).dias_con_saldo))-1)::NUMERIC(45,20) as base3_rentabilidad_anualizada,
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
            (power((1+(tb_calc.det_rent_3m).rentabilidad_periodo), (365.0/(tb_calc.det_rent_3m).dias_con_saldo))-1)::NUMERIC(45,20) as base4_rentabilidad_anualizada,
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
            (power((1+(tb_calc.det_rent_12m).rentabilidad_periodo), (365.0/(tb_calc.det_rent_12m).dias_con_saldo))-1)::NUMERIC(45,20) as base5_rentabilidad_anualizada,
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
            (power((1+(tb_calc.det_rent_ytd).rentabilidad_periodo), (365.0/(tb_calc.det_rent_ytd).dias_con_saldo))-1)::NUMERIC(45,20) as base6_rentabilidad_anualizada,
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
            (power((1+(tb_calc.det_rent_20m).rentabilidad_periodo), (365.0/(tb_calc.det_rent_20m).dias_con_saldo))-1)::NUMERIC(45,20) as base7_rentabilidad_anualizada,
            (tb_calc.det_rent_20m).dias_con_saldo as base7_dias_con_saldo,
            (tb_calc.det_rent_20m).suma_saldos_iniciales as base7_suma_saldos_iniciales,
            (tb_calc.det_rent_20m).suma_saldo_rentabilidad as base7_suma_saldo_rentabilidad,
            (tb_calc.det_rent_20m).rentabilidad_ponderada_cl as base7_rentabilidad_ponderada_cl,
            (tb_calc.det_rent_20m).rentabilidad_periodo_cl as base7_rentabilidad_periodo_cl,
            (tb_calc.det_rent_20m).cant_reg as base7_cant_reg,
            --1 día
            tb_calc.start_date_1d as base8_start_date,
            (tb_calc.det_rent_1d).fecha_desde as base8_fecha_desde,
            (tb_calc.det_rent_1d).fecha_hasta as base8_fecha_hasta,
            (tb_calc.det_rent_1d).rentabilidad_periodo as base8_rentabilidad,
            (power((1+(tb_calc.det_rent_1d).rentabilidad_periodo), (365.0/(tb_calc.det_rent_1d).dias_con_saldo))-1)::NUMERIC(45,20) as base8_rentabilidad_anualizada,
            (tb_calc.det_rent_1d).dias_con_saldo as base8_dias_con_saldo,
            (tb_calc.det_rent_1d).suma_saldos_iniciales as base8_suma_saldos_iniciales,
            (tb_calc.det_rent_1d).suma_saldo_rentabilidad as base8_suma_saldo_rentabilidad,
            (tb_calc.det_rent_1d).rentabilidad_ponderada_cl as base8_rentabilidad_ponderada_cl,
            (tb_calc.det_rent_1d).rentabilidad_periodo_cl as base8_rentabilidad_periodo_cl,
            (tb_calc.det_rent_1d).cant_reg as base8_cant_reg
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
                    tb_base.start_date_1d,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_inioper, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_inioper,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_aper, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_aper,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_1m, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_1m,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_3m, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_3m,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_12m, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_12m,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_ytd, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_ytd,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_20m, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_20m,
                    (rep_inv.fn_calculo_rentabilidad_agregada(tb_base.start_date_1d, tb_base.process_date_as_date, tb_base.agregador_n1, tb_base.agregador_n2, tb_base.agregador_n3, tb_base.agregador_n4)) as det_rent_1d
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
                            rep_inv.fn_start_date_for_metric(tbn.process_date_as_date, '20M') as start_date_20m,
                            rep_inv.fn_start_date_for_metric(tbn.process_date_as_date, '1D') as start_date_1d
                        FROM temptb_consolidado_agregado tbn
                    ) as tb_base
            ) as tb_calc
    ;

    DROP TABLE IF EXISTS temptb_consolidado_agregado;

    RETURN;
END;
$$;

create or replace function rep_inv.fn_calculo_rentabilidad_agregada(_date_ini date, _date_fin date, _agregador_n1 character varying, _agregador_n2 character varying, _agregador_n3 character varying, _agregador_n4 character varying) returns SETOF rep_inv.reg_rent
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
        tb_calc.suma_saldos_iniciales::NUMERIC(45,20), tb_calc.suma_saldo_rentabilidad::NUMERIC(45,20),
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



--========================================================================
--========================================================================
--========================================================================
--



