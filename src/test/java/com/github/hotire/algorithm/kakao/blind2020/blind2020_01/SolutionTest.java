package com.github.hotire.algorithm.kakao.blind2020.blind2020_01;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class SolutionTest {

  @ParameterizedTest
  @MethodSource("provideText")
  void solution(final String text, final int expected) {
    // Given
    final Solution solution = new Solution();

    // When
    final int length = solution.solution(text);

    // Then
    assertThat(length).isEqualTo(expected);
  }

  private static Stream<Arguments> provideText() {
    return Stream.of(
        Arguments.of("aabbaccc", 7),
        Arguments.of("ababcdcdababcdcd", 9),
        Arguments.of("abcabcdede", 8),
        Arguments.of("abcabcabcabcdededededede", 14),
        Arguments.of("xababcdcdababcdcd", 17)
    );
  }
}