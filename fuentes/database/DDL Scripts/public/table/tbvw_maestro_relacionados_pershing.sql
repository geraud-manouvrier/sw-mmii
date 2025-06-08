create table public.tbvw_maestro_relacionados_pershing
(
    id                                   bigint generated always as identity,
    process_date                         varchar(100),
    id_interno_cliente                   integer,
    custodian                            varchar(100),
    client_id                            varchar(100),
    account_no                           varchar(100),
    tipo_identificador_cliente           varchar(100),
    glosa_identificador_cliente          varchar(100),
    office_id                            varchar(100),
    name                                 varchar(100),
    id_relacionado                       integer,
    identificador_relacionado            varchar(100),
    nombre_relacionado                   varchar(100),
    tipo_identificador_relacionado       varchar(100),
    glosa_tipo_identificador_relacionado varchar(100),
    id_cargo                             varchar(100),
    cargo                                varchar(100),
    constraint tbvw_maestro_relacionados_pershing_pk
        primary key (id)
);

alter table public.tbvw_maestro_relacionados_pershing
    owner to postgres;

