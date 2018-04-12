package algo14502_2;

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
 * @comment : 14502 Samsung, DFS + BFS
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
	static int[][] map;
	static int[][] copyMap;
	static boolean[][] c;
	public static void run() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		c = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					c[i][j] = true;
					dfs(i, j, 1);
					map[i][j] = 0;
				}
			}
		}
		bw.write(MAX+"\n");
		bw.flush();
	}

	public static void dfs(int x, int y, int count) {
		if (count == 3) {
			bfs();
			return;
		}

		for (int i = x; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !c[i][j]) {
					map[i][j] = 1;
					dfs(i, j, count + 1);
					map[i][j] = 0;
				}
			}
		}

	}

	static Queue<Pair> q = new LinkedList<Pair>();
	static int[] moveX = new int[] { 0, 0, 1, -1 };
	static int[] moveY = new int[] { 1, -1, 0, -0 };
	static int MAX = Integer.MIN_VALUE;
	
	public static void bfs() {
		q.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					q.offer(new Pair(i, j));
				}
			}
		}
		
		for (int i = 0; i < N; i++)
			System.arraycopy(map[i], 0, copyMap[i], 0, M);
		
		while (!q.isEmpty()) {
			Pair now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = now.x + moveX[i];
				int nextY = now.y + moveY[i];
				if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && copyMap[nextX][nextY] == 0) {
					copyMap[nextX][nextY] = 2;
					q.offer(new Pair(nextX, nextY));
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					++ans;
				}
			}
		}
		MAX = Math.max(ans, MAX);
	}
}

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
