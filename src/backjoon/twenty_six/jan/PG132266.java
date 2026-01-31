package backjoon.twenty_six.jan;

import java.util.*;

public class PG132266 {
    class Solution {
        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            int[] answer = new int[sources.length];

            List<List<Integer>> adjNodes = new ArrayList<>();

            for (int i=0; i<=n; i++) {
                adjNodes.add(new ArrayList<>());
            }

            for (int[] road : roads) {
                int start = road[0];
                int end = road[1];
                adjNodes.get(start).add(end);
                adjNodes.get(end).add(start);
            }

            int[] visitTime = new int[n+1];
            Arrays.fill(visitTime, -1);

            // 계산 시작
            visitTime[destination] = 0;
            Queue<Integer> queue = new LinkedList<>();

            for (Integer index : adjNodes.get(destination)) {
                visitTime[index] = 1;
                queue.add(index);
            }

            while (!queue.isEmpty()) {
                int nowIndex = queue.poll();

                for (Integer nextIndex : adjNodes.get(nowIndex)) {
                    if (visitTime[nextIndex] == -1) {
                        visitTime[nextIndex] = visitTime[nowIndex]+1;
                        queue.add(nextIndex);
                    } else {
                        if (visitTime[nextIndex] > visitTime[nowIndex]+1) {
                            visitTime[nextIndex] = visitTime[nowIndex]+1;
                            queue.add(nextIndex);
                        }
                    }
                }


            }

            for (int i=0; i<sources.length; i++) {
                int source = sources[i];
                answer[i] = visitTime[source];
            }

            return answer;
        }
    }
}
