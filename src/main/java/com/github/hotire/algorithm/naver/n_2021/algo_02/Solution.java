package com.github.hotire.algorithm.naver.n_2021.algo_02;

import java.util.Arrays;

public class Solution {
    public int solution2(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n -1;) {
            if (i < m - 1 && B[i] < A[k])
                i += 1;
            else k += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }

    public int solution(int[] A, int[] B) {
       if (A.length < B.length) {
           Arrays.sort(A);
           return Arrays.stream(B)
                 .filter(it -> Arrays.binarySearch(A, it) >= 0)
                 .min()
                 .orElse(-1);
       } else {
           Arrays.sort(B);
           return Arrays.stream(A)
                        .filter(it -> Arrays.binarySearch(B, it) >= 0)
                        .min()
                        .orElse(-1);
       }
    }
}
