create unique index base_saldos_diarios_ui
    on rep_inv.base_saldos_diarios (process_date, client_id, custodian, account_no, cusip, isin, symbol,
                                    security_description, id_tipo_activo, id_sub_tipo_activo, id_sub_sub_tipo_activo,
                                    currency);

create index base_saldos_diarios_client_id_index
    on rep_inv.base_saldos_diarios (client_id);

