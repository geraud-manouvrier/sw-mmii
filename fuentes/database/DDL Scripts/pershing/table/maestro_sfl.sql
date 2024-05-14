create table pershing.maestro_sfl
(
    id                        varchar(100)          not null,
    flag_guardar_en_bd        boolean default false not null,
    flag_procesar_parse_en_bd boolean default false not null,
    filename                  varchar(100)          not null,
    flag_replicar_data        boolean default false not null,
    constraint maestro_sfl_pk
        primary key (id)
);

alter table pershing.maestro_sfl
    owner to postgres;

