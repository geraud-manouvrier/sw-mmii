create unique index sfl_gmon_historica_ui_account_fecha
    on pershing.sfl_gmon_historica (process_date, account_number);

create unique index sfl_gmon_historica_ui_account_proceso
    on pershing.sfl_gmon_historica (id_proceso, process_date, account_number);

