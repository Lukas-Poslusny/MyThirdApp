package cz.educanet.web;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@ApplicationScoped
public class AuthenticationManager {


    private final ArrayList<Users> loggedUsers = new ArrayList<>();


    public ArrayList<Users> getLoggedUsers() {
        return loggedUsers;
    }

    public Users getLoggedUser(int id) {
        return getLoggedUsers().get(id);
    }

    public boolean loginUser(String username, String password) {
        Users tempUser = new Users(username, password);

        if (doesUserExist(tempUser)) {
            for (Users user : getLoggedUsers()) {
                if (user.getUsername().equals(tempUser.getUsername()) && user.getPassword().equals(tempUser.getPassword())) {
                    loggedUsers.add(tempUser);
                    return true;
                }
            }
        }
        return false;
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
