create table stage_pershing.stage_gmon_reg_b
(
    id                             bigint generated always as identity,
    id_proceso                     bigint,
    process_date                   varchar(100),
    transaction_code               varchar(100),
    record_indicator_value         varchar(100),
    record_id_sequence_number      integer,
    account_number                 varchar(100),
    campo_5                        varchar(100),
    ip_number                      varchar(100),
    ibd_number                     varchar(100),
    usde_sd_balance                numeric(45, 20),
    usde_sd_balance_sign           varchar(100),
    usd_sd_balance                 numeric(45, 20),
    usd_sd_balance_sign            varchar(100),
    long_sd_market                 numeric(45, 20),
    long_sd_market_sign            varchar(100),
    short_sd_market                numeric(45, 20),
    short_sd_market_sign           varchar(100),
    sma_date_stamp                 date,
    sma_balance                    numeric(45, 20),
    sma_balance_sign               varchar(100),
    margin_buying_power            numeric(45, 20),
    margin_buying_power_sign       varchar(100),
    technical_short_value          numeric(45, 20),
    technical_short_value_sign     varchar(100),
    total_fed_requirement          numeric(45, 20),
    total_fed_requirement_sign     varchar(100),
    total_options_requirement      numeric(45, 20),
    total_options_requirement_sign varchar(100),
    base_currency                  varchar(100),
    non_usd_currency               varchar(100),
    masked_house_call              numeric(45, 20),
    masked_house_call_sign         varchar(100),
    campo_31                       varchar(100),
    date_of_data                   date,
    eor                            varchar(100),
    constraint stage_gmon_reg_b_pk
        primary key (id)
);

alter table stage_pershing.stage_gmon_reg_b
    owner to postgres;

