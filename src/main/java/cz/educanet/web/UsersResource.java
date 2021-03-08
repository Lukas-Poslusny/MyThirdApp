package cz.educanet.web;

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
    public Response getAllUsers() {
        return Response.ok(usersManager.getUsers()).build();
    }

    @GET    // get specific User
    public Response getUser(int id) {
        return Response.ok(usersManager.getUser(id)).build();
    }

    @POST
    public Response createUser(String username, String password) {
        Users tempUser = new Users(username, password);
        if (doesUserExist(tempUser)) {
            usersManager.createUser(username, password);
            return Response.ok().build();
        }
        return Response.status(Response.Status.valueOf("User does not exist")).build();
    }

    @DELETE // deletes a caretaker
    @Path("{id}")
    public Response deleteUser(Users c) {
        if (usersManager.deleteUser(c)) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.valueOf("Cannot delete nonexistent user.")).build();
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
