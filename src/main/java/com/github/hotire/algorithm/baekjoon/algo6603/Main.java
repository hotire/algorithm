package com.github.hotire.algorithm.baekjoon.algo6603;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author : hoTire
 * @comment : 6603
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

    static int[] ARR;

    public static void run() throws IOException {
        StringTokenizer st = null;
        int n = 0;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            ARR = new int[n];
            int i = 0;
            while (st.hasMoreTokens()) {
                ARR[i++] = Integer.parseInt(st.nextToken());
            }

            Stack s = new Stack();
            go(n, 0, s);
            bw.write("\n");
            bw.flush();
        }
    }

    public static void go(int length, int index, Stack s) throws IOException {
        if (s.size() == 6) {
            for (Object v : s) {
                bw.write((int) v + " ");
            }
            bw.write("\n");
            return;
        }
        if (index >= length) {
            return;
        }
        s.push(ARR[index]);
        go(length, index + 1, s);
        s.pop();
        go(length, index + 1, s);
    }
}
