create or replace function public.fn_actualiza_portfolio_ria(_custodian character varying, _account_no character varying, _process_date character varying, _new_portfolio character varying)
    returns TABLE(custodian character varying, account_no character varying, process_date character varying, new_portfolio character varying, modelo_clientes_rows_updated integer, maestro_cuentas_rows_match integer, maestro_cuentas_rows_updated integer, maestro_cuentas_old_portfolio character varying, maestro_cuentas_new_portfolio character varying, status_code integer, status_msg character varying)
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

alter function public.fn_actualiza_portfolio_ria(varchar, varchar, varchar, varchar) owner to postgres;

