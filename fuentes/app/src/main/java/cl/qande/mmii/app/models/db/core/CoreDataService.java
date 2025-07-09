package cl.qande.mmii.app.models.db.core;

import cl.qande.mmii.app.config.datasources.CoreDataSourceConfiguration;
import cl.qande.mmii.app.models.db.core.entity.VwReporteDiferenciasFee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
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
}
