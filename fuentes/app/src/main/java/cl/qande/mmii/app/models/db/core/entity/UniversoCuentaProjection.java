package cl.qande.mmii.app.models.db.core.entity;

public interface UniversoCuentaProjection {
    String getParent();
    String getId();
    String getValue();
    String getGrouper();

    default String getProjectionAsString() {
        return "UniversoCuentaProjection{" +
                "parent='" + getParent() + '\'' +
                "id='" + getId() + '\'' +
                ", value='" + getValue() + '\'' +
                ", grouper='" + getGrouper() + '\'' +
                '}';
    }
}