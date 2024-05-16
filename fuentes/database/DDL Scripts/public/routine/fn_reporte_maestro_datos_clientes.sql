create or replace function public.fn_reporte_maestro_datos_clientes(_process_date character varying) returns SETOF vw_reporte_maestro_datos_clientes
    language plpgsql
as
$$
    BEGIN


    RETURN QUERY
    SELECT
        *
    FROM public.vw_reporte_maestro_datos_clientes vw_cte
    WHERE vw_cte.process_date = _process_date

    ;

    RETURN;
    END;
$$;

alter function public.fn_reporte_maestro_datos_clientes(varchar) owner to postgres;

