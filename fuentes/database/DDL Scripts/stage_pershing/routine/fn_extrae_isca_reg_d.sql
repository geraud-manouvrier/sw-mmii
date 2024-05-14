create or replace function stage_pershing.fn_extrae_isca_reg_d(_id_proceso bigint)
    returns TABLE(id bigint, id_proceso bigint, process_date character varying, record_indicator character varying, record_id_sequence_number character varying, cusip_number character varying, campo_4 character varying, secutiry_description_line_6 character varying, put_price character varying, put_date character varying, second_premium_call_price character varying, second_premium_call_date character varying, called_date character varying, pool_number character varying, factor character varying, factor_date character varying, previous_factor character varying, previous_factor_date character varying, variable_rate_indicator character varying, next_last_coupon_date character varying, structured_product_ind character varying, perpetual_bond_indicator character varying, eor character varying)
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
        substr(sfl_file.linea, 21, 20)::VARCHAR(100) as secutiry_description_line_6,
        substr(sfl_file.linea, 41, 9)::VARCHAR(100) as put_price,
        substr(sfl_file.linea, 50, 7)::VARCHAR(100) as put_date,
        substr(sfl_file.linea, 57, 9)::VARCHAR(100) as second_premium_call_price,
        substr(sfl_file.linea, 66, 7)::VARCHAR(100) as second_premium_call_date,
        substr(sfl_file.linea, 73, 7)::VARCHAR(100) as called_date,
        substr(sfl_file.linea, 80, 8)::VARCHAR(100) as pool_number,
        substr(sfl_file.linea, 88, 10)::VARCHAR(100) as factor,
        substr(sfl_file.linea, 98, 7)::VARCHAR(100) as factor_date,
        substr(sfl_file.linea, 105, 10)::VARCHAR(100) as previous_factor,
        substr(sfl_file.linea, 115, 7)::VARCHAR(100) as previous_factor_date,
        substr(sfl_file.linea, 122, 1)::VARCHAR(100) as variable_rate_indicator,
        substr(sfl_file.linea, 123, 7)::VARCHAR(100) as next_last_coupon_date,
        substr(sfl_file.linea, 130, 1)::VARCHAR(100) as structured_product_ind,
        substr(sfl_file.linea, 131, 1)::VARCHAR(100) as perpetual_bond_indicator,
        substr(sfl_file.linea, 132, 1)::VARCHAR(100) as eor

    FROM stage_pershing.stage_isca_file sfl_file WHERE sfl_file.id_proceso = COALESCE(_id_proceso, sfl_file.id_proceso)
    --AND substr(sfl_file.linea, 1, 18)		= 'BOF      PERSHING '
    --AND substr(sfl_file.linea, 1, 18)		= 'EOF      PERSHING '
    AND substr(sfl_file.linea, 1, 1)		= 'D'
    ORDER BY sfl_file.id;

    RETURN;
    END;
$$;

alter function stage_pershing.fn_extrae_isca_reg_d(bigint) owner to postgres;

