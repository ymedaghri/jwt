package com.ymedaghri.retrogames.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationTokenFilter() {
        super("/api/**");
    }

    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        String header = request.getHeader("Authorization");

        if(header==null || !header.startsWith("Token")) {
            throw new RuntimeException("JWT Token is missing");
        }

        String authenticationToken = header.substring(6);
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);

        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain, final Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
