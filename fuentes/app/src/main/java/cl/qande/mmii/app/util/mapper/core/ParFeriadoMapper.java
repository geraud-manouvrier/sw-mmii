package cl.qande.mmii.app.util.mapper.core;

import cl.qande.mmii.app.models.db.core.entity.ParFeriado;
import cl.qande.mmii.app.models.dto.core.ParFeriadoDto;
import cl.qande.mmii.app.util.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ParFeriadoMapper extends EntityMapper<ParFeriadoDto, ParFeriado> {
}