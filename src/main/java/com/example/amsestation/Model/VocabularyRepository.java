package com.example.amsestation.Model;

import com.example.amsestation.Entities.Vocabulary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VocabularyRepository extends CrudRepository<Vocabulary, Long> {
    Vocabulary findById(long id);
    List<Vocabulary> findByName(String name);
    List<Vocabulary> findByPartOfSpeech(String partOfSpeech);
}
