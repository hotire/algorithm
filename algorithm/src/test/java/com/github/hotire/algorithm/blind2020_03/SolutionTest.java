package com.github.hotire.algorithm.blind2020_03;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author : hotire
 */
class SolutionTest {

  @Test
  void solution() {
    // Given
    final int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    final int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
    final Solution solution = new Solution();

    // When
    final boolean result = solution.solution(key, lock);

    // Then
    assertThat(result).isTrue();
  }
}