create or replace view clientes.vw_maestro_relacionado
            (id_relacionado, id_cliente_relacionado, identificador_relacionado, nombre_relacionado,
             tipo_identificador_relacionado, tipo_identificador, glosa_tipo_identificador, id_cargo_relacionado, glosa,
             flag_habilitado_relacionado)
as
SELECT tb_pr.id                    AS id_relacionado,
       tb_pr.id_cliente            AS id_cliente_relacionado,
       tb_pr.identificador         AS identificador_relacionado,
       tb_pr.nombre                AS nombre_relacionado,
       tb_pr.id_tipo_identificador AS tipo_identificador_relacionado,
       tipo_id.tipo_identificador,
       tipo_id.glosa_identificador AS glosa_tipo_identificador,
       tb_pr.id_cargo              AS id_cargo_relacionado,
       tb_cargo.glosa,
       tb_pr.flag_habilitado       AS flag_habilitado_relacionado
FROM clientes.persona_relacionada tb_pr
         LEFT JOIN clientes.tipo_identificador tipo_id ON tb_pr.id_tipo_identificador = tipo_id.id
         LEFT JOIN clientes.par_cargo tb_cargo ON tb_pr.id_cargo::text = tb_cargo.id::text
WHERE tb_pr.flag_habilitado = true;

alter table clientes.vw_maestro_relacionado
    owner to postgres;

