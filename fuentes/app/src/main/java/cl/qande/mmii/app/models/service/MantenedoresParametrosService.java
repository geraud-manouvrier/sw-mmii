package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.clientes.dao.IParFeeSegmentoDao;
import cl.qande.mmii.app.models.dto.clientes.ParFeeSegmentoDto;
import cl.qande.mmii.app.util.mapper.clientes.ParFeeSegmentoMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class MantenedoresParametrosService {

    private final IParFeeSegmentoDao parFeeSegmentoDao;
    private final ParFeeSegmentoMapper parFeeSegmentoMapper;

    public MantenedoresParametrosService(IParFeeSegmentoDao parFeeSegmentoDao, ParFeeSegmentoMapper parFeeSegmentoMapper) {
        this.parFeeSegmentoDao = parFeeSegmentoDao;
        this.parFeeSegmentoMapper = parFeeSegmentoMapper;
    }

    public ParFeeSegmentoDto registroPorId(Integer id) {
        return parFeeSegmentoMapper.toDto((parFeeSegmentoDao.findById(id).orElse(null)));
    }

    public List<ParFeeSegmentoDto> listaRegistros() {
        return parFeeSegmentoMapper.toDto(parFeeSegmentoDao.findAll());
    }

    public List<ParFeeSegmentoDto> listaRegistrosOrdenadorPorMonto() {
        return parFeeSegmentoMapper.toDto(parFeeSegmentoDao.findAllByOrderByMontoMinAsc());
    }
    public boolean isValidSegmentoFee(Integer id, BigDecimal montoMin, BigDecimal montoMax) {
        return parFeeSegmentoDao.validaSegmento(id, montoMin, montoMax).isEmpty();
    }

    public ParFeeSegmentoDto guardarRegistro(ParFeeSegmentoDto parFeeSegmentoDto) {
        parFeeSegmentoDto.setModificacionTimestamp(Instant.now());
        return parFeeSegmentoMapper.toDto(parFeeSegmentoDao.save(parFeeSegmentoMapper.toEntity(parFeeSegmentoDto)));
    }

}
