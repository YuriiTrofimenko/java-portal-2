/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.datastore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.io.Serializable;
//import java.util.Collection;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author student
 */
@Getter @Setter @NoArgsConstructor
public class AuthorFlavour implements Serializable{
    private Long id;
    private String name;
    private String about;
    private String startedAt;
    //
    //private Collection<Article> articlesCollection;
        
    public AuthorFlavour(Long id, String name, String about, String startedAt) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.startedAt = startedAt;
    }

    @Override
    public String toString() {
        return "AuthorFlavour{" + "id=" + id + ", name=" + name + ", about=" + about + ", startedAt=" + startedAt + '}';
    }
    
    
}
