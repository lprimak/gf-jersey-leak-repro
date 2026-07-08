package com.example.starter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;

@Slf4j
@Provider
@PreMatching
public class RestInterceptor implements ContainerRequestFilter {
    @Context
    HttpServletRequest servletRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        log.info("*** Intercepting REST request: {} {}", requestContext.getMethod(), requestContext.getUriInfo().getRequestUri());
        final HttpSession session = servletRequest.getSession(false);
        if (session != null) {
            throw new IllegalStateException("Session should not be created for REST requests");
        }
    }
}
