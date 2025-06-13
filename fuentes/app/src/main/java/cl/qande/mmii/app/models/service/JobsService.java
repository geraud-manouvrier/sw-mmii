package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.core.dao.IJobsLogDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class JobsService {

    private final IJobsLogDao jobsLogDao;

    public JobsService(IJobsLogDao jobsLogDao) {
        this.jobsLogDao = jobsLogDao;
    }

    @Transactional(readOnly = true)
    public boolean verificaEjecucionJobPorIdProceso(Integer idJob, String idProceso, boolean flagFinalizado) {
        Long cantRegistros;
        if (flagFinalizado) {
            cantRegistros = jobsLogDao.countByIdJobAndIdProcesoAndEndTimestampIsNotNull(idJob, idProceso);
        } else {
            cantRegistros = jobsLogDao.countByIdJobAndIdProceso(idJob, idProceso);
        }
        return (cantRegistros>0);
    }

    @Transactional(readOnly = true)
    public boolean verificaEjecucionJobPorIdProcesoSubIdProceso(Integer idJob, String idProceso, String subIdProceso, boolean flagFinalizado) {
        Long cantRegistros;
        if (flagFinalizado) {
            cantRegistros = jobsLogDao.countByIdJobAndIdProcesoAndSubIdProcesoAndEndTimestampIsNotNull(idJob, idProceso, subIdProceso);
        } else {
            cantRegistros = jobsLogDao.countByIdJobAndIdProcesoAndSubIdProceso(idJob, idProceso, subIdProceso);
        }
        return (cantRegistros>0);
    }
}
