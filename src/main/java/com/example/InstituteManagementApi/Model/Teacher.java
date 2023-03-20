package com.example.InstituteManagementApi.Model;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Teacher {
    private Long id;                // unique identifier for each teacher
    private String name;            // name of the teacher
    private String email;           // email of the teacher
    private String department;      // department the teacher
    private String password;        // password of the teacher

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");  // regular expression for email validation
    private static final Logger logger = LoggerFactory.getLogger(Teacher.class);  // logger for Teacher class

    public Teacher() {
        logger.info("Creating a new instance of Teacher class.");
    }

    public Teacher(String name, String email, String department, String password) {  // constructor that takes name, email, department and password as parameters
        this.name = name;
        setEmail(email);
        this.department = department;
        setPassword(password);
        logger.info("Creating a new instance of Teacher class with name: {}, email: {}, department: {}.", name, email, department);
    }

    public Long getId() {           // getter method for id
        return id;
    }

    public void setId(Long id) {    // setter method for id
        this.id = id;
    }

    public String getName() {       // getter method for name
        return name;
    }

    public void setName(String name) {  // setter method for name
        this.name = name;
    }

    public String getEmail() {      // getter method for email
        return email;
    }

    public void setEmail(String email) {  // setter method for email
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public String getDepartment() {    // getter method for department
        return department;
    }

    public void setDepartment(String department) {  // setter method for department
        this.department = department;
    }

    public String getPassword() {  // getter method for password
        return password;
    }

    public void setPassword(String password) {  // setter method for password, which encrypts the password using BCrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
        logger.info("Password set for Teacher with email: {}.", email);
    }
}
