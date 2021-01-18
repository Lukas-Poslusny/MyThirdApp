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

    public boolean doesAnimalExist(Animals a) {
        for (int i = 0; i < animalsList.size(); i++) {
            if (animalsList.get(i).getName().equals(a.getName())) {
                return true;
            }
        }
        return false;
    }

    public Animals createAnimal(String name, Integer age, Integer weight, String gender) {
        Animals tempAnimal = new Animals(name, age, weight, gender);

        if (doesAnimalExist(tempAnimal)) {
            return null;
        }
        return tempAnimal;
    }

    public Animals editAnimal(Animals a, String name, Integer age, Integer weight, String gender) {
        Animals tempAnimal = new Animals(name, age, weight, gender);

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

    public boolean deleteAnimal(Animals a) {
        for(int i = 0; i < animalsList.size(); i ++) {
            if (getAnimal(i) == a) {
                animalsList.remove(a);
                return true;
            }
        }
        return false;
    }

}
