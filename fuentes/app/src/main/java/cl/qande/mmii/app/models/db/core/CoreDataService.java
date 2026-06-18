package cl.qande.mmii.app.models.db.core;

import cl.qande.mmii.app.config.datasources.CoreDataSourceConfiguration;
import cl.qande.mmii.app.models.db.core.entity.FnActualizaFeeRia;
import cl.qande.mmii.app.models.db.core.entity.VwReporteDiferenciasFee;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoreDataService {

    private final EntityManager entityManager;

    public CoreDataService(@Qualifier(CoreDataSourceConfiguration.ENTITY_MANAGER) EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<VwReporteDiferenciasFee> reporteDiferenciasFee() {
        return VwReporteDiferenciasFee.findByProcessDate(entityManager);
    }

    public List<VwReporteDiferenciasFee> reporteDiferenciasFee(boolean flagFee) {
        return reporteDiferenciasFee()
                .stream()
                .filter(item -> item.getFlagFee() == flagFee)
                .collect(Collectors.toList());
    }

    public FnActualizaFeeRia actualizaFeeRia(String custodian, String accountNo, String processDate, BigDecimal newAnnualPercentFee) {
        var salida = entityManager.createNamedQuery(FnActualizaFeeRia.ACTUALIZA_FEE_FROM_RIA, FnActualizaFeeRia.class)
                .setParameter("_custodian", custodian)
                .setParameter("_account_no", accountNo)
                .setParameter("_process_date", processDate)
                .setParameter("_new_annual_percent_fee", newAnnualPercentFee)
                .getSingleResult();
        CustomLog.getInstance().info("Actualización Fee desde RIA: ["+salida+"]", false);
        return salida;
    }

}
