package com.dev.ict.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.ict.service.WordsRelayService;

@RestController
@RequestMapping("/api/group")
public class WordsRelayRestController { 
    private final WordsRelayService wordsRelayService;

    public WordsRelayRestController(WordsRelayService wordsRelayService){
        this.wordsRelayService = wordsRelayService;
    }

    @PostMapping("/words-relay")
    public ResponseEntity<Void> wordsRelay(){
        
        return null;
    }

}
