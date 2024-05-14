create table stage_pershing.stage_acct_reg_d
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
    addr_3_trx_code              varchar(100),
    addr_3_special_handling_ind  varchar(100),
    addr_3_delivery_id           varchar(100),
    addr_3_attention_line_prefix varchar(100),
    addr_3_attention_line_detail varchar(100),
    addr_3_line_1                varchar(100),
    addr_3_line_2                varchar(100),
    addr_3_line_3                varchar(100),
    addr_3_line_4                varchar(100),
    addr_3_city_state            varchar(100),
    addr_3_country_code          varchar(100),
    set_as_mail_addr_3_ind       varchar(100),
    campo_22                     varchar(100),
    addr_4_trx_code              varchar(100),
    addr_4_special_handling_ind  varchar(100),
    addr_4_delivery_id           varchar(100),
    addr_4_attention_line_prefix varchar(100),
    addr_4_attention_line_detail varchar(100),
    addr_4_line_1                varchar(100),
    addr_4_line_2                varchar(100),
    addr_4_line_3                varchar(100),
    addr_4_line_4                varchar(100),
    addr_4_city_state            varchar(100),
    addr_4_country_code          varchar(100),
    set_as_mail_addr_4_ind       varchar(100),
    campo_35                     varchar(100),
    eor                          varchar(100),
    constraint stage_acct_reg_d_pk
        primary key (id)
);

alter table stage_pershing.stage_acct_reg_d
    owner to postgres;

