package com.github.hotire.algorithm.kakao.blind2021.blind2021_02;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4}, new String[]{"AC", "ACDE", "BCFG", "CDE"}),
                Arguments.of(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5}, new String[]{"ACD", "AD", "ADE", "CD", "XYZ"})
                Arguments.of(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4}, new String[]{"WX", "XY"})
        );
    }

    @MethodSource
    @ParameterizedTest
    void solution(final String[] orders, final int[] course, final String[] expected) {

    }
}