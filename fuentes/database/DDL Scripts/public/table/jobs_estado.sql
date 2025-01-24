create table public.jobs_estado
(
    id              bigint generated always as identity,
    id_job          integer                 not null,
    id_proceso      varchar(100)            not null,
    sub_id_proceso  varchar(100)            not null,
    start_timestamp timestamp default now() not null,
    end_timestamp   timestamp,
    estado          integer,
    constraint jobs_estado_pk
        primary key (id),
    foreign key (id_job) references public.jobs_maestro
);

alter table public.jobs_estado
    owner to postgres;

