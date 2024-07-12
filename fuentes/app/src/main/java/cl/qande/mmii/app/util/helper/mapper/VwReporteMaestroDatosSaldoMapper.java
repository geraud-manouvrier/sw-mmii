package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.api.MaestroSaldosApiDto;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import cl.qande.mmii.app.util.helper.MathHelper;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VwReporteMaestroDatosSaldoMapper extends EntityMapper<MaestroSaldosApiDto, VwReporteMaestroDatosSaldo> {

    @Mapping(source = "quantity", target = "quantity", qualifiedByName = "redondea")
    @Mapping(source = "marketPrice", target = "marketPrice", qualifiedByName = "redondea")
    @Mapping(source = "marketValue", target = "marketValue", qualifiedByName = "redondea")
    @Mapping(source = "fxRate", target = "fxRate", qualifiedByName = "redondea")
    @Mapping(source = "usdeMarketValue", target = "usdeMarketValue", qualifiedByName = "redondea")
    @Mapping(source = "usdeMarketPrice", target = "usdeMarketPrice", qualifiedByName = "redondea")
    @Mapping(source = "annualFee", target = "annualFee", qualifiedByName = "redondea")
    @Mapping(source = "tasaProteccion", target = "tasaProteccion", qualifiedByName = "redondea")
    @Mapping(source = "feeDiarioProteccion", target = "feeDiarioProteccion", qualifiedByName = "redondea")
    @Mapping(source = "ingresoProteccion", target = "ingresoProteccion", qualifiedByName = "redondea")
    public MaestroSaldosApiDto toDto(VwReporteMaestroDatosSaldo entity);

    @Named("redondea")
    public static BigDecimal redondea(BigDecimal dtoValue) {
        return MathHelper.redondeaDecimal(dtoValue, 4);
    }
}