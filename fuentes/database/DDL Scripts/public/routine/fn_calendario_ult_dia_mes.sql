create or replace function public.fn_calendario_ult_dia_mes(_date_in date) returns date
    language plpgsql
as
$$
DECLARE _aux_date DATE;
    BEGIN

    _aux_date = _date_in + interval '1 day';

    IF EXTRACT(MONTH FROM _date_in) <> EXTRACT(MONTH FROM _aux_date) THEN
        RETURN _date_in;
    ELSE

    _aux_date = _date_in + interval '1 month';
    _aux_date = date_trunc('month', _aux_date);

    RETURN _aux_date - interval '1 day';
    END IF;

    END;
$$;

alter function public.fn_calendario_ult_dia_mes(date) owner to postgres;

