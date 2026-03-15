create or replace function public.fn_distribucion_ingresos(_annual_fee_perc numeric, _process_date character varying)
    returns TABLE(fee_perc_proteccion numeric, fee_perc_ria numeric)
    language plpgsql
as
$$
DECLARE
    _fee_perc_proteccion numeric(45,20);
    _fee_perc_ria numeric(45,20);
BEGIN
    -- Validaciones mínimas
    /*
    if (_annual_fee_perc is null) then
        raise exception '_annual_fee_perc [%] no puede ser nulo', _annual_fee_perc
            using errcode = '22023'; -- null value not allowed
    end if;
    */
    if (_process_date is null or _process_date<'20240422') then
        raise exception '_process_date no puede ser nulo ni precia al 20240429'
            using errcode = '22023'; -- null value not allowed
    end if;

    if (_annual_fee_perc<=0.5) then
        _fee_perc_ria        := 0.25;
        _fee_perc_proteccion := _annual_fee_perc-_fee_perc_ria;
    else
        _fee_perc_ria        := 0.4;
        _fee_perc_proteccion := _annual_fee_perc-_fee_perc_ria;
    END IF;

    RETURN QUERY
        select _fee_perc_proteccion, _fee_perc_ria;
    RETURN;

END;
$$;

alter function public.fn_distribucion_ingresos(numeric, varchar) owner to postgres;

