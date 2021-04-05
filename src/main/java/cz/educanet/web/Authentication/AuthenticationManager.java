package cz.educanet.web.Authentication;

import cz.educanet.web.Token;
import cz.educanet.web.Users.Users;
import cz.educanet.web.Users.UsersManager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;

@ApplicationScoped
public class AuthenticationManager {

    private final ArrayList<AuthenticationUserModel> loggedUsers = new ArrayList<>();
    @Inject
    private UsersManager usersManager;

    public ArrayList<Users> getLoggedUsers() {
        ArrayList<Users> temp = new ArrayList<>();
        for (AuthenticationUserModel pair: loggedUsers) {
            temp.add(pair.user);
        }
        return temp;
    }

    public Users getLoggedUser(int id) {
        return getLoggedUsers().get(id);
    }

    public boolean isValidToken(String username, String token) {
        for (AuthenticationUserModel pair: loggedUsers) {
            if (pair.user.getUsername().equals(username) && pair.token.getBody().equals(token)){
                return true;
            }
        }
        return false;
    }

    public AuthenticationUserModel loginUser(Users user) {
        ArrayList<Users> usersList = usersManager.getUsers();
        for (Users tempUser : usersList) {
            if (tempUser.getUsername().equals(user.getUsername()) && tempUser.getPassword().equals(user.getPassword())) {
                AuthenticationUserModel pair = new AuthenticationUserModel(user, new Token());
                loggedUsers.add(pair);
                return pair;
            }
        }
        return null;
    }

    public boolean isUserLoggedIn(Users user) {
        for (AuthenticationUserModel tempUser : loggedUsers) {
            if (tempUser.user.getUsername().equals(user.getUsername()) && tempUser.user.getUsername().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
