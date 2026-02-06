package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.List;

import static com.airtribe.learntrack.util.AppConstants.ENROLLMENT_NOT_FOUND;

public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository = new EnrollmentRepository();
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(StudentService studentService,
                             CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void enrollStudent(int studentId, int courseId)
            throws EntityNotFoundException {

        Student student = studentService.findById(studentId);
        Course course = courseService.findById(courseId);

        if (!student.isActive()) {
            throw new IllegalStateException("Inactive student cannot be enrolled.");
        }

        if (!course.isActive()) {
            throw new IllegalStateException("Inactive course cannot accept enrollments.");
        }

        Enrollment enrollment = new Enrollment(
                IdGenerator.nextEnrollmentId(),
                studentId,
                courseId,
                LocalDate.now()
        );

        enrollmentRepository.save(enrollment);
        System.out.println("Student enrolled successfully.");
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId)
            throws EntityNotFoundException {

        studentService.findById(studentId); // validation

        return enrollmentRepository.findByStudentId(studentId);
    }

    public void updateEnrollmentStatus(int studentId,
                                       EnrollmentStatus status)
            throws EntityNotFoundException {

        List<Enrollment> enrollments =
                enrollmentRepository.findByStudentId(studentId);

        if (enrollments.isEmpty()) {
            throw new EntityNotFoundException(ENROLLMENT_NOT_FOUND);
        }

        enrollments.forEach(e -> e.updateStatus(status));
        System.out.println("Enrollment status updated to " + status);
    }
}
