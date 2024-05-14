create or replace view clientes.vw_maestro_clientes_cuentas
            (id_interno_cliente, identificador_cliente, nombre_cliente, id_tipo_identificador_cliente,
             tipo_identificador_cliente, glosa_identificador_cliente, id_interno_cuenta, id_custodio,
             id_cuenta_custodio, habilitado)
as
SELECT c.id                    AS id_interno_cliente,
       c.identificador         AS identificador_cliente,
       c.nombre                AS nombre_cliente,
       c.id_tipo_identificador AS id_tipo_identificador_cliente,
       ti.tipo_identificador   AS tipo_identificador_cliente,
       ti.glosa_identificador  AS glosa_identificador_cliente,
       cu.id                   AS id_interno_cuenta,
       cu.id_custodio,
       cu.id_cuenta_custodio,
       cu.habilitado
FROM clientes.cliente c
         JOIN clientes.tipo_identificador ti ON c.id_tipo_identificador = ti.id
         LEFT JOIN clientes.cuenta cu ON c.id = cu.id_cliente;

alter table clientes.vw_maestro_clientes_cuentas
    owner to postgres;

