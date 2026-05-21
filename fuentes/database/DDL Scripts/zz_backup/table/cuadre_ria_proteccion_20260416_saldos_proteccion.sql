create table zz_backup.cuadre_ria_proteccion_20260416_saldos_proteccion
(
    process_date varchar(100),
    account_no   text,
    count        bigint,
    sum          numeric
);

alter table zz_backup.cuadre_ria_proteccion_20260416_saldos_proteccion
    owner to postgres;

