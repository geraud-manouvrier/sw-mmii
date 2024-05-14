create table pershing.par_country_code
(
    id       bigint generated always as identity,
    iso_code varchar(100)  not null,
    num_code integer,
    glosa    varchar(1000) not null,
    constraint par_country_code_pk
        primary key (id)
);

alter table pershing.par_country_code
    owner to postgres;

