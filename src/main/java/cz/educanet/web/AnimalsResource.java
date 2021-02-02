package cz.educanet.web;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("animals")
public class AnimalsResource {

    @Inject
    private AnimalsManager animalsManager;


    @GET    // get all animals
    public Response getAllAnimals() {
        return Response.ok(animalsManager.getAnimals()).build();
    }

    @GET    // get specific animal
    @Path("{id}")
    public Response getAnimal(@PathParam("id") int id) {
        return Response.ok(animalsManager.getAnimal(id)).build();
    }

    @POST   // creates an animal
    public Response createAnimal(@FormParam("name") String name, @FormParam("age") Integer age, @FormParam("weight") Integer weight, @FormParam("gender") String gender) {
        Animals tempAnimal = animalsManager.createAnimal(name, age, weight, gender);
        if (tempAnimal == null) {
            return Response.status(Response.Status.valueOf("Animal not created.")).build();
        }
        return Response.ok(tempAnimal).build();
    }

    @PUT    // edits an animal
    @Path("{id}")
    public Response editAnimal(Animals a, @FormParam("name") String name, @FormParam("age") Integer age, @FormParam("weight") Integer weight, @FormParam("gender") String gender) {
        if (animalsManager.editAnimal(a, name, age, weight, gender) == null) {
            return Response.status(Response.Status.valueOf("Input equal")).build();
        }
        return Response.ok(a).build();
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
