create table stage_pershing.stage_isca_reg_g
(
    id                                bigint generated always as identity,
    id_proceso                        bigint,
    process_date                      varchar(100),
    record_indicator                  varchar(100),
    record_id_sequence_number         integer,
    cusip_number                      varchar(100),
    campo_4                           varchar(100),
    delta                             numeric(45, 20),
    delta_sign                        varchar(100),
    delta_value_presence_ind          varchar(100),
    campo_8                           varchar(100),
    isin_code                         varchar(100),
    issuer_identifier                 varchar(100),
    campo_11                          varchar(100),
    campo_12                          varchar(100),
    symbol_of_the_underlying_security varchar(100),
    asset_type                        varchar(100),
    asset_subtype                     varchar(100),
    asset_subsubtype                  varchar(100),
    payment_day_delays                integer,
    campo_18                          varchar(100),
    eor                               varchar(100),
    constraint stage_isca_reg_g_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_g
    owner to postgres;

