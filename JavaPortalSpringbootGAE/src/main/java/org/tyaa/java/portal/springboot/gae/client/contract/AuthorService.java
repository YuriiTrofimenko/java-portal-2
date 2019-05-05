package org.tyaa.java.portal.springboot.gae.client.contract;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.tyaa.java.portal.datastore.model.Author;
import org.tyaa.java.portal.datastore.model.AuthorFlavour;
import org.tyaa.java.portal.datastore.model.AuthorResponse;
import org.tyaa.java.portal.datastore.model.JsonHttpResponse;
/* import org.tyaa.java.portal.datastore.model.Author;
import retrofit2.Call;
import retrofit2.http.GET; */

/**
 *
 * @author yurii
 */
@Path("author/flavour")
public interface AuthorService {
    
    /* @GET
    @Path("all")
    List<AuthorFlavour> getAuthors(); */
    
    @GET
    @Path("")
    AuthorResponse getAuthors();
    
}
