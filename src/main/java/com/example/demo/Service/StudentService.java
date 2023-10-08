package com.example.demo.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // Create a new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Retrieve a student by ID
    public Optional<Student> getStudentById(String studentId) {
        return studentRepository.findById(studentId);
    }

    // Retrieve all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Update a student
    public Student updateStudent(String studentId, Student updatedStudent) {
        if (studentRepository.existsById(studentId)) {
            updatedStudent.setID(studentId);
            return studentRepository.save(updatedStudent);
        } else {
            // Handle not found or other appropriate error handling
            return null;
        }
    }

    // Delete a student by ID
    public void deleteStudent(String studentId) {
        studentRepository.deleteById(studentId);
    }
}
