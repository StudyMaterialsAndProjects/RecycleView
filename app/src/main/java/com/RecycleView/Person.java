package com.RecycleView;

public class Person {

    enum GENDER{MALE, FEMALE};

    private String name;
    private String lastname;
    private GENDER gender;
    private String nationality;

    Person(String names,String lastname,GENDER gender,String nationality){
        this.name=names;
        this.lastname=lastname;
        this.gender=gender;
        this.nationality=nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
