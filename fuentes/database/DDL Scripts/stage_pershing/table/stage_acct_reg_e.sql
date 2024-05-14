create table stage_pershing.stage_acct_reg_e
(
    id                           bigint generated always as identity,
    id_proceso                   bigint,
    process_date                 varchar(100),
    transaction_code             varchar(100),
    record_indicator_value       varchar(100),
    record_id_sequence_number    integer,
    account_number               varchar(100),
    ibd_number                   varchar(100),
    campo_6                      varchar(100),
    ip_number                    varchar(100),
    account_short_name           varchar(100),
    campo_9                      varchar(100),
    addr_5_trx_code              varchar(100),
    addr_5_special_handling_ind  varchar(100),
    addr_5_delivery_id           varchar(100),
    addr_5_attention_line_prefix varchar(100),
    addr_5_attention_line_detail varchar(100),
    addr_5_line_1                varchar(100),
    addr_5_line_2                varchar(100),
    addr_5_line_3                varchar(100),
    addr_5_line_4                varchar(100),
    addr_5_city_state            varchar(100),
    addr_5_country_code          varchar(100),
    set_as_mail_addr_5_ind       varchar(100),
    campo_22                     varchar(100),
    addr_6_trx_code              varchar(100),
    addr_6_special_handling_ind  varchar(100),
    addr_6_delivery_id           varchar(100),
    addr_6_attention_line_prefix varchar(100),
    addr_6_attention_line_detail varchar(100),
    addr_6_line_1                varchar(100),
    addr_6_line_2                varchar(100),
    addr_6_line_3                varchar(100),
    addr_6_line_4                varchar(100),
    addr_6_city_state            varchar(100),
    addr_6_country_code          varchar(100),
    set_as_mail_addr_6_ind       varchar(100),
    campo_35                     varchar(100),
    eor                          varchar(100),
    constraint stage_acct_reg_e_pk
        primary key (id)
);

alter table stage_pershing.stage_acct_reg_e
    owner to postgres;

