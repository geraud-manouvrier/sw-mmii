create or replace procedure pershing.pa_procesa_isrc(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
DECLARE _row_count  BIGINT;
begin

    DELETE FROM pershing.sfl_isrc tb_sfl WHERE tb_sfl.process_date= (SELECT tb_proc.process_date FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso);

    INSERT INTO pershing.sfl_isrc (id_proceso, process_date, record_secuence_id, record_id_number, change_id, source_code, source_code_desc_line_1, source_code_desc_line_2, source_code_desc_line_3, tax_status, user_id, date_added, date_updated, ira_income_eligible, retail_income_eligible, customer_firm, cerdit_debit, statement_ind, statement_act_sum_ind, statement_act_sum_number, statement_trx_sum_ind, statement_trx_sum_number, statement_distrib_ind, statement_distrib_number, statement_distrib_tax_ind, statement_div_ind, statement_div_number, statement_div_tax_ind, pershing_depart, pershing_grp, user_id_added, user_id_updated, portfolio_eligible_ind, reinvest_ind)
    SELECT
        reg_header.id_proceso, reg_header.process_date, record_secuence_id, record_id_number, change_id, source_code, source_code_desc_line_1, source_code_desc_line_2, source_code_desc_line_3, tax_status, user_id, date_added, date_updated, ira_income_eligible, retail_income_eligible, customer_firm, cerdit_debit, statement_ind, statement_act_sum_ind, statement_act_sum_number, statement_trx_sum_ind, statement_trx_sum_number, statement_distrib_ind, statement_distrib_number, statement_distrib_tax_ind, statement_div_ind, statement_div_number, statement_div_tax_ind, pershing_depart, pershing_grp, user_id_added, user_id_updated, portfolio_eligible_ind, reinvest_ind
    FROM stage_pershing.stage_isrc_reg_header reg_header
    INNER JOIN stage_pershing.stage_isrc_reg_trailer reg_trailer
    ON reg_header.id_proceso=reg_trailer.id_proceso
    INNER JOIN stage_pershing.stage_isrc_reg_a reg_a
    ON reg_header.id_proceso=reg_a.id_proceso
    WHERE reg_header.id_proceso=_id_proceso
    ;

    GET DIAGNOSTICS _row_count = ROW_COUNT;
    IF(FOUND) THEN
        TRUNCATE TABLE pershing.sfl_isrc_actual;
        
        INSERT INTO pershing.sfl_isrc_actual (id_proceso, process_date, record_secuence_id, record_id_number, change_id, source_code, source_code_desc_line_1, source_code_desc_line_2, source_code_desc_line_3, tax_status, user_id, date_added, date_updated, ira_income_eligible, retail_income_eligible, customer_firm, cerdit_debit, statement_ind, statement_act_sum_ind, statement_act_sum_number, statement_trx_sum_ind, statement_trx_sum_number, statement_distrib_ind, statement_distrib_number, statement_distrib_tax_ind, statement_div_ind, statement_div_number, statement_div_tax_ind, pershing_depart, pershing_grp, user_id_added, user_id_updated, portfolio_eligible_ind, reinvest_ind)
        SELECT
            isrc_his.id_proceso, isrc_his.process_date, isrc_his.record_secuence_id, isrc_his.record_id_number, isrc_his.change_id, isrc_his.source_code, isrc_his.source_code_desc_line_1, isrc_his.source_code_desc_line_2, isrc_his.source_code_desc_line_3, isrc_his.tax_status, isrc_his.user_id, isrc_his.date_added, isrc_his.date_updated, isrc_his.ira_income_eligible, isrc_his.retail_income_eligible, isrc_his.customer_firm, isrc_his.cerdit_debit, isrc_his.statement_ind, isrc_his.statement_act_sum_ind, isrc_his.statement_act_sum_number, isrc_his.statement_trx_sum_ind, isrc_his.statement_trx_sum_number, isrc_his.statement_distrib_ind, isrc_his.statement_distrib_number, isrc_his.statement_distrib_tax_ind, isrc_his.statement_div_ind, isrc_his.statement_div_number, isrc_his.statement_div_tax_ind, isrc_his.pershing_depart, isrc_his.pershing_grp, isrc_his.user_id_added, isrc_his.user_id_updated, isrc_his.portfolio_eligible_ind, isrc_his.reinvest_ind
        FROM pershing.sfl_isrc isrc_his WHERE isrc_his.id_proceso=_id_proceso
        ;
    END IF;
end;
$$;

alter procedure pershing.pa_procesa_isrc(bigint) owner to postgres;

