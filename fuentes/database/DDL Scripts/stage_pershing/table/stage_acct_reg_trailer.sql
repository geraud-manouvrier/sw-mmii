create table stage_pershing.stage_acct_reg_trailer
(
    id                       bigint generated always as identity,
    id_proceso               bigint,
    process_date             varchar(100),
    eof                      varchar(100),
    campo_02                 varchar(100),
    campo_03                 varchar(100),
    date_of_data             varchar(100),
    campo_05                 varchar(100),
    remote_id                varchar(100),
    campo_07                 varchar(100),
    campo_08                 varchar(100),
    number_of_detail_records integer,
    campo_10                 varchar(100),
    refreshed_or_updated     varchar(100),
    campo_12                 varchar(100),
    eor                      varchar(100),
    constraint stage_acct_reg_trailer_pk
        primary key (id)
);

alter table stage_pershing.stage_acct_reg_trailer
    owner to postgres;

