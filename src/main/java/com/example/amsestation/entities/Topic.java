package com.example.amsestation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private final Long id;
    private final String name;
    private final String note;

    public Topic() {
        this.id = null;
        this.name = null;
        this.note = null;
    }

    public Topic(Long id, String name, String note) {
        this.id = id;
        this.name = name;
        this.note = note;
    }
}
