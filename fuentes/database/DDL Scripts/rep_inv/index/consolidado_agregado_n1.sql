create index consolidado_agregado_n1_ui
    on rep_inv.consolidado_agregado_n1 (process_date_as_date, agregador_n1);

create index consolidado_agregado_n1_agregadores_index
    on rep_inv.consolidado_agregado_n1 (agregador_n1);

