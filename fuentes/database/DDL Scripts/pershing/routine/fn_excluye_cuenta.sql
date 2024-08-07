create or replace function pershing.fn_excluye_cuenta(_proceso character varying, _account_number character varying) returns boolean
    language plpgsql
as
$$
DECLARE _valor_parametro_out bool;
    BEGIN
        _valor_parametro_out    := false;
        IF (_proceso='CARGA_SFL') THEN
            --Patrón de cuentas SURA RIA (internas)
            IF ( _account_number like '%T9N8%' or _account_number like '%T9N9%' or _account_number like '%T9O8%' or _account_number like '%T9O9%' ) THEN
                _valor_parametro_out    := true;
            END IF;
        END IF;

    RETURN _valor_parametro_out;
    END;
$$;

alter function pershing.fn_excluye_cuenta(varchar, varchar) owner to postgres;

