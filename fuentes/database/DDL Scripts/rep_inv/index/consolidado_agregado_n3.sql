create index consolidado_agregado_n3_ui
    on rep_inv.consolidado_agregado_n3 (process_date_as_date, agregador_n1, agregador_n2, agregador_n3);

create index consolidado_agregado_n3_agregadores_index
    on rep_inv.consolidado_agregado_n3 (agregador_n1, agregador_n2, agregador_n3);

