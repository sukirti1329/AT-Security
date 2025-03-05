package com.airtribe.user.news.aggregator.config;

import com.airtribe.user.news.aggregator.util.JwtTokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (request.getRequestURI().contains("/user/signup") || request.getRequestURI().contains("/verifyRegistration") || request.getRequestURI().contains("/signin")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (authHeader == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Missing Authorization header");
            return;
        }

        if (!JwtTokenUtil.validateToken(authHeader)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Invalid token");
            return;
        }

        filterChain.doFilter(request, response);

    }
}

