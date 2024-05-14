package cl.qande.mmii.app.util.helper;

import cl.qande.mmii.app.models.exception.QandeMmiiException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static cl.qande.mmii.app.MvcConfig.passwordEncoder;

@Component
public class UsuariosHelper {

    private static final int LARGO_CLAVE_MINIMO  = 10;

    public String generaEncodedPassword(String plainPassword) throws QandeMmiiException {
        PasswordEncoder encoder = passwordEncoder();
        var validacion  =validaClave(plainPassword);
        if(validacion.isEmpty()) {
            return encoder.encode(plainPassword);
        }
        throw new QandeMmiiException("Error con la nueva: "+validacion);
    }
    public List<String> validaClave(String clave) {
        List<String> validacion  = new ArrayList<>();
        if (! this.claveTieneLargo(clave)) {
            validacion.add("Clave no cumple largo mínimo ("+LARGO_CLAVE_MINIMO+").");
        }
        if (! this.claveTieneMayuscula(clave)) {
            validacion.add("Clave debe tener al menos una mayúscula.");
        }
        if (! this.claveTieneMinuscula(clave)) {
            validacion.add("Clave debe tener al menos una minúscula.");
        }
        if (! this.claveTieneDigito(clave)) {
            validacion.add("Clave debe tener al menos un número.");
        }
        if (! this.claveTieneSimbolo(clave)) {
            validacion.add("Clave debe tener al menos una caracter especial.");
        }
        return validacion;
    }

    private boolean claveTieneLargo(String clave) {
        return (clave.length()>=LARGO_CLAVE_MINIMO);
    }
    private boolean claveTieneMayuscula(String clave) {
        return clave.matches(".*[A-Z].*");
    }
    private boolean claveTieneMinuscula(String clave) {
        return clave.matches(".*[a-z].*");
    }
    private boolean claveTieneDigito(String clave) {
        return clave.matches(".*[\\d].*");
    }
    private boolean claveTieneSimbolo(String clave) {
        return ( clave.matches(".*[\\W].*") || clave.matches(".*[_].*") );
    }
}
