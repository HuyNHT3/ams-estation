package com.example.amsestation.controller;

import com.example.amsestation.dto.response.VocabularyResponseDTO;
import com.example.amsestation.entities.Vocabulary;
import com.example.amsestation.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Vocabulary addNewVocabulary (@RequestBody Vocabulary vocabulary) {
        return  vocabularyService.addNewVocabulary(vocabulary);
    }
}
