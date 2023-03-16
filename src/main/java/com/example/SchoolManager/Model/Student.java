package com.example.SchoolManager.Model;

public class Student {
    private Long id;        // unique identifier for each student
    private String name;    // name of the student
    private String email;   // email of the student

    public Student() {}

    public Student(String name, String email) {  // constructor that takes name and email as parameters
        this.name = name;
        this.email = email;
    }

    public Long getId() {   // getter method for id
        return id;
    }

    public void setId(Long id) {    // setter method for id
        this.id = id;
    }

    public String getName() {   // getter method for name
        return name;
    }

    public void setName(String name) {  // setter method for name
        this.name = name;
    }

    public String getEmail() {  // getter method for email
        return email;
    }

    public void setEmail(String email) {  // setter method for email
        this.email = email;
    }
}
