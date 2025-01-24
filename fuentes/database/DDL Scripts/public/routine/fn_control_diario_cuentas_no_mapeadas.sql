create or replace function public.fn_control_diario_cuentas_no_mapeadas(_process_date character varying)
    returns TABLE(id_control integer, glosa_control character varying, descripcion_control character varying, process_date character varying, identificador character varying, cant_reg integer)
    language plpgsql
as
$$

--Alerta de movimiento nuevo (nunca en la historia)
    BEGIN

    RETURN QUERY
        SELECT DISTINCT
            1 as id_control,
            'Cuentas no mapeadas'::VARCHAR(1000) as glosa_control,
            'Cuentas informadas por custodio, no agregadas en mantenedor enrolamiento'::VARCHAR(1000) as descripcion_control,
            CTA_NO_INF.process_date::VARCHAR(100),
            CTA_NO_INF.account_no::VARCHAR(100) as identificador,
            count(*)::int as cant_reg
            FROM
            (
                SELECT DISTINCT
                    ctas_no_map.process_date,
                    ctas_no_map.account_no
                FROM public.vw_cuentas_no_mapeadas_pershing ctas_no_map
                WHERE ctas_no_map.process_date=_process_date
            ) CTA_NO_INF
            GROUP BY CTA_NO_INF.process_date::VARCHAR(100), CTA_NO_INF.account_no::VARCHAR(100)
            ORDER BY CTA_NO_INF.process_date::VARCHAR(100), CTA_NO_INF.account_no::VARCHAR(100);
    RETURN;
    END;
$$;

alter function public.fn_control_diario_cuentas_no_mapeadas(varchar) owner to postgres;

