create table pershing.par_minor_product_code
(
    id    varchar(100)  not null,
    glosa varchar(1000) not null,
    constraint par_minor_product_code_pk
        primary key (id)
);

alter table pershing.par_minor_product_code
    owner to postgres;

