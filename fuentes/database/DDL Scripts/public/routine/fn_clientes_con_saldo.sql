create or replace function public.fn_clientes_con_saldo(_in_optional_process_date character varying)
    returns TABLE(client_id character varying, custodian character varying, account_no character varying)
    language sql
as
$$

    SELECT DISTINCT vw_sld.client_id, upper(vw_sld.custodian)::VARCHAR(100), vw_sld.account_no
    FROM public.vw_reporte_maestro_datos_saldos vw_sld
    WHERE vw_sld.process_date = COALESCE(_in_optional_process_date, public.get_max_process_date())
    ;
$$;

alter function public.fn_clientes_con_saldo(varchar) owner to postgres;

