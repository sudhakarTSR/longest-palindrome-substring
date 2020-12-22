package com.odx.test.repository;

import com.odx.test.model.LongestPalindrome;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromicSubStringRepository extends CrudRepository<LongestPalindrome, Integer> {

}