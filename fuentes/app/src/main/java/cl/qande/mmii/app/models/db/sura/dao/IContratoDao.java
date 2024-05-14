package cl.qande.mmii.app.models.db.sura.dao;

import cl.qande.mmii.app.models.db.sura.entity.Contrato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IContratoDao extends CrudRepository<Contrato, String> {

    @Transactional(readOnly = true)
    public List<Contrato> findByIdCliente(String idCliente);


}