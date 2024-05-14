package cl.qande.mmii.app.models.service;

public interface IJobsService {

    public boolean verificaEjecucionJobPorIdProceso(Integer idJob, String idProceso, boolean flagFinalizado);

    public boolean verificaEjecucionJobPorIdProcesoSubIdProceso(Integer idJob, String idProceso, String subIdProceso, boolean flagFinalizado);
}
