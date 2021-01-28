package com.github.hotire.algorithm.kakao.blind2021.blind2021_01;

public class Solution {
    private String regex = "[^\\p{IsAlphabetic}\\p{IsDigit}-_.]";

    public String solution(String newId) {
        // 1, 2
        newId = newId.toLowerCase().replaceAll(regex, "");

        // 3
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < newId.length() - 1 ; i++) {
            sb.append(newId.charAt(i));
            if (newId.charAt(i) == newId.charAt(i +1) && newId.charAt(i) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        sb.append(newId.charAt(newId.length() - 1));

        // 4
        if (sb.length() != 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.length() != 0 &&  sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 5
        if (sb.toString().isEmpty()) {
            sb.append("a");
        }

        // 6
        if (sb.length() >= 16) {
            sb.delete(15, sb.length());
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 7
        for (int i = sb.length(); i < 3 ; i ++) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }
}

