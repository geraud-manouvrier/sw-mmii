create table pershing.sfl_isrc
(
    id                        bigint generated always as identity,
    id_proceso                bigint       not null,
    process_date              varchar(100) not null,
    record_secuence_id        varchar(100),
    record_id_number          integer,
    change_id                 varchar(100),
    source_code               varchar(100),
    source_code_desc_line_1   varchar(100),
    source_code_desc_line_2   varchar(100),
    source_code_desc_line_3   varchar(100),
    tax_status                varchar(100),
    user_id                   varchar(100),
    date_added                varchar(100),
    date_updated              varchar(100),
    ira_income_eligible       varchar(100),
    retail_income_eligible    varchar(100),
    customer_firm             varchar(100),
    cerdit_debit              varchar(100),
    statement_ind             varchar(100),
    statement_act_sum_ind     varchar(100),
    statement_act_sum_number  varchar(100),
    statement_trx_sum_ind     varchar(100),
    statement_trx_sum_number  varchar(100),
    statement_distrib_ind     varchar(100),
    statement_distrib_number  varchar(100),
    statement_distrib_tax_ind varchar(100),
    statement_div_ind         varchar(100),
    statement_div_number      varchar(100),
    statement_div_tax_ind     varchar(100),
    pershing_depart           varchar(100),
    pershing_grp              varchar(100),
    user_id_added             varchar(100),
    user_id_updated           varchar(100),
    portfolio_eligible_ind    varchar(100),
    reinvest_ind              varchar(100),
    constraint sfl_isrc_pk
        primary key (id)
);

alter table pershing.sfl_isrc
    owner to postgres;

