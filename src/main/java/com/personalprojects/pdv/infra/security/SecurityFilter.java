package com.personalprojects.pdv.infra.security;

import com.personalprojects.pdv.domain.errors.StandardException;
import com.personalprojects.pdv.domain.errors.TokenVerificationException;
import com.personalprojects.pdv.domain.services.TokenService;
import com.personalprojects.pdv.infra.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService service;

    @Autowired
    UserRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException  {
        try {
            var token = recoverToken(request);
            if (token != null) {
                var username = service.validateToken(token);
                var user = repository.findByUsername(username);

                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            filterChain.doFilter(request, response);
        } catch (Exception exception) {
            handleFilterException(exception, request, response);
        }
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }

    private void handleFilterException(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setStatus(403);
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        String errorResponse = new StandardException(Instant.now(), request.getRequestURI(), exception.getMessage()).toString();
        out.print("{" + errorResponse + "}");

        out.flush();
    }
}
