package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.clientes.entity.ComisionCuenta;
import cl.qande.mmii.app.models.dto.ComisionCuentaDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ComisionCuentaMapper extends EntityMapper<ComisionCuentaDto, ComisionCuenta> {
}