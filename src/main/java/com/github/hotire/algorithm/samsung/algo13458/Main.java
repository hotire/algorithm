package com.github.hotire.algorithm.samsung.algo13458;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * @author : hoTire
 * @comment : 13458
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
	public static void run() throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] room = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");	
		for (int i = 1; i <= n; i++) 
			room[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");		
		
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long ans = 0;
		
		for (int i = 1; i <= n; i++) {
			room[i] -= B;
			ans +=  room[i] <= 0 ? 1 : (room[i] % C == 0) ? (room[i] / C) + 1 : (room[i] / C) + 2;
			
		}
		bw.write(ans+"\n");
	
	}
}