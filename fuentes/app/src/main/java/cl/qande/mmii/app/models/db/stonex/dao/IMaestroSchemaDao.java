package cl.qande.mmii.app.models.db.stonex.dao;

import cl.qande.mmii.app.models.db.stonex.entity.MaestroSchema;
import org.springframework.data.repository.CrudRepository;

public interface IMaestroSchemaDao extends CrudRepository<MaestroSchema, String> {

    public MaestroSchema findByFilename(String filename);
}
