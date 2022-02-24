package com.github.hotire.algorithm.baekjoon.algo2156;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author : hoTire
 * @comment : 2156, 포도주
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

    static long[] ARR;
    static long[][] dp = new long[3][10001];

    public static void run() throws IOException {
        int n = Integer.parseInt(br.readLine());
        ARR = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            ARR[i] = Long.parseLong(br.readLine());
        }

        dp[1][1] = ARR[1];
        dp[2][1] = ARR[1];
        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(Math.max(dp[2][i - 1], dp[1][i - 1]), dp[0][i - 1]);
            dp[1][i] = dp[0][i - 1] + ARR[i];
            dp[2][i] = dp[1][i - 1] + ARR[i];
        }
        long ans = Math.max(Math.max(dp[0][n], dp[1][n]), dp[2][n]);

        bw.write(ans + "\n");

    }
}
