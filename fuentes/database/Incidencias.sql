--========================================================================
--========================================================================
--========================================================================
--
--Qty/MktValue/USDE MktVal= -5710.61;   PD: 20251208
SELECT * FROM pershing.vw_maestro_posicion
where account_number like 'T9O004162%' and process_date='20251208'
;


SELECT * FROM pershing.vw_maestro_posicion_valorizada
where account_number like 'T9O004162%' and process_date='20251208'
;

SELECT * FROM public.vw_maestro_saldos_pershing
where account_no = 'T9O004162' and process_date='20251208'
;

SELECT * FROM public.vw_maestro_saldos_pershing
where client_id='9090280'
AND custodian='PERSHING'
and account_no = 'T9O004162'
and process_date between '20251208' AND '20251208'
;


--========================================================================
--========================================================================
--========================================================================
--

select
    tipo_reg, client_id, office_id, account_no,
    process_date, symbol, cusip, isin_code, product_type, security_description,
    cash_margin_account, quantity, market_price,usde_market_price, id_currency, currency, market_value, fx_rate, usde_market_value,
    comision_devengada_diaria, id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo
from public.tbvw_maestro_saldos_pershing
where process_date='20250105'
and ltrim(rtrim((lower(custodian))))='pershing'
order by process_date, client_id, account_no, cusip, quantity, market_price
;


--========================================================================
--========================================================================
--========================================================================
--
/*
Equipo, buenos días. Espero se encuentren muy bien.
Hemos identificado que, para el periodo comprendido entre el 20250821 y el  20251006, los datos de "fee anual" presentan una diferencia en la escala, evidenciando valores como "0.005" y "0.5" para un mismo concepto.
Agradecemos por favor su apoyo para regularizar los valores de fee correspondientes a este periodo, con el fin de asegurar la consistencia de la información. Para mayor claridad, les compartimos una imagen de referencia.
*/

select distinct annual_fee, annual_fee*100 as annual_fee_perc
from public.tbvw_maestro_saldos_pershing
where process_date>='20250821'
and process_date<='20251006'
order by 1
;



--========================================================================
--========================================================================
--========================================================================
--
select 1;
select
    --row_id, id_reg, tipo_reg, custodian,
    client_id, tipo_identificador_cliente, office_id, account_no, name, process_date,
    symbol, cusip, isin, product_type, security_description, cash_margin_account,
    quantity, market_price, currency, market_value, fx_rate, usde_market_value, comision_devengada_diaria, usde_market_price,
    id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo, total_usde_market_value,
    annual_fee, tasa_proteccion, fee_diario_proteccion, ingreso_proteccion--, tasa_suracorp, fee_diario, fee_diario_sura_corp
FROM public.vw_reporte_maestro_datos_saldos
where process_date>='20251001'
and process_date<='20251231'
--and account_no='T9N001490'
--order by process_date, client_id, account_no, cusip
;



--========================================================================
--========================================================================
--========================================================================
-- Reproceso
/*
1.	ACOSTA GIRALDO S.A.S – T9O005300 Se actualizó la longitud del ID.
2.	LOGIMPEX CARGO S.A.S – T9O004576  Se actualizó el tipo de ID.
*/


select min(process_date) from public.vw_reporte_maestro_datos_clientes where account_no in ('T9O005300', 'T9O004576');
select min(process_date) from public.vw_reporte_maestro_datos_saldos where account_no in ('T9O005300', 'T9O004576');
select min(process_date) from public.vw_reporte_maestro_datos_movimientos where account_no in ('T9O005300', 'T9O004576');




--========================================================================
--========================================================================
--========================================================================
--



