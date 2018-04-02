package algo1261;

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
 * @comment : 1261
 */
class Pair {
	int x;
	int y;
	
	Pair (int x, int y) {
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
	static int[] moveX = new int[]{1, -1, 0, 0};
	static int[] moveY = new int[]{0, 0, 1, -1};
	public static void run() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine()," ");		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[m+1][n+1];
		for (int i = 0; i < m; i++) {
			 String input = br.readLine();
			 for (int j = 0; j < n; j++)
				 arr[i+1][j+1] = input.charAt(j)-'0';
		}
	
		Queue zeroQ = new LinkedList();
		Queue oneQ = new LinkedList();
		zeroQ.offer(new Pair(1,1));
		
		int[][] dist = new int[m+1][n+1];
		boolean[][] c = new boolean[m+1][n+1];

		while (!zeroQ.isEmpty() || !oneQ.isEmpty()) {
			Pair now = zeroQ.isEmpty() ? (Pair) oneQ.poll() : (Pair) zeroQ.poll();
						
			if (c[m][n]) {
				break;
			}
			
			for (int i = 0; i < 4 ; i++) {
				int nextX = now.x + moveX[i];
				int nextY = now.y + moveY[i];
				if (nextX > 0 && nextY > 0 && nextX <= m && nextY <= n) {
					Pair p = new Pair(nextX, nextY);
					if (!c[nextX][nextY]) {
						c[nextX][nextY] = true;
						if (arr[nextX][nextY] == 1) {
							dist[nextX][nextY] = dist[now.x][now.y] +1; 
							oneQ.offer(p);
						} else {
							dist[nextX][nextY] = dist[now.x][now.y];
							zeroQ.offer(p);
						}
					}
				}
			}
		}
		
		bw.write(dist[m][n]+"\n");
	}
}
