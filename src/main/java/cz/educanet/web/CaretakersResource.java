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
    public Response createCaretaker(Caretakers c) {
        if(c == null) {
            return Response.status(400, "Caretaker not created.").build();
        }
        caretakersManager.createCaretaker(c.getFirstName(), c.getLastName(), c.getGender());
        return Response.ok(c).build();
    }

    @PUT    // edits a caretaker
    @Path("{id}")
    public Response editCaretaker(@PathParam("id") Integer id, Caretakers c) {
        if (getCaretaker(id) == null) {
            return Response.status(400, "Caretaker does not exist").build();
        }
        else if (caretakersManager.editCaretaker(id, c.getFirstName(), c.getLastName(), c.getGender()) == null) {
            return Response.status(400, "Input unequal").build();
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
