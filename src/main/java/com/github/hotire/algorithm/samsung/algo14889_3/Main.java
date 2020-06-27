package com.github.hotire.algorithm.samsung.algo14889_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author : hoTire
 * @comment : 14889 Samsung bitMask
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String args[]) throws IOException {
		run();
		br.close();
		bw.flush();
		bw.close();
	}
	public static void run() throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int MIN = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		boolean[] c = new boolean[n];
		int count = 0;
		for (int i = 1; i < (1<<n); i++) {
			count = 0;
			Arrays.fill(c, false);
			for (int j = 0; j < n; j++) {
				if ( (i & (1<<j)) > 0) {
					c[j] = true;
					count++;
				}
			}
			// 팀 나누기 
			if (count == n/2) {
				int ans1 = 0, ans2 = 0;
				for (int k = 0; k < n; k++) {
					for (int j = 0; j < n; j++) {
						if (c[k] && c[j]) ans1 += arr[k][j];
						if (!c[k] && !c[j]) ans2 += arr[k][j];
					}
				}	
				MIN = Math.min(MIN, Math.abs(ans1-ans2));		
			}
		}
		bw.write(MIN+"\n");
	}
}
