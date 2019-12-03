package com.github.hotire.algorithm.blind2020_02;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {

  private final Map<Character, Integer> bracketMap = Map.of('(', 1, ')', -1);
  private final Map<Character, Character> reverseMap = Map.of('(', ')', ')','(');

  public String solution(String p) {
    if (p.isBlank()) {
      return "";
    }

    final List<String> strings = partition(p);

    String u = strings.get(0);
    String v = strings.get(1);

    if (checkPerfectBracket(u)) {
      u += solution(v);
      return u;
    }

    String answer = "";
    answer += "(";
    answer += solution(v);
    answer += ")";
    answer += reverse(u.substring(1, u.length() - 1));

    return answer;
  }

  protected List<String> partition(String s) {
    int sum = 0;
    final List<String> strings = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      sum += bracketMap.get(s.charAt(i));
      if (sum == 0) {
        strings.add(s.substring(0, i+1));
        strings.add(s.substring(i+1));
        break;
      }
    }
    return strings;
  }

  protected boolean checkPerfectBracket(String s) {
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
      sum += bracketMap.get(s.charAt(i));
      if (sum < 0) {
        return false;
      }
    }
    return true;
  }

  protected String reverse(String s) {
    final StringBuilder stringBuilder = new StringBuilder();
    for (char c : s.toCharArray()) {
      stringBuilder.append(reverseMap.get(c));
    }
    return stringBuilder.toString();
  }
}
