package com.github.hotire.algorithm.kakao.blind2021.blind2021_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public String[] solution(String[] orders, int[] course) {
        final Map<String, Integer> bitmaskMap = new HashMap<>();
        final Set<Integer> courseSet = IntStream.of(course).boxed().collect(Collectors.toSet());
        Arrays.stream(orders).forEach(order -> {
            int n = order.length();
            final Set<Character> sb = new TreeSet<>();
            for (int i = 0; i< (1 << n); i++) {
                for (int j = 0; j < n; j++) {
                    if ( ( i & (1 << j)) > 0) {
                        sb.add(order.charAt(j));
                    }
                }
                final String result = sb.stream().map(Object::toString).collect(Collectors.joining());

                if (result.length() >= 2) {
                    if (bitmaskMap.containsKey(result)) {
                        bitmaskMap.put(result, bitmaskMap.get(result) + 1);
                    } else {
                        bitmaskMap.put(result, 1);
                    }
                }
                sb.clear();
            }
        });

        return bitmaskMap.entrySet()
                         .stream()
                         .filter(it -> it.getValue() >= 2)
                         .filter(it -> courseSet.contains(it.getKey().length()))
                         .reduce(new HashMap<Integer, List<Entry<String, Integer>>>(), (map, entry) -> {
                             int keyLength = entry.getKey().length();
                             if (!map.containsKey(keyLength)) {
                                 map.put(keyLength, new ArrayList<>());
                                 map.get(keyLength).add(entry);
                             } else if (map.get(keyLength).get(0).getValue() < entry.getValue()) {
                                 map.get(keyLength).clear();
                                 map.get(keyLength).add(entry);
                             } else if (map.get(keyLength).get(0).getValue().equals(entry.getValue())) {
                                 map.get(keyLength).add(entry);
                             }
                             return map;
                         }, (m1, m2) -> m1)
                         .values()
                         .stream()
                         .flatMap(it -> it.stream().map(Entry::getKey))
                         .sorted()
                         .toArray(String[]::new);
    }
}
