package com.github.hotire.algorithm.kakao.blind2021.blind2021_04;

import java.util.stream.IntStream;

public class Solution {
    public int solution(final int n, final int s, final int a, final int b, final int[][] fares) {
        final int[][] floydWarshall = floydWarshall(n, fares);
        return IntStream.range(0, n)
                        .map(index -> floydWarshall[s - 1][index] + floydWarshall[index][a - 1] + floydWarshall[index][b - 1])
                        .min()
                        .orElseThrow();
    }

    public int[][] floydWarshall(final int n, int graph[][]) {
        final int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            dist[graph[i][0] - 1][graph[i][1] - 1] = graph[i][2];
            dist[graph[i][1] - 1][graph[i][0] - 1] = graph[i][2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = dist[i][k] + dist[k][j];
                    if (sum < dist[i][j] && sum > 0) {
                        dist[i][j] = sum;
                    }
                }
            }
        }
        return dist;
    }
}
