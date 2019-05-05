/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae.client.viewcontroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.teavm.flavour.rest.RESTClient;
import org.teavm.flavour.templates.BindTemplate;
import org.teavm.flavour.widgets.BackgroundWorker;
import org.tyaa.java.portal.datastore.model.AuthorFlavour;
import org.tyaa.java.portal.datastore.model.AuthorResponse;
import org.tyaa.java.portal.datastore.model.JsonHttpResponse;
import org.tyaa.java.portal.springboot.gae.client.contract.AuthorService;

/**
 *
 * @author yurii
 */
@BindTemplate("templates/author.html")
public class Author {
    
    private final BackgroundWorker background = new BackgroundWorker();
    private List<AuthorFlavour> authors = new ArrayList<>();
    
    public Author(){
        
        AuthorService authorService =
            RESTClient.factory(AuthorService.class)
                .createResource("api");
        
        background.run(() -> {
            try {
                AuthorResponse authorsResponse = authorService.getAuthors();
                List<AuthorFlavour> authors =
                        (List<AuthorFlavour>)authorsResponse.getData();
                if (authors != null) {
                    this.authors.addAll(authors);
                } else {
                    System.out.println(authorsResponse.getMessage());
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
    }
    
    public List<AuthorFlavour> getAuthors() {
                
        return authors;
    }
}
