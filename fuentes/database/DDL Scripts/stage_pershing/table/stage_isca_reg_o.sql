create table stage_pershing.stage_isca_reg_o
(
    id                          bigint generated always as identity,
    id_proceso                  bigint,
    process_date                varchar(100),
    record_indicator            varchar(100),
    record_id_sequence_number   integer,
    cusip_number                varchar(100),
    campo_4                     varchar(100),
    oas_treasury_rate           numeric(45, 20),
    oas_treasury_rate_sign      varchar(100),
    oas_treasury_effective_date date,
    minimum_piece               numeric(45, 20),
    minimum_increment           numeric(45, 20),
    issue_date_security         date,
    campo_11                    varchar(100),
    eor                         varchar(100),
    constraint stage_isca_reg_o_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_o
    owner to postgres;

