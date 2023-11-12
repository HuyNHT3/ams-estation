package com.example.amsestation.controller;

import com.example.amsestation.dto.response.VocabularyResponseDTO;
import com.example.amsestation.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
