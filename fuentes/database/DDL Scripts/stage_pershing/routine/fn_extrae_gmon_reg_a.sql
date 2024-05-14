create or replace function stage_pershing.fn_extrae_gmon_reg_a(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, campo_5 character varying, ip_number character varying, ibd_number character varying, usde_td_balance character varying, usde_td_balance_sign character varying, usd_td_balance character varying, usd_td_balance_sign character varying, long_td_market character varying, long_td_market_sign character varying, short_td_market character varying, short_td_market_sign character varying, td_liquidating_equity character varying, td_liquidating_equity_sign character varying, total_usde_td_balance character varying, total_usde_td_balance_sign character varying, total_equity character varying, total_equity_sign character varying, trade_date_net_worth character varying, trade_date_net_worth_sign character varying, mmf_principal_balance character varying, mmf_principal_balance_sign character varying, mmf_dividend character varying, mmf_dividend_sign character varying, cash_available character varying, cash_available_sign character varying, campo_30 character varying, date_of_data character varying, eor character varying)
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
        substr(sfl_file.linea, 29, 18)::VARCHAR(100) as usde_td_balance,
        substr(sfl_file.linea, 47, 1)::VARCHAR(100) as usde_td_balance_sign,
        substr(sfl_file.linea, 48, 18)::VARCHAR(100) as usd_td_balance,
        substr(sfl_file.linea, 66, 1)::VARCHAR(100) as usd_td_balance_sign,
        substr(sfl_file.linea, 67, 18)::VARCHAR(100) as long_td_market,
        substr(sfl_file.linea, 85, 1)::VARCHAR(100) as long_td_market_sign,
        substr(sfl_file.linea, 86, 18)::VARCHAR(100) as short_td_market,
        substr(sfl_file.linea, 104, 1)::VARCHAR(100) as short_td_market_sign,
        substr(sfl_file.linea, 105, 18)::VARCHAR(100) as td_liquidating_equity,
        substr(sfl_file.linea, 123, 1)::VARCHAR(100) as td_liquidating_equity_sign,
        substr(sfl_file.linea, 124, 18)::VARCHAR(100) as total_usde_td_balance,
        substr(sfl_file.linea, 142, 1)::VARCHAR(100) as total_usde_td_balance_sign,
        substr(sfl_file.linea, 143, 18)::VARCHAR(100) as total_equity,
        substr(sfl_file.linea, 161, 1)::VARCHAR(100) as total_equity_sign,
        substr(sfl_file.linea, 162, 18)::VARCHAR(100) as trade_date_net_worth,
        substr(sfl_file.linea, 180, 1)::VARCHAR(100) as trade_date_net_worth_sign,
        substr(sfl_file.linea, 181, 18)::VARCHAR(100) as mmf_principal_balance,
        substr(sfl_file.linea, 199, 1)::VARCHAR(100) as mmf_principal_balance_sign,
        substr(sfl_file.linea, 200, 18)::VARCHAR(100) as mmf_dividend,
        substr(sfl_file.linea, 218, 1)::VARCHAR(100) as mmf_dividend_sign,
        substr(sfl_file.linea, 219, 18)::VARCHAR(100) as cash_available,
        substr(sfl_file.linea, 237, 1)::VARCHAR(100) as cash_available_sign,
        substr(sfl_file.linea, 238, 4)::VARCHAR(100) as campo_30,
        substr(sfl_file.linea, 242, 8)::VARCHAR(100) as date_of_data,
        substr(sfl_file.linea, 250, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gmon_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 3)		= 'GMA'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_gmon_reg_a(bigint) owner to postgres;

