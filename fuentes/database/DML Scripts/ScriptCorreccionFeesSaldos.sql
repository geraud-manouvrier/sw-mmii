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

--Cuando se debe usar el fee vigente en mantenedor
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

--Usar cuandos e debe mantener el fee del registro de saldos
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
        base.cusip,
        base.usde_market_value,
        base.total_usde_market_value,
        --Campos a usar en update: valor calculado y valor actualmente existente
        base.id_fee_aplicado as id_fee_aplicado_actual,
        fee_seg.id as id_fee_aplicado_calc,
        base.annual_fee as annual_fee_actual,
        base.annual_fee::numeric(45,20) AS annual_fee_calc,
        base.tasa_proteccion as tasa_proteccion_actual,
        (fn_dist.fee_perc_proteccion / 100)::NUMERIC(45,20) AS tasa_proteccion_calc,
        base.tasa_suracorp as tasa_suracorp_actual,
        (fn_dist.fee_perc_ria / 100)::NUMERIC(45,20)        AS tasa_suracorp_calc,
        base.fee_diario as fee_diario_actual,
        fn_change_base_fee((base.annual_fee * 100), 'ANNUAL', 'DAILY', 'P')::NUMERIC(45,20) AS fee_diario_calc,
        base.fee_diario_proteccion as fee_diario_proteccion_actual,
        fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying)::NUMERIC(45,20) as fee_diario_proteccion_calc,
        base.fee_diario_sura_corp as fee_diario_sura_corp_actual,
        fn_change_base_fee(fn_dist.fee_perc_ria, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying)::NUMERIC(45,20) as fee_diario_sura_corp_calc,
        base.comision_devengada_diaria as comision_devengada_diaria_actual,
        (fn_change_base_fee((base.annual_fee * 100), 'ANNUAL', 'DAILY', 'P')*base.usde_market_value)::NUMERIC(45,20) as comision_devengada_diaria_calc,
        base.ingreso_proteccion as ingreso_proteccion_actual,
        (fn_change_base_fee(fn_dist.fee_perc_proteccion, 'ANNUAL'::character varying, 'DAILY'::character varying,'P'::character varying)*base.usde_market_value)::NUMERIC(45,20) as ingreso_proteccion_calc,
        --Otros campos maestro (para checkeo)
        fee_seg.glosa, fee_seg.monto_min, fee_seg.monto_max
    FROM
    (
        SELECT
            row_no,
            process_date,
            account_no,
            cusip,
            usde_market_value,
            total_usde_market_value,
            id_fee_aplicado,annual_fee,tasa_proteccion,tasa_suracorp,fee_diario,fee_diario_proteccion,fee_diario_sura_corp,comision_devengada_diaria,ingreso_proteccion
        FROM public.tbvw_maestro_saldos_pershing
        --TODO: Cambiar por rangos correctos
        WHERE process_date in ('20251013', '20251111')
        and account_no in
            ('T9N001490', 'T9N001508', 'T9N001599', 'T9N001631', 'T9N001649', 'T9N001656', 'T9N001664', 'T9N001706', 'T9N002019', 'T9N002076', 'T9N002134', 'T9N002167', 'T9N002183', 'T9N002225', 'T9N002324', 'T9N002407', 'T9N002423', 'T9N002431', 'T9N002456', 'T9N002514', 'T9N002589', 'T9O001192', 'T9O001267', 'T9O001275', 'T9O001341', 'T9O001366', 'T9O001374', 'T9O001382', 'T9O001390', 'T9O001408', 'T9O001457', 'T9O001465', 'T9O001473', 'T9O001481', 'T9O001507', 'T9O001515', 'T9O001523', 'T9O001531', 'T9O001556', 'T9O001564', 'T9O001572', 'T9O001580', 'T9O001598', 'T9O001606', 'T9O001614', 'T9O001648', 'T9O001655', 'T9O001705', 'T9O001713', 'T9O001754', 'T9O001796', 'T9O001804', 'T9O001812', 'T9O001820', 'T9O001838', 'T9O001846', 'T9O001853', 'T9O001879', 'T9O001887', 'T9O001895', 'T9O001903', 'T9O001911', 'T9O001929', 'T9O001937', 'T9O001945', 'T9O001952', 'T9O001960', 'T9O001978', 'T9O001994', 'T9O002000', 'T9O002026', 'T9O002034', 'T9O002042', 'T9O002059', 'T9O002067', 'T9O002083', 'T9O002091', 'T9O002117', 'T9O002125', 'T9O002133', 'T9O002158', 'T9O002166', 'T9O002174', 'T9O002182', 'T9O002190', 'T9O002208', 'T9O002216', 'T9O002224', 'T9O002232', 'T9O002240', 'T9O002265', 'T9O002273', 'T9O002281', 'T9O002299', 'T9O002307', 'T9O002315', 'T9O002323', 'T9O002331', 'T9O002364', 'T9O002372', 'T9O002380', 'T9O002398', 'T9O002406', 'T9O002414', 'T9O002422', 'T9O002430', 'T9O002448', 'T9O002471', 'T9O002489', 'T9O002497', 'T9O002505', 'T9O002521', 'T9O002547', 'T9O002554', 'T9O002562', 'T9O002570', 'T9O002588', 'T9O002596', 'T9O002604', 'T9O002620', 'T9O002638', 'T9O002646', 'T9O002653', 'T9O002661', 'T9O002679', 'T9O002687', 'T9O002695', 'T9O002703', 'T9O002711', 'T9O002737', 'T9O002745', 'T9O002752', 'T9O002778', 'T9O002786', 'T9O002794', 'T9O002828', 'T9O002844', 'T9O002851', 'T9O002869', 'T9O002877', 'T9O002885', 'T9O002893', 'T9O002901', 'T9O002919', 'T9O002927', 'T9O002935', 'T9O002943', 'T9O002976', 'T9O002992', 'T9O003024', 'T9O003032', 'T9O003040', 'T9O003057', 'T9O003065', 'T9O003073', 'T9O003099', 'T9O003107', 'T9O003115', 'T9O003123', 'T9O003131', 'T9O003164', 'T9O003172', 'T9O003180', 'T9O003198', 'T9O003206', 'T9O003214', 'T9O003222', 'T9O003230', 'T9O003263', 'T9O003271', 'T9O003297', 'T9O003305', 'T9O003339', 'T9O003347', 'T9O003354', 'T9O003362', 'T9O003370', 'T9O003396', 'T9O003412', 'T9O003420', 'T9O003438', 'T9O003453', 'T9O003461', 'T9O003479', 'T9O003487', 'T9O003495', 'T9O003503', 'T9O003511', 'T9O003529', 'T9O003537', 'T9O003545', 'T9O003560', 'T9O003578', 'T9O003586', 'T9O003602', 'T9O003610', 'T9O003628', 'T9O003636', 'T9O003644', 'T9O003651', 'T9O003669', 'T9O003677', 'T9O003693', 'T9O003701', 'T9O003735', 'T9O003768', 'T9O003784', 'T9O003792', 'T9O003800', 'T9O003818', 'T9O003826', 'T9O003834', 'T9O003859', 'T9O003867', 'T9O003875', 'T9O003883', 'T9O003909', 'T9O003925', 'T9O003933', 'T9O003958', 'T9O003966', 'T9O003974', 'T9O003982', 'T9O003990', 'T9O004006', 'T9O004022', 'T9O004030', 'T9O004055', 'T9O004063', 'T9O004071', 'T9O004089', 'T9O004097', 'T9O004121', 'T9O004139', 'T9O004147', 'T9O004162', 'T9O004170', 'T9O004188', 'T9O004196', 'T9O004204', 'T9O004212', 'T9O004246', 'T9O004253', 'T9O004261', 'T9O004279', 'T9O004287', 'T9O004295', 'T9O004303', 'T9O004311', 'T9O004329', 'T9O004345', 'T9O004378', 'T9O004394', 'T9O004410', 'T9O004428', 'T9O004436', 'T9O004451', 'T9O004477', 'T9O004485', 'T9O004501', 'T9O004519', 'T9O004527', 'T9O004543', 'T9O004550', 'T9O004568', 'T9O004576', 'T9O004584', 'T9O004592', 'T9O004600', 'T9O004618', 'T9O004626', 'T9O004642', 'T9O004659', 'T9O004667', 'T9O004683', 'T9O004691', 'T9O004709', 'T9O004717', 'T9O004766', 'T9O004774', 'T9O004790', 'T9O004808', 'T9O004816', 'T9O004824', 'T9O004832', 'T9O004857', 'T9O004865', 'T9O004881', 'T9O004899', 'T9O004907', 'T9O004915', 'T9O004923', 'T9O004931', 'T9O004964', 'T9O004972', 'T9O004980', 'T9O005011', 'T9O005029', 'T9O005045', 'T9O005052', 'T9O005060', 'T9O005078', 'T9O005086', 'T9O005102', 'T9O005110', 'T9O005128', 'T9O005136', 'T9O005144', 'T9O005151', 'T9O005169', 'T9O005177', 'T9O005219', 'T9O005243', 'T9O005250', 'T9O005268', 'T9O005276', 'T9O005284', 'T9O005292', 'T9O005300', 'T9O005326', 'T9O005359', 'T9O005367', 'T9O005375', 'T9O005417', 'T9O005425', 'T9O005466', 'T9O005482', 'T9O005508', 'T9O005516', 'T9O005540', 'T9O005615', 'T9O005623', 'T9O005631', 'T9O005649', 'T9O005664', 'T9O005672', 'T9O005680', 'T9O005698', 'T9O005714', 'T9O005722', 'T9O005748', 'T9O005755', 'T9O005771', 'T9O005789', 'T9O005797', 'T9O005813', 'T9O005821', 'T9O005839', 'T9O005847', 'T9O005862', 'T9O005870', 'T9O005888', 'T9O005896', 'T9O005904', 'T9O005912', 'T9O005920', 'T9O005938', 'T9O005946', 'T9O005961', 'T9O005995', 'T9O006019', 'T9O006035', 'T9O006043', 'T9O006050', 'T9O006068', 'T9O006076', 'T9O006084', 'T9O006100', 'T9O006118', 'T9O006126', 'T9O006142', 'T9O006159', 'T9O006167', 'T9O006175', 'T9O006183', 'T9O006191', 'T9O006209', 'T9O006217', 'T9O006225', 'T9O006233', 'T9O006258', 'T9O006274', 'T9O006282', 'T9O006290', 'T9O006308', 'T9O006316', 'T9O006324', 'T9O006332', 'T9O006340', 'T9O006357', 'T9O006365', 'T9O006381', 'T9O006407', 'T9O006415', 'T9O006449'
            )
    ) base
    LEFT JOIN clientes.par_fee_segmento fee_seg
        ON fee_seg.monto_min <= base.total_usde_market_value
        AND fee_seg.monto_max >  base.total_usde_market_value
    CROSS JOIN LATERAL public.fn_distribucion_ingresos((base.annual_fee * 100), base.process_date) AS fn_dist(fee_perc_proteccion, fee_perc_ria)
    ) calc
WHERE tb_sld.row_no = calc.row_no
and tb_sld.process_date in ('20251013', '20251111')
    and tb_sld.account_no in
    ('T9N001490', 'T9N001508', 'T9N001599', 'T9N001631', 'T9N001649', 'T9N001656', 'T9N001664', 'T9N001706', 'T9N002019', 'T9N002076', 'T9N002134', 'T9N002167', 'T9N002183', 'T9N002225', 'T9N002324', 'T9N002407', 'T9N002423', 'T9N002431', 'T9N002456', 'T9N002514', 'T9N002589', 'T9O001192', 'T9O001267', 'T9O001275', 'T9O001341', 'T9O001366', 'T9O001374', 'T9O001382', 'T9O001390', 'T9O001408', 'T9O001457', 'T9O001465', 'T9O001473', 'T9O001481', 'T9O001507', 'T9O001515', 'T9O001523', 'T9O001531', 'T9O001556', 'T9O001564', 'T9O001572', 'T9O001580', 'T9O001598', 'T9O001606', 'T9O001614', 'T9O001648', 'T9O001655', 'T9O001705', 'T9O001713', 'T9O001754', 'T9O001796', 'T9O001804', 'T9O001812', 'T9O001820', 'T9O001838', 'T9O001846', 'T9O001853', 'T9O001879', 'T9O001887', 'T9O001895', 'T9O001903', 'T9O001911', 'T9O001929', 'T9O001937', 'T9O001945', 'T9O001952', 'T9O001960', 'T9O001978', 'T9O001994', 'T9O002000', 'T9O002026', 'T9O002034', 'T9O002042', 'T9O002059', 'T9O002067', 'T9O002083', 'T9O002091', 'T9O002117', 'T9O002125', 'T9O002133', 'T9O002158', 'T9O002166', 'T9O002174', 'T9O002182', 'T9O002190', 'T9O002208', 'T9O002216', 'T9O002224', 'T9O002232', 'T9O002240', 'T9O002265', 'T9O002273', 'T9O002281', 'T9O002299', 'T9O002307', 'T9O002315', 'T9O002323', 'T9O002331', 'T9O002364', 'T9O002372', 'T9O002380', 'T9O002398', 'T9O002406', 'T9O002414', 'T9O002422', 'T9O002430', 'T9O002448', 'T9O002471', 'T9O002489', 'T9O002497', 'T9O002505', 'T9O002521', 'T9O002547', 'T9O002554', 'T9O002562', 'T9O002570', 'T9O002588', 'T9O002596', 'T9O002604', 'T9O002620', 'T9O002638', 'T9O002646', 'T9O002653', 'T9O002661', 'T9O002679', 'T9O002687', 'T9O002695', 'T9O002703', 'T9O002711', 'T9O002737', 'T9O002745', 'T9O002752', 'T9O002778', 'T9O002786', 'T9O002794', 'T9O002828', 'T9O002844', 'T9O002851', 'T9O002869', 'T9O002877', 'T9O002885', 'T9O002893', 'T9O002901', 'T9O002919', 'T9O002927', 'T9O002935', 'T9O002943', 'T9O002976', 'T9O002992', 'T9O003024', 'T9O003032', 'T9O003040', 'T9O003057', 'T9O003065', 'T9O003073', 'T9O003099', 'T9O003107', 'T9O003115', 'T9O003123', 'T9O003131', 'T9O003164', 'T9O003172', 'T9O003180', 'T9O003198', 'T9O003206', 'T9O003214', 'T9O003222', 'T9O003230', 'T9O003263', 'T9O003271', 'T9O003297', 'T9O003305', 'T9O003339', 'T9O003347', 'T9O003354', 'T9O003362', 'T9O003370', 'T9O003396', 'T9O003412', 'T9O003420', 'T9O003438', 'T9O003453', 'T9O003461', 'T9O003479', 'T9O003487', 'T9O003495', 'T9O003503', 'T9O003511', 'T9O003529', 'T9O003537', 'T9O003545', 'T9O003560', 'T9O003578', 'T9O003586', 'T9O003602', 'T9O003610', 'T9O003628', 'T9O003636', 'T9O003644', 'T9O003651', 'T9O003669', 'T9O003677', 'T9O003693', 'T9O003701', 'T9O003735', 'T9O003768', 'T9O003784', 'T9O003792', 'T9O003800', 'T9O003818', 'T9O003826', 'T9O003834', 'T9O003859', 'T9O003867', 'T9O003875', 'T9O003883', 'T9O003909', 'T9O003925', 'T9O003933', 'T9O003958', 'T9O003966', 'T9O003974', 'T9O003982', 'T9O003990', 'T9O004006', 'T9O004022', 'T9O004030', 'T9O004055', 'T9O004063', 'T9O004071', 'T9O004089', 'T9O004097', 'T9O004121', 'T9O004139', 'T9O004147', 'T9O004162', 'T9O004170', 'T9O004188', 'T9O004196', 'T9O004204', 'T9O004212', 'T9O004246', 'T9O004253', 'T9O004261', 'T9O004279', 'T9O004287', 'T9O004295', 'T9O004303', 'T9O004311', 'T9O004329', 'T9O004345', 'T9O004378', 'T9O004394', 'T9O004410', 'T9O004428', 'T9O004436', 'T9O004451', 'T9O004477', 'T9O004485', 'T9O004501', 'T9O004519', 'T9O004527', 'T9O004543', 'T9O004550', 'T9O004568', 'T9O004576', 'T9O004584', 'T9O004592', 'T9O004600', 'T9O004618', 'T9O004626', 'T9O004642', 'T9O004659', 'T9O004667', 'T9O004683', 'T9O004691', 'T9O004709', 'T9O004717', 'T9O004766', 'T9O004774', 'T9O004790', 'T9O004808', 'T9O004816', 'T9O004824', 'T9O004832', 'T9O004857', 'T9O004865', 'T9O004881', 'T9O004899', 'T9O004907', 'T9O004915', 'T9O004923', 'T9O004931', 'T9O004964', 'T9O004972', 'T9O004980', 'T9O005011', 'T9O005029', 'T9O005045', 'T9O005052', 'T9O005060', 'T9O005078', 'T9O005086', 'T9O005102', 'T9O005110', 'T9O005128', 'T9O005136', 'T9O005144', 'T9O005151', 'T9O005169', 'T9O005177', 'T9O005219', 'T9O005243', 'T9O005250', 'T9O005268', 'T9O005276', 'T9O005284', 'T9O005292', 'T9O005300', 'T9O005326', 'T9O005359', 'T9O005367', 'T9O005375', 'T9O005417', 'T9O005425', 'T9O005466', 'T9O005482', 'T9O005508', 'T9O005516', 'T9O005540', 'T9O005615', 'T9O005623', 'T9O005631', 'T9O005649', 'T9O005664', 'T9O005672', 'T9O005680', 'T9O005698', 'T9O005714', 'T9O005722', 'T9O005748', 'T9O005755', 'T9O005771', 'T9O005789', 'T9O005797', 'T9O005813', 'T9O005821', 'T9O005839', 'T9O005847', 'T9O005862', 'T9O005870', 'T9O005888', 'T9O005896', 'T9O005904', 'T9O005912', 'T9O005920', 'T9O005938', 'T9O005946', 'T9O005961', 'T9O005995', 'T9O006019', 'T9O006035', 'T9O006043', 'T9O006050', 'T9O006068', 'T9O006076', 'T9O006084', 'T9O006100', 'T9O006118', 'T9O006126', 'T9O006142', 'T9O006159', 'T9O006167', 'T9O006175', 'T9O006183', 'T9O006191', 'T9O006209', 'T9O006217', 'T9O006225', 'T9O006233', 'T9O006258', 'T9O006274', 'T9O006282', 'T9O006290', 'T9O006308', 'T9O006316', 'T9O006324', 'T9O006332', 'T9O006340', 'T9O006357', 'T9O006365', 'T9O006381', 'T9O006407', 'T9O006415', 'T9O006449'
    )
;
