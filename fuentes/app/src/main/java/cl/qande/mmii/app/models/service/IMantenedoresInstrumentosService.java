package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ParSourceCode;
import cl.qande.mmii.app.models.dto.ParSourceCodeDto;
import cl.qande.mmii.app.models.exception.DaoException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMantenedoresInstrumentosService {

    @Transactional(readOnly = true)
    List<ParSourceCodeDto> listaSourceCode(boolean flagOrdenada);

    @Transactional(readOnly = true)
    ParSourceCodeDto sourceCodeByPershingCodeAndSigno(String sourceCodePershing, Integer signoMovimiento);

    @Transactional(readOnly = true)
    ParSourceCodeDto sourceCodeById(Long id);

    @Transactional
    ParSourceCodeDto save(ParSourceCodeDto parSourceCodeDto) throws DaoException;

    @Transactional
    ParSourceCodeDto save(ParSourceCode parSourceCodeFromApi) throws DaoException;
}
