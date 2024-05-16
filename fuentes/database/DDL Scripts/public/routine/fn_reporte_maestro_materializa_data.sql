create or replace function public.fn_reporte_maestro_materializa_data(_process_date character varying, _tipo_maestro character varying, _custodio character varying) returns bigint
    language plpgsql
as
$$
DECLARE _row_count  BIGINT;


    BEGIN

    IF (_tipo_maestro NOT IN ('CTA', 'SLD', 'MOV') ) THEN
        RAISE NOTICE 'Tipo de maestro no válido [%]', _tipo_maestro;
        return -1;
    end if;

    IF (_custodio NOT IN ('PERSHING') ) THEN
        RAISE NOTICE 'Custodio no válido [%]', _custodio;
        return -2;
    end if;

    IF (_tipo_maestro='CTA') THEN
        IF (_custodio ='PERSHING') THEN
            DELETE FROM public.tbvw_maestro_cuentas_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_cuentas_pershing SELECT * FROM public.vw_maestro_cuentas_pershing where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;
            RETURN _row_count;
        END IF;
    END IF;


    IF (_tipo_maestro='SLD') THEN
        IF (_custodio ='PERSHING') THEN
            DELETE FROM public.tbvw_maestro_saldos_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_saldos_pershing SELECT * FROM public.vw_maestro_saldos_pershing where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;
            RETURN _row_count;
        END IF;
    END IF;


    IF (_tipo_maestro='MOV') THEN
        IF (_custodio ='PERSHING') THEN
            DELETE FROM public.tbvw_maestro_movimientos_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_movimientos_pershing SELECT * FROM public.vw_maestro_movimientos_pershing where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;
            RETURN _row_count;
        END IF;
    END IF;

    return NULL::BIGINT;
    END;
$$;

alter function public.fn_reporte_maestro_materializa_data(varchar, varchar, varchar) owner to postgres;

