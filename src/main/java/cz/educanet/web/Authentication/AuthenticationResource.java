package cz.educanet.web.Authentication;

import cz.educanet.web.Users.Users;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("logged")
public class AuthenticationResource {

    @Inject
    private AuthenticationManager authenticationManager;

    @GET    // get all Users
    @Path("all")
    public Response getAllLoggedUsers() {
        return Response.ok(authenticationManager.getLoggedUsers()).build();
    }

    @GET    // get specific User
    public Response getLoggedUser(@QueryParam("id") int id) {
        return Response.ok(authenticationManager.getLoggedUser(id)).build();
    }

    @POST
    public Response loginUser(Users user) {
        AuthenticationUserModel tempPair = authenticationManager.loginUser(user);
        if (tempPair != null) {
            return Response.ok(tempPair.token).build();
        }
        return Response.status(400, "bad").build();
    }

}
