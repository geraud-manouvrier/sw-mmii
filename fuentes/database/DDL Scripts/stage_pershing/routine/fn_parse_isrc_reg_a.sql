create or replace function stage_pershing.fn_parse_isrc_reg_a(_id_proceso bigint) returns SETOF stage_pershing.stage_isrc_reg_a
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        transaction_code::VARCHAR(100),
        record_secuence_id::varchar(100),
        record_id_number::int,
        change_id::VARCHAR(100),
        source_code::VARCHAR(100),
        source_code_desc_line_1::VARCHAR(100),
        source_code_desc_line_2::VARCHAR(100),
        source_code_desc_line_3::VARCHAR(100),
        tax_status::VARCHAR(100),
        campo_10::VARCHAR(100),
        user_id::VARCHAR(100),
        date_added::VARCHAR(100),
        date_updated::VARCHAR(100),
        ira_income_eligible::VARCHAR(100),
        retail_income_eligible::VARCHAR(100),
        customer_firm::VARCHAR(100),
        cerdit_debit::VARCHAR(100),
        statement_ind::VARCHAR(100),
        statement_act_sum_ind::VARCHAR(100),
        statement_act_sum_number::VARCHAR(100),
        statement_trx_sum_ind::VARCHAR(100),
        statement_trx_sum_number::VARCHAR(100),
        statement_distrib_ind::VARCHAR(100),
        statement_distrib_number::VARCHAR(100),
        statement_distrib_tax_ind::VARCHAR(100),
        statement_div_ind::VARCHAR(100),
        statement_div_number::VARCHAR(100),
        statement_div_tax_ind::VARCHAR(100),
        pershing_depart::VARCHAR(100),
        pershing_grp::VARCHAR(100),
        campo_31::VARCHAR(100),
        user_id_added::VARCHAR(100),
        user_id_updated::VARCHAR(100),
        campo_34::VARCHAR(100),
        portfolio_eligible_ind::VARCHAR(100),
        reinvest_ind::VARCHAR(100),
        campo_37::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isrc_reg_a(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isrc_reg_a(bigint) owner to postgres;

