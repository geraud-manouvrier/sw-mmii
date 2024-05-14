create table pershing.estado_proceso_sfl
(
    id           integer      not null,
    glosa_estado varchar(100) not null,
    constraint estado_proceso_sfl_pk
        primary key (id)
);

alter table pershing.estado_proceso_sfl
    owner to postgres;

