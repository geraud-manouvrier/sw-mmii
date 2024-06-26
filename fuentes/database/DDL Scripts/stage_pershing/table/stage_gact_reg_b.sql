create table stage_pershing.stage_gact_reg_b
(
    id                                            bigint generated always as identity,
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
    eor                                           varchar(100),
    constraint stage_gact_reg_b_pk
        primary key (id)
);

alter table stage_pershing.stage_gact_reg_b
    owner to postgres;

