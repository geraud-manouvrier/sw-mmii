/*
2025-06-11
Actual: 11.2.0-COL
*/

INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTRL_DIFF_FEE' FROM public.users where username in ('admin-qye')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_REP_MAESTRO_REL' FROM public.users where username in ('daniel.gomez1', 'brayan.giraldom', 'santiago.isaza')
;
INSERT INTO public.authorities(user_id, authority)
SELECT id, 'ROLE_OP_CTRL_DIFF_FEE' FROM public.users where username in ('daniel.gomez1', 'brayan.giraldom', 'santiago.isaza')
;


--========================================================================
--========================================================================
--========================================================================
-- Reporte diferencias fee

--TODO: Debe llevar ingresos/egresos netos (movimientos)
CREATE OR REPLACE VIEW public.vw_reporte_diferencias_fee AS
    SELECT
        temp_sld.process_date,
        temp_sld.client_id, tb_cte.nombre, temp_sld.custodian, temp_sld.account_no,
        temp_sld.saldo_dia,
        seg_fee.id, seg_fee.glosa, seg_fee.monto_min, seg_fee.monto_max,
        seg_fee.annual_fee*100 as fee_seg, tb_cte.fee as fee_cte, COALESCE(((seg_fee.annual_fee*100)=tb_cte.fee), false) as flag_fee
    FROM
    (
        SELECT
            vw_sld.process_date,
            vw_sld.client_id, vw_sld.custodian, vw_sld.account_no,
            sum(vw_sld.usde_market_value) AS saldo_dia
        FROM public.vw_reporte_maestro_datos_saldos vw_sld
        GROUP BY vw_sld.process_date, vw_sld.client_id, vw_sld.custodian, vw_sld.account_no
    ) as temp_sld
    INNER JOIN clientes.par_fee_segmento as seg_fee
    ON temp_sld.saldo_dia BETWEEN seg_fee.monto_min AND seg_fee.monto_max
    INNER JOIN clientes.cliente tb_cte
    ON temp_sld.client_id = tb_cte.identificador
;

SELECT * FROM public.vw_reporte_diferencias_fee where process_date = '20250601';


--========================================================================
--========================================================================
--========================================================================
-- Carga masiva Fees
SELECT distinct identificador FROM clientes.cliente where fee is null order by identificador;

--155 reg
select distinct client_id
from public.vw_reporte_maestro_datos_saldos
where process_date = '20250608'
order by client_id
;
--155 reg
select distinct account_no
from public.vw_reporte_maestro_datos_saldos
where process_date = '20250608'
order by account_no
;

--179 total
SELECT
    identificador, nombre, tarifa_negociada as fee_ria
FROM clientes.cliente cte
LEFT JOIN
(
SELECT 10091580 AS id_cliente, 1.50000000000000000000 AS tarifa_negociada, 'Colombia SURA Investments' AS pais_atencion_cliente, 'T9O001523' AS id_cuenta_custodio
UNION ALL
SELECT 10097191, 1.00000000000000000000, 'Colombia Protección', 'T9N002183'
UNION ALL
SELECT 1017923423, 0.75000000000000000000, 'Colombia Protección', 'T9N001656'
UNION ALL
SELECT 1020723709, 1.50000000000000000000, 'Colombia Protección', 'T9O001838'
UNION ALL
SELECT 1020732642, 1.50000000000000000000, 'Colombia Protección', 'T9O003628'
UNION ALL
SELECT 1020735796, 1.50000000000000000000, 'Colombia Protección', 'T9O002869'
UNION ALL
SELECT 10270837, 1.00000000000000000000, 'Colombia Protección', 'T9O002638'
UNION ALL
SELECT 1037597813, 1.50000000000000000000, 'Colombia Protección', 'T9O002273'
UNION ALL
SELECT 10539476, 1.25000000000000000000, 'Colombia Protección', 'T9O003214'
UNION ALL
SELECT 1127587240, 1.50000000000000000000, 'Colombia Protección', 'T9O003537'
UNION ALL
SELECT 11304420, 1.25000000000000000000, 'Colombia Protección', 'T9O001374'
UNION ALL
SELECT 1144085491, 1.50000000000000000000, 'Colombia Protección', 'T9O003339'
UNION ALL
SELECT 12752797, 1.50000000000000000000, 'Colombia Protección', 'T9O002901'
UNION ALL
SELECT 13501824, 1.50000000000000000000, 'Colombia Protección', 'T9O002505'
UNION ALL
SELECT 13805837, 1.50000000000000000000, 'Colombia Protección', 'T9O002893'
UNION ALL
SELECT 13836438, 1.50000000000000000000, 'Colombia Protección', 'T9O002133'
UNION ALL
SELECT 14879654, 1.50000000000000000000, 'Colombia Protección', 'T9O003024'
UNION ALL
SELECT 14960137, 1.00000000000000000000, 'Colombia Protección', 'T9O002679'
UNION ALL
SELECT 14962611, 1.50000000000000000000, 'Colombia Protección', 'T9O002315'
UNION ALL
SELECT 15384977, 1.00000000000000000000, 'Colombia Protección', 'T9N002019'
UNION ALL
SELECT 15437350, 1.50000000000000000000, 'Colombia Protección', 'T9O001853'
UNION ALL
SELECT 16625260, 1.25000000000000000000, 'Colombia Protección', 'T9O002786'
UNION ALL
SELECT 16639238, 1.50000000000000000000, 'Colombia Protección', 'T9O003560'
UNION ALL
SELECT 16714580, 1.50000000000000000000, 'Colombia Protección', 'T9O002661'
UNION ALL
SELECT 16929738, 1.25000000000000000000, 'Colombia Protección', 'T9O002943'
UNION ALL
SELECT 19075638, 1.50000000000000000000, 'Colombia Protección', 'T9O003511'
UNION ALL
SELECT 19124278, 1.50000000000000000000, 'Colombia Protección', 'T9O002240'
UNION ALL
SELECT 19305986, 1.25000000000000000000, 'Colombia Protección', 'T9O002646'
UNION ALL
SELECT 19405529, 1.50000000000000000000, 'Colombia Protección', 'T9O002877'
UNION ALL
SELECT 19431643, 0.75000000000000000000, 'Colombia Protección', 'T9N002225'
UNION ALL
SELECT 20293407, 1.50000000000000000000, 'Colombia Protección', 'T9O001952'
UNION ALL
SELECT 21066858, 1.50000000000000000000, 'Colombia Protección', 'T9O001804'
UNION ALL
SELECT 21953012, 1.50000000000000000000, 'Colombia Protección', 'T9O002562'
UNION ALL
SELECT 24935623, 1.25000000000000000000, 'Colombia Protección', 'T9O002158'
UNION ALL
SELECT 2775975, 1.50000000000000000000, 'Colombia Protección', 'T9O001911'
UNION ALL
SELECT 29344278, 1.50000000000000000000, 'Colombia Protección', 'T9O002224'
UNION ALL
SELECT 31246784, 1.50000000000000000000, 'Colombia Protección', 'T9O002588'
UNION ALL
SELECT 31272539, 1.50000000000000000000, 'Colombia Protección', 'T9O003545'
UNION ALL
SELECT 31293855, 1.50000000000000000000, 'Colombia Protección', 'T9O003131'
UNION ALL
SELECT 31837808, 1.50000000000000000000, 'Colombia Protección', 'T9O003420'
UNION ALL
SELECT 3226846, 1.25000000000000000000, 'Colombia Protección', 'T9O002414'
UNION ALL
SELECT 32329206, 1.00000000000000000000, 'Colombia Protección', 'T9O001705'
UNION ALL
SELECT 32510753, 0.75000000000000000000, 'Colombia Protección', 'T9N001664'
UNION ALL
SELECT 32690774, 1.50000000000000000000, 'Colombia Protección', 'T9O002430'
UNION ALL
SELECT 3356341, 1.00000000000000000000, 'Colombia Protección', 'T9O001408'
UNION ALL
SELECT 3437044, 0.75000000000000000000, 'Colombia Protección', 'T9O003586'
UNION ALL
SELECT 3465429, 1.50000000000000000000, 'Colombia Protección', 'T9O003461'
UNION ALL
SELECT 35197791, 1.50000000000000000000, 'Colombia Protección', 'T9O001341'
UNION ALL
SELECT 35464580, 1.50000000000000000000, 'Colombia Protección', 'T9O002745'
UNION ALL
SELECT 37329351, 1.50000000000000000000, 'Colombia Protección', 'T9O003412'
UNION ALL
SELECT 396677, 1.50000000000000000000, 'Colombia Protección', 'T9O002448'
UNION ALL
SELECT 39750173, 1.50000000000000000000, 'Colombia Protección', 'T9O001796'
UNION ALL
SELECT 40985344, 1.50000000000000000000, 'Colombia Protección', 'T9O002026'
UNION ALL
SELECT 41663040, 1.25000000000000000000, 'Colombia Protección', 'T9O002489'
UNION ALL
SELECT 42754152, 1.50000000000000000000, 'Colombia Protección', 'T9O001812'
UNION ALL
SELECT 42797700, 1.50000000000000000000, 'Colombia Protección', 'T9O003172'
UNION ALL
SELECT 42868495, 1.50000000000000000000, 'Colombia Protección', 'T9O001598'
UNION ALL
SELECT 42871245, 1.50000000000000000000, 'Colombia Protección', 'T9O002034'
UNION ALL
SELECT 42875831, 1.50000000000000000000, 'Colombia Protección', 'T9O001879'
UNION ALL
SELECT 42884866, 1.50000000000000000000, 'Colombia Protección', 'T9O003123'
UNION ALL
SELECT 42887485, 1.50000000000000000000, 'Colombia Protección', 'T9O003693'
UNION ALL
SELECT 42893477, 1.50000000000000000000, 'Colombia Protección', 'T9O003644'
UNION ALL
SELECT 42893673, 1.50000000000000000000, 'Colombia Protección', 'T9O002166'
UNION ALL
SELECT 42896899, 1.50000000000000000000, 'Colombia Protección', 'T9O002042'
UNION ALL
SELECT 42987759, 1.25000000000000000000, 'Colombia Protección', 'T9O002125'
UNION ALL
SELECT 42987950, 1.25000000000000000000, 'Colombia Protección', 'T9O002307'
UNION ALL
SELECT 43011543, 1.50000000000000000000, 'Colombia Protección', 'T9O002547'
UNION ALL
SELECT 43034387, 1.50000000000000000000, 'Colombia Protección', 'T9O002570'
UNION ALL
SELECT 43076439, 0.75000000000000000000, 'Colombia Protección', 'T9O001606'
UNION ALL
SELECT 43266534, 1.50000000000000000000, 'Colombia Protección', 'T9O002208'
UNION ALL
SELECT 43510821, 1.25000000000000000000, 'Colombia Protección', 'T9O002398'
UNION ALL
SELECT 43511218, 1.50000000000000000000, 'Colombia Protección', 'T9O002695'
UNION ALL
SELECT 43511394, 1.50000000000000000000, 'Colombia Protección', 'T9O002778'
UNION ALL
SELECT 43512421, 1.50000000000000000000, 'Colombia Protección', 'T9O003362'
UNION ALL
SELECT 43613183, 1.50000000000000000000, 'Colombia Protección', 'T9O003297'
UNION ALL
SELECT 43627165, 1.00000000000000000000, 'Colombia Protección', 'T9O001960'
UNION ALL
SELECT 43628306, 1.50000000000000000000, 'Colombia Protección', 'T9O003354'
UNION ALL
SELECT 43725187, 1.50000000000000000000, 'Colombia Protección', 'T9O002935'
UNION ALL
SELECT 43731193, 1.50000000000000000000, 'Colombia Protección', 'T9O003198'
UNION ALL
SELECT 43743320, 1.50000000000000000000, 'Colombia Protección', 'T9O001713'
UNION ALL
SELECT 438124, 1.25000000000000000000, 'Colombia Protección', 'T9O002471'
UNION ALL
SELECT 51788982, 1.50000000000000000000, 'Colombia Protección', 'T9O003222'
UNION ALL
SELECT 51821877, 1.50000000000000000000, 'Colombia Protección', 'T9O001903'
UNION ALL
SELECT 51828522, 1.50000000000000000000, 'Colombia Protección', 'T9O003602'
UNION ALL
SELECT 51832175, 1.50000000000000000000, 'Colombia Protección', 'T9O001978'
UNION ALL
SELECT 52253501, 1.50000000000000000000, 'Colombia Protección', 'T9O002711'
UNION ALL
SELECT 52327763, 1.50000000000000000000, 'Colombia Protección', 'T9O002067'
UNION ALL
SELECT 52930869, 1.50000000000000000000, 'Colombia Protección', 'T9O002604'
UNION ALL
SELECT 52961052, 1.50000000000000000000, 'Colombia Protección', 'T9O003065'
UNION ALL
SELECT 5577128, 1.50000000000000000000, 'Colombia Protección', 'T9O002851'
UNION ALL
SELECT 65756505, 1.50000000000000000000, 'Colombia Protección', 'T9O002927'
UNION ALL
SELECT 66908071, 1.25000000000000000000, 'Colombia Protección', 'T9O002828'
UNION ALL
SELECT 67039590, 1.50000000000000000000, 'Colombia Protección', 'T9O002976'
UNION ALL
SELECT 70047140, 1.50000000000000000000, 'Colombia Protección', 'T9O001887'
UNION ALL
SELECT 70050050, 1.25000000000000000000, 'Colombia Protección', 'T9O001648'
UNION ALL
SELECT 70073062, 0.75000000000000000000, 'Colombia Protección', 'T9N001631'
UNION ALL
SELECT 70078031, 1.50000000000000000000, 'Colombia Protección', 'T9O002497'
UNION ALL
SELECT 70078622, 1.50000000000000000000, 'Colombia Protección', 'T9O003305'
UNION ALL
SELECT 70084412, 1.50000000000000000000, 'Colombia Protección', 'T9O001945'
UNION ALL
SELECT 70088161, 1.50000000000000000000, 'Colombia Protección', 'T9O001192'
UNION ALL
SELECT 70108265, 1.00000000000000000000, 'Colombia Protección', 'T9N001706'
UNION ALL
SELECT 70110696, 1.50000000000000000000, 'Colombia Protección', 'T9O002620'
UNION ALL
SELECT 70547303, 1.50000000000000000000, 'Colombia Protección', 'T9O003057'
UNION ALL
SELECT 70548472, 1.50000000000000000000, 'Colombia Protección', 'T9O001929'
UNION ALL
SELECT 70553220, 1.25000000000000000000, 'Colombia Protección', 'T9O001390'
UNION ALL
SELECT 70553661, 0.75000000000000000000, 'Colombia Protección', 'T9O001614'
UNION ALL
SELECT 70555842, 1.50000000000000000000, 'Colombia Protección', 'T9O002885'
UNION ALL
SELECT 70558091, 1.50000000000000000000, 'Colombia Protección', 'T9O001465'
UNION ALL
SELECT 70565698, 1.50000000000000000000, 'Colombia Protección', 'T9O002554'
UNION ALL
SELECT 70569522, 1.50000000000000000000, 'Colombia Protección', 'T9O003180'
UNION ALL
SELECT 70690050, 1.25000000000000000000, 'Colombia Protección', 'T9O001846'
UNION ALL
SELECT 71314452, 0.75000000000000000000, 'Colombia Protección', 'T9O003487'
UNION ALL
SELECT 71378377, 1.50000000000000000000, 'Colombia Protección', 'T9O001515'
UNION ALL
SELECT 71581571, 1.50000000000000000000, 'Colombia Protección', 'T9O003453'
UNION ALL
SELECT 71582184, 1.50000000000000000000, 'Colombia Protección', 'T9O002422'
UNION ALL
SELECT 71590666, 1.50000000000000000000, 'Colombia Protección', 'T9O002752'
UNION ALL
SELECT 71601302, 1.50000000000000000000, 'Colombia Protección', 'T9O003396'
UNION ALL
SELECT 71601846, 1.50000000000000000000, 'Colombia Protección', 'T9O001481'
UNION ALL
SELECT 71610115, 1.50000000000000000000, 'Colombia Protección', 'T9O002232'
UNION ALL
SELECT 71614465, 1.50000000000000000000, 'Colombia Protección', 'T9O002372'
UNION ALL
SELECT 71624537, 1.50000000000000000000, 'Colombia Protección', 'T9O001531'
UNION ALL
SELECT 71660105, 1.50000000000000000000, 'Colombia Protección', 'T9O002000'
UNION ALL
SELECT 71730270, 1.50000000000000000000, 'Colombia Protección', 'T9O003230'
UNION ALL
SELECT 71754485, 1.50000000000000000000, 'Colombia Protección', 'T9O003164'
UNION ALL
SELECT 71756033, 1.50000000000000000000, 'Colombia Protección', 'T9O003438'
UNION ALL
SELECT 71772027, 1.50000000000000000000, 'Colombia Protección', 'T9O002596'
UNION ALL
SELECT 71786079, 1.50000000000000000000, 'Colombia Protección', 'T9O001572'
UNION ALL
SELECT 71796747, 1.50000000000000000000, 'Colombia Protección', 'T9O002992'
UNION ALL
SELECT 75068780, 1.25000000000000000000, 'Colombia Protección', 'T9O002844'
UNION ALL
SELECT 7534308, 1.50000000000000000000, 'Colombia Protección', 'T9O002737'
UNION ALL
SELECT 79141359, 1.50000000000000000000, 'Colombia Protección', 'T9O001457'
UNION ALL
SELECT 79269584, 1.50000000000000000000, 'Colombia Protección', 'T9O002083'
UNION ALL
SELECT 79348420, 1.50000000000000000000, 'Colombia Protección', 'T9O003651'
UNION ALL
SELECT 79414237, 1.50000000000000000000, 'Colombia Protección', 'T9O002182'
UNION ALL
SELECT 79690698, 1.50000000000000000000, 'Colombia Protección', 'T9O002265'
UNION ALL
SELECT 79781218, 1.50000000000000000000, 'Colombia Protección', 'T9O002521'
UNION ALL
SELECT 79982116, 1.50000000000000000000, 'Colombia Protección', 'T9O002364'
UNION ALL
SELECT 80056807, 1.50000000000000000000, 'Colombia Protección', 'T9O003263'
UNION ALL
SELECT 80408493, 1.50000000000000000000, 'Colombia Protección', 'T9O002059'
UNION ALL
SELECT 80412997, 1.50000000000000000000, 'Colombia Protección', 'T9O001366'
UNION ALL
SELECT 80418652, 1.50000000000000000000, 'Colombia Protección', 'T9O001655'
UNION ALL
SELECT 80421565, 1.25000000000000000000, 'Colombia Protección', 'T9O001267'
UNION ALL
SELECT 8288660, 1.25000000000000000000, 'Colombia Protección', 'T9O001580'
UNION ALL
SELECT 8313904, 1.25000000000000000000, 'Colombia Protección', 'T9O002794'
UNION ALL
SELECT 8318613, 0.75000000000000000000, 'Colombia Protección', 'T9N001490'
UNION ALL
SELECT 8354081, 1.50000000000000000000, 'Colombia Protección', 'T9O003578'
UNION ALL
SELECT 9073723, 1.50000000000000000000, 'Colombia Protección', 'T9O002216'
UNION ALL
SELECT 9079945, 1.25000000000000000000, 'Colombia Protección', 'T9O002380'
UNION ALL
SELECT 91217078, 1.50000000000000000000, 'Colombia Protección', 'T9O003529'
UNION ALL
SELECT 93388223, 1.50000000000000000000, 'Colombia Protección', 'T9O002331'
UNION ALL
SELECT 98549660, 1.00000000000000000000, 'Colombia Protección', 'T9O001937'
UNION ALL
SELECT 98585356, 1.50000000000000000000, 'Colombia Protección', 'T9O002281'
UNION ALL
SELECT 98669418, 1.50000000000000000000, 'Colombia Protección', 'T9O001564'
) as fee_ria
ON cte.identificador=fee_ria.id_cliente::VARCHAR(100)
WHERE cte.fee IS NULL
and identificador in (
    select distinct client_id
    from public.vw_reporte_maestro_datos_saldos
    where process_date = '20250608'
    )
ORDER BY identificador
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



--========================================================================
--========================================================================
--========================================================================
--



