package fr.umlv.java.serviceskeleton;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

/**
 * Skeleton de webService
 * @author Besnard Arthur
 */
public class ServiceSkeleton extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);
        
        
        router.get("/hello/world/:name/").handler(rc -> {
            //Recuperation du parametre name
            String name = rc.request().getParam("name");

            rc.response()
                    .putHeader("content-type", "application/json")
                    .end(new JsonObject().put("key", "Bonjour " + name).encode());
        });

        /*
        Ici on définit la methode appelee lors de l'ecoute et sur quel port 
        cette écoute s'effectue
        */
        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }
}
