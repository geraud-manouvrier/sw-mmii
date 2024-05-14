package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.JobsLog;
import org.springframework.data.repository.CrudRepository;

public interface IJobsLogDao extends CrudRepository<JobsLog, Long> {

    public Long countByIdJobAndIdProcesoAndSubIdProceso(Integer idJob, String idProceso, String subIdProceso);
    public Long countByIdJobAndIdProcesoAndSubIdProcesoAndEndTimestampIsNotNull(Integer idJob, String idProceso, String subIdProceso);
    public Long countByIdJobAndIdProceso(Integer idJob, String idProceso);
    public Long countByIdJobAndIdProcesoAndEndTimestampIsNotNull(Integer idJob, String idProceso);

}