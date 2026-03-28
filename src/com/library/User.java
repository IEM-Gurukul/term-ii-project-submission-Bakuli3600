package com.library;

public abstract class User {
    private String id;
    private String name;
    private int borrowedCount;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedCount = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public void incrementBorrowed() {
        borrowedCount++;
    }

    public void decrementBorrowed() {
        if (borrowedCount > 0) borrowedCount--;
    }

    public abstract int getMaxBorrowLimit();

    @Override
    public String toString() {
        return String.format("[%s] %-15s | Type: %-10s | Borrowed: %d/%d", 
            id, name, this.getClass().getSimpleName(), borrowedCount, getMaxBorrowLimit());
    }
}
