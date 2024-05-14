create unique index sfl_gcus_ui_cusip_fecha
    on pershing.sfl_gcus (process_date, account_number, cusip_number);

create unique index sfl_gcus_ui_cusip_proceso
    on pershing.sfl_gcus (id_proceso, account_number, cusip_number);

