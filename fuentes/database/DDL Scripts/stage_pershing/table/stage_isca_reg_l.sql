create table stage_pershing.stage_isca_reg_l
(
    id                                bigint generated always as identity,
    id_proceso                        bigint,
    process_date                      varchar(100),
    record_indicator                  varchar(100),
    record_id_sequence_number         integer,
    cusip_number                      varchar(100),
    campo_4                           varchar(100),
    primary_idc_mkt_exch              varchar(100),
    primary_mkt_exch_trading_status   varchar(100),
    primary_mkt_symbol                varchar(100),
    primary_mkt_exch_effective_date   date,
    primary_mkt_status_code           varchar(100),
    secondary_idc_mkt_exch            varchar(100),
    secondary_mkt_exch_trading_status varchar(100),
    secondary_mkt_symbol              varchar(100),
    secondary_mkt_exch_effective_date date,
    secondary_mkt_status_code         varchar(100),
    tick_size_pilot_group             varchar(100),
    tick_size_effective_date          date,
    tick_size_change_date             date,
    update_date                       date,
    oas_libor_rate                    numeric(45, 20),
    oas_libor_rate_sign               varchar(100),
    campo_21                          varchar(100),
    eor                               varchar(100),
    constraint stage_isca_reg_l_pk
        primary key (id)
);

alter table stage_pershing.stage_isca_reg_l
    owner to postgres;

