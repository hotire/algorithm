package com.github.hotire.algorithm.baekjoon.algo2407;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 
 * @author : hoTire
 * @comment : 2407, 백준 조합
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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		BigInteger[] dp = new BigInteger[N + 2];
		BigInteger[] temp = new BigInteger[N + 2];
		dp[0] = BigInteger.ONE;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				temp[j] = BigInteger.ZERO;
				if (j - 1 >= 0) temp[j] = temp[j].add(dp[j - 1]);
				if (j != i) temp[j] = temp[j].add(dp[j]);
			}
			System.arraycopy(temp, 0, dp, 0, i + 1);
		}
		bw.write(dp[M] + "\n");
	}
}
