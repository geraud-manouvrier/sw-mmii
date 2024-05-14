create or replace function stage_pershing.fn_parse_isca_reg_c(_id_proceso bigint) returns SETOF stage_pershing.stage_isca_reg_c
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
        state_tax_ind::VARCHAR(100),
        fts_ind::VARCHAR(100),
        amt_ind::VARCHAR(100),
        ric_indicator::VARCHAR(100),
        number_of_description_lines::VARCHAR(100),
        secutiry_description_line_1::VARCHAR(100),
        secutiry_description_line_2::VARCHAR(100),
        secutiry_description_line_3::VARCHAR(100),
        secutiry_description_line_4::VARCHAR(100),
        secutiry_description_line_5::VARCHAR(100),
        user_cusip_identifier::VARCHAR(100),
        public.fn_fecha_string_to_date(price_purge_date, 'CCYYDDD') as price_purge_date,
        taxable_indicator::VARCHAR(100),
        eor::VARCHAR(100)

    FROM stage_pershing.fn_extrae_isca_reg_c(_id_proceso)
    ORDER BY id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_parse_isca_reg_c(bigint) owner to postgres;

