create table stage_pershing.stage_isca_reg_f
(
    id                                  bigint generated always as identity,
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
    eor                                 varchar(100),
    constraint stage_isca_reg_f_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_f
    owner to postgres;

