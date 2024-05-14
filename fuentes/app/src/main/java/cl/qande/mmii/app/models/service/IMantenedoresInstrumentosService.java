package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.dto.ParSourceCodeDto;
import cl.qande.mmii.app.models.exception.DaoException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMantenedoresInstrumentosService {

    @Transactional(readOnly = true)
    List<ParSourceCodeDto> listaSourceCode(boolean flagOrdenada);

    @Transactional(readOnly = true)
    List<ParSourceCodeDto> listaSourceCode(String sourceCodePershing, Integer signoMovimiento);

    abstract ParSourceCodeDto sourceCodeById(Long id);

    ParSourceCodeDto save(ParSourceCodeDto parSourceCodeDto) throws DaoException;
}
