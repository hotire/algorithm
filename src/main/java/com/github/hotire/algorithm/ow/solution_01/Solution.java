package com.github.hotire.algorithm.ow.solution_01;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;

public class Solution {

    public String solution(final int U, final int L, final int[] C) {
        final int[][] result = new int[2][C.length];

        if (dfs(result, C, U, L, -1)) {
            final StringBuilder sb = new StringBuilder();
            return sb.append(Arrays.stream(result[0])
                                   .mapToObj(String::valueOf)
                                   .collect(joining()))
                     .append(",")
                     .append(Arrays.stream(result[1])
                                   .mapToObj(String::valueOf)
                                   .collect(joining()))
                     .toString();
        } else {
            return "IMPOSSIBLE";
        }
    }

    public boolean dfs(final int[][] result, final int[] C, final int U, final int L, final int index) {
        if (index == C.length - 1) {
            if (Arrays.stream(result[0]).sum() == U && Arrays.stream(result[1]).sum() == L) {
                return true;
            } else {
                result[0][index] = 0;
                result[1][index] = 0;
                return false;
            }
        }

        for (int i = index + 1; i < C.length; i++) {
            if (C[i] == 2) {
                result[1][i] = 1;
                result[0][i] = 1;
                if (dfs(result, C, U, L, i)) {
                    return true;
                }
            } else if (C[i] == 0) {
                if (dfs(result, C, U, L, i)) {
                    return true;
                }
            } else {
                result[0][i] = 1;
                if (dfs(result, C, U, L, i)) {
                    return true;
                }
                result[1][i] = 1;
                if (dfs(result, C, U, L, i)) {
                    return true;
                }
            }
        }

        return false;
    }

}
