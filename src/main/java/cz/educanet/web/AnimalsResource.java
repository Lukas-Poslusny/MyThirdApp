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
    public Response createAnimal(Animals a) {
        if (a == null) {
            return Response.status(400, "Animal not created.").build();
        }
        animalsManager.createAnimal(a.getName(), a.getAge(), a.getWeight(), a.getGender());
        return Response.ok(a).build();
    }

    @PUT    // edits an animal
    @Path("{id}")
    public Response editAnimal(@PathParam("id") Integer id, Animals a) {
        if (getAnimal(id) == null) {
            return Response.status(400, "Animal does not exist").build();
        }
        else if (animalsManager.editAnimal(id, a.getName(), a.getAge(), a.getWeight(), a.getGender()) == null) {
            return Response.status(400, "Input unequal").build();
        }
        return Response.ok(getAnimal(id)).build();
    }

    @DELETE // deletes an animal
    @Path("{id}")
    public Response deleteAnimal(@PathParam("id") Integer id) {
    if (animalsManager.deleteAnimal(id)) {
            return Response.ok().build();
        }
        return Response.status(400, "Cannot delete non-existent animal.").build();
    }
}
