create or replace function stage_pershing.fn_parse_acct_reg_f(_id_proceso bigint) returns SETOF stage_pershing.stage_acct_reg_f
    language plpgsql
as
$$
    BEGIN

    RETURN QUERY
    SELECT
        fn_reg.id::bigint, fn_reg.id_proceso::bigint, fn_reg.process_date::VARCHAR(100),
        fn_reg.transaction_code::VARCHAR(100),
        fn_reg.record_indicator_value::VARCHAR(100),
        fn_reg.record_id_sequence_number::int as record_id_sequence_number,
        fn_reg.account_number::VARCHAR(100),
        fn_reg.ibd_number::VARCHAR(100),
        fn_reg.campo_6::VARCHAR(100),
        fn_reg.ip_number::VARCHAR(100),
        fn_reg.account_short_name::VARCHAR(100),
        fn_reg.campo_9::VARCHAR(100),
        fn_reg.addr_7_trx_code::VARCHAR(100),
        fn_reg.addr_7_special_handling_ind::VARCHAR(100),
        fn_reg.addr_7_delivery_id::VARCHAR(100),
        fn_reg.addr_7_attention_line_prefix::VARCHAR(100),
        fn_reg.addr_7_attention_line_detail::VARCHAR(100),
        fn_reg.addr_7_line_1::VARCHAR(100),
        fn_reg.addr_7_line_2::VARCHAR(100),
        fn_reg.addr_7_line_3::VARCHAR(100),
        fn_reg.addr_7_line_4::VARCHAR(100),
        fn_reg.addr_7_city_state::VARCHAR(100),
        fn_reg.addr_7_country_code::VARCHAR(100),
        fn_reg.set_as_mail_addr_7_ind::VARCHAR(100),
        fn_reg.campo_22::VARCHAR(100),
        fn_reg.eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_acct_reg_f(_id_proceso) fn_reg
    ORDER BY fn_reg.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_acct_reg_f(bigint) owner to postgres;

