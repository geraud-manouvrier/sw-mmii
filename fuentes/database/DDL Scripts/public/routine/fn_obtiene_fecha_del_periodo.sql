create or replace function public.fn_obtiene_fecha_del_periodo(_periodo character varying, _dom character varying DEFAULT 'FIRST'::character varying, _default_for_empty date DEFAULT NULL::date, _separator character varying DEFAULT '-'::character varying) returns date
    language plpgsql
as
$$
DECLARE _fecha_out DATE;
DECLARE _periodo_int INTEGER;
DECLARE _anio INTEGER;
DECLARE _mes INTEGER;
DECLARE _fecha_tmp DATE;
    BEGIN
        IF (COALESCE(trim(_periodo), '') = '') THEN
            _fecha_out := _default_for_empty;
        ELSE
            _periodo_int    := CAST(replace(_periodo, _separator, '') as INT);
            _anio           := _periodo_int/100;
            _mes            := _periodo_int%100;
            --Fecha del mes, día 1
            _fecha_tmp      := make_date(_anio, _mes, 1);
            IF (_dom = 'LAST') THEN
                --Sumamos un mes (día 1 del mes siguiente)
                _fecha_tmp  := _fecha_tmp+interval  '1 month';
                --Nos devolvemos un día (último día del mes anterior)
                _fecha_tmp  := _fecha_tmp-interval  '1 day';
            ELSEIF (_dom = 'FIRST') THEN
                --Nada que hacer
            ELSE
                --Nada que hacer
            END IF;
            _fecha_out  := _fecha_tmp;
        END IF;
    RETURN _fecha_out;
    END;
$$;

alter function public.fn_obtiene_fecha_del_periodo(varchar, varchar, date, varchar) owner to postgres;

