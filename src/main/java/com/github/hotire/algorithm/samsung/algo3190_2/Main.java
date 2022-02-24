package com.github.hotire.algorithm.samsung.algo3190_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Snake {
    int x = 1;
    int y = 1;
    int d = 1;                // 1 동, 2 남, 3 서, 4 북

    public void left() {
        d = d - 1 == 0 ? 4 : d - 1;
    }

    public void right() {
        d = d + 1 == 5 ? 1 : d + 1;
    }

    public int nextX() {
        if (d == 4) {
            return -1;
        } else if (d == 2) {
            return 1;
        }
        return 0;
    }

    public int nextY() {
        if (d == 1) {
            return 1;
        } else if (d == 3) {
            return -1;
        }
        return 0;
    }

    Snake(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

/**
 *
 * @author : hoTire
 * @comment : 백준, 3190 뱀 문제
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
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
        }
        int L = Integer.parseInt(br.readLine());
        Map<Integer, String> ins = new HashMap<Integer, String>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            ins.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Snake head = new Snake(1, 1, 1);
        Snake tail = head;

        int count = 0;
        while (true) {

            if (ins.containsKey(count)) {
                if (ins.get(count).equals("L")) {
                    head.left();
                } else {
                    head.right();
                }
            }

            int nextX = head.x + head.nextX();
            int nextY = head.y + head.nextY();

            if (nextX <= N && nextY <= N && nextX > 0 && nextY > 0 && map[nextX][nextY] <= 0) {
                int apple = map[nextX][nextY];
                map[head.x][head.y] = head.d;
                map[nextX][nextY] = head.d;
                head = new Snake(nextX, nextY, head.d);
                if (apple == 0) {
                    map[nextX][nextY] = head.d;
                    tail.d = map[tail.x][tail.y];
                    map[tail.x][tail.y] = 0;
                    tail.x += tail.nextX();
                    tail.y += tail.nextY();
                }
            } else {
                break;
            }
            count++;
        }

        bw.write((++count) + "\n");
    }
}
