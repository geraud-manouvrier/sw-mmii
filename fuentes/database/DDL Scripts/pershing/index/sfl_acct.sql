create unique index sfl_acct_ui_cusip_fecha
    on pershing.sfl_acct (process_date, account_number);

create unique index sfl_acct_ui_cusip_proceso
    on pershing.sfl_acct (id_proceso, account_number);

