package com.odx.test.service;

import com.odx.test.model.LongestPalindrome;
import com.odx.test.repository.PalindromicSubStringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PalindromicSubStringService {

    @Autowired
    PalindromicSubStringRepository repository;

    public void insertPalindromicSubString(String input) {
        LongestPalindrome palindrome = new LongestPalindrome();
        palindrome.setId(1);
        palindrome.setName(findLongestPalindrome(input));
        repository.save(palindrome);
    }

    public String getLongestPalindrome() {
        Optional<LongestPalindrome> optional = repository.findById(1);
        if (optional.isPresent()) {
            return optional.get().getName();
        }
        return "";
    }

    public String findLongestPalindrome(String input) {

        if (input == null || input.length() < 1) return "";
        int begin = 0, last = 0;
        for (int i = 0; i < input.length(); i++) {
            int a = expand(input, i, i);
            int b = expand(input, i, i + 1);
            int length = Math.max(a, b);
            if (length > last - begin) {
                begin = i - (length - 1) / 2;
                last = i + length / 2;
            }
        }
        return input.substring(begin, last + 1);
    }

    private int expand(String input, int first, int last) {
        char[] chars = input.toCharArray();
        int left = first, right = last;
        while (left >= 0 && right < input.length() && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
