create table stage_pershing.stage_isca_reg_d
(
    id                          bigint generated always as identity,
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
    eor                         varchar(100),
    constraint stage_isca_reg_d_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_d
    owner to postgres;

