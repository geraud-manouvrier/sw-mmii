create table zz_backup.tbvw_maestro_saldos_pershing_20241017
(
    custodian                  varchar(100),
    tipo_reg                   varchar(100),
    client_id                  varchar(100),
    office_id                  varchar(100),
    account_no                 text,
    name                       varchar(100),
    process_date               varchar(100),
    symbol                     varchar(100),
    cusip                      varchar(100),
    isin_code                  varchar(100),
    product_type               varchar(100),
    security_description       varchar(100),
    cash_margin_account        varchar(100),
    quantity                   numeric,
    market_price               numeric(45, 20),
    id_currency                varchar(100),
    currency                   varchar(100),
    market_value               numeric(45, 20),
    fx_rate                    numeric(45, 20),
    usde_market_value          numeric(45, 20),
    total_usde_market_value    numeric(45, 20),
    id_fee_aplicado            integer,
    annual_fee                 numeric(45, 20),
    tasa_proteccion            numeric(45, 20),
    tasa_suracorp              numeric(45, 20),
    fee_diario                 numeric(45, 20),
    fee_diario_proteccion      numeric(45, 20),
    fee_diario_sura_corp       numeric(45, 20),
    comision_devengada_diaria  numeric(45, 20),
    ingreso_proteccion         numeric(45, 20),
    usde_market_price          numeric(45, 20),
    id_sub_sub_tipo_activo     varchar(100),
    id_sub_tipo_activo         varchar(100),
    id_tipo_activo             varchar(100),
    nombre_sub_sub_tipo_activo varchar(1000),
    tipo_identificador_cliente varchar(100)
);

alter table zz_backup.tbvw_maestro_saldos_pershing_20241017
    owner to postgres;

