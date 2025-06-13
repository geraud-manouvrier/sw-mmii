package cl.qande.mmii.app.util.mapper.clientes;

import cl.qande.mmii.app.models.db.clientes.entity.ParCargo;
import cl.qande.mmii.app.models.dto.clientes.ParCargoDto;
import cl.qande.mmii.app.util.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ParCargoMapper extends EntityMapper<ParCargoDto, ParCargo> {
}