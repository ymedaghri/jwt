package com.ymedaghri.retrogames.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken{

    private String token;

    public JwtAuthenticationToken(final String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
