package cl.qande.mmii.app.util.mapper.core;

import cl.qande.mmii.app.models.api.reportes_maestros.MaestroSaldosApiDto;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import cl.qande.mmii.app.util.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

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
}