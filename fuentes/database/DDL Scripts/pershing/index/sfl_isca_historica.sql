create unique index sfl_isca_historica_ui_cusip_fecha
    on pershing.sfl_isca_historica (process_date, cusip_number);

create unique index sfl_isca_historica_ui_cusip_proceso
    on pershing.sfl_isca_historica (id_proceso, process_date, cusip_number);

