package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.core.dao.IRectificacionCuentasNoInformadaDao;
import cl.qande.mmii.app.models.db.core.dao.IRectificacionMovimientosNoInformadoDao;
import cl.qande.mmii.app.models.db.core.dao.IRectificacionSaldosNoInformadoDao;
import cl.qande.mmii.app.models.dto.RectificacionCuentasNoInformadaDto;
import cl.qande.mmii.app.models.dto.RectificacionMovimientosNoInformadoDto;
import cl.qande.mmii.app.models.dto.RectificacionSaldosNoInformadoDto;
import cl.qande.mmii.app.models.service.IRectificacionService;
import cl.qande.mmii.app.util.helper.mapper.RectificacionCuentasNoInformadaMapper;
import cl.qande.mmii.app.util.helper.mapper.RectificacionMovimientosNoInformadoMapper;
import cl.qande.mmii.app.util.helper.mapper.RectificacionSaldosNoInformadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class RectificacionImpl implements IRectificacionService {
    private static final int ETDO_PENDIENTE = -1;
    private static final int ETDO_APROBADO = 0;
    private static final int ETDO_RECHAZADO = 1;
    private static final int ETDO_ANULADO = 2;
    private static final int ETDO_REVERSADO = 3;


    @Autowired
    private IRectificacionCuentasNoInformadaDao rectificacionCuentasNoInformadaDao;
    @Autowired
    private IRectificacionSaldosNoInformadoDao rectificacionSaldosNoInformadoDao;
    @Autowired
    private IRectificacionMovimientosNoInformadoDao rectificacionMovimientosNoInformadoDao;
    @Autowired
    private RectificacionCuentasNoInformadaMapper rectificacionCuentasNoInformadaMapper;
    @Autowired
    private RectificacionSaldosNoInformadoMapper rectificacionSaldosNoInformadoMapper;
    @Autowired
    private RectificacionMovimientosNoInformadoMapper rectificacionMovimientosNoInformadoMapper;


    @Override
    @Transactional
    public void guardaRectificacionCuentaNoInformada(RectificacionCuentasNoInformadaDto rectificacionCuentasNoInformadaDto) {
        rectificacionCuentasNoInformadaDao.save(rectificacionCuentasNoInformadaMapper.toEntity(rectificacionCuentasNoInformadaDto));
    }
    @Override
    @Transactional
    public void guardaListaRectificacionCuentasNoInformada(List<RectificacionCuentasNoInformadaDto> listaRectificacionCuentasNoInformadaDto) {
        rectificacionCuentasNoInformadaDao.saveAll(rectificacionCuentasNoInformadaMapper.toEntity(listaRectificacionCuentasNoInformadaDto));
    }
    @Override
    @Transactional
    public void guardaListaRectificacionSaldosNoInformado(List<RectificacionSaldosNoInformadoDto> listaRectificacionSaldosNoInformadaDto) {
        rectificacionSaldosNoInformadoDao.saveAll(rectificacionSaldosNoInformadoMapper.toEntity(listaRectificacionSaldosNoInformadaDto));
    }
    @Override
    @Transactional
    public void guardaListaRectificacionMovimientosNoInformado(List<RectificacionMovimientosNoInformadoDto> listaRectificacionMovimientosNoInformadaDto) {
        rectificacionMovimientosNoInformadoDao.saveAll(rectificacionMovimientosNoInformadoMapper.toEntity(listaRectificacionMovimientosNoInformadaDto));
    }


    @Override
    @Transactional(readOnly = true)
    public List<RectificacionCuentasNoInformadaDto> listaRectificacionesCuentasPendientes() {
        return rectificacionCuentasNoInformadaMapper.toDto(rectificacionCuentasNoInformadaDao.findByIdEstadoAndOptionalProcessDate(ETDO_PENDIENTE, null));
    }
    @Override
    @Transactional(readOnly = true)
    public List<RectificacionCuentasNoInformadaDto> listaRectificacionesCuentasAprobadas(String optionalProcessDate) {
        return rectificacionCuentasNoInformadaMapper.toDto(rectificacionCuentasNoInformadaDao.findByIdEstadoAndOptionalProcessDate(ETDO_APROBADO, optionalProcessDate));
    }
    @Override
    @Transactional(readOnly = true)
    public List<RectificacionCuentasNoInformadaDto> listaRectificacionesCuentasRechazadas() {
        return rectificacionCuentasNoInformadaMapper.toDto(rectificacionCuentasNoInformadaDao.findByIdEstadoAndOptionalProcessDate(ETDO_RECHAZADO, null));
    }

    @Override
    @Transactional
    public int aprobacionMasivaCuentas(String usuarioModificador) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_APROBADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionCuentasNoInformadaDao.updateEstadoRectificacionByIdQuery(nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    @Override
    @Transactional
    public int aprobacionPorIdCuenta(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_APROBADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionCuentasNoInformadaDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    @Override
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
    @Override
    @Transactional
    public int rechazoMasivaCuentas(String usuarioModificador) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_RECHAZADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionCuentasNoInformadaDao.updateEstadoRectificacionByIdQuery(nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    @Override
    @Transactional
    public int rechazoPorIdCuenta(String usuarioModificador,  Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_RECHAZADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionCuentasNoInformadaDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    @Override
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
    @Override
    @Transactional
    public int anularRegistroCuenta(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_ANULADO;
        return rectificacionCuentasNoInformadaDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, usuarioModificador, timestampModificador);
    }
    @Override
    @Transactional
    public int reversarRegistroCuenta(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_REVERSADO;
        return rectificacionCuentasNoInformadaDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, usuarioModificador, timestampModificador);
    }





    @Override
    @Transactional(readOnly = true)
    public List<RectificacionSaldosNoInformadoDto> listaRectificacionesSaldosPendientes() {
        return rectificacionSaldosNoInformadoMapper.toDto(rectificacionSaldosNoInformadoDao.findByIdEstadoAndOptionalProcessDate(ETDO_PENDIENTE, null));
    }
    @Override
    @Transactional(readOnly = true)
    public List<RectificacionSaldosNoInformadoDto> listaRectificacionesSaldosAprobadas(String optionalProcessDate) {
        return rectificacionSaldosNoInformadoMapper.toDto(rectificacionSaldosNoInformadoDao.findByIdEstadoAndOptionalProcessDate(ETDO_APROBADO, optionalProcessDate));
    }
    @Override
    @Transactional(readOnly = true)
    public List<RectificacionSaldosNoInformadoDto> listaRectificacionesSaldosRechazadas() {
        return rectificacionSaldosNoInformadoMapper.toDto(rectificacionSaldosNoInformadoDao.findByIdEstadoAndOptionalProcessDate(ETDO_RECHAZADO, null));
    }
    @Override
    @Transactional
    public int aprobacionMasivaSaldos(String usuarioModificador) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_APROBADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionSaldosNoInformadoDao.updateEstadoRectificacionByIdQuery(nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    @Override
    @Transactional
    public int aprobacionPorIdSaldo(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_APROBADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionSaldosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    @Override
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
    @Override
    @Transactional
    public int rechazoMasivaSaldos(String usuarioModificador) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_RECHAZADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionSaldosNoInformadoDao.updateEstadoRectificacionByIdQuery(nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    @Override
    @Transactional
    public int rechazoPorIdSaldos(String usuarioModificador,  Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_RECHAZADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionSaldosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    @Override
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
    @Override
    @Transactional
    public int anularRegistroSaldo(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_ANULADO;
        return rectificacionSaldosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, usuarioModificador, timestampModificador);
    }
    @Override
    @Transactional
    public int reversarRegistroSaldo(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_REVERSADO;
        return rectificacionSaldosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, usuarioModificador, timestampModificador);
    }



    @Override
    @Transactional(readOnly = true)
    public List<RectificacionMovimientosNoInformadoDto> listaRectificacionesMovimientosPendientes() {
        return rectificacionMovimientosNoInformadoMapper.toDto(rectificacionMovimientosNoInformadoDao.findByIdEstadoAndOptionalProcessDate(ETDO_PENDIENTE, null));
    }
    @Override
    @Transactional(readOnly = true)
    public List<RectificacionMovimientosNoInformadoDto> listaRectificacionesMovimientosAprobadas(String optionalProcessDate) {
        return rectificacionMovimientosNoInformadoMapper.toDto(rectificacionMovimientosNoInformadoDao.findByIdEstadoAndOptionalProcessDate(ETDO_APROBADO, optionalProcessDate));
    }
    @Override
    @Transactional(readOnly = true)
    public List<RectificacionMovimientosNoInformadoDto> listaRectificacionesMovimientosRechazadas() {
        return rectificacionMovimientosNoInformadoMapper.toDto(rectificacionMovimientosNoInformadoDao.findByIdEstadoAndOptionalProcessDate(ETDO_RECHAZADO, null));
    }
    @Override
    @Transactional
    public int aprobacionMasivaMovimientos(String usuarioModificador) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_APROBADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionMovimientosNoInformadoDao.updateEstadoRectificacionByIdQuery(nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    @Override
    @Transactional
    public int aprobacionPorIdMovimiento(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_APROBADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionMovimientosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    @Override
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
    @Override
    @Transactional
    public int rechazoMasivaMovimientos(String usuarioModificador) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_RECHAZADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionMovimientosNoInformadoDao.updateEstadoRectificacionByIdQuery(nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    @Override
    @Transactional
    public int rechazoPorIdMovimiento(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_RECHAZADO;
        Integer antiguoEstado           = ETDO_PENDIENTE;
        return rectificacionMovimientosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, antiguoEstado, usuarioModificador, timestampModificador);
    }
    @Override
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
    @Override
    @Transactional
    public int anularRegistroMovimiento(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_ANULADO;
        return rectificacionMovimientosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, usuarioModificador, timestampModificador);
    }
    @Override
    @Transactional
    public int reversarRegistroMovimiento(String usuarioModificador, Long idRectificacion) {
        Instant timestampModificador    = Instant.now();
        Integer nuevoEstado             = ETDO_REVERSADO;
        return rectificacionMovimientosNoInformadoDao.updateEstadoRectificacionByIdQuery(idRectificacion, nuevoEstado, usuarioModificador, timestampModificador);
    }




}
