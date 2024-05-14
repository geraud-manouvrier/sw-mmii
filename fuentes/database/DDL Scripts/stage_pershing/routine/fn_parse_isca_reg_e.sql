create or replace function stage_pershing.fn_parse_isca_reg_e(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_e
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
        campo_4::VARCHAR(100),
        public.fn_convierte_texto_numerico_cobol(exp_first_call_price, 9)::NUMERIC(45,20) as exp_first_call_price,
        public.fn_convierte_texto_numerico_cobol(exp_first_par_call_price, 9)::NUMERIC(45,20) as exp_first_par_call_price,
        public.fn_convierte_texto_numerico_cobol(exp_put_price, 9)::NUMERIC(45,20) as exp_put_price,
        public.fn_convierte_texto_numerico_cobol(exp_second_premium_call_price, 9)::NUMERIC(45,20) as exp_second_premium_call_price,
        name_issuer_security::VARCHAR(100),
        issuing_currency::VARCHAR(100),
        globally_locked_sec_ind::VARCHAR(100),
        globally_locked_reason_code::VARCHAR(100),
        spac_ind::VARCHAR(100),
        campo_14::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_e(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_e(bigint) owner to postgres;

