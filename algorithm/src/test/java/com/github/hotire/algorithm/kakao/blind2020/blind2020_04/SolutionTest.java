package com.github.hotire.algorithm.kakao.blind2020.blind2020_04;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


class SolutionTest {

  @Test
  void solution() {
    final int[] expected = {3, 2, 4, 1, 0};
    final String[] words = {"frodo", "front", "frost", "frozen","frame" , "kakao"};
    final String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
    final Solution solution = new Solution();

    final int[] result = solution.solution(words, queries);

    assertThat(result).isEqualTo(expected);
  }
}