package cl.qande.mmii.app.models.db.clientes.dao;

import cl.qande.mmii.app.models.db.clientes.entity.ComisionCuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComisionCuentaDao extends JpaRepository<ComisionCuenta, Long> {
    public ComisionCuenta save(ComisionCuenta comisionCuenta);

}