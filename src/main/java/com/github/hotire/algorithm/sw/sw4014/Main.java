package com.github.hotire.algorithm.sw.sw4014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author : hoTire
 * @comment : SW Expert Academy, 4014
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String args[]) throws IOException {
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0)
			run();
		bw.flush();
		br.close();
		bw.close();
	}
	static int N;
	static int X;
	static int count = 1;
	static int MAX = Integer.MIN_VALUE;
	public static void run() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		int[][] MAP = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				MAX = Math.max(MAX, MAP[i][j]);
			}
		}
		int ans = 0;
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < N; i++) {
				List<Integer> list = new ArrayList<Integer>();
				List<Boolean> c = new ArrayList<Boolean>();
				if (k < 1) {
					for (int j = 0; j < N; j++) {
						list.add(MAP[i][j]);
						c.add(false);
					}
				} else {
					for (int j = 0; j < N; j++) {
						list.add(MAP[j][i]);
						c.add(false);
					}
				}
				
				if (check(list,c)) {
					Collections.reverse(list);
					Collections.reverse(c);
					if (check(list,c)) {
						ans++;
					}
				}
			}
		}
		bw.write("#"+(count++)+" "+ans + "\n");
		bw.flush();
	}
	
	static boolean check(List<Integer> list, List<Boolean> c) {
		int size = list.size();
		int plus = 1;;
		for (int j = 0; j < size - 1; j++) {
			if (list.get(j).equals(list.get(j + 1))) {
				if (list.get(j) != MAX) {
					plus++;
				}
				if (j == N - 2) return true;
			} else if (list.get(j + 1) - list.get(j) == 1) {
				if (plus >= X ) {
					for (int k = j; k > j-X; k--) {
						if (c.get(k)) return false;
						c.set(k, true);
					}
					if (j == N - 2) return true;
				} else 
					break;
			} else if (list.get(j) - list.get(j+1) == 1) {
				plus = 1;
				continue;
			} else 
				break;
		}
		return false;
	}
	
}
