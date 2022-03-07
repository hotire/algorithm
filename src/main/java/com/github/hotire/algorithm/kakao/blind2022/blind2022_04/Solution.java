package com.github.hotire.algorithm.kakao.blind2022.blind2022_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    final int[] target = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

    public int[] solution(final int n, final int[] info) {
        final List<int[]> combination = combination(new int[info.length], n, 0, 0, new ArrayList<>());
        final Record empty = new Record(new int[info.length]);
        final Record result = combination.stream()
                                         .map(Record::new)
                                         .reduce(empty, (record, other) -> {
                                             final int sum = compare(other.record, info);
                                             other.sum = sum;
                                             if (sum > 0) {
                                                 if (record.sum > other.sum) {
                                                     return record;
                                                 } else if (record.sum == other.sum) {
                                                     for (int i = target.length - 1; i >= 0; i--) {
                                                         if (record.record[i] < other.record[i]) {
                                                             return other;
                                                         } else if (record.record[i] > other.record[i]) {
                                                             return record;
                                                         }
                                                     }
                                                 } else {
                                                     return other;
                                                 }
                                             }
                                             return record;
                                         });


        if (result == empty) {
            return new int[]{-1};
        }

        return result.record;
    }

    private List<int[]> combination(final int[] combination, final int n, final int cnt, final int idx, final List<int[]> result) {

        if (cnt == n) {
            result.add(Arrays.copyOf(combination, combination.length));
            return result;
        }

        for (int i = idx; i < target.length; i++) {
            combination[target.length - target[i] - 1]++;
            combination(combination, n, cnt + 1, i, result);
            combination[target.length  - target[i] - 1]--;
        }

        return result;
    }

    private int compare(final int[] ryan, final int[] apeach) {
        int sum = 0;
        for (int i = 0; i < ryan.length; i++) {
            if (ryan[i] > apeach[i]) {
                sum += target[i];
            } else if (apeach[i] == 0) {

            } else {
                sum -= target[i];
            }
        }
        return sum;
    }

    public static class Record {
        final int[] record;
        int sum;

        public Record(final int[] record) {
            this.record = record;
        }
    }
}
