package cl.qande.mmii.app.models.api;
import java.util.ArrayList;
import java.util.List;
public class ClientesRequest {

    public ClientesRequest() {
        this.clientes = new ArrayList<>();
    }

    private List<Cliente> clientes;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "clientes=" + clientes +
                '}';
    }
}
