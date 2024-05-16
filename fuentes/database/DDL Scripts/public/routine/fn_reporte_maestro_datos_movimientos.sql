create or replace function public.fn_reporte_maestro_datos_movimientos(_process_date character varying) returns SETOF vw_reporte_maestro_datos_movimientos
    language plpgsql
as
$$
    BEGIN


    RETURN QUERY
    SELECT
        *
    FROM public.vw_reporte_maestro_datos_movimientos vw_mov
    WHERE vw_mov.process_date = _process_date

    ;

    RETURN;
    END;
$$;

alter function public.fn_reporte_maestro_datos_movimientos(varchar) owner to postgres;

