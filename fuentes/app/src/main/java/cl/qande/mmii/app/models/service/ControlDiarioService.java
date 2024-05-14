package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.core.dao.IControlDiarioReporteDao;
import cl.qande.mmii.app.models.db.core.entity.ControlDiarioReporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ControlDiarioService {
    @Autowired
    private IControlDiarioReporteDao controlDiarioReporteDao;

    private static final Integer CORRELATIVO_BASE   = 0;

    @Transactional
    public List<ControlDiarioReporte> ejecutaControlDiarioSegmentado(String processDate, String username) {
        return controlDiarioReporteDao.ejecutaControlDiarioSegmentado(processDate, username);
    }

    @Transactional(readOnly = true)
    public List<ControlDiarioReporte> resultadoVigenteDelDia(String processDate) {
        return controlDiarioReporteDao.reporteListadoDiario(processDate, processDate, CORRELATIVO_BASE);
    }

    @Transactional(readOnly = true)
    public List<ControlDiarioReporte> resultadoVigenteDelDiaPorSegmento(String processDate, Integer idSegmentacion) {
        return controlDiarioReporteDao.reporteListadoDiarioPorSegmento(processDate, processDate, 0, idSegmentacion);
    }


    @Transactional(readOnly = true)
    public List<ControlDiarioReporte> resultadoVigenteDelDiaPorListaSegmentos(String processDate, List<Integer> listaSegmentos) {
        List<ControlDiarioReporte> resultadoSegmentos = new ArrayList<>();
        for(Integer idSegmento : listaSegmentos) {
            var resultadoSegmentoActual   = resultadoVigenteDelDiaPorSegmento(processDate, idSegmento);
            resultadoSegmentos.addAll(resultadoSegmentoActual);
        }
        return resultadoSegmentos;
    }

}
