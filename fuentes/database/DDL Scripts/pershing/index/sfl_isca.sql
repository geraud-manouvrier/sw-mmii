create unique index sfl_isca_ui_cusip_fecha
    on pershing.sfl_isca (process_date, cusip_number);

create unique index sfl_isca_ui_cusip_proceso
    on pershing.sfl_isca (id_proceso, cusip_number);

