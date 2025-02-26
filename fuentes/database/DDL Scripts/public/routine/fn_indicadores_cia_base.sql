create or replace function public.fn_indicadores_cia_base(_start_process_date character varying)
    returns TABLE(periodo integer, agnio integer, mes integer, comdevper numeric, comdevmargen numeric, aummargen numeric, flujoneto numeric, feepromedioreal numeric, feepromediomargen numeric, clientes integer, cuentas integer, diasperiodo integer, firstprocessdate character varying, lastprocessdate character varying)
    language plpgsql
as
$$
DECLARE _last_process_date VARCHAR(100);
    BEGIN

    _last_process_date := (SELECT MAX(process_date) FROM public.vw_reporte_maestro_datos_saldos WHERE process_date >= _start_process_date);

    RETURN QUERY
        SELECT
            base.periodo::INT,
            LEFT(base.periodo, 4)::INT,
            RIGHT(base.periodo, 2)::INT,
            base.comdevper, base.comdevmargen, base.aummargen,
            (
                select sum(mov.usde_net_amount) FROM public.vw_reporte_maestro_datos_movimientos mov
                WHERE mov.process_date>=base.firstProcessDate
                  AND LEFT(mov.process_date, 6)=base.periodo
                  AND mov.aplica_flujo_neto=1
            )::NUMERIC(45,20) as flujoneto,
            CASE WHEN base.aum!=0 AND base.diasperiodo!=0 THEN ( ( base.comdevper*base.diasperiodo ) / base.aum ) END::NUMERIC(45,20) as feepromedioreal,
            CASE WHEN base.aummargen!=0 THEN ( (base.comdevmargen*365) / base.aummargen ) END::NUMERIC(45,20) as feepromediomargen,
            base.clientes::INT, base.cuentas::INT,
            base.diasperiodo::INT,
            base.firstprocessdate::VARCHAR(100),
            base.lastprocessdate::VARCHAR(100)
        FROM (
            SELECT
                LEFT(process_date, 6)                                                          AS periodo,
                SUM(comision_devengada_diaria)                                                 AS comdevper,
                sum(CASE WHEN cal.last_day_of_month OR sld.process_date=_last_process_date THEN comision_devengada_diaria ELSE 0 END) as comdevmargen,
                sum(CASE WHEN cal.last_day_of_month OR sld.process_date=_last_process_date THEN usde_market_value ELSE 0 END)         as aummargen,
                sum(usde_market_value)                                                         as aum,
                count(distinct client_id)                                                      as clientes,
                count(distinct account_no)                                                     as cuentas,
                count(distinct process_date)                                                   as diasperiodo,
                MIN(process_date)                                                              as firstprocessdate,
                MAX(process_date)                                                              as lastprocessdate
            FROM public.vw_reporte_maestro_datos_saldos sld
            INNER JOIN public.vw_calendario cal
                  ON sld.process_date = cal.fecha_as_str
            WHERE process_date >= _start_process_date
            GROUP BY LEFT(process_date, 6)
            ORDER BY LEFT(process_date, 6)
        ) as base
        ;

    RETURN;
    END;
$$;

alter function public.fn_indicadores_cia_base(varchar) owner to postgres;

