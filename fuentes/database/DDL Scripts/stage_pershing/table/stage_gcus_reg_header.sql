create table stage_pershing.stage_gcus_reg_header
(
    id                   bigint generated always as identity,
    id_proceso           bigint,
    process_date         varchar(100),
    bof                  varchar(100),
    campo_2              varchar(100),
    campo_3              varchar(100),
    date_of_data         varchar(100),
    campo_5              varchar(100),
    remote_id            varchar(100),
    campo_7              varchar(100),
    run_date             varchar(100),
    campo_9              varchar(100),
    run_time             varchar(100),
    campo_11             varchar(100),
    refreshed_or_updated varchar(100),
    campo_13             varchar(100),
    eof                  varchar(100),
    constraint stage_gcus_reg_header_pk
        primary key (id)
);

alter table stage_pershing.stage_gcus_reg_header
    owner to postgres;

