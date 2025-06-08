create or replace view public.vw_reporte_maestro_datos_relacionados
            (id, process_date, id_interno_cliente, custodian, client_id, account_no, tipo_identificador_cliente,
             glosa_identificador_cliente, office_id, name, id_relacionado, identificador_relacionado,
             nombre_relacionado, tipo_identificador_relacionado, glosa_tipo_identificador_relacionado, id_cargo, cargo)
as
SELECT row_number()
       OVER (ORDER BY vw_cte.process_date, vw_cte.client_id, vw_cte.custodian, vw_cte.account_no, vw_rel.id_relacionado) AS id,
       vw_cte.process_date,
       vw_cte.id_interno_cliente,
       vw_cte.custodian,
       vw_cte.client_id,
       vw_cte.account_no,
       vw_cte.tipo_identificador_cliente,
       vw_cte.glosa_identificador_cliente,
       vw_cte.office_id,
       vw_cte.name,
       vw_rel.id_relacionado,
       vw_rel.identificador_relacionado,
       vw_rel.nombre_relacionado,
       vw_rel.tipo_identificador                                                                                         AS tipo_identificador_relacionado,
       vw_rel.glosa_tipo_identificador                                                                                   AS glosa_tipo_identificador_relacionado,
       vw_rel.id_cargo_relacionado                                                                                       AS id_cargo,
       vw_rel.glosa                                                                                                      AS cargo
FROM vw_reporte_maestro_datos_clientes vw_cte
         JOIN clientes.vw_maestro_relacionado vw_rel ON vw_cte.id_interno_cliente = vw_rel.id_cliente_relacionado;

alter table public.vw_reporte_maestro_datos_relacionados
    owner to postgres;

