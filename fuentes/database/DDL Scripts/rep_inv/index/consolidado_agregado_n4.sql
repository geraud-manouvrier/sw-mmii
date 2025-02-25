create index consolidado_agregado_n4_ui
    on rep_inv.consolidado_agregado_n4 (process_date_as_date, agregador_n1, agregador_n2, agregador_n3, agregador_n4);

create index consolidado_agregado_n4_agregadores_index
    on rep_inv.consolidado_agregado_n4 (agregador_n1, agregador_n2, agregador_n3, agregador_n4);

