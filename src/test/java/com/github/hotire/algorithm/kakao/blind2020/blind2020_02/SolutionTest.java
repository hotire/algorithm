package com.github.hotire.algorithm.kakao.blind2020.blind2020_02;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("provideTextOfBracket")
    void solution(final String text, final String expected) {
        // When
        final Solution solution = new Solution();

        // When
        final String result = solution.solution(text);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTextOfBracket() {
        return Stream.of(
                Arguments.of("(()())()", "(()())()"),
                Arguments.of(")(", "()"),
                Arguments.of("()))((()", "()(())()"),
                Arguments.of(")()()()(", "(((())))"),
                Arguments.of(")))(((", "()(())")
        );
    }
}