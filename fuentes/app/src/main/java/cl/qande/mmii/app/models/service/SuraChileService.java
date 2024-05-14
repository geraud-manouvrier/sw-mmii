package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.ArchivosHelper;
import cl.qande.mmii.app.util.helper.ReportesMaestrosHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SuraChileService {

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private ReportesMaestrosHelper reportesMaestrosHelper;
    @Autowired
    private FtpSuraAmService ftpSuraAmService;
    @Autowired
    private ArchivosHelper archivosHelper;
    @Autowired
    private ControlDiarioService controlDiarioService;
    private static final String VARIANTE_CL_USA    = "CL_USA";
    private static final String VARIANTE_CL_CL    = "CL_CL";
    private static final Integer ID_JOB_CONTROLDIARIO    = 1;
    private static final List<Integer> LISTA_SEGMENTO    = Arrays.asList(4,5);
    @Autowired
    private IJobsService jobsService;

    public List<String> cargaArchivosEnFtpPorFechaProceso(String processDate, boolean flagOmitirControlDiario) throws QandeMmiiException {
        var estadoJobControlDiario  = jobsService.verificaEjecucionJobPorIdProceso(ID_JOB_CONTROLDIARIO, processDate, true);
        if (estadoJobControlDiario || flagOmitirControlDiario) {
            var resultadoControlDiario  = controlDiarioService.resultadoVigenteDelDiaPorListaSegmentos(processDate, LISTA_SEGMENTO);
            if (flagOmitirControlDiario || resultadoControlDiario.isEmpty()) {
                var archivosConError    = new ArrayList<String>();
                var archivosPorSubir    = this.listaArchivosPorSubir(processDate);
                for (var archivo : archivosPorSubir) {
                    try {
                        this.cargaArchivoVarianteEnFtpPorFechaProceso(archivo);
                    } catch (Exception e) {
                        archivosConError.add(archivo);
                    }
                }
                return archivosConError;
            }
            throw new QandeMmiiException("El Control Diario arroja errores, no es posible cargar al FTP: ["+resultadoControlDiario.toString()+"]");
        }
        throw new QandeMmiiException("El Control Diario no se ha ejecutado, no es posible cargar al FTP");
    }
    private void cargaArchivoVarianteEnFtpPorFechaProceso(String archivoPorSubir) throws QandeMmiiException {
        try {
            appConfig.customLog.info("Iniciando subida de archivo ["+archivoPorSubir+"] a FTP Chile...");
            ftpSuraAmService.cargarArchivo(archivoPorSubir);
            appConfig.customLog.info("Archivo subido a FTP Chile correctamente: "+archivoPorSubir);
        } catch (QandeMmiiException e) {
            throw new QandeMmiiException(e, "Error al subir archivo al FTP: [" + e.getMessage() + "]");
        }
    }

    private List<String> listaArchivosPorSubir(String processDate) throws QandeMmiiException {
        var listaArchivos           = new ArrayList<String>();
        var listadoArchivosDelDia   = Arrays.asList(archivosHelper.listadoDeArchivosMaestros(processDate));

        listaArchivos.add(this.generaNombreArchivoPorSubir(processDate, ReportesMaestrosHelper.REPORTE_CLIENTES, VARIANTE_CL_USA, listadoArchivosDelDia));
        listaArchivos.add(this.generaNombreArchivoPorSubir(processDate, ReportesMaestrosHelper.REPORTE_MOV_EYS, VARIANTE_CL_USA, listadoArchivosDelDia));
        listaArchivos.add(this.generaNombreArchivoPorSubir(processDate, ReportesMaestrosHelper.REPORTE_SALDOS, VARIANTE_CL_USA, listadoArchivosDelDia));

        listaArchivos.add(this.generaNombreArchivoPorSubir(processDate, ReportesMaestrosHelper.REPORTE_CLIENTES, VARIANTE_CL_CL, listadoArchivosDelDia));
        listaArchivos.add(this.generaNombreArchivoPorSubir(processDate, ReportesMaestrosHelper.REPORTE_MOV_EYS, VARIANTE_CL_CL, listadoArchivosDelDia));
        listaArchivos.add(this.generaNombreArchivoPorSubir(processDate, ReportesMaestrosHelper.REPORTE_SALDOS, VARIANTE_CL_CL, listadoArchivosDelDia));


        return listaArchivos;
    }

    private String generaNombreArchivoPorSubir(String processDate, String tipoReporte, String varianteReporte, List<String> listadoArchivosDelDia) throws QandeMmiiException {
        String rutaLocal		    = appConfig.appConfigProperties.getReportesMaestrosFolder();
        var archivoPorSubir = reportesMaestrosHelper.generaNombreReporte(processDate, tipoReporte, varianteReporte, ReportesMaestrosHelper.EXTENSION_CSV);
        if ( ! listadoArchivosDelDia.contains(archivoPorSubir)) {
            throw new QandeMmiiException("Error: el archivo Maestro Clientes (variante "+VARIANTE_CL_USA+") no ha sido generado aún.");
        }
        return rutaLocal+"/"+archivoPorSubir;
    }
}
