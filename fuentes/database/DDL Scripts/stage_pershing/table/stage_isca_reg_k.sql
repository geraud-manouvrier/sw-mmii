create table stage_pershing.stage_isca_reg_k
(
    id                        bigint generated always as identity,
    id_proceso                bigint,
    process_date              varchar(100),
    record_indicator          varchar(100),
    record_id_sequence_number integer,
    cusip_number              varchar(100),
    exchange_code_sedol_1     varchar(100),
    sedol_1                   varchar(100),
    exchange_code_sedol_2     varchar(100),
    sedol_2                   varchar(100),
    exchange_code_sedol_3     varchar(100),
    sedol_3                   varchar(100),
    exchange_code_sedol_4     varchar(100),
    sedol_4                   varchar(100),
    exchange_code_sedol_5     varchar(100),
    sedol_5                   varchar(100),
    exchange_code_sedol_6     varchar(100),
    sedol_6                   varchar(100),
    exchange_code_sedol_7     varchar(100),
    sedol_7                   varchar(100),
    exchange_code_sedol_8     varchar(100),
    sedol_8                   varchar(100),
    exchange_code_sedol_9     varchar(100),
    sedol_9                   varchar(100),
    exchange_code_sedol_10    varchar(100),
    sedol_10                  varchar(100),
    exchange_code_sedol_11    varchar(100),
    sedol_11                  varchar(100),
    campo_26                  varchar(100),
    eor                       varchar(100),
    constraint stage_isca_reg_k_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_k
    owner to postgres;

