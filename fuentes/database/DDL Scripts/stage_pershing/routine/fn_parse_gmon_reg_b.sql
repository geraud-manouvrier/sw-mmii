create or replace function stage_pershing.fn_parse_gmon_reg_b(_id_proceso bigint) returns SETOF stage_pershing.stage_gmon_reg_b
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
        public.fn_convierte_texto_numerico_cobol(usde_sd_balance, 2)::NUMERIC(45,20) as usde_sd_balance,
        usde_sd_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(usd_sd_balance, 2)::NUMERIC(45,20) as usd_sd_balance,
        usd_sd_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(long_sd_market, 2)::NUMERIC(45,20) as long_sd_market,
        long_sd_market_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(short_sd_market, 2)::NUMERIC(45,20) as short_sd_market,
        short_sd_market_sign::VARCHAR(100),
        public.fn_fecha_string_to_date(sma_date_stamp, 'CCYYMMDD') as sma_date_stamp,
        public.fn_convierte_texto_numerico_cobol(sma_balance, 2)::NUMERIC(45,20) as sma_balance,
        sma_balance_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(margin_buying_power, 2)::NUMERIC(45,20) as margin_buying_power,
        margin_buying_power_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(technical_short_value, 2)::NUMERIC(45,20) as technical_short_value,
        technical_short_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(total_fed_requirement, 2)::NUMERIC(45,20) as total_fed_requirement,
        total_fed_requirement_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(total_options_requirement, 2)::NUMERIC(45,20) as total_options_requirement,
        total_options_requirement_sign::VARCHAR(100),
        base_currency::VARCHAR(100),
        non_usd_currency::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(masked_house_call, 2)::NUMERIC(45,20) as masked_house_call,
        masked_house_call_sign::VARCHAR(100),
        campo_31::VARCHAR(100),
        public.fn_fecha_string_to_date(date_of_data, 'CCYYMMDD') as date_of_data,
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gmon_reg_b(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_gmon_reg_b(bigint) owner to postgres;

