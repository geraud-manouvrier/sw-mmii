create table pershing.par_tranche_code
(
    id    varchar(100)  not null,
    glosa varchar(1000) not null,
    constraint par_tranche_code_pk
        primary key (id)
);

alter table pershing.par_tranche_code
    owner to postgres;

