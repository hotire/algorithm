package com.github.hotire.algorithm.samsung.algo14888;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 *
 * @author : hoTire
 * @comment :14888, Samsung DFS
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        run();
        bw.flush();
        br.close();
        bw.close();
    }

    static long[] arr;
    static int N;
    static int[] OP = new int[5];
    static long MIN = Integer.MAX_VALUE;
    static long MAX = -Integer.MAX_VALUE;

    public static void run() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            OP[i] = Integer.parseInt(st.nextToken());
        }
        dfs(arr[1], 1);
        bw.write(MAX + "\n");
        bw.write(MIN + "\n");
    }

    public static void dfs(long sum, int count) {
        if (count > N) {
            return;
        }
        if (count == N) {
            MIN = Math.min(MIN, sum);
            MAX = Math.max(MAX, sum);
            return;
        }
        for (int j = 0; j < 4; j++) {
            if (OP[j] > 0) {
                --OP[j];
                if (j == 0) {
                    dfs(sum + arr[count + 1], count + 1);
                }
                if (j == 1) {
                    dfs(sum - arr[count + 1], count + 1);
                }
                if (j == 2) {
                    dfs(sum * arr[count + 1], count + 1);
                }
                if (j == 3) {
                    dfs(sum / arr[count + 1], count + 1);
                }
                ++OP[j];
            }
        }

    }
}
