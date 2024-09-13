create unique index cuenta_id_custodio_id_cuenta_custodio_ui
    on clientes.cuenta (id_custodio, id_cuenta_custodio);

create unique index cuenta_ui_cliente_cuenta
    on clientes.cuenta (id_cliente, id_cuenta_custodio, id_custodio);

