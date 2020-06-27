package com.github.hotire.algorithm.baekjoon.algo1158;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author : hoTire
 * @comment : 백준, 1158 Josephus
 */

class Josephus {
	private int N, M;
	private List<Integer> list = new ArrayList<Integer>();
	Josephus (int N, int M) {
		this.N = N;
		this.M = M;
		for (int i = 1; i <= this.N; i++) list.add(i);
	}
	public void run(StringBuilder sb) {
		int index = 0;
		while (!list.isEmpty()) {
			index = (M + index-1) % list.size();
			sb.append(list.get(index));
			if (list.size() != 1) sb.append(", ");
			list.remove(index);
		}
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
		StringTokenizer st = new StringTokenizer(br.readLine()," ");	
		Josephus josephus = new Josephus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		StringBuilder sb = new StringBuilder("<");
		josephus.run(sb);
		sb.append(">");
		bw.write(sb.toString());
	}
}
