package SWalgo1952;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * @author : hoTire
 * @comment : 1952
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
	static int arr[] = new int[5];
	static int month[] = new int[13];
	static int MIN;
	public static void run() throws IOException {
		int t = Integer.parseInt(br.readLine());		
		for (int n = 1; n <= t; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");	
			for (int i = 1; i <= 4; i++) arr[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 1; i <= 12; i++) month[i] = Integer.parseInt(st.nextToken());
			MIN = arr[4];
			dfs(1,0);
			bw.write("#"+n+" "+MIN+"\n");
			bw.flush();
		}
		
	}

	public static void dfs(int now, int s) throws IOException {
		if (now >= 13) {
			MIN = Math.min(MIN, s);
			return;
		} 
		dfs(now+1, s + month[now] * arr[1]);
		dfs(now+1, s + arr[2]);
		dfs(now+3, s + arr[3]);
		dfs(now+12, s + arr[4]);
	}
}
