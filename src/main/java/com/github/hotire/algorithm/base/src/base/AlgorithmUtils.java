package com.github.hotire.algorithm.base.src.base;

import java.util.List;

public class AlgorithmUtils {
    private AlgorithmUtils() {
    }

    ;
    private static AlgorithmUtils instance = new AlgorithmUtils();

    public static AlgorithmUtils getInstance() {
        return instance;
    }

    /**
     *
     * @author : hoTire
     * @comment : 다음 순열
     * @param a
     * @return
     */
    public boolean nextPermutation(int[] a) {
        int i = a.length - 1, j = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            --i;
        }
        if (i == 0) {
            return false;
        }
        while (a[i - 1] >= a[j]) {
            --j;
        }
        swap(a, i - 1, j);
        j = a.length - 1;
        while (i < j) {
            swap(a, i++, j--);
        }
        return true;
    }

    /**
     *
     * @author : hoTire
     * @comment : 이전 순열
     * @param a
     * @return
     */
    public boolean prePermutation(int[] a) {
        int i = a.length - 1, j = a.length - 1;
        while (i > 0 && a[i - 1] <= a[i]) {
            --i;
        }
        if (i == 0) {
            return false;
        }
        while (a[i - 1] <= a[j]) {
            --j;
        }
        swap(a, i - 1, j);
        j = a.length - 1;
        while (i < j) {
            swap(a, i++, j--);
        }
        return true;
    }

    public void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    /**
     *
     * @author : hoTire
     * @comment : 비트마스크
     * @param n
     */
    public void bitMask(int n) {
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    // TODO
                }
            }
        }
    }

    /**
     *
     * @author : hoTire
     * @comment : 오른쪽 회전
     * @param sb
     * @param n
     */
    public void rightCycle(StringBuilder sb, int n) {
        sb.insert(0, sb.substring(1, sb.length()));
        sb.setLength(n);
    }

    public long rightCycle(long number, long n) {
        return (number % n) * 10 + (number / n);
    }

    /**
     *
     * @author : hoTire
     * @comment : 왼쪽 회전 
     * @param sb
     * @param n
     */
    public void leftCycle(StringBuilder sb, int n) {
        sb.insert(0, sb.charAt(sb.length() - 1));
        sb.setLength(n);
    }

    public long leftCycle(long number, long n) {
        return (number / 10) + (number % 10) * n;
    }

    /**
     *
     * @author : hoTire
     * @comment : 소수 구하기 
     * @param a
     */
    public void getPrime(int a[]) {
        for (int i = 2; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 2; i < a.length; i++) {
            if (a[i] == 0) {
                continue;
            }
            for (int j = i + i; j < a.length; j += i) {
                a[j] = 0;
            }
        }
    }

    /**
     * lowerBoundSearch
     */
    public int lowerBoundSearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int m = (left + right) / 2;
            if (arr[m] < k) {
                left = m + 1;
            } else {
                right = m;
            }
        }

        return right;
    }

    public <T extends Comparable<T>> int lowerBoundSearch(List<T> list, T k) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int m = (left + right) / 2;
            if (list.get(m).compareTo(k) < 0) {
                left = m + 1;
            } else {
                right = m;
            }
        }

        return right;
    }

    public int[][] floydWarshall(final int n, int graph[][]) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            // 모든 정점들을 소스로 하나씩 선택
            for (int i = 0; i < n; i++) {
                // 선택한 소스의 대상으로 모든 정점들을 선택
                for (int j = 0; j < n; j++) {
                    // 정점 k에서 j까지 최단 경로이 있는 경우 dist[i][j] 값을 업데이트한다.
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return graph;
    }
}

