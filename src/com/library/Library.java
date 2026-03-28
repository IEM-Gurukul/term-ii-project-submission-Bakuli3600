package com.library;

import java.util.*;

public class Library {
    private List<Book> books;
    private List<User> users;
    private List<Transaction> transactions;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) return book;
        }
        return null;
    }

    public List<Book> searchBooksByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public User findUserById(String id) {
        for (User user : users) {
            if (user.getId().equalsIgnoreCase(id)) return user;
        }
        return null;
    }

    public boolean issueBook(String userId, String isbn) {
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);

        if (user == null) {
            System.out.println("Error: User not found.");
            return false;
        }
        if (book == null) {
            System.out.println("Error: Book not found.");
            return false;
        }
        if (!book.isAvailable()) {
            System.out.println("Error: Book is already borrowed.");
            return false;
        }
        if (user.getBorrowedCount() >= user.getMaxBorrowLimit()) {
            System.out.println("Error: User has reached borrowing limit.");
            return false;
        }

        book.setAvailable(false);
        user.incrementBorrowed();
        transactions.add(new Transaction(UUID.randomUUID().toString(), userId, isbn, "ISSUE"));
        System.out.println("Success: Book '" + book.getTitle() + "' issued to " + user.getName());
        return true;
    }

    public boolean returnBook(String userId, String isbn) {
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);

        if (user != null && book != null && !book.isAvailable()) {
            book.setAvailable(true);
            user.decrementBorrowed();
            transactions.add(new Transaction(UUID.randomUUID().toString(), userId, isbn, "RETURN"));
            System.out.println("Success: Book '" + book.getTitle() + "' returned by " + user.getName());
            return true;
        }
        System.out.println("Error: Invalid return operation.");
        return false;
    }

    public void showAllBooks() {
        System.out.println("\n--- Current Book Inventory ---");
        for (Book book : books) System.out.println(book);
    }

    public void showAllUsers() {
        System.out.println("\n--- Registered Library Users ---");
        for (User user : users) System.out.println(user);
    }

    public void showHistory() {
        System.out.println("\n--- Transaction History Log ---");
        if (transactions.isEmpty()) System.out.println("No records found.");
        else for (Transaction t : transactions) System.out.println(t);
    }
}
