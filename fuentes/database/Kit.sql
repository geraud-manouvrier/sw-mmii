/*
2025-08-05
Actual: 11.4.0-COL
*/

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTRL_DIFF_FEE' FROM public.users where username in ('admin-qye')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_ADMIN_JOBS_BY_USER' FROM public.users where username in ('brayan.giraldom')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTRL_DIFF_FEE' FROM public.users where username in ('daniel.gomez1', 'brayan.giraldom', 'santiago.isaza')
;


--========================================================================
--========================================================================
--========================================================================
--Corrección duplicados

create or replace view public.vw_reporte_diferencias_fee
as
SELECT ie_neto.client_id,
       tb_cte.nombre,
       ie_neto.custodian,
       ie_neto.account_no,
       ie_neto.ingreso_egreso_efectivo,
       seg_fee.id                                                        AS id_segmento,
       seg_fee.glosa,
       seg_fee.monto_min,
       seg_fee.monto_max,
       seg_fee.annual_fee * 100::numeric                                 AS fee_seg,
       tb_cte.fee                                                        AS fee_cte,
       COALESCE((seg_fee.annual_fee * 100::numeric) = tb_cte.fee, false) AS flag_fee,
       CASE
           WHEN vw_sld.client_id IS NOT NULL THEN true
           ELSE false
           END                                                           AS flag_tiene_saldo
FROM (SELECT vw_ie.client_id,
             vw_ie.custodian,
             vw_ie.account_no,
             sum(vw_ie.usde_net_amount) AS ingreso_egreso_efectivo
      FROM vw_ingresos_egresos_diarios vw_ie
      WHERE vw_ie.ingreso_egreso = true
      GROUP BY vw_ie.client_id, vw_ie.custodian, vw_ie.account_no) ie_neto
         JOIN clientes.par_fee_segmento seg_fee ON ie_neto.ingreso_egreso_efectivo >= seg_fee.monto_min AND
                                                   ie_neto.ingreso_egreso_efectivo < seg_fee.monto_max
         JOIN clientes.cliente tb_cte ON ie_neto.client_id::text = tb_cte.identificador::text
         LEFT JOIN fn_clientes_con_saldo(NULL::character varying) vw_sld(client_id, custodian, account_no)
                   ON ie_neto.client_id::text = vw_sld.client_id::text AND
                      ie_neto.custodian::text = vw_sld.custodian::text AND
                      ie_neto.account_no::text = vw_sld.account_no::text;




--========================================================================
--========================================================================
--========================================================================
--





--========================================================================
--========================================================================
--========================================================================
--





--========================================================================
--========================================================================
--========================================================================
--






--========================================================================
--========================================================================
--========================================================================
--





--========================================================================
--========================================================================
--========================================================================
--


--========================================================================
--========================================================================
--========================================================================
--



--========================================================================
--========================================================================
--========================================================================
--


--========================================================================
--========================================================================
--========================================================================
--




--========================================================================
--========================================================================
--========================================================================
--


--========================================================================
--========================================================================
--========================================================================
--



--========================================================================
--========================================================================
--========================================================================
--



