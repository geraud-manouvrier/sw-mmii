create table zz_backup.cuadre_ria_proteccion_20260416_clientes_proteccion
(
    process_date varchar(100),
    account_no   varchar(100),
    count        bigint
);

alter table zz_backup.cuadre_ria_proteccion_20260416_clientes_proteccion
    owner to postgres;

