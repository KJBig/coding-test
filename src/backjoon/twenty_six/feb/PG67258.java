package backjoon.twenty_six.feb;

import java.util.*;

public class PG67258 {
    class Solution {
        static Set<String> TYPES = new HashSet<>();
        static Map<String, Integer> BUY_TYPES = new HashMap<>();
        static int start;
        static int end;

        public int[] solution(String[] gems) {
            int[] answer = new int[2];
            answer[0] = -1;
            answer[1] = -1;

            for (String gem : gems) {
                TYPES.add(gem);
            }

            int typeSize = TYPES.size();

            start = 0;
            end = -1;

            while (end < gems.length-1) {
                if (BUY_TYPES.keySet().size() < typeSize) {
                    moveEnd(gems);
                }

                if (BUY_TYPES.keySet().size() > typeSize) {
                    moveStart(gems);
                }

                if (BUY_TYPES.keySet().size() == typeSize) {
                    allocateAnswer(answer);
                    moveStart(gems);
                }

                if (start > end) {
                    break;
                }
            }

            while (start <= end) {
                if (BUY_TYPES.keySet().size() != typeSize) {
                    break;
                }

                if (BUY_TYPES.keySet().size() == typeSize) {
                    allocateAnswer(answer);
                    moveStart(gems);
                }
            }

            return answer;
        }

        private void allocateAnswer(int[] answer){
            if (answer[0] == -1) {
                answer[0] = start+1;
                answer[1] = end+1;
            } else {
                if (answer[1]-answer[0] > end-start) {
                    answer[0] = start+1;
                    answer[1] = end+1;
                }
            }
        }

        private void moveEnd(String[] gems) {
            end++;
            if (!BUY_TYPES.containsKey(gems[end])) {
                BUY_TYPES.put(gems[end], 0);
            }
            BUY_TYPES.put(gems[end], BUY_TYPES.get(gems[end])+1);
        }

        private void moveStart(String[] gems) {
            BUY_TYPES.put(gems[start], BUY_TYPES.get(gems[start])-1);
            if (BUY_TYPES.get(gems[start]) == 0) {
                BUY_TYPES.remove(gems[start]);
            }
            start++;
        }
    }
}
