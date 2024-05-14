create table pershing.param_generic_pershing
(
    id          bigint generated always as identity,
    param_name  varchar(100)                                  not null,
    param_id    varchar(100),
    param_value varchar(1000)                                 not null,
    type_id     varchar(100) default 'STR'::character varying not null,
    type_value  varchar(100) default 'STR'::character varying not null,
    constraint param_generic_pershing_pk
        primary key (id)
);

alter table pershing.param_generic_pershing
    owner to postgres;

