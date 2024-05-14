create or replace function stage_pershing.fn_parse_gmon_reg_a(_id_proceso bigint) returns SETOF stage_pershing.stage_gmon_reg_a
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        transaction_code::VARCHAR(100),
        record_indicator_value::VARCHAR(100),
        record_id_sequence_number::int,
        account_number::VARCHAR(100),
        campo_5::VARCHAR(100),
        ip_number::VARCHAR(100),
        ibd_number::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(usde_td_balance, 2)::NUMERIC(45,20) as usde_td_balance,
        usde_td_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(usd_td_balance, 2)::NUMERIC(45,20) as usd_td_balance,
        usd_td_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(long_td_market, 2)::NUMERIC(45,20) as long_td_market,
        long_td_market_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(short_td_market, 2)::NUMERIC(45,20) as short_td_market,
        short_td_market_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(td_liquidating_equity, 2)::NUMERIC(45,20) as td_liquidating_equity,
        td_liquidating_equity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(total_usde_td_balance, 2)::NUMERIC(45,20) as total_usde_td_balance,
        total_usde_td_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(total_equity, 2)::NUMERIC(45,20) as total_equity,
        total_equity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_net_worth, 2)::NUMERIC(45,20) as trade_date_net_worth,
        trade_date_net_worth_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(mmf_principal_balance, 2)::NUMERIC(45,20) as mmf_principal_balance,
        mmf_principal_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(mmf_dividend, 2)::NUMERIC(45,20) as mmf_dividend,
        mmf_dividend_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(cash_available, 2)::NUMERIC(45,20) as cash_available,
        cash_available_sign::VARCHAR(100),
        campo_30::VARCHAR(100),
        public.fn_fecha_string_to_date(date_of_data, 'CCYYMMDD') as date_of_data,
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gmon_reg_a(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_gmon_reg_a(bigint) owner to postgres;

