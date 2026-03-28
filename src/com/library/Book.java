package com.library;

/**
 * Represents a library book with title, author, and ISBN details.
 */
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    /**
     * Constructs a new Book object.
     * @param title Title of the book
     * @param author Author of the book
     * @param isbn Unique ISBN code
     */
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s by %s - %s", isbn, title, author, isAvailable ? "Available" : "Borrowed");
    }
}
