/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae.client;

import org.teavm.flavour.routing.Path;
import org.teavm.flavour.routing.PathParameter;
import org.teavm.flavour.routing.PathSet;
import org.teavm.flavour.routing.Route;

/**
 *
 * @author yurii
 */
@PathSet
public interface ClientRoute extends Route {
    
    @Path("/")
    void index();
    
    @Path("/hello/{name}")
    void hello(@PathParameter("name") String name);

    @Path("/fibonacci")
    void fibonacci();
    
    @Path("/author")
    void author();
}
