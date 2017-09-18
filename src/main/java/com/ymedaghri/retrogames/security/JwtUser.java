package com.ymedaghri.retrogames.security;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
public class JwtUser {
    private String userName;
    private long id;
    private String role;

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }

    public long getId() {
        return id;
    }
}
