create or replace function rep_inv.fn_control_saldo_dia_negativo(_process_date character varying)
    returns TABLE(id_control integer, glosa_control character varying, descripcion_control character varying, process_date character varying, identificador character varying, cant_reg integer)
    language plpgsql
as
$$
DECLARE _id_control integer                     := 2;
DECLARE _glosa_control VARCHAR(1000)            := 'Saldo Diario Negativo';
DECLARE _descripcion_control_base VARCHAR(1000) := 'Saldo del día actual o anterior negativo';
--Otras variables auxiliares
    BEGIN


    RETURN QUERY
        SELECT DISTINCT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            _descripcion_control_base as descripcion_control,
            tb_n1.process_date::VARCHAR(100),
            tb_n1.agregador_n1::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
            from rep_inv.consolidado_agregado_n1 tb_n1
            WHERE tb_n1.process_date=COALESCE(_process_date, tb_n1.process_date)
            AND (tb_n1.saldo_dia<0 OR tb_n1.saldo_dia_anterior<0)
            GROUP BY tb_n1.process_date, tb_n1.agregador_n1
            ORDER BY tb_n1.process_date, tb_n1.agregador_n1
    ;
    RETURN;
    END;
$$;

alter function rep_inv.fn_control_saldo_dia_negativo(varchar) owner to postgres;

