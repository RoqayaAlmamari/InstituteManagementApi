package com.example.SchoolManager.Service;

import com.example.SchoolManager.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private Map<Long, Student> students = new HashMap<>();
    private Long nextId = 1L;

    // Get all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    // Get a specific student by ID
    public Student getStudentById(Long id) {
        return students.get(id);
    }

    // Create a new student
    public Student createStudent(Student student) {
        student.setId(nextId);
        students.put(nextId, student);
        nextId++;
        return student;
    }

    // Update an existing student by ID
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = students.get(id);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            students.put(id, existingStudent);
            return existingStudent;
        } else {
            return null;
        }
    }

    // Delete a student by ID
    public void deleteStudent(Long id) {
        students.remove(id);
    }

    // Search for students by name
    public List<Student> searchStudents(String name) {
        List<Student> searchResults = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                searchResults.add(student);
            }
        }
        return searchResults;
    }
}
