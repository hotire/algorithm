package com.github.hotire.algorithm.blind2020_02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author : hotire
 */
class SolutionTest {

  @Test
  void solution() {
    // When
    final Solution solution = new Solution();

    // When
    String result = solution.solution("(()())()");

    // Then
    Assertions.assertThat(result).isEqualTo("(()())()");

    System.out.println(solution.solution(")("));
    System.out.println(solution.solution("(()())()"));
  }
}