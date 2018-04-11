package sw2112_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author : hoTire
 * @comment : 2112, 보호필름
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String args[]) throws IOException {
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0)
			run();
		bw.flush();
		br.close();
		bw.close();
	}

	static int[][] MAP;			// 맵 
	static int D, W, K;			// 입력 값  
	static int COUNT = 1;		// 정답 인덱스 
	static int MIN;				// 정답 
	static boolean[] c;			
	static int[] s;				// 잉크 
	static int[][] copyMap;		// 롤백 


	public static void run() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		D = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		MAP = new int[D][W];
		copyMap = new int[D][W];
		c = new boolean[W];
		s = new int[D];
		for (int i = 0; i < D; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				copyMap[i][j] = MAP[i][j];
			}
		}
		// 입력 끝 
		
		
		// 값 초기화 
		MIN = K;
		Arrays.fill(s, -1); 
		
		/* DFS  
		 * 1. 해당 인덱스에서 잉크 넣지 않음 
		 * 2. 해당 인덱스에 잉크 A 넣기  
		 * 3. 해당 인덱스에 잉크 B 넣기
		 * */
		s[0] = -1; 
		dfs(0, 0);			
		s[0] = 1;
		dfs(1, 0);
		s[0] = 0;
		dfs(1, 0);
		
		bw.write("#" + (COUNT++) + " " + MIN + "\n");
	}

	/**
	 * 
	 * @author : hoTire
	 * @comment :정답인지 검사는 index가 D일 때 
	 * 			  MIN값 보다 큰 Count는 버린다. 
	 *  
	 * @param count
	 * @param index
	 */
	public static void dfs(int count, int index) {
		if (count >= MIN)
			return;
		if (index > D)
			return;

		if (index == D) {
			// 실제적으로 잉크 칠하기 
			for (int i = 0; i < D; i++) if (s[i] != -1) Arrays.fill(MAP[i], s[i]);
			
			int cnt = 1;
			Arrays.fill(c, false);
			for (int i = 0; i < W; i++) {
				cnt = 1;
				for (int j = 0; j < D - 1; j++) {
					if (MAP[j][i] == MAP[j + 1][i]) cnt++;
					else cnt = 1;
					if (cnt >= K) {
						c[i] = true;
						break;
					}
				}
				if (!c[i]) break;	// 중요한 if문이다. 만약 한 열의 필름이 완성되지 않으면 break;
			}
			
			// 롤백
			for (int i = 0; i < D; i++) {
				if (s[i] != -1)
					System.arraycopy(copyMap[i], 0, MAP[i], 0, W);
			}
			
			for (int i = 0; i < W; i++) 
				if (!c[i]) return;
				
			MIN = Math.min(count, MIN);
			return;
		}
		
		s[index] = -1;
		dfs(count, index + 1);
		s[index] = 1;
		dfs(count + 1, index + 1);
		s[index] = 0;
		dfs(count + 1, index + 1);
		
	}
}
