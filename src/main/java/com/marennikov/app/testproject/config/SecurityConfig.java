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
//      //Настройки для авторизации через бд
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select * from user where login=?")
//                .authoritiesByUsernameQuery("select role from user where login=?");
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
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                .   and()
                .csrf().disable()
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

