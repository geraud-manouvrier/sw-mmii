/*
2024-09-16
Actual: 8.4.0-COL
Last:   8.3.0-COL
*/

--========================================================================
--========================================================================
--========================================================================
--Creción de usuarios admin y app
/*
CREATE USER mmii_admindb CREATEDB CREATEROLE PASSWORD 'b55tO<RB4aza';
GRANT azure_pg_admin TO mmii_admindb;
--create database qande_mmii with owner mmii_admindb;
create database qande_mmii;
CREATE USER mmii_appuserdb PASSWORD 'H;859md+5GAf';
GRANT CONNECT ON DATABASE qande_mmii TO mmii_appuserdb;
--ALTER DEFAULT PRIVILEGES FOR ROLE mmii_appuserdb GRANT SELECT, INSERT, DELETE ON TABLES TO mmii_appuserdb;
--ALTER DEFAULT PRIVILEGES FOR ROLE mmii_appuserdb GRANT EXECUTE ON FUNCTIONS TO mmii_appuserdb;
*/

--========================================================================
--========================================================================
--========================================================================
-- Excepciones comerciales comisión

CREATE OR REPLACE function clientes.fn_comision_cuenta(_process_date VARCHAR(100), _cliente_id VARCHAR(100), _custodian VARCHAR(100), _account_no VARCHAR(100), _defaul_comision NUMERIC(45,20), _is_anual boolean)
    RETURNS NUMERIC(45,20)
    LANGUAGE plpgsql
AS $$
DECLARE
    _comision_excepcion NUMERIC(45,20);
    _comision_out NUMERIC(45,20);
BEGIN
    select vw_com.comision_diaria_saldo, *
    INTO _comision_excepcion
    from clientes.vw_maestro_comision vw_com
    where vw_com.identificador_cliente = _cliente_id
    AND UPPER(vw_com.id_custodio) = UPPER(_custodian)
    AND vw_com.id_cuenta_custodio = _account_no
    AND vw_com.fecha_inicio_vigencia <= public.fn_fecha_string_to_date(_process_date, 'YYYYMMDD')
    ORDER BY vw_com.fecha_inicio_vigencia DESC
    LIMIT 1;

    if (FOUND) THEN
        RAISE NOTICE 'Comisión exepción encontrada: %', _comision_excepcion;
    end if;

    if (_is_anual) THEN
        _comision_out := power((1 + _comision_excepcion), 365) - 1;
    else
        _comision_out := _comision_excepcion;
    end if;

    RETURN COALESCE(_comision_out, _defaul_comision)::NUMERIC(45,20);
END;
$$;



create or replace view public.vw_maestro_saldos_pershing
as
SELECT pos.custodian,
       pos.tipo_reg,
       pos.client_id,
       pos.tipo_identificador_cliente,
       pos.office_id,
       pos.account_no,
       pos.name,
       pos.process_date,
       pos.symbol,
       pos.cusip,
       pos.isin_code,
       pos.product_type,
       pos.security_description,
       pos.cash_margin_account,
       pos.quantity,
       pos.market_price,
       pos.id_currency,
       pos.currency,
       pos.market_value,
       pos.fx_rate,
       pos.usde_market_value,
       pos.total_usde_market_value::numeric(45, 20)                            AS total_usde_market_value,
       tb_fee.id                                                               AS id_fee_aplicado,
       COALESCE(pos.comision_anual_excepcion, tb_fee.annual_fee)::NUMERIC(45,20) as annual_fee,
       tb_fee.tasa_proteccion,
       tb_fee.tasa_suracorp,
       COALESCE(pos.comision_diaria_excepcion, tb_fee.fee_diario)::NUMERIC(45,20) as fee_diario,
       tb_fee.fee_diario_proteccion,
       tb_fee.fee_diario_sura_corp,
       (pos.usde_market_value * COALESCE(pos.comision_diaria_excepcion, tb_fee.fee_diario))::numeric(45, 20)            AS comision_devengada_diaria,
       (pos.usde_market_value * tb_fee.fee_diario_proteccion)::numeric(45, 20) AS ingreso_proteccion,
       pos.usde_market_price,
       pos.id_sub_sub_tipo_activo,
       pos.id_sub_tipo_activo,
       pos.id_tipo_activo,
       pos.nombre_sub_sub_tipo_activo
FROM (SELECT vw_pos_val.custodian,
             vw_pos_val.tipo_reg,
             maestro_crm.identificador_cliente                                                                        AS client_id,
             maestro_crm.tipo_identificador_cliente,
             vw_pos_val.office_id,
             vw_pos_val.account_number                                                                                AS account_no,
             COALESCE(maestro_crm.nombre_cliente, vw_act.full_name)                                                   AS name,
             vw_pos_val.process_date,
             vw_pos_val.symbol,
             vw_pos_val.cusip,
             vw_pos_val.isin_code,
             vw_pos_val.product_type,
             vw_pos_val.security_description,
             vw_pos_val.cash_margin_account,
             vw_pos_val.quantity,
             vw_pos_val.market_price,
             vw_pos_val.id_currency,
             vw_pos_val.currency,
             vw_pos_val.market_value,
             vw_pos_val.fx_rate,
             vw_pos_val.usde_market_value,
             sum(vw_pos_val.usde_market_value)
             OVER (PARTITION BY vw_pos_val.process_date, vw_pos_val.account_number)                                   AS total_usde_market_value,
             vw_pos_val.usde_market_price,
             vw_pos_val.id_sub_sub_tipo_activo,
             vw_pos_val.id_sub_tipo_activo,
             vw_pos_val.id_tipo_activo,
             vw_pos_val.nombre_sub_sub_tipo_activo,
             clientes.fn_comision_cuenta(vw_pos_val.process_date, maestro_crm.identificador_cliente, vw_pos_val.custodian, vw_pos_val.account_number, NULL::NUMERIC(45,20), false) AS comision_diaria_excepcion,
             clientes.fn_comision_cuenta(vw_pos_val.process_date, maestro_crm.identificador_cliente, vw_pos_val.custodian, vw_pos_val.account_number, NULL::NUMERIC(45,20), true) AS comision_anual_excepcion
      FROM pershing.vw_maestro_posicion_valorizada vw_pos_val
               LEFT JOIN clientes.vw_maestro_clientes_cuentas maestro_crm
                         ON vw_pos_val.id_custodian::text = maestro_crm.id_custodio::text AND
                            vw_pos_val.account_number = maestro_crm.id_cuenta_custodio::text
               LEFT JOIN pershing.vw_maestro_cuenta vw_act
                         ON vw_pos_val.account_number = vw_act.account_number::text AND
                            vw_pos_val.process_date::text = vw_act.process_date::text) pos
         LEFT JOIN clientes.par_fee_segmento tb_fee ON pos.total_usde_market_value >= tb_fee.monto_min AND
                                                       pos.total_usde_market_value < tb_fee.monto_max
;


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



