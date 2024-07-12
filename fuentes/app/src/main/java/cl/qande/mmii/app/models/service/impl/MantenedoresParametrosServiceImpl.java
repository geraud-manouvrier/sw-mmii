package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.clientes.dao.IParFeeSegmentoDao;
import cl.qande.mmii.app.models.dto.ParFeeSegmentoDto;
import cl.qande.mmii.app.models.service.IMantenedoresParametrosService;
import cl.qande.mmii.app.util.helper.mapper.ParFeeSegmentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class MantenedoresParametrosServiceImpl implements IMantenedoresParametrosService {

    @Autowired
    private IParFeeSegmentoDao parFeeSegmentoDao;
    @Autowired
    private ParFeeSegmentoMapper parFeeSegmentoMapper;

    @Override
    public ParFeeSegmentoDto registroPorId(Integer id) {
        return parFeeSegmentoMapper.toDto((parFeeSegmentoDao.findById(id).orElse(null)));
    }

    @Override
    public List<ParFeeSegmentoDto> listaRegistros() {
        return parFeeSegmentoMapper.toDto(parFeeSegmentoDao.findAll());
    }

    @Override
    public List<ParFeeSegmentoDto> listaRegistrosOrdenadorPorMonto() {
        return parFeeSegmentoMapper.toDto(parFeeSegmentoDao.findAllByOrderByMontoMinAsc());
    }
    @Override
    public boolean isValidSegmentoFee(Integer id, BigDecimal montoMin, BigDecimal montoMax) {
        return parFeeSegmentoDao.validaSegmento(id, montoMin, montoMax).isEmpty();
    }

    @Override
    public ParFeeSegmentoDto guardarRegistro(ParFeeSegmentoDto parFeeSegmentoDto) {
        parFeeSegmentoDto.setModificacionTimestamp(Instant.now());
        return parFeeSegmentoMapper.toDto(parFeeSegmentoDao.save(parFeeSegmentoMapper.toEntity(parFeeSegmentoDto)));
    }
}
