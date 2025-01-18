package com.example.wordgame.controller;

import com.example.wordgame.services.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @Autowired
    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/api/translate")
    public String getDefinition(@RequestParam("word") String word) {
        return dictionaryService.getTranslation(word);
    }
    public String getTranslation(String word) {
        return dictionaryService.getTranslation(word);
    }
}
