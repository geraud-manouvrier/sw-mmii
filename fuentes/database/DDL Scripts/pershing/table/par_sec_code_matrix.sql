create table pershing.par_sec_code_matrix
(
    id          bigint generated always as identity,
    id_type     varchar(100)  not null,
    id_modifier varchar(100)  not null,
    id_calc     varchar(100),
    id_minor    varchar(100),
    glosa       varchar(1000) not null,
    constraint par_sec_code_matrix_pk
        primary key (id)
);

alter table pershing.par_sec_code_matrix
    owner to postgres;

