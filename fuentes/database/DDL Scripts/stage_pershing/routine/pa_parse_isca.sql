create or replace procedure stage_pershing.pa_parse_isca(IN _id_proceso bigint)
    language plpgsql
as
$$
DECLARE _cursor_reg_modif refcursor;
DECLARE _reg_modif record;
DECLARE _process_date VARCHAR(100);
begin

    DELETE FROM stage_pershing.stage_isca_reg_header reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_a reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_b reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_c reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_d reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_e reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_f reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_g reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_h reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_i reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_j reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_k reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_l reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_m reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_n reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_o reg_del WHERE reg_del.id_proceso=_id_proceso;
    DELETE FROM stage_pershing.stage_isca_reg_trailer reg_del WHERE reg_del.id_proceso=_id_proceso;

    INSERT INTO stage_pershing.stage_isca_reg_header (id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, refreshed_or_updated, campo_13, eor)
    SELECT id_proceso, process_date, bof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, run_date, campo_9, run_time, campo_11, refreshed_or_updated, campo_13, eor
    FROM stage_pershing.fn_parse_isca_reg_header(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_a (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, security_type, security_modifier, security_calculation_code, primary_exchange, coupon_rate_fis_or_indicated_dividend_eq, maturity_option_expire_date, underlying_security_cusip, first_call_price_fix_inc_or_strike_price_option, first_par_call_price_fix_inc_or_units_option, primary_symbol, interest_frequency, bond_class, first_coupon_day, call_indicator, put_indicator, next_par_call_date, prerefunded_date, next_premium_call_date, dated_date_for_fix_inc_or_ex_dividend_date_eq, first_coupon_fix_inc_or_payable_date_eq, campo_24, federal_marginable_ind, cns_eligible_code, dtcc_eligible_code, nscc_eligible_code, foreign_security, second_coupon_day, dividend_interest_payment_method, minor_product_code, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, security_type, security_modifier, security_calculation_code, primary_exchange, coupon_rate_fis_or_indicated_dividend_eq, maturity_option_expire_date, underlying_security_cusip, first_call_price_fix_inc_or_strike_price_option, first_par_call_price_fix_inc_or_units_option, primary_symbol, interest_frequency, bond_class, first_coupon_day, call_indicator, put_indicator, next_par_call_date, prerefunded_date, next_premium_call_date, dated_date_for_fix_inc_or_ex_dividend_date_eq, first_coupon_fix_inc_or_payable_date_eq, campo_24, federal_marginable_ind, cns_eligible_code, dtcc_eligible_code, nscc_eligible_code, foreign_security, second_coupon_day, dividend_interest_payment_method, minor_product_code, eor
    FROM stage_pershing.fn_parse_isca_reg_a(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_b (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, etf_indicator, bid_price, ask_price, previous_day_price, latest_price, end_of_month_price, round_lot_quantity, dividend_reinvestment_eligibility_indicator, previous_price_date, latest_price_date, end_of_month_price_date, record_date, fundvest_ind, country_code, standard_poor_rating, moodys_rating, bond_sub_class, restriction_indicator, trace_indicator, new_interest_calculation_code, sic_code, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, etf_indicator, bid_price, ask_price, previous_day_price, latest_price, end_of_month_price, round_lot_quantity, dividend_reinvestment_eligibility_indicator, previous_price_date, latest_price_date, end_of_month_price_date, record_date, fundvest_ind, country_code, standard_poor_rating, moodys_rating, bond_sub_class, restriction_indicator, trace_indicator, new_interest_calculation_code, sic_code, eor
    FROM stage_pershing.fn_parse_isca_reg_b(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_c (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, state_tax_ind, fts_ind, amt_ind, ric_indicator, number_of_description_lines, secutiry_description_line_1, secutiry_description_line_2, secutiry_description_line_3, secutiry_description_line_4, secutiry_description_line_5, user_cusip_identifier, price_purge_date, taxable_indicator, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, state_tax_ind, fts_ind, amt_ind, ric_indicator, number_of_description_lines, secutiry_description_line_1, secutiry_description_line_2, secutiry_description_line_3, secutiry_description_line_4, secutiry_description_line_5, user_cusip_identifier, price_purge_date, taxable_indicator, eor
    FROM stage_pershing.fn_parse_isca_reg_c(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_d (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, secutiry_description_line_6, put_price, put_date, second_premium_call_price, second_premium_call_date, called_date, pool_number, factor, factor_date, previous_factor, previous_factor_date, variable_rate_indicator, next_last_coupon_date, structured_product_ind, perpetual_bond_indicator, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, secutiry_description_line_6, put_price, put_date, second_premium_call_price, second_premium_call_date, called_date, pool_number, factor, factor_date, previous_factor, previous_factor_date, variable_rate_indicator, next_last_coupon_date, structured_product_ind, perpetual_bond_indicator, eor
    FROM stage_pershing.fn_parse_isca_reg_d(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_e (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, exp_first_call_price, exp_first_par_call_price, exp_put_price, exp_second_premium_call_price, name_issuer_security, issuing_currency, globally_locked_sec_ind, globally_locked_reason_code, spac_ind, campo_14, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, exp_first_call_price, exp_first_par_call_price, exp_put_price, exp_second_premium_call_price, name_issuer_security, issuing_currency, globally_locked_sec_ind, globally_locked_reason_code, spac_ind, campo_14, eor
    FROM stage_pershing.fn_parse_isca_reg_e(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_f (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, expanded_bid_price, expanded_ask_price, expanded_previous_day_price, expanded_latest_price, expanded_end_of_month_price, contract_share_quantity, year_covered_under_cost_basis_rules, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, expanded_bid_price, expanded_ask_price, expanded_previous_day_price, expanded_latest_price, expanded_end_of_month_price, contract_share_quantity, year_covered_under_cost_basis_rules, eor
    FROM stage_pershing.fn_parse_isca_reg_f(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_g (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, delta, delta_sign, delta_value_presence_ind, campo_8, isin_code, issuer_identifier, campo_11, campo_12, symbol_of_the_underlying_security, asset_type, asset_subtype, asset_subsubtype, payment_day_delays, campo_18, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, delta, delta_sign, delta_value_presence_ind, campo_8, isin_code, issuer_identifier, campo_11, campo_12, symbol_of_the_underlying_security, asset_type, asset_subtype, asset_subsubtype, payment_day_delays, campo_18, eor
    FROM stage_pershing.fn_parse_isca_reg_g(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_h (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, exchange_rate_denom_currency_usd, underlying_cusip_1, campo_7, deliverable_unit_quantity_1, underlying_cusip_2, campo_10, deliverable_unit_quantity_2, underlying_cusip_3, campo_13, deliverable_unit_quantity_3, underlying_cusip_4, campo_16, deliverable_unit_quantity_4, annual_dividend_currency_code, outstanding_shares, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, exchange_rate_denom_currency_usd, underlying_cusip_1, campo_7, deliverable_unit_quantity_1, underlying_cusip_2, campo_10, deliverable_unit_quantity_2, underlying_cusip_3, campo_13, deliverable_unit_quantity_3, underlying_cusip_4, campo_16, deliverable_unit_quantity_4, annual_dividend_currency_code, outstanding_shares, eor
    FROM stage_pershing.fn_parse_isca_reg_h(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_i (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, option_root_id, expiration_date, call_put_indicator, strike_price, fund_type, broad_narrow_indicator, leverage_factor, leverage_factor_sign, outstanding_shares_update_date, expanded_symbol, state_of_issuance, option_excercise_pricing_model_code, first_accrual_date, tranche_code, campo_19, worthless_security_indicator, uit_termination_code, fdic_certification_number, revenue_stream, restricted_marijuana_ind, campo_25, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, option_root_id, expiration_date, call_put_indicator, strike_price, fund_type, broad_narrow_indicator, leverage_factor, leverage_factor_sign, outstanding_shares_update_date, expanded_symbol, state_of_issuance, option_excercise_pricing_model_code, first_accrual_date, tranche_code, campo_19, worthless_security_indicator, uit_termination_code, fdic_certification_number, revenue_stream, restricted_marijuana_ind, campo_25, eor
    FROM stage_pershing.fn_parse_isca_reg_i(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_j (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, latest_price, latest_price_date, factored_market_value_multiplier, current_yield, yield, price_source, country_of_origin, retricted_security_code, international_non_dollar_symbol, international_exchange, variable_rate_category_code, interest_rate_completion_ind, campo_17, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, latest_price, latest_price_date, factored_market_value_multiplier, current_yield, yield, price_source, country_of_origin, retricted_security_code, international_non_dollar_symbol, international_exchange, variable_rate_category_code, interest_rate_completion_ind, campo_17, eor
    FROM stage_pershing.fn_parse_isca_reg_j(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_k (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, exchange_code_sedol_1, sedol_1, exchange_code_sedol_2, sedol_2, exchange_code_sedol_3, sedol_3, exchange_code_sedol_4, sedol_4, exchange_code_sedol_5, sedol_5, exchange_code_sedol_6, sedol_6, exchange_code_sedol_7, sedol_7, exchange_code_sedol_8, sedol_8, exchange_code_sedol_9, sedol_9, exchange_code_sedol_10, sedol_10, exchange_code_sedol_11, sedol_11, campo_26, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, exchange_code_sedol_1, sedol_1, exchange_code_sedol_2, sedol_2, exchange_code_sedol_3, sedol_3, exchange_code_sedol_4, sedol_4, exchange_code_sedol_5, sedol_5, exchange_code_sedol_6, sedol_6, exchange_code_sedol_7, sedol_7, exchange_code_sedol_8, sedol_8, exchange_code_sedol_9, sedol_9, exchange_code_sedol_10, sedol_10, exchange_code_sedol_11, sedol_11, campo_26, eor
    FROM stage_pershing.fn_parse_isca_reg_k(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_l (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, primary_idc_mkt_exch, primary_mkt_exch_trading_status, primary_mkt_symbol, primary_mkt_exch_effective_date, primary_mkt_status_code, secondary_idc_mkt_exch, secondary_mkt_exch_trading_status, secondary_mkt_symbol, secondary_mkt_exch_effective_date, secondary_mkt_status_code, tick_size_pilot_group, tick_size_effective_date, tick_size_change_date, update_date, oas_libor_rate, oas_libor_rate_sign, campo_21, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, primary_idc_mkt_exch, primary_mkt_exch_trading_status, primary_mkt_symbol, primary_mkt_exch_effective_date, primary_mkt_status_code, secondary_idc_mkt_exch, secondary_mkt_exch_trading_status, secondary_mkt_symbol, secondary_mkt_exch_effective_date, secondary_mkt_status_code, tick_size_pilot_group, tick_size_effective_date, tick_size_change_date, update_date, oas_libor_rate, oas_libor_rate_sign, campo_21, eor
    FROM stage_pershing.fn_parse_isca_reg_l(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_m (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, campo_5, first_call_date, first_call_price, campo_8, second_call_date, second_call_price, campo_11, third_call_date, third_call_price, campo_14, fourth_call_date, fourth_call_price, campo_17, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, campo_5, first_call_date, first_call_price, campo_8, second_call_date, second_call_price, campo_11, third_call_date, third_call_price, campo_14, fourth_call_date, fourth_call_price, campo_17, eor
    FROM stage_pershing.fn_parse_isca_reg_m(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_n (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, campo_5, effective_date_rate_1, coupon_interest_rate_1, campo_8, effective_date_rate_2, coupon_interest_rate_2, campo_11, effective_date_rate_3, coupon_interest_rate_3, campo_14, effective_date_rate_4, coupon_interest_rate_4, campo_17, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, campo_5, effective_date_rate_1, coupon_interest_rate_1, campo_8, effective_date_rate_2, coupon_interest_rate_2, campo_11, effective_date_rate_3, coupon_interest_rate_3, campo_14, effective_date_rate_4, coupon_interest_rate_4, campo_17, eor
    FROM stage_pershing.fn_parse_isca_reg_n(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_o (id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, oas_treasury_rate, oas_treasury_rate_sign, oas_treasury_effective_date, minimum_piece, minimum_increment, issue_date_security, campo_11, eor)
    SELECT id_proceso, process_date, record_indicator, record_id_sequence_number, cusip_number, campo_4, oas_treasury_rate, oas_treasury_rate_sign, oas_treasury_effective_date, minimum_piece, minimum_increment, issue_date_security, campo_11, eor
    FROM stage_pershing.fn_parse_isca_reg_o(_id_proceso);

    INSERT INTO stage_pershing.stage_isca_reg_trailer (id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, number_detail_of_records, campo_9, refreshed_or_updated, campo_11, eor)
    SELECT id_proceso, process_date, eof, campo_2, campo_3, date_of_data, campo_5, remote_id, campo_7, number_detail_of_records, campo_9, refreshed_or_updated, campo_11, eor
    FROM stage_pershing.fn_parse_isca_reg_trailer(_id_proceso);

end;
$$;

alter procedure stage_pershing.pa_parse_isca(bigint) owner to postgres;

