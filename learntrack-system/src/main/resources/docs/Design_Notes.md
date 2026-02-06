# Design Notes

This document explains **design decisions**, **OOPS usage**, and **SOLID principles**
applied in the system.

---

## 🧱 Core Entities

- Person (Base class)
- Student (extends Person)
- Trainer (extends Person)
- Course
- Enrollment (association class)

---

## 🔗 Key Relationships

- Student ↔ Course → via Enrollment
- Trainer → teaches → Course
- Person → base abstraction

---

## 🧬 OOPS Principles Used

### Inheritance
```java
Student extends Person
Trainer extends Person
