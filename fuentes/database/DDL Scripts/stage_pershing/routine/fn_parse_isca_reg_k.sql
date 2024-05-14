create or replace function stage_pershing.fn_parse_isca_reg_k(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_k
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        record_indicator::VARCHAR(100),
        record_id_sequence_number::int,
        cusip_number::VARCHAR(100),
        exchange_code_sedol_1::VARCHAR(100),
        sedol_1::VARCHAR(100),
        exchange_code_sedol_2::VARCHAR(100),
        sedol_2::VARCHAR(100),
        exchange_code_sedol_3::VARCHAR(100),
        sedol_3::VARCHAR(100),
        exchange_code_sedol_4::VARCHAR(100),
        sedol_4::VARCHAR(100),
        exchange_code_sedol_5::VARCHAR(100),
        sedol_5::VARCHAR(100),
        exchange_code_sedol_6::VARCHAR(100),
        sedol_6::VARCHAR(100),
        exchange_code_sedol_7::VARCHAR(100),
        sedol_7::VARCHAR(100),
        exchange_code_sedol_8::VARCHAR(100),
        sedol_8::VARCHAR(100),
        exchange_code_sedol_9::VARCHAR(100),
        sedol_9::VARCHAR(100),
        exchange_code_sedol_10::VARCHAR(100),
        sedol_10::VARCHAR(100),
        exchange_code_sedol_11::VARCHAR(100),
        sedol_11::VARCHAR(100),
        campo_26::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_k(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_k(bigint) owner to postgres;

