/*
2024-05-11
Actual: 6.4.0
Last:   --
*/

--========================================================================
--========================================================================
--========================================================================
--Creción de usuarios admin y app
CREATE USER mmii_admindb CREATEDB CREATEROLE PASSWORD 'b55tO<RB4aza';
GRANT azure_pg_admin TO mmii_admindb;
--create database qande_mmii with owner mmii_admindb;
create database qande_mmii;
CREATE USER mmii_appuserdb PASSWORD 'H;859md+5GAf';
GRANT CONNECT ON DATABASE qande_mmii TO mmii_appuserdb;
--ALTER DEFAULT PRIVILEGES FOR ROLE mmii_appuserdb GRANT SELECT, INSERT, DELETE ON TABLES TO mmii_appuserdb;
--ALTER DEFAULT PRIVILEGES FOR ROLE mmii_appuserdb GRANT EXECUTE ON FUNCTIONS TO mmii_appuserdb;

--========================================================================
--========================================================================
--========================================================================
--Creación de schemas base
create schema stage_pershing;
create schema pershing;
create schema clientes;

--========================================================================
--========================================================================
--========================================================================
--Creación de tablas schema stage_pershing

create table stage_pershing.stage_isrc_reg_header
(
    id           bigint generated always as identity
        constraint stage_isrc_reg_header_pk
            primary key,
    id_proceso   bigint,
    process_date varchar(100),
    bof          varchar(100),
    campo_2      varchar(100),
    campo_3      varchar(100),
    date_of_data varchar(100),
    campo_5      varchar(100),
    remote_id    varchar(100),
    campo_7      varchar(100),
    run_date     varchar(100),
    campo_9      varchar(100),
    run_time     varchar(100),
    campo_11     varchar(100),
    eor          varchar(100)
);

create table stage_pershing.stage_isrc_reg_a
(
    id                        bigint generated always as identity
        constraint stage_isrc_reg_a_pk
            primary key,
    id_proceso                bigint,
    process_date              varchar(100),
    transaction_code          varchar(100),
    record_secuence_id        varchar(100),
    record_id_number          integer,
    change_id                 varchar(100),
    source_code               varchar(100),
    source_code_desc_line_1   varchar(100),
    source_code_desc_line_2   varchar(100),
    source_code_desc_line_3   varchar(100),
    tax_status                varchar(100),
    campo_10                  varchar(100),
    user_id                   varchar(100),
    date_added                varchar(100),
    date_updated              varchar(100),
    ira_income_eligible       varchar(100),
    retail_income_eligible    varchar(100),
    customer_firm             varchar(100),
    cerdit_debit              varchar(100),
    statement_ind             varchar(100),
    statement_act_sum_ind     varchar(100),
    statement_act_sum_number  varchar(100),
    statement_trx_sum_ind     varchar(100),
    statement_trx_sum_number  varchar(100),
    statement_distrib_ind     varchar(100),
    statement_distrib_number  varchar(100),
    statement_distrib_tax_ind varchar(100),
    statement_div_ind         varchar(100),
    statement_div_number      varchar(100),
    statement_div_tax_ind     varchar(100),
    pershing_depart           varchar(100),
    pershing_grp              varchar(100),
    campo_31                  varchar(100),
    user_id_added             varchar(100),
    user_id_updated           varchar(100),
    campo_34                  varchar(100),
    portfolio_eligible_ind    varchar(100),
    reinvest_ind              varchar(100),
    campo_37                  varchar(100),
    eor                       varchar(100)
);

create table stage_pershing.stage_isrc_reg_trailer
(
    id                bigint generated always as identity
        constraint stage_isrc_reg_trailer_pk
            primary key,
    id_proceso        bigint,
    process_date      varchar(100),
    eof               varchar(100),
    campo_2           varchar(100),
    campo_3           varchar(100),
    date_of_data      varchar(100),
    campo_5           varchar(100),
    remote_id         varchar(100),
    campo_7           varchar(100),
    campo_8           varchar(100),
    number_of_records integer,
    campo_10          varchar(100),
    eor               varchar(100)
);

create table stage_pershing.stage_isrc_file
(
    id           bigint generated always as identity
        constraint stage_isrc_file_pk
            primary key,
    id_proceso   bigint,
    process_date varchar(100),
    linea        varchar(1000)
);

create table stage_pershing.stage_isca_file
(
    id           bigint generated always as identity
        constraint stage_isca_file_pk
            primary key,
    id_proceso   bigint,
    process_date varchar(100),
    linea        varchar(1000)
);

create table stage_pershing.stage_gact_file
(
    id           bigint generated always as identity
        constraint stage_gact_file_pk
            primary key,
    id_proceso   bigint,
    process_date varchar(100),
    linea        varchar(1000)
);

create table stage_pershing.stage_gcus_file
(
    id           bigint generated always as identity
        constraint stage_gcus_file_pk
            primary key,
    id_proceso   bigint,
    process_date varchar(100),
    linea        varchar(1000)
);

create table stage_pershing.stage_gmon_file
(
    id           bigint generated always as identity
        constraint stage_gmon_file_pk
            primary key,
    id_proceso   bigint,
    process_date varchar(100),
    linea        varchar(1000)
);

create table stage_pershing.stage_acct_file
(
    id           bigint generated always as identity
        constraint stage_acct_file_pk
            primary key,
    id_proceso   bigint,
    process_date varchar(100),
    linea        varchar(1000)
);

create table stage_pershing.stage_isca_reg_header
(
    id                   bigint generated always as identity
        constraint stage_isca_reg_header_pk
            primary key,
    id_proceso           bigint,
    process_date         varchar(100),
    bof                  varchar(100),
    campo_2              varchar(100),
    campo_3              varchar(100),
    date_of_data         varchar(100),
    campo_5              varchar(100),
    remote_id            varchar(100),
    campo_7              varchar(100),
    run_date             varchar(100),
    campo_9              varchar(100),
    run_time             varchar(100),
    campo_11             varchar(100),
    refreshed_or_updated varchar(100),
    campo_13             varchar(100),
    eor                  varchar(100)
);

create table stage_pershing.stage_isca_reg_a
(
    id                                              bigint generated always as identity
        constraint stage_isca_reg_a_pk
            primary key,
    id_proceso                                      bigint,
    process_date                                    varchar(100),
    record_indicator                                varchar(100),
    record_id_sequence_number                       integer,
    cusip_number                                    varchar(100),
    security_type                                   varchar(100),
    security_modifier                               varchar(100),
    security_calculation_code                       varchar(100),
    primary_exchange                                varchar(100),
    coupon_rate_fis_or_indicated_dividend_eq        numeric(45, 20),
    maturity_option_expire_date                     date,
    underlying_security_cusip                       varchar(100),
    first_call_price_fix_inc_or_strike_price_option numeric(45, 20),
    first_par_call_price_fix_inc_or_units_option    numeric(45, 20),
    primary_symbol                                  varchar(100),
    interest_frequency                              varchar(100),
    bond_class                                      varchar(100),
    first_coupon_day                                varchar(100),
    call_indicator                                  varchar(100),
    put_indicator                                   varchar(100),
    next_par_call_date                              date,
    prerefunded_date                                date,
    next_premium_call_date                          date,
    dated_date_for_fix_inc_or_ex_dividend_date_eq   date,
    first_coupon_fix_inc_or_payable_date_eq         date,
    campo_24                                        varchar(100),
    federal_marginable_ind                          varchar(100),
    cns_eligible_code                               varchar(100),
    dtcc_eligible_code                              varchar(100),
    nscc_eligible_code                              varchar(100),
    foreign_security                                varchar(100),
    second_coupon_day                               varchar(100),
    dividend_interest_payment_method                varchar(100),
    minor_product_code                              varchar(100),
    eor                                             varchar(100)
);

create table stage_pershing.stage_isca_reg_b
(
    id                                          bigint generated always as identity
        constraint stage_isca_reg_b_pk
            primary key,
    id_proceso                                  bigint,
    process_date                                varchar(100),
    record_indicator                            varchar(100),
    record_id_sequence_number                   integer,
    cusip_number                                varchar(100),
    campo_4                                     varchar(100),
    etf_indicator                               varchar(100),
    bid_price                                   numeric(45, 20),
    ask_price                                   numeric(45, 20),
    previous_day_price                          numeric(45, 20),
    latest_price                                numeric(45, 20),
    end_of_month_price                          numeric(45, 20),
    round_lot_quantity                          integer,
    dividend_reinvestment_eligibility_indicator varchar(100),
    previous_price_date                         date,
    latest_price_date                           date,
    end_of_month_price_date                     date,
    record_date                                 date,
    fundvest_ind                                varchar(100),
    country_code                                varchar(100),
    standard_poor_rating                        varchar(100),
    moodys_rating                               varchar(100),
    bond_sub_class                              varchar(100),
    restriction_indicator                       varchar(100),
    trace_indicator                             varchar(100),
    new_interest_calculation_code               varchar(100),
    sic_code                                    varchar(100),
    eor                                         varchar(100)
);

create table stage_pershing.stage_isca_reg_c
(
    id                          bigint generated always as identity
        constraint stage_isca_reg_c_pk
            primary key,
    id_proceso                  bigint,
    process_date                varchar(100),
    record_indicator            varchar(100),
    record_id_sequence_number   integer,
    cusip_number                varchar(100),
    state_tax_ind               varchar(100),
    fts_ind                     varchar(100),
    amt_ind                     varchar(100),
    ric_indicator               varchar(100),
    number_of_description_lines varchar(100),
    secutiry_description_line_1 varchar(100),
    secutiry_description_line_2 varchar(100),
    secutiry_description_line_3 varchar(100),
    secutiry_description_line_4 varchar(100),
    secutiry_description_line_5 varchar(100),
    user_cusip_identifier       varchar(100),
    price_purge_date            date,
    taxable_indicator           varchar(100),
    eor                         varchar(100)
);

create table stage_pershing.stage_isca_reg_d
(
    id                          bigint generated always as identity
        constraint stage_isca_reg_d_pk
            primary key,
    id_proceso                  bigint,
    process_date                varchar(100),
    record_indicator            varchar(100),
    record_id_sequence_number   integer,
    cusip_number                varchar(100),
    campo_4                     varchar(100),
    secutiry_description_line_6 varchar(100),
    put_price                   numeric(45, 20),
    put_date                    date,
    second_premium_call_price   numeric(45, 20),
    second_premium_call_date    date,
    called_date                 date,
    pool_number                 varchar(100),
    factor                      numeric(45, 20),
    factor_date                 date,
    previous_factor             varchar(100),
    previous_factor_date        date,
    variable_rate_indicator     varchar(100),
    next_last_coupon_date       date,
    structured_product_ind      varchar(100),
    perpetual_bond_indicator    varchar(100),
    eor                         varchar(100)
);

create table stage_pershing.stage_isca_reg_e
(
    id                            bigint generated always as identity
        constraint stage_isca_reg_e_pk
            primary key,
    id_proceso                    bigint,
    process_date                  varchar(100),
    record_indicator              varchar(100),
    record_id_sequence_number     integer,
    cusip_number                  varchar(100),
    campo_4                       varchar(100),
    exp_first_call_price          numeric(45, 20),
    exp_first_par_call_price      numeric(45, 20),
    exp_put_price                 numeric(45, 20),
    exp_second_premium_call_price numeric(45, 20),
    name_issuer_security          varchar(100),
    issuing_currency              varchar(100),
    globally_locked_sec_ind       varchar(100),
    globally_locked_reason_code   varchar(100),
    spac_ind                      varchar(100),
    campo_14                      varchar(100),
    eor                           varchar(100)
);

create table stage_pershing.stage_isca_reg_f
(
    id                                  bigint generated always as identity
        constraint stage_isca_reg_f_pk
            primary key,
    id_proceso                          bigint,
    process_date                        varchar(100),
    record_indicator                    varchar(100),
    record_id_sequence_number           integer,
    cusip_number                        varchar(100),
    campo_4                             varchar(100),
    expanded_bid_price                  numeric(45, 20),
    expanded_ask_price                  numeric(45, 20),
    expanded_previous_day_price         numeric(45, 20),
    expanded_latest_price               numeric(45, 20),
    expanded_end_of_month_price         numeric(45, 20),
    contract_share_quantity             numeric(45, 20),
    year_covered_under_cost_basis_rules integer,
    eor                                 varchar(100)
);

create table stage_pershing.stage_isca_reg_g
(
    id                                bigint generated always as identity
        constraint stage_isca_reg_g_pk
            primary key,
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
    eor                               varchar(100)
);

create table stage_pershing.stage_isca_reg_h
(
    id                               bigint generated always as identity
        constraint stage_isca_reg_h_pk
            primary key,
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
    eor                              varchar(100)
);

create table stage_pershing.stage_isca_reg_i
(
    id                                  bigint generated always as identity
        constraint stage_isca_reg_i_pk
            primary key,
    id_proceso                          bigint,
    process_date                        varchar(100),
    record_indicator                    varchar(100),
    record_id_sequence_number           integer,
    cusip_number                        varchar(100),
    campo_4                             varchar(100),
    option_root_id                      varchar(100),
    expiration_date                     date,
    call_put_indicator                  varchar(100),
    strike_price                        numeric(45, 20),
    fund_type                           varchar(100),
    broad_narrow_indicator              varchar(100),
    leverage_factor                     numeric(45, 20),
    leverage_factor_sign                varchar(100),
    outstanding_shares_update_date      date,
    expanded_symbol                     varchar(100),
    state_of_issuance                   varchar(100),
    option_excercise_pricing_model_code varchar(100),
    first_accrual_date                  date,
    tranche_code                        varchar(100),
    campo_19                            varchar(100),
    worthless_security_indicator        varchar(100),
    uit_termination_code                integer,
    fdic_certification_number           varchar(100),
    revenue_stream                      varchar(100),
    restricted_marijuana_ind            varchar(100),
    campo_25                            varchar(100),
    eor                                 varchar(100)
);

create table stage_pershing.stage_isca_reg_j
(
    id                               bigint generated always as identity
        constraint stage_isca_reg_j_pk
            primary key,
    id_proceso                       bigint,
    process_date                     varchar(100),
    record_indicator                 varchar(100),
    record_id_sequence_number        integer,
    cusip_number                     varchar(100),
    campo_4                          varchar(100),
    latest_price                     numeric(45, 20),
    latest_price_date                date,
    factored_market_value_multiplier numeric(45, 20),
    current_yield                    numeric(45, 20),
    yield                            numeric(45, 20),
    price_source                     varchar(100),
    country_of_origin                varchar(100),
    retricted_security_code          varchar(100),
    international_non_dollar_symbol  varchar(100),
    international_exchange           varchar(100),
    variable_rate_category_code      varchar(100),
    interest_rate_completion_ind     varchar(100),
    campo_17                         varchar(100),
    eor                              varchar(100)
);

create table stage_pershing.stage_isca_reg_k
(
    id                        bigint generated always as identity
        constraint stage_isca_reg_k_pk
            primary key,
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
    eor                       varchar(100)
);

create table stage_pershing.stage_isca_reg_l
(
    id                                bigint generated always as identity
        constraint stage_isca_reg_l_pk
            primary key,
    id_proceso                        bigint,
    process_date                      varchar(100),
    record_indicator                  varchar(100),
    record_id_sequence_number         integer,
    cusip_number                      varchar(100),
    campo_4                           varchar(100),
    primary_idc_mkt_exch              varchar(100),
    primary_mkt_exch_trading_status   varchar(100),
    primary_mkt_symbol                varchar(100),
    primary_mkt_exch_effective_date   date,
    primary_mkt_status_code           varchar(100),
    secondary_idc_mkt_exch            varchar(100),
    secondary_mkt_exch_trading_status varchar(100),
    secondary_mkt_symbol              varchar(100),
    secondary_mkt_exch_effective_date date,
    secondary_mkt_status_code         varchar(100),
    tick_size_pilot_group             varchar(100),
    tick_size_effective_date          date,
    tick_size_change_date             date,
    update_date                       date,
    oas_libor_rate                    numeric(45, 20),
    oas_libor_rate_sign               varchar(100),
    campo_21                          varchar(100),
    eor                               varchar(100)
);

create table stage_pershing.stage_isca_reg_m
(
    id                        bigint generated always as identity
        constraint stage_isca_reg_m_pk
            primary key,
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
    eor                       varchar(100)
);

create table stage_pershing.stage_isca_reg_n
(
    id                        bigint generated always as identity
        constraint stage_isca_reg_n_pk
            primary key,
    id_proceso                bigint,
    process_date              varchar(100),
    record_indicator          varchar(100),
    record_id_sequence_number integer,
    cusip_number              varchar(100),
    campo_4                   varchar(100),
    campo_5                   varchar(100),
    effective_date_rate_1     date,
    coupon_interest_rate_1    numeric(45, 20),
    campo_8                   varchar(100),
    effective_date_rate_2     date,
    coupon_interest_rate_2    numeric(45, 20),
    campo_11                  varchar(100),
    effective_date_rate_3     date,
    coupon_interest_rate_3    numeric(45, 20),
    campo_14                  varchar(100),
    effective_date_rate_4     date,
    coupon_interest_rate_4    numeric(45, 20),
    campo_17                  varchar(100),
    eor                       varchar(100)
);

create table stage_pershing.stage_isca_reg_o
(
    id                          bigint generated always as identity
        constraint stage_isca_reg_o_pk
            primary key,
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
    eor                         varchar(100)
);

create table stage_pershing.stage_isca_reg_trailer
(
    id                       bigint generated always as identity
        constraint stage_isca_reg_trailer_pk
            primary key,
    id_proceso               bigint,
    process_date             varchar(100),
    eof                      varchar(100),
    campo_2                  varchar(100),
    campo_3                  varchar(100),
    date_of_data             varchar(100),
    campo_5                  varchar(100),
    remote_id                varchar(100),
    campo_7                  varchar(100),
    number_detail_of_records varchar(100),
    campo_9                  varchar(100),
    refreshed_or_updated     varchar(100),
    campo_11                 varchar(100),
    eor                      varchar(100)
);

create table stage_pershing.stage_gact_reg_header
(
    id           bigint generated always as identity
        constraint stage_gact_reg_header_pk
            primary key,
    id_proceso   bigint,
    process_date varchar(100),
    bof          varchar(100),
    campo_2      varchar(100),
    campo_3      varchar(100),
    date_of_data varchar(100),
    campo_5      varchar(100),
    remote_id    varchar(100),
    campo_7      varchar(100),
    run_date     varchar(100),
    campo_9      varchar(100),
    run_time     varchar(100),
    campo_11     varchar(100),
    eor          varchar(100)
);

create table stage_pershing.stage_gact_reg_a
(
    id                                       bigint generated always as identity
        constraint stage_gact_reg_a_pk
            primary key,
    id_proceso                               bigint,
    process_date                             varchar(100),
    transaction_code                         varchar(100),
    record_indicator_value                   varchar(100),
    record_id_sequence_number                integer,
    account_number                           varchar(100),
    cusip_number                             varchar(100),
    campo_6                                  varchar(100),
    underlying_cusip                         varchar(100),
    campo_8                                  varchar(100),
    security_symbol                          varchar(100),
    investment_professional_of_record        varchar(100),
    executing_investment_professional        varchar(100),
    transaction_type                         varchar(100),
    buy_sell_code                            varchar(100),
    open_close_indicator                     varchar(100),
    par_key_code                             varchar(100),
    source_code                              varchar(100),
    maxx_key_code                            integer,
    process_date_sfl                         date,
    trade_date                               date,
    settlement_entry_date                    date,
    campo_21                                 varchar(100),
    source_of_input                          varchar(100),
    reference_number                         varchar(100),
    batch_code                               varchar(100),
    same_day_settlement                      varchar(100),
    contra_account                           varchar(100),
    market_code                              varchar(100),
    blotter_code                             varchar(100),
    cancel_code                              varchar(100),
    correction_code                          varchar(100),
    merket_limit_indicator                   varchar(100),
    legend_code_1                            varchar(100),
    legend_code_2                            varchar(100),
    campo_34                                 varchar(100),
    quantity                                 numeric(45, 20),
    quantity_sign                            varchar(100),
    price_in_trade_currency                  numeric(45, 20),
    campo_38                                 varchar(100),
    price_in_trade_currency_sign             varchar(100),
    currency_indicator_for_price             varchar(100),
    net_amount_in_usd                        numeric(45, 20),
    net_amount_in_usd_sign                   varchar(100),
    principal_in_usd                         numeric(45, 20),
    principal_in_usd_sign                    varchar(100),
    interest_in_usd                          numeric(45, 20),
    interest_in_usd_sign                     varchar(100),
    commision_in_usd                         numeric(45, 20),
    commision_in_usd_sign                    varchar(100),
    tax_in_usd                               numeric(45, 20),
    tax_in_usd_sign                          varchar(100),
    transaction_fee_in_usd                   numeric(45, 20),
    transaction_fee_in_usd_sign              varchar(100),
    misc_fee_in_usd                          numeric(45, 20),
    misc_fee_in_usd_sign                     varchar(100),
    other_fee_in_usd                         numeric(45, 20),
    other_fee_in_usd_sign                    varchar(100),
    tefra_wh_amount_in_usd                   numeric(45, 20),
    tefra_wh_amount_in_usd_sign              varchar(100),
    pershing_charge_in_usd                   numeric(45, 20),
    pershing_charge_in_usd_sign              varchar(100),
    brokerage_charge_in_usd                  numeric(45, 20),
    brokerage_charge_in_usd_sign             varchar(100),
    sales_credit_in_usd                      numeric(45, 20),
    sales_credit_in_usd_sign                 varchar(100),
    settlement_fee_in_usd                    numeric(45, 20),
    settlement_fee_in_usd_sign               varchar(100),
    service_charge_in_usd                    numeric(45, 20),
    service_charge_in_usd_sign               varchar(100),
    markup_markdown_amount_in_usd            numeric(45, 20),
    markup_markdown_amount_in_usd_sign       varchar(100),
    campo_71                                 varchar(100),
    dividend_payable_date                    date,
    campo_73                                 varchar(100),
    dividend_record_date                     date,
    dividend_type                            integer,
    campo_76                                 varchar(100),
    shares_of_record_quantity_for_dividends  numeric(45, 20),
    order_size_quantity                      numeric(45, 20),
    campo_79                                 varchar(100),
    pool_factor                              numeric(45, 20),
    parsed_customer_account_number           varchar(100),
    ibd_number                               varchar(100),
    security_type_code                       varchar(100),
    security_modifier_code                   varchar(100),
    security_calculation_code                varchar(100),
    minor_product_code                       varchar(100),
    foreign_product_indicator                varchar(100),
    with_due_bill_indicator                  varchar(100),
    taxable_municipal_bond_indicator         varchar(100),
    omnibus_indicator                        varchar(100),
    external_order_id                        varchar(100),
    campo_92                                 varchar(100),
    market_value_of_transaction              numeric(45, 20),
    ip_number_parsed                         varchar(100),
    reported_price                           numeric(45, 20),
    reported_price_sign                      varchar(100),
    previous_day_market_value_of_transaction numeric(45, 20),
    price_in_usd                             numeric(45, 20),
    option_root_id                           varchar(100),
    expiration_date                          date,
    put_call_code                            varchar(100),
    strike_price                             numeric(45, 20),
    repo_identifier                          varchar(100),
    taxable                                  varchar(100),
    qualified                                varchar(100),
    expanded_ip_number                       varchar(100),
    expanded_exec_ip_number                  varchar(100),
    expanded_legacy_ip_number                varchar(100),
    campo_109                                varchar(100),
    campo_110                                varchar(100),
    campo_111                                varchar(100),
    eor                                      varchar(100)
);

create table stage_pershing.stage_gact_reg_b
(
    id                                            bigint generated always as identity
        constraint stage_gact_reg_b_pk
            primary key,
    id_proceso                                    bigint,
    process_date                                  varchar(100),
    transaction_code                              varchar(100),
    record_indicator_value                        varchar(100),
    record_id_sequence_number                     integer,
    account_number                                varchar(100),
    security_currency_of_issuance                 varchar(100),
    trade_currency_code                           varchar(100),
    settlement_currency_code                      varchar(100),
    settlement_usd_currency_fx_rate               numeric(45, 20),
    settlement_usd_multiply_divide_code           varchar(100),
    cross_currency_fx_rate                        numeric(45, 20),
    currency_multiply_divide_code                 varchar(100),
    accrued_interest_in_settlement_currency       numeric(45, 20),
    accrued_interest_in_settlement_currency_sign  varchar(100),
    market_code                                   varchar(100),
    internal_reference_for_gloss                  varchar(100),
    ibd_version                                   varchar(100),
    net_amount_in_settlement_currency             numeric(45, 20),
    net_amount_in_settlement_currency_sign        varchar(100),
    principal_amount_in_settlement_currency       numeric(45, 20),
    principal_amount_in_settlement_currency_sign  varchar(100),
    interest_in_settlement_currency               numeric(45, 20),
    interest_in_settlement_currency_sign          varchar(100),
    commission_in_settlement_currency             numeric(45, 20),
    commission_in_settlement_currency_sign        varchar(100),
    tax_in_settlement_currency                    numeric(45, 20),
    tax_in_settlement_currency_sign               varchar(100),
    transaction_fee_in_settlement_currency        numeric(45, 20),
    transaction_fee_in_settlement_currency_sign   varchar(100),
    miscellaneous_fee_in_settlement_currency      numeric(45, 20),
    miscellaneous_fee_in_settlement_currency_sign varchar(100),
    other_fee_in_settlement_currency              numeric(45, 20),
    other_fee_in_settlement_currency_sign         varchar(100),
    sales_credit_in_settlement_currency           numeric(45, 20),
    sales_credit_in_settlement_currency_sign      varchar(100),
    settlement_fee_in_settlement_currency         numeric(45, 20),
    settlement_fee_in_settlement_currency_sign    varchar(100),
    service_charge_in_settlement_currency         numeric(45, 20),
    service_charge_in_settlement_currency_sign    varchar(100),
    markup_markdown_in_settlement_currency        numeric(45, 20),
    markup_markdown_in_settlement_currency_sign   varchar(100),
    global_exchange                               varchar(100),
    number_of_description_lines                   integer,
    last_description_line                         integer,
    description_line_1                            varchar(100),
    description_line_2                            varchar(100),
    description_line_3                            varchar(100),
    description_line_4                            varchar(100),
    description_line_5                            varchar(100),
    description_line_6                            varchar(100),
    description_line_7                            varchar(100),
    description_line_8                            varchar(100),
    description_line_9                            varchar(100),
    description_line_10                           varchar(100),
    description_line_11                           varchar(100),
    description_line_12                           varchar(100),
    security_currency_indicator                   varchar(100),
    market_mnemonic_code                          varchar(100),
    ccy_of_issuance_usd_ccy_fx_rate               numeric(45, 20),
    ccy_of_issuance_usd_multiply_divide_code      varchar(100),
    alternate_security_id_type                    varchar(100),
    alternate_security_id                         varchar(100),
    alternate_security_id_type_2                  varchar(100),
    alternate_security_id_2                       varchar(100),
    international_non_dollar_symbol               varchar(100),
    confirmation_code_1                           varchar(100),
    confirmation_code_2                           varchar(100),
    confirmation_code_3                           varchar(100),
    confirmation_code_4                           varchar(100),
    pmp                                           numeric(45, 20),
    total_amount_mark_up_down                     numeric(45, 20),
    total_amount_mark_up_down_sign                varchar(100),
    pmp_percent                                   numeric(45, 20),
    campo_73                                      varchar(100),
    eor                                           varchar(100)
);

create table stage_pershing.stage_gact_reg_trailer
(
    id                       bigint generated always as identity
        constraint stage_gact_reg_trailer_pk
            primary key,
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
    eor                      varchar(100)
);

create table stage_pershing.stage_gcus_reg_header
(
    id                   bigint generated always as identity
        constraint stage_gcus_reg_header_pk
            primary key,
    id_proceso           bigint,
    process_date         varchar(100),
    bof                  varchar(100),
    campo_2              varchar(100),
    campo_3              varchar(100),
    date_of_data         varchar(100),
    campo_5              varchar(100),
    remote_id            varchar(100),
    campo_7              varchar(100),
    run_date             varchar(100),
    campo_9              varchar(100),
    run_time             varchar(100),
    campo_11             varchar(100),
    refreshed_or_updated varchar(100),
    campo_13             varchar(100),
    eof                  varchar(100)
);

create table stage_pershing.stage_gcus_reg_a
(
    id                                     bigint generated always as identity
        constraint stage_gcus_reg_a_pk
            primary key,
    id_proceso                             bigint,
    process_date                           varchar(100),
    transaction_code                       varchar(100),
    record_indicator_value                 varchar(100),
    record_id_sequence_number              integer,
    account_number                         varchar(100),
    cusip_number                           varchar(100),
    portfolio_currency                     varchar(100),
    campo_7                                varchar(100),
    underlying_cusip_number                varchar(100),
    country_code                           varchar(100),
    campo_10                               varchar(100),
    ip_record_number                       varchar(100),
    ibd_number                             varchar(100),
    currency_security_indicator            varchar(100),
    issue_currency                         varchar(100),
    datestamp_trade_date                   date,
    datestamp_settlement_date              date,
    trade_date_quantity                    numeric(45, 20),
    trade_date_quantity_sign               varchar(100),
    settlement_date_quantity               numeric(45, 20),
    settlement_date_quantity_sign          varchar(100),
    seg_quantity                           numeric(45, 20),
    seg_quantity_sign                      varchar(100),
    safekeeping_quantity                   numeric(45, 20),
    safekeeping_sign                       varchar(100),
    transfer_quantity                      numeric(45, 20),
    transfer_quantity_sign                 varchar(100),
    pending_transfer_quantity              numeric(45, 20),
    pending_transfer_quantity_sign         varchar(100),
    legal_transfer_quantity                numeric(45, 20),
    legal_transfer_quantity_sign           varchar(100),
    tendered_quantity                      numeric(45, 20),
    tendered_quantity_sign                 varchar(100),
    pending_papers                         numeric(45, 20),
    pending_papers_sign                    varchar(100),
    short_against_the_box_quantity         numeric(45, 20),
    short_against_the_box_quantity_sign    varchar(100),
    networked_quantity                     numeric(45, 20),
    networked_quantity_sign                varchar(100),
    pending_split_quantity                 numeric(45, 20),
    pending_split_quantity_sign            varchar(100),
    quantity_covering_options              numeric(45, 20),
    quantity_covering_options_sign         varchar(100),
    trade_date_quantity_bought             numeric(45, 20),
    trade_date_quantity_bought_sign        varchar(100),
    trade_date_quantity_sold               numeric(45, 20),
    trade_date_quantity_sold_sign          varchar(100),
    fed_rquirement                         numeric(45, 20),
    fed_rquirement_sign                    varchar(100),
    house_margin_requirement               numeric(45, 20),
    house_margin_requirement_sign          varchar(100),
    nyse_requirement                       numeric(45, 20),
    nyse_requirement_sign                  varchar(100),
    equity_requirment                      numeric(45, 20),
    equity_requirment_sign                 varchar(100),
    security_symbol                        varchar(100),
    security_type                          varchar(100),
    security_mod                           varchar(100),
    security_calc                          varchar(100),
    minor_product_code                     varchar(100),
    network_eligibility_indicator          varchar(100),
    strike_price                           numeric(45, 20),
    strike_price_sign                      varchar(100),
    expiration_maturity_date               date,
    contract_size                          numeric(45, 20),
    conversion_ratio                       numeric(45, 20),
    account_short_name                     varchar(100),
    state_code                             varchar(100),
    country_code_account                   varchar(100),
    campo_69                               varchar(100),
    number_security_description_lines      integer,
    security_description_line_1            varchar(100),
    security_description_line_2            varchar(100),
    security_description_line_3            varchar(100),
    security_description_line_4            varchar(100),
    security_description_line_5            varchar(100),
    security_description_line_6            varchar(100),
    dividend_option                        varchar(100),
    long_term_capital_gains_option         varchar(100),
    short_term_capital_gains_option        varchar(100),
    firm_trading_indicator                 varchar(100),
    position_currency_security             varchar(100),
    trade_date_liquidating_value           numeric(45, 20),
    trade_date_liquidating_value_sign      varchar(100),
    pool_factor                            numeric(45, 20),
    pool_factor_sign                       varchar(100),
    exchange_rate                          numeric(45, 20),
    exchange_rate_sign                     varchar(100),
    settlement_date_liquidating_value      numeric(45, 20),
    settlement_date_liquidating_value_sign varchar(100),
    campo_90                               varchar(100),
    alternate_security_id_type             varchar(100),
    alternate_security_id                  varchar(100),
    campo_93                               varchar(100),
    eor                                    varchar(100)
);

create table stage_pershing.stage_gcus_reg_b
(
    id                                                           bigint generated always as identity
        constraint stage_gcus_reg_b_pk
            primary key,
    id_proceso                                                   bigint,
    process_date                                                 varchar(100),
    transaction_code                                             varchar(100),
    record_indicator_value                                       varchar(100),
    recor_id_sequence_number                                     integer,
    account_number                                               varchar(100),
    cusip_number                                                 varchar(100),
    position_currency                                            varchar(100),
    campo_7                                                      varchar(100),
    underlying_cusip_number                                      varchar(100),
    country_code                                                 varchar(100),
    campo_10                                                     varchar(100),
    ip_record_number                                             varchar(100),
    ibd_number                                                   varchar(100),
    fully_paid_lending_quantity                                  numeric(45, 20),
    fully_paid_lending_quantity_sign                             varchar(100),
    fully_paid_lending_quantity_collateral_amount                numeric(45, 20),
    fully_paid_lending_quantity_collateral_amount_sign           varchar(100),
    option_root_id                                               varchar(100),
    expiration_date                                              date,
    call_put_indicator                                           varchar(100),
    strike_price                                                 numeric(45, 20),
    trade_date_repo_quantity                                     numeric(45, 20),
    trade_date_repo_quantity_sign                                varchar(100),
    settlement_date_repo_quantity                                numeric(45, 20),
    settlement_date_repo_quantity_sign                           varchar(100),
    trade_date_reverse_repo_quantity                             numeric(45, 20),
    trade_date_reverse_repo_quantity_sign                        varchar(100),
    settlement_date_reverse_repo_quantity                        numeric(45, 20),
    settlement_date_reverse_repo_quantity_sign                   varchar(100),
    collateral_pledge_quantity                                   numeric(45, 20),
    collateral_pledge_quantity_sign                              varchar(100),
    corporate_exec_serv_collateral_pledge_quantity               numeric(45, 20),
    corporate_exec_serv_collateral_pledge_quantity_sign          varchar(100),
    trade_date_repo_liquidating_value                            numeric(45, 20),
    trade_date_repo_liquidating_value_sign                       varchar(100),
    settlement_date_repo_liquidating_value                       numeric(45, 20),
    settlement_date_repo_liquidating_value_sign                  varchar(100),
    trade_date_reverse_repo_liquidating_value                    numeric(45, 20),
    trade_date_reverse_repo_liquidating_value_sign               varchar(100),
    settlement_date_reverse_repo_liquidating_value               numeric(45, 20),
    settlement_date_reverse_repo_liquidating_value_sign          varchar(100),
    collateral_pledge_liquidating_value                          numeric(45, 20),
    collateral_pledge_liquidating_value_sign                     varchar(100),
    corporate_exec_serv_collateral_pledge_liquidating_value      numeric(45, 20),
    corporate_exec_serv_collateral_pledge_liquidating_value_sign varchar(100),
    trade_date_repo_loan_amount                                  numeric(45, 20),
    trade_date_repo_loan_amount_sign                             varchar(100),
    settlement_date_repo_loan_amount                             numeric(45, 20),
    settlement_date_repo_loan_amount_sign                        varchar(100),
    trade_date_reverse_repo_loan_amount                          numeric(45, 20),
    trade_date_reverse_repo_loan_amount_sign                     varchar(100),
    settlement_date_reverse_repo_loan_amount                     numeric(45, 20),
    settlement_date_reverse_repo_loan_amount_sign                varchar(100),
    accrued_interes_value                                        numeric(45, 20),
    accrued_interes_value_sign                                   varchar(100),
    dividend_or_coupon_rate                                      numeric(45, 20),
    pending_split_quantity_liquidating_value                     numeric(45, 20),
    pending_split_quantity_liquidating_value_sign                varchar(100),
    campo_58                                                     varchar(100),
    internal_non_dollar_symbol                                   varchar(100),
    pledged_quantity                                             numeric(45, 20),
    pledged_quantity_sign                                        varchar(100),
    campo_62                                                     varchar(100),
    eor                                                          varchar(100)
);

create table stage_pershing.stage_gcus_reg_trailer
(
    id                       bigint generated always as identity
        constraint stage_gcus_reg_trailer_pk
            primary key,
    id_proceso               bigint,
    process_date             varchar(100),
    eof                      varchar(100),
    campo_2                  varchar(100),
    campo_3                  varchar(100),
    date_of_data             varchar(100),
    campo_5                  varchar(100),
    remote_id                varchar(100),
    campo_7                  varchar(100),
    number_detail_of_records integer,
    campo_9                  varchar(100),
    refreshed_or_updated     varchar(100),
    campo_11                 varchar(100),
    eor                      varchar(100)
);

create table stage_pershing.stage_gmon_reg_header
(
    id           bigint generated always as identity
        constraint stage_gmon_reg_header_pk
            primary key,
    id_proceso   bigint,
    process_date varchar(100),
    bof          varchar(100),
    campo_2      varchar(100),
    campo_3      varchar(100),
    date_of_data varchar(100),
    campo_5      varchar(100),
    remote_id    varchar(100),
    campo_7      varchar(100),
    run_date     varchar(100),
    campo_9      varchar(100),
    run_time     varchar(100),
    campo_11     varchar(100),
    eor          varchar(100)
);

create table stage_pershing.stage_gmon_reg_a
(
    id                         bigint generated always as identity
        constraint stage_gmon_reg_a_pk
            primary key,
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
    eor                        varchar(100)
);

create table stage_pershing.stage_gmon_reg_b
(
    id                             bigint generated always as identity
        constraint stage_gmon_reg_b_pk
            primary key,
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
    eor                            varchar(100)
);

create table stage_pershing.stage_gmon_reg_trailer
(
    id                       bigint generated always as identity
        constraint stage_gmon_reg_trailer_pk
            primary key,
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
    eor                      varchar(100)
);

create table stage_pershing.stage_acct_reg_header
(
    id                   bigint generated always as identity
        constraint stage_acct_reg_header_pk
            primary key,
    id_proceso           bigint,
    process_date         varchar(100),
    bof                  varchar(100),
    campo_2              varchar(100),
    campo_3              varchar(100),
    date_of_data         varchar(100),
    campo_5              varchar(100),
    remote_id            varchar(100),
    campo_7              varchar(100),
    run_date             varchar(100),
    campo_9              varchar(100),
    run_time             varchar(100),
    campo_11             varchar(100),
    refreshed_or_updated varchar(100),
    campo_13             varchar(100),
    eor                  varchar(100)
);

create table stage_pershing.stage_acct_reg_a
(
    id                                        bigint generated always as identity
        constraint stage_acct_reg_a_pk
            primary key,
    id_proceso                                bigint,
    process_date                              varchar(100),
    transaction_code                          varchar(100),
    record_indicator_value                    varchar(100),
    record_id_sequence_number                 integer,
    account_number                            varchar(100),
    ibd_number                                varchar(100),
    campo_6                                   varchar(100),
    ip_number                                 varchar(100),
    account_short_name                        varchar(100),
    campo_9                                   varchar(100),
    transaction_type                          varchar(100),
    autotitled_usertitled_account             varchar(100),
    account_type_code                         varchar(100),
    registration_type                         varchar(100),
    campo_14                                  varchar(100),
    number_of_account_title_lines             varchar(100),
    account_registration_line_1               varchar(100),
    account_registration_line_2               varchar(100),
    account_registration_line_3               varchar(100),
    account_registration_line_4               varchar(100),
    account_registration_line_5               varchar(100),
    account_registration_line_6               varchar(100),
    registration_type_detail                  varchar(100),
    date_account_opened                       date,
    date_account_information_updated          date,
    account_status_indicator                  varchar(100),
    pending_closed_date                       date,
    date_account_closed                       date,
    closing_notice_date                       date,
    account_reactivated_date                  date,
    date_account_reopened                     date,
    proceeds                                  varchar(100),
    transfer_instructions                     varchar(100),
    income_isntructions                       varchar(100),
    number_of_confirms_for_thi_account        varchar(100),
    number_of_statements_for_this_account     varchar(100),
    investment_objetive_trans_code            varchar(100),
    comments_act                              varchar(100),
    employer_shotname                         varchar(100),
    employers_cusip                           varchar(100),
    employers_symbol                          varchar(100),
    margin_privileges_revoked                 varchar(100),
    statement_review_date                     date,
    margin_papers_on_file                     varchar(100),
    option_papers_on_file                     varchar(100),
    campo_45                                  varchar(100),
    good_faith_margin                         varchar(100),
    ip_discretion_granted                     varchar(100),
    invest_advisor_discretion_granted         varchar(100),
    third_party_discretion_granted            varchar(100),
    third_party_name                          varchar(100),
    risk_factor_code                          varchar(100),
    investment_objetive_code                  varchar(100),
    option_equities                           varchar(100),
    option_index                              varchar(100),
    option_debt                               varchar(100),
    option_currency                           varchar(100),
    option_level_1                            varchar(100),
    option_level_2                            varchar(100),
    option_level_3                            varchar(100),
    option_level_4                            varchar(100),
    option_call_limits                        integer,
    option_put_limits                         integer,
    option_total_limits_of_puts_and_calls     integer,
    non_us_dollar_trading                     varchar(100),
    campo_65                                  varchar(100),
    non_customer_indicator                    varchar(100),
    third_party_fee_indicator                 varchar(100),
    third_party_fee_approval_date             date,
    intermediary_account_ind                  varchar(100),
    commission_schedule                       varchar(100),
    group_index                               varchar(100),
    money_manager_id                          varchar(100),
    money_manager_objective_id                varchar(100),
    dtc_id_confirm_number                     varchar(100),
    caps_master_mnemonic                      varchar(100),
    employee_id                               varchar(100),
    prime_broker_free_fund_indicator          varchar(100),
    fee_based_account_indicator               varchar(100),
    campo_79                                  varchar(100),
    fee_based_termination_date                date,
    campo_81                                  varchar(100),
    plan_name                                 varchar(100),
    self_directed_401_k_account_type          varchar(100),
    plan_type                                 varchar(100),
    plan_number                               varchar(100),
    employee_or_employee_relative             varchar(100),
    commission_percent_discount               numeric(45, 20),
    ind_12_b_1_fee_blocking                   varchar(100),
    name_of_ip_signed_new_account_form        varchar(100),
    date_of_ip_signed_new_account_form        date,
    name_of_principal_signed_new_account_form varchar(100),
    date_of_principal_signed_new_account_form date,
    politically_exposed_person                varchar(100),
    private_banking_account                   varchar(100),
    foreign_bank_account                      varchar(100),
    initial_source_of_funds                   varchar(100),
    usa_patriot_act_exempt_reason             varchar(100),
    primary_country_of_citizenship            varchar(100),
    country_of_residence                      varchar(100),
    birth_date                                date,
    age_based_fund_roll_exempt                varchar(100),
    money_fundreform_retail                   varchar(100),
    trusted_contact_status                    varchar(100),
    regulatory_account_type_category          varchar(100),
    account_managed_by_trust_comp_id          varchar(100),
    voting_auth                               varchar(100),
    campo_107                                 varchar(100),
    campo_108                                 varchar(100),
    campo_109                                 varchar(100),
    campo_110                                 varchar(100),
    customer_type                             varchar(100),
    campo_112                                 varchar(100),
    campo_113                                 varchar(100),
    campo_114                                 varchar(100),
    campo_115                                 varchar(100),
    campo_116                                 varchar(100),
    fulfillment_method                        varchar(100),
    credit_interest_indicator                 varchar(100),
    ama_indicator                             varchar(100),
    campo_120                                 varchar(100),
    eor                                       varchar(100)
);

create table stage_pershing.stage_acct_reg_b
(
    id                                            bigint generated always as identity
        constraint stage_acct_reg_b_pk
            primary key,
    id_proceso                                    bigint,
    process_date                                  varchar(100),
    transaction_code                              varchar(100),
    record_indicator_value                        varchar(100),
    record_id_sequence_number                     integer,
    account_number                                varchar(100),
    ibd_number                                    varchar(100),
    campo_6                                       varchar(100),
    ip_number                                     varchar(100),
    account_short_name                            varchar(100),
    campo_9                                       varchar(100),
    tax_id_type                                   varchar(100),
    tax_id_number                                 varchar(100),
    date_tax_id_applied_for                       date,
    w_8_w_9_indicator                             varchar(100),
    w_8_w_9_date_signed                           date,
    w_8_w_9_effective_date                        date,
    w_8_w_9_document_type                         varchar(100),
    tax_status                                    varchar(100),
    b_notice_reason_code                          varchar(100),
    first_b_notice_status                         varchar(100),
    date_first_b_notice_status_issued_enforced    date,
    campo_21                                      varchar(100),
    date_first_notice_status_satisfied            date,
    second_b_notice_status                        varchar(100),
    date_second_b_notice_status_issued_enforced   date,
    campo_25                                      varchar(100),
    date_second_b_notice_status_satisfied         date,
    c_notice_status                               varchar(100),
    date_c_notice_status_issued_enforced          date,
    date_c_notice_status_satisfied                date,
    old_account_number                            varchar(100),
    original_account_open_date                    date,
    unidentified_large_trader_id                  varchar(100),
    campo_33                                      varchar(100),
    large_trader_type_code                        varchar(100),
    large_trader_type_last_change_date            date,
    campo_36                                      varchar(100),
    campo_37                                      varchar(100),
    initial_source_of_funds_other                 varchar(100),
    finance_away                                  varchar(100),
    account_funding_date                          date,
    campo_41                                      varchar(100),
    statement_currency_code                       varchar(100),
    future_statement_currency_code                varchar(100),
    future_statement_currency_code_effective_date date,
    account_level_routing_code_1                  varchar(100),
    account_level_routing_code_2                  varchar(100),
    account_level_routing_code_3                  varchar(100),
    account_level_routing_code_4                  varchar(100),
    campo_49                                      varchar(100),
    self_directed_ind                             varchar(100),
    digital_advice_ind                            varchar(100),
    pte_account_ind                               varchar(100),
    campo_53                                      varchar(100),
    first_ip                                      varchar(100),
    second_ip                                     varchar(100),
    third_ip                                      varchar(100),
    fourth_ip                                     varchar(100),
    fifth_ip                                      varchar(100),
    sixth_ip                                      varchar(100),
    seventh_ip                                    varchar(100),
    eighth_ip                                     varchar(100),
    ninth_ip                                      varchar(100),
    tenth_ip                                      varchar(100),
    alert_im_acornym                              varchar(100),
    alert_im_access_code                          varchar(100),
    broker_acronym                                varchar(100),
    cross_reference_indicator                     varchar(100),
    bny_trust_indicator                           varchar(100),
    source_of_asset_at_acct_opening               varchar(100),
    commission_doscount_code                      varchar(100),
    external_account_number                       varchar(100),
    confirmation_suppression_indicator            varchar(100),
    date_last_mail_sent                           date,
    date_last_mail_sent_outside                   date,
    campo_75                                      varchar(100),
    fully_paid_lending_agreement_indicator        varchar(100),
    fully_paid_lending_agreement_date             date,
    custodian_account_type                        varchar(100),
    mifid_customer_categorization                 varchar(100),
    cash_management_tran_code                     varchar(100),
    sweep_status_indicator                        varchar(100),
    date_sweep_activated                          date,
    date_sweep_details_changed                    date,
    cober_margin_debit_indicator                  varchar(100),
    campo_85                                      varchar(100),
    first_fund_sweep_account_id                   varchar(100),
    firstfund_sweep_account_percent               numeric(45, 20),
    first_fundsweep_account_redemption_priority   varchar(100),
    second_fund_sweep_account_id                  varchar(100),
    second_fund_sweep_account_percent             numeric(45, 20),
    second_fundsweep_account_redemption_priority  varchar(100),
    type_of_bank_account                          varchar(100),
    banklink_aba_number                           varchar(100),
    banklink_dda_number                           varchar(100),
    campo_95                                      varchar(100),
    fund_bank_indicator                           varchar(100),
    campo_97                                      varchar(100),
    w_9_corp_tax_classification_code              varchar(100),
    campo_99                                      varchar(100),
    combined_margin_acct_indicator                varchar(100),
    pledge_collateral_account_indicator           varchar(100),
    finra_institutional_account_code              varchar(100),
    proposed_account_reference_id                 varchar(100),
    advisor_model_id                              varchar(100),
    firm_model_style_id                           varchar(100),
    campo_106                                     varchar(100),
    campo_107                                     varchar(100),
    campo_108                                     varchar(100),
    dvp_restriction_code                          varchar(100),
    dvp_restriction_exp_date                      date,
    escheatment_withholding_ind                   varchar(100),
    campo_112                                     varchar(100),
    source_of_origination                         varchar(100),
    source_of_persona                             varchar(100),
    client_onboarding_method                      varchar(100),
    tax_filing_code                               varchar(100),
    campo_117                                     varchar(100),
    campo_118                                     varchar(100),
    nor_purpose_collateral_acct_ind               varchar(100),
    eor                                           varchar(100)
);

create table stage_pershing.stage_acct_reg_c
(
    id                               bigint generated always as identity
        constraint stage_acct_reg_c_pk
            primary key,
    id_proceso                       bigint,
    process_date                     varchar(100),
    transaction_code                 varchar(100),
    record_indicator_value           varchar(100),
    record_id_sequence_number        integer,
    account_number                   varchar(100),
    ibd_number                       varchar(100),
    campo_6                          varchar(100),
    ip_number                        varchar(100),
    account_short_name               varchar(100),
    campo_9                          varchar(100),
    addr_1_trx_code                  varchar(100),
    addr_1_special_handling_ind      varchar(100),
    addr_1_delivery_id               varchar(100),
    addr_1_attention_line_prefix     varchar(100),
    addr_1_attention_line_detail     varchar(100),
    addr_1_line_1                    varchar(100),
    addr_1_line_2                    varchar(100),
    addr_1_line_3                    varchar(100),
    addr_1_line_4                    varchar(100),
    addr_1_city_state                varchar(100),
    addr_1_country_code              varchar(100),
    campo_21                         varchar(100),
    campo_22                         varchar(100),
    campo_23                         varchar(100),
    campo_24                         varchar(100),
    campo_25                         varchar(100),
    campo_26                         varchar(100),
    campo_27                         varchar(100),
    campo_28                         varchar(100),
    campo_29                         varchar(100),
    campo_30                         varchar(100),
    addr_2_trx_code                  varchar(100),
    addr_2_special_handling_ind      varchar(100),
    addr_2_delivery_id               varchar(100),
    addr_2_attention_line_prefix     varchar(100),
    addr_2_attention_line_detail     varchar(100),
    addr_2_line_1                    varchar(100),
    addr_2_line_2                    varchar(100),
    addr_2_line_3                    varchar(100),
    addr_2_line_4                    varchar(100),
    addr_2_city_state                varchar(100),
    addr_2_country_code              varchar(100),
    account_description              varchar(100),
    set_as_mail_addr_2_ind           varchar(100),
    campo_44                         varchar(100),
    principal_billing_allocation_pct numeric(45, 20),
    campo_46                         varchar(100),
    seasonal_addr_id_1               varchar(100),
    from_date_1                      date,
    to_date_1                        date,
    seasonal_addr_id_2               varchar(100),
    from_date_2                      date,
    to_date_2                        date,
    seasonal_addr_id_3               varchar(100),
    from_date_3                      date,
    to_date_3                        date,
    cost_basis_acct_system           varchar(100),
    disposition_method_mutual_funds  varchar(100),
    disposition_method_other         varchar(100),
    disposition_method_stocks        varchar(100),
    campo_60                         varchar(100),
    amortize_taxable_premium_bonds   varchar(100),
    accrue_market_disc_based_on      varchar(100),
    accrue_market_disc_income        varchar(100),
    campo_64                         varchar(100),
    campo_65                         varchar(100),
    campo_66                         varchar(100),
    eor                              varchar(100)
);

create table stage_pershing.stage_acct_reg_d
(
    id                           bigint generated always as identity
        constraint stage_acct_reg_d_pk
            primary key,
    id_proceso                   bigint,
    process_date                 varchar(100),
    transaction_code             varchar(100),
    record_indicator_value       varchar(100),
    record_id_sequence_number    integer,
    account_number               varchar(100),
    ibd_number                   varchar(100),
    campo_6                      varchar(100),
    ip_number                    varchar(100),
    account_short_name           varchar(100),
    campo_9                      varchar(100),
    addr_3_trx_code              varchar(100),
    addr_3_special_handling_ind  varchar(100),
    addr_3_delivery_id           varchar(100),
    addr_3_attention_line_prefix varchar(100),
    addr_3_attention_line_detail varchar(100),
    addr_3_line_1                varchar(100),
    addr_3_line_2                varchar(100),
    addr_3_line_3                varchar(100),
    addr_3_line_4                varchar(100),
    addr_3_city_state            varchar(100),
    addr_3_country_code          varchar(100),
    set_as_mail_addr_3_ind       varchar(100),
    campo_22                     varchar(100),
    addr_4_trx_code              varchar(100),
    addr_4_special_handling_ind  varchar(100),
    addr_4_delivery_id           varchar(100),
    addr_4_attention_line_prefix varchar(100),
    addr_4_attention_line_detail varchar(100),
    addr_4_line_1                varchar(100),
    addr_4_line_2                varchar(100),
    addr_4_line_3                varchar(100),
    addr_4_line_4                varchar(100),
    addr_4_city_state            varchar(100),
    addr_4_country_code          varchar(100),
    set_as_mail_addr_4_ind       varchar(100),
    campo_35                     varchar(100),
    eor                          varchar(100)
);

create table stage_pershing.stage_acct_reg_e
(
    id                           bigint generated always as identity
        constraint stage_acct_reg_e_pk
            primary key,
    id_proceso                   bigint,
    process_date                 varchar(100),
    transaction_code             varchar(100),
    record_indicator_value       varchar(100),
    record_id_sequence_number    integer,
    account_number               varchar(100),
    ibd_number                   varchar(100),
    campo_6                      varchar(100),
    ip_number                    varchar(100),
    account_short_name           varchar(100),
    campo_9                      varchar(100),
    addr_5_trx_code              varchar(100),
    addr_5_special_handling_ind  varchar(100),
    addr_5_delivery_id           varchar(100),
    addr_5_attention_line_prefix varchar(100),
    addr_5_attention_line_detail varchar(100),
    addr_5_line_1                varchar(100),
    addr_5_line_2                varchar(100),
    addr_5_line_3                varchar(100),
    addr_5_line_4                varchar(100),
    addr_5_city_state            varchar(100),
    addr_5_country_code          varchar(100),
    set_as_mail_addr_5_ind       varchar(100),
    campo_22                     varchar(100),
    addr_6_trx_code              varchar(100),
    addr_6_special_handling_ind  varchar(100),
    addr_6_delivery_id           varchar(100),
    addr_6_attention_line_prefix varchar(100),
    addr_6_attention_line_detail varchar(100),
    addr_6_line_1                varchar(100),
    addr_6_line_2                varchar(100),
    addr_6_line_3                varchar(100),
    addr_6_line_4                varchar(100),
    addr_6_city_state            varchar(100),
    addr_6_country_code          varchar(100),
    set_as_mail_addr_6_ind       varchar(100),
    campo_35                     varchar(100),
    eor                          varchar(100)
);

create table stage_pershing.stage_acct_reg_f
(
    id                           bigint generated always as identity
        constraint stage_acct_reg_f_pk
            primary key,
    id_proceso                   bigint,
    process_date                 varchar(100),
    transaction_code             varchar(100),
    record_indicator_value       varchar(100),
    record_id_sequence_number    integer,
    account_number               varchar(100),
    ibd_number                   varchar(100),
    campo_6                      varchar(100),
    ip_number                    varchar(100),
    account_short_name           varchar(100),
    campo_9                      varchar(100),
    addr_7_trx_code              varchar(100),
    addr_7_special_handling_ind  varchar(100),
    addr_7_delivery_id           varchar(100),
    addr_7_attention_line_prefix varchar(100),
    addr_7_attention_line_detail varchar(100),
    addr_7_line_1                varchar(100),
    addr_7_line_2                varchar(100),
    addr_7_line_3                varchar(100),
    addr_7_line_4                varchar(100),
    addr_7_city_state            varchar(100),
    addr_7_country_code          varchar(100),
    set_as_mail_addr_7_ind       varchar(100),
    campo_22                     varchar(100),
    eor                          varchar(100)
);

create table stage_pershing.stage_acct_reg_w
(
    id                               bigint generated always as identity
        constraint stage_acct_reg_w_pk
            primary key,
    id_proceso                       bigint,
    process_date                     varchar(100),
    transaction_code                 varchar(100),
    record_indicator_value           varchar(100),
    record_id_sequence_number        integer,
    account_number                   varchar(100),
    ibd_number                       varchar(100),
    campo_6                          varchar(100),
    ip_number                        varchar(100),
    account_short_name               varchar(100),
    campo_9                          varchar(100),
    record_transaction_code          varchar(100),
    non_us_dollar_trading            varchar(100),
    base_currency                    varchar(100),
    income_currency                  varchar(100),
    statement_language               varchar(100),
    statement_format_code            varchar(100),
    msrb_statement_ind               varchar(100),
    campo_17                         varchar(100),
    pep                              varchar(100),
    first_name_pep                   varchar(100),
    last_name_pep                    varchar(100),
    suffix_pep                       varchar(100),
    political_office_held            varchar(100),
    country_of_office                varchar(100),
    foreign_bank_account_ind         varchar(100),
    foreign_bank_cert_date           date,
    foreign_bank_cert_exp_date       date,
    central_bank_ind                 varchar(100),
    acct_foreign_financial_inst      varchar(100),
    foreign_bank_acct_oper_1         varchar(100),
    foreign_bank_acct_oper_2         varchar(100),
    foreign_bank_acct_oper_3         varchar(100),
    number_people_own                varchar(100),
    proprietary_acct_owned           varchar(100),
    campo_34                         varchar(100),
    tel_1_transaction_code           varchar(100),
    tel_1_us_ind                     varchar(100),
    tel_1_type_id                    varchar(100),
    tel_1_number                     varchar(100),
    tel_1_extension                  varchar(100),
    tel_2_transaction_code           varchar(100),
    tel_2_us_ind                     varchar(100),
    tel_2_type_id                    varchar(100),
    tel_2_number                     varchar(100),
    tel_2_extension                  varchar(100),
    tel_3_transaction_code           varchar(100),
    tel_3_us_ind                     varchar(100),
    tel_3_type_id                    varchar(100),
    tel_3_number                     varchar(100),
    tel_3_extension                  varchar(100),
    tel_4_transaction_code           varchar(100),
    tel_4_us_ind                     varchar(100),
    tel_4_type_id                    varchar(100),
    tel_4_number                     varchar(100),
    tel_4_extension                  varchar(100),
    tel_5_transaction_code           varchar(100),
    tel_5_us_ind                     varchar(100),
    tel_5_type_id                    varchar(100),
    tel_5_number                     varchar(100),
    tel_5_extension                  varchar(100),
    tel_6_transaction_code           varchar(100),
    tel_6_us_ind                     varchar(100),
    tel_6_type_id                    varchar(100),
    tel_6_number                     varchar(100),
    tel_6_extension                  varchar(100),
    tel_7_transaction_code           varchar(100),
    tel_7_us_ind                     varchar(100),
    tel_7_type_id                    varchar(100),
    tel_7_number                     varchar(100),
    tel_7_extension                  varchar(100),
    tel_8_transaction_code           varchar(100),
    tel_8_us_ind                     varchar(100),
    tel_8_type_id                    varchar(100),
    tel_8_number                     varchar(100),
    tel_8_extension                  varchar(100),
    email_address                    varchar(100),
    external_position_ind            varchar(100),
    purge_eligible_ind               varchar(100),
    advisory_acct_ind                varchar(100),
    product_profile_code             varchar(100),
    cents_per_share_discount         integer,
    campo_81                         varchar(100),
    option_disclosure_date           date,
    campo_83                         varchar(100),
    country_acct_level_tax_residency varchar(100),
    eor                              varchar(100)
);

create table stage_pershing.stage_acct_reg_trailer
(
    id                       bigint generated always as identity
        constraint stage_acct_reg_trailer_pk
            primary key,
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
    eor                      varchar(100)
);

create table stage_pershing.stage_ptld_file
(
    id           bigint generated always as identity
        constraint stage_ptld_file_pk
            primary key,
    id_proceso   bigint,
    process_date varchar(100),
    linea        varchar(1000)
);

create table stage_pershing.stage_potl_file
(
    id           bigint generated always as identity
        constraint stage_potl_file_pk
            primary key,
    id_proceso   bigint,
    process_date varchar(100),
    linea        varchar(1000)
);

create table stage_pershing.stage_gtol_file
(
    id           bigint generated always as identity
        constraint stage_gtol_file_pk
            primary key,
    id_proceso   bigint,
    process_date varchar(100),
    linea        varchar(2000)
);

create table stage_pershing.stage_capt_file
(
    id           bigint generated always as identity
        constraint stage_capt_file_pk
            primary key,
    id_proceso   bigint,
    process_date varchar(100),
    linea        varchar(1000)
);



--========================================================================
--========================================================================
--========================================================================
--Creación de rutinas schema stage_pershing
create function stage_pershing.fn_extrae_isrc_reg_header(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, bof character varying, campo_2 character varying, campo_3 character varying, date_of_data character varying, campo_5 character varying, remote_id character varying, campo_7 character varying, run_date character varying, campo_9 character varying, run_time character varying, campo_11 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as bof,
        substr(sfl_file.linea, 19, 18)::VARCHAR(100) as campo_2,
        substr(sfl_file.linea, 37, 10)::VARCHAR(100) as campo_3,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 14)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 86, 10)::VARCHAR(100) as run_date,
        substr(sfl_file.linea, 96, 1)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 97, 8)::VARCHAR(100) as run_time,
        substr(sfl_file.linea, 105, 145)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 250, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isrc_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 3)		= 'SRA'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isrc_reg_a(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_secuence_id character varying, record_id_number character varying, change_id character varying, source_code character varying, source_code_desc_line_1 character varying, source_code_desc_line_2 character varying, source_code_desc_line_3 character varying, tax_status character varying, campo_10 character varying, user_id character varying, date_added character varying, date_updated character varying, ira_income_eligible character varying, retail_income_eligible character varying, customer_firm character varying, cerdit_debit character varying, statement_ind character varying, statement_act_sum_ind character varying, statement_act_sum_number character varying, statement_trx_sum_ind character varying, statement_trx_sum_number character varying, statement_distrib_ind character varying, statement_distrib_number character varying, statement_distrib_tax_ind character varying, statement_div_ind character varying, statement_div_number character varying, statement_div_tax_ind character varying, pershing_depart character varying, pershing_grp character varying, campo_31 character varying, user_id_added character varying, user_id_updated character varying, campo_34 character varying, portfolio_eligible_ind character varying, reinvest_ind character varying, campo_37 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_secuence_id,
        substr(sfl_file.linea, 4, 6)::VARCHAR(100) as record_id_number,
        substr(sfl_file.linea, 10, 1)::VARCHAR(100) as change_id,
        substr(sfl_file.linea, 11, 3)::VARCHAR(100) as source_code,
        substr(sfl_file.linea, 14, 26)::VARCHAR(100) as source_code_desc_line_1,
        substr(sfl_file.linea, 40, 26)::VARCHAR(100) as source_code_desc_line_2,
        substr(sfl_file.linea, 66, 26)::VARCHAR(100) as source_code_desc_line_3,
        substr(sfl_file.linea, 92, 3)::VARCHAR(100) as tax_status,
        substr(sfl_file.linea, 95, 3)::VARCHAR(100) as campo_10,
        substr(sfl_file.linea, 98, 8)::VARCHAR(100) as user_id,
        substr(sfl_file.linea, 106, 8)::VARCHAR(100) as date_added,
        substr(sfl_file.linea, 114, 8)::VARCHAR(100) as date_updated,
        substr(sfl_file.linea, 122, 1)::VARCHAR(100) as ira_income_eligible,
        substr(sfl_file.linea, 123, 1)::VARCHAR(100) as retail_income_eligible,
        substr(sfl_file.linea, 124, 1)::VARCHAR(100) as customer_firm,
        substr(sfl_file.linea, 125, 1)::VARCHAR(100) as cerdit_debit,
        substr(sfl_file.linea, 126, 4)::VARCHAR(100) as statement_ind,
        substr(sfl_file.linea, 130, 4)::VARCHAR(100) as statement_act_sum_ind,
        substr(sfl_file.linea, 134, 2)::VARCHAR(100) as statement_act_sum_number,
        substr(sfl_file.linea, 136, 4)::VARCHAR(100) as statement_trx_sum_ind,
        substr(sfl_file.linea, 140, 2)::VARCHAR(100) as statement_trx_sum_number,
        substr(sfl_file.linea, 142, 4)::VARCHAR(100) as statement_distrib_ind,
        substr(sfl_file.linea, 146, 2)::VARCHAR(100) as statement_distrib_number,
        substr(sfl_file.linea, 148, 1)::VARCHAR(100) as statement_distrib_tax_ind,
        substr(sfl_file.linea, 149, 4)::VARCHAR(100) as statement_div_ind,
        substr(sfl_file.linea, 153, 2)::VARCHAR(100) as statement_div_number,
        substr(sfl_file.linea, 155, 1)::VARCHAR(100) as statement_div_tax_ind,
        substr(sfl_file.linea, 156, 3)::VARCHAR(100) as pershing_depart,
        substr(sfl_file.linea, 159, 22)::VARCHAR(100) as pershing_grp,
        substr(sfl_file.linea, 181, 40)::VARCHAR(100) as campo_31,
        substr(sfl_file.linea, 221, 8)::VARCHAR(100) as user_id_added,
        substr(sfl_file.linea, 229, 8)::VARCHAR(100) as user_id_updated,
        substr(sfl_file.linea, 237, 3)::VARCHAR(100) as campo_34,
        substr(sfl_file.linea, 240, 1)::VARCHAR(100) as portfolio_eligible_ind,
        substr(sfl_file.linea, 241, 1)::VARCHAR(100) as reinvest_ind,
        substr(sfl_file.linea, 242, 8)::VARCHAR(100) as campo_37,
        substr(sfl_file.linea, 250, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isrc_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 3)		= 'SRA'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isrc_reg_trailer(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, eof character varying, campo_2 character varying, campo_3 character varying, date_of_data character varying, campo_5 character varying, remote_id character varying, campo_7 character varying, campo_8 character varying, number_of_records character varying, campo_10 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as eof,
        substr(sfl_file.linea, 19, 18)::VARCHAR(100) as campo_2,
        substr(sfl_file.linea, 37, 10)::VARCHAR(100) as campo_3,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 12)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 84, 22)::VARCHAR(100) as campo_8,
        substr(sfl_file.linea, 106, 10)::VARCHAR(100) as number_of_records,
        substr(sfl_file.linea, 116, 134)::VARCHAR(100) as campo_10,
        substr(sfl_file.linea, 250, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isrc_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 3)		= 'SRA'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isrc_reg_header(_id_proceso bigint) returns SETOF stage_pershing.stage_isrc_reg_header
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        bof::VARCHAR(100),
        campo_2::VARCHAR(100),
        campo_3::VARCHAR(100),
        date_of_data::VARCHAR(100),
        campo_5::VARCHAR(100),
        remote_id::VARCHAR(100),
        campo_7::VARCHAR(100),
        run_date::VARCHAR(100),
        campo_9::VARCHAR(100),
        run_time::VARCHAR(100),
        campo_11::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isrc_reg_header(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isrc_reg_a(_id_proceso bigint) returns SETOF stage_pershing.stage_isrc_reg_a
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        transaction_code::VARCHAR(100),
        record_secuence_id::varchar(100),
        record_id_number::int,
        change_id::VARCHAR(100),
        source_code::VARCHAR(100),
        source_code_desc_line_1::VARCHAR(100),
        source_code_desc_line_2::VARCHAR(100),
        source_code_desc_line_3::VARCHAR(100),
        tax_status::VARCHAR(100),
        campo_10::VARCHAR(100),
        user_id::VARCHAR(100),
        date_added::VARCHAR(100),
        date_updated::VARCHAR(100),
        ira_income_eligible::VARCHAR(100),
        retail_income_eligible::VARCHAR(100),
        customer_firm::VARCHAR(100),
        cerdit_debit::VARCHAR(100),
        statement_ind::VARCHAR(100),
        statement_act_sum_ind::VARCHAR(100),
        statement_act_sum_number::VARCHAR(100),
        statement_trx_sum_ind::VARCHAR(100),
        statement_trx_sum_number::VARCHAR(100),
        statement_distrib_ind::VARCHAR(100),
        statement_distrib_number::VARCHAR(100),
        statement_distrib_tax_ind::VARCHAR(100),
        statement_div_ind::VARCHAR(100),
        statement_div_number::VARCHAR(100),
        statement_div_tax_ind::VARCHAR(100),
        pershing_depart::VARCHAR(100),
        pershing_grp::VARCHAR(100),
        campo_31::VARCHAR(100),
        user_id_added::VARCHAR(100),
        user_id_updated::VARCHAR(100),
        campo_34::VARCHAR(100),
        portfolio_eligible_ind::VARCHAR(100),
        reinvest_ind::VARCHAR(100),
        campo_37::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isrc_reg_a(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isrc_reg_trailer(_id_proceso bigint) returns SETOF stage_pershing.stage_isrc_reg_trailer
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        eof::VARCHAR(100),
        campo_2::VARCHAR(100),
        campo_3::VARCHAR(100),
        date_of_data::VARCHAR(100),
        campo_5::VARCHAR(100),
        remote_id::VARCHAR(100),
        campo_7::VARCHAR(100),
        campo_8::VARCHAR(100),
        number_of_records::int,
        campo_10::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isrc_reg_trailer(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create procedure stage_pershing.pa_parse_isrc(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
begin

    DELETE FROM stage_pershing.stage_isrc_reg_header reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isrc_reg_a reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isrc_reg_trailer reg_del WHERE reg_del.id_proceso=_id_proceso;

    INSERT INTO stage_pershing.stage_isrc_reg_header (id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, eor)
    SELECT id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, eor
    FROM stage_pershing.fn_parse_isrc_reg_header(_id_proceso);

    INSERT INTO stage_pershing.stage_isrc_reg_a (id_proceso, process_date, transaction_code, record_secuence_id, record_id_number, change_id, source_code, source_code_desc_line_1, source_code_desc_line_2, source_code_desc_line_3, tax_status, campo_10, user_id, date_added, date_updated, ira_income_eligible, retail_income_eligible, customer_firm, cerdit_debit, statement_ind, statement_act_sum_ind, statement_act_sum_number, statement_trx_sum_ind, statement_trx_sum_number, statement_distrib_ind, statement_distrib_number, statement_distrib_tax_ind, statement_div_ind, statement_div_number, statement_div_tax_ind, pershing_depart, pershing_grp, campo_31, user_id_added, user_id_updated, campo_34, portfolio_eligible_ind, reinvest_ind, campo_37, eor)
    SELECT id_proceso, process_date, transaction_code, record_secuence_id, record_id_number, change_id, source_code, source_code_desc_line_1, source_code_desc_line_2, source_code_desc_line_3, tax_status, campo_10, user_id, date_added, date_updated, ira_income_eligible, retail_income_eligible, customer_firm, cerdit_debit, statement_ind, statement_act_sum_ind, statement_act_sum_number, statement_trx_sum_ind, statement_trx_sum_number, statement_distrib_ind, statement_distrib_number, statement_distrib_tax_ind, statement_div_ind, statement_div_number, statement_div_tax_ind, pershing_depart, pershing_grp, campo_31, user_id_added, user_id_updated, campo_34, portfolio_eligible_ind, reinvest_ind, campo_37, eor
    FROM stage_pershing.fn_parse_isrc_reg_a(_id_proceso);

    INSERT INTO stage_pershing.stage_isrc_reg_trailer (id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, campo_8, number_of_records, campo_10, eor)
    SELECT id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, campo_8, number_of_records, campo_10, eor
    FROM stage_pershing.fn_parse_isrc_reg_trailer(_id_proceso);

end;
$$;

create function stage_pershing.fn_extrae_isca_reg_header(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, bof character varying, campo_2 character varying, campo_3 character varying, date_of_data character varying, campo_5 character varying, remote_id character varying, campo_7 character varying, run_date character varying, campo_9 character varying, run_time character varying, campo_11 character varying, refreshed_or_updated character varying, campo_13 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as bof,
        substr(sfl_file.linea, 19, 18)::VARCHAR(100) as campo_2,
        substr(sfl_file.linea, 37, 10)::VARCHAR(100) as campo_3,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 14)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 86, 10)::VARCHAR(100) as run_date,
        substr(sfl_file.linea, 96, 1)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 97, 8)::VARCHAR(100) as run_time,
        substr(sfl_file.linea, 105, 14)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 119, 9)::VARCHAR(100) as refreshed_or_updated,
        substr(sfl_file.linea, 128, 4)::VARCHAR(100) as campo_13,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 3)		= 'SRA'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_a(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, security_type character varying, security_modifier character varying, security_calculation_code character varying, primary_exchange character varying, coupon_rate_fis_or_indicated_dividend_eq character varying, maturity_option_expire_date character varying, underlying_security_cusip character varying, first_call_price_fix_inc_or_strike_price_option character varying, first_par_call_price_fix_inc_or_units_option character varying, primary_symbol character varying, interest_frequency character varying, bond_class character varying, first_coupon_day character varying, call_indicator character varying, put_indicator character varying, next_par_call_date character varying, prerefunded_date character varying, next_premium_call_date character varying, dated_date_for_fix_inc_or_ex_dividend_date_eq character varying, first_coupon_fix_inc_or_payable_date_eq character varying, campo_24 character varying, federal_marginable_ind character varying, cns_eligible_code character varying, dtcc_eligible_code character varying, nscc_eligible_code character varying, foreign_security character varying, second_coupon_day character varying, dividend_interest_payment_method character varying, minor_product_code character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 1)::VARCHAR(100) as security_type,
        substr(sfl_file.linea, 18, 1)::VARCHAR(100) as security_modifier,
        substr(sfl_file.linea, 19, 1)::VARCHAR(100) as security_calculation_code,
        substr(sfl_file.linea, 20, 1)::VARCHAR(100) as primary_exchange,
        substr(sfl_file.linea, 21, 7)::VARCHAR(100) as coupon_rate_fis_or_indicated_dividend_eq,
        substr(sfl_file.linea, 28, 7)::VARCHAR(100) as maturity_option_expire_date,
        substr(sfl_file.linea, 35, 9)::VARCHAR(100) as underlying_security_cusip,
        substr(sfl_file.linea, 44, 9)::VARCHAR(100) as first_call_price_fix_inc_or_strike_price_option,
        substr(sfl_file.linea, 53, 9)::VARCHAR(100) as first_par_call_price_fix_inc_or_units_option,
        substr(sfl_file.linea, 62, 10)::VARCHAR(100) as primary_symbol,
        substr(sfl_file.linea, 72, 2)::VARCHAR(100) as interest_frequency,
        substr(sfl_file.linea, 74, 1)::VARCHAR(100) as bond_class,
        substr(sfl_file.linea, 75, 2)::VARCHAR(100) as first_coupon_day,
        substr(sfl_file.linea, 77, 1)::VARCHAR(100) as call_indicator,
        substr(sfl_file.linea, 78, 1)::VARCHAR(100) as put_indicator,
        substr(sfl_file.linea, 79, 7)::VARCHAR(100) as next_par_call_date,
        substr(sfl_file.linea, 86, 7)::VARCHAR(100) as prerefunded_date,
        substr(sfl_file.linea, 93, 7)::VARCHAR(100) as next_premium_call_date,
        substr(sfl_file.linea, 100, 7)::VARCHAR(100) as dated_date_for_fix_inc_or_ex_dividend_date_eq,
        substr(sfl_file.linea, 107, 7)::VARCHAR(100) as first_coupon_fix_inc_or_payable_date_eq,
        substr(sfl_file.linea, 114, 7)::VARCHAR(100) as campo_24,
        substr(sfl_file.linea, 121, 1)::VARCHAR(100) as federal_marginable_ind,
        substr(sfl_file.linea, 122, 1)::VARCHAR(100) as cns_eligible_code,
        substr(sfl_file.linea, 123, 1)::VARCHAR(100) as dtcc_eligible_code,
        substr(sfl_file.linea, 124, 1)::VARCHAR(100) as nscc_eligible_code,
        substr(sfl_file.linea, 125, 1)::VARCHAR(100) as foreign_security,
        substr(sfl_file.linea, 126, 2)::VARCHAR(100) as second_coupon_day,
        substr(sfl_file.linea, 128, 1)::VARCHAR(100) as dividend_interest_payment_method,
        substr(sfl_file.linea, 129, 3)::VARCHAR(100) as minor_product_code,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'A'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_b(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, etf_indicator character varying, bid_price character varying, ask_price character varying, previous_day_price character varying, latest_price character varying, end_of_month_price character varying, round_lot_quantity character varying, dividend_reinvestment_eligibility_indicator character varying, previous_price_date character varying, latest_price_date character varying, end_of_month_price_date character varying, record_date character varying, fundvest_ind character varying, country_code character varying, standard_poor_rating character varying, moodys_rating character varying, bond_sub_class character varying, restriction_indicator character varying, trace_indicator character varying, new_interest_calculation_code character varying, sic_code character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 3)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 20, 1)::VARCHAR(100) as etf_indicator,
        substr(sfl_file.linea, 21, 9)::VARCHAR(100) as bid_price,
        substr(sfl_file.linea, 30, 9)::VARCHAR(100) as ask_price,
        substr(sfl_file.linea, 39, 9)::VARCHAR(100) as previous_day_price,
        substr(sfl_file.linea, 48, 9)::VARCHAR(100) as latest_price,
        substr(sfl_file.linea, 57, 9)::VARCHAR(100) as end_of_month_price,
        substr(sfl_file.linea, 66, 13)::VARCHAR(100) as round_lot_quantity,
        substr(sfl_file.linea, 79, 1)::VARCHAR(100) as dividend_reinvestment_eligibility_indicator,
        substr(sfl_file.linea, 80, 7)::VARCHAR(100) as previous_price_date,
        substr(sfl_file.linea, 87, 7)::VARCHAR(100) as latest_price_date,
        substr(sfl_file.linea, 94, 7)::VARCHAR(100) as end_of_month_price_date,
        substr(sfl_file.linea, 101, 7)::VARCHAR(100) as record_date,
        substr(sfl_file.linea, 108, 1)::VARCHAR(100) as fundvest_ind,
        substr(sfl_file.linea, 109, 3)::VARCHAR(100) as country_code,
        substr(sfl_file.linea, 112, 4)::VARCHAR(100) as standard_poor_rating,
        substr(sfl_file.linea, 116, 5)::VARCHAR(100) as moodys_rating,
        substr(sfl_file.linea, 121, 1)::VARCHAR(100) as bond_sub_class,
        substr(sfl_file.linea, 122, 4)::VARCHAR(100) as restriction_indicator,
        substr(sfl_file.linea, 126, 1)::VARCHAR(100) as trace_indicator,
        substr(sfl_file.linea, 127, 1)::VARCHAR(100) as new_interest_calculation_code,
        substr(sfl_file.linea, 128, 4)::VARCHAR(100) as sic_code,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    AND substr(sfl_file.linea, 1, 18)		<> 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'B'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_c(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, state_tax_ind character varying, fts_ind character varying, amt_ind character varying, ric_indicator character varying, number_of_description_lines character varying, secutiry_description_line_1 character varying, secutiry_description_line_2 character varying, secutiry_description_line_3 character varying, secutiry_description_line_4 character varying, secutiry_description_line_5 character varying, user_cusip_identifier character varying, price_purge_date character varying, taxable_indicator character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 1)::VARCHAR(100) as state_tax_ind,
        substr(sfl_file.linea, 18, 1)::VARCHAR(100) as fts_ind,
        substr(sfl_file.linea, 19, 1)::VARCHAR(100) as amt_ind,
        substr(sfl_file.linea, 20, 1)::VARCHAR(100) as ric_indicator,
        substr(sfl_file.linea, 21, 1)::VARCHAR(100) as number_of_description_lines,
        substr(sfl_file.linea, 22, 20)::VARCHAR(100) as secutiry_description_line_1,
        substr(sfl_file.linea, 42, 20)::VARCHAR(100) as secutiry_description_line_2,
        substr(sfl_file.linea, 62, 20)::VARCHAR(100) as secutiry_description_line_3,
        substr(sfl_file.linea, 82, 20)::VARCHAR(100) as secutiry_description_line_4,
        substr(sfl_file.linea, 102, 20)::VARCHAR(100) as secutiry_description_line_5,
        substr(sfl_file.linea, 122, 2)::VARCHAR(100) as user_cusip_identifier,
        substr(sfl_file.linea, 124, 7)::VARCHAR(100) as price_purge_date,
        substr(sfl_file.linea, 131, 1)::VARCHAR(100) as taxable_indicator,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'C'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_d(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, secutiry_description_line_6 character varying, put_price character varying, put_date character varying, second_premium_call_price character varying, second_premium_call_date character varying, called_date character varying, pool_number character varying, factor character varying, factor_date character varying, previous_factor character varying, previous_factor_date character varying, variable_rate_indicator character varying, next_last_coupon_date character varying, structured_product_ind character varying, perpetual_bond_indicator character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 4)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 21, 20)::VARCHAR(100) as secutiry_description_line_6,
        substr(sfl_file.linea, 41, 9)::VARCHAR(100) as put_price,
        substr(sfl_file.linea, 50, 7)::VARCHAR(100) as put_date,
        substr(sfl_file.linea, 57, 9)::VARCHAR(100) as second_premium_call_price,
        substr(sfl_file.linea, 66, 7)::VARCHAR(100) as second_premium_call_date,
        substr(sfl_file.linea, 73, 7)::VARCHAR(100) as called_date,
        substr(sfl_file.linea, 80, 8)::VARCHAR(100) as pool_number,
        substr(sfl_file.linea, 88, 10)::VARCHAR(100) as factor,
        substr(sfl_file.linea, 98, 7)::VARCHAR(100) as factor_date,
        substr(sfl_file.linea, 105, 10)::VARCHAR(100) as previous_factor,
        substr(sfl_file.linea, 115, 7)::VARCHAR(100) as previous_factor_date,
        substr(sfl_file.linea, 122, 1)::VARCHAR(100) as variable_rate_indicator,
        substr(sfl_file.linea, 123, 7)::VARCHAR(100) as next_last_coupon_date,
        substr(sfl_file.linea, 130, 1)::VARCHAR(100) as structured_product_ind,
        substr(sfl_file.linea, 131, 1)::VARCHAR(100) as perpetual_bond_indicator,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'D'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_e(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, exp_first_call_price character varying, exp_first_par_call_price character varying, exp_put_price character varying, exp_second_premium_call_price character varying, name_issuer_security character varying, issuing_currency character varying, globally_locked_sec_ind character varying, globally_locked_reason_code character varying, spac_ind character varying, campo_14 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 4)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 21, 18)::VARCHAR(100) as exp_first_call_price,
        substr(sfl_file.linea, 39, 18)::VARCHAR(100) as exp_first_par_call_price,
        substr(sfl_file.linea, 57, 18)::VARCHAR(100) as exp_put_price,
        substr(sfl_file.linea, 75, 18)::VARCHAR(100) as exp_second_premium_call_price,
        substr(sfl_file.linea, 93, 32)::VARCHAR(100) as name_issuer_security,
        substr(sfl_file.linea, 125, 3)::VARCHAR(100) as issuing_currency,
        substr(sfl_file.linea, 128, 1)::VARCHAR(100) as globally_locked_sec_ind,
        substr(sfl_file.linea, 129, 1)::VARCHAR(100) as globally_locked_reason_code,
        substr(sfl_file.linea, 130, 1)::VARCHAR(100) as spac_ind,
        substr(sfl_file.linea, 131, 1)::VARCHAR(100) as campo_14,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    AND substr(sfl_file.linea, 1, 18)		<> 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'E'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_f(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, expanded_bid_price character varying, expanded_ask_price character varying, expanded_previous_day_price character varying, expanded_latest_price character varying, expanded_end_of_month_price character varying, contract_share_quantity character varying, year_covered_under_cost_basis_rules character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 4)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 21, 18)::VARCHAR(100) as expanded_bid_price,
        substr(sfl_file.linea, 39, 18)::VARCHAR(100) as expanded_ask_price,
        substr(sfl_file.linea, 57, 18)::VARCHAR(100) as expanded_previous_day_price,
        substr(sfl_file.linea, 75, 18)::VARCHAR(100) as expanded_latest_price,
        substr(sfl_file.linea, 93, 18)::VARCHAR(100) as expanded_end_of_month_price,
        substr(sfl_file.linea, 111, 17)::VARCHAR(100) as contract_share_quantity,
        substr(sfl_file.linea, 128, 4)::VARCHAR(100) as year_covered_under_cost_basis_rules,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'F'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_g(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, delta character varying, delta_sign character varying, delta_value_presence_ind character varying, campo_8 character varying, isin_code character varying, issuer_identifier character varying, campo_11 character varying, campo_12 character varying, symbol_of_the_underlying_security character varying, asset_type character varying, asset_subtype character varying, asset_subsubtype character varying, payment_day_delays character varying, campo_18 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 4)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 21, 18)::VARCHAR(100) as delta,
        substr(sfl_file.linea, 39, 1)::VARCHAR(100) as delta_sign,
        substr(sfl_file.linea, 40, 1)::VARCHAR(100) as delta_value_presence_ind,
        substr(sfl_file.linea, 41, 12)::VARCHAR(100) as campo_8,
        substr(sfl_file.linea, 53, 12)::VARCHAR(100) as isin_code,
        substr(sfl_file.linea, 65, 15)::VARCHAR(100) as issuer_identifier,
        substr(sfl_file.linea, 80, 2)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 82, 3)::VARCHAR(100) as campo_12,
        substr(sfl_file.linea, 85, 16)::VARCHAR(100) as symbol_of_the_underlying_security,
        substr(sfl_file.linea, 101, 8)::VARCHAR(100) as asset_type,
        substr(sfl_file.linea, 109, 8)::VARCHAR(100) as asset_subtype,
        substr(sfl_file.linea, 117, 8)::VARCHAR(100) as asset_subsubtype,
        substr(sfl_file.linea, 125, 3)::VARCHAR(100) as payment_day_delays,
        substr(sfl_file.linea, 128, 4)::VARCHAR(100) as campo_18,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'G'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_h(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, exchange_rate_denom_currency_usd character varying, underlying_cusip_1 character varying, campo_7 character varying, deliverable_unit_quantity_1 character varying, underlying_cusip_2 character varying, campo_10 character varying, deliverable_unit_quantity_2 character varying, underlying_cusip_3 character varying, campo_13 character varying, deliverable_unit_quantity_3 character varying, underlying_cusip_4 character varying, campo_16 character varying, deliverable_unit_quantity_4 character varying, annual_dividend_currency_code character varying, outstanding_shares character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 4)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 21, 18)::VARCHAR(100) as exchange_rate_denom_currency_usd,
        substr(sfl_file.linea, 39, 9)::VARCHAR(100) as underlying_cusip_1,
        substr(sfl_file.linea, 48, 4)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 52, 5)::VARCHAR(100) as deliverable_unit_quantity_1,
        substr(sfl_file.linea, 57, 9)::VARCHAR(100) as underlying_cusip_2,
        substr(sfl_file.linea, 66, 4)::VARCHAR(100) as campo_10,
        substr(sfl_file.linea, 70, 5)::VARCHAR(100) as deliverable_unit_quantity_2,
        substr(sfl_file.linea, 75, 9)::VARCHAR(100) as underlying_cusip_3,
        substr(sfl_file.linea, 84, 4)::VARCHAR(100) as campo_13,
        substr(sfl_file.linea, 88, 5)::VARCHAR(100) as deliverable_unit_quantity_3,
        substr(sfl_file.linea, 93, 9)::VARCHAR(100) as underlying_cusip_4,
        substr(sfl_file.linea, 102, 4)::VARCHAR(100) as campo_16,
        substr(sfl_file.linea, 106, 5)::VARCHAR(100) as deliverable_unit_quantity_4,
        substr(sfl_file.linea, 111, 3)::VARCHAR(100) as annual_dividend_currency_code,
        substr(sfl_file.linea, 114, 18)::VARCHAR(100) as outstanding_shares,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'H'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_i(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, option_root_id character varying, expiration_date character varying, call_put_indicator character varying, strike_price character varying, fund_type character varying, broad_narrow_indicator character varying, leverage_factor character varying, leverage_factor_sign character varying, outstanding_shares_update_date character varying, expanded_symbol character varying, state_of_issuance character varying, option_excercise_pricing_model_code character varying, first_accrual_date character varying, tranche_code character varying, campo_19 character varying, worthless_security_indicator character varying, uit_termination_code character varying, fdic_certification_number character varying, revenue_stream character varying, restricted_marijuana_ind character varying, campo_25 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 4)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 21, 6)::VARCHAR(100) as option_root_id,
        substr(sfl_file.linea, 27, 6)::VARCHAR(100) as expiration_date,
        substr(sfl_file.linea, 33, 1)::VARCHAR(100) as call_put_indicator,
        substr(sfl_file.linea, 34, 8)::VARCHAR(100) as strike_price,
        substr(sfl_file.linea, 42, 1)::VARCHAR(100) as fund_type,
        substr(sfl_file.linea, 43, 1)::VARCHAR(100) as broad_narrow_indicator,
        substr(sfl_file.linea, 44, 18)::VARCHAR(100) as leverage_factor,
        substr(sfl_file.linea, 62, 1)::VARCHAR(100) as leverage_factor_sign,
        substr(sfl_file.linea, 63, 8)::VARCHAR(100) as outstanding_shares_update_date,
        substr(sfl_file.linea, 71, 16)::VARCHAR(100) as expanded_symbol,
        substr(sfl_file.linea, 87, 2)::VARCHAR(100) as state_of_issuance,
        substr(sfl_file.linea, 89, 1)::VARCHAR(100) as option_excercise_pricing_model_code,
        substr(sfl_file.linea, 90, 8)::VARCHAR(100) as first_accrual_date,
        substr(sfl_file.linea, 98, 6)::VARCHAR(100) as tranche_code,
        substr(sfl_file.linea, 104, 2)::VARCHAR(100) as campo_19,
        substr(sfl_file.linea, 106, 1)::VARCHAR(100) as worthless_security_indicator,
        substr(sfl_file.linea, 107, 8)::VARCHAR(100) as uit_termination_code,
        substr(sfl_file.linea, 115, 8)::VARCHAR(100) as fdic_certification_number,
        substr(sfl_file.linea, 123, 3)::VARCHAR(100) as revenue_stream,
        substr(sfl_file.linea, 126, 1)::VARCHAR(100) as restricted_marijuana_ind,
        substr(sfl_file.linea, 127, 5)::VARCHAR(100) as campo_25,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'I'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_j(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, latest_price character varying, latest_price_date character varying, factored_market_value_multiplier character varying, current_yield character varying, yield character varying, price_source character varying, country_of_origin character varying, retricted_security_code character varying, international_non_dollar_symbol character varying, international_exchange character varying, variable_rate_category_code character varying, interest_rate_completion_ind character varying, campo_17 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 4)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 21, 18)::VARCHAR(100) as latest_price,
        substr(sfl_file.linea, 39, 8)::VARCHAR(100) as latest_price_date,
        substr(sfl_file.linea, 47, 18)::VARCHAR(100) as factored_market_value_multiplier,
        substr(sfl_file.linea, 65, 18)::VARCHAR(100) as current_yield,
        substr(sfl_file.linea, 83, 18)::VARCHAR(100) as yield,
        substr(sfl_file.linea, 101, 1)::VARCHAR(100) as price_source,
        substr(sfl_file.linea, 102, 2)::VARCHAR(100) as country_of_origin,
        substr(sfl_file.linea, 104, 1)::VARCHAR(100) as retricted_security_code,
        substr(sfl_file.linea, 105, 16)::VARCHAR(100) as international_non_dollar_symbol,
        substr(sfl_file.linea, 121, 6)::VARCHAR(100) as international_exchange,
        substr(sfl_file.linea, 127, 3)::VARCHAR(100) as variable_rate_category_code,
        substr(sfl_file.linea, 130, 1)::VARCHAR(100) as interest_rate_completion_ind,
        substr(sfl_file.linea, 131, 1)::VARCHAR(100) as campo_17,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'J'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_k(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, exchange_code_sedol_1 character varying, sedol_1 character varying, exchange_code_sedol_2 character varying, sedol_2 character varying, exchange_code_sedol_3 character varying, sedol_3 character varying, exchange_code_sedol_4 character varying, sedol_4 character varying, exchange_code_sedol_5 character varying, sedol_5 character varying, exchange_code_sedol_6 character varying, sedol_6 character varying, exchange_code_sedol_7 character varying, sedol_7 character varying, exchange_code_sedol_8 character varying, sedol_8 character varying, exchange_code_sedol_9 character varying, sedol_9 character varying, exchange_code_sedol_10 character varying, sedol_10 character varying, exchange_code_sedol_11 character varying, sedol_11 character varying, campo_26 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 3)::VARCHAR(100) as exchange_code_sedol_1,
        substr(sfl_file.linea, 20, 7)::VARCHAR(100) as sedol_1,
        substr(sfl_file.linea, 27, 3)::VARCHAR(100) as exchange_code_sedol_2,
        substr(sfl_file.linea, 30, 7)::VARCHAR(100) as sedol_2,
        substr(sfl_file.linea, 37, 3)::VARCHAR(100) as exchange_code_sedol_3,
        substr(sfl_file.linea, 40, 7)::VARCHAR(100) as sedol_3,
        substr(sfl_file.linea, 47, 3)::VARCHAR(100) as exchange_code_sedol_4,
        substr(sfl_file.linea, 50, 7)::VARCHAR(100) as sedol_4,
        substr(sfl_file.linea, 57, 3)::VARCHAR(100) as exchange_code_sedol_5,
        substr(sfl_file.linea, 60, 7)::VARCHAR(100) as sedol_5,
        substr(sfl_file.linea, 67, 3)::VARCHAR(100) as exchange_code_sedol_6,
        substr(sfl_file.linea, 70, 7)::VARCHAR(100) as sedol_6,
        substr(sfl_file.linea, 77, 3)::VARCHAR(100) as exchange_code_sedol_7,
        substr(sfl_file.linea, 80, 7)::VARCHAR(100) as sedol_7,
        substr(sfl_file.linea, 87, 3)::VARCHAR(100) as exchange_code_sedol_8,
        substr(sfl_file.linea, 90, 7)::VARCHAR(100) as sedol_8,
        substr(sfl_file.linea, 97, 3)::VARCHAR(100) as exchange_code_sedol_9,
        substr(sfl_file.linea, 100, 7)::VARCHAR(100) as sedol_9,
        substr(sfl_file.linea, 107, 3)::VARCHAR(100) as exchange_code_sedol_10,
        substr(sfl_file.linea, 110, 7)::VARCHAR(100) as sedol_10,
        substr(sfl_file.linea, 117, 3)::VARCHAR(100) as exchange_code_sedol_11,
        substr(sfl_file.linea, 120, 7)::VARCHAR(100) as sedol_11,
        substr(sfl_file.linea, 127, 5)::VARCHAR(100) as campo_26,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'K'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_l(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, primary_idc_mkt_exch character varying, primary_mkt_exch_trading_status character varying, primary_mkt_symbol character varying, primary_mkt_exch_effective_date character varying, primary_mkt_status_code character varying, secondary_idc_mkt_exch character varying, secondary_mkt_exch_trading_status character varying, secondary_mkt_symbol character varying, secondary_mkt_exch_effective_date character varying, secondary_mkt_status_code character varying, tick_size_pilot_group character varying, tick_size_effective_date character varying, tick_size_change_date character varying, update_date character varying, oas_libor_rate character varying, oas_libor_rate_sign character varying, campo_21 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 4)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 21, 2)::VARCHAR(100) as primary_idc_mkt_exch,
        substr(sfl_file.linea, 23, 1)::VARCHAR(100) as primary_mkt_exch_trading_status,
        substr(sfl_file.linea, 24, 16)::VARCHAR(100) as primary_mkt_symbol,
        substr(sfl_file.linea, 40, 8)::VARCHAR(100) as primary_mkt_exch_effective_date,
        substr(sfl_file.linea, 48, 3)::VARCHAR(100) as primary_mkt_status_code,
        substr(sfl_file.linea, 51, 2)::VARCHAR(100) as secondary_idc_mkt_exch,
        substr(sfl_file.linea, 53, 1)::VARCHAR(100) as secondary_mkt_exch_trading_status,
        substr(sfl_file.linea, 54, 16)::VARCHAR(100) as secondary_mkt_symbol,
        substr(sfl_file.linea, 70, 8)::VARCHAR(100) as secondary_mkt_exch_effective_date,
        substr(sfl_file.linea, 78, 3)::VARCHAR(100) as secondary_mkt_status_code,
        substr(sfl_file.linea, 81, 2)::VARCHAR(100) as tick_size_pilot_group,
        substr(sfl_file.linea, 83, 8)::VARCHAR(100) as tick_size_effective_date,
        substr(sfl_file.linea, 91, 8)::VARCHAR(100) as tick_size_change_date,
        substr(sfl_file.linea, 99, 8)::VARCHAR(100) as update_date,
        substr(sfl_file.linea, 107, 18)::VARCHAR(100) as oas_libor_rate,
        substr(sfl_file.linea, 125, 1)::VARCHAR(100) as oas_libor_rate_sign,
        substr(sfl_file.linea, 126, 6)::VARCHAR(100) as campo_21,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'L'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_m(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, campo_5 character varying, first_call_date character varying, first_call_price character varying, campo_8 character varying, second_call_date character varying, second_call_price character varying, campo_11 character varying, third_call_date character varying, third_call_price character varying, campo_14 character varying, fourth_call_date character varying, fourth_call_price character varying, campo_17 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 4)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 21, 1)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 22, 8)::VARCHAR(100) as first_call_date,
        substr(sfl_file.linea, 30, 18)::VARCHAR(100) as first_call_price,
        substr(sfl_file.linea, 48, 1)::VARCHAR(100) as campo_8,
        substr(sfl_file.linea, 49, 8)::VARCHAR(100) as second_call_date,
        substr(sfl_file.linea, 57, 18)::VARCHAR(100) as second_call_price,
        substr(sfl_file.linea, 75, 1)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 76, 8)::VARCHAR(100) as third_call_date,
        substr(sfl_file.linea, 84, 18)::VARCHAR(100) as third_call_price,
        substr(sfl_file.linea, 102, 1)::VARCHAR(100) as campo_14,
        substr(sfl_file.linea, 103, 8)::VARCHAR(100) as fourth_call_date,
        substr(sfl_file.linea, 111, 18)::VARCHAR(100) as fourth_call_price,
        substr(sfl_file.linea, 129, 3)::VARCHAR(100) as campo_17,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'M'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_n(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, campo_5 character varying, effective_date_rate_1 character varying, coupon_interest_rate_1 character varying, campo_8 character varying, effective_date_rate_2 character varying, coupon_interest_rate_2 character varying, campo_11 character varying, effective_date_rate_3 character varying, coupon_interest_rate_3 character varying, campo_14 character varying, effective_date_rate_4 character varying, coupon_interest_rate_4 character varying, campo_17 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 4)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 21, 1)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 22, 8)::VARCHAR(100) as effective_date_rate_1,
        substr(sfl_file.linea, 30, 18)::VARCHAR(100) as coupon_interest_rate_1,
        substr(sfl_file.linea, 48, 1)::VARCHAR(100) as campo_8,
        substr(sfl_file.linea, 49, 8)::VARCHAR(100) as effective_date_rate_2,
        substr(sfl_file.linea, 57, 18)::VARCHAR(100) as coupon_interest_rate_2,
        substr(sfl_file.linea, 75, 1)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 76, 8)::VARCHAR(100) as effective_date_rate_3,
        substr(sfl_file.linea, 84, 18)::VARCHAR(100) as coupon_interest_rate_3,
        substr(sfl_file.linea, 102, 1)::VARCHAR(100) as campo_14,
        substr(sfl_file.linea, 103, 8)::VARCHAR(100) as effective_date_rate_4,
        substr(sfl_file.linea, 111, 18)::VARCHAR(100) as coupon_interest_rate_4,
        substr(sfl_file.linea, 129, 3)::VARCHAR(100) as campo_17,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'N'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_o(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, oas_treasury_rate character varying, oas_treasury_rate_sign character varying, oas_treasury_effective_date character varying, minimum_piece character varying, minimum_increment character varying, issue_date_security character varying, campo_11 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 4)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 21, 18)::VARCHAR(100) as oas_treasury_rate,
        substr(sfl_file.linea, 39, 1)::VARCHAR(100) as oas_treasury_rate_sign,
        substr(sfl_file.linea, 40, 8)::VARCHAR(100) as oas_treasury_effective_date,
        substr(sfl_file.linea, 48, 15)::VARCHAR(100) as minimum_piece,
        substr(sfl_file.linea, 63, 15)::VARCHAR(100) as minimum_increment,
        substr(sfl_file.linea, 78, 8)::VARCHAR(100) as issue_date_security,
        substr(sfl_file.linea, 86, 46)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'O'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_isca_reg_trailer(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, eof character varying, campo_2 character varying, campo_3 character varying, date_of_data character varying, campo_5 character varying, remote_id character varying, campo_7 character varying, number_detail_of_records character varying, campo_9 character varying, refreshed_or_updated character varying, campo_11 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as eof,
        substr(sfl_file.linea, 19, 18)::VARCHAR(100) as campo_2,
        substr(sfl_file.linea, 37, 10)::VARCHAR(100) as campo_3,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 34)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 106, 10)::VARCHAR(100) as number_detail_of_records,
        substr(sfl_file.linea, 116, 3)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 119, 9)::VARCHAR(100) as refreshed_or_updated,
        substr(sfl_file.linea, 128, 4)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 1)		= 'O'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_header(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_header
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        bof::VARCHAR(100),
        campo_2::VARCHAR(100),
        campo_3::VARCHAR(100),
        date_of_data::VARCHAR(100),
        campo_5::VARCHAR(100),
        remote_id::VARCHAR(100),
        campo_7::VARCHAR(100),
        run_date::VARCHAR(100),
        campo_9::VARCHAR(100),
        run_time::VARCHAR(100),
        campo_11::VARCHAR(100),
        refreshed_or_updated::VARCHAR(100),
        campo_13::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_header(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_a(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_a
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        security_type::VARCHAR(100),
        security_modifier::VARCHAR(100),
        security_calculation_code::VARCHAR(100),
        primary_exchange::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(coupon_rate_fis_or_indicated_dividend_eq, 3)::NUMERIC(45,20) as coupon_rate_fis_or_indicated_dividend_eq,
        public.fn_fecha_string_to_date(maturity_option_expire_date, 'CCYYDDD') as maturity_option_expire_date,
        underlying_security_cusip::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(first_call_price_fix_inc_or_strike_price_option, 4)::NUMERIC(45,20) as first_call_price_fix_inc_or_strike_price_option,
        public.fn_convierte_texto_numerico_cobol(first_par_call_price_fix_inc_or_units_option, 4)::NUMERIC(45,20) as first_par_call_price_fix_inc_or_units_option,
        primary_symbol::VARCHAR(100),
        interest_frequency::VARCHAR(100),
        bond_class::VARCHAR(100),
        first_coupon_day::VARCHAR(100),
        call_indicator::VARCHAR(100),
        put_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(next_par_call_date, 'CCYYDDD') as next_par_call_date,
        public.fn_fecha_string_to_date(prerefunded_date, 'CCYYDDD') as prerefunded_date,
        public.fn_fecha_string_to_date(next_premium_call_date, 'CCYYDDD') as next_premium_call_date,
        public.fn_fecha_string_to_date(dated_date_for_fix_inc_or_ex_dividend_date_eq, 'CCYYDDD') as dated_date_for_fix_inc_or_ex_dividend_date_eq,
        public.fn_fecha_string_to_date(first_coupon_fix_inc_or_payable_date_eq, 'CCYYDDD') as first_coupon_fix_inc_or_payable_date_eq,
        campo_24::VARCHAR(100),
        federal_marginable_ind::VARCHAR(100),
        cns_eligible_code::VARCHAR(100),
        dtcc_eligible_code::VARCHAR(100),
        nscc_eligible_code::VARCHAR(100),
        foreign_security::VARCHAR(100),
        second_coupon_day::VARCHAR(100),
        dividend_interest_payment_method::VARCHAR(100),
        minor_product_code::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_a(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_b(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_b
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        campo_4::VARCHAR(100),
        etf_indicator::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(bid_price, 4)::NUMERIC(45,20) as bid_price,
        public.fn_convierte_texto_numerico_cobol(ask_price, 4)::NUMERIC(45,20) as ask_price,
        public.fn_convierte_texto_numerico_cobol(previous_day_price, 4)::NUMERIC(45,20) as previous_day_price,
        public.fn_convierte_texto_numerico_cobol(latest_price, 4)::NUMERIC(45,20) as latest_price,
        public.fn_convierte_texto_numerico_cobol(end_of_month_price, 4)::NUMERIC(45,20) as end_of_month_price,
        round_lot_quantity::int,
        dividend_reinvestment_eligibility_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(previous_price_date, 'CCYYDDD') as previous_price_date,
        public.fn_fecha_string_to_date(latest_price_date, 'CCYYDDD') as latest_price_date,
        public.fn_fecha_string_to_date(end_of_month_price_date, 'CCYYDDD') as end_of_month_price_date,
        public.fn_fecha_string_to_date(record_date, 'CCYYDDD') as record_date,
        fundvest_ind::VARCHAR(100),
        country_code::VARCHAR(100),
        standard_poor_rating::VARCHAR(100),
        moodys_rating::VARCHAR(100),
        bond_sub_class::VARCHAR(100),
        restriction_indicator::VARCHAR(100),
        trace_indicator::VARCHAR(100),
        new_interest_calculation_code::VARCHAR(100),
        sic_code::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_b(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_c(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_c
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        state_tax_ind::VARCHAR(100),
        fts_ind::VARCHAR(100),
        amt_ind::VARCHAR(100),
        ric_indicator::VARCHAR(100),
        number_of_description_lines::VARCHAR(100),
        secutiry_description_line_1::VARCHAR(100),
        secutiry_description_line_2::VARCHAR(100),
        secutiry_description_line_3::VARCHAR(100),
        secutiry_description_line_4::VARCHAR(100),
        secutiry_description_line_5::VARCHAR(100),
        user_cusip_identifier::VARCHAR(100),
        public.fn_fecha_string_to_date(price_purge_date, 'CCYYDDD') as price_purge_date,
        taxable_indicator::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_c(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_d(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_d
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        campo_4::VARCHAR(100),
        secutiry_description_line_6::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(put_price, 4)::NUMERIC(45,20) as put_price,
        public.fn_fecha_string_to_date(put_date, 'CCYYDDD') as put_date,
        public.fn_convierte_texto_numerico_cobol(second_premium_call_price, 4)::NUMERIC(45,20) as second_premium_call_price,
        public.fn_fecha_string_to_date(second_premium_call_date, 'CCYYDDD') as second_premium_call_date,
        public.fn_fecha_string_to_date(called_date, 'CCYYDDD') as called_date,
        pool_number::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(factor, 8)::NUMERIC(45,20) as factor,
        public.fn_fecha_string_to_date(factor_date, 'CCYYDDD') as factor_date,
        previous_factor::VARCHAR(100),
        public.fn_fecha_string_to_date(previous_factor_date, 'CCYYDDD') as previous_factor_date,
        variable_rate_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(next_last_coupon_date, 'CCYYDDD') as next_last_coupon_date,
        structured_product_ind::VARCHAR(100),
        perpetual_bond_indicator::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_d(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_e(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_e
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        campo_4::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(exp_first_call_price, 9)::NUMERIC(45,20) as exp_first_call_price,
        public.fn_convierte_texto_numerico_cobol(exp_first_par_call_price, 9)::NUMERIC(45,20) as exp_first_par_call_price,
        public.fn_convierte_texto_numerico_cobol(exp_put_price, 9)::NUMERIC(45,20) as exp_put_price,
        public.fn_convierte_texto_numerico_cobol(exp_second_premium_call_price, 9)::NUMERIC(45,20) as exp_second_premium_call_price,
        name_issuer_security::VARCHAR(100),
        issuing_currency::VARCHAR(100),
        globally_locked_sec_ind::VARCHAR(100),
        globally_locked_reason_code::VARCHAR(100),
        spac_ind::VARCHAR(100),
        campo_14::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_e(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_f(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_f
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        campo_4::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(expanded_bid_price, 9)::NUMERIC(45,20) as expanded_bid_price,
        public.fn_convierte_texto_numerico_cobol(expanded_ask_price, 9)::NUMERIC(45,20) as expanded_ask_price,
        public.fn_convierte_texto_numerico_cobol(expanded_previous_day_price, 9)::NUMERIC(45,20) as expanded_previous_day_price,
        public.fn_convierte_texto_numerico_cobol(expanded_latest_price, 9)::NUMERIC(45,20) as expanded_latest_price,
        public.fn_convierte_texto_numerico_cobol(expanded_end_of_month_price, 9)::NUMERIC(45,20) as expanded_end_of_month_price,
        public.fn_convierte_texto_numerico_cobol(contract_share_quantity, 2)::NUMERIC(45,20) as contract_share_quantity,
        year_covered_under_cost_basis_rules::int,
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_f(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_g(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_g
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        campo_4::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(delta, 9)::NUMERIC(45,20) as delta,
        delta_sign::VARCHAR(100),
        delta_value_presence_ind::VARCHAR(100),
        campo_8::VARCHAR(100),
        isin_code::VARCHAR(100),
        issuer_identifier::VARCHAR(100),
        campo_11::VARCHAR(100),
        campo_12::VARCHAR(100),
        symbol_of_the_underlying_security::VARCHAR(100),
        asset_type::VARCHAR(100),
        asset_subtype::VARCHAR(100),
        asset_subsubtype::VARCHAR(100),
        payment_day_delays::int,
        campo_18::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_g(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_h(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_h
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        campo_4::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(exchange_rate_denom_currency_usd, 10)::NUMERIC(45,20) as exchange_rate_denom_currency_usd,
        underlying_cusip_1::VARCHAR(100),
        campo_7::VARCHAR(100),
        CASE WHEN trim(deliverable_unit_quantity_1)='' THEN NULL ELSE deliverable_unit_quantity_1 END::int as deliverable_unit_quantity_1,
        underlying_cusip_2::VARCHAR(100),
        campo_10::VARCHAR(100),
        CASE WHEN trim(deliverable_unit_quantity_2)='' THEN NULL ELSE deliverable_unit_quantity_2 END::int as deliverable_unit_quantity_2,
        underlying_cusip_3::VARCHAR(100),
        campo_13::VARCHAR(100),
        CASE WHEN trim(deliverable_unit_quantity_3)='' THEN NULL ELSE deliverable_unit_quantity_3 END::int as deliverable_unit_quantity_3,
        underlying_cusip_4::VARCHAR(100),
        campo_16::VARCHAR(100),
        CASE WHEN trim(deliverable_unit_quantity_4)='' THEN NULL ELSE deliverable_unit_quantity_4 END::int as deliverable_unit_quantity_4,
        annual_dividend_currency_code::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(outstanding_shares, 2)::NUMERIC(45,20) as outstanding_shares,
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_h(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_i(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_i
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        campo_4::VARCHAR(100),
        option_root_id::VARCHAR(100),
        public.fn_fecha_string_to_date(expiration_date, 'YYMMDD') as expiration_date,
        call_put_indicator::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(strike_price, 3)::NUMERIC(45,20) as strike_price,
        fund_type::VARCHAR(100),
        broad_narrow_indicator::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(leverage_factor, 9)::NUMERIC(45,20) as leverage_factor,
        leverage_factor_sign::VARCHAR(100),
        public.fn_fecha_string_to_date(outstanding_shares_update_date, 'CCYYMMDD') as outstanding_shares_update_date,
        expanded_symbol::VARCHAR(100),
        state_of_issuance::VARCHAR(100),
        option_excercise_pricing_model_code::VARCHAR(100),
        public.fn_fecha_string_to_date(first_accrual_date, 'CCYYMMDD') as first_accrual_date,
        tranche_code::VARCHAR(100),
        campo_19::VARCHAR(100),
        worthless_security_indicator::VARCHAR(100),
        uit_termination_code::int,
        fdic_certification_number::VARCHAR(100),
        revenue_stream::VARCHAR(100),
        restricted_marijuana_ind::VARCHAR(100),
        campo_25::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_i(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_j(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_j
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        campo_4::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(latest_price, 9)::NUMERIC(45,20) as latest_price,
        public.fn_fecha_string_to_date(latest_price_date, 'CCYYMMDD') as latest_price_date,
        public.fn_convierte_texto_numerico_cobol(factored_market_value_multiplier, 12)::NUMERIC(45,20) as factored_market_value_multiplier,
        public.fn_convierte_texto_numerico_cobol(current_yield, 9)::NUMERIC(45,20) as current_yield,
        public.fn_convierte_texto_numerico_cobol(yield, 9)::NUMERIC(45,20) as yield,
        price_source::VARCHAR(100),
        country_of_origin::VARCHAR(100),
        retricted_security_code::VARCHAR(100),
        international_non_dollar_symbol::VARCHAR(100),
        international_exchange::VARCHAR(100),
        variable_rate_category_code::VARCHAR(100),
        interest_rate_completion_ind::VARCHAR(100),
        campo_17::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_j(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_k(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_k
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        exchange_code_sedol_1::VARCHAR(100),
        sedol_1::VARCHAR(100),
        exchange_code_sedol_2::VARCHAR(100),
        sedol_2::VARCHAR(100),
        exchange_code_sedol_3::VARCHAR(100),
        sedol_3::VARCHAR(100),
        exchange_code_sedol_4::VARCHAR(100),
        sedol_4::VARCHAR(100),
        exchange_code_sedol_5::VARCHAR(100),
        sedol_5::VARCHAR(100),
        exchange_code_sedol_6::VARCHAR(100),
        sedol_6::VARCHAR(100),
        exchange_code_sedol_7::VARCHAR(100),
        sedol_7::VARCHAR(100),
        exchange_code_sedol_8::VARCHAR(100),
        sedol_8::VARCHAR(100),
        exchange_code_sedol_9::VARCHAR(100),
        sedol_9::VARCHAR(100),
        exchange_code_sedol_10::VARCHAR(100),
        sedol_10::VARCHAR(100),
        exchange_code_sedol_11::VARCHAR(100),
        sedol_11::VARCHAR(100),
        campo_26::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_k(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_l(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_l
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        campo_4::VARCHAR(100),
        primary_idc_mkt_exch::VARCHAR(100),
        primary_mkt_exch_trading_status::VARCHAR(100),
        primary_mkt_symbol::VARCHAR(100),
        public.fn_fecha_string_to_date(primary_mkt_exch_effective_date, 'CCYYMMDD') as primary_mkt_exch_effective_date,
        primary_mkt_status_code::VARCHAR(100),
        secondary_idc_mkt_exch::VARCHAR(100),
        secondary_mkt_exch_trading_status::VARCHAR(100),
        secondary_mkt_symbol::VARCHAR(100),
        public.fn_fecha_string_to_date(secondary_mkt_exch_effective_date, 'CCYYMMDD') as secondary_mkt_exch_effective_date,
        secondary_mkt_status_code::VARCHAR(100),
        tick_size_pilot_group::VARCHAR(100),
        public.fn_fecha_string_to_date(tick_size_effective_date, 'CCYYMMDD') as tick_size_effective_date,
        public.fn_fecha_string_to_date(tick_size_change_date, 'CCYYMMDD') as tick_size_change_date,
        public.fn_fecha_string_to_date(update_date, 'CCYYMMDD') as update_date,
        public.fn_convierte_texto_numerico_cobol(oas_libor_rate, 9)::NUMERIC(45,20) as oas_libor_rate,
        oas_libor_rate_sign::VARCHAR(100),
        campo_21::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_l(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_m(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_m
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        campo_4::VARCHAR(100),
        campo_5::VARCHAR(100),
        public.fn_fecha_string_to_date(first_call_date, 'CCYYMMDD') as first_call_date,
        public.fn_convierte_texto_numerico_cobol(first_call_price, 9)::NUMERIC(45,20) as first_call_price,
        campo_8::VARCHAR(100),
        public.fn_fecha_string_to_date(second_call_date, 'CCYYMMDD') as second_call_date,
        public.fn_convierte_texto_numerico_cobol(second_call_price, 9)::NUMERIC(45,20) as second_call_price,
        campo_11::VARCHAR(100),
        public.fn_fecha_string_to_date(third_call_date, 'CCYYMMDD') as third_call_date,
        public.fn_convierte_texto_numerico_cobol(third_call_price, 9)::NUMERIC(45,20) as third_call_price,
        campo_14::VARCHAR(100),
        public.fn_fecha_string_to_date(fourth_call_date, 'CCYYMMDD') as fourth_call_date,
        public.fn_convierte_texto_numerico_cobol(fourth_call_price, 9)::NUMERIC(45,20) as fourth_call_price,
        campo_17::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_m(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_n(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_n
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        campo_4::VARCHAR(100),
        campo_5::VARCHAR(100),
        public.fn_fecha_string_to_date(effective_date_rate_1, 'CCYYMMDD') as effective_date_rate_1,
        public.fn_convierte_texto_numerico_cobol(coupon_interest_rate_1, 9)::NUMERIC(45,20) as coupon_interest_rate_1,
        campo_8::VARCHAR(100),
        public.fn_fecha_string_to_date(effective_date_rate_2, 'CCYYMMDD') as effective_date_rate_2,
        public.fn_convierte_texto_numerico_cobol(coupon_interest_rate_2, 9)::NUMERIC(45,20) as coupon_interest_rate_2,
        campo_11::VARCHAR(100),
        public.fn_fecha_string_to_date(effective_date_rate_3, 'CCYYMMDD') as effective_date_rate_3,
        public.fn_convierte_texto_numerico_cobol(coupon_interest_rate_3, 9)::NUMERIC(45,20) as coupon_interest_rate_3,
        campo_14::VARCHAR(100),
        public.fn_fecha_string_to_date(effective_date_rate_4, 'CCYYMMDD') as effective_date_rate_4,
        public.fn_convierte_texto_numerico_cobol(coupon_interest_rate_4, 9)::NUMERIC(45,20) as coupon_interest_rate_4,
        campo_17::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_n(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_o(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_o
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        campo_4::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(oas_treasury_rate, 9)::NUMERIC(45,20) as oas_treasury_rate,
        oas_treasury_rate_sign::VARCHAR(100),
        public.fn_fecha_string_to_date(oas_treasury_effective_date, 'CCYYMMDD') as oas_treasury_effective_date,
        public.fn_convierte_texto_numerico_cobol(minimum_piece, 3)::NUMERIC(45,20) as minimum_piece,
        public.fn_convierte_texto_numerico_cobol(minimum_increment, 3)::NUMERIC(45,20) as minimum_increment,
        public.fn_fecha_string_to_date(issue_date_security, 'CCYYMMDD') as issue_date_security,
        campo_11::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_o(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_isca_reg_trailer(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_trailer
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        eof::VARCHAR(100),
        campo_2::VARCHAR(100),
        campo_3::VARCHAR(100),
        date_of_data::VARCHAR(100),
        campo_5::VARCHAR(100),
        remote_id::VARCHAR(100),
        campo_7::VARCHAR(100),
        number_detail_of_records::VARCHAR(100),
        campo_9::VARCHAR(100),
        refreshed_or_updated::VARCHAR(100),
        campo_11::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_trailer(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create procedure stage_pershing.pa_parse_isca(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
begin

    DELETE FROM stage_pershing.stage_isca_reg_header reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_a reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_b reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_c reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_d reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_e reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_f reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_g reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_h reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_i reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_j reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_k reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_l reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_m reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_n reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_o reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_trailer reg_del WHERE reg_del.id_proceso=_id_proceso;

    INSERT INTO stage_pershing.stage_isca_reg_header (id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, refreshed_or_updated, campo_13, eor)
    SELECT id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, refreshed_or_updated, campo_13, eor
    FROM stage_pershing.fn_parse_isca_reg_header(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_a (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, security_type, security_modifier, security_calculation_code, primary_exchange, coupon_rate_fis_or_indicated_dividend_eq, maturity_option_expire_date, underlying_security_cusip, first_call_price_fix_inc_or_strike_price_option, first_par_call_price_fix_inc_or_units_option, primary_symbol, interest_frequency, bond_class, first_coupon_day, call_indicator, put_indicator, next_par_call_date, prerefunded_date, next_premium_call_date, dated_date_for_fix_inc_or_ex_dividend_date_eq, first_coupon_fix_inc_or_payable_date_eq, campo_24, federal_marginable_ind, cns_eligible_code, dtcc_eligible_code, nscc_eligible_code, foreign_security, second_coupon_day, dividend_interest_payment_method, minor_product_code, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, security_type, security_modifier, security_calculation_code, primary_exchange, coupon_rate_fis_or_indicated_dividend_eq, maturity_option_expire_date, underlying_security_cusip, first_call_price_fix_inc_or_strike_price_option, first_par_call_price_fix_inc_or_units_option, primary_symbol, interest_frequency, bond_class, first_coupon_day, call_indicator, put_indicator, next_par_call_date, prerefunded_date, next_premium_call_date, dated_date_for_fix_inc_or_ex_dividend_date_eq, first_coupon_fix_inc_or_payable_date_eq, campo_24, federal_marginable_ind, cns_eligible_code, dtcc_eligible_code, nscc_eligible_code, foreign_security, second_coupon_day, dividend_interest_payment_method, minor_product_code, eor
    FROM stage_pershing.fn_parse_isca_reg_a(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_b (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, etf_indicator, bid_price, ask_price, previous_day_price, latest_price, end_of_month_price, round_lot_quantity, dividend_reinvestment_eligibility_indicator, previous_price_date, latest_price_date, end_of_month_price_date, record_date, fundvest_ind, country_code, standard_poor_rating, moodys_rating, bond_sub_class, restriction_indicator, trace_indicator, new_interest_calculation_code, sic_code, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, etf_indicator, bid_price, ask_price, previous_day_price, latest_price, end_of_month_price, round_lot_quantity, dividend_reinvestment_eligibility_indicator, previous_price_date, latest_price_date, end_of_month_price_date, record_date, fundvest_ind, country_code, standard_poor_rating, moodys_rating, bond_sub_class, restriction_indicator, trace_indicator, new_interest_calculation_code, sic_code, eor
    FROM stage_pershing.fn_parse_isca_reg_b(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_c (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, state_tax_ind, fts_ind, amt_ind, ric_indicator, number_of_description_lines, secutiry_description_line_1, secutiry_description_line_2, secutiry_description_line_3, secutiry_description_line_4, secutiry_description_line_5, user_cusip_identifier, price_purge_date, taxable_indicator, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, state_tax_ind, fts_ind, amt_ind, ric_indicator, number_of_description_lines, secutiry_description_line_1, secutiry_description_line_2, secutiry_description_line_3, secutiry_description_line_4, secutiry_description_line_5, user_cusip_identifier, price_purge_date, taxable_indicator, eor
    FROM stage_pershing.fn_parse_isca_reg_c(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_d (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, secutiry_description_line_6, put_price, put_date, second_premium_call_price, second_premium_call_date, called_date, pool_number, factor, factor_date, previous_factor, previous_factor_date, variable_rate_indicator, next_last_coupon_date, structured_product_ind, perpetual_bond_indicator, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, secutiry_description_line_6, put_price, put_date, second_premium_call_price, second_premium_call_date, called_date, pool_number, factor, factor_date, previous_factor, previous_factor_date, variable_rate_indicator, next_last_coupon_date, structured_product_ind, perpetual_bond_indicator, eor
    FROM stage_pershing.fn_parse_isca_reg_d(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_e (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, exp_first_call_price, exp_first_par_call_price, exp_put_price, exp_second_premium_call_price, name_issuer_security, issuing_currency, globally_locked_sec_ind, globally_locked_reason_code, spac_ind, campo_14, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, exp_first_call_price, exp_first_par_call_price, exp_put_price, exp_second_premium_call_price, name_issuer_security, issuing_currency, globally_locked_sec_ind, globally_locked_reason_code, spac_ind, campo_14, eor
    FROM stage_pershing.fn_parse_isca_reg_e(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_f (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, expanded_bid_price, expanded_ask_price, expanded_previous_day_price, expanded_latest_price, expanded_end_of_month_price, contract_share_quantity, year_covered_under_cost_basis_rules, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, expanded_bid_price, expanded_ask_price, expanded_previous_day_price, expanded_latest_price, expanded_end_of_month_price, contract_share_quantity, year_covered_under_cost_basis_rules, eor
    FROM stage_pershing.fn_parse_isca_reg_f(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_g (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, delta, delta_sign, delta_value_presence_ind, campo_8, isin_code, issuer_identifier, campo_11, campo_12, symbol_of_the_underlying_security, asset_type, asset_subtype, asset_subsubtype, payment_day_delays, campo_18, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, delta, delta_sign, delta_value_presence_ind, campo_8, isin_code, issuer_identifier, campo_11, campo_12, symbol_of_the_underlying_security, asset_type, asset_subtype, asset_subsubtype, payment_day_delays, campo_18, eor
    FROM stage_pershing.fn_parse_isca_reg_g(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_h (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, exchange_rate_denom_currency_usd, underlying_cusip_1, campo_7, deliverable_unit_quantity_1, underlying_cusip_2, campo_10, deliverable_unit_quantity_2, underlying_cusip_3, campo_13, deliverable_unit_quantity_3, underlying_cusip_4, campo_16, deliverable_unit_quantity_4, annual_dividend_currency_code, outstanding_shares, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, exchange_rate_denom_currency_usd, underlying_cusip_1, campo_7, deliverable_unit_quantity_1, underlying_cusip_2, campo_10, deliverable_unit_quantity_2, underlying_cusip_3, campo_13, deliverable_unit_quantity_3, underlying_cusip_4, campo_16, deliverable_unit_quantity_4, annual_dividend_currency_code, outstanding_shares, eor
    FROM stage_pershing.fn_parse_isca_reg_h(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_i (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, option_root_id, expiration_date, call_put_indicator, strike_price, fund_type, broad_narrow_indicator, leverage_factor, leverage_factor_sign, outstanding_shares_update_date, expanded_symbol, state_of_issuance, option_excercise_pricing_model_code, first_accrual_date, tranche_code, campo_19, worthless_security_indicator, uit_termination_code, fdic_certification_number, revenue_stream, restricted_marijuana_ind, campo_25, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, option_root_id, expiration_date, call_put_indicator, strike_price, fund_type, broad_narrow_indicator, leverage_factor, leverage_factor_sign, outstanding_shares_update_date, expanded_symbol, state_of_issuance, option_excercise_pricing_model_code, first_accrual_date, tranche_code, campo_19, worthless_security_indicator, uit_termination_code, fdic_certification_number, revenue_stream, restricted_marijuana_ind, campo_25, eor
    FROM stage_pershing.fn_parse_isca_reg_i(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_j (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, latest_price, latest_price_date, factored_market_value_multiplier, current_yield, yield, price_source, country_of_origin, retricted_security_code, international_non_dollar_symbol, international_exchange, variable_rate_category_code, interest_rate_completion_ind, campo_17, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, latest_price, latest_price_date, factored_market_value_multiplier, current_yield, yield, price_source, country_of_origin, retricted_security_code, international_non_dollar_symbol, international_exchange, variable_rate_category_code, interest_rate_completion_ind, campo_17, eor
    FROM stage_pershing.fn_parse_isca_reg_j(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_k (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, exchange_code_sedol_1, sedol_1, exchange_code_sedol_2, sedol_2, exchange_code_sedol_3, sedol_3, exchange_code_sedol_4, sedol_4, exchange_code_sedol_5, sedol_5, exchange_code_sedol_6, sedol_6, exchange_code_sedol_7, sedol_7, exchange_code_sedol_8, sedol_8, exchange_code_sedol_9, sedol_9, exchange_code_sedol_10, sedol_10, exchange_code_sedol_11, sedol_11, campo_26, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, exchange_code_sedol_1, sedol_1, exchange_code_sedol_2, sedol_2, exchange_code_sedol_3, sedol_3, exchange_code_sedol_4, sedol_4, exchange_code_sedol_5, sedol_5, exchange_code_sedol_6, sedol_6, exchange_code_sedol_7, sedol_7, exchange_code_sedol_8, sedol_8, exchange_code_sedol_9, sedol_9, exchange_code_sedol_10, sedol_10, exchange_code_sedol_11, sedol_11, campo_26, eor
    FROM stage_pershing.fn_parse_isca_reg_k(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_l (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, primary_idc_mkt_exch, primary_mkt_exch_trading_status, primary_mkt_symbol, primary_mkt_exch_effective_date, primary_mkt_status_code, secondary_idc_mkt_exch, secondary_mkt_exch_trading_status, secondary_mkt_symbol, secondary_mkt_exch_effective_date, secondary_mkt_status_code, tick_size_pilot_group, tick_size_effective_date, tick_size_change_date, update_date, oas_libor_rate, oas_libor_rate_sign, campo_21, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, primary_idc_mkt_exch, primary_mkt_exch_trading_status, primary_mkt_symbol, primary_mkt_exch_effective_date, primary_mkt_status_code, secondary_idc_mkt_exch, secondary_mkt_exch_trading_status, secondary_mkt_symbol, secondary_mkt_exch_effective_date, secondary_mkt_status_code, tick_size_pilot_group, tick_size_effective_date, tick_size_change_date, update_date, oas_libor_rate, oas_libor_rate_sign, campo_21, eor
    FROM stage_pershing.fn_parse_isca_reg_l(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_m (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, campo_5, first_call_date, first_call_price, campo_8, second_call_date, second_call_price, campo_11, third_call_date, third_call_price, campo_14, fourth_call_date, fourth_call_price, campo_17, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, campo_5, first_call_date, first_call_price, campo_8, second_call_date, second_call_price, campo_11, third_call_date, third_call_price, campo_14, fourth_call_date, fourth_call_price, campo_17, eor
    FROM stage_pershing.fn_parse_isca_reg_m(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_n (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, campo_5, effective_date_rate_1, coupon_interest_rate_1, campo_8, effective_date_rate_2, coupon_interest_rate_2, campo_11, effective_date_rate_3, coupon_interest_rate_3, campo_14, effective_date_rate_4, coupon_interest_rate_4, campo_17, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, campo_5, effective_date_rate_1, coupon_interest_rate_1, campo_8, effective_date_rate_2, coupon_interest_rate_2, campo_11, effective_date_rate_3, coupon_interest_rate_3, campo_14, effective_date_rate_4, coupon_interest_rate_4, campo_17, eor
    FROM stage_pershing.fn_parse_isca_reg_n(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_o (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, oas_treasury_rate, oas_treasury_rate_sign, oas_treasury_effective_date, minimum_piece, minimum_increment, issue_date_security, campo_11, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, oas_treasury_rate, oas_treasury_rate_sign, oas_treasury_effective_date, minimum_piece, minimum_increment, issue_date_security, campo_11, eor
    FROM stage_pershing.fn_parse_isca_reg_o(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_trailer (id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, number_detail_of_records, campo_9, refreshed_or_updated, campo_11, eor)
    SELECT id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, number_detail_of_records, campo_9, refreshed_or_updated, campo_11, eor
    FROM stage_pershing.fn_parse_isca_reg_trailer(_id_proceso);

end;
$$;

create function stage_pershing.fn_extrae_gact_reg_header(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, bof character varying, campo_2 character varying, campo_3 character varying, date_of_data character varying, campo_5 character varying, remote_id character varying, campo_7 character varying, run_date character varying, campo_9 character varying, run_time character varying, campo_11 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date::VARCHAR(100),
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as bof,
        substr(sfl_file.linea, 19, 18)::VARCHAR(100) as campo_2,
        substr(sfl_file.linea, 37, 10)::VARCHAR(100) as campo_3,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 14)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 86, 10)::VARCHAR(100) as run_date,
        substr(sfl_file.linea, 96, 1)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 97, 8)::VARCHAR(100) as run_time,
        substr(sfl_file.linea, 105, 645)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gact_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 1)		= 'O'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_gact_reg_a(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, cusip_number character varying, campo_6 character varying, underlying_cusip character varying, campo_8 character varying, security_symbol character varying, investment_professional_of_record character varying, executing_investment_professional character varying, transaction_type character varying, buy_sell_code character varying, open_close_indicator character varying, par_key_code character varying, source_code character varying, maxx_key_code character varying, process_date_sfl character varying, trade_date character varying, settlement_entry_date character varying, campo_21 character varying, source_of_input character varying, reference_number character varying, batch_code character varying, same_day_settlement character varying, contra_account character varying, market_code character varying, blotter_code character varying, cancel_code character varying, correction_code character varying, merket_limit_indicator character varying, legend_code_1 character varying, legend_code_2 character varying, campo_34 character varying, quantity character varying, quantity_sign character varying, price_in_trade_currency character varying, campo_38 character varying, price_in_trade_currency_sign character varying, currency_indicator_for_price character varying, net_amount_in_usd character varying, net_amount_in_usd_sign character varying, principal_in_usd character varying, principal_in_usd_sign character varying, interest_in_usd character varying, interest_in_usd_sign character varying, commision_in_usd character varying, commision_in_usd_sign character varying, tax_in_usd character varying, tax_in_usd_sign character varying, transaction_fee_in_usd character varying, transaction_fee_in_usd_sign character varying, misc_fee_in_usd character varying, misc_fee_in_usd_sign character varying, other_fee_in_usd character varying, other_fee_in_usd_sign character varying, tefra_wh_amount_in_usd character varying, tefra_wh_amount_in_usd_sign character varying, pershing_charge_in_usd character varying, pershing_charge_in_usd_sign character varying, brokerage_charge_in_usd character varying, brokerage_charge_in_usd_sign character varying, sales_credit_in_usd character varying, sales_credit_in_usd_sign character varying, settlement_fee_in_usd character varying, settlement_fee_in_usd_sign character varying, service_charge_in_usd character varying, service_charge_in_usd_sign character varying, markup_markdown_amount_in_usd character varying, markup_markdown_amount_in_usd_sign character varying, campo_71 character varying, dividend_payable_date character varying, campo_73 character varying, dividend_record_date character varying, dividend_type character varying, campo_76 character varying, shares_of_record_quantity_for_dividends character varying, order_size_quantity character varying, campo_79 character varying, pool_factor character varying, parsed_customer_account_number character varying, ibd_number character varying, security_type_code character varying, security_modifier_code character varying, security_calculation_code character varying, minor_product_code character varying, foreign_product_indicator character varying, with_due_bill_indicator character varying, taxable_municipal_bond_indicator character varying, omnibus_indicator character varying, external_order_id character varying, campo_92 character varying, market_value_of_transaction character varying, ip_number_parsed character varying, reported_price character varying, reported_price_sign character varying, previous_day_market_value_of_transaction character varying, price_in_usd character varying, option_root_id character varying, expiration_date character varying, put_call_code character varying, strike_price character varying, repo_identifier character varying, taxable character varying, qualified character varying, expanded_ip_number character varying, expanded_exec_ip_number character varying, expanded_legacy_ip_number character varying, campo_109 character varying, campo_110 character varying, campo_111 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 10)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 22, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 31, 4)::VARCHAR(100) as campo_6,
        substr(sfl_file.linea, 35, 9)::VARCHAR(100) as underlying_cusip,
        substr(sfl_file.linea, 44, 4)::VARCHAR(100) as campo_8,
        substr(sfl_file.linea, 48, 16)::VARCHAR(100) as security_symbol,
        substr(sfl_file.linea, 64, 3)::VARCHAR(100) as investment_professional_of_record,
        substr(sfl_file.linea, 67, 3)::VARCHAR(100) as executing_investment_professional,
        substr(sfl_file.linea, 70, 1)::VARCHAR(100) as transaction_type,
        substr(sfl_file.linea, 71, 1)::VARCHAR(100) as buy_sell_code,
        substr(sfl_file.linea, 72, 1)::VARCHAR(100) as open_close_indicator,
        substr(sfl_file.linea, 73, 2)::VARCHAR(100) as par_key_code,
        substr(sfl_file.linea, 75, 3)::VARCHAR(100) as source_code,
        substr(sfl_file.linea, 78, 4)::VARCHAR(100) as maxx_key_code,
        substr(sfl_file.linea, 82, 8)::VARCHAR(100) as process_date_sfl,
        substr(sfl_file.linea, 90, 8)::VARCHAR(100) as trade_date,
        substr(sfl_file.linea, 98, 8)::VARCHAR(100) as settlement_entry_date,
        substr(sfl_file.linea, 106, 7)::VARCHAR(100) as campo_21,
        substr(sfl_file.linea, 113, 2)::VARCHAR(100) as source_of_input,
        substr(sfl_file.linea, 115, 6)::VARCHAR(100) as reference_number,
        substr(sfl_file.linea, 121, 5)::VARCHAR(100) as batch_code,
        substr(sfl_file.linea, 126, 1)::VARCHAR(100) as same_day_settlement,
        substr(sfl_file.linea, 127, 10)::VARCHAR(100) as contra_account,
        substr(sfl_file.linea, 137, 1)::VARCHAR(100) as market_code,
        substr(sfl_file.linea, 138, 1)::VARCHAR(100) as blotter_code,
        substr(sfl_file.linea, 139, 1)::VARCHAR(100) as cancel_code,
        substr(sfl_file.linea, 140, 1)::VARCHAR(100) as correction_code,
        substr(sfl_file.linea, 141, 1)::VARCHAR(100) as merket_limit_indicator,
        substr(sfl_file.linea, 142, 1)::VARCHAR(100) as legend_code_1,
        substr(sfl_file.linea, 143, 1)::VARCHAR(100) as legend_code_2,
        substr(sfl_file.linea, 144, 2)::VARCHAR(100) as campo_34,
        substr(sfl_file.linea, 146, 18)::VARCHAR(100) as quantity,
        substr(sfl_file.linea, 164, 1)::VARCHAR(100) as quantity_sign,
        substr(sfl_file.linea, 165, 18)::VARCHAR(100) as price_in_trade_currency,
        substr(sfl_file.linea, 183, 5)::VARCHAR(100) as campo_38,
        substr(sfl_file.linea, 188, 1)::VARCHAR(100) as price_in_trade_currency_sign,
        substr(sfl_file.linea, 189, 3)::VARCHAR(100) as currency_indicator_for_price,
        substr(sfl_file.linea, 192, 18)::VARCHAR(100) as net_amount_in_usd,
        substr(sfl_file.linea, 210, 1)::VARCHAR(100) as net_amount_in_usd_sign,
        substr(sfl_file.linea, 211, 18)::VARCHAR(100) as principal_in_usd,
        substr(sfl_file.linea, 229, 1)::VARCHAR(100) as principal_in_usd_sign,
        substr(sfl_file.linea, 230, 18)::VARCHAR(100) as interest_in_usd,
        substr(sfl_file.linea, 248, 1)::VARCHAR(100) as interest_in_usd_sign,
        substr(sfl_file.linea, 249, 18)::VARCHAR(100) as commision_in_usd,
        substr(sfl_file.linea, 267, 1)::VARCHAR(100) as commision_in_usd_sign,
        substr(sfl_file.linea, 268, 18)::VARCHAR(100) as tax_in_usd,
        substr(sfl_file.linea, 286, 1)::VARCHAR(100) as tax_in_usd_sign,
        substr(sfl_file.linea, 287, 18)::VARCHAR(100) as transaction_fee_in_usd,
        substr(sfl_file.linea, 305, 1)::VARCHAR(100) as transaction_fee_in_usd_sign,
        substr(sfl_file.linea, 306, 18)::VARCHAR(100) as misc_fee_in_usd,
        substr(sfl_file.linea, 324, 1)::VARCHAR(100) as misc_fee_in_usd_sign,
        substr(sfl_file.linea, 325, 18)::VARCHAR(100) as other_fee_in_usd,
        substr(sfl_file.linea, 343, 1)::VARCHAR(100) as other_fee_in_usd_sign,
        substr(sfl_file.linea, 344, 18)::VARCHAR(100) as tefra_wh_amount_in_usd,
        substr(sfl_file.linea, 362, 1)::VARCHAR(100) as tefra_wh_amount_in_usd_sign,
        substr(sfl_file.linea, 363, 18)::VARCHAR(100) as pershing_charge_in_usd,
        substr(sfl_file.linea, 381, 1)::VARCHAR(100) as pershing_charge_in_usd_sign,
        substr(sfl_file.linea, 382, 18)::VARCHAR(100) as brokerage_charge_in_usd,
        substr(sfl_file.linea, 400, 1)::VARCHAR(100) as brokerage_charge_in_usd_sign,
        substr(sfl_file.linea, 401, 18)::VARCHAR(100) as sales_credit_in_usd,
        substr(sfl_file.linea, 419, 1)::VARCHAR(100) as sales_credit_in_usd_sign,
        substr(sfl_file.linea, 420, 18)::VARCHAR(100) as settlement_fee_in_usd,
        substr(sfl_file.linea, 438, 1)::VARCHAR(100) as settlement_fee_in_usd_sign,
        substr(sfl_file.linea, 439, 18)::VARCHAR(100) as service_charge_in_usd,
        substr(sfl_file.linea, 457, 1)::VARCHAR(100) as service_charge_in_usd_sign,
        substr(sfl_file.linea, 458, 18)::VARCHAR(100) as markup_markdown_amount_in_usd,
        substr(sfl_file.linea, 476, 1)::VARCHAR(100) as markup_markdown_amount_in_usd_sign,
        substr(sfl_file.linea, 477, 1)::VARCHAR(100) as campo_71,
        substr(sfl_file.linea, 478, 8)::VARCHAR(100) as dividend_payable_date,
        substr(sfl_file.linea, 486, 1)::VARCHAR(100) as campo_73,
        substr(sfl_file.linea, 487, 8)::VARCHAR(100) as dividend_record_date,
        substr(sfl_file.linea, 495, 1)::VARCHAR(100) as dividend_type,
        substr(sfl_file.linea, 496, 1)::VARCHAR(100) as campo_76,
        substr(sfl_file.linea, 497, 18)::VARCHAR(100) as shares_of_record_quantity_for_dividends,
        substr(sfl_file.linea, 515, 18)::VARCHAR(100) as order_size_quantity,
        substr(sfl_file.linea, 533, 1)::VARCHAR(100) as campo_79,
        substr(sfl_file.linea, 534, 18)::VARCHAR(100) as pool_factor,
        substr(sfl_file.linea, 552, 10)::VARCHAR(100) as parsed_customer_account_number,
        substr(sfl_file.linea, 562, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 565, 1)::VARCHAR(100) as security_type_code,
        substr(sfl_file.linea, 566, 1)::VARCHAR(100) as security_modifier_code,
        substr(sfl_file.linea, 567, 1)::VARCHAR(100) as security_calculation_code,
        substr(sfl_file.linea, 568, 3)::VARCHAR(100) as minor_product_code,
        substr(sfl_file.linea, 571, 1)::VARCHAR(100) as foreign_product_indicator,
        substr(sfl_file.linea, 572, 1)::VARCHAR(100) as with_due_bill_indicator,
        substr(sfl_file.linea, 573, 1)::VARCHAR(100) as taxable_municipal_bond_indicator,
        substr(sfl_file.linea, 574, 1)::VARCHAR(100) as omnibus_indicator,
        substr(sfl_file.linea, 575, 20)::VARCHAR(100) as external_order_id,
        substr(sfl_file.linea, 595, 3)::VARCHAR(100) as campo_92,
        substr(sfl_file.linea, 598, 18)::VARCHAR(100) as market_value_of_transaction,
        substr(sfl_file.linea, 616, 3)::VARCHAR(100) as ip_number_parsed,
        substr(sfl_file.linea, 619, 18)::VARCHAR(100) as reported_price,
        substr(sfl_file.linea, 637, 1)::VARCHAR(100) as reported_price_sign,
        substr(sfl_file.linea, 638, 18)::VARCHAR(100) as previous_day_market_value_of_transaction,
        substr(sfl_file.linea, 656, 18)::VARCHAR(100) as price_in_usd,
        substr(sfl_file.linea, 674, 6)::VARCHAR(100) as option_root_id,
        substr(sfl_file.linea, 680, 6)::VARCHAR(100) as expiration_date,
        substr(sfl_file.linea, 686, 1)::VARCHAR(100) as put_call_code,
        substr(sfl_file.linea, 687, 8)::VARCHAR(100) as strike_price,
        substr(sfl_file.linea, 695, 1)::VARCHAR(100) as repo_identifier,
        substr(sfl_file.linea, 696, 1)::VARCHAR(100) as taxable,
        substr(sfl_file.linea, 697, 1)::VARCHAR(100) as qualified,
        substr(sfl_file.linea, 698, 4)::VARCHAR(100) as expanded_ip_number,
        substr(sfl_file.linea, 702, 4)::VARCHAR(100) as expanded_exec_ip_number,
        substr(sfl_file.linea, 706, 4)::VARCHAR(100) as expanded_legacy_ip_number,
        substr(sfl_file.linea, 710, 20)::VARCHAR(100) as campo_109,
        substr(sfl_file.linea, 730, 12)::VARCHAR(100) as campo_110,
        substr(sfl_file.linea, 742, 8)::VARCHAR(100) as campo_111,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gact_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 3)		= 'GAA'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_gact_reg_b(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, security_currency_of_issuance character varying, trade_currency_code character varying, settlement_currency_code character varying, settlement_usd_currency_fx_rate character varying, settlement_usd_multiply_divide_code character varying, cross_currency_fx_rate character varying, currency_multiply_divide_code character varying, accrued_interest_in_settlement_currency character varying, accrued_interest_in_settlement_currency_sign character varying, market_code character varying, internal_reference_for_gloss character varying, ibd_version character varying, net_amount_in_settlement_currency character varying, net_amount_in_settlement_currency_sign character varying, principal_amount_in_settlement_currency character varying, principal_amount_in_settlement_currency_sign character varying, interest_in_settlement_currency character varying, interest_in_settlement_currency_sign character varying, commission_in_settlement_currency character varying, commission_in_settlement_currency_sign character varying, tax_in_settlement_currency character varying, tax_in_settlement_currency_sign character varying, transaction_fee_in_settlement_currency character varying, transaction_fee_in_settlement_currency_sign character varying, miscellaneous_fee_in_settlement_currency character varying, miscellaneous_fee_in_settlement_currency_sign character varying, other_fee_in_settlement_currency character varying, other_fee_in_settlement_currency_sign character varying, sales_credit_in_settlement_currency character varying, sales_credit_in_settlement_currency_sign character varying, settlement_fee_in_settlement_currency character varying, settlement_fee_in_settlement_currency_sign character varying, service_charge_in_settlement_currency character varying, service_charge_in_settlement_currency_sign character varying, markup_markdown_in_settlement_currency character varying, markup_markdown_in_settlement_currency_sign character varying, global_exchange character varying, number_of_description_lines character varying, last_description_line character varying, description_line_1 character varying, description_line_2 character varying, description_line_3 character varying, description_line_4 character varying, description_line_5 character varying, description_line_6 character varying, description_line_7 character varying, description_line_8 character varying, description_line_9 character varying, description_line_10 character varying, description_line_11 character varying, description_line_12 character varying, security_currency_indicator character varying, market_mnemonic_code character varying, ccy_of_issuance_usd_ccy_fx_rate character varying, ccy_of_issuance_usd_multiply_divide_code character varying, alternate_security_id_type character varying, alternate_security_id character varying, alternate_security_id_type_2 character varying, alternate_security_id_2 character varying, international_non_dollar_symbol character varying, confirmation_code_1 character varying, confirmation_code_2 character varying, confirmation_code_3 character varying, confirmation_code_4 character varying, pmp character varying, total_amount_mark_up_down character varying, total_amount_mark_up_down_sign character varying, pmp_percent character varying, campo_73 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 10)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 22, 3)::VARCHAR(100) as security_currency_of_issuance,
        substr(sfl_file.linea, 25, 3)::VARCHAR(100) as trade_currency_code,
        substr(sfl_file.linea, 28, 3)::VARCHAR(100) as settlement_currency_code,
        substr(sfl_file.linea, 31, 18)::VARCHAR(100) as settlement_usd_currency_fx_rate,
        substr(sfl_file.linea, 49, 1)::VARCHAR(100) as settlement_usd_multiply_divide_code,
        substr(sfl_file.linea, 50, 18)::VARCHAR(100) as cross_currency_fx_rate,
        substr(sfl_file.linea, 68, 1)::VARCHAR(100) as currency_multiply_divide_code,
        substr(sfl_file.linea, 69, 18)::VARCHAR(100) as accrued_interest_in_settlement_currency,
        substr(sfl_file.linea, 87, 1)::VARCHAR(100) as accrued_interest_in_settlement_currency_sign,
        substr(sfl_file.linea, 88, 12)::VARCHAR(100) as market_code,
        substr(sfl_file.linea, 100, 20)::VARCHAR(100) as internal_reference_for_gloss,
        substr(sfl_file.linea, 120, 2)::VARCHAR(100) as ibd_version,
        substr(sfl_file.linea, 122, 18)::VARCHAR(100) as net_amount_in_settlement_currency,
        substr(sfl_file.linea, 140, 1)::VARCHAR(100) as net_amount_in_settlement_currency_sign,
        substr(sfl_file.linea, 141, 18)::VARCHAR(100) as principal_amount_in_settlement_currency,
        substr(sfl_file.linea, 159, 1)::VARCHAR(100) as principal_amount_in_settlement_currency_sign,
        substr(sfl_file.linea, 160, 18)::VARCHAR(100) as interest_in_settlement_currency,
        substr(sfl_file.linea, 178, 1)::VARCHAR(100) as interest_in_settlement_currency_sign,
        substr(sfl_file.linea, 179, 18)::VARCHAR(100) as commission_in_settlement_currency,
        substr(sfl_file.linea, 197, 1)::VARCHAR(100) as commission_in_settlement_currency_sign,
        substr(sfl_file.linea, 198, 18)::VARCHAR(100) as tax_in_settlement_currency,
        substr(sfl_file.linea, 216, 1)::VARCHAR(100) as tax_in_settlement_currency_sign,
        substr(sfl_file.linea, 217, 18)::VARCHAR(100) as transaction_fee_in_settlement_currency,
        substr(sfl_file.linea, 235, 1)::VARCHAR(100) as transaction_fee_in_settlement_currency_sign,
        substr(sfl_file.linea, 236, 18)::VARCHAR(100) as miscellaneous_fee_in_settlement_currency,
        substr(sfl_file.linea, 254, 1)::VARCHAR(100) as miscellaneous_fee_in_settlement_currency_sign,
        substr(sfl_file.linea, 255, 18)::VARCHAR(100) as other_fee_in_settlement_currency,
        substr(sfl_file.linea, 273, 1)::VARCHAR(100) as other_fee_in_settlement_currency_sign,
        substr(sfl_file.linea, 274, 18)::VARCHAR(100) as sales_credit_in_settlement_currency,
        substr(sfl_file.linea, 292, 1)::VARCHAR(100) as sales_credit_in_settlement_currency_sign,
        substr(sfl_file.linea, 293, 18)::VARCHAR(100) as settlement_fee_in_settlement_currency,
        substr(sfl_file.linea, 311, 1)::VARCHAR(100) as settlement_fee_in_settlement_currency_sign,
        substr(sfl_file.linea, 312, 18)::VARCHAR(100) as service_charge_in_settlement_currency,
        substr(sfl_file.linea, 330, 1)::VARCHAR(100) as service_charge_in_settlement_currency_sign,
        substr(sfl_file.linea, 331, 18)::VARCHAR(100) as markup_markdown_in_settlement_currency,
        substr(sfl_file.linea, 349, 1)::VARCHAR(100) as markup_markdown_in_settlement_currency_sign,
        substr(sfl_file.linea, 350, 4)::VARCHAR(100) as global_exchange,
        substr(sfl_file.linea, 354, 2)::VARCHAR(100) as number_of_description_lines,
        substr(sfl_file.linea, 356, 2)::VARCHAR(100) as last_description_line,
        substr(sfl_file.linea, 358, 20)::VARCHAR(100) as description_line_1,
        substr(sfl_file.linea, 378, 20)::VARCHAR(100) as description_line_2,
        substr(sfl_file.linea, 398, 20)::VARCHAR(100) as description_line_3,
        substr(sfl_file.linea, 418, 20)::VARCHAR(100) as description_line_4,
        substr(sfl_file.linea, 438, 20)::VARCHAR(100) as description_line_5,
        substr(sfl_file.linea, 458, 20)::VARCHAR(100) as description_line_6,
        substr(sfl_file.linea, 478, 20)::VARCHAR(100) as description_line_7,
        substr(sfl_file.linea, 498, 20)::VARCHAR(100) as description_line_8,
        substr(sfl_file.linea, 518, 20)::VARCHAR(100) as description_line_9,
        substr(sfl_file.linea, 538, 20)::VARCHAR(100) as description_line_10,
        substr(sfl_file.linea, 558, 20)::VARCHAR(100) as description_line_11,
        substr(sfl_file.linea, 578, 20)::VARCHAR(100) as description_line_12,
        substr(sfl_file.linea, 598, 1)::VARCHAR(100) as security_currency_indicator,
        substr(sfl_file.linea, 599, 4)::VARCHAR(100) as market_mnemonic_code,
        substr(sfl_file.linea, 603, 18)::VARCHAR(100) as ccy_of_issuance_usd_ccy_fx_rate,
        substr(sfl_file.linea, 621, 1)::VARCHAR(100) as ccy_of_issuance_usd_multiply_divide_code,
        substr(sfl_file.linea, 622, 1)::VARCHAR(100) as alternate_security_id_type,
        substr(sfl_file.linea, 623, 12)::VARCHAR(100) as alternate_security_id,
        substr(sfl_file.linea, 635, 1)::VARCHAR(100) as alternate_security_id_type_2,
        substr(sfl_file.linea, 636, 12)::VARCHAR(100) as alternate_security_id_2,
        substr(sfl_file.linea, 648, 16)::VARCHAR(100) as international_non_dollar_symbol,
        substr(sfl_file.linea, 664, 2)::VARCHAR(100) as confirmation_code_1,
        substr(sfl_file.linea, 666, 2)::VARCHAR(100) as confirmation_code_2,
        substr(sfl_file.linea, 668, 2)::VARCHAR(100) as confirmation_code_3,
        substr(sfl_file.linea, 670, 2)::VARCHAR(100) as confirmation_code_4,
        substr(sfl_file.linea, 672, 18)::VARCHAR(100) as pmp,
        substr(sfl_file.linea, 690, 18)::VARCHAR(100) as total_amount_mark_up_down,
        substr(sfl_file.linea, 708, 1)::VARCHAR(100) as total_amount_mark_up_down_sign,
        substr(sfl_file.linea, 709, 9)::VARCHAR(100) as pmp_percent,
        substr(sfl_file.linea, 718, 32)::VARCHAR(100) as campo_73,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gact_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 3)		= 'GAB'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_gact_reg_trailer(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, eof character varying, campo_2 character varying, campo_3 character varying, date_of_data character varying, campo_5 character varying, remote_id character varying, campo_7 character varying, campo_8 character varying, number_detail_of_records character varying, campo_10 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as eof,
        substr(sfl_file.linea, 19, 18)::VARCHAR(100) as campo_2,
        substr(sfl_file.linea, 37, 10)::VARCHAR(100) as campo_3,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 12)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 84, 22)::VARCHAR(100) as campo_8,
        substr(sfl_file.linea, 106, 10)::VARCHAR(100) as number_detail_of_records,
        substr(sfl_file.linea, 116, 634)::VARCHAR(100) as campo_10,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gact_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 3)		= 'GAB'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_gact_reg_header(_id_proceso bigint) returns SETOF stage_pershing.stage_gact_reg_header
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        bof::VARCHAR(100),
        campo_2::VARCHAR(100),
        campo_3::VARCHAR(100),
        date_of_data::VARCHAR(100),
        campo_5::VARCHAR(100),
        remote_id::VARCHAR(100),
        campo_7::VARCHAR(100),
        run_date::VARCHAR(100),
        campo_9::VARCHAR(100),
        run_time::VARCHAR(100),
        campo_11::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gact_reg_header(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_gact_reg_a(_id_proceso bigint) returns SETOF stage_pershing.stage_gact_reg_a
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        transaction_code::VARCHAR(100),
        record_indicator_value::VARCHAR(100),
        record_id_sequence_number::int,
        account_number::VARCHAR(100),
        cusip_number::VARCHAR(100),
        campo_6::VARCHAR(100),
        underlying_cusip::VARCHAR(100),
        campo_8::VARCHAR(100),
        security_symbol::VARCHAR(100),
        investment_professional_of_record::VARCHAR(100),
        executing_investment_professional::VARCHAR(100),
        transaction_type::VARCHAR(100),
        buy_sell_code::VARCHAR(100),
        open_close_indicator::VARCHAR(100),
        par_key_code::VARCHAR(100),
        source_code::VARCHAR(100),
        maxx_key_code::int,
        public.fn_fecha_string_to_date(process_date_sfl, 'CCYYMMDD') as process_date_sfl,
        public.fn_fecha_string_to_date(trade_date, 'CCYYMMDD') as trade_date,
        public.fn_fecha_string_to_date(settlement_entry_date, 'CCYYMMDD') as settlement_entry_date,
        campo_21::VARCHAR(100),
        source_of_input::VARCHAR(100),
        reference_number::VARCHAR(100),
        batch_code::VARCHAR(100),
        same_day_settlement::VARCHAR(100),
        contra_account::VARCHAR(100),
        market_code::VARCHAR(100),
        blotter_code::VARCHAR(100),
        cancel_code::VARCHAR(100),
        correction_code::VARCHAR(100),
        merket_limit_indicator::VARCHAR(100),
        legend_code_1::VARCHAR(100),
        legend_code_2::VARCHAR(100),
        campo_34::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(quantity, 5)::NUMERIC(45,20) as quantity,
        quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(price_in_trade_currency, 9)::NUMERIC(45,20) as price_in_trade_currency,
        campo_38::VARCHAR(100),
        price_in_trade_currency_sign::VARCHAR(100),
        currency_indicator_for_price::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(net_amount_in_usd, 3)::NUMERIC(45,20) as net_amount_in_usd,
        net_amount_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(principal_in_usd, 3)::NUMERIC(45,20) as principal_in_usd,
        principal_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(interest_in_usd, 2)::NUMERIC(45,20) as interest_in_usd,
        interest_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(commision_in_usd, 2)::NUMERIC(45,20) as commision_in_usd,
        commision_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(tax_in_usd, 2)::NUMERIC(45,20) as tax_in_usd,
        tax_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(transaction_fee_in_usd, 2)::NUMERIC(45,20) as transaction_fee_in_usd,
        transaction_fee_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(misc_fee_in_usd, 2)::NUMERIC(45,20) as misc_fee_in_usd,
        misc_fee_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(other_fee_in_usd, 2)::NUMERIC(45,20) as other_fee_in_usd,
        other_fee_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(tefra_wh_amount_in_usd, 2)::NUMERIC(45,20) as tefra_wh_amount_in_usd,
        tefra_wh_amount_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(pershing_charge_in_usd, 2)::NUMERIC(45,20) as pershing_charge_in_usd,
        pershing_charge_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(brokerage_charge_in_usd, 2)::NUMERIC(45,20) as brokerage_charge_in_usd,
        brokerage_charge_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(sales_credit_in_usd, 2)::NUMERIC(45,20) as sales_credit_in_usd,
        sales_credit_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_fee_in_usd, 2)::NUMERIC(45,20) as settlement_fee_in_usd,
        settlement_fee_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(service_charge_in_usd, 2)::NUMERIC(45,20) as service_charge_in_usd,
        service_charge_in_usd_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(markup_markdown_amount_in_usd, 2)::NUMERIC(45,20) as markup_markdown_amount_in_usd,
        markup_markdown_amount_in_usd_sign::VARCHAR(100),
        campo_71::VARCHAR(100),
        public.fn_fecha_string_to_date(dividend_payable_date, 'CCYYMMDD') as dividend_payable_date,
        campo_73::VARCHAR(100),
        public.fn_fecha_string_to_date(dividend_record_date, 'CCYYMMDD') as dividend_record_date,
        dividend_type::int,
        campo_76::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(shares_of_record_quantity_for_dividends, 5)::NUMERIC(45,20) as shares_of_record_quantity_for_dividends,
        public.fn_convierte_texto_numerico_cobol(order_size_quantity, 5)::NUMERIC(45,20) as order_size_quantity,
        campo_79::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(pool_factor, 9)::NUMERIC(45,20) as pool_factor,
        parsed_customer_account_number::VARCHAR(100),
        ibd_number::VARCHAR(100),
        security_type_code::VARCHAR(100),
        security_modifier_code::VARCHAR(100),
        security_calculation_code::VARCHAR(100),
        minor_product_code::VARCHAR(100),
        foreign_product_indicator::VARCHAR(100),
        with_due_bill_indicator::VARCHAR(100),
        taxable_municipal_bond_indicator::VARCHAR(100),
        omnibus_indicator::VARCHAR(100),
        external_order_id::VARCHAR(100),
        campo_92::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(market_value_of_transaction, 2)::NUMERIC(45,20) as market_value_of_transaction,
        ip_number_parsed::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(reported_price, 9)::NUMERIC(45,20) as reported_price,
        reported_price_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(previous_day_market_value_of_transaction, 2)::NUMERIC(45,20) as previous_day_market_value_of_transaction,
        public.fn_convierte_texto_numerico_cobol(price_in_usd, 9)::NUMERIC(45,20) as price_in_usd,
        option_root_id::VARCHAR(100),
        public.fn_fecha_string_to_date(expiration_date, 'YYMMDD') as expiration_date,
        put_call_code::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(strike_price, 3)::NUMERIC(45,20) as strike_price,
        repo_identifier::VARCHAR(100),
        taxable::VARCHAR(100),
        qualified::VARCHAR(100),
        expanded_ip_number::VARCHAR(100),
        expanded_exec_ip_number::VARCHAR(100),
        expanded_legacy_ip_number::VARCHAR(100),
        campo_109::VARCHAR(100),
        campo_110::VARCHAR(100),
        campo_111::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gact_reg_a(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_gact_reg_b(_id_proceso bigint) returns SETOF stage_pershing.stage_gact_reg_b
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        transaction_code::VARCHAR(100),
        record_indicator_value::VARCHAR(100),
        record_id_sequence_number::int,
        account_number::VARCHAR(100),
        security_currency_of_issuance::VARCHAR(100),
        trade_currency_code::VARCHAR(100),
        settlement_currency_code::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_usd_currency_fx_rate, 9)::NUMERIC(45,20) as settlement_usd_currency_fx_rate,
        settlement_usd_multiply_divide_code::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(cross_currency_fx_rate, 9)::NUMERIC(45,20) as cross_currency_fx_rate,
        currency_multiply_divide_code::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(accrued_interest_in_settlement_currency, 2)::NUMERIC(45,20) as accrued_interest_in_settlement_currency,
        accrued_interest_in_settlement_currency_sign::VARCHAR(100),
        market_code::VARCHAR(100),
        internal_reference_for_gloss::VARCHAR(100),
        ibd_version::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(net_amount_in_settlement_currency, 2)::NUMERIC(45,20) as net_amount_in_settlement_currency,
        net_amount_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(principal_amount_in_settlement_currency, 2)::NUMERIC(45,20) as principal_amount_in_settlement_currency,
        principal_amount_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(interest_in_settlement_currency, 2)::NUMERIC(45,20) as interest_in_settlement_currency,
        interest_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(commission_in_settlement_currency, 2)::NUMERIC(45,20) as commission_in_settlement_currency,
        commission_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(tax_in_settlement_currency, 2)::NUMERIC(45,20) as tax_in_settlement_currency,
        tax_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(transaction_fee_in_settlement_currency, 2)::NUMERIC(45,20) as transaction_fee_in_settlement_currency,
        transaction_fee_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(miscellaneous_fee_in_settlement_currency, 2)::NUMERIC(45,20) as miscellaneous_fee_in_settlement_currency,
        miscellaneous_fee_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(other_fee_in_settlement_currency, 2)::NUMERIC(45,20) as other_fee_in_settlement_currency,
        other_fee_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(sales_credit_in_settlement_currency, 2)::NUMERIC(45,20) as sales_credit_in_settlement_currency,
        sales_credit_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_fee_in_settlement_currency, 2)::NUMERIC(45,20) as settlement_fee_in_settlement_currency,
        settlement_fee_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(service_charge_in_settlement_currency, 2)::NUMERIC(45,20) as service_charge_in_settlement_currency,
        service_charge_in_settlement_currency_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(markup_markdown_in_settlement_currency, 2)::NUMERIC(45,20) as markup_markdown_in_settlement_currency,
        markup_markdown_in_settlement_currency_sign::VARCHAR(100),
        global_exchange::VARCHAR(100),
        number_of_description_lines::int,
        last_description_line::int,
        description_line_1::VARCHAR(100),
        description_line_2::VARCHAR(100),
        description_line_3::VARCHAR(100),
        description_line_4::VARCHAR(100),
        description_line_5::VARCHAR(100),
        description_line_6::VARCHAR(100),
        description_line_7::VARCHAR(100),
        description_line_8::VARCHAR(100),
        description_line_9::VARCHAR(100),
        description_line_10::VARCHAR(100),
        description_line_11::VARCHAR(100),
        description_line_12::VARCHAR(100),
        security_currency_indicator::VARCHAR(100),
        market_mnemonic_code::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(ccy_of_issuance_usd_ccy_fx_rate, 9)::NUMERIC(45,20) as ccy_of_issuance_usd_ccy_fx_rate,
        ccy_of_issuance_usd_multiply_divide_code::VARCHAR(100),
        alternate_security_id_type::VARCHAR(100),
        alternate_security_id::VARCHAR(100),
        alternate_security_id_type_2::VARCHAR(100),
        alternate_security_id_2::VARCHAR(100),
        international_non_dollar_symbol::VARCHAR(100),
        confirmation_code_1::VARCHAR(100),
        confirmation_code_2::VARCHAR(100),
        confirmation_code_3::VARCHAR(100),
        confirmation_code_4::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(pmp, 9)::NUMERIC(45,20) as pmp,
        public.fn_convierte_texto_numerico_cobol(total_amount_mark_up_down, 2)::NUMERIC(45,20) as total_amount_mark_up_down,
        total_amount_mark_up_down_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(pmp_percent, 5)::NUMERIC(45,20) as pmp_percent,
        campo_73::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gact_reg_b(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_gact_reg_trailer(_id_proceso bigint) returns SETOF stage_pershing.stage_gact_reg_trailer
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        eof::VARCHAR(100),
        campo_2::VARCHAR(100),
        campo_3::VARCHAR(100),
        date_of_data::VARCHAR(100),
        campo_5::VARCHAR(100),
        remote_id::VARCHAR(100),
        campo_7::VARCHAR(100),
        campo_8::VARCHAR(100),
        number_detail_of_records::int,
        campo_10::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gact_reg_trailer(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create procedure stage_pershing.pa_parse_gact(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
begin

    DELETE FROM stage_pershing.stage_gact_reg_header reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_gact_reg_a reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_gact_reg_b reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_gact_reg_trailer reg_del WHERE reg_del.id_proceso=_id_proceso;

    INSERT INTO stage_pershing.stage_gact_reg_header (id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, eor)
    SELECT id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, eor
    FROM stage_pershing.fn_parse_gact_reg_header(_id_proceso);

    INSERT INTO stage_pershing.stage_gact_reg_a (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, cusip_number, campo_6, underlying_cusip, campo_8, security_symbol, investment_professional_of_record, executing_investment_professional, transaction_type, buy_sell_code, open_close_indicator, par_key_code, source_code, maxx_key_code, process_date_sfl, trade_date, settlement_entry_date, campo_21, source_of_input, reference_number, batch_code, same_day_settlement, contra_account, market_code, blotter_code, cancel_code, correction_code, merket_limit_indicator, legend_code_1, legend_code_2, campo_34, quantity, quantity_sign, price_in_trade_currency, campo_38, price_in_trade_currency_sign, currency_indicator_for_price, net_amount_in_usd, net_amount_in_usd_sign, principal_in_usd, principal_in_usd_sign, interest_in_usd, interest_in_usd_sign, commision_in_usd, commision_in_usd_sign, tax_in_usd, tax_in_usd_sign, transaction_fee_in_usd, transaction_fee_in_usd_sign, misc_fee_in_usd, misc_fee_in_usd_sign, other_fee_in_usd, other_fee_in_usd_sign, tefra_wh_amount_in_usd, tefra_wh_amount_in_usd_sign, pershing_charge_in_usd, pershing_charge_in_usd_sign, brokerage_charge_in_usd, brokerage_charge_in_usd_sign, sales_credit_in_usd, sales_credit_in_usd_sign, settlement_fee_in_usd, settlement_fee_in_usd_sign, service_charge_in_usd, service_charge_in_usd_sign, markup_markdown_amount_in_usd, markup_markdown_amount_in_usd_sign, campo_71, dividend_payable_date, campo_73, dividend_record_date, dividend_type, campo_76, shares_of_record_quantity_for_dividends, order_size_quantity, campo_79, pool_factor, parsed_customer_account_number, ibd_number, security_type_code, security_modifier_code, security_calculation_code, minor_product_code, foreign_product_indicator, with_due_bill_indicator, taxable_municipal_bond_indicator, omnibus_indicator, external_order_id, campo_92, market_value_of_transaction, ip_number_parsed, reported_price, reported_price_sign, previous_day_market_value_of_transaction, price_in_usd, option_root_id, expiration_date, put_call_code, strike_price, repo_identifier, taxable, qualified, expanded_ip_number, expanded_exec_ip_number, expanded_legacy_ip_number, campo_109, campo_110, campo_111, eor)
    SELECT id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, cusip_number, campo_6, underlying_cusip, campo_8, security_symbol, investment_professional_of_record, executing_investment_professional, transaction_type, buy_sell_code, open_close_indicator, par_key_code, source_code, maxx_key_code, process_date_sfl, trade_date, settlement_entry_date, campo_21, source_of_input, reference_number, batch_code, same_day_settlement, contra_account, market_code, blotter_code, cancel_code, correction_code, merket_limit_indicator, legend_code_1, legend_code_2, campo_34, quantity, quantity_sign, price_in_trade_currency, campo_38, price_in_trade_currency_sign, currency_indicator_for_price, net_amount_in_usd, net_amount_in_usd_sign, principal_in_usd, principal_in_usd_sign, interest_in_usd, interest_in_usd_sign, commision_in_usd, commision_in_usd_sign, tax_in_usd, tax_in_usd_sign, transaction_fee_in_usd, transaction_fee_in_usd_sign, misc_fee_in_usd, misc_fee_in_usd_sign, other_fee_in_usd, other_fee_in_usd_sign, tefra_wh_amount_in_usd, tefra_wh_amount_in_usd_sign, pershing_charge_in_usd, pershing_charge_in_usd_sign, brokerage_charge_in_usd, brokerage_charge_in_usd_sign, sales_credit_in_usd, sales_credit_in_usd_sign, settlement_fee_in_usd, settlement_fee_in_usd_sign, service_charge_in_usd, service_charge_in_usd_sign, markup_markdown_amount_in_usd, markup_markdown_amount_in_usd_sign, campo_71, dividend_payable_date, campo_73, dividend_record_date, dividend_type, campo_76, shares_of_record_quantity_for_dividends, order_size_quantity, campo_79, pool_factor, parsed_customer_account_number, ibd_number, security_type_code, security_modifier_code, security_calculation_code, minor_product_code, foreign_product_indicator, with_due_bill_indicator, taxable_municipal_bond_indicator, omnibus_indicator, external_order_id, campo_92, market_value_of_transaction, ip_number_parsed, reported_price, reported_price_sign, previous_day_market_value_of_transaction, price_in_usd, option_root_id, expiration_date, put_call_code, strike_price, repo_identifier, taxable, qualified, expanded_ip_number, expanded_exec_ip_number, expanded_legacy_ip_number, campo_109, campo_110, campo_111, eor
    FROM stage_pershing.fn_parse_gact_reg_a(_id_proceso);

    INSERT INTO stage_pershing.stage_gact_reg_b (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, security_currency_of_issuance, trade_currency_code, settlement_currency_code, settlement_usd_currency_fx_rate, settlement_usd_multiply_divide_code, cross_currency_fx_rate, currency_multiply_divide_code, accrued_interest_in_settlement_currency, accrued_interest_in_settlement_currency_sign, market_code, internal_reference_for_gloss, ibd_version, net_amount_in_settlement_currency, net_amount_in_settlement_currency_sign, principal_amount_in_settlement_currency, principal_amount_in_settlement_currency_sign, interest_in_settlement_currency, interest_in_settlement_currency_sign, commission_in_settlement_currency, commission_in_settlement_currency_sign, tax_in_settlement_currency, tax_in_settlement_currency_sign, transaction_fee_in_settlement_currency, transaction_fee_in_settlement_currency_sign, miscellaneous_fee_in_settlement_currency, miscellaneous_fee_in_settlement_currency_sign, other_fee_in_settlement_currency, other_fee_in_settlement_currency_sign, sales_credit_in_settlement_currency, sales_credit_in_settlement_currency_sign, settlement_fee_in_settlement_currency, settlement_fee_in_settlement_currency_sign, service_charge_in_settlement_currency, service_charge_in_settlement_currency_sign, markup_markdown_in_settlement_currency, markup_markdown_in_settlement_currency_sign, global_exchange, number_of_description_lines, last_description_line, description_line_1, description_line_2, description_line_3, description_line_4, description_line_5, description_line_6, description_line_7, description_line_8, description_line_9, description_line_10, description_line_11, description_line_12, security_currency_indicator, market_mnemonic_code, ccy_of_issuance_usd_ccy_fx_rate, ccy_of_issuance_usd_multiply_divide_code, alternate_security_id_type, alternate_security_id, alternate_security_id_type_2, alternate_security_id_2, international_non_dollar_symbol, confirmation_code_1, confirmation_code_2, confirmation_code_3, confirmation_code_4, pmp, total_amount_mark_up_down, total_amount_mark_up_down_sign, pmp_percent, campo_73, eor)
    SELECT id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, security_currency_of_issuance, trade_currency_code, settlement_currency_code, settlement_usd_currency_fx_rate, settlement_usd_multiply_divide_code, cross_currency_fx_rate, currency_multiply_divide_code, accrued_interest_in_settlement_currency, accrued_interest_in_settlement_currency_sign, market_code, internal_reference_for_gloss, ibd_version, net_amount_in_settlement_currency, net_amount_in_settlement_currency_sign, principal_amount_in_settlement_currency, principal_amount_in_settlement_currency_sign, interest_in_settlement_currency, interest_in_settlement_currency_sign, commission_in_settlement_currency, commission_in_settlement_currency_sign, tax_in_settlement_currency, tax_in_settlement_currency_sign, transaction_fee_in_settlement_currency, transaction_fee_in_settlement_currency_sign, miscellaneous_fee_in_settlement_currency, miscellaneous_fee_in_settlement_currency_sign, other_fee_in_settlement_currency, other_fee_in_settlement_currency_sign, sales_credit_in_settlement_currency, sales_credit_in_settlement_currency_sign, settlement_fee_in_settlement_currency, settlement_fee_in_settlement_currency_sign, service_charge_in_settlement_currency, service_charge_in_settlement_currency_sign, markup_markdown_in_settlement_currency, markup_markdown_in_settlement_currency_sign, global_exchange, number_of_description_lines, last_description_line, description_line_1, description_line_2, description_line_3, description_line_4, description_line_5, description_line_6, description_line_7, description_line_8, description_line_9, description_line_10, description_line_11, description_line_12, security_currency_indicator, market_mnemonic_code, ccy_of_issuance_usd_ccy_fx_rate, ccy_of_issuance_usd_multiply_divide_code, alternate_security_id_type, alternate_security_id, alternate_security_id_type_2, alternate_security_id_2, international_non_dollar_symbol, confirmation_code_1, confirmation_code_2, confirmation_code_3, confirmation_code_4, pmp, total_amount_mark_up_down, total_amount_mark_up_down_sign, pmp_percent, campo_73, eor
    FROM stage_pershing.fn_parse_gact_reg_b(_id_proceso);

    INSERT INTO stage_pershing.stage_gact_reg_trailer (id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, campo_8, number_detail_of_records, campo_10, eor)
    SELECT id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, campo_8, number_detail_of_records, campo_10, eor
    FROM stage_pershing.fn_parse_gact_reg_trailer(_id_proceso);

end;
$$;

create function stage_pershing.fn_extrae_gcus_reg_header(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, bof character varying, campo_2 character varying, campo_3 character varying, date_of_data character varying, campo_5 character varying, remote_id character varying, campo_7 character varying, run_date character varying, campo_9 character varying, run_time character varying, campo_11 character varying, refreshed_or_updated character varying, campo_13 character varying, eof character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as bof,
        substr(sfl_file.linea, 19, 18)::VARCHAR(100) as campo_2,
        substr(sfl_file.linea, 37, 10)::VARCHAR(100) as campo_3,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 14)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 86, 10)::VARCHAR(100) as run_date,
        substr(sfl_file.linea, 96, 1)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 97, 8)::VARCHAR(100) as run_time,
        substr(sfl_file.linea, 105, 14)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 119, 9)::VARCHAR(100) as refreshed_or_updated,
        substr(sfl_file.linea, 128, 622)::VARCHAR(100) as campo_13,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eof

    FROM stage_pershing.stage_gcus_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 3)		= 'GAB'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_gcus_reg_a(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, cusip_number character varying, portfolio_currency character varying, campo_7 character varying, underlying_cusip_number character varying, country_code character varying, campo_10 character varying, ip_record_number character varying, ibd_number character varying, currency_security_indicator character varying, issue_currency character varying, datestamp_trade_date character varying, datestamp_settlement_date character varying, trade_date_quantity character varying, trade_date_quantity_sign character varying, settlement_date_quantity character varying, settlement_date_quantity_sign character varying, seg_quantity character varying, seg_quantity_sign character varying, safekeeping_quantity character varying, safekeeping_sign character varying, transfer_quantity character varying, transfer_quantity_sign character varying, pending_transfer_quantity character varying, pending_transfer_quantity_sign character varying, legal_transfer_quantity character varying, legal_transfer_quantity_sign character varying, tendered_quantity character varying, tendered_quantity_sign character varying, pending_papers character varying, pending_papers_sign character varying, short_against_the_box_quantity character varying, short_against_the_box_quantity_sign character varying, networked_quantity character varying, networked_quantity_sign character varying, pending_split_quantity character varying, pending_split_quantity_sign character varying, quantity_covering_options character varying, quantity_covering_options_sign character varying, trade_date_quantity_bought character varying, trade_date_quantity_bought_sign character varying, trade_date_quantity_sold character varying, trade_date_quantity_sold_sign character varying, fed_rquirement character varying, fed_rquirement_sign character varying, house_margin_requirement character varying, house_margin_requirement_sign character varying, nyse_requirement character varying, nyse_requirement_sign character varying, equity_requirment character varying, equity_requirment_sign character varying, security_symbol character varying, security_type character varying, security_mod character varying, security_calc character varying, minor_product_code character varying, network_eligibility_indicator character varying, strike_price character varying, strike_price_sign character varying, expiration_maturity_date character varying, contract_size character varying, conversion_ratio character varying, account_short_name character varying, state_code character varying, country_code_account character varying, campo_69 character varying, number_security_description_lines character varying, security_description_line_1 character varying, security_description_line_2 character varying, security_description_line_3 character varying, security_description_line_4 character varying, security_description_line_5 character varying, security_description_line_6 character varying, dividend_option character varying, long_term_capital_gains_option character varying, short_term_capital_gains_option character varying, firm_trading_indicator character varying, position_currency_security character varying, trade_date_liquidating_value character varying, trade_date_liquidating_value_sign character varying, pool_factor character varying, pool_factor_sign character varying, exchange_rate character varying, exchange_rate_sign character varying, settlement_date_liquidating_value character varying, settlement_date_liquidating_value_sign character varying, campo_90 character varying, alternate_security_id_type character varying, alternate_security_id character varying, campo_93 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 10)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 22, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 31, 3)::VARCHAR(100) as portfolio_currency,
        substr(sfl_file.linea, 34, 1)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 35, 9)::VARCHAR(100) as underlying_cusip_number,
        substr(sfl_file.linea, 44, 2)::VARCHAR(100) as country_code,
        substr(sfl_file.linea, 46, 1)::VARCHAR(100) as campo_10,
        substr(sfl_file.linea, 47, 4)::VARCHAR(100) as ip_record_number,
        substr(sfl_file.linea, 51, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 54, 1)::VARCHAR(100) as currency_security_indicator,
        substr(sfl_file.linea, 55, 3)::VARCHAR(100) as issue_currency,
        substr(sfl_file.linea, 58, 8)::VARCHAR(100) as datestamp_trade_date,
        substr(sfl_file.linea, 66, 8)::VARCHAR(100) as datestamp_settlement_date,
        substr(sfl_file.linea, 74, 18)::VARCHAR(100) as trade_date_quantity,
        substr(sfl_file.linea, 92, 1)::VARCHAR(100) as trade_date_quantity_sign,
        substr(sfl_file.linea, 93, 18)::VARCHAR(100) as settlement_date_quantity,
        substr(sfl_file.linea, 111, 1)::VARCHAR(100) as settlement_date_quantity_sign,
        substr(sfl_file.linea, 112, 18)::VARCHAR(100) as seg_quantity,
        substr(sfl_file.linea, 130, 1)::VARCHAR(100) as seg_quantity_sign,
        substr(sfl_file.linea, 131, 18)::VARCHAR(100) as safekeeping_quantity,
        substr(sfl_file.linea, 149, 1)::VARCHAR(100) as safekeeping_sign,
        substr(sfl_file.linea, 150, 18)::VARCHAR(100) as transfer_quantity,
        substr(sfl_file.linea, 168, 1)::VARCHAR(100) as transfer_quantity_sign,
        substr(sfl_file.linea, 169, 18)::VARCHAR(100) as pending_transfer_quantity,
        substr(sfl_file.linea, 187, 1)::VARCHAR(100) as pending_transfer_quantity_sign,
        substr(sfl_file.linea, 188, 18)::VARCHAR(100) as legal_transfer_quantity,
        substr(sfl_file.linea, 206, 1)::VARCHAR(100) as legal_transfer_quantity_sign,
        substr(sfl_file.linea, 207, 18)::VARCHAR(100) as tendered_quantity,
        substr(sfl_file.linea, 225, 1)::VARCHAR(100) as tendered_quantity_sign,
        substr(sfl_file.linea, 226, 18)::VARCHAR(100) as pending_papers,
        substr(sfl_file.linea, 244, 1)::VARCHAR(100) as pending_papers_sign,
        substr(sfl_file.linea, 245, 18)::VARCHAR(100) as short_against_the_box_quantity,
        substr(sfl_file.linea, 263, 1)::VARCHAR(100) as short_against_the_box_quantity_sign,
        substr(sfl_file.linea, 264, 18)::VARCHAR(100) as networked_quantity,
        substr(sfl_file.linea, 282, 1)::VARCHAR(100) as networked_quantity_sign,
        substr(sfl_file.linea, 283, 18)::VARCHAR(100) as pending_split_quantity,
        substr(sfl_file.linea, 301, 1)::VARCHAR(100) as pending_split_quantity_sign,
        substr(sfl_file.linea, 302, 18)::VARCHAR(100) as quantity_covering_options,
        substr(sfl_file.linea, 320, 1)::VARCHAR(100) as quantity_covering_options_sign,
        substr(sfl_file.linea, 321, 18)::VARCHAR(100) as trade_date_quantity_bought,
        substr(sfl_file.linea, 339, 1)::VARCHAR(100) as trade_date_quantity_bought_sign,
        substr(sfl_file.linea, 340, 18)::VARCHAR(100) as trade_date_quantity_sold,
        substr(sfl_file.linea, 358, 1)::VARCHAR(100) as trade_date_quantity_sold_sign,
        substr(sfl_file.linea, 359, 18)::VARCHAR(100) as fed_rquirement,
        substr(sfl_file.linea, 377, 1)::VARCHAR(100) as fed_rquirement_sign,
        substr(sfl_file.linea, 378, 18)::VARCHAR(100) as house_margin_requirement,
        substr(sfl_file.linea, 396, 1)::VARCHAR(100) as house_margin_requirement_sign,
        substr(sfl_file.linea, 397, 18)::VARCHAR(100) as nyse_requirement,
        substr(sfl_file.linea, 415, 1)::VARCHAR(100) as nyse_requirement_sign,
        substr(sfl_file.linea, 416, 18)::VARCHAR(100) as equity_requirment,
        substr(sfl_file.linea, 434, 1)::VARCHAR(100) as equity_requirment_sign,
        substr(sfl_file.linea, 435, 9)::VARCHAR(100) as security_symbol,
        substr(sfl_file.linea, 444, 1)::VARCHAR(100) as security_type,
        substr(sfl_file.linea, 445, 1)::VARCHAR(100) as security_mod,
        substr(sfl_file.linea, 446, 1)::VARCHAR(100) as security_calc,
        substr(sfl_file.linea, 447, 3)::VARCHAR(100) as minor_product_code,
        substr(sfl_file.linea, 450, 1)::VARCHAR(100) as network_eligibility_indicator,
        substr(sfl_file.linea, 451, 18)::VARCHAR(100) as strike_price,
        substr(sfl_file.linea, 469, 1)::VARCHAR(100) as strike_price_sign,
        substr(sfl_file.linea, 470, 8)::VARCHAR(100) as expiration_maturity_date,
        substr(sfl_file.linea, 478, 18)::VARCHAR(100) as contract_size,
        substr(sfl_file.linea, 496, 18)::VARCHAR(100) as conversion_ratio,
        substr(sfl_file.linea, 514, 10)::VARCHAR(100) as account_short_name,
        substr(sfl_file.linea, 524, 3)::VARCHAR(100) as state_code,
        substr(sfl_file.linea, 527, 3)::VARCHAR(100) as country_code_account,
        substr(sfl_file.linea, 530, 4)::VARCHAR(100) as campo_69,
        substr(sfl_file.linea, 534, 4)::VARCHAR(100) as number_security_description_lines,
        substr(sfl_file.linea, 538, 20)::VARCHAR(100) as security_description_line_1,
        substr(sfl_file.linea, 558, 20)::VARCHAR(100) as security_description_line_2,
        substr(sfl_file.linea, 578, 20)::VARCHAR(100) as security_description_line_3,
        substr(sfl_file.linea, 598, 20)::VARCHAR(100) as security_description_line_4,
        substr(sfl_file.linea, 618, 20)::VARCHAR(100) as security_description_line_5,
        substr(sfl_file.linea, 638, 20)::VARCHAR(100) as security_description_line_6,
        substr(sfl_file.linea, 658, 1)::VARCHAR(100) as dividend_option,
        substr(sfl_file.linea, 659, 1)::VARCHAR(100) as long_term_capital_gains_option,
        substr(sfl_file.linea, 660, 1)::VARCHAR(100) as short_term_capital_gains_option,
        substr(sfl_file.linea, 661, 1)::VARCHAR(100) as firm_trading_indicator,
        substr(sfl_file.linea, 662, 3)::VARCHAR(100) as position_currency_security,
        substr(sfl_file.linea, 665, 18)::VARCHAR(100) as trade_date_liquidating_value,
        substr(sfl_file.linea, 683, 1)::VARCHAR(100) as trade_date_liquidating_value_sign,
        substr(sfl_file.linea, 684, 10)::VARCHAR(100) as pool_factor,
        substr(sfl_file.linea, 694, 1)::VARCHAR(100) as pool_factor_sign,
        substr(sfl_file.linea, 695, 18)::VARCHAR(100) as exchange_rate,
        substr(sfl_file.linea, 713, 1)::VARCHAR(100) as exchange_rate_sign,
        substr(sfl_file.linea, 714, 18)::VARCHAR(100) as settlement_date_liquidating_value,
        substr(sfl_file.linea, 732, 1)::VARCHAR(100) as settlement_date_liquidating_value_sign,
        substr(sfl_file.linea, 733, 3)::VARCHAR(100) as campo_90,
        substr(sfl_file.linea, 736, 1)::VARCHAR(100) as alternate_security_id_type,
        substr(sfl_file.linea, 737, 12)::VARCHAR(100) as alternate_security_id,
        substr(sfl_file.linea, 749, 1)::VARCHAR(100) as campo_93,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gcus_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 3)		= 'GCA'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_gcus_reg_b(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, recor_id_sequence_number character varying, account_number character varying, cusip_number character varying, position_currency character varying, campo_7 character varying, underlying_cusip_number character varying, country_code character varying, campo_10 character varying, ip_record_number character varying, ibd_number character varying, fully_paid_lending_quantity character varying, fully_paid_lending_quantity_sign character varying, fully_paid_lending_quantity_collateral_amount character varying, fully_paid_lending_quantity_collateral_amount_sign character varying, option_root_id character varying, expiration_date character varying, call_put_indicator character varying, strike_price character varying, trade_date_repo_quantity character varying, trade_date_repo_quantity_sign character varying, settlement_date_repo_quantity character varying, settlement_date_repo_quantity_sign character varying, trade_date_reverse_repo_quantity character varying, trade_date_reverse_repo_quantity_sign character varying, settlement_date_reverse_repo_quantity character varying, settlement_date_reverse_repo_quantity_sign character varying, collateral_pledge_quantity character varying, collateral_pledge_quantity_sign character varying, corporate_exec_serv_collateral_pledge_quantity character varying, corporate_exec_serv_collateral_pledge_quantity_sign character varying, trade_date_repo_liquidating_value character varying, trade_date_repo_liquidating_value_sign character varying, settlement_date_repo_liquidating_value character varying, settlement_date_repo_liquidating_value_sign character varying, trade_date_reverse_repo_liquidating_value character varying, trade_date_reverse_repo_liquidating_value_sign character varying, settlement_date_reverse_repo_liquidating_value character varying, settlement_date_reverse_repo_liquidating_value_sign character varying, collateral_pledge_liquidating_value character varying, collateral_pledge_liquidating_value_sign character varying, corporate_exec_serv_collateral_pledge_liquidating_value character varying, corporate_exec_serv_collateral_pledge_liquidating_value_sign character varying, trade_date_repo_loan_amount character varying, trade_date_repo_loan_amount_sign character varying, settlement_date_repo_loan_amount character varying, settlement_date_repo_loan_amount_sign character varying, trade_date_reverse_repo_loan_amount character varying, trade_date_reverse_repo_loan_amount_sign character varying, settlement_date_reverse_repo_loan_amount character varying, settlement_date_reverse_repo_loan_amount_sign character varying, accrued_interes_value character varying, accrued_interes_value_sign character varying, dividend_or_coupon_rate character varying, pending_split_quantity_liquidating_value character varying, pending_split_quantity_liquidating_value_sign character varying, campo_58 character varying, internal_non_dollar_symbol character varying, pledged_quantity character varying, pledged_quantity_sign character varying, campo_62 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as recor_id_sequence_number,
        substr(sfl_file.linea, 12, 10)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 22, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 31, 3)::VARCHAR(100) as position_currency,
        substr(sfl_file.linea, 34, 1)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 35, 9)::VARCHAR(100) as underlying_cusip_number,
        substr(sfl_file.linea, 44, 2)::VARCHAR(100) as country_code,
        substr(sfl_file.linea, 46, 1)::VARCHAR(100) as campo_10,
        substr(sfl_file.linea, 47, 4)::VARCHAR(100) as ip_record_number,
        substr(sfl_file.linea, 51, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 54, 18)::VARCHAR(100) as fully_paid_lending_quantity,
        substr(sfl_file.linea, 72, 1)::VARCHAR(100) as fully_paid_lending_quantity_sign,
        substr(sfl_file.linea, 73, 18)::VARCHAR(100) as fully_paid_lending_quantity_collateral_amount,
        substr(sfl_file.linea, 91, 1)::VARCHAR(100) as fully_paid_lending_quantity_collateral_amount_sign,
        substr(sfl_file.linea, 92, 6)::VARCHAR(100) as option_root_id,
        substr(sfl_file.linea, 98, 6)::VARCHAR(100) as expiration_date,
        substr(sfl_file.linea, 104, 1)::VARCHAR(100) as call_put_indicator,
        substr(sfl_file.linea, 105, 8)::VARCHAR(100) as strike_price,
        substr(sfl_file.linea, 113, 18)::VARCHAR(100) as trade_date_repo_quantity,
        substr(sfl_file.linea, 131, 1)::VARCHAR(100) as trade_date_repo_quantity_sign,
        substr(sfl_file.linea, 132, 18)::VARCHAR(100) as settlement_date_repo_quantity,
        substr(sfl_file.linea, 150, 1)::VARCHAR(100) as settlement_date_repo_quantity_sign,
        substr(sfl_file.linea, 151, 18)::VARCHAR(100) as trade_date_reverse_repo_quantity,
        substr(sfl_file.linea, 169, 1)::VARCHAR(100) as trade_date_reverse_repo_quantity_sign,
        substr(sfl_file.linea, 170, 18)::VARCHAR(100) as settlement_date_reverse_repo_quantity,
        substr(sfl_file.linea, 188, 1)::VARCHAR(100) as settlement_date_reverse_repo_quantity_sign,
        substr(sfl_file.linea, 189, 18)::VARCHAR(100) as collateral_pledge_quantity,
        substr(sfl_file.linea, 207, 1)::VARCHAR(100) as collateral_pledge_quantity_sign,
        substr(sfl_file.linea, 208, 18)::VARCHAR(100) as corporate_exec_serv_collateral_pledge_quantity,
        substr(sfl_file.linea, 226, 1)::VARCHAR(100) as corporate_exec_serv_collateral_pledge_quantity_sign,
        substr(sfl_file.linea, 227, 18)::VARCHAR(100) as trade_date_repo_liquidating_value,
        substr(sfl_file.linea, 245, 1)::VARCHAR(100) as trade_date_repo_liquidating_value_sign,
        substr(sfl_file.linea, 246, 18)::VARCHAR(100) as settlement_date_repo_liquidating_value,
        substr(sfl_file.linea, 264, 1)::VARCHAR(100) as settlement_date_repo_liquidating_value_sign,
        substr(sfl_file.linea, 265, 18)::VARCHAR(100) as trade_date_reverse_repo_liquidating_value,
        substr(sfl_file.linea, 283, 1)::VARCHAR(100) as trade_date_reverse_repo_liquidating_value_sign,
        substr(sfl_file.linea, 284, 18)::VARCHAR(100) as settlement_date_reverse_repo_liquidating_value,
        substr(sfl_file.linea, 302, 1)::VARCHAR(100) as settlement_date_reverse_repo_liquidating_value_sign,
        substr(sfl_file.linea, 303, 18)::VARCHAR(100) as collateral_pledge_liquidating_value,
        substr(sfl_file.linea, 321, 1)::VARCHAR(100) as collateral_pledge_liquidating_value_sign,
        substr(sfl_file.linea, 322, 18)::VARCHAR(100) as corporate_exec_serv_collateral_pledge_liquidating_value,
        substr(sfl_file.linea, 340, 1)::VARCHAR(100) as corporate_exec_serv_collateral_pledge_liquidating_value_sign,
        substr(sfl_file.linea, 341, 18)::VARCHAR(100) as trade_date_repo_loan_amount,
        substr(sfl_file.linea, 359, 1)::VARCHAR(100) as trade_date_repo_loan_amount_sign,
        substr(sfl_file.linea, 360, 18)::VARCHAR(100) as settlement_date_repo_loan_amount,
        substr(sfl_file.linea, 378, 1)::VARCHAR(100) as settlement_date_repo_loan_amount_sign,
        substr(sfl_file.linea, 379, 18)::VARCHAR(100) as trade_date_reverse_repo_loan_amount,
        substr(sfl_file.linea, 397, 1)::VARCHAR(100) as trade_date_reverse_repo_loan_amount_sign,
        substr(sfl_file.linea, 398, 18)::VARCHAR(100) as settlement_date_reverse_repo_loan_amount,
        substr(sfl_file.linea, 416, 1)::VARCHAR(100) as settlement_date_reverse_repo_loan_amount_sign,
        substr(sfl_file.linea, 417, 18)::VARCHAR(100) as accrued_interes_value,
        substr(sfl_file.linea, 435, 1)::VARCHAR(100) as accrued_interes_value_sign,
        substr(sfl_file.linea, 436, 18)::VARCHAR(100) as dividend_or_coupon_rate,
        substr(sfl_file.linea, 454, 18)::VARCHAR(100) as pending_split_quantity_liquidating_value,
        substr(sfl_file.linea, 472, 1)::VARCHAR(100) as pending_split_quantity_liquidating_value_sign,
        substr(sfl_file.linea, 473, 38)::VARCHAR(100) as campo_58,
        substr(sfl_file.linea, 511, 16)::VARCHAR(100) as internal_non_dollar_symbol,
        substr(sfl_file.linea, 527, 18)::VARCHAR(100) as pledged_quantity,
        substr(sfl_file.linea, 545, 1)::VARCHAR(100) as pledged_quantity_sign,
        substr(sfl_file.linea, 546, 204)::VARCHAR(100) as campo_62,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gcus_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 3)		= 'GCB'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_gcus_reg_trailer(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, eof character varying, campo_2 character varying, campo_3 character varying, date_of_data character varying, campo_5 character varying, remote_id character varying, campo_7 character varying, number_detail_of_records character varying, campo_9 character varying, refreshed_or_updated character varying, campo_11 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as eof,
        substr(sfl_file.linea, 19, 18)::VARCHAR(100) as campo_2,
        substr(sfl_file.linea, 37, 10)::VARCHAR(100) as campo_3,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 34)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 106, 10)::VARCHAR(100) as number_detail_of_records,
        substr(sfl_file.linea, 116, 3)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 119, 9)::VARCHAR(100) as refreshed_or_updated,
        substr(sfl_file.linea, 128, 622)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gcus_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 3)		= 'GCB'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_gcus_reg_header(_id_proceso bigint) returns SETOF stage_pershing.stage_gcus_reg_header
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        bof::VARCHAR(100),
        campo_2::VARCHAR(100),
        campo_3::VARCHAR(100),
        date_of_data::VARCHAR(100),
        campo_5::VARCHAR(100),
        remote_id::VARCHAR(100),
        campo_7::VARCHAR(100),
        run_date::VARCHAR(100),
        campo_9::VARCHAR(100),
        run_time::VARCHAR(100),
        campo_11::VARCHAR(100),
        refreshed_or_updated::VARCHAR(100),
        campo_13::VARCHAR(100),
        eof::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gcus_reg_header(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_gcus_reg_a(_id_proceso bigint) returns SETOF stage_pershing.stage_gcus_reg_a
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        transaction_code::VARCHAR(100),
        record_indicator_value::VARCHAR(100),
        record_id_sequence_number::int,
        account_number::VARCHAR(100),
        cusip_number::VARCHAR(100),
        portfolio_currency::VARCHAR(100),
        campo_7::VARCHAR(100),
        underlying_cusip_number::VARCHAR(100),
        country_code::VARCHAR(100),
        campo_10::VARCHAR(100),
        ip_record_number::VARCHAR(100),
        ibd_number::VARCHAR(100),
        currency_security_indicator::VARCHAR(100),
        issue_currency::VARCHAR(100),
        public.fn_fecha_string_to_date(datestamp_trade_date, 'CCYYMMDD') as datestamp_trade_date,
        public.fn_fecha_string_to_date(datestamp_settlement_date, 'CCYYMMDD') as datestamp_settlement_date,
        public.fn_convierte_texto_numerico_cobol(trade_date_quantity, 5)::NUMERIC(45,20) as trade_date_quantity,
        trade_date_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_quantity, 5)::NUMERIC(45,20) as settlement_date_quantity,
        settlement_date_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(seg_quantity, 5)::NUMERIC(45,20) as seg_quantity,
        seg_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(safekeeping_quantity, 5)::NUMERIC(45,20) as safekeeping_quantity,
        safekeeping_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(transfer_quantity, 5)::NUMERIC(45,20) as transfer_quantity,
        transfer_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(pending_transfer_quantity, 5)::NUMERIC(45,20) as pending_transfer_quantity,
        pending_transfer_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(legal_transfer_quantity, 5)::NUMERIC(45,20) as legal_transfer_quantity,
        legal_transfer_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(tendered_quantity, 5)::NUMERIC(45,20) as tendered_quantity,
        tendered_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(pending_papers, 5)::NUMERIC(45,20) as pending_papers,
        pending_papers_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(short_against_the_box_quantity, 5)::NUMERIC(45,20) as short_against_the_box_quantity,
        short_against_the_box_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(networked_quantity, 5)::NUMERIC(45,20) as networked_quantity,
        networked_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(pending_split_quantity, 5)::NUMERIC(45,20) as pending_split_quantity,
        pending_split_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(quantity_covering_options, 5)::NUMERIC(45,20) as quantity_covering_options,
        quantity_covering_options_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_quantity_bought, 5)::NUMERIC(45,20) as trade_date_quantity_bought,
        trade_date_quantity_bought_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_quantity_sold, 5)::NUMERIC(45,20) as trade_date_quantity_sold,
        trade_date_quantity_sold_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(fed_rquirement, 2)::NUMERIC(45,20) as fed_rquirement,
        fed_rquirement_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(house_margin_requirement, 2)::NUMERIC(45,20) as house_margin_requirement,
        house_margin_requirement_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(nyse_requirement, 2)::NUMERIC(45,20) as nyse_requirement,
        nyse_requirement_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(equity_requirment, 2)::NUMERIC(45,20) as equity_requirment,
        equity_requirment_sign::VARCHAR(100),
        security_symbol::VARCHAR(100),
        security_type::VARCHAR(100),
        security_mod::VARCHAR(100),
        security_calc::VARCHAR(100),
        minor_product_code::VARCHAR(100),
        network_eligibility_indicator::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(strike_price, 9)::NUMERIC(45,20) as strike_price,
        strike_price_sign::VARCHAR(100),
        public.fn_fecha_string_to_date(expiration_maturity_date, 'CCYYMMDD') as expiration_maturity_date,
        public.fn_convierte_texto_numerico_cobol(contract_size, 5)::NUMERIC(45,20) as contract_size,
        public.fn_convierte_texto_numerico_cobol(conversion_ratio, 9)::NUMERIC(45,20) as conversion_ratio,
        account_short_name::VARCHAR(100),
        state_code::VARCHAR(100),
        country_code_account::VARCHAR(100),
        campo_69::VARCHAR(100),
        number_security_description_lines::int,
        security_description_line_1::VARCHAR(100),
        security_description_line_2::VARCHAR(100),
        security_description_line_3::VARCHAR(100),
        security_description_line_4::VARCHAR(100),
        security_description_line_5::VARCHAR(100),
        security_description_line_6::VARCHAR(100),
        dividend_option::VARCHAR(100),
        long_term_capital_gains_option::VARCHAR(100),
        short_term_capital_gains_option::VARCHAR(100),
        firm_trading_indicator::VARCHAR(100),
        position_currency_security::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_liquidating_value, 3)::NUMERIC(45,20) as trade_date_liquidating_value,
        trade_date_liquidating_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(pool_factor, 8)::NUMERIC(45,20) as pool_factor,
        pool_factor_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(exchange_rate, 10)::NUMERIC(45,20) as exchange_rate,
        exchange_rate_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_liquidating_value, 3)::NUMERIC(45,20) as settlement_date_liquidating_value,
        settlement_date_liquidating_value_sign::VARCHAR(100),
        campo_90::VARCHAR(100),
        alternate_security_id_type::VARCHAR(100),
        alternate_security_id::VARCHAR(100),
        campo_93::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gcus_reg_a(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_gcus_reg_b(_id_proceso bigint) returns SETOF stage_pershing.stage_gcus_reg_b
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        transaction_code::VARCHAR(100),
        record_indicator_value::VARCHAR(100),
        recor_id_sequence_number::int,
        account_number::VARCHAR(100),
        cusip_number::VARCHAR(100),
        position_currency::VARCHAR(100),
        campo_7::VARCHAR(100),
        underlying_cusip_number::VARCHAR(100),
        country_code::VARCHAR(100),
        campo_10::VARCHAR(100),
        ip_record_number::VARCHAR(100),
        ibd_number::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(fully_paid_lending_quantity, 5)::NUMERIC(45,20) as fully_paid_lending_quantity,
        fully_paid_lending_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(fully_paid_lending_quantity_collateral_amount, 3)::NUMERIC(45,20) as fully_paid_lending_quantity_collateral_amount,
        fully_paid_lending_quantity_collateral_amount_sign::VARCHAR(100),
        option_root_id::VARCHAR(100),
        public.fn_fecha_string_to_date(expiration_date, 'YYMMDD') as expiration_date,
        call_put_indicator::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(strike_price, 3)::NUMERIC(45,20) as strike_price,
        public.fn_convierte_texto_numerico_cobol(trade_date_repo_quantity, 5)::NUMERIC(45,20) as trade_date_repo_quantity,
        trade_date_repo_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_repo_quantity, 5)::NUMERIC(45,20) as settlement_date_repo_quantity,
        settlement_date_repo_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_reverse_repo_quantity, 5)::NUMERIC(45,20) as trade_date_reverse_repo_quantity,
        trade_date_reverse_repo_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_reverse_repo_quantity, 5)::NUMERIC(45,20) as settlement_date_reverse_repo_quantity,
        settlement_date_reverse_repo_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(collateral_pledge_quantity, 5)::NUMERIC(45,20) as collateral_pledge_quantity,
        collateral_pledge_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(corporate_exec_serv_collateral_pledge_quantity, 5)::NUMERIC(45,20) as corporate_exec_serv_collateral_pledge_quantity,
        corporate_exec_serv_collateral_pledge_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_repo_liquidating_value, 3)::NUMERIC(45,20) as trade_date_repo_liquidating_value,
        trade_date_repo_liquidating_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_repo_liquidating_value, 3)::NUMERIC(45,20) as settlement_date_repo_liquidating_value,
        settlement_date_repo_liquidating_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_reverse_repo_liquidating_value, 3)::NUMERIC(45,20) as trade_date_reverse_repo_liquidating_value,
        trade_date_reverse_repo_liquidating_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_reverse_repo_liquidating_value, 3)::NUMERIC(45,20) as settlement_date_reverse_repo_liquidating_value,
        settlement_date_reverse_repo_liquidating_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(collateral_pledge_liquidating_value, 3)::NUMERIC(45,20) as collateral_pledge_liquidating_value,
        collateral_pledge_liquidating_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(corporate_exec_serv_collateral_pledge_liquidating_value, 3)::NUMERIC(45,20) as corporate_exec_serv_collateral_pledge_liquidating_value,
        corporate_exec_serv_collateral_pledge_liquidating_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_repo_loan_amount, 3)::NUMERIC(45,20) as trade_date_repo_loan_amount,
        trade_date_repo_loan_amount_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_repo_loan_amount, 3)::NUMERIC(45,20) as settlement_date_repo_loan_amount,
        settlement_date_repo_loan_amount_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_reverse_repo_loan_amount, 3)::NUMERIC(45,20) as trade_date_reverse_repo_loan_amount,
        trade_date_reverse_repo_loan_amount_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_reverse_repo_loan_amount, 3)::NUMERIC(45,20) as settlement_date_reverse_repo_loan_amount,
        settlement_date_reverse_repo_loan_amount_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(accrued_interes_value, 3)::NUMERIC(45,20) as accrued_interes_value,
        accrued_interes_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(dividend_or_coupon_rate, 9)::NUMERIC(45,20) as dividend_or_coupon_rate,
        public.fn_convierte_texto_numerico_cobol(pending_split_quantity_liquidating_value, 3)::NUMERIC(45,20) as pending_split_quantity_liquidating_value,
        pending_split_quantity_liquidating_value_sign::VARCHAR(100),
        campo_58::VARCHAR(100),
        internal_non_dollar_symbol::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(pledged_quantity, 5)::NUMERIC(45,20) as pledged_quantity,
        pledged_quantity_sign::VARCHAR(100),
        campo_62::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gcus_reg_b(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_gcus_reg_trailer(_id_proceso bigint) returns SETOF stage_pershing.stage_gcus_reg_trailer
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        eof::VARCHAR(100),
        campo_2::VARCHAR(100),
        campo_3::VARCHAR(100),
        date_of_data::VARCHAR(100),
        campo_5::VARCHAR(100),
        remote_id::VARCHAR(100),
        campo_7::VARCHAR(100),
        number_detail_of_records::int,
        campo_9::VARCHAR(100),
        refreshed_or_updated::VARCHAR(100),
        campo_11::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gcus_reg_trailer(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create procedure stage_pershing.pa_parse_gcus(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
begin

    DELETE FROM stage_pershing.stage_gcus_reg_header reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_gcus_reg_a reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_gcus_reg_b reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_gcus_reg_trailer reg_del WHERE reg_del.id_proceso=_id_proceso;

    INSERT INTO stage_pershing.stage_gcus_reg_header (id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, refreshed_or_updated, campo_13, eof)
    SELECT id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, refreshed_or_updated, campo_13, eof
    FROM stage_pershing.fn_parse_gcus_reg_header(_id_proceso);

    INSERT INTO stage_pershing.stage_gcus_reg_a (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, cusip_number, portfolio_currency, campo_7, underlying_cusip_number, country_code, campo_10, ip_record_number, ibd_number, currency_security_indicator, issue_currency, datestamp_trade_date, datestamp_settlement_date, trade_date_quantity, trade_date_quantity_sign, settlement_date_quantity, settlement_date_quantity_sign, seg_quantity, seg_quantity_sign, safekeeping_quantity, safekeeping_sign, transfer_quantity, transfer_quantity_sign, pending_transfer_quantity, pending_transfer_quantity_sign, legal_transfer_quantity, legal_transfer_quantity_sign, tendered_quantity, tendered_quantity_sign, pending_papers, pending_papers_sign, short_against_the_box_quantity, short_against_the_box_quantity_sign, networked_quantity, networked_quantity_sign, pending_split_quantity, pending_split_quantity_sign, quantity_covering_options, quantity_covering_options_sign, trade_date_quantity_bought, trade_date_quantity_bought_sign, trade_date_quantity_sold, trade_date_quantity_sold_sign, fed_rquirement, fed_rquirement_sign, house_margin_requirement, house_margin_requirement_sign, nyse_requirement, nyse_requirement_sign, equity_requirment, equity_requirment_sign, security_symbol, security_type, security_mod, security_calc, minor_product_code, network_eligibility_indicator, strike_price, strike_price_sign, expiration_maturity_date, contract_size, conversion_ratio, account_short_name, state_code, country_code_account, campo_69, number_security_description_lines, security_description_line_1, security_description_line_2, security_description_line_3, security_description_line_4, security_description_line_5, security_description_line_6, dividend_option, long_term_capital_gains_option, short_term_capital_gains_option, firm_trading_indicator, position_currency_security, trade_date_liquidating_value, trade_date_liquidating_value_sign, pool_factor, pool_factor_sign, exchange_rate, exchange_rate_sign, settlement_date_liquidating_value, settlement_date_liquidating_value_sign, campo_90, alternate_security_id_type, alternate_security_id, campo_93, eor)
    SELECT id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, cusip_number, portfolio_currency, campo_7, underlying_cusip_number, country_code, campo_10, ip_record_number, ibd_number, currency_security_indicator, issue_currency, datestamp_trade_date, datestamp_settlement_date, trade_date_quantity, trade_date_quantity_sign, settlement_date_quantity, settlement_date_quantity_sign, seg_quantity, seg_quantity_sign, safekeeping_quantity, safekeeping_sign, transfer_quantity, transfer_quantity_sign, pending_transfer_quantity, pending_transfer_quantity_sign, legal_transfer_quantity, legal_transfer_quantity_sign, tendered_quantity, tendered_quantity_sign, pending_papers, pending_papers_sign, short_against_the_box_quantity, short_against_the_box_quantity_sign, networked_quantity, networked_quantity_sign, pending_split_quantity, pending_split_quantity_sign, quantity_covering_options, quantity_covering_options_sign, trade_date_quantity_bought, trade_date_quantity_bought_sign, trade_date_quantity_sold, trade_date_quantity_sold_sign, fed_rquirement, fed_rquirement_sign, house_margin_requirement, house_margin_requirement_sign, nyse_requirement, nyse_requirement_sign, equity_requirment, equity_requirment_sign, security_symbol, security_type, security_mod, security_calc, minor_product_code, network_eligibility_indicator, strike_price, strike_price_sign, expiration_maturity_date, contract_size, conversion_ratio, account_short_name, state_code, country_code_account, campo_69, number_security_description_lines, security_description_line_1, security_description_line_2, security_description_line_3, security_description_line_4, security_description_line_5, security_description_line_6, dividend_option, long_term_capital_gains_option, short_term_capital_gains_option, firm_trading_indicator, position_currency_security, trade_date_liquidating_value, trade_date_liquidating_value_sign, pool_factor, pool_factor_sign, exchange_rate, exchange_rate_sign, settlement_date_liquidating_value, settlement_date_liquidating_value_sign, campo_90, alternate_security_id_type, alternate_security_id, campo_93, eor
    FROM stage_pershing.fn_parse_gcus_reg_a(_id_proceso);

    INSERT INTO stage_pershing.stage_gcus_reg_b (id_proceso, process_date, transaction_code, record_indicator_value, recor_id_sequence_number, account_number, cusip_number, position_currency, campo_7, underlying_cusip_number, country_code, campo_10, ip_record_number, ibd_number, fully_paid_lending_quantity, fully_paid_lending_quantity_sign, fully_paid_lending_quantity_collateral_amount, fully_paid_lending_quantity_collateral_amount_sign, option_root_id, expiration_date, call_put_indicator, strike_price, trade_date_repo_quantity, trade_date_repo_quantity_sign, settlement_date_repo_quantity, settlement_date_repo_quantity_sign, trade_date_reverse_repo_quantity, trade_date_reverse_repo_quantity_sign, settlement_date_reverse_repo_quantity, settlement_date_reverse_repo_quantity_sign, collateral_pledge_quantity, collateral_pledge_quantity_sign, corporate_exec_serv_collateral_pledge_quantity, corporate_exec_serv_collateral_pledge_quantity_sign, trade_date_repo_liquidating_value, trade_date_repo_liquidating_value_sign, settlement_date_repo_liquidating_value, settlement_date_repo_liquidating_value_sign, trade_date_reverse_repo_liquidating_value, trade_date_reverse_repo_liquidating_value_sign, settlement_date_reverse_repo_liquidating_value, settlement_date_reverse_repo_liquidating_value_sign, collateral_pledge_liquidating_value, collateral_pledge_liquidating_value_sign, corporate_exec_serv_collateral_pledge_liquidating_value, corporate_exec_serv_collateral_pledge_liquidating_value_sign, trade_date_repo_loan_amount, trade_date_repo_loan_amount_sign, settlement_date_repo_loan_amount, settlement_date_repo_loan_amount_sign, trade_date_reverse_repo_loan_amount, trade_date_reverse_repo_loan_amount_sign, settlement_date_reverse_repo_loan_amount, settlement_date_reverse_repo_loan_amount_sign, accrued_interes_value, accrued_interes_value_sign, dividend_or_coupon_rate, pending_split_quantity_liquidating_value, pending_split_quantity_liquidating_value_sign, campo_58, internal_non_dollar_symbol, pledged_quantity, pledged_quantity_sign, campo_62, eor)
    SELECT id_proceso, process_date, transaction_code, record_indicator_value, recor_id_sequence_number, account_number, cusip_number, position_currency, campo_7, underlying_cusip_number, country_code, campo_10, ip_record_number, ibd_number, fully_paid_lending_quantity, fully_paid_lending_quantity_sign, fully_paid_lending_quantity_collateral_amount, fully_paid_lending_quantity_collateral_amount_sign, option_root_id, expiration_date, call_put_indicator, strike_price, trade_date_repo_quantity, trade_date_repo_quantity_sign, settlement_date_repo_quantity, settlement_date_repo_quantity_sign, trade_date_reverse_repo_quantity, trade_date_reverse_repo_quantity_sign, settlement_date_reverse_repo_quantity, settlement_date_reverse_repo_quantity_sign, collateral_pledge_quantity, collateral_pledge_quantity_sign, corporate_exec_serv_collateral_pledge_quantity, corporate_exec_serv_collateral_pledge_quantity_sign, trade_date_repo_liquidating_value, trade_date_repo_liquidating_value_sign, settlement_date_repo_liquidating_value, settlement_date_repo_liquidating_value_sign, trade_date_reverse_repo_liquidating_value, trade_date_reverse_repo_liquidating_value_sign, settlement_date_reverse_repo_liquidating_value, settlement_date_reverse_repo_liquidating_value_sign, collateral_pledge_liquidating_value, collateral_pledge_liquidating_value_sign, corporate_exec_serv_collateral_pledge_liquidating_value, corporate_exec_serv_collateral_pledge_liquidating_value_sign, trade_date_repo_loan_amount, trade_date_repo_loan_amount_sign, settlement_date_repo_loan_amount, settlement_date_repo_loan_amount_sign, trade_date_reverse_repo_loan_amount, trade_date_reverse_repo_loan_amount_sign, settlement_date_reverse_repo_loan_amount, settlement_date_reverse_repo_loan_amount_sign, accrued_interes_value, accrued_interes_value_sign, dividend_or_coupon_rate, pending_split_quantity_liquidating_value, pending_split_quantity_liquidating_value_sign, campo_58, internal_non_dollar_symbol, pledged_quantity, pledged_quantity_sign, campo_62, eor
    FROM stage_pershing.fn_parse_gcus_reg_b(_id_proceso);

    INSERT INTO stage_pershing.stage_gcus_reg_trailer (id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, number_detail_of_records, campo_9, refreshed_or_updated, campo_11, eor)
    SELECT id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, number_detail_of_records, campo_9, refreshed_or_updated, campo_11, eor
    FROM stage_pershing.fn_parse_gcus_reg_trailer(_id_proceso);

end;
$$;

create function stage_pershing.fn_extrae_gmon_reg_header(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, bof character varying, campo_2 character varying, campo_3 character varying, date_of_data character varying, campo_5 character varying, remote_id character varying, campo_7 character varying, run_date character varying, campo_9 character varying, run_time character varying, campo_11 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as bof,
        substr(sfl_file.linea, 19, 19)::VARCHAR(100) as campo_2,
        substr(sfl_file.linea, 38, 9)::VARCHAR(100) as campo_3,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 14)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 86, 10)::VARCHAR(100) as run_date,
        substr(sfl_file.linea, 96, 1)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 97, 8)::VARCHAR(100) as run_time,
        substr(sfl_file.linea, 105, 145)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 250, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gmon_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 3)		= 'GCB'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_gmon_reg_a(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, campo_5 character varying, ip_number character varying, ibd_number character varying, usde_td_balance character varying, usde_td_balance_sign character varying, usd_td_balance character varying, usd_td_balance_sign character varying, long_td_market character varying, long_td_market_sign character varying, short_td_market character varying, short_td_market_sign character varying, td_liquidating_equity character varying, td_liquidating_equity_sign character varying, total_usde_td_balance character varying, total_usde_td_balance_sign character varying, total_equity character varying, total_equity_sign character varying, trade_date_net_worth character varying, trade_date_net_worth_sign character varying, mmf_principal_balance character varying, mmf_principal_balance_sign character varying, mmf_dividend character varying, mmf_dividend_sign character varying, cash_available character varying, cash_available_sign character varying, campo_30 character varying, date_of_data character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 9)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 21, 1)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 22, 4)::VARCHAR(100) as ip_number,
        substr(sfl_file.linea, 26, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 29, 18)::VARCHAR(100) as usde_td_balance,
        substr(sfl_file.linea, 47, 1)::VARCHAR(100) as usde_td_balance_sign,
        substr(sfl_file.linea, 48, 18)::VARCHAR(100) as usd_td_balance,
        substr(sfl_file.linea, 66, 1)::VARCHAR(100) as usd_td_balance_sign,
        substr(sfl_file.linea, 67, 18)::VARCHAR(100) as long_td_market,
        substr(sfl_file.linea, 85, 1)::VARCHAR(100) as long_td_market_sign,
        substr(sfl_file.linea, 86, 18)::VARCHAR(100) as short_td_market,
        substr(sfl_file.linea, 104, 1)::VARCHAR(100) as short_td_market_sign,
        substr(sfl_file.linea, 105, 18)::VARCHAR(100) as td_liquidating_equity,
        substr(sfl_file.linea, 123, 1)::VARCHAR(100) as td_liquidating_equity_sign,
        substr(sfl_file.linea, 124, 18)::VARCHAR(100) as total_usde_td_balance,
        substr(sfl_file.linea, 142, 1)::VARCHAR(100) as total_usde_td_balance_sign,
        substr(sfl_file.linea, 143, 18)::VARCHAR(100) as total_equity,
        substr(sfl_file.linea, 161, 1)::VARCHAR(100) as total_equity_sign,
        substr(sfl_file.linea, 162, 18)::VARCHAR(100) as trade_date_net_worth,
        substr(sfl_file.linea, 180, 1)::VARCHAR(100) as trade_date_net_worth_sign,
        substr(sfl_file.linea, 181, 18)::VARCHAR(100) as mmf_principal_balance,
        substr(sfl_file.linea, 199, 1)::VARCHAR(100) as mmf_principal_balance_sign,
        substr(sfl_file.linea, 200, 18)::VARCHAR(100) as mmf_dividend,
        substr(sfl_file.linea, 218, 1)::VARCHAR(100) as mmf_dividend_sign,
        substr(sfl_file.linea, 219, 18)::VARCHAR(100) as cash_available,
        substr(sfl_file.linea, 237, 1)::VARCHAR(100) as cash_available_sign,
        substr(sfl_file.linea, 238, 4)::VARCHAR(100) as campo_30,
        substr(sfl_file.linea, 242, 8)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 250, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gmon_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 3)		= 'GMA'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_gmon_reg_b(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, campo_5 character varying, ip_number character varying, ibd_number character varying, usde_sd_balance character varying, usde_sd_balance_sign character varying, usd_sd_balance character varying, usd_sd_balance_sign character varying, long_sd_market character varying, long_sd_market_sign character varying, short_sd_market character varying, short_sd_market_sign character varying, sma_date_stamp character varying, sma_balance character varying, sma_balance_sign character varying, margin_buying_power character varying, margin_buying_power_sign character varying, technical_short_value character varying, technical_short_value_sign character varying, total_fed_requirement character varying, total_fed_requirement_sign character varying, total_options_requirement character varying, total_options_requirement_sign character varying, base_currency character varying, non_usd_currency character varying, masked_house_call character varying, masked_house_call_sign character varying, campo_31 character varying, date_of_data character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 9)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 21, 1)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 22, 4)::VARCHAR(100) as ip_number,
        substr(sfl_file.linea, 26, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 29, 18)::VARCHAR(100) as usde_sd_balance,
        substr(sfl_file.linea, 47, 1)::VARCHAR(100) as usde_sd_balance_sign,
        substr(sfl_file.linea, 48, 18)::VARCHAR(100) as usd_sd_balance,
        substr(sfl_file.linea, 66, 1)::VARCHAR(100) as usd_sd_balance_sign,
        substr(sfl_file.linea, 67, 18)::VARCHAR(100) as long_sd_market,
        substr(sfl_file.linea, 85, 1)::VARCHAR(100) as long_sd_market_sign,
        substr(sfl_file.linea, 86, 18)::VARCHAR(100) as short_sd_market,
        substr(sfl_file.linea, 104, 1)::VARCHAR(100) as short_sd_market_sign,
        substr(sfl_file.linea, 105, 8)::VARCHAR(100) as sma_date_stamp,
        substr(sfl_file.linea, 113, 18)::VARCHAR(100) as sma_balance,
        substr(sfl_file.linea, 131, 1)::VARCHAR(100) as sma_balance_sign,
        substr(sfl_file.linea, 132, 18)::VARCHAR(100) as margin_buying_power,
        substr(sfl_file.linea, 150, 1)::VARCHAR(100) as margin_buying_power_sign,
        substr(sfl_file.linea, 151, 18)::VARCHAR(100) as technical_short_value,
        substr(sfl_file.linea, 169, 1)::VARCHAR(100) as technical_short_value_sign,
        substr(sfl_file.linea, 170, 18)::VARCHAR(100) as total_fed_requirement,
        substr(sfl_file.linea, 188, 1)::VARCHAR(100) as total_fed_requirement_sign,
        substr(sfl_file.linea, 189, 18)::VARCHAR(100) as total_options_requirement,
        substr(sfl_file.linea, 207, 1)::VARCHAR(100) as total_options_requirement_sign,
        substr(sfl_file.linea, 208, 3)::VARCHAR(100) as base_currency,
        substr(sfl_file.linea, 211, 1)::VARCHAR(100) as non_usd_currency,
        substr(sfl_file.linea, 212, 18)::VARCHAR(100) as masked_house_call,
        substr(sfl_file.linea, 230, 1)::VARCHAR(100) as masked_house_call_sign,
        substr(sfl_file.linea, 231, 11)::VARCHAR(100) as campo_31,
        substr(sfl_file.linea, 242, 8)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 250, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gmon_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 3)		= 'GMB'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_gmon_reg_trailer(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, eof character varying, campo_2 character varying, campo_3 character varying, date_of_data character varying, campo_5 character varying, remote_id character varying, campo_7 character varying, campo_8 character varying, number_detail_of_records character varying, campo_10 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as eof,
        substr(sfl_file.linea, 19, 19)::VARCHAR(100) as campo_2,
        substr(sfl_file.linea, 38, 9)::VARCHAR(100) as campo_3,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 12)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 84, 22)::VARCHAR(100) as campo_8,
        substr(sfl_file.linea, 106, 10)::VARCHAR(100) as number_detail_of_records,
        substr(sfl_file.linea, 116, 134)::VARCHAR(100) as campo_10,
        substr(sfl_file.linea, 250, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gmon_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 3)		= 'GMB'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_gmon_reg_header(_id_proceso bigint) returns SETOF stage_pershing.stage_gmon_reg_header
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        bof::VARCHAR(100),
        campo_2::VARCHAR(100),
        campo_3::VARCHAR(100),
        date_of_data::VARCHAR(100),
        campo_5::VARCHAR(100),
        remote_id::VARCHAR(100),
        campo_7::VARCHAR(100),
        run_date::VARCHAR(100),
        campo_9::VARCHAR(100),
        run_time::VARCHAR(100),
        campo_11::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gmon_reg_header(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_gmon_reg_a(_id_proceso bigint) returns SETOF stage_pershing.stage_gmon_reg_a
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        transaction_code::VARCHAR(100),
        record_indicator_value::VARCHAR(100),
        record_id_sequence_number::int,
        account_number::VARCHAR(100),
        campo_5::VARCHAR(100),
        ip_number::VARCHAR(100),
        ibd_number::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(usde_td_balance, 2)::NUMERIC(45,20) as usde_td_balance,
        usde_td_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(usd_td_balance, 2)::NUMERIC(45,20) as usd_td_balance,
        usd_td_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(long_td_market, 2)::NUMERIC(45,20) as long_td_market,
        long_td_market_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(short_td_market, 2)::NUMERIC(45,20) as short_td_market,
        short_td_market_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(td_liquidating_equity, 2)::NUMERIC(45,20) as td_liquidating_equity,
        td_liquidating_equity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(total_usde_td_balance, 2)::NUMERIC(45,20) as total_usde_td_balance,
        total_usde_td_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(total_equity, 2)::NUMERIC(45,20) as total_equity,
        total_equity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_net_worth, 2)::NUMERIC(45,20) as trade_date_net_worth,
        trade_date_net_worth_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(mmf_principal_balance, 2)::NUMERIC(45,20) as mmf_principal_balance,
        mmf_principal_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(mmf_dividend, 2)::NUMERIC(45,20) as mmf_dividend,
        mmf_dividend_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(cash_available, 2)::NUMERIC(45,20) as cash_available,
        cash_available_sign::VARCHAR(100),
        campo_30::VARCHAR(100),
        public.fn_fecha_string_to_date(date_of_data, 'CCYYMMDD') as date_of_data,
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gmon_reg_a(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_gmon_reg_b(_id_proceso bigint) returns SETOF stage_pershing.stage_gmon_reg_b
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        transaction_code::VARCHAR(100),
        record_indicator_value::VARCHAR(100),
        record_id_sequence_number::int,
        account_number::VARCHAR(100),
        campo_5::VARCHAR(100),
        ip_number::VARCHAR(100),
        ibd_number::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(usde_sd_balance, 2)::NUMERIC(45,20) as usde_sd_balance,
        usde_sd_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(usd_sd_balance, 2)::NUMERIC(45,20) as usd_sd_balance,
        usd_sd_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(long_sd_market, 2)::NUMERIC(45,20) as long_sd_market,
        long_sd_market_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(short_sd_market, 2)::NUMERIC(45,20) as short_sd_market,
        short_sd_market_sign::VARCHAR(100),
        public.fn_fecha_string_to_date(sma_date_stamp, 'CCYYMMDD') as sma_date_stamp,
        public.fn_convierte_texto_numerico_cobol(sma_balance, 2)::NUMERIC(45,20) as sma_balance,
        sma_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(margin_buying_power, 2)::NUMERIC(45,20) as margin_buying_power,
        margin_buying_power_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(technical_short_value, 2)::NUMERIC(45,20) as technical_short_value,
        technical_short_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(total_fed_requirement, 2)::NUMERIC(45,20) as total_fed_requirement,
        total_fed_requirement_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(total_options_requirement, 2)::NUMERIC(45,20) as total_options_requirement,
        total_options_requirement_sign::VARCHAR(100),
        base_currency::VARCHAR(100),
        non_usd_currency::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(masked_house_call, 2)::NUMERIC(45,20) as masked_house_call,
        masked_house_call_sign::VARCHAR(100),
        campo_31::VARCHAR(100),
        public.fn_fecha_string_to_date(date_of_data, 'CCYYMMDD') as date_of_data,
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gmon_reg_b(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_gmon_reg_trailer(_id_proceso bigint) returns SETOF stage_pershing.stage_gmon_reg_trailer
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        eof::VARCHAR(100),
        campo_2::VARCHAR(100),
        campo_3::VARCHAR(100),
        date_of_data::VARCHAR(100),
        campo_5::VARCHAR(100),
        remote_id::VARCHAR(100),
        campo_7::VARCHAR(100),
        campo_8::VARCHAR(100),
        number_detail_of_records::int,
        campo_10::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gmon_reg_trailer(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

create procedure stage_pershing.pa_parse_gmon(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
begin

    DELETE FROM stage_pershing.stage_gmon_reg_header reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_gmon_reg_a reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_gmon_reg_b reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_gmon_reg_trailer reg_del WHERE reg_del.id_proceso=_id_proceso;

    INSERT INTO stage_pershing.stage_gmon_reg_header (id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, eor)
    SELECT id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, eor
    FROM stage_pershing.fn_parse_gmon_reg_header(_id_proceso);

    INSERT INTO stage_pershing.stage_gmon_reg_a (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, campo_5, ip_number, ibd_number, usde_td_balance, usde_td_balance_sign, usd_td_balance, usd_td_balance_sign, long_td_market, long_td_market_sign, short_td_market, short_td_market_sign, td_liquidating_equity, td_liquidating_equity_sign, total_usde_td_balance, total_usde_td_balance_sign, total_equity, total_equity_sign, trade_date_net_worth, trade_date_net_worth_sign, mmf_principal_balance, mmf_principal_balance_sign, mmf_dividend, mmf_dividend_sign, cash_available, cash_available_sign, campo_30, date_of_data, eor)
    SELECT id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, campo_5, ip_number, ibd_number, usde_td_balance, usde_td_balance_sign, usd_td_balance, usd_td_balance_sign, long_td_market, long_td_market_sign, short_td_market, short_td_market_sign, td_liquidating_equity, td_liquidating_equity_sign, total_usde_td_balance, total_usde_td_balance_sign, total_equity, total_equity_sign, trade_date_net_worth, trade_date_net_worth_sign, mmf_principal_balance, mmf_principal_balance_sign, mmf_dividend, mmf_dividend_sign, cash_available, cash_available_sign, campo_30, date_of_data, eor
    FROM stage_pershing.fn_parse_gmon_reg_a(_id_proceso);

    INSERT INTO stage_pershing.stage_gmon_reg_b (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, campo_5, ip_number, ibd_number, usde_sd_balance, usde_sd_balance_sign, usd_sd_balance, usd_sd_balance_sign, long_sd_market, long_sd_market_sign, short_sd_market, short_sd_market_sign, sma_date_stamp, sma_balance, sma_balance_sign, margin_buying_power, margin_buying_power_sign, technical_short_value, technical_short_value_sign, total_fed_requirement, total_fed_requirement_sign, total_options_requirement, total_options_requirement_sign, base_currency, non_usd_currency, masked_house_call, masked_house_call_sign, campo_31, date_of_data, eor)
    SELECT id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, campo_5, ip_number, ibd_number, usde_sd_balance, usde_sd_balance_sign, usd_sd_balance, usd_sd_balance_sign, long_sd_market, long_sd_market_sign, short_sd_market, short_sd_market_sign, sma_date_stamp, sma_balance, sma_balance_sign, margin_buying_power, margin_buying_power_sign, technical_short_value, technical_short_value_sign, total_fed_requirement, total_fed_requirement_sign, total_options_requirement, total_options_requirement_sign, base_currency, non_usd_currency, masked_house_call, masked_house_call_sign, campo_31, date_of_data, eor
    FROM stage_pershing.fn_parse_gmon_reg_b(_id_proceso);

    INSERT INTO stage_pershing.stage_gmon_reg_trailer (id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, campo_8, number_detail_of_records, campo_10, eor)
    SELECT id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, campo_8, number_detail_of_records, campo_10, eor
    FROM stage_pershing.fn_parse_gmon_reg_trailer(_id_proceso);

end;
$$;

create function stage_pershing.fn_extrae_acct_reg_header(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, bof character varying, campo_2 character varying, campo_3 character varying, date_of_data character varying, campo_5 character varying, remote_id character varying, campo_7 character varying, run_date character varying, campo_9 character varying, run_time character varying, campo_11 character varying, refreshed_or_updated character varying, campo_13 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as bof,
        substr(sfl_file.linea, 19, 18)::VARCHAR(100) as campo_2,
        substr(sfl_file.linea, 37, 10)::VARCHAR(100) as campo_3,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 14)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 86, 10)::VARCHAR(100) as run_date,
        substr(sfl_file.linea, 96, 1)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 97, 8)::VARCHAR(100) as run_time,
        substr(sfl_file.linea, 105, 14)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 119, 9)::VARCHAR(100) as refreshed_or_updated,
        substr(sfl_file.linea, 128, 622)::VARCHAR(100) as campo_13,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CIA'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_acct_reg_a(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, ibd_number character varying, campo_6 character varying, ip_number character varying, account_short_name character varying, campo_9 character varying, transaction_type character varying, autotitled_usertitled_account character varying, account_type_code character varying, registration_type character varying, campo_14 character varying, number_of_account_title_lines character varying, account_registration_line_1 character varying, account_registration_line_2 character varying, account_registration_line_3 character varying, account_registration_line_4 character varying, account_registration_line_5 character varying, account_registration_line_6 character varying, registration_type_detail character varying, date_account_opened character varying, date_account_information_updated character varying, account_status_indicator character varying, pending_closed_date character varying, date_account_closed character varying, closing_notice_date character varying, account_reactivated_date character varying, date_account_reopened character varying, proceeds character varying, transfer_instructions character varying, income_isntructions character varying, number_of_confirms_for_thi_account character varying, number_of_statements_for_this_account character varying, investment_objetive_trans_code character varying, comments_act character varying, employer_shotname character varying, employers_cusip character varying, employers_symbol character varying, margin_privileges_revoked character varying, statement_review_date character varying, margin_papers_on_file character varying, option_papers_on_file character varying, campo_45 character varying, good_faith_margin character varying, ip_discretion_granted character varying, invest_advisor_discretion_granted character varying, third_party_discretion_granted character varying, third_party_name character varying, risk_factor_code character varying, investment_objetive_code character varying, option_equities character varying, option_index character varying, option_debt character varying, option_currency character varying, option_level_1 character varying, option_level_2 character varying, option_level_3 character varying, option_level_4 character varying, option_call_limits character varying, option_put_limits character varying, option_total_limits_of_puts_and_calls character varying, non_us_dollar_trading character varying, campo_65 character varying, non_customer_indicator character varying, third_party_fee_indicator character varying, third_party_fee_approval_date character varying, intermediary_account_ind character varying, commission_schedule character varying, group_index character varying, money_manager_id character varying, money_manager_objective_id character varying, dtc_id_confirm_number character varying, caps_master_mnemonic character varying, employee_id character varying, prime_broker_free_fund_indicator character varying, fee_based_account_indicator character varying, campo_79 character varying, fee_based_termination_date character varying, campo_81 character varying, plan_name character varying, self_directed_401_k_account_type character varying, plan_type character varying, plan_number character varying, employee_or_employee_relative character varying, commission_percent_discount character varying, ind_12_b_1_fee_blocking character varying, name_of_ip_signed_new_account_form character varying, date_of_ip_signed_new_account_form character varying, name_of_principal_signed_new_account_form character varying, date_of_principal_signed_new_account_form character varying, politically_exposed_person character varying, private_banking_account character varying, foreign_bank_account character varying, initial_source_of_funds character varying, usa_patriot_act_exempt_reason character varying, primary_country_of_citizenship character varying, country_of_residence character varying, birth_date character varying, age_based_fund_roll_exempt character varying, money_fundreform_retail character varying, trusted_contact_status character varying, regulatory_account_type_category character varying, account_managed_by_trust_comp_id character varying, voting_auth character varying, campo_107 character varying, campo_108 character varying, campo_109 character varying, campo_110 character varying, customer_type character varying, campo_112 character varying, campo_113 character varying, campo_114 character varying, campo_115 character varying, campo_116 character varying, fulfillment_method character varying, credit_interest_indicator character varying, ama_indicator character varying, campo_120 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 9)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 21, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 24, 1)::VARCHAR(100) as campo_6,
        substr(sfl_file.linea, 25, 4)::VARCHAR(100) as ip_number,
        substr(sfl_file.linea, 29, 10)::VARCHAR(100) as account_short_name,
        substr(sfl_file.linea, 39, 2)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 41, 1)::VARCHAR(100) as transaction_type,
        substr(sfl_file.linea, 42, 1)::VARCHAR(100) as autotitled_usertitled_account,
        substr(sfl_file.linea, 43, 1)::VARCHAR(100) as account_type_code,
        substr(sfl_file.linea, 44, 4)::VARCHAR(100) as registration_type,
        substr(sfl_file.linea, 48, 1)::VARCHAR(100) as campo_14,
        substr(sfl_file.linea, 49, 1)::VARCHAR(100) as number_of_account_title_lines,
        substr(sfl_file.linea, 50, 32)::VARCHAR(100) as account_registration_line_1,
        substr(sfl_file.linea, 82, 32)::VARCHAR(100) as account_registration_line_2,
        substr(sfl_file.linea, 114, 32)::VARCHAR(100) as account_registration_line_3,
        substr(sfl_file.linea, 146, 32)::VARCHAR(100) as account_registration_line_4,
        substr(sfl_file.linea, 178, 32)::VARCHAR(100) as account_registration_line_5,
        substr(sfl_file.linea, 210, 32)::VARCHAR(100) as account_registration_line_6,
        substr(sfl_file.linea, 242, 21)::VARCHAR(100) as registration_type_detail,
        substr(sfl_file.linea, 263, 8)::VARCHAR(100) as date_account_opened,
        substr(sfl_file.linea, 271, 8)::VARCHAR(100) as date_account_information_updated,
        substr(sfl_file.linea, 279, 1)::VARCHAR(100) as account_status_indicator,
        substr(sfl_file.linea, 280, 8)::VARCHAR(100) as pending_closed_date,
        substr(sfl_file.linea, 288, 8)::VARCHAR(100) as date_account_closed,
        substr(sfl_file.linea, 296, 8)::VARCHAR(100) as closing_notice_date,
        substr(sfl_file.linea, 304, 8)::VARCHAR(100) as account_reactivated_date,
        substr(sfl_file.linea, 312, 8)::VARCHAR(100) as date_account_reopened,
        substr(sfl_file.linea, 320, 1)::VARCHAR(100) as proceeds,
        substr(sfl_file.linea, 321, 1)::VARCHAR(100) as transfer_instructions,
        substr(sfl_file.linea, 322, 1)::VARCHAR(100) as income_isntructions,
        substr(sfl_file.linea, 323, 2)::VARCHAR(100) as number_of_confirms_for_thi_account,
        substr(sfl_file.linea, 325, 2)::VARCHAR(100) as number_of_statements_for_this_account,
        substr(sfl_file.linea, 327, 1)::VARCHAR(100) as investment_objetive_trans_code,
        substr(sfl_file.linea, 328, 26)::VARCHAR(100) as comments_act,
        substr(sfl_file.linea, 354, 15)::VARCHAR(100) as employer_shotname,
        substr(sfl_file.linea, 369, 9)::VARCHAR(100) as employers_cusip,
        substr(sfl_file.linea, 378, 9)::VARCHAR(100) as employers_symbol,
        substr(sfl_file.linea, 387, 1)::VARCHAR(100) as margin_privileges_revoked,
        substr(sfl_file.linea, 388, 8)::VARCHAR(100) as statement_review_date,
        substr(sfl_file.linea, 396, 1)::VARCHAR(100) as margin_papers_on_file,
        substr(sfl_file.linea, 397, 1)::VARCHAR(100) as option_papers_on_file,
        substr(sfl_file.linea, 398, 1)::VARCHAR(100) as campo_45,
        substr(sfl_file.linea, 399, 1)::VARCHAR(100) as good_faith_margin,
        substr(sfl_file.linea, 400, 1)::VARCHAR(100) as ip_discretion_granted,
        substr(sfl_file.linea, 401, 1)::VARCHAR(100) as invest_advisor_discretion_granted,
        substr(sfl_file.linea, 402, 1)::VARCHAR(100) as third_party_discretion_granted,
        substr(sfl_file.linea, 403, 15)::VARCHAR(100) as third_party_name,
        substr(sfl_file.linea, 418, 1)::VARCHAR(100) as risk_factor_code,
        substr(sfl_file.linea, 419, 4)::VARCHAR(100) as investment_objetive_code,
        substr(sfl_file.linea, 423, 1)::VARCHAR(100) as option_equities,
        substr(sfl_file.linea, 424, 1)::VARCHAR(100) as option_index,
        substr(sfl_file.linea, 425, 1)::VARCHAR(100) as option_debt,
        substr(sfl_file.linea, 426, 1)::VARCHAR(100) as option_currency,
        substr(sfl_file.linea, 427, 1)::VARCHAR(100) as option_level_1,
        substr(sfl_file.linea, 428, 1)::VARCHAR(100) as option_level_2,
        substr(sfl_file.linea, 429, 1)::VARCHAR(100) as option_level_3,
        substr(sfl_file.linea, 430, 1)::VARCHAR(100) as option_level_4,
        substr(sfl_file.linea, 431, 10)::VARCHAR(100) as option_call_limits,
        substr(sfl_file.linea, 441, 10)::VARCHAR(100) as option_put_limits,
        substr(sfl_file.linea, 451, 10)::VARCHAR(100) as option_total_limits_of_puts_and_calls,
        substr(sfl_file.linea, 461, 1)::VARCHAR(100) as non_us_dollar_trading,
        substr(sfl_file.linea, 462, 3)::VARCHAR(100) as campo_65,
        substr(sfl_file.linea, 465, 1)::VARCHAR(100) as non_customer_indicator,
        substr(sfl_file.linea, 466, 2)::VARCHAR(100) as third_party_fee_indicator,
        substr(sfl_file.linea, 468, 8)::VARCHAR(100) as third_party_fee_approval_date,
        substr(sfl_file.linea, 476, 1)::VARCHAR(100) as intermediary_account_ind,
        substr(sfl_file.linea, 477, 2)::VARCHAR(100) as commission_schedule,
        substr(sfl_file.linea, 479, 5)::VARCHAR(100) as group_index,
        substr(sfl_file.linea, 484, 3)::VARCHAR(100) as money_manager_id,
        substr(sfl_file.linea, 487, 3)::VARCHAR(100) as money_manager_objective_id,
        substr(sfl_file.linea, 490, 5)::VARCHAR(100) as dtc_id_confirm_number,
        substr(sfl_file.linea, 495, 9)::VARCHAR(100) as caps_master_mnemonic,
        substr(sfl_file.linea, 504, 8)::VARCHAR(100) as employee_id,
        substr(sfl_file.linea, 512, 1)::VARCHAR(100) as prime_broker_free_fund_indicator,
        substr(sfl_file.linea, 513, 1)::VARCHAR(100) as fee_based_account_indicator,
        substr(sfl_file.linea, 514, 3)::VARCHAR(100) as campo_79,
        substr(sfl_file.linea, 517, 8)::VARCHAR(100) as fee_based_termination_date,
        substr(sfl_file.linea, 525, 1)::VARCHAR(100) as campo_81,
        substr(sfl_file.linea, 526, 32)::VARCHAR(100) as plan_name,
        substr(sfl_file.linea, 558, 32)::VARCHAR(100) as self_directed_401_k_account_type,
        substr(sfl_file.linea, 590, 2)::VARCHAR(100) as plan_type,
        substr(sfl_file.linea, 592, 10)::VARCHAR(100) as plan_number,
        substr(sfl_file.linea, 602, 4)::VARCHAR(100) as employee_or_employee_relative,
        substr(sfl_file.linea, 606, 18)::VARCHAR(100) as commission_percent_discount,
        substr(sfl_file.linea, 624, 1)::VARCHAR(100) as ind_12_b_1_fee_blocking,
        substr(sfl_file.linea, 625, 15)::VARCHAR(100) as name_of_ip_signed_new_account_form,
        substr(sfl_file.linea, 640, 8)::VARCHAR(100) as date_of_ip_signed_new_account_form,
        substr(sfl_file.linea, 648, 15)::VARCHAR(100) as name_of_principal_signed_new_account_form,
        substr(sfl_file.linea, 663, 8)::VARCHAR(100) as date_of_principal_signed_new_account_form,
        substr(sfl_file.linea, 671, 1)::VARCHAR(100) as politically_exposed_person,
        substr(sfl_file.linea, 672, 1)::VARCHAR(100) as private_banking_account,
        substr(sfl_file.linea, 673, 1)::VARCHAR(100) as foreign_bank_account,
        substr(sfl_file.linea, 674, 4)::VARCHAR(100) as initial_source_of_funds,
        substr(sfl_file.linea, 678, 4)::VARCHAR(100) as usa_patriot_act_exempt_reason,
        substr(sfl_file.linea, 682, 2)::VARCHAR(100) as primary_country_of_citizenship,
        substr(sfl_file.linea, 684, 2)::VARCHAR(100) as country_of_residence,
        substr(sfl_file.linea, 686, 8)::VARCHAR(100) as birth_date,
        substr(sfl_file.linea, 694, 1)::VARCHAR(100) as age_based_fund_roll_exempt,
        substr(sfl_file.linea, 695, 1)::VARCHAR(100) as money_fundreform_retail,
        substr(sfl_file.linea, 696, 1)::VARCHAR(100) as trusted_contact_status,
        substr(sfl_file.linea, 697, 4)::VARCHAR(100) as regulatory_account_type_category,
        substr(sfl_file.linea, 701, 1)::VARCHAR(100) as account_managed_by_trust_comp_id,
        substr(sfl_file.linea, 702, 2)::VARCHAR(100) as voting_auth,
        substr(sfl_file.linea, 704, 6)::VARCHAR(100) as campo_107,
        substr(sfl_file.linea, 710, 2)::VARCHAR(100) as campo_108,
        substr(sfl_file.linea, 712, 3)::VARCHAR(100) as campo_109,
        substr(sfl_file.linea, 715, 4)::VARCHAR(100) as campo_110,
        substr(sfl_file.linea, 719, 4)::VARCHAR(100) as customer_type,
        substr(sfl_file.linea, 723, 4)::VARCHAR(100) as campo_112,
        substr(sfl_file.linea, 727, 4)::VARCHAR(100) as campo_113,
        substr(sfl_file.linea, 731, 4)::VARCHAR(100) as campo_114,
        substr(sfl_file.linea, 735, 4)::VARCHAR(100) as campo_115,
        substr(sfl_file.linea, 739, 4)::VARCHAR(100) as campo_116,
        substr(sfl_file.linea, 743, 4)::VARCHAR(100) as fulfillment_method,
        substr(sfl_file.linea, 747, 1)::VARCHAR(100) as credit_interest_indicator,
        substr(sfl_file.linea, 748, 1)::VARCHAR(100) as ama_indicator,
        substr(sfl_file.linea, 749, 1)::VARCHAR(100) as campo_120,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CIA'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_acct_reg_b(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, ibd_number character varying, campo_6 character varying, ip_number character varying, account_short_name character varying, campo_9 character varying, tax_id_type character varying, tax_id_number character varying, date_tax_id_applied_for character varying, w_8_w_9_indicator character varying, w_8_w_9_date_signed character varying, w_8_w_9_effective_date character varying, w_8_w_9_document_type character varying, tax_status character varying, b_notice_reason_code character varying, first_b_notice_status character varying, date_first_b_notice_status_issued_enforced character varying, campo_21 character varying, date_first_notice_status_satisfied character varying, second_b_notice_status character varying, date_second_b_notice_status_issued_enforced character varying, campo_25 character varying, date_second_b_notice_status_satisfied character varying, c_notice_status character varying, date_c_notice_status_issued_enforced character varying, date_c_notice_status_satisfied character varying, old_account_number character varying, original_account_open_date character varying, unidentified_large_trader_id character varying, campo_33 character varying, large_trader_type_code character varying, large_trader_type_last_change_date character varying, campo_36 character varying, campo_37 character varying, initial_source_of_funds_other character varying, finance_away character varying, account_funding_date character varying, campo_41 character varying, statement_currency_code character varying, future_statement_currency_code character varying, future_statement_currency_code_effective_date character varying, account_level_routing_code_1 character varying, account_level_routing_code_2 character varying, account_level_routing_code_3 character varying, account_level_routing_code_4 character varying, campo_49 character varying, self_directed_ind character varying, digital_advice_ind character varying, pte_account_ind character varying, campo_53 character varying, first_ip character varying, second_ip character varying, third_ip character varying, fourth_ip character varying, fifth_ip character varying, sixth_ip character varying, seventh_ip character varying, eighth_ip character varying, ninth_ip character varying, tenth_ip character varying, alert_im_acornym character varying, alert_im_access_code character varying, broker_acronym character varying, cross_reference_indicator character varying, bny_trust_indicator character varying, source_of_asset_at_acct_opening character varying, commission_doscount_code character varying, external_account_number character varying, confirmation_suppression_indicator character varying, date_last_mail_sent character varying, date_last_mail_sent_outside character varying, campo_75 character varying, fully_paid_lending_agreement_indicator character varying, fully_paid_lending_agreement_date character varying, custodian_account_type character varying, mifid_customer_categorization character varying, cash_management_tran_code character varying, sweep_status_indicator character varying, date_sweep_activated character varying, date_sweep_details_changed character varying, cober_margin_debit_indicator character varying, campo_85 character varying, first_fund_sweep_account_id character varying, firstfund_sweep_account_percent character varying, first_fundsweep_account_redemption_priority character varying, second_fund_sweep_account_id character varying, second_fund_sweep_account_percent character varying, second_fundsweep_account_redemption_priority character varying, type_of_bank_account character varying, banklink_aba_number character varying, banklink_dda_number character varying, campo_95 character varying, fund_bank_indicator character varying, campo_97 character varying, w_9_corp_tax_classification_code character varying, campo_99 character varying, combined_margin_acct_indicator character varying, pledge_collateral_account_indicator character varying, finra_institutional_account_code character varying, proposed_account_reference_id character varying, advisor_model_id character varying, firm_model_style_id character varying, campo_106 character varying, campo_107 character varying, campo_108 character varying, dvp_restriction_code character varying, dvp_restriction_exp_date character varying, escheatment_withholding_ind character varying, campo_112 character varying, source_of_origination character varying, source_of_persona character varying, client_onboarding_method character varying, tax_filing_code character varying, campo_117 character varying, campo_118 character varying, nor_purpose_collateral_acct_ind character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 9)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 21, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 24, 1)::VARCHAR(100) as campo_6,
        substr(sfl_file.linea, 25, 4)::VARCHAR(100) as ip_number,
        substr(sfl_file.linea, 29, 10)::VARCHAR(100) as account_short_name,
        substr(sfl_file.linea, 39, 2)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 41, 1)::VARCHAR(100) as tax_id_type,
        substr(sfl_file.linea, 42, 9)::VARCHAR(100) as tax_id_number,
        substr(sfl_file.linea, 51, 8)::VARCHAR(100) as date_tax_id_applied_for,
        substr(sfl_file.linea, 59, 2)::VARCHAR(100) as w_8_w_9_indicator,
        substr(sfl_file.linea, 61, 8)::VARCHAR(100) as w_8_w_9_date_signed,
        substr(sfl_file.linea, 69, 8)::VARCHAR(100) as w_8_w_9_effective_date,
        substr(sfl_file.linea, 77, 4)::VARCHAR(100) as w_8_w_9_document_type,
        substr(sfl_file.linea, 81, 1)::VARCHAR(100) as tax_status,
        substr(sfl_file.linea, 82, 1)::VARCHAR(100) as b_notice_reason_code,
        substr(sfl_file.linea, 83, 20)::VARCHAR(100) as first_b_notice_status,
        substr(sfl_file.linea, 103, 8)::VARCHAR(100) as date_first_b_notice_status_issued_enforced,
        substr(sfl_file.linea, 111, 8)::VARCHAR(100) as campo_21,
        substr(sfl_file.linea, 119, 8)::VARCHAR(100) as date_first_notice_status_satisfied,
        substr(sfl_file.linea, 127, 20)::VARCHAR(100) as second_b_notice_status,
        substr(sfl_file.linea, 147, 8)::VARCHAR(100) as date_second_b_notice_status_issued_enforced,
        substr(sfl_file.linea, 155, 8)::VARCHAR(100) as campo_25,
        substr(sfl_file.linea, 163, 8)::VARCHAR(100) as date_second_b_notice_status_satisfied,
        substr(sfl_file.linea, 171, 20)::VARCHAR(100) as c_notice_status,
        substr(sfl_file.linea, 191, 8)::VARCHAR(100) as date_c_notice_status_issued_enforced,
        substr(sfl_file.linea, 199, 8)::VARCHAR(100) as date_c_notice_status_satisfied,
        substr(sfl_file.linea, 207, 20)::VARCHAR(100) as old_account_number,
        substr(sfl_file.linea, 227, 8)::VARCHAR(100) as original_account_open_date,
        substr(sfl_file.linea, 235, 13)::VARCHAR(100) as unidentified_large_trader_id,
        substr(sfl_file.linea, 248, 2)::VARCHAR(100) as campo_33,
        substr(sfl_file.linea, 250, 2)::VARCHAR(100) as large_trader_type_code,
        substr(sfl_file.linea, 252, 8)::VARCHAR(100) as large_trader_type_last_change_date,
        substr(sfl_file.linea, 260, 13)::VARCHAR(100) as campo_36,
        substr(sfl_file.linea, 273, 14)::VARCHAR(100) as campo_37,
        substr(sfl_file.linea, 287, 30)::VARCHAR(100) as initial_source_of_funds_other,
        substr(sfl_file.linea, 317, 1)::VARCHAR(100) as finance_away,
        substr(sfl_file.linea, 318, 8)::VARCHAR(100) as account_funding_date,
        substr(sfl_file.linea, 326, 7)::VARCHAR(100) as campo_41,
        substr(sfl_file.linea, 333, 3)::VARCHAR(100) as statement_currency_code,
        substr(sfl_file.linea, 336, 3)::VARCHAR(100) as future_statement_currency_code,
        substr(sfl_file.linea, 339, 8)::VARCHAR(100) as future_statement_currency_code_effective_date,
        substr(sfl_file.linea, 347, 3)::VARCHAR(100) as account_level_routing_code_1,
        substr(sfl_file.linea, 350, 3)::VARCHAR(100) as account_level_routing_code_2,
        substr(sfl_file.linea, 353, 3)::VARCHAR(100) as account_level_routing_code_3,
        substr(sfl_file.linea, 356, 3)::VARCHAR(100) as account_level_routing_code_4,
        substr(sfl_file.linea, 359, 1)::VARCHAR(100) as campo_49,
        substr(sfl_file.linea, 360, 1)::VARCHAR(100) as self_directed_ind,
        substr(sfl_file.linea, 361, 1)::VARCHAR(100) as digital_advice_ind,
        substr(sfl_file.linea, 362, 1)::VARCHAR(100) as pte_account_ind,
        substr(sfl_file.linea, 363, 8)::VARCHAR(100) as campo_53,
        substr(sfl_file.linea, 371, 3)::VARCHAR(100) as first_ip,
        substr(sfl_file.linea, 374, 3)::VARCHAR(100) as second_ip,
        substr(sfl_file.linea, 377, 3)::VARCHAR(100) as third_ip,
        substr(sfl_file.linea, 380, 3)::VARCHAR(100) as fourth_ip,
        substr(sfl_file.linea, 383, 3)::VARCHAR(100) as fifth_ip,
        substr(sfl_file.linea, 386, 3)::VARCHAR(100) as sixth_ip,
        substr(sfl_file.linea, 389, 3)::VARCHAR(100) as seventh_ip,
        substr(sfl_file.linea, 392, 3)::VARCHAR(100) as eighth_ip,
        substr(sfl_file.linea, 395, 3)::VARCHAR(100) as ninth_ip,
        substr(sfl_file.linea, 398, 3)::VARCHAR(100) as tenth_ip,
        substr(sfl_file.linea, 401, 8)::VARCHAR(100) as alert_im_acornym,
        substr(sfl_file.linea, 409, 16)::VARCHAR(100) as alert_im_access_code,
        substr(sfl_file.linea, 425, 8)::VARCHAR(100) as broker_acronym,
        substr(sfl_file.linea, 433, 1)::VARCHAR(100) as cross_reference_indicator,
        substr(sfl_file.linea, 434, 1)::VARCHAR(100) as bny_trust_indicator,
        substr(sfl_file.linea, 435, 2)::VARCHAR(100) as source_of_asset_at_acct_opening,
        substr(sfl_file.linea, 437, 1)::VARCHAR(100) as commission_doscount_code,
        substr(sfl_file.linea, 438, 20)::VARCHAR(100) as external_account_number,
        substr(sfl_file.linea, 458, 1)::VARCHAR(100) as confirmation_suppression_indicator,
        substr(sfl_file.linea, 459, 6)::VARCHAR(100) as date_last_mail_sent,
        substr(sfl_file.linea, 465, 6)::VARCHAR(100) as date_last_mail_sent_outside,
        substr(sfl_file.linea, 471, 1)::VARCHAR(100) as campo_75,
        substr(sfl_file.linea, 472, 1)::VARCHAR(100) as fully_paid_lending_agreement_indicator,
        substr(sfl_file.linea, 473, 8)::VARCHAR(100) as fully_paid_lending_agreement_date,
        substr(sfl_file.linea, 481, 4)::VARCHAR(100) as custodian_account_type,
        substr(sfl_file.linea, 485, 4)::VARCHAR(100) as mifid_customer_categorization,
        substr(sfl_file.linea, 489, 1)::VARCHAR(100) as cash_management_tran_code,
        substr(sfl_file.linea, 490, 4)::VARCHAR(100) as sweep_status_indicator,
        substr(sfl_file.linea, 494, 8)::VARCHAR(100) as date_sweep_activated,
        substr(sfl_file.linea, 502, 8)::VARCHAR(100) as date_sweep_details_changed,
        substr(sfl_file.linea, 510, 1)::VARCHAR(100) as cober_margin_debit_indicator,
        substr(sfl_file.linea, 511, 1)::VARCHAR(100) as campo_85,
        substr(sfl_file.linea, 512, 7)::VARCHAR(100) as first_fund_sweep_account_id,
        substr(sfl_file.linea, 519, 18)::VARCHAR(100) as firstfund_sweep_account_percent,
        substr(sfl_file.linea, 537, 1)::VARCHAR(100) as first_fundsweep_account_redemption_priority,
        substr(sfl_file.linea, 538, 7)::VARCHAR(100) as second_fund_sweep_account_id,
        substr(sfl_file.linea, 545, 18)::VARCHAR(100) as second_fund_sweep_account_percent,
        substr(sfl_file.linea, 563, 1)::VARCHAR(100) as second_fundsweep_account_redemption_priority,
        substr(sfl_file.linea, 564, 1)::VARCHAR(100) as type_of_bank_account,
        substr(sfl_file.linea, 565, 9)::VARCHAR(100) as banklink_aba_number,
        substr(sfl_file.linea, 574, 17)::VARCHAR(100) as banklink_dda_number,
        substr(sfl_file.linea, 591, 3)::VARCHAR(100) as campo_95,
        substr(sfl_file.linea, 594, 1)::VARCHAR(100) as fund_bank_indicator,
        substr(sfl_file.linea, 595, 36)::VARCHAR(100) as campo_97,
        substr(sfl_file.linea, 631, 4)::VARCHAR(100) as w_9_corp_tax_classification_code,
        substr(sfl_file.linea, 635, 1)::VARCHAR(100) as campo_99,
        substr(sfl_file.linea, 636, 1)::VARCHAR(100) as combined_margin_acct_indicator,
        substr(sfl_file.linea, 637, 1)::VARCHAR(100) as pledge_collateral_account_indicator,
        substr(sfl_file.linea, 638, 4)::VARCHAR(100) as finra_institutional_account_code,
        substr(sfl_file.linea, 642, 6)::VARCHAR(100) as proposed_account_reference_id,
        substr(sfl_file.linea, 648, 12)::VARCHAR(100) as advisor_model_id,
        substr(sfl_file.linea, 660, 6)::VARCHAR(100) as firm_model_style_id,
        substr(sfl_file.linea, 666, 20)::VARCHAR(100) as campo_106,
        substr(sfl_file.linea, 686, 13)::VARCHAR(100) as campo_107,
        substr(sfl_file.linea, 699, 12)::VARCHAR(100) as campo_108,
        substr(sfl_file.linea, 711, 1)::VARCHAR(100) as dvp_restriction_code,
        substr(sfl_file.linea, 712, 8)::VARCHAR(100) as dvp_restriction_exp_date,
        substr(sfl_file.linea, 720, 2)::VARCHAR(100) as escheatment_withholding_ind,
        substr(sfl_file.linea, 722, 1)::VARCHAR(100) as campo_112,
        substr(sfl_file.linea, 723, 4)::VARCHAR(100) as source_of_origination,
        substr(sfl_file.linea, 727, 4)::VARCHAR(100) as source_of_persona,
        substr(sfl_file.linea, 731, 4)::VARCHAR(100) as client_onboarding_method,
        substr(sfl_file.linea, 735, 4)::VARCHAR(100) as tax_filing_code,
        substr(sfl_file.linea, 739, 6)::VARCHAR(100) as campo_117,
        substr(sfl_file.linea, 745, 4)::VARCHAR(100) as campo_118,
        substr(sfl_file.linea, 749, 1)::VARCHAR(100) as nor_purpose_collateral_acct_ind,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CIB'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_acct_reg_c(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, ibd_number character varying, campo_6 character varying, ip_number character varying, account_short_name character varying, campo_9 character varying, addr_1_trx_code character varying, addr_1_special_handling_ind character varying, addr_1_delivery_id character varying, addr_1_attention_line_prefix character varying, addr_1_attention_line_detail character varying, addr_1_line_1 character varying, addr_1_line_2 character varying, addr_1_line_3 character varying, addr_1_line_4 character varying, addr_1_city_state character varying, addr_1_country_code character varying, campo_21 character varying, campo_22 character varying, campo_23 character varying, campo_24 character varying, campo_25 character varying, campo_26 character varying, campo_27 character varying, campo_28 character varying, campo_29 character varying, campo_30 character varying, addr_2_trx_code character varying, addr_2_special_handling_ind character varying, addr_2_delivery_id character varying, addr_2_attention_line_prefix character varying, addr_2_attention_line_detail character varying, addr_2_line_1 character varying, addr_2_line_2 character varying, addr_2_line_3 character varying, addr_2_line_4 character varying, addr_2_city_state character varying, addr_2_country_code character varying, account_description character varying, set_as_mail_addr_2_ind character varying, campo_44 character varying, principal_billing_allocation_pct character varying, campo_46 character varying, seasonal_addr_id_1 character varying, from_date_1 character varying, to_date_1 character varying, seasonal_addr_id_2 character varying, from_date_2 character varying, to_date_2 character varying, seasonal_addr_id_3 character varying, from_date_3 character varying, to_date_3 character varying, cost_basis_acct_system character varying, disposition_method_mutual_funds character varying, disposition_method_other character varying, disposition_method_stocks character varying, campo_60 character varying, amortize_taxable_premium_bonds character varying, accrue_market_disc_based_on character varying, accrue_market_disc_income character varying, campo_64 character varying, campo_65 character varying, campo_66 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 9)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 21, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 24, 1)::VARCHAR(100) as campo_6,
        substr(sfl_file.linea, 25, 4)::VARCHAR(100) as ip_number,
        substr(sfl_file.linea, 29, 10)::VARCHAR(100) as account_short_name,
        substr(sfl_file.linea, 39, 2)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 41, 1)::VARCHAR(100) as addr_1_trx_code,
        substr(sfl_file.linea, 42, 1)::VARCHAR(100) as addr_1_special_handling_ind,
        substr(sfl_file.linea, 43, 1)::VARCHAR(100) as addr_1_delivery_id,
        substr(sfl_file.linea, 44, 4)::VARCHAR(100) as addr_1_attention_line_prefix,
        substr(sfl_file.linea, 48, 28)::VARCHAR(100) as addr_1_attention_line_detail,
        substr(sfl_file.linea, 76, 32)::VARCHAR(100) as addr_1_line_1,
        substr(sfl_file.linea, 108, 32)::VARCHAR(100) as addr_1_line_2,
        substr(sfl_file.linea, 140, 32)::VARCHAR(100) as addr_1_line_3,
        substr(sfl_file.linea, 172, 32)::VARCHAR(100) as addr_1_line_4,
        substr(sfl_file.linea, 204, 32)::VARCHAR(100) as addr_1_city_state,
        substr(sfl_file.linea, 236, 2)::VARCHAR(100) as addr_1_country_code,
        substr(sfl_file.linea, 238, 1)::VARCHAR(100) as campo_21,
        substr(sfl_file.linea, 239, 8)::VARCHAR(100) as campo_22,
        substr(sfl_file.linea, 247, 21)::VARCHAR(100) as campo_23,
        substr(sfl_file.linea, 268, 4)::VARCHAR(100) as campo_24,
        substr(sfl_file.linea, 272, 8)::VARCHAR(100) as campo_25,
        substr(sfl_file.linea, 280, 21)::VARCHAR(100) as campo_26,
        substr(sfl_file.linea, 301, 4)::VARCHAR(100) as campo_27,
        substr(sfl_file.linea, 305, 8)::VARCHAR(100) as campo_28,
        substr(sfl_file.linea, 313, 21)::VARCHAR(100) as campo_29,
        substr(sfl_file.linea, 334, 4)::VARCHAR(100) as campo_30,
        substr(sfl_file.linea, 338, 1)::VARCHAR(100) as addr_2_trx_code,
        substr(sfl_file.linea, 339, 1)::VARCHAR(100) as addr_2_special_handling_ind,
        substr(sfl_file.linea, 340, 1)::VARCHAR(100) as addr_2_delivery_id,
        substr(sfl_file.linea, 341, 4)::VARCHAR(100) as addr_2_attention_line_prefix,
        substr(sfl_file.linea, 345, 28)::VARCHAR(100) as addr_2_attention_line_detail,
        substr(sfl_file.linea, 373, 32)::VARCHAR(100) as addr_2_line_1,
        substr(sfl_file.linea, 405, 32)::VARCHAR(100) as addr_2_line_2,
        substr(sfl_file.linea, 437, 50)::VARCHAR(100) as addr_2_line_3,
        substr(sfl_file.linea, 487, 14)::VARCHAR(100) as addr_2_line_4,
        substr(sfl_file.linea, 501, 32)::VARCHAR(100) as addr_2_city_state,
        substr(sfl_file.linea, 533, 2)::VARCHAR(100) as addr_2_country_code,
        substr(sfl_file.linea, 535, 32)::VARCHAR(100) as account_description,
        substr(sfl_file.linea, 567, 1)::VARCHAR(100) as set_as_mail_addr_2_ind,
        substr(sfl_file.linea, 568, 33)::VARCHAR(100) as campo_44,
        substr(sfl_file.linea, 601, 18)::VARCHAR(100) as principal_billing_allocation_pct,
        substr(sfl_file.linea, 619, 16)::VARCHAR(100) as campo_46,
        substr(sfl_file.linea, 635, 1)::VARCHAR(100) as seasonal_addr_id_1,
        substr(sfl_file.linea, 636, 8)::VARCHAR(100) as from_date_1,
        substr(sfl_file.linea, 644, 8)::VARCHAR(100) as to_date_1,
        substr(sfl_file.linea, 652, 1)::VARCHAR(100) as seasonal_addr_id_2,
        substr(sfl_file.linea, 653, 8)::VARCHAR(100) as from_date_2,
        substr(sfl_file.linea, 661, 8)::VARCHAR(100) as to_date_2,
        substr(sfl_file.linea, 669, 1)::VARCHAR(100) as seasonal_addr_id_3,
        substr(sfl_file.linea, 670, 8)::VARCHAR(100) as from_date_3,
        substr(sfl_file.linea, 678, 8)::VARCHAR(100) as to_date_3,
        substr(sfl_file.linea, 686, 4)::VARCHAR(100) as cost_basis_acct_system,
        substr(sfl_file.linea, 690, 2)::VARCHAR(100) as disposition_method_mutual_funds,
        substr(sfl_file.linea, 692, 2)::VARCHAR(100) as disposition_method_other,
        substr(sfl_file.linea, 694, 2)::VARCHAR(100) as disposition_method_stocks,
        substr(sfl_file.linea, 696, 1)::VARCHAR(100) as campo_60,
        substr(sfl_file.linea, 697, 1)::VARCHAR(100) as amortize_taxable_premium_bonds,
        substr(sfl_file.linea, 698, 1)::VARCHAR(100) as accrue_market_disc_based_on,
        substr(sfl_file.linea, 699, 1)::VARCHAR(100) as accrue_market_disc_income,
        substr(sfl_file.linea, 700, 6)::VARCHAR(100) as campo_64,
        substr(sfl_file.linea, 706, 42)::VARCHAR(100) as campo_65,
        substr(sfl_file.linea, 748, 2)::VARCHAR(100) as campo_66,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CIC'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_acct_reg_d(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, ibd_number character varying, campo_6 character varying, ip_number character varying, account_short_name character varying, campo_9 character varying, addr_3_trx_code character varying, addr_3_special_handling_ind character varying, addr_3_delivery_id character varying, addr_3_attention_line_prefix character varying, addr_3_attention_line_detail character varying, addr_3_line_1 character varying, addr_3_line_2 character varying, addr_3_line_3 character varying, addr_3_line_4 character varying, addr_3_city_state character varying, addr_3_country_code character varying, set_as_mail_addr_3_ind character varying, campo_22 character varying, addr_4_trx_code character varying, addr_4_special_handling_ind character varying, addr_4_delivery_id character varying, addr_4_attention_line_prefix character varying, addr_4_attention_line_detail character varying, addr_4_line_1 character varying, addr_4_line_2 character varying, addr_4_line_3 character varying, addr_4_line_4 character varying, addr_4_city_state character varying, addr_4_country_code character varying, set_as_mail_addr_4_ind character varying, campo_35 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 9)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 21, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 24, 1)::VARCHAR(100) as campo_6,
        substr(sfl_file.linea, 25, 4)::VARCHAR(100) as ip_number,
        substr(sfl_file.linea, 29, 10)::VARCHAR(100) as account_short_name,
        substr(sfl_file.linea, 39, 2)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 41, 1)::VARCHAR(100) as addr_3_trx_code,
        substr(sfl_file.linea, 42, 1)::VARCHAR(100) as addr_3_special_handling_ind,
        substr(sfl_file.linea, 43, 1)::VARCHAR(100) as addr_3_delivery_id,
        substr(sfl_file.linea, 44, 4)::VARCHAR(100) as addr_3_attention_line_prefix,
        substr(sfl_file.linea, 48, 28)::VARCHAR(100) as addr_3_attention_line_detail,
        substr(sfl_file.linea, 76, 32)::VARCHAR(100) as addr_3_line_1,
        substr(sfl_file.linea, 108, 32)::VARCHAR(100) as addr_3_line_2,
        substr(sfl_file.linea, 140, 32)::VARCHAR(100) as addr_3_line_3,
        substr(sfl_file.linea, 172, 32)::VARCHAR(100) as addr_3_line_4,
        substr(sfl_file.linea, 204, 32)::VARCHAR(100) as addr_3_city_state,
        substr(sfl_file.linea, 236, 2)::VARCHAR(100) as addr_3_country_code,
        substr(sfl_file.linea, 238, 1)::VARCHAR(100) as set_as_mail_addr_3_ind,
        substr(sfl_file.linea, 239, 99)::VARCHAR(100) as campo_22,
        substr(sfl_file.linea, 338, 1)::VARCHAR(100) as addr_4_trx_code,
        substr(sfl_file.linea, 339, 1)::VARCHAR(100) as addr_4_special_handling_ind,
        substr(sfl_file.linea, 340, 1)::VARCHAR(100) as addr_4_delivery_id,
        substr(sfl_file.linea, 341, 4)::VARCHAR(100) as addr_4_attention_line_prefix,
        substr(sfl_file.linea, 345, 28)::VARCHAR(100) as addr_4_attention_line_detail,
        substr(sfl_file.linea, 373, 32)::VARCHAR(100) as addr_4_line_1,
        substr(sfl_file.linea, 405, 32)::VARCHAR(100) as addr_4_line_2,
        substr(sfl_file.linea, 437, 50)::VARCHAR(100) as addr_4_line_3,
        substr(sfl_file.linea, 487, 14)::VARCHAR(100) as addr_4_line_4,
        substr(sfl_file.linea, 501, 32)::VARCHAR(100) as addr_4_city_state,
        substr(sfl_file.linea, 533, 2)::VARCHAR(100) as addr_4_country_code,
        substr(sfl_file.linea, 535, 1)::VARCHAR(100) as set_as_mail_addr_4_ind,
        substr(sfl_file.linea, 536, 214)::VARCHAR(100) as campo_35,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CID'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_acct_reg_e(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, ibd_number character varying, campo_6 character varying, ip_number character varying, account_short_name character varying, campo_9 character varying, addr_5_trx_code character varying, addr_5_special_handling_ind character varying, addr_5_delivery_id character varying, addr_5_attention_line_prefix character varying, addr_5_attention_line_detail character varying, addr_5_line_1 character varying, addr_5_line_2 character varying, addr_5_line_3 character varying, addr_5_line_4 character varying, addr_5_city_state character varying, addr_5_country_code character varying, set_as_mail_addr_5_ind character varying, campo_22 character varying, addr_6_trx_code character varying, addr_6_special_handling_ind character varying, addr_6_delivery_id character varying, addr_6_attention_line_prefix character varying, addr_6_attention_line_detail character varying, addr_6_line_1 character varying, addr_6_line_2 character varying, addr_6_line_3 character varying, addr_6_line_4 character varying, addr_6_city_state character varying, addr_6_country_code character varying, set_as_mail_addr_6_ind character varying, campo_35 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 9)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 21, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 24, 1)::VARCHAR(100) as campo_6,
        substr(sfl_file.linea, 25, 4)::VARCHAR(100) as ip_number,
        substr(sfl_file.linea, 29, 10)::VARCHAR(100) as account_short_name,
        substr(sfl_file.linea, 39, 2)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 41, 1)::VARCHAR(100) as addr_5_trx_code,
        substr(sfl_file.linea, 42, 1)::VARCHAR(100) as addr_5_special_handling_ind,
        substr(sfl_file.linea, 43, 1)::VARCHAR(100) as addr_5_delivery_id,
        substr(sfl_file.linea, 44, 4)::VARCHAR(100) as addr_5_attention_line_prefix,
        substr(sfl_file.linea, 48, 28)::VARCHAR(100) as addr_5_attention_line_detail,
        substr(sfl_file.linea, 76, 32)::VARCHAR(100) as addr_5_line_1,
        substr(sfl_file.linea, 108, 32)::VARCHAR(100) as addr_5_line_2,
        substr(sfl_file.linea, 140, 32)::VARCHAR(100) as addr_5_line_3,
        substr(sfl_file.linea, 172, 32)::VARCHAR(100) as addr_5_line_4,
        substr(sfl_file.linea, 204, 32)::VARCHAR(100) as addr_5_city_state,
        substr(sfl_file.linea, 236, 2)::VARCHAR(100) as addr_5_country_code,
        substr(sfl_file.linea, 238, 1)::VARCHAR(100) as set_as_mail_addr_5_ind,
        substr(sfl_file.linea, 239, 99)::VARCHAR(100) as campo_22,
        substr(sfl_file.linea, 338, 1)::VARCHAR(100) as addr_6_trx_code,
        substr(sfl_file.linea, 339, 1)::VARCHAR(100) as addr_6_special_handling_ind,
        substr(sfl_file.linea, 340, 1)::VARCHAR(100) as addr_6_delivery_id,
        substr(sfl_file.linea, 341, 4)::VARCHAR(100) as addr_6_attention_line_prefix,
        substr(sfl_file.linea, 345, 28)::VARCHAR(100) as addr_6_attention_line_detail,
        substr(sfl_file.linea, 373, 32)::VARCHAR(100) as addr_6_line_1,
        substr(sfl_file.linea, 405, 32)::VARCHAR(100) as addr_6_line_2,
        substr(sfl_file.linea, 437, 32)::VARCHAR(100) as addr_6_line_3,
        substr(sfl_file.linea, 469, 32)::VARCHAR(100) as addr_6_line_4,
        substr(sfl_file.linea, 501, 32)::VARCHAR(100) as addr_6_city_state,
        substr(sfl_file.linea, 533, 2)::VARCHAR(100) as addr_6_country_code,
        substr(sfl_file.linea, 535, 1)::VARCHAR(100) as set_as_mail_addr_6_ind,
        substr(sfl_file.linea, 536, 214)::VARCHAR(100) as campo_35,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CIE'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_acct_reg_f(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, ibd_number character varying, campo_6 character varying, ip_number character varying, account_short_name character varying, campo_9 character varying, addr_7_trx_code character varying, addr_7_special_handling_ind character varying, addr_7_delivery_id character varying, addr_7_attention_line_prefix character varying, addr_7_attention_line_detail character varying, addr_7_line_1 character varying, addr_7_line_2 character varying, addr_7_line_3 character varying, addr_7_line_4 character varying, addr_7_city_state character varying, addr_7_country_code character varying, set_as_mail_addr_7_ind character varying, campo_22 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 9)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 21, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 24, 1)::VARCHAR(100) as campo_6,
        substr(sfl_file.linea, 25, 4)::VARCHAR(100) as ip_number,
        substr(sfl_file.linea, 29, 10)::VARCHAR(100) as account_short_name,
        substr(sfl_file.linea, 39, 2)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 41, 1)::VARCHAR(100) as addr_7_trx_code,
        substr(sfl_file.linea, 42, 1)::VARCHAR(100) as addr_7_special_handling_ind,
        substr(sfl_file.linea, 43, 1)::VARCHAR(100) as addr_7_delivery_id,
        substr(sfl_file.linea, 44, 4)::VARCHAR(100) as addr_7_attention_line_prefix,
        substr(sfl_file.linea, 48, 28)::VARCHAR(100) as addr_7_attention_line_detail,
        substr(sfl_file.linea, 76, 32)::VARCHAR(100) as addr_7_line_1,
        substr(sfl_file.linea, 108, 32)::VARCHAR(100) as addr_7_line_2,
        substr(sfl_file.linea, 140, 32)::VARCHAR(100) as addr_7_line_3,
        substr(sfl_file.linea, 172, 32)::VARCHAR(100) as addr_7_line_4,
        substr(sfl_file.linea, 204, 32)::VARCHAR(100) as addr_7_city_state,
        substr(sfl_file.linea, 236, 2)::VARCHAR(100) as addr_7_country_code,
        substr(sfl_file.linea, 238, 1)::VARCHAR(100) as set_as_mail_addr_7_ind,
        substr(sfl_file.linea, 239, 511)::VARCHAR(100) as campo_22,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CIF'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_acct_reg_w(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, ibd_number character varying, campo_6 character varying, ip_number character varying, account_short_name character varying, campo_9 character varying, record_transaction_code character varying, non_us_dollar_trading character varying, base_currency character varying, income_currency character varying, statement_language character varying, statement_format_code character varying, msrb_statement_ind character varying, campo_17 character varying, pep character varying, first_name_pep character varying, last_name_pep character varying, suffix_pep character varying, political_office_held character varying, country_of_office character varying, foreign_bank_account_ind character varying, foreign_bank_cert_date character varying, foreign_bank_cert_exp_date character varying, central_bank_ind character varying, acct_foreign_financial_inst character varying, foreign_bank_acct_oper_1 character varying, foreign_bank_acct_oper_2 character varying, foreign_bank_acct_oper_3 character varying, number_people_own character varying, proprietary_acct_owned character varying, campo_34 character varying, tel_1_transaction_code character varying, tel_1_us_ind character varying, tel_1_type_id character varying, tel_1_number character varying, tel_1_extension character varying, tel_2_transaction_code character varying, tel_2_us_ind character varying, tel_2_type_id character varying, tel_2_number character varying, tel_2_extension character varying, tel_3_transaction_code character varying, tel_3_us_ind character varying, tel_3_type_id character varying, tel_3_number character varying, tel_3_extension character varying, tel_4_transaction_code character varying, tel_4_us_ind character varying, tel_4_type_id character varying, tel_4_number character varying, tel_4_extension character varying, tel_5_transaction_code character varying, tel_5_us_ind character varying, tel_5_type_id character varying, tel_5_number character varying, tel_5_extension character varying, tel_6_transaction_code character varying, tel_6_us_ind character varying, tel_6_type_id character varying, tel_6_number character varying, tel_6_extension character varying, tel_7_transaction_code character varying, tel_7_us_ind character varying, tel_7_type_id character varying, tel_7_number character varying, tel_7_extension character varying, tel_8_transaction_code character varying, tel_8_us_ind character varying, tel_8_type_id character varying, tel_8_number character varying, tel_8_extension character varying, email_address character varying, external_position_ind character varying, purge_eligible_ind character varying, advisory_acct_ind character varying, product_profile_code character varying, cents_per_share_discount character varying, campo_81 character varying, option_disclosure_date character varying, campo_83 character varying, country_acct_level_tax_residency character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 9)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 21, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 24, 1)::VARCHAR(100) as campo_6,
        substr(sfl_file.linea, 25, 4)::VARCHAR(100) as ip_number,
        substr(sfl_file.linea, 29, 10)::VARCHAR(100) as account_short_name,
        substr(sfl_file.linea, 39, 2)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 41, 1)::VARCHAR(100) as record_transaction_code,
        substr(sfl_file.linea, 42, 1)::VARCHAR(100) as non_us_dollar_trading,
        substr(sfl_file.linea, 43, 3)::VARCHAR(100) as base_currency,
        substr(sfl_file.linea, 46, 3)::VARCHAR(100) as income_currency,
        substr(sfl_file.linea, 49, 3)::VARCHAR(100) as statement_language,
        substr(sfl_file.linea, 52, 3)::VARCHAR(100) as statement_format_code,
        substr(sfl_file.linea, 55, 1)::VARCHAR(100) as msrb_statement_ind,
        substr(sfl_file.linea, 56, 6)::VARCHAR(100) as campo_17,
        substr(sfl_file.linea, 62, 1)::VARCHAR(100) as pep,
        substr(sfl_file.linea, 63, 25)::VARCHAR(100) as first_name_pep,
        substr(sfl_file.linea, 88, 25)::VARCHAR(100) as last_name_pep,
        substr(sfl_file.linea, 113, 4)::VARCHAR(100) as suffix_pep,
        substr(sfl_file.linea, 117, 35)::VARCHAR(100) as political_office_held,
        substr(sfl_file.linea, 152, 2)::VARCHAR(100) as country_of_office,
        substr(sfl_file.linea, 154, 1)::VARCHAR(100) as foreign_bank_account_ind,
        substr(sfl_file.linea, 155, 8)::VARCHAR(100) as foreign_bank_cert_date,
        substr(sfl_file.linea, 163, 8)::VARCHAR(100) as foreign_bank_cert_exp_date,
        substr(sfl_file.linea, 171, 1)::VARCHAR(100) as central_bank_ind,
        substr(sfl_file.linea, 172, 1)::VARCHAR(100) as acct_foreign_financial_inst,
        substr(sfl_file.linea, 173, 1)::VARCHAR(100) as foreign_bank_acct_oper_1,
        substr(sfl_file.linea, 174, 1)::VARCHAR(100) as foreign_bank_acct_oper_2,
        substr(sfl_file.linea, 175, 1)::VARCHAR(100) as foreign_bank_acct_oper_3,
        substr(sfl_file.linea, 176, 2)::VARCHAR(100) as number_people_own,
        substr(sfl_file.linea, 178, 1)::VARCHAR(100) as proprietary_acct_owned,
        substr(sfl_file.linea, 179, 3)::VARCHAR(100) as campo_34,
        substr(sfl_file.linea, 182, 1)::VARCHAR(100) as tel_1_transaction_code,
        substr(sfl_file.linea, 183, 1)::VARCHAR(100) as tel_1_us_ind,
        substr(sfl_file.linea, 184, 1)::VARCHAR(100) as tel_1_type_id,
        substr(sfl_file.linea, 185, 48)::VARCHAR(100) as tel_1_number,
        substr(sfl_file.linea, 233, 7)::VARCHAR(100) as tel_1_extension,
        substr(sfl_file.linea, 240, 1)::VARCHAR(100) as tel_2_transaction_code,
        substr(sfl_file.linea, 241, 1)::VARCHAR(100) as tel_2_us_ind,
        substr(sfl_file.linea, 242, 1)::VARCHAR(100) as tel_2_type_id,
        substr(sfl_file.linea, 243, 48)::VARCHAR(100) as tel_2_number,
        substr(sfl_file.linea, 291, 7)::VARCHAR(100) as tel_2_extension,
        substr(sfl_file.linea, 298, 1)::VARCHAR(100) as tel_3_transaction_code,
        substr(sfl_file.linea, 299, 1)::VARCHAR(100) as tel_3_us_ind,
        substr(sfl_file.linea, 300, 1)::VARCHAR(100) as tel_3_type_id,
        substr(sfl_file.linea, 301, 48)::VARCHAR(100) as tel_3_number,
        substr(sfl_file.linea, 349, 7)::VARCHAR(100) as tel_3_extension,
        substr(sfl_file.linea, 356, 1)::VARCHAR(100) as tel_4_transaction_code,
        substr(sfl_file.linea, 357, 1)::VARCHAR(100) as tel_4_us_ind,
        substr(sfl_file.linea, 358, 1)::VARCHAR(100) as tel_4_type_id,
        substr(sfl_file.linea, 359, 48)::VARCHAR(100) as tel_4_number,
        substr(sfl_file.linea, 407, 7)::VARCHAR(100) as tel_4_extension,
        substr(sfl_file.linea, 414, 1)::VARCHAR(100) as tel_5_transaction_code,
        substr(sfl_file.linea, 415, 1)::VARCHAR(100) as tel_5_us_ind,
        substr(sfl_file.linea, 416, 1)::VARCHAR(100) as tel_5_type_id,
        substr(sfl_file.linea, 417, 48)::VARCHAR(100) as tel_5_number,
        substr(sfl_file.linea, 465, 7)::VARCHAR(100) as tel_5_extension,
        substr(sfl_file.linea, 472, 1)::VARCHAR(100) as tel_6_transaction_code,
        substr(sfl_file.linea, 473, 1)::VARCHAR(100) as tel_6_us_ind,
        substr(sfl_file.linea, 474, 1)::VARCHAR(100) as tel_6_type_id,
        substr(sfl_file.linea, 475, 48)::VARCHAR(100) as tel_6_number,
        substr(sfl_file.linea, 523, 7)::VARCHAR(100) as tel_6_extension,
        substr(sfl_file.linea, 530, 1)::VARCHAR(100) as tel_7_transaction_code,
        substr(sfl_file.linea, 531, 1)::VARCHAR(100) as tel_7_us_ind,
        substr(sfl_file.linea, 532, 1)::VARCHAR(100) as tel_7_type_id,
        substr(sfl_file.linea, 533, 48)::VARCHAR(100) as tel_7_number,
        substr(sfl_file.linea, 581, 7)::VARCHAR(100) as tel_7_extension,
        substr(sfl_file.linea, 588, 1)::VARCHAR(100) as tel_8_transaction_code,
        substr(sfl_file.linea, 589, 1)::VARCHAR(100) as tel_8_us_ind,
        substr(sfl_file.linea, 590, 1)::VARCHAR(100) as tel_8_type_id,
        substr(sfl_file.linea, 591, 48)::VARCHAR(100) as tel_8_number,
        substr(sfl_file.linea, 639, 7)::VARCHAR(100) as tel_8_extension,
        substr(sfl_file.linea, 646, 50)::VARCHAR(100) as email_address,
        substr(sfl_file.linea, 696, 1)::VARCHAR(100) as external_position_ind,
        substr(sfl_file.linea, 697, 1)::VARCHAR(100) as purge_eligible_ind,
        substr(sfl_file.linea, 698, 1)::VARCHAR(100) as advisory_acct_ind,
        substr(sfl_file.linea, 699, 4)::VARCHAR(100) as product_profile_code,
        substr(sfl_file.linea, 703, 2)::VARCHAR(100) as cents_per_share_discount,
        substr(sfl_file.linea, 705, 10)::VARCHAR(100) as campo_81,
        substr(sfl_file.linea, 715, 8)::VARCHAR(100) as option_disclosure_date,
        substr(sfl_file.linea, 723, 23)::VARCHAR(100) as campo_83,
        substr(sfl_file.linea, 746, 4)::VARCHAR(100) as country_acct_level_tax_residency,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CIW'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_extrae_acct_reg_trailer(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, eof character varying, campo_02 character varying, campo_03 character varying, date_of_data character varying, campo_05 character varying, remote_id character varying, campo_07 character varying, campo_08 character varying, number_of_detail_records character varying, campo_10 character varying, refreshed_or_updated character varying, campo_12 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 18)::VARCHAR(100) as eof,
        substr(sfl_file.linea, 19, 18)::VARCHAR(100) as campo_02,
        substr(sfl_file.linea, 37, 10)::VARCHAR(100) as campo_03,
        substr(sfl_file.linea, 47, 10)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 57, 11)::VARCHAR(100) as campo_05,
        substr(sfl_file.linea, 68, 4)::VARCHAR(100) as remote_id,
        substr(sfl_file.linea, 72, 12)::VARCHAR(100) as campo_07,
        substr(sfl_file.linea, 84, 22)::VARCHAR(100) as campo_08,
        substr(sfl_file.linea, 106, 10)::VARCHAR(100) as number_of_detail_records,
        substr(sfl_file.linea, 116, 3)::VARCHAR(100) as campo_10,
        substr(sfl_file.linea, 119, 9)::VARCHAR(100) as refreshed_or_updated,
        substr(sfl_file.linea, 128, 622)::VARCHAR(100) as campo_12,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CIW'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_acct_reg_header(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_header
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        fn_reg.id::bigint, fn_reg.id_proceso::bigint, fn_reg.process_date::VARCHAR(100),
        fn_reg.bof::VARCHAR(100),
        fn_reg.campo_2::VARCHAR(100),
        fn_reg.campo_3::VARCHAR(100),
        fn_reg.date_of_data::VARCHAR(100),
        fn_reg.campo_5::VARCHAR(100),
        fn_reg.remote_id::VARCHAR(100),
        fn_reg.campo_7::VARCHAR(100),
        fn_reg.run_date::VARCHAR(100),
        fn_reg.campo_9::VARCHAR(100),
        fn_reg.run_time::VARCHAR(100),
        fn_reg.campo_11::VARCHAR(100),
        fn_reg.refreshed_or_updated::VARCHAR(100),
        fn_reg.campo_13::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_header(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_acct_reg_a(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_a
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        fn_reg.id::BIGINT, fn_reg.id_proceso::BIGINT, fn_reg.process_date::VARCHAR(100),
        fn_reg.transaction_code::VARCHAR(100),
        fn_reg.record_indicator_value::VARCHAR(100),
        fn_reg.record_id_sequence_number::int as record_id_sequence_number,
        fn_reg.account_number::VARCHAR(100),
        fn_reg.ibd_number::VARCHAR(100),
        fn_reg.campo_6::VARCHAR(100),
        fn_reg.ip_number::VARCHAR(100),
        fn_reg.account_short_name::VARCHAR(100),
        fn_reg.campo_9::VARCHAR(100),
        fn_reg.transaction_type::VARCHAR(100),
        fn_reg.autotitled_usertitled_account::VARCHAR(100),
        fn_reg.account_type_code::VARCHAR(100),
        fn_reg.registration_type::VARCHAR(100),
        fn_reg.campo_14::VARCHAR(100),
        fn_reg.number_of_account_title_lines::VARCHAR(100),
        fn_reg.account_registration_line_1::VARCHAR(100),
        fn_reg.account_registration_line_2::VARCHAR(100),
        fn_reg.account_registration_line_3::VARCHAR(100),
        fn_reg.account_registration_line_4::VARCHAR(100),
        fn_reg.account_registration_line_5::VARCHAR(100),
        fn_reg.account_registration_line_6::VARCHAR(100),
        fn_reg.registration_type_detail::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_account_opened, 'CCYYMMDD')::DATE as date_account_opened,
        public.fn_fecha_string_to_date(fn_reg.date_account_information_updated, 'CCYYMMDD')::DATE as date_account_information_updated,
        fn_reg.account_status_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.pending_closed_date, 'CCYYMMDD')::DATE as pending_closed_date,
        public.fn_fecha_string_to_date(fn_reg.date_account_closed, 'CCYYMMDD')::DATE as date_account_closed,
        public.fn_fecha_string_to_date(fn_reg.closing_notice_date, 'CCYYMMDD')::DATE as closing_notice_date,
        public.fn_fecha_string_to_date(fn_reg.account_reactivated_date, 'CCYYMMDD')::DATE as account_reactivated_date,
        public.fn_fecha_string_to_date(fn_reg.date_account_reopened, 'CCYYMMDD')::DATE as date_account_reopened,
        fn_reg.proceeds::VARCHAR(100),
        fn_reg.transfer_instructions::VARCHAR(100),
        fn_reg.income_isntructions::VARCHAR(100),
        fn_reg.number_of_confirms_for_thi_account::VARCHAR(100),
        fn_reg.number_of_statements_for_this_account::VARCHAR(100),
        fn_reg.investment_objetive_trans_code::VARCHAR(100),
        fn_reg.comments_act::VARCHAR(100),
        fn_reg.employer_shotname::VARCHAR(100),
        fn_reg.employers_cusip::VARCHAR(100),
        fn_reg.employers_symbol::VARCHAR(100),
        fn_reg.margin_privileges_revoked::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.statement_review_date, 'CCYYMMDD')::DATE as statement_review_date,
        fn_reg.margin_papers_on_file::VARCHAR(100),
        fn_reg.option_papers_on_file::VARCHAR(100),
        fn_reg.campo_45::VARCHAR(100),
        fn_reg.good_faith_margin::VARCHAR(100),
        fn_reg.ip_discretion_granted::VARCHAR(100),
        fn_reg.invest_advisor_discretion_granted::VARCHAR(100),
        fn_reg.third_party_discretion_granted::VARCHAR(100),
        fn_reg.third_party_name::VARCHAR(100),
        fn_reg.risk_factor_code::VARCHAR(100),
        fn_reg.investment_objetive_code::VARCHAR(100),
        fn_reg.option_equities::VARCHAR(100),
        fn_reg.option_index::VARCHAR(100),
        fn_reg.option_debt::VARCHAR(100),
        fn_reg.option_currency::VARCHAR(100),
        fn_reg.option_level_1::VARCHAR(100),
        fn_reg.option_level_2::VARCHAR(100),
        fn_reg.option_level_3::VARCHAR(100),
        fn_reg.option_level_4::VARCHAR(100),
        CASE WHEN trim(fn_reg.option_call_limits)='' THEN NULL ELSE fn_reg.option_call_limits END::int as option_call_limits,
        CASE WHEN trim(fn_reg.option_put_limits)='' THEN NULL ELSE fn_reg.option_put_limits END::int as option_put_limits,
        CASE WHEN trim(fn_reg.option_total_limits_of_puts_and_calls)='' THEN NULL ELSE fn_reg.option_total_limits_of_puts_and_calls END::int as option_total_limits_of_puts_and_calls,
        fn_reg.non_us_dollar_trading::VARCHAR(100),
        fn_reg.campo_65::VARCHAR(100),
        fn_reg.non_customer_indicator::VARCHAR(100),
        fn_reg.third_party_fee_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.third_party_fee_approval_date, 'CCYYMMDD')::DATE as third_party_fee_approval_date,
        fn_reg.intermediary_account_ind::VARCHAR(100),
        fn_reg.commission_schedule::VARCHAR(100),
        fn_reg.group_index::VARCHAR(100),
        fn_reg.money_manager_id::VARCHAR(100),
        fn_reg.money_manager_objective_id::VARCHAR(100),
        fn_reg.dtc_id_confirm_number::VARCHAR(100),
        fn_reg.caps_master_mnemonic::VARCHAR(100),
        fn_reg.employee_id::VARCHAR(100),
        fn_reg.prime_broker_free_fund_indicator::VARCHAR(100),
        fn_reg.fee_based_account_indicator::VARCHAR(100),
        fn_reg.campo_79::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.fee_based_termination_date, 'CCYYMMDD')::DATE as fee_based_termination_date,
        fn_reg.campo_81::VARCHAR(100),
        fn_reg.plan_name::VARCHAR(100),
        fn_reg.self_directed_401_k_account_type::VARCHAR(100),
        fn_reg.plan_type::VARCHAR(100),
        fn_reg.plan_number::VARCHAR(100),
        fn_reg.employee_or_employee_relative::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(fn_reg.commission_percent_discount, 9)::NUMERIC(45,20) as commission_percent_discount,
        fn_reg.ind_12_b_1_fee_blocking::VARCHAR(100),
        fn_reg.name_of_ip_signed_new_account_form::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_of_ip_signed_new_account_form, 'CCYYMMDD')::DATE as date_of_ip_signed_new_account_form,
        fn_reg.name_of_principal_signed_new_account_form::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_of_principal_signed_new_account_form, 'CCYYMMDD')::DATE as date_of_principal_signed_new_account_form,
        fn_reg.politically_exposed_person::VARCHAR(100),
        fn_reg.private_banking_account::VARCHAR(100),
        fn_reg.foreign_bank_account::VARCHAR(100),
        fn_reg.initial_source_of_funds::VARCHAR(100),
        fn_reg.usa_patriot_act_exempt_reason::VARCHAR(100),
        fn_reg.primary_country_of_citizenship::VARCHAR(100),
        fn_reg.country_of_residence::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.birth_date, 'CCYYMMDD')::DATE as birth_date,
        fn_reg.age_based_fund_roll_exempt::VARCHAR(100),
        fn_reg.money_fundreform_retail::VARCHAR(100),
        fn_reg.trusted_contact_status::VARCHAR(100),
        fn_reg.regulatory_account_type_category::VARCHAR(100),
        fn_reg.account_managed_by_trust_comp_id::VARCHAR(100),
        fn_reg.voting_auth::VARCHAR(100),
        fn_reg.campo_107::VARCHAR(100),
        fn_reg.campo_108::VARCHAR(100),
        fn_reg.campo_109::VARCHAR(100),
        fn_reg.campo_110::VARCHAR(100),
        fn_reg.customer_type::VARCHAR(100),
        fn_reg.campo_112::VARCHAR(100),
        fn_reg.campo_113::VARCHAR(100),
        fn_reg.campo_114::VARCHAR(100),
        fn_reg.campo_115::VARCHAR(100),
        fn_reg.campo_116::VARCHAR(100),
        fn_reg.fulfillment_method::VARCHAR(100),
        fn_reg.credit_interest_indicator::VARCHAR(100),
        fn_reg.ama_indicator::VARCHAR(100),
        fn_reg.campo_120::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_a(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_acct_reg_b(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_b
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        fn_reg.id::BIGINT, fn_reg.id_proceso::BIGINT, fn_reg.process_date::VARCHAR(100),
        fn_reg.transaction_code::VARCHAR(100),
        fn_reg.record_indicator_value::VARCHAR(100),
        fn_reg.record_id_sequence_number::int as record_id_sequence_number,
        fn_reg.account_number::VARCHAR(100),
        fn_reg.ibd_number::VARCHAR(100),
        fn_reg.campo_6::VARCHAR(100),
        fn_reg.ip_number::VARCHAR(100),
        fn_reg.account_short_name::VARCHAR(100),
        fn_reg.campo_9::VARCHAR(100),
        fn_reg.tax_id_type::VARCHAR(100),
        fn_reg.tax_id_number::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_tax_id_applied_for, 'CCYYMMDD')::DATE as date_tax_id_applied_for,
        fn_reg.w_8_w_9_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.w_8_w_9_date_signed, 'CCYYMMDD')::DATE as w_8_w_9_date_signed,
        public.fn_fecha_string_to_date(fn_reg.w_8_w_9_effective_date, 'CCYYMMDD')::DATE as w_8_w_9_effective_date,
        fn_reg.w_8_w_9_document_type::VARCHAR(100),
        fn_reg.tax_status::VARCHAR(100),
        fn_reg.b_notice_reason_code::VARCHAR(100),
        fn_reg.first_b_notice_status::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_first_b_notice_status_issued_enforced, 'CCYYMMDD')::DATE as date_first_b_notice_status_issued_enforced,
        fn_reg.campo_21::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_first_notice_status_satisfied, 'CCYYMMDD')::DATE as date_first_notice_status_satisfied,
        fn_reg.second_b_notice_status::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_second_b_notice_status_issued_enforced, 'CCYYMMDD')::DATE as date_second_b_notice_status_issued_enforced,
        fn_reg.campo_25::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_second_b_notice_status_satisfied, 'CCYYMMDD')::DATE as date_second_b_notice_status_satisfied,
        fn_reg.c_notice_status::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_c_notice_status_issued_enforced, 'CCYYMMDD')::DATE as date_c_notice_status_issued_enforced,
        public.fn_fecha_string_to_date(fn_reg.date_c_notice_status_satisfied, 'CCYYMMDD')::DATE as date_c_notice_status_satisfied,
        fn_reg.old_account_number::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.original_account_open_date, 'CCYYMMDD')::DATE as original_account_open_date,
        fn_reg.unidentified_large_trader_id::VARCHAR(100),
        fn_reg.campo_33::VARCHAR(100),
        fn_reg.large_trader_type_code::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.large_trader_type_last_change_date, 'CCYYMMDD')::DATE as large_trader_type_last_change_date,
        fn_reg.campo_36::VARCHAR(100),
        fn_reg.campo_37::VARCHAR(100),
        fn_reg.initial_source_of_funds_other::VARCHAR(100),
        fn_reg.finance_away::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.account_funding_date, 'CCYYMMDD')::DATE as account_funding_date,
        fn_reg.campo_41::VARCHAR(100),
        fn_reg.statement_currency_code::VARCHAR(100),
        fn_reg.future_statement_currency_code::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.future_statement_currency_code_effective_date, 'CCYYMMDD')::DATE as future_statement_currency_code_effective_date,
        fn_reg.account_level_routing_code_1::VARCHAR(100),
        fn_reg.account_level_routing_code_2::VARCHAR(100),
        fn_reg.account_level_routing_code_3::VARCHAR(100),
        fn_reg.account_level_routing_code_4::VARCHAR(100),
        fn_reg.campo_49::VARCHAR(100),
        fn_reg.self_directed_ind::VARCHAR(100),
        fn_reg.digital_advice_ind::VARCHAR(100),
        fn_reg.pte_account_ind::VARCHAR(100),
        fn_reg.campo_53::VARCHAR(100),
        fn_reg.first_ip::VARCHAR(100),
        fn_reg.second_ip::VARCHAR(100),
        fn_reg.third_ip::VARCHAR(100),
        fn_reg.fourth_ip::VARCHAR(100),
        fn_reg.fifth_ip::VARCHAR(100),
        fn_reg.sixth_ip::VARCHAR(100),
        fn_reg.seventh_ip::VARCHAR(100),
        fn_reg.eighth_ip::VARCHAR(100),
        fn_reg.ninth_ip::VARCHAR(100),
        fn_reg.tenth_ip::VARCHAR(100),
        fn_reg.alert_im_acornym::VARCHAR(100),
        fn_reg.alert_im_access_code::VARCHAR(100),
        fn_reg.broker_acronym::VARCHAR(100),
        fn_reg.cross_reference_indicator::VARCHAR(100),
        fn_reg.bny_trust_indicator::VARCHAR(100),
        fn_reg.source_of_asset_at_acct_opening::VARCHAR(100),
        fn_reg.commission_doscount_code::VARCHAR(100),
        fn_reg.external_account_number::VARCHAR(100),
        fn_reg.confirmation_suppression_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_last_mail_sent, 'CCYYMM')::DATE as date_last_mail_sent,
        public.fn_fecha_string_to_date(fn_reg.date_last_mail_sent_outside, 'CCYYMM')::DATE as date_last_mail_sent_outside,
        fn_reg.campo_75::VARCHAR(100),
        fn_reg.fully_paid_lending_agreement_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.fully_paid_lending_agreement_date, 'CCYYMMDD')::DATE as fully_paid_lending_agreement_date,
        fn_reg.custodian_account_type::VARCHAR(100),
        fn_reg.mifid_customer_categorization::VARCHAR(100),
        fn_reg.cash_management_tran_code::VARCHAR(100),
        fn_reg.sweep_status_indicator::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.date_sweep_activated, 'CCYYMMDD')::DATE as date_sweep_activated,
        public.fn_fecha_string_to_date(fn_reg.date_sweep_details_changed, 'CCYYMMDD')::DATE as date_sweep_details_changed,
        fn_reg.cober_margin_debit_indicator::VARCHAR(100),
        fn_reg.campo_85::VARCHAR(100),
        fn_reg.first_fund_sweep_account_id::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(fn_reg.firstfund_sweep_account_percent, 9)::NUMERIC(45,20) as firstfund_sweep_account_percent,
        fn_reg.first_fundsweep_account_redemption_priority::VARCHAR(100),
        fn_reg.second_fund_sweep_account_id::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(fn_reg.second_fund_sweep_account_percent, 9)::NUMERIC(45,20) as second_fund_sweep_account_percent,
        fn_reg.second_fundsweep_account_redemption_priority::VARCHAR(100),
        fn_reg.type_of_bank_account::VARCHAR(100),
        fn_reg.banklink_aba_number::VARCHAR(100),
        fn_reg.banklink_dda_number::VARCHAR(100),
        fn_reg.campo_95::VARCHAR(100),
        fn_reg.fund_bank_indicator::VARCHAR(100),
        fn_reg.campo_97::VARCHAR(100),
        fn_reg.w_9_corp_tax_classification_code::VARCHAR(100),
        fn_reg.campo_99::VARCHAR(100),
        fn_reg.combined_margin_acct_indicator::VARCHAR(100),
        fn_reg.pledge_collateral_account_indicator::VARCHAR(100),
        fn_reg.finra_institutional_account_code::VARCHAR(100),
        fn_reg.proposed_account_reference_id::VARCHAR(100),
        fn_reg.advisor_model_id::VARCHAR(100),
        fn_reg.firm_model_style_id::VARCHAR(100),
        fn_reg.campo_106::VARCHAR(100),
        fn_reg.campo_107::VARCHAR(100),
        fn_reg.campo_108::VARCHAR(100),
        fn_reg.dvp_restriction_code::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.dvp_restriction_exp_date, 'CCYYMMDD')::DATE as dvp_restriction_exp_date,
        fn_reg.escheatment_withholding_ind::VARCHAR(100),
        fn_reg.campo_112::VARCHAR(100),
        fn_reg.source_of_origination::VARCHAR(100),
        fn_reg.source_of_persona::VARCHAR(100),
        fn_reg.client_onboarding_method::VARCHAR(100),
        fn_reg.tax_filing_code::VARCHAR(100),
        fn_reg.campo_117::VARCHAR(100),
        fn_reg.campo_118::VARCHAR(100),
        fn_reg.nor_purpose_collateral_acct_ind::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_b(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_acct_reg_c(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_c
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        fn_reg.id::BIGINT, fn_reg.id_proceso::BIGINT, fn_reg.process_date::VARCHAR(100),
        fn_reg.transaction_code::VARCHAR(100),
        fn_reg.record_indicator_value::VARCHAR(100),
        fn_reg.record_id_sequence_number::int as record_id_sequence_number,
        fn_reg.account_number::VARCHAR(100),
        fn_reg.ibd_number::VARCHAR(100),
        fn_reg.campo_6::VARCHAR(100),
        fn_reg.ip_number::VARCHAR(100),
        fn_reg.account_short_name::VARCHAR(100),
        fn_reg.campo_9::VARCHAR(100),
        fn_reg.addr_1_trx_code::VARCHAR(100),
        fn_reg.addr_1_special_handling_ind::VARCHAR(100),
        fn_reg.addr_1_delivery_id::VARCHAR(100),
        fn_reg.addr_1_attention_line_prefix::VARCHAR(100),
        fn_reg.addr_1_attention_line_detail::VARCHAR(100),
        fn_reg.addr_1_line_1::VARCHAR(100),
        fn_reg.addr_1_line_2::VARCHAR(100),
        fn_reg.addr_1_line_3::VARCHAR(100),
        fn_reg.addr_1_line_4::VARCHAR(100),
        fn_reg.addr_1_city_state::VARCHAR(100),
        fn_reg.addr_1_country_code::VARCHAR(100),
        fn_reg.campo_21::VARCHAR(100),
        fn_reg.campo_22::VARCHAR(100),
        fn_reg.campo_23::VARCHAR(100),
        fn_reg.campo_24::VARCHAR(100),
        fn_reg.campo_25::VARCHAR(100),
        fn_reg.campo_26::VARCHAR(100),
        fn_reg.campo_27::VARCHAR(100),
        fn_reg.campo_28::VARCHAR(100),
        fn_reg.campo_29::VARCHAR(100),
        fn_reg.campo_30::VARCHAR(100),
        fn_reg.addr_2_trx_code::VARCHAR(100),
        fn_reg.addr_2_special_handling_ind::VARCHAR(100),
        fn_reg.addr_2_delivery_id::VARCHAR(100),
        fn_reg.addr_2_attention_line_prefix::VARCHAR(100),
        fn_reg.addr_2_attention_line_detail::VARCHAR(100),
        fn_reg.addr_2_line_1::VARCHAR(100),
        fn_reg.addr_2_line_2::VARCHAR(100),
        fn_reg.addr_2_line_3::VARCHAR(100),
        fn_reg.addr_2_line_4::VARCHAR(100),
        fn_reg.addr_2_city_state::VARCHAR(100),
        fn_reg.addr_2_country_code::VARCHAR(100),
        fn_reg.account_description::VARCHAR(100),
        fn_reg.set_as_mail_addr_2_ind::VARCHAR(100),
        fn_reg.campo_44::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(fn_reg.principal_billing_allocation_pct, 9)::NUMERIC(45,20) as principal_billing_allocation_pct,
        fn_reg.campo_46::VARCHAR(100),
        fn_reg.seasonal_addr_id_1::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.from_date_1, 'CCYYMMDD')::DATE as from_date_1,
        public.fn_fecha_string_to_date(fn_reg.to_date_1, 'CCYYMMDD')::DATE as to_date_1,
        fn_reg.seasonal_addr_id_2::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.from_date_2, 'CCYYMMDD')::DATE as from_date_2,
        public.fn_fecha_string_to_date(fn_reg.to_date_2, 'CCYYMMDD')::DATE as to_date_2,
        fn_reg.seasonal_addr_id_3::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.from_date_3, 'CCYYMMDD')::DATE as from_date_3,
        public.fn_fecha_string_to_date(fn_reg.to_date_3, 'CCYYMMDD')::DATE as to_date_3,
        fn_reg.cost_basis_acct_system::VARCHAR(100),
        fn_reg.disposition_method_mutual_funds::VARCHAR(100),
        fn_reg.disposition_method_other::VARCHAR(100),
        fn_reg.disposition_method_stocks::VARCHAR(100),
        fn_reg.campo_60::VARCHAR(100),
        fn_reg.amortize_taxable_premium_bonds::VARCHAR(100),
        fn_reg.accrue_market_disc_based_on::VARCHAR(100),
        fn_reg.accrue_market_disc_income::VARCHAR(100),
        fn_reg.campo_64::VARCHAR(100),
        fn_reg.campo_65::VARCHAR(100),
        fn_reg.campo_66::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_c(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_acct_reg_d(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_d
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        fn_reg.id::BIGINT, fn_reg.id_proceso::BIGINT, fn_reg.process_date::VARCHAR(100),
        fn_reg.transaction_code::VARCHAR(100),
        fn_reg.record_indicator_value::VARCHAR(100),
        fn_reg.record_id_sequence_number::int as record_id_sequence_number,
        fn_reg.account_number::VARCHAR(100),
        fn_reg.ibd_number::VARCHAR(100),
        fn_reg.campo_6::VARCHAR(100),
        fn_reg.ip_number::VARCHAR(100),
        fn_reg.account_short_name::VARCHAR(100),
        fn_reg.campo_9::VARCHAR(100),
        fn_reg.addr_3_trx_code::VARCHAR(100),
        fn_reg.addr_3_special_handling_ind::VARCHAR(100),
        fn_reg.addr_3_delivery_id::VARCHAR(100),
        fn_reg.addr_3_attention_line_prefix::VARCHAR(100),
        fn_reg.addr_3_attention_line_detail::VARCHAR(100),
        fn_reg.addr_3_line_1::VARCHAR(100),
        fn_reg.addr_3_line_2::VARCHAR(100),
        fn_reg.addr_3_line_3::VARCHAR(100),
        fn_reg.addr_3_line_4::VARCHAR(100),
        fn_reg.addr_3_city_state::VARCHAR(100),
        fn_reg.addr_3_country_code::VARCHAR(100),
        fn_reg.set_as_mail_addr_3_ind::VARCHAR(100),
        fn_reg.campo_22::VARCHAR(100),
        fn_reg.addr_4_trx_code::VARCHAR(100),
        fn_reg.addr_4_special_handling_ind::VARCHAR(100),
        fn_reg.addr_4_delivery_id::VARCHAR(100),
        fn_reg.addr_4_attention_line_prefix::VARCHAR(100),
        fn_reg.addr_4_attention_line_detail::VARCHAR(100),
        fn_reg.addr_4_line_1::VARCHAR(100),
        fn_reg.addr_4_line_2::VARCHAR(100),
        fn_reg.addr_4_line_3::VARCHAR(100),
        fn_reg.addr_4_line_4::VARCHAR(100),
        fn_reg.addr_4_city_state::VARCHAR(100),
        fn_reg.addr_4_country_code::VARCHAR(100),
        fn_reg.set_as_mail_addr_4_ind::VARCHAR(100),
        fn_reg.campo_35::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_d(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_acct_reg_e(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_e
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        fn_reg.id::bigint, fn_reg.id_proceso::bigint, fn_reg.process_date::VARCHAR(100),
        fn_reg.transaction_code::VARCHAR(100),
        fn_reg.record_indicator_value::VARCHAR(100),
        fn_reg.record_id_sequence_number::int as record_id_sequence_number,
        fn_reg.account_number::VARCHAR(100),
        fn_reg.ibd_number::VARCHAR(100),
        fn_reg.campo_6::VARCHAR(100),
        fn_reg.ip_number::VARCHAR(100),
        fn_reg.account_short_name::VARCHAR(100),
        fn_reg.campo_9::VARCHAR(100),
        fn_reg.addr_5_trx_code::VARCHAR(100),
        fn_reg.addr_5_special_handling_ind::VARCHAR(100),
        fn_reg.addr_5_delivery_id::VARCHAR(100),
        fn_reg.addr_5_attention_line_prefix::VARCHAR(100),
        fn_reg.addr_5_attention_line_detail::VARCHAR(100),
        fn_reg.addr_5_line_1::VARCHAR(100),
        fn_reg.addr_5_line_2::VARCHAR(100),
        fn_reg.addr_5_line_3::VARCHAR(100),
        fn_reg.addr_5_line_4::VARCHAR(100),
        fn_reg.addr_5_city_state::VARCHAR(100),
        fn_reg.addr_5_country_code::VARCHAR(100),
        fn_reg.set_as_mail_addr_5_ind::VARCHAR(100),
        fn_reg.campo_22::VARCHAR(100),
        fn_reg.addr_6_trx_code::VARCHAR(100),
        fn_reg.addr_6_special_handling_ind::VARCHAR(100),
        fn_reg.addr_6_delivery_id::VARCHAR(100),
        fn_reg.addr_6_attention_line_prefix::VARCHAR(100),
        fn_reg.addr_6_attention_line_detail::VARCHAR(100),
        fn_reg.addr_6_line_1::VARCHAR(100),
        fn_reg.addr_6_line_2::VARCHAR(100),
        fn_reg.addr_6_line_3::VARCHAR(100),
        fn_reg.addr_6_line_4::VARCHAR(100),
        fn_reg.addr_6_city_state::VARCHAR(100),
        fn_reg.addr_6_country_code::VARCHAR(100),
        fn_reg.set_as_mail_addr_6_ind::VARCHAR(100),
        fn_reg.campo_35::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_e(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_acct_reg_f(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_f
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        fn_reg.id::bigint, fn_reg.id_proceso::bigint, fn_reg.process_date::VARCHAR(100),
        fn_reg.transaction_code::VARCHAR(100),
        fn_reg.record_indicator_value::VARCHAR(100),
        fn_reg.record_id_sequence_number::int as record_id_sequence_number,
        fn_reg.account_number::VARCHAR(100),
        fn_reg.ibd_number::VARCHAR(100),
        fn_reg.campo_6::VARCHAR(100),
        fn_reg.ip_number::VARCHAR(100),
        fn_reg.account_short_name::VARCHAR(100),
        fn_reg.campo_9::VARCHAR(100),
        fn_reg.addr_7_trx_code::VARCHAR(100),
        fn_reg.addr_7_special_handling_ind::VARCHAR(100),
        fn_reg.addr_7_delivery_id::VARCHAR(100),
        fn_reg.addr_7_attention_line_prefix::VARCHAR(100),
        fn_reg.addr_7_attention_line_detail::VARCHAR(100),
        fn_reg.addr_7_line_1::VARCHAR(100),
        fn_reg.addr_7_line_2::VARCHAR(100),
        fn_reg.addr_7_line_3::VARCHAR(100),
        fn_reg.addr_7_line_4::VARCHAR(100),
        fn_reg.addr_7_city_state::VARCHAR(100),
        fn_reg.addr_7_country_code::VARCHAR(100),
        fn_reg.set_as_mail_addr_7_ind::VARCHAR(100),
        fn_reg.campo_22::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_f(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_acct_reg_w(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_w
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        fn_reg.id::BIGINT, fn_reg.id_proceso::BIGINT, fn_reg.process_date::VARCHAR(100),
        fn_reg.transaction_code::VARCHAR(100),
        fn_reg.record_indicator_value::VARCHAR(100),
        fn_reg.record_id_sequence_number::int as record_id_sequence_number,
        fn_reg.account_number::VARCHAR(100),
        fn_reg.ibd_number::VARCHAR(100),
        fn_reg.campo_6::VARCHAR(100),
        fn_reg.ip_number::VARCHAR(100),
        fn_reg.account_short_name::VARCHAR(100),
        fn_reg.campo_9::VARCHAR(100),
        fn_reg.record_transaction_code::VARCHAR(100),
        fn_reg.non_us_dollar_trading::VARCHAR(100),
        fn_reg.base_currency::VARCHAR(100),
        fn_reg.income_currency::VARCHAR(100),
        fn_reg.statement_language::VARCHAR(100),
        fn_reg.statement_format_code::VARCHAR(100),
        fn_reg.msrb_statement_ind::VARCHAR(100),
        fn_reg.campo_17::VARCHAR(100),
        fn_reg.pep::VARCHAR(100),
        fn_reg.first_name_pep::VARCHAR(100),
        fn_reg.last_name_pep::VARCHAR(100),
        fn_reg.suffix_pep::VARCHAR(100),
        fn_reg.political_office_held::VARCHAR(100),
        fn_reg.country_of_office::VARCHAR(100),
        fn_reg.foreign_bank_account_ind::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.foreign_bank_cert_date, 'CCYYMMDD')::DATE as foreign_bank_cert_date,
        public.fn_fecha_string_to_date(fn_reg.foreign_bank_cert_exp_date, 'CCYYMMDD')::DATE as foreign_bank_cert_exp_date,
        fn_reg.central_bank_ind::VARCHAR(100),
        fn_reg.acct_foreign_financial_inst::VARCHAR(100),
        fn_reg.foreign_bank_acct_oper_1::VARCHAR(100),
        fn_reg.foreign_bank_acct_oper_2::VARCHAR(100),
        fn_reg.foreign_bank_acct_oper_3::VARCHAR(100),
        fn_reg.number_people_own::VARCHAR(100),
        fn_reg.proprietary_acct_owned::VARCHAR(100),
        fn_reg.campo_34::VARCHAR(100),
        fn_reg.tel_1_transaction_code::VARCHAR(100),
        fn_reg.tel_1_us_ind::VARCHAR(100),
        fn_reg.tel_1_type_id::VARCHAR(100),
        fn_reg.tel_1_number::VARCHAR(100),
        fn_reg.tel_1_extension::VARCHAR(100),
        fn_reg.tel_2_transaction_code::VARCHAR(100),
        fn_reg.tel_2_us_ind::VARCHAR(100),
        fn_reg.tel_2_type_id::VARCHAR(100),
        fn_reg.tel_2_number::VARCHAR(100),
        fn_reg.tel_2_extension::VARCHAR(100),
        fn_reg.tel_3_transaction_code::VARCHAR(100),
        fn_reg.tel_3_us_ind::VARCHAR(100),
        fn_reg.tel_3_type_id::VARCHAR(100),
        fn_reg.tel_3_number::VARCHAR(100),
        fn_reg.tel_3_extension::VARCHAR(100),
        fn_reg.tel_4_transaction_code::VARCHAR(100),
        fn_reg.tel_4_us_ind::VARCHAR(100),
        fn_reg.tel_4_type_id::VARCHAR(100),
        fn_reg.tel_4_number::VARCHAR(100),
        fn_reg.tel_4_extension::VARCHAR(100),
        fn_reg.tel_5_transaction_code::VARCHAR(100),
        fn_reg.tel_5_us_ind::VARCHAR(100),
        fn_reg.tel_5_type_id::VARCHAR(100),
        fn_reg.tel_5_number::VARCHAR(100),
        fn_reg.tel_5_extension::VARCHAR(100),
        fn_reg.tel_6_transaction_code::VARCHAR(100),
        fn_reg.tel_6_us_ind::VARCHAR(100),
        fn_reg.tel_6_type_id::VARCHAR(100),
        fn_reg.tel_6_number::VARCHAR(100),
        fn_reg.tel_6_extension::VARCHAR(100),
        fn_reg.tel_7_transaction_code::VARCHAR(100),
        fn_reg.tel_7_us_ind::VARCHAR(100),
        fn_reg.tel_7_type_id::VARCHAR(100),
        fn_reg.tel_7_number::VARCHAR(100),
        fn_reg.tel_7_extension::VARCHAR(100),
        fn_reg.tel_8_transaction_code::VARCHAR(100),
        fn_reg.tel_8_us_ind::VARCHAR(100),
        fn_reg.tel_8_type_id::VARCHAR(100),
        fn_reg.tel_8_number::VARCHAR(100),
        fn_reg.tel_8_extension::VARCHAR(100),
        fn_reg.email_address::VARCHAR(100),
        fn_reg.external_position_ind::VARCHAR(100),
        fn_reg.purge_eligible_ind::VARCHAR(100),
        fn_reg.advisory_acct_ind::VARCHAR(100),
        fn_reg.product_profile_code::VARCHAR(100),
        CASE WHEN trim(fn_reg.cents_per_share_discount)='' THEN NULL ELSE fn_reg.cents_per_share_discount END::int as cents_per_share_discount,
        fn_reg.campo_81::VARCHAR(100),
        public.fn_fecha_string_to_date(fn_reg.option_disclosure_date, 'CCYYMMDD')::DATE as option_disclosure_date,
        fn_reg.campo_83::VARCHAR(100),
        fn_reg.country_acct_level_tax_residency::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_w(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

create function stage_pershing.fn_parse_acct_reg_trailer(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_trailer
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        fn_reg.id::bigint, fn_reg.id_proceso::bigint, fn_reg.process_date::VARCHAR(100),
        fn_reg.eof::VARCHAR(100),
        fn_reg.campo_02::VARCHAR(100),
        fn_reg.campo_03::VARCHAR(100),
        fn_reg.date_of_data::VARCHAR(100),
        fn_reg.campo_05::VARCHAR(100),
        fn_reg.remote_id::VARCHAR(100),
        fn_reg.campo_07::VARCHAR(100),
        fn_reg.campo_08::VARCHAR(100),
        fn_reg.number_of_detail_records::int as number_of_detail_records,
        fn_reg.campo_10::VARCHAR(100),
        fn_reg.refreshed_or_updated::VARCHAR(100),
        fn_reg.campo_12::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_trailer(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

create procedure stage_pershing.pa_parse_acct(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
begin

    DELETE FROM stage_pershing.stage_acct_reg_header reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_acct_reg_a reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_acct_reg_b reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_acct_reg_c reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_acct_reg_d reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_acct_reg_e reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_acct_reg_f reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_acct_reg_w reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_acct_reg_trailer reg_del WHERE reg_del.id_proceso=_id_proceso;

    INSERT INTO stage_pershing.stage_acct_reg_header (id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, refreshed_or_updated, campo_13, eor)
    SELECT fn_reg.id_proceso, fn_reg.process_date, fn_reg.bof, fn_reg.campo_2, fn_reg.campo_3, fn_reg.date_of_data, fn_reg.campo_5, fn_reg.remote_id, fn_reg.campo_7, fn_reg.run_date, fn_reg.campo_9, fn_reg.run_time, fn_reg.campo_11, fn_reg.refreshed_or_updated, fn_reg.campo_13, fn_reg.eor
    FROM stage_pershing.fn_parse_acct_reg_header(_id_proceso) fn_reg;

    INSERT INTO stage_pershing.stage_acct_reg_a (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, ibd_number, campo_6, ip_number, account_short_name, campo_9, transaction_type, autotitled_usertitled_account, account_type_code, registration_type, campo_14, number_of_account_title_lines, account_registration_line_1, account_registration_line_2, account_registration_line_3, account_registration_line_4, account_registration_line_5, account_registration_line_6, registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions, income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked, statement_review_date, margin_papers_on_file, option_papers_on_file, campo_45, good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted, third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits, option_total_limits_of_puts_and_calls, non_us_dollar_trading, campo_65, non_customer_indicator, third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule, group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic, employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, campo_79, fee_based_termination_date, campo_81, plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative, commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form, date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form, date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account, foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, primary_country_of_citizenship, country_of_residence, birth_date, age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status, regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, campo_107, campo_108, campo_109, campo_110, customer_type, campo_112, campo_113, campo_114, campo_115, campo_116, fulfillment_method, credit_interest_indicator, ama_indicator, campo_120, eor)
    SELECT fn_reg.id_proceso, fn_reg.process_date, fn_reg.transaction_code, fn_reg.record_indicator_value, fn_reg.record_id_sequence_number, fn_reg.account_number, fn_reg.ibd_number, fn_reg.campo_6, fn_reg.ip_number, fn_reg.account_short_name, fn_reg.campo_9, fn_reg.transaction_type, fn_reg.autotitled_usertitled_account, fn_reg.account_type_code, fn_reg.registration_type, fn_reg.campo_14, fn_reg.number_of_account_title_lines, fn_reg.account_registration_line_1, fn_reg.account_registration_line_2, fn_reg.account_registration_line_3, fn_reg.account_registration_line_4, fn_reg.account_registration_line_5, fn_reg.account_registration_line_6, fn_reg.registration_type_detail, fn_reg.date_account_opened, fn_reg.date_account_information_updated, fn_reg.account_status_indicator, fn_reg.pending_closed_date, fn_reg.date_account_closed, fn_reg.closing_notice_date, fn_reg.account_reactivated_date, fn_reg.date_account_reopened, fn_reg.proceeds, fn_reg.transfer_instructions, fn_reg.income_isntructions, fn_reg.number_of_confirms_for_thi_account, fn_reg.number_of_statements_for_this_account, fn_reg.investment_objetive_trans_code, fn_reg.comments_act, fn_reg.employer_shotname, fn_reg.employers_cusip, fn_reg.employers_symbol, fn_reg.margin_privileges_revoked, fn_reg.statement_review_date, fn_reg.margin_papers_on_file, fn_reg.option_papers_on_file, fn_reg.campo_45, fn_reg.good_faith_margin, fn_reg.ip_discretion_granted, fn_reg.invest_advisor_discretion_granted, fn_reg.third_party_discretion_granted, fn_reg.third_party_name, fn_reg.risk_factor_code, fn_reg.investment_objetive_code, fn_reg.option_equities, fn_reg.option_index, fn_reg.option_debt, fn_reg.option_currency, fn_reg.option_level_1, fn_reg.option_level_2, fn_reg.option_level_3, fn_reg.option_level_4, fn_reg.option_call_limits, fn_reg.option_put_limits, fn_reg.option_total_limits_of_puts_and_calls, fn_reg.non_us_dollar_trading, fn_reg.campo_65, fn_reg.non_customer_indicator, fn_reg.third_party_fee_indicator, fn_reg.third_party_fee_approval_date, fn_reg.intermediary_account_ind, fn_reg.commission_schedule, fn_reg.group_index, fn_reg.money_manager_id, fn_reg.money_manager_objective_id, fn_reg.dtc_id_confirm_number, fn_reg.caps_master_mnemonic, fn_reg.employee_id, fn_reg.prime_broker_free_fund_indicator, fn_reg.fee_based_account_indicator, fn_reg.campo_79, fn_reg.fee_based_termination_date, fn_reg.campo_81, fn_reg.plan_name, fn_reg.self_directed_401_k_account_type, fn_reg.plan_type, fn_reg.plan_number, fn_reg.employee_or_employee_relative, fn_reg.commission_percent_discount, fn_reg.ind_12_b_1_fee_blocking, fn_reg.name_of_ip_signed_new_account_form, fn_reg.date_of_ip_signed_new_account_form, fn_reg.name_of_principal_signed_new_account_form, fn_reg.date_of_principal_signed_new_account_form, fn_reg.politically_exposed_person, fn_reg.private_banking_account, fn_reg.foreign_bank_account, fn_reg.initial_source_of_funds, fn_reg.usa_patriot_act_exempt_reason, fn_reg.primary_country_of_citizenship, fn_reg.country_of_residence, fn_reg.birth_date, fn_reg.age_based_fund_roll_exempt, fn_reg.money_fundreform_retail, fn_reg.trusted_contact_status, fn_reg.regulatory_account_type_category, fn_reg.account_managed_by_trust_comp_id, fn_reg.voting_auth, fn_reg.campo_107, fn_reg.campo_108, fn_reg.campo_109, fn_reg.campo_110, fn_reg.customer_type, fn_reg.campo_112, fn_reg.campo_113, fn_reg.campo_114, fn_reg.campo_115, fn_reg.campo_116, fn_reg.fulfillment_method, fn_reg.credit_interest_indicator, fn_reg.ama_indicator, fn_reg.campo_120, fn_reg.eor
    FROM stage_pershing.fn_parse_acct_reg_a(_id_proceso) fn_reg;

    INSERT INTO stage_pershing.stage_acct_reg_b (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, ibd_number, campo_6, ip_number, account_short_name, campo_9, tax_id_type, tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced, campo_21, date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced, campo_25, date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced, date_c_notice_status_satisfied, old_account_number, original_account_open_date, unidentified_large_trader_id, campo_33, large_trader_type_code, large_trader_type_last_change_date, campo_36, campo_37, initial_source_of_funds_other, finance_away, account_funding_date, campo_41, statement_currency_code, future_statement_currency_code, future_statement_currency_code_effective_date, account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3, account_level_routing_code_4, campo_49, self_directed_ind, digital_advice_ind, pte_account_ind, campo_53, first_ip, second_ip, third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym, alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator, source_of_asset_at_acct_opening, commission_doscount_code, external_account_number, confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside, campo_75, fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type, mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated, date_sweep_details_changed, cober_margin_debit_indicator, campo_85, first_fund_sweep_account_id, firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id, second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account, banklink_aba_number, banklink_dda_number, campo_95, fund_bank_indicator, campo_97, w_9_corp_tax_classification_code, campo_99, combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code, proposed_account_reference_id, advisor_model_id, firm_model_style_id, campo_106, campo_107, campo_108, dvp_restriction_code, dvp_restriction_exp_date, escheatment_withholding_ind, campo_112, source_of_origination, source_of_persona, client_onboarding_method, tax_filing_code, campo_117, campo_118, nor_purpose_collateral_acct_ind, eor)
    SELECT fn_reg.id_proceso, fn_reg.process_date, fn_reg.transaction_code, fn_reg.record_indicator_value, fn_reg.record_id_sequence_number, fn_reg.account_number, fn_reg.ibd_number, fn_reg.campo_6, fn_reg.ip_number, fn_reg.account_short_name, fn_reg.campo_9, fn_reg.tax_id_type, fn_reg.tax_id_number, fn_reg.date_tax_id_applied_for, fn_reg.w_8_w_9_indicator, fn_reg.w_8_w_9_date_signed, fn_reg.w_8_w_9_effective_date, fn_reg.w_8_w_9_document_type, fn_reg.tax_status, fn_reg.b_notice_reason_code, fn_reg.first_b_notice_status, fn_reg.date_first_b_notice_status_issued_enforced, fn_reg.campo_21, fn_reg.date_first_notice_status_satisfied, fn_reg.second_b_notice_status, fn_reg.date_second_b_notice_status_issued_enforced, fn_reg.campo_25, fn_reg.date_second_b_notice_status_satisfied, fn_reg.c_notice_status, fn_reg.date_c_notice_status_issued_enforced, fn_reg.date_c_notice_status_satisfied, fn_reg.old_account_number, fn_reg.original_account_open_date, fn_reg.unidentified_large_trader_id, fn_reg.campo_33, fn_reg.large_trader_type_code, fn_reg.large_trader_type_last_change_date, fn_reg.campo_36, fn_reg.campo_37, fn_reg.initial_source_of_funds_other, fn_reg.finance_away, fn_reg.account_funding_date, fn_reg.campo_41, fn_reg.statement_currency_code, fn_reg.future_statement_currency_code, fn_reg.future_statement_currency_code_effective_date, fn_reg.account_level_routing_code_1, fn_reg.account_level_routing_code_2, fn_reg.account_level_routing_code_3, fn_reg.account_level_routing_code_4, fn_reg.campo_49, fn_reg.self_directed_ind, fn_reg.digital_advice_ind, fn_reg.pte_account_ind, fn_reg.campo_53, fn_reg.first_ip, fn_reg.second_ip, fn_reg.third_ip, fn_reg.fourth_ip, fn_reg.fifth_ip, fn_reg.sixth_ip, fn_reg.seventh_ip, fn_reg.eighth_ip, fn_reg.ninth_ip, fn_reg.tenth_ip, fn_reg.alert_im_acornym, fn_reg.alert_im_access_code, fn_reg.broker_acronym, fn_reg.cross_reference_indicator, fn_reg.bny_trust_indicator, fn_reg.source_of_asset_at_acct_opening, fn_reg.commission_doscount_code, fn_reg.external_account_number, fn_reg.confirmation_suppression_indicator, fn_reg.date_last_mail_sent, fn_reg.date_last_mail_sent_outside, fn_reg.campo_75, fn_reg.fully_paid_lending_agreement_indicator, fn_reg.fully_paid_lending_agreement_date, fn_reg.custodian_account_type, fn_reg.mifid_customer_categorization, fn_reg.cash_management_tran_code, fn_reg.sweep_status_indicator, fn_reg.date_sweep_activated, fn_reg.date_sweep_details_changed, fn_reg.cober_margin_debit_indicator, fn_reg.campo_85, fn_reg.first_fund_sweep_account_id, fn_reg.firstfund_sweep_account_percent, fn_reg.first_fundsweep_account_redemption_priority, fn_reg.second_fund_sweep_account_id, fn_reg.second_fund_sweep_account_percent, fn_reg.second_fundsweep_account_redemption_priority, fn_reg.type_of_bank_account, fn_reg.banklink_aba_number, fn_reg.banklink_dda_number, fn_reg.campo_95, fn_reg.fund_bank_indicator, fn_reg.campo_97, fn_reg.w_9_corp_tax_classification_code, fn_reg.campo_99, fn_reg.combined_margin_acct_indicator, fn_reg.pledge_collateral_account_indicator, fn_reg.finra_institutional_account_code, fn_reg.proposed_account_reference_id, fn_reg.advisor_model_id, fn_reg.firm_model_style_id, fn_reg.campo_106, fn_reg.campo_107, fn_reg.campo_108, fn_reg.dvp_restriction_code, fn_reg.dvp_restriction_exp_date, fn_reg.escheatment_withholding_ind, fn_reg.campo_112, fn_reg.source_of_origination, fn_reg.source_of_persona, fn_reg.client_onboarding_method, fn_reg.tax_filing_code, fn_reg.campo_117, fn_reg.campo_118, fn_reg.nor_purpose_collateral_acct_ind, fn_reg.eor
    FROM stage_pershing.fn_parse_acct_reg_b(_id_proceso) fn_reg;

    INSERT INTO stage_pershing.stage_acct_reg_c (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, ibd_number, campo_6, ip_number, account_short_name, campo_9, addr_1_trx_code, addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix, addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4, addr_1_city_state, addr_1_country_code, campo_21, campo_22, campo_23, campo_24, campo_25, campo_26, campo_27, campo_28, campo_29, campo_30, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id, addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3, addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind, campo_44, principal_billing_allocation_pct, campo_46, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2, from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system, disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks, campo_60, amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, campo_64, campo_65, campo_66, eor)
    SELECT fn_reg.id_proceso, fn_reg.process_date, fn_reg.transaction_code, fn_reg.record_indicator_value, fn_reg.record_id_sequence_number, fn_reg.account_number, fn_reg.ibd_number, fn_reg.campo_6, fn_reg.ip_number, fn_reg.account_short_name, fn_reg.campo_9, fn_reg.addr_1_trx_code, fn_reg.addr_1_special_handling_ind, fn_reg.addr_1_delivery_id, fn_reg.addr_1_attention_line_prefix, fn_reg.addr_1_attention_line_detail, fn_reg.addr_1_line_1, fn_reg.addr_1_line_2, fn_reg.addr_1_line_3, fn_reg.addr_1_line_4, fn_reg.addr_1_city_state, fn_reg.addr_1_country_code, fn_reg.campo_21, fn_reg.campo_22, fn_reg.campo_23, fn_reg.campo_24, fn_reg.campo_25, fn_reg.campo_26, fn_reg.campo_27, fn_reg.campo_28, fn_reg.campo_29, fn_reg.campo_30, fn_reg.addr_2_trx_code, fn_reg.addr_2_special_handling_ind, fn_reg.addr_2_delivery_id, fn_reg.addr_2_attention_line_prefix, fn_reg.addr_2_attention_line_detail, fn_reg.addr_2_line_1, fn_reg.addr_2_line_2, fn_reg.addr_2_line_3, fn_reg.addr_2_line_4, fn_reg.addr_2_city_state, fn_reg.addr_2_country_code, fn_reg.account_description, fn_reg.set_as_mail_addr_2_ind, fn_reg.campo_44, fn_reg.principal_billing_allocation_pct, fn_reg.campo_46, fn_reg.seasonal_addr_id_1, fn_reg.from_date_1, fn_reg.to_date_1, fn_reg.seasonal_addr_id_2, fn_reg.from_date_2, fn_reg.to_date_2, fn_reg.seasonal_addr_id_3, fn_reg.from_date_3, fn_reg.to_date_3, fn_reg.cost_basis_acct_system, fn_reg.disposition_method_mutual_funds, fn_reg.disposition_method_other, fn_reg.disposition_method_stocks, fn_reg.campo_60, fn_reg.amortize_taxable_premium_bonds, fn_reg.accrue_market_disc_based_on, fn_reg.accrue_market_disc_income, fn_reg.campo_64, fn_reg.campo_65, fn_reg.campo_66, fn_reg.eor
    FROM stage_pershing.fn_parse_acct_reg_c(_id_proceso) fn_reg;

    INSERT INTO stage_pershing.stage_acct_reg_d (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, ibd_number, campo_6, ip_number, account_short_name, campo_9, addr_3_trx_code, addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix, addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4, addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, campo_22, addr_4_trx_code, addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix, addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4, addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, campo_35, eor)
    SELECT fn_reg.id_proceso, fn_reg.process_date, fn_reg.transaction_code, fn_reg.record_indicator_value, fn_reg.record_id_sequence_number, fn_reg.account_number, fn_reg.ibd_number, fn_reg.campo_6, fn_reg.ip_number, fn_reg.account_short_name, fn_reg.campo_9, fn_reg.addr_3_trx_code, fn_reg.addr_3_special_handling_ind, fn_reg.addr_3_delivery_id, fn_reg.addr_3_attention_line_prefix, fn_reg.addr_3_attention_line_detail, fn_reg.addr_3_line_1, fn_reg.addr_3_line_2, fn_reg.addr_3_line_3, fn_reg.addr_3_line_4, fn_reg.addr_3_city_state, fn_reg.addr_3_country_code, fn_reg.set_as_mail_addr_3_ind, fn_reg.campo_22, fn_reg.addr_4_trx_code, fn_reg.addr_4_special_handling_ind, fn_reg.addr_4_delivery_id, fn_reg.addr_4_attention_line_prefix, fn_reg.addr_4_attention_line_detail, fn_reg.addr_4_line_1, fn_reg.addr_4_line_2, fn_reg.addr_4_line_3, fn_reg.addr_4_line_4, fn_reg.addr_4_city_state, fn_reg.addr_4_country_code, fn_reg.set_as_mail_addr_4_ind, fn_reg.campo_35, fn_reg.eor
    FROM stage_pershing.fn_parse_acct_reg_d(_id_proceso) fn_reg;

    INSERT INTO stage_pershing.stage_acct_reg_e (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, ibd_number, campo_6, ip_number, account_short_name, campo_9, addr_5_trx_code, addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix, addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4, addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, campo_22, addr_6_trx_code, addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix, addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4, addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, campo_35, eor)
    SELECT fn_reg.id_proceso, fn_reg.process_date, fn_reg.transaction_code, fn_reg.record_indicator_value, fn_reg.record_id_sequence_number, fn_reg.account_number, fn_reg.ibd_number, fn_reg.campo_6, fn_reg.ip_number, fn_reg.account_short_name, fn_reg.campo_9, fn_reg.addr_5_trx_code, fn_reg.addr_5_special_handling_ind, fn_reg.addr_5_delivery_id, fn_reg.addr_5_attention_line_prefix, fn_reg.addr_5_attention_line_detail, fn_reg.addr_5_line_1, fn_reg.addr_5_line_2, fn_reg.addr_5_line_3, fn_reg.addr_5_line_4, fn_reg.addr_5_city_state, fn_reg.addr_5_country_code, fn_reg.set_as_mail_addr_5_ind, fn_reg.campo_22, fn_reg.addr_6_trx_code, fn_reg.addr_6_special_handling_ind, fn_reg.addr_6_delivery_id, fn_reg.addr_6_attention_line_prefix, fn_reg.addr_6_attention_line_detail, fn_reg.addr_6_line_1, fn_reg.addr_6_line_2, fn_reg.addr_6_line_3, fn_reg.addr_6_line_4, fn_reg.addr_6_city_state, fn_reg.addr_6_country_code, fn_reg.set_as_mail_addr_6_ind, fn_reg.campo_35, fn_reg.eor
    FROM stage_pershing.fn_parse_acct_reg_e(_id_proceso) fn_reg;

    INSERT INTO stage_pershing.stage_acct_reg_f (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, ibd_number, campo_6, ip_number, account_short_name, campo_9, addr_7_trx_code, addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix, addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4, addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, campo_22, eor)
    SELECT fn_reg.id_proceso, fn_reg.process_date, fn_reg.transaction_code, fn_reg.record_indicator_value, fn_reg.record_id_sequence_number, fn_reg.account_number, fn_reg.ibd_number, fn_reg.campo_6, fn_reg.ip_number, fn_reg.account_short_name, fn_reg.campo_9, fn_reg.addr_7_trx_code, fn_reg.addr_7_special_handling_ind, fn_reg.addr_7_delivery_id, fn_reg.addr_7_attention_line_prefix, fn_reg.addr_7_attention_line_detail, fn_reg.addr_7_line_1, fn_reg.addr_7_line_2, fn_reg.addr_7_line_3, fn_reg.addr_7_line_4, fn_reg.addr_7_city_state, fn_reg.addr_7_country_code, fn_reg.set_as_mail_addr_7_ind, fn_reg.campo_22, fn_reg.eor
    FROM stage_pershing.fn_parse_acct_reg_f(_id_proceso) fn_reg;

    INSERT INTO stage_pershing.stage_acct_reg_w (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, ibd_number, campo_6, ip_number, account_short_name, campo_9, record_transaction_code, non_us_dollar_trading, base_currency, income_currency, statement_language, statement_format_code, msrb_statement_ind, campo_17, pep, first_name_pep, last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind, foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst, foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own, proprietary_acct_owned, campo_34, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension, tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code, tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind, tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id, tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number, tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension, tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address, external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code, cents_per_share_discount, campo_81, option_disclosure_date, campo_83, country_acct_level_tax_residency, eor)
    SELECT fn_reg.id_proceso, fn_reg.process_date, fn_reg.transaction_code, fn_reg.record_indicator_value, fn_reg.record_id_sequence_number, fn_reg.account_number, fn_reg.ibd_number, fn_reg.campo_6, fn_reg.ip_number, fn_reg.account_short_name, fn_reg.campo_9, fn_reg.record_transaction_code, fn_reg.non_us_dollar_trading, fn_reg.base_currency, fn_reg.income_currency, fn_reg.statement_language, fn_reg.statement_format_code, fn_reg.msrb_statement_ind, fn_reg.campo_17, fn_reg.pep, fn_reg.first_name_pep, fn_reg.last_name_pep, fn_reg.suffix_pep, fn_reg.political_office_held, fn_reg.country_of_office, fn_reg.foreign_bank_account_ind, fn_reg.foreign_bank_cert_date, fn_reg.foreign_bank_cert_exp_date, fn_reg.central_bank_ind, fn_reg.acct_foreign_financial_inst, fn_reg.foreign_bank_acct_oper_1, fn_reg.foreign_bank_acct_oper_2, fn_reg.foreign_bank_acct_oper_3, fn_reg.number_people_own, fn_reg.proprietary_acct_owned, fn_reg.campo_34, fn_reg.tel_1_transaction_code, fn_reg.tel_1_us_ind, fn_reg.tel_1_type_id, fn_reg.tel_1_number, fn_reg.tel_1_extension, fn_reg.tel_2_transaction_code, fn_reg.tel_2_us_ind, fn_reg.tel_2_type_id, fn_reg.tel_2_number, fn_reg.tel_2_extension, fn_reg.tel_3_transaction_code, fn_reg.tel_3_us_ind, fn_reg.tel_3_type_id, fn_reg.tel_3_number, fn_reg.tel_3_extension, fn_reg.tel_4_transaction_code, fn_reg.tel_4_us_ind, fn_reg.tel_4_type_id, fn_reg.tel_4_number, fn_reg.tel_4_extension, fn_reg.tel_5_transaction_code, fn_reg.tel_5_us_ind, fn_reg.tel_5_type_id, fn_reg.tel_5_number, fn_reg.tel_5_extension, fn_reg.tel_6_transaction_code, fn_reg.tel_6_us_ind, fn_reg.tel_6_type_id, fn_reg.tel_6_number, fn_reg.tel_6_extension, fn_reg.tel_7_transaction_code, fn_reg.tel_7_us_ind, fn_reg.tel_7_type_id, fn_reg.tel_7_number, fn_reg.tel_7_extension, fn_reg.tel_8_transaction_code, fn_reg.tel_8_us_ind, fn_reg.tel_8_type_id, fn_reg.tel_8_number, fn_reg.tel_8_extension, fn_reg.email_address, fn_reg.external_position_ind, fn_reg.purge_eligible_ind, fn_reg.advisory_acct_ind, fn_reg.product_profile_code, fn_reg.cents_per_share_discount, fn_reg.campo_81, fn_reg.option_disclosure_date, fn_reg.campo_83, fn_reg.country_acct_level_tax_residency, fn_reg.eor
    FROM stage_pershing.fn_parse_acct_reg_w(_id_proceso) fn_reg;

    INSERT INTO stage_pershing.stage_acct_reg_trailer (id_proceso, process_date, eof, campo_02, campo_03, date_of_data, campo_05, remote_id, campo_07, campo_08, number_of_detail_records, campo_10, refreshed_or_updated, campo_12, eor)
    SELECT fn_reg.id_proceso, fn_reg.process_date, fn_reg.eof, fn_reg.campo_02, fn_reg.campo_03, fn_reg.date_of_data, fn_reg.campo_05, fn_reg.remote_id, fn_reg.campo_07, fn_reg.campo_08, fn_reg.number_of_detail_records, fn_reg.campo_10, fn_reg.refreshed_or_updated, fn_reg.campo_12, fn_reg.eor
    FROM stage_pershing.fn_parse_acct_reg_trailer(_id_proceso) fn_reg;

end;
$$;





--========================================================================
--========================================================================
--========================================================================
--Crear tablas de schema pershing

create table pershing.estado_proceso_sfl
(
    id           integer      not null
        constraint estado_proceso_sfl_pk
            primary key,
    glosa_estado varchar(100) not null
);

create table pershing.proceso_sfl
(
    id                    bigint generated always as identity
        constraint proceso_sfl_pk
            primary key,
    process_date          varchar(100) not null,
    process_stamp         varchar(100) not null,
    start_timestamp       timestamp    not null,
    last_step_timestamp   timestamp    not null,
    info_log              varchar      not null,
    id_estado_proceso_sfl integer      not null
        constraint proceso_sfl_fk_estado_proceso_sfl
            references pershing.estado_proceso_sfl
);

create unique index proceso_sfl_index_ui
    on pershing.proceso_sfl (process_stamp, process_date);

create unique index proceso_sfl_ui_process_stamp
    on pershing.proceso_sfl (process_stamp);

create table pershing.sfl_isrc
(
    id                        bigint generated always as identity
        constraint sfl_isrc_pk
            primary key,
    id_proceso                bigint       not null,
    process_date              varchar(100) not null,
    record_secuence_id        varchar(100),
    record_id_number          integer,
    change_id                 varchar(100),
    source_code               varchar(100),
    source_code_desc_line_1   varchar(100),
    source_code_desc_line_2   varchar(100),
    source_code_desc_line_3   varchar(100),
    tax_status                varchar(100),
    user_id                   varchar(100),
    date_added                varchar(100),
    date_updated              varchar(100),
    ira_income_eligible       varchar(100),
    retail_income_eligible    varchar(100),
    customer_firm             varchar(100),
    cerdit_debit              varchar(100),
    statement_ind             varchar(100),
    statement_act_sum_ind     varchar(100),
    statement_act_sum_number  varchar(100),
    statement_trx_sum_ind     varchar(100),
    statement_trx_sum_number  varchar(100),
    statement_distrib_ind     varchar(100),
    statement_distrib_number  varchar(100),
    statement_distrib_tax_ind varchar(100),
    statement_div_ind         varchar(100),
    statement_div_number      varchar(100),
    statement_div_tax_ind     varchar(100),
    pershing_depart           varchar(100),
    pershing_grp              varchar(100),
    user_id_added             varchar(100),
    user_id_updated           varchar(100),
    portfolio_eligible_ind    varchar(100),
    reinvest_ind              varchar(100)
);

create unique index sfl_isrc_ui_source_code_fecha
    on pershing.sfl_isrc (process_date, source_code);

create unique index sfl_isrc_ui_source_code_proceso
    on pershing.sfl_isrc (id_proceso, source_code);

create table pershing.sfl_isca
(
    id                                              bigint generated always as identity
        constraint sfl_isca_pk
            primary key,
    id_proceso                                      bigint       not null,
    process_date                                    varchar(100) not null,
    cusip_number                                    varchar(100),
    security_type                                   varchar(100),
    security_modifier                               varchar(100),
    security_calculation_code                       varchar(100),
    primary_exchange                                varchar(100),
    coupon_rate_fis_or_indicated_dividend_eq        numeric(45, 20),
    maturity_option_expire_date                     date,
    underlying_security_cusip                       varchar(100),
    first_call_price_fix_inc_or_strike_price_option numeric(45, 20),
    first_par_call_price_fix_inc_or_units_option    numeric(45, 20),
    primary_symbol                                  varchar(100),
    interest_frequency                              varchar(100),
    bond_class                                      varchar(100),
    first_coupon_day                                varchar(100),
    call_indicator                                  varchar(100),
    put_indicator                                   varchar(100),
    next_par_call_date                              date,
    prerefunded_date                                date,
    next_premium_call_date                          date,
    dated_date_for_fix_inc_or_ex_dividend_date_eq   date,
    first_coupon_fix_inc_or_payable_date_eq         date,
    federal_marginable_ind                          varchar(100),
    cns_eligible_code                               varchar(100),
    dtcc_eligible_code                              varchar(100),
    nscc_eligible_code                              varchar(100),
    foreign_security                                varchar(100),
    second_coupon_day                               varchar(100),
    dividend_interest_payment_method                varchar(100),
    minor_product_code                              varchar(100),
    etf_indicator                                   varchar(100),
    bid_price                                       numeric(45, 20),
    ask_price                                       numeric(45, 20),
    previous_day_price                              numeric(45, 20),
    latest_price                                    numeric(45, 20),
    end_of_month_price                              numeric(45, 20),
    round_lot_quantity                              integer,
    dividend_reinvestment_eligibility_indicator     varchar(100),
    previous_price_date                             date,
    latest_price_date                               date,
    end_of_month_price_date                         date,
    record_date                                     date,
    fundvest_ind                                    varchar(100),
    country_code                                    varchar(100),
    standard_poor_rating                            varchar(100),
    moodys_rating                                   varchar(100),
    bond_sub_class                                  varchar(100),
    restriction_indicator                           varchar(100),
    trace_indicator                                 varchar(100),
    new_interest_calculation_code                   varchar(100),
    sic_code                                        varchar(100),
    state_tax_ind                                   varchar(100),
    fts_ind                                         varchar(100),
    amt_ind                                         varchar(100),
    ric_indicator                                   varchar(100),
    number_of_description_lines                     varchar(100),
    secutiry_description_line_1                     varchar(100),
    secutiry_description_line_2                     varchar(100),
    secutiry_description_line_3                     varchar(100),
    secutiry_description_line_4                     varchar(100),
    secutiry_description_line_5                     varchar(100),
    user_cusip_identifier                           varchar(100),
    price_purge_date                                date,
    taxable_indicator                               varchar(100),
    secutiry_description_line_6                     varchar(100),
    put_price                                       numeric(45, 20),
    put_date                                        date,
    second_premium_call_price                       numeric(45, 20),
    second_premium_call_date                        date,
    called_date                                     date,
    pool_number                                     varchar(100),
    factor                                          numeric(45, 20),
    factor_date                                     date,
    previous_factor                                 varchar(100),
    previous_factor_date                            date,
    variable_rate_indicator                         varchar(100),
    next_last_coupon_date                           date,
    structured_product_ind                          varchar(100),
    perpetual_bond_indicator                        varchar(100),
    exp_first_call_price                            numeric(45, 20),
    exp_first_par_call_price                        numeric(45, 20),
    exp_put_price                                   numeric(45, 20),
    exp_second_premium_call_price                   numeric(45, 20),
    name_issuer_security                            varchar(100),
    issuing_currency                                varchar(100),
    globally_locked_sec_ind                         varchar(100),
    globally_locked_reason_code                     varchar(100),
    spac_ind                                        varchar(100),
    eor                                             varchar(100),
    expanded_bid_price                              numeric(45, 20),
    expanded_ask_price                              numeric(45, 20),
    expanded_previous_day_price                     numeric(45, 20),
    expanded_latest_price                           numeric(45, 20),
    expanded_end_of_month_price                     numeric(45, 20),
    contract_share_quantity                         numeric(45, 20),
    year_covered_under_cost_basis_rules             integer,
    delta                                           numeric(45, 20),
    delta_value_presence_ind                        varchar(100),
    isin_code                                       varchar(100),
    issuer_identifier                               varchar(100),
    symbol_of_the_underlying_security               varchar(100),
    asset_type                                      varchar(100),
    asset_subtype                                   varchar(100),
    asset_subsubtype                                varchar(100),
    payment_day_delays                              integer,
    exchange_rate_denom_currency_usd                numeric(45, 20),
    underlying_cusip_1                              varchar(100),
    deliverable_unit_quantity_1                     integer,
    underlying_cusip_2                              varchar(100),
    deliverable_unit_quantity_2                     integer,
    underlying_cusip_3                              varchar(100),
    deliverable_unit_quantity_3                     integer,
    underlying_cusip_4                              varchar(100),
    deliverable_unit_quantity_4                     integer,
    annual_dividend_currency_code                   varchar(100),
    outstanding_shares                              numeric(45, 20),
    option_root_id                                  varchar(100),
    expiration_date                                 date,
    call_put_indicator                              varchar(100),
    strike_price                                    numeric(45, 20),
    fund_type                                       varchar(100),
    broad_narrow_indicator                          varchar(100),
    leverage_factor                                 numeric(45, 20),
    outstanding_shares_update_date                  date,
    expanded_symbol                                 varchar(100),
    state_of_issuance                               varchar(100),
    option_excercise_pricing_model_code             varchar(100),
    first_accrual_date                              date,
    tranche_code                                    varchar(100),
    worthless_security_indicator                    varchar(100),
    uit_termination_code                            integer,
    fdic_certification_number                       varchar(100),
    revenue_stream                                  varchar(100),
    restricted_marijuana_ind                        varchar(100),
    factored_market_value_multiplier                numeric(45, 20),
    current_yield                                   numeric(45, 20),
    yield                                           numeric(45, 20),
    price_source                                    varchar(100),
    country_of_origin                               varchar(100),
    retricted_security_code                         varchar(100),
    international_non_dollar_symbol                 varchar(100),
    international_exchange                          varchar(100),
    variable_rate_category_code                     varchar(100),
    interest_rate_completion_ind                    varchar(100),
    exchange_code_sedol_1                           varchar(100),
    sedol_1                                         varchar(100),
    exchange_code_sedol_2                           varchar(100),
    sedol_2                                         varchar(100),
    exchange_code_sedol_3                           varchar(100),
    sedol_3                                         varchar(100),
    exchange_code_sedol_4                           varchar(100),
    sedol_4                                         varchar(100),
    exchange_code_sedol_5                           varchar(100),
    sedol_5                                         varchar(100),
    exchange_code_sedol_6                           varchar(100),
    sedol_6                                         varchar(100),
    exchange_code_sedol_7                           varchar(100),
    sedol_7                                         varchar(100),
    exchange_code_sedol_8                           varchar(100),
    sedol_8                                         varchar(100),
    exchange_code_sedol_9                           varchar(100),
    sedol_9                                         varchar(100),
    exchange_code_sedol_10                          varchar(100),
    sedol_10                                        varchar(100),
    exchange_code_sedol_11                          varchar(100),
    sedol_11                                        varchar(100),
    primary_idc_mkt_exch                            varchar(100),
    primary_mkt_exch_trading_status                 varchar(100),
    primary_mkt_symbol                              varchar(100),
    primary_mkt_exch_effective_date                 date,
    primary_mkt_status_code                         varchar(100),
    secondary_idc_mkt_exch                          varchar(100),
    secondary_mkt_exch_trading_status               varchar(100),
    secondary_mkt_symbol                            varchar(100),
    secondary_mkt_exch_effective_date               date,
    secondary_mkt_status_code                       varchar(100),
    tick_size_pilot_group                           varchar(100),
    tick_size_effective_date                        date,
    tick_size_change_date                           date,
    update_date                                     date,
    oas_libor_rate                                  numeric(45, 20),
    first_call_date                                 date,
    first_call_price                                numeric(45, 20),
    second_call_date                                date,
    second_call_price                               numeric(45, 20),
    third_call_date                                 date,
    third_call_price                                numeric(45, 20),
    fourth_call_date                                date,
    fourth_call_price                               numeric(45, 20),
    effective_date_rate_1                           date,
    coupon_interest_rate_1                          numeric(45, 20),
    effective_date_rate_2                           date,
    coupon_interest_rate_2                          numeric(45, 20),
    effective_date_rate_3                           date,
    coupon_interest_rate_3                          numeric(45, 20),
    effective_date_rate_4                           date,
    coupon_interest_rate_4                          numeric(45, 20),
    oas_treasury_rate                               numeric(45, 20),
    oas_treasury_effective_date                     date,
    minimum_piece                                   numeric(45, 20),
    minimum_increment                               numeric(45, 20),
    issue_date_security                             date
);

create unique index sfl_isca_ui_cusip_fecha
    on pershing.sfl_isca (process_date, cusip_number);

create unique index sfl_isca_ui_cusip_proceso
    on pershing.sfl_isca (id_proceso, cusip_number);

create table pershing.sfl_gact
(
    id                                       bigint generated always as identity
        constraint sfl_gact_pk
            primary key,
    id_proceso                               bigint       not null,
    process_date                             varchar(100) not null,
    record_id_sequence_number                integer,
    account_number                           varchar(100),
    cusip_number                             varchar(100),
    underlying_cusip                         varchar(100),
    security_symbol                          varchar(100),
    investment_professional_of_record        varchar(100),
    executing_investment_professional        varchar(100),
    transaction_type                         varchar(100),
    buy_sell_code                            varchar(100),
    open_close_indicator                     varchar(100),
    par_key_code                             varchar(100),
    source_code                              varchar(100),
    maxx_key_code                            integer,
    process_date_sfl                         date,
    trade_date                               date,
    settlement_entry_date                    date,
    source_of_input                          varchar(100),
    reference_number                         varchar(100),
    batch_code                               varchar(100),
    same_day_settlement                      varchar(100),
    contra_account                           varchar(100),
    market_code                              varchar(100),
    blotter_code                             varchar(100),
    cancel_code                              varchar(100),
    correction_code                          varchar(100),
    merket_limit_indicator                   varchar(100),
    legend_code_1                            varchar(100),
    legend_code_2                            varchar(100),
    quantity                                 numeric(45, 20),
    price_in_trade_currency                  numeric(45, 20),
    currency_indicator_for_price             varchar(100),
    net_amount_in_usd                        numeric(45, 20),
    principal_in_usd                         numeric(45, 20),
    interest_in_usd                          numeric(45, 20),
    commision_in_usd                         numeric(45, 20),
    tax_in_usd                               numeric(45, 20),
    transaction_fee_in_usd                   numeric(45, 20),
    misc_fee_in_usd                          numeric(45, 20),
    other_fee_in_usd                         numeric(45, 20),
    tefra_wh_amount_in_usd                   numeric(45, 20),
    pershing_charge_in_usd                   numeric(45, 20),
    brokerage_charge_in_usd                  numeric(45, 20),
    sales_credit_in_usd                      numeric(45, 20),
    settlement_fee_in_usd                    numeric(45, 20),
    service_charge_in_usd                    numeric(45, 20),
    markup_markdown_amount_in_usd            numeric(45, 20),
    dividend_payable_date                    date,
    dividend_record_date                     date,
    dividend_type                            integer,
    shares_of_record_quantity_for_dividends  numeric(45, 20),
    order_size_quantity                      numeric(45, 20),
    pool_factor                              numeric(45, 20),
    parsed_customer_account_number           varchar(100),
    ibd_number                               varchar(100),
    security_type_code                       varchar(100),
    security_modifier_code                   varchar(100),
    security_calculation_code                varchar(100),
    minor_product_code                       varchar(100),
    foreign_product_indicator                varchar(100),
    with_due_bill_indicator                  varchar(100),
    taxable_municipal_bond_indicator         varchar(100),
    omnibus_indicator                        varchar(100),
    external_order_id                        varchar(100),
    market_value_of_transaction              numeric(45, 20),
    ip_number_parsed                         varchar(100),
    reported_price                           numeric(45, 20),
    previous_day_market_value_of_transaction numeric(45, 20),
    price_in_usd                             numeric(45, 20),
    option_root_id                           varchar(100),
    expiration_date                          date,
    put_call_code                            varchar(100),
    strike_price                             numeric(45, 20),
    repo_identifier                          varchar(100),
    taxable                                  varchar(100),
    qualified                                varchar(100),
    expanded_ip_number                       varchar(100),
    expanded_exec_ip_number                  varchar(100),
    expanded_legacy_ip_number                varchar(100),
    security_currency_of_issuance            varchar(100),
    trade_currency_code                      varchar(100),
    settlement_currency_code                 varchar(100),
    settlement_usd_currency_fx_rate          numeric(45, 20),
    settlement_usd_multiply_divide_code      varchar(100),
    cross_currency_fx_rate                   numeric(45, 20),
    currency_multiply_divide_code            varchar(100),
    accrued_interest_in_settlement_currency  numeric(45, 20),
    internal_reference_for_gloss             varchar(100),
    ibd_version                              varchar(100),
    net_amount_in_settlement_currency        numeric(45, 20),
    principal_amount_in_settlement_currency  numeric(45, 20),
    interest_in_settlement_currency          numeric(45, 20),
    commission_in_settlement_currency        numeric(45, 20),
    tax_in_settlement_currency               numeric(45, 20),
    transaction_fee_in_settlement_currency   numeric(45, 20),
    miscellaneous_fee_in_settlement_currency numeric(45, 20),
    other_fee_in_settlement_currency         numeric(45, 20),
    sales_credit_in_settlement_currency      numeric(45, 20),
    settlement_fee_in_settlement_currency    numeric(45, 20),
    service_charge_in_settlement_currency    numeric(45, 20),
    markup_markdown_in_settlement_currency   numeric(45, 20),
    global_exchange                          varchar(100),
    number_of_description_lines              integer,
    last_description_line                    integer,
    description_line_1                       varchar(100),
    description_line_2                       varchar(100),
    description_line_3                       varchar(100),
    description_line_4                       varchar(100),
    description_line_5                       varchar(100),
    description_line_6                       varchar(100),
    description_line_7                       varchar(100),
    description_line_8                       varchar(100),
    description_line_9                       varchar(100),
    description_line_10                      varchar(100),
    description_line_11                      varchar(100),
    description_line_12                      varchar(100),
    security_currency_indicator              varchar(100),
    market_mnemonic_code                     varchar(100),
    ccy_of_issuance_usd_ccy_fx_rate          numeric(45, 20),
    ccy_of_issuance_usd_multiply_divide_code varchar(100),
    alternate_security_id_type               varchar(100),
    alternate_security_id                    varchar(100),
    alternate_security_id_type_2             varchar(100),
    alternate_security_id_2                  varchar(100),
    international_non_dollar_symbol          varchar(100),
    confirmation_code_1                      varchar(100),
    confirmation_code_2                      varchar(100),
    confirmation_code_3                      varchar(100),
    confirmation_code_4                      varchar(100),
    pmp                                      numeric(45, 20),
    total_amount_mark_up_down                numeric(45, 20),
    pmp_percent                              numeric(45, 20)
);

create unique index sfl_gact_ui_record_id_fecha
    on pershing.sfl_gact (process_date, record_id_sequence_number);

create unique index sfl_gact_ui_record_id_proceso
    on pershing.sfl_gact (id_proceso, record_id_sequence_number);

create table pershing.sfl_gcus
(
    id                                                      bigint generated always as identity
        constraint sfl_gcus_pk
            primary key,
    id_proceso                                              bigint       not null,
    process_date                                            varchar(100) not null,
    record_id_sequence_number                               integer,
    account_number                                          varchar(100),
    cusip_number                                            varchar(100),
    portfolio_currency                                      varchar(100),
    underlying_cusip_number                                 varchar(100),
    country_code                                            varchar(100),
    ip_record_number                                        varchar(100),
    ibd_number                                              varchar(100),
    currency_security_indicator                             varchar(100),
    issue_currency                                          varchar(100),
    datestamp_trade_date                                    date,
    datestamp_settlement_date                               date,
    trade_date_quantity                                     numeric(45, 20),
    settlement_date_quantity                                numeric(45, 20),
    seg_quantity                                            numeric(45, 20),
    safekeeping_quantity                                    numeric(45, 20),
    transfer_quantity                                       numeric(45, 20),
    pending_transfer_quantity                               numeric(45, 20),
    legal_transfer_quantity                                 numeric(45, 20),
    tendered_quantity                                       numeric(45, 20),
    pending_papers                                          numeric(45, 20),
    short_against_the_box_quantity                          numeric(45, 20),
    networked_quantity                                      numeric(45, 20),
    pending_split_quantity                                  numeric(45, 20),
    quantity_covering_options                               numeric(45, 20),
    trade_date_quantity_bought                              numeric(45, 20),
    trade_date_quantity_sold                                numeric(45, 20),
    fed_rquirement                                          numeric(45, 20),
    house_margin_requirement                                numeric(45, 20),
    nyse_requirement                                        numeric(45, 20),
    equity_requirment                                       numeric(45, 20),
    security_symbol                                         varchar(100),
    security_type                                           varchar(100),
    security_mod                                            varchar(100),
    security_calc                                           varchar(100),
    minor_product_code                                      varchar(100),
    network_eligibility_indicator                           varchar(100),
    strike_price                                            numeric(45, 20),
    expiration_maturity_date                                date,
    contract_size                                           numeric(45, 20),
    conversion_ratio                                        numeric(45, 20),
    account_short_name                                      varchar(100),
    state_code                                              varchar(100),
    country_code_account                                    varchar(100),
    number_security_description_lines                       integer,
    security_description_line_1                             varchar(100),
    security_description_line_2                             varchar(100),
    security_description_line_3                             varchar(100),
    security_description_line_4                             varchar(100),
    security_description_line_5                             varchar(100),
    security_description_line_6                             varchar(100),
    dividend_option                                         varchar(100),
    long_term_capital_gains_option                          varchar(100),
    short_term_capital_gains_option                         varchar(100),
    firm_trading_indicator                                  varchar(100),
    position_currency_security                              varchar(100),
    trade_date_liquidating_value                            numeric(45, 20),
    pool_factor                                             numeric(45, 20),
    exchange_rate                                           numeric(45, 20),
    settlement_date_liquidating_value                       numeric(45, 20),
    alternate_security_id_type                              varchar(100),
    alternate_security_id                                   varchar(100),
    position_currency                                       varchar(100),
    fully_paid_lending_quantity                             numeric(45, 20),
    fully_paid_lending_quantity_collateral_amount           numeric(45, 20),
    option_root_id                                          varchar(100),
    expiration_date                                         date,
    call_put_indicator                                      varchar(100),
    trade_date_repo_quantity                                numeric(45, 20),
    settlement_date_repo_quantity                           numeric(45, 20),
    trade_date_reverse_repo_quantity                        numeric(45, 20),
    settlement_date_reverse_repo_quantity                   numeric(45, 20),
    collateral_pledge_quantity                              numeric(45, 20),
    corporate_exec_serv_collateral_pledge_quantity          numeric(45, 20),
    trade_date_repo_liquidating_value                       numeric(45, 20),
    settlement_date_repo_liquidating_value                  numeric(45, 20),
    trade_date_reverse_repo_liquidating_value               numeric(45, 20),
    settlement_date_reverse_repo_liquidating_value          numeric(45, 20),
    collateral_pledge_liquidating_value                     numeric(45, 20),
    corporate_exec_serv_collateral_pledge_liquidating_value numeric(45, 20),
    trade_date_repo_loan_amount                             numeric(45, 20),
    settlement_date_repo_loan_amount                        numeric(45, 20),
    trade_date_reverse_repo_loan_amount                     numeric(45, 20),
    settlement_date_reverse_repo_loan_amount                numeric(45, 20),
    accrued_interes_value                                   numeric(45, 20),
    dividend_or_coupon_rate                                 numeric(45, 20),
    pending_split_quantity_liquidating_value                numeric(45, 20),
    internal_non_dollar_symbol                              varchar(100),
    pledged_quantity                                        numeric(45, 20)
);

create unique index sfl_gcus_ui_cusip_fecha
    on pershing.sfl_gcus (process_date, account_number, cusip_number);

create unique index sfl_gcus_ui_cusip_proceso
    on pershing.sfl_gcus (id_proceso, account_number, cusip_number);

create table pershing.sfl_gmon
(
    id                        bigint generated always as identity
        constraint sfl_gmon_pk
            primary key,
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
    masked_house_call         numeric(45, 20)
);

create unique index sfl_gmon_ui_account_fecha
    on pershing.sfl_gmon (process_date, account_number);

create unique index sfl_gmon_ui_account_proceso
    on pershing.sfl_gmon (id_proceso, account_number);

create table pershing.maestro_sfl
(
    id                        varchar(100)          not null
        constraint maestro_sfl_pk
            primary key,
    flag_guardar_en_bd        boolean default false not null,
    flag_procesar_parse_en_bd boolean default false not null,
    filename                  varchar(100)          not null,
    flag_replicar_data        boolean default false not null
);

create unique index maestro_sfl_ui_filename
    on pershing.maestro_sfl (filename);

create table pershing.sfl_acct
(
    id                                            bigint generated always as identity
        constraint sfl_acct_pk
            primary key,
    id_proceso                                    bigint       not null,
    process_date                                  varchar(100) not null,
    record_id_sequence_number                     integer,
    account_number                                varchar(100),
    ibd_number                                    varchar(100),
    ip_number                                     varchar(100),
    account_short_name                            varchar(100),
    transaction_type                              varchar(100),
    autotitled_usertitled_account                 varchar(100),
    account_type_code                             varchar(100),
    registration_type                             varchar(100),
    number_of_account_title_lines                 varchar(100),
    account_registration_line_1                   varchar(100),
    account_registration_line_2                   varchar(100),
    account_registration_line_3                   varchar(100),
    account_registration_line_4                   varchar(100),
    account_registration_line_5                   varchar(100),
    account_registration_line_6                   varchar(100),
    registration_type_detail                      varchar(100),
    date_account_opened                           date,
    date_account_information_updated              date,
    account_status_indicator                      varchar(100),
    pending_closed_date                           date,
    date_account_closed                           date,
    closing_notice_date                           date,
    account_reactivated_date                      date,
    date_account_reopened                         date,
    proceeds                                      varchar(100),
    transfer_instructions                         varchar(100),
    income_isntructions                           varchar(100),
    number_of_confirms_for_thi_account            varchar(100),
    number_of_statements_for_this_account         varchar(100),
    investment_objetive_trans_code                varchar(100),
    comments_act                                  varchar(100),
    employer_shotname                             varchar(100),
    employers_cusip                               varchar(100),
    employers_symbol                              varchar(100),
    margin_privileges_revoked                     varchar(100),
    statement_review_date                         date,
    margin_papers_on_file                         varchar(100),
    option_papers_on_file                         varchar(100),
    good_faith_margin                             varchar(100),
    ip_discretion_granted                         varchar(100),
    invest_advisor_discretion_granted             varchar(100),
    third_party_discretion_granted                varchar(100),
    third_party_name                              varchar(100),
    risk_factor_code                              varchar(100),
    investment_objetive_code                      varchar(100),
    option_equities                               varchar(100),
    option_index                                  varchar(100),
    option_debt                                   varchar(100),
    option_currency                               varchar(100),
    option_level_1                                varchar(100),
    option_level_2                                varchar(100),
    option_level_3                                varchar(100),
    option_level_4                                varchar(100),
    option_call_limits                            integer,
    option_put_limits                             integer,
    option_total_limits_of_puts_and_calls         integer,
    non_us_dollar_trading                         varchar(100),
    non_customer_indicator                        varchar(100),
    third_party_fee_indicator                     varchar(100),
    third_party_fee_approval_date                 date,
    intermediary_account_ind                      varchar(100),
    commission_schedule                           varchar(100),
    group_index                                   varchar(100),
    money_manager_id                              varchar(100),
    money_manager_objective_id                    varchar(100),
    dtc_id_confirm_number                         varchar(100),
    caps_master_mnemonic                          varchar(100),
    employee_id                                   varchar(100),
    prime_broker_free_fund_indicator              varchar(100),
    fee_based_account_indicator                   varchar(100),
    fee_based_termination_date                    date,
    plan_name                                     varchar(100),
    self_directed_401_k_account_type              varchar(100),
    plan_type                                     varchar(100),
    plan_number                                   varchar(100),
    employee_or_employee_relative                 varchar(100),
    commission_percent_discount                   numeric(45, 20),
    ind_12_b_1_fee_blocking                       varchar(100),
    name_of_ip_signed_new_account_form            varchar(100),
    date_of_ip_signed_new_account_form            date,
    name_of_principal_signed_new_account_form     varchar(100),
    date_of_principal_signed_new_account_form     date,
    politically_exposed_person                    varchar(100),
    private_banking_account                       varchar(100),
    foreign_bank_account                          varchar(100),
    initial_source_of_funds                       varchar(100),
    usa_patriot_act_exempt_reason                 varchar(100),
    primary_country_of_citizenship                varchar(100),
    country_of_residence                          varchar(100),
    birth_date                                    date,
    age_based_fund_roll_exempt                    varchar(100),
    money_fundreform_retail                       varchar(100),
    trusted_contact_status                        varchar(100),
    regulatory_account_type_category              varchar(100),
    account_managed_by_trust_comp_id              varchar(100),
    voting_auth                                   varchar(100),
    customer_type                                 varchar(100),
    fulfillment_method                            varchar(100),
    credit_interest_indicator                     varchar(100),
    ama_indicator                                 varchar(100),
    tax_id_type                                   varchar(100),
    tax_id_number                                 varchar(100),
    date_tax_id_applied_for                       date,
    w_8_w_9_indicator                             varchar(100),
    w_8_w_9_date_signed                           date,
    w_8_w_9_effective_date                        date,
    w_8_w_9_document_type                         varchar(100),
    tax_status                                    varchar(100),
    b_notice_reason_code                          varchar(100),
    first_b_notice_status                         varchar(100),
    date_first_b_notice_status_issued_enforced    date,
    date_first_notice_status_satisfied            date,
    second_b_notice_status                        varchar(100),
    date_second_b_notice_status_issued_enforced   date,
    date_second_b_notice_status_satisfied         date,
    c_notice_status                               varchar(100),
    date_c_notice_status_issued_enforced          date,
    date_c_notice_status_satisfied                date,
    old_account_number                            varchar(100),
    original_account_open_date                    date,
    unidentified_large_trader_id                  varchar(100),
    large_trader_type_code                        varchar(100),
    large_trader_type_last_change_date            date,
    initial_source_of_funds_other                 varchar(100),
    finance_away                                  varchar(100),
    account_funding_date                          date,
    statement_currency_code                       varchar(100),
    future_statement_currency_code                varchar(100),
    future_statement_currency_code_effective_date date,
    account_level_routing_code_1                  varchar(100),
    account_level_routing_code_2                  varchar(100),
    account_level_routing_code_3                  varchar(100),
    account_level_routing_code_4                  varchar(100),
    self_directed_ind                             varchar(100),
    digital_advice_ind                            varchar(100),
    pte_account_ind                               varchar(100),
    first_ip                                      varchar(100),
    second_ip                                     varchar(100),
    third_ip                                      varchar(100),
    fourth_ip                                     varchar(100),
    fifth_ip                                      varchar(100),
    sixth_ip                                      varchar(100),
    seventh_ip                                    varchar(100),
    eighth_ip                                     varchar(100),
    ninth_ip                                      varchar(100),
    tenth_ip                                      varchar(100),
    alert_im_acornym                              varchar(100),
    alert_im_access_code                          varchar(100),
    broker_acronym                                varchar(100),
    cross_reference_indicator                     varchar(100),
    bny_trust_indicator                           varchar(100),
    source_of_asset_at_acct_opening               varchar(100),
    commission_doscount_code                      varchar(100),
    external_account_number                       varchar(100),
    confirmation_suppression_indicator            varchar(100),
    date_last_mail_sent                           date,
    date_last_mail_sent_outside                   date,
    fully_paid_lending_agreement_indicator        varchar(100),
    fully_paid_lending_agreement_date             date,
    custodian_account_type                        varchar(100),
    mifid_customer_categorization                 varchar(100),
    cash_management_tran_code                     varchar(100),
    sweep_status_indicator                        varchar(100),
    date_sweep_activated                          date,
    date_sweep_details_changed                    date,
    cober_margin_debit_indicator                  varchar(100),
    first_fund_sweep_account_id                   varchar(100),
    firstfund_sweep_account_percent               numeric(45, 20),
    first_fundsweep_account_redemption_priority   varchar(100),
    second_fund_sweep_account_id                  varchar(100),
    second_fund_sweep_account_percent             numeric(45, 20),
    second_fundsweep_account_redemption_priority  varchar(100),
    type_of_bank_account                          varchar(100),
    banklink_aba_number                           varchar(100),
    banklink_dda_number                           varchar(100),
    fund_bank_indicator                           varchar(100),
    w_9_corp_tax_classification_code              varchar(100),
    combined_margin_acct_indicator                varchar(100),
    pledge_collateral_account_indicator           varchar(100),
    finra_institutional_account_code              varchar(100),
    proposed_account_reference_id                 varchar(100),
    advisor_model_id                              varchar(100),
    firm_model_style_id                           varchar(100),
    dvp_restriction_code                          varchar(100),
    dvp_restriction_exp_date                      date,
    escheatment_withholding_ind                   varchar(100),
    source_of_origination                         varchar(100),
    source_of_persona                             varchar(100),
    client_onboarding_method                      varchar(100),
    tax_filing_code                               varchar(100),
    nor_purpose_collateral_acct_ind               varchar(100),
    addr_1_trx_code                               varchar(100),
    addr_1_special_handling_ind                   varchar(100),
    addr_1_delivery_id                            varchar(100),
    addr_1_attention_line_prefix                  varchar(100),
    addr_1_attention_line_detail                  varchar(100),
    addr_1_line_1                                 varchar(100),
    addr_1_line_2                                 varchar(100),
    addr_1_line_3                                 varchar(100),
    addr_1_line_4                                 varchar(100),
    addr_1_city_state                             varchar(100),
    addr_1_country_code                           varchar(100),
    addr_2_trx_code                               varchar(100),
    addr_2_special_handling_ind                   varchar(100),
    addr_2_delivery_id                            varchar(100),
    addr_2_attention_line_prefix                  varchar(100),
    addr_2_attention_line_detail                  varchar(100),
    addr_2_line_1                                 varchar(100),
    addr_2_line_2                                 varchar(100),
    addr_2_line_3                                 varchar(100),
    addr_2_line_4                                 varchar(100),
    addr_2_city_state                             varchar(100),
    addr_2_country_code                           varchar(100),
    account_description                           varchar(100),
    set_as_mail_addr_2_ind                        varchar(100),
    principal_billing_allocation_pct              numeric(45, 20),
    seasonal_addr_id_1                            varchar(100),
    from_date_1                                   date,
    to_date_1                                     date,
    seasonal_addr_id_2                            varchar(100),
    from_date_2                                   date,
    to_date_2                                     date,
    seasonal_addr_id_3                            varchar(100),
    from_date_3                                   date,
    to_date_3                                     date,
    cost_basis_acct_system                        varchar(100),
    disposition_method_mutual_funds               varchar(100),
    disposition_method_other                      varchar(100),
    disposition_method_stocks                     varchar(100),
    amortize_taxable_premium_bonds                varchar(100),
    accrue_market_disc_based_on                   varchar(100),
    accrue_market_disc_income                     varchar(100),
    addr_3_trx_code                               varchar(100),
    addr_3_special_handling_ind                   varchar(100),
    addr_3_delivery_id                            varchar(100),
    addr_3_attention_line_prefix                  varchar(100),
    addr_3_attention_line_detail                  varchar(100),
    addr_3_line_1                                 varchar(100),
    addr_3_line_2                                 varchar(100),
    addr_3_line_3                                 varchar(100),
    addr_3_line_4                                 varchar(100),
    addr_3_city_state                             varchar(100),
    addr_3_country_code                           varchar(100),
    set_as_mail_addr_3_ind                        varchar(100),
    addr_4_trx_code                               varchar(100),
    addr_4_special_handling_ind                   varchar(100),
    addr_4_delivery_id                            varchar(100),
    addr_4_attention_line_prefix                  varchar(100),
    addr_4_attention_line_detail                  varchar(100),
    addr_4_line_1                                 varchar(100),
    addr_4_line_2                                 varchar(100),
    addr_4_line_3                                 varchar(100),
    addr_4_line_4                                 varchar(100),
    addr_4_city_state                             varchar(100),
    addr_4_country_code                           varchar(100),
    set_as_mail_addr_4_ind                        varchar(100),
    addr_5_trx_code                               varchar(100),
    addr_5_special_handling_ind                   varchar(100),
    addr_5_delivery_id                            varchar(100),
    addr_5_attention_line_prefix                  varchar(100),
    addr_5_attention_line_detail                  varchar(100),
    addr_5_line_1                                 varchar(100),
    addr_5_line_2                                 varchar(100),
    addr_5_line_3                                 varchar(100),
    addr_5_line_4                                 varchar(100),
    addr_5_city_state                             varchar(100),
    addr_5_country_code                           varchar(100),
    set_as_mail_addr_5_ind                        varchar(100),
    addr_6_trx_code                               varchar(100),
    addr_6_special_handling_ind                   varchar(100),
    addr_6_delivery_id                            varchar(100),
    addr_6_attention_line_prefix                  varchar(100),
    addr_6_attention_line_detail                  varchar(100),
    addr_6_line_1                                 varchar(100),
    addr_6_line_2                                 varchar(100),
    addr_6_line_3                                 varchar(100),
    addr_6_line_4                                 varchar(100),
    addr_6_city_state                             varchar(100),
    addr_6_country_code                           varchar(100),
    set_as_mail_addr_6_ind                        varchar(100),
    addr_7_trx_code                               varchar(100),
    addr_7_special_handling_ind                   varchar(100),
    addr_7_delivery_id                            varchar(100),
    addr_7_attention_line_prefix                  varchar(100),
    addr_7_attention_line_detail                  varchar(100),
    addr_7_line_1                                 varchar(100),
    addr_7_line_2                                 varchar(100),
    addr_7_line_3                                 varchar(100),
    addr_7_line_4                                 varchar(100),
    addr_7_city_state                             varchar(100),
    addr_7_country_code                           varchar(100),
    set_as_mail_addr_7_ind                        varchar(100),
    record_transaction_code                       varchar(100),
    base_currency                                 varchar(100),
    income_currency                               varchar(100),
    statement_language                            varchar(100),
    statement_format_code                         varchar(100),
    msrb_statement_ind                            varchar(100),
    pep                                           varchar(100),
    first_name_pep                                varchar(100),
    last_name_pep                                 varchar(100),
    suffix_pep                                    varchar(100),
    political_office_held                         varchar(100),
    country_of_office                             varchar(100),
    foreign_bank_account_ind                      varchar(100),
    foreign_bank_cert_date                        date,
    foreign_bank_cert_exp_date                    date,
    central_bank_ind                              varchar(100),
    acct_foreign_financial_inst                   varchar(100),
    foreign_bank_acct_oper_1                      varchar(100),
    foreign_bank_acct_oper_2                      varchar(100),
    foreign_bank_acct_oper_3                      varchar(100),
    number_people_own                             varchar(100),
    proprietary_acct_owned                        varchar(100),
    tel_1_transaction_code                        varchar(100),
    tel_1_us_ind                                  varchar(100),
    tel_1_type_id                                 varchar(100),
    tel_1_number                                  varchar(100),
    tel_1_extension                               varchar(100),
    tel_2_transaction_code                        varchar(100),
    tel_2_us_ind                                  varchar(100),
    tel_2_type_id                                 varchar(100),
    tel_2_number                                  varchar(100),
    tel_2_extension                               varchar(100),
    tel_3_transaction_code                        varchar(100),
    tel_3_us_ind                                  varchar(100),
    tel_3_type_id                                 varchar(100),
    tel_3_number                                  varchar(100),
    tel_3_extension                               varchar(100),
    tel_4_transaction_code                        varchar(100),
    tel_4_us_ind                                  varchar(100),
    tel_4_type_id                                 varchar(100),
    tel_4_number                                  varchar(100),
    tel_4_extension                               varchar(100),
    tel_5_transaction_code                        varchar(100),
    tel_5_us_ind                                  varchar(100),
    tel_5_type_id                                 varchar(100),
    tel_5_number                                  varchar(100),
    tel_5_extension                               varchar(100),
    tel_6_transaction_code                        varchar(100),
    tel_6_us_ind                                  varchar(100),
    tel_6_type_id                                 varchar(100),
    tel_6_number                                  varchar(100),
    tel_6_extension                               varchar(100),
    tel_7_transaction_code                        varchar(100),
    tel_7_us_ind                                  varchar(100),
    tel_7_type_id                                 varchar(100),
    tel_7_number                                  varchar(100),
    tel_7_extension                               varchar(100),
    tel_8_transaction_code                        varchar(100),
    tel_8_us_ind                                  varchar(100),
    tel_8_type_id                                 varchar(100),
    tel_8_number                                  varchar(100),
    tel_8_extension                               varchar(100),
    email_address                                 varchar(100),
    external_position_ind                         varchar(100),
    purge_eligible_ind                            varchar(100),
    advisory_acct_ind                             varchar(100),
    product_profile_code                          varchar(100),
    cents_per_share_discount                      integer,
    option_disclosure_date                        date,
    country_acct_level_tax_residency              varchar(100)
);

create unique index sfl_acct_ui_cusip_fecha
    on pershing.sfl_acct (process_date, account_number);

create unique index sfl_acct_ui_cusip_proceso
    on pershing.sfl_acct (id_proceso, account_number);

create table pershing.sfl_gcus_actual
(
    id                                                      bigint generated always as identity
        constraint sfl_gcus_actual_pk
            primary key,
    id_proceso                                              bigint       not null,
    process_date                                            varchar(100) not null,
    record_id_sequence_number                               integer,
    account_number                                          varchar(100),
    cusip_number                                            varchar(100),
    portfolio_currency                                      varchar(100),
    underlying_cusip_number                                 varchar(100),
    country_code                                            varchar(100),
    ip_record_number                                        varchar(100),
    ibd_number                                              varchar(100),
    currency_security_indicator                             varchar(100),
    issue_currency                                          varchar(100),
    datestamp_trade_date                                    date,
    datestamp_settlement_date                               date,
    trade_date_quantity                                     numeric(45, 20),
    settlement_date_quantity                                numeric(45, 20),
    seg_quantity                                            numeric(45, 20),
    safekeeping_quantity                                    numeric(45, 20),
    transfer_quantity                                       numeric(45, 20),
    pending_transfer_quantity                               numeric(45, 20),
    legal_transfer_quantity                                 numeric(45, 20),
    tendered_quantity                                       numeric(45, 20),
    pending_papers                                          numeric(45, 20),
    short_against_the_box_quantity                          numeric(45, 20),
    networked_quantity                                      numeric(45, 20),
    pending_split_quantity                                  numeric(45, 20),
    quantity_covering_options                               numeric(45, 20),
    trade_date_quantity_bought                              numeric(45, 20),
    trade_date_quantity_sold                                numeric(45, 20),
    fed_rquirement                                          numeric(45, 20),
    house_margin_requirement                                numeric(45, 20),
    nyse_requirement                                        numeric(45, 20),
    equity_requirment                                       numeric(45, 20),
    security_symbol                                         varchar(100),
    security_type                                           varchar(100),
    security_mod                                            varchar(100),
    security_calc                                           varchar(100),
    minor_product_code                                      varchar(100),
    network_eligibility_indicator                           varchar(100),
    strike_price                                            numeric(45, 20),
    expiration_maturity_date                                date,
    contract_size                                           numeric(45, 20),
    conversion_ratio                                        numeric(45, 20),
    account_short_name                                      varchar(100),
    state_code                                              varchar(100),
    country_code_account                                    varchar(100),
    number_security_description_lines                       integer,
    security_description_line_1                             varchar(100),
    security_description_line_2                             varchar(100),
    security_description_line_3                             varchar(100),
    security_description_line_4                             varchar(100),
    security_description_line_5                             varchar(100),
    security_description_line_6                             varchar(100),
    dividend_option                                         varchar(100),
    long_term_capital_gains_option                          varchar(100),
    short_term_capital_gains_option                         varchar(100),
    firm_trading_indicator                                  varchar(100),
    position_currency_security                              varchar(100),
    trade_date_liquidating_value                            numeric(45, 20),
    pool_factor                                             numeric(45, 20),
    exchange_rate                                           numeric(45, 20),
    settlement_date_liquidating_value                       numeric(45, 20),
    alternate_security_id_type                              varchar(100),
    alternate_security_id                                   varchar(100),
    position_currency                                       varchar(100),
    fully_paid_lending_quantity                             numeric(45, 20),
    fully_paid_lending_quantity_collateral_amount           numeric(45, 20),
    option_root_id                                          varchar(100),
    expiration_date                                         date,
    call_put_indicator                                      varchar(100),
    trade_date_repo_quantity                                numeric(45, 20),
    settlement_date_repo_quantity                           numeric(45, 20),
    trade_date_reverse_repo_quantity                        numeric(45, 20),
    settlement_date_reverse_repo_quantity                   numeric(45, 20),
    collateral_pledge_quantity                              numeric(45, 20),
    corporate_exec_serv_collateral_pledge_quantity          numeric(45, 20),
    trade_date_repo_liquidating_value                       numeric(45, 20),
    settlement_date_repo_liquidating_value                  numeric(45, 20),
    trade_date_reverse_repo_liquidating_value               numeric(45, 20),
    settlement_date_reverse_repo_liquidating_value          numeric(45, 20),
    collateral_pledge_liquidating_value                     numeric(45, 20),
    corporate_exec_serv_collateral_pledge_liquidating_value numeric(45, 20),
    trade_date_repo_loan_amount                             numeric(45, 20),
    settlement_date_repo_loan_amount                        numeric(45, 20),
    trade_date_reverse_repo_loan_amount                     numeric(45, 20),
    settlement_date_reverse_repo_loan_amount                numeric(45, 20),
    accrued_interes_value                                   numeric(45, 20),
    dividend_or_coupon_rate                                 numeric(45, 20),
    pending_split_quantity_liquidating_value                numeric(45, 20),
    internal_non_dollar_symbol                              varchar(100),
    pledged_quantity                                        numeric(45, 20)
);

create unique index sfl_gcus_actual_ui_cusip_fecha
    on pershing.sfl_gcus_actual (process_date, account_number, cusip_number);

create unique index sfl_gcus_actual_ui_cusip_proceso
    on pershing.sfl_gcus_actual (id_proceso, account_number, cusip_number);

create table pershing.sfl_gcus_historica
(
    id                                                      bigint generated always as identity
        constraint sfl_gcus_historica_pk
            primary key,
    id_proceso                                              bigint       not null,
    process_date                                            varchar(100) not null,
    record_id_sequence_number                               integer,
    account_number                                          varchar(100),
    cusip_number                                            varchar(100),
    portfolio_currency                                      varchar(100),
    underlying_cusip_number                                 varchar(100),
    country_code                                            varchar(100),
    ip_record_number                                        varchar(100),
    ibd_number                                              varchar(100),
    currency_security_indicator                             varchar(100),
    issue_currency                                          varchar(100),
    datestamp_trade_date                                    date,
    datestamp_settlement_date                               date,
    trade_date_quantity                                     numeric(45, 20),
    settlement_date_quantity                                numeric(45, 20),
    seg_quantity                                            numeric(45, 20),
    safekeeping_quantity                                    numeric(45, 20),
    transfer_quantity                                       numeric(45, 20),
    pending_transfer_quantity                               numeric(45, 20),
    legal_transfer_quantity                                 numeric(45, 20),
    tendered_quantity                                       numeric(45, 20),
    pending_papers                                          numeric(45, 20),
    short_against_the_box_quantity                          numeric(45, 20),
    networked_quantity                                      numeric(45, 20),
    pending_split_quantity                                  numeric(45, 20),
    quantity_covering_options                               numeric(45, 20),
    trade_date_quantity_bought                              numeric(45, 20),
    trade_date_quantity_sold                                numeric(45, 20),
    fed_rquirement                                          numeric(45, 20),
    house_margin_requirement                                numeric(45, 20),
    nyse_requirement                                        numeric(45, 20),
    equity_requirment                                       numeric(45, 20),
    security_symbol                                         varchar(100),
    security_type                                           varchar(100),
    security_mod                                            varchar(100),
    security_calc                                           varchar(100),
    minor_product_code                                      varchar(100),
    network_eligibility_indicator                           varchar(100),
    strike_price                                            numeric(45, 20),
    expiration_maturity_date                                date,
    contract_size                                           numeric(45, 20),
    conversion_ratio                                        numeric(45, 20),
    account_short_name                                      varchar(100),
    state_code                                              varchar(100),
    country_code_account                                    varchar(100),
    number_security_description_lines                       integer,
    security_description_line_1                             varchar(100),
    security_description_line_2                             varchar(100),
    security_description_line_3                             varchar(100),
    security_description_line_4                             varchar(100),
    security_description_line_5                             varchar(100),
    security_description_line_6                             varchar(100),
    dividend_option                                         varchar(100),
    long_term_capital_gains_option                          varchar(100),
    short_term_capital_gains_option                         varchar(100),
    firm_trading_indicator                                  varchar(100),
    position_currency_security                              varchar(100),
    trade_date_liquidating_value                            numeric(45, 20),
    pool_factor                                             numeric(45, 20),
    exchange_rate                                           numeric(45, 20),
    settlement_date_liquidating_value                       numeric(45, 20),
    alternate_security_id_type                              varchar(100),
    alternate_security_id                                   varchar(100),
    position_currency                                       varchar(100),
    fully_paid_lending_quantity                             numeric(45, 20),
    fully_paid_lending_quantity_collateral_amount           numeric(45, 20),
    option_root_id                                          varchar(100),
    expiration_date                                         date,
    call_put_indicator                                      varchar(100),
    trade_date_repo_quantity                                numeric(45, 20),
    settlement_date_repo_quantity                           numeric(45, 20),
    trade_date_reverse_repo_quantity                        numeric(45, 20),
    settlement_date_reverse_repo_quantity                   numeric(45, 20),
    collateral_pledge_quantity                              numeric(45, 20),
    corporate_exec_serv_collateral_pledge_quantity          numeric(45, 20),
    trade_date_repo_liquidating_value                       numeric(45, 20),
    settlement_date_repo_liquidating_value                  numeric(45, 20),
    trade_date_reverse_repo_liquidating_value               numeric(45, 20),
    settlement_date_reverse_repo_liquidating_value          numeric(45, 20),
    collateral_pledge_liquidating_value                     numeric(45, 20),
    corporate_exec_serv_collateral_pledge_liquidating_value numeric(45, 20),
    trade_date_repo_loan_amount                             numeric(45, 20),
    settlement_date_repo_loan_amount                        numeric(45, 20),
    trade_date_reverse_repo_loan_amount                     numeric(45, 20),
    settlement_date_reverse_repo_loan_amount                numeric(45, 20),
    accrued_interes_value                                   numeric(45, 20),
    dividend_or_coupon_rate                                 numeric(45, 20),
    pending_split_quantity_liquidating_value                numeric(45, 20),
    internal_non_dollar_symbol                              varchar(100),
    pledged_quantity                                        numeric(45, 20)
);

create unique index sfl_gcus_historica_ui_cusip_fecha
    on pershing.sfl_gcus_historica (process_date, account_number, cusip_number);

create table pershing.sfl_isrc_actual
(
    id                        bigint generated always as identity
        constraint sfl_isrc_actual_pk
            primary key,
    id_proceso                bigint       not null,
    process_date              varchar(100) not null,
    record_secuence_id        varchar(100),
    record_id_number          integer,
    change_id                 varchar(100),
    source_code               varchar(100),
    source_code_desc_line_1   varchar(100),
    source_code_desc_line_2   varchar(100),
    source_code_desc_line_3   varchar(100),
    tax_status                varchar(100),
    user_id                   varchar(100),
    date_added                varchar(100),
    date_updated              varchar(100),
    ira_income_eligible       varchar(100),
    retail_income_eligible    varchar(100),
    customer_firm             varchar(100),
    cerdit_debit              varchar(100),
    statement_ind             varchar(100),
    statement_act_sum_ind     varchar(100),
    statement_act_sum_number  varchar(100),
    statement_trx_sum_ind     varchar(100),
    statement_trx_sum_number  varchar(100),
    statement_distrib_ind     varchar(100),
    statement_distrib_number  varchar(100),
    statement_distrib_tax_ind varchar(100),
    statement_div_ind         varchar(100),
    statement_div_number      varchar(100),
    statement_div_tax_ind     varchar(100),
    pershing_depart           varchar(100),
    pershing_grp              varchar(100),
    user_id_added             varchar(100),
    user_id_updated           varchar(100),
    portfolio_eligible_ind    varchar(100),
    reinvest_ind              varchar(100)
);

create unique index sfl_isrc_actual_ui_source_code_fecha
    on pershing.sfl_isrc_actual (process_date, source_code);

create unique index sfl_isrc_actual_ui_source_code_proceso
    on pershing.sfl_isrc_actual (id_proceso, source_code);

create table pershing.par_currency_code
(
    id    varchar(100)  not null
        constraint par_currency_code_pk
            primary key,
    glosa varchar(1000) not null
);

create table pershing.par_tranche_code
(
    id    varchar(100)  not null
        constraint par_tranche_code_pk
            primary key,
    glosa varchar(1000) not null
);

create table pershing.par_minor_product_code
(
    id    varchar(100)  not null
        constraint par_minor_product_code_pk
            primary key,
    glosa varchar(1000) not null
);

create table pershing.par_asset_type_code
(
    id                    bigint generated always as identity
        constraint par_asset_type_code_pk
            primary key,
    id_tipo               varchar(100)              not null,
    id_sub_tipo           varchar(100)              not null,
    id_sub_sub_tipo       varchar(100)              not null,
    glosa                 varchar(1000)             not null,
    factor_division_saldo numeric(45, 20) default 1 not null
);

create unique index par_asset_type_code_ui_subtipos
    on pershing.par_asset_type_code (id_tipo, id_sub_tipo, id_sub_sub_tipo);

create table pershing.par_sec_code_matrix
(
    id          bigint generated always as identity
        constraint par_sec_code_matrix_pk
            primary key,
    id_type     varchar(100)  not null,
    id_modifier varchar(100)  not null,
    id_calc     varchar(100),
    id_minor    varchar(100),
    glosa       varchar(1000) not null
);

create unique index par_sec_code_matrix_ui_ids
    on pershing.par_sec_code_matrix (id_type, id_modifier, id_calc, id_minor);

create table pershing.param_generic_pershing
(
    id          bigint generated always as identity
        constraint param_generic_pershing_pk
            primary key,
    param_name  varchar(100)                                  not null,
    param_id    varchar(100),
    param_value varchar(1000)                                 not null,
    type_id     varchar(100) default 'STR'::character varying not null,
    type_value  varchar(100) default 'STR'::character varying not null
);

create unique index param_generic_pershing_ui_param_name_id
    on pershing.param_generic_pershing (param_name, param_id);

create table pershing.par_country_code
(
    id       bigint generated always as identity
        constraint par_country_code_pk
            primary key,
    iso_code varchar(100)  not null,
    num_code integer,
    glosa    varchar(1000) not null
);

create unique index par_country_code_ui_iso_code
    on pershing.par_country_code (iso_code);

create table pershing.par_registration_type
(
    id    varchar(100)  not null
        constraint par_registration_type_pk
            primary key,
    glosa varchar(1000) not null
);

create table pershing.sfl_acct_historica
(
    id                                            bigint generated always as identity
        constraint sfl_acct_historica_pk
            primary key,
    id_proceso                                    bigint       not null,
    process_date                                  varchar(100) not null,
    record_id_sequence_number                     integer,
    account_number                                varchar(100),
    ibd_number                                    varchar(100),
    ip_number                                     varchar(100),
    account_short_name                            varchar(100),
    transaction_type                              varchar(100),
    autotitled_usertitled_account                 varchar(100),
    account_type_code                             varchar(100),
    registration_type                             varchar(100),
    number_of_account_title_lines                 varchar(100),
    account_registration_line_1                   varchar(100),
    account_registration_line_2                   varchar(100),
    account_registration_line_3                   varchar(100),
    account_registration_line_4                   varchar(100),
    account_registration_line_5                   varchar(100),
    account_registration_line_6                   varchar(100),
    registration_type_detail                      varchar(100),
    date_account_opened                           date,
    date_account_information_updated              date,
    account_status_indicator                      varchar(100),
    pending_closed_date                           date,
    date_account_closed                           date,
    closing_notice_date                           date,
    account_reactivated_date                      date,
    date_account_reopened                         date,
    proceeds                                      varchar(100),
    transfer_instructions                         varchar(100),
    income_isntructions                           varchar(100),
    number_of_confirms_for_thi_account            varchar(100),
    number_of_statements_for_this_account         varchar(100),
    investment_objetive_trans_code                varchar(100),
    comments_act                                  varchar(100),
    employer_shotname                             varchar(100),
    employers_cusip                               varchar(100),
    employers_symbol                              varchar(100),
    margin_privileges_revoked                     varchar(100),
    statement_review_date                         date,
    margin_papers_on_file                         varchar(100),
    option_papers_on_file                         varchar(100),
    good_faith_margin                             varchar(100),
    ip_discretion_granted                         varchar(100),
    invest_advisor_discretion_granted             varchar(100),
    third_party_discretion_granted                varchar(100),
    third_party_name                              varchar(100),
    risk_factor_code                              varchar(100),
    investment_objetive_code                      varchar(100),
    option_equities                               varchar(100),
    option_index                                  varchar(100),
    option_debt                                   varchar(100),
    option_currency                               varchar(100),
    option_level_1                                varchar(100),
    option_level_2                                varchar(100),
    option_level_3                                varchar(100),
    option_level_4                                varchar(100),
    option_call_limits                            integer,
    option_put_limits                             integer,
    option_total_limits_of_puts_and_calls         integer,
    non_us_dollar_trading                         varchar(100),
    non_customer_indicator                        varchar(100),
    third_party_fee_indicator                     varchar(100),
    third_party_fee_approval_date                 date,
    intermediary_account_ind                      varchar(100),
    commission_schedule                           varchar(100),
    group_index                                   varchar(100),
    money_manager_id                              varchar(100),
    money_manager_objective_id                    varchar(100),
    dtc_id_confirm_number                         varchar(100),
    caps_master_mnemonic                          varchar(100),
    employee_id                                   varchar(100),
    prime_broker_free_fund_indicator              varchar(100),
    fee_based_account_indicator                   varchar(100),
    fee_based_termination_date                    date,
    plan_name                                     varchar(100),
    self_directed_401_k_account_type              varchar(100),
    plan_type                                     varchar(100),
    plan_number                                   varchar(100),
    employee_or_employee_relative                 varchar(100),
    commission_percent_discount                   numeric(45, 20),
    ind_12_b_1_fee_blocking                       varchar(100),
    name_of_ip_signed_new_account_form            varchar(100),
    date_of_ip_signed_new_account_form            date,
    name_of_principal_signed_new_account_form     varchar(100),
    date_of_principal_signed_new_account_form     date,
    politically_exposed_person                    varchar(100),
    private_banking_account                       varchar(100),
    foreign_bank_account                          varchar(100),
    initial_source_of_funds                       varchar(100),
    usa_patriot_act_exempt_reason                 varchar(100),
    primary_country_of_citizenship                varchar(100),
    country_of_residence                          varchar(100),
    birth_date                                    date,
    age_based_fund_roll_exempt                    varchar(100),
    money_fundreform_retail                       varchar(100),
    trusted_contact_status                        varchar(100),
    regulatory_account_type_category              varchar(100),
    account_managed_by_trust_comp_id              varchar(100),
    voting_auth                                   varchar(100),
    customer_type                                 varchar(100),
    fulfillment_method                            varchar(100),
    credit_interest_indicator                     varchar(100),
    ama_indicator                                 varchar(100),
    tax_id_type                                   varchar(100),
    tax_id_number                                 varchar(100),
    date_tax_id_applied_for                       date,
    w_8_w_9_indicator                             varchar(100),
    w_8_w_9_date_signed                           date,
    w_8_w_9_effective_date                        date,
    w_8_w_9_document_type                         varchar(100),
    tax_status                                    varchar(100),
    b_notice_reason_code                          varchar(100),
    first_b_notice_status                         varchar(100),
    date_first_b_notice_status_issued_enforced    date,
    date_first_notice_status_satisfied            date,
    second_b_notice_status                        varchar(100),
    date_second_b_notice_status_issued_enforced   date,
    date_second_b_notice_status_satisfied         date,
    c_notice_status                               varchar(100),
    date_c_notice_status_issued_enforced          date,
    date_c_notice_status_satisfied                date,
    old_account_number                            varchar(100),
    original_account_open_date                    date,
    unidentified_large_trader_id                  varchar(100),
    large_trader_type_code                        varchar(100),
    large_trader_type_last_change_date            date,
    initial_source_of_funds_other                 varchar(100),
    finance_away                                  varchar(100),
    account_funding_date                          date,
    statement_currency_code                       varchar(100),
    future_statement_currency_code                varchar(100),
    future_statement_currency_code_effective_date date,
    account_level_routing_code_1                  varchar(100),
    account_level_routing_code_2                  varchar(100),
    account_level_routing_code_3                  varchar(100),
    account_level_routing_code_4                  varchar(100),
    self_directed_ind                             varchar(100),
    digital_advice_ind                            varchar(100),
    pte_account_ind                               varchar(100),
    first_ip                                      varchar(100),
    second_ip                                     varchar(100),
    third_ip                                      varchar(100),
    fourth_ip                                     varchar(100),
    fifth_ip                                      varchar(100),
    sixth_ip                                      varchar(100),
    seventh_ip                                    varchar(100),
    eighth_ip                                     varchar(100),
    ninth_ip                                      varchar(100),
    tenth_ip                                      varchar(100),
    alert_im_acornym                              varchar(100),
    alert_im_access_code                          varchar(100),
    broker_acronym                                varchar(100),
    cross_reference_indicator                     varchar(100),
    bny_trust_indicator                           varchar(100),
    source_of_asset_at_acct_opening               varchar(100),
    commission_doscount_code                      varchar(100),
    external_account_number                       varchar(100),
    confirmation_suppression_indicator            varchar(100),
    date_last_mail_sent                           date,
    date_last_mail_sent_outside                   date,
    fully_paid_lending_agreement_indicator        varchar(100),
    fully_paid_lending_agreement_date             date,
    custodian_account_type                        varchar(100),
    mifid_customer_categorization                 varchar(100),
    cash_management_tran_code                     varchar(100),
    sweep_status_indicator                        varchar(100),
    date_sweep_activated                          date,
    date_sweep_details_changed                    date,
    cober_margin_debit_indicator                  varchar(100),
    first_fund_sweep_account_id                   varchar(100),
    firstfund_sweep_account_percent               numeric(45, 20),
    first_fundsweep_account_redemption_priority   varchar(100),
    second_fund_sweep_account_id                  varchar(100),
    second_fund_sweep_account_percent             numeric(45, 20),
    second_fundsweep_account_redemption_priority  varchar(100),
    type_of_bank_account                          varchar(100),
    banklink_aba_number                           varchar(100),
    banklink_dda_number                           varchar(100),
    fund_bank_indicator                           varchar(100),
    w_9_corp_tax_classification_code              varchar(100),
    combined_margin_acct_indicator                varchar(100),
    pledge_collateral_account_indicator           varchar(100),
    finra_institutional_account_code              varchar(100),
    proposed_account_reference_id                 varchar(100),
    advisor_model_id                              varchar(100),
    firm_model_style_id                           varchar(100),
    dvp_restriction_code                          varchar(100),
    dvp_restriction_exp_date                      date,
    escheatment_withholding_ind                   varchar(100),
    source_of_origination                         varchar(100),
    source_of_persona                             varchar(100),
    client_onboarding_method                      varchar(100),
    tax_filing_code                               varchar(100),
    nor_purpose_collateral_acct_ind               varchar(100),
    addr_1_trx_code                               varchar(100),
    addr_1_special_handling_ind                   varchar(100),
    addr_1_delivery_id                            varchar(100),
    addr_1_attention_line_prefix                  varchar(100),
    addr_1_attention_line_detail                  varchar(100),
    addr_1_line_1                                 varchar(100),
    addr_1_line_2                                 varchar(100),
    addr_1_line_3                                 varchar(100),
    addr_1_line_4                                 varchar(100),
    addr_1_city_state                             varchar(100),
    addr_1_country_code                           varchar(100),
    addr_2_trx_code                               varchar(100),
    addr_2_special_handling_ind                   varchar(100),
    addr_2_delivery_id                            varchar(100),
    addr_2_attention_line_prefix                  varchar(100),
    addr_2_attention_line_detail                  varchar(100),
    addr_2_line_1                                 varchar(100),
    addr_2_line_2                                 varchar(100),
    addr_2_line_3                                 varchar(100),
    addr_2_line_4                                 varchar(100),
    addr_2_city_state                             varchar(100),
    addr_2_country_code                           varchar(100),
    account_description                           varchar(100),
    set_as_mail_addr_2_ind                        varchar(100),
    principal_billing_allocation_pct              numeric(45, 20),
    seasonal_addr_id_1                            varchar(100),
    from_date_1                                   date,
    to_date_1                                     date,
    seasonal_addr_id_2                            varchar(100),
    from_date_2                                   date,
    to_date_2                                     date,
    seasonal_addr_id_3                            varchar(100),
    from_date_3                                   date,
    to_date_3                                     date,
    cost_basis_acct_system                        varchar(100),
    disposition_method_mutual_funds               varchar(100),
    disposition_method_other                      varchar(100),
    disposition_method_stocks                     varchar(100),
    amortize_taxable_premium_bonds                varchar(100),
    accrue_market_disc_based_on                   varchar(100),
    accrue_market_disc_income                     varchar(100),
    addr_3_trx_code                               varchar(100),
    addr_3_special_handling_ind                   varchar(100),
    addr_3_delivery_id                            varchar(100),
    addr_3_attention_line_prefix                  varchar(100),
    addr_3_attention_line_detail                  varchar(100),
    addr_3_line_1                                 varchar(100),
    addr_3_line_2                                 varchar(100),
    addr_3_line_3                                 varchar(100),
    addr_3_line_4                                 varchar(100),
    addr_3_city_state                             varchar(100),
    addr_3_country_code                           varchar(100),
    set_as_mail_addr_3_ind                        varchar(100),
    addr_4_trx_code                               varchar(100),
    addr_4_special_handling_ind                   varchar(100),
    addr_4_delivery_id                            varchar(100),
    addr_4_attention_line_prefix                  varchar(100),
    addr_4_attention_line_detail                  varchar(100),
    addr_4_line_1                                 varchar(100),
    addr_4_line_2                                 varchar(100),
    addr_4_line_3                                 varchar(100),
    addr_4_line_4                                 varchar(100),
    addr_4_city_state                             varchar(100),
    addr_4_country_code                           varchar(100),
    set_as_mail_addr_4_ind                        varchar(100),
    addr_5_trx_code                               varchar(100),
    addr_5_special_handling_ind                   varchar(100),
    addr_5_delivery_id                            varchar(100),
    addr_5_attention_line_prefix                  varchar(100),
    addr_5_attention_line_detail                  varchar(100),
    addr_5_line_1                                 varchar(100),
    addr_5_line_2                                 varchar(100),
    addr_5_line_3                                 varchar(100),
    addr_5_line_4                                 varchar(100),
    addr_5_city_state                             varchar(100),
    addr_5_country_code                           varchar(100),
    set_as_mail_addr_5_ind                        varchar(100),
    addr_6_trx_code                               varchar(100),
    addr_6_special_handling_ind                   varchar(100),
    addr_6_delivery_id                            varchar(100),
    addr_6_attention_line_prefix                  varchar(100),
    addr_6_attention_line_detail                  varchar(100),
    addr_6_line_1                                 varchar(100),
    addr_6_line_2                                 varchar(100),
    addr_6_line_3                                 varchar(100),
    addr_6_line_4                                 varchar(100),
    addr_6_city_state                             varchar(100),
    addr_6_country_code                           varchar(100),
    set_as_mail_addr_6_ind                        varchar(100),
    addr_7_trx_code                               varchar(100),
    addr_7_special_handling_ind                   varchar(100),
    addr_7_delivery_id                            varchar(100),
    addr_7_attention_line_prefix                  varchar(100),
    addr_7_attention_line_detail                  varchar(100),
    addr_7_line_1                                 varchar(100),
    addr_7_line_2                                 varchar(100),
    addr_7_line_3                                 varchar(100),
    addr_7_line_4                                 varchar(100),
    addr_7_city_state                             varchar(100),
    addr_7_country_code                           varchar(100),
    set_as_mail_addr_7_ind                        varchar(100),
    record_transaction_code                       varchar(100),
    base_currency                                 varchar(100),
    income_currency                               varchar(100),
    statement_language                            varchar(100),
    statement_format_code                         varchar(100),
    msrb_statement_ind                            varchar(100),
    pep                                           varchar(100),
    first_name_pep                                varchar(100),
    last_name_pep                                 varchar(100),
    suffix_pep                                    varchar(100),
    political_office_held                         varchar(100),
    country_of_office                             varchar(100),
    foreign_bank_account_ind                      varchar(100),
    foreign_bank_cert_date                        date,
    foreign_bank_cert_exp_date                    date,
    central_bank_ind                              varchar(100),
    acct_foreign_financial_inst                   varchar(100),
    foreign_bank_acct_oper_1                      varchar(100),
    foreign_bank_acct_oper_2                      varchar(100),
    foreign_bank_acct_oper_3                      varchar(100),
    number_people_own                             varchar(100),
    proprietary_acct_owned                        varchar(100),
    tel_1_transaction_code                        varchar(100),
    tel_1_us_ind                                  varchar(100),
    tel_1_type_id                                 varchar(100),
    tel_1_number                                  varchar(100),
    tel_1_extension                               varchar(100),
    tel_2_transaction_code                        varchar(100),
    tel_2_us_ind                                  varchar(100),
    tel_2_type_id                                 varchar(100),
    tel_2_number                                  varchar(100),
    tel_2_extension                               varchar(100),
    tel_3_transaction_code                        varchar(100),
    tel_3_us_ind                                  varchar(100),
    tel_3_type_id                                 varchar(100),
    tel_3_number                                  varchar(100),
    tel_3_extension                               varchar(100),
    tel_4_transaction_code                        varchar(100),
    tel_4_us_ind                                  varchar(100),
    tel_4_type_id                                 varchar(100),
    tel_4_number                                  varchar(100),
    tel_4_extension                               varchar(100),
    tel_5_transaction_code                        varchar(100),
    tel_5_us_ind                                  varchar(100),
    tel_5_type_id                                 varchar(100),
    tel_5_number                                  varchar(100),
    tel_5_extension                               varchar(100),
    tel_6_transaction_code                        varchar(100),
    tel_6_us_ind                                  varchar(100),
    tel_6_type_id                                 varchar(100),
    tel_6_number                                  varchar(100),
    tel_6_extension                               varchar(100),
    tel_7_transaction_code                        varchar(100),
    tel_7_us_ind                                  varchar(100),
    tel_7_type_id                                 varchar(100),
    tel_7_number                                  varchar(100),
    tel_7_extension                               varchar(100),
    tel_8_transaction_code                        varchar(100),
    tel_8_us_ind                                  varchar(100),
    tel_8_type_id                                 varchar(100),
    tel_8_number                                  varchar(100),
    tel_8_extension                               varchar(100),
    email_address                                 varchar(100),
    external_position_ind                         varchar(100),
    purge_eligible_ind                            varchar(100),
    advisory_acct_ind                             varchar(100),
    product_profile_code                          varchar(100),
    cents_per_share_discount                      integer,
    option_disclosure_date                        date,
    country_acct_level_tax_residency              varchar(100)
);

create unique index sfl_acct_historica_ui_account_fecha
    on pershing.sfl_acct_historica (process_date, account_number);

create unique index sfl_acct_historica_ui_account_proceso
    on pershing.sfl_acct_historica (id_proceso, process_date, account_number);

create table pershing.sfl_isca_historica
(
    id                                              bigint generated always as identity
        constraint sfl_isca_historica_pk
            primary key,
    id_proceso                                      bigint       not null,
    process_date                                    varchar(100) not null,
    cusip_number                                    varchar(100),
    security_type                                   varchar(100),
    security_modifier                               varchar(100),
    security_calculation_code                       varchar(100),
    primary_exchange                                varchar(100),
    coupon_rate_fis_or_indicated_dividend_eq        numeric(45, 20),
    maturity_option_expire_date                     date,
    underlying_security_cusip                       varchar(100),
    first_call_price_fix_inc_or_strike_price_option numeric(45, 20),
    first_par_call_price_fix_inc_or_units_option    numeric(45, 20),
    primary_symbol                                  varchar(100),
    interest_frequency                              varchar(100),
    bond_class                                      varchar(100),
    first_coupon_day                                varchar(100),
    call_indicator                                  varchar(100),
    put_indicator                                   varchar(100),
    next_par_call_date                              date,
    prerefunded_date                                date,
    next_premium_call_date                          date,
    dated_date_for_fix_inc_or_ex_dividend_date_eq   date,
    first_coupon_fix_inc_or_payable_date_eq         date,
    federal_marginable_ind                          varchar(100),
    cns_eligible_code                               varchar(100),
    dtcc_eligible_code                              varchar(100),
    nscc_eligible_code                              varchar(100),
    foreign_security                                varchar(100),
    second_coupon_day                               varchar(100),
    dividend_interest_payment_method                varchar(100),
    minor_product_code                              varchar(100),
    etf_indicator                                   varchar(100),
    bid_price                                       numeric(45, 20),
    ask_price                                       numeric(45, 20),
    previous_day_price                              numeric(45, 20),
    latest_price                                    numeric(45, 20),
    end_of_month_price                              numeric(45, 20),
    round_lot_quantity                              integer,
    dividend_reinvestment_eligibility_indicator     varchar(100),
    previous_price_date                             date,
    latest_price_date                               date,
    end_of_month_price_date                         date,
    record_date                                     date,
    fundvest_ind                                    varchar(100),
    country_code                                    varchar(100),
    standard_poor_rating                            varchar(100),
    moodys_rating                                   varchar(100),
    bond_sub_class                                  varchar(100),
    restriction_indicator                           varchar(100),
    trace_indicator                                 varchar(100),
    new_interest_calculation_code                   varchar(100),
    sic_code                                        varchar(100),
    state_tax_ind                                   varchar(100),
    fts_ind                                         varchar(100),
    amt_ind                                         varchar(100),
    ric_indicator                                   varchar(100),
    number_of_description_lines                     varchar(100),
    secutiry_description_line_1                     varchar(100),
    secutiry_description_line_2                     varchar(100),
    secutiry_description_line_3                     varchar(100),
    secutiry_description_line_4                     varchar(100),
    secutiry_description_line_5                     varchar(100),
    user_cusip_identifier                           varchar(100),
    price_purge_date                                date,
    taxable_indicator                               varchar(100),
    secutiry_description_line_6                     varchar(100),
    put_price                                       numeric(45, 20),
    put_date                                        date,
    second_premium_call_price                       numeric(45, 20),
    second_premium_call_date                        date,
    called_date                                     date,
    pool_number                                     varchar(100),
    factor                                          numeric(45, 20),
    factor_date                                     date,
    previous_factor                                 varchar(100),
    previous_factor_date                            date,
    variable_rate_indicator                         varchar(100),
    next_last_coupon_date                           date,
    structured_product_ind                          varchar(100),
    perpetual_bond_indicator                        varchar(100),
    exp_first_call_price                            numeric(45, 20),
    exp_first_par_call_price                        numeric(45, 20),
    exp_put_price                                   numeric(45, 20),
    exp_second_premium_call_price                   numeric(45, 20),
    name_issuer_security                            varchar(100),
    issuing_currency                                varchar(100),
    globally_locked_sec_ind                         varchar(100),
    globally_locked_reason_code                     varchar(100),
    spac_ind                                        varchar(100),
    eor                                             varchar(100),
    expanded_bid_price                              numeric(45, 20),
    expanded_ask_price                              numeric(45, 20),
    expanded_previous_day_price                     numeric(45, 20),
    expanded_latest_price                           numeric(45, 20),
    expanded_end_of_month_price                     numeric(45, 20),
    contract_share_quantity                         numeric(45, 20),
    year_covered_under_cost_basis_rules             integer,
    delta                                           numeric(45, 20),
    delta_value_presence_ind                        varchar(100),
    isin_code                                       varchar(100),
    issuer_identifier                               varchar(100),
    symbol_of_the_underlying_security               varchar(100),
    asset_type                                      varchar(100),
    asset_subtype                                   varchar(100),
    asset_subsubtype                                varchar(100),
    payment_day_delays                              integer,
    exchange_rate_denom_currency_usd                numeric(45, 20),
    underlying_cusip_1                              varchar(100),
    deliverable_unit_quantity_1                     integer,
    underlying_cusip_2                              varchar(100),
    deliverable_unit_quantity_2                     integer,
    underlying_cusip_3                              varchar(100),
    deliverable_unit_quantity_3                     integer,
    underlying_cusip_4                              varchar(100),
    deliverable_unit_quantity_4                     integer,
    annual_dividend_currency_code                   varchar(100),
    outstanding_shares                              numeric(45, 20),
    option_root_id                                  varchar(100),
    expiration_date                                 date,
    call_put_indicator                              varchar(100),
    strike_price                                    numeric(45, 20),
    fund_type                                       varchar(100),
    broad_narrow_indicator                          varchar(100),
    leverage_factor                                 numeric(45, 20),
    outstanding_shares_update_date                  date,
    expanded_symbol                                 varchar(100),
    state_of_issuance                               varchar(100),
    option_excercise_pricing_model_code             varchar(100),
    first_accrual_date                              date,
    tranche_code                                    varchar(100),
    worthless_security_indicator                    varchar(100),
    uit_termination_code                            integer,
    fdic_certification_number                       varchar(100),
    revenue_stream                                  varchar(100),
    restricted_marijuana_ind                        varchar(100),
    factored_market_value_multiplier                numeric(45, 20),
    current_yield                                   numeric(45, 20),
    yield                                           numeric(45, 20),
    price_source                                    varchar(100),
    country_of_origin                               varchar(100),
    retricted_security_code                         varchar(100),
    international_non_dollar_symbol                 varchar(100),
    international_exchange                          varchar(100),
    variable_rate_category_code                     varchar(100),
    interest_rate_completion_ind                    varchar(100),
    exchange_code_sedol_1                           varchar(100),
    sedol_1                                         varchar(100),
    exchange_code_sedol_2                           varchar(100),
    sedol_2                                         varchar(100),
    exchange_code_sedol_3                           varchar(100),
    sedol_3                                         varchar(100),
    exchange_code_sedol_4                           varchar(100),
    sedol_4                                         varchar(100),
    exchange_code_sedol_5                           varchar(100),
    sedol_5                                         varchar(100),
    exchange_code_sedol_6                           varchar(100),
    sedol_6                                         varchar(100),
    exchange_code_sedol_7                           varchar(100),
    sedol_7                                         varchar(100),
    exchange_code_sedol_8                           varchar(100),
    sedol_8                                         varchar(100),
    exchange_code_sedol_9                           varchar(100),
    sedol_9                                         varchar(100),
    exchange_code_sedol_10                          varchar(100),
    sedol_10                                        varchar(100),
    exchange_code_sedol_11                          varchar(100),
    sedol_11                                        varchar(100),
    primary_idc_mkt_exch                            varchar(100),
    primary_mkt_exch_trading_status                 varchar(100),
    primary_mkt_symbol                              varchar(100),
    primary_mkt_exch_effective_date                 date,
    primary_mkt_status_code                         varchar(100),
    secondary_idc_mkt_exch                          varchar(100),
    secondary_mkt_exch_trading_status               varchar(100),
    secondary_mkt_symbol                            varchar(100),
    secondary_mkt_exch_effective_date               date,
    secondary_mkt_status_code                       varchar(100),
    tick_size_pilot_group                           varchar(100),
    tick_size_effective_date                        date,
    tick_size_change_date                           date,
    update_date                                     date,
    oas_libor_rate                                  numeric(45, 20),
    first_call_date                                 date,
    first_call_price                                numeric(45, 20),
    second_call_date                                date,
    second_call_price                               numeric(45, 20),
    third_call_date                                 date,
    third_call_price                                numeric(45, 20),
    fourth_call_date                                date,
    fourth_call_price                               numeric(45, 20),
    effective_date_rate_1                           date,
    coupon_interest_rate_1                          numeric(45, 20),
    effective_date_rate_2                           date,
    coupon_interest_rate_2                          numeric(45, 20),
    effective_date_rate_3                           date,
    coupon_interest_rate_3                          numeric(45, 20),
    effective_date_rate_4                           date,
    coupon_interest_rate_4                          numeric(45, 20),
    oas_treasury_rate                               numeric(45, 20),
    oas_treasury_effective_date                     date,
    minimum_piece                                   numeric(45, 20),
    minimum_increment                               numeric(45, 20),
    issue_date_security                             date
);

create unique index sfl_isca_historica_ui_cusip_fecha
    on pershing.sfl_isca_historica (process_date, cusip_number);

create unique index sfl_isca_historica_ui_cusip_proceso
    on pershing.sfl_isca_historica (id_proceso, process_date, cusip_number);

create table pershing.sfl_gmon_historica
(
    id                        bigint generated always as identity
        constraint sfl_gmon_historica_pk
            primary key,
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
    masked_house_call         numeric(45, 20)
);

create unique index sfl_gmon_historica_ui_account_fecha
    on pershing.sfl_gmon_historica (process_date, account_number);

create unique index sfl_gmon_historica_ui_account_proceso
    on pershing.sfl_gmon_historica (id_proceso, process_date, account_number);






--========================================================================
--========================================================================
--========================================================================
--Rutinas schema pershing

create procedure pershing.pa_procesa_isrc(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
DECLARE _row_count  BIGINT;
begin

    DELETE FROM pershing.sfl_isrc tb_sfl WHERE tb_sfl.process_date= (SELECT tb_proc.process_date FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso);

    INSERT INTO pershing.sfl_isrc (id_proceso, process_date, record_secuence_id, record_id_number, change_id, source_code, source_code_desc_line_1, source_code_desc_line_2, source_code_desc_line_3, tax_status, user_id, date_added, date_updated, ira_income_eligible, retail_income_eligible, customer_firm, cerdit_debit, statement_ind, statement_act_sum_ind, statement_act_sum_number, statement_trx_sum_ind, statement_trx_sum_number, statement_distrib_ind, statement_distrib_number, statement_distrib_tax_ind, statement_div_ind, statement_div_number, statement_div_tax_ind, pershing_depart, pershing_grp, user_id_added, user_id_updated, portfolio_eligible_ind, reinvest_ind)
    SELECT
        reg_header.id_proceso, reg_header.process_date, record_secuence_id, record_id_number, change_id, source_code, source_code_desc_line_1, source_code_desc_line_2, source_code_desc_line_3, tax_status, user_id, date_added, date_updated, ira_income_eligible, retail_income_eligible, customer_firm, cerdit_debit, statement_ind, statement_act_sum_ind, statement_act_sum_number, statement_trx_sum_ind, statement_trx_sum_number, statement_distrib_ind, statement_distrib_number, statement_distrib_tax_ind, statement_div_ind, statement_div_number, statement_div_tax_ind, pershing_depart, pershing_grp, user_id_added, user_id_updated, portfolio_eligible_ind, reinvest_ind
    FROM stage_pershing.stage_isrc_reg_header reg_header
    INNER JOIN stage_pershing.stage_isrc_reg_trailer reg_trailer
    ON reg_header.id_proceso=reg_trailer.id_proceso
    INNER JOIN stage_pershing.stage_isrc_reg_a reg_a
    ON reg_header.id_proceso=reg_a.id_proceso
    WHERE reg_header.id_proceso=_id_proceso
    ;

    GET DIAGNOSTICS _row_count = ROW_COUNT;
    IF(FOUND) THEN
        TRUNCATE TABLE pershing.sfl_isrc_actual;

        INSERT INTO pershing.sfl_isrc_actual (id_proceso, process_date, record_secuence_id, record_id_number, change_id, source_code, source_code_desc_line_1, source_code_desc_line_2, source_code_desc_line_3, tax_status, user_id, date_added, date_updated, ira_income_eligible, retail_income_eligible, customer_firm, cerdit_debit, statement_ind, statement_act_sum_ind, statement_act_sum_number, statement_trx_sum_ind, statement_trx_sum_number, statement_distrib_ind, statement_distrib_number, statement_distrib_tax_ind, statement_div_ind, statement_div_number, statement_div_tax_ind, pershing_depart, pershing_grp, user_id_added, user_id_updated, portfolio_eligible_ind, reinvest_ind)
        SELECT
            isrc_his.id_proceso, isrc_his.process_date, isrc_his.record_secuence_id, isrc_his.record_id_number, isrc_his.change_id, isrc_his.source_code, isrc_his.source_code_desc_line_1, isrc_his.source_code_desc_line_2, isrc_his.source_code_desc_line_3, isrc_his.tax_status, isrc_his.user_id, isrc_his.date_added, isrc_his.date_updated, isrc_his.ira_income_eligible, isrc_his.retail_income_eligible, isrc_his.customer_firm, isrc_his.cerdit_debit, isrc_his.statement_ind, isrc_his.statement_act_sum_ind, isrc_his.statement_act_sum_number, isrc_his.statement_trx_sum_ind, isrc_his.statement_trx_sum_number, isrc_his.statement_distrib_ind, isrc_his.statement_distrib_number, isrc_his.statement_distrib_tax_ind, isrc_his.statement_div_ind, isrc_his.statement_div_number, isrc_his.statement_div_tax_ind, isrc_his.pershing_depart, isrc_his.pershing_grp, isrc_his.user_id_added, isrc_his.user_id_updated, isrc_his.portfolio_eligible_ind, isrc_his.reinvest_ind
        FROM pershing.sfl_isrc isrc_his WHERE isrc_his.id_proceso=_id_proceso
        ;
    END IF;
end;
$$;

create procedure pershing.pa_procesa_isca(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _process_date VARCHAR(100);
DECLARE _last_process_date VARCHAR(100);
begin

    SELECT tb_proc.process_date INTO _process_date
    FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso;

    DELETE FROM pershing.sfl_isca tb_sfl WHERE tb_sfl.process_date= _process_date;

    INSERT INTO pershing.sfl_isca (id_proceso, process_date, cusip_number, security_type, security_modifier, security_calculation_code, primary_exchange, coupon_rate_fis_or_indicated_dividend_eq, maturity_option_expire_date, underlying_security_cusip, first_call_price_fix_inc_or_strike_price_option, first_par_call_price_fix_inc_or_units_option, primary_symbol, interest_frequency, bond_class, first_coupon_day, call_indicator, put_indicator, next_par_call_date, prerefunded_date, next_premium_call_date, dated_date_for_fix_inc_or_ex_dividend_date_eq, first_coupon_fix_inc_or_payable_date_eq, federal_marginable_ind, cns_eligible_code, dtcc_eligible_code, nscc_eligible_code, foreign_security, second_coupon_day, dividend_interest_payment_method, minor_product_code, etf_indicator, bid_price, ask_price, previous_day_price, latest_price, end_of_month_price, round_lot_quantity, dividend_reinvestment_eligibility_indicator, previous_price_date, latest_price_date, end_of_month_price_date, record_date, fundvest_ind, country_code, standard_poor_rating, moodys_rating, bond_sub_class, restriction_indicator, trace_indicator, new_interest_calculation_code, sic_code, state_tax_ind, fts_ind, amt_ind, ric_indicator, number_of_description_lines, secutiry_description_line_1, secutiry_description_line_2, secutiry_description_line_3, secutiry_description_line_4, secutiry_description_line_5, user_cusip_identifier, price_purge_date, taxable_indicator, secutiry_description_line_6, put_price, put_date, second_premium_call_price, second_premium_call_date, called_date, pool_number, factor, factor_date, previous_factor, previous_factor_date, variable_rate_indicator, next_last_coupon_date, structured_product_ind, perpetual_bond_indicator, exp_first_call_price, exp_first_par_call_price, exp_put_price, exp_second_premium_call_price, name_issuer_security, issuing_currency, globally_locked_sec_ind, globally_locked_reason_code, spac_ind, eor, expanded_bid_price, expanded_ask_price, expanded_previous_day_price, expanded_latest_price, expanded_end_of_month_price, contract_share_quantity, year_covered_under_cost_basis_rules, delta, delta_value_presence_ind, isin_code, issuer_identifier, symbol_of_the_underlying_security, asset_type, asset_subtype, asset_subsubtype, payment_day_delays, exchange_rate_denom_currency_usd, underlying_cusip_1, deliverable_unit_quantity_1, underlying_cusip_2, deliverable_unit_quantity_2, underlying_cusip_3, deliverable_unit_quantity_3, underlying_cusip_4, deliverable_unit_quantity_4, annual_dividend_currency_code, outstanding_shares, option_root_id, expiration_date, call_put_indicator, strike_price, fund_type, broad_narrow_indicator, leverage_factor, outstanding_shares_update_date, expanded_symbol, state_of_issuance, option_excercise_pricing_model_code, first_accrual_date, tranche_code, worthless_security_indicator, uit_termination_code, fdic_certification_number, revenue_stream, restricted_marijuana_ind, factored_market_value_multiplier, current_yield, yield, price_source, country_of_origin, retricted_security_code, international_non_dollar_symbol, international_exchange, variable_rate_category_code, interest_rate_completion_ind, exchange_code_sedol_1, sedol_1, exchange_code_sedol_2, sedol_2, exchange_code_sedol_3, sedol_3, exchange_code_sedol_4, sedol_4, exchange_code_sedol_5, sedol_5, exchange_code_sedol_6, sedol_6, exchange_code_sedol_7, sedol_7, exchange_code_sedol_8, sedol_8, exchange_code_sedol_9, sedol_9, exchange_code_sedol_10, sedol_10, exchange_code_sedol_11, sedol_11, primary_idc_mkt_exch, primary_mkt_exch_trading_status, primary_mkt_symbol, primary_mkt_exch_effective_date, primary_mkt_status_code, secondary_idc_mkt_exch, secondary_mkt_exch_trading_status, secondary_mkt_symbol, secondary_mkt_exch_effective_date, secondary_mkt_status_code, tick_size_pilot_group, tick_size_effective_date, tick_size_change_date, update_date, oas_libor_rate, first_call_date, first_call_price, second_call_date, second_call_price, third_call_date, third_call_price, fourth_call_date, fourth_call_price, effective_date_rate_1, coupon_interest_rate_1, effective_date_rate_2, coupon_interest_rate_2, effective_date_rate_3, coupon_interest_rate_3, effective_date_rate_4, coupon_interest_rate_4, oas_treasury_rate, oas_treasury_effective_date, minimum_piece, minimum_increment, issue_date_security)
    SELECT
        reg_header.id_proceso, reg_header.process_date, reg_a.cusip_number, security_type, security_modifier, security_calculation_code, primary_exchange, coupon_rate_fis_or_indicated_dividend_eq, maturity_option_expire_date, underlying_security_cusip, first_call_price_fix_inc_or_strike_price_option, first_par_call_price_fix_inc_or_units_option, primary_symbol, interest_frequency, bond_class, first_coupon_day, call_indicator, put_indicator, next_par_call_date, prerefunded_date, next_premium_call_date, dated_date_for_fix_inc_or_ex_dividend_date_eq, first_coupon_fix_inc_or_payable_date_eq, federal_marginable_ind, cns_eligible_code, dtcc_eligible_code, nscc_eligible_code, foreign_security, second_coupon_day, dividend_interest_payment_method, minor_product_code, etf_indicator, bid_price, ask_price, previous_day_price, reg_b.latest_price, end_of_month_price, round_lot_quantity, dividend_reinvestment_eligibility_indicator, previous_price_date, reg_b.latest_price_date, end_of_month_price_date, record_date, fundvest_ind, country_code, standard_poor_rating, moodys_rating, bond_sub_class, restriction_indicator, trace_indicator, new_interest_calculation_code, sic_code, state_tax_ind, fts_ind, amt_ind, ric_indicator, number_of_description_lines, secutiry_description_line_1, secutiry_description_line_2, secutiry_description_line_3, secutiry_description_line_4, secutiry_description_line_5, user_cusip_identifier, price_purge_date, taxable_indicator, secutiry_description_line_6, put_price, put_date, second_premium_call_price, second_premium_call_date, called_date, pool_number, factor, factor_date, previous_factor, previous_factor_date, variable_rate_indicator, next_last_coupon_date, structured_product_ind, perpetual_bond_indicator, exp_first_call_price, exp_first_par_call_price, exp_put_price, exp_second_premium_call_price, name_issuer_security, issuing_currency, globally_locked_sec_ind, globally_locked_reason_code, spac_ind, reg_a.eor, expanded_bid_price, expanded_ask_price, expanded_previous_day_price, expanded_latest_price, expanded_end_of_month_price, contract_share_quantity, year_covered_under_cost_basis_rules,
        delta*public.fn_convierte_signo_factor(reg_g.delta_sign), delta_value_presence_ind, isin_code, issuer_identifier, symbol_of_the_underlying_security, asset_type, asset_subtype, asset_subsubtype, payment_day_delays, exchange_rate_denom_currency_usd, underlying_cusip_1, deliverable_unit_quantity_1, underlying_cusip_2, deliverable_unit_quantity_2, underlying_cusip_3, deliverable_unit_quantity_3, underlying_cusip_4, deliverable_unit_quantity_4, annual_dividend_currency_code, outstanding_shares, option_root_id, expiration_date, call_put_indicator, strike_price, fund_type, broad_narrow_indicator,
        leverage_factor*public.fn_convierte_signo_factor(reg_i.leverage_factor_sign), outstanding_shares_update_date, expanded_symbol, state_of_issuance, option_excercise_pricing_model_code, first_accrual_date, tranche_code, worthless_security_indicator, uit_termination_code, fdic_certification_number, revenue_stream, restricted_marijuana_ind, factored_market_value_multiplier, current_yield, yield, price_source, country_of_origin, retricted_security_code, international_non_dollar_symbol, international_exchange, variable_rate_category_code, interest_rate_completion_ind, exchange_code_sedol_1, sedol_1, exchange_code_sedol_2, sedol_2, exchange_code_sedol_3, sedol_3, exchange_code_sedol_4, sedol_4, exchange_code_sedol_5, sedol_5, exchange_code_sedol_6, sedol_6, exchange_code_sedol_7, sedol_7, exchange_code_sedol_8, sedol_8, exchange_code_sedol_9, sedol_9, exchange_code_sedol_10, sedol_10, exchange_code_sedol_11, sedol_11, primary_idc_mkt_exch, primary_mkt_exch_trading_status, primary_mkt_symbol, primary_mkt_exch_effective_date, primary_mkt_status_code, secondary_idc_mkt_exch, secondary_mkt_exch_trading_status, secondary_mkt_symbol, secondary_mkt_exch_effective_date, secondary_mkt_status_code, tick_size_pilot_group, tick_size_effective_date, tick_size_change_date, update_date,
        oas_libor_rate*public.fn_convierte_signo_factor(reg_l.oas_libor_rate_sign), first_call_date, first_call_price, second_call_date, second_call_price, third_call_date, third_call_price, fourth_call_date, fourth_call_price, effective_date_rate_1, coupon_interest_rate_1, effective_date_rate_2, coupon_interest_rate_2, effective_date_rate_3, coupon_interest_rate_3, effective_date_rate_4, coupon_interest_rate_4,
        oas_treasury_rate*public.fn_convierte_signo_factor(reg_o.oas_treasury_rate_sign), oas_treasury_effective_date, minimum_piece, minimum_increment, issue_date_security
    FROM stage_pershing.stage_isca_reg_header reg_header
    INNER JOIN stage_pershing.stage_isca_reg_trailer reg_trailer
    ON reg_header.id_proceso=reg_trailer.id_proceso
    INNER JOIN stage_pershing.stage_isca_reg_a reg_a
    ON reg_header.id_proceso=reg_a.id_proceso
    LEFT JOIN stage_pershing.stage_isca_reg_b reg_b
    ON reg_header.id_proceso=reg_b.id_proceso AND reg_a.cusip_number=reg_b.cusip_number
    LEFT JOIN stage_pershing.stage_isca_reg_c reg_c
    ON reg_header.id_proceso=reg_c.id_proceso AND reg_a.cusip_number=reg_c.cusip_number
    LEFT JOIN stage_pershing.stage_isca_reg_d reg_d
    ON reg_header.id_proceso=reg_d.id_proceso AND reg_a.cusip_number=reg_d.cusip_number
    LEFT JOIN stage_pershing.stage_isca_reg_e reg_e
    ON reg_header.id_proceso=reg_e.id_proceso AND reg_a.cusip_number=reg_e.cusip_number
    LEFT JOIN stage_pershing.stage_isca_reg_f reg_f
    ON reg_header.id_proceso=reg_f.id_proceso AND reg_a.cusip_number=reg_f.cusip_number
    LEFT JOIN stage_pershing.stage_isca_reg_g reg_g
    ON reg_header.id_proceso=reg_g.id_proceso AND reg_a.cusip_number=reg_g.cusip_number
    LEFT JOIN stage_pershing.stage_isca_reg_h reg_h
    ON reg_header.id_proceso=reg_h.id_proceso AND reg_a.cusip_number=reg_h.cusip_number
    LEFT JOIN stage_pershing.stage_isca_reg_i reg_i
    ON reg_header.id_proceso=reg_i.id_proceso AND reg_a.cusip_number=reg_i.cusip_number
    LEFT JOIN stage_pershing.stage_isca_reg_j reg_j
    ON reg_header.id_proceso=reg_j.id_proceso AND reg_a.cusip_number=reg_j.cusip_number
    LEFT JOIN stage_pershing.stage_isca_reg_k reg_k
    ON reg_header.id_proceso=reg_k.id_proceso AND reg_a.cusip_number=reg_k.cusip_number
    LEFT JOIN stage_pershing.stage_isca_reg_l reg_l
    ON reg_header.id_proceso=reg_l.id_proceso AND reg_a.cusip_number=reg_l.cusip_number
    LEFT JOIN stage_pershing.stage_isca_reg_m reg_m
    ON reg_header.id_proceso=reg_m.id_proceso AND reg_a.cusip_number=reg_m.cusip_number
    LEFT JOIN stage_pershing.stage_isca_reg_n reg_n
    ON reg_header.id_proceso=reg_n.id_proceso AND reg_a.cusip_number=reg_n.cusip_number
    LEFT JOIN stage_pershing.stage_isca_reg_o reg_o
    ON reg_header.id_proceso=reg_o.id_proceso AND reg_a.cusip_number=reg_o.cusip_number
    WHERE reg_header.id_proceso=_id_proceso
    ;


    DELETE FROM pershing.sfl_isca_historica WHERE process_date=_process_date;

    --Si no se cargaron datos y no existe SFL
    IF ( (SELECT count(*) FROM pershing.sfl_isca where process_date=_process_date)=0
        AND
         (SELECT count(*) FROM stage_pershing.stage_isca_reg_header where process_date=_process_date)=0 ) THEN
        --Replicar data ultimo process date disponible
        SELECT max(process_date) INTO _last_process_date
        FROM pershing.sfl_isca where process_date<=_process_date;

        INSERT INTO pershing.sfl_isca_historica (id_proceso, process_date, cusip_number, security_type, security_modifier, security_calculation_code, primary_exchange, coupon_rate_fis_or_indicated_dividend_eq, maturity_option_expire_date, underlying_security_cusip, first_call_price_fix_inc_or_strike_price_option, first_par_call_price_fix_inc_or_units_option, primary_symbol, interest_frequency, bond_class, first_coupon_day, call_indicator, put_indicator, next_par_call_date, prerefunded_date, next_premium_call_date, dated_date_for_fix_inc_or_ex_dividend_date_eq, first_coupon_fix_inc_or_payable_date_eq, federal_marginable_ind, cns_eligible_code, dtcc_eligible_code, nscc_eligible_code, foreign_security, second_coupon_day, dividend_interest_payment_method, minor_product_code, etf_indicator, bid_price, ask_price, previous_day_price, latest_price, end_of_month_price, round_lot_quantity, dividend_reinvestment_eligibility_indicator, previous_price_date, latest_price_date, end_of_month_price_date, record_date, fundvest_ind, country_code, standard_poor_rating, moodys_rating, bond_sub_class, restriction_indicator, trace_indicator, new_interest_calculation_code, sic_code, state_tax_ind, fts_ind, amt_ind, ric_indicator, number_of_description_lines, secutiry_description_line_1, secutiry_description_line_2, secutiry_description_line_3, secutiry_description_line_4, secutiry_description_line_5, user_cusip_identifier, price_purge_date, taxable_indicator, secutiry_description_line_6, put_price, put_date, second_premium_call_price, second_premium_call_date, called_date, pool_number, factor, factor_date, previous_factor, previous_factor_date, variable_rate_indicator, next_last_coupon_date, structured_product_ind, perpetual_bond_indicator, exp_first_call_price, exp_first_par_call_price, exp_put_price, exp_second_premium_call_price, name_issuer_security, issuing_currency, globally_locked_sec_ind, globally_locked_reason_code, spac_ind, eor, expanded_bid_price, expanded_ask_price, expanded_previous_day_price, expanded_latest_price, expanded_end_of_month_price, contract_share_quantity, year_covered_under_cost_basis_rules, delta, delta_value_presence_ind, isin_code, issuer_identifier, symbol_of_the_underlying_security, asset_type, asset_subtype, asset_subsubtype, payment_day_delays, exchange_rate_denom_currency_usd, underlying_cusip_1, deliverable_unit_quantity_1, underlying_cusip_2, deliverable_unit_quantity_2, underlying_cusip_3, deliverable_unit_quantity_3, underlying_cusip_4, deliverable_unit_quantity_4, annual_dividend_currency_code, outstanding_shares, option_root_id, expiration_date, call_put_indicator, strike_price, fund_type, broad_narrow_indicator, leverage_factor, outstanding_shares_update_date, expanded_symbol, state_of_issuance, option_excercise_pricing_model_code, first_accrual_date, tranche_code, worthless_security_indicator, uit_termination_code, fdic_certification_number, revenue_stream, restricted_marijuana_ind, factored_market_value_multiplier, current_yield, yield, price_source, country_of_origin, retricted_security_code, international_non_dollar_symbol, international_exchange, variable_rate_category_code, interest_rate_completion_ind, exchange_code_sedol_1, sedol_1, exchange_code_sedol_2, sedol_2, exchange_code_sedol_3, sedol_3, exchange_code_sedol_4, sedol_4, exchange_code_sedol_5, sedol_5, exchange_code_sedol_6, sedol_6, exchange_code_sedol_7, sedol_7, exchange_code_sedol_8, sedol_8, exchange_code_sedol_9, sedol_9, exchange_code_sedol_10, sedol_10, exchange_code_sedol_11, sedol_11, primary_idc_mkt_exch, primary_mkt_exch_trading_status, primary_mkt_symbol, primary_mkt_exch_effective_date, primary_mkt_status_code, secondary_idc_mkt_exch, secondary_mkt_exch_trading_status, secondary_mkt_symbol, secondary_mkt_exch_effective_date, secondary_mkt_status_code, tick_size_pilot_group, tick_size_effective_date, tick_size_change_date, update_date, oas_libor_rate, first_call_date, first_call_price, second_call_date, second_call_price, third_call_date, third_call_price, fourth_call_date, fourth_call_price, effective_date_rate_1, coupon_interest_rate_1, effective_date_rate_2, coupon_interest_rate_2, effective_date_rate_3, coupon_interest_rate_3, effective_date_rate_4, coupon_interest_rate_4, oas_treasury_rate, oas_treasury_effective_date, minimum_piece, minimum_increment, issue_date_security)
        SELECT
            isca_his.id_proceso, _process_date as process_date, isca_his.cusip_number, isca_his.security_type, isca_his.security_modifier, isca_his.security_calculation_code, isca_his.primary_exchange, isca_his.coupon_rate_fis_or_indicated_dividend_eq, isca_his.maturity_option_expire_date, isca_his.underlying_security_cusip, isca_his.first_call_price_fix_inc_or_strike_price_option, isca_his.first_par_call_price_fix_inc_or_units_option, isca_his.primary_symbol, isca_his.interest_frequency, isca_his.bond_class, isca_his.first_coupon_day, isca_his.call_indicator, isca_his.put_indicator, isca_his.next_par_call_date, isca_his.prerefunded_date, isca_his.next_premium_call_date, isca_his.dated_date_for_fix_inc_or_ex_dividend_date_eq, isca_his.first_coupon_fix_inc_or_payable_date_eq, isca_his.federal_marginable_ind, isca_his.cns_eligible_code, isca_his.dtcc_eligible_code, isca_his.nscc_eligible_code, isca_his.foreign_security, isca_his.second_coupon_day, isca_his.dividend_interest_payment_method, isca_his.minor_product_code, isca_his.etf_indicator, isca_his.bid_price, isca_his.ask_price, isca_his.previous_day_price, isca_his.latest_price, isca_his.end_of_month_price, isca_his.round_lot_quantity, isca_his.dividend_reinvestment_eligibility_indicator, isca_his.previous_price_date, isca_his.latest_price_date, isca_his.end_of_month_price_date, isca_his.record_date, isca_his.fundvest_ind, isca_his.country_code, isca_his.standard_poor_rating, isca_his.moodys_rating, isca_his.bond_sub_class, isca_his.restriction_indicator, isca_his.trace_indicator, isca_his.new_interest_calculation_code, isca_his.sic_code, isca_his.state_tax_ind, isca_his.fts_ind, isca_his.amt_ind, isca_his.ric_indicator, isca_his.number_of_description_lines, isca_his.secutiry_description_line_1, isca_his.secutiry_description_line_2, isca_his.secutiry_description_line_3, isca_his.secutiry_description_line_4, isca_his.secutiry_description_line_5, isca_his.user_cusip_identifier, isca_his.price_purge_date, isca_his.taxable_indicator, isca_his.secutiry_description_line_6, isca_his.put_price, isca_his.put_date, isca_his.second_premium_call_price, isca_his.second_premium_call_date, isca_his.called_date, isca_his.pool_number, isca_his.factor, isca_his.factor_date, isca_his.previous_factor, isca_his.previous_factor_date, isca_his.variable_rate_indicator, isca_his.next_last_coupon_date, isca_his.structured_product_ind, isca_his.perpetual_bond_indicator, isca_his.exp_first_call_price, isca_his.exp_first_par_call_price, isca_his.exp_put_price, isca_his.exp_second_premium_call_price, isca_his.name_issuer_security, isca_his.issuing_currency, isca_his.globally_locked_sec_ind, isca_his.globally_locked_reason_code, isca_his.spac_ind, isca_his.eor, isca_his.expanded_bid_price, isca_his.expanded_ask_price, isca_his.expanded_previous_day_price, isca_his.expanded_latest_price, isca_his.expanded_end_of_month_price, isca_his.contract_share_quantity, isca_his.year_covered_under_cost_basis_rules, isca_his.delta, isca_his.delta_value_presence_ind, isca_his.isin_code, isca_his.issuer_identifier, isca_his.symbol_of_the_underlying_security, isca_his.asset_type, isca_his.asset_subtype, isca_his.asset_subsubtype, isca_his.payment_day_delays, isca_his.exchange_rate_denom_currency_usd, isca_his.underlying_cusip_1, isca_his.deliverable_unit_quantity_1, isca_his.underlying_cusip_2, isca_his.deliverable_unit_quantity_2, isca_his.underlying_cusip_3, isca_his.deliverable_unit_quantity_3, isca_his.underlying_cusip_4, isca_his.deliverable_unit_quantity_4, isca_his.annual_dividend_currency_code, isca_his.outstanding_shares, isca_his.option_root_id, isca_his.expiration_date, isca_his.call_put_indicator, isca_his.strike_price, isca_his.fund_type, isca_his.broad_narrow_indicator, isca_his.leverage_factor, isca_his.outstanding_shares_update_date, isca_his.expanded_symbol, isca_his.state_of_issuance, isca_his.option_excercise_pricing_model_code, isca_his.first_accrual_date, isca_his.tranche_code, isca_his.worthless_security_indicator, isca_his.uit_termination_code, isca_his.fdic_certification_number, isca_his.revenue_stream, isca_his.restricted_marijuana_ind, isca_his.factored_market_value_multiplier, isca_his.current_yield, isca_his.yield, isca_his.price_source, isca_his.country_of_origin, isca_his.retricted_security_code, isca_his.international_non_dollar_symbol, isca_his.international_exchange, isca_his.variable_rate_category_code, isca_his.interest_rate_completion_ind, isca_his.exchange_code_sedol_1, isca_his.sedol_1, isca_his.exchange_code_sedol_2, isca_his.sedol_2, isca_his.exchange_code_sedol_3, isca_his.sedol_3, isca_his.exchange_code_sedol_4, isca_his.sedol_4, isca_his.exchange_code_sedol_5, isca_his.sedol_5, isca_his.exchange_code_sedol_6, isca_his.sedol_6, isca_his.exchange_code_sedol_7, isca_his.sedol_7, isca_his.exchange_code_sedol_8, isca_his.sedol_8, isca_his.exchange_code_sedol_9, isca_his.sedol_9, isca_his.exchange_code_sedol_10, isca_his.sedol_10, isca_his.exchange_code_sedol_11, isca_his.sedol_11, isca_his.primary_idc_mkt_exch, isca_his.primary_mkt_exch_trading_status, isca_his.primary_mkt_symbol, isca_his.primary_mkt_exch_effective_date, isca_his.primary_mkt_status_code, isca_his.secondary_idc_mkt_exch, isca_his.secondary_mkt_exch_trading_status, isca_his.secondary_mkt_symbol, isca_his.secondary_mkt_exch_effective_date, isca_his.secondary_mkt_status_code, isca_his.tick_size_pilot_group, isca_his.tick_size_effective_date, isca_his.tick_size_change_date, isca_his.update_date, isca_his.oas_libor_rate, isca_his.first_call_date, isca_his.first_call_price, isca_his.second_call_date, isca_his.second_call_price, isca_his.third_call_date, isca_his.third_call_price, isca_his.fourth_call_date, isca_his.fourth_call_price, isca_his.effective_date_rate_1, isca_his.coupon_interest_rate_1, isca_his.effective_date_rate_2, isca_his.coupon_interest_rate_2, isca_his.effective_date_rate_3, isca_his.coupon_interest_rate_3, isca_his.effective_date_rate_4, isca_his.coupon_interest_rate_4, isca_his.oas_treasury_rate, isca_his.oas_treasury_effective_date, isca_his.minimum_piece, isca_his.minimum_increment, isca_his.issue_date_security
        FROM pershing.sfl_isca isca_his
        WHERE isca_his.process_date=_last_process_date;

    ELSE

        INSERT INTO pershing.sfl_isca_historica (id_proceso, process_date, cusip_number, security_type, security_modifier, security_calculation_code, primary_exchange, coupon_rate_fis_or_indicated_dividend_eq, maturity_option_expire_date, underlying_security_cusip, first_call_price_fix_inc_or_strike_price_option, first_par_call_price_fix_inc_or_units_option, primary_symbol, interest_frequency, bond_class, first_coupon_day, call_indicator, put_indicator, next_par_call_date, prerefunded_date, next_premium_call_date, dated_date_for_fix_inc_or_ex_dividend_date_eq, first_coupon_fix_inc_or_payable_date_eq, federal_marginable_ind, cns_eligible_code, dtcc_eligible_code, nscc_eligible_code, foreign_security, second_coupon_day, dividend_interest_payment_method, minor_product_code, etf_indicator, bid_price, ask_price, previous_day_price, latest_price, end_of_month_price, round_lot_quantity, dividend_reinvestment_eligibility_indicator, previous_price_date, latest_price_date, end_of_month_price_date, record_date, fundvest_ind, country_code, standard_poor_rating, moodys_rating, bond_sub_class, restriction_indicator, trace_indicator, new_interest_calculation_code, sic_code, state_tax_ind, fts_ind, amt_ind, ric_indicator, number_of_description_lines, secutiry_description_line_1, secutiry_description_line_2, secutiry_description_line_3, secutiry_description_line_4, secutiry_description_line_5, user_cusip_identifier, price_purge_date, taxable_indicator, secutiry_description_line_6, put_price, put_date, second_premium_call_price, second_premium_call_date, called_date, pool_number, factor, factor_date, previous_factor, previous_factor_date, variable_rate_indicator, next_last_coupon_date, structured_product_ind, perpetual_bond_indicator, exp_first_call_price, exp_first_par_call_price, exp_put_price, exp_second_premium_call_price, name_issuer_security, issuing_currency, globally_locked_sec_ind, globally_locked_reason_code, spac_ind, eor, expanded_bid_price, expanded_ask_price, expanded_previous_day_price, expanded_latest_price, expanded_end_of_month_price, contract_share_quantity, year_covered_under_cost_basis_rules, delta, delta_value_presence_ind, isin_code, issuer_identifier, symbol_of_the_underlying_security, asset_type, asset_subtype, asset_subsubtype, payment_day_delays, exchange_rate_denom_currency_usd, underlying_cusip_1, deliverable_unit_quantity_1, underlying_cusip_2, deliverable_unit_quantity_2, underlying_cusip_3, deliverable_unit_quantity_3, underlying_cusip_4, deliverable_unit_quantity_4, annual_dividend_currency_code, outstanding_shares, option_root_id, expiration_date, call_put_indicator, strike_price, fund_type, broad_narrow_indicator, leverage_factor, outstanding_shares_update_date, expanded_symbol, state_of_issuance, option_excercise_pricing_model_code, first_accrual_date, tranche_code, worthless_security_indicator, uit_termination_code, fdic_certification_number, revenue_stream, restricted_marijuana_ind, factored_market_value_multiplier, current_yield, yield, price_source, country_of_origin, retricted_security_code, international_non_dollar_symbol, international_exchange, variable_rate_category_code, interest_rate_completion_ind, exchange_code_sedol_1, sedol_1, exchange_code_sedol_2, sedol_2, exchange_code_sedol_3, sedol_3, exchange_code_sedol_4, sedol_4, exchange_code_sedol_5, sedol_5, exchange_code_sedol_6, sedol_6, exchange_code_sedol_7, sedol_7, exchange_code_sedol_8, sedol_8, exchange_code_sedol_9, sedol_9, exchange_code_sedol_10, sedol_10, exchange_code_sedol_11, sedol_11, primary_idc_mkt_exch, primary_mkt_exch_trading_status, primary_mkt_symbol, primary_mkt_exch_effective_date, primary_mkt_status_code, secondary_idc_mkt_exch, secondary_mkt_exch_trading_status, secondary_mkt_symbol, secondary_mkt_exch_effective_date, secondary_mkt_status_code, tick_size_pilot_group, tick_size_effective_date, tick_size_change_date, update_date, oas_libor_rate, first_call_date, first_call_price, second_call_date, second_call_price, third_call_date, third_call_price, fourth_call_date, fourth_call_price, effective_date_rate_1, coupon_interest_rate_1, effective_date_rate_2, coupon_interest_rate_2, effective_date_rate_3, coupon_interest_rate_3, effective_date_rate_4, coupon_interest_rate_4, oas_treasury_rate, oas_treasury_effective_date, minimum_piece, minimum_increment, issue_date_security)
        SELECT
            isca_his.id_proceso, _process_date as process_date, isca_his.cusip_number, isca_his.security_type, isca_his.security_modifier, isca_his.security_calculation_code, isca_his.primary_exchange, isca_his.coupon_rate_fis_or_indicated_dividend_eq, isca_his.maturity_option_expire_date, isca_his.underlying_security_cusip, isca_his.first_call_price_fix_inc_or_strike_price_option, isca_his.first_par_call_price_fix_inc_or_units_option, isca_his.primary_symbol, isca_his.interest_frequency, isca_his.bond_class, isca_his.first_coupon_day, isca_his.call_indicator, isca_his.put_indicator, isca_his.next_par_call_date, isca_his.prerefunded_date, isca_his.next_premium_call_date, isca_his.dated_date_for_fix_inc_or_ex_dividend_date_eq, isca_his.first_coupon_fix_inc_or_payable_date_eq, isca_his.federal_marginable_ind, isca_his.cns_eligible_code, isca_his.dtcc_eligible_code, isca_his.nscc_eligible_code, isca_his.foreign_security, isca_his.second_coupon_day, isca_his.dividend_interest_payment_method, isca_his.minor_product_code, isca_his.etf_indicator, isca_his.bid_price, isca_his.ask_price, isca_his.previous_day_price, isca_his.latest_price, isca_his.end_of_month_price, isca_his.round_lot_quantity, isca_his.dividend_reinvestment_eligibility_indicator, isca_his.previous_price_date, isca_his.latest_price_date, isca_his.end_of_month_price_date, isca_his.record_date, isca_his.fundvest_ind, isca_his.country_code, isca_his.standard_poor_rating, isca_his.moodys_rating, isca_his.bond_sub_class, isca_his.restriction_indicator, isca_his.trace_indicator, isca_his.new_interest_calculation_code, isca_his.sic_code, isca_his.state_tax_ind, isca_his.fts_ind, isca_his.amt_ind, isca_his.ric_indicator, isca_his.number_of_description_lines, isca_his.secutiry_description_line_1, isca_his.secutiry_description_line_2, isca_his.secutiry_description_line_3, isca_his.secutiry_description_line_4, isca_his.secutiry_description_line_5, isca_his.user_cusip_identifier, isca_his.price_purge_date, isca_his.taxable_indicator, isca_his.secutiry_description_line_6, isca_his.put_price, isca_his.put_date, isca_his.second_premium_call_price, isca_his.second_premium_call_date, isca_his.called_date, isca_his.pool_number, isca_his.factor, isca_his.factor_date, isca_his.previous_factor, isca_his.previous_factor_date, isca_his.variable_rate_indicator, isca_his.next_last_coupon_date, isca_his.structured_product_ind, isca_his.perpetual_bond_indicator, isca_his.exp_first_call_price, isca_his.exp_first_par_call_price, isca_his.exp_put_price, isca_his.exp_second_premium_call_price, isca_his.name_issuer_security, isca_his.issuing_currency, isca_his.globally_locked_sec_ind, isca_his.globally_locked_reason_code, isca_his.spac_ind, isca_his.eor, isca_his.expanded_bid_price, isca_his.expanded_ask_price, isca_his.expanded_previous_day_price, isca_his.expanded_latest_price, isca_his.expanded_end_of_month_price, isca_his.contract_share_quantity, isca_his.year_covered_under_cost_basis_rules, isca_his.delta, isca_his.delta_value_presence_ind, isca_his.isin_code, isca_his.issuer_identifier, isca_his.symbol_of_the_underlying_security, isca_his.asset_type, isca_his.asset_subtype, isca_his.asset_subsubtype, isca_his.payment_day_delays, isca_his.exchange_rate_denom_currency_usd, isca_his.underlying_cusip_1, isca_his.deliverable_unit_quantity_1, isca_his.underlying_cusip_2, isca_his.deliverable_unit_quantity_2, isca_his.underlying_cusip_3, isca_his.deliverable_unit_quantity_3, isca_his.underlying_cusip_4, isca_his.deliverable_unit_quantity_4, isca_his.annual_dividend_currency_code, isca_his.outstanding_shares, isca_his.option_root_id, isca_his.expiration_date, isca_his.call_put_indicator, isca_his.strike_price, isca_his.fund_type, isca_his.broad_narrow_indicator, isca_his.leverage_factor, isca_his.outstanding_shares_update_date, isca_his.expanded_symbol, isca_his.state_of_issuance, isca_his.option_excercise_pricing_model_code, isca_his.first_accrual_date, isca_his.tranche_code, isca_his.worthless_security_indicator, isca_his.uit_termination_code, isca_his.fdic_certification_number, isca_his.revenue_stream, isca_his.restricted_marijuana_ind, isca_his.factored_market_value_multiplier, isca_his.current_yield, isca_his.yield, isca_his.price_source, isca_his.country_of_origin, isca_his.retricted_security_code, isca_his.international_non_dollar_symbol, isca_his.international_exchange, isca_his.variable_rate_category_code, isca_his.interest_rate_completion_ind, isca_his.exchange_code_sedol_1, isca_his.sedol_1, isca_his.exchange_code_sedol_2, isca_his.sedol_2, isca_his.exchange_code_sedol_3, isca_his.sedol_3, isca_his.exchange_code_sedol_4, isca_his.sedol_4, isca_his.exchange_code_sedol_5, isca_his.sedol_5, isca_his.exchange_code_sedol_6, isca_his.sedol_6, isca_his.exchange_code_sedol_7, isca_his.sedol_7, isca_his.exchange_code_sedol_8, isca_his.sedol_8, isca_his.exchange_code_sedol_9, isca_his.sedol_9, isca_his.exchange_code_sedol_10, isca_his.sedol_10, isca_his.exchange_code_sedol_11, isca_his.sedol_11, isca_his.primary_idc_mkt_exch, isca_his.primary_mkt_exch_trading_status, isca_his.primary_mkt_symbol, isca_his.primary_mkt_exch_effective_date, isca_his.primary_mkt_status_code, isca_his.secondary_idc_mkt_exch, isca_his.secondary_mkt_exch_trading_status, isca_his.secondary_mkt_symbol, isca_his.secondary_mkt_exch_effective_date, isca_his.secondary_mkt_status_code, isca_his.tick_size_pilot_group, isca_his.tick_size_effective_date, isca_his.tick_size_change_date, isca_his.update_date, isca_his.oas_libor_rate, isca_his.first_call_date, isca_his.first_call_price, isca_his.second_call_date, isca_his.second_call_price, isca_his.third_call_date, isca_his.third_call_price, isca_his.fourth_call_date, isca_his.fourth_call_price, isca_his.effective_date_rate_1, isca_his.coupon_interest_rate_1, isca_his.effective_date_rate_2, isca_his.coupon_interest_rate_2, isca_his.effective_date_rate_3, isca_his.coupon_interest_rate_3, isca_his.effective_date_rate_4, isca_his.coupon_interest_rate_4, isca_his.oas_treasury_rate, isca_his.oas_treasury_effective_date, isca_his.minimum_piece, isca_his.minimum_increment, isca_his.issue_date_security
        FROM pershing.sfl_isca isca_his
        WHERE isca_his.process_date=_process_date
        ;
    END IF;

end;
$$;

create procedure pershing.pa_procesa_gact(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
begin

    DELETE FROM pershing.sfl_gact tb_sfl WHERE tb_sfl.process_date= (SELECT tb_proc.process_date FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso);
--public.fn_convierte_signo_factor(
    INSERT INTO pershing.sfl_gact (id_proceso, process_date, record_id_sequence_number, account_number, cusip_number, underlying_cusip, security_symbol, investment_professional_of_record, executing_investment_professional, transaction_type, buy_sell_code, open_close_indicator, par_key_code, source_code, maxx_key_code, process_date_sfl, trade_date, settlement_entry_date, source_of_input, reference_number, batch_code, same_day_settlement, contra_account, market_code, blotter_code, cancel_code, correction_code, merket_limit_indicator, legend_code_1, legend_code_2, quantity, price_in_trade_currency, currency_indicator_for_price, net_amount_in_usd, principal_in_usd, interest_in_usd, commision_in_usd, tax_in_usd, transaction_fee_in_usd, misc_fee_in_usd, other_fee_in_usd, tefra_wh_amount_in_usd, pershing_charge_in_usd, brokerage_charge_in_usd, sales_credit_in_usd, settlement_fee_in_usd, service_charge_in_usd, markup_markdown_amount_in_usd, dividend_payable_date, dividend_record_date, dividend_type, shares_of_record_quantity_for_dividends, order_size_quantity, pool_factor, parsed_customer_account_number, ibd_number, security_type_code, security_modifier_code, security_calculation_code, minor_product_code, foreign_product_indicator, with_due_bill_indicator, taxable_municipal_bond_indicator, omnibus_indicator, external_order_id, market_value_of_transaction, ip_number_parsed, reported_price, previous_day_market_value_of_transaction, price_in_usd, option_root_id, expiration_date, put_call_code, strike_price, repo_identifier, taxable, qualified, expanded_ip_number, expanded_exec_ip_number, expanded_legacy_ip_number, security_currency_of_issuance, trade_currency_code, settlement_currency_code, settlement_usd_currency_fx_rate, settlement_usd_multiply_divide_code, cross_currency_fx_rate, currency_multiply_divide_code, accrued_interest_in_settlement_currency, internal_reference_for_gloss, ibd_version, net_amount_in_settlement_currency, principal_amount_in_settlement_currency, interest_in_settlement_currency, commission_in_settlement_currency, tax_in_settlement_currency, transaction_fee_in_settlement_currency, miscellaneous_fee_in_settlement_currency, other_fee_in_settlement_currency, sales_credit_in_settlement_currency, settlement_fee_in_settlement_currency, service_charge_in_settlement_currency, markup_markdown_in_settlement_currency, global_exchange, number_of_description_lines, last_description_line, description_line_1, description_line_2, description_line_3, description_line_4, description_line_5, description_line_6, description_line_7, description_line_8, description_line_9, description_line_10, description_line_11, description_line_12, security_currency_indicator, market_mnemonic_code, ccy_of_issuance_usd_ccy_fx_rate, ccy_of_issuance_usd_multiply_divide_code, alternate_security_id_type, alternate_security_id, alternate_security_id_type_2, alternate_security_id_2, international_non_dollar_symbol, confirmation_code_1, confirmation_code_2, confirmation_code_3, confirmation_code_4, pmp, total_amount_mark_up_down, pmp_percent)
    SELECT
        reg_header.id_proceso, reg_header.process_date, reg_a.record_id_sequence_number, reg_a.account_number, reg_a.cusip_number, underlying_cusip, security_symbol, investment_professional_of_record, executing_investment_professional, transaction_type, buy_sell_code, open_close_indicator, par_key_code, source_code, maxx_key_code, process_date_sfl, trade_date, settlement_entry_date, source_of_input, reference_number, batch_code, same_day_settlement, contra_account, reg_a.market_code, blotter_code, cancel_code, correction_code, merket_limit_indicator, legend_code_1, legend_code_2,
        quantity*public.fn_convierte_signo_factor(quantity_sign) as quantity,
        price_in_trade_currency*public.fn_convierte_signo_factor(price_in_trade_currency_sign) as price_in_trade_currency, currency_indicator_for_price,
        net_amount_in_usd*public.fn_convierte_signo_factor(net_amount_in_usd_sign) as net_amount_in_usd,
        principal_in_usd*public.fn_convierte_signo_factor(principal_in_usd_sign) as principal_in_usd,
        interest_in_usd*public.fn_convierte_signo_factor(interest_in_usd_sign) as interest_in_usd,
        commision_in_usd*public.fn_convierte_signo_factor(commision_in_usd_sign) as commision_in_usd,
        tax_in_usd*public.fn_convierte_signo_factor(tax_in_usd_sign) as tax_in_usd,
        transaction_fee_in_usd*public.fn_convierte_signo_factor(transaction_fee_in_usd_sign) as transaction_fee_in_usd,
        misc_fee_in_usd*public.fn_convierte_signo_factor(misc_fee_in_usd_sign) as misc_fee_in_usd,
        other_fee_in_usd*public.fn_convierte_signo_factor(other_fee_in_usd_sign) as other_fee_in_usd,
        tefra_wh_amount_in_usd*public.fn_convierte_signo_factor(tefra_wh_amount_in_usd_sign) as tefra_wh_amount_in_usd,
        pershing_charge_in_usd*public.fn_convierte_signo_factor(pershing_charge_in_usd_sign) as pershing_charge_in_usd,
        brokerage_charge_in_usd*public.fn_convierte_signo_factor(brokerage_charge_in_usd_sign) as brokerage_charge_in_usd,
        sales_credit_in_usd*public.fn_convierte_signo_factor(sales_credit_in_usd_sign) as sales_credit_in_usd,
        settlement_fee_in_usd*public.fn_convierte_signo_factor(settlement_fee_in_usd_sign) as settlement_fee_in_usd,
        service_charge_in_usd*public.fn_convierte_signo_factor(service_charge_in_usd_sign) as service_charge_in_usd,
        markup_markdown_amount_in_usd*public.fn_convierte_signo_factor(markup_markdown_amount_in_usd_sign) as markup_markdown_amount_in_usd, dividend_payable_date, dividend_record_date, dividend_type, shares_of_record_quantity_for_dividends, order_size_quantity, pool_factor, parsed_customer_account_number, ibd_number, security_type_code, security_modifier_code, security_calculation_code, minor_product_code, foreign_product_indicator, with_due_bill_indicator, taxable_municipal_bond_indicator, omnibus_indicator, external_order_id, market_value_of_transaction, ip_number_parsed,
        reported_price*public.fn_convierte_signo_factor(reported_price_sign) as reported_price, previous_day_market_value_of_transaction, price_in_usd, option_root_id, expiration_date, put_call_code, strike_price, repo_identifier, taxable, qualified, expanded_ip_number, expanded_exec_ip_number, expanded_legacy_ip_number, security_currency_of_issuance, trade_currency_code, settlement_currency_code, settlement_usd_currency_fx_rate, settlement_usd_multiply_divide_code, cross_currency_fx_rate, currency_multiply_divide_code,
        accrued_interest_in_settlement_currency*public.fn_convierte_signo_factor(accrued_interest_in_settlement_currency_sign) as accrued_interest_in_settlement_currency, internal_reference_for_gloss, ibd_version,
        net_amount_in_settlement_currency*public.fn_convierte_signo_factor(net_amount_in_settlement_currency_sign) as net_amount_in_settlement_currency,
        principal_amount_in_settlement_currency*public.fn_convierte_signo_factor(principal_amount_in_settlement_currency_sign) as principal_amount_in_settlement_currency,
        interest_in_settlement_currency*public.fn_convierte_signo_factor(interest_in_settlement_currency_sign) as interest_in_settlement_currency,
        commission_in_settlement_currency*public.fn_convierte_signo_factor(commission_in_settlement_currency_sign) as commission_in_settlement_currency,
        tax_in_settlement_currency*public.fn_convierte_signo_factor(tax_in_settlement_currency_sign) as tax_in_settlement_currency,
        transaction_fee_in_settlement_currency*public.fn_convierte_signo_factor(transaction_fee_in_settlement_currency_sign) as transaction_fee_in_settlement_currency,
        miscellaneous_fee_in_settlement_currency*public.fn_convierte_signo_factor(miscellaneous_fee_in_settlement_currency_sign) as miscellaneous_fee_in_settlement_currency,
        other_fee_in_settlement_currency*public.fn_convierte_signo_factor(other_fee_in_settlement_currency_sign) as other_fee_in_settlement_currency,
        sales_credit_in_settlement_currency*public.fn_convierte_signo_factor(sales_credit_in_settlement_currency_sign) as sales_credit_in_settlement_currency,
        settlement_fee_in_settlement_currency*public.fn_convierte_signo_factor(settlement_fee_in_settlement_currency_sign) as settlement_fee_in_settlement_currency,
        service_charge_in_settlement_currency*public.fn_convierte_signo_factor(service_charge_in_settlement_currency_sign) as service_charge_in_settlement_currency,
        markup_markdown_in_settlement_currency*public.fn_convierte_signo_factor(markup_markdown_in_settlement_currency_sign) as markup_markdown_in_settlement_currency, global_exchange, number_of_description_lines, last_description_line, description_line_1, description_line_2, description_line_3, description_line_4, description_line_5, description_line_6, description_line_7, description_line_8, description_line_9, description_line_10, description_line_11, description_line_12, security_currency_indicator, market_mnemonic_code, ccy_of_issuance_usd_ccy_fx_rate, ccy_of_issuance_usd_multiply_divide_code, alternate_security_id_type, alternate_security_id, alternate_security_id_type_2, alternate_security_id_2, international_non_dollar_symbol, confirmation_code_1, confirmation_code_2, confirmation_code_3, confirmation_code_4, pmp,
        total_amount_mark_up_down*public.fn_convierte_signo_factor(total_amount_mark_up_down_sign) as total_amount_mark_up_down, pmp_percent
    FROM stage_pershing.stage_gact_reg_header reg_header
    INNER JOIN stage_pershing.stage_gact_reg_trailer reg_trailer
    ON reg_header.id_proceso=reg_trailer.id_proceso
    INNER JOIN stage_pershing.stage_gact_reg_a reg_a
    ON reg_header.id_proceso=reg_a.id_proceso
    LEFT JOIN stage_pershing.stage_gact_reg_b reg_b
    ON reg_header.id_proceso=reg_b.id_proceso AND reg_a.record_id_sequence_number=reg_b.record_id_sequence_number
    WHERE reg_header.id_proceso=_id_proceso
    ;
end;
$$;

create procedure pershing.pa_procesa_gcus(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
begin

    SELECT tb_proc.process_date INTO _process_date FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso;

    DELETE FROM pershing.sfl_gcus tb_sfl WHERE tb_sfl.process_date= (SELECT tb_proc.process_date FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso);
--public.fn_convierte_signo_factor(
    INSERT INTO pershing.sfl_gcus (id_proceso, process_date, record_id_sequence_number, account_number, cusip_number, portfolio_currency, underlying_cusip_number, country_code, ip_record_number, ibd_number, currency_security_indicator, issue_currency, datestamp_trade_date, datestamp_settlement_date, trade_date_quantity, settlement_date_quantity, seg_quantity, safekeeping_quantity, transfer_quantity, pending_transfer_quantity, legal_transfer_quantity, tendered_quantity, pending_papers, short_against_the_box_quantity, networked_quantity, pending_split_quantity, quantity_covering_options, trade_date_quantity_bought, trade_date_quantity_sold, fed_rquirement, house_margin_requirement, nyse_requirement, equity_requirment, security_symbol, security_type, security_mod, security_calc, minor_product_code, network_eligibility_indicator, strike_price, expiration_maturity_date, contract_size, conversion_ratio, account_short_name, state_code, country_code_account, number_security_description_lines, security_description_line_1, security_description_line_2, security_description_line_3, security_description_line_4, security_description_line_5, security_description_line_6, dividend_option, long_term_capital_gains_option, short_term_capital_gains_option, firm_trading_indicator, position_currency_security, trade_date_liquidating_value, pool_factor, exchange_rate, settlement_date_liquidating_value, alternate_security_id_type, alternate_security_id, position_currency, fully_paid_lending_quantity, fully_paid_lending_quantity_collateral_amount, option_root_id, expiration_date, call_put_indicator, trade_date_repo_quantity, settlement_date_repo_quantity, trade_date_reverse_repo_quantity, settlement_date_reverse_repo_quantity, collateral_pledge_quantity, corporate_exec_serv_collateral_pledge_quantity, trade_date_repo_liquidating_value, settlement_date_repo_liquidating_value, trade_date_reverse_repo_liquidating_value, settlement_date_reverse_repo_liquidating_value, collateral_pledge_liquidating_value, corporate_exec_serv_collateral_pledge_liquidating_value, trade_date_repo_loan_amount, settlement_date_repo_loan_amount, trade_date_reverse_repo_loan_amount, settlement_date_reverse_repo_loan_amount, accrued_interes_value, dividend_or_coupon_rate, pending_split_quantity_liquidating_value, internal_non_dollar_symbol, pledged_quantity)
    SELECT
        reg_header.id_proceso, reg_header.process_date, reg_a.record_id_sequence_number, reg_a.account_number, reg_a.cusip_number, portfolio_currency, reg_a.underlying_cusip_number, reg_a.country_code, reg_a.ip_record_number, reg_a.ibd_number, currency_security_indicator, issue_currency, datestamp_trade_date, datestamp_settlement_date,
        trade_date_quantity*public.fn_convierte_signo_factor(trade_date_quantity_sign) as trade_date_quantity,
        settlement_date_quantity*public.fn_convierte_signo_factor(settlement_date_quantity_sign) as settlement_date_quantity,
        seg_quantity*public.fn_convierte_signo_factor(seg_quantity_sign) as seg_quantity,
        safekeeping_quantity*public.fn_convierte_signo_factor(safekeeping_sign) as safekeeping_quantity,
        transfer_quantity*public.fn_convierte_signo_factor(transfer_quantity_sign) as transfer_quantity,
        pending_transfer_quantity*public.fn_convierte_signo_factor(pending_transfer_quantity_sign) as pending_transfer_quantity,
        legal_transfer_quantity*public.fn_convierte_signo_factor(legal_transfer_quantity_sign) as legal_transfer_quantity,
        tendered_quantity*public.fn_convierte_signo_factor(tendered_quantity_sign) as tendered_quantity,
        pending_papers*public.fn_convierte_signo_factor(pending_papers_sign) as pending_papers,
        short_against_the_box_quantity*public.fn_convierte_signo_factor(short_against_the_box_quantity_sign) as short_against_the_box_quantity,
        networked_quantity*public.fn_convierte_signo_factor(networked_quantity_sign) as networked_quantity,
        pending_split_quantity*public.fn_convierte_signo_factor(pending_split_quantity_sign) as pending_split_quantity,
        quantity_covering_options*public.fn_convierte_signo_factor(quantity_covering_options_sign) as quantity_covering_options,
        trade_date_quantity_bought*public.fn_convierte_signo_factor(trade_date_quantity_bought_sign) as trade_date_quantity_bought,
        trade_date_quantity_sold*public.fn_convierte_signo_factor(trade_date_quantity_sold_sign) as trade_date_quantity_sold,
        fed_rquirement*public.fn_convierte_signo_factor(fed_rquirement_sign) as fed_rquirement,
        house_margin_requirement*public.fn_convierte_signo_factor(house_margin_requirement_sign) as house_margin_requirement,
        nyse_requirement*public.fn_convierte_signo_factor(nyse_requirement_sign) as nyse_requirement,
        equity_requirment*public.fn_convierte_signo_factor(equity_requirment_sign) as equity_requirment, security_symbol, security_type, security_mod, security_calc, minor_product_code, network_eligibility_indicator,
        reg_a.strike_price*public.fn_convierte_signo_factor(reg_a.strike_price_sign) as strike_price, expiration_maturity_date, contract_size, conversion_ratio, account_short_name, state_code, country_code_account, number_security_description_lines, security_description_line_1, security_description_line_2, security_description_line_3, security_description_line_4, security_description_line_5, security_description_line_6, dividend_option, long_term_capital_gains_option, short_term_capital_gains_option, firm_trading_indicator, position_currency_security,
        trade_date_liquidating_value*public.fn_convierte_signo_factor(trade_date_liquidating_value_sign) as trade_date_liquidating_value,
        pool_factor*public.fn_convierte_signo_factor(pool_factor_sign) as pool_factor,
        exchange_rate*public.fn_convierte_signo_factor(exchange_rate_sign) as exchange_rate,
        settlement_date_liquidating_value*public.fn_convierte_signo_factor(settlement_date_liquidating_value_sign) as settlement_date_liquidating_value, alternate_security_id_type, alternate_security_id, position_currency,
        fully_paid_lending_quantity*public.fn_convierte_signo_factor(fully_paid_lending_quantity_sign) as fully_paid_lending_quantity,
        fully_paid_lending_quantity_collateral_amount*public.fn_convierte_signo_factor(fully_paid_lending_quantity_collateral_amount_sign) as fully_paid_lending_quantity_collateral_amount, option_root_id, expiration_date, call_put_indicator,
        trade_date_repo_quantity*public.fn_convierte_signo_factor(trade_date_repo_quantity_sign) as trade_date_repo_quantity,
        settlement_date_repo_quantity*public.fn_convierte_signo_factor(settlement_date_repo_quantity_sign) as settlement_date_repo_quantity,
        trade_date_reverse_repo_quantity*public.fn_convierte_signo_factor(trade_date_reverse_repo_quantity_sign) as trade_date_reverse_repo_quantity,
        settlement_date_reverse_repo_quantity*public.fn_convierte_signo_factor(settlement_date_reverse_repo_quantity_sign) as settlement_date_reverse_repo_quantity,
        collateral_pledge_quantity*public.fn_convierte_signo_factor(collateral_pledge_quantity_sign) as collateral_pledge_quantity,
        corporate_exec_serv_collateral_pledge_quantity*public.fn_convierte_signo_factor(corporate_exec_serv_collateral_pledge_quantity_sign) as corporate_exec_serv_collateral_pledge_quantity,
        trade_date_repo_liquidating_value*public.fn_convierte_signo_factor(trade_date_repo_liquidating_value_sign) as trade_date_repo_liquidating_value,
        settlement_date_repo_liquidating_value*public.fn_convierte_signo_factor(settlement_date_repo_liquidating_value_sign) as settlement_date_repo_liquidating_value,
        trade_date_reverse_repo_liquidating_value*public.fn_convierte_signo_factor(trade_date_reverse_repo_liquidating_value_sign) as trade_date_reverse_repo_liquidating_value,
        settlement_date_reverse_repo_liquidating_value*public.fn_convierte_signo_factor(settlement_date_reverse_repo_liquidating_value_sign) as settlement_date_reverse_repo_liquidating_value,
        collateral_pledge_liquidating_value*public.fn_convierte_signo_factor(collateral_pledge_liquidating_value_sign) as collateral_pledge_liquidating_value,
        corporate_exec_serv_collateral_pledge_liquidating_value*public.fn_convierte_signo_factor(corporate_exec_serv_collateral_pledge_liquidating_value_sign) as corporate_exec_serv_collateral_pledge_liquidating_value,
        trade_date_repo_loan_amount*public.fn_convierte_signo_factor(trade_date_repo_loan_amount_sign) as trade_date_repo_loan_amount,
        settlement_date_repo_loan_amount*public.fn_convierte_signo_factor(settlement_date_repo_loan_amount_sign) as settlement_date_repo_loan_amount,
        trade_date_reverse_repo_loan_amount*public.fn_convierte_signo_factor(trade_date_reverse_repo_loan_amount_sign) as trade_date_reverse_repo_loan_amount,
        settlement_date_reverse_repo_loan_amount*public.fn_convierte_signo_factor(settlement_date_reverse_repo_loan_amount_sign) as settlement_date_reverse_repo_loan_amount,
        accrued_interes_value*public.fn_convierte_signo_factor(accrued_interes_value_sign) as accrued_interes_value, dividend_or_coupon_rate,
        pending_split_quantity_liquidating_value*public.fn_convierte_signo_factor(pending_split_quantity_liquidating_value_sign) as pending_split_quantity_liquidating_value, internal_non_dollar_symbol,
        pledged_quantity*public.fn_convierte_signo_factor(pledged_quantity_sign) as pledged_quantity
    FROM stage_pershing.stage_gcus_reg_header reg_header
    INNER JOIN stage_pershing.stage_gcus_reg_trailer reg_trailer
    ON reg_header.id_proceso=reg_trailer.id_proceso
    INNER JOIN stage_pershing.stage_gcus_reg_a reg_a
    ON reg_header.id_proceso=reg_a.id_proceso
    LEFT JOIN stage_pershing.stage_gcus_reg_b reg_b
    ON reg_header.id_proceso=reg_b.id_proceso AND reg_a.account_number=reg_b.account_number AND reg_a.cusip_number=reg_b.cusip_number AND reg_a.record_id_sequence_number=reg_b.recor_id_sequence_number
    WHERE reg_header.id_proceso=_id_proceso
    ;

    CALL pershing.pa_gcus_calcula_custodia(_process_date);
end;
$$;

create procedure pershing.pa_procesa_gmon(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _process_date VARCHAR(100);
DECLARE _last_process_date VARCHAR(100);
begin

    SELECT tb_proc.process_date INTO _process_date
    FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso;

    DELETE FROM pershing.sfl_gmon tb_sfl WHERE tb_sfl.process_date= _process_date;
--public.fn_convierte_signo_factor(
    INSERT INTO pershing.sfl_gmon (id_proceso, process_date, record_id_sequence_number, account_number, ip_number, ibd_number, usde_td_balance, usd_td_balance, long_td_market, short_td_market, td_liquidating_equity, total_usde_td_balance, total_equity, trade_date_net_worth, mmf_principal_balance, mmf_dividend, cash_available, date_of_data, usde_sd_balance, usd_sd_balance, long_sd_market, short_sd_market, sma_date_stamp, sma_balance, margin_buying_power, technical_short_value, total_fed_requirement, total_options_requirement, base_currency, non_usd_currency, masked_house_call)
    SELECT
        reg_header.id_proceso, reg_header.process_date, reg_a.record_id_sequence_number, reg_a.account_number, reg_a.ip_number, reg_a.ibd_number,
        usde_td_balance*public.fn_convierte_signo_factor(usde_td_balance_sign) as usde_td_balance,
        usd_td_balance*public.fn_convierte_signo_factor(usd_td_balance_sign) as usd_td_balance,
        long_td_market*public.fn_convierte_signo_factor(long_td_market_sign) as long_td_market,
        short_td_market*public.fn_convierte_signo_factor(short_td_market_sign) as short_td_market,
        td_liquidating_equity*public.fn_convierte_signo_factor(td_liquidating_equity_sign) as td_liquidating_equity,
        total_usde_td_balance*public.fn_convierte_signo_factor(total_usde_td_balance_sign) as total_usde_td_balance,
        total_equity*public.fn_convierte_signo_factor(total_equity_sign) as total_equity,
        trade_date_net_worth*public.fn_convierte_signo_factor(trade_date_net_worth_sign) as trade_date_net_worth,
        mmf_principal_balance*public.fn_convierte_signo_factor(mmf_principal_balance_sign) as mmf_principal_balance,
        mmf_dividend*public.fn_convierte_signo_factor(mmf_dividend_sign) as mmf_dividend,
        cash_available*public.fn_convierte_signo_factor(cash_available_sign) as cash_available, reg_a.date_of_data,
        usde_sd_balance*public.fn_convierte_signo_factor(usde_sd_balance_sign) as usde_sd_balance,
        usd_sd_balance*public.fn_convierte_signo_factor(usd_sd_balance_sign) as usd_sd_balance,
        long_sd_market*public.fn_convierte_signo_factor(long_sd_market_sign) as long_sd_market,
        short_sd_market*public.fn_convierte_signo_factor(short_sd_market_sign) as short_sd_market, sma_date_stamp,
        sma_balance*public.fn_convierte_signo_factor(sma_balance_sign) as sma_balance,
        margin_buying_power*public.fn_convierte_signo_factor(margin_buying_power_sign) as margin_buying_power,
        technical_short_value*public.fn_convierte_signo_factor(technical_short_value_sign) as technical_short_value,
        total_fed_requirement*public.fn_convierte_signo_factor(total_fed_requirement_sign) as total_fed_requirement,
        total_options_requirement*public.fn_convierte_signo_factor(total_options_requirement_sign) as total_options_requirement, base_currency, non_usd_currency,
        masked_house_call*public.fn_convierte_signo_factor(masked_house_call_sign) as masked_house_call
    FROM stage_pershing.stage_gmon_reg_header reg_header
    INNER JOIN stage_pershing.stage_gmon_reg_trailer reg_trailer
    ON reg_header.id_proceso=reg_trailer.id_proceso
    INNER JOIN stage_pershing.stage_gmon_reg_a reg_a
    ON reg_header.id_proceso=reg_a.id_proceso
    LEFT JOIN stage_pershing.stage_gmon_reg_b reg_b
    ON reg_header.id_proceso=reg_b.id_proceso AND reg_a.account_number=reg_b.account_number
    WHERE reg_header.id_proceso=_id_proceso
    ;


    DELETE FROM pershing.sfl_gmon_historica WHERE process_date=_process_date;

    --Si no se cargaron datos y no existe SFL
    IF ( (SELECT count(*) FROM pershing.sfl_gmon where process_date=_process_date)=0
        AND
         (SELECT count(*) FROM stage_pershing.stage_gmon_reg_header where process_date=_process_date)=0 ) THEN
        --Replicar data ultimo process date disponible
        SELECT max(process_date) INTO _last_process_date
        FROM pershing.sfl_gmon where process_date<=_process_date;

        INSERT INTO pershing.sfl_gmon_historica (id_proceso, process_date, record_id_sequence_number, account_number, ip_number, ibd_number, usde_td_balance, usd_td_balance, long_td_market, short_td_market, td_liquidating_equity, total_usde_td_balance, total_equity, trade_date_net_worth, mmf_principal_balance, mmf_dividend, cash_available, date_of_data, usde_sd_balance, usd_sd_balance, long_sd_market, short_sd_market, sma_date_stamp, sma_balance, margin_buying_power, technical_short_value, total_fed_requirement, total_options_requirement, base_currency, non_usd_currency, masked_house_call)
        SELECT
            id_proceso, _process_date as process_date, record_id_sequence_number, account_number, ip_number, ibd_number, usde_td_balance, usd_td_balance, long_td_market, short_td_market, td_liquidating_equity, total_usde_td_balance, total_equity, trade_date_net_worth, mmf_principal_balance, mmf_dividend, cash_available, date_of_data, usde_sd_balance, usd_sd_balance, long_sd_market, short_sd_market, sma_date_stamp, sma_balance, margin_buying_power, technical_short_value, total_fed_requirement, total_options_requirement, base_currency, non_usd_currency, masked_house_call
        FROM pershing.sfl_gmon
        WHERE process_date=_last_process_date;
    ELSE

        INSERT INTO pershing.sfl_gmon_historica (id_proceso, process_date, record_id_sequence_number, account_number, ip_number, ibd_number, usde_td_balance, usd_td_balance, long_td_market, short_td_market, td_liquidating_equity, total_usde_td_balance, total_equity, trade_date_net_worth, mmf_principal_balance, mmf_dividend, cash_available, date_of_data, usde_sd_balance, usd_sd_balance, long_sd_market, short_sd_market, sma_date_stamp, sma_balance, margin_buying_power, technical_short_value, total_fed_requirement, total_options_requirement, base_currency, non_usd_currency, masked_house_call)
        SELECT
            gmon_his.id_proceso, _process_date as process_date, gmon_his.record_id_sequence_number, gmon_his.account_number, gmon_his.ip_number, gmon_his.ibd_number, gmon_his.usde_td_balance, gmon_his.usd_td_balance, gmon_his.long_td_market, gmon_his.short_td_market, gmon_his.td_liquidating_equity, gmon_his.total_usde_td_balance, gmon_his.total_equity, gmon_his.trade_date_net_worth, gmon_his.mmf_principal_balance, gmon_his.mmf_dividend, gmon_his.cash_available, gmon_his.date_of_data, gmon_his.usde_sd_balance, gmon_his.usd_sd_balance, gmon_his.long_sd_market, gmon_his.short_sd_market, gmon_his.sma_date_stamp, gmon_his.sma_balance, gmon_his.margin_buying_power, gmon_his.technical_short_value, gmon_his.total_fed_requirement, gmon_his.total_options_requirement, gmon_his.base_currency, gmon_his.non_usd_currency, gmon_his.masked_house_call
        FROM pershing.sfl_gmon gmon_his
        WHERE gmon_his.process_date=_process_date
        ;
    END IF;


end;
$$;

create function pershing.fn_proceso_sfl(_process_date character varying, _process_stamp_app character varying, _message character varying) returns pershing.proceso_sfl
    language plpgsql
as
$$
DECLARE _id_proceso_sfl bigint;
DECLARE _ahora timestamp;
DECLARE _proceso_sfl pershing.proceso_sfl;
    BEGIN
        _ahora              := now();

        SELECT id INTO _id_proceso_sfl FROM pershing.proceso_sfl WHERE process_date=_process_date AND process_stamp=_process_stamp_app;

        IF ( _id_proceso_sfl IS NULL) THEN
           --No existe proceso, lo creamos
            INSERT INTO pershing.proceso_sfl (process_date, process_stamp, start_timestamp, last_step_timestamp, info_log, id_estado_proceso_sfl)
            VALUES (_process_date, _process_stamp_app, _ahora, _ahora, 'Proceso iniciado||'||_message, -1);
           _id_proceso_sfl  := LASTVAL();
        ELSE
            --Actualizamos info
            UPDATE pershing.proceso_sfl SET
                last_step_timestamp = _ahora,
                info_log            = info_log||'||'||_message
            WHERE id=_id_proceso_sfl;
        END IF;

    SELECT * INTO _proceso_sfl FROM pershing.proceso_sfl WHERE id=_id_proceso_sfl;

    RETURN _proceso_sfl;
    END;
$$;

create procedure pershing.pa_procesa_acct(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
begin

    SELECT tb_proc.process_date INTO _process_date
    FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso;

    DELETE FROM pershing.sfl_acct tb_sfl WHERE tb_sfl.process_date= _process_date;
--public.fn_convierte_signo_factor(
    INSERT INTO pershing.sfl_acct (id_proceso, process_date, record_id_sequence_number, account_number, ibd_number, ip_number, account_short_name, transaction_type, autotitled_usertitled_account, account_type_code, registration_type, number_of_account_title_lines, account_registration_line_1, account_registration_line_2, account_registration_line_3, account_registration_line_4, account_registration_line_5, account_registration_line_6, registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions, income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked, statement_review_date, margin_papers_on_file, option_papers_on_file, good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted, third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits, option_total_limits_of_puts_and_calls, non_us_dollar_trading, non_customer_indicator, third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule, group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic, employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date, plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative, commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form, date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form, date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account, foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, primary_country_of_citizenship, country_of_residence, birth_date, age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status, regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, customer_type, fulfillment_method, credit_interest_indicator, ama_indicator, tax_id_type, tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced, date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced, date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced, date_c_notice_status_satisfied, old_account_number, original_account_open_date, unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date, initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code, future_statement_currency_code, future_statement_currency_code_effective_date, account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3, account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip, third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym, alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator, source_of_asset_at_acct_opening, commission_doscount_code, external_account_number, confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside, fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type, mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated, date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id, firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id, second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account, banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code, combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code, proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code, dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona, client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code, addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix, addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4, addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id, addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3, addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind, principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2, from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system, disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks, amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code, addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix, addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4, addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code, addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix, addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4, addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code, addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix, addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4, addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code, addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix, addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4, addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code, addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix, addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4, addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency, income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep, last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind, foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst, foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own, proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension, tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code, tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind, tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id, tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number, tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension, tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address, external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code, cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency)
    SELECT
        reg_a.id_proceso, reg_a.process_date, reg_a.record_id_sequence_number, reg_a.account_number, reg_a.ibd_number, reg_a.ip_number,
        reg_a.account_short_name, transaction_type, autotitled_usertitled_account, account_type_code, registration_type, number_of_account_title_lines, account_registration_line_1, account_registration_line_2, account_registration_line_3, account_registration_line_4, account_registration_line_5, account_registration_line_6, registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions, income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked, statement_review_date, margin_papers_on_file, option_papers_on_file, good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted, third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits, option_total_limits_of_puts_and_calls, reg_a.non_us_dollar_trading, non_customer_indicator, third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule, group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic, employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date, plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative, commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form, date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form, date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account, foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, primary_country_of_citizenship, country_of_residence, birth_date, age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status, regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, customer_type, fulfillment_method, credit_interest_indicator, ama_indicator, tax_id_type, tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced, date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced, date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced, date_c_notice_status_satisfied, old_account_number, original_account_open_date, unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date, initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code, future_statement_currency_code, future_statement_currency_code_effective_date, account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3, account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip, third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym, alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator, source_of_asset_at_acct_opening, commission_doscount_code, external_account_number, confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside, fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type, mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated, date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id, firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id, second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account, banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code, combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code, proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code, dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona, client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code, addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix, addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4, addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id, addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3, addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind, principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2, from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system, disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks, amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code, addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix, addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4, addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code, addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix, addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4, addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code, addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix, addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4, addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code, addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix, addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4, addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code, addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix, addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4, addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency, income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep, last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind, foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst, foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own, proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension, tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code, tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind, tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id, tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number, tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension, tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address, external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code, cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency
    FROM stage_pershing.stage_acct_reg_header reg_header
    INNER JOIN stage_pershing.stage_acct_reg_trailer reg_trailer
    ON reg_header.id_proceso=reg_trailer.id_proceso
    INNER JOIN stage_pershing.stage_acct_reg_a reg_a
    ON reg_header.id_proceso=reg_a.id_proceso
    LEFT JOIN stage_pershing.stage_acct_reg_b reg_b
    ON reg_header.id_proceso=reg_b.id_proceso AND reg_a.account_number=reg_b.account_number
    LEFT JOIN stage_pershing.stage_acct_reg_c reg_c
    ON reg_header.id_proceso=reg_c.id_proceso AND reg_a.account_number=reg_c.account_number
    LEFT JOIN stage_pershing.stage_acct_reg_d reg_d
    ON reg_header.id_proceso=reg_d.id_proceso AND reg_a.account_number=reg_d.account_number
    LEFT JOIN stage_pershing.stage_acct_reg_e reg_e
    ON reg_header.id_proceso=reg_e.id_proceso AND reg_a.account_number=reg_e.account_number
    LEFT JOIN stage_pershing.stage_acct_reg_f reg_f
    ON reg_header.id_proceso=reg_f.id_proceso AND reg_a.account_number=reg_f.account_number
    LEFT JOIN stage_pershing.stage_acct_reg_w reg_w
    ON reg_header.id_proceso=reg_w.id_proceso AND reg_a.account_number=reg_w.account_number
    WHERE reg_header.id_proceso=_id_proceso
    ;

    DELETE FROM pershing.sfl_acct_historica WHERE process_date=_process_date;

    INSERT INTO pershing.sfl_acct_historica (id_proceso, process_date, record_id_sequence_number, account_number, ibd_number, ip_number, account_short_name, transaction_type, autotitled_usertitled_account, account_type_code, registration_type, number_of_account_title_lines, account_registration_line_1, account_registration_line_2, account_registration_line_3, account_registration_line_4, account_registration_line_5, account_registration_line_6, registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions, income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked, statement_review_date, margin_papers_on_file, option_papers_on_file, good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted, third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits, option_total_limits_of_puts_and_calls, non_us_dollar_trading, non_customer_indicator, third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule, group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic, employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date, plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative, commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form, date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form, date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account, foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, primary_country_of_citizenship, country_of_residence, birth_date, age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status, regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, customer_type, fulfillment_method, credit_interest_indicator, ama_indicator, tax_id_type, tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced, date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced, date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced, date_c_notice_status_satisfied, old_account_number, original_account_open_date, unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date, initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code, future_statement_currency_code, future_statement_currency_code_effective_date, account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3, account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip, third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym, alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator, source_of_asset_at_acct_opening, commission_doscount_code, external_account_number, confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside, fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type, mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated, date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id, firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id, second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account, banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code, combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code, proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code, dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona, client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code, addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix, addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4, addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id, addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3, addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind, principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2, from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system, disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks, amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code, addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix, addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4, addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code, addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix, addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4, addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code, addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix, addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4, addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code, addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix, addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4, addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code, addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix, addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4, addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency, income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep, last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind, foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst, foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own, proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension, tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code, tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind, tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id, tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number, tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension, tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address, external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code, cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency)
    SELECT
        acct_his.id_proceso, _process_date as process_date, acct_his.record_id_sequence_number, acct_his.account_number, acct_his.ibd_number, acct_his.ip_number, acct_his.account_short_name, acct_his.transaction_type, acct_his.autotitled_usertitled_account, acct_his.account_type_code, acct_his.registration_type, acct_his.number_of_account_title_lines, acct_his.account_registration_line_1, acct_his.account_registration_line_2, acct_his.account_registration_line_3, acct_his.account_registration_line_4, acct_his.account_registration_line_5, acct_his.account_registration_line_6, acct_his.registration_type_detail, acct_his.date_account_opened, acct_his.date_account_information_updated, acct_his.account_status_indicator, acct_his.pending_closed_date, acct_his.date_account_closed, acct_his.closing_notice_date, acct_his.account_reactivated_date, acct_his.date_account_reopened, acct_his.proceeds, acct_his.transfer_instructions, acct_his.income_isntructions, acct_his.number_of_confirms_for_thi_account, acct_his.number_of_statements_for_this_account, acct_his.investment_objetive_trans_code, acct_his.comments_act, acct_his.employer_shotname, acct_his.employers_cusip, acct_his.employers_symbol, acct_his.margin_privileges_revoked, acct_his.statement_review_date, acct_his.margin_papers_on_file, acct_his.option_papers_on_file, acct_his.good_faith_margin, acct_his.ip_discretion_granted, acct_his.invest_advisor_discretion_granted, acct_his.third_party_discretion_granted, acct_his.third_party_name, acct_his.risk_factor_code, acct_his.investment_objetive_code, acct_his.option_equities, acct_his.option_index, acct_his.option_debt, acct_his.option_currency, acct_his.option_level_1, acct_his.option_level_2, acct_his.option_level_3, acct_his.option_level_4, acct_his.option_call_limits, acct_his.option_put_limits, acct_his.option_total_limits_of_puts_and_calls, acct_his.non_us_dollar_trading, acct_his.non_customer_indicator, acct_his.third_party_fee_indicator, acct_his.third_party_fee_approval_date, acct_his.intermediary_account_ind, acct_his.commission_schedule, acct_his.group_index, acct_his.money_manager_id, acct_his.money_manager_objective_id, acct_his.dtc_id_confirm_number, acct_his.caps_master_mnemonic, acct_his.employee_id, acct_his.prime_broker_free_fund_indicator, acct_his.fee_based_account_indicator, acct_his.fee_based_termination_date, acct_his.plan_name, acct_his.self_directed_401_k_account_type, acct_his.plan_type, acct_his.plan_number, acct_his.employee_or_employee_relative, acct_his.commission_percent_discount, acct_his.ind_12_b_1_fee_blocking, acct_his.name_of_ip_signed_new_account_form, acct_his.date_of_ip_signed_new_account_form, acct_his.name_of_principal_signed_new_account_form, acct_his.date_of_principal_signed_new_account_form, acct_his.politically_exposed_person, acct_his.private_banking_account, acct_his.foreign_bank_account, acct_his.initial_source_of_funds, acct_his.usa_patriot_act_exempt_reason, acct_his.primary_country_of_citizenship, acct_his.country_of_residence, acct_his.birth_date, acct_his.age_based_fund_roll_exempt, acct_his.money_fundreform_retail, acct_his.trusted_contact_status, acct_his.regulatory_account_type_category, acct_his.account_managed_by_trust_comp_id, acct_his.voting_auth, acct_his.customer_type, acct_his.fulfillment_method, acct_his.credit_interest_indicator, acct_his.ama_indicator, acct_his.tax_id_type, acct_his.tax_id_number, acct_his.date_tax_id_applied_for, acct_his.w_8_w_9_indicator, acct_his.w_8_w_9_date_signed, acct_his.w_8_w_9_effective_date, acct_his.w_8_w_9_document_type, acct_his.tax_status, acct_his.b_notice_reason_code, acct_his.first_b_notice_status, acct_his.date_first_b_notice_status_issued_enforced, acct_his.date_first_notice_status_satisfied, acct_his.second_b_notice_status, acct_his.date_second_b_notice_status_issued_enforced, acct_his.date_second_b_notice_status_satisfied, acct_his.c_notice_status, acct_his.date_c_notice_status_issued_enforced, acct_his.date_c_notice_status_satisfied, acct_his.old_account_number, acct_his.original_account_open_date, acct_his.unidentified_large_trader_id, acct_his.large_trader_type_code, acct_his.large_trader_type_last_change_date, acct_his.initial_source_of_funds_other, acct_his.finance_away, acct_his.account_funding_date, acct_his.statement_currency_code, acct_his.future_statement_currency_code, acct_his.future_statement_currency_code_effective_date, acct_his.account_level_routing_code_1, acct_his.account_level_routing_code_2, acct_his.account_level_routing_code_3, acct_his.account_level_routing_code_4, acct_his.self_directed_ind, acct_his.digital_advice_ind, acct_his.pte_account_ind, acct_his.first_ip, acct_his.second_ip, acct_his.third_ip, acct_his.fourth_ip, acct_his.fifth_ip, acct_his.sixth_ip, acct_his.seventh_ip, acct_his.eighth_ip, acct_his.ninth_ip, acct_his.tenth_ip, acct_his.alert_im_acornym, acct_his.alert_im_access_code, acct_his.broker_acronym, acct_his.cross_reference_indicator, acct_his.bny_trust_indicator, acct_his.source_of_asset_at_acct_opening, acct_his.commission_doscount_code, acct_his.external_account_number, acct_his.confirmation_suppression_indicator, acct_his.date_last_mail_sent, acct_his.date_last_mail_sent_outside, acct_his.fully_paid_lending_agreement_indicator, acct_his.fully_paid_lending_agreement_date, acct_his.custodian_account_type, acct_his.mifid_customer_categorization, acct_his.cash_management_tran_code, acct_his.sweep_status_indicator, acct_his.date_sweep_activated, acct_his.date_sweep_details_changed, acct_his.cober_margin_debit_indicator, acct_his.first_fund_sweep_account_id, acct_his.firstfund_sweep_account_percent, acct_his.first_fundsweep_account_redemption_priority, acct_his.second_fund_sweep_account_id, acct_his.second_fund_sweep_account_percent, acct_his.second_fundsweep_account_redemption_priority, acct_his.type_of_bank_account, acct_his.banklink_aba_number, acct_his.banklink_dda_number, acct_his.fund_bank_indicator, acct_his.w_9_corp_tax_classification_code, acct_his.combined_margin_acct_indicator, acct_his.pledge_collateral_account_indicator, acct_his.finra_institutional_account_code, acct_his.proposed_account_reference_id, acct_his.advisor_model_id, acct_his.firm_model_style_id, acct_his.dvp_restriction_code, acct_his.dvp_restriction_exp_date, acct_his.escheatment_withholding_ind, acct_his.source_of_origination, acct_his.source_of_persona, acct_his.client_onboarding_method, acct_his.tax_filing_code, acct_his.nor_purpose_collateral_acct_ind, acct_his.addr_1_trx_code, acct_his.addr_1_special_handling_ind, acct_his.addr_1_delivery_id, acct_his.addr_1_attention_line_prefix, acct_his.addr_1_attention_line_detail, acct_his.addr_1_line_1, acct_his.addr_1_line_2, acct_his.addr_1_line_3, acct_his.addr_1_line_4, acct_his.addr_1_city_state, acct_his.addr_1_country_code, acct_his.addr_2_trx_code, acct_his.addr_2_special_handling_ind, acct_his.addr_2_delivery_id, acct_his.addr_2_attention_line_prefix, acct_his.addr_2_attention_line_detail, acct_his.addr_2_line_1, acct_his.addr_2_line_2, acct_his.addr_2_line_3, acct_his.addr_2_line_4, acct_his.addr_2_city_state, acct_his.addr_2_country_code, acct_his.account_description, acct_his.set_as_mail_addr_2_ind, acct_his.principal_billing_allocation_pct, acct_his.seasonal_addr_id_1, acct_his.from_date_1, acct_his.to_date_1, acct_his.seasonal_addr_id_2, acct_his.from_date_2, acct_his.to_date_2, acct_his.seasonal_addr_id_3, acct_his.from_date_3, acct_his.to_date_3, acct_his.cost_basis_acct_system, acct_his.disposition_method_mutual_funds, acct_his.disposition_method_other, acct_his.disposition_method_stocks, acct_his.amortize_taxable_premium_bonds, acct_his.accrue_market_disc_based_on, acct_his.accrue_market_disc_income, acct_his.addr_3_trx_code, acct_his.addr_3_special_handling_ind, acct_his.addr_3_delivery_id, acct_his.addr_3_attention_line_prefix, acct_his.addr_3_attention_line_detail, acct_his.addr_3_line_1, acct_his.addr_3_line_2, acct_his.addr_3_line_3, acct_his.addr_3_line_4, acct_his.addr_3_city_state, acct_his.addr_3_country_code, acct_his.set_as_mail_addr_3_ind, acct_his.addr_4_trx_code, acct_his.addr_4_special_handling_ind, acct_his.addr_4_delivery_id, acct_his.addr_4_attention_line_prefix, acct_his.addr_4_attention_line_detail, acct_his.addr_4_line_1, acct_his.addr_4_line_2, acct_his.addr_4_line_3, acct_his.addr_4_line_4, acct_his.addr_4_city_state, acct_his.addr_4_country_code, acct_his.set_as_mail_addr_4_ind, acct_his.addr_5_trx_code, acct_his.addr_5_special_handling_ind, acct_his.addr_5_delivery_id, acct_his.addr_5_attention_line_prefix, acct_his.addr_5_attention_line_detail, acct_his.addr_5_line_1, acct_his.addr_5_line_2, acct_his.addr_5_line_3, acct_his.addr_5_line_4, acct_his.addr_5_city_state, acct_his.addr_5_country_code, acct_his.set_as_mail_addr_5_ind, acct_his.addr_6_trx_code, acct_his.addr_6_special_handling_ind, acct_his.addr_6_delivery_id, acct_his.addr_6_attention_line_prefix, acct_his.addr_6_attention_line_detail, acct_his.addr_6_line_1, acct_his.addr_6_line_2, acct_his.addr_6_line_3, acct_his.addr_6_line_4, acct_his.addr_6_city_state, acct_his.addr_6_country_code, acct_his.set_as_mail_addr_6_ind, acct_his.addr_7_trx_code, acct_his.addr_7_special_handling_ind, acct_his.addr_7_delivery_id, acct_his.addr_7_attention_line_prefix, acct_his.addr_7_attention_line_detail, acct_his.addr_7_line_1, acct_his.addr_7_line_2, acct_his.addr_7_line_3, acct_his.addr_7_line_4, acct_his.addr_7_city_state, acct_his.addr_7_country_code, acct_his.set_as_mail_addr_7_ind, acct_his.record_transaction_code, acct_his.base_currency, acct_his.income_currency, acct_his.statement_language, acct_his.statement_format_code, acct_his.msrb_statement_ind, acct_his.pep, acct_his.first_name_pep, acct_his.last_name_pep, acct_his.suffix_pep, acct_his.political_office_held, acct_his.country_of_office, acct_his.foreign_bank_account_ind, acct_his.foreign_bank_cert_date, acct_his.foreign_bank_cert_exp_date, acct_his.central_bank_ind, acct_his.acct_foreign_financial_inst, acct_his.foreign_bank_acct_oper_1, acct_his.foreign_bank_acct_oper_2, acct_his.foreign_bank_acct_oper_3, acct_his.number_people_own, acct_his.proprietary_acct_owned, acct_his.tel_1_transaction_code, acct_his.tel_1_us_ind, acct_his.tel_1_type_id, acct_his.tel_1_number, acct_his.tel_1_extension, acct_his.tel_2_transaction_code, acct_his.tel_2_us_ind, acct_his.tel_2_type_id, acct_his.tel_2_number, acct_his.tel_2_extension, acct_his.tel_3_transaction_code, acct_his.tel_3_us_ind, acct_his.tel_3_type_id, acct_his.tel_3_number, acct_his.tel_3_extension, acct_his.tel_4_transaction_code, acct_his.tel_4_us_ind, acct_his.tel_4_type_id, acct_his.tel_4_number, acct_his.tel_4_extension, acct_his.tel_5_transaction_code, acct_his.tel_5_us_ind, acct_his.tel_5_type_id, acct_his.tel_5_number, acct_his.tel_5_extension, acct_his.tel_6_transaction_code, acct_his.tel_6_us_ind, acct_his.tel_6_type_id, acct_his.tel_6_number, acct_his.tel_6_extension, acct_his.tel_7_transaction_code, acct_his.tel_7_us_ind, acct_his.tel_7_type_id, acct_his.tel_7_number, acct_his.tel_7_extension, acct_his.tel_8_transaction_code, acct_his.tel_8_us_ind, acct_his.tel_8_type_id, acct_his.tel_8_number, acct_his.tel_8_extension, acct_his.email_address, acct_his.external_position_ind, acct_his.purge_eligible_ind, acct_his.advisory_acct_ind, acct_his.product_profile_code, acct_his.cents_per_share_discount, acct_his.option_disclosure_date, acct_his.country_acct_level_tax_residency
    FROM pershing.sfl_acct acct_his
    INNER JOIN
    (
        SELECT max(acct_det.process_date) as process_date, acct_det.account_number
        FROM pershing.sfl_acct acct_det
        WHERE acct_det.process_date<=_process_date
        GROUP BY acct_det.account_number
    ) as acct_last
    ON acct_his.process_date=acct_last.process_date
    AND acct_his.account_number=acct_last.account_number
    ;
end;
$$;

create procedure pershing.pa_gcus_calcula_custodia(IN _process_date character varying)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
begin

    IF (_process_date IS NULL) THEN
        RAISE EXCEPTION 'Process Date no puede ser NULL';
    END IF;

    TRUNCATE TABLE pershing.sfl_gcus_actual;

    INSERT INTO pershing.sfl_gcus_actual (id_proceso, process_date, record_id_sequence_number, account_number, cusip_number, portfolio_currency, underlying_cusip_number, country_code, ip_record_number, ibd_number, currency_security_indicator, issue_currency, datestamp_trade_date, datestamp_settlement_date, trade_date_quantity, settlement_date_quantity, seg_quantity, safekeeping_quantity, transfer_quantity, pending_transfer_quantity, legal_transfer_quantity, tendered_quantity, pending_papers, short_against_the_box_quantity, networked_quantity, pending_split_quantity, quantity_covering_options, trade_date_quantity_bought, trade_date_quantity_sold, fed_rquirement, house_margin_requirement, nyse_requirement, equity_requirment, security_symbol, security_type, security_mod, security_calc, minor_product_code, network_eligibility_indicator, strike_price, expiration_maturity_date, contract_size, conversion_ratio, account_short_name, state_code, country_code_account, number_security_description_lines, security_description_line_1, security_description_line_2, security_description_line_3, security_description_line_4, security_description_line_5, security_description_line_6, dividend_option, long_term_capital_gains_option, short_term_capital_gains_option, firm_trading_indicator, position_currency_security, trade_date_liquidating_value, pool_factor, exchange_rate, settlement_date_liquidating_value, alternate_security_id_type, alternate_security_id, position_currency, fully_paid_lending_quantity, fully_paid_lending_quantity_collateral_amount, option_root_id, expiration_date, call_put_indicator, trade_date_repo_quantity, settlement_date_repo_quantity, trade_date_reverse_repo_quantity, settlement_date_reverse_repo_quantity, collateral_pledge_quantity, corporate_exec_serv_collateral_pledge_quantity, trade_date_repo_liquidating_value, settlement_date_repo_liquidating_value, trade_date_reverse_repo_liquidating_value, settlement_date_reverse_repo_liquidating_value, collateral_pledge_liquidating_value, corporate_exec_serv_collateral_pledge_liquidating_value, trade_date_repo_loan_amount, settlement_date_repo_loan_amount, trade_date_reverse_repo_loan_amount, settlement_date_reverse_repo_loan_amount, accrued_interes_value, dividend_or_coupon_rate, pending_split_quantity_liquidating_value, internal_non_dollar_symbol, pledged_quantity)
    SELECT tb_det.id_proceso, tb_det.process_date, tb_det.record_id_sequence_number, tb_det.account_number, tb_det.cusip_number, tb_det.portfolio_currency, tb_det.underlying_cusip_number, tb_det.country_code, tb_det.ip_record_number, tb_det.ibd_number, tb_det.currency_security_indicator, tb_det.issue_currency, tb_det.datestamp_trade_date, tb_det.datestamp_settlement_date, tb_det.trade_date_quantity, tb_det.settlement_date_quantity, tb_det.seg_quantity, tb_det.safekeeping_quantity, tb_det.transfer_quantity, tb_det.pending_transfer_quantity, tb_det.legal_transfer_quantity, tb_det.tendered_quantity, tb_det.pending_papers, tb_det.short_against_the_box_quantity, tb_det.networked_quantity, tb_det.pending_split_quantity, tb_det.quantity_covering_options, tb_det.trade_date_quantity_bought, tb_det.trade_date_quantity_sold, tb_det.fed_rquirement, tb_det.house_margin_requirement, tb_det.nyse_requirement, tb_det.equity_requirment, tb_det.security_symbol, tb_det.security_type, tb_det.security_mod, tb_det.security_calc, tb_det.minor_product_code, tb_det.network_eligibility_indicator, tb_det.strike_price, tb_det.expiration_maturity_date, tb_det.contract_size, tb_det.conversion_ratio, tb_det.account_short_name, tb_det.state_code, tb_det.country_code_account, tb_det.number_security_description_lines, tb_det.security_description_line_1, tb_det.security_description_line_2, tb_det.security_description_line_3, tb_det.security_description_line_4, tb_det.security_description_line_5, tb_det.security_description_line_6, tb_det.dividend_option, tb_det.long_term_capital_gains_option, tb_det.short_term_capital_gains_option, tb_det.firm_trading_indicator, tb_det.position_currency_security, tb_det.trade_date_liquidating_value, tb_det.pool_factor, tb_det.exchange_rate, tb_det.settlement_date_liquidating_value, tb_det.alternate_security_id_type, tb_det.alternate_security_id, tb_det.position_currency, tb_det.fully_paid_lending_quantity, tb_det.fully_paid_lending_quantity_collateral_amount, tb_det.option_root_id, tb_det.expiration_date, tb_det.call_put_indicator, tb_det.trade_date_repo_quantity, tb_det.settlement_date_repo_quantity, tb_det.trade_date_reverse_repo_quantity, tb_det.settlement_date_reverse_repo_quantity, tb_det.collateral_pledge_quantity, tb_det.corporate_exec_serv_collateral_pledge_quantity, tb_det.trade_date_repo_liquidating_value, tb_det.settlement_date_repo_liquidating_value, tb_det.trade_date_reverse_repo_liquidating_value, tb_det.settlement_date_reverse_repo_liquidating_value, tb_det.collateral_pledge_liquidating_value, tb_det.corporate_exec_serv_collateral_pledge_liquidating_value, tb_det.trade_date_repo_loan_amount, tb_det.settlement_date_repo_loan_amount, tb_det.trade_date_reverse_repo_loan_amount, tb_det.settlement_date_reverse_repo_loan_amount, tb_det.accrued_interes_value, tb_det.dividend_or_coupon_rate, tb_det.pending_split_quantity_liquidating_value, tb_det.internal_non_dollar_symbol, tb_det.pledged_quantity
    FROM pershing.sfl_gcus tb_det
    INNER JOIN
    (
        SELECT max(gcus_acum.process_date) as process_date, gcus_acum.account_number, gcus_acum.cusip_number, gcus_acum.currency_security_indicator
        FROM pershing.sfl_gcus gcus_acum
        WHERE gcus_acum.process_date<=_process_date
        GROUP BY gcus_acum.account_number, gcus_acum.cusip_number, gcus_acum.currency_security_indicator
    ) as tb_cab
    ON tb_det.process_date=tb_cab.process_date
    AND tb_det.account_number=tb_cab.account_number
    AND tb_det.cusip_number=tb_cab.cusip_number
    AND tb_det.currency_security_indicator=tb_cab.currency_security_indicator
    AND tb_det.process_date=tb_cab.process_date
    ;

    DELETE FROM pershing.sfl_gcus_historica gcus_del WHERE gcus_del.process_date=_process_date;

    INSERT INTO pershing.sfl_gcus_historica (id_proceso, process_date, record_id_sequence_number, account_number, cusip_number, portfolio_currency, underlying_cusip_number, country_code, ip_record_number, ibd_number, currency_security_indicator, issue_currency, datestamp_trade_date, datestamp_settlement_date, trade_date_quantity, settlement_date_quantity, seg_quantity, safekeeping_quantity, transfer_quantity, pending_transfer_quantity, legal_transfer_quantity, tendered_quantity, pending_papers, short_against_the_box_quantity, networked_quantity, pending_split_quantity, quantity_covering_options, trade_date_quantity_bought, trade_date_quantity_sold, fed_rquirement, house_margin_requirement, nyse_requirement, equity_requirment, security_symbol, security_type, security_mod, security_calc, minor_product_code, network_eligibility_indicator, strike_price, expiration_maturity_date, contract_size, conversion_ratio, account_short_name, state_code, country_code_account, number_security_description_lines, security_description_line_1, security_description_line_2, security_description_line_3, security_description_line_4, security_description_line_5, security_description_line_6, dividend_option, long_term_capital_gains_option, short_term_capital_gains_option, firm_trading_indicator, position_currency_security, trade_date_liquidating_value, pool_factor, exchange_rate, settlement_date_liquidating_value, alternate_security_id_type, alternate_security_id, position_currency, fully_paid_lending_quantity, fully_paid_lending_quantity_collateral_amount, option_root_id, expiration_date, call_put_indicator, trade_date_repo_quantity, settlement_date_repo_quantity, trade_date_reverse_repo_quantity, settlement_date_reverse_repo_quantity, collateral_pledge_quantity, corporate_exec_serv_collateral_pledge_quantity, trade_date_repo_liquidating_value, settlement_date_repo_liquidating_value, trade_date_reverse_repo_liquidating_value, settlement_date_reverse_repo_liquidating_value, collateral_pledge_liquidating_value, corporate_exec_serv_collateral_pledge_liquidating_value, trade_date_repo_loan_amount, settlement_date_repo_loan_amount, trade_date_reverse_repo_loan_amount, settlement_date_reverse_repo_loan_amount, accrued_interes_value, dividend_or_coupon_rate, pending_split_quantity_liquidating_value, internal_non_dollar_symbol, pledged_quantity)
    SELECT
        gcus_act.id_proceso, _process_date as process_date, gcus_act.record_id_sequence_number, gcus_act.account_number, gcus_act.cusip_number, gcus_act.portfolio_currency, gcus_act.underlying_cusip_number, gcus_act.country_code, gcus_act.ip_record_number, gcus_act.ibd_number, gcus_act.currency_security_indicator, gcus_act.issue_currency, gcus_act.datestamp_trade_date, gcus_act.datestamp_settlement_date, gcus_act.trade_date_quantity, gcus_act.settlement_date_quantity, gcus_act.seg_quantity, gcus_act.safekeeping_quantity, gcus_act.transfer_quantity, gcus_act.pending_transfer_quantity, gcus_act.legal_transfer_quantity, gcus_act.tendered_quantity, gcus_act.pending_papers, gcus_act.short_against_the_box_quantity, gcus_act.networked_quantity, gcus_act.pending_split_quantity, gcus_act.quantity_covering_options, gcus_act.trade_date_quantity_bought, gcus_act.trade_date_quantity_sold, gcus_act.fed_rquirement, gcus_act.house_margin_requirement, gcus_act.nyse_requirement, gcus_act.equity_requirment, gcus_act.security_symbol, gcus_act.security_type, gcus_act.security_mod, gcus_act.security_calc, gcus_act.minor_product_code, gcus_act.network_eligibility_indicator, gcus_act.strike_price, gcus_act.expiration_maturity_date, gcus_act.contract_size, gcus_act.conversion_ratio, gcus_act.account_short_name, gcus_act.state_code, gcus_act.country_code_account, gcus_act.number_security_description_lines, gcus_act.security_description_line_1, gcus_act.security_description_line_2, gcus_act.security_description_line_3, gcus_act.security_description_line_4, gcus_act.security_description_line_5, gcus_act.security_description_line_6, gcus_act.dividend_option, gcus_act.long_term_capital_gains_option, gcus_act.short_term_capital_gains_option, gcus_act.firm_trading_indicator, gcus_act.position_currency_security, gcus_act.trade_date_liquidating_value, gcus_act.pool_factor, gcus_act.exchange_rate, gcus_act.settlement_date_liquidating_value, gcus_act.alternate_security_id_type, gcus_act.alternate_security_id, gcus_act.position_currency, gcus_act.fully_paid_lending_quantity, gcus_act.fully_paid_lending_quantity_collateral_amount, gcus_act.option_root_id, gcus_act.expiration_date, gcus_act.call_put_indicator, gcus_act.trade_date_repo_quantity, gcus_act.settlement_date_repo_quantity, gcus_act.trade_date_reverse_repo_quantity, gcus_act.settlement_date_reverse_repo_quantity, gcus_act.collateral_pledge_quantity, gcus_act.corporate_exec_serv_collateral_pledge_quantity, gcus_act.trade_date_repo_liquidating_value, gcus_act.settlement_date_repo_liquidating_value, gcus_act.trade_date_reverse_repo_liquidating_value, gcus_act.settlement_date_reverse_repo_liquidating_value, gcus_act.collateral_pledge_liquidating_value, gcus_act.corporate_exec_serv_collateral_pledge_liquidating_value, gcus_act.trade_date_repo_loan_amount, gcus_act.settlement_date_repo_loan_amount, gcus_act.trade_date_reverse_repo_loan_amount, gcus_act.settlement_date_reverse_repo_loan_amount, gcus_act.accrued_interes_value, gcus_act.dividend_or_coupon_rate, gcus_act.pending_split_quantity_liquidating_value, gcus_act.internal_non_dollar_symbol, gcus_act.pledged_quantity
    FROM pershing.sfl_gcus_actual gcus_act;

end;
$$;

create function pershing.fn_obtiene_valor_param_generic_pershing(_param_name character varying, _param_id character varying) returns character varying
    language plpgsql
as
$$
DECLARE _valor_parametro_out VARCHAR(1000);
    BEGIN
        select PAR.param_value INTO _valor_parametro_out
        FROM pershing.param_generic_pershing PAR
        WHERE PAR.param_name=_param_name AND PAR.param_id=_param_id
        LIMIT 1;
    RETURN _valor_parametro_out;
    END;
$$;





--========================================================================
--========================================================================
--========================================================================
--
create table clientes.cliente
(
    id                    integer generated always as identity
        constraint cliente_pk
            primary key,
    identificador         VARCHAR(100) not null,
    nombre                VARCHAR(100) not null,
    id_tipo_identificador int          not null
);

create unique index cliente_identificador_ui
    on clientes.cliente (identificador);

create table clientes.tipo_identificador
(
    id   integer generated always as identity
        constraint tipo_identificador_pk
            primary key,
    tipo_identificador VARCHAR(100) not null,
    glosa_identificador VARCHAR(100) not null,
    habilitado          BOOLEAN      not null default true
);

create unique index tipo_identificador_tipo_identificador_ui
    on clientes.tipo_identificador (tipo_identificador);

alter table clientes.cliente
    add constraint cliente_tipo_identificador_fk
        foreign key (id_tipo_identificador) references clientes.tipo_identificador (id);

insert into clientes.tipo_identificador (tipo_identificador, glosa_identificador)
values ('CC', 'CEDULA DE CIUDADANIA'),
       ('CD', 'CARNE DIPLOMATICO'),
       ('CE', 'CEDULA DE EXTRANJERIA'),
       ('IF', 'CEDULA DE EXTRANJERIA'),
       ('MS', 'MENOR SIN IDENTIFICAR'),
       ('NI', 'NIT'),
       ('NU', 'NUMERO UNICO DE IDENTIFICACION PERSONAL'),
       ('PA', 'PASAPORTE'),
       ('PD', 'CARNE DIPLOMATICO'),
       ('RC', 'REGISTRO CIVIL'),
       ('RP', 'REGISTRO CIVIL PENDIENTE'),
       ('TE', 'TARJETA DE EXTRANJERIA'),
       ('TI', 'TARJETA DE IDENTIDAD');

create table clientes.cuenta
(
    id                 integer generated always as identity
        constraint cuenta_pk
            primary key,
    id_cliente         int          not null,
    id_custodio        VARCHAR(100) not null,
    id_cuenta_custodio VARCHAR(100) not null,
    habilitado         BOOLEAN      not null default true
);

create unique index cuenta_id_custodio_id_cuenta_custodio_ui
    on clientes.cuenta (id_custodio, id_cuenta_custodio);

alter table clientes.cuenta
    add constraint cuenta_cliente_fk
        foreign key (id_cliente) references clientes.cliente (id);

create table clientes.comision_cuenta
(
    id         integer generated always as identity
        constraint comision_cuenta_pk
            primary key,
    id_cuenta int not null,
    comision_diaria_saldo numeric(45,20) not null default 0,
    fecha_inicio_vigencia date not null default current_date
);

alter table clientes.comision_cuenta
    add constraint comision_cuenta_cuenta_fk
        foreign key (id_cuenta) references clientes.cuenta (id);

create unique index comision_cuenta_id_cuenta_fecha_inicio_vigencia_ui
    on clientes.comision_cuenta (id_cuenta, fecha_inicio_vigencia);



create table clientes.par_fee_segmento
(
    id integer generated always as identity
        constraint par_fee_segmento_pk
            primary key,
    glosa varchar(100) not null,
    monto_min numeric(45,20) not null,
    monto_max numeric(45,20) not null,
    annual_fee numeric(45,20) not null,
    tasa_proteccion numeric(45,20) not null,
    tasa_suracorp numeric(45,20) not null
);

create unique index par_fee_segmento_monto_rango_ui
    on clientes.par_fee_segmento (monto_min, monto_max);

ALTER TABLE clientes.par_fee_segmento
ADD CONSTRAINT check_annual_fee
CHECK (annual_fee = tasa_proteccion + tasa_suracorp);

ALTER TABLE clientes.par_fee_segmento
ADD CONSTRAINT no_overlap_rango_monto
EXCLUDE USING gist
(numrange(monto_min, monto_max, '[)') WITH &&);



INSERT INTO clientes.par_fee_segmento (glosa, monto_min, monto_max, annual_fee, tasa_proteccion, tasa_suracorp) VALUES
('>= 100k y < 250k', 100000, 250000, 0.015, 0.011, 0.004),
('>= 250k y < 500k', 250000, 500000, 0.0125, 0.0085, 0.004),
('>= 500k y < 1M', 500000, 1000000, 0.01, 0.006, 0.004),
('>= 1M y < 2.5M', 1000000, 2500000, 0.0075, 0.0035, 0.004),
('>= 2.5M', 2500000,999999999, 0.005, 0.0025, 0.0025);

ALTER TABLE clientes.par_fee_segmento
ADD COLUMN fee_diario numeric(45,20) GENERATED ALWAYS AS ((power(1::NUMERIC(45,20)+annual_fee, (1::NUMERIC(45,20)/365::NUMERIC(45,20))::NUMERIC(45,20))-1::NUMERIC(45,20))::NUMERIC(45,20)) STORED,
ADD COLUMN fee_diario_proteccion numeric(45,20) GENERATED ALWAYS AS ((power(1::NUMERIC(45,20)+tasa_proteccion, (1::NUMERIC(45,20)/365::NUMERIC(45,20))::NUMERIC(45,20))-1::NUMERIC(45,20))::NUMERIC(45,20)) STORED,
ADD COLUMN fee_diario_sura_corp numeric(45,20) GENERATED ALWAYS AS ((power(1::NUMERIC(45,20)+tasa_suracorp, (1::NUMERIC(45,20)/365::NUMERIC(45,20))::NUMERIC(45,20))-1::NUMERIC(45,20))::NUMERIC(45,20)) STORED;


create VIEW clientes.vw_maestro_clientes_cuentas AS
SELECT c.id as id_interno_cliente,
       c.identificador as identificador_cliente,
       c.nombre as nombre_cliente,
       c.id_tipo_identificador as id_tipo_identificador_cliente,
       ti.tipo_identificador as tipo_identificador_cliente,
       ti.glosa_identificador as glosa_identificador_cliente,
       cu.id as id_interno_cuenta,
       cu.id_custodio,
       cu.id_cuenta_custodio,
       cu.habilitado
FROM clientes.cliente c
JOIN clientes.tipo_identificador ti ON c.id_tipo_identificador = ti.id
LEFT JOIN clientes.cuenta cu ON c.id = cu.id_cliente
;





--========================================================================
--========================================================================
--========================================================================
--Vistas schema pershing

create view pershing.vw_maestro_acct
            (id, id_proceso, process_date, record_id_sequence_number, account_number, ibd_number, ip_number,
             account_short_name, transaction_type, autotitled_usertitled_account, account_type_code, registration_type,
             number_of_account_title_lines, account_registration_line_1, account_registration_line_2,
             account_registration_line_3, account_registration_line_4, account_registration_line_5,
             account_registration_line_6, registration_type_detail, date_account_opened,
             date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed,
             closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions,
             income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account,
             investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol,
             margin_privileges_revoked, statement_review_date, margin_papers_on_file, option_papers_on_file,
             good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted,
             third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code,
             option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2,
             option_level_3, option_level_4, option_call_limits, option_put_limits,
             option_total_limits_of_puts_and_calls, non_us_dollar_trading, non_customer_indicator,
             third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule,
             group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic,
             employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date,
             plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative,
             commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form,
             date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form,
             date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account,
             foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason,
             primary_country_of_citizenship, country_of_residence, birth_date, age_based_fund_roll_exempt,
             money_fundreform_retail, trusted_contact_status, regulatory_account_type_category,
             account_managed_by_trust_comp_id, voting_auth, customer_type, fulfillment_method,
             credit_interest_indicator, ama_indicator, tax_id_type, tax_id_number, date_tax_id_applied_for,
             w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, tax_status,
             b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced,
             date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced,
             date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced,
             date_c_notice_status_satisfied, old_account_number, original_account_open_date,
             unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date,
             initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code,
             future_statement_currency_code, future_statement_currency_code_effective_date,
             account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3,
             account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip,
             third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym,
             alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator,
             source_of_asset_at_acct_opening, commission_doscount_code, external_account_number,
             confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside,
             fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type,
             mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated,
             date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id,
             firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id,
             second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account,
             banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code,
             combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code,
             proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code,
             dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona,
             client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code,
             addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix,
             addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4,
             addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id,
             addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3,
             addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind,
             principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2,
             from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system,
             disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks,
             amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code,
             addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix,
             addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4,
             addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code,
             addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix,
             addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4,
             addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code,
             addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix,
             addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4,
             addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code,
             addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix,
             addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4,
             addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code,
             addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix,
             addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4,
             addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency,
             income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep,
             last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind,
             foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst,
             foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own,
             proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension,
             tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code,
             tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind,
             tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id,
             tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number,
             tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension,
             tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address,
             external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code,
             cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency)
as
SELECT tb_det.id,
       tb_det.id_proceso,
       tb_det.process_date,
       tb_det.record_id_sequence_number,
       tb_det.account_number,
       tb_det.ibd_number,
       tb_det.ip_number,
       tb_det.account_short_name,
       tb_det.transaction_type,
       tb_det.autotitled_usertitled_account,
       tb_det.account_type_code,
       tb_det.registration_type,
       tb_det.number_of_account_title_lines,
       tb_det.account_registration_line_1,
       tb_det.account_registration_line_2,
       tb_det.account_registration_line_3,
       tb_det.account_registration_line_4,
       tb_det.account_registration_line_5,
       tb_det.account_registration_line_6,
       tb_det.registration_type_detail,
       tb_det.date_account_opened,
       tb_det.date_account_information_updated,
       tb_det.account_status_indicator,
       tb_det.pending_closed_date,
       tb_det.date_account_closed,
       tb_det.closing_notice_date,
       tb_det.account_reactivated_date,
       tb_det.date_account_reopened,
       tb_det.proceeds,
       tb_det.transfer_instructions,
       tb_det.income_isntructions,
       tb_det.number_of_confirms_for_thi_account,
       tb_det.number_of_statements_for_this_account,
       tb_det.investment_objetive_trans_code,
       tb_det.comments_act,
       tb_det.employer_shotname,
       tb_det.employers_cusip,
       tb_det.employers_symbol,
       tb_det.margin_privileges_revoked,
       tb_det.statement_review_date,
       tb_det.margin_papers_on_file,
       tb_det.option_papers_on_file,
       tb_det.good_faith_margin,
       tb_det.ip_discretion_granted,
       tb_det.invest_advisor_discretion_granted,
       tb_det.third_party_discretion_granted,
       tb_det.third_party_name,
       tb_det.risk_factor_code,
       tb_det.investment_objetive_code,
       tb_det.option_equities,
       tb_det.option_index,
       tb_det.option_debt,
       tb_det.option_currency,
       tb_det.option_level_1,
       tb_det.option_level_2,
       tb_det.option_level_3,
       tb_det.option_level_4,
       tb_det.option_call_limits,
       tb_det.option_put_limits,
       tb_det.option_total_limits_of_puts_and_calls,
       tb_det.non_us_dollar_trading,
       tb_det.non_customer_indicator,
       tb_det.third_party_fee_indicator,
       tb_det.third_party_fee_approval_date,
       tb_det.intermediary_account_ind,
       tb_det.commission_schedule,
       tb_det.group_index,
       tb_det.money_manager_id,
       tb_det.money_manager_objective_id,
       tb_det.dtc_id_confirm_number,
       tb_det.caps_master_mnemonic,
       tb_det.employee_id,
       tb_det.prime_broker_free_fund_indicator,
       tb_det.fee_based_account_indicator,
       tb_det.fee_based_termination_date,
       tb_det.plan_name,
       tb_det.self_directed_401_k_account_type,
       tb_det.plan_type,
       tb_det.plan_number,
       tb_det.employee_or_employee_relative,
       tb_det.commission_percent_discount,
       tb_det.ind_12_b_1_fee_blocking,
       tb_det.name_of_ip_signed_new_account_form,
       tb_det.date_of_ip_signed_new_account_form,
       tb_det.name_of_principal_signed_new_account_form,
       tb_det.date_of_principal_signed_new_account_form,
       tb_det.politically_exposed_person,
       tb_det.private_banking_account,
       tb_det.foreign_bank_account,
       tb_det.initial_source_of_funds,
       tb_det.usa_patriot_act_exempt_reason,
       tb_det.primary_country_of_citizenship,
       tb_det.country_of_residence,
       tb_det.birth_date,
       tb_det.age_based_fund_roll_exempt,
       tb_det.money_fundreform_retail,
       tb_det.trusted_contact_status,
       tb_det.regulatory_account_type_category,
       tb_det.account_managed_by_trust_comp_id,
       tb_det.voting_auth,
       tb_det.customer_type,
       tb_det.fulfillment_method,
       tb_det.credit_interest_indicator,
       tb_det.ama_indicator,
       tb_det.tax_id_type,
       tb_det.tax_id_number,
       tb_det.date_tax_id_applied_for,
       tb_det.w_8_w_9_indicator,
       tb_det.w_8_w_9_date_signed,
       tb_det.w_8_w_9_effective_date,
       tb_det.w_8_w_9_document_type,
       tb_det.tax_status,
       tb_det.b_notice_reason_code,
       tb_det.first_b_notice_status,
       tb_det.date_first_b_notice_status_issued_enforced,
       tb_det.date_first_notice_status_satisfied,
       tb_det.second_b_notice_status,
       tb_det.date_second_b_notice_status_issued_enforced,
       tb_det.date_second_b_notice_status_satisfied,
       tb_det.c_notice_status,
       tb_det.date_c_notice_status_issued_enforced,
       tb_det.date_c_notice_status_satisfied,
       tb_det.old_account_number,
       tb_det.original_account_open_date,
       tb_det.unidentified_large_trader_id,
       tb_det.large_trader_type_code,
       tb_det.large_trader_type_last_change_date,
       tb_det.initial_source_of_funds_other,
       tb_det.finance_away,
       tb_det.account_funding_date,
       tb_det.statement_currency_code,
       tb_det.future_statement_currency_code,
       tb_det.future_statement_currency_code_effective_date,
       tb_det.account_level_routing_code_1,
       tb_det.account_level_routing_code_2,
       tb_det.account_level_routing_code_3,
       tb_det.account_level_routing_code_4,
       tb_det.self_directed_ind,
       tb_det.digital_advice_ind,
       tb_det.pte_account_ind,
       tb_det.first_ip,
       tb_det.second_ip,
       tb_det.third_ip,
       tb_det.fourth_ip,
       tb_det.fifth_ip,
       tb_det.sixth_ip,
       tb_det.seventh_ip,
       tb_det.eighth_ip,
       tb_det.ninth_ip,
       tb_det.tenth_ip,
       tb_det.alert_im_acornym,
       tb_det.alert_im_access_code,
       tb_det.broker_acronym,
       tb_det.cross_reference_indicator,
       tb_det.bny_trust_indicator,
       tb_det.source_of_asset_at_acct_opening,
       tb_det.commission_doscount_code,
       tb_det.external_account_number,
       tb_det.confirmation_suppression_indicator,
       tb_det.date_last_mail_sent,
       tb_det.date_last_mail_sent_outside,
       tb_det.fully_paid_lending_agreement_indicator,
       tb_det.fully_paid_lending_agreement_date,
       tb_det.custodian_account_type,
       tb_det.mifid_customer_categorization,
       tb_det.cash_management_tran_code,
       tb_det.sweep_status_indicator,
       tb_det.date_sweep_activated,
       tb_det.date_sweep_details_changed,
       tb_det.cober_margin_debit_indicator,
       tb_det.first_fund_sweep_account_id,
       tb_det.firstfund_sweep_account_percent,
       tb_det.first_fundsweep_account_redemption_priority,
       tb_det.second_fund_sweep_account_id,
       tb_det.second_fund_sweep_account_percent,
       tb_det.second_fundsweep_account_redemption_priority,
       tb_det.type_of_bank_account,
       tb_det.banklink_aba_number,
       tb_det.banklink_dda_number,
       tb_det.fund_bank_indicator,
       tb_det.w_9_corp_tax_classification_code,
       tb_det.combined_margin_acct_indicator,
       tb_det.pledge_collateral_account_indicator,
       tb_det.finra_institutional_account_code,
       tb_det.proposed_account_reference_id,
       tb_det.advisor_model_id,
       tb_det.firm_model_style_id,
       tb_det.dvp_restriction_code,
       tb_det.dvp_restriction_exp_date,
       tb_det.escheatment_withholding_ind,
       tb_det.source_of_origination,
       tb_det.source_of_persona,
       tb_det.client_onboarding_method,
       tb_det.tax_filing_code,
       tb_det.nor_purpose_collateral_acct_ind,
       tb_det.addr_1_trx_code,
       tb_det.addr_1_special_handling_ind,
       tb_det.addr_1_delivery_id,
       tb_det.addr_1_attention_line_prefix,
       tb_det.addr_1_attention_line_detail,
       tb_det.addr_1_line_1,
       tb_det.addr_1_line_2,
       tb_det.addr_1_line_3,
       tb_det.addr_1_line_4,
       tb_det.addr_1_city_state,
       tb_det.addr_1_country_code,
       tb_det.addr_2_trx_code,
       tb_det.addr_2_special_handling_ind,
       tb_det.addr_2_delivery_id,
       tb_det.addr_2_attention_line_prefix,
       tb_det.addr_2_attention_line_detail,
       tb_det.addr_2_line_1,
       tb_det.addr_2_line_2,
       tb_det.addr_2_line_3,
       tb_det.addr_2_line_4,
       tb_det.addr_2_city_state,
       tb_det.addr_2_country_code,
       tb_det.account_description,
       tb_det.set_as_mail_addr_2_ind,
       tb_det.principal_billing_allocation_pct,
       tb_det.seasonal_addr_id_1,
       tb_det.from_date_1,
       tb_det.to_date_1,
       tb_det.seasonal_addr_id_2,
       tb_det.from_date_2,
       tb_det.to_date_2,
       tb_det.seasonal_addr_id_3,
       tb_det.from_date_3,
       tb_det.to_date_3,
       tb_det.cost_basis_acct_system,
       tb_det.disposition_method_mutual_funds,
       tb_det.disposition_method_other,
       tb_det.disposition_method_stocks,
       tb_det.amortize_taxable_premium_bonds,
       tb_det.accrue_market_disc_based_on,
       tb_det.accrue_market_disc_income,
       tb_det.addr_3_trx_code,
       tb_det.addr_3_special_handling_ind,
       tb_det.addr_3_delivery_id,
       tb_det.addr_3_attention_line_prefix,
       tb_det.addr_3_attention_line_detail,
       tb_det.addr_3_line_1,
       tb_det.addr_3_line_2,
       tb_det.addr_3_line_3,
       tb_det.addr_3_line_4,
       tb_det.addr_3_city_state,
       tb_det.addr_3_country_code,
       tb_det.set_as_mail_addr_3_ind,
       tb_det.addr_4_trx_code,
       tb_det.addr_4_special_handling_ind,
       tb_det.addr_4_delivery_id,
       tb_det.addr_4_attention_line_prefix,
       tb_det.addr_4_attention_line_detail,
       tb_det.addr_4_line_1,
       tb_det.addr_4_line_2,
       tb_det.addr_4_line_3,
       tb_det.addr_4_line_4,
       tb_det.addr_4_city_state,
       tb_det.addr_4_country_code,
       tb_det.set_as_mail_addr_4_ind,
       tb_det.addr_5_trx_code,
       tb_det.addr_5_special_handling_ind,
       tb_det.addr_5_delivery_id,
       tb_det.addr_5_attention_line_prefix,
       tb_det.addr_5_attention_line_detail,
       tb_det.addr_5_line_1,
       tb_det.addr_5_line_2,
       tb_det.addr_5_line_3,
       tb_det.addr_5_line_4,
       tb_det.addr_5_city_state,
       tb_det.addr_5_country_code,
       tb_det.set_as_mail_addr_5_ind,
       tb_det.addr_6_trx_code,
       tb_det.addr_6_special_handling_ind,
       tb_det.addr_6_delivery_id,
       tb_det.addr_6_attention_line_prefix,
       tb_det.addr_6_attention_line_detail,
       tb_det.addr_6_line_1,
       tb_det.addr_6_line_2,
       tb_det.addr_6_line_3,
       tb_det.addr_6_line_4,
       tb_det.addr_6_city_state,
       tb_det.addr_6_country_code,
       tb_det.set_as_mail_addr_6_ind,
       tb_det.addr_7_trx_code,
       tb_det.addr_7_special_handling_ind,
       tb_det.addr_7_delivery_id,
       tb_det.addr_7_attention_line_prefix,
       tb_det.addr_7_attention_line_detail,
       tb_det.addr_7_line_1,
       tb_det.addr_7_line_2,
       tb_det.addr_7_line_3,
       tb_det.addr_7_line_4,
       tb_det.addr_7_city_state,
       tb_det.addr_7_country_code,
       tb_det.set_as_mail_addr_7_ind,
       tb_det.record_transaction_code,
       tb_det.base_currency,
       tb_det.income_currency,
       tb_det.statement_language,
       tb_det.statement_format_code,
       tb_det.msrb_statement_ind,
       tb_det.pep,
       tb_det.first_name_pep,
       tb_det.last_name_pep,
       tb_det.suffix_pep,
       tb_det.political_office_held,
       tb_det.country_of_office,
       tb_det.foreign_bank_account_ind,
       tb_det.foreign_bank_cert_date,
       tb_det.foreign_bank_cert_exp_date,
       tb_det.central_bank_ind,
       tb_det.acct_foreign_financial_inst,
       tb_det.foreign_bank_acct_oper_1,
       tb_det.foreign_bank_acct_oper_2,
       tb_det.foreign_bank_acct_oper_3,
       tb_det.number_people_own,
       tb_det.proprietary_acct_owned,
       tb_det.tel_1_transaction_code,
       tb_det.tel_1_us_ind,
       tb_det.tel_1_type_id,
       tb_det.tel_1_number,
       tb_det.tel_1_extension,
       tb_det.tel_2_transaction_code,
       tb_det.tel_2_us_ind,
       tb_det.tel_2_type_id,
       tb_det.tel_2_number,
       tb_det.tel_2_extension,
       tb_det.tel_3_transaction_code,
       tb_det.tel_3_us_ind,
       tb_det.tel_3_type_id,
       tb_det.tel_3_number,
       tb_det.tel_3_extension,
       tb_det.tel_4_transaction_code,
       tb_det.tel_4_us_ind,
       tb_det.tel_4_type_id,
       tb_det.tel_4_number,
       tb_det.tel_4_extension,
       tb_det.tel_5_transaction_code,
       tb_det.tel_5_us_ind,
       tb_det.tel_5_type_id,
       tb_det.tel_5_number,
       tb_det.tel_5_extension,
       tb_det.tel_6_transaction_code,
       tb_det.tel_6_us_ind,
       tb_det.tel_6_type_id,
       tb_det.tel_6_number,
       tb_det.tel_6_extension,
       tb_det.tel_7_transaction_code,
       tb_det.tel_7_us_ind,
       tb_det.tel_7_type_id,
       tb_det.tel_7_number,
       tb_det.tel_7_extension,
       tb_det.tel_8_transaction_code,
       tb_det.tel_8_us_ind,
       tb_det.tel_8_type_id,
       tb_det.tel_8_number,
       tb_det.tel_8_extension,
       tb_det.email_address,
       tb_det.external_position_ind,
       tb_det.purge_eligible_ind,
       tb_det.advisory_acct_ind,
       tb_det.product_profile_code,
       tb_det.cents_per_share_discount,
       tb_det.option_disclosure_date,
       tb_det.country_acct_level_tax_residency
FROM pershing.sfl_acct_historica tb_det;

create view pershing.vw_maestro_posicion
            (tipo_reg, sub_tipo_reg, flag_informar, ip_number, process_date, account_number, account_type,
             security_symbol, cusip_number, security_description_line_1, security_description_line_2,
             security_description_line_3, security_description_line_4, security_description_line_5,
             security_description_line_6, quantity, currency, fx_rate)
as
SELECT tb_pos.tipo_reg,
       tb_pos.sub_tipo_reg,
       tb_pos.flag_informar,
       TRIM(BOTH FROM tb_pos.ip_number)::character varying(100)                    AS ip_number,
       tb_pos.process_date,
       tb_pos.account_number,
       tb_pos.account_type,
       tb_pos.security_symbol,
       tb_pos.cusip_number,
       tb_pos.security_description_line_1,
       tb_pos.security_description_line_2,
       tb_pos.security_description_line_3,
       tb_pos.security_description_line_4,
       tb_pos.security_description_line_5,
       tb_pos.security_description_line_6,
       tb_pos.quantity,
       COALESCE(tb_pos.currency, 'USD'::character varying)::character varying(100) AS currency,
       tb_pos.fx_rate
FROM (SELECT 'CUS'::character varying(100)                                  AS tipo_reg,
             t_cus.currency_security_indicator                              AS sub_tipo_reg,
             t_cus.trade_date_quantity <> 0::numeric                        AS flag_informar,
             t_cus.ip_record_number                                         AS ip_number,
             t_cus.process_date,
             "left"(t_cus.account_number::text, 9)                          AS account_number,
             "right"(t_cus.account_number::text, 1)::character varying(100) AS account_type,
             t_cus.security_symbol,
             t_cus.cusip_number,
             t_cus.security_description_line_1,
             t_cus.security_description_line_2,
             t_cus.security_description_line_3,
             t_cus.security_description_line_4,
             t_cus.security_description_line_5,
             t_cus.security_description_line_6,
             t_cus.trade_date_quantity                                      AS quantity,
             t_cus.position_currency_security                               AS currency,
             t_cus.exchange_rate                                            AS fx_rate
      FROM pershing.sfl_gcus_historica t_cus
      UNION
      SELECT 'CAJA'::character varying(100)                                                   AS tipo_reg,
             'MM'::character varying(100)                                                     AS sub_tipo_reg,
             true                                                                             AS flag_informar,
             reg_mm.ip_number,
             reg_mm.process_date,
             reg_mm.account_number,
             '1'::character varying(100)                                                      AS account_type,
             public.fn_obtiene_valor_parametro('generic.symbol'::character varying,
                                        'MNY_MKT'::character varying)::character varying(100) AS security_symbol,
             public.fn_obtiene_valor_parametro('generic.cusip'::character varying,
                                        'MNY_MKT'::character varying)::character varying(100) AS cusip_number,
             'Money Market'::character varying                                                AS security_description_line_1,
             ''::character varying                                                            AS security_description_line_2,
             ''::character varying                                                            AS security_description_line_3,
             ''::character varying                                                            AS security_description_line_4,
             ''::character varying                                                            AS security_description_line_5,
             ''::character varying                                                            AS security_description_line_6,
             reg_mm.mmf_principal_balance + reg_mm.mmf_dividend                               AS quantity,
             CASE
                 WHEN TRIM(BOTH FROM COALESCE(reg_mm.base_currency, ''::character varying)) = ''::text
                     THEN (SELECT gcus_crrcy.position_currency_security
                           FROM pershing.sfl_gcus_historica gcus_crrcy
                           WHERE gcus_crrcy.process_date::text = reg_mm.process_date::text
                             AND "left"(gcus_crrcy.account_number::text, 9) = reg_mm.account_number::text
                             AND gcus_crrcy.cusip_number::text = 'USD999997'::text
                           LIMIT 1)
                 ELSE reg_mm.base_currency
                 END                                                                          AS currency,
             1::numeric(45, 20)                                                               AS fx_rate
      FROM pershing.sfl_gmon_historica reg_mm
      UNION
      SELECT 'CAJA'::character varying(100)                                                AS tipo_reg,
             'ST'::character varying(100)                                                  AS sub_tipo_reg,
             false                                                                         AS flag_informar,
             reg_st.ip_number,
             reg_st.process_date,
             reg_st.account_number,
             '1'::character varying(100)                                                   AS account_type,
             public.fn_obtiene_valor_parametro('generic.symbol'::character varying,
                                        'CASH'::character varying)::character varying(100) AS security_symbol,
             public.fn_obtiene_valor_parametro('generic.cusip'::character varying,
                                        'CASH'::character varying)::character varying(100) AS cusip_number,
             'Saldo en tránsito'::character varying                                        AS security_description_line_1,
             ''::character varying                                                         AS security_description_line_2,
             ''::character varying                                                         AS security_description_line_3,
             ''::character varying                                                         AS security_description_line_4,
             ''::character varying                                                         AS security_description_line_5,
             ''::character varying                                                         AS security_description_line_6,
             reg_st.usde_td_balance * '-1'::integer::numeric                               AS quantity,
             CASE
                 WHEN TRIM(BOTH FROM COALESCE(reg_st.base_currency, ''::character varying)) = ''::text
                     THEN (SELECT gcus_crrcy.position_currency_security
                           FROM pershing.sfl_gcus_historica gcus_crrcy
                           WHERE gcus_crrcy.process_date::text = reg_st.process_date::text
                             AND "left"(gcus_crrcy.account_number::text, 9) = reg_st.account_number::text
                             AND gcus_crrcy.cusip_number::text = 'USD999997'::text
                           LIMIT 1)
                 ELSE reg_st.base_currency
                 END                                                                       AS currency,
             1::numeric(45, 20)                                                            AS fx_rate
      FROM pershing.sfl_gmon_historica reg_st) tb_pos;




--========================================================================
--========================================================================
--========================================================================
--
CREATE VIEW pershing.vw_maestro_posicion_valorizada AS
SELECT
    t_pos.process_date,
    t_pos.process_date_val_his,
    t_pos.id_custodian,
    t_pos.custodian,
    t_pos.tipo_reg,
    t_pos.sub_tipo_reg,
    t_pos.office_id,
    t_pos.ip_number,
    t_pos.account_number,
    t_pos.cusip_number AS cusip,
    t_pos.quantity,
    t_pos.account_type,
    t_pos.cash_margin_account,
    t_pos.id_currency,
    t_pos.currency,
    t_pos.fx_rate,
    t_pos.market_price,
    (CASE
        WHEN t_pos.tipo_reg::text = 'CAJA'::text OR t_pos.sub_tipo_reg::text = 'C' THEN t_pos.quantity
        ELSE t_pos.quantity * t_pos.latest_price
    END * t_pos.factor_mkv_mult)::numeric(45, 20)                 AS market_value,
    CASE
        WHEN t_pos.tipo_reg::text = 'CAJA'::text THEN 1::numeric(45, 20)
        WHEN t_pos.sub_tipo_reg::text = 'C'::text THEN t_pos.fx_rate
        ELSE t_pos.latest_price * t_pos.fx_rate
    END::numeric(45, 20)                                          AS usde_market_price,
    (CASE
        WHEN t_pos.tipo_reg::text = 'CAJA'::text OR t_pos.sub_tipo_reg::text = 'C' THEN t_pos.quantity
        ELSE t_pos.quantity * t_pos.latest_price
    END * t_pos.factor_mkv_mult * t_pos.fx_rate)::numeric(45, 20) AS usde_market_value,
    t_pos.security_symbol                                         AS symbol,
    t_pos.isin_code,
    t_pos.security_description,
    t_pos.product_type,
    t_pos.id_sub_sub_tipo_activo,
    t_pos.id_sub_tipo_activo,
    t_pos.id_tipo_activo,
    t_pos.nombre_sub_sub_tipo_activo

FROM (
    SELECT
        'pershing'::VARCHAR(100) as id_custodian,
        fn_obtiene_valor_parametro('custodian'::character varying, 'pershing'::character varying)::VARCHAR(100) AS custodian,
        vw_pos.tipo_reg,
        vw_pos.sub_tipo_reg,
        vw_pos.flag_informar,
        vw_pos.ip_number,
        vw_pos.process_date,
        vw_pos.account_number,
        "left"(vw_pos.account_number, 3)::VARCHAR(100) AS office_id,
        vw_pos.account_type,
        pershing.fn_obtiene_valor_param_generic_pershing('account_type'::character varying,
        vw_pos.account_type)::VARCHAR(100) as cash_margin_account,
        vw_pos.security_symbol,
        vw_pos.cusip_number,
        TRIM(BOTH FROM (((((((((TRIM(BOTH FROM vw_pos.security_description_line_1) || ' '::text) ||
        TRIM(BOTH FROM vw_pos.security_description_line_2)) || ' '::text) ||
        TRIM(BOTH FROM vw_pos.security_description_line_3)) || ' '::text) ||
        TRIM(BOTH FROM vw_pos.security_description_line_4)) || ' '::text) ||
        TRIM(BOTH FROM vw_pos.security_description_line_5)) || ' '::text) ||
        TRIM(BOTH FROM vw_pos.security_description_line_6))::VARCHAR(100)                  AS security_description,
        vw_pos.currency AS id_currency,
        vw_pos.quantity,
        CASE
            WHEN vw_pos.tipo_reg::text = 'CAJA'::text OR vw_pos.sub_tipo_reg::text = 'C'::text THEN 1::numeric
            ELSE val_his.latest_price
        END::numeric(45, 20) as market_price,
        --ISCA
        val_his.process_date as process_date_val_his,
        val_his.latest_price,
        CASE
            WHEN vw_pos.tipo_reg::text = 'CAJA'::text THEN 1
            ELSE val_his.exchange_rate_denom_currency_usd
        END::numeric(45, 20) as fx_rate,
        COALESCE(val_his.factored_market_value_multiplier, 1::numeric(45, 20))::numeric(45, 20) as factor_mkv_mult,
        CASE
            WHEN vw_pos.tipo_reg = 'CAJA' THEN vw_pos.cusip_number
            ELSE val_his.isin_code
        END::VARCHAR(100) AS isin_code,
        --Currency
        par_crrcy.codigo::VARCHAR(100) AS currency,
        --Asset Type
        par_asset.id_sub_sub_tipo                                     AS product_type,
        par_asset.id_sub_sub_tipo                                     AS id_sub_sub_tipo_activo,
        par_asset.id_sub_tipo                                         AS id_sub_tipo_activo,
        par_asset.id_tipo                                             AS id_tipo_activo,
        par_asset.glosa                                               AS nombre_sub_sub_tipo_activo
    FROM pershing.vw_maestro_posicion vw_pos
    LEFT JOIN pershing.sfl_isca_historica val_his
        ON vw_pos.process_date = val_his.process_date AND vw_pos.cusip_number = val_his.cusip_number
    LEFT JOIN par_maestro_monedas par_crrcy
        ON vw_pos.currency = par_crrcy.cod_pershing
    LEFT JOIN pershing.par_asset_type_code par_asset
    ON CASE
        WHEN vw_pos.tipo_reg::text = 'CAJA'::text THEN 'MONEY'::text = par_asset.id_sub_sub_tipo::text
        ELSE TRIM(BOTH FROM val_his.asset_type) = TRIM(BOTH FROM par_asset.id_tipo) AND
        TRIM(BOTH FROM val_his.asset_subtype) = TRIM(BOTH FROM par_asset.id_sub_tipo) AND
        TRIM(BOTH FROM val_his.asset_subsubtype) = TRIM(BOTH FROM par_asset.id_sub_sub_tipo)
    END
    WHERE vw_pos.flag_informar
) t_pos
;

--========================================================================
--========================================================================
--========================================================================
--

CREATE VIEW pershing.vw_maestro_cuenta AS
    SELECT
    'pershing'::character varying(100) AS id_custodian,
    fn_obtiene_valor_parametro('custodian'::character varying, 'pershing'::character varying)::VARCHAR(100) AS custodian,
    vw_act.id,
    vw_act.ibd_number,
    "left"(vw_act.account_number::text, 3)                                                     AS id_office,
    vw_act.ip_number,
    vw_act.account_number,
    vw_act.id_proceso,
    vw_act.process_date,
    vw_act.record_id_sequence_number,
    vw_act.account_short_name,
    CASE
        WHEN vw_act.number_of_account_title_lines::text = '1'::text
           THEN TRIM(BOTH FROM vw_act.account_registration_line_1)
        WHEN vw_act.number_of_account_title_lines::text = '2'::text THEN
               (TRIM(BOTH FROM vw_act.account_registration_line_1) || ' '::text) ||
               TRIM(BOTH FROM vw_act.account_registration_line_2)
        WHEN vw_act.number_of_account_title_lines::text = '3'::text THEN
               (((TRIM(BOTH FROM vw_act.account_registration_line_1) || ' '::text) ||
                 TRIM(BOTH FROM vw_act.account_registration_line_2)) || ' '::text) ||
               TRIM(BOTH FROM vw_act.account_registration_line_3)
        WHEN vw_act.number_of_account_title_lines::text = '4'::text THEN
               (((((TRIM(BOTH FROM vw_act.account_registration_line_1) || ' '::text) ||
                   TRIM(BOTH FROM vw_act.account_registration_line_2)) || ' '::text) ||
                 TRIM(BOTH FROM vw_act.account_registration_line_3)) || ' '::text) ||
               TRIM(BOTH FROM vw_act.account_registration_line_4)
        WHEN vw_act.number_of_account_title_lines::text = '5'::text THEN
               (((((((TRIM(BOTH FROM vw_act.account_registration_line_1) || ' '::text) ||
                     TRIM(BOTH FROM vw_act.account_registration_line_2)) || ' '::text) ||
                   TRIM(BOTH FROM vw_act.account_registration_line_3)) || ' '::text) ||
                 TRIM(BOTH FROM vw_act.account_registration_line_4)) || ' '::text) ||
               TRIM(BOTH FROM vw_act.account_registration_line_5)
        WHEN vw_act.number_of_account_title_lines::text = '6'::text THEN
               (((((((((TRIM(BOTH FROM vw_act.account_registration_line_1) || ' '::text) ||
                       TRIM(BOTH FROM vw_act.account_registration_line_2)) || ' '::text) ||
                     TRIM(BOTH FROM vw_act.account_registration_line_3)) || ' '::text) ||
                   TRIM(BOTH FROM vw_act.account_registration_line_4)) || ' '::text) ||
                 TRIM(BOTH FROM vw_act.account_registration_line_5)) || ' '::text) ||
               TRIM(BOTH FROM vw_act.account_registration_line_6)
        ELSE NULL::text
    END::character varying(100)                                                            AS full_name,
    CASE
        WHEN vw_act.number_of_account_title_lines::text = '5'::text
           THEN TRIM(BOTH FROM vw_act.account_registration_line_6)
        WHEN vw_act.number_of_account_title_lines::text = '4'::text THEN
               (TRIM(BOTH FROM vw_act.account_registration_line_5) || ' '::text) ||
               TRIM(BOTH FROM vw_act.account_registration_line_6)
        WHEN vw_act.number_of_account_title_lines::text = '3'::text THEN
               (((TRIM(BOTH FROM vw_act.account_registration_line_4) || ' '::text) ||
                 TRIM(BOTH FROM vw_act.account_registration_line_5)) || ' '::text) ||
               TRIM(BOTH FROM vw_act.account_registration_line_6)
        WHEN vw_act.number_of_account_title_lines::text = '2'::text THEN
               (((((TRIM(BOTH FROM vw_act.account_registration_line_3) || ' '::text) ||
                   TRIM(BOTH FROM vw_act.account_registration_line_4)) || ' '::text) ||
                 TRIM(BOTH FROM vw_act.account_registration_line_5)) || ' '::text) ||
               TRIM(BOTH FROM vw_act.account_registration_line_6)
        WHEN vw_act.number_of_account_title_lines::text = '1'::text THEN
               (((((((TRIM(BOTH FROM vw_act.account_registration_line_2) || ' '::text) ||
                     TRIM(BOTH FROM vw_act.account_registration_line_3)) || ' '::text) ||
                   TRIM(BOTH FROM vw_act.account_registration_line_4)) || ' '::text) ||
                 TRIM(BOTH FROM vw_act.account_registration_line_5)) || ' '::text) ||
               TRIM(BOTH FROM vw_act.account_registration_line_6)
        ELSE NULL::text
    END::character varying(100)                                                            AS full_address,
    vw_act.transaction_type,
    vw_act.autotitled_usertitled_account,
    vw_act.account_type_code,
    vw_act.registration_type,
    par_reg_type.glosa                                                                         AS registration_type_value,
    vw_act.number_of_account_title_lines,
    vw_act.account_registration_line_1,
    vw_act.account_registration_line_2,
    vw_act.account_registration_line_3,
    vw_act.account_registration_line_4,
    vw_act.account_registration_line_5,
    vw_act.account_registration_line_6,
    vw_act.registration_type_detail,
    vw_act.date_account_opened,
    vw_act.date_account_information_updated,
    vw_act.account_status_indicator,
    vw_act.pending_closed_date,
    vw_act.date_account_closed,
    vw_act.closing_notice_date,
    vw_act.account_reactivated_date,
    vw_act.date_account_reopened,
    vw_act.proceeds,
    vw_act.transfer_instructions,
    vw_act.income_isntructions,
    vw_act.number_of_confirms_for_thi_account,
    vw_act.number_of_statements_for_this_account,
    vw_act.investment_objetive_trans_code,
    vw_act.comments_act,
    vw_act.employer_shotname,
    vw_act.employers_cusip,
    vw_act.employers_symbol,
    vw_act.margin_privileges_revoked,
    vw_act.statement_review_date,
    vw_act.margin_papers_on_file,
    CASE
       WHEN vw_act.margin_papers_on_file::text = 'Y'::text THEN 'MARGIN'::text
       ELSE 'CASH'::text
    END::character varying(100)                                                            AS cash_margin_account,
    vw_act.option_papers_on_file,
    vw_act.good_faith_margin,
    vw_act.ip_discretion_granted,
    vw_act.invest_advisor_discretion_granted,
    pershing.fn_obtiene_valor_param_generic_pershing('invest_adv_discr_granted'::character varying,vw_act.invest_advisor_discretion_granted) AS invest_advisor_discretion_granted_value,
    vw_act.third_party_discretion_granted,
    vw_act.third_party_name,
    vw_act.risk_factor_code,
    vw_act.investment_objetive_code,
    vw_act.option_equities,
    vw_act.option_index,
    vw_act.option_debt,
    vw_act.option_currency,
    vw_act.option_level_1,
    vw_act.option_level_2,
    vw_act.option_level_3,
    vw_act.option_level_4,
    vw_act.option_call_limits,
    vw_act.option_put_limits,
    vw_act.option_total_limits_of_puts_and_calls,
    vw_act.non_us_dollar_trading,
    vw_act.non_customer_indicator,
    vw_act.third_party_fee_indicator,
    vw_act.third_party_fee_approval_date,
    vw_act.intermediary_account_ind,
    vw_act.commission_schedule,
    vw_act.group_index,
    vw_act.money_manager_id,
    vw_act.money_manager_objective_id,
    vw_act.dtc_id_confirm_number,
    vw_act.caps_master_mnemonic,
    vw_act.employee_id,
    vw_act.prime_broker_free_fund_indicator,
    vw_act.fee_based_account_indicator,
    vw_act.fee_based_termination_date,
    vw_act.plan_name,
    vw_act.self_directed_401_k_account_type,
    vw_act.plan_type,
    vw_act.plan_number,
    vw_act.employee_or_employee_relative,
    vw_act.commission_percent_discount,
    vw_act.ind_12_b_1_fee_blocking,
    vw_act.name_of_ip_signed_new_account_form,
    vw_act.date_of_ip_signed_new_account_form,
    vw_act.name_of_principal_signed_new_account_form,
    vw_act.date_of_principal_signed_new_account_form,
    vw_act.politically_exposed_person,
    vw_act.private_banking_account,
    vw_act.foreign_bank_account,
    vw_act.initial_source_of_funds,
    vw_act.usa_patriot_act_exempt_reason,
    vw_act.primary_country_of_citizenship                                                      AS country_of_citizenship_code,
    par_cc_cit.glosa                                                                           AS country_of_citizenship_value,
    vw_act.country_of_residence                                                                AS country_of_residence_code,
    par_cc_res.glosa                                                                           AS country_of_residence_value,
    vw_act.birth_date,
    vw_act.age_based_fund_roll_exempt,
    vw_act.money_fundreform_retail,
    vw_act.trusted_contact_status,
    vw_act.regulatory_account_type_category,
    vw_act.account_managed_by_trust_comp_id,
    vw_act.voting_auth,
    vw_act.customer_type,
    vw_act.fulfillment_method,
    vw_act.credit_interest_indicator,
    vw_act.ama_indicator,
    CASE
        WHEN vw_act.ama_indicator::text = ANY
            (ARRAY ['1'::character varying::text, '2'::character varying::text, '4'::character varying::text])
           THEN 'C'::text
        ELSE ''::text
    END                                                                                    AS ama_indicator_value,
    vw_act.tax_id_type,
    vw_act.tax_id_number,
    vw_act.date_tax_id_applied_for,
    vw_act.w_8_w_9_indicator,
    vw_act.w_8_w_9_date_signed,
    vw_act.w_8_w_9_effective_date,
    vw_act.w_8_w_9_document_type,
    CASE
       WHEN TRIM(BOTH FROM vw_act.w_8_w_9_indicator) = 'W8'::text THEN vw_act.w_8_w_9_date_signed
       ELSE NULL::date
    END                                                                                    AS w_8_date_signed,
    CASE
       WHEN TRIM(BOTH FROM vw_act.w_8_w_9_indicator) = 'W8'::text THEN vw_act.w_8_w_9_effective_date
       ELSE NULL::date
    END                                                                                    AS w_8_effective_date,
    CASE
       WHEN TRIM(BOTH FROM vw_act.w_8_w_9_indicator) = 'W9'::text THEN vw_act.w_8_w_9_date_signed
       ELSE NULL::date
    END                                                                                    AS w_9_date_signed,
    CASE
       WHEN TRIM(BOTH FROM vw_act.w_8_w_9_indicator) = 'W9'::text THEN vw_act.w_8_w_9_effective_date
       ELSE NULL::date
    END                                                                                    AS w_9_effective_date,
    vw_act.tax_status,
    vw_act.b_notice_reason_code,
    vw_act.first_b_notice_status,
    vw_act.date_first_b_notice_status_issued_enforced,
    vw_act.date_first_notice_status_satisfied,
    vw_act.second_b_notice_status,
    vw_act.date_second_b_notice_status_issued_enforced,
    vw_act.date_second_b_notice_status_satisfied,
    vw_act.c_notice_status,
    vw_act.date_c_notice_status_issued_enforced,
    vw_act.date_c_notice_status_satisfied,
    vw_act.old_account_number,
    vw_act.original_account_open_date,
    vw_act.unidentified_large_trader_id,
    vw_act.large_trader_type_code,
    vw_act.large_trader_type_last_change_date,
    vw_act.initial_source_of_funds_other,
    vw_act.finance_away,
    vw_act.account_funding_date,
    vw_act.statement_currency_code,
    vw_act.future_statement_currency_code,
    vw_act.future_statement_currency_code_effective_date,
    vw_act.account_level_routing_code_1,
    vw_act.account_level_routing_code_2,
    vw_act.account_level_routing_code_3,
    vw_act.account_level_routing_code_4,
    vw_act.self_directed_ind,
    vw_act.digital_advice_ind,
    vw_act.pte_account_ind,
    vw_act.first_ip,
    vw_act.second_ip,
    vw_act.third_ip,
    vw_act.fourth_ip,
    vw_act.fifth_ip,
    vw_act.sixth_ip,
    vw_act.seventh_ip,
    vw_act.eighth_ip,
    vw_act.ninth_ip,
    vw_act.tenth_ip,
    vw_act.alert_im_acornym,
    vw_act.alert_im_access_code,
    vw_act.broker_acronym,
    vw_act.cross_reference_indicator,
    vw_act.bny_trust_indicator,
    vw_act.source_of_asset_at_acct_opening,
    vw_act.commission_doscount_code,
    vw_act.external_account_number,
    vw_act.confirmation_suppression_indicator,
    vw_act.date_last_mail_sent,
    vw_act.date_last_mail_sent_outside,
    vw_act.fully_paid_lending_agreement_indicator,
    vw_act.fully_paid_lending_agreement_date,
    vw_act.custodian_account_type,
    vw_act.mifid_customer_categorization,
    vw_act.cash_management_tran_code,
    vw_act.sweep_status_indicator,
    vw_act.date_sweep_activated,
    vw_act.date_sweep_details_changed,
    vw_act.cober_margin_debit_indicator,
    vw_act.first_fund_sweep_account_id,
    vw_act.firstfund_sweep_account_percent,
    vw_act.first_fundsweep_account_redemption_priority,
    vw_act.second_fund_sweep_account_id,
    vw_act.second_fund_sweep_account_percent,
    vw_act.second_fundsweep_account_redemption_priority,
    vw_act.type_of_bank_account,
    vw_act.banklink_aba_number,
    vw_act.banklink_dda_number,
    vw_act.fund_bank_indicator,
    vw_act.w_9_corp_tax_classification_code,
    vw_act.combined_margin_acct_indicator,
    vw_act.pledge_collateral_account_indicator,
    vw_act.finra_institutional_account_code,
    vw_act.proposed_account_reference_id,
    vw_act.advisor_model_id,
    vw_act.firm_model_style_id,
    vw_act.dvp_restriction_code,
    vw_act.dvp_restriction_exp_date,
    vw_act.escheatment_withholding_ind,
    vw_act.source_of_origination,
    vw_act.source_of_persona,
    vw_act.client_onboarding_method,
    vw_act.tax_filing_code,
    vw_act.nor_purpose_collateral_acct_ind,
    vw_act.addr_1_trx_code,
    vw_act.addr_1_special_handling_ind,
    vw_act.addr_1_delivery_id,
    vw_act.addr_1_attention_line_prefix,
    vw_act.addr_1_attention_line_detail,
    vw_act.addr_1_line_1,
    vw_act.addr_1_line_2,
    vw_act.addr_1_line_3,
    vw_act.addr_1_line_4,
    vw_act.addr_1_city_state,
    vw_act.addr_1_country_code,
    vw_act.addr_2_trx_code,
    vw_act.addr_2_special_handling_ind,
    vw_act.addr_2_delivery_id,
    vw_act.addr_2_attention_line_prefix,
    vw_act.addr_2_attention_line_detail,
    vw_act.addr_2_line_1,
    vw_act.addr_2_line_2,
    vw_act.addr_2_line_3,
    vw_act.addr_2_line_4,
    vw_act.addr_2_city_state,
    vw_act.addr_2_country_code,
    vw_act.account_description,
    vw_act.set_as_mail_addr_2_ind,
    vw_act.principal_billing_allocation_pct,
    vw_act.seasonal_addr_id_1,
    vw_act.from_date_1,
    vw_act.to_date_1,
    vw_act.seasonal_addr_id_2,
    vw_act.from_date_2,
    vw_act.to_date_2,
    vw_act.seasonal_addr_id_3,
    vw_act.from_date_3,
    vw_act.to_date_3,
    vw_act.cost_basis_acct_system,
    vw_act.disposition_method_mutual_funds,
    vw_act.disposition_method_other,
    vw_act.disposition_method_stocks,
    vw_act.amortize_taxable_premium_bonds,
    vw_act.accrue_market_disc_based_on,
    vw_act.accrue_market_disc_income,
    vw_act.addr_3_trx_code,
    vw_act.addr_3_special_handling_ind,
    vw_act.addr_3_delivery_id,
    vw_act.addr_3_attention_line_prefix,
    vw_act.addr_3_attention_line_detail,
    vw_act.addr_3_line_1,
    vw_act.addr_3_line_2,
    vw_act.addr_3_line_3,
    vw_act.addr_3_line_4,
    vw_act.addr_3_city_state,
    vw_act.addr_3_country_code,
    vw_act.set_as_mail_addr_3_ind,
    vw_act.addr_4_trx_code,
    vw_act.addr_4_special_handling_ind,
    vw_act.addr_4_delivery_id,
    vw_act.addr_4_attention_line_prefix,
    vw_act.addr_4_attention_line_detail,
    vw_act.addr_4_line_1,
    vw_act.addr_4_line_2,
    vw_act.addr_4_line_3,
    vw_act.addr_4_line_4,
    vw_act.addr_4_city_state,
    vw_act.addr_4_country_code,
    vw_act.set_as_mail_addr_4_ind,
    vw_act.addr_5_trx_code,
    vw_act.addr_5_special_handling_ind,
    vw_act.addr_5_delivery_id,
    vw_act.addr_5_attention_line_prefix,
    vw_act.addr_5_attention_line_detail,
    vw_act.addr_5_line_1,
    vw_act.addr_5_line_2,
    vw_act.addr_5_line_3,
    vw_act.addr_5_line_4,
    vw_act.addr_5_city_state,
    vw_act.addr_5_country_code,
    vw_act.set_as_mail_addr_5_ind,
    vw_act.addr_6_trx_code,
    vw_act.addr_6_special_handling_ind,
    vw_act.addr_6_delivery_id,
    vw_act.addr_6_attention_line_prefix,
    vw_act.addr_6_attention_line_detail,
    vw_act.addr_6_line_1,
    vw_act.addr_6_line_2,
    vw_act.addr_6_line_3,
    vw_act.addr_6_line_4,
    vw_act.addr_6_city_state,
    vw_act.addr_6_country_code,
    vw_act.set_as_mail_addr_6_ind,
    vw_act.addr_7_trx_code,
    vw_act.addr_7_special_handling_ind,
    vw_act.addr_7_delivery_id,
    vw_act.addr_7_attention_line_prefix,
    vw_act.addr_7_attention_line_detail,
    vw_act.addr_7_line_1,
    vw_act.addr_7_line_2,
    vw_act.addr_7_line_3,
    vw_act.addr_7_line_4,
    vw_act.addr_7_city_state,
    vw_act.addr_7_country_code,
    vw_act.set_as_mail_addr_7_ind,
    vw_act.record_transaction_code,
    vw_act.base_currency,
    vw_act.income_currency,
    vw_act.statement_language,
    vw_act.statement_format_code,
    vw_act.msrb_statement_ind,
    vw_act.pep,
    vw_act.first_name_pep,
    vw_act.last_name_pep,
    vw_act.suffix_pep,
    vw_act.political_office_held,
    vw_act.country_of_office,
    vw_act.foreign_bank_account_ind,
    vw_act.foreign_bank_cert_date,
    vw_act.foreign_bank_cert_exp_date,
    vw_act.central_bank_ind,
    vw_act.acct_foreign_financial_inst,
    vw_act.foreign_bank_acct_oper_1,
    vw_act.foreign_bank_acct_oper_2,
    vw_act.foreign_bank_acct_oper_3,
    vw_act.number_people_own,
    vw_act.proprietary_acct_owned,
    vw_act.tel_1_transaction_code,
    vw_act.tel_1_us_ind,
    vw_act.tel_1_type_id,
    vw_act.tel_1_number,
    vw_act.tel_1_extension,
    vw_act.tel_2_transaction_code,
    vw_act.tel_2_us_ind,
    vw_act.tel_2_type_id,
    vw_act.tel_2_number,
    vw_act.tel_2_extension,
    vw_act.tel_3_transaction_code,
    vw_act.tel_3_us_ind,
    vw_act.tel_3_type_id,
    vw_act.tel_3_number,
    vw_act.tel_3_extension,
    vw_act.tel_4_transaction_code,
    vw_act.tel_4_us_ind,
    vw_act.tel_4_type_id,
    vw_act.tel_4_number,
    vw_act.tel_4_extension,
    vw_act.tel_5_transaction_code,
    vw_act.tel_5_us_ind,
    vw_act.tel_5_type_id,
    vw_act.tel_5_number,
    vw_act.tel_5_extension,
    vw_act.tel_6_transaction_code,
    vw_act.tel_6_us_ind,
    vw_act.tel_6_type_id,
    vw_act.tel_6_number,
    vw_act.tel_6_extension,
    vw_act.tel_7_transaction_code,
    vw_act.tel_7_us_ind,
    vw_act.tel_7_type_id,
    vw_act.tel_7_number,
    vw_act.tel_7_extension,
    vw_act.tel_8_transaction_code,
    vw_act.tel_8_us_ind,
    vw_act.tel_8_type_id,
    vw_act.tel_8_number,
    vw_act.tel_8_extension,
    vw_act.email_address,
    vw_act.external_position_ind,
    vw_act.purge_eligible_ind,
    vw_act.advisory_acct_ind,
    vw_act.product_profile_code,
    vw_act.cents_per_share_discount,
    vw_act.option_disclosure_date,
    vw_act.country_acct_level_tax_residency
    FROM pershing.vw_maestro_acct vw_act
    LEFT JOIN pershing.par_country_code par_cc_res
        ON vw_act.country_of_residence::text = par_cc_res.iso_code::text
    LEFT JOIN pershing.par_country_code par_cc_cit
        ON vw_act.primary_country_of_citizenship::text = par_cc_cit.iso_code::text
    LEFT JOIN pershing.par_registration_type par_reg_type
        ON vw_act.registration_type::text = par_reg_type.id::text
    ;

--========================================================================
--========================================================================
--========================================================================
--
create view public.vw_maestro_cuentas_pershing
            (id, custodian, client_id, name, ibd_number, id_office, ip_number, account_no, id_proceso, process_date, record_id_sequence_number,
             account_short_name, full_name, full_address, transaction_type, autotitled_usertitled_account,
             account_type_code, registration_type, registration_type_value, number_of_account_title_lines,
             account_registration_line_1, account_registration_line_2, account_registration_line_3,
             account_registration_line_4, account_registration_line_5, account_registration_line_6,
             registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator,
             pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date,
             date_account_reopened, proceeds, transfer_instructions, income_isntructions,
             number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code,
             comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked,
             statement_review_date, margin_papers_on_file, cash_margin_account, option_papers_on_file,
             good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted,
             invest_advisor_discretion_granted_value, third_party_discretion_granted, third_party_name,
             risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency,
             option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits,
             option_total_limits_of_puts_and_calls, non_us_dollar_trading, non_customer_indicator,
             third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule,
             group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic,
             employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date,
             plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative,
             commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form,
             date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form,
             date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account,
             foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, country_of_citizenship_code,
             country_of_citizenship_value, country_of_residence_code, country_of_residence_value, birth_date,
             age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status,
             regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, customer_type,
             fulfillment_method, credit_interest_indicator, ama_indicator, ama_indicator_value, tax_id_type,
             tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date,
             w_8_w_9_document_type, w_8_date_signed, w_8_effective_date, w_9_date_signed, w_9_effective_date,
             tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced,
             date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced,
             date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced,
             date_c_notice_status_satisfied, old_account_number, original_account_open_date,
             unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date,
             initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code,
             future_statement_currency_code, future_statement_currency_code_effective_date,
             account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3,
             account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip,
             third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym,
             alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator,
             source_of_asset_at_acct_opening, commission_doscount_code, external_account_number,
             confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside,
             fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type,
             mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated,
             date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id,
             firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id,
             second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account,
             banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code,
             combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code,
             proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code,
             dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona,
             client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code,
             addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix,
             addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4,
             addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id,
             addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3,
             addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind,
             principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2,
             from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system,
             disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks,
             amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code,
             addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix,
             addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4,
             addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code,
             addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix,
             addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4,
             addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code,
             addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix,
             addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4,
             addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code,
             addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix,
             addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4,
             addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code,
             addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix,
             addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4,
             addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency,
             income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep,
             last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind,
             foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst,
             foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own,
             proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension,
             tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code,
             tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind,
             tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id,
             tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number,
             tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension,
             tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address,
             external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code,
             cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency)
as
SELECT
    vw_act.id,
    vw_act.custodian,
    maestro_crm.identificador_cliente AS client_id,
    maestro_crm.nombre_cliente AS name,
    vw_act.ibd_number,
    vw_act.id_office,
    vw_act.ip_number,
    vw_act.account_number as account_no,
    vw_act.id_proceso,
    vw_act.process_date,
    vw_act.record_id_sequence_number,
    vw_act.account_short_name,
    vw_act.full_name,
    vw_act.full_address,
    vw_act.transaction_type,
    vw_act.autotitled_usertitled_account,
    vw_act.account_type_code,
    vw_act.registration_type,
    vw_act.registration_type_value,
    vw_act.number_of_account_title_lines,
    vw_act.account_registration_line_1,
    vw_act.account_registration_line_2,
    vw_act.account_registration_line_3,
    vw_act.account_registration_line_4,
    vw_act.account_registration_line_5,
    vw_act.account_registration_line_6,
    vw_act.registration_type_detail,
    vw_act.date_account_opened,
    vw_act.date_account_information_updated,
    vw_act.account_status_indicator,
    vw_act.pending_closed_date,
    vw_act.date_account_closed,
    vw_act.closing_notice_date,
    vw_act.account_reactivated_date,
    vw_act.date_account_reopened,
    vw_act.proceeds,
    vw_act.transfer_instructions,
    vw_act.income_isntructions,
    vw_act.number_of_confirms_for_thi_account,
    vw_act.number_of_statements_for_this_account,
    vw_act.investment_objetive_trans_code,
    vw_act.comments_act,
    vw_act.employer_shotname,
    vw_act.employers_cusip,
    vw_act.employers_symbol,
    vw_act.margin_privileges_revoked,
    vw_act.statement_review_date,
    vw_act.margin_papers_on_file,
    vw_act.cash_margin_account,
    vw_act.option_papers_on_file,
    vw_act.good_faith_margin,
    vw_act.ip_discretion_granted,
    vw_act.invest_advisor_discretion_granted,
    vw_act.invest_advisor_discretion_granted_value,
    vw_act.third_party_discretion_granted,
    vw_act.third_party_name,
    vw_act.risk_factor_code,
    vw_act.investment_objetive_code,
    vw_act.option_equities,
    vw_act.option_index,
    vw_act.option_debt,
    vw_act.option_currency,
    vw_act.option_level_1,
    vw_act.option_level_2,
    vw_act.option_level_3,
    vw_act.option_level_4,
    vw_act.option_call_limits,
    vw_act.option_put_limits,
    vw_act.option_total_limits_of_puts_and_calls,
    vw_act.non_us_dollar_trading,
    vw_act.non_customer_indicator,
    vw_act.third_party_fee_indicator,
    vw_act.third_party_fee_approval_date,
    vw_act.intermediary_account_ind,
    vw_act.commission_schedule,
    vw_act.group_index,
    vw_act.money_manager_id,
    vw_act.money_manager_objective_id,
    vw_act.dtc_id_confirm_number,
    vw_act.caps_master_mnemonic,
    vw_act.employee_id,
    vw_act.prime_broker_free_fund_indicator,
    vw_act.fee_based_account_indicator,
    vw_act.fee_based_termination_date,
    vw_act.plan_name,
    vw_act.self_directed_401_k_account_type,
    vw_act.plan_type,
    vw_act.plan_number,
    vw_act.employee_or_employee_relative,
    vw_act.commission_percent_discount,
    vw_act.ind_12_b_1_fee_blocking,
    vw_act.name_of_ip_signed_new_account_form,
    vw_act.date_of_ip_signed_new_account_form,
    vw_act.name_of_principal_signed_new_account_form,
    vw_act.date_of_principal_signed_new_account_form,
    vw_act.politically_exposed_person,
    vw_act.private_banking_account,
    vw_act.foreign_bank_account,
    vw_act.initial_source_of_funds,
    vw_act.usa_patriot_act_exempt_reason,
    vw_act.country_of_citizenship_code,
    vw_act.country_of_citizenship_value,
    vw_act.country_of_residence_code,
    vw_act.country_of_residence_value,
    vw_act.birth_date,
    vw_act.age_based_fund_roll_exempt,
    vw_act.money_fundreform_retail,
    vw_act.trusted_contact_status,
    vw_act.regulatory_account_type_category,
    vw_act.account_managed_by_trust_comp_id,
    vw_act.voting_auth,
    vw_act.customer_type,
    vw_act.fulfillment_method,
    vw_act.credit_interest_indicator,
    vw_act.ama_indicator,
    vw_act.ama_indicator_value,
    vw_act.tax_id_type,
    vw_act.tax_id_number,
    vw_act.date_tax_id_applied_for,
    vw_act.w_8_w_9_indicator,
    vw_act.w_8_w_9_date_signed,
    vw_act.w_8_w_9_effective_date,
    vw_act.w_8_w_9_document_type,
    vw_act.w_8_date_signed,
    vw_act.w_8_effective_date,
    vw_act.w_9_date_signed,
    vw_act.w_9_effective_date,
    vw_act.tax_status,
    vw_act.b_notice_reason_code,
    vw_act.first_b_notice_status,
    vw_act.date_first_b_notice_status_issued_enforced,
    vw_act.date_first_notice_status_satisfied,
    vw_act.second_b_notice_status,
    vw_act.date_second_b_notice_status_issued_enforced,
    vw_act.date_second_b_notice_status_satisfied,
    vw_act.c_notice_status,
    vw_act.date_c_notice_status_issued_enforced,
    vw_act.date_c_notice_status_satisfied,
    vw_act.old_account_number,
    vw_act.original_account_open_date,
    vw_act.unidentified_large_trader_id,
    vw_act.large_trader_type_code,
    vw_act.large_trader_type_last_change_date,
    vw_act.initial_source_of_funds_other,
    vw_act.finance_away,
    vw_act.account_funding_date,
    vw_act.statement_currency_code,
    vw_act.future_statement_currency_code,
    vw_act.future_statement_currency_code_effective_date,
    vw_act.account_level_routing_code_1,
    vw_act.account_level_routing_code_2,
    vw_act.account_level_routing_code_3,
    vw_act.account_level_routing_code_4,
    vw_act.self_directed_ind,
    vw_act.digital_advice_ind,
    vw_act.pte_account_ind,
    vw_act.first_ip,
    vw_act.second_ip,
    vw_act.third_ip,
    vw_act.fourth_ip,
    vw_act.fifth_ip,
    vw_act.sixth_ip,
    vw_act.seventh_ip,
    vw_act.eighth_ip,
    vw_act.ninth_ip,
    vw_act.tenth_ip,
    vw_act.alert_im_acornym,
    vw_act.alert_im_access_code,
    vw_act.broker_acronym,
    vw_act.cross_reference_indicator,
    vw_act.bny_trust_indicator,
    vw_act.source_of_asset_at_acct_opening,
    vw_act.commission_doscount_code,
    vw_act.external_account_number,
    vw_act.confirmation_suppression_indicator,
    vw_act.date_last_mail_sent,
    vw_act.date_last_mail_sent_outside,
    vw_act.fully_paid_lending_agreement_indicator,
    vw_act.fully_paid_lending_agreement_date,
    vw_act.custodian_account_type,
    vw_act.mifid_customer_categorization,
    vw_act.cash_management_tran_code,
    vw_act.sweep_status_indicator,
    vw_act.date_sweep_activated,
    vw_act.date_sweep_details_changed,
    vw_act.cober_margin_debit_indicator,
    vw_act.first_fund_sweep_account_id,
    vw_act.firstfund_sweep_account_percent,
    vw_act.first_fundsweep_account_redemption_priority,
    vw_act.second_fund_sweep_account_id,
    vw_act.second_fund_sweep_account_percent,
    vw_act.second_fundsweep_account_redemption_priority,
    vw_act.type_of_bank_account,
    vw_act.banklink_aba_number,
    vw_act.banklink_dda_number,
    vw_act.fund_bank_indicator,
    vw_act.w_9_corp_tax_classification_code,
    vw_act.combined_margin_acct_indicator,
    vw_act.pledge_collateral_account_indicator,
    vw_act.finra_institutional_account_code,
    vw_act.proposed_account_reference_id,
    vw_act.advisor_model_id,
    vw_act.firm_model_style_id,
    vw_act.dvp_restriction_code,
    vw_act.dvp_restriction_exp_date,
    vw_act.escheatment_withholding_ind,
    vw_act.source_of_origination,
    vw_act.source_of_persona,
    vw_act.client_onboarding_method,
    vw_act.tax_filing_code,
    vw_act.nor_purpose_collateral_acct_ind,
    vw_act.addr_1_trx_code,
    vw_act.addr_1_special_handling_ind,
    vw_act.addr_1_delivery_id,
    vw_act.addr_1_attention_line_prefix,
    vw_act.addr_1_attention_line_detail,
    vw_act.addr_1_line_1,
    vw_act.addr_1_line_2,
    vw_act.addr_1_line_3,
    vw_act.addr_1_line_4,
    vw_act.addr_1_city_state,
    vw_act.addr_1_country_code,
    vw_act.addr_2_trx_code,
    vw_act.addr_2_special_handling_ind,
    vw_act.addr_2_delivery_id,
    vw_act.addr_2_attention_line_prefix,
    vw_act.addr_2_attention_line_detail,
    vw_act.addr_2_line_1,
    vw_act.addr_2_line_2,
    vw_act.addr_2_line_3,
    vw_act.addr_2_line_4,
    vw_act.addr_2_city_state,
    vw_act.addr_2_country_code,
    vw_act.account_description,
    vw_act.set_as_mail_addr_2_ind,
    vw_act.principal_billing_allocation_pct,
    vw_act.seasonal_addr_id_1,
    vw_act.from_date_1,
    vw_act.to_date_1,
    vw_act.seasonal_addr_id_2,
    vw_act.from_date_2,
    vw_act.to_date_2,
    vw_act.seasonal_addr_id_3,
    vw_act.from_date_3,
    vw_act.to_date_3,
    vw_act.cost_basis_acct_system,
    vw_act.disposition_method_mutual_funds,
    vw_act.disposition_method_other,
    vw_act.disposition_method_stocks,
    vw_act.amortize_taxable_premium_bonds,
    vw_act.accrue_market_disc_based_on,
    vw_act.accrue_market_disc_income,
    vw_act.addr_3_trx_code,
    vw_act.addr_3_special_handling_ind,
    vw_act.addr_3_delivery_id,
    vw_act.addr_3_attention_line_prefix,
    vw_act.addr_3_attention_line_detail,
    vw_act.addr_3_line_1,
    vw_act.addr_3_line_2,
    vw_act.addr_3_line_3,
    vw_act.addr_3_line_4,
    vw_act.addr_3_city_state,
    vw_act.addr_3_country_code,
    vw_act.set_as_mail_addr_3_ind,
    vw_act.addr_4_trx_code,
    vw_act.addr_4_special_handling_ind,
    vw_act.addr_4_delivery_id,
    vw_act.addr_4_attention_line_prefix,
    vw_act.addr_4_attention_line_detail,
    vw_act.addr_4_line_1,
    vw_act.addr_4_line_2,
    vw_act.addr_4_line_3,
    vw_act.addr_4_line_4,
    vw_act.addr_4_city_state,
    vw_act.addr_4_country_code,
    vw_act.set_as_mail_addr_4_ind,
    vw_act.addr_5_trx_code,
    vw_act.addr_5_special_handling_ind,
    vw_act.addr_5_delivery_id,
    vw_act.addr_5_attention_line_prefix,
    vw_act.addr_5_attention_line_detail,
    vw_act.addr_5_line_1,
    vw_act.addr_5_line_2,
    vw_act.addr_5_line_3,
    vw_act.addr_5_line_4,
    vw_act.addr_5_city_state,
    vw_act.addr_5_country_code,
    vw_act.set_as_mail_addr_5_ind,
    vw_act.addr_6_trx_code,
    vw_act.addr_6_special_handling_ind,
    vw_act.addr_6_delivery_id,
    vw_act.addr_6_attention_line_prefix,
    vw_act.addr_6_attention_line_detail,
    vw_act.addr_6_line_1,
    vw_act.addr_6_line_2,
    vw_act.addr_6_line_3,
    vw_act.addr_6_line_4,
    vw_act.addr_6_city_state,
    vw_act.addr_6_country_code,
    vw_act.set_as_mail_addr_6_ind,
    vw_act.addr_7_trx_code,
    vw_act.addr_7_special_handling_ind,
    vw_act.addr_7_delivery_id,
    vw_act.addr_7_attention_line_prefix,
    vw_act.addr_7_attention_line_detail,
    vw_act.addr_7_line_1,
    vw_act.addr_7_line_2,
    vw_act.addr_7_line_3,
    vw_act.addr_7_line_4,
    vw_act.addr_7_city_state,
    vw_act.addr_7_country_code,
    vw_act.set_as_mail_addr_7_ind,
    vw_act.record_transaction_code,
    vw_act.base_currency,
    vw_act.income_currency,
    vw_act.statement_language,
    vw_act.statement_format_code,
    vw_act.msrb_statement_ind,
    vw_act.pep,
    vw_act.first_name_pep,
    vw_act.last_name_pep,
    vw_act.suffix_pep,
    vw_act.political_office_held,
    vw_act.country_of_office,
    vw_act.foreign_bank_account_ind,
    vw_act.foreign_bank_cert_date,
    vw_act.foreign_bank_cert_exp_date,
    vw_act.central_bank_ind,
    vw_act.acct_foreign_financial_inst,
    vw_act.foreign_bank_acct_oper_1,
    vw_act.foreign_bank_acct_oper_2,
    vw_act.foreign_bank_acct_oper_3,
    vw_act.number_people_own,
    vw_act.proprietary_acct_owned,
    vw_act.tel_1_transaction_code,
    vw_act.tel_1_us_ind,
    vw_act.tel_1_type_id,
    vw_act.tel_1_number,
    vw_act.tel_1_extension,
    vw_act.tel_2_transaction_code,
    vw_act.tel_2_us_ind,
    vw_act.tel_2_type_id,
    vw_act.tel_2_number,
    vw_act.tel_2_extension,
    vw_act.tel_3_transaction_code,
    vw_act.tel_3_us_ind,
    vw_act.tel_3_type_id,
    vw_act.tel_3_number,
    vw_act.tel_3_extension,
    vw_act.tel_4_transaction_code,
    vw_act.tel_4_us_ind,
    vw_act.tel_4_type_id,
    vw_act.tel_4_number,
    vw_act.tel_4_extension,
    vw_act.tel_5_transaction_code,
    vw_act.tel_5_us_ind,
    vw_act.tel_5_type_id,
    vw_act.tel_5_number,
    vw_act.tel_5_extension,
    vw_act.tel_6_transaction_code,
    vw_act.tel_6_us_ind,
    vw_act.tel_6_type_id,
    vw_act.tel_6_number,
    vw_act.tel_6_extension,
    vw_act.tel_7_transaction_code,
    vw_act.tel_7_us_ind,
    vw_act.tel_7_type_id,
    vw_act.tel_7_number,
    vw_act.tel_7_extension,
    vw_act.tel_8_transaction_code,
    vw_act.tel_8_us_ind,
    vw_act.tel_8_type_id,
    vw_act.tel_8_number,
    vw_act.tel_8_extension,
    vw_act.email_address,
    vw_act.external_position_ind,
    vw_act.purge_eligible_ind,
    vw_act.advisory_acct_ind,
    vw_act.product_profile_code,
    vw_act.cents_per_share_discount,
    vw_act.option_disclosure_date,
    vw_act.country_acct_level_tax_residency
    FROM pershing.vw_maestro_cuenta vw_act
    LEFT JOIN clientes.vw_maestro_clientes_cuentas maestro_crm
        ON vw_act.id_custodian= maestro_crm.id_custodio AND vw_act.account_number = maestro_crm.id_cuenta_custodio

;



--========================================================================
--========================================================================
--========================================================================
--


create view public.vw_maestro_movimientos_pershing
            (custodian, client_id, office_id, account_no, name, process_date, tipo_reg, trade_date, settlement_date,
             activity, buy_sell_code, buy_sell_value, quantity, price, commission, fees, net_amount, usde_net_amount,
             principal, cusip, symbol, isin, currency, fx_rate, interest, currency_base, cash_margin, product_type,
             security_description, activity_description, activity_code, source_code, reporte, description_1,
             description_2, description_3, ticker, id_sub_sub_tipo, id_sub_tipo, id_tipo, nombre_sub_sub_tipo, sec_id,
             flujo_neto, advisory_fee_anual, id_cuenta_custodio, sec_type)
as
SELECT vw_mov_persh.custodian,
       maestro_crm.identificador_cliente AS client_id,
       vw_mov_persh.office_id,
       vw_mov_persh.account_no,
       maestro_crm.nombre_cliente AS name,
       vw_mov_persh.process_date,
       vw_mov_persh.tipo_reg,
       COALESCE(vw_mov_persh.trade_date, fn_fecha_string_to_date(vw_mov_persh.process_date,
                                                                 'YYYYMMDD'::character varying))              AS trade_date,
       vw_mov_persh.settlement_date,
       par_src_cod.descripcion_movimiento                                                                     AS activity,
       vw_mov_persh.buy_sell_code,
       vw_mov_persh.buy_sell_value,
       COALESCE(vw_mov_persh.quantity,
                CASE
                    WHEN vw_mov_persh.price <> 0::numeric THEN vw_mov_persh.net_amount / vw_mov_persh.price
                    ELSE NULL::numeric
                    END)::numeric(45, 20)                                                                     AS quantity,
       vw_mov_persh.price,
       vw_mov_persh.commission,
       vw_mov_persh.total_fees                                                                                AS fees,
       COALESCE(vw_mov_persh.net_amount, vw_mov_persh.quantity * vw_mov_persh.price *
                                         COALESCE(vw_mov_persh.factored_market_value_multiplier,
                                                  1::numeric(45, 20)))::numeric(45, 20)                       AS net_amount,
       COALESCE(vw_mov_persh.usde_net_amount, vw_mov_persh.quantity * vw_mov_persh.price * vw_mov_persh.fx_rate *
                                              COALESCE(vw_mov_persh.factored_market_value_multiplier,
                                                       1::numeric(45, 20)))::numeric(45, 20)                  AS usde_net_amount,
       COALESCE(vw_mov_persh.principal, vw_mov_persh.net_amount,
                vw_mov_persh.quantity * vw_mov_persh.price * vw_mov_persh.fx_rate *
                COALESCE(vw_mov_persh.factored_market_value_multiplier,
                         1::numeric(45, 20)))::numeric(45, 20)                                                AS principal,
       vw_mov_persh.cusip,
       CASE
           WHEN TRIM(BOTH FROM COALESCE(vw_mov_persh.symbol, ''::character varying)) = ''::text AND
                vw_mov_persh.cusip::text = 'USD999997'::text THEN vw_mov_persh.cusip
           ELSE vw_mov_persh.symbol
           END                                                                                                AS symbol,
       vw_mov_persh.isin,
       vw_mov_persh.currency,
       vw_mov_persh.fx_rate,
       vw_mov_persh.interest,
       vw_mov_persh.currency_base,
       vw_mov_persh.cash_margin,
       vw_mov_persh.id_sub_sub_tipo                                                                           AS product_type,
       vw_mov_persh.security_description,
       CASE
           WHEN vw_mov_persh.tipo_reg::text = 'NON_TDE'::text THEN
               CASE
                   WHEN TRIM(BOTH FROM vw_mov_persh.source_code) = 'CHRG'::text AND
                        POSITION(('FgnFee'::text) IN (vw_mov_persh.description_1)) = 0 THEN TRIM(BOTH FROM
                                                                                                 (((TRIM(BOTH FROM vw_mov_persh.description_1) || ' '::text) ||
                                                                                                   TRIM(BOTH FROM vw_mov_persh.description_2)) ||
                                                                                                  ' '::text) ||
                                                                                                 TRIM(BOTH FROM vw_mov_persh.description_3))
                   ELSE par_src_cod.descripcion_movimiento::text
                   END
           WHEN vw_mov_persh.isin::text = '9999246'::text THEN
                   (((((((COALESCE(vw_mov_persh.buy_sell_value::character varying(100),
                                   ''::character varying)::character varying(100)::text || ' $'::text) ||
                         COALESCE(abs(vw_mov_persh.net_amount::numeric(45, 2))::character varying(100),
                                  ''::character varying)::character varying(100)::text) || ' ISIN #'::text) ||
                       COALESCE(vw_mov_persh.isin, ''::character varying)::character varying(100)::text) ||
                      ' TD:'::text) || COALESCE((((substr(vw_mov_persh.trade_date::text, 6, 2) || '/'::text) ||
                                                  substr(vw_mov_persh.trade_date::text, 9, 2)) || '/'::text) ||
                                                substr(vw_mov_persh.trade_date::text, 1, 4),
                                                ''::text)::character varying(100)::text) || ' SD:'::text) || COALESCE(
                               (((substr(vw_mov_persh.settlement_date::text, 6, 2) || '/'::text) ||
                                 substr(vw_mov_persh.settlement_date::text, 9, 2)) || '/'::text) ||
                               substr(vw_mov_persh.settlement_date::text, 1, 4), ''::text)::character varying(100)::text
           ELSE (((((((((COALESCE(vw_mov_persh.buy_sell_value::character varying(100),
                                  ''::character varying)::character varying(100)::text || ' '::text) ||
                        COALESCE(abs(vw_mov_persh.quantity::numeric(45, 2))::character varying(100),
                                 ''::character varying)::character varying(100)::text) || ' SHRS OF ISIN #'::text) ||
                      COALESCE(vw_mov_persh.isin, ''::character varying)::character varying(100)::text) ||
                     ' PRICE: $'::text) || COALESCE(vw_mov_persh.price::numeric(45, 4)::character varying(100),
                                                    ''::character varying)::character varying(100)::text) ||
                   ' TD:'::text) || COALESCE((((substr(vw_mov_persh.trade_date::text, 6, 2) || '/'::text) ||
                                               substr(vw_mov_persh.trade_date::text, 9, 2)) || '/'::text) ||
                                             substr(vw_mov_persh.trade_date::text, 1, 4),
                                             ''::text)::character varying(100)::text) || ' SD:'::text) || COALESCE(
                            (((substr(vw_mov_persh.settlement_date::text, 6, 2) || '/'::text) ||
                              substr(vw_mov_persh.settlement_date::text, 9, 2)) || '/'::text) ||
                            substr(vw_mov_persh.settlement_date::text, 1, 4), ''::text)::character varying(100)::text
           END::character varying(100)                                                                        AS activity_description,
       vw_mov_persh.source_code                                                                               AS activity_code,
       vw_mov_persh.source_code,
       NULL::character varying(100)                              AS reporte,
       vw_mov_persh.description_1,
       vw_mov_persh.description_2,
       vw_mov_persh.description_3,
       vw_mov_persh.ticker,
       vw_mov_persh.id_sub_sub_tipo,
       vw_mov_persh.id_sub_tipo,
       vw_mov_persh.id_tipo,
       par_asset.glosa::character varying(100)                                                                AS nombre_sub_sub_tipo,
       NULL::character varying(100)                                                                           AS sec_id,
       par_src_cod.aplica_flujo_neto                                                                          AS flujo_neto,
       NULL::NUMERIC(45,20) AS advisory_fee_anual,
       maestro_crm.id_cuenta_custodio,
       NULL::character varying(100)                                                                           AS sec_type
FROM (
    SELECT
        'pershing'::character varying(100) AS id_custodian,
        fn_obtiene_valor_parametro('custodian'::character varying, 'pershing'::character varying)::VARCHAR(100) AS custodian,
        "left"(tb_mov.account_number::text, 3)::VARCHAR(100) AS office_id,
        "left"(tb_mov.account_number::text, 9)::VARCHAR(100) AS account_no,
        tb_mov.account_number AS account_number_full,
        pershing.fn_obtiene_valor_param_generic_pershing('account_type'::character varying,"right"(tb_mov.account_number::text, 1)::character varying)::VARCHAR(100) AS cash_margin,
        tb_mov.process_date,
        CASE
            WHEN tb_mov.buy_sell_code::text <> ALL (ARRAY ['B'::character varying::text, 'S'::character varying::text]) THEN 'NON_TDE'::text
            ELSE 'TDE_INST'::text
        END::VARCHAR(100) AS tipo_reg,
        tb_mov.trade_date,
        tb_mov.settlement_entry_date AS settlement_date,
        tb_mov.buy_sell_code,
        pershing.fn_obtiene_valor_param_generic_pershing('buy_sell_code'::character varying,tb_mov.buy_sell_code)::VARCHAR(100) AS buy_sell_value,
        tb_mov.quantity,
        COALESCE(tb_mov.price_in_trade_currency, tb_det.latest_price) AS price,
        COALESCE(tb_mov.commision_in_usd, 0::numeric)::numeric(45, 20) AS commission,
        (COALESCE(tb_mov.misc_fee_in_usd, 0::numeric) + COALESCE(tb_mov.other_fee_in_usd, 0::numeric) +
            COALESCE(tb_mov.settlement_fee_in_usd, 0::numeric) +
            COALESCE(tb_mov.transaction_fee_in_usd, 0::numeric))::numeric(45, 20) AS total_fees,
        (tb_mov.net_amount_in_usd * '-1'::integer::numeric)::numeric(45, 20) AS net_amount,
        tb_mov.net_amount_in_usd * '-1'::integer::numeric * tb_mov.settlement_usd_currency_fx_rate AS usde_net_amount,
        tb_mov.principal_in_usd AS principal,
        tb_mov.cusip_number AS cusip,
        tb_mov.security_symbol AS symbol,
        tb_det.isin_code AS isin,
        tb_mov.trade_currency_code AS currency,
        tb_mov.settlement_usd_currency_fx_rate AS fx_rate,
        COALESCE(tb_mov.interest_in_usd, 0::numeric)::numeric(45, 20) AS interest,
        tb_mov.security_currency_of_issuance AS currency_base,
        TRIM(BOTH FROM (((((((((TRIM(BOTH FROM tb_det.secutiry_description_line_1) || ' '::text) ||
            TRIM(BOTH FROM tb_det.secutiry_description_line_2)) || ' '::text) ||
            TRIM(BOTH FROM tb_det.secutiry_description_line_3)) || ' '::text) ||
            TRIM(BOTH FROM tb_det.secutiry_description_line_4)) || ' '::text) ||
            TRIM(BOTH FROM tb_det.secutiry_description_line_5)) || ' '::text) ||
            TRIM(BOTH FROM tb_det.secutiry_description_line_6))::VARCHAR(100) AS security_description,
        CASE
            WHEN tb_mov.transaction_type::text = 'T'::text THEN 'TDE'::character varying
            ELSE tb_mov.source_code
        END::VARCHAR(100) AS source_code,
        TRIM(BOTH FROM tb_mov.description_line_1) AS description_1,
        TRIM(BOTH FROM tb_mov.description_line_2) AS description_2,
        TRIM(BOTH FROM tb_mov.description_line_3) AS description_3,
        tb_mov.security_symbol AS ticker,
        tb_det.asset_subsubtype AS id_sub_sub_tipo,
        tb_det.asset_subtype AS id_sub_tipo,
        tb_det.asset_type AS id_tipo,
        tb_det.factored_market_value_multiplier
    FROM pershing.sfl_gact tb_mov
    LEFT JOIN pershing.sfl_isca tb_det
        ON tb_mov.process_date::text = tb_det.process_date::text AND tb_mov.cusip_number::text = tb_det.cusip_number::text
    WHERE TRIM(BOTH FROM tb_mov.source_code) <> ALL (ARRAY ['ITS'::text, 'SGR'::text, 'NET'::text])
) vw_mov_persh
LEFT JOIN clientes.vw_maestro_clientes_cuentas maestro_crm
    ON vw_mov_persh.id_custodian= maestro_crm.id_custodio AND vw_mov_persh.account_no = maestro_crm.id_cuenta_custodio

LEFT JOIN par_source_code par_src_cod
    ON TRIM(BOTH FROM vw_mov_persh.source_code) = par_src_cod.source_code_pershing::text
    AND (par_src_cod.signo_movimiento IS NULL
        OR
        CASE
            WHEN COALESCE(vw_mov_persh.quantity,
            CASE
                WHEN vw_mov_persh.price <> 0::numeric
                THEN vw_mov_persh.net_amount / vw_mov_persh.price
                ELSE NULL::numeric
            END)::numeric(45, 20) >= 0::numeric THEN par_src_cod.signo_movimiento >= 0
            ELSE par_src_cod.signo_movimiento < 0
        END)
LEFT JOIN pershing.par_asset_type_code par_asset
    ON TRIM(BOTH FROM vw_mov_persh.id_tipo) = TRIM(BOTH FROM par_asset.id_tipo) AND
    TRIM(BOTH FROM vw_mov_persh.id_sub_tipo) = TRIM(BOTH FROM par_asset.id_sub_tipo) AND
    TRIM(BOTH FROM vw_mov_persh.id_sub_sub_tipo) = TRIM(BOTH FROM par_asset.id_sub_sub_tipo)
WHERE
    CASE
        WHEN par_src_cod.source_code_pershing IS NULL AND
        COALESCE(vw_mov_persh.net_amount, vw_mov_persh.quantity * vw_mov_persh.price) = 0::numeric THEN false
        ELSE true
    END;



--========================================================================
--========================================================================
--========================================================================
--

create view public.vw_maestro_saldos_pershing
            (custodian, tipo_reg, client_id, firm_no, sub_no, office_id, rep_no, rep, account_no, name, process_date,
             symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity, market_price,
             id_currency, currency, market_value, fx_rate, usde_market_value, advisory_fee_anual, factor,
             comision_devengada_diaria, usde_market_price, sec_no, desc_1, desc_2, desc_3, sedol, ticker,
             id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo, sec_id)
as
SELECT
    pos.custodian,
    pos.tipo_reg,
    pos.client_id,
    NULL::VARCHAR(100) as firm_no,
    NULL::VARCHAR(100) as sub_no,
    pos.office_id,
    NULL::VARCHAR(100) as rep_no,
    NULL::VARCHAR(100) as rep,
    pos.account_no,
    pos.name, pos.process_date,
    pos.symbol, pos.cusip, pos.isin_code, pos.product_type, pos.security_description, pos.cash_margin_account, pos.quantity, pos.market_price,
    pos.id_currency, pos.currency, pos.market_value, pos.fx_rate, pos.usde_market_value,
    NULL::NUMERIC(45,20) as advisory_fee_anual, NULL::int as factor,
    (pos.usde_market_value * tb_fee.fee_diario)::numeric(45, 20) AS comision_devengada_diaria,
    pos.usde_market_price, pos.sec_no,
    NULL::VARCHAR(100) as desc_1,
    NULL::VARCHAR(100) as desc_2,
    NULL::VARCHAR(100) as desc_3,
    NULL::VARCHAR(100) as sedol,
    NULL::VARCHAR(100) as ticker,
    pos.id_sub_sub_tipo_activo, pos.id_sub_tipo_activo, pos.id_tipo_activo, pos.nombre_sub_sub_tipo_activo,
    NULL::VARCHAR(100) as sec_id
    --TODO: mapear a tabla  tb_fee.annual_fee as fee_anual, tb_fee.fee_diario, tb_fee.fee_diario_proteccion, tb_fee.fee_diario_sura_corp, pos.total_usde_market_value,
FROM (
    SELECT
        vw_pos_val.custodian,
        vw_pos_val.tipo_reg,
        maestro_crm.identificador_cliente AS client_id,
        vw_pos_val.office_id,
        vw_pos_val.account_number as account_no,
        maestro_crm.nombre_cliente AS name,
        vw_pos_val.process_date,
        vw_pos_val.symbol,
        vw_pos_val.cusip,
        vw_pos_val.isin_code,
        vw_pos_val.product_type,
        vw_pos_val.security_description,
        vw_pos_val.cash_margin_account,
        vw_pos_val.quantity,
        vw_pos_val.market_price,
        vw_pos_val.id_currency,
        vw_pos_val.currency,
        vw_pos_val.market_value,
        vw_pos_val.fx_rate,
        vw_pos_val.usde_market_value,
        sum(vw_pos_val.usde_market_value) over (partition by vw_pos_val.process_date, vw_pos_val.account_number) as total_usde_market_value,
        vw_pos_val.usde_market_price,
        NULL::integer AS sec_no,
        vw_pos_val.id_sub_sub_tipo_activo,
        vw_pos_val.id_sub_tipo_activo,
        vw_pos_val.id_tipo_activo,
        vw_pos_val.nombre_sub_sub_tipo_activo
    FROM pershing.vw_maestro_posicion_valorizada vw_pos_val
    LEFT JOIN clientes.vw_maestro_clientes_cuentas maestro_crm
        ON vw_pos_val.id_custodian= maestro_crm.id_custodio AND vw_pos_val.account_number = maestro_crm.id_cuenta_custodio
) as pos
LEFT JOIN clientes.par_fee_segmento as tb_fee
    ON total_usde_market_value >= tb_fee.monto_min AND total_usde_market_value < tb_fee.monto_max
;





--========================================================================
--========================================================================
--========================================================================
--TODO: ajustar vistas de negocio y recrear tablas materializadas
DROP TABLE public.tbvw_maestro_cuentas_pershing;
DROP TABLE public.tbvw_maestro_movimientos_pershing;
DROP TABLE public.tbvw_maestro_saldos_pershing;

SELECT * INTO public.tbvw_maestro_cuentas_pershing FROM public.vw_maestro_cuentas_pershing;
SELECT * INTO public.tbvw_maestro_movimientos_pershing FROM public.vw_maestro_movimientos_pershing;
SELECT * INTO public.tbvw_maestro_saldos_pershing FROM public.vw_maestro_saldos_pershing;
--========================================================================
--========================================================================
--========================================================================
--Control diario
create or replace view public.control_diario_reporte
as
SELECT rep_cd.id AS id_reporte,
       rep_cd.correlativo_diario,
       rep_cd.process_date,
       rep_cd.timestamp_control,
       rep_cd.timestamp_registro,
       rep_cd.id_control,
       rep_cd.glosa_control,
       rep_cd.descripcion_control,
       rep_cd.identificador,
       rep_cd.cant_reg,
       rep_cd.username,
       rep_cd.id_segmentacion
FROM control_diario rep_cd
;

create function public.fn_control_diario_reporte_listado(_process_date_from character varying, _process_date_to character varying, _correlativo integer) returns SETOF public.control_diario_reporte
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
        SELECT *
        FROM public.control_diario_reporte REP_CD
        WHERE REP_CD.process_date       >= _process_date_from
        AND REP_CD.process_date         <= _process_date_to
        AND REP_CD.correlativo_diario   = COALESCE(_correlativo, REP_CD.correlativo_diario)
        ORDER BY REP_CD.process_date ASC, REP_CD.correlativo_diario ASC, REP_CD.id_segmentacion, REP_CD.id_control, REP_CD.identificador ASC, REP_CD.cant_reg ASC
        ;

    RETURN;
    END;
$$;


create function public.fn_control_diario(_process_date character varying, _username character varying) returns SETOF public.control_diario
    language plpgsql
as
$$
DECLARE _timestamp_reg timestamp;
DECLARE _timestamp_proceso timestamp;
DECLARE _menor_correlativo int;
DECLARE _correlativo int;
DECLARE _id_jobs_log bigint;
    BEGIN
        _timestamp_proceso  := clock_timestamp();
        _timestamp_reg      := _timestamp_proceso;
        _correlativo        := -1;

        INSERT INTO public.jobs_log (id_job, start_timestamp, end_timestamp, id_proceso, sub_id_proceso, info)
        VALUES (1, _timestamp_proceso, NULL, _process_date, NULL, NULL);
        _id_jobs_log  := LASTVAL();

        SELECT min(correlativo_diario) INTO _menor_correlativo
        FROM public.control_diario TB_CD WHERE TB_CD.process_date=_process_date;

        IF ( COALESCE(_menor_correlativo,0)<0 ) THEN
            RAISE NOTICE 'Actualizando correlativos para fecha proceso [%], usuario [%]', _process_date, _username;
            UPDATE public.control_diario  SET correlativo_diario=correlativo_diario+ABS(_menor_correlativo)
            WHERE process_date=_process_date;
        END IF;


        RAISE NOTICE 'Desplazando correlativos';
        UPDATE public.control_diario SET correlativo_diario=correlativo_diario+ 1
        WHERE process_date=_process_date;

        UPDATE public.jobs_log tb_log SET end_timestamp = clock_timestamp() WHERE tb_log.id=_id_jobs_log;

    RETURN QUERY
        SELECT *
        FROM public.control_diario TB_CD
        WHERE TB_CD.process_date=_process_date AND TB_CD.correlativo_diario=0
        ORDER BY TB_CD.process_date DESC, TB_CD.correlativo_diario ASC,
            TB_CD.id_control ASC, TB_CD.identificador ASC, TB_CD.cant_reg ASC
        ;

    RETURN;
    END;
$$;



--========================================================================
--========================================================================
--========================================================================
--
create function public.fn_reporte_maestro_materializa_data(_process_date character varying, _tipo_maestro character varying, _custodio character varying) returns bigint
    language plpgsql
as
$$
DECLARE _row_count  BIGINT;


    BEGIN

    IF (_tipo_maestro NOT IN ('CTA', 'SLD', 'MOV') ) THEN
        RAISE NOTICE 'Tipo de maestro no válido [%]', _tipo_maestro;
        return -1;
    end if;

    IF (_custodio NOT IN ('PERSHING') ) THEN
        RAISE NOTICE 'Custodio no válido [%]', _custodio;
        return -2;
    end if;

    IF (_tipo_maestro='CTA') THEN
        IF (_custodio ='PERSHING') THEN
            DELETE FROM public.tbvw_maestro_cuentas_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_cuentas_pershing SELECT * FROM public.vw_maestro_cuentas_pershing where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;
            RETURN _row_count;
        END IF;
    END IF;


    IF (_tipo_maestro='SLD') THEN
        IF (_custodio ='PERSHING') THEN
            DELETE FROM public.tbvw_maestro_saldos_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_saldos_pershing SELECT * FROM public.vw_maestro_saldos_pershing where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;
            RETURN _row_count;
        END IF;
    END IF;


    IF (_tipo_maestro='MOV') THEN
        IF (_custodio ='PERSHING') THEN
            DELETE FROM public.tbvw_maestro_movimientos_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_movimientos_pershing SELECT * FROM public.vw_maestro_movimientos_pershing where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;
            RETURN _row_count;
        END IF;
    END IF;

    return NULL::BIGINT;
    END;
$$;

--========================================================================
--========================================================================
--========================================================================
--Limpieza pre carga incial
