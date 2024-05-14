create table public.parametro
(
    id               integer generated always as identity,
    id_parametro     varchar(100)  not null,
    sub_id_parametro varchar(100)  not null,
    valor_parametro  varchar(1000) not null,
    comentario       varchar(100)  not null,
    constraint parametro_pk
        primary key (id),
    constraint parametro_pk_id_sub_id_parametro
        unique (id_parametro, sub_id_parametro)
);

alter table public.parametro
    owner to postgres;

