create or replace function stage_pershing.fn_extrae_gact_reg_b(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, transaction_code character varying, record_indicator_value character varying, record_id_sequence_number character varying, account_number character varying, security_currency_of_issuance character varying, trade_currency_code character varying, settlement_currency_code character varying, settlement_usd_currency_fx_rate character varying, settlement_usd_multiply_divide_code character varying, cross_currency_fx_rate character varying, currency_multiply_divide_code character varying, accrued_interest_in_settlement_currency character varying, accrued_interest_in_settlement_currency_sign character varying, market_code character varying, internal_reference_for_gloss character varying, ibd_version character varying, net_amount_in_settlement_currency character varying, net_amount_in_settlement_currency_sign character varying, principal_amount_in_settlement_currency character varying, principal_amount_in_settlement_currency_sign character varying, interest_in_settlement_currency character varying, interest_in_settlement_currency_sign character varying, commission_in_settlement_currency character varying, commission_in_settlement_currency_sign character varying, tax_in_settlement_currency character varying, tax_in_settlement_currency_sign character varying, transaction_fee_in_settlement_currency character varying, transaction_fee_in_settlement_currency_sign character varying, miscellaneous_fee_in_settlement_currency character varying, miscellaneous_fee_in_settlement_currency_sign character varying, other_fee_in_settlement_currency character varying, other_fee_in_settlement_currency_sign character varying, sales_credit_in_settlement_currency character varying, sales_credit_in_settlement_currency_sign character varying, settlement_fee_in_settlement_currency character varying, settlement_fee_in_settlement_currency_sign character varying, service_charge_in_settlement_currency character varying, service_charge_in_settlement_currency_sign character varying, markup_markdown_in_settlement_currency character varying, markup_markdown_in_settlement_currency_sign character varying, global_exchange character varying, number_of_description_lines character varying, last_description_line character varying, description_line_1 character varying, description_line_2 character varying, description_line_3 character varying, description_line_4 character varying, description_line_5 character varying, description_line_6 character varying, description_line_7 character varying, description_line_8 character varying, description_line_9 character varying, description_line_10 character varying, description_line_11 character varying, description_line_12 character varying, security_currency_indicator character varying, market_mnemonic_code character varying, ccy_of_issuance_usd_ccy_fx_rate character varying, ccy_of_issuance_usd_multiply_divide_code character varying, alternate_security_id_type character varying, alternate_security_id character varying, alternate_security_id_type_2 character varying, alternate_security_id_2 character varying, international_non_dollar_symbol character varying, confirmation_code_1 character varying, confirmation_code_2 character varying, confirmation_code_3 character varying, confirmation_code_4 character varying, pmp character varying, total_amount_mark_up_down character varying, total_amount_mark_up_down_sign character varying, pmp_percent character varying, campo_73 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 2)::VARCHAR(100) as transaction_code,
        substr(sfl_file.linea, 3, 1)::VARCHAR(100) as record_indicator_value,
        substr(sfl_file.linea, 4, 8)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 12, 10)::VARCHAR(100) as account_number,
        substr(sfl_file.linea, 22, 3)::VARCHAR(100) as security_currency_of_issuance,
        substr(sfl_file.linea, 25, 3)::VARCHAR(100) as trade_currency_code,
        substr(sfl_file.linea, 28, 3)::VARCHAR(100) as settlement_currency_code,
        substr(sfl_file.linea, 31, 18)::VARCHAR(100) as settlement_usd_currency_fx_rate,
        substr(sfl_file.linea, 49, 1)::VARCHAR(100) as settlement_usd_multiply_divide_code,
        substr(sfl_file.linea, 50, 18)::VARCHAR(100) as cross_currency_fx_rate,
        substr(sfl_file.linea, 68, 1)::VARCHAR(100) as currency_multiply_divide_code,
        substr(sfl_file.linea, 69, 18)::VARCHAR(100) as accrued_interest_in_settlement_currency,
        substr(sfl_file.linea, 87, 1)::VARCHAR(100) as accrued_interest_in_settlement_currency_sign,
        substr(sfl_file.linea, 88, 12)::VARCHAR(100) as market_code,
        substr(sfl_file.linea, 100, 20)::VARCHAR(100) as internal_reference_for_gloss,
        substr(sfl_file.linea, 120, 2)::VARCHAR(100) as ibd_version,
        substr(sfl_file.linea, 122, 18)::VARCHAR(100) as net_amount_in_settlement_currency,
        substr(sfl_file.linea, 140, 1)::VARCHAR(100) as net_amount_in_settlement_currency_sign,
        substr(sfl_file.linea, 141, 18)::VARCHAR(100) as principal_amount_in_settlement_currency,
        substr(sfl_file.linea, 159, 1)::VARCHAR(100) as principal_amount_in_settlement_currency_sign,
        substr(sfl_file.linea, 160, 18)::VARCHAR(100) as interest_in_settlement_currency,
        substr(sfl_file.linea, 178, 1)::VARCHAR(100) as interest_in_settlement_currency_sign,
        substr(sfl_file.linea, 179, 18)::VARCHAR(100) as commission_in_settlement_currency,
        substr(sfl_file.linea, 197, 1)::VARCHAR(100) as commission_in_settlement_currency_sign,
        substr(sfl_file.linea, 198, 18)::VARCHAR(100) as tax_in_settlement_currency,
        substr(sfl_file.linea, 216, 1)::VARCHAR(100) as tax_in_settlement_currency_sign,
        substr(sfl_file.linea, 217, 18)::VARCHAR(100) as transaction_fee_in_settlement_currency,
        substr(sfl_file.linea, 235, 1)::VARCHAR(100) as transaction_fee_in_settlement_currency_sign,
        substr(sfl_file.linea, 236, 18)::VARCHAR(100) as miscellaneous_fee_in_settlement_currency,
        substr(sfl_file.linea, 254, 1)::VARCHAR(100) as miscellaneous_fee_in_settlement_currency_sign,
        substr(sfl_file.linea, 255, 18)::VARCHAR(100) as other_fee_in_settlement_currency,
        substr(sfl_file.linea, 273, 1)::VARCHAR(100) as other_fee_in_settlement_currency_sign,
        substr(sfl_file.linea, 274, 18)::VARCHAR(100) as sales_credit_in_settlement_currency,
        substr(sfl_file.linea, 292, 1)::VARCHAR(100) as sales_credit_in_settlement_currency_sign,
        substr(sfl_file.linea, 293, 18)::VARCHAR(100) as settlement_fee_in_settlement_currency,
        substr(sfl_file.linea, 311, 1)::VARCHAR(100) as settlement_fee_in_settlement_currency_sign,
        substr(sfl_file.linea, 312, 18)::VARCHAR(100) as service_charge_in_settlement_currency,
        substr(sfl_file.linea, 330, 1)::VARCHAR(100) as service_charge_in_settlement_currency_sign,
        substr(sfl_file.linea, 331, 18)::VARCHAR(100) as markup_markdown_in_settlement_currency,
        substr(sfl_file.linea, 349, 1)::VARCHAR(100) as markup_markdown_in_settlement_currency_sign,
        substr(sfl_file.linea, 350, 4)::VARCHAR(100) as global_exchange,
        substr(sfl_file.linea, 354, 2)::VARCHAR(100) as number_of_description_lines,
        substr(sfl_file.linea, 356, 2)::VARCHAR(100) as last_description_line,
        substr(sfl_file.linea, 358, 20)::VARCHAR(100) as description_line_1,
        substr(sfl_file.linea, 378, 20)::VARCHAR(100) as description_line_2,
        substr(sfl_file.linea, 398, 20)::VARCHAR(100) as description_line_3,
        substr(sfl_file.linea, 418, 20)::VARCHAR(100) as description_line_4,
        substr(sfl_file.linea, 438, 20)::VARCHAR(100) as description_line_5,
        substr(sfl_file.linea, 458, 20)::VARCHAR(100) as description_line_6,
        substr(sfl_file.linea, 478, 20)::VARCHAR(100) as description_line_7,
        substr(sfl_file.linea, 498, 20)::VARCHAR(100) as description_line_8,
        substr(sfl_file.linea, 518, 20)::VARCHAR(100) as description_line_9,
        substr(sfl_file.linea, 538, 20)::VARCHAR(100) as description_line_10,
        substr(sfl_file.linea, 558, 20)::VARCHAR(100) as description_line_11,
        substr(sfl_file.linea, 578, 20)::VARCHAR(100) as description_line_12,
        substr(sfl_file.linea, 598, 1)::VARCHAR(100) as security_currency_indicator,
        substr(sfl_file.linea, 599, 4)::VARCHAR(100) as market_mnemonic_code,
        substr(sfl_file.linea, 603, 18)::VARCHAR(100) as ccy_of_issuance_usd_ccy_fx_rate,
        substr(sfl_file.linea, 621, 1)::VARCHAR(100) as ccy_of_issuance_usd_multiply_divide_code,
        substr(sfl_file.linea, 622, 1)::VARCHAR(100) as alternate_security_id_type,
        substr(sfl_file.linea, 623, 12)::VARCHAR(100) as alternate_security_id,
        substr(sfl_file.linea, 635, 1)::VARCHAR(100) as alternate_security_id_type_2,
        substr(sfl_file.linea, 636, 12)::VARCHAR(100) as alternate_security_id_2,
        substr(sfl_file.linea, 648, 16)::VARCHAR(100) as international_non_dollar_symbol,
        substr(sfl_file.linea, 664, 2)::VARCHAR(100) as confirmation_code_1,
        substr(sfl_file.linea, 666, 2)::VARCHAR(100) as confirmation_code_2,
        substr(sfl_file.linea, 668, 2)::VARCHAR(100) as confirmation_code_3,
        substr(sfl_file.linea, 670, 2)::VARCHAR(100) as confirmation_code_4,
        substr(sfl_file.linea, 672, 18)::VARCHAR(100) as pmp,
        substr(sfl_file.linea, 690, 18)::VARCHAR(100) as total_amount_mark_up_down,
        substr(sfl_file.linea, 708, 1)::VARCHAR(100) as total_amount_mark_up_down_sign,
        substr(sfl_file.linea, 709, 9)::VARCHAR(100) as pmp_percent,
        substr(sfl_file.linea, 718, 32)::VARCHAR(100) as campo_73,
        substr(sfl_file.linea, 750, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_gact_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 3)		= 'GAB'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_gact_reg_b(bigint) owner to postgres;

