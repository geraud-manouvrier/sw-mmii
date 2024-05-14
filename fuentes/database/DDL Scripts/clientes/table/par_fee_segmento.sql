create table clientes.par_fee_segmento
(
    id                    integer generated always as identity,
    glosa                 varchar(100)    not null,
    monto_min             numeric(45, 20) not null,
    monto_max             numeric(45, 20) not null,
    annual_fee            numeric(45, 20) not null,
    tasa_proteccion       numeric(45, 20) not null,
    tasa_suracorp         numeric(45, 20) not null,
    fee_diario            numeric(45, 20) generated always as (((power(((1)::numeric(45, 20) + annual_fee),
                                                                       (((1)::numeric(45, 20) / (365)::numeric(45, 20)))::numeric(45, 20)) -
                                                                 (1)::numeric(45, 20)))::numeric(45, 20)) stored,
    fee_diario_proteccion numeric(45, 20) generated always as (((power(((1)::numeric(45, 20) + tasa_proteccion),
                                                                       (((1)::numeric(45, 20) / (365)::numeric(45, 20)))::numeric(45, 20)) -
                                                                 (1)::numeric(45, 20)))::numeric(45, 20)) stored,
    fee_diario_sura_corp  numeric(45, 20) generated always as (((power(((1)::numeric(45, 20) + tasa_suracorp),
                                                                       (((1)::numeric(45, 20) / (365)::numeric(45, 20)))::numeric(45, 20)) -
                                                                 (1)::numeric(45, 20)))::numeric(45, 20)) stored,
    constraint par_fee_segmento_pk
        primary key (id),
    constraint no_overlap_rango_monto
        exclude using gist ("numrange(monto_min, monto_max, '[)'::text)" with pg_catalog.&&),
    constraint check_annual_fee
        check (annual_fee = (tasa_proteccion + tasa_suracorp))
);

alter table clientes.par_fee_segmento
    owner to postgres;

