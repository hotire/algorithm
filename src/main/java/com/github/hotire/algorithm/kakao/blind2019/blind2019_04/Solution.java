package com.github.hotire.algorithm.kakao.blind2019.blind2019_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author : hotire
 */
public class Solution {

    public static void main(String args[]) {
        Solution s = new Solution();
        s.solution(new int[] { 3, 1, 2 }, 5);

        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

    }

    public int solution(int[] food_times, long k) {
        Josephus josephus = new Josephus(food_times, k);
        int answer = josephus.run();
        System.out.println(answer);
        return answer;
    }
}

class Josephus {
    private int M;
    private long K;
    private List<Food> list = new ArrayList<>();
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    Josephus(int[] foodTimes, long K) {
        this.K = K;
        for (int i = 0; i < foodTimes.length; i++) {
            list.add(new Food(foodTimes[i], i + 1));
            priorityQueue.add(foodTimes[i]);
        }
    }

    public int run() {
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            int value = priorityQueue.poll();
            if (list.size() <= K) {
                K = K - (list.size() * (value - index));
                Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).time <= value) {
                        set.add(i);
                    }
                }
                for (int i : set) {
                    list.remove(i);
                }

                if (list.isEmpty()) {
                    return -1;
                }

                index = value;
            } else {
                break;
            }
        }
        return list.get((int) K).index;
    }
}

class Food {
    int time;
    int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }
}

//class Food implements  Comparable<Food>{
//    private int time;
//    private boolean empty;
//
//
//    public Food(int time) {
//        this.time = time;
//    }
//
//    public int getTime() {
//        return time;
//    }
//
//    public void eat(int time) {
//        this.time -= time;
//        if (this.time <= 0) empty = true;
//    }
//
//    public boolean isEmpty() {
//        return this.empty;
//    }
//
//    @Override
//    public int compareTo(Food o) {
//        return Integer.compare(this.time, o.time);
//    }
//}

//class KakaoTv {
//    private long K;
//    private long sumOfFoodTime;
//    private List<Food> foods = new ArrayList<>();
//    private List<Food> sortedFoods = new ArrayList<>();
//
//    KakaoTv (int[] foodTimes, long K) {
//        this.K = K;
//        for (int foodTime : foodTimes) {
//            foods.add(new Food(foodTime));
//            sortedFoods.add(new Food(foodTime));
//            sumOfFoodTime += foodTime;
//        }
//
//        Collections.sort(sortedFoods);
//    }
//
//    public int run() {
//        if (sumOfFoodTime <= K) return -1;
//
//        int width = foods.size();
//        int cycle = 0;
//        int minIndex = 0;
//
//        while (K >= width) {
//            K -= width;
//            cycle++;
//            while( sortedFoods.get(minIndex).getTime() - cycle <= 0) {
//                minIndex++;
//                width--;
//            }
//        }
//        final int totalCycle = cycle;
//        foods.forEach(food-> food.eat(totalCycle));
//
//        int index = 0;
//        while (K-- > 0) {
//            while (foods.get(index).isEmpty()) index = (index + 1) % foods.size();
//            foods.get(index).eat(1);
//            index = (index + 1) % foods.size();
//        }
//
//        while (foods.get(index).isEmpty()) index = (index + 1) % foods.size();
//
//        return index + 1;
//
//    }
//
//}