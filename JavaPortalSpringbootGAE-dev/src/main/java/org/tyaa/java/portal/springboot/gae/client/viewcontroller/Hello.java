/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae.client.viewcontroller;

import java.util.function.Consumer;
import org.teavm.flavour.routing.Routing;
import org.teavm.flavour.templates.BindTemplate;
import org.tyaa.java.portal.springboot.gae.client.ClientRoute;

/**
 *
 * @author yurii
 */
@BindTemplate("templates/hello.html")
public class Hello {
    
    private String name;

    public Hello(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public ClientRoute route(Consumer<String> consumer) {
        return Routing.build(ClientRoute.class, consumer);
    }
}
