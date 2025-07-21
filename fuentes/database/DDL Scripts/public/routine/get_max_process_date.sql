create or replace function public.get_max_process_date() returns character varying
    stable
    language sql
as
$$
  SELECT greatest(
    (SELECT process_date
       FROM public.tbvw_maestro_cuentas_pershing
      ORDER BY process_date DESC
      LIMIT 1),
    (SELECT process_date
       FROM public.rectificacion_cuentas_no_informadas
      WHERE id_estado_rectificacion = 0
      ORDER BY process_date DESC
      LIMIT 1)
  );
$$;

alter function public.get_max_process_date() owner to postgres;

