package com.github.hotire.algorithm.kakao.blind2021.blind2021_03;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Solution {

    public int[] solution(String[] info, String[] query) {
        final List<Applicant> applicants = Arrays.stream(info)
                                                 .map(it -> Applicant.create(it.split(" ")))
                                                 .collect(toList());
        final Map<Applicant, int[]> applicantSetMap = new HashMap<>();
        Arrays.stream(Language.values())
              .map(it -> new Applicant().setLanguage(it))
              .flatMap(it -> Arrays.stream(DeveloperType.values()).map(dtype -> it.copy().setDeveloperType(dtype)))
              .flatMap(it -> Arrays.stream(Career.values()).map(c -> it.copy().setCareer(c)))
              .flatMap(it -> Arrays.stream(SoulFood.values()).map(s -> it.copy().setSoulFood(s)))
              .forEach(it -> applicantSetMap.put(it, applicants.stream()
                                                           .filter(applicant -> it.getLanguage().equals(applicant))
                                                           .filter(applicant -> it.getDeveloperType().equals(applicant))
                                                           .filter(applicant -> it.getCareer().equals(applicant))
                                                           .filter(applicant -> it.getSoulFood().equals(applicant))
                                                           .mapToInt(Applicant::getScore)
                                                           .sorted()
                                                           .toArray()));
        return Arrays.stream(query)
                     .map(it -> Applicant.create(it.split("and")))
                     .mapToInt(q -> lowerBoundSearchCount(applicantSetMap.getOrDefault(q, new int[]{}), q.getScore()))
                     .toArray();
    }

    public int lowerBoundSearchCount(int[] arr, int k) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int m = (left + right) / 2;
            if (arr[m] < k) {
                left = m + 1;
            } else {
                right = m;
            }
        }

        return arr.length - right;
    }

    public enum Language {
        CPP, JAVA, PYTHON, NONE {
            @Override
            public boolean equals(Applicant applicant) {
                return true;
            }
        };
        public static Language lookup(String name) {
            if ("-".equals(name)) {
                return NONE;
            }
            return Language.valueOf(name.toUpperCase());
        }

        public boolean equals(Applicant applicant) {
            return this == applicant.getLanguage();
        }
    }

    public enum DeveloperType {
        BACKEND, FRONTEND, NONE {
            @Override
            public boolean equals(Applicant applicant) {
                return true;
            }
        };
        public static DeveloperType lookup(String name) {
            if ("-".equals(name)) {
                return NONE;
            }
            return DeveloperType.valueOf(name.toUpperCase());
        }

        public boolean equals(Applicant applicant) {
            return this == applicant.getDeveloperType();
        }
    }

    public enum Career {
        JUNIOR, SENIOR, NONE {
            @Override
            public boolean equals(Applicant applicant) {
                return true;
            }
        };
        public static Career lookup(String name) {
            if ("-".equals(name)) {
                return NONE;
            }
            return Career.valueOf(name.toUpperCase());
        }

        public boolean equals(Applicant applicant) {
            return this == applicant.getCareer();
        }
    }

    public enum SoulFood {
        PIZZA, CHICKEN, NONE {
            @Override
            public boolean equals(Applicant applicant) {
                return true;
            }
        };
        public static SoulFood lookup(String name) {
            if ("-".equals(name)) {
                return NONE;
            }
            return SoulFood.valueOf(name.toUpperCase());
        }

        public boolean equals(Applicant applicant) {
            return this == applicant.getSoulFood();
        }
    }

    public static class Applicant {
        private Language language;
        private DeveloperType developerType;
        private Career career;
        private SoulFood soulFood;
        private Integer score;

        public Applicant copy() {
            return new Applicant()
                    .setLanguage(getLanguage())
                    .setDeveloperType(getDeveloperType())
                    .setCareer(getCareer())
                    .setSoulFood(getSoulFood());
        }

        public static Applicant create(String[] info) {
            final Applicant applicant = new Applicant();
            applicant.setLanguage(Language.lookup(info[0].trim()));
            applicant.setDeveloperType(DeveloperType.lookup(info[1].trim()));
            applicant.setCareer(Career.lookup(info[2].trim()));

            if (info.length > 4) {
                applicant.setSoulFood(SoulFood.lookup(info[3].trim()));
                applicant.setScore(Integer.valueOf(info[4].trim()));
            } else {
                info = info[3].trim().split(" ");
                applicant.setSoulFood(SoulFood.lookup(info[0].trim()));
                applicant.setScore(Integer.valueOf(info[1].trim()));
            }

            return applicant;
        }

        public Language getLanguage() {
            return language;
        }

        public Applicant setLanguage(Language language) {
            this.language = language;
            return this;
        }

        public DeveloperType getDeveloperType() {
            return developerType;
        }

        public Applicant setDeveloperType(DeveloperType developerType) {
            this.developerType = developerType;
            return this;
        }

        public Career getCareer() {
            return career;
        }

        public Applicant setCareer(Career career) {
            this.career = career;
            return this;
        }

        public SoulFood getSoulFood() {
            return soulFood;
        }

        public Applicant setSoulFood(SoulFood soulFood) {
            this.soulFood = soulFood;
            return this;
        }

        public int getScore() {
            return score;
        }

        public Applicant setScore(Integer score) {
            this.score = score;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Applicant applicant = (Applicant) o;
            return language == applicant.language &&
                   developerType == applicant.developerType &&
                   career == applicant.career &&
                   soulFood == applicant.soulFood;
        }

        @Override
        public int hashCode() {
            return Objects.hash(language, developerType, career, soulFood);
        }

    }
}
