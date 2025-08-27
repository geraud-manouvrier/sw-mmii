/*
2025-08-27
Actual: 11.5.0-COL
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
-- Carga de Fees pendientes
/*
ID	NOMBRE	FEE	ESTATUS
98568420	ALEJANDRO E LONDONO TOD	1,50%	SIN FONDEAR
71611555	FRANCISCO HERNAN SALDARRIAGA GARCIA	NO SE ENCUENTRA COMO CUENTA	NO SE ENCUENTRA
19254829	MARTIN GILBERTO GALINDO JUNCO LILIA RUTH GONZALEZ RAMIREZ JT TEN TOD DTD 05/28/2024	1,25%	FONDEADO
43009580	MONICA MARIA ESCOBAR MEJIA TOD DTD 06/20/2024	1,50%	FONDEADO
71575710	GONZALO ORREGO PALACIO TOD DTD 06/25/2024	1,50%	SIN FONDEAR
21329806	M GALLEGO DE ECHEVERRY TOD DTD 07/24/2024	1,50%	SIN FONDEAR
16135403	JESUS WILLIAM CASTANO GOMEZ TOD DTD 07/30/2024	1,50%	SIN FONDEAR
51831659	ADRIANA MARTINEZ ANTORVEZA TOD DTD 08/29/2024	1,50%	SIN FONDEAR
52327763	MONICA CORTES RAMIREZ TOD DTD 08/28/2024	1,50%	FONDEADO
19359981	CARLOS ALFREDO QUINONES MACHLER M ZUREK GARCIA HERREROS JT TEN	1,50%	SIN FONDEAR
42881190	MARIA MERCEDES BRAVO MONTOYA TOD DTD 09/05/2024	1,50%	SIN FONDEAR
24319724	M BERNAL DE JARAMILLO TOD DTD 09/06/2024	1,50%	SIN FONDEAR
17146598	E PILONIETA PINILLA TOD DTD 09/06/2024	1,50%	SIN FONDEAR
1039454269	JUAN PABLO LOPEZ LINCE TOD DTD 09/25/2024	1,50%	SIN FONDEAR
71668858	JULIO CESAR CALLE MUNOZ TOD DTD 10/08/2024	1,50%	SIN FONDEAR
8254870	JUAN ESTEBAN RESTREPO SANTAMARIA IVONNE KLUGE VELILLA	1,50%	SIN FONDEAR
91492958	CAMILO ORLANDO REYES CARRASCAL	1,50%	SIN FONDEAR
901815012	INVERSIONES ABEDULES SA	1,00%	FONDEADO
16455111	JOSE CARLOS GIRALDO SALAZAR TOD DTD 02/24/2025	1,50%	SIN FONDEAR
80098170	DAVID LEONARDO MOLINA GARZON GISELA NAYIBE PENAGOS GARZON JT TEN	1,50%	SIN FONDEAR
996522	SILVIO PEDRO FIGLIUOLO TOD DTD 03/11/2025	1,50%	SIN FONDEAR
98550669	JUAN CARLOS GARCES BELTRAN TOD DTD 01/27/2025	1,00%	SIN FONDEAR
79937622	P PARRA GALLEGO TOD DTD 03/19/2025	1,50%	SIN FONDEAR
15366821	MARINO ANTONIO RENDON PRADO TOD DTD 04/08/2025	1,50%	SIN FONDEAR
155753768	NUSIBEL INVESTMENTS INC	1,50%	SIN FONDEAR
19466536	JOSE REINALDO GARCIA GONZALEZ TOD DTD 05/06/2025	1,50%	SIN FONDEAR
*/

SELECT * INTO zz_backup.cliente_20250805
FROM clientes.cliente;

update clientes.cliente set fee=1.5 where trim(identificador)='98568420';
update clientes.cliente set fee=1.25 where trim(identificador)='19254829';
update clientes.cliente set fee=1.5 where trim(identificador)='43009580';
update clientes.cliente set fee=1.5 where trim(identificador)='71575710';
update clientes.cliente set fee=1.5 where trim(identificador)='21329806';
update clientes.cliente set fee=1.5 where trim(identificador)='16135403';
update clientes.cliente set fee=1.5 where trim(identificador)='51831659';
update clientes.cliente set fee=1.5 where trim(identificador)='52327763';
update clientes.cliente set fee=1.5 where trim(identificador)='19359981';
update clientes.cliente set fee=1.5 where trim(identificador)='42881190';
update clientes.cliente set fee=1.5 where trim(identificador)='24319724';
update clientes.cliente set fee=1.5 where trim(identificador)='17146598';
update clientes.cliente set fee=1.5 where trim(identificador)='1039454269';
update clientes.cliente set fee=1.5 where trim(identificador)='71668858';
update clientes.cliente set fee=1.5 where trim(identificador)='8254870';
update clientes.cliente set fee=1.5 where trim(identificador)='91492958';
update clientes.cliente set fee=1 where trim(identificador)='901815012';
update clientes.cliente set fee=1.5 where trim(identificador)='16455111';
update clientes.cliente set fee=1.5 where trim(identificador)='80098170';
update clientes.cliente set fee=1.5 where trim(identificador)='996522';
update clientes.cliente set fee=1 where trim(identificador)='98550669';
update clientes.cliente set fee=1.5 where trim(identificador)='79937622';
update clientes.cliente set fee=1.5 where trim(identificador)='15366821';
update clientes.cliente set fee=1.5 where trim(identificador)='155753768';
update clientes.cliente set fee=1.5 where trim(identificador)='19466536';

select * from clientes.cliente where trim(identificador)='71611555';
select * from clientes.cuenta where id_cliente=(
    select id from clientes.cliente where trim(identificador)='71611555'
);

delete from clientes.cliente where trim(identificador)='71611555';
select * from clientes.cliente where trim(identificador)='71611555';

select * from clientes.cliente where fee is null or fee=0;


--========================================================================
--========================================================================
--========================================================================
--Cambio vista saldos para usar fee cliente y no fee parámetro

create or replace function public.fn_change_base_fee(_percentual_comision numeric(45,20), _base_from VARCHAR(100), _base_to VARCHAR(100), _method VARCHAR(100)) returns numeric
    language plpgsql
as
$$
DECLARE
    _factor int := 365;
    allowed constant text[] := array['ANNUAL','DAILY'];
    allowed_method constant text[] := array['E','P'];
BEGIN
    -- Validaciones de presencia
    if (_base_from is null or _base_to is null or _method is null) then
        raise exception 'base_from, base_to y method son obligatorios'
            using errcode = '22004'; -- null value not allowed
    end if;

    -- Validación IN (lista permitida)
    if not (_base_from = any(allowed) AND _base_to = any(allowed)) then
        raise exception 'Bases "%-%" no soportadas. Permitidas: %', _base_from, _base_to, allowed
            using errcode = '22023'; -- invalid parameter value
    end if;
    -- Validación IN (lista permitida)
    if not (_method = any(allowed_method)) then
        raise exception 'Method "%" no soportado. Permitidos: %', _method, allowed_method
            using errcode = '22023'; -- invalid parameter value
    end if;

     IF (_base_from=_base_to) THEN
        RETURN _percentual_comision;
    END IF;

    --Daily -> Annual
    IF (_base_from='DAILY' AND _base_to='ANNUAL') THEN
        IF (_method='P') THEN
            RETURN _percentual_comision*_factor*100;   --Método Proporcional (sin capitalización)
        END IF;
        IF (_method='E') THEN
            RETURN (power(1 + _percentual_comision, _factor) - 1) * 100;   --Método efectivo (CON capitalización)
        END IF;
    END IF;

    --Annual -> Daily
    IF (_base_from='ANNUAL' AND _base_to='DAILY') THEN
        IF (_method='P') THEN
            RETURN _percentual_comision/_factor/100;   --Método Proporcional (sin capitalización)
        END IF;
        IF (_method='E') THEN
            RETURN power(1 + (_percentual_comision / 100.0), 1.0 / _factor) - 1;   --Método efectivo (CON capitalización)
        END IF;

    END IF;


    RAISE EXCEPTION 'Base de comisión no soportada: [%] %->%', _percentual_comision, _base_from, _base_to
        using errcode = '0A000';

END;
$$;

DROP VIEW public.vw_cuentas_no_mapeadas_pershing;   --TODO: Restaurar luego
DROP VIEW public.vw_maestro_saldos_pershing;
DROP FUNCTION clientes.fn_comision_cuenta;


--Modificamos función de comisión para que use fee cliente
create or replace function clientes.fn_comision_cuenta(_process_date character varying, _cliente_id character varying, _custodian character varying, _account_no character varying, _default_annual_comision numeric, _is_anual boolean) returns numeric
    language plpgsql
as
$$
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

    RETURN COALESCE(_comision_out, _default_annual_comision)::NUMERIC(45,20);
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
       pos.total_usde_market_value::numeric(45, 20)                                                          AS total_usde_market_value,
       tb_fee.id                                                                                             AS id_fee_aplicado,
       COALESCE(pos.comision_anual_excepcion, pos.annual_fee_client)::numeric(45, 20)                            AS annual_fee,
       tb_fee.tasa_proteccion,
       tb_fee.tasa_suracorp,
       COALESCE(pos.comision_diaria_excepcion, pos.daily_fee_client)::numeric(45, 20)                           AS fee_diario,
       tb_fee.fee_diario_proteccion,
       tb_fee.fee_diario_sura_corp,
       (pos.usde_market_value *
        COALESCE(pos.comision_diaria_excepcion, pos.daily_fee_client))::numeric(45, 20)                         AS comision_devengada_diaria,
       (pos.usde_market_value * tb_fee.fee_diario_proteccion)::numeric(45, 20)                               AS ingreso_proteccion,
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
             clientes.fn_comision_cuenta(vw_pos_val.process_date, maestro_crm.identificador_cliente,
                                         vw_pos_val.custodian, vw_pos_val.account_number::character varying,
                                         NULL::numeric(45, 20),
                                         false)                                                                       AS comision_diaria_excepcion,
             clientes.fn_comision_cuenta(vw_pos_val.process_date, maestro_crm.identificador_cliente,
                                         vw_pos_val.custodian, vw_pos_val.account_number::character varying,
                                         NULL::numeric(45, 20),
                                         true)                                                                        AS comision_anual_excepcion,
          --Nuevos campos de comisión (del cliente, no excepciones)
            maestro_crm.fee as annual_fee_client,
            public.fn_change_base_fee(maestro_crm.fee, 'ANNUAL', 'DAILY', 'P') as daily_fee_client
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


-- Restaurar mediante Diff Schemas IDE
/*
public.vw_cuentas_no_mapeadas_pershing;
*/



--========================================================================
--========================================================================
--========================================================================
-- Corrección flujo neto de source code no aprametrizados
/*
MVD -0
BKR -1
*/
select * into zz_backup.tbvw_maestro_movimientos_pershing_20250813
FROM public.tbvw_maestro_movimientos_pershing;

UPDATE public.tbvw_maestro_movimientos_pershing SET
flujo_neto = CASE
    WHEN source_code = 'MVD' THEN 0
    WHEN source_code = 'BKR' THEN 1
    ELSE flujo_neto
END,
ingreso_egreso = CASE
    WHEN source_code = 'MVD' THEN false
    WHEN source_code = 'BKR' THEN true
    ELSE ingreso_egreso END,
retiro = CASE
    WHEN source_code = 'MVD' THEN 0
    WHEN source_code = 'BKR' THEN 0
    ELSE retiro END,
recaudo = CASE
    WHEN source_code = 'MVD' THEN 0
    WHEN source_code = 'BKR' THEN abs(usde_net_amount)
    ELSE recaudo END,
activity= CASE
    WHEN source_code = 'MVD' THEN 'POSITION ADJUSTMENT       DECREASE'
    WHEN source_code = 'BKR' THEN 'SECURITY RECEIVED'
    ELSE activity END
WHERE flujo_neto IS NULL
;


SELECT *
FROM public.tbvw_maestro_movimientos_pershing
WHERE flujo_neto IS NULL
;
SELECT *
FROM public.tbvw_maestro_movimientos_pershing
WHERE source_code in ('MVD', 'BKR') and row_no in (1523,8367)
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



