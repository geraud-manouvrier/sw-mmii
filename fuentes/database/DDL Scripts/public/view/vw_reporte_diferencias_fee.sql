create or replace view public.vw_reporte_diferencias_fee
            (client_id, nombre, custodian, account_no, ingreso_egreso_efectivo, id, glosa, monto_min, monto_max,
             fee_seg, fee_cte, flag_fee)
as
SELECT ie_neto.client_id,
       tb_cte.nombre,
       ie_neto.custodian,
       ie_neto.account_no,
       ie_neto.ingreso_egreso_efectivo,
       seg_fee.id,
       seg_fee.glosa,
       seg_fee.monto_min,
       seg_fee.monto_max,
       seg_fee.annual_fee * 100::numeric                                 AS fee_seg,
       tb_cte.fee                                                        AS fee_cte,
       COALESCE((seg_fee.annual_fee * 100::numeric) = tb_cte.fee, false) AS flag_fee
FROM (SELECT vw_ie.client_id,
             vw_ie.custodian,
             vw_ie.account_no,
             sum(vw_ie.usde_net_amount) AS ingreso_egreso_efectivo
      FROM vw_ingresos_egresos_diarios vw_ie
      WHERE vw_ie.ingreso_egreso = true
      GROUP BY vw_ie.client_id, vw_ie.custodian, vw_ie.account_no) ie_neto
         JOIN clientes.par_fee_segmento seg_fee ON ie_neto.ingreso_egreso_efectivo >= seg_fee.monto_min AND
                                                   ie_neto.ingreso_egreso_efectivo <= seg_fee.monto_max
         JOIN clientes.cliente tb_cte ON ie_neto.client_id::text = tb_cte.identificador::text;

alter table public.vw_reporte_diferencias_fee
    owner to postgres;

