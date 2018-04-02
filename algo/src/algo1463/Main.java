package algo1463;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author : hoTire
 * @comment : 1463
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
			
		Queue<Integer> q = new LinkedList<Integer>();
		int[] dist = new int[n+1];
		q.offer(n);
	
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == 1) {
				bw.write(dist[now]+"\n");
				break;
			}
			
			if (now % 3 == 0) {
				if (dist[now/3] == 0) {
					q.offer(now/3);
					dist[now/3] = dist[now] +1;
				}
			}
			if (now % 2 == 0) {
				if (dist[now/2] == 0) {
					q.offer(now/2);
					dist[now/2] = dist[now] +1;
				}
			}
			
			if (dist[now-1] == 0) {
				q.offer(now-1);
				dist[now-1] = dist[now] +1;
			}
		}
		
	}
}