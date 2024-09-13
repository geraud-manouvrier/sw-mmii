package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.core.entity.RectificacionCuentasNoInformada;
import cl.qande.mmii.app.models.dto.RectificacionCuentasNoInformadaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RectificacionCuentasNoInformadaMapper extends EntityMapper<RectificacionCuentasNoInformadaDto, RectificacionCuentasNoInformada> {
    @Mapping(source = "tipoReg", target = "tipoReg", qualifiedByName = "blankIsNull")
    @Mapping(source = "w8Date", target = "w8Date", qualifiedByName = "blankIsNull")
    @Mapping(source = "w8StatusValue", target = "w8StatusValue", qualifiedByName = "blankIsNull")
    @Mapping(source = "w9StatusValue", target = "w9StatusValue", qualifiedByName = "blankIsNull")
    @Mapping(source = "debitCardIndicator", target = "debitCardIndicator", qualifiedByName = "blankIsNull")
    @Mapping(source = "restrictionDate", target = "restrictionDate", qualifiedByName = "blankIsNull")
    @Mapping(source = "processStamp", target = "processStamp", qualifiedByName = "blankIsNull")
    @Mapping(source = "lastProcessDate", target = "lastProcessDate", qualifiedByName = "blankIsNull")
    @Mapping(source = "lastProcessStamp", target = "lastProcessStamp", qualifiedByName = "blankIsNull")
    @Mapping(source = "acctTypeInd", target = "acctTypeInd", qualifiedByName = "blankIsNull")
    @Mapping(source = "rep", target = "rep", qualifiedByName = "blankIsNull")
    @Mapping(source = "branch", target = "branch", qualifiedByName = "blankIsNull")
    @Mapping(source = "idCuentaCustodio", target = "idCuentaCustodio", qualifiedByName = "blankIsNull")
    @Mapping(source = "nameLine1", target = "nameLine1", qualifiedByName = "blankIsNull")
    @Mapping(source = "nameLine2", target = "nameLine2", qualifiedByName = "blankIsNull")
    @Mapping(source = "nameLine3", target = "nameLine3", qualifiedByName = "blankIsNull")
    @Mapping(source = "nameLine4", target = "nameLine4", qualifiedByName = "blankIsNull")
    @Mapping(source = "nameLine5", target = "nameLine5", qualifiedByName = "blankIsNull")
    @Mapping(source = "nameLine6", target = "nameLine6", qualifiedByName = "blankIsNull")
    @Mapping(source = "acctStatus", target = "acctStatus", qualifiedByName = "blankIsNull")
    @Mapping(source = "countryCode", target = "countryCode", qualifiedByName = "blankIsNull")
    @Mapping(source = "w8Status", target = "w8Status", qualifiedByName = "blankIsNull")
    @Mapping(source = "w9Status", target = "w9Status", qualifiedByName = "blankIsNull")
    @Mapping(source = "discrTradingCode", target = "discrTradingCode", qualifiedByName = "blankIsNull")
    @Mapping(source = "socialCode", target = "socialCode", qualifiedByName = "blankIsNull")
    @Mapping(source = "instCode", target = "instCode", qualifiedByName = "blankIsNull")
    @Mapping(source = "cma", target = "cma", qualifiedByName = "blankIsNull")
    @Mapping(source = "lastStmtCym", target = "lastStmtCym", qualifiedByName = "blankIsNull")
    @Mapping(source = "lastActivityCym", target = "lastActivityCym", qualifiedByName = "blankIsNull")
    @Mapping(source = "marginSi1", target = "marginSi1", qualifiedByName = "blankIsNull")
    @Mapping(source = "marginSi2", target = "marginSi2", qualifiedByName = "blankIsNull")
    @Mapping(source = "restrictionCode", target = "restrictionCode", qualifiedByName = "blankIsNull")
    @Mapping(source = "restrictionCodeValue", target = "restrictionCodeValue", qualifiedByName = "blankIsNull")
    @Mapping(source = "accountRestriction", target = "accountRestriction", qualifiedByName = "blankIsNull")
    public RectificacionCuentasNoInformada toEntity(RectificacionCuentasNoInformadaDto dto);
}