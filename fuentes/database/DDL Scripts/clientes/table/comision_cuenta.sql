create table clientes.comision_cuenta
(
    id                    integer generated always as identity,
    id_cuenta             integer                              not null,
    comision_diaria_saldo numeric(45, 20) default 0            not null,
    fecha_inicio_vigencia date            default CURRENT_DATE not null,
    constraint comision_cuenta_pk
        primary key (id),
    constraint comision_cuenta_cuenta_fk
        foreign key (id_cuenta) references clientes.cuenta
);

alter table clientes.comision_cuenta
    owner to postgres;

