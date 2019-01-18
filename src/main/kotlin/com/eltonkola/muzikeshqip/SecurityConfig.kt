package com.eltonkola.muzikeshqip

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter {

  
  
    override fun configure(http : HttpSecurity) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                 .anyRequest().authenticated()
                .and()
                 .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }

    override fun configure(auth : AuthenticationManagerBuilder) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("elton")
                    .password("kola")
                    .roles("USER")
//             .and()
//                 .withUser("admin")
//                     .password("kola")
//                     .credentialsExpired(true)
//                     .accountExpired(true)
//                     .accountLocked(true)
//                     .authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES")
//                     .roles("MANAGER")
    }

}