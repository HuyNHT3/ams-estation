package com.example.amsestation.service;

import com.example.amsestation.dto.VocabularyDTO;
import com.example.amsestation.dto.response.VocabularyResponseDTO;
import com.example.amsestation.entities.Vocabulary;
import com.example.amsestation.model.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
