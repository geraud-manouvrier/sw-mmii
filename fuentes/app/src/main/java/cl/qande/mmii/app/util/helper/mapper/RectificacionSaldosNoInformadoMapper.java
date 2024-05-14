package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.core.entity.RectificacionSaldosNoInformado;
import cl.qande.mmii.app.models.dto.RectificacionSaldosNoInformadoDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RectificacionSaldosNoInformadoMapper extends EntityMapper<RectificacionSaldosNoInformadoDto, RectificacionSaldosNoInformado> {
}