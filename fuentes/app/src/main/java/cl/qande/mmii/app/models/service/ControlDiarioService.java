package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.job.JobControlDiario;
import cl.qande.mmii.app.models.db.core.dao.IControlDiarioDao;
import cl.qande.mmii.app.models.db.core.entity.ControlDiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ControlDiarioService {

    private final IControlDiarioDao controlDiarioDao;

    private static final Integer CORRELATIVO_BASE   = 0;


    @Autowired
    public ControlDiarioService(IControlDiarioDao controlDiarioDao) {
        this.controlDiarioDao = controlDiarioDao;
    }


    @Transactional
    public List<ControlDiario> ejecutaControlDiario(String processDate, String username) {
        return controlDiarioDao.ejecutaControlDiario(processDate, username);
    }

    @Transactional(readOnly = true)
    public List<ControlDiario> resultadoVigenteDelDia(String processDate) {
        return controlDiarioDao.reporteListadoDiario(processDate, processDate, CORRELATIVO_BASE);
    }

    @Transactional(readOnly = true)
    public Integer resultadoJobs(String processDate) {
        return controlDiarioDao.resultadoJobs(1, processDate, "");
    }

    @Transactional(readOnly = true)
    public List<String> lastErrors(Integer limite) {
        return controlDiarioDao.lastErrors(JobControlDiario.ID_JOB, limite);
    }


}
