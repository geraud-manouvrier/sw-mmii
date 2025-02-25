create or replace function rep_inv.fn_calcula_rentabilidad_base100(_process_date_start character varying, _process_date_end character varying, _agregador_n1 character varying)
    returns TABLE(process_date character varying, agregador_n1 character varying, valor_dia numeric, valor_base_100 numeric, min_axis numeric, max_axis numeric)
    language plpgsql
as
$$
DECLARE
    --Limites y rangos
    _max_value NUMERIC(45,20);
    _min_value NUMERIC(45,20);
    _max_value_mult NUMERIC(45,20);
    _min_value_mult NUMERIC(45,20);
    _max_diff NUMERIC(45,20);
    _min_diff NUMERIC(45,20);
    _max_axis NUMERIC(45,20);
    _min_axis NUMERIC(45,20);

BEGIN

    IF (_process_date_start IS NULL) THEN
        _process_date_start := public.fn_fecha_date_to_string(
                                    rep_inv.fn_start_date_for_metric( public.fn_fecha_string_to_date(_process_date_end, 'YYYYMMDD'::character varying), '12M'),
                                    'YYYYMMDD', '');
        RAISE NOTICE 'Se ha calculado _process_date_start como [%] para _process_date_end [%]', _process_date_start, _process_date_end;
    end if;
    DROP TABLE IF EXISTS temp_rentabilidad;

    CREATE TEMP TABLE temp_rentabilidad AS
        SELECT
            tb_rent.process_date,
            tb_rent.agregador_n1,
            tb_rent.rentabilidad_base_pitatoria as valor_dia,
            public.prod(tb_rent.rentabilidad_base_pitatoria) OVER (PARTITION BY tb_rent.agregador_n1 ORDER BY tb_rent.process_date_as_date ASC)*100::NUMERIC(45,20) AS valor_base_100
        FROM rep_inv.consolidado_agregado_n1 tb_rent
        WHERE tb_rent.process_date >= _process_date_start AND tb_rent.process_date <= _process_date_end
        AND tb_rent.agregador_n1 = _agregador_n1
        ORDER BY tb_rent.process_date;

    RAISE NOTICE 'Datos cargados, iniciando cálculos...';


    RAISE NOTICE 'Cálculos de base generados, calculando min/max ejes...';

    SELECT
        min(tmp_tb.valor_base_100), max(tmp_tb.valor_base_100)
    INTO
        _min_value, _max_value
    FROM temp_rentabilidad tmp_tb;

    _min_value_mult := rep_inv.fn_redond_mult(_min_value, 5);
    _max_value_mult := rep_inv.fn_redond_mult(_max_value,5);

    _min_diff   := _min_value_mult - _min_value;
    _max_diff   := _max_value_mult - _max_value;

    _min_axis   :=  CASE WHEN (_min_diff>=0) then _min_value_mult - 5 else _min_value_mult END;
    _max_axis   :=  CASE WHEN (_max_diff<1) then _max_value_mult + 5 else _max_value_mult END;
    --Ajustamos para que no sea 100 el límite
    IF (_min_axis=100)
    THEN
        _min_axis := 95;
    END IF;
    IF (_max_axis=100)
    THEN
        _max_axis := 105;
    END IF;

    --RAISE NOTICE 'Mínimo [%], múltiplo [%], Diff [%], Axis [%]', _min_value, _min_value_mult, _min_diff, _min_axis;
    --RAISE NOTICE 'Máximo [%], múltiplo [%], Diff [%], Axis [%]', _max_value, _max_value_mult, _max_diff, _max_axis;

    RAISE NOTICE 'Devolviendo datos...';

    RETURN QUERY
        SELECT
            tb_out.process_date,
            tb_out.agregador_n1,
            tb_out.valor_dia,
            tb_out.valor_base_100,
            _min_axis as min_axis, _max_axis as max_axis
        FROM temp_rentabilidad tb_out
        ORDER BY tb_out.process_date ASC;

    -- Manejo de excepciones
    EXCEPTION
    WHEN OTHERS THEN
        RAISE EXCEPTION 'Error en calcular_rentabilidad_base100 para rango de process date [%-%] y agregador [%]: %', _process_date_start, _process_date_end, _agregador_n1,SQLERRM;

END;
$$;

alter function rep_inv.fn_calcula_rentabilidad_base100(varchar, varchar, varchar) owner to postgres;

