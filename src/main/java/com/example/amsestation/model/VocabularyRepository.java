package com.example.amsestation.model;

import com.example.amsestation.entities.Vocabulary;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VocabularyRepository extends CrudRepository<Vocabulary, Long> {
//    @Modifying
//    @Transactional
//    @Query("select * from Vocabulary v where v.name = :name")
//    Vocabulary findByName(@Param(value="name") String name);
//    List<Vocabulary> findByPartOfSpeech(String partOfSpeech);
    @Modifying
    @Transactional
    @Query("update Vocabulary v " +
           "set v.idTopic = :idTopic, v.name = :name, v.partOfSpeech = :partOfSpeech, v.meaning = :meaning, v.example = :example " +
           "where v.id = :id")
    void updateAVocabulary(
            @Param(value="id") Long id,
            @Param(value="idTopic") String idTopic,
            @Param(value="name") String name,
            @Param(value="partOfSpeech") String partOfSpeech,
            @Param(value="meaning") String meaning,
            @Param(value="example") String example
    );

}
