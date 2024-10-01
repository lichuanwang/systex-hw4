package com.systex.hw4.utils;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*") // Filter all requests
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        String requestURI = httpRequest.getRequestURI();

        // Define protected resources that require login
        boolean authenticateRequired = requestURI.startsWith(httpRequest.getContextPath() + "/lottery") ||
                requestURI.startsWith(httpRequest.getContextPath() + "/game");

        // Check if the resource is protected and if the user is logged in
        if (authenticateRequired && (session == null || session.getAttribute("user") == null)) {
            // If the user is not logged in and tries to access a protected resource, redirect to login page
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/auth/login");
        } else {
            // If it's a login, register, or forgot-password request, or the user is logged in, proceed with the request
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }
}