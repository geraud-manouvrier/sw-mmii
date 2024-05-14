package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.sura.entity.Contrato;
import cl.qande.mmii.app.models.dto.ContratoDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContratoMapper extends EntityMapper<ContratoDto, Contrato> {
}