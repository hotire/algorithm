package algo2580;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * @author : hoTire
 * @comment : 2580
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
	
	static int[][] arr = new int[9][9];
	static boolean[][][] c = new boolean[3][9][10];
	public static void run() throws IOException {
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");	
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0) {
					c[0][i][arr[i][j]] = true;
					c[1][j][arr[i][j]] = true;
					c[2][square(i,j)][arr[i][j]] = true;
				}
			}
		}
		System.out.println(sudoku(0));
	}
	
	public static int square(int x, int y) {
        return (x/3)*3+(y/3);
    }
	
	public static boolean sudoku(int count) throws IOException {
		if (count == 81) {
			for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(arr[i][j] + " ");
                }
                bw.write("\n");
            }
			return true;
		}
		
		int x = count / 9;
		int y = count % 9;
		if (arr[x][y] != 0) {
			sudoku(count+1);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (!c[0][x][i] && !c[1][y][i] && !c[2][square(x,y)][i]) {
					arr[x][y] = i;
					c[0][x][i] = c[1][y][i] = c[2][square(x,y)][i] = true;
					if (sudoku(count+1)) {
						return true;
					}
					arr[x][y] = 0;
					c[0][x][i] = c[1][y][i] = c[2][square(x,y)][i] = false;
				}
			}
		}
		return false;
	}
}
