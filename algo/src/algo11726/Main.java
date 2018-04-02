package algo11726;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
		int goal = Integer.parseInt(br.readLine());
		bw.write(go(goal) +"\n");
		
	}
	static int[] dp = new int[1001];
	public static int go(int n) {
		if (n == 1 || n == 0) return 1;
		if (dp[n] != 0) return dp[n];
		
		dp[n] = (go(n-1) + go(n-2)) % 10007;
		return dp[n];
	}
}
