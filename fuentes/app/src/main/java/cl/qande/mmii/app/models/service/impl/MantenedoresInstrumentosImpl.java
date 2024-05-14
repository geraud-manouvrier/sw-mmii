package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.core.dao.IParHomologacionSourceCodeStonexDao;
import cl.qande.mmii.app.models.db.core.dao.IParSourceCodeDao;
import cl.qande.mmii.app.models.dto.ParHomologacionSourceCodeStonexDto;
import cl.qande.mmii.app.models.dto.ParSourceCodeDto;
import cl.qande.mmii.app.models.exception.DaoException;
import cl.qande.mmii.app.models.service.IMantenedoresInstrumentosService;
import cl.qande.mmii.app.util.helper.mapper.ParHomologacionSourceCodeStonexMapper;
import cl.qande.mmii.app.util.helper.mapper.ParSourceCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MantenedoresInstrumentosImpl implements IMantenedoresInstrumentosService {
    @Autowired
    private IParSourceCodeDao parSourceCodeDao;
    @Autowired
    private IParHomologacionSourceCodeStonexDao parHomologacionSourceCodeStonexDao;
    @Autowired
    private ParSourceCodeMapper parSourceCodeMapper;
    @Autowired
    private ParHomologacionSourceCodeStonexMapper parHomologacionSourceCodeStonexMapper;
    @Override
    public List<ParSourceCodeDto> listaSourceCode(boolean flagOrdenada) {
        if(flagOrdenada) {
            return parSourceCodeMapper.toDto(parSourceCodeDao.findAllOrderedBySourCodeAndSigno());
        }
        return parSourceCodeMapper.toDto(parSourceCodeDao.findAll());
    }
    @Override
    public List<ParHomologacionSourceCodeStonexDto> listaSourceCodeStonex() {
        return parHomologacionSourceCodeStonexMapper.toDto(parHomologacionSourceCodeStonexDao.findAll());
    }

    @Override
    public List<ParSourceCodeDto> listaSourceCode(String sourceCodePershing, Integer signoMovimiento) {
        return parSourceCodeMapper.toDto(parSourceCodeDao.findBySourceCodePershingAndSignoMovimiento(sourceCodePershing, signoMovimiento));
    }
    @Override
    public List<ParHomologacionSourceCodeStonexDto> listaSourceCodeStonex(String sourceCodeStonex, Integer signoMovimiento) {
        return parHomologacionSourceCodeStonexMapper.toDto(parHomologacionSourceCodeStonexDao.findBySourceCodeStonexAndSignoMovimiento(sourceCodeStonex, signoMovimiento));
    }

    @Override
    public ParSourceCodeDto sourceCodeById(Long id) {
        return parSourceCodeMapper.toDto(parSourceCodeDao.findById(id).orElse(null));
    }
    @Override
    public ParHomologacionSourceCodeStonexDto sourceCodeStonexById(Long id) {
        return parHomologacionSourceCodeStonexMapper.toDto(parHomologacionSourceCodeStonexDao.findById(id).orElse(null));
    }

    @Override
    public ParSourceCodeDto save(ParSourceCodeDto parSourceCodeDto) throws DaoException {

        isValid(parSourceCodeDto, true);
        return parSourceCodeMapper.toDto(parSourceCodeDao.save(parSourceCodeMapper.toEntity(parSourceCodeDto)));
    }

    @Override
    public ParHomologacionSourceCodeStonexDto save(ParHomologacionSourceCodeStonexDto parHomologacionSourceCodeStonexDto) throws DaoException {

        isValid(parHomologacionSourceCodeStonexDto, true);
        return parHomologacionSourceCodeStonexMapper.toDto(parHomologacionSourceCodeStonexDao.save(parHomologacionSourceCodeStonexMapper.toEntity(parHomologacionSourceCodeStonexDto)));
    }

    private boolean isValid(ParSourceCodeDto parSourceCodeDto, boolean flagThrowException) throws DaoException {
        var existingDao = parSourceCodeDao.findBySourceCodePershingAndSignoMovimiento(parSourceCodeDto.getSourceCodePershing(), parSourceCodeDto.getSignoMovimiento());
        if (! existingDao.isEmpty()) {
            //Existe un registro
            //Si viene ID y es el mismo, no hay problema
            if ( (parSourceCodeDto.getId()!=null) && (parSourceCodeDto.getId().equals(existingDao.get(0).getId())) ) {
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
    private boolean isValid(ParHomologacionSourceCodeStonexDto parHomologacionSourceCodeStonexDto, boolean flagThrowException) throws DaoException {
        var existingDao = parHomologacionSourceCodeStonexDao.findBySourceCodeStonexAndSignoMovimiento(parHomologacionSourceCodeStonexDto.getSourceCodeStonex(), parHomologacionSourceCodeStonexDto.getSignoMovimiento());
        if(! existingDao.isEmpty()) {
            //Existe un registro
            //Si viene ID y es el mismo, no hay problema
            if ( (parHomologacionSourceCodeStonexDto.getId()!=null) && (parHomologacionSourceCodeStonexDto.getId().equals(existingDao.get(0).getId())) ) {
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
