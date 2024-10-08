package cl.qande.mmii.app;

import cl.qande.mmii.app.interceptors.CustomInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private final CustomInterceptor customInterceptor;

    @Autowired
    public MvcConfig(CustomInterceptor customInterceptor) {
        this.customInterceptor = customInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor);
    }
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/error_403").setViewName("errores/error_403");
}
}
