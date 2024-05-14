package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.core.entity.ParHomologacionSourceCodeStonex;
import cl.qande.mmii.app.models.dto.ParHomologacionSourceCodeStonexDto;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ParHomologacionSourceCodeStonexMapper extends EntityMapper<ParHomologacionSourceCodeStonexDto, ParHomologacionSourceCodeStonex> {

    @Mapping(source = "observacionesInternas", target = "observacionesInternas", qualifiedByName = "blankIsNull")
    public ParHomologacionSourceCodeStonex toEntity(ParHomologacionSourceCodeStonexDto dto);

    @Named("blankIsNull")
    public static String blankIsNull(String dtoStringValue) {
        if (dtoStringValue.isEmpty())
            return null;
        return dtoStringValue;
    }
}