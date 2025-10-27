package backjoon.twenty_five.oct;

import java.util.*;


public class PG42628 {
    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = {};
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();

            for (String operation : operations) {
                String[] order = operation.split(" ");
                if (order[0].equals("I")) {
                    maxQueue.add(Integer.parseInt(order[1]));
                    minQueue.add(Integer.parseInt(order[1]));
                } else {
                    if (order[1].equals("1") && !maxQueue.isEmpty()) {
                        int poll = maxQueue.poll();
                        minQueue.remove(poll);
                    }

                    if (order[1].equals("-1") && !minQueue.isEmpty()) {
                        int poll = minQueue.poll();
                        maxQueue.remove(poll);
                    }
                }
            }

            int maxNumber = 0;
            int minNumber = 0;

            if (!maxQueue.isEmpty()) {
                maxNumber = maxQueue.poll();
            }

            if (!minQueue.isEmpty()) {
                minNumber = minQueue.poll();
            }

            answer = new int[2];
            answer[0] = maxNumber;
            answer[1] = minNumber;
            return answer;
        }
    }
}
