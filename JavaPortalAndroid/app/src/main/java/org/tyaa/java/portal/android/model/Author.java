package org.tyaa.java.portal.android.model;

import java.io.Serializable;
import java.util.Date;

public class Author implements Serializable {
    private Long id;
    private String name;
    private String about;
    private Date startedAt;

    public Author() {
    }

    public Author(Long id) {
        this.id = id;
    }

    public Author(String name, String about, Date startedAt) {
        this.name = name;
        this.about = about;
        this.startedAt = startedAt;
    }

    public Author(Long id, String name, String about, Date startedAt) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.startedAt = startedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }
}
