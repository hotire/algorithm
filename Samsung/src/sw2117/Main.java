package sw2117;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * @author : hoTire
 * @comment : SW Expert 2117, DFS
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws IOException {
	
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)run();
		bw.flush();
		br.close();
		bw.close();
	}
	static int N;
	static int M;
	static int[][] MAP;
	static int MAX;
	static int count = 1;
	public static void run() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine()," ");	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MAP = new int[N][N];
		MAX = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");	
			for (int j = 0; j < N; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				if (MAP[i][j] == 1) MAX = 1;
			}
		}
		boolean[][] map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (MAP[i][j] == 1) {
					map[i][j] = true;
					dfs(2,map,M,1);
					map[i][j] = false;
				} else {
					map[i][j] = true;
					dfs(2,map,0,0);
					map[i][j] = false;
				}
			}
		}
		bw.write("#"+(count++)+" "+MAX+"\n");
	}
	static int[] moveX = new int[]{-1,1,0,0};
	static int[] moveY = new int[]{0,0,-1,1};
	public static void dfs(int K,boolean[][] map, int sum, int cnt) {
		if (K > N*2) return;

		boolean[][] temp = new boolean[N][N];
		for (int i = 0; i < N; i++) 
			System.arraycopy(map[i], 0, temp[i], 0, N);
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]) {
					for (int k = 0; k < 4; k++) {
						int nextX = i + moveX[k];
						int nextY = j + moveY[k];
						if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !temp[nextX][nextY]) {
							temp[nextX][nextY] = true;
							if (MAP[nextX][nextY] == 1) {
								sum += M;
								cnt++;
							}
						}
					}
				}
			}
		}
		int value = K * K + (K - 1) * (K - 1);
		if (sum-value >= 0) MAX = Math.max(MAX, cnt);
		dfs(K+1,temp,sum,cnt);
	}
}
