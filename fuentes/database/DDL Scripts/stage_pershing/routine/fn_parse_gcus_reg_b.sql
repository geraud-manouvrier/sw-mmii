create or replace function stage_pershing.fn_parse_gcus_reg_b(_id_proceso bigint) returns SETOF stage_pershing.stage_gcus_reg_b
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        transaction_code::VARCHAR(100),
        record_indicator_value::VARCHAR(100),
        recor_id_sequence_number::int,
        account_number::VARCHAR(100),
        cusip_number::VARCHAR(100),
        position_currency::VARCHAR(100),
        campo_7::VARCHAR(100),
        underlying_cusip_number::VARCHAR(100),
        country_code::VARCHAR(100),
        campo_10::VARCHAR(100),
        ip_record_number::VARCHAR(100),
        ibd_number::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(fully_paid_lending_quantity, 5)::NUMERIC(45,20) as fully_paid_lending_quantity,
        fully_paid_lending_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(fully_paid_lending_quantity_collateral_amount, 3)::NUMERIC(45,20) as fully_paid_lending_quantity_collateral_amount,
        fully_paid_lending_quantity_collateral_amount_sign::VARCHAR(100),
        option_root_id::VARCHAR(100),
        public.fn_fecha_string_to_date(expiration_date, 'YYMMDD') as expiration_date,
        call_put_indicator::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(strike_price, 3)::NUMERIC(45,20) as strike_price,
        public.fn_convierte_texto_numerico_cobol(trade_date_repo_quantity, 5)::NUMERIC(45,20) as trade_date_repo_quantity,
        trade_date_repo_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_repo_quantity, 5)::NUMERIC(45,20) as settlement_date_repo_quantity,
        settlement_date_repo_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_reverse_repo_quantity, 5)::NUMERIC(45,20) as trade_date_reverse_repo_quantity,
        trade_date_reverse_repo_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_reverse_repo_quantity, 5)::NUMERIC(45,20) as settlement_date_reverse_repo_quantity,
        settlement_date_reverse_repo_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(collateral_pledge_quantity, 5)::NUMERIC(45,20) as collateral_pledge_quantity,
        collateral_pledge_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(corporate_exec_serv_collateral_pledge_quantity, 5)::NUMERIC(45,20) as corporate_exec_serv_collateral_pledge_quantity,
        corporate_exec_serv_collateral_pledge_quantity_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_repo_liquidating_value, 3)::NUMERIC(45,20) as trade_date_repo_liquidating_value,
        trade_date_repo_liquidating_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_repo_liquidating_value, 3)::NUMERIC(45,20) as settlement_date_repo_liquidating_value,
        settlement_date_repo_liquidating_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_reverse_repo_liquidating_value, 3)::NUMERIC(45,20) as trade_date_reverse_repo_liquidating_value,
        trade_date_reverse_repo_liquidating_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_reverse_repo_liquidating_value, 3)::NUMERIC(45,20) as settlement_date_reverse_repo_liquidating_value,
        settlement_date_reverse_repo_liquidating_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(collateral_pledge_liquidating_value, 3)::NUMERIC(45,20) as collateral_pledge_liquidating_value,
        collateral_pledge_liquidating_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(corporate_exec_serv_collateral_pledge_liquidating_value, 3)::NUMERIC(45,20) as corporate_exec_serv_collateral_pledge_liquidating_value,
        corporate_exec_serv_collateral_pledge_liquidating_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_repo_loan_amount, 3)::NUMERIC(45,20) as trade_date_repo_loan_amount,
        trade_date_repo_loan_amount_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_repo_loan_amount, 3)::NUMERIC(45,20) as settlement_date_repo_loan_amount,
        settlement_date_repo_loan_amount_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(trade_date_reverse_repo_loan_amount, 3)::NUMERIC(45,20) as trade_date_reverse_repo_loan_amount,
        trade_date_reverse_repo_loan_amount_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(settlement_date_reverse_repo_loan_amount, 3)::NUMERIC(45,20) as settlement_date_reverse_repo_loan_amount,
        settlement_date_reverse_repo_loan_amount_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(accrued_interes_value, 3)::NUMERIC(45,20) as accrued_interes_value,
        accrued_interes_value_sign::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(dividend_or_coupon_rate, 9)::NUMERIC(45,20) as dividend_or_coupon_rate,
        public.fn_convierte_texto_numerico_cobol(pending_split_quantity_liquidating_value, 3)::NUMERIC(45,20) as pending_split_quantity_liquidating_value,
        pending_split_quantity_liquidating_value_sign::VARCHAR(100),
        campo_58::VARCHAR(100),
        internal_non_dollar_symbol::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(pledged_quantity, 5)::NUMERIC(45,20) as pledged_quantity,
        pledged_quantity_sign::VARCHAR(100),
        campo_62::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_gcus_reg_b(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_gcus_reg_b(bigint) owner to postgres;

