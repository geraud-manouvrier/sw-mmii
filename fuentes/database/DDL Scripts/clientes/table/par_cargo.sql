create table clientes.par_cargo
(
    id                          varchar(100) not null,
    glosa                       varchar(100) not null,
    flag_habilitado_relacionado boolean      not null,
    constraint pk_par_cargo
        primary key (id)
);

alter table clientes.par_cargo
    owner to postgres;

