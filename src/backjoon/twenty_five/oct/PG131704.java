package backjoon.twenty_five.oct;

import java.util.*;

public class PG131704 {
    class Solution {
        public int solution(int[] order) {
            int answer = 0;
            Queue<Integer> mainBelt = new LinkedList<>();
            Stack<Integer> subBelt = new Stack<>();

            for (int i=0; i<order.length; i++) {
                mainBelt.add(i+1);
            }

            int index = 0;
            while (!mainBelt.isEmpty() || !subBelt.isEmpty()) {
                if (!mainBelt.isEmpty() && mainBelt.peek()==order[index]) {
                    mainBelt.poll();
                    answer++;
                    index++;
                } else if (!subBelt.isEmpty() && subBelt.peek()==order[index]) {
                    subBelt.pop();
                    answer++;
                    index++;
                } else {
                    if (mainBelt.isEmpty()) {
                        break;
                    }
                    int poll = mainBelt.poll();
                    subBelt.add(poll);
                }
            }

            return answer;
        }
    }
}
