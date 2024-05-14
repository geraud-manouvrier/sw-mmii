create unique index sfl_gmon_ui_account_fecha
    on pershing.sfl_gmon (process_date, account_number);

create unique index sfl_gmon_ui_account_proceso
    on pershing.sfl_gmon (id_proceso, account_number);

