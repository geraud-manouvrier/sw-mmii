create table stage_pershing.stage_isca_reg_j
(
    id                               bigint generated always as identity,
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
    eor                              varchar(100),
    constraint stage_isca_reg_j_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_j
    owner to postgres;

