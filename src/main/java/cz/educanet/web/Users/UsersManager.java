package cz.educanet.web.Users;

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

    public void createUser(Users user) {
        usersList.add(user);
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
