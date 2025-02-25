create or replace function rep_inv.fn_precalculo_diario(_process_date_from character varying) returns character varying
    language plpgsql
as
$$
DECLARE _output VARCHAR(100);
    BEGIN
        _output:='';


        RAISE NOTICE 'Limpiando datos pre-existente del mismo process date... [%]', timeofday();


        DELETE FROM rep_inv.base_saldos_diarios WHERE process_date      >= _process_date_from;
        DELETE FROM rep_inv.base_movimientos_diarios WHERE process_date >= _process_date_from;
        DELETE FROM rep_inv.consolidado_agregado_n1 WHERE process_date  >= _process_date_from;
        DELETE FROM rep_inv.consolidado_agregado_n2 WHERE process_date  >= _process_date_from;
        DELETE FROM rep_inv.consolidado_agregado_n3 WHERE process_date  >= _process_date_from;
        DELETE FROM rep_inv.consolidado_agregado_n4 WHERE process_date  >= _process_date_from;

        /***********************************
        *** Saldos
        ***********************************/
        RAISE NOTICE 'Guardando saldos... [%]', timeofday();



        RAISE NOTICE 'Obteniendo saldos desde Maestros Hub [%]', timeofday();
        INSERT INTO rep_inv.base_saldos_diarios
            (cant_reg,
             process_date, client_id, custodian, account_no,
             cusip, isin, symbol, security_description,
             id_tipo_activo, id_sub_tipo_activo, id_sub_sub_tipo_activo, currency,
             sum_quantity, sum_market_value, sum_usde_market_value, sum_comision_devengada_diaria)
        SELECT
            count(*) as cant_reg,
            process_date, client_id, trim(upper(custodian)) as custodian, trim(account_no) as account_no,
            trim(cusip) as cusip, trim(isin) as isin, trim(symbol) as symbol, trim(security_description),
            trim(id_tipo_activo) as id_tipo_activo, trim(id_sub_tipo_activo) as id_sub_tipo_activo, trim(id_sub_sub_tipo_activo) as id_sub_sub_tipo_activo, trim(currency) as currency,
            sum(quantity) as sum_quantity, sum(market_value) as sum_market_value, sum(usde_market_value) as sum_usde_market_value, sum(comision_devengada_diaria) as sum_comision_devengada_diaria
        FROM public.vw_reporte_maestro_datos_saldos
        WHERE process_date  >= _process_date_from
        GROUP BY process_date, client_id, trim(upper(custodian)), trim(account_no), trim(cusip), trim(isin), trim(symbol), trim(security_description), trim(id_tipo_activo), trim(id_sub_tipo_activo), trim(id_sub_sub_tipo_activo), trim(currency)
        ORDER BY 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
        ;


        /***********************************
        *** Movimientos
        ***********************************/
        RAISE NOTICE 'Obteniendo movimientos desde Maestros Hub [%]', timeofday();

        RAISE NOTICE 'Guardando dividendos... [%]', timeofday();
        --Dividendos
        INSERT INTO rep_inv.base_movimientos_diarios
            (cant_reg,
             process_date, client_id, custodian, account_no,
             cusip, isin, symbol, source_code, activity_description,
             id_tipo_activo, id_sub_tipo_activo, id_sub_sub_tipo_activo, currency,
             sum_quantity, sum_net_amount, sum_principal, sum_usde_net_amount,
             tipo_reg)
        SELECT
            count(*) as cant_reg,
            process_date, client_id, trim(upper(custodian)) as custodian, trim(account_no) as account_no,
            trim(cusip) as cusip, trim(isin) as isin, trim(symbol) as symbol, trim(activity_code) as source_code, trim(activity_description) as activity_description,
            trim(id_tipo_activo) as id_tipo_activo, trim(id_sub_tipo_activo) as id_sub_tipo_activo, trim(id_sub_sub_tipo_activo) as id_sub_sub_tipo_activo, trim(currency) as currency,
            sum(quantity) as sum_quantity, sum(net_amount) as sum_net_amount, sum(principal) as sum_principal, sum(usde_net_amount) as sum_usde_net_amount,
            'DIV'::VARCHAR(100) as tipo_reg
        FROM public.vw_reporte_maestro_datos_movimientos
        WHERE process_date  >= _process_date_from
        AND trim(activity_code) in ( SELECT trim(tb_isrc.source_code) from pershing.sfl_isrc_actual tb_isrc where tb_isrc.statement_div_ind='DIVT' )
        GROUP BY process_date, client_id, trim(upper(custodian)), trim(account_no), trim(cusip), trim(isin), trim(symbol), trim(activity_code), trim(activity_description), trim(id_tipo_activo), trim(id_sub_tipo_activo), trim(id_sub_sub_tipo_activo), trim(currency)
        ORDER BY 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14;

        RAISE NOTICE 'Guardando abonos... [%]', timeofday();
        --Abonos
        INSERT INTO rep_inv.base_movimientos_diarios
            (cant_reg,
             process_date, client_id, custodian, account_no,
             cusip, isin, symbol, source_code, activity_description,
             id_tipo_activo, id_sub_tipo_activo, id_sub_sub_tipo_activo, currency,
             sum_quantity, sum_net_amount, sum_principal, sum_usde_net_amount,
             tipo_reg)
        SELECT
            count(*) as cant_reg,
            process_date, client_id, trim(upper(custodian)) as custodian, trim(account_no) as account_no,
            trim(cusip) as cusip, trim(isin) as isin, trim(symbol) as symbol, trim(activity_code) as source_code, trim(activity_description) as activity_description,
            trim(id_tipo_activo) as id_tipo_activo, trim(id_sub_tipo_activo) as id_sub_tipo_activo, trim(id_sub_sub_tipo_activo) as id_sub_sub_tipo_activo, trim(currency) as currency,
            sum(quantity) as sum_quantity, sum(net_amount) as sum_net_amount, sum(principal) as sum_principal, sum(usde_net_amount) as sum_usde_net_amount,
            'ABO'::VARCHAR(100) as tipo_reg
        FROM public.vw_reporte_maestro_datos_movimientos
        WHERE process_date  >= _process_date_from
        AND aplica_flujo_neto=1
        AND usde_net_amount>0
        GROUP BY process_date, client_id, trim(upper(custodian)), trim(account_no), trim(cusip), trim(isin), trim(symbol), trim(activity_code), trim(activity_description), trim(id_tipo_activo), trim(id_sub_tipo_activo), trim(id_sub_sub_tipo_activo), trim(currency)
        ORDER BY 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14;

        RAISE NOTICE 'Guardando retiros... [%]', timeofday();
        --Retiros
        INSERT INTO rep_inv.base_movimientos_diarios
            (cant_reg,
             process_date, client_id, custodian, account_no,
             cusip, isin, symbol, source_code, activity_description,
             id_tipo_activo, id_sub_tipo_activo, id_sub_sub_tipo_activo, currency,
             sum_quantity, sum_net_amount, sum_principal, sum_usde_net_amount,
             tipo_reg)
        SELECT
            count(*) as cant_reg,
            process_date, client_id, trim(upper(custodian)) as custodian, trim(account_no) as account_no,
            trim(cusip) as cusip, trim(isin) as isin, trim(symbol) as symbol, trim(activity_code) as source_code, trim(activity_description) as activity_description,
            trim(id_tipo_activo) as id_tipo_activo, trim(id_sub_tipo_activo) as id_sub_tipo_activo, trim(id_sub_sub_tipo_activo) as id_sub_sub_tipo_activo, trim(currency) as currency,
            sum(quantity) as sum_quantity, sum(net_amount) as sum_net_amount, sum(principal) as sum_principal, sum(usde_net_amount) as sum_usde_net_amount,
            'RET'::VARCHAR(100) as tipo_reg
        FROM public.vw_reporte_maestro_datos_movimientos
        WHERE process_date  >= _process_date_from
        AND aplica_flujo_neto=1
        AND usde_net_amount<0
        GROUP BY process_date, client_id, trim(upper(custodian)), trim(account_no), trim(cusip), trim(isin), trim(symbol), trim(activity_code), trim(activity_description), trim(id_tipo_activo), trim(id_sub_tipo_activo), trim(id_sub_sub_tipo_activo), trim(currency)
        ORDER BY 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14;



        RAISE NOTICE 'Limpiando saldos no positivos iniciales... [%]', timeofday();

        CREATE TEMP TABLE temptb_first_process_date AS
            SELECT
                tb_start_date.client_id, min(tb_start_date.process_date) as first_process_date
            FROM
            (
                select process_date, client_id, sum(sum_usde_market_value) as sum_usde_market_value
                from rep_inv.base_saldos_diarios
                group by process_date, client_id
            ) as tb_start_date
            where tb_start_date.sum_usde_market_value>0
            group by tb_start_date.client_id
            ;


        --Borra los registros que no tienen ningún saldo positivo
        DELETE FROM rep_inv.base_saldos_diarios
        WHERE client_id NOT IN (SELECT client_id FROM temptb_first_process_date);

        --Borra los registros que no tienen ningún saldo positivo
        DELETE FROM rep_inv.base_movimientos_diarios
        WHERE client_id NOT IN (SELECT client_id FROM temptb_first_process_date);

        --Borra los registros para clientes que inician con saldo negativo (deja desde el primer día con saldo positivo)
        DELETE FROM rep_inv.base_saldos_diarios
        USING temptb_first_process_date
        WHERE rep_inv.base_saldos_diarios.client_id = temptb_first_process_date.client_id
        AND rep_inv.base_saldos_diarios.process_date < temptb_first_process_date.first_process_date;

        --Borra los registros para clientes que inician con saldo negativo (deja desde el primer día con saldo positivo)
        DELETE FROM rep_inv.base_movimientos_diarios
        USING temptb_first_process_date
        WHERE rep_inv.base_movimientos_diarios.client_id = temptb_first_process_date.client_id
        AND rep_inv.base_movimientos_diarios.process_date < temptb_first_process_date.first_process_date;


        RAISE NOTICE 'Creando base agregada... [%]', timeofday();

        CREATE TEMP TABLE temptb_base_agregada AS
            (
            SELECT
                process_date,
                public.fn_fecha_string_to_date(process_date, 'YYYYMMDD'::character varying) AS process_date_as_date,
                client_id as agregador_n1,
                custodian||'||'||account_no as agregador_n2,
                id_sub_sub_tipo_activo as agregador_n3,
                cusip as agregador_n4,
                sum(saldo_dia) as saldo_dia,
                sum(abonos_dia) as abonos_dia,
                sum(retiros_dia) as retiros_dia,
                sum(dividendos_dia) as dividendos_dia,
                sum(comision_devengada) as comision_devengada_dia
            FROM rep_inv.vw_base_consolidado
            WHERE process_date  >= _process_date_from
            group by process_date, client_id, custodian||'||'||account_no, account_no, id_sub_sub_tipo_activo, cusip
            HAVING
                process_date IS NOT NULL
               AND client_id IS NOT NULL
               AND custodian||'||'||account_no IS NOT NULL
               AND id_sub_sub_tipo_activo IS NOT NULL
               AND cusip IS NOT NULL
            ORDER BY 1, 2, 3, 4, 5, 6
        );

        RAISE NOTICE 'Cargando datos desde base agregada... [%]', timeofday();


        INSERT INTO rep_inv.consolidado_agregado_n1
            (process_date, process_date_as_date, agregador_n1, saldo_dia, abonos_dia, retiros_dia, dividendos_dia, comision_devengada_dia)
        SELECT
            process_date, process_date_as_date, agregador_n1, sum(saldo_dia) as saldo_dia, sum(abonos_dia) as abonos_dia, sum(retiros_dia) as retiros_dia, sum(dividendos_dia) as dividendos_dia, sum(comision_devengada_dia) as comision_devengada
        FROM temptb_base_agregada
        GROUP BY process_date, process_date_as_date, agregador_n1
        ORDER BY process_date, process_date_as_date, agregador_n1
        ;


        INSERT INTO rep_inv.consolidado_agregado_n2
            (process_date, process_date_as_date, agregador_n1, agregador_n2, saldo_dia, abonos_dia, retiros_dia, dividendos_dia, comision_devengada_dia)
        SELECT
            process_date, process_date_as_date, agregador_n1, agregador_n2, sum(saldo_dia) as saldo_dia, sum(abonos_dia) as abonos_dia, sum(retiros_dia) as retiros_dia, sum(dividendos_dia) as dividendos_dia, sum(comision_devengada_dia) as comision_devengada
        FROM temptb_base_agregada
        GROUP BY process_date, process_date_as_date, agregador_n1, agregador_n2
        ORDER BY process_date, process_date_as_date, agregador_n1, agregador_n2
        ;


        INSERT INTO rep_inv.consolidado_agregado_n3
            (process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3, saldo_dia, abonos_dia, retiros_dia, dividendos_dia, comision_devengada_dia)
        SELECT
            process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3, sum(saldo_dia) as saldo_dia, sum(abonos_dia) as abonos_dia, sum(retiros_dia) as retiros_dia, sum(dividendos_dia) as dividendos_dia, sum(comision_devengada_dia) as comision_devengada
        FROM temptb_base_agregada
        GROUP BY process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3
        ORDER BY process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3
        ;


        INSERT INTO rep_inv.consolidado_agregado_n4
            (process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4, saldo_dia, abonos_dia, retiros_dia, dividendos_dia, comision_devengada_dia)
        SELECT
            process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4, sum(saldo_dia) as saldo_dia, sum(abonos_dia) as abonos_dia, sum(retiros_dia) as retiros_dia, sum(dividendos_dia) as dividendos_dia, sum(comision_devengada_dia) as comision_devengada
        FROM temptb_base_agregada
        GROUP BY process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4
        ORDER BY process_date, process_date_as_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4
        ;



        RAISE NOTICE 'Calculando saldo día anterior N1... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n1 data_t0
        SET saldo_dia_anterior= COALESCE((SELECT sum(saldo_dia)
                                          FROM rep_inv.consolidado_agregado_n1 data_tmenos1
                                          WHERE data_tmenos1.process_date_as_date   = data_t0.process_date_as_date - 1
                                            AND data_tmenos1.agregador_n1           = data_t0.agregador_n1), 0)
        WHERE data_t0.process_date  >= _process_date_from
        ;


        RAISE NOTICE 'Calculando saldo día anterior N2... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n2 data_t0
        SET saldo_dia_anterior= COALESCE((SELECT sum(saldo_dia)
                                          FROM rep_inv.consolidado_agregado_n2 data_tmenos1
                                          WHERE data_tmenos1.process_date_as_date   = data_t0.process_date_as_date - 1
                                            AND data_tmenos1.agregador_n1           = data_t0.agregador_n1
                                            AND data_tmenos1.agregador_n2           = data_t0.agregador_n2), 0)
        WHERE data_t0.process_date  >= _process_date_from
        ;


        RAISE NOTICE 'Calculando saldo día anterior N3... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n3 data_t0
        SET saldo_dia_anterior= COALESCE((SELECT sum(saldo_dia)
                                          FROM rep_inv.consolidado_agregado_n3 data_tmenos1
                                          WHERE data_tmenos1.process_date_as_date   = data_t0.process_date_as_date - 1
                                            AND data_tmenos1.agregador_n1           = data_t0.agregador_n1
                                            AND data_tmenos1.agregador_n2           = data_t0.agregador_n2
                                            AND data_tmenos1.agregador_n3           = data_t0.agregador_n3), 0)
        WHERE data_t0.process_date  >= _process_date_from
        ;


        RAISE NOTICE 'Calculando saldo día anterior N4... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n4 data_t0
        SET saldo_dia_anterior= COALESCE((SELECT sum(saldo_dia)
                                          FROM rep_inv.consolidado_agregado_n4 data_tmenos1
                                          WHERE data_tmenos1.process_date_as_date   = data_t0.process_date_as_date - 1
                                            AND data_tmenos1.agregador_n1           = data_t0.agregador_n1
                                            AND data_tmenos1.agregador_n2           = data_t0.agregador_n2
                                            AND data_tmenos1.agregador_n3           = data_t0.agregador_n3
                                            AND data_tmenos1.agregador_n4           = data_t0.agregador_n4), 0)
        WHERE data_t0.process_date  >= _process_date_from
        ;



        RAISE NOTICE 'Calculando utilidades y rentabilidades N1... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n1
        SET
            --Dividendos ya están considerados en saldos... se duplciaría
            utilidad= saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior,
            rentabilidad= CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END,
            rentabilidad_base_pitatoria= (CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END)+1,
            saldo_rentabilidad  = CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE ( (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior ) * saldo_dia_anterior END
        WHERE process_date  >= _process_date_from;

        RAISE NOTICE 'Calculando utilidades y rentabilidades N2... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n2
        SET
            --Dividendos ya están considerados en saldos... se duplciaría
            utilidad= saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior,
            rentabilidad= CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END,
            rentabilidad_base_pitatoria= (CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END)+1,
            saldo_rentabilidad  = CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE ( (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior ) * saldo_dia_anterior END
        WHERE process_date  >= _process_date_from;

        RAISE NOTICE 'Calculando utilidades y rentabilidades N3... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n3
        SET
            --Dividendos ya están considerados en saldos... se duplciaría
            utilidad= saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior,
            rentabilidad= CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END,
            rentabilidad_base_pitatoria= (CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END)+1,
            saldo_rentabilidad  = CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE ( (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior ) * saldo_dia_anterior END
        WHERE process_date  >= _process_date_from;

        RAISE NOTICE 'Calculando utilidades y rentabilidades N4... [%]', timeofday();

        UPDATE rep_inv.consolidado_agregado_n4
        SET
            --Dividendos ya están considerados en saldos... se duplciaría
            utilidad= saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior,
            rentabilidad= CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END,
            rentabilidad_base_pitatoria= (CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior END)+1,
            saldo_rentabilidad  = CASE WHEN saldo_dia_anterior=0 THEN 0 ELSE ( (saldo_dia-abonos_dia-retiros_dia-saldo_dia_anterior)/saldo_dia_anterior ) * saldo_dia_anterior END
        WHERE process_date  >= _process_date_from;



        RAISE NOTICE 'Finalizando PA... [%]', timeofday();
        DROP TABLE IF EXISTS temptb_base_agregada;
        DROP TABLE IF EXISTS temptb_first_process_date;

        return _output;
    END;
$$;

alter function rep_inv.fn_precalculo_diario(varchar) owner to postgres;

