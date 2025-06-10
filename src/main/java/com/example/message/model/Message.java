package com.example.message.model;

import jakarta.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String text;

    public Message() {
    }

    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getText(){
        return text;
    }

}