package com.github.hotire.algorithm.samsung.algo14891;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author : hoTire
 * @comment : 14891 
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

    static StringBuilder[] sb = new StringBuilder[5];
    static boolean[] c = new boolean[5];
    static int[] score = new int[] { 0, 1, 2, 4, 8 };

    public static void run() throws IOException {
        int[][] arr = new int[5][9];
        for (int i = 1; i <= 4; i++) {
            sb[i] = new StringBuilder(br.readLine());
        }
        int t = Integer.parseInt(br.readLine());
        int[][] test = new int[t + 1][2];
        for (int n = 1; n <= t; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int target = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            go(target, index);
            Arrays.fill(c, false);
        }

        long ans = 0;
        for (int i = 1; i <= 4; i++) {
            if (sb[i].charAt(0) == '1') {
                ans += score[i];
            }
        }
        bw.write(ans + "\n");
    }

    public static void go(int target, int index) {
        if (target > 4 || target < 1) {
            return;
        }
        if (c[target]) {
            return;
        }

        c[target] = true;

        if (target <= 3) {
            if (sb[target].charAt(2) != sb[target + 1].charAt(6)) {
                go(target + 1, index * -1);
            }
        }

        if (target >= 2) {
            if (sb[target - 1].charAt(2) != sb[target].charAt(6)) {
                go(target - 1, index * -1);
            }
        }

        if (index == 1) {
            rCycle(target);
        } else {
            lCycle(target);
        }
    }

    public static void lCycle(int target) {
        char c = sb[target].charAt(0);
        sb[target].insert(0, sb[target].substring(1, sb[target].length()));
        sb[target].setLength(8);
    }

    public static void rCycle(int target) {
        char c = sb[target].charAt(sb[target].length() - 1);
        sb[target].insert(1, sb[target].substring(0, sb[target].length()));
        sb[target].setCharAt(0, c);
        sb[target].setLength(8);
    }

    public static void rCycle(StringBuilder s) {
        char c = s.charAt(0);
        s.insert(0, s.substring(1, s.length()));
        s.setLength(4);
    }

    public static void lCycle(StringBuilder s) {
        char c = s.charAt(s.length() - 1);
        s.insert(1, s.substring(0, s.length()));
        s.setCharAt(0, c);
        s.setLength(4);
    }
}
