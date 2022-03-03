package com.github.hotire.algorithm.kakao.blind2022.blind2022_03;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {

    @TestFactory
    Stream<DynamicTest> solution() {
        class TestCase {
            private final int[] fees;
            private final String[] records;
            private final int[] expected;

            TestCase(final int[] fees, final String[] records, final int[] expected) {
                this.fees = fees;
                this.records = records;
                this.expected = expected;
            }
        }
        final Solution solution = new Solution();

        return Stream.of(
                new TestCase(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}, new int[]{14600, 34400, 5000}),
                new TestCase(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"}, new int[]{0, 591}),
                new TestCase(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"}, new int[]{14841})
        ).map(it -> DynamicTest.dynamicTest("solution", () -> {
            // expected
            assertThat(solution.solution(it.fees, it.records)).isEqualTo(it.expected);
        }));
    }
}