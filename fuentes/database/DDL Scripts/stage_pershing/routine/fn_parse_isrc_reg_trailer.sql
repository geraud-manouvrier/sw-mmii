create or replace function stage_pershing.fn_parse_isrc_reg_trailer(_id_proceso bigint) returns SETOF stage_pershing.stage_isrc_reg_trailer
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        id, id_proceso, process_date::VARCHAR(100),
        eof::VARCHAR(100),
        campo_2::VARCHAR(100),
        campo_3::VARCHAR(100),
        date_of_data::VARCHAR(100),
        campo_5::VARCHAR(100),
        remote_id::VARCHAR(100),
        campo_7::VARCHAR(100),
        campo_8::VARCHAR(100),
        number_of_records::int,
        campo_10::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isrc_reg_trailer(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isrc_reg_trailer(bigint) owner to postgres;

