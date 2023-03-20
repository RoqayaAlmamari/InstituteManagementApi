package com.example.InstituteManagementApi.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Student {
    private static final Logger LOGGER = LoggerFactory.getLogger(Student.class);

    private Long id;        // unique identifier for each student
    private String name;    // name of the student
    private String email;   // email of the student
    private String password;   // password of the student

    public Student() {}

    public Student(String name, String email) {
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
        LOGGER.debug("Name set to: {}", this.name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        // Regex pattern to validate email address
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = pattern.matcher(email.trim());
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email.trim();
        LOGGER.debug("Email set to: {}", this.email);
    }

    public String getPassword() {  // getter method for password
        return password;
    }

    public void setPassword(String password) {  // setter method for password, which encrypts the password using BCrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
        LOGGER.debug("Password set to encrypted value.");
    }
}

