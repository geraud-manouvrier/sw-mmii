create table pershing.par_asset_type_code
(
    id                    bigint generated always as identity,
    id_tipo               varchar(100)              not null,
    id_sub_tipo           varchar(100)              not null,
    id_sub_sub_tipo       varchar(100)              not null,
    glosa                 varchar(1000)             not null,
    factor_division_saldo numeric(45, 20) default 1 not null,
    constraint par_asset_type_code_pk
        primary key (id)
);

alter table pershing.par_asset_type_code
    owner to postgres;

