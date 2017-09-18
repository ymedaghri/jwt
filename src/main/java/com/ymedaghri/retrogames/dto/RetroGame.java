package com.ymedaghri.retrogames.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
@Entity
public class RetroGame implements java.io.Serializable {

    @GeneratedValue
    @Id
    private Long id;

    private String name;

    public RetroGame() {
        // Why JPA Why ?
    }

    public RetroGame(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
