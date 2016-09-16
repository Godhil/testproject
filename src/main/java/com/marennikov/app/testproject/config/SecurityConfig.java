package com.marennikov.app.testproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .withDefaultSchema()
//                .withUser("user").password("password").roles("OPERATOR").and()
//                .withUser("admin").password("password").roles("USER", "ADMIN");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/css/**", "/founts/**", "/js/**", "/", "/login").permitAll()

                    .antMatchers(
                            "/requests",
                            "/place/**",
                            "/construction/**",
                            "/new/**", "/send/**", "/edit/**"
                            ).hasAnyRole("OPERATOR", "ADMIN")
                    .antMatchers("/approved", "/approve").hasAnyRole("OPERATOR", "REDACTOR", "ADMIN")
                    .antMatchers("/view/**", "/approval").hasAnyRole("REDACTOR", "ADMIN")
                    .antMatchers("/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/j_spring_security_check")
                    .usernameParameter("j_username")
                    .passwordParameter("j_password")
                    .permitAll()
                    .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("redactor").password("1234").roles("REDACTOR").and()
                .withUser("operator").password("1234").roles("OPERATOR").and()
                .withUser("admin").password("1234").roles("ADMIN");
    }
}

