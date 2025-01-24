create or replace view public.vw_reporte_consolidado_saldos
            (agnio, periodo, clients, accounts, accounts_without_client, usde_market_value, ingreso_proteccion) as
SELECT "left"(process_date::text, 4)::character varying(100)                AS agnio,
       "left"(process_date::text, 6)::character varying(100)                AS periodo,
       count(DISTINCT client_id)::integer                                   AS clients,
       count(DISTINCT account_no)::integer                                  AS accounts,
       count(DISTINCT account_no) FILTER (WHERE client_id IS NULL)::integer AS accounts_without_client,
       sum(usde_market_value)::numeric(45, 20)                              AS usde_market_value,
       sum(ingreso_proteccion)::numeric(45, 20)                             AS ingreso_proteccion
FROM vw_reporte_maestro_datos_saldos
GROUP BY ("left"(process_date::text, 4)), ("left"(process_date::text, 6))
ORDER BY ("left"(process_date::text, 4)), ("left"(process_date::text, 6));

alter table public.vw_reporte_consolidado_saldos
    owner to postgres;

