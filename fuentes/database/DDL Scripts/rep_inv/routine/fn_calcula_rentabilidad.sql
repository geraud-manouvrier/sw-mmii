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

alter function rep_inv.fn_calcula_rentabilidad(varchar, varchar, varchar, varchar, varchar, varchar) owner to postgres;

