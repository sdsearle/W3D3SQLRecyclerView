package com.example.admin.w3d3sqlrecyclerview;

/**
 * Created by admin on 9/13/2017.
 */

public class Animal {
    String name, type;
    int age, weight, id;
    int img1, img2;

    public Animal(int id, String name, String type, int age, int weight, int img1, int img2) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.weight = weight;
        this.id = id;
        this.img1 = img1;
        this.img2 = img2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }
}
