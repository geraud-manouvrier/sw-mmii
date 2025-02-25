create index consolidado_agregado_n2_ui
    on rep_inv.consolidado_agregado_n2 (process_date_as_date, agregador_n1, agregador_n2);

create index consolidado_agregado_n2_agregadores_index
    on rep_inv.consolidado_agregado_n2 (agregador_n1, agregador_n2);

