create or replace function public.fn_obtiene_valor_parametro(_id_parametro character varying, _sub_id_parametro character varying) returns character varying
    language plpgsql
as
$$
DECLARE _valor_parametro_out VARCHAR(1000);
    BEGIN
        select PAR.valor_parametro INTO _valor_parametro_out
        FROM public.parametro PAR
        WHERE PAR.id_parametro=_id_parametro AND PAR.sub_id_parametro=_sub_id_parametro;
    RETURN _valor_parametro_out;
    END;
$$;

alter function public.fn_obtiene_valor_parametro(varchar, varchar) owner to postgres;

