/*
2026-05-21
Actual: 14.1.1-COL
*/

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_PARAMETROS_FERIADOS' FROM public.users where username in ('admin-qye')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTES_INFOREJEC' FROM public.users where username in ('daniel.gomez1', 'santiago.isaza', 'luis.sanchezc', 'valentina.velez')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_MANT_ENROL_CUENTA' FROM public.users where username in ('daniel.gomez1', 'brayan.giraldom')
;

--========================================================================
--========================================================================
--========================================================================
-- Integración Fee RIA
-- Al actualziar registros del modelo clientes, ponemos filtro de diff fee old/new para que no actualice con mismo valor
CREATE or replace function public.fn_actualiza_fee_ria(_custodian character varying, _account_no character varying, _process_date character varying, _new_annual_percent_fee numeric)
    returns TABLE(custodian character varying, account_no character varying, process_date character varying, new_annual_percent_fee numeric, modelo_clientes_rows_updated integer, maestro_saldos_rows_match integer, maestro_saldos_rows_updated integer, maestro_saldos_old_annual_fee_min numeric, maestro_saldos_old_annual_fee_max numeric, maestro_saldos_new_annual_fee numeric, maestro_cuentas_rows_match integer, maestro_cuentas_rows_updated integer, maestro_cuentas_old_fee_min numeric, maestro_cuentas_old_fee_max numeric, maestro_cuentas_new_fee numeric, status_code integer, status_msg character varying)
    language plpgsql
as
$$
DECLARE
    _cant_update_model_cte int := 0;
    _cant_match_saldos int;
    _cant_update_saldos int;
    _cant_match_cuentas int;
    _cant_update_cuentas int;
    _old_fee_saldos_min numeric(45,20);
    _old_fee_saldos_max numeric(45,20);
    _old_fee_cuentas_min numeric(45,20);
    _old_fee_cuentas_max numeric(45,20);
BEGIN
    --Validaciones mínimas
    IF _custodian IS NULL OR trim(_custodian) = '' THEN
        RAISE EXCEPTION '_custodian no puede ser nulo/vacío' USING ERRCODE = '22023';
    END IF;

    IF _account_no IS NULL OR trim(_account_no) = '' THEN
        RAISE EXCEPTION '_account_no no puede ser nulo/vacío' USING ERRCODE = '22023';
    END IF;

    IF _process_date IS NULL OR trim(_process_date) = '' THEN
        RAISE EXCEPTION '_process_date no puede ser nulo/vacío' USING ERRCODE = '22023';
    END IF;

    IF _new_annual_percent_fee IS NULL OR _new_annual_percent_fee < 0 THEN
        RAISE EXCEPTION '_new_annual_percent_fee inválido [%]', _new_annual_percent_fee USING ERRCODE = '22023';
    END IF;

    --Normalizamos
    _custodian:= trim(upper(_custodian));

    --Modelo clientes (N/A)
    if (_process_date=public.get_max_process_date()) then
        RAISE NOTICE 'Actualizando Fee de Modelo Clientes...';
        UPDATE clientes.cuenta
            set fee = _new_annual_percent_fee
        WHERE upper(cuenta.id_custodio) = _custodian
        AND cuenta.id_cuenta_custodio   = _account_no
        AND cuenta.fee IS DISTINCT FROM _new_annual_percent_fee
        ;

        GET DIAGNOSTICS _cant_update_model_cte = ROW_COUNT;
    END IF;

    --Estadísticas previas a update
    SELECT
        count(*),
        min(annual_fee),
        max(annual_fee)
    INTO
        _cant_match_saldos,
        _old_fee_saldos_min,
        _old_fee_saldos_max
    FROM public.tbvw_maestro_saldos_pershing tb_sld
    WHERE tb_sld.account_no = _account_no
      AND tb_sld.process_date = _process_date
      AND upper(tb_sld.custodian) = _custodian;

    --Actualizamos registros de Maestro de saldos
    UPDATE public.tbvw_maestro_saldos_pershing tb_sld
    SET
        id_fee_aplicado           = calc.id_fee_aplicado_calc,
        annual_fee                = calc.annual_fee_calc,
        tasa_proteccion           = calc.tasa_proteccion_calc,
        tasa_suracorp             = calc.tasa_suracorp_calc,
        fee_diario                = calc.fee_diario_calc,
        fee_diario_proteccion     = calc.fee_diario_proteccion_calc,
        fee_diario_sura_corp      = calc.fee_diario_sura_corp_calc,
        comision_devengada_diaria = calc.comision_devengada_diaria_calc,
        ingreso_proteccion        = calc.ingreso_proteccion_calc
    FROM (
        SELECT
            base.row_no,
            base.process_date,
            base.account_no,
            base.usde_market_value,
            base.total_usde_market_value,
            --Campos a usar en update: valor calculado y valor actualmente existente
            base.id_fee_aplicado as id_fee_aplicado_actual,
            fee_seg.id as id_fee_aplicado_calc,
            base.annual_fee as annual_fee_actual,
            (base.new_fee / 100)::numeric(45,20) AS annual_fee_calc,
            base.tasa_proteccion as tasa_proteccion_actual,
            (fn_dist.fee_perc_proteccion / 100)::NUMERIC(45,20) AS tasa_proteccion_calc,
            base.tasa_suracorp as tasa_suracorp_actual,
            (fn_dist.fee_perc_ria / 100)::NUMERIC(45,20)        AS tasa_suracorp_calc,
            base.fee_diario as fee_diario_actual,
            fn_change_base_fee(base.new_fee, 'ANNUAL', 'DAILY', 'P')::NUMERIC(45,20) AS fee_diario_calc,
            base.fee_diario_proteccion as fee_diario_proteccion_actual,
            fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying)::NUMERIC(45,20) as fee_diario_proteccion_calc,
            base.fee_diario_sura_corp as fee_diario_sura_corp_actual,
            fn_change_base_fee(fn_dist.fee_perc_ria, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying)::NUMERIC(45,20) as fee_diario_sura_corp_calc,
            base.comision_devengada_diaria as comision_devengada_diaria_actual,
            (fn_change_base_fee(base.new_fee, 'ANNUAL', 'DAILY', 'P')*base.usde_market_value)::NUMERIC(45,20) as comision_devengada_diaria_calc ,
            base.ingreso_proteccion as ingreso_proteccion_actual,
            (fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying)*base.usde_market_value)::NUMERIC(45,20) as ingreso_proteccion_calc
        FROM
        (
            SELECT
                tb_sld.row_no,
                tb_sld.process_date,
                upper(tb_sld.custodian)::VARCHAR(100) as custodian,
                tb_sld.account_no,
                tb_sld.usde_market_value,
                tb_sld.total_usde_market_value,
                tb_sld.id_fee_aplicado,
                tb_sld.annual_fee,
                tb_sld.tasa_proteccion,
                tb_sld.tasa_suracorp,
                tb_sld.fee_diario,
                tb_sld.fee_diario_proteccion,
                tb_sld.fee_diario_sura_corp,
                tb_sld.comision_devengada_diaria,
                tb_sld.ingreso_proteccion,
                _new_annual_percent_fee::NUMERIC(45,20) as new_fee
            FROM public.tbvw_maestro_saldos_pershing tb_sld
            WHERE tb_sld.account_no = _account_no
            AND tb_sld.process_date = _process_date
            AND upper(tb_sld.custodian)=_custodian
        ) base
        LEFT JOIN clientes.par_fee_segmento fee_seg
            ON fee_seg.monto_min <= base.total_usde_market_value
            AND fee_seg.monto_max >  base.total_usde_market_value
        CROSS JOIN LATERAL public.fn_distribucion_ingresos(base.new_fee, base.process_date) AS fn_dist(fee_perc_proteccion, fee_perc_ria)
        ) calc
    WHERE tb_sld.row_no = calc.row_no
    AND tb_sld.annual_fee IS DISTINCT FROM calc.annual_fee_calc;

    GET DIAGNOSTICS _cant_update_saldos = ROW_COUNT;

    --Estadísticas previas a update
    SELECT
        count(*),
        min(fee),
        max(fee)
    INTO
        _cant_match_cuentas,
        _old_fee_cuentas_min,
        _old_fee_cuentas_max
    FROM public.tbvw_maestro_cuentas_pershing tb_cta
    WHERE tb_cta.account_no = _account_no
      AND tb_cta.process_date = _process_date
      AND upper(tb_cta.custodian) = _custodian;

    --Actualizamos registros de Maestro de Cuentas
    UPDATE public.tbvw_maestro_cuentas_pershing tb_cta
    SET
        fee                = calc.annual_fee_calc
    FROM (
        SELECT
            base.row_no,
            base.process_date,
            base.account_no,
            base.fee   as annual_fee_actual,
            base.new_fee as annual_fee_calc
        FROM (
            SELECT
                tb_cta.row_no,
                tb_cta.process_date,
                tb_cta.account_no,
                tb_cta.fee,
                _new_annual_percent_fee::NUMERIC(45,20) as new_fee
            FROM public.tbvw_maestro_cuentas_pershing tb_cta
            WHERE tb_cta.account_no = _account_no
            AND tb_cta.process_date = _process_date
            AND upper(tb_cta.custodian)=_custodian
            ) base
    ) calc
    WHERE tb_cta.row_no = calc.row_no
    AND tb_cta.fee IS DISTINCT FROM calc.annual_fee_calc;

    GET DIAGNOSTICS _cant_update_cuentas = ROW_COUNT;


    RETURN QUERY
    SELECT
        _custodian,
        _account_no,
        _process_date,
        _new_annual_percent_fee,
        _cant_update_model_cte,
        _cant_match_saldos,
        _cant_update_saldos,
        _old_fee_saldos_min,
        _old_fee_saldos_max,
        (_new_annual_percent_fee / 100)::numeric(45,20),

        _cant_match_cuentas,
        _cant_update_cuentas,
        _old_fee_cuentas_min,
        _old_fee_cuentas_max,
        _new_annual_percent_fee,

        0,
        'OK'::varchar(1000);

END
$$;

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