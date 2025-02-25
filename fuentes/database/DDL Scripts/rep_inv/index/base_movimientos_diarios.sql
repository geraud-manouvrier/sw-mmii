create unique index base_movimientos_diarios_ui
    on rep_inv.base_movimientos_diarios (process_date, client_id, custodian, account_no, cusip, isin, symbol,
                                         source_code, activity_description, id_tipo_activo, id_sub_tipo_activo,
                                         id_sub_sub_tipo_activo, currency, tipo_reg);

create index base_movimientos_diarios_client_id_index
    on rep_inv.base_movimientos_diarios (client_id);

