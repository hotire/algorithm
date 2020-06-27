package com.github.hotire.algorithm.samsung.algo3109;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * @author : hoTire
 * @comment : 3109 빵집
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

	static int N, M;
	static int[][] arr;

	public static void run() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String txt = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = txt.charAt(j) == '.' ? 0 : 2;
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (dfs(i, 0)) ans++;
		}
		bw.write(ans + "\n");
	}

	static int[] moveX = new int[] { -1, 0, 1 };

	public static boolean dfs(int x, int y) {
		if (y == M - 1) return true;
		
		for (int i = 0; i < 3; i++) {
			int nextX = x + moveX[i];
			int nextY = y + 1;
			if (nextX < N && nextY < M && nextX >= 0 && nextY >= 0 && arr[nextX][nextY] == 0) {
				arr[nextX][nextY] = 1;
				if (dfs(nextX, nextY)) return true;
			}
		}
		return false;
	}
}
