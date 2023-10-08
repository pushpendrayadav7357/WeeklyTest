package com.example.demo.Service;

import com.example.demo.Entity.Course;
import com.example.demo.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    // Create a new course
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Retrieve a course by ID
    public Optional<Course> getCourseById(String courseId) {
        return courseRepository.findById(courseId);
    }

    // Retrieve all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Update a course
    public Course updateCourse(String courseId, Course updatedCourse) {
        if (courseRepository.existsById(courseId)) {
            updatedCourse.setID(courseId);
            return courseRepository.save(updatedCourse);
        } else {
            // Handle not found or other appropriate error handling
            return null;
        }
    }

    // Delete a course by ID
    public void deleteCourse(String courseId) {
        courseRepository.deleteById(courseId);
    }
}
