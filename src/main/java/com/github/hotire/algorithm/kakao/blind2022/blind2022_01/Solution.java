package com.github.hotire.algorithm.kakao.blind2022.blind2022_01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(final String[] ids, final String[] reports, final int k) {
        final Map<String, Set<String>> countMapById = Arrays.stream(ids).collect(Collectors.toMap(Function.identity(), s -> new HashSet<>()));
        final Map<String, Set<String>> reportMapById = Arrays.stream(ids).collect(Collectors.toMap(Function.identity(), s -> new HashSet<>()));

        for (final String report : reports) {
            final String[] strings = report.split(" ");
            countMapById.get(strings[1]).add(strings[0]);
            reportMapById.get(strings[0]).add(strings[1]);
        }

        return Arrays.stream(ids)
                     .mapToInt(id -> (int) reportMapById.get(id).stream().filter(it -> countMapById.get(it).size() >= k).count())
                     .toArray();
    }
}
