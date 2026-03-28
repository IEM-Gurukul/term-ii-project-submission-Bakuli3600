package com.library;

public class Librarian extends User {
    public Librarian(String id, String name) {
        super(id, name);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 10;
    }
}
