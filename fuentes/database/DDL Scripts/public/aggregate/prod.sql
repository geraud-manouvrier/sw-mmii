create aggregate public.prod(numeric) (
    sfunc = aggfn_sfunc_prod,
    stype = numeric,
    initcond = '1'
    );

alter aggregate public.prod(numeric) owner to postgres;

