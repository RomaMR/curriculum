package com.curriculum.web.security;

import com.curriculum.dto.exception.ExceptionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("accessDeniedHandler")
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(AccessDeniedHandler.class);

    @Autowired
    private ObjectMapper jacksonObjectMapper;

    /**
     * Always returns a 403 error code to the client.
     */
    @Override
    public void handle(final HttpServletRequest request, final HttpServletResponse response, final AccessDeniedException ae) throws IOException, ServletException {
        LOGGER.error("Pre-authenticated entry point called. Rejecting access to path={}", request.getRequestURI());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        ExceptionDTO exceptionDTO = new ExceptionDTO(ae.getMessage() , HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write(jacksonObjectMapper.writeValueAsString(exceptionDTO));
    }

}
