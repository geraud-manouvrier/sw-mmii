create or replace function stage_pershing.fn_extrae_acct_reg_c(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, ibd_number character varying, campo_6 character varying, ip_number character varying, account_short_name character varying, campo_9 character varying, addr_1_trx_code character varying, addr_1_special_handling_ind character varying, addr_1_delivery_id character varying, addr_1_attention_line_prefix character varying, addr_1_attention_line_detail character varying, addr_1_line_1 character varying, addr_1_line_2 character varying, addr_1_line_3 character varying, addr_1_line_4 character varying, addr_1_city_state character varying, addr_1_country_code character varying, campo_21 character varying, campo_22 character varying, campo_23 character varying, campo_24 character varying, campo_25 character varying, campo_26 character varying, campo_27 character varying, campo_28 character varying, campo_29 character varying, campo_30 character varying, addr_2_trx_code character varying, addr_2_special_handling_ind character varying, addr_2_delivery_id character varying, addr_2_attention_line_prefix character varying, addr_2_attention_line_detail character varying, addr_2_line_1 character varying, addr_2_line_2 character varying, addr_2_line_3 character varying, addr_2_line_4 character varying, addr_2_city_state character varying, addr_2_country_code character varying, account_description character varying, set_as_mail_addr_2_ind character varying, campo_44 character varying, principal_billing_allocation_pct character varying, campo_46 character varying, seasonal_addr_id_1 character varying, from_date_1 character varying, to_date_1 character varying, seasonal_addr_id_2 character varying, from_date_2 character varying, to_date_2 character varying, seasonal_addr_id_3 character varying, from_date_3 character varying, to_date_3 character varying, cost_basis_acct_system character varying, disposition_method_mutual_funds character varying, disposition_method_other character varying, disposition_method_stocks character varying, campo_60 character varying, amortize_taxable_premium_bonds character varying, accrue_market_disc_based_on character varying, accrue_market_disc_income character varying, campo_64 character varying, campo_65 character varying, campo_66 character varying, eor character varying)
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
        substr(sfl_file.linea, 41, 1)::VARCHAR(100) as addr_1_trx_code,
        substr(sfl_file.linea, 42, 1)::VARCHAR(100) as addr_1_special_handling_ind,
        substr(sfl_file.linea, 43, 1)::VARCHAR(100) as addr_1_delivery_id,
        substr(sfl_file.linea, 44, 4)::VARCHAR(100) as addr_1_attention_line_prefix,
        substr(sfl_file.linea, 48, 28)::VARCHAR(100) as addr_1_attention_line_detail,
        substr(sfl_file.linea, 76, 32)::VARCHAR(100) as addr_1_line_1,
        substr(sfl_file.linea, 108, 32)::VARCHAR(100) as addr_1_line_2,
        substr(sfl_file.linea, 140, 32)::VARCHAR(100) as addr_1_line_3,
        substr(sfl_file.linea, 172, 32)::VARCHAR(100) as addr_1_line_4,
        substr(sfl_file.linea, 204, 32)::VARCHAR(100) as addr_1_city_state,
        substr(sfl_file.linea, 236, 2)::VARCHAR(100) as addr_1_country_code,
        substr(sfl_file.linea, 238, 1)::VARCHAR(100) as campo_21,
        substr(sfl_file.linea, 239, 8)::VARCHAR(100) as campo_22,
        substr(sfl_file.linea, 247, 21)::VARCHAR(100) as campo_23,
        substr(sfl_file.linea, 268, 4)::VARCHAR(100) as campo_24,
        substr(sfl_file.linea, 272, 8)::VARCHAR(100) as campo_25,
        substr(sfl_file.linea, 280, 21)::VARCHAR(100) as campo_26,
        substr(sfl_file.linea, 301, 4)::VARCHAR(100) as campo_27,
        substr(sfl_file.linea, 305, 8)::VARCHAR(100) as campo_28,
        substr(sfl_file.linea, 313, 21)::VARCHAR(100) as campo_29,
        substr(sfl_file.linea, 334, 4)::VARCHAR(100) as campo_30,
        substr(sfl_file.linea, 338, 1)::VARCHAR(100) as addr_2_trx_code,
        substr(sfl_file.linea, 339, 1)::VARCHAR(100) as addr_2_special_handling_ind,
        substr(sfl_file.linea, 340, 1)::VARCHAR(100) as addr_2_delivery_id,
        substr(sfl_file.linea, 341, 4)::VARCHAR(100) as addr_2_attention_line_prefix,
        substr(sfl_file.linea, 345, 28)::VARCHAR(100) as addr_2_attention_line_detail,
        substr(sfl_file.linea, 373, 32)::VARCHAR(100) as addr_2_line_1,
        substr(sfl_file.linea, 405, 32)::VARCHAR(100) as addr_2_line_2,
        substr(sfl_file.linea, 437, 50)::VARCHAR(100) as addr_2_line_3,
        substr(sfl_file.linea, 487, 14)::VARCHAR(100) as addr_2_line_4,
        substr(sfl_file.linea, 501, 32)::VARCHAR(100) as addr_2_city_state,
        substr(sfl_file.linea, 533, 2)::VARCHAR(100) as addr_2_country_code,
        substr(sfl_file.linea, 535, 32)::VARCHAR(100) as account_description,
        substr(sfl_file.linea, 567, 1)::VARCHAR(100) as set_as_mail_addr_2_ind,
        substr(sfl_file.linea, 568, 33)::VARCHAR(100) as campo_44,
        substr(sfl_file.linea, 601, 18)::VARCHAR(100) as principal_billing_allocation_pct,
        substr(sfl_file.linea, 619, 16)::VARCHAR(100) as campo_46,
        substr(sfl_file.linea, 635, 1)::VARCHAR(100) as seasonal_addr_id_1,
        substr(sfl_file.linea, 636, 8)::VARCHAR(100) as from_date_1,
        substr(sfl_file.linea, 644, 8)::VARCHAR(100) as to_date_1,
        substr(sfl_file.linea, 652, 1)::VARCHAR(100) as seasonal_addr_id_2,
        substr(sfl_file.linea, 653, 8)::VARCHAR(100) as from_date_2,
        substr(sfl_file.linea, 661, 8)::VARCHAR(100) as to_date_2,
        substr(sfl_file.linea, 669, 1)::VARCHAR(100) as seasonal_addr_id_3,
        substr(sfl_file.linea, 670, 8)::VARCHAR(100) as from_date_3,
        substr(sfl_file.linea, 678, 8)::VARCHAR(100) as to_date_3,
        substr(sfl_file.linea, 686, 4)::VARCHAR(100) as cost_basis_acct_system,
        substr(sfl_file.linea, 690, 2)::VARCHAR(100) as disposition_method_mutual_funds,
        substr(sfl_file.linea, 692, 2)::VARCHAR(100) as disposition_method_other,
        substr(sfl_file.linea, 694, 2)::VARCHAR(100) as disposition_method_stocks,
        substr(sfl_file.linea, 696, 1)::VARCHAR(100) as campo_60,
        substr(sfl_file.linea, 697, 1)::VARCHAR(100) as amortize_taxable_premium_bonds,
        substr(sfl_file.linea, 698, 1)::VARCHAR(100) as accrue_market_disc_based_on,
        substr(sfl_file.linea, 699, 1)::VARCHAR(100) as accrue_market_disc_income,
        substr(sfl_file.linea, 700, 6)::VARCHAR(100) as campo_64,
        substr(sfl_file.linea, 706, 42)::VARCHAR(100) as campo_65,
        substr(sfl_file.linea, 748, 2)::VARCHAR(100) as campo_66,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CIC'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_acct_reg_c(bigint) owner to postgres;

