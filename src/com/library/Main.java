package com.library;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        prepopulateData(library);

        while (true) {
            displayMenu();
            int choice = getIntInput(scanner);
            
            if (choice == 8) {
                System.out.println("Thank you for using the Library Management System!");
                break;
            }

            handleMenuChoice(choice, library, scanner);
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===============================");
        System.out.println("   LIBRARY MANAGEMENT SYSTEM   ");
        System.out.println("===============================");
        System.out.println("1. Add a New Book");
        System.out.println("2. Register a New User");
        System.out.println("3. Show Full Inventory");
        System.out.println("4. Show Registered Users");
        System.out.println("5. Search Books by Title");
        System.out.println("6. Issue a Book (Borrow)");
        System.out.println("7. Return a Book");
        System.out.println("8. Exit Application");
        System.out.print("Please select an option (1-8): ");
    }

    private static void handleMenuChoice(int choice, Library lib, Scanner sc) {
        switch (choice) {
            case 1:
                System.out.print("Title: "); String t = sc.nextLine();
                System.out.print("Author: "); String a = sc.nextLine();
                System.out.print("ISBN: "); String i = sc.nextLine();
                lib.addBook(new Book(t, a, i));
                System.out.println("Book added successfully.");
                break;
            case 2:
                System.out.print("User ID: "); String uid = sc.nextLine();
                System.out.print("Name: "); String n = sc.nextLine();
                System.out.print("Type (1 for Student, 2 for Librarian): ");
                int type = getIntInput(sc);
                if (type == 1) lib.addUser(new Student(uid, n));
                else if (type == 2) lib.addUser(new Librarian(uid, n));
                else System.out.println("Invalid type choice.");
                break;
            case 3: lib.showAllBooks(); break;
            case 4: lib.showAllUsers(); break;
            case 5:
                System.out.print("Enter partial title to search: ");
                String query = sc.nextLine();
                List<Book> found = lib.searchBooksByTitle(query);
                if (found.isEmpty()) System.out.println("No matching books found.");
                else for (Book b : found) System.out.println(b);
                break;
            case 6:
                System.out.print("User ID: "); String bUid = sc.nextLine();
                System.out.print("Book ISBN: "); String bIsbn = sc.nextLine();
                lib.issueBook(bUid, bIsbn);
                break;
            case 7:
                System.out.print("User ID: "); String rUid = sc.nextLine();
                System.out.print("Book ISBN: "); String rIsbn = sc.nextLine();
                lib.returnBook(rUid, rIsbn);
                break;
            default: System.out.println("Option not recognized.");
        }
    }

    private static void prepopulateData(Library lib) {
        lib.addBook(new Book("Clean Code", "Robert Martin", "ISBN01"));
        lib.addBook(new Book("Introduction to Algorithms", "CLRS", "ISBN02"));
        lib.addBook(new Book("Effective Java", "Joshua Bloch", "ISBN03"));
        lib.addUser(new Student("S101", "Alice Student"));
        lib.addUser(new Librarian("L505", "Bob Librarian"));
    }

    private static int getIntInput(Scanner sc) {
        try {
            int input = sc.nextInt();
            sc.nextLine(); 
            return input;
        } catch (InputMismatchException e) {
            sc.nextLine(); 
            return -1;
        }
    }
}
