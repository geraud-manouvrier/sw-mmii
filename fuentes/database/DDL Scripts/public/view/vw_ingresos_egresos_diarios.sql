create or replace view public.vw_ingresos_egresos_diarios
            (client_id, custodian, account_no, ingreso_egreso, date_mov, usde_net_amount, retiro, recaudo, cant_reg) as
SELECT client_id,
       custodian,
       account_no,
       ingreso_egreso,
       replace(COALESCE(trade_date, process_date)::text, '-'::text, ''::text)::character varying(100) AS date_mov,
       sum(usde_net_amount)::numeric(45, 20)                                                          AS usde_net_amount,
       sum(retiro)::numeric(45, 20)                                                                   AS retiro,
       sum(recaudo)::numeric(45, 20)                                                                  AS recaudo,
       count(*)                                                                                       AS cant_reg
FROM vw_reporte_maestro_datos_movimientos
GROUP BY client_id, custodian, account_no, ingreso_egreso,
         (replace(COALESCE(trade_date, process_date)::text, '-'::text, ''::text));

alter table public.vw_ingresos_egresos_diarios
    owner to postgres;

