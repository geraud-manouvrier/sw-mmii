package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ParSourceCode;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ParSourceCodeResponse;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParametrosFromMmiiSuraCorp {

    private final ApiRestClientService apiRestClientService;
    private final MantenedoresInstrumentosService mantenedoresInstrumentosService;

    @Autowired
    public ParametrosFromMmiiSuraCorp(ApiRestClientService apiRestClientService, MantenedoresInstrumentosService mantenedoresInstrumentosService) {
        this.apiRestClientService = apiRestClientService;
        this.mantenedoresInstrumentosService = mantenedoresInstrumentosService;
    }

    public ParSourceCode[][] actualizaParametrosFromMmiiSuraCorp() throws QandeMmiiException {
        List<ParSourceCode> listaOk = new ArrayList<>();
        List<ParSourceCode> listaError = new ArrayList<>();
        CustomLog.getInstance().info("Obteniendo lista de códigos de fuente desde MMII SuraCorp");
        ParSourceCodeResponse response = null;
        try {
            response = apiRestClientService.getListSourceCode();
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error al obtener lista de SourceCode desde MMII SuraCorp: " + e.getMessage());
        }
        CustomLog.getInstance().info("Guardando lista de códigos de fuente en base de datos");
        for (ParSourceCode parSourceCode : response.getListaParSourceCode()) {
            try {
                mantenedoresInstrumentosService.save(parSourceCode);
                listaOk.add(parSourceCode);
            } catch (Exception e) {
                listaError.add(parSourceCode);
                CustomLog.getInstance().error("Error al guardar registro ["+parSourceCode.toString()+"]: " + e.getMessage());
            }
        }
        ParSourceCode[][] respuesta = new ParSourceCode[2][];
        respuesta[0] = listaOk.toArray(new ParSourceCode[0]);
        respuesta[1] = listaError.toArray(new ParSourceCode[0]);
        return respuesta;
    }

}
