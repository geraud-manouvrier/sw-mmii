create or replace function stage_pershing.fn_parse_acct_reg_header(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_header
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        fn_reg.id::bigint, fn_reg.id_proceso::bigint, fn_reg.process_date::VARCHAR(100),
        fn_reg.bof::VARCHAR(100),
        fn_reg.campo_2::VARCHAR(100),
        fn_reg.campo_3::VARCHAR(100),
        fn_reg.date_of_data::VARCHAR(100),
        fn_reg.campo_5::VARCHAR(100),
        fn_reg.remote_id::VARCHAR(100),
        fn_reg.campo_7::VARCHAR(100),
        fn_reg.run_date::VARCHAR(100),
        fn_reg.campo_9::VARCHAR(100),
        fn_reg.run_time::VARCHAR(100),
        fn_reg.campo_11::VARCHAR(100),
        fn_reg.refreshed_or_updated::VARCHAR(100),
        fn_reg.campo_13::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_header(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_acct_reg_header(bigint) owner to postgres;

