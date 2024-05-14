create table pershing.sfl_gcus
(
    id                                                      bigint generated always as identity,
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
    pledged_quantity                                        numeric(45, 20),
    constraint sfl_gcus_pk
        primary key (id)
);

alter table pershing.sfl_gcus
    owner to postgres;

