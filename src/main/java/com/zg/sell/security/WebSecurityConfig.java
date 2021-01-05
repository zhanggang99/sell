package com.zg.sell.security;

import com.zg.sell.service.impl.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public CustomUserService customUserService(){
        return new CustomUserService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().failureForwardUrl("/login?error").defaultSuccessUrl("/user/test").permitAll();
        super.configure(http);
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("zg").password(passwordEncoder().encode("1")).roles("ADMIN").and().withUser("zt").password(passwordEncoder().encode("2")).roles("USER");
        //基于user\role验证
        auth.userDetailsService(customUserService()).passwordEncoder(new MyPasswordEncoder());
    }
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

