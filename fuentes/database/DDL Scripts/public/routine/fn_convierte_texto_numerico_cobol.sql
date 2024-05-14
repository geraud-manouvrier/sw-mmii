create or replace function public.fn_convierte_texto_numerico_cobol(_texto_numerico_cobol character varying, _cant_decimales integer) returns numeric
    language plpgsql
as
$$
DECLARE _temp NUMERIC(45,20);
DECLARE _entero character varying;
DECLARE _decimal character varying;
DECLARE _ult_car character varying;
DECLARE _signo int;
DECLARE _dig_entero int;

    BEGIN
        IF (TRIM(_texto_numerico_cobol)='') THEN
            _temp := 0::NUMERIC(45,20);
            RETURN _temp;
        END IF;


        _dig_entero := length(_texto_numerico_cobol)-_cant_decimales;

        --Extraemos la parte entera y la decimal
        _entero  := SUBSTRING(_texto_numerico_cobol, 1, _dig_entero);
        IF (_cant_decimales<>0) THEN
            _decimal := SUBSTRING(_texto_numerico_cobol, _dig_entero+1, _cant_decimales);
        ELSE
            _decimal := 0;
        END IF;
        --estraemos el ultimo caracter para transformarlo
        _ult_car  := RIGHT(_texto_numerico_cobol, 1);

        --Transformamos el ultimo caracter en el valor correcto
        _signo  := public.fn_convierte_caracter_cobol(_ult_car);

        --Re transformamos la parte decimal con el valor que corresponde
        _decimal    := SUBSTRING(_decimal, 1, length(_decimal)-1) || CAST(ABS(_signo) as VARCHAR(1));

        --Armamos el valor como numero ahora
        --Primero le colocamos la parte decimal (como entero)
        _temp  := CAST(_decimal as NUMERIC(45,20));
        -- Dividmos para transformar en decimal
        -- Para evitar desbordamiento, la base de POWER debe ser de tipo BIGINT u otro
        _temp  := _temp/(POWER(CAST(10 as BIGINT),_cant_decimales));
        --Sumamos l parte entera
        _temp  := CAST(_entero as NUMERIC(45,20)) + _temp;

        --Aplicamos signo
        IF (_signo<0) THEN
            _temp := _temp * CAST(-1 as NUMERIC(45,20));
        END IF;

        RETURN(_temp);
    END;
$$;

alter function public.fn_convierte_texto_numerico_cobol(varchar, integer) owner to postgres;

