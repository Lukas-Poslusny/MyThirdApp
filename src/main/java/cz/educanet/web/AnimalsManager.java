package cz.educanet.web;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class AnimalsManager {

    private final ArrayList<Animals> animalsList = new ArrayList<>();

    public ArrayList<Animals> getAnimals() {
        return animalsList;
    }

    public Animals getAnimal(Integer i) {
        return getAnimals().get(i);
    }

    public void createAnimal(String name, Integer age, Integer weight, String gender) {
        Animals tempAnimal = new Animals(name, age, weight, gender);
        animalsList.add(tempAnimal);
    }

    public Animals editAnimal(Integer id, String name, Integer age, Integer weight, String gender) {
        Animals tempAnimal = new Animals(name, age, weight, gender);
        Animals a = getAnimal(id);
        if (!a.equals(tempAnimal)) {
            return null;
        }
        else {
            a.setName(name);
            a.setAge(age);
            a.setWeight(weight);
            a.setGender(gender);
        }
        return a;
    }

    public boolean deleteAnimal(Integer id) {
        for(int i = 0; i < animalsList.size(); i ++) {
            if (getAnimal(i) == getAnimal(id)) {
                animalsList.remove(getAnimal(id));
                return true;
            }
        }
        return false;
    }

}
