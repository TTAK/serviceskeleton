package fr.umlv.java.smanipulator;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

/**
 *
 * @author Besnard Arthur
 */
public class ServiceSkeleton extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);

        router.get("/hello/world/:name").handler(rc -> {
            String name = rc.request().getParam("name");

            rc.response()
                    .putHeader("content-type", "application/json")
                    .end(new JsonObject().put("key", "Bonjour " + name).encode());
        });

        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }
}
