package com.github.hotire.algorithm.base.src.base;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AlgorithmUtilsTest {

    @Test
    void lowerBoundSearch() {
        // expected
        assertThat(AlgorithmUtils.getInstance().lowerBoundSearch(new int[] { 1, 5, 5, 7}, 5)).isEqualTo(1);
        assertThat(AlgorithmUtils.getInstance().lowerBoundSearch(new int[] {1, 3, 5, 7, 7}, 5)).isEqualTo(2);
        assertThat(AlgorithmUtils.getInstance().lowerBoundSearch(new int[] {1, 2, 3, 5, 7, 9, 11, 15}, 5)).isEqualTo(3);
    }
}