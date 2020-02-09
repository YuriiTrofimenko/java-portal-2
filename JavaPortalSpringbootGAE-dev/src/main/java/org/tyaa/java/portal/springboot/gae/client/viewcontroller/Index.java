/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae.client.viewcontroller;

import org.teavm.flavour.routing.Routing;
import org.teavm.flavour.templates.BindTemplate;
import org.tyaa.java.portal.springboot.gae.client.ClientRoute;

/**
 *
 * @author yurii
 */
@BindTemplate("templates/index.html")
public class Index {
    
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    
    public void sayHello() {
        Routing.open(ClientRoute.class).hello(name);
    }
}
