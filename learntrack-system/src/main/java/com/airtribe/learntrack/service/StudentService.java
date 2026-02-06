package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

import static com.airtribe.learntrack.util.AppConstants.STUDENT_NOT_FOUND;

public class StudentService {

    private final StudentRepository repository = new StudentRepository();

    public void addStudent(String fn, String ln, String email, String batch) {
        Student s = new Student(IdGenerator.nextStudentId(), fn, ln, email, batch);
        repository.save(s);
    }

    public Student findById(int id) throws EntityNotFoundException {
        Student s = repository.findById(id);
        if (s == null) {
            throw new EntityNotFoundException(STUDENT_NOT_FOUND + id);
        }
        return s;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }
    public void deactivateStudent(int id) throws EntityNotFoundException {
        Student student = findById(id);

        if (!student.isActive()) {
            System.out.println("Student is already inactive.");
            return;
        }

        student.deactivate();
        System.out.println("Student deactivated successfully.");
    }
}
