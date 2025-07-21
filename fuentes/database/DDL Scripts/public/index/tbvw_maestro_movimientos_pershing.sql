create index tbvw_maestro_movimientos_pershing_client_index
    on public.tbvw_maestro_movimientos_pershing (client_id);

create index tbvw_maestro_movimientos_pershing_custodian_index
    on public.tbvw_maestro_movimientos_pershing (custodian);

create index tbvw_maestro_movimientos_pershing_account_index
    on public.tbvw_maestro_movimientos_pershing (account_no);

create index tbvw_maestro_movimientos_pershing_process_date_index
    on public.tbvw_maestro_movimientos_pershing (process_date);

create index tbvw_maestro_movimientos_pershing_cusip_index
    on public.tbvw_maestro_movimientos_pershing (cusip);

create index tbvw_maestro_movimientos_pershing_product_index
    on public.tbvw_maestro_movimientos_pershing (product_type);

