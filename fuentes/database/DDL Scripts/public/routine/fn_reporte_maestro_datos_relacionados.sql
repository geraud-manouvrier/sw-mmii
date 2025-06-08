create or replace function public.fn_reporte_maestro_datos_relacionados(_process_date character varying) returns SETOF vw_reporte_maestro_datos_relacionados
    language plpgsql
as
$$
    BEGIN


    RETURN QUERY
    SELECT
        *
    FROM public.vw_reporte_maestro_datos_relacionados vw_rel
    WHERE vw_rel.process_date = _process_date

    ;

    RETURN;
    END;
$$;

alter function public.fn_reporte_maestro_datos_relacionados(varchar) owner to postgres;

