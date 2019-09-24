package com.example.basic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class student {
    public void setId(UUID id) {
        this.id = id;
    }

    private  UUID id;
    private final int age;
    private final String firstname;
    private final String lastname;
    private final String course;

    public UUID getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCourse() {
        return course;
    }

    public student(
            @JsonProperty("id") UUID id,
            @JsonProperty("age") int age,
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastname") String lastname,
            @JsonProperty("course") String course) {
        this.id = id;
        this.age = age;
        this.firstname = firstname;
        this.lastname = lastname;
        this.course = course;
    }



}