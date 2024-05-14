create unique index sfl_gcus_actual_ui_cusip_fecha
    on pershing.sfl_gcus_actual (process_date, account_number, cusip_number);

create unique index sfl_gcus_actual_ui_cusip_proceso
    on pershing.sfl_gcus_actual (id_proceso, account_number, cusip_number);

