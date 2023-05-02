package com.example.a77simpleintentexplicit;

import java.io.Serializable;

public class Student implements Serializable {
    String fullName;
    int birthYear;

    public Student(String fullName, int birthYear) {
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public String getFullName() {
        return fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }
}
