package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.core.entity.Parametro;

import java.util.List;

public interface IParametroCoreService {

    String valorParametroCore(String idParametro, String subIdParametro);
    List<Parametro> listaParametroCore(String idParametro);
    Parametro parametroCore(String idParametro, String subIdParametro);
}
