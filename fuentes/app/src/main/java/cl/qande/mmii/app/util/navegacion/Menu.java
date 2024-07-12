package cl.qande.mmii.app.util.navegacion;

import cl.qande.mmii.app.models.exception.QandeMmiiException;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public static final String URL_INICIO ="/home";
    public static final String ERROR_GENERICO ="errores/error_controlado";
    //Admin Q&E
    public static final String ADMINQANDE_LOGS ="ADMINQANDE_LOGS";
    public static final String ADMIN_JOBS ="ADMIN_JOBS";
    //FTP
    public static final String LS_FTP_PERSHING ="LS_FTP_PERSHING";
    //Pershing
    public static final String PERSHING_CONFIGSFL ="PERSHING_CONFIGSFL";
    public static final String PERSHING_ETDO_FTP ="PERSHING_ETDO_FTP";
    //Parámetros
    public static final String PARAMETROS_GLOBALES ="PARAMETROS_GLOBALES";
    public static final String PARAMETROS_PERSHING ="PARAMETROS_PERSHING";
    //Usuarios
    public static final String USUARIOS_CUENTAS   ="USUARIOS_CUENTAS";
    public static final String USUARIOS_ROLES   ="USUARIOS_ROLES";
    //Archivos
    public static final String ARCHIVOS_MAESTROS   ="ARCHIVOS_MAESTROS";
    //Reportes Maestros
    public static final String REP_MAESTRO_CLIENTE   ="REP_MAESTRO_CLIENTE";
    public static final String REP_MAESTRO_SALDOS   ="REP_MAESTRO_SALDOS";
    public static final String REP_MAESTRO_MOVTOS   ="REP_MAESTRO_MOVTOS";
    //Mantenedores Instrumentos
    public static final String MANT_SRC_COD_PER ="MANT_SRC_COD_PER";
    //Control de operaciones
    public static final String CTRL_OPER_DIARIO   ="CTRL_OPER_DIARIO";
    //Reportes SFL
    public static final String CONT_SFL_ACCT   ="CONT_SFL_ACCT";
    public static final String CONT_SFL_GACT   ="CONT_SFL_GACT";
    public static final String CONT_SFL_GCUS   ="CONT_SFL_GCUS";
    public static final String CONT_SFL_GMON   ="CONT_SFL_GMON";
    public static final String CONT_SFL_ISCA   ="CONT_SFL_ISCA";
    public static final String CONT_SFL_ISRC   ="CONT_SFL_ISRC";
    //Rectificaciones
    public static final String RECT_NO_INF   ="RECT_NO_INF";
    public static final String RECT_NO_INF_APR   ="RECT_NO_INF_APR";
    public static final String RECT_NO_INF_REVER ="RECT_NO_INF_REVER";
    //Enrolamiento
    public static final String MANT_ENROL_CLIENTE ="MANT_ENROL_CLIENTE";
    public static final String MANT_FEE_SEGMENTO ="MANT_FEE_SEGMENTO";


    public static final String ROLE_ADMIN  = "ROLE_ADMIN";      //Máximos privilegios, admin del sistema
    public static final String ROLE_SUPER  = "ROLE_SUPER";      //Usuario con permisos mayores al básico (no admin sistema)
    public static final String ROLE_USER  = "ROLE_USER";        //Usuario básico
    public static final String ROLE_BASIC  = "ROLE_BASIC";        //Usuario básico
    public static final String ROLE_READER  = "ROLE_READER";    //Usuario que sólo lee/ve info

    private static final String ICON_CLASS_FILE = "nav-icon fas fa-file-alt";
    private static final String ICON_CLASS_ENGRANAJE = "nav-icon fas fa-cog";

    private String opcionElegida;
    private String opcionPorDefecto;

    private ArrayList<CategoriaMenu> opcionesMenu;

    public Menu() {

        ArrayList<String> perfilTodos = new ArrayList<>();
        perfilTodos.add(ROLE_ADMIN);
        perfilTodos.add(ROLE_SUPER);
        perfilTodos.add(ROLE_USER);
        perfilTodos.add(ROLE_READER);
        perfilTodos.add(ROLE_BASIC);
        ArrayList<String> perfilAdminQye = new ArrayList<>();
        perfilAdminQye.add(ROLE_ADMIN);
        ArrayList<String> perfilUsuario = new ArrayList<>();
        perfilUsuario.add(ROLE_ADMIN);
        perfilUsuario.add(ROLE_SUPER);
        perfilUsuario.add(ROLE_USER);
        ArrayList<String> perfilUsuarioLimitado = new ArrayList<>();
        perfilUsuarioLimitado.add(ROLE_ADMIN);
        perfilUsuarioLimitado.add(ROLE_SUPER);
        perfilUsuarioLimitado.add(ROLE_USER);
        perfilUsuarioLimitado.add(ROLE_BASIC);
        ArrayList<String> perfilSupervisor = new ArrayList<>();
        perfilSupervisor.add(ROLE_SUPER);
        perfilSupervisor.add(ROLE_ADMIN);

        var categoriaAdminQande    = new CategoriaMenu("ADMINQANDE", "Administración", false, "nav-icon fas fa-home");
        categoriaAdminQande.setListaRoles(perfilAdminQye);
        var categoriaFtp    = new CategoriaMenu("FTP", "FTP", false, "nav-icon fas fa-envelope-open-text");
        categoriaFtp.setListaRoles(perfilAdminQye);
        var categoriaPershing    = new CategoriaMenu("PERSHING", "Pershing", false, "nav-icon fas fa-copy");
        categoriaPershing.setListaRoles(perfilAdminQye);
        var categoriaParametros    = new CategoriaMenu("PARAMETROS", "Parámetros", false, ICON_CLASS_ENGRANAJE);
        categoriaParametros.setListaRoles(perfilAdminQye);
        var categoriaUsuarios    = new CategoriaMenu("USUARIOS", "Usuarios", false, "nav-icon fas fa-users");
        categoriaUsuarios.setListaRoles(perfilAdminQye);
        var categoriaArchivos    = new CategoriaMenu("ARCHIVOS", "Archivos", false, "nav-icon fas fa-file-excel");
        categoriaArchivos.setListaRoles(perfilTodos);
        var categoriaReportesMaestros    = new CategoriaMenu("REPORTES_MAESTROS", "Reportes Maestro Datos", false, "nav-icon fab fa-searchengin");
        categoriaReportesMaestros.setListaRoles(perfilTodos);
        var categoriaMantenedoresInstrumentos    = new CategoriaMenu("MANTENEDORES_INSTRUMENTOS", "Mantenedores", false, ICON_CLASS_ENGRANAJE);
        categoriaMantenedoresInstrumentos.setListaRoles(perfilAdminQye);
        var categoriaControlOperaciones    = new CategoriaMenu("CONTROL_OPERACIONES", "Control Operaciones", false, "nav-icon fas fa-tasks");
        categoriaControlOperaciones.setListaRoles(perfilAdminQye);
        var categoriaReportesSfl    = new CategoriaMenu("CONTENIDO_SFL", "Data SFL", false, ICON_CLASS_FILE);
        categoriaReportesSfl.setListaRoles(perfilAdminQye);
        var categoriaMantenedoresEnrolamiento    = new CategoriaMenu("MANTENEDORES_ENROL", "Mantenedores Enrolamiento", false, ICON_CLASS_ENGRANAJE);
        categoriaMantenedoresEnrolamiento.setListaRoles(perfilTodos);
        var categoriaRegistroRectificaciones    = new CategoriaMenu("REGISTRO_RECT", "Registro Rectificaciones", false, "nav-icon fas fa-edit");
        categoriaRegistroRectificaciones.setListaRoles(perfilAdminQye);
        var categoriaAprobacionRectificaciones    = new CategoriaMenu("APRUEBA_RECT", "Aprobación Rectificaciones", false, "nav-icon fas fa-pen-alt");
        categoriaAprobacionRectificaciones.setListaRoles(perfilAdminQye);
        var categoriaProcesosPorUsuario    = new CategoriaMenu("ADMIN_BY_USER", "Procesos", false, ICON_CLASS_FILE);
        categoriaProcesosPorUsuario.setListaRoles(perfilAdminQye);
        var categoriaMantenedoresParametros    = new CategoriaMenu("MANTENEDORES_PARAM", "Mantenedores Parámetros", false, ICON_CLASS_ENGRANAJE);
        categoriaMantenedoresParametros.setListaRoles(perfilAdminQye);


        ArrayList<OpcionMenu> opcionesInicio    = new ArrayList<>();
        opcionesInicio.add(new OpcionMenu(ADMINQANDE_LOGS, "Logs App", "/logs", false));
        opcionesInicio.add(new OpcionMenu(ADMIN_JOBS, "Ejecutar Jobs", "/jobs", false));
        categoriaAdminQande.setListaOpciones(opcionesInicio);

        ArrayList<OpcionMenu> opcionesFtp    = new ArrayList<>();
        opcionesFtp.add(new OpcionMenu(LS_FTP_PERSHING, "Listar FTP Pershing", "/ftp_externo/pershing/listar", false));
        categoriaFtp.setListaOpciones(opcionesFtp);

        ArrayList<OpcionMenu> opcionesPershing    = new ArrayList<>();
        opcionesPershing.add(new OpcionMenu(PERSHING_CONFIGSFL, "Config SFL", URL_INICIO, false));
        opcionesPershing.add(new OpcionMenu(PERSHING_ETDO_FTP, "Estado Proceso Pershing", "/jobs/reportes/proceso_ftp_pershing", false));
        categoriaPershing.setListaOpciones(opcionesPershing);

        ArrayList<OpcionMenu> opcionesParametros    = new ArrayList<>();
        opcionesParametros.add(new OpcionMenu(PARAMETROS_GLOBALES, "Parámetros Globales", URL_INICIO, false));
        opcionesParametros.add(new OpcionMenu(PARAMETROS_PERSHING, "Parámetros Pershing", URL_INICIO, false));
        categoriaParametros.setListaOpciones(opcionesParametros);

        ArrayList<OpcionMenu> opcionesUsuarios    = new ArrayList<>();
        opcionesUsuarios.add(new OpcionMenu(USUARIOS_CUENTAS, "Cuentas de usuario", "/usuarios/admin_users", false));
        opcionesUsuarios.add(new OpcionMenu(USUARIOS_ROLES, "Roles de usuario", URL_INICIO, false));
        categoriaUsuarios.setListaOpciones(opcionesUsuarios);

        ArrayList<OpcionMenu> opcionesArchivos    = new ArrayList<>();
        opcionesArchivos.add(new OpcionMenu(ARCHIVOS_MAESTROS, "Maestro de Datos", "/archivos/maestro_datos/listar", false));
        categoriaArchivos.setListaOpciones(opcionesArchivos);

        ArrayList<OpcionMenu> opcionesReportesMaestros    = new ArrayList<>();
        opcionesReportesMaestros.add(new OpcionMenu(REP_MAESTRO_CLIENTE, "Maestro de Cuentas", "/reportes/maestro_datos/clientes", false));
        opcionesReportesMaestros.add(new OpcionMenu(REP_MAESTRO_SALDOS, "Maestro de Saldos", "/reportes/maestro_datos/saldos", false));
        opcionesReportesMaestros.add(new OpcionMenu(REP_MAESTRO_MOVTOS, "Maestro Movimientos", "/reportes/maestro_datos/movimientos", false));
        categoriaReportesMaestros.setListaOpciones(opcionesReportesMaestros);

        ArrayList<OpcionMenu> opcionesMantenedoresInstrumentos    = new ArrayList<>();
        opcionesMantenedoresInstrumentos.add(new OpcionMenu(MANT_SRC_COD_PER, "Source Code Pershing", "/mantenedores/parametros_instrumentos/source_code_pershing/crear", false));
        categoriaMantenedoresInstrumentos.setListaOpciones(opcionesMantenedoresInstrumentos);

        ArrayList<OpcionMenu> opcionesControlOperaciones    = new ArrayList<>();
        opcionesControlOperaciones.add(new OpcionMenu(CTRL_OPER_DIARIO, "Control diario", "/reportes/controles/control_diario", false));
        categoriaControlOperaciones.setListaOpciones(opcionesControlOperaciones);

        ArrayList<OpcionMenu> opcionesReportesSfl    = new ArrayList<>();
        opcionesReportesSfl.add(new OpcionMenu(CONT_SFL_ACCT, "ACCT", "/reportes/sfl_pershing/acct", false));
        opcionesReportesSfl.add(new OpcionMenu(CONT_SFL_GACT, "GACT", "/reportes/sfl_pershing/gact", false));
        opcionesReportesSfl.add(new OpcionMenu(CONT_SFL_GCUS, "GCUS", "/reportes/sfl_pershing/gcus", false));
        opcionesReportesSfl.add(new OpcionMenu(CONT_SFL_GMON, "GMON", "/reportes/sfl_pershing/gmon", false));
        opcionesReportesSfl.add(new OpcionMenu(CONT_SFL_ISRC, "ISRC", "/reportes/sfl_pershing/isrc", false));
        opcionesReportesSfl.add(new OpcionMenu(CONT_SFL_ISCA, "ISCA", "/reportes/sfl_pershing/isca", false));
        categoriaReportesSfl.setListaOpciones(opcionesReportesSfl);

        ArrayList<OpcionMenu> opcionesMantenedoresEnrolamiento    = new ArrayList<>();
        opcionesMantenedoresEnrolamiento.add(new OpcionMenu(MANT_ENROL_CLIENTE, "Clientes", "/mantenedores/enrolamiento/cliente", false));
        categoriaMantenedoresEnrolamiento.setListaOpciones(opcionesMantenedoresEnrolamiento);

        ArrayList<OpcionMenu> opcionesRegistroRectificacion    = new ArrayList<>();
        opcionesRegistroRectificacion.add(new OpcionMenu(RECT_NO_INF, "Registros No Informados", "/rectificacion/registros_no_informados/nuevo", false));
        categoriaRegistroRectificaciones.setListaOpciones(opcionesRegistroRectificacion);

        ArrayList<OpcionMenu> opcionesAprobacionRectificacion    = new ArrayList<>();
        opcionesAprobacionRectificacion.add(new OpcionMenu(RECT_NO_INF_APR, "Aprobación o rechazo", "/rectificacion/registros_no_informados/aprobacion", false));
        opcionesAprobacionRectificacion.add(new OpcionMenu(RECT_NO_INF_REVER, "Reversa Registros", "/rectificacion/registros_no_informados/reversa", false));
        categoriaAprobacionRectificaciones.setListaOpciones(opcionesAprobacionRectificacion);

        ArrayList<OpcionMenu> opcionesMantenedoresParametros    = new ArrayList<>();
        opcionesMantenedoresParametros.add(new OpcionMenu(MANT_FEE_SEGMENTO, "Fee Segmentos", "/mantenedores/parametros/fee_segmento", false));
        categoriaMantenedoresParametros.setListaOpciones(opcionesMantenedoresParametros);

        opcionesMenu    = new ArrayList<>();
        opcionesMenu.add(categoriaAdminQande);
        opcionesMenu.add(categoriaFtp);
        opcionesMenu.add(categoriaPershing);
        opcionesMenu.add(categoriaParametros);
        opcionesMenu.add(categoriaUsuarios);
        opcionesMenu.add(categoriaArchivos);
        opcionesMenu.add(categoriaReportesMaestros);
        opcionesMenu.add(categoriaControlOperaciones);
        opcionesMenu.add(categoriaReportesSfl);
        opcionesMenu.add(categoriaMantenedoresEnrolamiento);
        opcionesMenu.add(categoriaRegistroRectificaciones);
        opcionesMenu.add(categoriaAprobacionRectificaciones);
        opcionesMenu.add(categoriaMantenedoresParametros);

        this.opcionPorDefecto   = ADMINQANDE_LOGS;
        this.opcionElegida      = this.opcionPorDefecto;
    }

    public String cambiaNavegacion(String nuevaOpcion, boolean flagRedirect) throws QandeMmiiException {
        var rutaUrl  = "";
        for (CategoriaMenu categoriaActual : this.listaOpciones()) {
            categoriaActual.setActivo(false);
            categoriaActual.desativaOpciones();

            if(rutaUrl.equals("")) {
                rutaUrl = categoriaActual.getUrlPorClave(nuevaOpcion, true);
                if (!rutaUrl.equals("")) {
                    categoriaActual.setActivo(true);
                }
            }
        }
        if (nuevaOpcion.equals(ERROR_GENERICO)) {
            rutaUrl = nuevaOpcion;
        }
        if(flagRedirect) {
            rutaUrl = "redirect:"+rutaUrl;
        }
        return rutaUrl;
    }

    public List<String> getBreadcrumb() {
        var breadcrumb = new ArrayList<String>();
        breadcrumb.add("Inicio");
        for (CategoriaMenu categoriaActual : this.listaOpciones()) {
            if (categoriaActual.isActivo()) {
                breadcrumb.add(categoriaActual.getTexto());
                for (OpcionMenu opcionActual : categoriaActual.getListaOpciones()) {
                    if (opcionActual.getActivo()) {
                        try {
                            breadcrumb.add(opcionActual.getTexto());
                        } catch (QandeMmiiException e) {
                            breadcrumb.add(".");
                        }
                    }
                }
            }
        }

        return breadcrumb;
    }
    public List<CategoriaMenu> listaOpciones() {
        return this.opcionesMenu;
    }

    public String estadoActivo(String opcion){
        if(opcion.equals(this.opcionElegida)) {
            return "active";
        } else {
            return "";
        }
    }
    public static String roleOp(String clave){
        return "ROLE_OP_"+clave.toUpperCase();
    }
}
