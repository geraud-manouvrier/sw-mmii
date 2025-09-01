create or replace function public.fn_estado_cuenta_from_tbvw(_account_no character varying, _opt_process_date character varying) returns character varying
    language plpgsql
as
$$
--Variables de control de datos en maestros
DECLARE _has_mov boolean;
DECLARE _has_sld boolean;
DECLARE _account_closed boolean;
--Parámetros
DECLARE _days_whitout_rec INT   := 60;
DECLARE _date_yesterday date    := (current_date - interval '1 day')::date;
DECLARE _date_start date;
--Filtros querys principales
DECLARE _process_date_current VARCHAR(100);
DECLARE _process_date_start VARCHAR(100);
    BEGIN
        --Fecha de proceso "tope" o última disponible. Si no se entrega, es T-1
        _process_date_current   := COALESCE(_opt_process_date, public.fn_fecha_date_to_string(_date_yesterday, 'YYYYMMDD', ''));
        _date_start             := public.fn_fecha_string_to_date(_process_date_current, 'YYYYMMDD') - ((interval '1 day')*_days_whitout_rec);
        _process_date_start     := public.fn_fecha_date_to_string(_date_start, 'YYYYMMDD', '');


        --Estado de la cuenta según lo informado por custodio a la fecha deseada/buscada (sirve para fechas pasadas)
        SELECT (date_account_closed IS NOT NULL) INTO _account_closed
        FROM public.tbvw_maestro_cuentas_pershing where account_no = _account_no AND process_date=_process_date_current
        LIMIT 1;

        IF (_account_closed) THEN
            return 'C-CERRADA';
        end if;

        --Buscamos movimientos (separados de saldos por performance), considerando la fecha tope (para re-procesos pasados)
        _has_mov := EXISTS(SELECT 1
                           FROM public.tbvw_maestro_movimientos_pershing vw_mov
                           WHERE vw_mov.account_no = _account_no
                             AND vw_mov.process_date >= _process_date_start
                           AND vw_mov.process_date <= _process_date_current);
        IF (_has_mov) THEN
            return 'A-ACTIVA';
        END IF;

        --Buscamos saldos (separados de mov por performance), considerando la fecha tope (para re-procesos pasados)
        _has_sld := EXISTS(SELECT 1
                           FROM public.tbvw_maestro_saldos_pershing vw_sld
                           WHERE vw_sld.account_no = _account_no
                             AND vw_sld.process_date >= _process_date_start
                           AND vw_sld.process_date <= _process_date_current);

        IF (_has_sld) THEN
            return 'A-ACTIVA';
        END IF;

    RETURN 'I-INACTIVA';
    END;
$$;

alter function public.fn_estado_cuenta_from_tbvw(varchar, varchar) owner to postgres;

