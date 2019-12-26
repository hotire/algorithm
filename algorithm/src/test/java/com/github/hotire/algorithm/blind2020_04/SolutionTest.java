package com.github.hotire.algorithm.blind2020_04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * @author : hotire
 */
class SolutionTest {

  @Test
  void solution() {
    final String[] words = {"frodo", "front", "frost", "frozen","frame" , "kakao"};
    final String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
    final Solution solution = new Solution();

    final int[] result = solution.solution(words, queries);

    System.out.println(Arrays.toString(result));
  }
}