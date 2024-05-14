create table stage_pershing.stage_gmon_reg_trailer
(
    id                       bigint generated always as identity,
    id_proceso               bigint,
    process_date             varchar(100),
    eof                      varchar(100),
    campo_2                  varchar(100),
    campo_3                  varchar(100),
    date_of_data             varchar(100),
    campo_5                  varchar(100),
    remote_id                varchar(100),
    campo_7                  varchar(100),
    campo_8                  varchar(100),
    number_detail_of_records integer,
    campo_10                 varchar(100),
    eor                      varchar(100),
    constraint stage_gmon_reg_trailer_pk
        primary key (id)
);

alter table stage_pershing.stage_gmon_reg_trailer
    owner to postgres;

