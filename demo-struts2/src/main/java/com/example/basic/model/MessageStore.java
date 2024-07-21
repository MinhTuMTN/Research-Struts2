package com.example.basic.model;

import lombok.Getter;

@Getter
public class MessageStore {
    private final String message;

    public MessageStore() {
        message = "Hello Struts User";
    }

    public MessageStore(String message) {
        this.message = message;
    }

}
