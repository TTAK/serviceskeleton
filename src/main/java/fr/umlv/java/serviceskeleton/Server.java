
package fr.umlv.java.serviceskeleton;

import io.vertx.core.Vertx;

/**
 * Main class used to launch the VertX server
 * @author TTAK
 */
public class Server {

    /**
     * Main used to launch the VertX server
     * @param args : command line arguments
     */
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        ServiceSkeleton service= new ServiceSkeleton();
        vertx.deployVerticle(service);
    }
}
