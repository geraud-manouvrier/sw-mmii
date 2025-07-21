create index tbvw_maestro_saldos_pershing_client_index
    on public.tbvw_maestro_saldos_pershing (client_id);

create index tbvw_maestro_saldos_pershing_custodian_index
    on public.tbvw_maestro_saldos_pershing (custodian);

create index tbvw_maestro_saldos_pershing_account_index
    on public.tbvw_maestro_saldos_pershing (account_no);

create index tbvw_maestro_saldos_pershing_process_date_index
    on public.tbvw_maestro_saldos_pershing (process_date);

create index tbvw_maestro_saldos_pershing_cusip_index
    on public.tbvw_maestro_saldos_pershing (cusip);

create index tbvw_maestro_saldos_pershing_product_index
    on public.tbvw_maestro_saldos_pershing (product_type);

