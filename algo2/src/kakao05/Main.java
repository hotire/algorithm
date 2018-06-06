package kakao05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author : hoTire
 * @comment : Kakao 5, 자동완성
 */
public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<String> list = new ArrayList<String>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		for (int i = 0; i < n; i++) {
			String word = scanner.next();
			list.add(word);
			StringBuilder sb = new StringBuilder();
			for (char c : word.toCharArray()) {
				sb.append(c);
				String s = sb.toString();
				if (map.containsKey(s)) map.put(s, map.get(s)+1);
				else map.put(s, 1);
			}
		}
		
		int ans = 0;
		for (String word : list ) {
			StringBuilder sb = new StringBuilder();
			boolean isAdd = false;
			for (char c : word.toCharArray()) {
				sb.append(c);
				if (map.get(sb.toString()) == 1) {
					ans += sb.length();
					isAdd = true;
					break;
				}
			}
			if (!isAdd) ans += sb.length();
		}
		System.out.println(ans);
		scanner.close();
	}
}
