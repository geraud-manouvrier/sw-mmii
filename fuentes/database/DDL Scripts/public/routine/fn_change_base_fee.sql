create or replace function public.fn_change_base_fee(_percentual_comision numeric, _base_from character varying, _base_to character varying, _method character varying) returns numeric
    language plpgsql
as
$$
DECLARE
    _factor int := 365;
    allowed constant text[] := array['ANNUAL','DAILY'];
    allowed_method constant text[] := array['E','P'];
BEGIN
    -- Validaciones de presencia
    if (_base_from is null or _base_to is null or _method is null) then
        raise exception 'base_from, base_to y method son obligatorios'
            using errcode = '22004'; -- null value not allowed
    end if;

    -- Validación IN (lista permitida)
    if not (_base_from = any(allowed) AND _base_to = any(allowed)) then
        raise exception 'Bases "%-%" no soportadas. Permitidas: %', _base_from, _base_to, allowed
            using errcode = '22023'; -- invalid parameter value
    end if;
    -- Validación IN (lista permitida)
    if not (_method = any(allowed_method)) then
        raise exception 'Method "%" no soportado. Permitidos: %', _method, allowed_method
            using errcode = '22023'; -- invalid parameter value
    end if;

     IF (_base_from=_base_to) THEN
        RETURN _percentual_comision;
    END IF;

    --Daily -> Annual
    IF (_base_from='DAILY' AND _base_to='ANNUAL') THEN
        IF (_method='P') THEN
            RETURN _percentual_comision*_factor*100;   --Método Proporcional (sin capitalización)
        END IF;
        IF (_method='E') THEN
            RETURN (power(1 + _percentual_comision, _factor) - 1) * 100;   --Método efectivo (CON capitalización)
        END IF;
    END IF;

    --Annual -> Daily
    IF (_base_from='ANNUAL' AND _base_to='DAILY') THEN
        IF (_method='P') THEN
            RETURN _percentual_comision/_factor/100;   --Método Proporcional (sin capitalización)
        END IF;
        IF (_method='E') THEN
            RETURN power(1 + (_percentual_comision / 100.0), 1.0 / _factor) - 1;   --Método efectivo (CON capitalización)
        END IF;

    END IF;


    RAISE EXCEPTION 'Base de comisión no soportada: [%] %->%', _percentual_comision, _base_from, _base_to
        using errcode = '0A000';

END;
$$;

alter function public.fn_change_base_fee(numeric, varchar, varchar, varchar) owner to postgres;

