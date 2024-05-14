create table stage_pershing.stage_isca_reg_n
(
    id                        bigint generated always as identity,
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
    eor                       varchar(100),
    constraint stage_isca_reg_n_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_n
    owner to postgres;

