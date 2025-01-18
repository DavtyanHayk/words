package com.example.wordgame.entity;
import com.example.wordgame.controller.DictionaryController;
import com.example.wordgame.services.DictionaryService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    private String translation;

    public Word() {
    }

    public Word(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

}
