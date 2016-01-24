package fr.umlv.java.smanipulator;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

/**
 *
 * @author Besnard Arthur
 */
public class SManipulator extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);

        router.get("/mirror/:string/").handler(rc -> {
            String string = rc.request().getParam("string");

            rc.response()
                    .putHeader("content-type", "application/json")
                    .end(new JsonObject().put("result", new StringBuilder(string).reverse().toString()).encode());
        });

        router.get("/upper/:string/").handler(rc -> {
            String string = rc.request().getParam("string");

            rc.response()
                    .putHeader("content-type", "application/json")
                    .end(new JsonObject().put("result", string.toUpperCase()).encode());
        });

        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }
}
