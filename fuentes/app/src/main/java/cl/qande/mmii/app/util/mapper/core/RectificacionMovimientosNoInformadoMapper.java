package cl.qande.mmii.app.util.mapper.core;

import cl.qande.mmii.app.models.db.core.entity.RectificacionMovimientosNoInformado;
import cl.qande.mmii.app.models.dto.core.RectificacionMovimientosNoInformadoDto;
import cl.qande.mmii.app.util.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RectificacionMovimientosNoInformadoMapper extends EntityMapper<RectificacionMovimientosNoInformadoDto, RectificacionMovimientosNoInformado> {
}