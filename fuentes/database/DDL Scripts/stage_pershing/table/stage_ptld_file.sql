create table stage_pershing.stage_ptld_file
(
    id           bigint generated always as identity,
    id_proceso   bigint,
    process_date varchar(100),
    linea        varchar(1000),
    constraint stage_ptld_file_pk
        primary key (id)
);

alter table stage_pershing.stage_ptld_file
    owner to postgres;

