create or replace function stage_pershing.fn_extrae_isca_reg_f(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, expanded_bid_price character varying, expanded_ask_price character varying, expanded_previous_day_price character varying, expanded_latest_price character varying, expanded_end_of_month_price character varying, contract_share_quantity character varying, year_covered_under_cost_basis_rules character varying, eor character varying)
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
        substr(sfl_file.linea, 21, 18)::VARCHAR(100) as expanded_bid_price,
        substr(sfl_file.linea, 39, 18)::VARCHAR(100) as expanded_ask_price,
        substr(sfl_file.linea, 57, 18)::VARCHAR(100) as expanded_previous_day_price,
        substr(sfl_file.linea, 75, 18)::VARCHAR(100) as expanded_latest_price,
        substr(sfl_file.linea, 93, 18)::VARCHAR(100) as expanded_end_of_month_price,
        substr(sfl_file.linea, 111, 17)::VARCHAR(100) as contract_share_quantity,
        substr(sfl_file.linea, 128, 4)::VARCHAR(100) as year_covered_under_cost_basis_rules,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'F'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_f(bigint) owner to postgres;

