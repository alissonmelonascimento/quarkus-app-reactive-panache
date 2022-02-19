package org.acme;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Uni;

@Path("/fruits")
public class FruitResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Fruit>> listAll() {
        return Fruit.listAll();
    }
}