package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

import static com.airtribe.learntrack.util.AppConstants.COURSE_NOT_FOUND;

public class CourseService {

    private final CourseRepository repository = new CourseRepository();

    public void addCourse(String courseName, String desc) {
        Course course = new Course(
                IdGenerator.nextCourseId(),
                courseName,desc
        );
        repository.save(course);
        System.out.println("Course added successfully.");
    }

    public Course findById(int id) throws EntityNotFoundException {
        Course course = repository.findById(id);
        if (course == null) {
            throw new EntityNotFoundException(COURSE_NOT_FOUND + id);
        }
        return course;
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }
    public void activateCourse(int id) {
        repository.findById(id).activate();
    }

    public void deactivateCourse(int id) {
        repository.findById(id).deactivate();
    }
}
