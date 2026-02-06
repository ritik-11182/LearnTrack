package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class EnrollmentMenu {

    public static void show(
            Scanner sc,
            EnrollmentService enrollmentService,
            StudentService studentService,
            CourseService courseService) throws EntityNotFoundException {

        while (true) {
            System.out.println("\n--- ENROLLMENT MANAGEMENT ---");
            System.out.println("1. Enroll Student");
            System.out.println("2. View Enrollments by Student");
            System.out.println("3. Mark Completed");
            System.out.println("4. Cancel Enrollment");
            System.out.println("0. Back");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Student ID: ");
                    int sid = Integer.parseInt(sc.nextLine());
                    System.out.print("Course ID: ");
                    int cid = Integer.parseInt(sc.nextLine());

                    studentService.findById(sid);
                    courseService.findById(cid);

                    enrollmentService.enrollStudent(sid, cid);
                    System.out.println("Enrollment successful.");
                }
                case 2 -> {
                    System.out.print("Student ID: ");
                    enrollmentService.getEnrollmentsByStudent(
                                    Integer.parseInt(sc.nextLine()))
                            .forEach(e -> System.out.println(
                                    e.getId() + " Course:" + e.getCourseId()
                                            + " Status:" + e.getStatus()));
                }
                case 3 -> {
                    System.out.print("Enrollment ID: ");
                    enrollmentService.updateEnrollmentStatus(
                            Integer.parseInt(sc.nextLine()), EnrollmentStatus.COMPLETED);
                }
                case 4 -> {
                    System.out.print("Enrollment ID: ");
                    enrollmentService.updateEnrollmentStatus(
                            Integer.parseInt(sc.nextLine()), EnrollmentStatus.CANCELLED);
                }
                case 0 -> { return; }
            }
        }
    }
}
