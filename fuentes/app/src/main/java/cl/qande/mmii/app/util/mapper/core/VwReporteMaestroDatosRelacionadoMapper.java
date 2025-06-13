package cl.qande.mmii.app.util.mapper.core;

import cl.qande.mmii.app.models.api.reportes_maestros.MaestroRelacionadosApiDto;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosRelacionado;
import cl.qande.mmii.app.util.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VwReporteMaestroDatosRelacionadoMapper extends EntityMapper<MaestroRelacionadosApiDto, VwReporteMaestroDatosRelacionado> {
}