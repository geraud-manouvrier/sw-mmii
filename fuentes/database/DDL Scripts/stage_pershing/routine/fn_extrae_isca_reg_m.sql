create or replace function stage_pershing.fn_extrae_isca_reg_m(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, campo_5 character varying, first_call_date character varying, first_call_price character varying, campo_8 character varying, second_call_date character varying, second_call_price character varying, campo_11 character varying, third_call_date character varying, third_call_price character varying, campo_14 character varying, fourth_call_date character varying, fourth_call_price character varying, campo_17 character varying, eor character varying)
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
        substr(sfl_file.linea, 21, 1)::VARCHAR(100) as campo_5,
        substr(sfl_file.linea, 22, 8)::VARCHAR(100) as first_call_date,
        substr(sfl_file.linea, 30, 18)::VARCHAR(100) as first_call_price,
        substr(sfl_file.linea, 48, 1)::VARCHAR(100) as campo_8,
        substr(sfl_file.linea, 49, 8)::VARCHAR(100) as second_call_date,
        substr(sfl_file.linea, 57, 18)::VARCHAR(100) as second_call_price,
        substr(sfl_file.linea, 75, 1)::VARCHAR(100) as campo_11,
        substr(sfl_file.linea, 76, 8)::VARCHAR(100) as third_call_date,
        substr(sfl_file.linea, 84, 18)::VARCHAR(100) as third_call_price,
        substr(sfl_file.linea, 102, 1)::VARCHAR(100) as campo_14,
        substr(sfl_file.linea, 103, 8)::VARCHAR(100) as fourth_call_date,
        substr(sfl_file.linea, 111, 18)::VARCHAR(100) as fourth_call_price,
        substr(sfl_file.linea, 129, 3)::VARCHAR(100) as campo_17,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'M'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_m(bigint) owner to postgres;

