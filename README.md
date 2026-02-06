# \# 📘 LearnTrack – Student \& Course Management System

# 

# LearnTrack is a \*\*menu-driven console application\*\* built using \*\*Core Java\*\* to manage:

# 

# \- Students  

# \- Courses  

# \- Trainers  

# \- Enrollments  

# 

# The project focuses on \*\*OOPS fundamentals, SOLID principles, clean architecture\*\*, and \*\*in-memory data management\*\* using repositories.

# 

# ---

# 

# \## ✨ Features

# 

# \### 👩‍🎓 Student Management

# \- Add new student

# \- View all students

# \- Search student by ID

# \- Deactivate student (soft delete)

# 

# \### 📚 Course Management

# \- Add new course

# \- View all courses

# \- Activate / Deactivate course

# 

# \### 🧾 Enrollment Management

# \- Enroll a student into a course

# \- View enrollments for a student

# \- Mark enrollment as COMPLETED or CANCELLED

# 

# ---

# 

# \## 🧱 Architecture Overview

# 

# The application follows a \*\*layered architecture\*\*:



Menu (UI)

↓

Service (Business Logic)

↓

Repository (In-Memory Storage)

↓

Entity (Domain Models)



===

# \### Design Principles

# \- OOPS: Encapsulation, Inheritance, Polymorphism

# \- SOLID Principles

# \- Repository Pattern

# \- Custom Exceptions

# \- Enums instead of magic strings

# 

# ---

# 

# \## 🗂️ Package Structure

# 

com.airtribe.learntrack

│

├── entity // Domain models

├── repository // In-memory data storage

├── service // Business logic

├── menu // Console menus

├── enums // Application enums

├── exception // Custom exceptions

├── util // Constants \& helpers



\## 🧬 Class Diagram



```mermaid

classDiagram

&nbsp;   class Person {

&nbsp;       -int id

&nbsp;       -String firstName

&nbsp;       -String lastName

&nbsp;       -String email

&nbsp;       +getDisplayName()

&nbsp;   }



&nbsp;   class Student {

&nbsp;       -boolean active

&nbsp;       -String batch

&nbsp;       +isActive()

&nbsp;       +deactivate()

&nbsp;   }



&nbsp;   class Trainer {

&nbsp;       -String expertise

&nbsp;       -int experienceInYears

&nbsp;       -boolean active

&nbsp;       +deactivate()

&nbsp;       +getExpertise()

&nbsp;       +getExperienceInYears()

&nbsp;       ++isActive()

&nbsp;   }



&nbsp;   class Course {

&nbsp;       -int id

&nbsp;       -String name

&nbsp;       -String description

&nbsp;       -boolean active

&nbsp;       +activate()

&nbsp;       +deactivate()

&nbsp;   }



&nbsp;   class Enrollment {

&nbsp;       -int id

&nbsp;       -int studentId

&nbsp;       -int courseId

&nbsp;       -LocalDate enrollmentDate

&nbsp;       -EnrollmentStatus status

&nbsp;       +updateStatus()

&nbsp;   }



&nbsp;   class EnrollmentStatus {

&nbsp;       <<enum>>

&nbsp;       ACTIVE

&nbsp;       COMPLETED

&nbsp;       CANCELLED

&nbsp;   }

&nbsp;   %% Inheritance

&nbsp;   Person <|-- Student

&nbsp;   Person <|-- Trainer



&nbsp;   %% Relationships

&nbsp;   Student "1" --> "0..\*" Enrollment : enrolls

&nbsp;   Course  "1" --> "0..\*" Enrollment : has

&nbsp;   Trainer "1" --> "0..\*" Course : teaches



Future Scope:  Include course trainer implementation to complete the relationship shown in class diagram

