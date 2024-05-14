create or replace function public.fn_convierte_caracter_cobol(_caracter_cobol character varying) returns integer
    language plpgsql
as
$$
    BEGIN
        IF (_caracter_cobol in ('1','2','3','4','5','6','7','8','9','0') ) THEN
            return _caracter_cobol::int;
        END IF;
        IF (_caracter_cobol='{') THEN
            return 0::int;
        END IF;
        IF (_caracter_cobol='A') THEN
            return 1::int;
        END IF;
        IF (_caracter_cobol='B') THEN
            return 2::int;
        END IF;
        IF (_caracter_cobol='C') THEN
            return 3::int;
        END IF;
        IF (_caracter_cobol='D') THEN
            return 4::int;
        END IF;
        IF (_caracter_cobol='E') THEN
            return 5::int;
        END IF;
        IF (_caracter_cobol='F') THEN
            return 6::int;
        END IF;
        IF (_caracter_cobol='G') THEN
            return 7::int;
        END IF;
        IF (_caracter_cobol='H') THEN
            return 8::int;
        END IF;
        IF (_caracter_cobol='I') THEN
            return 9::int;
        END IF;
        IF (_caracter_cobol='}') THEN
            return 0::int;
        END IF;
        IF (_caracter_cobol='J') THEN
            return -1::int;
        END IF;
        IF (_caracter_cobol='K') THEN
            return -2::int;
        END IF;
        IF (_caracter_cobol='L') THEN
            return -3::int;
        END IF;
        IF (_caracter_cobol='M') THEN
            return -4::int;
        END IF;
        IF (_caracter_cobol='N') THEN
            return -5::int;
        END IF;
        IF (_caracter_cobol='O') THEN
            return -6::int;
        END IF;
        IF (_caracter_cobol='P') THEN
            return -7::int;
        END IF;
        IF (_caracter_cobol='Q') THEN
            return -8::int;
        END IF;
        IF (_caracter_cobol='R') THEN
            return -9::int;
        END IF;

        RETURN NULL;
    END;
$$;

alter function public.fn_convierte_caracter_cobol(varchar) owner to postgres;

