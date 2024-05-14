create or replace function stage_pershing.fn_extrae_isca_reg_b(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, etf_indicator character varying, bid_price character varying, ask_price character varying, previous_day_price character varying, latest_price character varying, end_of_month_price character varying, round_lot_quantity character varying, dividend_reinvestment_eligibility_indicator character varying, previous_price_date character varying, latest_price_date character varying, end_of_month_price_date character varying, record_date character varying, fundvest_ind character varying, country_code character varying, standard_poor_rating character varying, moodys_rating character varying, bond_sub_class character varying, restriction_indicator character varying, trace_indicator character varying, new_interest_calculation_code character varying, sic_code character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 3)::VARCHAR(100) as campo_4,
        substr(sfl_file.linea, 20, 1)::VARCHAR(100) as etf_indicator,
        substr(sfl_file.linea, 21, 9)::VARCHAR(100) as bid_price,
        substr(sfl_file.linea, 30, 9)::VARCHAR(100) as ask_price,
        substr(sfl_file.linea, 39, 9)::VARCHAR(100) as previous_day_price,
        substr(sfl_file.linea, 48, 9)::VARCHAR(100) as latest_price,
        substr(sfl_file.linea, 57, 9)::VARCHAR(100) as end_of_month_price,
        substr(sfl_file.linea, 66, 13)::VARCHAR(100) as round_lot_quantity,
        substr(sfl_file.linea, 79, 1)::VARCHAR(100) as dividend_reinvestment_eligibility_indicator,
        substr(sfl_file.linea, 80, 7)::VARCHAR(100) as previous_price_date,
        substr(sfl_file.linea, 87, 7)::VARCHAR(100) as latest_price_date,
        substr(sfl_file.linea, 94, 7)::VARCHAR(100) as end_of_month_price_date,
        substr(sfl_file.linea, 101, 7)::VARCHAR(100) as record_date,
        substr(sfl_file.linea, 108, 1)::VARCHAR(100) as fundvest_ind,
        substr(sfl_file.linea, 109, 3)::VARCHAR(100) as country_code,
        substr(sfl_file.linea, 112, 4)::VARCHAR(100) as standard_poor_rating,
        substr(sfl_file.linea, 116, 5)::VARCHAR(100) as moodys_rating,
        substr(sfl_file.linea, 121, 1)::VARCHAR(100) as bond_sub_class,
        substr(sfl_file.linea, 122, 4)::VARCHAR(100) as restriction_indicator,
        substr(sfl_file.linea, 126, 1)::VARCHAR(100) as trace_indicator,
        substr(sfl_file.linea, 127, 1)::VARCHAR(100) as new_interest_calculation_code,
        substr(sfl_file.linea, 128, 4)::VARCHAR(100) as sic_code,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    AND substr(sfl_file.linea, 1, 18)		<> 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'B'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_b(bigint) owner to postgres;

