package cl.qande.mmii.app.util.mapper.core;

import cl.qande.mmii.app.models.api.reportes_maestros.MaestroCuentasApiDto;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import cl.qande.mmii.app.util.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VwReporteMaestroDatosClienteMapper extends EntityMapper<MaestroCuentasApiDto, VwReporteMaestroDatosCliente> {
}