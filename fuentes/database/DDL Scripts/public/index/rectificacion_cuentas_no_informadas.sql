create index rectificacion_cuentas_no_informadas_custodian_index
    on public.rectificacion_cuentas_no_informadas (custodian);

create index rectificacion_cuentas_no_informadas_account_index
    on public.rectificacion_cuentas_no_informadas (account_no);

create index rectificacion_cuentas_no_informadas_cuenta_index
    on public.rectificacion_cuentas_no_informadas (id_cuenta_custodio);

create index rectificacion_cuentas_no_informadas_client_index
    on public.rectificacion_cuentas_no_informadas (client_id);

create index rectificacion_cuentas_no_informadas_process_date_index
    on public.rectificacion_cuentas_no_informadas (process_date);

