create or replace function stage_pershing.fn_extrae_gmon_reg_b(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, campo_5 character varying, ip_number character varying, ibd_number character varying, usde_sd_balance character varying, usde_sd_balance_sign character varying, usd_sd_balance character varying, usd_sd_balance_sign character varying, long_sd_market character varying, long_sd_market_sign character varying, short_sd_market character varying, short_sd_market_sign character varying, sma_date_stamp character varying, sma_balance character varying, sma_balance_sign character varying, margin_buying_power character varying, margin_buying_power_sign character varying, technical_short_value character varying, technical_short_value_sign character varying, total_fed_requirement character varying, total_fed_requirement_sign character varying, total_options_requirement character varying, total_options_requirement_sign character varying, base_currency character varying, non_usd_currency character varying, masked_house_call character varying, masked_house_call_sign character varying, campo_31 character varying, date_of_data character varying, eor character varying)
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
        substr(sfl_file.linea, 21, 1)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 22, 4)::VARCHAR(100) as ip_number,
        substr(sfl_file.linea, 26, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 29, 18)::VARCHAR(100) as usde_sd_balance,
        substr(sfl_file.linea, 47, 1)::VARCHAR(100) as usde_sd_balance_sign,
        substr(sfl_file.linea, 48, 18)::VARCHAR(100) as usd_sd_balance,
        substr(sfl_file.linea, 66, 1)::VARCHAR(100) as usd_sd_balance_sign,
        substr(sfl_file.linea, 67, 18)::VARCHAR(100) as long_sd_market,
        substr(sfl_file.linea, 85, 1)::VARCHAR(100) as long_sd_market_sign,
        substr(sfl_file.linea, 86, 18)::VARCHAR(100) as short_sd_market,
        substr(sfl_file.linea, 104, 1)::VARCHAR(100) as short_sd_market_sign,
        substr(sfl_file.linea, 105, 8)::VARCHAR(100) as sma_date_stamp,
        substr(sfl_file.linea, 113, 18)::VARCHAR(100) as sma_balance,
        substr(sfl_file.linea, 131, 1)::VARCHAR(100) as sma_balance_sign,
        substr(sfl_file.linea, 132, 18)::VARCHAR(100) as margin_buying_power,
        substr(sfl_file.linea, 150, 1)::VARCHAR(100) as margin_buying_power_sign,
        substr(sfl_file.linea, 151, 18)::VARCHAR(100) as technical_short_value,
        substr(sfl_file.linea, 169, 1)::VARCHAR(100) as technical_short_value_sign,
        substr(sfl_file.linea, 170, 18)::VARCHAR(100) as total_fed_requirement,
        substr(sfl_file.linea, 188, 1)::VARCHAR(100) as total_fed_requirement_sign,
        substr(sfl_file.linea, 189, 18)::VARCHAR(100) as total_options_requirement,
        substr(sfl_file.linea, 207, 1)::VARCHAR(100) as total_options_requirement_sign,
        substr(sfl_file.linea, 208, 3)::VARCHAR(100) as base_currency,
        substr(sfl_file.linea, 211, 1)::VARCHAR(100) as non_usd_currency,
        substr(sfl_file.linea, 212, 18)::VARCHAR(100) as masked_house_call,
        substr(sfl_file.linea, 230, 1)::VARCHAR(100) as masked_house_call_sign,
        substr(sfl_file.linea, 231, 11)::VARCHAR(100) as campo_31,
        substr(sfl_file.linea, 242, 8)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 250, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gmon_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 3)		= 'GMB'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_gmon_reg_b(bigint) owner to postgres;

