/*
Calcula Fee y campos derivados para actualziar registros antiguos mal procesados.
1.- Debe estar en el mantenedor de cuentas el fee correcto a asignar
2.- Ejecutar el select intenrod el script usando fechas recientes que tienen fee correcto para contrastasr que campos actuales y calculados coinciden
3.- Ejecutar select interno con parámetros correctos para estimar filas a actualizar
4.- Respaldar tabla tbvw_maestro_saldos_pershing
5.- Ejecutar update y verificar que registros actualizados coincidan con la cantidad del punto 3
6.- Ejecutar select interno para verificar que campos calculados son los mismos que los actuales
*/

/*
Para registro histórico, dejar process dates y account N° de registros a modificar
WHERE account_no = 'T9O001390' AND process_date >= '20260425' AND process_date <  '20260505'    --64 reg.
WHERE account_no = 'T9O001879' AND process_date >= '20260423' AND process_date <  '20260505'    --44 reg.
*/

--Respaldo
SELECT * INTO zz_backup.tbvw_maestro_saldos_pershing_20260513 FROM public.tbvw_maestro_saldos_pershing;

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
        (vw_cta.fee / 100)::numeric(45,20) AS annual_fee_calc,
        base.tasa_proteccion as tasa_proteccion_actual,
        (fn_dist.fee_perc_proteccion / 100)::NUMERIC(45,20) AS tasa_proteccion_calc,
        base.tasa_suracorp as tasa_suracorp_actual,
        (fn_dist.fee_perc_ria / 100)::NUMERIC(45,20)        AS tasa_suracorp_calc,
        base.fee_diario as fee_diario_actual,
        fn_change_base_fee(vw_cta.fee, 'ANNUAL', 'DAILY', 'P')::NUMERIC(45,20) AS fee_diario_calc,
        base.fee_diario_proteccion as fee_diario_proteccion_actual,
        fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying)::NUMERIC(45,20) as fee_diario_proteccion_calc,
        base.fee_diario_sura_corp as fee_diario_sura_corp_actual,
        fn_change_base_fee(fn_dist.fee_perc_ria, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying)::NUMERIC(45,20) as fee_diario_sura_corp_calc,
        base.comision_devengada_diaria as comision_devengada_diaria_actual,
        (fn_change_base_fee(vw_cta.fee, 'ANNUAL', 'DAILY', 'P')*base.usde_market_value)::NUMERIC(45,20) as comision_devengada_diaria_calc ,
        base.ingreso_proteccion as ingreso_proteccion_actual,
        (fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying)*base.usde_market_value)::NUMERIC(45,20) as ingreso_proteccion_calc,
        --Otros campos maestro (para checkeo)
        vw_cta.id_interno_cliente,
        vw_cta.identificador_cliente,
        vw_cta.nombre_cliente,
        vw_cta.id_cuenta_custodio,
        vw_cta.fee,
        fee_seg.glosa, fee_seg.monto_min, fee_seg.monto_max
    FROM
    (
        SELECT
            row_no,
            process_date,
            account_no,
            usde_market_value,
            total_usde_market_value,
            id_fee_aplicado,annual_fee,tasa_proteccion,tasa_suracorp,fee_diario,fee_diario_proteccion,fee_diario_sura_corp,comision_devengada_diaria,ingreso_proteccion
        FROM public.tbvw_maestro_saldos_pershing
        --TODO: Cambiar por rangos correctos
        WHERE account_no = 'T9O001879' AND process_date >= '20260423' AND process_date <  '20260505'
    ) base
    JOIN clientes.vw_maestro_clientes_cuentas vw_cta
        ON base.account_no=vw_cta.id_cuenta_custodio
    LEFT JOIN clientes.par_fee_segmento fee_seg
        ON fee_seg.monto_min <= base.total_usde_market_value
        AND fee_seg.monto_max >  base.total_usde_market_value
    CROSS JOIN LATERAL public.fn_distribucion_ingresos(vw_cta.fee, base.process_date) AS fn_dist(fee_perc_proteccion, fee_perc_ria)
    ) calc
WHERE tb_sld.row_no = calc.row_no;


--Respaldo
SELECT * INTO zz_backup.tbvw_maestro_cuentas_pershing_20260514 FROM public.tbvw_maestro_cuentas_pershing;

UPDATE public.tbvw_maestro_cuentas_pershing tb_cta
SET
    fee                = calc.annual_fee_calc
FROM (
    SELECT
        base.row_no,
        base.process_date,
        base.account_no,
        base.fee   as annual_fee_actual,
        vw_cta.fee as annual_fee_calc
    FROM (
        SELECT
            row_no,
            process_date,
            account_no,
            fee
        FROM public.tbvw_maestro_cuentas_pershing
        --TODO: Cambiar por rangos correctos
        WHERE (account_no = 'T9O001390' AND process_date >= '20260425' AND process_date <  '20260505')  --10 reg.
        OR (account_no = 'T9O001879' AND process_date >= '20260423' AND process_date < '20260505')      --12 reg.
    ) base
    JOIN clientes.vw_maestro_clientes_cuentas vw_cta
    ON base.account_no = vw_cta.id_cuenta_custodio
) calc
WHERE tb_cta.row_no = calc.row_no
;