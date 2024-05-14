create unique index sfl_isrc_ui_source_code_fecha
    on pershing.sfl_isrc (process_date, source_code);

create unique index sfl_isrc_ui_source_code_proceso
    on pershing.sfl_isrc (id_proceso, source_code);

