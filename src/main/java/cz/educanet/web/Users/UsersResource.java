package cz.educanet.web.Users;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("users")
public class UsersResource {

    @Inject
    private UsersManager usersManager;

    @GET    // get all Users
    @Path("all")
    public Response getAllUsers() {
        return Response.ok(usersManager.getUsers()).build();
    }

    @GET    // get specific User
    public Response getUser(@QueryParam("id") int id) {
        return Response.ok(usersManager.getUser(id)).build();
    }

    @POST
    public Response createUser(Users user) {
        if (!doesUserExist(user)) {
            usersManager.createUser(user);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }

    @DELETE // deletes a caretaker
    @Path("{id}")
    public Response deleteUser(Users c) {
        if (usersManager.deleteUser(c)) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }

    public boolean doesUserExist(Users user) {
        for (int i = 0; i < usersManager.getUsers().size(); i++) {
            if (usersManager.getUsers().get(i).getUsername().equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }
}
