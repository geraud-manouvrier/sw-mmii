package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.core.dao.ParFeriadoDao;
import cl.qande.mmii.app.models.dto.core.ParFeriadoDto;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.mapper.core.ParFeriadoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ParametrosSistemaService {

    private final ParFeriadoDao parFeriadoDao;
    private final ParFeriadoMapper parFeriadoMapper;

    public ParametrosSistemaService(ParFeriadoDao parFeriadoDao,
                                    ParFeriadoMapper parFeriadoMapper) {
        this.parFeriadoDao = parFeriadoDao;
        this.parFeriadoMapper = parFeriadoMapper;
    }

    @Transactional(readOnly = true)
    public List<ParFeriadoDto> listaFeriado() {
        return parFeriadoMapper.toDto(parFeriadoDao.findAllByOrderByIdDesc());

    }
    @Transactional(readOnly = true)
    public ParFeriadoDto listaFeriado(LocalDate dia) {
        return parFeriadoMapper.toDto(parFeriadoDao.findById(dia).orElse(null));
    }
    @Transactional
    public ParFeriadoDto guardaFeriado(ParFeriadoDto parFeriado) {
        return parFeriadoMapper.toDto(parFeriadoDao.save(parFeriadoMapper.toEntity(parFeriado)));
    }

    @Transactional
    public void toggleFeriadoPershing(LocalDate dia) throws QandeMmiiException {
        try {
            parFeriadoDao.toggleFeriadoPershing(dia);
        } catch (Exception e) {
            var msg = "No se pudo cambiar el estado del feriado Pershing para el: " + dia;
            CustomLog.getInstance().error(msg, true);
            throw new QandeMmiiException(e,msg);
        }
    }

    @Transactional
    public void toggleFeriadoStonex(LocalDate dia) throws QandeMmiiException {
        try {
            parFeriadoDao.toggleFeriadoStonex(dia);
        } catch (Exception e) {
            var msg = "No se pudo cambiar el estado del feriado Stonex para el: " + dia;
            CustomLog.getInstance().error(msg, true);
            throw new QandeMmiiException(e,msg);
        }
    }

}

