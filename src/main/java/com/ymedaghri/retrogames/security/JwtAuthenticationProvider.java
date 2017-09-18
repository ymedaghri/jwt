package com.ymedaghri.retrogames.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {


    @Autowired
    private JwtValidator validator;

    @Override
    protected void additionalAuthenticationChecks(final UserDetails userDetails, final UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(final String username, final UsernamePasswordAuthenticationToken authenticationToken) throws AuthenticationException {

        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authenticationToken;
        String token = jwtAuthenticationToken.getToken();
        JwtUser jwtUser = validator.validate(token);

        if (jwtUser == null) throw new RuntimeException("JWT Token is incorrect");

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(jwtUser.getRole());

        return new JwtUserDetails(jwtUser.getUserName(), jwtUser.getId(),
                token, grantedAuthorities);
    }

    @Override
    public boolean supports(final Class<?> authenticationClass) {
        return JwtAuthenticationToken.class.isAssignableFrom(authenticationClass);
    }


}
