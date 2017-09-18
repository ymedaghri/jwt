package com.ymedaghri.retrogames.security;

import com.ymedaghri.retrogames.config.JwtSecurityConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
@Component
public class JwtValidator {



    public JwtUser validate(final String token) {

        JwtUser jwtUser = null;

        try {

            Claims body = Jwts.parser()
                    .setSigningKey(JwtSecurityConfig.secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));

        } catch (Exception e) {
            System.out.println(e);
        }


        return jwtUser;
    }
}
