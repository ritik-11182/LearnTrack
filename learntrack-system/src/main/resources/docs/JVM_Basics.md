
---

# 📁 docs/JVM_Basics.md

```md
# JVM Basics (Java Virtual Machine)

This document explains JVM concepts relevant to this project.

---

## 🧠 What is JVM?

The JVM is a runtime engine that:
- Executes Java bytecode
- Manages memory
- Handles garbage collection

---

## ⚙️ JVM Architecture

### 1️⃣ Class Loader
- Loads `.class` files into memory
- Follows delegation model

### 2️⃣ Runtime Data Areas
| Area | Purpose |
|----|--------|
| Heap | Stores objects |
| Stack | Method calls & local variables |
| Method Area | Class metadata |
| PC Register | Current instruction |
| Native Stack | Native method calls |

---

## 🧹 Garbage Collection

- Automatically removes unused objects
- Improves memory safety
- Developers don’t manually free memory

---

## 🔄 Why JVM Matters Here

- Menu-driven app heavily uses:
  - Stack (method calls)
  - Heap (Student, Course, Enrollment objects)
- Exceptions propagate via JVM stack
- Polymorphism resolved at runtime

---

## 💡 Key Takeaway

> JVM allows Java code to be platform-independent and memory-safe while supporting OOPS features like inheritance and polymorphism.
