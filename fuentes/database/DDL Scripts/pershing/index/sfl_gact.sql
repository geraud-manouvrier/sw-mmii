create unique index sfl_gact_ui_record_id_fecha
    on pershing.sfl_gact (process_date, record_id_sequence_number);

create unique index sfl_gact_ui_record_id_proceso
    on pershing.sfl_gact (id_proceso, record_id_sequence_number);

