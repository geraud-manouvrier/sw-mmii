package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.ParSourceCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IParSourceCodeDao extends CrudRepository<ParSourceCode, Long> {
    @Query("select psc from ParSourceCode psc")
    public List<ParSourceCode> findAll();
    @Query("select psc from ParSourceCode psc order by psc.sourceCodePershing ASC, COALESCE(psc.signoMovimiento,-99) ASC ")
    public List<ParSourceCode> findAllOrderedBySourCodeAndSigno();
    public List<ParSourceCode> findBySourceCodePershingAndSignoMovimiento(String sourceCodePershing, Integer signoMovimiento);
    public ParSourceCode getById(Long id);

}