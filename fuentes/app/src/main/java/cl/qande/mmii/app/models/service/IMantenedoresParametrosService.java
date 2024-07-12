package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.dto.ParFeeSegmentoDto;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface IMantenedoresParametrosService {

    @Transactional(readOnly = true)
    public ParFeeSegmentoDto registroPorId(Integer id);
    @Transactional(readOnly = true)
    public List<ParFeeSegmentoDto> listaRegistros();

    List<ParFeeSegmentoDto> listaRegistrosOrdenadorPorMonto();

    boolean isValidSegmentoFee(Integer id, BigDecimal montoMin, BigDecimal montoMax);

    @Transactional(readOnly = true)
    public ParFeeSegmentoDto guardarRegistro(ParFeeSegmentoDto parFeeSegmentoDto);

}
