create or replace view clientes.vw_maestro_clientes
            (id, identificador, nombre, id_tipo_identificador, tipo_identificador, glosa_identificador, habilitado,
             lista_cuentas, fee)
as
SELECT cte.id,
       cte.identificador,
       cte.nombre,
       cte.id_tipo_identificador,
       tid.tipo_identificador,
       tid.glosa_identificador,
       tid.habilitado,
       (((SELECT string_agg(cta.id_cuenta_custodio::text, ','::text) AS string_agg
          FROM clientes.cuenta cta
          WHERE cta.id_cliente = cte.id)))::character varying(100) AS lista_cuentas,
       cte.fee
FROM clientes.cliente cte
         LEFT JOIN clientes.tipo_identificador tid ON cte.id_tipo_identificador = tid.id;

alter table clientes.vw_maestro_clientes
    owner to postgres;

