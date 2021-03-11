package com.github.hotire.algorithm.naver.fi_2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.hotire.algorithm.naver.n_2021.algo_02.Solution;

class SolutionTest {

    @Test
    void solution() {
        // given
        final Solution solution = new Solution();

        // then
        Assertions.assertThat(solution.solution(new int[]{1, 3, 2, 1}, new int[]{4, 2, 5, 3, 2})).isEqualTo(2);
        Assertions.assertThat(solution.solution(new int[]{2, 1}, new int[]{3, 3})).isEqualTo(-1);
        Assertions.assertThat(solution.solution(new int[]{1, 3, 5, 7}, new int[]{0, 0, 1, 4, 6})).isEqualTo(1);
    }

    @Test
    void solution2() {
        // given
        final Solution solution = new Solution();

        // then
        Assertions.assertThat(solution.solution2(new int[]{1, 3, 2, 1}, new int[]{4, 2, 5, 3, 2})).isEqualTo(2);
        Assertions.assertThat(solution.solution2(new int[]{2, 1}, new int[]{3, 3})).isEqualTo(-1);
        Assertions.assertThat(solution.solution2(new int[]{1, 3, 5, 7}, new int[]{0, 0, 1, 4, 6})).isEqualTo(1);
        Assertions.assertThat(solution.solution2(new int[]{2, 1}, new int[]{3, 3})).isEqualTo(-1);
    }
}