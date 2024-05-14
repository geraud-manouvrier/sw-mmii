create table public.jobs_log
(
    id              bigint generated always as identity,
    id_job          integer                     not null,
    start_timestamp timestamp     default now() not null,
    end_timestamp   timestamp,
    id_proceso      varchar(100)                not null,
    sub_id_proceso  varchar(100)  default NULL::character varying,
    info            varchar(1000) default NULL::character varying,
    constraint jobs_log_pk
        primary key (id)
);

alter table public.jobs_log
    owner to postgres;

