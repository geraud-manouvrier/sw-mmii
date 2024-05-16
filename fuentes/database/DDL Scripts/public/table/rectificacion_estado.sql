create table public.rectificacion_estado
(
    id    integer      not null,
    glosa varchar(100) not null,
    constraint rectificacion_estado_pk
        primary key (id)
);

alter table public.rectificacion_estado
    owner to postgres;

