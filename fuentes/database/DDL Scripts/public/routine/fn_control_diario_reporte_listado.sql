create or replace function public.fn_control_diario_reporte_listado(_process_date_from character varying, _process_date_to character varying, _correlativo integer) returns SETOF control_diario
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
        SELECT *
        FROM public.control_diario REP_CD
        WHERE REP_CD.process_date       >= _process_date_from
        AND REP_CD.process_date         <= _process_date_to
        AND REP_CD.correlativo_diario   = COALESCE(_correlativo, REP_CD.correlativo_diario)
        ORDER BY REP_CD.process_date ASC, REP_CD.correlativo_diario ASC, REP_CD.id_control, REP_CD.identificador ASC, REP_CD.cant_reg ASC
        ;

    RETURN;
    END;
$$;

alter function public.fn_control_diario_reporte_listado(varchar, varchar, integer) owner to postgres;

