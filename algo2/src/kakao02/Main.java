package kakao02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author : hoTire
 * @comment : 카카오 3차 테스트, 압축
 */
public class Main {
	public static void main(String[] arsgs) {
		Scanner scanner = new Scanner(System.in);
		String msg = scanner.next();
		scanner.close();
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		char c = 'A';
		for (int i = 1; i <= 26; i++) map.put(Character.toString(c++),i);
		
		int value = 27;
		int n = msg.length();
		StringBuilder sb = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(msg.charAt(i));
			if (!map.containsKey(sb.toString())) {
				map.put(sb.toString(), value++);
				sb.setLength(sb.length()-1);
				ans.append(map.get(sb.toString())+", ");
				sb.setLength(0);
				i--;
			}
		}
		if (sb.length() > 0) ans.append(map.get(sb.toString())+" ,");
		
		ans.setLength(ans.length()-1);
		System.out.println(ans);		
	}
}
