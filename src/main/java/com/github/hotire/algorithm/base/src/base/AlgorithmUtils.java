package com.github.hotire.algorithm.base.src.base;


public class AlgorithmUtils {	
	private AlgorithmUtils(){};
	private static AlgorithmUtils instance = new AlgorithmUtils();
	public static AlgorithmUtils getInstance() {
		return instance;
	}
	/**
	 * 
	 * @author : hoTire
	 * @comment : 다음 순열
	 * @param a
	 * @return
	 */
	public boolean nextPermutation(int[] a) {
		int i = a.length - 1, j = a.length - 1;
		while (i > 0 && a[i-1] >= a[i]) --i;
		if (i == 0) return false;
		while (a[i-1] >= a[j]) --j;
		swap(a,i-1,j);
		j = a.length - 1;
		while (i < j) swap(a,i++,j--);
		return true;
	}
	/**
	 * 
	 * @author : hoTire
	 * @comment : 이전 순열
	 * @param a
	 * @return
	 */
	public boolean prePermutation(int[] a) {
		int i = a.length - 1, j = a.length - 1;
		while (i > 0 && a[i-1] <= a[i]) --i;
		if (i == 0) return false;
		while (a[i-1] <= a[j]) --j;
		swap(a,i-1,j);
		j = a.length - 1;
		while (i < j) swap(a,i++,j--);
		return true;
	}
	public void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	/**
	 * 
	 * @author : hoTire
	 * @comment : 비트마스크
	 * @param n
	 */
	public void bitMask(int n) {
		for (int i = 0; i< (1<<n); i++) {
			for (int j = 0; j < n; j++) {
				if ( (i& (1<<j)) > 0) {
					// TODO
				}
			}
		}
	}
	
	/**
	 * 
	 * @author : hoTire
	 * @comment : 오른쪽 회전
	 * @param sb
	 * @param n
	 */
	public void rightCycle(StringBuilder sb, int n) {
		sb.insert(0, sb.substring(1,sb.length()));
		sb.setLength(n);
	}
	public long rightCycle(long number, long n) {
		return (number % n) * 10 + (number / n);
	}
	/**
	 * 
	 * @author : hoTire
	 * @comment : 왼쪽 회전 
	 * @param sb
	 * @param n
	 */
	public void leftCycle(StringBuilder sb, int n) {
		sb.insert(0, sb.charAt(sb.length()-1));
		sb.setLength(n);
	}
	public long leftCycle(long number, long n) {
		return (number / 10) + (number%10) * n;
	}
	
	/**
	 * 
	 * @author : hoTire
	 * @comment : 소수 구하기 
	 * @param a
	 */
	public void getPrime(int a[]) {
		for (int i = 2; i < a.length; i++) a[i] = i;
		for (int i = 2; i < a.length; i++) {
			if (a[i] == 0) continue;
			for (int j = i + i; j < a.length; j +=i) 
				a[j] = 0;
		}
	}
}

