package cz.educanet.web;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class UsersManager {

    private final ArrayList<Users> usersList = new ArrayList<>();


    public ArrayList<Users> getUsers() {
        return usersList;
    }

    public Users getUser(Integer i) {
        return getUsers().get(i);
    }

    public void createUser(String username, String password) {
        Users tempUser = new Users(username, password);
        usersList.add(tempUser);
    }

    public boolean deleteUser(Users user) {
        for(int i = 0; i < usersList.size(); i ++) {
            if (getUser(i) == user) {
                usersList.remove(user);
                return true;
            }
        }
        return false;
    }
}
