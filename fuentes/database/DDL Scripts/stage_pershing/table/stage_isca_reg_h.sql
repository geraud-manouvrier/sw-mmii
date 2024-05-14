create table stage_pershing.stage_isca_reg_h
(
    id                               bigint generated always as identity,
    id_proceso                       bigint,
    process_date                     varchar(100),
    record_indicator                 varchar(100),
    record_id_sequence_number        integer,
    cusip_number                     varchar(100),
    campo_4                          varchar(100),
    exchange_rate_denom_currency_usd numeric(45, 20),
    underlying_cusip_1               varchar(100),
    campo_7                          varchar(100),
    deliverable_unit_quantity_1      integer,
    underlying_cusip_2               varchar(100),
    campo_10                         varchar(100),
    deliverable_unit_quantity_2      integer,
    underlying_cusip_3               varchar(100),
    campo_13                         varchar(100),
    deliverable_unit_quantity_3      integer,
    underlying_cusip_4               varchar(100),
    campo_16                         varchar(100),
    deliverable_unit_quantity_4      integer,
    annual_dividend_currency_code    varchar(100),
    outstanding_shares               numeric(45, 20),
    eor                              varchar(100),
    constraint stage_isca_reg_h_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_h
    owner to postgres;

