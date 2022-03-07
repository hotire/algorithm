package com.github.hotire.algorithm.kakao.blind2022.blind2022_04;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {

    @TestFactory
    Stream<DynamicTest> solution() {
        class TestCase {
            private final int n;
            private final int[] info;
            private final int[] expected;

            TestCase(final int n, final int[] info, final int[] expected) {
                this.n = n;
                this.info = info;
                this.expected = expected;
            }
        }
        final Solution solution = new Solution();

        return Stream.of(
                new TestCase(5, new int[]{2,1,1,1,0,0,0,0,0,0,0}, new int[]{0,2,2,0,1,0,0,0,0,0,0}),
                new TestCase(1, new int[]{1,0,0,0,0,0,0,0,0,0,0}, new int[]{-1}),
                new TestCase(9, new int[]{0,0,1,2,0,1,1,1,1,1,1}, new int[]{1,1,2,0,1,2,2,0,0,0,0}),
                new TestCase(10, new int[]{0,0,0,0,0,0,0,0,3,4,3}, new int[]{1,1,1,1,1,1,1,1,0,0,2})
        ).map(it -> DynamicTest.dynamicTest("solution", () -> {
            // expected
            assertThat(solution.solution(it.n, it.info)).isEqualTo(it.expected);
        }));
    }
}