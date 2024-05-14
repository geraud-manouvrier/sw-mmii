package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.core.entity.ParPaisAtencion;
import cl.qande.mmii.app.models.db.sura.entity.*;

import java.util.List;

public interface IEnrolamientoClienteParService {
    List<TipoCuenta> listTipoCuenta();

    TipoCuenta tipoCuentaById(String id);

    List<TipoServicio> listTipoServicio();

    TipoServicio tipoServicioById(String id);

    List<ModeloAsesoria> listModeloAsesoria();

    ModeloAsesoria modeloAsesoriaById(String id);

    List<Perfil> listPerfil();

    Perfil perfilById(String id);

    List<Custodio> listCustodio();

    Custodio custodioById(String id);

    boolean existPaisAtencion(Integer codPaisAtencion);

    List<ParPaisAtencion> listaPaisAtencion();

    ParPaisAtencion paisAtencionById(Integer codPaisAtencion);

    List<ParPaisAtencion> listaPaisResidencia();
}
