package com.ymedaghri.retrogames.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
public class JwtUserDetails implements UserDetails {
    private String userName;
    private long id;
    private String token;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public JwtUserDetails(final String userName, final long id, final String token, final List<GrantedAuthority> grantedAuthorities) {
        this.userName = userName;
        this.id = id;
        this.token = token;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return null;
    }


    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
