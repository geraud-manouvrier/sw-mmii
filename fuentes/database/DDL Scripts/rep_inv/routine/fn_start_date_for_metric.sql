create or replace function rep_inv.fn_start_date_for_metric(_date_in date, _metric character varying) returns date
    language plpgsql
as
$$
DECLARE _aux_date DATE;
    BEGIN

    IF _metric='MTD' THEN
        RETURN date_trunc('month', _date_in);
    ELSEIF _metric='YTD' THEN
        RETURN date_trunc('year', _date_in);
    ELSEIF _metric='INI_OPER' THEN
        RETURN '2022-01-01'::date;
    ELSEIF _metric='APER' THEN
        RETURN '2022-01-01'::date;
    ELSEIF _metric='1M' THEN
        _aux_date = public.fn_calendario_ult_dia_mes(_date_in);
        IF _date_in=_aux_date THEN
            RETURN date_trunc('month', _date_in);
        ELSE
            RETURN (_date_in - interval '1 month')+ interval '1 day';
        END IF;
    ELSEIF _metric='3M' THEN
        _aux_date = public.fn_calendario_ult_dia_mes(_date_in);
        IF _date_in=_aux_date THEN
            RETURN date_trunc('month', _date_in - interval '2 month');
        ELSE
            RETURN (_date_in - interval '3 month')+ interval '1 day';
        END IF;
    ELSEIF _metric='12M' THEN
        _aux_date = public.fn_calendario_ult_dia_mes(_date_in);
        IF _date_in=_aux_date THEN
            RETURN date_trunc('month', _date_in - interval '11 month');
        ELSE
            RETURN (_date_in - interval '12 month')+ interval '1 day';
        END IF;
    ELSEIF _metric='20M' THEN
        _aux_date = public.fn_calendario_ult_dia_mes(_date_in);
        IF _date_in=_aux_date THEN
            RETURN date_trunc('month', _date_in - interval '19 month');
        ELSE
            RETURN (_date_in - interval '20 month')+ interval '1 day';
        END IF;
    ELSEIF _metric='1D' THEN
        --RETURN (_date_in - interval '2 day')+ interval '1 day';
        --RETURN (_date_in - interval '1 day');
        RETURN (_date_in);
    END IF;

    RETURN null::date;

    END;
$$;

alter function rep_inv.fn_start_date_for_metric(date, varchar) owner to postgres;

