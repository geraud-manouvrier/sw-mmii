package cl.qande.mmii.app.interceptors;

import cl.qande.mmii.app.models.api.ApiResponse;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.ApiHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class ApiHeadersInterceptor implements HandlerInterceptor {

    private static final HttpStatus HTTP_STATUS_HEADER_ERROR    = HttpStatus.BAD_REQUEST;

    private final ApiHelper apiHelper;

    @Autowired
    public ApiHeadersInterceptor(ApiHelper apiHelper) {
        this.apiHelper = apiHelper;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String headerValueForClientId   = request.getHeader(ApiHelper.HEADER_CLIENT_ID);
        String headerValueForApiKey     = request.getHeader(ApiHelper.HEADER_API_KEY);
        String urlConsultada            = request.getRequestURI();
        CustomLog.getInstance().info("URL API consultada: " + urlConsultada);
        if (headerValueForClientId == null || headerValueForApiKey == null) {
            setHeaderErrorResponde(response, "No vienen headers de api-key");
            return false;
        } else {
            try {
                apiHelper.validateApiKey(headerValueForApiKey, headerValueForClientId, ApiHelper.ID_API_STATUS);
            } catch (QandeMmiiException qandeMmiiException) {
                setHeaderErrorResponde(response, "Api-key - ClientID incorrecto");
                return false;
            }
        }
        return true;
    }

    private void setHeaderErrorResponde(HttpServletResponse response, String mensaje) throws IOException {
        CustomLog.getInstance().error("Error en método REST ["+response+"], retornando error: "+HTTP_STATUS_HEADER_ERROR);
        var apiResponse= new ApiResponse(1, "Error al validar llamada: "+mensaje);

        response.setHeader(ApiHelper.HEADER_JSON_KEY, ApiHelper.HEADER_JSON_VAL);
        response.setStatus(HTTP_STATUS_HEADER_ERROR.value());

        PrintWriter errorWriter = response.getWriter();

        ObjectMapper objectMapper = new ObjectMapper();
        errorWriter.println(objectMapper.writeValueAsString(apiResponse));

    }

}
