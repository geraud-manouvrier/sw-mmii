package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ParSourceCode;
import cl.qande.mmii.app.models.db.core.dao.IParSourceCodeDao;
import cl.qande.mmii.app.models.dto.ParSourceCodeDto;
import cl.qande.mmii.app.models.exception.DaoException;
import cl.qande.mmii.app.models.service.IMantenedoresInstrumentosService;
import cl.qande.mmii.app.util.helper.mapper.ParSourceCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MantenedoresInstrumentosImpl implements IMantenedoresInstrumentosService {
    private final IParSourceCodeDao parSourceCodeDao;
    private final ParSourceCodeMapper parSourceCodeMapper;

    @Autowired
    public MantenedoresInstrumentosImpl(IParSourceCodeDao parSourceCodeDao, ParSourceCodeMapper parSourceCodeMapper) {
        this.parSourceCodeDao = parSourceCodeDao;
        this.parSourceCodeMapper = parSourceCodeMapper;
    }


    @Override
    public List<ParSourceCodeDto> listaSourceCode(boolean flagOrdenada) {
        if(flagOrdenada) {
            return parSourceCodeMapper.toDto(parSourceCodeDao.findAllOrderedBySourCodeAndSigno());
        }
        return parSourceCodeMapper.toDto(parSourceCodeDao.findAll());
    }

    @Override
    public ParSourceCodeDto sourceCodeByPershingCodeAndSigno(String sourceCodePershing, Integer signoMovimiento) {
        return parSourceCodeMapper.toDto(parSourceCodeDao.findBySourceCodePershingAndSignoMovimiento(sourceCodePershing, signoMovimiento));
    }

    @Override
    public ParSourceCodeDto sourceCodeById(Long id) {
        return parSourceCodeMapper.toDto(parSourceCodeDao.findById(id).orElse(null));
    }

    @Override
    public ParSourceCodeDto save(ParSourceCodeDto parSourceCodeDto) throws DaoException {

        isValid(parSourceCodeDto, true);
        return parSourceCodeMapper.toDto(parSourceCodeDao.save(parSourceCodeMapper.toEntity(parSourceCodeDto)));
    }
    @Override
    public ParSourceCodeDto save(ParSourceCode parSourceCodeFromApi) throws DaoException {

        var existingParSourceCode = sourceCodeByPershingCodeAndSigno(parSourceCodeFromApi.getSourceCodePershing(), parSourceCodeFromApi.getSignoMovimiento());
        if (existingParSourceCode!=null) {
            //Ya existe un registro
            existingParSourceCode.setDescripcionMovimiento(parSourceCodeFromApi.getDescripcionMovimiento());
            existingParSourceCode.setSignoMovimiento(parSourceCodeFromApi.getSignoMovimiento());
            existingParSourceCode.setAplicaFlujoNeto(parSourceCodeFromApi.getAplicaFlujoNeto());
            return save(existingParSourceCode);
        }
        //Nuevo registro
        var newParSourceCode = new ParSourceCodeDto();
        newParSourceCode.setSourceCodePershing(parSourceCodeFromApi.getSourceCodePershing());
        newParSourceCode.setSignoMovimiento(parSourceCodeFromApi.getSignoMovimiento());
        newParSourceCode.setDescripcionMovimiento(parSourceCodeFromApi.getDescripcionMovimiento());
        newParSourceCode.setAplicaFlujoNeto(parSourceCodeFromApi.getAplicaFlujoNeto());
        newParSourceCode.setObservacionesInternas(parSourceCodeFromApi.getObservacionesInternas());
        return save(newParSourceCode);
    }


    private boolean isValid(ParSourceCodeDto parSourceCodeDto, boolean flagThrowException) throws DaoException {
        var existingDao = sourceCodeByPershingCodeAndSigno(parSourceCodeDto.getSourceCodePershing(), parSourceCodeDto.getSignoMovimiento());
        if ( existingDao!=null) {
            //Existe un registro
            //Si viene ID y es el mismo, no hay problema
            if ( (parSourceCodeDto.getId()!=null) && (parSourceCodeDto.getId().equals(existingDao.getId())) ) {
                return true;
            }
            if (flagThrowException) {
                throw new DaoException("Ya existe un registro para este Source Code y Signo");
            }
            return false;
        }
        //Otras validaciones
        return true;
    }
}
