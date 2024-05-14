create or replace function public.fn_fecha_string_to_date(_fecha_string character varying, _format_input_date character varying) returns date
    language plpgsql
as
$$
DECLARE _fecha_date_out date;
DECLARE _dia integer;
DECLARE _mes integer;
DECLARE _anio integer;
DECLARE _fecha_aux character varying;
DECLARE _salto int;
DECLARE _fecha_base date;

    BEGIN

    IF (trim(_fecha_string)='' OR _fecha_string =repeat('0', length(_fecha_string)) OR _fecha_string IS NULL) THEN
        RETURN NULL::DATE;
    END IF;

    _fecha_aux  := replace(replace(_fecha_string, '-', ''), '/', '');
    IF (_format_input_date = 'YYYYMMDD') THEN
        _dia    := substr(_fecha_aux, 7, 2)::integer;
        _mes    := substr(_fecha_aux, 5, 2)::integer;
        _anio   := substr(_fecha_aux, 1, 4)::integer;
    ELSEIF (_format_input_date = 'DDMMYYYY') THEN
        _dia    := substr(_fecha_aux, 1, 2)::integer;
        _mes    := substr(_fecha_aux, 3, 2)::integer;
        _anio   := substr(_fecha_aux, 5, 4)::integer;
    ELSEIF (_format_input_date = 'MMDDYYYY') THEN
        _dia    := substr(_fecha_aux, 3, 2)::integer;
        _mes    := substr(_fecha_aux, 1, 2)::integer;
        _anio   := substr(_fecha_aux, 5, 4)::integer;
    ELSEIF (_format_input_date = 'MMDDCCYY') THEN
        _dia    := substr(_fecha_aux, 3, 2)::integer;
        _mes    := substr(_fecha_aux, 1, 2)::integer;
        _anio   := substr(_fecha_aux, 5, 4)::integer;
    ELSEIF (_format_input_date = 'CCYYMMDD') THEN
        _dia    := substr(_fecha_aux, 7, 2)::integer;
        _mes    := substr(_fecha_aux, 5, 2)::integer;
        _anio   := substr(_fecha_aux, 1, 4)::integer;
    ELSEIF (_format_input_date = 'CCYYDDD') THEN
        _salto  := CAST(substr(_fecha_string, 5, 3) as INT)-1;
        _fecha_base := make_date(substr(_fecha_string, 1, 4)::integer, 1, 1);
        _fecha_base := _fecha_base + (interval  '1 day'*_salto);
        _dia    := EXTRACT(day FROM _fecha_base)::integer;
        _mes    := EXTRACT(month FROM _fecha_base)::integer;
        _anio   := EXTRACT(year FROM _fecha_base)::integer;
    ELSEIF (_format_input_date = 'CCYY') THEN
        _dia    := 1::integer;
        _mes    := 1::integer;
        _anio   := substr(_fecha_aux, 1, 4)::integer;
    ELSEIF (_format_input_date = 'YYMMDD') THEN
        _dia    := substr(_fecha_aux, 5, 2)::integer;
        _mes    := substr(_fecha_aux, 3, 2)::integer;
        _anio   := (substr(_fecha_aux, 1, 2)::integer)+2000;
    ELSEIF (_format_input_date = 'CCYYMMDD') THEN
        _dia    := substr(_fecha_aux, 7, 2)::integer;
        _mes    := substr(_fecha_aux, 5, 2)::integer;
        _anio   := substr(_fecha_aux, 1, 4)::integer;
    ELSEIF (_format_input_date = 'CCYYMMDD') THEN
        _dia    := substr(_fecha_aux, 7, 2)::integer;
        _mes    := substr(_fecha_aux, 5, 2)::integer;
        _anio   := substr(_fecha_aux, 1, 4)::integer;
    ELSE
        _dia    := null;
        _mes    := null;
        _anio   := null;
    END IF;
    _fecha_date_out := make_date(_anio, _mes, _dia);
    return _fecha_date_out;
    END;
$$;

alter function public.fn_fecha_string_to_date(varchar, varchar) owner to postgres;

