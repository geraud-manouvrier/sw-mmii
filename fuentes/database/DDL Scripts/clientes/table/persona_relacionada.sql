create table clientes.persona_relacionada
(
    id                    integer generated always as identity,
    identificador         varchar(100)               not null,
    nombre                varchar(100)               not null,
    id_tipo_identificador integer                    not null,
    id_cliente            integer                    not null,
    flag_habilitado       boolean      default true  not null,
    creacion_ts           timestamp    default now() not null,
    creacion_user         varchar(100)               not null,
    modificacion_ts       timestamp,
    modificacion_user     varchar(100) default NULL::character varying,
    id_cargo              varchar(100),
    constraint persona_relacionada_pk
        primary key (id),
    constraint cliente_tipo_identificador_fk
        foreign key (id_tipo_identificador) references clientes.tipo_identificador,
    constraint cliente_id_fk
        foreign key (id_cliente) references clientes.cliente
);

alter table clientes.persona_relacionada
    owner to postgres;

