create or replace function public.fn_convierte_signo_factor(_signo character varying) returns integer
    language plpgsql
as
$$
    BEGIN
        IF (_signo = '-') THEN
            return -1;
        END IF;
        IF (_signo ='+') THEN
            return 1;
        END IF;

        RETURN NULL;
    END;
$$;

alter function public.fn_convierte_signo_factor(varchar) owner to postgres;

