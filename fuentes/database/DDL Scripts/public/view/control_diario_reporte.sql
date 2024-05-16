create or replace view public.control_diario_reporte
            (id_reporte, correlativo_diario, process_date, timestamp_control, timestamp_registro, id_control,
             glosa_control, descripcion_control, identificador, cant_reg, username, id_segmentacion)
as
SELECT id AS id_reporte,
       correlativo_diario,
       process_date,
       timestamp_control,
       timestamp_registro,
       id_control,
       glosa_control,
       descripcion_control,
       identificador,
       cant_reg,
       username,
       id_segmentacion
FROM control_diario rep_cd;

alter table public.control_diario_reporte
    owner to postgres;

