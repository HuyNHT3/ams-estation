package com.example.amsestation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vocabulary {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public final Long id;
    public final String idTopic;
    public final String name;
    public final String partOfSpeech;
    public final String meaning;
    public final String example;

    public Vocabulary() {
        id = null;
        name = null;
        partOfSpeech = null;
        meaning = null;
        example = null;
        idTopic = null;
    }

    public Vocabulary(Long id,String idTopic, String name, String partOfSpeech, String meaning, String example) {
        this.id = id;
        this.name = name;
        this.partOfSpeech = partOfSpeech;
        this.meaning = meaning;
        this.example = example;
        this.idTopic = idTopic;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", partOfSpeech='" + partOfSpeech + '\'' +
                ", meaning='" + meaning + '\'' +
                ", example='" + example + '\'' +
                '}';
    }

}