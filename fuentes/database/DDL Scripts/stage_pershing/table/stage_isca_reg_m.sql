create table stage_pershing.stage_isca_reg_m
(
    id                        bigint generated always as identity,
    id_proceso                bigint,
    process_date              varchar(100),
    record_indicator          varchar(100),
    record_id_sequence_number integer,
    cusip_number              varchar(100),
    campo_4                   varchar(100),
    campo_5                   varchar(100),
    first_call_date           date,
    first_call_price          numeric(45, 20),
    campo_8                   varchar(100),
    second_call_date          date,
    second_call_price         numeric(45, 20),
    campo_11                  varchar(100),
    third_call_date           date,
    third_call_price          numeric(45, 20),
    campo_14                  varchar(100),
    fourth_call_date          date,
    fourth_call_price         numeric(45, 20),
    campo_17                  varchar(100),
    eor                       varchar(100),
    constraint stage_isca_reg_m_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_m
    owner to postgres;

