package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.ParSourceCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IParSourceCodeDao extends CrudRepository<ParSourceCode, Long> {
    @Query("select psc from ParSourceCode psc")
    public List<ParSourceCode> findAll();
    @Query(value = "select psc.* from public.par_source_code psc order by psc.source_code_pershing ASC, COALESCE(psc.signo_movimiento,-99) ASC ", nativeQuery = true)
    public List<ParSourceCode> findAllOrderedBySourCodeAndSigno();
    public ParSourceCode findBySourceCodePershingAndSignoMovimiento(String sourceCodePershing, Integer signoMovimiento);
    public ParSourceCode getById(Long id);

}