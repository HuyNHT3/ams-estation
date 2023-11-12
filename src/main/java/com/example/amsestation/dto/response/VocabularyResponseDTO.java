package com.example.amsestation.dto.response;

import com.example.amsestation.dto.VocabularyDTO;

import java.util.List;

public class VocabularyResponseDTO {
    private List<VocabularyDTO> vocabularies;

    public VocabularyResponseDTO() {
    }


    public List<VocabularyDTO> getVocabularyList() {
        return vocabularies;
    }

    public void setVocabularyList(List<VocabularyDTO> vocabularies) {
        this.vocabularies = vocabularies;
    }
}
