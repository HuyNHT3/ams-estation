package com.example.amsestation.controller;

import com.example.amsestation.dto.response.VocabularyResponseDTO;
import com.example.amsestation.entities.Vocabulary;
import com.example.amsestation.service.VocabularyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/vocabulary")
public class VocabularyController {
    @Autowired
    VocabularyService vocabularyService;
    @GetMapping("/all")
    @ResponseBody
    public VocabularyResponseDTO getAllVocabulary () {
        return  vocabularyService.getAllVocabulary();
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity addNewVocabulary (@RequestBody Vocabulary vocabulary) {
        try {
            if(
                    StringUtils.isBlank(vocabulary.name) ||
                            StringUtils.isBlank(vocabulary.idTopic) ||
                            StringUtils.isBlank(vocabulary.partOfSpeech) ||
                            StringUtils.isBlank(vocabulary.meaning)
            ) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing name, idTopic, partOfSpeech or meaning of vocabulary");
            }
            Vocabulary savedVocabulary = vocabularyService.addNewVocabulary(vocabulary);
            return ResponseEntity.status(HttpStatus.OK).body(savedVocabulary);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when saving a vocabulary: " + e.getMessage());
        }

    }

    @DeleteMapping({"delete/{vocabularyId}"})
    public ResponseEntity deleteAVocabulary (@PathVariable("vocabularyId") Long vocabularyId) {
        Vocabulary vocabulary = vocabularyService.findByVocabularyId(vocabularyId);
        try {
            if(
                 Objects.isNull(vocabularyId)
            ) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing vocabularyId");
            }
           if (Objects.isNull(vocabulary)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot find the vocabulary with id: " + vocabularyId);
            }

           String message = vocabularyService.deleteAVocabulary(vocabularyId);
           return ResponseEntity.status(HttpStatus.OK).body(message);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when saving a vocabulary: " + e.getMessage());
        }

    }
}
