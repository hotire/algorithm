package com.github.hotire.algorithm.baekjoon.algo1525;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author : hoTire
 * @comment : 1525
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final int[] dx = { 0, 0, 1, -1 };
    public static final int[] dy = { 1, -1, 0, 0 };

    public static void main(String args[]) throws IOException {
        run();
        bw.flush();
        br.close();
        bw.close();
    }

    public static void run() throws IOException {
        int n = 3;
        int start = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                int temp = Integer.parseInt(st.nextToken());
                temp = temp == 0 ? 9 : temp;
                start = start * 10 + temp;
            }
        }

        Queue q = new LinkedList();
        Map dist = new HashMap();
        q.offer(start);
        dist.put(start, 0);

        while (!q.isEmpty()) {

            int fromNum = (int) q.poll();
            String num = String.valueOf(fromNum);
            int index = num.indexOf('9');    // 123 456 978
            int x = index / 3;
            int y = index % 3;

            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (moveX >= 0 && moveX < 3 && moveY >= 0 && moveY < 3) {
                    StringBuilder next = new StringBuilder(num);
                    char temp = next.charAt(moveX * 3 + moveY);
                    next.setCharAt(moveX * 3 + moveY, next.charAt(x * 3 + y));
                    next.setCharAt(x * 3 + y, temp);
                    int nextNum = Integer.parseInt(next.toString());
                    if (!dist.containsKey(nextNum)) {
                        dist.put(nextNum, (int) dist.get(fromNum) + 1);
                        q.offer(nextNum);
                    }
                }
            }

        }

        if (dist.containsKey(123456789)) {
            bw.write(dist.get(123456789) + "\n");
        } else {
            bw.write("-1\n");
        }

    }
}
