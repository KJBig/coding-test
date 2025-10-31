package backjoon.twenty_five.oct;

import java.util.*;

public class PG12927 {
    class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i=0; i<works.length; i++) {
                queue.add(works[i]);
            }

            for (int i=0; i<n; i++) {
                int poll = queue.poll();
                if (poll == 0) {
                    break;
                }
                queue.add(poll-1);
            }

            while (!queue.isEmpty()) {
                int poll = queue.poll();
                answer += (poll*poll);
            }
            return answer;
        }
    }
}
