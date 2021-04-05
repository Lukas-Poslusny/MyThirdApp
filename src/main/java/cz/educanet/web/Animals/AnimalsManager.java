package cz.educanet.web.Animals;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class AnimalsManager {

    private int id = -1;

    private final ArrayList<Animals> animalsList = new ArrayList<>();

    public ArrayList<Animals> getAnimals() {
        return animalsList;
    }

    public Animals getAnimal(Integer id) {
        return getAnimals().get(id);
    }

    public void createAnimal(Animals tempAnimal) {
        id++;
        tempAnimal.setId(id);
        animalsList.add(tempAnimal);
    }

    public Animals editAnimal(Integer id, Animals newAnimal) {
        Animals currentAnimal = getAnimal(id);
        if (!currentAnimal.equals(newAnimal)) {
            return null;
        }
        else {
            currentAnimal.setName(newAnimal.getName());
            currentAnimal.setAge(newAnimal.getAge());
            currentAnimal.setWeight(newAnimal.getWeight());
            currentAnimal.setGender(newAnimal.getGender());
        }
        return currentAnimal;
    }

    public boolean deleteAnimal(Integer id) {
        for(int i = 0; i < animalsList.size(); i ++) {
            if (getAnimal(i).getId() == id) {
                animalsList.remove(getAnimal(i));
                return true;
            }
        }
        return false;
    }

}
