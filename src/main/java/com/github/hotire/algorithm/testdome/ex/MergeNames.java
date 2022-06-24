package com.github.hotire.algorithm.testdome.ex;

import java.util.Arrays;
import java.util.HashSet;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        final HashSet<String> nameSet = new HashSet<>();
        nameSet.addAll(Arrays.asList(names1));
        nameSet.addAll(Arrays.asList(names2));
        return nameSet.toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}