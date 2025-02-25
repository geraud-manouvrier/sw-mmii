create or replace function rep_inv.fn_lista_clientes_por_generar(_process_date character varying)
    returns TABLE(client_id character varying, process_date character varying)
    language plpgsql
as
$$
    DECLARE _start_process_date VARCHAR(100);
    DECLARE _end_process_date VARCHAR(100);
BEGIN


    _start_process_date := LEFT(_process_date,6)||'01';
    _end_process_date   := _process_date;

    DROP TABLE IF EXISTS temp_base_clientes;

    CREATE TEMP TABLE temp_base_clientes AS
        SELECT distinct vw_sld.client_id FROM public.vw_reporte_maestro_datos_saldos vw_sld
        WHERE vw_sld.process_date<=_process_date AND vw_sld.process_date>=_start_process_date;

    INSERT INTO temp_base_clientes (client_id)
    SELECT distinct vw_mov.client_id FROM public.vw_reporte_maestro_datos_movimientos vw_mov
    WHERE vw_mov.process_date<=_process_date AND vw_mov.process_date>=_start_process_date;

    RETURN QUERY
        SELECT DISTINCT tb_base.client_id::VARCHAR(100) as client_id, _process_date::VARCHAR(100) as process_date
        FROM temp_base_clientes tb_base
        ORDER BY tb_base.client_id
        ;

    -- Manejo de excepciones
    EXCEPTION
    WHEN OTHERS THEN
        RAISE EXCEPTION 'Error en fn_lista_clientes_por_generar para process date [%]: %', _process_date, SQLERRM;

END;
$$;

alter function rep_inv.fn_lista_clientes_por_generar(varchar) owner to postgres;

