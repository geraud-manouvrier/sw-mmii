package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.sura.entity.Cliente;
import cl.qande.mmii.app.models.dto.ClienteDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper extends EntityMapper<ClienteDto, Cliente> {
    @Mapping(source = "residenteFiscalUsa", target = "residenteFiscalUsa", qualifiedByName = "blankIsNull")
    public Cliente toEntity(ClienteDto dto);
    @Mapping(source = "residenteFiscalUsa", target = "residenteFiscalUsa", qualifiedByName = "nullIsBlank")
    public ClienteDto toDto(Cliente entity);

    @Named("blankIsNull")
    public static String blankIsNull(String stringValue) {
        if (stringValue!=null && stringValue.isBlank())
            return null;
        return stringValue;
    }

    @Named("nullIsBlank")
    public static String nullIsBlank(String stringValue) {
        if (stringValue==null)
            return "";
        return stringValue;
    }
}