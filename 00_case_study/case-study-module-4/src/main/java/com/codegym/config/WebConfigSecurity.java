package com.codegym.config;

import com.codegym.service.implement.user.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailServiceImpl userDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests().antMatchers("/home","/sign-in","/sign-up","/logout","/service/list").permitAll();

        http.authorizeRequests().antMatchers("/customer/detail","/service/booking/*","/service/booking").access("hasAnyRole('ROLE_GUEST','ROLE_EMPLOYEE','ROLE_MANAGE','ROLE_ADMIN')");

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/sign-in")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")

                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/home");

        http.authorizeRequests().and()
                .rememberMe().tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(24 * 60 * 60);

    }

    public PersistentTokenRepository persistentTokenRepository() {
        return new InMemoryTokenRepositoryImpl();
    }
}
