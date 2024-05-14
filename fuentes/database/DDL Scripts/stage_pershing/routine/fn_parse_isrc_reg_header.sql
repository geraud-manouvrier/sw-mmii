create or replace function stage_pershing.fn_parse_isrc_reg_header(_id_proceso bigint) returns SETOF stage_pershing.stage_isrc_reg_header
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        bof::VARCHAR(100),
        campo_2::VARCHAR(100),
        campo_3::VARCHAR(100),
        date_of_data::VARCHAR(100),
        campo_5::VARCHAR(100),
        remote_id::VARCHAR(100),
        campo_7::VARCHAR(100),
        run_date::VARCHAR(100),
        campo_9::VARCHAR(100),
        run_time::VARCHAR(100),
        campo_11::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isrc_reg_header(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isrc_reg_header(bigint) owner to postgres;

