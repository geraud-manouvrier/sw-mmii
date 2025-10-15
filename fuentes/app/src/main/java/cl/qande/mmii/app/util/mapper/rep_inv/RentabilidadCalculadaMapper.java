package cl.qande.mmii.app.util.mapper.rep_inv;

import cl.qande.mmii.app.models.api.retornos.RetornoCuenta;
import cl.qande.mmii.app.models.db.rep_inv.entity.RentabilidadCalculada;
import cl.qande.mmii.app.util.mapper.EntityMapper;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RentabilidadCalculadaMapper extends EntityMapper<RetornoCuenta, RentabilidadCalculada> {


  @Mapping(source = "agregadorN2", target = "accountNo", qualifiedByName = "accountFromAgregador")
  @Mapping(source = "base8Rentabilidad", target = "rentDia")
  @Mapping(source = "base3Rentabilidad", target = "rent1m")
  @Mapping(source = "base4Rentabilidad", target = "rent3m")
  @Mapping(source = "base5Rentabilidad", target = "rent12m")
  @Mapping(source = "base6Rentabilidad", target = "rentYtd")
  @Mapping(source = "base1Rentabilidad", target = "rentInicio")
  public RetornoCuenta toDto(RentabilidadCalculada entity);

  @Named("accountFromAgregador")
  public static String accountFromAgregador(String agregadorN2) {
    if (agregadorN2 == null || !agregadorN2.contains("||")) {
      return null;
    }
    String[] parts = agregadorN2.split("\\|\\|");
    return parts.length > 1 ? parts[1] : null;
  }
}