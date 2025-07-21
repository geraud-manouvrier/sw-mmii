create table zz_backup.cuenta_20250721
(
    id                 integer,
    id_cliente         integer,
    id_custodio        varchar(100),
    id_cuenta_custodio varchar(100),
    habilitado         boolean
);

alter table zz_backup.cuenta_20250721
    owner to postgres;

