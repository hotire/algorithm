package com.github.hotire.algorithm.kakao.blind2019.blind2019_03;

import java.util.*;

public class Solution {
    public int solution(String[][] relation) {
        int answer = Combination.solution(relation);
        return answer;
    }
}

class CandidateKey {
    boolean[] columns = new boolean[8];
    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof CandidateKey) ) return false;
        else {
            CandidateKey candidateKey = ((CandidateKey) obj);
            for (int i = 0 ; i < columns.length; i++) {
                if (columns[i] && !candidateKey.columns[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
class Combination {
    private static String array[][];
    private static List<CandidateKey> ans = new ArrayList<>();

    private static void combine(int n, Stack<Integer> st, int r) {
        if (r == 0) {
            findCandidateKey(st);
        }
        int smallest = st.isEmpty() ? 0 : st.lastElement() + 1;
        for (int next = smallest; next < n; next++) {
            st.push(next);
            combine(n, st, r - 1);
            st.pop();
        }
    }
    private static void findCandidateKey(Stack<Integer> st) {
        Set<String> set = new HashSet<>();
        CandidateKey candidateKey = new CandidateKey();
        for (String[] s : array) {
            String info = "";
            for (int i : st) {
                info = info + s[i];
                candidateKey.columns[i] = true;
            }
            set.add(info);
        }
        if (set.size() == array.length) {
            for (CandidateKey t : ans) {
                if (t.equals(candidateKey)) return;
            }
            ans.add(candidateKey);
        }
    }
    public static int solution(String[][] relation) {
        Stack<Integer> st = new Stack<Integer>();
        array = relation;
        for (int i = 1; i <= array[0].length; i++) {
            combine(array[0].length, st, i);
        }
        return ans.size();
    }
}
