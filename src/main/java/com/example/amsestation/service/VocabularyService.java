package com.example.amsestation.service;

import com.example.amsestation.dto.VocabularyDTO;
import com.example.amsestation.dto.response.VocabularyResponseDTO;
import com.example.amsestation.entities.Vocabulary;
import com.example.amsestation.model.VocabularyRepository;
import com.example.amsestation.util.constant.VocabularySearchKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VocabularyService {
    @Autowired
    VocabularyRepository vocabularyRepository;

    public VocabularyResponseDTO getAllVocabulary() {
        List<Vocabulary> vocabularies = (List<Vocabulary>) vocabularyRepository.findAll();
        List<VocabularyDTO> vocabularyDTOS = new ArrayList<>();
        VocabularyResponseDTO vocabularyResponseDTO = new VocabularyResponseDTO();

        for (Vocabulary item : vocabularies) {
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
        if (vocabularyOpt.isPresent()) {
            vocabulary = vocabularyOpt.get();
        }
        return vocabulary;
    }

    public VocabularyResponseDTO searchVocabulary(String searchBy, String searchValue) {
        List<Vocabulary> vocabularies = new ArrayList<>();
        List<VocabularyDTO> vocabularyDTOS = new ArrayList<>();
        VocabularyResponseDTO vocabularyResponseDTO = new VocabularyResponseDTO();

        if (!getSearchKey().contains(searchBy)) {
            vocabularyResponseDTO.setErrorMessage("Error when searching by: " + searchBy);
            return vocabularyResponseDTO;
        }


        try {
            //search by id
            if (searchBy.equals(VocabularySearchKey.id.toString())) {
                Long id = Long.valueOf(searchValue);
                Optional<Vocabulary> vocabularyOpt = vocabularyRepository.findById(id);
                if (vocabularyOpt.isPresent()) {
                    Vocabulary vocabulary = vocabularyOpt.get();
                    VocabularyDTO vocabularyDTO = new VocabularyDTO(
                            vocabulary.id,
                            vocabulary.idTopic,
                            vocabulary.name,
                            vocabulary.partOfSpeech,
                            vocabulary.meaning,
                            vocabulary.example
                    );
                    vocabularyDTOS.add(vocabularyDTO);
                    vocabularyResponseDTO.setVocabularyList(vocabularyDTOS);
                    vocabularyResponseDTO.setErrorMessage("");
                }
            }

            //search by name
            if (searchBy.equals(VocabularySearchKey.name.toString())) {
                List<Vocabulary> vocabularyList = vocabularyRepository.findByName(searchValue);
                for (Vocabulary vocabulary : vocabularyList) {
                    VocabularyDTO vocabularyDTO = new VocabularyDTO(
                            vocabulary.id,
                            vocabulary.idTopic,
                            vocabulary.name,
                            vocabulary.partOfSpeech,
                            vocabulary.meaning,
                            vocabulary.example
                    );
                    vocabularyDTOS.add(vocabularyDTO);
                }
                vocabularyResponseDTO.setVocabularyList(vocabularyDTOS);
                vocabularyResponseDTO.setErrorMessage("");
            }
        } catch (Exception e) {
            vocabularyResponseDTO.setErrorMessage(
                    "Error when searching by: " + searchBy + ", " + e.getMessage()
            );
            return vocabularyResponseDTO;
        }
        return vocabularyResponseDTO;
    }

    public Vocabulary addNewVocabulary(Vocabulary vocabulary) {
        return vocabularyRepository.save(vocabulary);
    }

    public String deleteAVocabulary(Long vocabularyId) {
        vocabularyRepository.deleteById(vocabularyId);
        Optional<Vocabulary> vocabulary = vocabularyRepository.findById(vocabularyId);
        if (vocabulary.isEmpty()) {
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

    private Set<String> getSearchKey() {
        Set<String> searchKey = new HashSet<>();
        searchKey.add("id");
        searchKey.add("idTopic");
        searchKey.add("name");
        searchKey.add("partOfSpeech");
        searchKey.add("meaning");
        searchKey.add("example");
        return searchKey;
    }
}
