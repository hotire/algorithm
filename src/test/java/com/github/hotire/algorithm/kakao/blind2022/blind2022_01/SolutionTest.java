package com.github.hotire.algorithm.kakao.blind2022.blind2022_01;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SolutionTest {

    @TestFactory
    Stream<DynamicTest> solution() {
        class TestCase {
            private final String[] ids;
            private final String[] report;
            private final int k;
            private final int[] result;

            TestCase(final String[] ids, final String[] report, final int k, final int[] result) {
                this.ids = ids;
                this.report = report;
                this.k = k;
                this.result = result;
            }
        }
        final Solution solution = new Solution();

        return Stream.of(
                new TestCase(new String[] { "muzi", "frodo", "apeach", "neo"}, new String[] { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2, new int[] { 2,1,1,0 }),
                new TestCase(new String[] { "con", "ryan"}, new String[] { "ryan con", "ryan con", "ryan con", "ryan con" }, 3, new int[] { 0, 0 })
        ).map(testCase -> DynamicTest.dynamicTest("solution", () -> {
            // given
            final String[] ids = testCase.ids;
            final String[] report = testCase.report;
            final int k = testCase.k;

            // when
            final int[] result = solution.solution(ids, report, k);

            // then
            assertThat(result).isEqualTo(testCase.result);
        }));
    }
}