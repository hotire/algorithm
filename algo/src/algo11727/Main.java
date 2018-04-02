package algo11727;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * @author : hoTire
 * @comment : 11727
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
	static long[] dp = new long[1001];
	public static void run() throws IOException {
		int n = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[0] = 1;
		for (int i =2; i <= n; i++) {
			dp[i] = (2*dp[i-2] + dp[i-1]) % 10007; 
		}
		bw.write(dp[n] + "\n");
	}
}
