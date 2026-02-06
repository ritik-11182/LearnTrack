package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class StudentMenu {

    public static void show(Scanner sc, StudentService service) throws EntityNotFoundException {
        while (true) {
            System.out.println("\n--- STUDENT MANAGEMENT ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("0. Back");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("First Name: ");
                    String fn = sc.nextLine();
                    System.out.print("Last Name: ");
                    String ln = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Batch: ");
                    String batch = sc.nextLine();
                    service.addStudent(fn, ln, email, batch);
                    System.out.println("Student added.");
                }
                case 2 -> service.getAllStudents()
                        .forEach(s -> System.out.println(s.getDisplayName()));
                case 3 -> {
                    System.out.print("ID: ");
                    System.out.println(service.findById(
                            Integer.parseInt(sc.nextLine())).getDisplayName());
                }
                case 4 -> {
                    System.out.print("ID: ");
                    service.deactivateStudent(Integer.parseInt(sc.nextLine()));
                    System.out.println("Student deactivated.");
                }
                case 0 -> {
                    return;
                }
            }
        }
    }
}
