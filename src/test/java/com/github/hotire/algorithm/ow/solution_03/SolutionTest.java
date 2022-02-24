package com.github.hotire.algorithm.ow.solution_03;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solution() {
        final Solution solution = new Solution();

        assertThat(solution.solution(new int[] { 3, 2, -2, 5, -3 })).isEqualTo(3);
        assertThat(solution.solution(new int[] { 3, 2, 5, -3, -2 })).isEqualTo(3);
        assertThat(solution.solution(new int[] { 1, 1, 2, -1, 2, -1 })).isEqualTo(1);
        assertThat(solution.solution(new int[] { 1, 2, 3, -4 })).isEqualTo(0);
        assertThat(solution.solution(new int[] { 0, 0, 0, 0 })).isEqualTo(0);
        assertThat(solution.solution(new int[] { 0, 0, 0, 0 })).isEqualTo(0);
        assertThat(solution.solution(new int[] { -1000000000, 1000000000, 0, 0 })).isEqualTo(1000000000);
        assertThat(solution.solution(new int[] { -1000000000, 1000000000, 1, -1 })).isEqualTo(1000000000);
        assertThat(solution.solution(new int[] { 0, 1, 1, -1 })).isEqualTo(1);
    }
}