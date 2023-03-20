package com.example.InstituteManagementApi.Service;

import com.example.InstituteManagementApi.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private List<Teacher> teachers = new ArrayList<>();
    private Long nextId = 1L;

    // Method to retrieve all teachers
    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    // Method to retrieve a single teacher by ID
    public Teacher getTeacherById(Long id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(id)) {
                return teacher;
            }
        }
        return null;
    }

    // Method to create a new teacher
    public Teacher createTeacher(Teacher teacher) {
        teacher.setId(nextId++);
        teachers.add(teacher);
        return teacher;
    }

    // Method to update an existing teacher by ID
    public Teacher updateTeacher(Long id, Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                teacher.setId(id);
                teachers.set(i, teacher);
                return teacher;
            }
        }
        return null;
    }

    // Method to delete a teacher by ID
    public void deleteTeacher(Long id) {
        teachers.removeIf(teacher -> teacher.getId().equals(id));
    }

    // Method to search for teachers by name
    public List<Teacher> searchTeachers(String name) {
        List<Teacher> result = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(teacher);
            }
        }
        return result;
    }
}
