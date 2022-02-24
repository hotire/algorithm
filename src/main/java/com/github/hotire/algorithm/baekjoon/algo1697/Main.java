package com.github.hotire.algorithm.baekjoon.algo1697;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author : hoTire
 * @comment : 1697
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

    public static void run() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        Queue q = new LinkedList();
        q.offer(from);

        boolean[] c = new boolean[100001];
        int[] dist = new int[100001];

        while (!q.isEmpty()) {
            from = (int) q.poll();

            if (from == to) {
                bw.write(dist[from] + "\n");
                break;
            } else {
                if (from - 1 >= 0 && !c[from - 1]) {
                    q.offer(from - 1);
                    c[from - 1] = true;
                    dist[from - 1] = dist[from] + 1;
                }
                if (from + 1 <= 100000 && !c[from + 1]) {
                    q.offer(from + 1);
                    c[from + 1] = true;
                    dist[from + 1] = dist[from] + 1;
                }
                if (from * 2 <= 100000 && !c[from * 2]) {
                    q.offer(from * 2);
                    c[from * 2] = true;
                    dist[from * 2] = dist[from] + 1;
                }
            }
        }

    }
}
