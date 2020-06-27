package com.github.hotire.algorithm.baekjoon.algo9095;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * @author : hoTire
 * @comment : 9095
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
		for (int i = 0 ; i < n; i++)
			bw.write(getCase(0,Integer.parseInt(br.readLine())) + "\n");
	}
	
	public static int getCase(int sum, int goal) {
		if (sum > goal) return 0;
		else if (sum == goal) return 1;
	
		int now = 0;
		for (int i = 1; i <= 3; i++)
			now += getCase(sum+i, goal); 
		
		return now;
	}
	
	
}
