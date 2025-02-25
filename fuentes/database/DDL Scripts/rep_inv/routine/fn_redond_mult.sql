create or replace function rep_inv.fn_redond_mult(value numeric, multiple numeric) returns numeric
    language plpgsql
as
$$
BEGIN
    --RAISE NOTICE 'Llamando a fn_redond_mult con value [%] y multiple [%]', value, multiple;
    RETURN (ROUND(value / multiple) * multiple)::NUMERIC(45,20);
END;
$$;

alter function rep_inv.fn_redond_mult(numeric, numeric) owner to postgres;

