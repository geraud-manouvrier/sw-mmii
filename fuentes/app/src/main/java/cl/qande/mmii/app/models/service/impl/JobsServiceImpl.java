package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.core.dao.IJobsLogDao;
import cl.qande.mmii.app.models.service.IJobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobsServiceImpl implements IJobsService {

    @Autowired
    private IJobsLogDao jobsLogDao;
    @Transactional(readOnly = true)
    @Override
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
    @Override
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
