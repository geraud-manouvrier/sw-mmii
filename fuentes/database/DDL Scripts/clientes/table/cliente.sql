create table clientes.cliente
(
    id                    integer generated always as identity,
    identificador         varchar(100) not null,
    nombre                varchar(100) not null,
    id_tipo_identificador integer      not null,
    fee                   numeric(45, 20) default NULL::numeric,
    constraint cliente_pk
        primary key (id),
    constraint cliente_tipo_identificador_fk
        foreign key (id_tipo_identificador) references clientes.tipo_identificador
);

alter table clientes.cliente
    owner to postgres;

