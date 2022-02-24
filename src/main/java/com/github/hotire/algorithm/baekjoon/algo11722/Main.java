package com.github.hotire.algorithm.baekjoon.algo11722;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 *
 * @author : hoTire
 * @comment : 11722
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

    static int[] dp = new int[1001];

    public static void run() throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        dp[1] = 1;

        int ans = 1;
        for (int i = 2; i <= n; i++) {
            int maxDp = 0;
            for (int j = i - 1; j > 0; j--) {
                if (arr[i] < arr[j] && maxDp < dp[j]) {
                    maxDp = dp[j];
                }
            }
            dp[i] = maxDp + 1;
            ans = ans < dp[i] ? dp[i] : ans;
        }
        bw.write(ans + "\n");
    }
}