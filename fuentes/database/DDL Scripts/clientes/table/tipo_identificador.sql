create table clientes.tipo_identificador
(
    id                      integer generated always as identity,
    tipo_identificador      varchar(100)          not null,
    glosa_identificador     varchar(100)          not null,
    habilitado              boolean default true  not null,
    flag_tiene_relacionados boolean default false not null,
    constraint tipo_identificador_pk
        primary key (id)
);

alter table clientes.tipo_identificador
    owner to postgres;

