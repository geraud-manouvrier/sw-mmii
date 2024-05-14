create table stage_pershing.stage_isca_reg_i
(
    id                                  bigint generated always as identity,
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
    eor                                 varchar(100),
    constraint stage_isca_reg_i_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_i
    owner to postgres;

