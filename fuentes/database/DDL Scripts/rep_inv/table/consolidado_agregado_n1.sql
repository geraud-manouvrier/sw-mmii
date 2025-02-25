create table rep_inv.consolidado_agregado_n1
(
    process_date                varchar(100) not null,
    process_date_as_date        date,
    agregador_n1                varchar(100) not null,
    saldo_dia                   numeric(45, 20),
    abonos_dia                  numeric(45, 20),
    retiros_dia                 numeric(45, 20),
    dividendos_dia              numeric(45, 20),
    comision_devengada_dia      numeric(45, 20),
    saldo_dia_anterior          numeric(45, 20) default (0)::numeric(45, 20),
    utilidad                    numeric(45, 20) default (0)::numeric(45, 20),
    rentabilidad                numeric(45, 20) default (0)::numeric(45, 20),
    saldo_rentabilidad          numeric(45, 20) default (0)::numeric(45, 20),
    rentabilidad_base_pitatoria numeric(45, 20) default 0,
    constraint consolidado_agregado_n1_pk
        primary key (process_date, agregador_n1)
);

alter table rep_inv.consolidado_agregado_n1
    owner to postgres;

