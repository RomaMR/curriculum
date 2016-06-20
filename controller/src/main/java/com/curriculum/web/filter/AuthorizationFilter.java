package com.curriculum.web.filter;

import com.curriculum.domain.token.Token;
import com.curriculum.exception.ContentNotFoundException;
import com.curriculum.service.token.TokenService;
import com.curriculum.web.config.API;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorizationFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationFilter.class);

    private TokenService tokenService;

    public AuthorizationFilter(final TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
        LOGGER.info("AuthorizationFilter: authenticate user");
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        if (request.getCookies() != null) {
            for (final Cookie cookie : request.getCookies()) {
                if (API.Headers.Cookie.TOKEN.equals(cookie.getName())) {
                    try {
                        final Token token = tokenService.find(cookie.getValue());
                        final String principal = token.getUserId();
                        final String credentials = token.getId();
                        final String authority = token.getUserRole();

                        final List<GrantedAuthority> authorities = new ArrayList<>();
                        authorities.add(new SimpleGrantedAuthority(authority));

                        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(principal, credentials, authorities));
                        LOGGER.info("AuthorizationFilter: authentication finished");
                    } catch (final ContentNotFoundException e) {
                        LOGGER.error("AuthorizationFilter: message={}", e.getValue());
                    }
                }
            }
        }
        chain.doFilter(request, response);
        SecurityContextHolder.clearContext();
    }

    @Override
    public void destroy() {

    }
}
