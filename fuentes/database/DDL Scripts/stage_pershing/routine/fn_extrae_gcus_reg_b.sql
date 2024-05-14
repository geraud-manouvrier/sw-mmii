create or replace function stage_pershing.fn_extrae_gcus_reg_b(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, recor_id_sequence_number character varying, account_number character varying, cusip_number character varying, position_currency character varying, campo_7 character varying, underlying_cusip_number character varying, country_code character varying, campo_10 character varying, ip_record_number character varying, ibd_number character varying, fully_paid_lending_quantity character varying, fully_paid_lending_quantity_sign character varying, fully_paid_lending_quantity_collateral_amount character varying, fully_paid_lending_quantity_collateral_amount_sign character varying, option_root_id character varying, expiration_date character varying, call_put_indicator character varying, strike_price character varying, trade_date_repo_quantity character varying, trade_date_repo_quantity_sign character varying, settlement_date_repo_quantity character varying, settlement_date_repo_quantity_sign character varying, trade_date_reverse_repo_quantity character varying, trade_date_reverse_repo_quantity_sign character varying, settlement_date_reverse_repo_quantity character varying, settlement_date_reverse_repo_quantity_sign character varying, collateral_pledge_quantity character varying, collateral_pledge_quantity_sign character varying, corporate_exec_serv_collateral_pledge_quantity character varying, corporate_exec_serv_collateral_pledge_quantity_sign character varying, trade_date_repo_liquidating_value character varying, trade_date_repo_liquidating_value_sign character varying, settlement_date_repo_liquidating_value character varying, settlement_date_repo_liquidating_value_sign character varying, trade_date_reverse_repo_liquidating_value character varying, trade_date_reverse_repo_liquidating_value_sign character varying, settlement_date_reverse_repo_liquidating_value character varying, settlement_date_reverse_repo_liquidating_value_sign character varying, collateral_pledge_liquidating_value character varying, collateral_pledge_liquidating_value_sign character varying, corporate_exec_serv_collateral_pledge_liquidating_value character varying, corporate_exec_serv_collateral_pledge_liquidating_value_sign character varying, trade_date_repo_loan_amount character varying, trade_date_repo_loan_amount_sign character varying, settlement_date_repo_loan_amount character varying, settlement_date_repo_loan_amount_sign character varying, trade_date_reverse_repo_loan_amount character varying, trade_date_reverse_repo_loan_amount_sign character varying, settlement_date_reverse_repo_loan_amount character varying, settlement_date_reverse_repo_loan_amount_sign character varying, accrued_interes_value character varying, accrued_interes_value_sign character varying, dividend_or_coupon_rate character varying, pending_split_quantity_liquidating_value character varying, pending_split_quantity_liquidating_value_sign character varying, campo_58 character varying, internal_non_dollar_symbol character varying, pledged_quantity character varying, pledged_quantity_sign character varying, campo_62 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as recor_id_sequence_number,
        substr(sfl_file.linea, 12, 10)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 22, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 31, 3)::VARCHAR(100) as position_currency,
        substr(sfl_file.linea, 34, 1)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 35, 9)::VARCHAR(100) as underlying_cusip_number,
        substr(sfl_file.linea, 44, 2)::VARCHAR(100) as country_code,
        substr(sfl_file.linea, 46, 1)::VARCHAR(100) as campo_10,
        substr(sfl_file.linea, 47, 4)::VARCHAR(100) as ip_record_number,
        substr(sfl_file.linea, 51, 3)::VARCHAR(100) as ibd_number,
        substr(sfl_file.linea, 54, 18)::VARCHAR(100) as fully_paid_lending_quantity,
        substr(sfl_file.linea, 72, 1)::VARCHAR(100) as fully_paid_lending_quantity_sign,
        substr(sfl_file.linea, 73, 18)::VARCHAR(100) as fully_paid_lending_quantity_collateral_amount,
        substr(sfl_file.linea, 91, 1)::VARCHAR(100) as fully_paid_lending_quantity_collateral_amount_sign,
        substr(sfl_file.linea, 92, 6)::VARCHAR(100) as option_root_id,
        substr(sfl_file.linea, 98, 6)::VARCHAR(100) as expiration_date,
        substr(sfl_file.linea, 104, 1)::VARCHAR(100) as call_put_indicator,
        substr(sfl_file.linea, 105, 8)::VARCHAR(100) as strike_price,
        substr(sfl_file.linea, 113, 18)::VARCHAR(100) as trade_date_repo_quantity,
        substr(sfl_file.linea, 131, 1)::VARCHAR(100) as trade_date_repo_quantity_sign,
        substr(sfl_file.linea, 132, 18)::VARCHAR(100) as settlement_date_repo_quantity,
        substr(sfl_file.linea, 150, 1)::VARCHAR(100) as settlement_date_repo_quantity_sign,
        substr(sfl_file.linea, 151, 18)::VARCHAR(100) as trade_date_reverse_repo_quantity,
        substr(sfl_file.linea, 169, 1)::VARCHAR(100) as trade_date_reverse_repo_quantity_sign,
        substr(sfl_file.linea, 170, 18)::VARCHAR(100) as settlement_date_reverse_repo_quantity,
        substr(sfl_file.linea, 188, 1)::VARCHAR(100) as settlement_date_reverse_repo_quantity_sign,
        substr(sfl_file.linea, 189, 18)::VARCHAR(100) as collateral_pledge_quantity,
        substr(sfl_file.linea, 207, 1)::VARCHAR(100) as collateral_pledge_quantity_sign,
        substr(sfl_file.linea, 208, 18)::VARCHAR(100) as corporate_exec_serv_collateral_pledge_quantity,
        substr(sfl_file.linea, 226, 1)::VARCHAR(100) as corporate_exec_serv_collateral_pledge_quantity_sign,
        substr(sfl_file.linea, 227, 18)::VARCHAR(100) as trade_date_repo_liquidating_value,
        substr(sfl_file.linea, 245, 1)::VARCHAR(100) as trade_date_repo_liquidating_value_sign,
        substr(sfl_file.linea, 246, 18)::VARCHAR(100) as settlement_date_repo_liquidating_value,
        substr(sfl_file.linea, 264, 1)::VARCHAR(100) as settlement_date_repo_liquidating_value_sign,
        substr(sfl_file.linea, 265, 18)::VARCHAR(100) as trade_date_reverse_repo_liquidating_value,
        substr(sfl_file.linea, 283, 1)::VARCHAR(100) as trade_date_reverse_repo_liquidating_value_sign,
        substr(sfl_file.linea, 284, 18)::VARCHAR(100) as settlement_date_reverse_repo_liquidating_value,
        substr(sfl_file.linea, 302, 1)::VARCHAR(100) as settlement_date_reverse_repo_liquidating_value_sign,
        substr(sfl_file.linea, 303, 18)::VARCHAR(100) as collateral_pledge_liquidating_value,
        substr(sfl_file.linea, 321, 1)::VARCHAR(100) as collateral_pledge_liquidating_value_sign,
        substr(sfl_file.linea, 322, 18)::VARCHAR(100) as corporate_exec_serv_collateral_pledge_liquidating_value,
        substr(sfl_file.linea, 340, 1)::VARCHAR(100) as corporate_exec_serv_collateral_pledge_liquidating_value_sign,
        substr(sfl_file.linea, 341, 18)::VARCHAR(100) as trade_date_repo_loan_amount,
        substr(sfl_file.linea, 359, 1)::VARCHAR(100) as trade_date_repo_loan_amount_sign,
        substr(sfl_file.linea, 360, 18)::VARCHAR(100) as settlement_date_repo_loan_amount,
        substr(sfl_file.linea, 378, 1)::VARCHAR(100) as settlement_date_repo_loan_amount_sign,
        substr(sfl_file.linea, 379, 18)::VARCHAR(100) as trade_date_reverse_repo_loan_amount,
        substr(sfl_file.linea, 397, 1)::VARCHAR(100) as trade_date_reverse_repo_loan_amount_sign,
        substr(sfl_file.linea, 398, 18)::VARCHAR(100) as settlement_date_reverse_repo_loan_amount,
        substr(sfl_file.linea, 416, 1)::VARCHAR(100) as settlement_date_reverse_repo_loan_amount_sign,
        substr(sfl_file.linea, 417, 18)::VARCHAR(100) as accrued_interes_value,
        substr(sfl_file.linea, 435, 1)::VARCHAR(100) as accrued_interes_value_sign,
        substr(sfl_file.linea, 436, 18)::VARCHAR(100) as dividend_or_coupon_rate,
        substr(sfl_file.linea, 454, 18)::VARCHAR(100) as pending_split_quantity_liquidating_value,
        substr(sfl_file.linea, 472, 1)::VARCHAR(100) as pending_split_quantity_liquidating_value_sign,
        substr(sfl_file.linea, 473, 38)::VARCHAR(100) as campo_58,
        substr(sfl_file.linea, 511, 16)::VARCHAR(100) as internal_non_dollar_symbol,
        substr(sfl_file.linea, 527, 18)::VARCHAR(100) as pledged_quantity,
        substr(sfl_file.linea, 545, 1)::VARCHAR(100) as pledged_quantity_sign,
        substr(sfl_file.linea, 546, 204)::VARCHAR(100) as campo_62,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gcus_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 3)		= 'GCB'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_gcus_reg_b(bigint) owner to postgres;

