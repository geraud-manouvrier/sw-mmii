package cl.qande.mmii.app.models.db.sura.dao;

import cl.qande.mmii.app.models.db.sura.entity.BaseInstrumento;
import org.springframework.data.repository.CrudRepository;

public interface IBaseInstrumentoDao extends CrudRepository<BaseInstrumento, Long> {
}