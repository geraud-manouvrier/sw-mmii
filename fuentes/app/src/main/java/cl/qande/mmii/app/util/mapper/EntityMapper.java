package cl.qande.mmii.app.util.mapper;

import cl.qande.mmii.app.util.helper.MathHelper;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.math.BigDecimal;
import java.util.List;

public interface EntityMapper <D, E> {
    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);
    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget E entity, D dto);


    @Named("blankIsNull")
    public static String blankIsNull(String dtoStringValue) {
        if (dtoStringValue==null || dtoStringValue.isEmpty())
            return null;
        return dtoStringValue;
    }

    @Named("zeroIsNull")
    public static BigDecimal zeroIsNull(BigDecimal value) {
        if( value.compareTo(BigDecimal.ZERO)==0 )
            return null;
        return value;
    }
    @Named("nullIsZero")
    public static BigDecimal nullIsZero(BigDecimal value) {
        if (value==null)
            return BigDecimal.ZERO;
        return value;
    }

    @Named("negativeIsNull")
    public static Integer negativeIsNull(Integer value) {
        if (value!=null && value<0)
            return null;
        return value;
    }

    @Named("redondea")
    public static BigDecimal redondea(BigDecimal dtoValue) {
        return MathHelper.redondeaDecimal(dtoValue, 4);
    }

}