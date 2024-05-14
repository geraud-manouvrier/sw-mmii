create table public.jobs_maestro
(
    id     integer      not null,
    nombre varchar(100) not null,
    constraint jobs_maestro_pk
        primary key (id)
);

alter table public.jobs_maestro
    owner to postgres;

