create or replace function stage_pershing.fn_extrae_isca_reg_k(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, exchange_code_sedol_1 character varying, sedol_1 character varying, exchange_code_sedol_2 character varying, sedol_2 character varying, exchange_code_sedol_3 character varying, sedol_3 character varying, exchange_code_sedol_4 character varying, sedol_4 character varying, exchange_code_sedol_5 character varying, sedol_5 character varying, exchange_code_sedol_6 character varying, sedol_6 character varying, exchange_code_sedol_7 character varying, sedol_7 character varying, exchange_code_sedol_8 character varying, sedol_8 character varying, exchange_code_sedol_9 character varying, sedol_9 character varying, exchange_code_sedol_10 character varying, sedol_10 character varying, exchange_code_sedol_11 character varying, sedol_11 character varying, campo_26 character varying, eor character varying)
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT sfl_file.id, sfl_file.id_proceso, sfl_file.process_date,
        substr(sfl_file.linea, 1, 1)::VARCHAR(100) as record_indicator,
        substr(sfl_file.linea, 2, 6)::VARCHAR(100) as record_id_sequence_number,
        substr(sfl_file.linea, 8, 9)::VARCHAR(100) as cusip_number,
        substr(sfl_file.linea, 17, 3)::VARCHAR(100) as exchange_code_sedol_1,
        substr(sfl_file.linea, 20, 7)::VARCHAR(100) as sedol_1,
        substr(sfl_file.linea, 27, 3)::VARCHAR(100) as exchange_code_sedol_2,
        substr(sfl_file.linea, 30, 7)::VARCHAR(100) as sedol_2,
        substr(sfl_file.linea, 37, 3)::VARCHAR(100) as exchange_code_sedol_3,
        substr(sfl_file.linea, 40, 7)::VARCHAR(100) as sedol_3,
        substr(sfl_file.linea, 47, 3)::VARCHAR(100) as exchange_code_sedol_4,
        substr(sfl_file.linea, 50, 7)::VARCHAR(100) as sedol_4,
        substr(sfl_file.linea, 57, 3)::VARCHAR(100) as exchange_code_sedol_5,
        substr(sfl_file.linea, 60, 7)::VARCHAR(100) as sedol_5,
        substr(sfl_file.linea, 67, 3)::VARCHAR(100) as exchange_code_sedol_6,
        substr(sfl_file.linea, 70, 7)::VARCHAR(100) as sedol_6,
        substr(sfl_file.linea, 77, 3)::VARCHAR(100) as exchange_code_sedol_7,
        substr(sfl_file.linea, 80, 7)::VARCHAR(100) as sedol_7,
        substr(sfl_file.linea, 87, 3)::VARCHAR(100) as exchange_code_sedol_8,
        substr(sfl_file.linea, 90, 7)::VARCHAR(100) as sedol_8,
        substr(sfl_file.linea, 97, 3)::VARCHAR(100) as exchange_code_sedol_9,
        substr(sfl_file.linea, 100, 7)::VARCHAR(100) as sedol_9,
        substr(sfl_file.linea, 107, 3)::VARCHAR(100) as exchange_code_sedol_10,
        substr(sfl_file.linea, 110, 7)::VARCHAR(100) as sedol_10,
        substr(sfl_file.linea, 117, 3)::VARCHAR(100) as exchange_code_sedol_11,
        substr(sfl_file.linea, 120, 7)::VARCHAR(100) as sedol_11,
        substr(sfl_file.linea, 127, 5)::VARCHAR(100) as campo_26,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'K'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_k(bigint) owner to postgres;

