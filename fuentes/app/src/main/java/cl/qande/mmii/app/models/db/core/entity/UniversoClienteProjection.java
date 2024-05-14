package cl.qande.mmii.app.models.db.core.entity;

public interface UniversoClienteProjection {
    String getId();
    String getValue();
    String getGrouper();

    default String getProjectionAsString() {
        return "UniversoClienteProjection{" +
                "id='" + getId() + '\'' +
                ", value='" + getValue() + '\'' +
                ", grouper='" + getGrouper() + '\'' +
                '}';
    }
}