package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import cl.qande.mmii.app.util.helper.ReportesMaestrosHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportesMaestrosMapper {

    @Autowired
    private ReportesMaestrosHelper reportesMaestrosHelper;

    public List<String> getFromDbToCsvLine(VwReporteMaestroDatosCliente fila){
        ArrayList<String> dataRow = new ArrayList<>();

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCustodian()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getClientId()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getTipoIdentificadorCliente()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getOfficeId()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getAccountNo()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getName()));

        return dataRow;
    }
    public List<String> getFromDbToCsvLine(VwReporteMaestroDatosMovimiento fila) {
        ArrayList<String> dataRow = new ArrayList<>();

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCustodian()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getTipoIdentificadorCliente()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getClientId()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getOfficeId()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getAccountNo()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getName()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getProcessDate()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getTradeDate()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getSettlementDate()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getActivity()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getBuySell()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getQuantity()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getPrice()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getComission()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getFees()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getNetAmount()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getUsdeNetAmount()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getPrincipal()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCusip()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCurrency()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getFxRate()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCashMarginAccount()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getProductType()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getSecurityDescription()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getActivityDescription()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getSourceCode()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getNombreSubSubTipoActivo()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getIngresoEgreso()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getRetiro()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getRecaudo()));

        return dataRow;
    }

    public List<String> getFromDbToCsvLine(VwReporteMaestroDatosSaldo fila) {
        ArrayList<String> dataRow = new ArrayList<>();

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCustodian()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getOfficeId()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getTipoIdentificadorCliente()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getClientId()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getAccountNo()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getName()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getProcessDate()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCusip()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getSecurityDescription()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getQuantity()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getMarketPrice()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCurrency()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getMarketValue()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getFxRate()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getUsdeMarketValue()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getUsdeMarketPrice()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getNombreSubSubTipoActivo()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getAnnualFee()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getTasaProteccion()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getFeeDiarioProteccion()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getIngresoProteccion()));

        return dataRow;
    }
}
