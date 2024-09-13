package cl.qande.mmii.app;

import cl.qande.mmii.app.auth.handler.LoginSuccessHandler;
import cl.qande.mmii.app.models.service.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Necesario para usar anotaciones en controladores @Secured y @PreAuthorize
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    private static final String API_PATH = "/api/**";
    private static final String LOG_PATH = "/logs/**";
    private static final String SYNCFUSION_PATH = "/syncfusion.v26.1.35/**";
    private static final String ROL_ADMIN = "ADMIN";
    private static final String ROL_USER = "USER";
    private final JpaUserDetailsService userDetailsService;

    private final BCryptPasswordEncoder passwordEncoder;

    private final LoginSuccessHandler successHandler;

    @Autowired
    public SpringSecurityConfig(JpaUserDetailsService userDetailsService, BCryptPasswordEncoder passwordEncoder, LoginSuccessHandler successHandler) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.successHandler = successHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.csrf().disable()
                .csrf().ignoringAntMatchers(API_PATH,LOG_PATH)
                .and()
                .authorizeRequests()
                .antMatchers("/test/**","/build/**", "/custom/**", "/dist/**", "/plugins/**",API_PATH, SYNCFUSION_PATH).permitAll()
                .antMatchers(HttpMethod.GET,API_PATH).permitAll()
                .antMatchers(HttpMethod.POST,API_PATH).permitAll()
                .antMatchers(HttpMethod.DELETE,API_PATH).permitAll()
                .antMatchers(HttpMethod.POST,LOG_PATH).hasAnyRole(ROL_ADMIN, ROL_USER)
                .antMatchers("/errores/**").hasAnyRole(ROL_ADMIN, ROL_USER)
                .antMatchers("/mantenedores/parametros_instrumentos/**").hasAnyRole(ROL_ADMIN, ROL_USER)
                .antMatchers("/uploads/**").hasAnyRole(ROL_USER)
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                .successHandler(successHandler)
                    .loginPage("/login")
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error_403");
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {

        //Usuarios en BD
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);

    }
}