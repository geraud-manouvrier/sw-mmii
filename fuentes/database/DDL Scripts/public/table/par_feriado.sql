create table public.par_feriado
(
    dia               date                 not null,
    es_habil_pershing boolean default true not null,
    es_habil_stonex   boolean default true not null,
    observaciones     varchar(100)         not null,
    constraint feriado_pk
        primary key (dia)
);

alter table public.par_feriado
    owner to postgres;

