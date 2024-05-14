create table clientes.cuenta
(
    id                 integer generated always as identity,
    id_cliente         integer              not null,
    id_custodio        varchar(100)         not null,
    id_cuenta_custodio varchar(100)         not null,
    habilitado         boolean default true not null,
    constraint cuenta_pk
        primary key (id),
    constraint cuenta_cliente_fk
        foreign key (id_cliente) references clientes.cliente
);

alter table clientes.cuenta
    owner to postgres;

