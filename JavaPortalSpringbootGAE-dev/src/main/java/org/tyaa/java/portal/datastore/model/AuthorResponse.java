/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.datastore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author yurii
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @NoArgsConstructor
public class AuthorResponse {
    
    private String status;
    private String message;
    private List<AuthorFlavour> data;
    

    public AuthorResponse(String status, String message, List<AuthorFlavour> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    
}
