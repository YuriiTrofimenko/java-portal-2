package org.tyaa.java.portal.springboot.gae.client;

import java.util.function.Consumer;
import org.teavm.flavour.routing.Routing;
import org.teavm.flavour.templates.BindTemplate;
import org.teavm.flavour.templates.Templates;
import org.teavm.flavour.widgets.ApplicationTemplate;
import org.teavm.flavour.widgets.RouteBinder;
import org.tyaa.java.portal.springboot.gae.client.viewcontroller.Author;
import org.tyaa.java.portal.springboot.gae.client.viewcontroller.Fibonacci;
import org.tyaa.java.portal.springboot.gae.client.viewcontroller.Hello;
import org.tyaa.java.portal.springboot.gae.client.viewcontroller.Index;

@BindTemplate("templates/master.html")
public class Client extends ApplicationTemplate implements ClientRoute {
    private String userName = "";

    public static void main(String[] args) {
        // Client client = new Client();
        // client.bind("application-content");
        
        // Templates.bind(new Fibonacci(), "application-content");
        
        Client client = new Client();
        new RouteBinder()
            .withDefault(ClientRoute.class, r -> r.index())
            .add(client)
            .update();

        client.bind("application-content");
    }

    /* public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    } */

    @Override
    public void index() {
        setView(new Index());
    }

    @Override
    public void hello(String name) {
        setView(new Hello(name));
    }

    @Override
    public void fibonacci() {
        setView(new Fibonacci());
    }
    
    @Override
    public void author() {
        setView(new Author());
    }
    
    public ClientRoute route(Consumer<String> consumer) {
        return Routing.build(ClientRoute.class, consumer);
    }
}
