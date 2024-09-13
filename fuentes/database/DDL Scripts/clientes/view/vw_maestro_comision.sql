create or replace view clientes.vw_maestro_comision
            (row_id, id, id_cuenta, comision_diaria_saldo, fecha_inicio_vigencia, log_fecha_creacion,
             log_usuario_creacion, id_interno_cliente, identificador_cliente, nombre_cliente,
             id_tipo_identificador_cliente, tipo_identificador_cliente, glosa_identificador_cliente, id_interno_cuenta,
             id_custodio, id_cuenta_custodio, habilitado)
as
SELECT row_number() OVER (ORDER BY com_cta.id) AS row_id,
       com_cta.id,
       com_cta.id_cuenta,
       com_cta.comision_diaria_saldo,
       com_cta.fecha_inicio_vigencia,
       com_cta.log_fecha_creacion,
       com_cta.log_usuario_creacion,
       vw_cte_cta.id_interno_cliente,
       vw_cte_cta.identificador_cliente,
       vw_cte_cta.nombre_cliente,
       vw_cte_cta.id_tipo_identificador_cliente,
       vw_cte_cta.tipo_identificador_cliente,
       vw_cte_cta.glosa_identificador_cliente,
       vw_cte_cta.id_interno_cuenta,
       vw_cte_cta.id_custodio,
       vw_cte_cta.id_cuenta_custodio,
       vw_cte_cta.habilitado
FROM clientes.comision_cuenta com_cta
         JOIN clientes.vw_maestro_clientes_cuentas vw_cte_cta ON com_cta.id_cuenta = vw_cte_cta.id_interno_cuenta;

alter table clientes.vw_maestro_comision
    owner to postgres;

