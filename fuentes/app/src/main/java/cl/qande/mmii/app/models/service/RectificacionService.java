package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.core.dao.IRectificacionCuentasNoInformadaDao;
import cl.qande.mmii.app.models.db.core.dao.IRectificacionMovimientosNoInformadoDao;
import cl.qande.mmii.app.models.db.core.dao.IRectificacionSaldosNoInformadoDao;
import cl.qande.mmii.app.models.dto.core.RectificacionCuentasNoInformadaDto;
import cl.qande.mmii.app.models.dto.core.RectificacionMovimientosNoInformadoDto;
import cl.qande.mmii.app.models.dto.core.RectificacionSaldosNoInformadoDto;
import cl.qande.mmii.app.util.mapper.core.RectificacionCuentasNoInformadaMapper;
import cl.qande.mmii.app.util.mapper.core.RectificacionMovimientosNoInformadoMapper;
import cl.qande.mmii.app.util.mapper.core.RectificacionSaldosNoInformadoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class RectificacionService {


    private static final int ETDO_PENDIENTE = -1;
    private static final int ETDO_APROBADO = 0;
    private static final int ETDO_RECHAZADO = 1;
    private static final int ETDO_ANULADO = 2;
    private static final int ETDO_REVERSADO = 3;


    private final IRectificacionCuentasNoInformadaDao rectificacionCuentasNoInformadaDao;
    private final IRectificacionSaldosNoInformadoDao rectificacionSaldosNoInformadoDao;
    private final IRectificacionMovimientosNoInformadoDao rectificacionMovimientosNoInformadoDao;
    private final RectificacionCuentasNoInformadaMapper rectificacionCuentasNoInformadaMapper;
    private final RectificacionSaldosNoInformadoMapper rectificacionSaldosNoInformadoMapper;
    private final RectificacionMovimientosNoInformadoMapper rectificacionMovimientosNoInformadoMapper;

    public RectificacionService(IRectificacionCuentasNoInformadaDao rectificacionCuentasNoInformadaDao, IRectificacionSaldosNoInformadoDao rectificacionSaldosNoInformadoDao, IRectificacionMovimientosNoInformadoDao rectificacionMovimientosNoInformadoDao, RectificacionCuentasNoInformadaMapper rectificacionCuentasNoInformadaMapper, RectificacionSaldosNoInformadoMapper rectificacionSaldosNoInformadoMapper, RectificacionMovimientosNoInformadoMapper rectificacionMovimientosNoInformadoMapper) {
        this.rectificacionCuentasNoInformadaDao = rectificacionCuentasNoInformadaDao;
        this.rectificacionSaldosNoInformadoDao = rectificacionSaldosNoInformadoDao;
        this.rectificacionMovimientosNoInformadoDao = rectificacionMovimientosNoInformadoDao;
        this.rectificacionCuentasNoInformadaMapper = rectificacionCuentasNoInformadaMapper;
        this.rectificacionSaldosNoInformadoMapper = rectificacionSaldosNoInformadoMapper;
        this.rectificacionMovimientosNoInformadoMapper = rectificacionMovimientosNoInformadoMapper;
    }


    @Transactional
    public void guardaRectificacionCuentaNoInformada(RectificacionCuentasNoInformadaDto rectificacionCuentasNoInformadaDto) {
        rectificacionCuentasNoInformadaDao.save(rectificacionCuentasNoInformadaMapper.toEntity(rectificacionCuentasNoInformadaDto));
    }
    
    @Transactional
    public void guardaListaRectificacionCuentasNoInformada(List<RectificacionCuentasNoInformadaDto> listaRectificacionCuentasNoInformadaDto) {
        rectificacionCuentasNoInformadaDao.saveAll(rectificacionCuentasNoInformadaMapper.toEntity(listaRectificacionCuentasNoInformadaDto));
    }
    
    @Transactional
    public void guardaListaRectificacionSaldosNoInformado(List<RectificacionSaldosNoInformadoDto> listaRectificacionSaldosNoInformadaDto) {
        rectificacionSaldosNoInformadoDao.saveAll(rectificacionSaldosNoInformadoMapper.toEntity(listaRectificacionSaldosNoInformadaDto));
    }
    
    @Transactional
    public void guardaListaRectificacionMovimientosNoInformado(List<RectificacionMovimientosNoInformadoDto> listaRectificacionMovimientosNoInformadaDto) {
        rectificacionMovimientosNoInformadoDao.saveAll(rectificacionMovimientosNoInformadoMapper.toEntity(listaRectificacionMovimientosNoInformadaDto));
    }


    
    @Transactional(readOnly = true)
    public List<RectificacionCuentasNoInformadaDto> listaRectificacionesCuentasPendientes() {
        return rectificacionCuentasNoInformadaMapper.toDto(rectificacionCuentasNoInformadaDao.findByIdEstadoAndOptionalProcessDate(ETDO_PENDIENTE, null));
    }
    
    @Transactional(readOnly = true)
    public List<RectificacionCuentasNoInformadaDto> listaRectificacionesCuentasAprobadas(String optionalProcessDate) {
        return rectificacionCuentasNoInformadaMapper.toDto(rectificacionCuentasNoInformadaDao.findByIdEstadoAndOptionalProcessDate(ETDO_APROBADO, optionalProcessDate));
    }
    
    @Transactional(readOnly = true)
    public List<RectificacionCuentasNoInformadaDto> listaRectificacionesCuentasRechazadas() {
        return rectificacionCuentasNoInformadaMapper.toDto(rectificacionCuentasNoInformadaDao.findByIdEstadoAndOptionalProcessDate(ETDO_RECHAZADO, null));
    }

    
    @Transactional
    public int aprobacionMasivaCuentas(String usuarioModificador) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_APROBADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionCuentasNoInformadaDao.updateEstadoRectificacionByIdQuery(nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int aprobacionPorIdCuenta(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_APROBADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionCuentasNoInformadaDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int aprobacionPorSeleccionCuenta(String usuarioModificador, String[] idsCuentas) {
        if (idsCuentas==null || idsCuentas.length==0)
            return 0;
        int i=0;
        for (i=0; i<idsCuentas.length; i++) {
            Long idActual   = Long.valueOf(idsCuentas[i]);
            this.aprobacionPorIdCuenta(usuarioModificador, idActual);
        }
        return i;
    }
    
    @Transactional
    public int rechazoMasivaCuentas(String usuarioModificador) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_RECHAZADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionCuentasNoInformadaDao.updateEstadoRectificacionByIdQuery(nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int rechazoPorIdCuenta(String usuarioModificador,  Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_RECHAZADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionCuentasNoInformadaDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int rechazoPorSeleccionCuenta(String usuarioModificador, String[] idsCuentas) {
        if (idsCuentas==null || idsCuentas.length==0)
            return 0;
        int i=0;
        for (i=0; i<idsCuentas.length; i++) {
            Long idActual   = Long.valueOf(idsCuentas[i]);
            this.rechazoPorIdCuenta(usuarioModificador, idActual);
        }
        return i;
    }
    
    @Transactional
    public int anularRegistroCuenta(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_ANULADO;
        return rectificacionCuentasNoInformadaDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int reversarRegistroCuenta(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_REVERSADO;
        return rectificacionCuentasNoInformadaDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, usuarioModificador, timestampModificador);
    }





    
    @Transactional(readOnly = true)
    public List<RectificacionSaldosNoInformadoDto> listaRectificacionesSaldosPendientes() {
        return rectificacionSaldosNoInformadoMapper.toDto(rectificacionSaldosNoInformadoDao.findByIdEstadoAndOptionalProcessDate(ETDO_PENDIENTE, null));
    }
    
    @Transactional(readOnly = true)
    public List<RectificacionSaldosNoInformadoDto> listaRectificacionesSaldosAprobadas(String optionalProcessDate) {
        return rectificacionSaldosNoInformadoMapper.toDto(rectificacionSaldosNoInformadoDao.findByIdEstadoAndOptionalProcessDate(ETDO_APROBADO, optionalProcessDate));
    }
    
    @Transactional(readOnly = true)
    public List<RectificacionSaldosNoInformadoDto> listaRectificacionesSaldosRechazadas() {
        return rectificacionSaldosNoInformadoMapper.toDto(rectificacionSaldosNoInformadoDao.findByIdEstadoAndOptionalProcessDate(ETDO_RECHAZADO, null));
    }
    
    @Transactional
    public int aprobacionMasivaSaldos(String usuarioModificador) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_APROBADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionSaldosNoInformadoDao.updateEstadoRectificacionByIdQuery(nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int aprobacionPorIdSaldo(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_APROBADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionSaldosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int aprobacionPorSeleccionSaldos(String usuarioModificador, String[] idsSaldos) {
        if (idsSaldos==null || idsSaldos.length==0)
            return 0;
        int i=0;
        for (i=0; i<idsSaldos.length; i++) {
            Long idActual   = Long.valueOf(idsSaldos[i]);
            this.aprobacionPorIdSaldo(usuarioModificador, idActual);
        }
        return i;
    }
    
    @Transactional
    public int rechazoMasivaSaldos(String usuarioModificador) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_RECHAZADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionSaldosNoInformadoDao.updateEstadoRectificacionByIdQuery(nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int rechazoPorIdSaldos(String usuarioModificador,  Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_RECHAZADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionSaldosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int rechazoPorSeleccionSaldos(String usuarioModificador, String[] idsSaldos) {
        if (idsSaldos==null || idsSaldos.length==0)
            return 0;
        int i=0;
        for (i=0; i<idsSaldos.length; i++) {
            Long idActual   = Long.valueOf(idsSaldos[i]);
            this.rechazoPorIdSaldos(usuarioModificador, idActual);
        }
        return i;
    }
    
    @Transactional
    public int anularRegistroSaldo(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_ANULADO;
        return rectificacionSaldosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int reversarRegistroSaldo(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_REVERSADO;
        return rectificacionSaldosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, usuarioModificador, timestampModificador);
    }



    
    @Transactional(readOnly = true)
    public List<RectificacionMovimientosNoInformadoDto> listaRectificacionesMovimientosPendientes() {
        return rectificacionMovimientosNoInformadoMapper.toDto(rectificacionMovimientosNoInformadoDao.findByIdEstadoAndOptionalProcessDate(ETDO_PENDIENTE, null));
    }
    
    @Transactional(readOnly = true)
    public List<RectificacionMovimientosNoInformadoDto> listaRectificacionesMovimientosAprobadas(String optionalProcessDate) {
        return rectificacionMovimientosNoInformadoMapper.toDto(rectificacionMovimientosNoInformadoDao.findByIdEstadoAndOptionalProcessDate(ETDO_APROBADO, optionalProcessDate));
    }
    
    @Transactional(readOnly = true)
    public List<RectificacionMovimientosNoInformadoDto> listaRectificacionesMovimientosRechazadas() {
        return rectificacionMovimientosNoInformadoMapper.toDto(rectificacionMovimientosNoInformadoDao.findByIdEstadoAndOptionalProcessDate(ETDO_RECHAZADO, null));
    }
    
    @Transactional
    public int aprobacionMasivaMovimientos(String usuarioModificador) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_APROBADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionMovimientosNoInformadoDao.updateEstadoRectificacionByIdQuery(nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int aprobacionPorIdMovimiento(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_APROBADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionMovimientosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int aprobacionPorSeleccionMovimientos(String usuarioModificador, String[] idsMovimientos) {
        if (idsMovimientos==null || idsMovimientos.length==0)
            return 0;
        int i=0;
        for (i=0; i<idsMovimientos.length; i++) {
            Long idActual   = Long.valueOf(idsMovimientos[i]);
            this.aprobacionPorIdMovimiento(usuarioModificador, idActual);
        }
        return i;
    }
    
    @Transactional
    public int rechazoMasivaMovimientos(String usuarioModificador) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_RECHAZADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionMovimientosNoInformadoDao.updateEstadoRectificacionByIdQuery(nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int rechazoPorIdMovimiento(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_RECHAZADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionMovimientosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int rechazoPorSeleccionMovimientos(String usuarioModificador, String[] idsMovimientos) {
        if (idsMovimientos==null || idsMovimientos.length==0)
            return 0;
        int i=0;
        for (i=0; i<idsMovimientos.length; i++) {
            Long idActual   = Long.valueOf(idsMovimientos[i]);
            this.rechazoPorIdMovimiento(usuarioModificador, idActual);
        }
        return i;
    }
    
    @Transactional
    public int anularRegistroMovimiento(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_ANULADO;
        return rectificacionMovimientosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, usuarioModificador, timestampModificador);
    }
    
    @Transactional
    public int reversarRegistroMovimiento(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_REVERSADO;
        return rectificacionMovimientosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, usuarioModificador, timestampModificador);
    }

}
