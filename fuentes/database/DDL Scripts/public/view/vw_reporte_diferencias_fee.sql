create or replace view public.vw_reporte_diferencias_fee
            (process_date, client_id, nombre, custodian, account_no, saldo_dia, id, glosa, monto_min, monto_max,
             fee_seg, fee_cte, flag_fee)
as
SELECT temp_sld.process_date,
       temp_sld.client_id,
       tb_cte.nombre,
       temp_sld.custodian,
       temp_sld.account_no,
       temp_sld.saldo_dia,
       seg_fee.id,
       seg_fee.glosa,
       seg_fee.monto_min,
       seg_fee.monto_max,
       seg_fee.annual_fee * 100::numeric                                 AS fee_seg,
       tb_cte.fee                                                        AS fee_cte,
       COALESCE((seg_fee.annual_fee * 100::numeric) = tb_cte.fee, false) AS flag_fee
FROM (SELECT vw_sld.process_date,
             vw_sld.client_id,
             vw_sld.custodian,
             vw_sld.account_no,
             sum(vw_sld.usde_market_value) AS saldo_dia
      FROM vw_reporte_maestro_datos_saldos vw_sld
      GROUP BY vw_sld.process_date, vw_sld.client_id, vw_sld.custodian, vw_sld.account_no) temp_sld
         JOIN clientes.par_fee_segmento seg_fee
              ON temp_sld.saldo_dia >= seg_fee.monto_min AND temp_sld.saldo_dia <= seg_fee.monto_max
         JOIN clientes.cliente tb_cte ON temp_sld.client_id::text = tb_cte.identificador::text;

alter table public.vw_reporte_diferencias_fee
    owner to postgres;

