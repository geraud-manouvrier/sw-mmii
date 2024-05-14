package cl.qande.mmii.app.controllers.mantenedores;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@RequestMapping("/mantenedores/enrolamiento")
public class MantenedorEnrolamientoController {




}
