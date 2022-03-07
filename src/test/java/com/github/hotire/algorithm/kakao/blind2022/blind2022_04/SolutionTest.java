package com.github.hotire.algorithm.kakao.blind2022.blind2022_04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solution() {
        final Solution solution = new Solution();
        final int[] result = solution.solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0});

        System.out.println(Arrays.toString(result));
    }
}