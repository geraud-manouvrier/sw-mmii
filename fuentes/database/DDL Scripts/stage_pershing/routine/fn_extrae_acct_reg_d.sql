create or replace function stage_pershing.fn_extrae_acct_reg_d(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, ibd_number character varying, campo_6 character varying, ip_number character varying, account_short_name character varying, campo_9 character varying, addr_3_trx_code character varying, addr_3_special_handling_ind character varying, addr_3_delivery_id character varying, addr_3_attention_line_prefix character varying, addr_3_attention_line_detail character varying, addr_3_line_1 character varying, addr_3_line_2 character varying, addr_3_line_3 character varying, addr_3_line_4 character varying, addr_3_city_state character varying, addr_3_country_code character varying, set_as_mail_addr_3_ind character varying, campo_22 character varying, addr_4_trx_code character varying, addr_4_special_handling_ind character varying, addr_4_delivery_id character varying, addr_4_attention_line_prefix character varying, addr_4_attention_line_detail character varying, addr_4_line_1 character varying, addr_4_line_2 character varying, addr_4_line_3 character varying, addr_4_line_4 character varying, addr_4_city_state character varying, addr_4_country_code character varying, set_as_mail_addr_4_ind character varying, campo_35 character varying, eor character varying)
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
        substr(sfl_file.linea, 41, 1)::VARCHAR(100) as addr_3_trx_code,
        substr(sfl_file.linea, 42, 1)::VARCHAR(100) as addr_3_special_handling_ind,
        substr(sfl_file.linea, 43, 1)::VARCHAR(100) as addr_3_delivery_id,
        substr(sfl_file.linea, 44, 4)::VARCHAR(100) as addr_3_attention_line_prefix,
        substr(sfl_file.linea, 48, 28)::VARCHAR(100) as addr_3_attention_line_detail,
        substr(sfl_file.linea, 76, 32)::VARCHAR(100) as addr_3_line_1,
        substr(sfl_file.linea, 108, 32)::VARCHAR(100) as addr_3_line_2,
        substr(sfl_file.linea, 140, 32)::VARCHAR(100) as addr_3_line_3,
        substr(sfl_file.linea, 172, 32)::VARCHAR(100) as addr_3_line_4,
        substr(sfl_file.linea, 204, 32)::VARCHAR(100) as addr_3_city_state,
        substr(sfl_file.linea, 236, 2)::VARCHAR(100) as addr_3_country_code,
        substr(sfl_file.linea, 238, 1)::VARCHAR(100) as set_as_mail_addr_3_ind,
        substr(sfl_file.linea, 239, 99)::VARCHAR(100) as campo_22,
        substr(sfl_file.linea, 338, 1)::VARCHAR(100) as addr_4_trx_code,
        substr(sfl_file.linea, 339, 1)::VARCHAR(100) as addr_4_special_handling_ind,
        substr(sfl_file.linea, 340, 1)::VARCHAR(100) as addr_4_delivery_id,
        substr(sfl_file.linea, 341, 4)::VARCHAR(100) as addr_4_attention_line_prefix,
        substr(sfl_file.linea, 345, 28)::VARCHAR(100) as addr_4_attention_line_detail,
        substr(sfl_file.linea, 373, 32)::VARCHAR(100) as addr_4_line_1,
        substr(sfl_file.linea, 405, 32)::VARCHAR(100) as addr_4_line_2,
        substr(sfl_file.linea, 437, 50)::VARCHAR(100) as addr_4_line_3,
        substr(sfl_file.linea, 487, 14)::VARCHAR(100) as addr_4_line_4,
        substr(sfl_file.linea, 501, 32)::VARCHAR(100) as addr_4_city_state,
        substr(sfl_file.linea, 533, 2)::VARCHAR(100) as addr_4_country_code,
        substr(sfl_file.linea, 535, 1)::VARCHAR(100) as set_as_mail_addr_4_ind,
        substr(sfl_file.linea, 536, 214)::VARCHAR(100) as campo_35,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_acct_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND SUBSTRING(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND SUBSTRING(sfl_file.linea, 1, 3)		= 'CID'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_acct_reg_d(bigint) owner to postgres;

