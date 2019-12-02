package blind2019_04;

import java.util.*;

/**
 * @author : hotire
 */
public class Solution {

    public static void main(String args[]) {
        Solution s = new Solution();
        s.solution(new int[]{3,1,2},5);

        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

    }

    public int solution(int[] food_times, long k) {
        Josephus josephus = new Josephus(food_times, k);
        int answer = josephus.run();
        System.out.println(answer);
        return answer;
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

class Josephus {
    private int M;
    private long K;
    private List<Food> list = new ArrayList<>();
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    Josephus (int[] foodTimes, long K) {
        this.K = K;
        for (int i = 0; i < foodTimes.length; i++) {
            list.add(new Food(foodTimes[i], i+1));
            priorityQueue.add(foodTimes[i]);
        }
    }

    public int run() {
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            int value = priorityQueue.poll();
            if (list.size() <= K) {
                K = K - (list.size()* (value-index));
                Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).time <= value ) set.add(i);
                }
                for (int i : set) list.remove(i);

                if (list.isEmpty()) return -1;

                index = value;
            } else {
                break;
            }
        }
        return list.get((int)K).index;
    }
}