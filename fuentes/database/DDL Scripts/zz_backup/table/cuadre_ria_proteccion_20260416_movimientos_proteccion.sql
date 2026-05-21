create table zz_backup.cuadre_ria_proteccion_20260416_movimientos_proteccion
(
    process_date varchar(100),
    account_no   varchar(100),
    count        bigint,
    sum          numeric
);

alter table zz_backup.cuadre_ria_proteccion_20260416_movimientos_proteccion
    owner to postgres;

