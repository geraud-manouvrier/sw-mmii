package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.ControlDiario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IControlDiarioDao extends CrudRepository<ControlDiario, Long> {

    @Query(value = "SELECT * FROM public.fn_control_diario(:_process_date, :_username)", nativeQuery = true)
    public List<ControlDiario> ejecutaControlDiario(@Param("_process_date") String processDate, @Param("_username") String username);

    public List<ControlDiario> findByProcessDateAndCorrelativoDiarioOrderByCorrelativoDiarioAscIdControlAscIdentificadorAscCantRegAsc(String processDate, Integer correlativoDiario);

    public List<ControlDiario> findByProcessDateOrderByProcessDateDescCorrelativoDiarioAscIdControlAscIdentificadorAscCantRegAsc(String processDate);

}