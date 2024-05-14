create or replace function stage_pershing.fn_extrae_isca_reg_h(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, exchange_rate_denom_currency_usd character varying, underlying_cusip_1 character varying, campo_7 character varying, deliverable_unit_quantity_1 character varying, underlying_cusip_2 character varying, campo_10 character varying, deliverable_unit_quantity_2 character varying, underlying_cusip_3 character varying, campo_13 character varying, deliverable_unit_quantity_3 character varying, underlying_cusip_4 character varying, campo_16 character varying, deliverable_unit_quantity_4 character varying, annual_dividend_currency_code character varying, outstanding_shares character varying, eor character varying)
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
        substr(sfl_file.linea, 21, 18)::VARCHAR(100) as exchange_rate_denom_currency_usd,
        substr(sfl_file.linea, 39, 9)::VARCHAR(100) as underlying_cusip_1,
        substr(sfl_file.linea, 48, 4)::VARCHAR(100) as campo_7,
        substr(sfl_file.linea, 52, 5)::VARCHAR(100) as deliverable_unit_quantity_1,
        substr(sfl_file.linea, 57, 9)::VARCHAR(100) as underlying_cusip_2,
        substr(sfl_file.linea, 66, 4)::VARCHAR(100) as campo_10,
        substr(sfl_file.linea, 70, 5)::VARCHAR(100) as deliverable_unit_quantity_2,
        substr(sfl_file.linea, 75, 9)::VARCHAR(100) as underlying_cusip_3,
        substr(sfl_file.linea, 84, 4)::VARCHAR(100) as campo_13,
        substr(sfl_file.linea, 88, 5)::VARCHAR(100) as deliverable_unit_quantity_3,
        substr(sfl_file.linea, 93, 9)::VARCHAR(100) as underlying_cusip_4,
        substr(sfl_file.linea, 102, 4)::VARCHAR(100) as campo_16,
        substr(sfl_file.linea, 106, 5)::VARCHAR(100) as deliverable_unit_quantity_4,
        substr(sfl_file.linea, 111, 3)::VARCHAR(100) as annual_dividend_currency_code,
        substr(sfl_file.linea, 114, 18)::VARCHAR(100) as outstanding_shares,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'H'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_h(bigint) owner to postgres;

