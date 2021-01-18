package cz.educanet.web;

public class Animals {

    private String name;
    private Integer age;
    private Integer weight;
    private String gender;

    public Animals(String name, Integer age, Integer weight, String gender) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
