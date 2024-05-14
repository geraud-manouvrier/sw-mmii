create table stage_pershing.stage_gtol_file
(
    id           bigint generated always as identity,
    id_proceso   bigint,
    process_date varchar(100),
    linea        varchar(2000),
    constraint stage_gtol_file_pk
        primary key (id)
);

alter table stage_pershing.stage_gtol_file
    owner to postgres;

