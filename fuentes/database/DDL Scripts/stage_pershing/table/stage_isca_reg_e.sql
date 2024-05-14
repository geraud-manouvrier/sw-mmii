create table stage_pershing.stage_isca_reg_e
(
    id                            bigint generated always as identity,
    id_proceso                    bigint,
    process_date                  varchar(100),
    record_indicator              varchar(100),
    record_id_sequence_number     integer,
    cusip_number                  varchar(100),
    campo_4                       varchar(100),
    exp_first_call_price          numeric(45, 20),
    exp_first_par_call_price      numeric(45, 20),
    exp_put_price                 numeric(45, 20),
    exp_second_premium_call_price numeric(45, 20),
    name_issuer_security          varchar(100),
    issuing_currency              varchar(100),
    globally_locked_sec_ind       varchar(100),
    globally_locked_reason_code   varchar(100),
    spac_ind                      varchar(100),
    campo_14                      varchar(100),
    eor                           varchar(100),
    constraint stage_isca_reg_e_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_e
    owner to postgres;

