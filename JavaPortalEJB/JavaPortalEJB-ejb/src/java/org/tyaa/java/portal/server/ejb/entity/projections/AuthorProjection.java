/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.server.ejb.entity.projections;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author yurii
 */
public class AuthorProjection {
    
    private Integer id;
    private String name;
    private Date startedAt;

    public AuthorProjection(Integer id, String name, Date startedAt) {
        this.id = id;
        this.name = name;
        this.startedAt = startedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }
}
