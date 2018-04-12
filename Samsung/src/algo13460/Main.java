package algo13460;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * @author : hoTire
 * @comment : 13460, Samsung DFS
 */
class Pair {
	int x;
	int y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Pair(){};
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
	static int N;
	static int M;
	static char[][] MAP;
	static int MIN = 11;
	static Pair goal;
	public static void run() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine()," ");	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MAP = new char[N+1][M+1]; 
		Pair red = null;
		Pair blue = null;
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < row.length(); j++) {
				MAP[i][j] = row.charAt(j);
				if (row.charAt(j) == 'O') goal = new Pair(i,j);
				if (row.charAt(j) == 'R') {
					red = new Pair(i,j);
					MAP[i][j] = '.';
				}
				if (row.charAt(j) == 'B') {
					blue = new Pair(i,j);
					MAP[i][j] = '.';
				}
			}
		}
		dfs(0,0,red,blue);
		dfs(0,1,red,blue);
		dfs(0,2,red,blue);
		dfs(0,3,red,blue);
		MIN = MIN == 11 ? -1 : MIN;
		bw.write(MIN+"\n");
	}
	
	public static void dfs(int count, int index, Pair cRed, Pair cBlue) {
	
		if (count > 10 ) return;
		if (cBlue.x == goal.x && cBlue.y == goal.y) return;
		if (cRed.x == goal.x && cRed.y == goal.y) {
			MIN = Math.min(MIN, count);
			return;
		}
	
		Pair red = new Pair(cRed.x, cRed.y);
		Pair blue = new Pair(cBlue.x, cBlue.y);
				
		/* 4방향 */
		if (index == 0 ) {
			int x = blue.x;
			for (int j = blue.y+1; j < M; j++) {
				if (MAP[x][j] == '#' ) {
					blue.y = j-1;
					break;
				}
				if (MAP[x][j] == 'O') {
					blue.y = j;
					break;
				}
			}
			x = red.x;
			for (int j = red.y+1; j < M; j++) {
				if (MAP[x][j] == '#') {
					red.y = j-1;
					break;
				}
				if (MAP[x][j] == 'O') {
					red.y = j;
					break;
				}
			}
		}
		if (index == 1 ){
			int x = blue.x;
			for (int j = blue.y-1; j >= 0; j--) {
				if (MAP[x][j] == '#'){
					blue.y = j+1;
					break;
				}
				if (MAP[x][j] == 'O') {
					blue.y = j;
					break;
				}
			}
			x = red.x;
			for (int j = red.y-1; j >= 0; j--) {
				if (MAP[x][j] == '#') {
					red.y = j+1;
					break;
				}
				if (MAP[x][j] == 'O') {
					red.y = j;
					break;
				}
			}
		}
		
		if (index == 2) {
			int y = blue.y;
			for (int j = blue.x+1; j < N; j++) {
				if (MAP[j][y] == '#'){
					blue.x = j-1;
					break;
				}
				if (MAP[j][y] == 'O') {
					blue.x = j;
					break;
				}
			}
			y = red.y;
			for (int j = red.x+1; j < N; j++) {
				if (MAP[j][y] == '#') {
					red.x = j-1;
					break;
				}
				if (MAP[j][y] == 'O') {
					red.x = j;
					break;
				}
			}
		}	
		if (index == 3 ) {
			int y = blue.y;
			for (int j = blue.x-1; j >= 0; j--) {
				if (MAP[j][y] == '#'){
					blue.x = j+1;
					break;
				}
				if (MAP[j][y] == 'O') {
					blue.x = j;
					break;
				}
			}
			y = red.y;
			for (int j = red.x-1; j >= 0; j--) {
				if (MAP[j][y] == '#') {
					red.x = j+1;
					break;
				}
				if (MAP[j][y] == 'O') {
					red.x = j;
					break;
				}
			}
		}
		
		/* 위치 조정 */
		if (red.x == blue.x && red.y == blue.y) {
			if (MAP[red.x][red.y] == '.') {
				int yCom = cRed.y - cBlue.y;
				int xCom = cRed.x - cBlue.x;	
				if (index == 0) {
					if (yCom > 0) blue.y = blue.y - 1; 
					else red.y = red.y - 1;
				} 
				if (index == 1) {
					if (yCom > 0) red.y = red.y + 1;
					else blue.y = blue.y + 1; 
				} 
				if (index == 2) {
					if (xCom > 0) blue.x = blue.x - 1; 
					else red.x = red.x - 1;
				} 
				if (index == 3) {
					if (xCom > 0) red.x = red.x + 1; 
					else blue.x = blue.x + 1;
				} 
			}
		}
		
		/* 4방향 DFS */
		dfs(count+1,0,red,blue);
		dfs(count+1,1,red,blue);
		dfs(count+1,2,red,blue);
		dfs(count+1,3,red,blue);
	}	
}