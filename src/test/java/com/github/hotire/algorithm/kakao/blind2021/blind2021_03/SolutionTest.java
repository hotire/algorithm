package com.github.hotire.algorithm.kakao.blind2021.blind2021_03;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                             new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"},
                             new int[]{1,1,1,1,2,4})
        );
    }


    @ParameterizedTest
    @MethodSource("provideTest")
    void solution(String[] info, String[] query, int[] expected) {
        // given
        final Solution solution = new Solution();

        // when
        final int[] result = solution.solution(info, query);

        // then
        assertThat(result).isEqualTo(expected);
    }
}