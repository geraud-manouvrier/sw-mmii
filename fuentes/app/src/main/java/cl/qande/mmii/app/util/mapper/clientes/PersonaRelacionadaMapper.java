package cl.qande.mmii.app.util.mapper.clientes;

import cl.qande.mmii.app.models.db.clientes.entity.PersonaRelacionada;
import cl.qande.mmii.app.models.dto.clientes.PersonaRelacionadaDto;
import cl.qande.mmii.app.util.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonaRelacionadaMapper extends EntityMapper<PersonaRelacionadaDto, PersonaRelacionada> {

    @Mapping(source = "id", target = "id", qualifiedByName = "negativeIsNull")
    public PersonaRelacionada toEntity(PersonaRelacionadaDto dto);
}