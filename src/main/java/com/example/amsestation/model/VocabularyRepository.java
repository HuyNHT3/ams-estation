package com.example.amsestation.model;

import com.example.amsestation.entities.Vocabulary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VocabularyRepository extends CrudRepository<Vocabulary, Long> {
    Vocabulary findById(long id);
    List<Vocabulary> findByName(String name);
    List<Vocabulary> findByPartOfSpeech(String partOfSpeech);
}
