package com.github.hotire.algorithm.ow.solution_04;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solution() {
        final Solution solution = new Solution();
        assertThat(solution.solution(new int[] { 1, 3, 2, 1, }, new int[] { 4, 2, 5, 3, 2 })).isEqualTo(2);
        assertThat(solution.solution(new int[] { 2, 1 }, new int[] { 3, 3 })).isEqualTo(-1);
        assertThat(solution.solution(new int[] { 4, 1, 1, 1 }, new int[] { 1, 1 })).isEqualTo(1);
        assertThat(solution.solution(new int[] { 0, 0, 0, 1 }, new int[] { 0, 0, 1, 4, 6 })).isEqualTo(0);
        assertThat(solution.solution(new int[] { 0, 0, 0, 1 }, new int[] { 1, 1, 1, 4, 0 })).isEqualTo(0);
        assertThat(solution.solution(new int[] { 1, 1, 1, 4, 0 }, new int[] { 0, 0, 0, 1 })).isEqualTo(0);
        assertThat(solution.solution(new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE }, new int[] { Integer.MAX_VALUE })).isEqualTo(2147483647);
        assertThat(solution.solution(new int[] { 1 }, new int[] { 1 })).isEqualTo(1);
        assertThat(solution.solution(new int[] { 1 }, new int[] { 0 })).isEqualTo(-1);
        assertThat(solution.solution(new int[] { 0 }, new int[] { 1 })).isEqualTo(-1);
        assertThat(solution.solution(new int[] { 0, 1 }, new int[] { 1 })).isEqualTo(1);
        assertThat(solution.solution(new int[] { 0, 0 }, new int[] { 0, 0 })).isEqualTo(0);
        assertThat(solution.solution(new int[] { 1, 1 }, new int[] { 1, 1 })).isEqualTo(1);
        assertThat(solution.solution(new int[] { 1, 1, 0 }, new int[] { 1, 1 })).isEqualTo(1);
        assertThat(solution.solution(new int[] { 1, 1, 0 }, new int[] { 1, 1, 1, 1, 0 })).isEqualTo(0);
    }
}