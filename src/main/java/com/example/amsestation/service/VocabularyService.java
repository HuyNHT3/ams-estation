package com.example.amsestation.service;

import com.example.amsestation.dto.VocabularyDTO;
import com.example.amsestation.dto.response.VocabularyResponseDTO;
import com.example.amsestation.entities.Vocabulary;
import com.example.amsestation.model.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VocabularyService {
    @Autowired
    VocabularyRepository vocabularyRepository;

    public VocabularyResponseDTO getAllVocabulary (){
        List<Vocabulary> vocabularies = (List<Vocabulary>) vocabularyRepository.findAll();
        List<VocabularyDTO> vocabularyDTOS = new ArrayList<>();
        VocabularyResponseDTO vocabularyResponseDTO = new VocabularyResponseDTO();

        for (Vocabulary item: vocabularies) {
             vocabularyDTOS.add(
                     new VocabularyDTO(
                             item.id,
                             item.idTopic,
                             item.name,
                             item.partOfSpeech,
                             item.meaning,
                             item.example)
             );
        }
        vocabularyResponseDTO.setVocabularyList(vocabularyDTOS);
        return vocabularyResponseDTO;
    }

    public Vocabulary findByVocabularyId(Long vocabularyId) {
        Optional<Vocabulary> vocabularyOpt = vocabularyRepository.findById(vocabularyId);
        Vocabulary vocabulary = new Vocabulary();
        if(vocabularyOpt.isPresent()) {
            vocabulary = vocabularyOpt.get();
        }
        return vocabulary;
    }

    public Vocabulary addNewVocabulary (Vocabulary vocabulary) {
        return vocabularyRepository.save(vocabulary);
    }

    public String deleteAVocabulary(Long vocabularyId) {
        vocabularyRepository.deleteById(vocabularyId);
        Optional<Vocabulary> vocabulary = vocabularyRepository.findById(vocabularyId);
        if(vocabulary.isEmpty()) {
            return "Deleted successfully a vocabulary with id: " + vocabularyId;
        }
        return "Problem when deleting a vocabulary with id: " + vocabularyId;
    }

    public String UpdateAVocabulary(Vocabulary vocabulary) {
        vocabularyRepository.updateAVocabulary(
                vocabulary.id,
                vocabulary.idTopic,
                vocabulary.name,
                vocabulary.partOfSpeech,
                vocabulary.meaning,
                vocabulary.example);
        return "Update a vocabulary Successfully";
    }
}
