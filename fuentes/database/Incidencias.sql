--========================================================================
--========================================================================
--========================================================================
-- Retornos id cliente: 71597710    Cta. T9O003990
--'PERSHING||T9O003990'
--
select * from public.tbvw_maestro_saldos_pershing tb_sld
where client_id ='71597710' or account_no='T9O003990'
;

select * from rep_inv.consolidado_agregado_n1 where agregador_n1='71597710';
select * from rep_inv.consolidado_agregado_n2 where agregador_n1='71597710';
--Join de ambas por processd date y agregador n1
SELECT * FROM rep_inv.consolidado_agregado_n1 n1
INNER JOIN rep_inv.consolidado_agregado_n2 n2
    ON n1.process_date=n2.process_date
    AND n1.agregador_n1=n2.agregador_n1
WHERE n1.agregador_n1='71597710';
;

 SELECT
        'N2'::VARCHAR(100) as nivel,
        rank() OVER (ORDER BY tbn.process_date, tbn.agregador_n1, tbn.agregador_n2)::BIGINT as sub_nivel,
        tbn.process_date, tbn.process_date_as_date,
        tbn.agregador_n1, tbn.agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4,
        tbn.saldo_dia_anterior, tbn.abonos_dia, tbn.retiros_dia, tbn.dividendos_dia, tbn.saldo_dia,
        tbn.comision_devengada_dia,
        tbn.utilidad, tbn.rentabilidad, tbn.rentabilidad_base_pitatoria, tbn.saldo_rentabilidad
    FROM rep_inv.consolidado_agregado_n2 tbn
    WHERE tbn.agregador_n1=COALESCE('71597710', tbn.agregador_n1) AND tbn.agregador_n2=COALESCE(null, tbn.agregador_n2)
    AND tbn.process_date>='20260630' AND tbn.process_date<='20260630'
 ;

--RetN1
SELECT * FROM rep_inv.fn_calcula_rentabilidad
('71597710', NULL, null, null, '20260630', '20260630') fn_rent
WHERE CASE WHEN true then true ELSE fn_rent.agregador_n1='71597710' and COALESCE(fn_rent.agregador_n2,'')=COALESCE(NULL,'') END
order by fn_rent.nivel, fn_rent.process_date, fn_rent.agregador_n1, fn_rent.agregador_n2, fn_rent.agregador_n3, fn_rent.agregador_n4
;
--RetN2
SELECT * FROM rep_inv.fn_calcula_rentabilidad
('71597710', 'PERSHING||T9O003990', null, null, '20260630', '20260630') fn_rent
WHERE CASE WHEN true then true ELSE fn_rent.agregador_n1='71597710' and COALESCE(fn_rent.agregador_n2,'')=COALESCE('PERSHING||T9O003990','') END
order by fn_rent.nivel, fn_rent.process_date, fn_rent.agregador_n1, fn_rent.agregador_n2, fn_rent.agregador_n3, fn_rent.agregador_n4
;

--RetAgrN1
SELECT * FROM rep_inv.fn_calculo_rentabilidad_agregada('2026-06-01', '2026-06-30', '71597710', null, null, null);
--RetAgrN2
SELECT * FROM rep_inv.fn_calculo_rentabilidad_agregada('2026-06-01', '2026-06-30', '71597710', 'PERSHING||T9O003990', null, null);

/*
base3_rentabilidad
0.00055936605584806809  --Cte       0.00055936605584806809
0.00111904500208057121  --Cta       0.00111904500208057121

-> Hay diferencias en fn_calculo_rentabilidad_agregada
*/

SELECT
    tbn.process_date_as_date, tbn.saldo_dia_anterior, tbn.saldo_rentabilidad, tbn.rentabilidad_base_pitatoria,
    tbn.agregador_n1, NULL::VARCHAR(100) as agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4
FROM rep_inv.consolidado_agregado_n1 tbn
WHERE tbn.agregador_n1= '71597710'
AND tbn.process_date_as_date>='2026-06-01'
AND tbn.process_date_as_date<='2026-06-30'
UNION ALL
SELECT
    tbn.process_date_as_date, tbn.saldo_dia_anterior, tbn.saldo_rentabilidad, tbn.rentabilidad_base_pitatoria,
    tbn.agregador_n1, NULL::VARCHAR(100) as agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4
FROM rep_inv.consolidado_agregado_n2 tbn
WHERE tbn.agregador_n1= '71597710' AND tbn.agregador_n2= null
AND tbn.process_date_as_date>='2026-06-01'
AND tbn.process_date_as_date<='2026-06-30'
;

SELECT
    tbn.process_date_as_date, tbn.saldo_dia_anterior, tbn.saldo_rentabilidad, tbn.rentabilidad_base_pitatoria,
    tbn.agregador_n1, NULL::VARCHAR(100) as agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4
FROM rep_inv.consolidado_agregado_n1 tbn
WHERE tbn.agregador_n1= '71597710'
AND tbn.process_date_as_date>='2026-06-01'
AND tbn.process_date_as_date<='2026-06-30'
UNION ALL
SELECT
    tbn.process_date_as_date, tbn.saldo_dia_anterior, tbn.saldo_rentabilidad, tbn.rentabilidad_base_pitatoria,
    tbn.agregador_n1, NULL::VARCHAR(100) as agregador_n2, NULL::VARCHAR(100) as agregador_n3, NULL::VARCHAR(100) as agregador_n4
FROM rep_inv.consolidado_agregado_n2 tbn
WHERE tbn.agregador_n1= '71597710' AND tbn.agregador_n2= 'PERSHING||T9O003990'
AND tbn.process_date_as_date>='2026-06-01'
AND tbn.process_date_as_date<='2026-06-30'
;

-- Pre UNION
--En ambas ejecuciones, N1 son iguales
--En segunda ejecución, la primera no devuelv eregistros para N2 (correcto) y si devuelve para la segunda (correcto)

--POST UNION



select * from rep_inv.consolidado_agregado_n2 where agregador_n1='71597710';

--TODO: Rutina estaría mala ya que el agregador n2 lo deja en null al calcular, por lo que se mezcla con N1

--RetN1: Qued aok en valores, pero ducĺica registro de cuenta (nod el cliente), dando 3 filas
    -- Ojo con filtro por "todos los nvieles"
--RetAgrN1 igual que antres -> ok
--RetAgrN2 agrega una fila más de la cuenta -> ok, comportamiento esperado: ver impacto en otra función fn_calcula_rentabilidad (app no la llama directo)

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



