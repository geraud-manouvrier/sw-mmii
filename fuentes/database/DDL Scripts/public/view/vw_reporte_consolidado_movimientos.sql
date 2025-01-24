create or replace view public.vw_reporte_consolidado_movimientos
            (agnio, periodo, clients, accounts, accounts_without_client, usde_net_amount, retiro, recaudo) as
SELECT "left"(process_date::text, 4)::character varying(100)                AS agnio,
       "left"(process_date::text, 6)::character varying(100)                AS periodo,
       count(DISTINCT client_id)::integer                                   AS clients,
       count(DISTINCT account_no)::integer                                  AS accounts,
       count(DISTINCT account_no) FILTER (WHERE client_id IS NULL)::integer AS accounts_without_client,
       sum(usde_net_amount)::numeric(45, 20)                                AS usde_net_amount,
       sum(retiro)::numeric(45, 20)                                         AS retiro,
       sum(recaudo)::numeric(45, 20)                                        AS recaudo
FROM vw_reporte_maestro_datos_movimientos
GROUP BY ("left"(process_date::text, 4)), ("left"(process_date::text, 6))
ORDER BY ("left"(process_date::text, 4)), ("left"(process_date::text, 6));

alter table public.vw_reporte_consolidado_movimientos
    owner to postgres;

