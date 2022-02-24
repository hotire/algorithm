package com.github.hotire.algorithm.baekjoon.algo1987;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Pair {
    int x;
    int y;
    Set set;

    Pair(int x, int y, Set set) {
        this.set = set;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        run();
        bw.flush();
        br.close();
        bw.close();
    }

    static int[] moveX = new int[] { 1, -1, 0, 0 };
    static int[] moveY = new int[] { 0, 0, 1, -1 };

    public static void run() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());        // 세로
        int C = Integer.parseInt(st.nextToken());        // 가로

        char[][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        Queue q = new LinkedList();
        Set set = new HashSet();
        set.add(arr[0][0]);
        Pair pair = new Pair(0, 0, set);

        q.offer(pair);

        int max = 0;
        while (!q.isEmpty()) {
            Pair p = (Pair) q.poll();

            if (p.set.size() > max) {
                max = p.set.size();
            }

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + moveX[i];
                int nextY = p.y + moveY[i];

                if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {
                    if (!p.set.contains(arr[nextX][nextY])) {
                        Set nextSet = new HashSet();
                        nextSet.addAll(p.set);
                        nextSet.add(arr[nextX][nextY]);
                        Pair nextP = new Pair(nextX, nextY, nextSet);
                        q.offer(nextP);
                    }
                }
            }
        }
        bw.write(max + "\n");
    }
}