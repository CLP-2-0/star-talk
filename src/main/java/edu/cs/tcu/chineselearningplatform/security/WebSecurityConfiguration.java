package edu.cs.tcu.chineselearningplatform.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/**").permitAll()
//                .antMatchers(HttpMethod.GET,"/users/**").permitAll()
//                .antMatchers(HttpMethod.GET,"/courses/**").permitAll()
                .anyRequest().authenticated();
    }
}