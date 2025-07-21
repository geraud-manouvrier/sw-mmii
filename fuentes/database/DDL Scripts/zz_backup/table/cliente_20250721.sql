create table zz_backup.cliente_20250721
(
    id                    integer,
    identificador         varchar(100),
    nombre                varchar(100),
    id_tipo_identificador integer,
    fee                   numeric(45, 20)
);

alter table zz_backup.cliente_20250721
    owner to postgres;

