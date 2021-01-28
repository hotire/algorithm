package com.github.hotire.algorithm.kakao.coding2021;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.hotire.algorithm.kakao.coding2021.coding2021_01.Solution;

class SolutionTest {

    private static Stream<Arguments> provideTest() {
        return Stream.of(Arguments.of("...!@BaT#*..y.abcdefghijklm", "bat.y.abcdefghi"),
                         Arguments.of( "z-+.^.", "z--"),
                         Arguments.of( "=.=", "aaa"),
                         Arguments.of( "123_.def", "123_.def"),
                         Arguments.of( "abcdefghijklmn.p", "abcdefghijklmn")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTest")
    void test(final String newId, final String expected) {
        // given
        final Solution solution = new Solution();

        // when
        final String result = solution.solution(newId);

        // then
        assertThat(result).isEqualTo(expected);
    }
}