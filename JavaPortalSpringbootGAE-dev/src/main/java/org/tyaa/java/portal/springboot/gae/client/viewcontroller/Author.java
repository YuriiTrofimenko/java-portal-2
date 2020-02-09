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
    // private AuthorFlavour author = new AuthorFlavour();
    private org.tyaa.java.portal.datastore.model.Author author =
        new org.tyaa.java.portal.datastore.model.Author();
    private AuthorService authorService;
    
    public Author(){
        
        authorService =
            RESTClient.factory(AuthorService.class)
                .createResource("api");
        loadAuthors();
        
    }
    
    private void loadAuthors() {
    
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
    
    public org.tyaa.java.portal.datastore.model.Author getAuthor() {
                
        return author;
    }
    
    public void save() {
    
        AuthorFlavour authorFlavour =
            new AuthorFlavour(
                author.getName()
                , author.getAbout()
                , new SimpleDateFormat("yyyy-MM-dd").format(author.getStartedAt())
            );
        background.run(() -> {
            try {
                authorService.create(authorFlavour);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } finally {
                this.authors.clear();
                loadAuthors();
            }
        });
    }
}
