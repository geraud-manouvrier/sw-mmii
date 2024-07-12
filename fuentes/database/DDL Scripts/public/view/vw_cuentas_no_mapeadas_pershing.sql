create or replace view public.vw_cuentas_no_mapeadas_pershing(source, process_date, account_no, client_name) as
SELECT DISTINCT source,
                process_date,
                account_no,
                client_name
FROM (SELECT DISTINCT 'CTA'::character varying(100) AS source,
                      vw_cta.process_date,
                      vw_cta.account_no,
                      vw_cta.full_name              AS client_name
      FROM vw_maestro_cuentas_pershing vw_cta
      WHERE vw_cta.client_id IS NULL
      UNION
      SELECT DISTINCT 'SLD'::character varying(100)             AS source,
                      vw_sld.process_date,
                      vw_sld.account_no::character varying(100) AS account_no,
                      vw_sld.name                               AS client_name
      FROM vw_maestro_saldos_pershing vw_sld
      WHERE vw_sld.client_id IS NULL
      UNION
      SELECT DISTINCT 'MOV'::character varying(100) AS source,
                      vw_mov.process_date,
                      vw_mov.account_no,
                      vw_mov.name                   AS client_name
      FROM vw_maestro_movimientos_pershing vw_mov
      WHERE vw_mov.client_id IS NULL) act_no_inf;

alter table public.vw_cuentas_no_mapeadas_pershing
    owner to postgres;

