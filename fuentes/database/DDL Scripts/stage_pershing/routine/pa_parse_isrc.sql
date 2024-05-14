create or replace procedure stage_pershing.pa_parse_isrc(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
begin

    DELETE FROM stage_pershing.stage_isrc_reg_header reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isrc_reg_a reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isrc_reg_trailer reg_del WHERE reg_del.id_proceso=_id_proceso;

    INSERT INTO stage_pershing.stage_isrc_reg_header (id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, eor)
    SELECT id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, eor
    FROM stage_pershing.fn_parse_isrc_reg_header(_id_proceso);

    INSERT INTO stage_pershing.stage_isrc_reg_a (id_proceso, process_date, transaction_code, record_secuence_id, record_id_number, change_id, source_code, source_code_desc_line_1, source_code_desc_line_2, source_code_desc_line_3, tax_status, campo_10, user_id, date_added, date_updated, ira_income_eligible, retail_income_eligible, customer_firm, cerdit_debit, statement_ind, statement_act_sum_ind, statement_act_sum_number, statement_trx_sum_ind, statement_trx_sum_number, statement_distrib_ind, statement_distrib_number, statement_distrib_tax_ind, statement_div_ind, statement_div_number, statement_div_tax_ind, pershing_depart, pershing_grp, campo_31, user_id_added, user_id_updated, campo_34, portfolio_eligible_ind, reinvest_ind, campo_37, eor)
    SELECT id_proceso, process_date, transaction_code, record_secuence_id, record_id_number, change_id, source_code, source_code_desc_line_1, source_code_desc_line_2, source_code_desc_line_3, tax_status, campo_10, user_id, date_added, date_updated, ira_income_eligible, retail_income_eligible, customer_firm, cerdit_debit, statement_ind, statement_act_sum_ind, statement_act_sum_number, statement_trx_sum_ind, statement_trx_sum_number, statement_distrib_ind, statement_distrib_number, statement_distrib_tax_ind, statement_div_ind, statement_div_number, statement_div_tax_ind, pershing_depart, pershing_grp, campo_31, user_id_added, user_id_updated, campo_34, portfolio_eligible_ind, reinvest_ind, campo_37, eor
    FROM stage_pershing.fn_parse_isrc_reg_a(_id_proceso);

    INSERT INTO stage_pershing.stage_isrc_reg_trailer (id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, campo_8, number_of_records, campo_10, eor)
    SELECT id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, campo_8, number_of_records, campo_10, eor
    FROM stage_pershing.fn_parse_isrc_reg_trailer(_id_proceso);

end;
$$;

alter procedure stage_pershing.pa_parse_isrc(bigint) owner to postgres;

