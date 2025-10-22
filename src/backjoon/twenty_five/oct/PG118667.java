package backjoon.twenty_five.oct;

import java.util.*;

public class PG118667 {
    class Solution {
        public int solution(int[] queue1, int[] queue2) {
            int answer = 0;
            Queue<Integer> queueOne = new LinkedList<>();
            Queue<Integer> queueTwo = new LinkedList<>();
            long queueOneSize = 0;
            long queueTwoSize = 0;

            for (int i = 0; i < queue1.length; i++) {
                queueOne.add(queue1[i]);
                queueTwo.add(queue2[i]);
                queueOneSize += queue1[i];
                queueTwoSize += queue2[i];
            }

            long total = queueOneSize + queueTwoSize;
            if ((total & 1L) == 1L) {
                return -1;
            }

            // 무한 루프 방지 상한
            int limit = queue1.length * 3;

            while (answer <= limit) {
                if (queueOneSize == queueTwoSize) {
                    return answer;
                } else if (queueOneSize < queueTwoSize) {
                    int poll = queueTwo.poll();
                    queueOne.add(poll);
                    queueOneSize += poll;
                    queueTwoSize -= poll;
                } else {
                    int poll = queueOne.poll();
                    queueTwo.add(poll);
                    queueTwoSize += poll;
                    queueOneSize -= poll;
                }
                answer++;
            }

            return -1;
        }
    }
}
