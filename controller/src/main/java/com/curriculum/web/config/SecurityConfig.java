package com.curriculum.web.config;

import com.curriculum.service.token.TokenService;
import com.curriculum.web.filter.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationEntryPoint")
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    @Qualifier("accessDeniedHandler")
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    @Qualifier("defaultTokenService")
    private TokenService tokenService;

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring()
                .antMatchers(HttpMethod.OPTIONS)
                .antMatchers(HttpMethod.GET, API.User.ROOT + API.User.EMAIL)
                .antMatchers(HttpMethod.POST, API.Authentication.ROOT)
                .antMatchers(HttpMethod.POST, API.User.ROOT);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //static content
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET, "/scripts/**").permitAll()
                .antMatchers(HttpMethod.GET, "/styles/**").permitAll()
                //users
                .antMatchers(HttpMethod.GET, API.User.ROOT).hasRole(SecurityConstants.Role.ADMIN)
                .antMatchers(HttpMethod.GET, API.User.ROOT + API.User.CURRENT).fullyAuthenticated()
                .antMatchers(HttpMethod.PATCH, API.User.ROOT + API.ID).fullyAuthenticated()
                .antMatchers(HttpMethod.PATCH, API.User.ROOT + API.User.PASSWORD).fullyAuthenticated()
                .antMatchers(HttpMethod.PATCH, API.User.ROOT + API.User.ROLE).hasRole(SecurityConstants.Role.ADMIN)
                //curriculums
                .antMatchers(HttpMethod.GET, API.Curriculum.ROOT + API.ID).hasAnyRole(SecurityConstants.Role.WRITE, SecurityConstants.Role.ADMIN)
                .antMatchers(HttpMethod.GET, API.Curriculum.ROOT).fullyAuthenticated()
                .antMatchers(HttpMethod.POST, API.Curriculum.ROOT).hasAnyRole(SecurityConstants.Role.WRITE, SecurityConstants.Role.ADMIN)
                .antMatchers(HttpMethod.PATCH, API.Curriculum.ROOT + API.ID).hasAnyRole(SecurityConstants.Role.WRITE, SecurityConstants.Role.ADMIN)
                //constants
                .antMatchers(HttpMethod.GET, API.Constants.ROOT + API.ID).hasAnyRole(SecurityConstants.Role.WRITE, SecurityConstants.Role.ADMIN)
                .antMatchers(HttpMethod.GET, API.Constants.ROOT).hasRole(SecurityConstants.Role.ADMIN)
                .antMatchers(HttpMethod.POST, API.Constants.ROOT).hasRole(SecurityConstants.Role.ADMIN)
                .anyRequest().authenticated()
                //authentication
                .antMatchers(HttpMethod.GET, API.Authentication.ROOT).fullyAuthenticated()
                .and()
                .addFilterBefore(new AuthorizationFilter(tokenService), BasicAuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler);
    }

    private interface SecurityConstants {
        interface Role {
            String READ = "READ";
            String WRITE = "WRITE";
            String ADMIN = "ADMIN";
        }
    }
}
