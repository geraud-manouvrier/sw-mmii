create table stage_pershing.stage_isca_reg_b
(
    id                                          bigint generated always as identity,
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
    eor                                         varchar(100),
    constraint stage_isca_reg_b_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_b
    owner to postgres;

