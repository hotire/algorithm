package com.github.hotire.algorithm.naver.n_2021.algo_03;

public class Solution {
    int solution(int[] A) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                sum += A[i];
                if (max < sum) {
                    max = sum;
                }
            } else {
                if (max < sum) {
                    max = sum;
                }
                sum = 0;
            }
        }
        return max;
    }
}
