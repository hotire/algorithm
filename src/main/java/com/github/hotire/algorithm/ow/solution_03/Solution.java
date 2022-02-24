package com.github.hotire.algorithm.ow.solution_03;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

    public int solution(final int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();

        for (final int value : arr) {
            if (value != 0) {
                if (map.containsKey(-value)) {
                    map.put(Math.abs(value), 2);
                } else {
                    map.put(value, 1);
                }
            } else {
                // zero
            }

        }

        return map.entrySet()
                  .stream()
                  .filter(it -> it.getValue() == 2)
                  .mapToInt(Entry::getKey)
                  .max()
                  .orElse(0);

    }
}
