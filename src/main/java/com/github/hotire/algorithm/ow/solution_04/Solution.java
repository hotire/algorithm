package com.github.hotire.algorithm.ow.solution_04;

import java.util.Arrays;

public class Solution {
    // 1, 3, 5, 7, // 0, 0, 1, 4, 6
    public int solution(final int[] A, final int[] B) {
        final int n = A.length;
        final int m = B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        // i -> B의 인덱스 , k -> A의 인덱스
        int i = 0;
        for (int k = 0; k < n && !(i == m - 1 && B[i] < A[k]); ) {
            if (i < m - 1 && B[i] < A[k]) {
                i += 1;
            }
            if (A[k] == B[i]) {
                return A[k];
            }
            if (B[i] >= A[k]) {
                k++;
            }
        }

        return -1;
    }
}
