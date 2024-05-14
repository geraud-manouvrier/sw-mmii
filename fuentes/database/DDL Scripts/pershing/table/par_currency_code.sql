create table pershing.par_currency_code
(
    id    varchar(100)  not null,
    glosa varchar(1000) not null,
    constraint par_currency_code_pk
        primary key (id)
);

alter table pershing.par_currency_code
    owner to postgres;

