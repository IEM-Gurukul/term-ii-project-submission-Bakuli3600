PCCCS495 – Term II Project
# Library Management System

## Project Title
Library Management System (LMS)

## Problem Statement (max 150 words)
The manual management of library resources is prone to errors, inefficient tracking, and data redundancy. This project implements an automated Library Management System in Java to streamline the process of cataloging books, managing users (Students and Librarians), and tracking borrowing transactions. It ensures data integrity and provides an interactive interface for real-time library operations, replacing outdated paper-based logs with a robust digital solution.

## Target User
- **Librarians:** For administrative control, adding books, and monitoring overall history.
- **Students:** For searching, borrowing, and returning books within specified limits.

## Core Features
- **Dynamic Inventory:** Add and search books by title or ISBN.
- **User Management:** Categorized users (Student/Librarian) with distinct permissions.
- **Borrowing Logic:** Automated issue/return system with validation checks.
- **Transaction History:** Persistent logs of all library activities with timestamps.
- **Input Validation:** Robust menu-driven interface with error handling for user inputs.

## OOP Concepts Used
- **Abstraction:** The `User` class is abstract, ensuring no generic user can be created without a specific type (Student or Librarian).
- **Inheritance:** `Student` and `Librarian` classes inherit common attributes and behaviors from the abstract `User` class.
- **Polymorphism:** Overridden the `getMaxBorrowLimit()` method to provide different borrowing rules for different user types.
- **Exception Handling:** Implemented `try-catch` blocks in `Main.java` to handle `InputMismatchException` during user interaction, ensuring application stability.
- **Collections / Threads:** Utilized `java.util.List` and `ArrayList` for dynamic storage of books, users, and transaction records.

## Proposed Architecture Description
The system follows a modular architecture:
- **Models:** `Book`, `User`, `Student`, `Librarian`, and `Transaction` represent the data layer.
- **Service Layer:** `Library.java` contains the business logic for issuing/returning books and searching.
- **Controller/Main:** `Main.java` handles the user interaction loop and input processing.

## How to Run
1. Ensure you have **Java JDK 8+** installed.
2. Open your terminal in the project root directory.
3. Compile the source code:
   ```bash
   javac src/com/library/*.java -d .
   ```
4. Run the application:
   ```bash
   java com.library.Main
   ```

## Git Discipline Notes
- Incremental development with descriptive commit messages.
- Clear separation of features into logical commits.
- Adherence to project structure requirements.
