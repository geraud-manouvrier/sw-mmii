package cl.qande.mmii.app.util.mapper.clientes;

import cl.qande.mmii.app.models.db.clientes.entity.Cliente;
import cl.qande.mmii.app.models.dto.clientes.ClienteDto;
import cl.qande.mmii.app.util.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper extends EntityMapper<ClienteDto, Cliente> {
}