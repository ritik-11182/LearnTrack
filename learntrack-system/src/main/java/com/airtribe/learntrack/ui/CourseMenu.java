package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.service.CourseService;

import java.util.Scanner;

public class CourseMenu {

    public static void show(Scanner sc, CourseService service) {
        while (true) {
            System.out.println("\n--- COURSE MANAGEMENT ---");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Activate Course");
            System.out.println("4. Deactivate Course");
            System.out.println("0. Back");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    service.addCourse(name, desc);
                }
                case 2 -> service.getAllCourses()
                        .forEach(c -> System.out.println(
                                c.getId() + " " + c.getName() + " Active:" + c.isActive()));
                case 3 -> {
                    System.out.print("ID: ");
                    service.activateCourse(Integer.parseInt(sc.nextLine()));
                }
                case 4 -> {
                    System.out.print("ID: ");
                    service.deactivateCourse(Integer.parseInt(sc.nextLine()));
                }
                case 0 -> { return; }
            }
        }
    }
}
