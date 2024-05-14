create unique index sfl_isrc_actual_ui_source_code_fecha
    on pershing.sfl_isrc_actual (process_date, source_code);

create unique index sfl_isrc_actual_ui_source_code_proceso
    on pershing.sfl_isrc_actual (id_proceso, source_code);

