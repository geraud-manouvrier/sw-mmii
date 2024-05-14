create or replace function stage_pershing.fn_extrae_isrc_reg_a(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_secuence_id character varying, record_id_number character varying, change_id character varying, source_code character varying, source_code_desc_line_1 character varying, source_code_desc_line_2 character varying, source_code_desc_line_3 character varying, tax_status character varying, campo_10 character varying, user_id character varying, date_added character varying, date_updated character varying, ira_income_eligible character varying, retail_income_eligible character varying, customer_firm character varying, cerdit_debit character varying, statement_ind character varying, statement_act_sum_ind character varying, statement_act_sum_number character varying, statement_trx_sum_ind character varying, statement_trx_sum_number character varying, statement_distrib_ind character varying, statement_distrib_number character varying, statement_distrib_tax_ind character varying, statement_div_ind character varying, statement_div_number character varying, statement_div_tax_ind character varying, pershing_depart character varying, pershing_grp character varying, campo_31 character varying, user_id_added character varying, user_id_updated character varying, campo_34 character varying, portfolio_eligible_ind character varying, reinvest_ind character varying, campo_37 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_secuence_id,
        substr(sfl_file.linea, 4, 6)::VARCHAR(100) as record_id_number,
        substr(sfl_file.linea, 10, 1)::VARCHAR(100) as change_id,
        substr(sfl_file.linea, 11, 3)::VARCHAR(100) as source_code,
        substr(sfl_file.linea, 14, 26)::VARCHAR(100) as source_code_desc_line_1,
        substr(sfl_file.linea, 40, 26)::VARCHAR(100) as source_code_desc_line_2,
        substr(sfl_file.linea, 66, 26)::VARCHAR(100) as source_code_desc_line_3,
        substr(sfl_file.linea, 92, 3)::VARCHAR(100) as tax_status,
        substr(sfl_file.linea, 95, 3)::VARCHAR(100) as campo_10,
        substr(sfl_file.linea, 98, 8)::VARCHAR(100) as user_id,
        substr(sfl_file.linea, 106, 8)::VARCHAR(100) as date_added,
        substr(sfl_file.linea, 114, 8)::VARCHAR(100) as date_updated,
        substr(sfl_file.linea, 122, 1)::VARCHAR(100) as ira_income_eligible,
        substr(sfl_file.linea, 123, 1)::VARCHAR(100) as retail_income_eligible,
        substr(sfl_file.linea, 124, 1)::VARCHAR(100) as customer_firm,
        substr(sfl_file.linea, 125, 1)::VARCHAR(100) as cerdit_debit,
        substr(sfl_file.linea, 126, 4)::VARCHAR(100) as statement_ind,
        substr(sfl_file.linea, 130, 4)::VARCHAR(100) as statement_act_sum_ind,
        substr(sfl_file.linea, 134, 2)::VARCHAR(100) as statement_act_sum_number,
        substr(sfl_file.linea, 136, 4)::VARCHAR(100) as statement_trx_sum_ind,
        substr(sfl_file.linea, 140, 2)::VARCHAR(100) as statement_trx_sum_number,
        substr(sfl_file.linea, 142, 4)::VARCHAR(100) as statement_distrib_ind,
        substr(sfl_file.linea, 146, 2)::VARCHAR(100) as statement_distrib_number,
        substr(sfl_file.linea, 148, 1)::VARCHAR(100) as statement_distrib_tax_ind,
        substr(sfl_file.linea, 149, 4)::VARCHAR(100) as statement_div_ind,
        substr(sfl_file.linea, 153, 2)::VARCHAR(100) as statement_div_number,
        substr(sfl_file.linea, 155, 1)::VARCHAR(100) as statement_div_tax_ind,
        substr(sfl_file.linea, 156, 3)::VARCHAR(100) as pershing_depart,
        substr(sfl_file.linea, 159, 22)::VARCHAR(100) as pershing_grp,
        substr(sfl_file.linea, 181, 40)::VARCHAR(100) as campo_31,
        substr(sfl_file.linea, 221, 8)::VARCHAR(100) as user_id_added,
        substr(sfl_file.linea, 229, 8)::VARCHAR(100) as user_id_updated,
        substr(sfl_file.linea, 237, 3)::VARCHAR(100) as campo_34,
        substr(sfl_file.linea, 240, 1)::VARCHAR(100) as portfolio_eligible_ind,
        substr(sfl_file.linea, 241, 1)::VARCHAR(100) as reinvest_ind,
        substr(sfl_file.linea, 242, 8)::VARCHAR(100) as campo_37,
        substr(sfl_file.linea, 250, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isrc_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 3)		= 'SRA'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isrc_reg_a(bigint) owner to postgres;

