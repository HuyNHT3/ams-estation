package com.example.amsestation.dto;

import lombok.Data;

@Data
public class VocabularyDTO {
    private Long id;
    private String idTopic;
    private String name;
    private String partOfSpeech;
    private String meaning;
    private String example;

    public VocabularyDTO(Long id, String idTopic, String name, String partOfSpeech, String meaning, String example) {
        this.id = id;
        this.idTopic = idTopic;
        this.name = name;
        this.partOfSpeech = partOfSpeech;
        this.meaning = meaning;
        this.example = example;
    }

}
