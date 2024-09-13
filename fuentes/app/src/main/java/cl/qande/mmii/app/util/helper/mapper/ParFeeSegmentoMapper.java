package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.clientes.entity.ParFeeSegmento;
import cl.qande.mmii.app.models.dto.ParFeeSegmentoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ParFeeSegmentoMapper extends EntityMapper<ParFeeSegmentoDto, ParFeeSegmento> {

    @Mapping(source = "montoMin", target = "montoMin", qualifiedByName = "nullIsZero")
    @Mapping(source = "montoMax", target = "montoMax", qualifiedByName = "nullIsZero")
    @Mapping(source = "annualFee", target = "annualFee", qualifiedByName = "nullIsZero")
    @Mapping(source = "tasaProteccion", target = "tasaProteccion", qualifiedByName = "nullIsZero")
    @Mapping(source = "tasaSuracorp", target = "tasaSuracorp", qualifiedByName = "nullIsZero")
    public ParFeeSegmento toEntity(ParFeeSegmentoDto dto);

    @Mapping(source = "montoMin", target = "montoMin", qualifiedByName = "zeroIsNull")
    @Mapping(source = "montoMax", target = "montoMax", qualifiedByName = "zeroIsNull")
    @Mapping(source = "annualFee", target = "annualFee", qualifiedByName = "zeroIsNull")
    @Mapping(source = "tasaProteccion", target = "tasaProteccion", qualifiedByName = "zeroIsNull")
    @Mapping(source = "tasaSuracorp", target = "tasaSuracorp", qualifiedByName = "zeroIsNull")
    public ParFeeSegmentoDto toDto(ParFeeSegmento dto);
}