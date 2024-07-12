package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.api.MaestroCuentasApiDto;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VwReporteMaestroDatosClienteMapper extends EntityMapper<MaestroCuentasApiDto, VwReporteMaestroDatosCliente> {
}