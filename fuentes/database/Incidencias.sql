--========================================================================
--========================================================================
--========================================================================
--Error fee
/*
Fee anual
Viene en valores multiplicado y no por 100 (1,5 y 0,015)
Debe venir sin multiplciar (0,015)
Desde el 20 de agosto en adelante se produce cambio (liberación de kit?)
-->Se evidencian registros con valores de fee anual de 1 y 1,25, cuando deberían ser 0,01 o 0,0125
*/
select * from clientes.cliente;
--Dominio de valores 0.5 a 1.5: 0.5, 0.75, 1.0, 1.25, 1.5 (estan en formato "distinto", deben transformarse al irse a saldos!!!)

SELECT *,
       fee,
       fn_change_base_fee(maestro_crm.fee, 'ANNUAL'::character varying, 'DAILY'::character varying,
                                'P'::character varying),
       fee/100,
       fn_change_base_fee(maestro_crm.fee, 'ANNUAL'::character varying, 'DAILY'::character varying,
                                'P'::character varying)
FROM clientes.vw_maestro_clientes_cuentas maestro_crm;
--Dominio de valores 0.5 a 1.5: 0.5, 0.75, 1.0, 1.25, 1.5 (estan en formato "distinto", deben transformarse al irse a saldos!!!)

select distinct process_date, annual_fee, annual_fee*100 from public.vw_maestro_saldos_pershing
order by 1, 2
; --Dominio de valores 0.01 a 1.5

select * from public.vw_maestro_saldos_pershing
where annual_fee=0.00999998082740715670
;--Solo 2 cuentas (las con excepción)


select distinct process_date, annual_fee, annual_fee/100 from public.tbvw_maestro_saldos_pershing
where annual_fee>0.015
order by 1, 2
;
--20240429  --> 20251022


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



