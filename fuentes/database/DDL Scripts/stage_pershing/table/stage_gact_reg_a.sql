create table stage_pershing.stage_gact_reg_a
(
    id                                       bigint generated always as identity,
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
    eor                                      varchar(100),
    constraint stage_gact_reg_a_pk
        primary key (id)
);

alter table stage_pershing.stage_gact_reg_a
    owner to postgres;

