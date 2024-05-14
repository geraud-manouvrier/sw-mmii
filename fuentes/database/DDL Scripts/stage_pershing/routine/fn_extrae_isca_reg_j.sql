create or replace function stage_pershing.fn_extrae_isca_reg_j(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, latest_price character varying, latest_price_date character varying, factored_market_value_multiplier character varying, current_yield character varying, yield character varying, price_source character varying, country_of_origin character varying, retricted_security_code character varying, international_non_dollar_symbol character varying, international_exchange character varying, variable_rate_category_code character varying, interest_rate_completion_ind character varying, campo_17 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 4)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 21, 18)::VARCHAR(100) as latest_price,
        substr(sfl_file.linea, 39, 8)::VARCHAR(100) as latest_price_date,
        substr(sfl_file.linea, 47, 18)::VARCHAR(100) as factored_market_value_multiplier,
        substr(sfl_file.linea, 65, 18)::VARCHAR(100) as current_yield,
        substr(sfl_file.linea, 83, 18)::VARCHAR(100) as yield,
        substr(sfl_file.linea, 101, 1)::VARCHAR(100) as price_source,
        substr(sfl_file.linea, 102, 2)::VARCHAR(100) as country_of_origin,
        substr(sfl_file.linea, 104, 1)::VARCHAR(100) as retricted_security_code,
        substr(sfl_file.linea, 105, 16)::VARCHAR(100) as international_non_dollar_symbol,
        substr(sfl_file.linea, 121, 6)::VARCHAR(100) as international_exchange,
        substr(sfl_file.linea, 127, 3)::VARCHAR(100) as variable_rate_category_code,
        substr(sfl_file.linea, 130, 1)::VARCHAR(100) as interest_rate_completion_ind,
        substr(sfl_file.linea, 131, 1)::VARCHAR(100) as campo_17,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'J'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_j(bigint) owner to postgres;

