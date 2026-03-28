package com.library;

import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private String user_id;
    private String isbn;
    private LocalDateTime date;
    private String type;

    public Transaction(String id, String user_id, String isbn, String type) {
        this.id = id;
        this.user_id = user_id;
        this.isbn = isbn;
        this.date = LocalDateTime.now();
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s by User %s", date, type, isbn, user_id);
    }
}
