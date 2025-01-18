package com.example.wordgame.controller;

import com.example.wordgame.entity.Word;
import com.example.wordgame.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WordController {
    @Autowired
    private WordRepository wordRepository;
    @Autowired
    private DictionaryController dictionaryController;

    @GetMapping("/")
    public String getTasks(Model model) {
        List<Word> words = wordRepository.findAll();
        model.addAttribute("words", words);
        return "index";
    }

    @GetMapping("/addForm")
    public String goToAddForm() {
        return "addForm";
    }

    @PostMapping("/add")
    public String add(@RequestParam("word") String word) {
        wordRepository.save(new Word(word, dictionaryController.getTranslation(word)));
        return "addForm";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("wordId") Long id) {
        wordRepository.deleteById(id);
        return "redirect:/";
    }

}
