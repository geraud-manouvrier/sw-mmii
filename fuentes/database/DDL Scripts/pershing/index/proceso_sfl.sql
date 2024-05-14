create unique index proceso_sfl_index_ui
    on pershing.proceso_sfl (process_stamp, process_date);

create unique index proceso_sfl_ui_process_stamp
    on pershing.proceso_sfl (process_stamp);

