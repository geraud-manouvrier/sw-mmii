package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.clientes.entity.ClienteCuentaMaestro;
import cl.qande.mmii.app.models.db.clientes.entity.ClienteCuentaMaestroId;
import cl.qande.mmii.app.models.dto.ClienteCuentaMaestroDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteCuentaMaestroMapper extends EntityMapper<ClienteCuentaMaestroDto, ClienteCuentaMaestro> {

    ClienteCuentaMaestroId toEntity(ClienteCuentaMaestroDto.ClienteCuentaMaestroIdDto dto);

    ClienteCuentaMaestroDto.ClienteCuentaMaestroIdDto toDto(ClienteCuentaMaestroId entity);
}