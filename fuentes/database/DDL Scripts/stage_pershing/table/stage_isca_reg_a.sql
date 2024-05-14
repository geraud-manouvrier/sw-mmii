create table stage_pershing.stage_isca_reg_a
(
    id                                              bigint generated always as identity,
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
    eor                                             varchar(100),
    constraint stage_isca_reg_a_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_a
    owner to postgres;

