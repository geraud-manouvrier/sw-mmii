create or replace function public.fn_fecha_date_to_string(_fecha_date date, _format_output character varying, _separator character varying) returns character varying
    language plpgsql
as
$$
DECLARE _fecha_date_out character varying;
DECLARE _pattern TEXT;

    BEGIN

    IF (_format_output = 'YYYYMMDD') THEN
        _pattern    := substr(_format_output, 1, 4)||_separator||substr(_format_output, 5, 2)||_separator||substr(_format_output, 7, 2);
    ELSEIF (_format_output = 'DDMMYYYY' OR _format_output = 'MMDDYYYY') THEN
        _pattern    := substr(_format_output, 1, 2)||_separator||substr(_format_output, 3, 2)||_separator||substr(_format_output, 5, 4);
    ELSE
        _pattern    := _format_output;
    END IF;
    _fecha_date_out := to_char(_fecha_date, _pattern)::character varying;
    return _fecha_date_out;
    END;
$$;

alter function public.fn_fecha_date_to_string(date, varchar, varchar) owner to postgres;

