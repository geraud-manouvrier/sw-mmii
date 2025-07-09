create index tbvw_maestro_cuentas_pershing_custodian_index
    on public.tbvw_maestro_cuentas_pershing (custodian);

create index tbvw_maestro_cuentas_pershing_account_index
    on public.tbvw_maestro_cuentas_pershing (account_no);

create index tbvw_maestro_cuentas_pershing_cuenta_index
    on public.tbvw_maestro_cuentas_pershing (id_cuenta_custodio);

create index tbvw_maestro_cuentas_pershing_client_index
    on public.tbvw_maestro_cuentas_pershing (client_id);

