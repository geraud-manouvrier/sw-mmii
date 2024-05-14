create table stage_pershing.stage_gmon_reg_a
(
    id                         bigint generated always as identity,
    id_proceso                 bigint,
    process_date               varchar(100),
    transaction_code           varchar(100),
    record_indicator_value     varchar(100),
    record_id_sequence_number  integer,
    account_number             varchar(100),
    campo_5                    varchar(100),
    ip_number                  varchar(100),
    ibd_number                 varchar(100),
    usde_td_balance            numeric(45, 20),
    usde_td_balance_sign       varchar(100),
    usd_td_balance             numeric(45, 20),
    usd_td_balance_sign        varchar(100),
    long_td_market             numeric(45, 20),
    long_td_market_sign        varchar(100),
    short_td_market            numeric(45, 20),
    short_td_market_sign       varchar(100),
    td_liquidating_equity      numeric(45, 20),
    td_liquidating_equity_sign varchar(100),
    total_usde_td_balance      numeric(45, 20),
    total_usde_td_balance_sign varchar(100),
    total_equity               numeric(45, 20),
    total_equity_sign          varchar(100),
    trade_date_net_worth       numeric(45, 20),
    trade_date_net_worth_sign  varchar(100),
    mmf_principal_balance      numeric(45, 20),
    mmf_principal_balance_sign varchar(100),
    mmf_dividend               numeric(45, 20),
    mmf_dividend_sign          varchar(100),
    cash_available             numeric(45, 20),
    cash_available_sign        varchar(100),
    campo_30                   varchar(100),
    date_of_data               date,
    eor                        varchar(100),
    constraint stage_gmon_reg_a_pk
        primary key (id)
);

alter table stage_pershing.stage_gmon_reg_a
    owner to postgres;

