package cl.qande.mmii.app;

import cl.qande.mmii.app.interceptors.ApiHeadersInterceptor;
import cl.qande.mmii.app.interceptors.CustomInterceptor;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import java.util.concurrent.TimeUnit;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    protected static final String ACCESS_PLUS_1_YEAR = "access plus 1 year";
    private final CustomInterceptor customInterceptor;
    private final ApiHeadersInterceptor apiHeadersInterceptor;

    @Autowired
    public MvcConfig(CustomInterceptor customInterceptor, ApiHeadersInterceptor apiHeadersInterceptor) {
        this.customInterceptor = customInterceptor;
        this.apiHeadersInterceptor = apiHeadersInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor);
        registry.addInterceptor(apiHeadersInterceptor).addPathPatterns("/api/**");
        registry.addInterceptor(apiHeadersInterceptor).addPathPatterns("/api-internal/**");
    }
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/error_403").setViewName("errores/error_403");
    }
    @Bean
    public FilterRegistrationBean<ExpiresFilter> expiresFilter() {
        FilterRegistrationBean<ExpiresFilter> registrationBean = new FilterRegistrationBean<>();
        ExpiresFilter expiresFilter = new ExpiresFilter();

        registrationBean.setFilter(expiresFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("ExpiresByType text/css", ACCESS_PLUS_1_YEAR);
        registrationBean.addInitParameter("ExpiresByType application/javascript", ACCESS_PLUS_1_YEAR);
        registrationBean.addInitParameter("ExpiresByType image/jpeg", ACCESS_PLUS_1_YEAR);
        return registrationBean;
    }


    // Configuración para el versionado de recursos estáticos
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //Rutas estarían mal definidas
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(31556926) // 1 año en segundos
                .resourceChain(true)
                .addResolver(new VersionResourceResolver()
                        .addContentVersionStrategy("/**")); // Agrega un hash basado en el contenido

        customRegistryCache(registry, "build");
        customRegistryCache(registry, "dist");
        customRegistryCache(registry, "plugins");
        customRegistryCache(registry, "syncfusion.v26.1.35");
    }

    private void customRegistryCache(ResourceHandlerRegistry registry, String baseFolder) {
        registry.addResourceHandler("/"+baseFolder+"/**") //cómo se exponen los recursos en la URL
                .addResourceLocations("classpath:/static/"+baseFolder+"/")    //define la ubicación de los recursos en el sistema de archivos del proyecto
                .setCacheControl(CacheControl.maxAge(30, TimeUnit.DAYS));
    }

}
