package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.sura.entity.Cuenta;
import cl.qande.mmii.app.models.dto.CuentaDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CuentaMapper extends EntityMapper<CuentaDto, Cuenta> {
}