create or replace function pershing.fn_obtiene_valor_param_generic_pershing(_param_name character varying, _param_id character varying) returns character varying
    language plpgsql
as
$$
DECLARE _valor_parametro_out VARCHAR(1000);
    BEGIN
        select PAR.param_value INTO _valor_parametro_out
        FROM pershing.param_generic_pershing PAR
        WHERE PAR.param_name=_param_name AND PAR.param_id=_param_id
        LIMIT 1;
    RETURN _valor_parametro_out;
    END;
$$;

alter function pershing.fn_obtiene_valor_param_generic_pershing(varchar, varchar) owner to postgres;

