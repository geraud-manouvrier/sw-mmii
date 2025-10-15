--========================================================================
--========================================================================
--========================================================================
--Retorno métrica 1 día
--901751968
--PERSHING||T9O003206
--Pre cambio N1
SELECT * FROM rep_inv.fn_calcula_rentabilidad
('901751968', null, null, null, '20251014', '20251014') fn_rent
WHERE CASE WHEN true then true ELSE fn_rent.agregador_n1='901751968' and COALESCE(fn_rent.agregador_n2,'')=COALESCE(null,'') END
order by fn_rent.nivel, fn_rent.process_date, fn_rent.agregador_n1, fn_rent.agregador_n2, fn_rent.agregador_n3, fn_rent.agregador_n4
;
--Pre cambio N2
SELECT * FROM rep_inv.fn_calcula_rentabilidad
('901751968', 'PERSHING||T9O003206', null, null, '20251014', '20251014') fn_rent
WHERE CASE WHEN true then true ELSE fn_rent.agregador_n1='901751968' and COALESCE(fn_rent.agregador_n2,'')=COALESCE('PERSHING||T9O003206','') END
order by fn_rent.nivel, fn_rent.process_date, fn_rent.agregador_n1, fn_rent.agregador_n2, fn_rent.agregador_n3, fn_rent.agregador_n4
;


--Post cambio N1
SELECT * FROM rep_inv.fn_calcula_rentabilidad
('901751968', null, null, null, '20251014', '20251014') fn_rent
WHERE CASE WHEN true then true ELSE fn_rent.agregador_n1='901751968' and COALESCE(fn_rent.agregador_n2,'')=COALESCE(null,'') END
order by fn_rent.nivel, fn_rent.process_date, fn_rent.agregador_n1, fn_rent.agregador_n2, fn_rent.agregador_n3, fn_rent.agregador_n4
;
--Post cambio N2
SELECT * FROM rep_inv.fn_calcula_rentabilidad
('901751968', 'PERSHING||T9O003206', null, null, '20251014', '20251014') fn_rent
WHERE CASE WHEN true then true ELSE fn_rent.agregador_n1='901751968' and COALESCE(fn_rent.agregador_n2,'')=COALESCE('PERSHING||T9O003206','') END
order by fn_rent.nivel, fn_rent.process_date, fn_rent.agregador_n1, fn_rent.agregador_n2, fn_rent.agregador_n3, fn_rent.agregador_n4
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



