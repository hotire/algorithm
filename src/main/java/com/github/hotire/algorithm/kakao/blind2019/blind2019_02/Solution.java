package com.github.hotire.algorithm.kakao.blind2019.blind2019_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * [2, 1, 2, 6, 2, 4, 3, 3] -> [3,4,2,1,5]
     */

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.solution(5,new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }

    public int[] solution(int N, int[] stages) {

        Map<Integer,Integer> frequency = new HashMap<>();
        Map<Integer,Double> failureRate = new HashMap<>();

        for (int stage : stages) {
            int count = frequency.containsKey(stage) ? frequency.get(stage) + 1 : 1;
            frequency.put(stage,count);
        }

        int NumberOfUsers = stages.length;
        for (int i = 1; i <= N; i++) {
            if (frequency.containsKey(i)) {
                int cnt = frequency.get(i);
                failureRate.put(i,  (double) cnt / NumberOfUsers);
                NumberOfUsers -= cnt;
            } else {
                failureRate.put(i, 0.0);
            }
        }

        List<Integer> result = sortByValue(failureRate);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static List<Integer> sortByValue(final Map<Integer,Double> map) {
        List<Integer> result = new ArrayList();
        result.addAll(map.keySet());
        Collections.sort(result, (Comparator) (o1, o2) -> {
            Object v1 = map.get(o1);
            Object v2 = map.get(o2);
            return ((Comparable) v2).compareTo(v1);
        });
        return result;
    }

}
