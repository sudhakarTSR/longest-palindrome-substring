package com.odx.test.controller;

import com.odx.test.model.LongestPalindrome;
import com.odx.test.service.PalindromicSubStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromicSubStringController {

    @Autowired
    PalindromicSubStringService service;

    @PostMapping("/palindrome/{input}")
    public void insertPalindromicSubString(@PathVariable("input") String input) {
        service.insertPalindromicSubString(input);
    }

    @GetMapping("/palindrome")
    public String getLongestPalindrome() {
        return service.getLongestPalindrome();
    }


}
