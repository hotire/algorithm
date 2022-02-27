package com.github.hotire.algorithm.kakao.blind2022.blind2022_02;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final Map<Long, Boolean> primeCache = new HashMap<>();

    public int solution(final int n, final int k) {
        final String s = Integer.toString(n , k);
        final StringBuilder sb = new StringBuilder();
        int answer = 0;
        for (final char c : s.toCharArray()) {
            if (c == '0') {
                if (isPrime(sb.toString())) {
                    answer++;
                }
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        if (isPrime(sb.toString())) {
            answer++;
        }

        return answer;
    }

    long parseLong(final String s) {
        return Long.parseLong(s);
    }

    boolean isPrime(final String s) {
        if (s.isEmpty()) {
            return false;
        }

        final long n = parseLong(s);
        if (n <= 1) {
            return false;
        }
        if (primeCache.containsKey(n)) {
            return primeCache.get(n);
        }

        // Check from 2 to n-1
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                primeCache.put(n, false);
                return false;
            }
        }

        return true;
    }
}
