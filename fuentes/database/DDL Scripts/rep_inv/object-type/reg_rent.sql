create type rep_inv.reg_rent as
(
    fecha_desde               date,
    fecha_hasta               date,
    agregador_n1              varchar(100),
    agregador_n2              varchar(100),
    agregador_n3              varchar(100),
    agregador_n4              varchar(100),
    cant_reg                  integer,
    dias_con_saldo            integer,
    rentabilidad_periodo      numeric(45, 20),
    suma_saldos_iniciales     numeric(45, 20),
    suma_saldo_rentabilidad   numeric(45, 20),
    rentabilidad_ponderada_cl numeric(45, 20),
    rentabilidad_periodo_cl   numeric(45, 20)
);

alter type rep_inv.reg_rent owner to postgres;

