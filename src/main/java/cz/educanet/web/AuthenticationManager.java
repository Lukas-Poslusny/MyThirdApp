package cz.educanet.web;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class AuthenticationManager {
    @Inject
    private UsersManager usersManager;

    private final ArrayList<Users> tempUsers = usersManager.getUsers();
    private final ArrayList<Users> loggedUsers = new ArrayList<>();

    @GET
    public Response getLoggedUsers() {
        return Response.ok(loggedUsers).build();
    }

    @POST
    public Response registerUser(String username, String password) {
        Users tempUser = new Users(username, password);
        if (doesUserExist(tempUser)) {
            usersManager.createUser(username, password);
            return Response.ok().build();
        }
        return Response.status(Response.Status.valueOf("User does not exist")).build();
    }

    @POST
    public Response loginUser(String username, String password) {
        Users tempUser = new Users(username, password);

        if (doesUserExist(tempUser)) {
            for (Users user : tempUsers) {
                if (user.getUsername().equals(tempUser.getUsername()) && user.getPassword().equals(tempUser.getPassword())) {
                    loggedUsers.add(tempUser);
                    return Response.ok("Successfully logged in").build();
                }
            }
        }
        return Response.status(Response.Status.valueOf("User does not exist")).build();
    }

    @DELETE
    public Response logoutUser(Users user) {
        for (Users tempUser : tempUsers) {
            if (tempUser.getUsername().equals(user.getUsername())) {
                loggedUsers.remove(user);
                return Response.ok("Successfully logged out").build();
            }
        }
        return Response.status(Response.Status.valueOf("Could not log user out.")).build();
    }

    public boolean doesUserExist(Users user) {
        for (Users loggedUser : loggedUsers) {
            if (loggedUser.getUsername().equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }
}
