package com.github.thisguy_cinsea.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/user/**").hasRole("ADMIN")
                .antMatchers("/registered/*").permitAll()
                .antMatchers("/chore/*").permitAll()
                .antMatchers("/group/*").permitAll()
                .antMatchers("/note/*").permitAll()
//                .antMatchers("/api/v2/user").hasRole("**")
                .anyRequest().authenticated();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        System.out.println("springSec.configureGlobal");
        auth.jdbcAuthentication().dataSource(dataSource)
                .authoritiesByUsernameQuery("SELECT `email`, `role` from `reg_user_tbl` where `email`=?")
                .usersByUsernameQuery("SELECT `email`, `password`, 1 as enabled from `reg_user_tbl` where `email`=?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//encoder.matches(password,user.getPassword());
//    password -
//
//    from form(JSP)
//        user.getPassword()-
//    from database
//
//    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        if(email.equalsIgnoreCase(user.getEmail())&&encoder.matches(password,user.getPassword()))
//
//    {
//        userService.deactivateUserByID(user.getId());
//        redirectAttributes.addFlashAttribute("successmsg", "Your account has been deactivated successfully.");
//        model.setViewName("redirect:/logout");
//    }else
//
//    {
//        redirectAttributes.addFlashAttribute("errormsg", "Email or Password is incorrect");
//        model.setViewName("redirect:/app/profile/deactivate");
//    }
}