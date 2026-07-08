package com.example.starter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import java.util.Objects;

@Path("/hello")
public class HelloResource {
    @Context
    UriInfo uriInfo;
    @Context
    HttpServletRequest request;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Objects.requireNonNull(uriInfo, "UriInfo is null");
        Objects.requireNonNull(request, "HttpServletRequest is null");
        return "Hello World!";
    }
}
