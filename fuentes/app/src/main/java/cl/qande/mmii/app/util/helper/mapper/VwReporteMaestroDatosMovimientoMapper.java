package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.api.MaestroMovimientosApiDto;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento;
import cl.qande.mmii.app.util.helper.MathHelper;
import org.mapstruct.*;

import java.math.BigDecimal;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VwReporteMaestroDatosMovimientoMapper extends EntityMapper<MaestroMovimientosApiDto, VwReporteMaestroDatosMovimiento> {

    @Mapping(source = "quantity", target = "quantity", qualifiedByName = "redondea")
    @Mapping(source = "price", target = "price", qualifiedByName = "redondea")
    @Mapping(source = "comission", target = "comission", qualifiedByName = "redondea")
    @Mapping(source = "fees", target = "fees", qualifiedByName = "redondea")
    @Mapping(source = "netAmount", target = "netAmount", qualifiedByName = "redondea")
    @Mapping(source = "usdeNetAmount", target = "usdeNetAmount", qualifiedByName = "redondea")
    @Mapping(source = "principal", target = "principal", qualifiedByName = "redondea")
    @Mapping(source = "fxRate", target = "fxRate", qualifiedByName = "redondea")
    @Mapping(source = "retiro", target = "retiro", qualifiedByName = "redondea")
    @Mapping(source = "recaudo", target = "recaudo", qualifiedByName = "redondea")
    public MaestroMovimientosApiDto toDto(VwReporteMaestroDatosMovimiento entity);

    @Named("redondea")
    public static BigDecimal redondea(BigDecimal dtoValue) {
        return MathHelper.redondeaDecimal(dtoValue, 4);
    }
}