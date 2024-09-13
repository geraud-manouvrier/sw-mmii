package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.core.entity.ParSourceCode;
import cl.qande.mmii.app.models.dto.ParSourceCodeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ParSourceCodeMapper extends EntityMapper<ParSourceCodeDto, ParSourceCode> {

    @Mapping(source = "observacionesInternas", target = "observacionesInternas", qualifiedByName = "blankIsNull")
    public ParSourceCode toEntity(ParSourceCodeDto dto);
}