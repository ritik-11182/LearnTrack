package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws EntityNotFoundException {

        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService(studentService,courseService);

        while (true) {
            System.out.println("\n=== LEARNTRACK ===");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("0. Exit");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> StudentMenu.show(sc, studentService);
                case 2 -> CourseMenu.show(sc, courseService);
                case 3 -> EnrollmentMenu.show(sc, enrollmentService, studentService, courseService);
                case 0 -> System.exit(0);
            }
        }
    }
}
