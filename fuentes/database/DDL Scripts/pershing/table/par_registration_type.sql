create table pershing.par_registration_type
(
    id    varchar(100)  not null,
    glosa varchar(1000) not null,
    constraint par_registration_type_pk
        primary key (id)
);

alter table pershing.par_registration_type
    owner to postgres;

