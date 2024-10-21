package cl.qande.mmii.app.interceptors;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class CustomInterceptor implements HandlerInterceptor {

    private final AppConfig appConfig;
    private final SesionWeb sesionWeb;
    private static final String ATTR_STATUS = "status";
    private static final String ATTR_SESION = "sesionWeb";
    private static final String ATTR_TITTLE = "titulo";

    @Autowired
    public CustomInterceptor(AppConfig appConfig, SesionWeb sesionWeb) {
        this.appConfig = appConfig;
        this.sesionWeb = sesionWeb;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Class<?> controllerClass = method.getDeclaringClass();
            if (modelAndView!=null && controllerClass.isAnnotationPresent(RequestMapping.class)) {
                this.auxSetStatus(modelAndView.getModelMap());
            }
        }
        if (modelAndView!=null) {
            String viewName = modelAndView.getViewName();
            if (viewName != null) {
                if (!viewName.startsWith("redirect:")) {
                    modelAndView.getModelMap().addAttribute("projectVersion", appConfig.appConfigProperties.getProjectVersion());
                    var tituloPagina=modelAndView.getModelMap().getAttribute(ATTR_TITTLE);
                    if (tituloPagina==null) {
                        tituloPagina="";
                    }
                    sesionWeb.addNotification("Página "+tituloPagina+" cargada correctamente");
                    modelAndView.getModelMap().addAttribute("notifications", sesionWeb.getNotifications());
                }
                this.auxSetOnError(modelAndView.getModelMap(), viewName);
            }
        }
    }
    private ModelMap auxSetOnError(ModelMap modelMap, String viewName) {
        if (viewName.startsWith("errores/error_403")) {
            CustomLog.getInstance().error("Error de acceso denegado para usuario: [" + sesionWeb.getUsuario() + "] Roles: [" + sesionWeb.listaDeRoles().toString() + "]");
            modelMap.addAttribute(ATTR_SESION, sesionWeb);
            modelMap.addAttribute(ATTR_TITTLE, "Acceso denegado");
        }
        return modelMap;
    }
    private ModelMap auxSetStatus(ModelMap modelMap) {
        if (modelMap.getAttribute(ATTR_STATUS)==null) {
            modelMap.addAttribute(ATTR_STATUS, new EstadoPeticion(0, "Página cargada", "Proceso terminado correctamente."));
        }
        return modelMap;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Class<?> controllerClass = method.getDeclaringClass();

            if (controllerClass.isAnnotationPresent(RequestMapping.class)) {
                CustomLog.getInstance().info("Intercepted request to controller for user: ["+sesionWeb.getUsuario()+"] to RequestURI: ["+request.getRequestURI()+"]-["+request.getMethod()+"]");
                sesionWeb.clearNotifications();
            }
        }
        return true;
    }

}
