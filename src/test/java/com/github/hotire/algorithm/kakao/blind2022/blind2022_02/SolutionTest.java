package com.github.hotire.algorithm.kakao.blind2022.blind2022_02;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {

    @TestFactory
    Stream<DynamicTest> solution() {
        class TestCase {
            private final int n;
            private final int k;
            private final int expected;

            TestCase(final int n, final int k, final int expected) {
                this.n = n;
                this.k = k;
                this.expected = expected;
            }
        }
        final Solution solution = new Solution();

        return Stream.of(
                new TestCase(437674, 3, 3),
                new TestCase(110011, 10, 2)
        ).map(it -> DynamicTest.dynamicTest("solution", () -> {
            // expected
            assertThat(solution.solution(it.n, it.k)).isEqualTo(it.expected);
        }));
    }
}