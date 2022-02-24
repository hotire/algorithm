package com.github.hotire.algorithm.samsung.algo14501;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 *
 * @author : hoTire
 * @comment : 백준 14501, DFS 퇴사 
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

    static int N;
    static int[][] arr;
    static int MAX;

    public static void run() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0, 0);
        bw.write(MAX + "\n");
    }

    public static void DFS(int index, int sum, int value) {
        if (index >= N) {
            sum = index == N ? sum : sum - value;
            MAX = Math.max(MAX, sum);
            return;
        }

        DFS(index + arr[index][0], sum + arr[index][1], arr[index][1]);        // 상담을 한다.
        DFS(index + 1, sum, value);                                                // 상담을 안한다.
    }
}