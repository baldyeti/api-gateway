package io.ibex.apigateway.configs;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.stereotype.Component;

@EnableResourceServer
@Component
public class JwtSecurityConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("**/swagger-resources").permitAll()
                .antMatchers("/swagger-resources").permitAll()
                .antMatchers("swagger-resources/**").permitAll()
                .antMatchers("/**/api-docs").permitAll()
                .antMatchers("/**/actuator/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/**").hasAuthority("ROLE_DEVELOPER")
                .and()
                .csrf().disable();
    }
}
