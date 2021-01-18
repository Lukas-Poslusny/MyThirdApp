package cz.educanet.web;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("{animals}")
public class AnimalsResource {

    @Inject
    private AnimalsManager animalsManager;
    // TODO: 1/12/2021
    //  GET  /animals/id return specific animal

    @GET    // get all animals
    public Response getAllAnimals() {
        animalsManager.getAnimals(); // result ignored
        return Response.ok().build();
    }

    @POST   // creates an animal
    @Path("{create}")
    public Response createAnimal(@FormParam("name") String name, @FormParam("age") Integer age, @FormParam("weight") Integer weight, @FormParam("gender") String gender) {
        if (animalsManager.createAnimal(name, age, weight, gender) == null) {
            return Response.status(Response.Status.valueOf("Animal not created.")).build();
        }
        return Response.ok().build();
    }

    @PUT    // edits an animal
    @Path("{id}")
    public Response editAnimal(Animals a, @FormParam("name") String name, @FormParam("age") Integer age, @FormParam("weight") Integer weight, @FormParam("gender") String gender) {
        if (animalsManager.editAnimal(a, name, age, weight, gender) == null) {
            return Response.status(Response.Status.valueOf("Input equal")).build();
        }
        return Response.ok().build();
    }

    @DELETE // deletes an animal
    @Path("{id}")
    public Response deleteAnimal(Animals a) {
    if (animalsManager.deleteAnimal(a)) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.valueOf("Cannot delete none existent animal.")).build();
    }
}
