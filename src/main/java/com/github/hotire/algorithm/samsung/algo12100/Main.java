package com.github.hotire.algorithm.samsung.algo12100;

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
 * @comment : 백준 12100, Samsung DFS
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

	static int[][] arr;
	static int N;
	static int MAX = Integer.MIN_VALUE;
	public static void run() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= 4; i++)
			DFS(0,i,arr);
		bw.write(MAX+"\n");
	}

	static List<Integer> list = new ArrayList<Integer>();
	static List<Integer> plusList = new ArrayList<Integer>();
	public static void DFS(int count, int index, int[][] map) {
		if (count == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					MAX = Math.max(MAX, map[i][j]);
				}
			}
			return;
		}
		
		int[][] nextMap = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			list.clear();
			plusList.clear();
			for (int j = 0; j < N; j++) {
				if (index > 2) {
					if (map[j][i] != 0) list.add(map[j][i]);
				} else {
					if (map[i][j] != 0) list.add(map[i][j]);
				}
			}
			
			if (index == 1 || index == 4) 
				Collections.reverse(list);
			
			for (int j = 0; j < list.size(); j++) {
				if (j != list.size()-1 && list.get(j).equals(list.get(j + 1))) {
					plusList.add(list.get(j++)*2);
				} else {
					plusList.add(list.get(j));
				}
			}
			for (int j = 0; j < plusList.size(); j++) {
				if (index == 1) nextMap[i][N - j - 1] = plusList.get(j);
				else if (index == 4) nextMap[N - j - 1][i] = plusList.get(j);
				else if (index == 2) nextMap[i][j] = plusList.get(j);
				else if (index == 3) nextMap[j][i] = plusList.get(j);
			}
		}
		for (int i = 1; i <= 4; i++)
			DFS(count + 1, i, nextMap);
	}
}
