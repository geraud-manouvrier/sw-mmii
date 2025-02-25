create or replace function rep_inv.fn_control_agregadores_invalidos(_process_date character varying)
    returns TABLE(id_control integer, glosa_control character varying, descripcion_control character varying, process_date character varying, identificador character varying, cant_reg integer)
    language plpgsql
as
$$
DECLARE _id_control integer                     := 3;
DECLARE _glosa_control VARCHAR(1000)            := 'Agregadores no válidos';
DECLARE _descripcion_control_base VARCHAR(1000) := 'Campos de agregación con valores no válidos';
--Otras variables auxiliares
    BEGIN


    RETURN QUERY
        SELECT DISTINCT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||' (Saldos)')::VARCHAR(1000) as descripcion_control,
            tb_n1.process_date::VARCHAR(100),
            ('Client-ID:'||COALESCE(tb_n1.client_id, '')||'||Custodian:'||COALESCE(tb_n1.custodian, '')||'||Account:'||COALESCE(tb_n1.account_no, '')||'||Cusip:'||COALESCE(tb_n1.cusip, ''))::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
            from rep_inv.base_saldos_diarios tb_n1
            WHERE tb_n1.process_date=COALESCE(_process_date, tb_n1.process_date)
            AND (tb_n1.client_id IS NULL OR tb_n1.account_no IS NULL OR tb_n1.custodian IS NULL or tb_n1.cusip IS NULL)
            GROUP BY tb_n1.process_date,
                     ('Client-ID:'||COALESCE(tb_n1.client_id, '')||'||Custodian:'||COALESCE(tb_n1.custodian, '')||'||Account:'||COALESCE(tb_n1.account_no, '')||'||Cusip:'||COALESCE(tb_n1.cusip, ''))::VARCHAR(100)
            ORDER BY tb_n1.process_date,
                     ('Client-ID:'||COALESCE(tb_n1.client_id, '')||'||Custodian:'||COALESCE(tb_n1.custodian, '')||'||Account:'||COALESCE(tb_n1.account_no, '')||'||Cusip:'||COALESCE(tb_n1.cusip, ''))::VARCHAR(100)
    ;
    RETURN QUERY
        SELECT DISTINCT
            _id_control::int as id_control,
            _glosa_control as glosa_control,
            (_descripcion_control_base||' (Movimientos)')::VARCHAR(1000) as descripcion_control,
            tb_n1.process_date::VARCHAR(100),
            ('Client-ID:'||COALESCE(tb_n1.client_id, '')||'||Custodian:'||COALESCE(tb_n1.custodian, '')||'||Account:'||COALESCE(tb_n1.account_no, '')||'||Cusip:'||COALESCE(tb_n1.cusip, ''))::VARCHAR(100) as identificador,
            count(*)::integer as cant_reg
            from rep_inv.base_movimientos_diarios tb_n1
            WHERE tb_n1.process_date=COALESCE(_process_date, tb_n1.process_date)
            AND (tb_n1.client_id IS NULL OR tb_n1.account_no IS NULL OR tb_n1.custodian IS NULL or tb_n1.cusip IS NULL)
            GROUP BY tb_n1.process_date,
                     ('Client-ID:'||COALESCE(tb_n1.client_id, '')||'||Custodian:'||COALESCE(tb_n1.custodian, '')||'||Account:'||COALESCE(tb_n1.account_no, '')||'||Cusip:'||COALESCE(tb_n1.cusip, ''))::VARCHAR(100)
            ORDER BY tb_n1.process_date,
                     ('Client-ID:'||COALESCE(tb_n1.client_id, '')||'||Custodian:'||COALESCE(tb_n1.custodian, '')||'||Account:'||COALESCE(tb_n1.account_no, '')||'||Cusip:'||COALESCE(tb_n1.cusip, ''))::VARCHAR(100)

    ;

    RETURN;
    END;
$$;

alter function rep_inv.fn_control_agregadores_invalidos(varchar) owner to postgres;

