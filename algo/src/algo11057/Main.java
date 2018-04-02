package algo11057;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * @author : hoTire
 * @comment : 11057
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
	static long[][] dp = new long[1001][10];
	public static void run() throws IOException {
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i <=9 ; i++ ) {
			dp[1][i] = 1;
		}
		long ans = 0;
		for (int i = 0; i <= 9; i++) {
			go(n,i);
			ans += dp[n][i];
		}
		ans %= 10007;
		bw.write(ans+"\n");
	}
	
	public static long go(int n, int index) {
		if (n <= 0 || index < 0) return 0;
		if (dp[n][index] != 0 ) return dp[n][index];
		
		for (int i = 0; i <= index; i++)
			dp[n][index] += go(n-1,i);
		
		dp[n][index] %= 10007;
		return dp[n][index];
	}
	
	
}
