package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.clientes.entity.TipoIdentificador;
import cl.qande.mmii.app.models.dto.TipoIdentificadorDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TipoIdentificadorMapper extends EntityMapper<TipoIdentificadorDto, TipoIdentificador> {
}