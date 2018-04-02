package algo14499;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * @author : hoTire
 * @comment : 14499
 */
class Dice {
	int top;
	int bottom;
	int right;
	int left;
	int back;
	int front;
	int x;
	int y;

	Dice(int x, int y) {
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

	static int[] moveX = new int[] { 0, 0, 0, -1, 1 };
	static int[] moveY = new int[] { 0, 1, -1, 0, 0 };

	public static void run() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][M + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Dice dice = new Dice(x, y);
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			int nextX = dice.x + moveX[arr[i]];
			int nextY = dice.y + moveY[arr[i]];
	
			if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
				if (arr[i] == 1) {
					int temp = dice.right;
					dice.right = dice.top;
					dice.top = dice.left;
					dice.left = dice.bottom;
					dice.bottom = temp;
				} else if (arr[i] == 2) {
					int temp = dice.left;
					dice.left = dice.top;
					dice.top = dice.right;
					dice.right = dice.bottom;
					dice.bottom = temp;
				} else if (arr[i] == 3) {
					int temp = dice.top;
					dice.top = dice.back;
					dice.back = dice.bottom;
					dice.bottom = dice.front;
					dice.front = temp;
				} else if (arr[i] == 4) {
					int temp = dice.top;
					dice.top = dice.front;
					dice.front = dice.bottom;
					dice.bottom = dice.back;
					dice.back = temp;
				}
				
				if (map[nextX][nextY] != 0) {
					dice.bottom = map[nextX][nextY];
					map[nextX][nextY] = 0;
				} else {
					map[nextX][nextY] = dice.bottom;
				}
				dice.x = nextX;
				dice.y = nextY;
				
				bw.write(dice.top+"\n");
				bw.flush();
			}

		}

	}
}