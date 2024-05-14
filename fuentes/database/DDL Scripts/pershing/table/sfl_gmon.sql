create table pershing.sfl_gmon
(
    id                        bigint generated always as identity,
    id_proceso                bigint       not null,
    process_date              varchar(100) not null,
    record_id_sequence_number integer,
    account_number            varchar(100),
    ip_number                 varchar(100),
    ibd_number                varchar(100),
    usde_td_balance           numeric(45, 20),
    usd_td_balance            numeric(45, 20),
    long_td_market            numeric(45, 20),
    short_td_market           numeric(45, 20),
    td_liquidating_equity     numeric(45, 20),
    total_usde_td_balance     numeric(45, 20),
    total_equity              numeric(45, 20),
    trade_date_net_worth      numeric(45, 20),
    mmf_principal_balance     numeric(45, 20),
    mmf_dividend              numeric(45, 20),
    cash_available            numeric(45, 20),
    date_of_data              date,
    usde_sd_balance           numeric(45, 20),
    usd_sd_balance            numeric(45, 20),
    long_sd_market            numeric(45, 20),
    short_sd_market           numeric(45, 20),
    sma_date_stamp            date,
    sma_balance               numeric(45, 20),
    margin_buying_power       numeric(45, 20),
    technical_short_value     numeric(45, 20),
    total_fed_requirement     numeric(45, 20),
    total_options_requirement numeric(45, 20),
    base_currency             varchar(100),
    non_usd_currency          varchar(100),
    masked_house_call         numeric(45, 20),
    constraint sfl_gmon_pk
        primary key (id)
);

alter table pershing.sfl_gmon
    owner to postgres;

