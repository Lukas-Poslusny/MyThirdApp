package cz.educanet.web.Animals;


public class Animals {

    private int id = 0;
    private String name;
    private int age;
    private int weight;
    private String gender;

    public Animals(int id, String name, int age, int weight, String gender) {
        this.id = getId();
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
    }
    public Animals(){

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
