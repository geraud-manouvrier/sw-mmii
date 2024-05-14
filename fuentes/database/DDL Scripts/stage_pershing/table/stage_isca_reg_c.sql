create table stage_pershing.stage_isca_reg_c
(
    id                          bigint generated always as identity,
    id_proceso                  bigint,
    process_date                varchar(100),
    record_indicator            varchar(100),
    record_id_sequence_number   integer,
    cusip_number                varchar(100),
    state_tax_ind               varchar(100),
    fts_ind                     varchar(100),
    amt_ind                     varchar(100),
    ric_indicator               varchar(100),
    number_of_description_lines varchar(100),
    secutiry_description_line_1 varchar(100),
    secutiry_description_line_2 varchar(100),
    secutiry_description_line_3 varchar(100),
    secutiry_description_line_4 varchar(100),
    secutiry_description_line_5 varchar(100),
    user_cusip_identifier       varchar(100),
    price_purge_date            date,
    taxable_indicator           varchar(100),
    eor                         varchar(100),
    constraint stage_isca_reg_c_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_c
    owner to postgres;

