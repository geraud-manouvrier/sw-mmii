create table public.par_source_code
(
    id                     bigint generated always as identity,
    source_code_pershing   varchar(100) not null,
    signo_movimiento       integer,
    descripcion_movimiento varchar(100) not null,
    aplica_flujo_neto      integer      not null,
    observaciones_internas varchar(1000) default NULL::character varying,
    constraint par_source_code_pk
        primary key (id)
);

alter table public.par_source_code
    owner to postgres;

