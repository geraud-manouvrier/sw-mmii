create table pershing.proceso_sfl
(
    id                    bigint generated always as identity,
    process_date          varchar(100) not null,
    process_stamp         varchar(100) not null,
    start_timestamp       timestamp    not null,
    last_step_timestamp   timestamp    not null,
    info_log              varchar      not null,
    id_estado_proceso_sfl integer      not null,
    constraint proceso_sfl_pk
        primary key (id),
    constraint proceso_sfl_fk_estado_proceso_sfl
        foreign key (id_estado_proceso_sfl) references pershing.estado_proceso_sfl
);

alter table pershing.proceso_sfl
    owner to postgres;

