package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.ParHomologacionSourceCodeStonex;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IParHomologacionSourceCodeStonexDao extends CrudRepository<ParHomologacionSourceCodeStonex, Long> {
    @Query("select tbPar from ParHomologacionSourceCodeStonex tbPar")
    public List<ParHomologacionSourceCodeStonex> findAll();
    public List<ParHomologacionSourceCodeStonex> findBySourceCodeStonexAndSignoMovimiento(String sourceCodeStonex, Integer signoMovimiento);
    public List<ParHomologacionSourceCodeStonex> findByIdParSourceCode(Integer idParSourceCode);
}