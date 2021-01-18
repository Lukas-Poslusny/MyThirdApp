package cz.educanet.web;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@ApplicationScoped
public class CaretakersManager {

    private final ArrayList<Caretakers> caretakersList = new ArrayList<>();


    public ArrayList<Caretakers> getCaretakers() {
        return caretakersList;
    }

    public Caretakers getCaretaker(Integer i) {
        return getCaretakers().get(i);
    }

    public Caretakers createCaretaker(String firstName, String lastName, String gender) {
        Caretakers tempUser = new Caretakers(firstName, lastName, gender);
        if (doesCaretakerExist(tempUser)) {
            return null;
        }
        return  tempUser;
    }

    public boolean doesCaretakerExist(Caretakers c) {
        for (int i = 0; i < caretakersList.size(); i++) {
            if (caretakersList.get(i).getFullName().equals(c.getFullName())) {
                return true;
            }
        }
        return false;
    }

    public Caretakers editCaretaker(Caretakers c, String firstName, String lastName, String gender) {
        Caretakers tempCaretaker = new Caretakers(firstName, lastName, gender);

        if (!c.equals(tempCaretaker)) {
            return null;
        }
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setGender(gender);
        return c;
    }

    public boolean deleteCaretaker(Caretakers c) {
        for(int i = 0; i < caretakersList.size(); i ++) {
            if (getCaretaker(i) == c) {
                caretakersList.remove(c);
                return true;
            }
        }
        return false;
    }
}
