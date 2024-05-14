create or replace function public.fn_es_habil_pershing_by_process_date(_process_date_in character varying) returns boolean
    language plpgsql
as
$$
DECLARE _process_date_as_date date;
    BEGIN
        _process_date_as_date   := public.fn_fecha_string_to_date(_process_date_in, 'YYYYMMDD');
        IF ( EXTRACT(DOW FROM _process_date_as_date) IN (6,0) ) THEN
            return false;
        end if;
        IF ( EXISTS (SELECT 1 FROM public.par_feriado FER WHERE FER.dia=_process_date_as_date AND NOT FER.es_habil_pershing) ) THEN
            return false;
        END IF;

        RETURN true;
    END;
$$;

alter function public.fn_es_habil_pershing_by_process_date(varchar) owner to postgres;

