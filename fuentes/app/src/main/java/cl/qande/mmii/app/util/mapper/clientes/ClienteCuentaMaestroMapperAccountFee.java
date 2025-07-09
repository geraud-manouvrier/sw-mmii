package cl.qande.mmii.app.util.mapper.clientes;

import cl.qande.mmii.app.models.api_clients.mmii_suracorp.AccountFee;
import cl.qande.mmii.app.models.db.clientes.entity.ClienteCuentaMaestro;
import cl.qande.mmii.app.util.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteCuentaMaestroMapperAccountFee extends EntityMapper<AccountFee, ClienteCuentaMaestro> {

    @Mapping(source = "idCuentaCustodio", target = "accountNumber")
    @Mapping(source = "fee", target = "fee")
    public AccountFee toDto(ClienteCuentaMaestro entity);
}