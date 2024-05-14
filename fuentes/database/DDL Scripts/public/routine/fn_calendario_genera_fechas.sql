create or replace function public.fn_calendario_genera_fechas(_start_date_in date, _end_date_in date)
    returns TABLE(fecha_as_date date)
    language plpgsql
as
$$
DECLARE _start_date_default DATE;
DECLARE _end_date_default DATE;
    BEGIN

    _start_date_default := '1800-01-01'::DATE;
    _end_date_default := '2100-12-31'::DATE;

    IF (_start_date_in IS NULL) THEN
        _start_date_in  := _start_date_default;
    end if;
    IF (_end_date_in IS NULL) THEN
        _end_date_in    := _end_date_default;
    end if;

    RETURN QUERY
        SELECT dd::date as fecha_as_date
        FROM generate_series
                ( _start_date_in::timestamp
                , _end_date_in::timestamp
                , '1 day'::interval) dd
                ;
    RETURN;
    END;
$$;

alter function public.fn_calendario_genera_fechas(date, date) owner to postgres;

create or replace function public.fn_calendario_genera_fechas()
    returns TABLE(fecha_as_date date)
    language plpgsql
as
$$
begin
    -- missing source code
end;
$$;

alter function public.fn_calendario_genera_fechas() owner to postgres;

