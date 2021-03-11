package com.github.hotire.algorithm.kakao.blind2021.blind2021_04;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    private static Stream<Arguments> provide()  {
        return Stream.of(Arguments.of(6, 4, 6, 2, new int[][] { {4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25} }, 82),
                         Arguments.of(7, 3, 4, 1, new int[][] { {5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6} }, 14),
                         Arguments.of(6, 4, 5, 6, new int[][] { {2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9} }, 18));
    }

    @MethodSource("provide")
    @ParameterizedTest
    void solution(final int n, final int s, final int a, final int b, final int[][] fares, final int expected) {
        // given
        final Solution solution = new Solution();

        // when
        final int result = solution.solution(n, s, a, b, fares);

        // then
        assertThat(result).isEqualTo(expected);
    }
}