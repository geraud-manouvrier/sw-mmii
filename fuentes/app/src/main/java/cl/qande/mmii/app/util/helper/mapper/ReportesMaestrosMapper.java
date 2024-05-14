package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.ReportesMaestrosHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ReportesMaestrosMapper {

    @Autowired
    private ReportesMaestrosHelper reportesMaestrosHelper;
    @Autowired
    private CalendarioHelper calendarioHelper;

    public List<String> getFromDbToCsvLine(VwReporteMaestroDatosCliente fila) throws QandeMmiiException {
        ArrayList<String> dataRow = new ArrayList<>();

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCustodian()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getClientId()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getOfficeId()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getAccountNo()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getName()));

    dataRow.add(reportesMaestrosHelper.csvValue(fila.getDateOfBirth()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getAcctStatusValue()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getEmail()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCountry()));
        try {
            if (fila.getW8Date()==null) {
                dataRow.add(reportesMaestrosHelper.csvValue((Date)null));
            } else {
                dataRow.add(reportesMaestrosHelper.csvValue(calendarioHelper.convierteFechaStrToFormatoBd(fila.getW8Date())));
            }
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error al generar CSV parse fecha w8 ["+fila.getW8Date()+"]: "+e.getMessage());
        }
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getW9Date()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getW8StatusValue()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getW9StatusValue()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getAccountType()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCashMarginAccount()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getModeloRelacionamiento()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getDebitCardIndicator()));
    dataRow.add(reportesMaestrosHelper.csvValue(reportesMaestrosHelper.excelValueAsDate(fila.getOpenDate(),ReportesMaestrosHelper.FORMATO_FECHA_BD)));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCloseDate()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getParticipantType()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getClientInvestmentProfile()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getAdvisoryFeeAnnualPct()));
    dataRow.add(reportesMaestrosHelper.csvValue(fila.getLastStatementDate()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getMainAdvisor()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getSecondaryAdvisor()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getEmailMainAdvisor()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getEmailSecondaryAdvisor()));

        return dataRow;
    }
    public List<String> getFromDbToCsvLine(VwReporteMaestroDatosMovimiento fila) throws QandeMmiiException {
        ArrayList<String> dataRow = new ArrayList<>();

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCustodian()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getClientId()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getOfficeId()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getAccountNo()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getName()));

        dataRow.add(reportesMaestrosHelper.csvValue(reportesMaestrosHelper.excelValueAsDate(fila.getProcessDate(), "yyyyMMdd")));
        dataRow.add(reportesMaestrosHelper.csvValue(reportesMaestrosHelper.excelValueAsDate(fila.getTradeDate(), ReportesMaestrosHelper.FORMATO_FECHA_BD)));
        dataRow.add(reportesMaestrosHelper.csvValue(reportesMaestrosHelper.excelValueAsDate(fila.getSettlementDate(), ReportesMaestrosHelper.FORMATO_FECHA_BD)));
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
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getSymbol()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getIsin()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCurrency()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getFxRate()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getInterest()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCurrencyBase()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCashMarginAccount()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getProductType()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getSecurityDescription()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getActivityDescription()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getActivityCode()));

        return dataRow;
    }

    public List<String> getFromDbToCsvLine(VwReporteMaestroDatosSaldo fila) throws QandeMmiiException {
        ArrayList<String> dataRow = new ArrayList<>();

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCustodian()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getClientId()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getOfficeId()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getRep()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getAccountNo()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getName()));
        dataRow.add(reportesMaestrosHelper.csvValue(reportesMaestrosHelper.excelValueAsDate(fila.getProcessDate(), "yyyyMMdd")));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getSymbol()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCusip()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getIsin()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getProductType()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getSecurityDescription()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCashMarginAccount()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getQuantity()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getMarketPrice()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getCurrency()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getMarketValue()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getFxRate()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getUsdeMarketValue()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getAdvisoryFeeAnual()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getFactor()));
        dataRow.add(reportesMaestrosHelper.csvValue(fila.getComisionDevengadaDiaria()));

        dataRow.add(reportesMaestrosHelper.csvValue(fila.getUsdeMarketPrice()));

        return dataRow;
    }
}
