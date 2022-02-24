package com.github.hotire.algorithm.ow.solution_01;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solution() {
        // given
        System.out.println(new Solution().solution(3, 2, new int[] { 2, 1, 1, 0, 1 }));
        System.out.println(new Solution().solution(2, 3, new int[] { 0, 0, 1, 1, 2 }));
        System.out.println(new Solution().solution(2, 2, new int[] { 2, 0, 2, 0 }));
    }
}