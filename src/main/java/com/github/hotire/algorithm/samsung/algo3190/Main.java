package com.github.hotire.algorithm.samsung.algo3190;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * 
 * @author : hoTire
 * @comment : 3190 
 */
class Snake {
	int D = 1;				// 1 동 , 2 남 , 3 서 , 4 북
	int x = 1;
	int y = 1;
	Snake(){}
	Snake(int x,int y,int D) {
		this.x = x;
		this.y = y;
		this.D = D;
	}
	public int nextX() {
		if (this.D == 2) return 1;
		if (this.D == 4) return -1;
		return 0;
	}
	public int nextY() {
		if (this.D == 1) return 1;
		if (this.D == 3) return -1;
		return 0;
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
	public static void run() throws IOException {
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][n+1];
		int[][] map = new int[n+1][n+1];
		for (int i = 1; i <= k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
		}
		
		int l = Integer.parseInt(br.readLine());
		Map<Integer,String> order = new HashMap<Integer,String>();
		for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			order.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
	
		int time = 0;
		map[1][1] = 1;
		Snake s = new Snake();
		Snake tail = s;

		while (true) {
			int nextX = s.x + s.nextX();
			int nextY = s.y + s.nextY();
			if ( nextX <= 0 || nextY <= 0 || nextX > n || nextY > n || map[nextX][nextY] != 0) {
				bw.write(time+1+"\n");
				break;
			}
			
			map[s.x][s.y] = s.D;
			map[nextX][nextY] = s.D;
			s = new Snake(nextX, nextY, s.D);
			
			if (arr[nextX][nextY] == 1) {
				arr[nextX][nextY] = 0;	
			} else {
				tail.D = map[tail.x][tail.y];
				map[tail.x][tail.y] = 0;
				tail.x = tail.x + tail.nextX();
				tail.y = tail.y + tail.nextY();
			}
			
			if (order.containsKey(++time)) {
				if (order.get(time).equals("L")) {
					s.D = (s.D - 1) == 0 ? 4 : (s.D - 1);
				} else {
					s.D = (s.D + 1) == 5 ? 1 : (s.D + 1);
				}
			}
		}
	}
}
