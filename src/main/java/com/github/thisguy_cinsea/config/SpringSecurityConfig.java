package com.github.thisguy_cinsea.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource ds() {
        return DataSourceBuilder.create().build();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.httpBasic()
                .and()
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/user/**").hasRole("ADMIN")
                .antMatchers("/api/v2/user/*").permitAll()
//                .antMatchers("/api/v2/user").hasRole("**")
                .anyRequest().authenticated();
    }

    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new CustomBasicAuthenticationEntryPoint();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        System.out.println("springSec.configureGlobal");
        auth.jdbcAuthentication().dataSource(dataSource)
                .authoritiesByUsernameQuery("SELECT `email`, `role` from `register_user_tbl` where `email`=?")
                .usersByUsernameQuery("SELECT `email`, `password`, 1 as enabled from `register_user_tbl` where `email`=?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        System.out.println("password encoder");
        return new BCryptPasswordEncoder();
    }
}
