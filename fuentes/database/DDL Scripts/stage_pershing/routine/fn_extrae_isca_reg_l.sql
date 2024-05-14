create or replace function stage_pershing.fn_extrae_isca_reg_l(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, primary_idc_mkt_exch character varying, primary_mkt_exch_trading_status character varying, primary_mkt_symbol character varying, primary_mkt_exch_effective_date character varying, primary_mkt_status_code character varying, secondary_idc_mkt_exch character varying, secondary_mkt_exch_trading_status character varying, secondary_mkt_symbol character varying, secondary_mkt_exch_effective_date character varying, secondary_mkt_status_code character varying, tick_size_pilot_group character varying, tick_size_effective_date character varying, tick_size_change_date character varying, update_date character varying, oas_libor_rate character varying, oas_libor_rate_sign character varying, campo_21 character varying, eor character varying)
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
        substr(sfl_file.linea, 21, 2)::VARCHAR(100) as primary_idc_mkt_exch,
        substr(sfl_file.linea, 23, 1)::VARCHAR(100) as primary_mkt_exch_trading_status,
        substr(sfl_file.linea, 24, 16)::VARCHAR(100) as primary_mkt_symbol,
        substr(sfl_file.linea, 40, 8)::VARCHAR(100) as primary_mkt_exch_effective_date,
        substr(sfl_file.linea, 48, 3)::VARCHAR(100) as primary_mkt_status_code,
        substr(sfl_file.linea, 51, 2)::VARCHAR(100) as secondary_idc_mkt_exch,
        substr(sfl_file.linea, 53, 1)::VARCHAR(100) as secondary_mkt_exch_trading_status,
        substr(sfl_file.linea, 54, 16)::VARCHAR(100) as secondary_mkt_symbol,
        substr(sfl_file.linea, 70, 8)::VARCHAR(100) as secondary_mkt_exch_effective_date,
        substr(sfl_file.linea, 78, 3)::VARCHAR(100) as secondary_mkt_status_code,
        substr(sfl_file.linea, 81, 2)::VARCHAR(100) as tick_size_pilot_group,
        substr(sfl_file.linea, 83, 8)::VARCHAR(100) as tick_size_effective_date,
        substr(sfl_file.linea, 91, 8)::VARCHAR(100) as tick_size_change_date,
        substr(sfl_file.linea, 99, 8)::VARCHAR(100) as update_date,
        substr(sfl_file.linea, 107, 18)::VARCHAR(100) as oas_libor_rate,
        substr(sfl_file.linea, 125, 1)::VARCHAR(100) as oas_libor_rate_sign,
        substr(sfl_file.linea, 126, 6)::VARCHAR(100) as campo_21,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'L'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_l(bigint) owner to postgres;

