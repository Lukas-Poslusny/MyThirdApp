package cz.educanet.web;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("animals")
public class CaretakersResource {

    @Inject
    private CaretakersManager caretakersManager;


    @GET    // get all caretakers
    public Response getAllCaretakers() {
        return Response.ok(caretakersManager.getCaretakers()).build();
    }

    @GET    // get specific caretaker
    public Response getCaretaker(int id) {
        return Response.ok(caretakersManager.getCaretaker(id)).build();
    }

    @POST   // creates/adds a caretaker
    public Response createCaretaker(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("gender") String gender) {
        Caretakers tempCaretaker = caretakersManager.createCaretaker(firstName, lastName, gender);
        if(tempCaretaker == null) {
            return Response.status(Response.Status.valueOf("Caretaker already exists!")).build();
        }
        return Response.ok("New caretaker created").build();
    }

    @PUT    // edits a caretaker
    @Path("{id}")
    public Response editCaretaker(Caretakers c, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("gender") String gender) {
        if (caretakersManager.editCaretaker(c, firstName, lastName, gender) == null) {
            return Response.status(Response.Status.valueOf("Input equal")).build();
        }
        return Response.ok().build();
    }

    @DELETE // deletes a caretaker
    @Path("{id}")
    public Response deleteCaretaker(Caretakers c) {
        if (caretakersManager.deleteCaretaker(c)) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.valueOf("Cannot delete none existent caretaker.")).build();
    }
}
