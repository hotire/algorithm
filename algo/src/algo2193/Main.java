package algo2193;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * @author : hoTire
 * @comment : 2193
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
	static long[][] dp = new long[91][10];
	public static void run() throws IOException {
		int n = Integer.parseInt(br.readLine());
		dp[1][1] = 1;
		long ans = 0;
		for (int i = 0; i <= 1; i++)
			ans += go(n,i);
		bw.write(ans+"\n");
	}
	
	public static long go(int n, int index) {
		if (n <= 0 || (n ==1 && index == 0)) return 0;
		if (dp[n][index] != 0 ) return dp[n][index];
		
		dp[n][index] = go(n-1,0);
		if (index != 1) dp[n][index] +=  go(n-1,1);
		
		return dp[n][index];
	}
}

