package com.github.hotire.algorithm.kakao.blind2022.blind2022_03;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class Solution {

    public static class Record {

        private static final LocalTime MAX = LocalTime.of(23, 59);
        private final LocalTime time;
        private final String carId;
        private final String status;

        private int duration;

        public int resolveDuration() {
            if ("OUT".equals(status)) {
                return duration;
            }
            final int duration = (int) (Duration.between(this.time, MAX).getSeconds() / 60);
            addDuration(duration);
            return this.duration;
        }

        public boolean isEntrance() {
            return !"OUT".equals(status);
        }

        public void addDuration(final int duration) {
            this.duration += duration;
        }

        public Record(final String[] strings) {
            final String[] time = strings[0].split(":");
            this.time = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
            this.carId = strings[1];
            this.status = strings[2];
        }
    }

    public int[] solution(final int[] fees, final String[] records) {

        final Map<String, Optional<Record>> result = Arrays.stream(records).map(it -> new Record(it.split(" ")))
                                                           .collect(groupingBy(it -> it.carId,
                                                                               TreeMap::new,
                                                                               reducing((record1, record2) -> {
                                                                                   if (record2.isEntrance()) {
                                                                                       record2.addDuration(record1.duration);
                                                                                       return record2;
                                                                                   }
                                                                                   final int duration = (int) (Duration.between(record1.time, record2.time).getSeconds() / 60);
                                                                                   record2.addDuration(record1.duration);
                                                                                   record2.addDuration(duration);
                                                                                   return record2;
                                                                               })));


        final int defaultDuration = (int) (Duration.ofMinutes(fees[0]).getSeconds() / 60);
        final int defaultFee = fees[1];
        final int unitDuration = fees[2];
        final int unitFee = fees[3];

        return result.values()
                     .stream()
                     .map(Optional::get)
                     .mapToInt(v -> {
                         int duration = v.resolveDuration();
                         if (duration <= defaultDuration) {
                             return defaultFee;
                         }
                         duration = duration - defaultDuration;

                         if (duration % unitDuration == 0) {
                             return duration / unitDuration * unitFee + defaultFee;
                         }
                         return ((duration / unitDuration) + 1) * unitFee +  defaultFee; })
                     .toArray();
    }
}
