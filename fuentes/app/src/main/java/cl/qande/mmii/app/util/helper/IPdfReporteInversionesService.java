package cl.qande.mmii.app.util.helper;

import cl.qande.mmii.app.models.dto.reporte_inversiones.ReporteInversionesClienteDto;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import com.lowagie.text.DocumentException;

import java.io.IOException;

public interface IPdfReporteInversionesService {

    public String generaPdfCliente(ReporteInversionesClienteDto reporteInversionesClienteDto) throws DocumentException, IOException, QandeMmiiException;

}
