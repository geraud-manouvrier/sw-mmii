/*
2026-07-25
Actual: 16.0.0-COL
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
-- Corrección módulo retornos
create or replace function rep_inv.fn_calculo_rentabilidad_agregada(_date_ini date, _date_fin date, _agregador_n1 character varying, _agregador_n2 character varying, _agregador_n3 character varying, _agregador_n4 character varying) returns SETOF rep_inv.reg_rent
    language plpgsql
as
$$
    BEGIN

    DROP TABLE IF EXISTS temptb_base_calculo;

    CREATE TEMP TABLE temptb_base_calculo AS
    (
        SELECT
            tbn.process_date_as_date, tbn.saldo_dia_anterior, tbn.saldo_rentabilidad, tbn.rentabilidad_base_pitatoria,
            tbn.agregador_n1, NULL::VARCHAR(100) as agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4
        FROM rep_inv.consolidado_agregado_n1 tbn
        WHERE COALESCE(_agregador_n2,'')=''    --Si queremos N1, NO se puede pasar agregador 2 (es decir, vacío/nulo)
        AND tbn.agregador_n1= _agregador_n1
        AND tbn.process_date_as_date>=_date_ini
        AND tbn.process_date_as_date<=_date_fin
    );

    INSERT INTO temptb_base_calculo
    SELECT
            tbn.process_date_as_date, tbn.saldo_dia_anterior, tbn.saldo_rentabilidad, tbn.rentabilidad_base_pitatoria,
            tbn.agregador_n1, tbn.agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4
        FROM rep_inv.consolidado_agregado_n2 tbn
        WHERE tbn.agregador_n1= _agregador_n1 AND tbn.agregador_n2= _agregador_n2
        AND tbn.process_date_as_date>=_date_ini
        AND tbn.process_date_as_date<=_date_fin
    ;

    RETURN QUERY
    SELECT
        tb_calc.fecha_desde, tb_calc.fecha_hasta,
        tb_calc.agregador_n1, tb_calc.agregador_n2, tb_calc.agregador_n3, tb_calc.agregador_n4,
        tb_calc.cant_reg, tb_calc.dias_con_saldo,
        tb_calc.pitatoria::NUMERIC(45,20) as rentabilidad_periodo,
        tb_calc.suma_saldos_iniciales::NUMERIC(45,20), tb_calc.suma_saldo_rentabilidad::NUMERIC(45,20),
        (CASE
            WHEN tb_calc.suma_saldos_iniciales=0 THEN NULL
            ELSE tb_calc.suma_saldo_rentabilidad/tb_calc.suma_saldos_iniciales
            END)::NUMERIC(45,20) as rentabilidad_ponderada_cl,
        (power(
            ( 1 + CASE WHEN tb_calc.suma_saldos_iniciales=0 THEN NULL ELSE tb_calc.suma_saldo_rentabilidad/tb_calc.suma_saldos_iniciales END ),
            (tb_calc.dias_con_saldo)
            ) - 1)::NUMERIC(45,20) as rentabilidad_periodo_cl

    FROM
    (
        SELECT
            count(*)::integer                                                           as cant_reg,
            min(tbn.process_date_as_date)::DATE                                         as fecha_desde,
            max(tbn.process_date_as_date)::DATE                                         as fecha_hasta,
            ((max(tbn.process_date_as_date)- min(tbn.process_date_as_date))+1)::integer as dias_con_saldo,
            sum(tbn.saldo_dia_anterior)::NUMERIC(45,20)                                 as suma_saldos_iniciales,
            sum(tbn.saldo_rentabilidad)::NUMERIC(45,20)                                 as suma_saldo_rentabilidad,
            public.prod(COALESCE(tbn.rentabilidad_base_pitatoria,1))-1::NUMERIC(45,20)  as pitatoria,
            tbn.agregador_n1                                                            as agregador_n1,
            tbn.agregador_n2                                                            as agregador_n2,
            tbn.agregador_n3                                                            as agregador_n3,
            tbn.agregador_n4                                                            as agregador_n4
        FROM temptb_base_calculo tbn
        GROUP BY tbn.agregador_n1, tbn.agregador_n2, tbn.agregador_n3, tbn.agregador_n4
    ) as tb_calc
    ;

    DROP TABLE temptb_base_calculo;

    END;
$$;




--========================================================================
--========================================================================
--========================================================================
-- Integración Fee RIA
-- Al actualziar registros del modelo clientes, ponemos filtro de diff fee old/new para que no actualice con mismo valor
CREATE or replace function public.fn_actualiza_fee_ria(_custodian character varying, _account_no character varying, _process_date character varying, _new_annual_percent_fee numeric)
    returns TABLE(
        custodian character varying,
        account_no character varying,
        process_date character varying,
        new_annual_percent_fee numeric,
        modelo_clientes_rows_updated integer,
        maestro_saldos_rows_match integer,
        maestro_saldos_rows_updated integer,
        maestro_saldos_old_annual_fee_min numeric,
        maestro_saldos_old_annual_fee_max numeric,
        maestro_saldos_new_annual_fee numeric,
        maestro_cuentas_rows_match integer,
        maestro_cuentas_rows_updated integer,
        maestro_cuentas_old_fee_min numeric,
        maestro_cuentas_old_fee_max numeric,
        maestro_cuentas_new_fee numeric,
        status_code integer,
        status_msg character varying)
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
        (_new_annual_percent_fee / 100)::numeric(45,20),    --maestro_saldos_new_annual_fee

        _cant_match_cuentas,
        _cant_update_cuentas,
        _old_fee_cuentas_min,
        _old_fee_cuentas_max,
        _new_annual_percent_fee,

        0,  --status_code
        'OK'::varchar(1000);    --status_msg

END
$$;

--========================================================================
--========================================================================
--========================================================================
-- Eliminación excepciones comerciales deprecadas
SELECT * FROM clientes.comision_cuenta;
/*
id  id_cuenta   comision_diaria_saldo   fecha_inicio_vigencia   log_fecha_creacion          log_usuario_creacion
1   57          0.00002726150000000000  2024-08-26              2025-02-28 13:51:05.145554  daniel.gomez1
2   54          0.00002726150000000000  2024-08-26              2025-02-28 13:52:00.208092  daniel.gomez1
*/
DELETE FROM clientes.comision_cuenta WHERE id_cuenta IN (54,57);



--========================================================================
--========================================================================
--========================================================================
-- Corrección función de retornos, que no usaba bien agregador
create or replace function rep_inv.fn_calculo_rentabilidad_agregada(_date_ini date, _date_fin date, _agregador_n1 character varying, _agregador_n2 character varying, _agregador_n3 character varying, _agregador_n4 character varying) returns SETOF rep_inv.reg_rent
    language plpgsql
as
$$
    BEGIN

    DROP TABLE IF EXISTS temptb_base_calculo;

    CREATE TEMP TABLE temptb_base_calculo AS
    (
        SELECT
            tbn.process_date_as_date, tbn.saldo_dia_anterior, tbn.saldo_rentabilidad, tbn.rentabilidad_base_pitatoria,
            tbn.agregador_n1, NULL::VARCHAR(100) as agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4
        FROM rep_inv.consolidado_agregado_n1 tbn
        WHERE tbn.agregador_n1= _agregador_n1
        AND tbn.process_date_as_date>=_date_ini
        AND tbn.process_date_as_date<=_date_fin
    );

    INSERT INTO temptb_base_calculo
    SELECT
            tbn.process_date_as_date, tbn.saldo_dia_anterior, tbn.saldo_rentabilidad, tbn.rentabilidad_base_pitatoria,
            tbn.agregador_n1, tbn.agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4
        FROM rep_inv.consolidado_agregado_n2 tbn
        WHERE tbn.agregador_n1= _agregador_n1 AND tbn.agregador_n2= _agregador_n2
        AND tbn.process_date_as_date>=_date_ini
        AND tbn.process_date_as_date<=_date_fin
    ;

    RETURN QUERY
    SELECT
        tb_calc.fecha_desde, tb_calc.fecha_hasta,
        tb_calc.agregador_n1, tb_calc.agregador_n2, tb_calc.agregador_n3, tb_calc.agregador_n4,
        tb_calc.cant_reg, tb_calc.dias_con_saldo,
        tb_calc.pitatoria::NUMERIC(45,20) as rentabilidad_periodo,
        tb_calc.suma_saldos_iniciales::NUMERIC(45,20), tb_calc.suma_saldo_rentabilidad::NUMERIC(45,20),
        (CASE
            WHEN tb_calc.suma_saldos_iniciales=0 THEN NULL
            ELSE tb_calc.suma_saldo_rentabilidad/tb_calc.suma_saldos_iniciales
            END)::NUMERIC(45,20) as rentabilidad_ponderada_cl,
        (power(
            ( 1 + CASE WHEN tb_calc.suma_saldos_iniciales=0 THEN NULL ELSE tb_calc.suma_saldo_rentabilidad/tb_calc.suma_saldos_iniciales END ),
            (tb_calc.dias_con_saldo)
            ) - 1)::NUMERIC(45,20) as rentabilidad_periodo_cl

    FROM
    (
        SELECT
            count(*)::integer                                                           as cant_reg,
            min(tbn.process_date_as_date)::DATE                                         as fecha_desde,
            max(tbn.process_date_as_date)::DATE                                         as fecha_hasta,
            ((max(tbn.process_date_as_date)- min(tbn.process_date_as_date))+1)::integer as dias_con_saldo,
            sum(tbn.saldo_dia_anterior)::NUMERIC(45,20)                                 as suma_saldos_iniciales,
            sum(tbn.saldo_rentabilidad)::NUMERIC(45,20)                                 as suma_saldo_rentabilidad,
            public.prod(COALESCE(tbn.rentabilidad_base_pitatoria,1))-1::NUMERIC(45,20)  as pitatoria,
            tbn.agregador_n1                                                            as agregador_n1,
            tbn.agregador_n2                                                            as agregador_n2,
            tbn.agregador_n3                                                            as agregador_n3,
            tbn.agregador_n4                                                            as agregador_n4
        FROM temptb_base_calculo tbn
        GROUP BY tbn.agregador_n1, tbn.agregador_n2, tbn.agregador_n3, tbn.agregador_n4
    ) as tb_calc
    ;

    DROP TABLE temptb_base_calculo;

    END;
$$;






--========================================================================
--========================================================================
--========================================================================
-- Portfolios desde RIA: Job debe correr luego de SFL, pero antes de maestros -> TODO: Ver mismo comportamiento con fee
--Agregamos columna a tabla cuenta
ALTER TABLE clientes.cuenta ADD COLUMN portfolio character varying(100) DEFAULT NULL;

--Agregamos a tabla de materialización de clientes/cuentas
ALTER TABLE public.tbvw_maestro_cuentas_pershing ADD COLUMN portfolio character varying(100) DEFAULT NULL;

--Eliminamos vistas y rutinas de dependencias para editar vistas/rutinas
DROP function public.fn_reporte_maestro_datos_relacionados;
DROP function public.fn_reporte_maestro_datos_clientes;
DROP view clientes.vw_maestro_comision;
DROP view vw_cuentas_no_mapeadas_pershing;
DROP view public.vw_maestro_cuentas_pershing;
DROP view vw_maestro_saldos_pershing;
DROP view vw_maestro_movimientos_pershing;
DROP view clientes.vw_maestro_clientes_cuentas;
DROP view public.vw_reporte_maestro_datos_relacionados;
DROP view public.vw_reporte_maestro_datos_clientes;

--Modificamos vistas
create or replace view clientes.vw_maestro_clientes_cuentas
as
SELECT c.id                    AS id_interno_cliente,
       c.identificador         AS identificador_cliente,
       c.nombre                AS nombre_cliente,
       c.id_tipo_identificador AS id_tipo_identificador_cliente,
       ti.tipo_identificador   AS tipo_identificador_cliente,
       ti.glosa_identificador  AS glosa_identificador_cliente,
       cu.id                   AS id_interno_cuenta,
       cu.id_custodio,
       cu.id_cuenta_custodio,
       cu.habilitado,
       cu.fee,
       cu.portfolio
FROM clientes.cliente c
         JOIN clientes.tipo_identificador ti ON c.id_tipo_identificador = ti.id
         LEFT JOIN clientes.cuenta cu ON c.id = cu.id_cliente;


create or replace view public.vw_maestro_cuentas_pershing
as
SELECT vw_act.id,
       vw_act.custodian,
       maestro_crm.id_interno_cliente,
       maestro_crm.identificador_cliente AS client_id,
       maestro_crm.nombre_cliente        AS name,
       maestro_crm.id_tipo_identificador_cliente,
       maestro_crm.tipo_identificador_cliente,
       maestro_crm.glosa_identificador_cliente,
       maestro_crm.id_interno_cuenta,
       maestro_crm.id_custodio,
       maestro_crm.id_cuenta_custodio,
       maestro_crm.habilitado,
       maestro_crm.fee,
       vw_act.ibd_number,
       vw_act.id_office,
       vw_act.ip_number,
       vw_act.account_number             AS account_no,
       vw_act.id_proceso,
       vw_act.process_date,
       vw_act.record_id_sequence_number,
       vw_act.account_short_name,
       vw_act.full_name,
       vw_act.full_address,
       vw_act.transaction_type,
       vw_act.autotitled_usertitled_account,
       vw_act.account_type_code,
       vw_act.registration_type,
       vw_act.registration_type_value,
       vw_act.number_of_account_title_lines,
       vw_act.account_registration_line_1,
       vw_act.account_registration_line_2,
       vw_act.account_registration_line_3,
       vw_act.account_registration_line_4,
       vw_act.account_registration_line_5,
       vw_act.account_registration_line_6,
       vw_act.registration_type_detail,
       vw_act.date_account_opened,
       vw_act.date_account_information_updated,
       vw_act.account_status_indicator,
       vw_act.pending_closed_date,
       vw_act.date_account_closed,
       vw_act.closing_notice_date,
       vw_act.account_reactivated_date,
       vw_act.date_account_reopened,
       vw_act.proceeds,
       vw_act.transfer_instructions,
       vw_act.income_isntructions,
       vw_act.number_of_confirms_for_thi_account,
       vw_act.number_of_statements_for_this_account,
       vw_act.investment_objetive_trans_code,
       vw_act.comments_act,
       vw_act.employer_shotname,
       vw_act.employers_cusip,
       vw_act.employers_symbol,
       vw_act.margin_privileges_revoked,
       vw_act.statement_review_date,
       vw_act.margin_papers_on_file,
       vw_act.cash_margin_account,
       vw_act.option_papers_on_file,
       vw_act.good_faith_margin,
       vw_act.ip_discretion_granted,
       vw_act.invest_advisor_discretion_granted,
       vw_act.invest_advisor_discretion_granted_value,
       vw_act.third_party_discretion_granted,
       vw_act.third_party_name,
       vw_act.risk_factor_code,
       vw_act.investment_objetive_code,
       vw_act.option_equities,
       vw_act.option_index,
       vw_act.option_debt,
       vw_act.option_currency,
       vw_act.option_level_1,
       vw_act.option_level_2,
       vw_act.option_level_3,
       vw_act.option_level_4,
       vw_act.option_call_limits,
       vw_act.option_put_limits,
       vw_act.option_total_limits_of_puts_and_calls,
       vw_act.non_us_dollar_trading,
       vw_act.non_customer_indicator,
       vw_act.third_party_fee_indicator,
       vw_act.third_party_fee_approval_date,
       vw_act.intermediary_account_ind,
       vw_act.commission_schedule,
       vw_act.group_index,
       vw_act.money_manager_id,
       vw_act.money_manager_objective_id,
       vw_act.dtc_id_confirm_number,
       vw_act.caps_master_mnemonic,
       vw_act.employee_id,
       vw_act.prime_broker_free_fund_indicator,
       vw_act.fee_based_account_indicator,
       vw_act.fee_based_termination_date,
       vw_act.plan_name,
       vw_act.self_directed_401_k_account_type,
       vw_act.plan_type,
       vw_act.plan_number,
       vw_act.employee_or_employee_relative,
       vw_act.commission_percent_discount,
       vw_act.ind_12_b_1_fee_blocking,
       vw_act.name_of_ip_signed_new_account_form,
       vw_act.date_of_ip_signed_new_account_form,
       vw_act.name_of_principal_signed_new_account_form,
       vw_act.date_of_principal_signed_new_account_form,
       vw_act.politically_exposed_person,
       vw_act.private_banking_account,
       vw_act.foreign_bank_account,
       vw_act.initial_source_of_funds,
       vw_act.usa_patriot_act_exempt_reason,
       vw_act.country_of_citizenship_code,
       vw_act.country_of_citizenship_value,
       vw_act.country_of_residence_code,
       vw_act.country_of_residence_value,
       vw_act.birth_date,
       vw_act.age_based_fund_roll_exempt,
       vw_act.money_fundreform_retail,
       vw_act.trusted_contact_status,
       vw_act.regulatory_account_type_category,
       vw_act.account_managed_by_trust_comp_id,
       vw_act.voting_auth,
       vw_act.customer_type,
       vw_act.fulfillment_method,
       vw_act.credit_interest_indicator,
       vw_act.ama_indicator,
       vw_act.ama_indicator_value,
       vw_act.tax_id_type,
       vw_act.tax_id_number,
       vw_act.date_tax_id_applied_for,
       vw_act.w_8_w_9_indicator,
       vw_act.w_8_w_9_date_signed,
       vw_act.w_8_w_9_effective_date,
       vw_act.w_8_w_9_document_type,
       vw_act.w_8_date_signed,
       vw_act.w_8_effective_date,
       vw_act.w_9_date_signed,
       vw_act.w_9_effective_date,
       vw_act.tax_status,
       vw_act.b_notice_reason_code,
       vw_act.first_b_notice_status,
       vw_act.date_first_b_notice_status_issued_enforced,
       vw_act.date_first_notice_status_satisfied,
       vw_act.second_b_notice_status,
       vw_act.date_second_b_notice_status_issued_enforced,
       vw_act.date_second_b_notice_status_satisfied,
       vw_act.c_notice_status,
       vw_act.date_c_notice_status_issued_enforced,
       vw_act.date_c_notice_status_satisfied,
       vw_act.old_account_number,
       vw_act.original_account_open_date,
       vw_act.unidentified_large_trader_id,
       vw_act.large_trader_type_code,
       vw_act.large_trader_type_last_change_date,
       vw_act.initial_source_of_funds_other,
       vw_act.finance_away,
       vw_act.account_funding_date,
       vw_act.statement_currency_code,
       vw_act.future_statement_currency_code,
       vw_act.future_statement_currency_code_effective_date,
       vw_act.account_level_routing_code_1,
       vw_act.account_level_routing_code_2,
       vw_act.account_level_routing_code_3,
       vw_act.account_level_routing_code_4,
       vw_act.self_directed_ind,
       vw_act.digital_advice_ind,
       vw_act.pte_account_ind,
       vw_act.first_ip,
       vw_act.second_ip,
       vw_act.third_ip,
       vw_act.fourth_ip,
       vw_act.fifth_ip,
       vw_act.sixth_ip,
       vw_act.seventh_ip,
       vw_act.eighth_ip,
       vw_act.ninth_ip,
       vw_act.tenth_ip,
       vw_act.alert_im_acornym,
       vw_act.alert_im_access_code,
       vw_act.broker_acronym,
       vw_act.cross_reference_indicator,
       vw_act.bny_trust_indicator,
       vw_act.source_of_asset_at_acct_opening,
       vw_act.commission_doscount_code,
       vw_act.external_account_number,
       vw_act.confirmation_suppression_indicator,
       vw_act.date_last_mail_sent,
       vw_act.date_last_mail_sent_outside,
       vw_act.fully_paid_lending_agreement_indicator,
       vw_act.fully_paid_lending_agreement_date,
       vw_act.custodian_account_type,
       vw_act.mifid_customer_categorization,
       vw_act.cash_management_tran_code,
       vw_act.sweep_status_indicator,
       vw_act.date_sweep_activated,
       vw_act.date_sweep_details_changed,
       vw_act.cober_margin_debit_indicator,
       vw_act.first_fund_sweep_account_id,
       vw_act.firstfund_sweep_account_percent,
       vw_act.first_fundsweep_account_redemption_priority,
       vw_act.second_fund_sweep_account_id,
       vw_act.second_fund_sweep_account_percent,
       vw_act.second_fundsweep_account_redemption_priority,
       vw_act.type_of_bank_account,
       vw_act.banklink_aba_number,
       vw_act.banklink_dda_number,
       vw_act.fund_bank_indicator,
       vw_act.w_9_corp_tax_classification_code,
       vw_act.combined_margin_acct_indicator,
       vw_act.pledge_collateral_account_indicator,
       vw_act.finra_institutional_account_code,
       vw_act.proposed_account_reference_id,
       vw_act.advisor_model_id,
       vw_act.firm_model_style_id,
       vw_act.dvp_restriction_code,
       vw_act.dvp_restriction_exp_date,
       vw_act.escheatment_withholding_ind,
       vw_act.source_of_origination,
       vw_act.source_of_persona,
       vw_act.client_onboarding_method,
       vw_act.tax_filing_code,
       vw_act.nor_purpose_collateral_acct_ind,
       vw_act.addr_1_trx_code,
       vw_act.addr_1_special_handling_ind,
       vw_act.addr_1_delivery_id,
       vw_act.addr_1_attention_line_prefix,
       vw_act.addr_1_attention_line_detail,
       vw_act.addr_1_line_1,
       vw_act.addr_1_line_2,
       vw_act.addr_1_line_3,
       vw_act.addr_1_line_4,
       vw_act.addr_1_city_state,
       vw_act.addr_1_country_code,
       vw_act.addr_2_trx_code,
       vw_act.addr_2_special_handling_ind,
       vw_act.addr_2_delivery_id,
       vw_act.addr_2_attention_line_prefix,
       vw_act.addr_2_attention_line_detail,
       vw_act.addr_2_line_1,
       vw_act.addr_2_line_2,
       vw_act.addr_2_line_3,
       vw_act.addr_2_line_4,
       vw_act.addr_2_city_state,
       vw_act.addr_2_country_code,
       vw_act.account_description,
       vw_act.set_as_mail_addr_2_ind,
       vw_act.principal_billing_allocation_pct,
       vw_act.seasonal_addr_id_1,
       vw_act.from_date_1,
       vw_act.to_date_1,
       vw_act.seasonal_addr_id_2,
       vw_act.from_date_2,
       vw_act.to_date_2,
       vw_act.seasonal_addr_id_3,
       vw_act.from_date_3,
       vw_act.to_date_3,
       vw_act.cost_basis_acct_system,
       vw_act.disposition_method_mutual_funds,
       vw_act.disposition_method_other,
       vw_act.disposition_method_stocks,
       vw_act.amortize_taxable_premium_bonds,
       vw_act.accrue_market_disc_based_on,
       vw_act.accrue_market_disc_income,
       vw_act.addr_3_trx_code,
       vw_act.addr_3_special_handling_ind,
       vw_act.addr_3_delivery_id,
       vw_act.addr_3_attention_line_prefix,
       vw_act.addr_3_attention_line_detail,
       vw_act.addr_3_line_1,
       vw_act.addr_3_line_2,
       vw_act.addr_3_line_3,
       vw_act.addr_3_line_4,
       vw_act.addr_3_city_state,
       vw_act.addr_3_country_code,
       vw_act.set_as_mail_addr_3_ind,
       vw_act.addr_4_trx_code,
       vw_act.addr_4_special_handling_ind,
       vw_act.addr_4_delivery_id,
       vw_act.addr_4_attention_line_prefix,
       vw_act.addr_4_attention_line_detail,
       vw_act.addr_4_line_1,
       vw_act.addr_4_line_2,
       vw_act.addr_4_line_3,
       vw_act.addr_4_line_4,
       vw_act.addr_4_city_state,
       vw_act.addr_4_country_code,
       vw_act.set_as_mail_addr_4_ind,
       vw_act.addr_5_trx_code,
       vw_act.addr_5_special_handling_ind,
       vw_act.addr_5_delivery_id,
       vw_act.addr_5_attention_line_prefix,
       vw_act.addr_5_attention_line_detail,
       vw_act.addr_5_line_1,
       vw_act.addr_5_line_2,
       vw_act.addr_5_line_3,
       vw_act.addr_5_line_4,
       vw_act.addr_5_city_state,
       vw_act.addr_5_country_code,
       vw_act.set_as_mail_addr_5_ind,
       vw_act.addr_6_trx_code,
       vw_act.addr_6_special_handling_ind,
       vw_act.addr_6_delivery_id,
       vw_act.addr_6_attention_line_prefix,
       vw_act.addr_6_attention_line_detail,
       vw_act.addr_6_line_1,
       vw_act.addr_6_line_2,
       vw_act.addr_6_line_3,
       vw_act.addr_6_line_4,
       vw_act.addr_6_city_state,
       vw_act.addr_6_country_code,
       vw_act.set_as_mail_addr_6_ind,
       vw_act.addr_7_trx_code,
       vw_act.addr_7_special_handling_ind,
       vw_act.addr_7_delivery_id,
       vw_act.addr_7_attention_line_prefix,
       vw_act.addr_7_attention_line_detail,
       vw_act.addr_7_line_1,
       vw_act.addr_7_line_2,
       vw_act.addr_7_line_3,
       vw_act.addr_7_line_4,
       vw_act.addr_7_city_state,
       vw_act.addr_7_country_code,
       vw_act.set_as_mail_addr_7_ind,
       vw_act.record_transaction_code,
       vw_act.base_currency,
       vw_act.income_currency,
       vw_act.statement_language,
       vw_act.statement_format_code,
       vw_act.msrb_statement_ind,
       vw_act.pep,
       vw_act.first_name_pep,
       vw_act.last_name_pep,
       vw_act.suffix_pep,
       vw_act.political_office_held,
       vw_act.country_of_office,
       vw_act.foreign_bank_account_ind,
       vw_act.foreign_bank_cert_date,
       vw_act.foreign_bank_cert_exp_date,
       vw_act.central_bank_ind,
       vw_act.acct_foreign_financial_inst,
       vw_act.foreign_bank_acct_oper_1,
       vw_act.foreign_bank_acct_oper_2,
       vw_act.foreign_bank_acct_oper_3,
       vw_act.number_people_own,
       vw_act.proprietary_acct_owned,
       vw_act.tel_1_transaction_code,
       vw_act.tel_1_us_ind,
       vw_act.tel_1_type_id,
       vw_act.tel_1_number,
       vw_act.tel_1_extension,
       vw_act.tel_2_transaction_code,
       vw_act.tel_2_us_ind,
       vw_act.tel_2_type_id,
       vw_act.tel_2_number,
       vw_act.tel_2_extension,
       vw_act.tel_3_transaction_code,
       vw_act.tel_3_us_ind,
       vw_act.tel_3_type_id,
       vw_act.tel_3_number,
       vw_act.tel_3_extension,
       vw_act.tel_4_transaction_code,
       vw_act.tel_4_us_ind,
       vw_act.tel_4_type_id,
       vw_act.tel_4_number,
       vw_act.tel_4_extension,
       vw_act.tel_5_transaction_code,
       vw_act.tel_5_us_ind,
       vw_act.tel_5_type_id,
       vw_act.tel_5_number,
       vw_act.tel_5_extension,
       vw_act.tel_6_transaction_code,
       vw_act.tel_6_us_ind,
       vw_act.tel_6_type_id,
       vw_act.tel_6_number,
       vw_act.tel_6_extension,
       vw_act.tel_7_transaction_code,
       vw_act.tel_7_us_ind,
       vw_act.tel_7_type_id,
       vw_act.tel_7_number,
       vw_act.tel_7_extension,
       vw_act.tel_8_transaction_code,
       vw_act.tel_8_us_ind,
       vw_act.tel_8_type_id,
       vw_act.tel_8_number,
       vw_act.tel_8_extension,
       vw_act.email_address,
       vw_act.external_position_ind,
       vw_act.purge_eligible_ind,
       vw_act.advisory_acct_ind,
       vw_act.product_profile_code,
       vw_act.cents_per_share_discount,
       vw_act.option_disclosure_date,
       vw_act.country_acct_level_tax_residency,
       maestro_crm.portfolio
FROM pershing.vw_maestro_cuenta vw_act
         LEFT JOIN clientes.vw_maestro_clientes_cuentas maestro_crm
                   ON vw_act.id_custodian::text = maestro_crm.id_custodio::text AND
                      vw_act.account_number::text = maestro_crm.id_cuenta_custodio::text;


create or replace view public.vw_reporte_maestro_datos_clientes
as
SELECT row_id +
       CASE src_vw
           WHEN 'A'::text THEN 0
           WHEN 'B'::text THEN 1000000000
           WHEN 'C'::text THEN 2000000000
           ELSE NULL::integer
           END::bigint AS row_id,
       id_reg,
       id_interno_cliente,
       custodian,
       client_id,
       tipo_identificador_cliente,
       glosa_identificador_cliente,
       firm_no,
       sub_no,
       rep_no,
       office_id,
       account_no,
       name,
       fee,
       full_name,
       address,
       short_name,
       date_of_birth,
       acct_status_value,
       email,
       country_code_value,
       country,
       w8_date,
       w9_date,
       w8_status_value,
       w9_status_value,
       discr_trading_code_value,
       account_type,
       cash_margin_account,
       debit_card_indicator,
       open_date,
       close_date,
       participant_type,
       last_statement_date,
       tax_id,
       process_date,
       is_last_info,
       is_last_schema_by_account_no,
       estado_cuenta,
       portfolio
FROM (SELECT 'B'::text                                                                                                  AS src_vw,
             tb_acct.row_no                                                                                             AS row_id,
             tb_acct.id                                                                                                 AS id_reg,
             tb_acct.id_interno_cliente,
             upper(tb_acct.custodian::text)::character varying(100)                                                     AS custodian,
             upper(tb_acct.client_id::text)::character varying(100)                                                     AS client_id,
             tb_acct.tipo_identificador_cliente,
             tb_acct.glosa_identificador_cliente,
             tb_acct.ibd_number                                                                                         AS firm_no,
             tb_acct.id_office::character varying(100)                                                                  AS sub_no,
             upper(tb_acct.ip_number::text)::character varying(100)                                                     AS rep_no,
             upper(tb_acct.id_office)::character varying(100)                                                           AS office_id,
             upper(tb_acct.account_no::text)::character varying(100)                                                    AS account_no,
             COALESCE(upper(tb_acct.name::text),
                      upper(tb_acct.full_name::text))::character varying(100)                                           AS name,
             upper(tb_acct.full_name::text)::character varying(100)                                                     AS full_name,
             upper(tb_acct.full_address::text)::character varying(100)                                                  AS address,
             upper(tb_acct.account_short_name::text)::character varying(100)                                            AS short_name,
             tb_acct.birth_date                                                                                         AS date_of_birth,
             CASE
                 WHEN tb_acct.date_account_closed IS NULL THEN 'OPEN'::text
                 ELSE 'CLOSED'::text
                 END::character varying(100)                                                                            AS acct_status_value,
             lower(tb_acct.email_address::text)::character varying(100)                                                 AS email,
             upper(tb_acct.country_of_residence_code::text)::character varying(100)                                     AS country_code_value,
             upper(tb_acct.country_of_residence_value::text)::character varying(100)                                    AS country,
             fn_fecha_date_to_string(tb_acct.w_8_date_signed, 'YYYYMMDD'::character varying,
                                     '-'::character varying)                                                            AS w8_date,
             tb_acct.w_9_date_signed                                                                                    AS w9_date,
             upper(
                     CASE
                         WHEN tb_acct.w_8_w_9_indicator::text = 'W8'::text
                             THEN pershing.fn_obtiene_valor_param_generic_pershing('w8_status'::character varying,
                                                                                   (tb_acct.w_8_date_signed IS NOT NULL)::character varying(100))
                         ELSE NULL::character varying
                         END::text)::character varying(100)                                                             AS w8_status_value,
             upper(
                     CASE
                         WHEN tb_acct.w_8_w_9_indicator::text = 'W9'::text
                             THEN pershing.fn_obtiene_valor_param_generic_pershing('w9_status'::character varying,
                                                                                   (tb_acct.w_9_date_signed IS NOT NULL)::character varying(100))
                         ELSE NULL::character varying
                         END::text)::character varying(100)                                                             AS w9_status_value,
             upper(tb_acct.invest_advisor_discretion_granted_value::text)::character varying(100)                       AS discr_trading_code_value,
             upper(((tb_acct.registration_type_value::text || ' ('::text) || tb_acct.registration_type::text) ||
                   ')'::text)::character varying(100)                                                                   AS account_type,
             upper(tb_acct.cash_margin_account::text)::character varying(100)                                           AS cash_margin_account,
             upper(tb_acct.ama_indicator_value)::character varying(100)                                                 AS debit_card_indicator,
             fn_fecha_date_to_string(tb_acct.date_account_opened, 'YYYYMMDD'::character varying,
                                     '-'::character varying)::character varying(100)                                    AS open_date,
             tb_acct.date_account_closed                                                                                AS close_date,
             fn_obtiene_valor_parametro('pershing.participant_type'::character varying,
                                        'participant_type'::character varying)::character varying(1000)                 AS participant_type,
             NULL::date                                                                                                 AS last_statement_date,
             upper(pershing.fn_obtiene_valor_param_generic_pershing('tax_id_type'::character varying,
                                                                    tb_acct.tax_id_type)::text)::character varying(100) AS tax_id,
             tb_acct.process_date,
             true                                                                                                       AS is_last_info,
             true                                                                                                       AS is_last_schema_by_account_no,
             tb_acct.fee,
             tb_acct.estado_cuenta,
             tb_acct.portfolio
      FROM tbvw_maestro_cuentas_pershing tb_acct) vw_union;





--Re creamos objetos eliminado spor dependencias (sin cambios)
create or replace view clientes.vw_maestro_comision
as
SELECT row_number() OVER (ORDER BY com_cta.id) AS row_id,
       com_cta.id,
       com_cta.id_cuenta,
       com_cta.comision_diaria_saldo,
       com_cta.fecha_inicio_vigencia,
       com_cta.log_fecha_creacion,
       com_cta.log_usuario_creacion,
       vw_cte_cta.id_interno_cliente,
       vw_cte_cta.identificador_cliente,
       vw_cte_cta.nombre_cliente,
       vw_cte_cta.id_tipo_identificador_cliente,
       vw_cte_cta.tipo_identificador_cliente,
       vw_cte_cta.glosa_identificador_cliente,
       vw_cte_cta.id_interno_cuenta,
       vw_cte_cta.id_custodio,
       vw_cte_cta.id_cuenta_custodio,
       vw_cte_cta.habilitado
FROM clientes.comision_cuenta com_cta
         JOIN clientes.vw_maestro_clientes_cuentas vw_cte_cta ON com_cta.id_cuenta = vw_cte_cta.id_interno_cuenta;


create or replace view public.vw_maestro_movimientos_pershing
as
SELECT custodian,
       client_id,
       tipo_identificador_cliente,
       office_id,
       account_no,
       name,
       process_date,
       tipo_reg,
       trade_date,
       settlement_date,
       activity,
       buy_sell_code,
       buy_sell_value,
       quantity,
       price,
       commission,
       fees,
       net_amount,
       usde_net_amount,
       principal,
       cusip,
       symbol,
       isin,
       currency,
       fx_rate,
       interest,
       currency_base,
       cash_margin,
       product_type,
       security_description,
       activity_description,
       activity_code,
       source_code,
       description_1,
       description_2,
       description_3,
       ticker,
       id_sub_sub_tipo,
       id_sub_tipo,
       id_tipo,
       nombre_sub_sub_tipo,
       flujo_neto,
       ingreso_egreso,
       CASE
           WHEN ingreso_egreso AND usde_net_amount < 0::numeric THEN abs(usde_net_amount)
           ELSE 0::numeric
           END::numeric(45, 20) AS retiro,
       CASE
           WHEN ingreso_egreso AND usde_net_amount > 0::numeric THEN abs(usde_net_amount)
           ELSE 0::numeric
           END::numeric(45, 20) AS recaudo,
       id_cuenta_custodio
FROM (SELECT vw_mov_persh.custodian,
             maestro_crm.identificador_cliente                                                                      AS client_id,
             maestro_crm.tipo_identificador_cliente,
             vw_mov_persh.office_id,
             vw_mov_persh.account_no,
             COALESCE(maestro_crm.nombre_cliente, vw_act.full_name)                                                 AS name,
             vw_mov_persh.process_date,
             vw_mov_persh.tipo_reg,
             COALESCE(vw_mov_persh.trade_date, fn_fecha_string_to_date(vw_mov_persh.process_date,
                                                                       'YYYYMMDD'::character varying))              AS trade_date,
             vw_mov_persh.settlement_date,
             par_src_cod.descripcion_movimiento                                                                     AS activity,
             vw_mov_persh.buy_sell_code,
             vw_mov_persh.buy_sell_value,
             COALESCE(vw_mov_persh.quantity,
                      CASE
                          WHEN vw_mov_persh.price <> 0::numeric THEN vw_mov_persh.net_amount / vw_mov_persh.price
                          ELSE NULL::numeric
                          END)::numeric(45, 20)                                                                     AS quantity,
             vw_mov_persh.price,
             vw_mov_persh.commission,
             vw_mov_persh.total_fees                                                                                AS fees,
             COALESCE(vw_mov_persh.net_amount, vw_mov_persh.quantity * vw_mov_persh.price *
                                               COALESCE(vw_mov_persh.factored_market_value_multiplier,
                                                        1::numeric(45, 20)))::numeric(45, 20)                       AS net_amount,
             COALESCE(vw_mov_persh.usde_net_amount, vw_mov_persh.quantity * vw_mov_persh.price * vw_mov_persh.fx_rate *
                                                    COALESCE(vw_mov_persh.factored_market_value_multiplier,
                                                             1::numeric(45, 20)))::numeric(45, 20)                  AS usde_net_amount,
             COALESCE(vw_mov_persh.principal, vw_mov_persh.net_amount,
                      vw_mov_persh.quantity * vw_mov_persh.price * vw_mov_persh.fx_rate *
                      COALESCE(vw_mov_persh.factored_market_value_multiplier,
                               1::numeric(45, 20)))::numeric(45, 20)                                                AS principal,
             vw_mov_persh.cusip,
             CASE
                 WHEN TRIM(BOTH FROM COALESCE(vw_mov_persh.symbol, ''::character varying)) = ''::text AND
                      vw_mov_persh.cusip::text = 'USD999997'::text THEN vw_mov_persh.cusip
                 ELSE vw_mov_persh.symbol
                 END                                                                                                AS symbol,
             vw_mov_persh.isin,
             vw_mov_persh.currency,
             vw_mov_persh.fx_rate,
             vw_mov_persh.interest,
             vw_mov_persh.currency_base,
             vw_mov_persh.cash_margin,
             vw_mov_persh.id_sub_sub_tipo                                                                           AS product_type,
             vw_mov_persh.security_description,
             CASE
                 WHEN vw_mov_persh.tipo_reg::text = 'NON_TDE'::text THEN
                     CASE
                         WHEN TRIM(BOTH FROM vw_mov_persh.source_code) = 'CHRG'::text AND
                              POSITION(('FgnFee'::text) IN (vw_mov_persh.description_1)) = 0 THEN TRIM(BOTH FROM
                                                                                                       (((TRIM(BOTH FROM vw_mov_persh.description_1) || ' '::text) ||
                                                                                                         TRIM(BOTH FROM vw_mov_persh.description_2)) ||
                                                                                                        ' '::text) ||
                                                                                                       TRIM(BOTH FROM vw_mov_persh.description_3))
                         ELSE par_src_cod.descripcion_movimiento::text
                         END
                 WHEN vw_mov_persh.isin::text = '9999246'::text THEN
                     (((((((COALESCE(vw_mov_persh.buy_sell_value, ''::character varying)::character varying(100)::text ||
                            ' $'::text) ||
                           COALESCE(abs(vw_mov_persh.net_amount::numeric(45, 2))::character varying(100),
                                    ''::character varying)::character varying(100)::text) || ' ISIN #'::text) ||
                         COALESCE(vw_mov_persh.isin, ''::character varying)::character varying(100)::text) ||
                        ' TD:'::text) || COALESCE((((substr(vw_mov_persh.trade_date::text, 6, 2) || '/'::text) ||
                                                    substr(vw_mov_persh.trade_date::text, 9, 2)) || '/'::text) ||
                                                  substr(vw_mov_persh.trade_date::text, 1, 4),
                                                  ''::text)::character varying(100)::text) || ' SD:'::text) || COALESCE(
                             (((substr(vw_mov_persh.settlement_date::text, 6, 2) || '/'::text) ||
                               substr(vw_mov_persh.settlement_date::text, 9, 2)) || '/'::text) ||
                             substr(vw_mov_persh.settlement_date::text, 1, 4), ''::text)::character varying(100)::text
                 ELSE
                     (((((((((COALESCE(vw_mov_persh.buy_sell_value, ''::character varying)::character varying(100)::text ||
                              ' '::text) || COALESCE(abs(vw_mov_persh.quantity::numeric(45, 2))::character varying(100),
                                                     ''::character varying)::character varying(100)::text) ||
                            ' SHRS OF ISIN #'::text) ||
                           COALESCE(vw_mov_persh.isin, ''::character varying)::character varying(100)::text) ||
                          ' PRICE: $'::text) || COALESCE(vw_mov_persh.price::numeric(45, 4)::character varying(100),
                                                         ''::character varying)::character varying(100)::text) ||
                        ' TD:'::text) || COALESCE((((substr(vw_mov_persh.trade_date::text, 6, 2) || '/'::text) ||
                                                    substr(vw_mov_persh.trade_date::text, 9, 2)) || '/'::text) ||
                                                  substr(vw_mov_persh.trade_date::text, 1, 4),
                                                  ''::text)::character varying(100)::text) || ' SD:'::text) || COALESCE(
                             (((substr(vw_mov_persh.settlement_date::text, 6, 2) || '/'::text) ||
                               substr(vw_mov_persh.settlement_date::text, 9, 2)) || '/'::text) ||
                             substr(vw_mov_persh.settlement_date::text, 1, 4), ''::text)::character varying(100)::text
                 END::character varying(100)                                                                        AS activity_description,
             vw_mov_persh.source_code                                                                               AS activity_code,
             vw_mov_persh.source_code,
             vw_mov_persh.description_1,
             vw_mov_persh.description_2,
             vw_mov_persh.description_3,
             vw_mov_persh.ticker,
             vw_mov_persh.id_sub_sub_tipo,
             vw_mov_persh.id_sub_tipo,
             vw_mov_persh.id_tipo,
             par_asset.glosa::character varying(100)                                                                AS nombre_sub_sub_tipo,
             par_src_cod.aplica_flujo_neto                                                                          AS flujo_neto,
             par_src_cod.aplica_flujo_neto = 1                                                                      AS ingreso_egreso,
             maestro_crm.id_cuenta_custodio
      FROM (SELECT 'pershing'::character varying(100)                                                                                                   AS id_custodian,
                   fn_obtiene_valor_parametro('custodian'::character varying,
                                              'pershing'::character varying)::character varying(100)                                                    AS custodian,
                   "left"(tb_mov.account_number::text, 3)::character varying(100)                                                                       AS office_id,
                   "left"(tb_mov.account_number::text, 9)::character varying(100)                                                                       AS account_no,
                   tb_mov.account_number                                                                                                                AS account_number_full,
                   pershing.fn_obtiene_valor_param_generic_pershing('account_type'::character varying,
                                                                    "right"(tb_mov.account_number::text, 1)::character varying)::character varying(100) AS cash_margin,
                   tb_mov.process_date,
                   CASE
                       WHEN tb_mov.buy_sell_code::text <> ALL
                            (ARRAY ['B'::character varying::text, 'S'::character varying::text]) THEN 'NON_TDE'::text
                       ELSE 'TDE_INST'::text
                       END::character varying(100)                                                                                                      AS tipo_reg,
                   tb_mov.trade_date,
                   tb_mov.settlement_entry_date                                                                                                         AS settlement_date,
                   tb_mov.buy_sell_code,
                   pershing.fn_obtiene_valor_param_generic_pershing('buy_sell_code'::character varying,
                                                                    tb_mov.buy_sell_code)::character varying(100)                                       AS buy_sell_value,
                   tb_mov.quantity,
                   COALESCE(tb_mov.price_in_trade_currency, tb_det.latest_price)                                                                        AS price,
                   COALESCE(tb_mov.commision_in_usd, 0::numeric)::numeric(45, 20)                                                                       AS commission,
                   (COALESCE(tb_mov.misc_fee_in_usd, 0::numeric) + COALESCE(tb_mov.other_fee_in_usd, 0::numeric) +
                    COALESCE(tb_mov.settlement_fee_in_usd, 0::numeric) +
                    COALESCE(tb_mov.transaction_fee_in_usd, 0::numeric))::numeric(45, 20)                                                               AS total_fees,
                   (tb_mov.net_amount_in_usd * '-1'::integer::numeric)::numeric(45, 20)                                                                 AS net_amount,
                   tb_mov.net_amount_in_usd * '-1'::integer::numeric *
                   tb_mov.settlement_usd_currency_fx_rate                                                                                               AS usde_net_amount,
                   tb_mov.principal_in_usd                                                                                                              AS principal,
                   tb_mov.cusip_number                                                                                                                  AS cusip,
                   tb_mov.security_symbol                                                                                                               AS symbol,
                   tb_det.isin_code                                                                                                                     AS isin,
                   tb_mov.trade_currency_code                                                                                                           AS currency,
                   tb_mov.settlement_usd_currency_fx_rate                                                                                               AS fx_rate,
                   COALESCE(tb_mov.interest_in_usd, 0::numeric)::numeric(45, 20)                                                                        AS interest,
                   tb_mov.security_currency_of_issuance                                                                                                 AS currency_base,
                   TRIM(BOTH FROM (((((((((TRIM(BOTH FROM tb_det.secutiry_description_line_1) || ' '::text) ||
                                          TRIM(BOTH FROM tb_det.secutiry_description_line_2)) || ' '::text) ||
                                        TRIM(BOTH FROM tb_det.secutiry_description_line_3)) || ' '::text) ||
                                      TRIM(BOTH FROM tb_det.secutiry_description_line_4)) || ' '::text) ||
                                    TRIM(BOTH FROM tb_det.secutiry_description_line_5)) || ' '::text) ||
                                  TRIM(BOTH FROM tb_det.secutiry_description_line_6))::character varying(100)                                           AS security_description,
                   CASE
                       WHEN tb_mov.transaction_type::text = 'T'::text THEN 'TDE'::character varying
                       ELSE tb_mov.source_code
                       END::character varying(100)                                                                                                      AS source_code,
                   TRIM(BOTH FROM tb_mov.description_line_1)                                                                                            AS description_1,
                   TRIM(BOTH FROM tb_mov.description_line_2)                                                                                            AS description_2,
                   TRIM(BOTH FROM tb_mov.description_line_3)                                                                                            AS description_3,
                   tb_mov.security_symbol                                                                                                               AS ticker,
                   tb_det.asset_subsubtype                                                                                                              AS id_sub_sub_tipo,
                   tb_det.asset_subtype                                                                                                                 AS id_sub_tipo,
                   tb_det.asset_type                                                                                                                    AS id_tipo,
                   tb_det.factored_market_value_multiplier
            FROM pershing.sfl_gact tb_mov
                     LEFT JOIN pershing.sfl_isca tb_det ON tb_mov.process_date::text = tb_det.process_date::text AND
                                                           tb_mov.cusip_number::text = tb_det.cusip_number::text
            WHERE
                TRIM(BOTH FROM tb_mov.source_code) <> ALL (ARRAY ['ITS'::text, 'SGR'::text, 'NET'::text])) vw_mov_persh
               LEFT JOIN clientes.vw_maestro_clientes_cuentas maestro_crm
                         ON vw_mov_persh.id_custodian::text = maestro_crm.id_custodio::text AND
                            vw_mov_persh.account_no::text = maestro_crm.id_cuenta_custodio::text
               LEFT JOIN pershing.vw_maestro_cuenta vw_act
                         ON vw_mov_persh.account_no::text = vw_act.account_number::text AND
                            vw_mov_persh.process_date::text = vw_act.process_date::text
               LEFT JOIN par_source_code par_src_cod
                         ON TRIM(BOTH FROM vw_mov_persh.source_code) = par_src_cod.source_code_pershing::text AND
                            (par_src_cod.signo_movimiento IS NULL OR
                             CASE
                                 WHEN COALESCE(vw_mov_persh.quantity,
                                               CASE
                                                   WHEN vw_mov_persh.price <> 0::numeric
                                                       THEN vw_mov_persh.net_amount / vw_mov_persh.price
                                                   ELSE NULL::numeric
                                                   END)::numeric(45, 20) >= 0::numeric
                                     THEN par_src_cod.signo_movimiento >= 0
                                 ELSE par_src_cod.signo_movimiento < 0
                                 END)
               LEFT JOIN pershing.par_asset_type_code par_asset
                         ON TRIM(BOTH FROM vw_mov_persh.id_tipo) = TRIM(BOTH FROM par_asset.id_tipo) AND
                            TRIM(BOTH FROM vw_mov_persh.id_sub_tipo) = TRIM(BOTH FROM par_asset.id_sub_tipo) AND
                            TRIM(BOTH FROM vw_mov_persh.id_sub_sub_tipo) = TRIM(BOTH FROM par_asset.id_sub_sub_tipo)
      WHERE CASE
                WHEN par_src_cod.source_code_pershing IS NULL AND
                     COALESCE(vw_mov_persh.net_amount, vw_mov_persh.quantity * vw_mov_persh.price) = 0::numeric
                    THEN false
                ELSE true
                END) tb_mov_persh;


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
       pos.total_usde_market_value::numeric(45, 20)                                                             AS total_usde_market_value,
       tb_fee.id                                                                                                AS id_fee_aplicado,
       COALESCE(pos.comision_anual_excepcion, pos.annual_fee_client)::numeric(45, 20)                           AS annual_fee,
       (fn_dist.fee_perc_proteccion / 100::numeric)::numeric(45, 20)                                            AS tasa_proteccion,
       (fn_dist.fee_perc_ria / 100::numeric)::numeric(45, 20)                                                   AS tasa_suracorp,
       COALESCE(pos.comision_diaria_excepcion, pos.daily_fee_client)::numeric(45, 20)                           AS fee_diario,
       fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL'::character varying, 'DAILY'::character varying,
                          'P'::character varying)::numeric(45, 20)                                              AS fee_diario_proteccion,
       fn_change_base_fee(fn_dist.fee_perc_ria, 'ANNUAL'::character varying, 'DAILY'::character varying,
                          'P'::character varying)::numeric(45, 20)                                              AS fee_diario_sura_corp,
       (pos.usde_market_value *
        COALESCE(pos.comision_diaria_excepcion, pos.daily_fee_client))::numeric(45, 20)                         AS comision_devengada_diaria,
       (pos.usde_market_value *
        fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL'::character varying, 'DAILY'::character varying,
                           'P'::character varying))::numeric(45, 20)                                            AS ingreso_proteccion,
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
             maestro_crm.fee / 100::numeric                                                                           AS annual_fee_client,
             fn_change_base_fee(maestro_crm.fee, 'ANNUAL'::character varying, 'DAILY'::character varying,
                                'P'::character varying)                                                               AS daily_fee_client
      FROM pershing.vw_maestro_posicion_valorizada vw_pos_val
               LEFT JOIN clientes.vw_maestro_clientes_cuentas maestro_crm
                         ON vw_pos_val.id_custodian::text = maestro_crm.id_custodio::text AND
                            vw_pos_val.account_number = maestro_crm.id_cuenta_custodio::text
               LEFT JOIN pershing.vw_maestro_cuenta vw_act
                         ON vw_pos_val.account_number = vw_act.account_number::text AND
                            vw_pos_val.process_date::text = vw_act.process_date::text) pos
         CROSS JOIN LATERAL fn_distribucion_ingresos(
        COALESCE(pos.comision_anual_excepcion, pos.annual_fee_client) * 100::numeric,
        pos.process_date) fn_dist(fee_perc_proteccion, fee_perc_ria)
         LEFT JOIN clientes.par_fee_segmento tb_fee ON pos.total_usde_market_value >= tb_fee.monto_min AND
                                                       pos.total_usde_market_value < tb_fee.monto_max;


create or replace view public.vw_cuentas_no_mapeadas_pershing as
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


create or replace view public.vw_reporte_maestro_datos_relacionados
as
SELECT row_number()
       OVER (ORDER BY vw_cte.process_date, vw_cte.client_id, vw_cte.custodian, vw_cte.account_no, vw_rel.id_relacionado) AS id,
       vw_cte.process_date,
       vw_cte.id_interno_cliente,
       vw_cte.custodian,
       vw_cte.client_id,
       vw_cte.account_no,
       vw_cte.tipo_identificador_cliente,
       vw_cte.glosa_identificador_cliente,
       vw_cte.office_id,
       vw_cte.name,
       vw_rel.id_relacionado,
       vw_rel.identificador_relacionado,
       vw_rel.nombre_relacionado,
       vw_rel.tipo_identificador                                                                                         AS tipo_identificador_relacionado,
       vw_rel.glosa_tipo_identificador                                                                                   AS glosa_tipo_identificador_relacionado,
       vw_rel.id_cargo_relacionado                                                                                       AS id_cargo,
       vw_rel.glosa                                                                                                      AS cargo
FROM vw_reporte_maestro_datos_clientes vw_cte
         JOIN clientes.vw_maestro_relacionado vw_rel ON vw_cte.id_interno_cliente = vw_rel.id_cliente_relacionado;



create or replace function public.fn_reporte_maestro_datos_clientes(_process_date character varying) returns SETOF vw_reporte_maestro_datos_clientes
    language plpgsql
as
$$
    BEGIN


    RETURN QUERY
    SELECT
        *
    FROM public.vw_reporte_maestro_datos_clientes vw_cte
    WHERE vw_cte.process_date = _process_date

    ;

    RETURN;
    END;
$$;


create or replace function public.fn_reporte_maestro_datos_relacionados(_process_date character varying) returns SETOF vw_reporte_maestro_datos_relacionados
    language plpgsql
as
$$
    BEGIN


    RETURN QUERY
    SELECT
        *
    FROM public.vw_reporte_maestro_datos_relacionados vw_rel
    WHERE vw_rel.process_date = _process_date

    ;

    RETURN;
    END;
$$;



--Teniendo dependencias ok, modificamos rutina de materialziación
create or replace function public.fn_reporte_maestro_materializa_data(_process_date character varying, _tipo_maestro character varying, _custodio character varying) returns bigint
    language plpgsql
as
$$
DECLARE _row_count  BIGINT;
/*Por clientes mal cargados en Custodio, mal proceso de SFL o similares (se modifica info del custodio)*/
DECLARE black_list_sld character varying[] := ARRAY['20251013', '20251111', '20251112', '20251113', '20251219', '20251224', '20251225', '20251226', '20251227', '20251228', '20251229', '20251230', '20251231', '20260101', '20260102', '20260103', '20260104', '20260105', '20260306', '20260307', '20260308'];
DECLARE black_list_mov character varying[] := ARRAY['20251013', '20251111', '20260306'];


    BEGIN

    IF (_tipo_maestro NOT IN ('CTA', 'SLD', 'MOV', 'REL') ) THEN
        RAISE NOTICE 'Tipo de maestro no válido [%]', _tipo_maestro;
        return -1;
    end if;

    IF (_custodio NOT IN ('PERSHING') ) THEN
        RAISE NOTICE 'Custodio no válido [%]', _custodio;
        return -2;
    end if;

    IF (_tipo_maestro='CTA') THEN
        IF (_custodio ='PERSHING') THEN
            DELETE FROM public.tbvw_maestro_cuentas_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_cuentas_pershing
            (id, custodian, id_interno_cliente, client_id, name, id_tipo_identificador_cliente, tipo_identificador_cliente, glosa_identificador_cliente, id_interno_cuenta, id_custodio, id_cuenta_custodio, habilitado, fee, ibd_number, id_office, ip_number, account_no, id_proceso, process_date, record_id_sequence_number, account_short_name, full_name, full_address, transaction_type, autotitled_usertitled_account, account_type_code, registration_type, registration_type_value, number_of_account_title_lines, account_registration_line_1, account_registration_line_2, account_registration_line_3, account_registration_line_4, account_registration_line_5, account_registration_line_6, registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions, income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked, statement_review_date, margin_papers_on_file, cash_margin_account, option_papers_on_file, good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted, invest_advisor_discretion_granted_value, third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits, option_total_limits_of_puts_and_calls, non_us_dollar_trading, non_customer_indicator, third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule, group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic, employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date, plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative, commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form, date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form, date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account, foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, country_of_citizenship_code, country_of_citizenship_value, country_of_residence_code, country_of_residence_value, birth_date, age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status, regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, customer_type, fulfillment_method, credit_interest_indicator, ama_indicator, ama_indicator_value, tax_id_type, tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, w_8_date_signed, w_8_effective_date, w_9_date_signed, w_9_effective_date, tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced, date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced, date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced, date_c_notice_status_satisfied, old_account_number, original_account_open_date, unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date, initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code, future_statement_currency_code, future_statement_currency_code_effective_date, account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3, account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip, third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym, alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator, source_of_asset_at_acct_opening, commission_doscount_code, external_account_number, confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside, fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type, mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated, date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id, firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id, second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account, banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code, combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code, proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code, dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona, client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code, addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix, addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4, addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id, addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3, addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind, principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2, from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system, disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks, amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code, addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix, addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4, addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code, addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix, addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4, addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code, addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix, addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4, addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code, addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix, addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4, addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code, addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix, addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4, addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency, income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep, last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind, foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst, foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own, proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension, tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code, tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind, tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id, tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number, tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension, tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address, external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code, cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency, estado_cuenta, portfolio)
            SELECT
                id, custodian, id_interno_cliente, client_id, name, id_tipo_identificador_cliente, tipo_identificador_cliente, glosa_identificador_cliente, id_interno_cuenta, id_custodio, id_cuenta_custodio, habilitado, fee, ibd_number, id_office, ip_number, account_no, id_proceso, process_date, record_id_sequence_number, account_short_name, full_name, full_address, transaction_type, autotitled_usertitled_account, account_type_code, registration_type, registration_type_value, number_of_account_title_lines, account_registration_line_1, account_registration_line_2, account_registration_line_3, account_registration_line_4, account_registration_line_5, account_registration_line_6, registration_type_detail, date_account_opened, date_account_information_updated, account_status_indicator, pending_closed_date, date_account_closed, closing_notice_date, account_reactivated_date, date_account_reopened, proceeds, transfer_instructions, income_isntructions, number_of_confirms_for_thi_account, number_of_statements_for_this_account, investment_objetive_trans_code, comments_act, employer_shotname, employers_cusip, employers_symbol, margin_privileges_revoked, statement_review_date, margin_papers_on_file, cash_margin_account, option_papers_on_file, good_faith_margin, ip_discretion_granted, invest_advisor_discretion_granted, invest_advisor_discretion_granted_value, third_party_discretion_granted, third_party_name, risk_factor_code, investment_objetive_code, option_equities, option_index, option_debt, option_currency, option_level_1, option_level_2, option_level_3, option_level_4, option_call_limits, option_put_limits, option_total_limits_of_puts_and_calls, non_us_dollar_trading, non_customer_indicator, third_party_fee_indicator, third_party_fee_approval_date, intermediary_account_ind, commission_schedule, group_index, money_manager_id, money_manager_objective_id, dtc_id_confirm_number, caps_master_mnemonic, employee_id, prime_broker_free_fund_indicator, fee_based_account_indicator, fee_based_termination_date, plan_name, self_directed_401_k_account_type, plan_type, plan_number, employee_or_employee_relative, commission_percent_discount, ind_12_b_1_fee_blocking, name_of_ip_signed_new_account_form, date_of_ip_signed_new_account_form, name_of_principal_signed_new_account_form, date_of_principal_signed_new_account_form, politically_exposed_person, private_banking_account, foreign_bank_account, initial_source_of_funds, usa_patriot_act_exempt_reason, country_of_citizenship_code, country_of_citizenship_value, country_of_residence_code, country_of_residence_value, birth_date, age_based_fund_roll_exempt, money_fundreform_retail, trusted_contact_status, regulatory_account_type_category, account_managed_by_trust_comp_id, voting_auth, customer_type, fulfillment_method, credit_interest_indicator, ama_indicator, ama_indicator_value, tax_id_type, tax_id_number, date_tax_id_applied_for, w_8_w_9_indicator, w_8_w_9_date_signed, w_8_w_9_effective_date, w_8_w_9_document_type, w_8_date_signed, w_8_effective_date, w_9_date_signed, w_9_effective_date, tax_status, b_notice_reason_code, first_b_notice_status, date_first_b_notice_status_issued_enforced, date_first_notice_status_satisfied, second_b_notice_status, date_second_b_notice_status_issued_enforced, date_second_b_notice_status_satisfied, c_notice_status, date_c_notice_status_issued_enforced, date_c_notice_status_satisfied, old_account_number, original_account_open_date, unidentified_large_trader_id, large_trader_type_code, large_trader_type_last_change_date, initial_source_of_funds_other, finance_away, account_funding_date, statement_currency_code, future_statement_currency_code, future_statement_currency_code_effective_date, account_level_routing_code_1, account_level_routing_code_2, account_level_routing_code_3, account_level_routing_code_4, self_directed_ind, digital_advice_ind, pte_account_ind, first_ip, second_ip, third_ip, fourth_ip, fifth_ip, sixth_ip, seventh_ip, eighth_ip, ninth_ip, tenth_ip, alert_im_acornym, alert_im_access_code, broker_acronym, cross_reference_indicator, bny_trust_indicator, source_of_asset_at_acct_opening, commission_doscount_code, external_account_number, confirmation_suppression_indicator, date_last_mail_sent, date_last_mail_sent_outside, fully_paid_lending_agreement_indicator, fully_paid_lending_agreement_date, custodian_account_type, mifid_customer_categorization, cash_management_tran_code, sweep_status_indicator, date_sweep_activated, date_sweep_details_changed, cober_margin_debit_indicator, first_fund_sweep_account_id, firstfund_sweep_account_percent, first_fundsweep_account_redemption_priority, second_fund_sweep_account_id, second_fund_sweep_account_percent, second_fundsweep_account_redemption_priority, type_of_bank_account, banklink_aba_number, banklink_dda_number, fund_bank_indicator, w_9_corp_tax_classification_code, combined_margin_acct_indicator, pledge_collateral_account_indicator, finra_institutional_account_code, proposed_account_reference_id, advisor_model_id, firm_model_style_id, dvp_restriction_code, dvp_restriction_exp_date, escheatment_withholding_ind, source_of_origination, source_of_persona, client_onboarding_method, tax_filing_code, nor_purpose_collateral_acct_ind, addr_1_trx_code, addr_1_special_handling_ind, addr_1_delivery_id, addr_1_attention_line_prefix, addr_1_attention_line_detail, addr_1_line_1, addr_1_line_2, addr_1_line_3, addr_1_line_4, addr_1_city_state, addr_1_country_code, addr_2_trx_code, addr_2_special_handling_ind, addr_2_delivery_id, addr_2_attention_line_prefix, addr_2_attention_line_detail, addr_2_line_1, addr_2_line_2, addr_2_line_3, addr_2_line_4, addr_2_city_state, addr_2_country_code, account_description, set_as_mail_addr_2_ind, principal_billing_allocation_pct, seasonal_addr_id_1, from_date_1, to_date_1, seasonal_addr_id_2, from_date_2, to_date_2, seasonal_addr_id_3, from_date_3, to_date_3, cost_basis_acct_system, disposition_method_mutual_funds, disposition_method_other, disposition_method_stocks, amortize_taxable_premium_bonds, accrue_market_disc_based_on, accrue_market_disc_income, addr_3_trx_code, addr_3_special_handling_ind, addr_3_delivery_id, addr_3_attention_line_prefix, addr_3_attention_line_detail, addr_3_line_1, addr_3_line_2, addr_3_line_3, addr_3_line_4, addr_3_city_state, addr_3_country_code, set_as_mail_addr_3_ind, addr_4_trx_code, addr_4_special_handling_ind, addr_4_delivery_id, addr_4_attention_line_prefix, addr_4_attention_line_detail, addr_4_line_1, addr_4_line_2, addr_4_line_3, addr_4_line_4, addr_4_city_state, addr_4_country_code, set_as_mail_addr_4_ind, addr_5_trx_code, addr_5_special_handling_ind, addr_5_delivery_id, addr_5_attention_line_prefix, addr_5_attention_line_detail, addr_5_line_1, addr_5_line_2, addr_5_line_3, addr_5_line_4, addr_5_city_state, addr_5_country_code, set_as_mail_addr_5_ind, addr_6_trx_code, addr_6_special_handling_ind, addr_6_delivery_id, addr_6_attention_line_prefix, addr_6_attention_line_detail, addr_6_line_1, addr_6_line_2, addr_6_line_3, addr_6_line_4, addr_6_city_state, addr_6_country_code, set_as_mail_addr_6_ind, addr_7_trx_code, addr_7_special_handling_ind, addr_7_delivery_id, addr_7_attention_line_prefix, addr_7_attention_line_detail, addr_7_line_1, addr_7_line_2, addr_7_line_3, addr_7_line_4, addr_7_city_state, addr_7_country_code, set_as_mail_addr_7_ind, record_transaction_code, base_currency, income_currency, statement_language, statement_format_code, msrb_statement_ind, pep, first_name_pep, last_name_pep, suffix_pep, political_office_held, country_of_office, foreign_bank_account_ind, foreign_bank_cert_date, foreign_bank_cert_exp_date, central_bank_ind, acct_foreign_financial_inst, foreign_bank_acct_oper_1, foreign_bank_acct_oper_2, foreign_bank_acct_oper_3, number_people_own, proprietary_acct_owned, tel_1_transaction_code, tel_1_us_ind, tel_1_type_id, tel_1_number, tel_1_extension, tel_2_transaction_code, tel_2_us_ind, tel_2_type_id, tel_2_number, tel_2_extension, tel_3_transaction_code, tel_3_us_ind, tel_3_type_id, tel_3_number, tel_3_extension, tel_4_transaction_code, tel_4_us_ind, tel_4_type_id, tel_4_number, tel_4_extension, tel_5_transaction_code, tel_5_us_ind, tel_5_type_id, tel_5_number, tel_5_extension, tel_6_transaction_code, tel_6_us_ind, tel_6_type_id, tel_6_number, tel_6_extension, tel_7_transaction_code, tel_7_us_ind, tel_7_type_id, tel_7_number, tel_7_extension, tel_8_transaction_code, tel_8_us_ind, tel_8_type_id, tel_8_number, tel_8_extension, email_address, external_position_ind, purge_eligible_ind, advisory_acct_ind, product_profile_code, cents_per_share_discount, option_disclosure_date, country_acct_level_tax_residency, NULL::VARCHAR(100) as estado_cuenta, portfolio
            FROM public.vw_maestro_cuentas_pershing where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;

            --Actualizamos marca estado cuenta
            UPDATE public.tbvw_maestro_cuentas_pershing
                SET estado_cuenta = public.fn_estado_cuenta_from_tbvw(account_no, _process_date)
            WHERE process_date=_process_date;

            RETURN _row_count;
        END IF;
    END IF;


    IF (_tipo_maestro='SLD') THEN
        IF (_custodio ='PERSHING') THEN
            IF _process_date = ANY(black_list_sld) THEN
                RAISE EXCEPTION 'La fecha [%] está en la lista no permitida de procesos para saldos. No se realizará la materialización.', _process_date
                using errcode = '22023';
            END IF;
            DELETE FROM public.tbvw_maestro_saldos_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_saldos_pershing
            (custodian, tipo_reg, client_id, office_id, account_no, name, process_date, symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity, market_price, id_currency, currency, market_value, fx_rate, usde_market_value, total_usde_market_value, id_fee_aplicado, annual_fee, tasa_proteccion, tasa_suracorp, fee_diario, fee_diario_proteccion, fee_diario_sura_corp, comision_devengada_diaria, ingreso_proteccion, usde_market_price, id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo, tipo_identificador_cliente)
            SELECT
                custodian, tipo_reg, client_id, office_id, account_no, name, process_date, symbol, cusip, isin_code, product_type, security_description, cash_margin_account, quantity, market_price, id_currency, currency, market_value, fx_rate, usde_market_value, total_usde_market_value, id_fee_aplicado, annual_fee, tasa_proteccion, tasa_suracorp, fee_diario, fee_diario_proteccion, fee_diario_sura_corp, comision_devengada_diaria, ingreso_proteccion, usde_market_price, id_sub_sub_tipo_activo, id_sub_tipo_activo, id_tipo_activo, nombre_sub_sub_tipo_activo, tipo_identificador_cliente
            FROM public.vw_maestro_saldos_pershing where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;


            RETURN _row_count;
        END IF;
    END IF;


    IF (_tipo_maestro='MOV') THEN
        IF (_custodio ='PERSHING') THEN
            IF _process_date = ANY(black_list_mov) THEN
                RAISE EXCEPTION 'La fecha [%] está en la lista no permitida de procesos para movimientos. No se realizará la materialización.', _process_date
                using errcode = '22023';
            END IF;
            DELETE FROM public.tbvw_maestro_movimientos_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_movimientos_pershing
                (custodian, client_id, office_id, account_no, name, process_date, tipo_reg, trade_date, settlement_date, activity, buy_sell_code, buy_sell_value, quantity, price, commission, fees, net_amount, usde_net_amount, principal, cusip, symbol, isin, currency, fx_rate, interest, currency_base, cash_margin, product_type, security_description, activity_description, activity_code, source_code, description_1, description_2, description_3, ticker, id_sub_sub_tipo, id_sub_tipo, id_tipo, nombre_sub_sub_tipo, flujo_neto, ingreso_egreso, retiro, recaudo, id_cuenta_custodio, tipo_identificador_cliente)
                SELECT
                    custodian, client_id, office_id, account_no, name, process_date, tipo_reg, trade_date, settlement_date, activity, buy_sell_code, buy_sell_value, quantity, price, commission, fees, net_amount, usde_net_amount, principal, cusip, symbol, isin, currency, fx_rate, interest, currency_base, cash_margin, product_type, security_description, activity_description, activity_code, source_code, description_1, description_2, description_3, ticker, id_sub_sub_tipo, id_sub_tipo, id_tipo, nombre_sub_sub_tipo, flujo_neto, ingreso_egreso, retiro, recaudo, id_cuenta_custodio, tipo_identificador_cliente
                FROM public.vw_maestro_movimientos_pershing where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;
            RETURN _row_count;
        END IF;
    END IF;



    IF (_tipo_maestro='REL') THEN
        IF (_custodio ='PERSHING') THEN
            DELETE FROM public.tbvw_maestro_relacionados_pershing WHERE process_date=_process_date;
            INSERT INTO public.tbvw_maestro_relacionados_pershing
                (process_date, id_interno_cliente, custodian, client_id, account_no, tipo_identificador_cliente, glosa_identificador_cliente, office_id, name, id_relacionado, identificador_relacionado, nombre_relacionado, tipo_identificador_relacionado, glosa_tipo_identificador_relacionado, id_cargo, cargo)
                SELECT
                    process_date, id_interno_cliente, custodian, client_id, account_no, tipo_identificador_cliente, glosa_identificador_cliente, office_id, name, id_relacionado, identificador_relacionado, nombre_relacionado, tipo_identificador_relacionado, glosa_tipo_identificador_relacionado, id_cargo, cargo
                FROM public.vw_reporte_maestro_datos_relacionados where process_date=_process_date;
            GET DIAGNOSTICS _row_count = ROW_COUNT;
            RETURN _row_count;
        END IF;
    END IF;

    return NULL::BIGINT;
    END;
$$;


--TODO: Hacer diff de schemas y nada debe cambiar en los últimos objetos


create or replace function public.fn_actualiza_portfolio_ria(_custodian character varying, _account_no character varying, _process_date character varying, _new_portfolio character varying)
    returns TABLE(
        custodian character varying, account_no character varying, process_date character varying, new_portfolio character varying,
        modelo_clientes_rows_updated integer,
        maestro_cuentas_rows_match integer, maestro_cuentas_rows_updated integer,
        maestro_cuentas_old_portfolio character varying, maestro_cuentas_new_portfolio character varying,
        status_code integer, status_msg character varying)
    language plpgsql
as
$$
DECLARE
    _cant_update_model_cte int := 0;
    _cant_match_cuentas int;
    _cant_update_cuentas int;
    _old_portfolio_cuentas VARCHAR(100);
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

    IF _new_portfolio IS NULL OR trim(_new_portfolio) = '' THEN
        RAISE EXCEPTION '_new_portfolio no puede ser nulo/vacío' USING ERRCODE = '22023';
    END IF;

    --Normalizamos
    _custodian:= trim(upper(_custodian));

    --Modelo clientes (N/A)
    if (_process_date=public.get_max_process_date()) then
        RAISE NOTICE 'Actualizando Portfolio de Modelo Clientes...';
        UPDATE clientes.cuenta
            set portfolio = _new_portfolio
        WHERE upper(cuenta.id_custodio) = _custodian
        AND cuenta.id_cuenta_custodio   = _account_no
        AND cuenta.portfolio IS DISTINCT FROM _new_portfolio
        ;

        GET DIAGNOSTICS _cant_update_model_cte = ROW_COUNT;
    END IF;

    --Estadísticas previas a update
    SELECT
        1,
        portfolio
    INTO
        _cant_match_cuentas,
        _old_portfolio_cuentas
    FROM public.tbvw_maestro_cuentas_pershing tb_cta
    WHERE tb_cta.account_no = _account_no
      AND tb_cta.process_date = _process_date
      AND upper(tb_cta.custodian) = _custodian;

    --Actualizamos registros de Maestro de Cuentas
    UPDATE public.tbvw_maestro_cuentas_pershing tb_cta
    SET
        portfolio                = calc.portfolio_calc
    FROM (
        SELECT
            base.row_no,
            base.process_date,
            base.account_no,
            base.portfolio   as portfolio_actual,
            base.new_portfolio as portfolio_calc
        FROM (
            SELECT
                tb_cta.row_no,
                tb_cta.process_date,
                tb_cta.account_no,
                tb_cta.portfolio,
                _new_portfolio as new_portfolio
            FROM public.tbvw_maestro_cuentas_pershing tb_cta
            WHERE tb_cta.account_no = _account_no
            AND tb_cta.process_date = _process_date
            AND upper(tb_cta.custodian)=_custodian
            ) base
    ) calc
    WHERE tb_cta.row_no = calc.row_no
    AND tb_cta.portfolio IS DISTINCT FROM calc.portfolio_calc;

    GET DIAGNOSTICS _cant_update_cuentas = ROW_COUNT;


    RETURN QUERY
    SELECT
        _custodian, _account_no, _process_date, _new_portfolio,
        _cant_update_model_cte as modelo_clientes_rows_updated,
        _cant_match_cuentas as maestro_cuentas_rows_match, _cant_update_cuentas as maestro_cuentas_rows_updated,
        _old_portfolio_cuentas as maestro_cuentas_old_portfolio, _new_portfolio as maestro_cuentas_new_portfolio,
        0 as status_code, 'OK'::varchar(1000) as status_msg;

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