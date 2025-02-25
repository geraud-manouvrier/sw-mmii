create or replace function rep_inv.fn_rentabilidad(_agregador_n1 character varying, _agregador_n2 character varying, _agregador_n3 character varying, _agregador_n4 character varying, _fecha_desde character varying, _fecha_hasta character varying)
    returns TABLE(row_id character varying, nivel character varying, sub_nivel bigint, process_date character varying, process_date_as_date date, agregador_n1 character varying, agregador_n2 character varying, agregador_n3 character varying, agregador_n4 character varying, saldo_dia numeric, abonos_dia numeric, retiros_dia numeric, dividendos_dia numeric, saldo_dia_anterior numeric, comision_devengada_dia numeric, utilidad numeric, rentabilidad numeric, saldo_rentabilidad numeric, suma_saldo_rentabilidad numeric, suma_saldos_iniciales numeric, primer_dia_con_saldo date, ultimo_dia_con_saldo date, dias_con_saldo integer, rentabilidad_ponderada numeric, rentabilidad_periodo_cl numeric, base1_fecha_desde date, base1_fecha_hasta date, base1_rentabilidad numeric, base2_fecha_desde date, base2_fecha_hasta date, base2_rentabilidad numeric, base3_fecha_desde date, base3_fecha_hasta date, base3_rentabilidad numeric, base4_fecha_desde date, base4_fecha_hasta date, base4_rentabilidad numeric, base5_fecha_desde date, base5_fecha_hasta date, base5_rentabilidad numeric, base6_fecha_desde date, base6_fecha_hasta date, base6_rentabilidad numeric, base7_fecha_desde date, base7_fecha_hasta date, base7_rentabilidad numeric, base8_fecha_desde date, base8_fecha_hasta date, base8_rentabilidad numeric)
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

alter function rep_inv.fn_rentabilidad(varchar, varchar, varchar, varchar, varchar, varchar) owner to postgres;

