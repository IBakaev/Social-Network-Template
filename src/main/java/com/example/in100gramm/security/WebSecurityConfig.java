package com.example.in100gramm.security;

import com.example.in100gramm.security.jwt.JWTAuthenticationEntryPoint;
import com.example.in100gramm.security.jwt.JWTAuthenticationFilter;
import com.example.in100gramm.service.ConfigUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
        (
                securedEnabled = true,
                jsr250Enabled = true,
                proxyTargetClass = true
        )
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    ConfigUserDetailsService configUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.cors().and().csrf().disable()
               .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
               .and()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
               .authorizeRequests()
               .antMatchers(SecurityConstants.SIGN_UP_URLS).permitAll()
               .anyRequest().authenticated();

       http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);


    }

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception
{
    auth.userDetailsService(configUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
}

@Override
@Bean(BeanIds.AUTHENTICATION_MANAGER)
    protected AuthenticationManager authenticationManager() throws  Exception
    {
        return super.authenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter()
    {
        return new JWTAuthenticationFilter();
    }
}
