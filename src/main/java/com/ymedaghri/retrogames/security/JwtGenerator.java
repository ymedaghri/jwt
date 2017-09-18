package com.ymedaghri.retrogames.security;

import com.ymedaghri.retrogames.config.JwtSecurityConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
@Component
public class JwtGenerator {
    public String generate(final JwtUser jwtUser) {
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, JwtSecurityConfig.secret)
                .compact();
    }
}
