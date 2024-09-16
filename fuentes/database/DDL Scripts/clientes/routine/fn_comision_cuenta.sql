create or replace function clientes.fn_comision_cuenta(_process_date character varying, _cliente_id character varying, _custodian character varying, _account_no character varying, _defaul_comision numeric, _is_anual boolean) returns numeric
    language plpgsql
as
$$
DECLARE
    _comision_excepcion NUMERIC(45,20);
    _comision_out NUMERIC(45,20);
BEGIN
    select vw_com.comision_diaria_saldo, *
    INTO _comision_excepcion
    from clientes.vw_maestro_comision vw_com
    where vw_com.identificador_cliente = _cliente_id
    AND UPPER(vw_com.id_custodio) = UPPER(_custodian)
    AND vw_com.id_cuenta_custodio = _account_no
    AND vw_com.fecha_inicio_vigencia <= public.fn_fecha_string_to_date(_process_date, 'YYYYMMDD')
    ORDER BY vw_com.fecha_inicio_vigencia DESC
    LIMIT 1;

    if (FOUND) THEN
        RAISE NOTICE 'Comisión exepción encontrada: %', _comision_excepcion;
    end if;

    if (_is_anual) THEN
        _comision_out := power((1 + _comision_excepcion), 365) - 1;
    else
        _comision_out := _comision_excepcion;
    end if;

    RETURN COALESCE(_comision_out, _defaul_comision)::NUMERIC(45,20);
END;
$$;

alter function clientes.fn_comision_cuenta(varchar, varchar, varchar, varchar, numeric, boolean) owner to postgres;

