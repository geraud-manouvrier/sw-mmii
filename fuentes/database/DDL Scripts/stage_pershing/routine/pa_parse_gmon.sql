create or replace procedure stage_pershing.pa_parse_gmon(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
begin

    DELETE FROM stage_pershing.stage_gmon_reg_header reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_gmon_reg_a reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_gmon_reg_b reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_gmon_reg_trailer reg_del WHERE reg_del.id_proceso=_id_proceso;

    INSERT INTO stage_pershing.stage_gmon_reg_header (id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, eor)
    SELECT id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, eor
    FROM stage_pershing.fn_parse_gmon_reg_header(_id_proceso);

    INSERT INTO stage_pershing.stage_gmon_reg_a (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, campo_5, ip_number, ibd_number, usde_td_balance, usde_td_balance_sign, usd_td_balance, usd_td_balance_sign, long_td_market, long_td_market_sign, short_td_market, short_td_market_sign, td_liquidating_equity, td_liquidating_equity_sign, total_usde_td_balance, total_usde_td_balance_sign, total_equity, total_equity_sign, trade_date_net_worth, trade_date_net_worth_sign, mmf_principal_balance, mmf_principal_balance_sign, mmf_dividend, mmf_dividend_sign, cash_available, cash_available_sign, campo_30, date_of_data, eor)
    SELECT id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, campo_5, ip_number, ibd_number, usde_td_balance, usde_td_balance_sign, usd_td_balance, usd_td_balance_sign, long_td_market, long_td_market_sign, short_td_market, short_td_market_sign, td_liquidating_equity, td_liquidating_equity_sign, total_usde_td_balance, total_usde_td_balance_sign, total_equity, total_equity_sign, trade_date_net_worth, trade_date_net_worth_sign, mmf_principal_balance, mmf_principal_balance_sign, mmf_dividend, mmf_dividend_sign, cash_available, cash_available_sign, campo_30, date_of_data, eor
    FROM stage_pershing.fn_parse_gmon_reg_a(_id_proceso);

    INSERT INTO stage_pershing.stage_gmon_reg_b (id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, campo_5, ip_number, ibd_number, usde_sd_balance, usde_sd_balance_sign, usd_sd_balance, usd_sd_balance_sign, long_sd_market, long_sd_market_sign, short_sd_market, short_sd_market_sign, sma_date_stamp, sma_balance, sma_balance_sign, margin_buying_power, margin_buying_power_sign, technical_short_value, technical_short_value_sign, total_fed_requirement, total_fed_requirement_sign, total_options_requirement, total_options_requirement_sign, base_currency, non_usd_currency, masked_house_call, masked_house_call_sign, campo_31, date_of_data, eor)
    SELECT id_proceso, process_date, transaction_code, record_indicator_value, record_id_sequence_number, account_number, campo_5, ip_number, ibd_number, usde_sd_balance, usde_sd_balance_sign, usd_sd_balance, usd_sd_balance_sign, long_sd_market, long_sd_market_sign, short_sd_market, short_sd_market_sign, sma_date_stamp, sma_balance, sma_balance_sign, margin_buying_power, margin_buying_power_sign, technical_short_value, technical_short_value_sign, total_fed_requirement, total_fed_requirement_sign, total_options_requirement, total_options_requirement_sign, base_currency, non_usd_currency, masked_house_call, masked_house_call_sign, campo_31, date_of_data, eor
    FROM stage_pershing.fn_parse_gmon_reg_b(_id_proceso);

    INSERT INTO stage_pershing.stage_gmon_reg_trailer (id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, campo_8, number_detail_of_records, campo_10, eor)
    SELECT id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, campo_8, number_detail_of_records, campo_10, eor
    FROM stage_pershing.fn_parse_gmon_reg_trailer(_id_proceso);

end;
$$;

alter procedure stage_pershing.pa_parse_gmon(bigint) owner to postgres;

