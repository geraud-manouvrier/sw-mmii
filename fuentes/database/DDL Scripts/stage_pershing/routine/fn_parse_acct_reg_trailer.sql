create or replace function stage_pershing.fn_parse_acct_reg_trailer(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_trailer
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        fn_reg.id::bigint, fn_reg.id_proceso::bigint, fn_reg.process_date::VARCHAR(100),
        fn_reg.eof::VARCHAR(100),
        fn_reg.campo_02::VARCHAR(100),
        fn_reg.campo_03::VARCHAR(100),
        fn_reg.date_of_data::VARCHAR(100),
        fn_reg.campo_05::VARCHAR(100),
        fn_reg.remote_id::VARCHAR(100),
        fn_reg.campo_07::VARCHAR(100),
        fn_reg.campo_08::VARCHAR(100),
        fn_reg.number_of_detail_records::int as number_of_detail_records,
        fn_reg.campo_10::VARCHAR(100),
        fn_reg.refreshed_or_updated::VARCHAR(100),
        fn_reg.campo_12::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_trailer(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_acct_reg_trailer(bigint) owner to postgres;

