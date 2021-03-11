package com.github.hotire.algorithm.naver.fi_2021.algo_03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.hotire.algorithm.naver.n_2021.algo_03.Solution;

class SolutionTest {

    @Test
    void solution() {
        // given
        Solution solution = new Solution();

        // expected
        Assertions.assertThat(solution.solution(new int[]{ 1, 2, -3, 4, 5, -6})).isEqualTo(9);
        Assertions.assertThat(solution.solution(new int[]{-8, 3, 0, 5, -3, 12})).isEqualTo(12);
        Assertions.assertThat(solution.solution(new int[]{-1, 2, 1, 2, 0, 2, 1, -3, 4, 3, 0, -1})).isEqualTo(8);
    }
}