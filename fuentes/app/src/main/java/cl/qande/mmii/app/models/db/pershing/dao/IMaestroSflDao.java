package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.MaestroSfl;
import org.springframework.data.repository.CrudRepository;

public interface IMaestroSflDao extends CrudRepository<MaestroSfl, String> {

    public MaestroSfl findByFilename(String filename);
}