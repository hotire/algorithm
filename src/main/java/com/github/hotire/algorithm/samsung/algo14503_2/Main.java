package com.github.hotire.algorithm.samsung.algo14503_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Robot {
    int x;
    int y;
    int D;                        // 0 : 북 , 1 : 동, 2 : 남, 3: 서

    Robot(int x, int y, int D) {
        this.x = x;
        this.y = y;
        this.D = D;
    }

    public void leftD() {
        D = D - 1 < 0 ? 3 : D - 1;
    }

    public int nextX() {
        if (D == 0) {
            return -1;
        } else if (D == 2) {
            return 1;
        }
        return 0;
    }

    public int nextY() {
        if (D == 1) {
            return 1;
        } else if (D == 3) {
            return -1;
        }
        return 0;
    }

    public int backX() {
        if (D == 0) {
            return 1;
        } else if (D == 2) {
            return -1;
        }
        return 0;
    }

    public int backY() {
        if (D == 1) {
            return -1;
        } else if (D == 3) {
            return 1;
        }
        return 0;
    }
}

/**
 *
 * @author : hoTire
 * @comment : 14503, Samsung BFS, 로봇 청소 
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][] check = new boolean[n][m];
        st = new StringTokenizer(br.readLine(), " ");
        Robot r = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Robot> q = new LinkedList<Robot>();
        q.offer(r);
        check[r.x][r.y] = true;
        int ans = 1;

        while (!q.isEmpty()) {
            Robot now = q.poll();
            boolean clean = false;
            int copyD = now.D;
            for (int i = 0; i < 4; i++) {
                now.leftD();        // 방향 회전
                int nextX = now.x + now.nextX();
                int nextY = now.y + now.nextY();
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m && map[nextX][nextY] != 1 && !check[nextX][nextY]) {
                    q.offer(new Robot(nextX, nextY, now.D));
                    check[nextX][nextY] = true;
                    ans++;
                    clean = true;
                    break;
                }
            }
            if (!clean) {
                now.D = copyD;
                int nextX = now.x + now.backX();
                int nextY = now.y + now.backY();
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m && map[nextX][nextY] != 1) {
                    q.offer(new Robot(nextX, nextY, now.D));
                }
            }
            now = null;
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}