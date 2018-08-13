package tr.edu.itu.cavabunga.server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import tr.edu.itu.cavabunga.server.auth.CavabungaUserAuthenticationProvider;
import tr.edu.itu.cavabunga.server.auth.CavabungaClientAuthenticationProvider;


@Configuration
@EnableWebMvcSecurity
@ComponentScan("tr.edu.itu.cavabunga.server.configuration")
public class AuthenticationConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CavabungaUserAuthenticationProvider cavabungaUserAuthenticationProvider;

    @Autowired
    private CavabungaAuthenticationConfiguration cavabungaAuthenticationConfiguration;

    @Autowired
    private CavabungaClientAuthenticationProvider cavabungaClientAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity httpSecuriy) throws Exception{

        httpSecuriy.authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilterBefore(cavabungaClientAuthenticationProvider, BasicAuthenticationFilter.class)
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.authenticationProvider(cavabungaUserAuthenticationProvider);
    }
}
