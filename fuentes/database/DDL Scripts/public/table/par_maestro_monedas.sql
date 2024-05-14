create table public.par_maestro_monedas
(
    id           bigint generated always as identity,
    codigo       varchar(100) not null,
    cod_stonex   integer,
    cod_pershing varchar(100),
    nombre       varchar(100) not null,
    constraint par_maestro_monedas_pk
        primary key (id)
);

alter table public.par_maestro_monedas
    owner to postgres;

