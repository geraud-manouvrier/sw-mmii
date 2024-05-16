create or replace function public.fn_reporte_maestro_datos_saldos(_process_date character varying) returns SETOF vw_reporte_maestro_datos_saldos
    language plpgsql
as
$$
    BEGIN


    RETURN QUERY
    SELECT
        *
    FROM public.vw_reporte_maestro_datos_saldos vw_sal
    WHERE vw_sal.process_date = _process_date

    ;

    RETURN;
    END;
$$;

alter function public.fn_reporte_maestro_datos_saldos(varchar) owner to postgres;

