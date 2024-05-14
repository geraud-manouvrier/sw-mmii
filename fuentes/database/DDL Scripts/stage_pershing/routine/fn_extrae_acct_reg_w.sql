create or replace function stage_pershing.fn_extrae_acct_reg_w(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, ibd_number character varying, campo_6 character varying, ip_number character varying, account_short_name character varying, campo_9 character varying, record_transaction_code character varying, non_us_dollar_trading character varying, base_currency character varying, income_currency character varying, statement_language character varying, statement_format_code character varying, msrb_statement_ind character varying, campo_17 character varying, pep character varying, first_name_pep character varying, last_name_pep character varying, suffix_pep character varying, political_office_held character varying, country_of_office character varying, foreign_bank_account_ind character varying, foreign_bank_cert_date character varying, foreign_bank_cert_exp_date character varying, central_bank_ind character varying, acct_foreign_financial_inst character varying, foreign_bank_acct_oper_1 character varying, foreign_bank_acct_oper_2 character varying, foreign_bank_acct_oper_3 character varying, number_people_own character varying, proprietary_acct_owned character varying, campo_34 character varying, tel_1_transaction_code character varying, tel_1_us_ind character varying, tel_1_type_id character varying, tel_1_number character varying, tel_1_extension character varying, tel_2_transaction_code character varying, tel_2_us_ind character varying, tel_2_type_id character varying, tel_2_number character varying, tel_2_extension character varying, tel_3_transaction_code character varying, tel_3_us_ind character varying, tel_3_type_id character varying, tel_3_number character varying, tel_3_extension character varying, tel_4_transaction_code character varying, tel_4_us_ind character varying, tel_4_type_id character varying, tel_4_number character varying, tel_4_extension character varying, tel_5_transaction_code character varying, tel_5_us_ind character varying, tel_5_type_id character varying, tel_5_number character varying, tel_5_extension character varying, tel_6_transaction_code character varying, tel_6_us_ind character varying, tel_6_type_id character varying, tel_6_number character varying, tel_6_extension character varying, tel_7_transaction_code character varying, tel_7_us_ind character varying, tel_7_type_id character varying, tel_7_number character varying, tel_7_extension character varying, tel_8_transaction_code character varying, tel_8_us_ind character varying, tel_8_type_id character varying, tel_8_number character varying, tel_8_extension character varying, email_address character varying, external_position_ind character varying, purge_eligible_ind character varying, advisory_acct_ind character varying, product_profile_code character varying, cents_per_share_discount character varying, campo_81 character varying, option_disclosure_date character varying, campo_83 character varying, country_acct_level_tax_residency character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 9)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 21, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 24, 1)::VARCHAR(100) as campo_6,
        substr(sfl_file.linea, 25, 4)::VARCHAR(100) as ip_number,
        substr(sfl_file.linea, 29, 10)::VARCHAR(100) as account_short_name,
        substr(sfl_file.linea, 39, 2)::VARCHAR(100) as campo_9,
        substr(sfl_file.linea, 41, 1)::VARCHAR(100) as record_transaction_code,
        substr(sfl_file.linea, 42, 1)::VARCHAR(100) as non_us_dollar_trading,
        substr(sfl_file.linea, 43, 3)::VARCHAR(100) as base_currency,
        substr(sfl_file.linea, 46, 3)::VARCHAR(100) as income_currency,
        substr(sfl_file.linea, 49, 3)::VARCHAR(100) as statement_language,
        substr(sfl_file.linea, 52, 3)::VARCHAR(100) as statement_format_code,
        substr(sfl_file.linea, 55, 1)::VARCHAR(100) as msrb_statement_ind,
        substr(sfl_file.linea, 56, 6)::VARCHAR(100) as campo_17,
        substr(sfl_file.linea, 62, 1)::VARCHAR(100) as pep,
        substr(sfl_file.linea, 63, 25)::VARCHAR(100) as first_name_pep,
        substr(sfl_file.linea, 88, 25)::VARCHAR(100) as last_name_pep,
        substr(sfl_file.linea, 113, 4)::VARCHAR(100) as suffix_pep,
        substr(sfl_file.linea, 117, 35)::VARCHAR(100) as political_office_held,
        substr(sfl_file.linea, 152, 2)::VARCHAR(100) as country_of_office,
        substr(sfl_file.linea, 154, 1)::VARCHAR(100) as foreign_bank_account_ind,
        substr(sfl_file.linea, 155, 8)::VARCHAR(100) as foreign_bank_cert_date,
        substr(sfl_file.linea, 163, 8)::VARCHAR(100) as foreign_bank_cert_exp_date,
        substr(sfl_file.linea, 171, 1)::VARCHAR(100) as central_bank_ind,
        substr(sfl_file.linea, 172, 1)::VARCHAR(100) as acct_foreign_financial_inst,
        substr(sfl_file.linea, 173, 1)::VARCHAR(100) as foreign_bank_acct_oper_1,
        substr(sfl_file.linea, 174, 1)::VARCHAR(100) as foreign_bank_acct_oper_2,
        substr(sfl_file.linea, 175, 1)::VARCHAR(100) as foreign_bank_acct_oper_3,
        substr(sfl_file.linea, 176, 2)::VARCHAR(100) as number_people_own,
        substr(sfl_file.linea, 178, 1)::VARCHAR(100) as proprietary_acct_owned,
        substr(sfl_file.linea, 179, 3)::VARCHAR(100) as campo_34,
        substr(sfl_file.linea, 182, 1)::VARCHAR(100) as tel_1_transaction_code,
        substr(sfl_file.linea, 183, 1)::VARCHAR(100) as tel_1_us_ind,
        substr(sfl_file.linea, 184, 1)::VARCHAR(100) as tel_1_type_id,
        substr(sfl_file.linea, 185, 48)::VARCHAR(100) as tel_1_number,
        substr(sfl_file.linea, 233, 7)::VARCHAR(100) as tel_1_extension,
        substr(sfl_file.linea, 240, 1)::VARCHAR(100) as tel_2_transaction_code,
        substr(sfl_file.linea, 241, 1)::VARCHAR(100) as tel_2_us_ind,
        substr(sfl_file.linea, 242, 1)::VARCHAR(100) as tel_2_type_id,
        substr(sfl_file.linea, 243, 48)::VARCHAR(100) as tel_2_number,
        substr(sfl_file.linea, 291, 7)::VARCHAR(100) as tel_2_extension,
        substr(sfl_file.linea, 298, 1)::VARCHAR(100) as tel_3_transaction_code,
        substr(sfl_file.linea, 299, 1)::VARCHAR(100) as tel_3_us_ind,
        substr(sfl_file.linea, 300, 1)::VARCHAR(100) as tel_3_type_id,
        substr(sfl_file.linea, 301, 48)::VARCHAR(100) as tel_3_number,
        substr(sfl_file.linea, 349, 7)::VARCHAR(100) as tel_3_extension,
        substr(sfl_file.linea, 356, 1)::VARCHAR(100) as tel_4_transaction_code,
        substr(sfl_file.linea, 357, 1)::VARCHAR(100) as tel_4_us_ind,
        substr(sfl_file.linea, 358, 1)::VARCHAR(100) as tel_4_type_id,
        substr(sfl_file.linea, 359, 48)::VARCHAR(100) as tel_4_number,
        substr(sfl_file.linea, 407, 7)::VARCHAR(100) as tel_4_extension,
        substr(sfl_file.linea, 414, 1)::VARCHAR(100) as tel_5_transaction_code,
        substr(sfl_file.linea, 415, 1)::VARCHAR(100) as tel_5_us_ind,
        substr(sfl_file.linea, 416, 1)::VARCHAR(100) as tel_5_type_id,
        substr(sfl_file.linea, 417, 48)::VARCHAR(100) as tel_5_number,
        substr(sfl_file.linea, 465, 7)::VARCHAR(100) as tel_5_extension,
        substr(sfl_file.linea, 472, 1)::VARCHAR(100) as tel_6_transaction_code,
        substr(sfl_file.linea, 473, 1)::VARCHAR(100) as tel_6_us_ind,
        substr(sfl_file.linea, 474, 1)::VARCHAR(100) as tel_6_type_id,
        substr(sfl_file.linea, 475, 48)::VARCHAR(100) as tel_6_number,
        substr(sfl_file.linea, 523, 7)::VARCHAR(100) as tel_6_extension,
        substr(sfl_file.linea, 530, 1)::VARCHAR(100) as tel_7_transaction_code,
        substr(sfl_file.linea, 531, 1)::VARCHAR(100) as tel_7_us_ind,
        substr(sfl_file.linea, 532, 1)::VARCHAR(100) as tel_7_type_id,
        substr(sfl_file.linea, 533, 48)::VARCHAR(100) as tel_7_number,
        substr(sfl_file.linea, 581, 7)::VARCHAR(100) as tel_7_extension,
        substr(sfl_file.linea, 588, 1)::VARCHAR(100) as tel_8_transaction_code,
        substr(sfl_file.linea, 589, 1)::VARCHAR(100) as tel_8_us_ind,
        substr(sfl_file.linea, 590, 1)::VARCHAR(100) as tel_8_type_id,
        substr(sfl_file.linea, 591, 48)::VARCHAR(100) as tel_8_number,
        substr(sfl_file.linea, 639, 7)::VARCHAR(100) as tel_8_extension,
        substr(sfl_file.linea, 646, 50)::VARCHAR(100) as email_address,
        substr(sfl_file.linea, 696, 1)::VARCHAR(100) as external_position_ind,
        substr(sfl_file.linea, 697, 1)::VARCHAR(100) as purge_eligible_ind,
        substr(sfl_file.linea, 698, 1)::VARCHAR(100) as advisory_acct_ind,
        substr(sfl_file.linea, 699, 4)::VARCHAR(100) as product_profile_code,
        substr(sfl_file.linea, 703, 2)::VARCHAR(100) as cents_per_share_discount,
        substr(sfl_file.linea, 705, 10)::VARCHAR(100) as campo_81,
        substr(sfl_file.linea, 715, 8)::VARCHAR(100) as option_disclosure_date,
        substr(sfl_file.linea, 723, 23)::VARCHAR(100) as campo_83,
        substr(sfl_file.linea, 746, 4)::VARCHAR(100) as country_acct_level_tax_residency,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CIW'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_acct_reg_w(bigint) owner to postgres;

