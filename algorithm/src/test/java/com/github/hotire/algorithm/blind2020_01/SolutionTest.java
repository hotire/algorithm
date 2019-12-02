package com.github.hotire.algorithm.blind2020_01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


class SolutionTest {

  @Test
  void solution() {
    // Given
    final String text = "aabbaccc";
    final Solution solution = new Solution();

    // When
    final int length = solution.solution(text);

    // Then
    assertThat(length).isEqualTo(7);
  }
}