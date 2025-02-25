create or replace view public.vw_calendario
            (fecha_as_date, fecha_as_str, fecha_cl, fecha_cl_inv, fecha_usa, fecha_usa_inv, dia_del_mes, mes_del_agnio,
             mes_del_agnio_str, mes_del_agnio_str_corto, agnio, dia_de_semana_base0, dia_de_semana_base1, dia_del_agnio,
             semana_del_mes_base_dia1, semana_del_mes_base_entera, semana_del_agnio_base_dia1,
             semana_del_agnio_base_entera, habil_chile, habil_usa, habil_pershing, habil_stonex, last_day_of_month,
             last_day_of_year)
as
SELECT fecha_as_date,
       fn_fecha_date_to_string(fecha_as_date, 'YYYYMMDD'::character varying, ''::character varying)  AS fecha_as_str,
       fn_fecha_date_to_string(fecha_as_date, 'DDMMYYYY'::character varying, '-'::character varying) AS fecha_cl,
       fn_fecha_date_to_string(fecha_as_date, 'YYYYMMDD'::character varying, '-'::character varying) AS fecha_cl_inv,
       fn_fecha_date_to_string(fecha_as_date, 'MMDDYYYY'::character varying, '/'::character varying) AS fecha_usa,
       fn_fecha_date_to_string(fecha_as_date, 'YYYYDDMM'::character varying, '/'::character varying) AS fecha_usa_inv,
       EXTRACT(day FROM fecha_as_date)::integer                                                      AS dia_del_mes,
       EXTRACT(month FROM fecha_as_date)::integer                                                    AS mes_del_agnio,
       NULL::character varying(100)                                                                  AS mes_del_agnio_str,
       NULL::character varying(100)                                                                  AS mes_del_agnio_str_corto,
       EXTRACT(year FROM fecha_as_date)::integer                                                     AS agnio,
       NULL::integer                                                                                 AS dia_de_semana_base0,
       NULL::integer                                                                                 AS dia_de_semana_base1,
       NULL::integer                                                                                 AS dia_del_agnio,
       NULL::integer                                                                                 AS semana_del_mes_base_dia1,
       NULL::integer                                                                                 AS semana_del_mes_base_entera,
       NULL::integer                                                                                 AS semana_del_agnio_base_dia1,
       NULL::integer                                                                                 AS semana_del_agnio_base_entera,
       NULL::boolean                                                                                 AS habil_chile,
       NULL::boolean                                                                                 AS habil_usa,
       NULL::boolean                                                                                 AS habil_pershing,
       NULL::boolean                                                                                 AS habil_stonex,
       EXTRACT(month FROM fecha_as_date + '1 day'::interval) <>
       EXTRACT(month FROM fecha_as_date)                                                             AS last_day_of_month,
       EXTRACT(year FROM fecha_as_date + '1 day'::interval) <> EXTRACT(year FROM fecha_as_date)      AS last_day_of_year
FROM fn_calendario_genera_fechas() cal(fecha_as_date)
ORDER BY fecha_as_date;

alter table public.vw_calendario
    owner to postgres;

