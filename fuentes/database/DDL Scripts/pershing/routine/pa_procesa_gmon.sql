create or replace procedure pershing.pa_procesa_gmon(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _process_date VARCHAR(100);
DECLARE _last_process_date VARCHAR(100);
begin

    SELECT tb_proc.process_date INTO _process_date
    FROM pershing.proceso_sfl tb_proc WHERE tb_proc.id=_id_proceso;

    DELETE FROM pershing.sfl_gmon tb_sfl WHERE tb_sfl.process_date= _process_date;
--public.fn_convierte_signo_factor(
    INSERT INTO pershing.sfl_gmon (id_proceso, process_date, record_id_sequence_number, account_number, ip_number, ibd_number, usde_td_balance, usd_td_balance, long_td_market, short_td_market, td_liquidating_equity, total_usde_td_balance, total_equity, trade_date_net_worth, mmf_principal_balance, mmf_dividend, cash_available, date_of_data, usde_sd_balance, usd_sd_balance, long_sd_market, short_sd_market, sma_date_stamp, sma_balance, margin_buying_power, technical_short_value, total_fed_requirement, total_options_requirement, base_currency, non_usd_currency, masked_house_call)
    SELECT
        reg_header.id_proceso, reg_header.process_date, reg_a.record_id_sequence_number, reg_a.account_number, reg_a.ip_number, reg_a.ibd_number,
        usde_td_balance*public.fn_convierte_signo_factor(usde_td_balance_sign) as usde_td_balance,
        usd_td_balance*public.fn_convierte_signo_factor(usd_td_balance_sign) as usd_td_balance,
        long_td_market*public.fn_convierte_signo_factor(long_td_market_sign) as long_td_market,
        short_td_market*public.fn_convierte_signo_factor(short_td_market_sign) as short_td_market,
        td_liquidating_equity*public.fn_convierte_signo_factor(td_liquidating_equity_sign) as td_liquidating_equity,
        total_usde_td_balance*public.fn_convierte_signo_factor(total_usde_td_balance_sign) as total_usde_td_balance,
        total_equity*public.fn_convierte_signo_factor(total_equity_sign) as total_equity,
        trade_date_net_worth*public.fn_convierte_signo_factor(trade_date_net_worth_sign) as trade_date_net_worth,
        mmf_principal_balance*public.fn_convierte_signo_factor(mmf_principal_balance_sign) as mmf_principal_balance,
        mmf_dividend*public.fn_convierte_signo_factor(mmf_dividend_sign) as mmf_dividend,
        cash_available*public.fn_convierte_signo_factor(cash_available_sign) as cash_available, reg_a.date_of_data,
        usde_sd_balance*public.fn_convierte_signo_factor(usde_sd_balance_sign) as usde_sd_balance,
        usd_sd_balance*public.fn_convierte_signo_factor(usd_sd_balance_sign) as usd_sd_balance,
        long_sd_market*public.fn_convierte_signo_factor(long_sd_market_sign) as long_sd_market,
        short_sd_market*public.fn_convierte_signo_factor(short_sd_market_sign) as short_sd_market, sma_date_stamp,
        sma_balance*public.fn_convierte_signo_factor(sma_balance_sign) as sma_balance,
        margin_buying_power*public.fn_convierte_signo_factor(margin_buying_power_sign) as margin_buying_power,
        technical_short_value*public.fn_convierte_signo_factor(technical_short_value_sign) as technical_short_value,
        total_fed_requirement*public.fn_convierte_signo_factor(total_fed_requirement_sign) as total_fed_requirement,
        total_options_requirement*public.fn_convierte_signo_factor(total_options_requirement_sign) as total_options_requirement, base_currency, non_usd_currency,
        masked_house_call*public.fn_convierte_signo_factor(masked_house_call_sign) as masked_house_call
    FROM stage_pershing.stage_gmon_reg_header reg_header
    INNER JOIN stage_pershing.stage_gmon_reg_trailer reg_trailer
    ON reg_header.id_proceso=reg_trailer.id_proceso
    INNER JOIN stage_pershing.stage_gmon_reg_a reg_a
    ON reg_header.id_proceso=reg_a.id_proceso
    LEFT JOIN stage_pershing.stage_gmon_reg_b reg_b
    ON reg_header.id_proceso=reg_b.id_proceso AND reg_a.account_number=reg_b.account_number
    WHERE reg_header.id_proceso=_id_proceso
    ;


    DELETE FROM pershing.sfl_gmon_historica WHERE process_date=_process_date;

    --Si no se cargaron datos y no existe SFL
    IF ( (SELECT count(*) FROM pershing.sfl_gmon where process_date=_process_date)=0
        AND
         (SELECT count(*) FROM stage_pershing.stage_gmon_reg_header where process_date=_process_date)=0 ) THEN
        --Replicar data ultimo process date disponible
        SELECT max(process_date) INTO _last_process_date
        FROM pershing.sfl_gmon where process_date<=_process_date;

        INSERT INTO pershing.sfl_gmon_historica (id_proceso, process_date, record_id_sequence_number, account_number, ip_number, ibd_number, usde_td_balance, usd_td_balance, long_td_market, short_td_market, td_liquidating_equity, total_usde_td_balance, total_equity, trade_date_net_worth, mmf_principal_balance, mmf_dividend, cash_available, date_of_data, usde_sd_balance, usd_sd_balance, long_sd_market, short_sd_market, sma_date_stamp, sma_balance, margin_buying_power, technical_short_value, total_fed_requirement, total_options_requirement, base_currency, non_usd_currency, masked_house_call)
        SELECT
            id_proceso, _process_date as process_date, record_id_sequence_number, account_number, ip_number, ibd_number, usde_td_balance, usd_td_balance, long_td_market, short_td_market, td_liquidating_equity, total_usde_td_balance, total_equity, trade_date_net_worth, mmf_principal_balance, mmf_dividend, cash_available, date_of_data, usde_sd_balance, usd_sd_balance, long_sd_market, short_sd_market, sma_date_stamp, sma_balance, margin_buying_power, technical_short_value, total_fed_requirement, total_options_requirement, base_currency, non_usd_currency, masked_house_call
        FROM pershing.sfl_gmon
        WHERE process_date=_last_process_date;
    ELSE

        INSERT INTO pershing.sfl_gmon_historica (id_proceso, process_date, record_id_sequence_number, account_number, ip_number, ibd_number, usde_td_balance, usd_td_balance, long_td_market, short_td_market, td_liquidating_equity, total_usde_td_balance, total_equity, trade_date_net_worth, mmf_principal_balance, mmf_dividend, cash_available, date_of_data, usde_sd_balance, usd_sd_balance, long_sd_market, short_sd_market, sma_date_stamp, sma_balance, margin_buying_power, technical_short_value, total_fed_requirement, total_options_requirement, base_currency, non_usd_currency, masked_house_call)
        SELECT
            gmon_his.id_proceso, _process_date as process_date, gmon_his.record_id_sequence_number, gmon_his.account_number, gmon_his.ip_number, gmon_his.ibd_number, gmon_his.usde_td_balance, gmon_his.usd_td_balance, gmon_his.long_td_market, gmon_his.short_td_market, gmon_his.td_liquidating_equity, gmon_his.total_usde_td_balance, gmon_his.total_equity, gmon_his.trade_date_net_worth, gmon_his.mmf_principal_balance, gmon_his.mmf_dividend, gmon_his.cash_available, gmon_his.date_of_data, gmon_his.usde_sd_balance, gmon_his.usd_sd_balance, gmon_his.long_sd_market, gmon_his.short_sd_market, gmon_his.sma_date_stamp, gmon_his.sma_balance, gmon_his.margin_buying_power, gmon_his.technical_short_value, gmon_his.total_fed_requirement, gmon_his.total_options_requirement, gmon_his.base_currency, gmon_his.non_usd_currency, gmon_his.masked_house_call
        FROM pershing.sfl_gmon gmon_his
        WHERE gmon_his.process_date=_process_date
        ;
    END IF;


end;
$$;

alter procedure pershing.pa_procesa_gmon(bigint) owner to postgres;

